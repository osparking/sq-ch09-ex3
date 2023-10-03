package sq_ch09_ex3.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import space.jbpark.utility.MyUtil;

@Controller
public class LoginController {
	
	private final Logger logger = MyUtil.getLogger(LoginController.class.getName());
	private final LoginProcessor loginProcessor;
	
	public LoginController(LoginProcessor loginProcessor) {
		super();
		this.loginProcessor = loginProcessor;
		logger.info("로그인 제어기 생성");
	}

	@GetMapping("/")
	public String loginForm() {
		return "login.html";
	}
	
	@PostMapping("/")
	public String loginProcessing(@RequestParam String username,
			@RequestParam String password, Model page, RedirectAttributes redAttr) {
		
		if (loginProcessor.processLogin(username, password)) {
			redAttr.addFlashAttribute("message", "로그인 성공");
			return "redirect:/";
		} else {
			page.addAttribute("message", "로그인 실패");
			return "login.html";
		}
	}
}
