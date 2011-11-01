package com.sparklytix.socialme.model;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson
@RooEntity(finders = { "findSocialUserRegistrationsBySocialUser", "findSocialUserRegistrationsByRegistrationIdEquals" })
public class SocialUserRegistration {

    @NotNull
    @ManyToOne
    private SocialUser socialUser;

    @NotNull
    private String registrationId;
}
