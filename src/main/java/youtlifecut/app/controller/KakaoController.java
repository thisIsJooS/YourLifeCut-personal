package youtlifecut.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import youtlifecut.app.service.KakaoService;

import java.io.IOException;
import java.util.Map;

@Controller
public class KakaoController {

    @GetMapping("/login/kakao")
    public String kakaoLogin(){
        return "forward:/https://kauth.kakao.com/oauth/authorize?client_id=f59f1da1323e0e466c18bfdf8d2c67b2&redirect_uri=http://127.0.0.1:8080/login/oauth2/code/kakao&response_type=code";
    }

    @Autowired
    KakaoService ks;

    @GetMapping("/login/oauth2/code/kakao")
    public String getCI(@RequestParam String code, Model model) throws IOException {
        System.out.println("code = " + code);
        String access_token = ks.getToken(code);
        Map<String, Object> userInfo = ks.getUserInfo(access_token);
        model.addAttribute("code", code);
        model.addAttribute("access_token", access_token);
        model.addAttribute("userInfo", userInfo);

        //ci는 비즈니스 전환후 검수신청 -> 허락받아야 수집 가능
        return "kakaoResponse";
    }
}
