package lsh.messagebox.dao.proxy;

import java.sql.Connection;
import java.util.Map;

import lsh.messagebox.dao.NaticeDao;
import lsh.messagebox.dao.impl.NaticeDaoImpl;
import lsh.messagebox.util.DatabaseConnection;
import lsh.messagebox.vo.Natice;

public class NaticeDaoProxy implements NaticeDao {

	private DatabaseConnection dbc = null;				//定义数据库连接
	private Connection conn = null;
	private NaticeDao nat = null;
	
	public NaticeDaoProxy() {
		dbc = new DatabaseConnection();
		conn = dbc.getConnction();
		nat = new NaticeDaoImpl(conn);
	}
	
	
	@Override
	public void saveNatice(Natice n) {
		try {
			nat.saveNatice(n);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbc.closeConnection(conn);
		}
	}

	@Override
	public Map<String, Natice> showNatice() {
		Map<String, Natice> allNatice = nat.showNatice();
		dbc.closeConnection(conn);
		return allNatice;
	}

}
