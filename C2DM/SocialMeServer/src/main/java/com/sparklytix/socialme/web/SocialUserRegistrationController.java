package com.sparklytix.socialme.web;

import java.util.List;

import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sparklytix.socialme.model.SocialUserRegistration;

@RequestMapping("/socialuserregistrations")
@Controller
@RooWebScaffold(path = "socialuserregistrations", formBackingObject = SocialUserRegistration.class)
@RooWebFinder
@RooWebJson(jsonObject = SocialUserRegistration.class)
public class SocialUserRegistrationController {

	@RequestMapping(method = RequestMethod.DELETE, headers = "Accept=application/json",params="registrationId")
	public void deleteRegistrationId(
			@RequestParam("registrationId") String registrationId) {
		List<SocialUserRegistration> registrations = SocialUserRegistration.findSocialUserRegistrationsByRegistrationIdEquals(registrationId).getResultList();
		for(SocialUserRegistration userReg: registrations){
			userReg.remove();
			
		}
		

	}
}
