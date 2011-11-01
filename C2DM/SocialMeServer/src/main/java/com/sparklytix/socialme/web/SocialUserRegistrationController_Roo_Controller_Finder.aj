// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sparklytix.socialme.web;

import com.sparklytix.socialme.model.SocialUser;
import com.sparklytix.socialme.model.SocialUserRegistration;
import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

privileged aspect SocialUserRegistrationController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByRegistrationIdEquals", "form" }, method = RequestMethod.GET)
    public String SocialUserRegistrationController.findSocialUserRegistrationsByRegistrationIdEqualsForm(Model uiModel) {
        return "socialuserregistrations/findSocialUserRegistrationsByRegistrationIdEquals";
    }
    
    @RequestMapping(params = "find=ByRegistrationIdEquals", method = RequestMethod.GET)
    public String SocialUserRegistrationController.findSocialUserRegistrationsByRegistrationIdEquals(@RequestParam("registrationId") String registrationId, Model uiModel) {
        uiModel.addAttribute("socialuserregistrations", SocialUserRegistration.findSocialUserRegistrationsByRegistrationIdEquals(registrationId).getResultList());
        return "socialuserregistrations/list";
    }
    
    @RequestMapping(params = { "find=BySocialUser", "form" }, method = RequestMethod.GET)
    public String SocialUserRegistrationController.findSocialUserRegistrationsBySocialUserForm(Model uiModel) {
        uiModel.addAttribute("socialusers", SocialUser.findAllSocialUsers());
        return "socialuserregistrations/findSocialUserRegistrationsBySocialUser";
    }
    
    @RequestMapping(params = "find=BySocialUser", method = RequestMethod.GET)
    public String SocialUserRegistrationController.findSocialUserRegistrationsBySocialUser(@RequestParam("socialUser") SocialUser socialUser, Model uiModel) {
        uiModel.addAttribute("socialuserregistrations", SocialUserRegistration.findSocialUserRegistrationsBySocialUser(socialUser).getResultList());
        return "socialuserregistrations/list";
    }
    
}