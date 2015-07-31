package lsh.messagebox.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import lsh.messagebox.dao.MessageDao;
import lsh.messagebox.vo.Message;

public class MessageDaoImpl implements MessageDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public MessageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	
	@Override
	public boolean saveMessage(Message mes) throws Exception {
		boolean flag = false;
		
		try {
			String sql = "insert into message (m_name,theme,email,address,picture,qq,myhome,message,admonly,m_time) value(?,?,?,?,?,?,?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, mes.getM_name());		
			this.pstmt.setString(2, mes.getTheme());	
			this.pstmt.setString(3, mes.getEmail());	
			this.pstmt.setString(4, mes.getAddress());	
			this.pstmt.setString(5, mes.getPicture());	
			this.pstmt.setString(6, mes.getQq());	
			this.pstmt.setString(7, mes.getMyhome());	
			this.pstmt.setString(8, mes.getMessage());	
			this.pstmt.setString(9, mes.getAdmonly());	
			this.pstmt.setString(10, mes.getM_time());	
			this.pstmt.executeUpdate();
			flag = true;
		} catch (Exception e) {
			throw e;
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

	@Override
	public Map<String, Message> showMessage() {			
		
		Map<String,Message> allMessage = new LinkedHashMap<String,Message>();			//存储所以留言
		
		try {
			String sql = "select* from message";
			
			Statement st=conn.createStatement();
		    ResultSet rs=st.executeQuery(sql);
			
			/*this.pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = this.pstmt.executeQuery();*/
			while (rs.next()) {
				
				Message mes = new Message();
				
				mes.setM_name(rs.getString("m_name"));			//用一个message对象获得相应message信息
				mes.setTheme(rs.getString("theme"));			
				mes.setEmail(rs.getString("email"));
				mes.setAddress(rs.getString("address"));
				mes.setPicture(rs.getString("picture"));
				mes.setQq(rs.getString("qq"));
				mes.setMyhome(rs.getString("myhome"));
				mes.setMessage(rs.getString("message"));
				mes.setAdmonly(rs.getString("admonly"));
				mes.setM_time(rs.getString("m_time"));
				mes.setM_level(rs.getString("m_level"));
				
				allMessage.put(rs.getString("m_level"), mes);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
		return allMessage;
	}
}
