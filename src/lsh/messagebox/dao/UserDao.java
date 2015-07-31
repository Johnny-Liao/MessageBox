package lsh.messagebox.dao;

import lsh.messagebox.vo.User;


public interface UserDao {
	
	//用户登录验证
	public boolean findLogin(User user) throws Exception;
	
}
