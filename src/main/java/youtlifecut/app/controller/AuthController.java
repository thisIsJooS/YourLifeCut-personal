package youtlifecut.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import youtlifecut.app.domain.User;

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
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String currentPrincipalName = authentication.getName();
//        System.out.println("currentPrincipalName >>>>> " + currentPrincipalName);

        return "navbar";
    }


}
