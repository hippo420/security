package spring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Slf4j
@Controller
public class HomeController {
    @GetMapping("/index")
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication: {}", authentication);

        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getName())) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("user", true);

            // 역할(Role) 정보 가져오기
            String roleName = authentication.getAuthorities().iterator().next().getAuthority();
            model.addAttribute("roleName", roleName);

            // 관리자 여부 확인
            boolean isAdmin = AuthorityUtils.authorityListToSet(authentication.getAuthorities()).contains("ROLE_ADMIN");
            model.addAttribute("isAdmin", isAdmin);

        } else {
            model.addAttribute("user", false);
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
