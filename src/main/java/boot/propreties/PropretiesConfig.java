package boot.propreties;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
@EnableConfigurationProperties(MypInfo.class)
public class PropretiesConfig implements CommandLineRunner{

	private final static Logger logger = LoggerFactory.getLogger(PropretiesConfig.class);
	@Value("${myp.msg}")
	String message;
	
	@Autowired
	MypInfo info;
	
//	@Bean("validator")
//	public LocalValidatorFactoryBean getLocalValidation() {
//		return new LocalValidatorFactoryBean();
//	}
	
	@Autowired
	Validator validator;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info(message);
		
//		DataBinder db = new DataBinder(info);
//		db.addValidators(validator);
//		db.validate();
//		BindingResult res =db.getBindingResult();
//		res.getAllErrors().forEach(o->System.err.println(o.getCode()));
		
		// 注意如果MypInfo通不过验证会报异常程序不能正常运行
		logger.info(info.getMsg());
		
	}
	
}
