<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="sessioncheck.jsp" %>	 	<%-- 验证是否登录 --%>
<html>
  <head>
    <title>Welcome to index!</title>
  </head>
  <meta http-equiv='refresh' content='3; url=${pageContext.request.contextPath}/ShowMessage' />

  <body>
	<center><font size="4" color="#33FF33">	欢迎${LoginInfo}3秒后跳转到留言板首页！</font></center>
	<center><font size="3" color="#FF3333">如未跳转请点<a href="${pageContext.request.contextPath}/ShowMessage">here!</a></font></center>
  </body>
</html>
