package com.sparklytix.socialme.model;

import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findSocialUserScrapBooksBySocialUser", "findSocialUserScrapBooksBySocialUserAndCreatedGreaterThan" })
@RooJson
public class SocialUserScrapBook {

    @NotNull
    @ManyToOne
    private SocialUser socialUser;

    @NotNull
    private String scrap;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date created;
}
