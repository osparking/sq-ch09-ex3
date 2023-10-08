package sq_ch09_ex3.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;
import space.jbpark.utility.MyUtil;

@Component
@SessionScope
@Data
public class LoginUser {
	private String username;
	private static final Logger logger = 
			MyUtil.getLogger(LoginUser.class.getName());

	public LoginUser() {
		super();
		logger.info("LoginUser 생성자");
	}

}
