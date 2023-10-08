package sq_ch09_ex3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private final LoginUser loginUser;
	
	@GetMapping("/main")
	public String getMainView(RedirectAttributes redAttrs, Model model) {
		if (loginUser.getUsername() == null) {
			redAttrs.addFlashAttribute("message", "요청한 페이지는 로그인 후 접근 가능합니다");
			return "redirect:/";
		} else {
			model.addAttribute("username", loginUser.getUsername());
			return "main.html";
		}
	}

}
