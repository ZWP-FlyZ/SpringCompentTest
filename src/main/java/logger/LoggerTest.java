package logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// JDK 原生日志实现
		java.util.logging.Logger lgJdk = 
					java.util.logging.Logger.getLogger(LoggerTest.class.getName());
		lgJdk.info(" JDK logger");
		
//		org.apache.logging.log4j.Logger lgLg4j = 
//				org.apache.logging.log4j.LogManager.getLogger(LoggerTest.class);
//		lgLg4j.info(" Log4J logger");
		
		Logger logger = LoggerFactory.getLogger(LoggerTest.class);
		logger.info("SLF4J Logger - log4j");
	}

}
