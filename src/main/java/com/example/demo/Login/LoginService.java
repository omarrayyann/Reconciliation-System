package com.example.demo.Login;

import User.User;
import com.example.demo.Config;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public Boolean logIn(String username, String password) {

        for(int i = 0; i<Config.users.size(); i++){
            if(Config.users.get(i).authenticateUser(username, password)) {
                Config.setCurrentUser(Config.users.get(i));
                return true;
            }
        }

        // Wrong Credentials
        Config.setCurrentUser(null);
        return false;

    }

}