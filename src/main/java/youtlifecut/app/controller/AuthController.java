package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import youtlifecut.app.dto.UserDto;
import youtlifecut.app.service.AuthService;
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

    @Autowired
    private AuthService authService;



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

        return "kakaoResponse"; // 프론트에서 닉네임 설정하는 곳으로 보내기
    }

    /**
     * 로그아웃 - logout redirect url은 홈으로 설정해놓음. 바꿀거면 말해주기. 카카오 developments 사이트에서 바꿔야함
     */
    @GetMapping("/logout")
    public void logout(HttpServletResponse httpServletResponse) throws IOException{
        //카카오 로그아웃
        httpServletResponse.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id=f59f1da1323e0e466c18bfdf8d2c67b2&logout_redirect_uri=http://localhost:8080/");
    }

    /**
     * 닉네임 수정 요청
     */
    @PostMapping("/nickname")
    public ResponseEntity setNickname(@RequestBody UserDto userDto){
        return authService.setNickname(userDto);
    }

    /**
     * 로그인 페이지 매핑 - 내가 그냥 테스트용 html 넘어가기 용
     * @return
     */
    @GetMapping("/login")
    public String loginPageRedirect(){
        return "login_form";
    }





}
