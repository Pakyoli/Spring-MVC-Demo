package com.patspringframework.controller;

import com.patspringframework.dto.User;
import com.patspringframework.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String newUserform(Model model){
        model.addAttribute("user", new User());
        return "users/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("user")User user, BindingResult result, RedirectAttributes ra){
        if(result.hasErrors()){
            return "users/register";
        }
        userManager.create(user);
        ra.addFlashAttribute("success", true);
        ra.addFlashAttribute("message","Your account has been created. Please log in.");
        return "redirect:/login";
    }


}
