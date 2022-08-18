package youtlifecut.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String root(){
        return "navbar";
    }

    @GetMapping("/loginform")
    public String loginPageRedirect(){
        return "login_form";
    }
}
