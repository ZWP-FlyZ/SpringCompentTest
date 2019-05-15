package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StreamUtils;

public class AopMain {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		TypeA a = ctx.getBean("typeA",TypeA.class);
		TypeB b = (TypeB) ctx.getBean("typeB");
		
		a.work();
		a.work2();
		
		b.work();
		b.work2();
		b.work3();
		
	}

}
