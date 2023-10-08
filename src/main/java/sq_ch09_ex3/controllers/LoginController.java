package sq_ch09_ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
	
	private final LoginProcessor loginProcessor;
	private final LoginUser loginUser;

	@GetMapping("/")
	public String loginForm() {
		return "login.html";
	}
	
	@GetMapping("/logout")
	public String processLogout(RedirectAttributes redAttrs) {
		redAttrs.addFlashAttribute("message", 
				loginUser.getUsername() + "님이 로그아웃하였습니다.");
		loginUser.setUsername(null);
		return "redirect:/";
	}
	
	@PostMapping("/")
	public String loginProcessing(@RequestParam String username,
			@RequestParam String password, Model page, RedirectAttributes redAttr) {
		
		if (loginProcessor.processLogin(username, password)) {
			redAttr.addFlashAttribute("message", "로그인 성공");
			return "redirect:/main";
		} else {
			page.addAttribute("message", "로그인 실패");
			return "login.html";
		}
	}
}
