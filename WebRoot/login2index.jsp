<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="sessioncheck.jsp" %>	 	<%-- ��֤�Ƿ��¼ --%>
<html>
  <head>
    <title>Welcome to index!</title>
  </head>
  <meta http-equiv='refresh' content='3; url=${pageContext.request.contextPath}/ShowMessage' />

  <body>
	<center><font size="4" color="#33FF33">	��ӭ${LoginInfo}3�����ת�����԰���ҳ��</font></center>
	<center><font size="3" color="#FF3333">��δ��ת���<a href="${pageContext.request.contextPath}/ShowMessage">here!</a></font></center>
  </body>
</html>
