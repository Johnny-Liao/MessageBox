package lsh.messagebox.dao.proxy;

import java.sql.Connection;
import java.util.Map;

import lsh.messagebox.dao.MessageDao;
import lsh.messagebox.dao.impl.MessageDaoImpl;
import lsh.messagebox.util.DatabaseConnection;
import lsh.messagebox.vo.Message;

public class MessageDaoProxy implements MessageDao {

	private DatabaseConnection dbc = null;				//定义数据库连接
	private Connection conn = null;
	private MessageDao md = null;
	
	public MessageDaoProxy() {
		dbc = new DatabaseConnection();
		conn = dbc.getConnction();
		md = new MessageDaoImpl(conn);
	}
	
	@Override
	public boolean saveMessage(Message mes) throws Exception {
		boolean flag = false;
		
		try {
			flag = md.saveMessage(mes);
		} catch (Exception e) {
			throw e;
		} finally {
			dbc.closeConnection(conn);
		}
		
		return flag;
	}

	@Override
	public Map<String, Message> showMessage() {
		Map<String, Message> allmessage = md.showMessage();
		dbc.closeConnection(conn);
		return allmessage;
	}

}
