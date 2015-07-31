package lsh.messagebox.dao.proxy;

import java.sql.Connection;

import lsh.messagebox.dao.UserDao;
import lsh.messagebox.dao.impl.UserDaoImpl;
import lsh.messagebox.util.DatabaseConnection;
import lsh.messagebox.vo.User;


public class UserDaoProxy implements UserDao {

	private DatabaseConnection dbc = null;				//定义数据库连接
	private Connection conn = null;
	private UserDao dao = null;							//定义dao接口
	
	public UserDaoProxy() {
		this.dbc = new DatabaseConnection();			//实例化数据库连接
		conn = this.dbc.getConnction();
		this.dao = new UserDaoImpl(conn);
	}
	
	
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(user);		//调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection(conn);
		}
		return flag;
	}

}
