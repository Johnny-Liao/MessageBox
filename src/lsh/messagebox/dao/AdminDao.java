package lsh.messagebox.dao;

import lsh.messagebox.vo.Admin;

public interface AdminDao {
	
	//管理员登录验证
	public boolean findLogin(Admin admin) throws Exception;

}
