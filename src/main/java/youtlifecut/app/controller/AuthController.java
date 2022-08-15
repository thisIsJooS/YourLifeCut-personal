package youtlifecut.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import youtlifecut.app.domain.User;
import youtlifecut.app.service.OAuthService;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final OAuthService oAuthService;
    /**
     * 로그인 페이지 매핑
     * @return
     */
    @GetMapping("/auth/login")
    public String loginPageRedirect(){
        return "login_form";
    }

    /**
     * 로그아웃 그리고 로그아웃 후 페이지 매핑
     * @return
     */
    @GetMapping("/auth/logout")
    public String logout(){
        return "redirect:/logout";
    }

    /**
     * 로그인 성공시 redirect 될 url을 매필해주기
     */
    @GetMapping("/login/oauth2/code/{socialType}")
    public String loginCallbackRedirection(){

        System.out.println("ㅇㄴ머우머ㅏ라ㅓ뮤ㅏㅓㅁ퓽나ㅓ풍나파ㅣㅇ러ㅏㅣㅁㄴ런마ㅣㅓㅁ나ㅜㄴ망운므,ㅡㅇㄴ믄ㅇ민몬ㅁㅇ푠ㅁㅇㅊㄹㄴㅁㅊㅇㅅㄴㅁㄴ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        System.out.println("currentPrincipalName >>>>> " + currentPrincipalName);

        return "redirect:/login_form";
    }

    /**
     * 현재 로그인된 사용자의 아이디 반환하기
     */
    @GetMapping("/auth/userid")
    @ResponseBody
    @PreAuthorize("isAuthenticated()")
    public Long getUserId(Principal principal){
        OAuth2AuthenticationToken oAuth2AuthenticationToken;
        System.out.println(principal.toString());
        return 1L;
    }


}
