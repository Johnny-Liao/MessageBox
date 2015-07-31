package lsh.messagebox.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lsh.messagebox.factory.DaoFactory;
import lsh.messagebox.util.IPTimeStamp;
import lsh.messagebox.vo.Message;

import com.jspsmart.upload.SmartUpload;


//处理留言信息
public class MessageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("GBK");		//会取中文编码--无用功
		response.setCharacterEncoding("GBK");
		response.setContentType("text/html;charset=GBK");
		
		SmartUpload smart = new SmartUpload();		//为后面上传图片先定义
		smart.initialize(this.getServletConfig(), request, response);
		String fileName = null;
		try {
			smart.setAllowedFilesList("jpg,png");		//设置上传文件类型
			smart.upload();
			IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr());
			String ext = smart.getFiles().getFile(0).getFileExt();			//获取文件后缀
			fileName = its.getIPTimeRand() + "." + ext;						//拼凑文件名称
			smart.getFiles().getFile(0).saveAs(getServletContext().getRealPath("/")+"upload"+java.io.File.separator + fileName);	//保存文件
		} catch (Exception e) {
			request.setAttribute("picture_error", "图片上传出错，只能上传jpg和png类型的文件！");			//有点小bug图片出错会降低用户体验
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		//获取相应参数信息
		String theme = smart.getRequest().getParameter("textfield1");		
		String email = smart.getRequest().getParameter("textfield2");
		String address = smart.getRequest().getParameter("select");
		String picture = fileName;
		String qq = smart.getRequest().getParameter("textfield3");		
		String myhome = smart.getRequest().getParameter("textfield4");
		String message = smart.getRequest().getParameter("in_message");
		String checkbox = smart.getRequest().getParameter("checkbox");
		
		//just debug
		System.out.println(theme);
		System.out.println(email);
		System.out.println(address);
		System.out.println(picture);
		System.out.println(qq);
		System.out.println(myhome);
		System.out.println(message);
		System.out.println(checkbox);
		
		//设置相应信息用来存入数据库
		Message mes = new Message();
			mes.setM_name((String)request.getSession().getAttribute("LoginName"));
			mes.setTheme(theme);
			mes.setEmail(email);
			mes.setAddress(address);
			mes.setPicture(picture);
			mes.setQq(qq);
			mes.setMyhome(myhome);
			mes.setMessage(message);
		if (checkbox == null) 																				///////////-----------未解决---全是0
			mes.setAdmonly("0");		
		else
			mes.setAdmonly("1");		//只有管理员可见	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = sdf.format(new Date());
		mes.setM_time(time);
		
		//把用户填写好的信息保存，提高用户体验
		request.setAttribute("message", mes);			
		
		//验证
		if (theme.trim().length() < 4 || theme.trim().length() > 10) {
			request.setAttribute("theme_error", "留言主题只能是4~10个字之间！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		if (!email.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")) {
			request.setAttribute("email_error", "email格式不正确！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		//验证通过把数据存入数据库--闯过重重关卡啊
		try {
			DaoFactory.getMessageDaoInstence().saveMessage(mes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.removeAttribute("message");						//上传成功后把用户所填表单清空以用下次填写。
		request.getRequestDispatcher("/ShowMessage").forward(request, response);
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
