package sq_ch09_ex3.controllers;

import java.util.logging.Logger;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import space.jbpark.utility.MyUtil;

@Component
@RequestScope
public class LoginProcessor {

	private final static Logger logger = MyUtil.getLogger(LoginProcessor.class.getName());
	private final LoginUser loginUser;
	
	public LoginProcessor(LoginUser loginUser) {
		super();
		this.loginUser = loginUser;
		logger.info("로그인 처리기 생성");
	}

	public boolean processLogin(String username, String password) {
		if ("natalie".equals(username) && "1234".equals(password)) {
			loginUser.setUsername(username);
			return true;
		} else {
			return false;
		}
	}

}
