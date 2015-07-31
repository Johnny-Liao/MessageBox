package lsh.messagebox.dao;

import java.util.Map;

import lsh.messagebox.vo.Message;

public interface MessageDao {
	
	//保存留言
	boolean saveMessage(Message mes) throws Exception;
	
	//显示留言
	Map<String, Message> showMessage();
	
}
