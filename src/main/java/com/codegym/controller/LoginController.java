package com.codegym.controller;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.persistence.LoginPersistenceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    LoginPersistenceImpl loginPersistence = new LoginPersistenceImpl();
@RequestMapping("/form")
    public String showFormLogin(Model model){
    return "/form";
}
@PostMapping("/show")
    public String login(@ModelAttribute("account") String account, @ModelAttribute("password") String password, Model model) {
    Login login = new Login(account,password);
    User user = loginPersistence.checkLogin(login);
    if (user == null) {
        return "/error";
    } else {
        model.addAttribute("user",user);
        return "/show";
    }
}

}
