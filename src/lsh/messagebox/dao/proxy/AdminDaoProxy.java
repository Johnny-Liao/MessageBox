package lsh.messagebox.dao.proxy;

import java.sql.Connection;

import lsh.messagebox.dao.AdminDao;
import lsh.messagebox.dao.impl.AdminDaoImpl;
import lsh.messagebox.util.DatabaseConnection;
import lsh.messagebox.vo.Admin;

public class AdminDaoProxy implements AdminDao {

	private DatabaseConnection dbc = null;				//定义数据库连接
	private Connection conn = null;
	private AdminDaoImpl dao = null;							//定义dao接口
	
	public AdminDaoProxy() {
		this.dbc = new DatabaseConnection();			//实例化数据库连接
		conn = this.dbc.getConnction();
		this.dao = new AdminDaoImpl(conn);
	}
	
	@Override
	public boolean findLogin(Admin admin) throws Exception {
		boolean flag = false;
		try {
			flag = this.dao.findLogin(admin);		//调用真实主题
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.closeConnection(conn);
		}
		return flag;
	}

}
