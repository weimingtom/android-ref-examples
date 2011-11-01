package com.sparklytix.socialme.web;

import com.sparklytix.socialme.model.SocialUserScrapBook;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/socialuserscrapbooks")
@Controller
@RooWebScaffold(path = "socialuserscrapbooks", formBackingObject = SocialUserScrapBook.class)
@RooWebFinder
@RooWebJson(jsonObject = SocialUserScrapBook.class)
public class SocialUserScrapBookController {
}
