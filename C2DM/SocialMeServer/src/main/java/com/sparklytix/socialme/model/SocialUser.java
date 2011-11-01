package com.sparklytix.socialme.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJson
@RooEntity(finders = { "findSocialUsersByEmailAddressEqualsAndPasswordEquals", "findSocialUsersByEmailAddressEquals" })
public class SocialUser {

    @NotNull
    @Column(unique = true)
    private String emailAddress;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String password;
}
