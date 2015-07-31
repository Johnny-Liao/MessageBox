package lsh.messagebox.factory;

import lsh.messagebox.dao.AdminDao;
import lsh.messagebox.dao.MessageDao;
import lsh.messagebox.dao.NaticeDao;
import lsh.messagebox.dao.UserDao;
import lsh.messagebox.dao.proxy.AdminDaoProxy;
import lsh.messagebox.dao.proxy.MessageDaoProxy;
import lsh.messagebox.dao.proxy.NaticeDaoProxy;
import lsh.messagebox.dao.proxy.UserDaoProxy;


//定义工厂类取得dao实例
public class DaoFactory {
	
	//获取用户实例
	public static UserDao getUserDaoInstence() {
		return new UserDaoProxy();
	}
	
	//获取管理员实例
	public static AdminDao getAdminDaoInstence() {
		return new AdminDaoProxy();
	}
	
	//获取message实例
	public static MessageDao getMessageDaoInstence() {
		return new MessageDaoProxy();
	}
	
	//获取natice实例
	public static NaticeDao getNaticeDaoInstence() {
		return new NaticeDaoProxy();
	}
}
