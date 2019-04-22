package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
