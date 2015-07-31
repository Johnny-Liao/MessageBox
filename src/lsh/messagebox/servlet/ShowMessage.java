package lsh.messagebox.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.messagebox.factory.DaoFactory;
import lsh.messagebox.vo.Message;

public class ShowMessage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Message> allMessage = DaoFactory.getMessageDaoInstence().showMessage();		//获得留言
		request.getSession().setAttribute("allMessage", allMessage);	
		
	/*	for(Map.Entry<String,Message> entry: allMessage.entrySet()) {		//打印楼层--测试
			Message mes = entry.getValue();
			System.out.println(mes.getM_level());
			System.out.println(mes.getM_time());
		}*/
		
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
