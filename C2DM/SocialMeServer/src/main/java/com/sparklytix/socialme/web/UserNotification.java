package com.sparklytix.socialme.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparklytix.socialme.c2dm.C2DMUtil;
import com.sparklytix.socialme.model.SocialUser;
import com.sparklytix.socialme.model.SocialUserRegistration;

@RequestMapping("/usernotification/**")
@Controller
public class UserNotification {

	private C2DMUtil c2dmUtil = new C2DMUtil();
	
    @RequestMapping
    public void get(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

   
    @RequestMapping(method = RequestMethod.POST)
	public String post(@RequestParam("socialuser") String username, ModelMap modelMap,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Got "+username+" as post");
		try {
			String clientAuthToken = c2dmUtil.getToken("sparklytix", "Peace4me");

			SocialUser socialUser = SocialUser.findSocialUsersByEmailAddressEquals(username).getSingleResult();
			List<SocialUserRegistration> registrations = SocialUserRegistration.findSocialUserRegistrationsBySocialUser(socialUser).getResultList();
			
			
			for(SocialUserRegistration registration: registrations){
				String registrationId = registration.getRegistrationId();
				c2dmUtil.sendMessage(clientAuthToken, registrationId, "Please Upgrade!");
			}
			modelMap.put("message", "Message sent successfully to "+socialUser.getFirstName()+" "+socialUser.getLastName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		modelMap.put("socialusers",
				SocialUser.findAllSocialUsers());
		return "usernotification/index";
	}

	@RequestMapping
	public String index(Model uiModel) {

		uiModel.addAttribute("socialusers",
				SocialUser.findAllSocialUsers());

		return "usernotification/index";
	}
}
