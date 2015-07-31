package lsh.messagebox.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.messagebox.factory.DaoFactory;
import lsh.messagebox.vo.Admin;
import lsh.messagebox.vo.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/login2index.jsp";
		String userid = request.getParameter("userid");
		String userpassword = request.getParameter("userpassword");
		
		String info = new String();				//用來保存信息
		String loginname = new String();				//用來保存登录姓名
		
		if (userid.trim().length() <= 4 || userid.trim().length() > 10) {			//确保输入合法
			info = "请输入正确的id:用户id为6~10位字母或数字，管理员为5位字母或数字！";
			request.setAttribute("info", info);
			request.getRequestDispatcher("/login_index.jsp").forward(request, response);
			return;
		}
		
		if (userid.trim().length() > 5 ) {			//用户登录
			User user = new User();			
			user.setUserid(userid);
			user.setPassword(userpassword);
			try {
				if (DaoFactory.getUserDaoInstence().findLogin(user)) {			//用户验证通过		
					info = user.getName() + "-用户,登录成功！";
					loginname = user.getName();
					request.getSession().setAttribute("LoginId", "user");					//标记用户
					request.getSession().setAttribute("note_href","admin_index.jsp");					//限制用户发布公告
				} else {
					info = "用户登录失败，错误的用户名或密码";
					request.setAttribute("info", info);
					request.getRequestDispatcher("/login_index.jsp").forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		} else {									//管理员登录
			
			Admin admin = new Admin();
			admin.setA_id(userid);
			admin.setA_password(userpassword);
			
			try {
				if (DaoFactory.getAdminDaoInstence().findLogin(admin)) {
					info = admin.getA_name() + "-管理员,登录成功！";
					loginname = admin.getA_name();
					request.getSession().setAttribute("LoginId", "admin");					//标记管理员
					request.getSession().setAttribute("note_href","note_edit.jsp");					//限制用户发布公告
				} else {
					info = "管理员登录失败，错误的管理员id或密码";
					request.setAttribute("info", info);
					request.getRequestDispatcher("/login_index.jsp").forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		request.getSession().setAttribute("LoginName", loginname);				//保存用户名用以存入留言信息中
		request.getSession().setAttribute("LoginInfo", info);					//保存登录用户信息
		request.getRequestDispatcher(path).forward(request, response);			//跳转路径相同
		return;

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
