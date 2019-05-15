package boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;

import starter.MyStarterInfo;
import starter.StarterInfoProvider;

@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class,DataSourceAutoConfiguration.class})
public class SpringCompentTestApplication implements CommandLineRunner{

	@Autowired
	ApplicationContext ctx;
	
//	@Bean
	public StarterInfoProvider startInfoProvider() {
		StarterInfoProvider pro = new StarterInfoProvider();
		pro.setInfo(new MyStarterInfo());
		return pro;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCompentTestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 自定义starter 和 自动配置 测试
		StarterInfoProvider pro = ctx.getBean(StarterInfoProvider.class);
		System.err.println(pro.getInfo().getName());
	}

}
