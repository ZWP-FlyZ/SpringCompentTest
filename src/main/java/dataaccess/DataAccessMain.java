package dataaccess;



import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataAccessMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserAccessSerivce ds = ctx.getBean(UserAccessSerivce.class);
		List<User> user = ds.getUserByUserName("zwp");
		user.forEach(u->System.err.println(u));
		
		User nu = new User();
		nu.setUserName("zwp"+System.currentTimeMillis());
		nu.setUserPassWord("zzzzzzz");
		nu.setRegTime(LocalDateTime.now().toString());
		ds.addUserTx2(nu);
		
	}

}
