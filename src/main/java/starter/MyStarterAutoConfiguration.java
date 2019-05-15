package starter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyStarterInfo.class)
public class MyStarterAutoConfiguration {

	@Autowired
	MyStarterInfo info;
	
	@Bean
	@ConditionalOnMissingBean(StarterInfoProvider.class)
	public StarterInfoProvider startInfoProvider() {
		StarterInfoProvider pro = new StarterInfoProvider();
		pro.setInfo(info);
		return pro;
	}
	
}
