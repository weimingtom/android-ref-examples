// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.sparklytix.socialme.model;

import com.sparklytix.socialme.model.SocialUser;
import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect SocialUser_Roo_Finder {
    
    public static TypedQuery<SocialUser> SocialUser.findSocialUsersByEmailAddressEquals(String emailAddress) {
        if (emailAddress == null || emailAddress.length() == 0) throw new IllegalArgumentException("The emailAddress argument is required");
        EntityManager em = SocialUser.entityManager();
        TypedQuery<SocialUser> q = em.createQuery("SELECT o FROM SocialUser AS o WHERE o.emailAddress = :emailAddress", SocialUser.class);
        q.setParameter("emailAddress", emailAddress);
        return q;
    }
    
    public static TypedQuery<SocialUser> SocialUser.findSocialUsersByEmailAddressEqualsAndPasswordEquals(String emailAddress, String password) {
        if (emailAddress == null || emailAddress.length() == 0) throw new IllegalArgumentException("The emailAddress argument is required");
        if (password == null || password.length() == 0) throw new IllegalArgumentException("The password argument is required");
        EntityManager em = SocialUser.entityManager();
        TypedQuery<SocialUser> q = em.createQuery("SELECT o FROM SocialUser AS o WHERE o.emailAddress = :emailAddress  AND o.password = :password", SocialUser.class);
        q.setParameter("emailAddress", emailAddress);
        q.setParameter("password", password);
        return q;
    }
    
}
