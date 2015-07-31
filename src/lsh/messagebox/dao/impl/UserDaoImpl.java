package lsh.messagebox.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lsh.messagebox.dao.UserDao;
import lsh.messagebox.vo.User;


/**实现类
 * 通过输入的用户id和密码进行验证，
 * 如果验证成功，则通过vo将用户的真实姓名取出并返回
 *
 */

public class UserDaoImpl implements UserDao {

	private Connection conn = null;
	private PreparedStatement pstmt= null;
	
	public UserDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public boolean findLogin(User user) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "select u_name from m_user where u_id=? and u_password=?";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, user.getUserid());		//取得id
			this.pstmt.setString(2, user.getPassword());	//取得密码
			ResultSet rs = this.pstmt.executeQuery();
			if (rs.next()) {
				user.setName(rs.getString("u_name"));			//取得姓名
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
