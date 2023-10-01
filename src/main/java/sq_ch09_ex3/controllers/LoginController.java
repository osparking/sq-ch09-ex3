package sq_ch09_ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String loginForm() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String loginProcessing(@RequestParam String username,
			@RequestParam String password, Model page, RedirectAttributes redAttr) {
		
		if ("natalie".equals(username) && "1234".equals(password)) {
			redAttr.addFlashAttribute("message", "로그인 성공");
			return "redirect:/";
		} else {
			page.addAttribute("message", "로그인 실패");
			return "login.html";
		}
	}
}
