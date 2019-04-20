package dataaccess;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@ComponentScan("dataaccess")
@PropertySource("application.properties")
@EnableTransactionManagement
public class AppConfig {

	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String username;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Bean("datasource")
	public DataSource getDataSource() {
		DataSource ds = new DriverManagerDataSource(url, username, password);
		return ds;
	}
	
	@Bean("txManager")
	public DataSourceTransactionManager getTxManager(DataSource datasource) {
		return new DataSourceTransactionManager(datasource);
	}
	
	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
	
	@Bean("txTemplate")
	public TransactionTemplate getTxTemplate(PlatformTransactionManager txManager) {
		return new TransactionTemplate(txManager);
	}
		
}
