package com.patspringframework.controller;

import com.patspringframework.dao.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by pakyo_000 on 6/6/2016.
 */
@Controller
public class UserController {

    private UserDAOImpl userDAO;

    @Autowired
    public void setUserDAO(UserDAOImpl userDAO){
        this.userDAO = userDAO;
    }


}
