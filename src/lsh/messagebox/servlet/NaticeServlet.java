package lsh.messagebox.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.messagebox.factory.DaoFactory;
import lsh.messagebox.vo.Natice;

public class NaticeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");
		
		String name = request.getParameter("textfield");
		String title = request.getParameter("textfield2");
		String content = request.getParameter("naticecontent");
		
		System.out.println(title);
		System.out.println(content);
		
		if (title.trim().length() == 0) {
			request.setAttribute("errortitle", "标题不能为空");
			request.getRequestDispatcher("/note_edit.jsp").forward(request, response);
			return;
		} 
		if (content.trim().length() == 0) {
			request.setAttribute("errorcon", "公告不能为空");
			request.getRequestDispatcher("/note_edit.jsp").forward(request, response);
			return;
		}
		
		
		Natice nd = new Natice();
		nd.setN_name(name);
		nd.setTitle(title);
		nd.setContent(content);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = sdf.format(new Date());
		nd.setN_time(time);
		
		DaoFactory.getNaticeDaoInstence().saveNatice(nd);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		return;
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
