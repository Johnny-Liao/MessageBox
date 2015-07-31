package lsh.messagebox.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;

import lsh.messagebox.dao.NaticeDao;
import lsh.messagebox.vo.Natice;

public class NaticeDaoImpl implements NaticeDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	
	public NaticeDaoImpl (Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void saveNatice(Natice n) {		//save the natice
		try {
			String sql = "insert into natice values(?,?,?,?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, n.getN_name());
			this.pstmt.setString(2, n.getTitle());
			this.pstmt.setString(3, n.getContent());
			this.pstmt.setString(4, n.getN_time());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Map<String, Natice> showNatice() {			//show the natice
		Map<String, Natice> allNatice = new LinkedHashMap<String, Natice>(); 
		
		try {
			String sql = "select* from natice";
			Statement st=conn.createStatement();
		    ResultSet rs=st.executeQuery(sql);
			while (rs.next()) {
				Natice n = new Natice();
				n.setN_name(rs.getString("n_name"));
				n.setTitle(rs.getString("title"));
				n.setContent(rs.getString("content"));
				n.setN_time(rs.getString("n_time"));
				
				allNatice.put(rs.getString("n_name"), n);
				n = null;
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
		
		
		for (Map.Entry<String, Natice> entry : allNatice.entrySet()) { // 打印楼层--测试
			Natice mes = entry.getValue();
			System.out.println(mes.getN_name());
			System.out.println(mes.getTitle());
		}
		
		
		return allNatice;
	}

}
