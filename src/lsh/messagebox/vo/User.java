package lsh.messagebox.vo;

public class User {
	private String userid;		//对应u_id
	private String name;		//对应u_name
	private String password;	//对应u_password
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
