package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("aop")
public class AppConfig {

	
	@Bean("typeA")
	public TypeA getTypeA() {
		return new TypeA();
	}
	
	@Bean("typeB")
	public TypeB getTypeB() {
		return new TypeB();
	}
	
}
