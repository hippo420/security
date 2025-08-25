package spring.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("user", user);
        System.out.println("user: " + user.getUsername());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
