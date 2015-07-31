 <%
  	String str = (String)session.getAttribute("LoginInfo");
  	if(str==null || str.equals("")) {
  		response.sendRedirect("login_index.jsp");
  	}
 %>