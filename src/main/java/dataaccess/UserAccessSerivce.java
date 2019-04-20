package dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserAccessSerivce {

	@Autowired
	JdbcTemplate template;
	
	@Autowired
	TransactionTemplate txTemplate;
	
	
	public int addUser(User user) {
		String sql = "INSERT INTO user (user_name,user_pass,user_reg_time) values (?,?,?)";
		return template.update(sql, user.getUserName(),
									user.getUserPassWord(),
									user.getRegTime());
	}
	
	public List<User> getUserByUserName(String userName){
		String sql = "SELECT * FROM user WHERE user_name=? limit 1";
		return template.query(sql, new UserRowMapper(),userName);
	}
	
	
	public int addUserTx(User user) {
		txTemplate.execute(status->{
			addUser(user);
			throw new IllegalArgumentException("事务测试");

		});
		return 0;
	}
	
	@Transactional
	public int addUserTx2(User user) {
		addUser(user);
		throw new IllegalArgumentException("事务测试");
	}
	
	private class UserRowMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt("iduser"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPassWord(rs.getString("user_pass"));
			user.setRegTime(rs.getString("user_reg_time"));
			return user;
		}
		
	}
	
}
