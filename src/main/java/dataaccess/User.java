package dataaccess;

public class User {
	private Integer userId;
	private String userName;
	private String userPassWord;
	private String regTime;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassWord() {
		return userPassWord;
	}
	public void setUserPassWord(String userPassWord) {
		this.userPassWord = userPassWord;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb  = new StringBuilder();
		sb.append(userId).append(",");
		sb.append(userName).append(",");
		sb.append(userPassWord).append(",");
		sb.append(regTime);
		return sb.toString();
	}
	
}
