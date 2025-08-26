package spring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class HomeController {
    @GetMapping("/index")
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        if(user == null) {
            log.error("인증정보 없음");
            model.addAttribute("username", "undefined");
        }
        else{
            model.addAttribute("user", user);
            log.info("로그인 성공 - 사용자: [{}], 역할 : [{}]", user.getUsername(),user.getAuthorities());

        }
        return "index";
    }

    @GetMapping("/loginView")
    public String loginView() {
        return "loginView";
    }

    @GetMapping("/public")
    public String publicView() {
        return "public";
    }
}
