<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'shownote.jsp' starting page</title>
    
  </head>
  
  <body>
  <center>
	<table border="1" width="60%">
   		<tr>
   			<td>发布者</td>
   			<td>标题</td>
   			<td>发布时间</td>
   			<td>公告内容</td>
   		</tr>
	    <c:forEach var="entry" items="${allNatice}">
	    		<tr>
	    			<td>${entry.value.n_name}</td>
	    			<td>${entry.value.title}</td>
	    			<td>${entry.value.n_time}</td>
	    			<td>${entry.value.content}</td>
	    		</tr>
	    </c:forEach>
	</table>
    </center>
  </body>
</html>
