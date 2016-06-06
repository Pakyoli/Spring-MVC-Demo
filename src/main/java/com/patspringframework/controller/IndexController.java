package com.patspringframework.controller;

import com.patspringframework.dto.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by pakyo_000 on 6/4/2016.
 */
@SessionAttributes({"user"})
@Controller
public class IndexController {

    @RequestMapping("/")
    public String showHomePage(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(Model model){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return "welcome";
    }


}
