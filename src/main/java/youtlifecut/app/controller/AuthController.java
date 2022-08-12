package youtlifecut.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

    @GetMapping("/auth/login")
    public String loginPageRedirect(){
        return "login_form";
    }

    @GetMapping("/auth/logout")
    public String logout(){
        return "redirect:/logout";
    }

    @GetMapping("/login/oauth2/code/{socialType}")
    public String navberRedirection(){
        return "navbar";
    }


}
