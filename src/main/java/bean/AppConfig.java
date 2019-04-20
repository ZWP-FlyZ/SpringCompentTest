package bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("bean")
@PropertySource("application.properties")
public class AppConfig {

	@Value("${my.a.name}")
	String aName;
	
	@Value("${my.b.name}")
	String bName;
	
	
	@Bean("a")
	@Scope("singleton")
	public TypeA getA() {
		TypeA a = new TypeA();
		a.setName(aName);
		a.setValue((int) 'a');
		return a;
	}
	
	@Bean("b")
	@Scope("singleton")
	public TypeB getB() {
		TypeB b = new TypeB();
		b.setName(bName);
		b.setValue((int) 'b');
		return b;
	}
	
	@Bean("c")
	public TypeCFactory getFactroy() {
		return new TypeCFactory();
	}
	
	
}
