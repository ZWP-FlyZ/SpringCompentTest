package bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

public class CoreMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		TypeA a = ctx.getBean(TypeA.class);
		TypeB b = ctx.getBean(TypeB.class);
		
		
		////////////// FactoryBean 测试 /////////////////
		@SuppressWarnings("unused")
		TypeCFactory cFactory = (TypeCFactory) ctx.getBean("&c");
		
		System.err.println(a+","+a.getB());
		System.err.println(b+","+b.getA());
		for(int i=0;i<10;i++) {
			TypeC c = (TypeC) ctx.getBean("c");
			System.err.println(c.getName());
			System.err.println(c.getValue());
		}

		/////////////// 资源测试 ///////////////////////
		
		/// 从类路径中获取Resource
		Resource classResource = ctx.getResource("classpath:application.properties");
		new BufferedReader(new InputStreamReader(classResource.getInputStream())).
			lines().forEach(v->System.err.println(v));
		
		/// 从类路径中获取Resource
		Resource urlResource = ctx.getResource("http://www.baidu.com");
		new BufferedReader(new InputStreamReader(urlResource.getInputStream())).
			lines().forEach(v->System.err.println(v));
		
		/// 从文件系统中获取Resource
		Resource fileResource = ctx.getResource("file:///e:/test.txt");
		new BufferedReader(new InputStreamReader(fileResource.getInputStream())).
			lines().forEach(v->System.err.println(v));		
		
	}

}
