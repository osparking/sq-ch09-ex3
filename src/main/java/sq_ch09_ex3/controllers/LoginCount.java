package sq_ch09_ex3.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import lombok.Data;

@Component
@ApplicationScope
@Data
public class LoginCount {
	private long loginCount = 0;
	public long increase() {
		return ++loginCount;
	}
	
	public long getCount() {
		return loginCount;
	}

}
