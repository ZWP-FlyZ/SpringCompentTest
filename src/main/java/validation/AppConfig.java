package validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AppConfig {

	
	@Bean("a")
	public TypeA getA() {
		TypeA a = new TypeA();
		a.setAge(201);
		a.setPass("222");
		a.setName("aaa@ccc.com");
		return a;
	}
	
	@Bean("validator")
	public LocalValidatorFactoryBean getLocalValidation() {
		return new LocalValidatorFactoryBean();
	}
	
	
}
