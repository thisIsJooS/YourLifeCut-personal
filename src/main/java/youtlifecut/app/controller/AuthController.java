package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import youtlifecut.app.service.KakaoService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private KakaoService kakaoService;

    /**
     * 카카오 로그인 요청
     */
    @GetMapping("/login/kakao")
    public void kakaoLogin(HttpServletResponse httpServletResponse) throws IOException{
        httpServletResponse.sendRedirect("https://kauth.kakao.com/oauth/authorize?client_id=f59f1da1323e0e466c18bfdf8d2c67b2&redirect_uri=http://127.0.0.1:8080/auth/login/kakao/callback&response_type=code");
    }

    /**
     * 카카오 로그인 이후 콜백
     */
    @GetMapping("/login/kakao/callback")
    public String kakaoCallback(@RequestParam String code, Model model) throws IOException {
        String access_token = kakaoService.getToken(code);
        Map<String, Object> userInfo = kakaoService.getUserInfo(access_token);
        kakaoService.kakaoSignup(userInfo);
        model.addAttribute("userId", userInfo.get("id"));

        return "kakaoResponse";
    }

    /**
     * 로그아웃
     */
    @GetMapping("/logout")
    public void logout(HttpServletResponse httpServletResponse) throws IOException{
        //카카오 로그아웃
        httpServletResponse.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=f59f1da1323e0e466c18bfdf8d2c67b2&logout_redirect_uri=http://localhost:8080/");
    }



    /**
     * 로그인 페이지 매핑 - 내가 그냥 테스트용 html 넘어가기 용
     * @return
     */
    @GetMapping("/login")
    public String loginPageRedirect(){
        return "login_form";
    }

    /**
     * 로그아웃 그리고 로그아웃 후 페이지 매핑
     * @return
     */
    @GetMapping("/logout")
    public String logout(){
        return "redirect:/logout";
    }

    /**
     * 로그인 성공시 redirect 될 url을 매필해주기
     */
    @GetMapping("????")
    public String loginCallbackRedirection(){


        return "redirect:/login_form";
    }



}
