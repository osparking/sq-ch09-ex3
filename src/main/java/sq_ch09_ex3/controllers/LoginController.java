package sq_ch09_ex3.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import space.jbpark.utility.MyUtil;

@Controller
@AllArgsConstructor
public class LoginController {
	
	private final LoginProcessor loginProcessor;
	private final LoginUser loginUser;
	private final Logger logger = MyUtil.getLogger(LoginController.class.getName());
	private final LoginCount loginCount;

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
		String returnUrl = "login.html";
		if (loginProcessor.processLogin(username, password)) {
			redAttr.addFlashAttribute("message", "로그인 성공");
			returnUrl = "redirect:/main";
		} else {
			page.addAttribute("message", "로그인 실패");
		}
		logger.info("누적 로그인 횟수: " + loginCount.getCount());
		return returnUrl;
	}
}
