package com.sparklytix.socialme.web;

import com.sparklytix.socialme.model.SocialUser;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/socialusers")
@Controller
@RooWebScaffold(path = "socialusers", formBackingObject = SocialUser.class)
@RooWebFinder
@RooWebJson(jsonObject = SocialUser.class)
public class SocialUserController {
}
