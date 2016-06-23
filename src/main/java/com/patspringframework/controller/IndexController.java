package com.patspringframework.controller;

import com.patspringframework.service.LogoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by pakyo_000 on 6/4/2016.
 */
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

    @RequestMapping("/login?error")
    public String loginFailed(Model model){
        model.addAttribute("error", true);
        model.addAttribute("error_message", "Can't find user");
        return "/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        LogoutService.logout(request,response);
        return "/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/backoffice")
    public String backoffice(){
        return "backoffice/backoffice";
    }

}
