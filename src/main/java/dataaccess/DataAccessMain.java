package dataaccess;



import java.sql.SQLException;
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
		
//		User nu = new User();
//		nu.setUserName("zwp");
//		nu.setUserPassWord("zzzzzzz");
//		nu.setRegTime(LocalDateTime.now().toString());
//		ds.addUser(nu);
		
	}

}
