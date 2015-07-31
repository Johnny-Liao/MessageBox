package lsh.messagebox.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.messagebox.factory.DaoFactory;
import lsh.messagebox.vo.Natice;

public class ShowNatice extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, Natice> allNatice = DaoFactory.getNaticeDaoInstence().showNatice();
		
		request.getSession().setAttribute("allNatice", allNatice);	
		
		for (Map.Entry<String, Natice> entry : allNatice.entrySet()) { // 打印楼层--测试
			Natice mes = entry.getValue();
			System.out.println(mes.getN_name());
			System.out.println(mes.getTitle());
		}
		
		
		response.sendRedirect(request.getContextPath() + "/shownote.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
