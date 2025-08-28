package spring.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class AuthorizationController {

    //메서드 단위 권한 제어
    @Secured("ADMIN")
    @PostMapping("/prdAdminMethod")
    public String prdAdminMethod() {
        log.info("prdAdminMethod처리");
        return "prdAdminMethod처리 완료";
    }

    @PostMapping("/admin/prdAdminUrl")
    public String prdAdminUrl() {
        log.info("prdAdminUrl처리");
        return "prdAdminUrl처리 완료";
    }

    @PostMapping("/user/prdUserUrl")
    public String prdUserUrl() {
        log.info("prdUserUrl");
        return "prdUserUrl 완료";
    }

}
