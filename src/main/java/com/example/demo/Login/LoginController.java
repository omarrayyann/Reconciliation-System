package com.example.demo.Login;

import User.User;
import com.example.demo.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "login.jsp";
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public String logIn(ModelMap model, @RequestParam String username, @RequestParam String password){

        if (service.logIn(username, password)) {
            model.put("errorMessage", "");
            return "redirect:/source-file";
        }
        else{
            model.put("errorMessage", "Invalid Credentials");
            model.put("username", username);
            return "login.jsp";
        }



    }

}