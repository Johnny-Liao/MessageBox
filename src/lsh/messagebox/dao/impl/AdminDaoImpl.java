package lsh.messagebox.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lsh.messagebox.dao.AdminDao;
import lsh.messagebox.vo.Admin;

public class AdminDaoImpl implements AdminDao {

	private Connection conn = null;
	private PreparedStatement pstmt= null;
	
	public AdminDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean findLogin(Admin admin) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "select a_name from m_admin where a_id=? and a_password=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, admin.getA_id());		//取得id
			this.pstmt.setString(2, admin.getA_password());	//取得密码
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				admin.setA_name(rs.getString("a_name"));			//取得姓名
				flag = true;								//登陆成功
			}
		} catch (Exception e) {
			throw e;			//向上抛异常
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return flag;
	}

}
