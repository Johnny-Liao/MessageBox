<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@ include file="sessioncheck.jsp" %>		<%-- ��֤�Ƿ��¼ --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>���㹤�������԰�</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<link href="css/index.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/login_index.js"></script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
<!-- ImageReady Slices (index.jpg) -->
<table id="__01" width="990" height="793" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="7">
			<img src="images/index_08.gif" width="12" height="631" alt=""></td>
		<td height="27" colspan="2" class="tdfont" background="images/index_09_repeat.gif">&nbsp;${LoginInfo}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${note_href }   ">��������</a></td>
		<td rowspan="7">
			<img src="images/index_10.gif" width="7" height="631" alt=""></td>
	</tr>
	<tr>
		<td colspan="2"><marquee class="tdfont" vspace="5" scrollamount="3"  height="15" width="500" align="middle" onMouseOver="this.stop()" onMouseOut="this.start()"><a href="#">��ӭ�������㹤�������԰壡</a></marquee></td>
	</tr>
	<tr>			
	<!-- ---------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!��ʾ���Կ�ʼ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
				<td colspan="2">
	<c:forEach var="entry" items="${allMessage }">
		<c:if test="${ LoginId == 'admin' || entry.value.admonly == '0' }">		<%--����ֻ�й���Ա�ɼ�	--%>
			<table width="762" bordercolor="#FF6600" cellspacing="0" cellpadding="0" border="1">
		  <tr align="center" class="tdfont">
		    <td height="27" width="200" background="images/index_09_repeat.gif">��������</td>
		    <td height="27" background="images/index_09_repeat.gif">������Ϣ</td>
		   
		  </tr>
		  <tr>
		    <td><table width="200" cellspacing="0" cellpadding="0" border="0">
		      <tr>
		        <td colspan="3" align="center"><img src="${pageContext.request.contextPath}/upload/${entry.value.picture}" width="75" height="75"></td><!--images/1.gif-->
		        </tr>
		      <tr class="tdfont">
		        <td align="right">NO:${entry.key }</td>
		        <td width="22" height="15" ><img src="images/logo_sanjiao.gif"></td>
		        <td align="left" width="90">${entry.value.m_name }</td>
		      </tr>
		    </table></td>
		    <td valign="top"><table width="562" cellspacing="0" cellpadding="0" border="0">
		      <tr>
		        <td class="tdfont" width="53">���⣺</td>
		        <td>${entry.value.theme }</td>
		        <td class="tdfont" width="53">ʱ�䣺</td>
		        <td>${entry.value.m_time }</td>
		        <td>&nbsp;</td>
		        <td width="19" height="16"><img src="images/icon_profile.gif" alt="סַ" width="16" height="16"></td>
		        <td width="19" height="16"><img src="images/icon_email.gif" alt="����" width="16" height="16"></td>
		        <td width="19" height="16"><img src="images/icon_editor_oicq.gif" alt="ICQC" width="16" height="16"></td>
		        <td width="19" height="16"><img src="images/icon_homepage.gif" alt="��ҳ" width="16" height="16"></td>
		        <td width="19" height="16"><img src="images/icon_ip.gif" alt="IP" width="16" height="16"></td>
		      </tr>
		      <tr>
		        <td colspan="10" height="75" background="images/index_09_repeat1.gif">&nbsp;${entry.value.message }</td>
		        </tr>
		    </table></td>
		  </tr>
		</table>
		<br>
		</c:if>
	</c:forEach>
		</td>
			<!-- ---------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!��ʾ���Խ���!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
	</tr>
	
	<input type="submit" name="shownote" value="�鿴����" onclick="shownote()">
	<tr height="27">
		<td valign="bottom" colspan="2" width="762" height="27" background="images/index_09_repeat.gif"></td>
	</tr>
	<tr>
		<td colspan="2"><img src="images/index_14.gif" width="762" height="9" alt=""></td>
	</tr>
	<tr>
		<td colspan="2" width="762" height="380">
	<form action="MessageServlet" name="message" method="post" onsubmit="return validate_indexform(this)" encType="multipart/form-data" onkeydown="ctrlSubmit(event)">					<%--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!����ʼ!!!!!!!!!!!!!!!!!!!!!!! --%>
		<table class="tdfont"  width="762" height="380" border="1" cellpadding="0" cellspacing="0" bordercolor="orange">
		  <tr align="center">
		    <td height="28" colspan="2" background="images/index_09_repeat.gif"><font style="font-weight:bold; color:ffffff">ǩд����</font></td>
		  </tr>
		  
		  <tr>
		    <td width="233" height="28"><div align="right">�������⣺</div></td>
		    <td height="28"><label><input name="textfield1" type="text" size="40" value="${message.getTheme() }" />*�����<font color="#FF3333">${theme_error }</font></label></td>
		  </tr>
		  <tr>
		    <td height="28"><div align="right">�����ʼ���</div></td>
		    <td height="28"><label><input type="text" name="textfield2" value="${message.getEmail() }" />*�����<font color="#FF3333">${email_error }</font></label></td>
		  </tr>
		  <tr>
		    <td height="28"><div align="right">���Ժη���</div></td>
		    <td height="28"><label>
		      <select name="select" >
		        <option value="����">����</option>
		        <option value="����">����</option>
		        <option value="����">����</option>
		      </select>
		    *�����</label></td>
		  </tr>
		  <tr>
		    <td height="28"><div align="right">ͷ��</div></td>
		    <td height="28"><input type="file" name="picture" id="fileupload"/>*����ѡ��<font color="#FF3333">${picture_error}</font></td>
		  </tr>
		  <tr>
		    <td height="28"><div align="right">Q&nbsp;Q:</div></td>
		    <td height="28"><label>
		      <input type="text" name="textfield3" value="${message.getQq() }" />*�����</label></td>
		  </tr>
		  <tr>
		    <td height="28"><div align="right">�ҵ���ҳ��</div></td>
		    <td height="28"><label>
		      <input type="text" name="textfield4" value="${message.getMyhome() }" />
		    *�����</label></td>
		  </tr>
		  <tr>
		    <td><div align="right">�������ݣ�</div></td>
		    <td><textarea name="in_message" cols="55" rows="10" >${message.getMessage()}</textarea>
		*�����</td>
		  </tr>
		  <tr>
		    <td height="28">&nbsp;</td>
		    <td height="28" >
		    	<input name="" type="image" id="submit" src="images/button_note_tijiao.gif" "/>
		     		 [��CTRL+ENTERֱ�ӷ���]
		        <label><input type="checkbox" name="checkbox" value="checked" onClick="check();" id="lee" />ֻ�й���Ա���ܿ�</label>
		        <input type="hidden" name="user_check" value="${LoginId}">
		    </td>
		  </tr>
		</table>
	</form>				<%--!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!������!!!!!!!!!!!!!!!!!!!!!!! --%>
		</td>
	</tr>
	
	<tr>
		<td colspan="2" >
			<img src="images/index_16.gif" width="762" height="17" alt=""></td>
	</tr>
	<tr>
		<td align="center" class="tdfont" colspan="4" width="781" height="37" background="images/foot_repeate.gif">
		  <a href="admin_index.jsp">����Ա��½</a>
			</td>
	</tr>
	<tr>
		<td>
			<img src="images/�ָ���.gif" width="104" height="1" alt=""></td>
		<td>
			<img src="images/�ָ���.gif" width="12" height="1" alt=""></td>
		<td>
			<img src="images/�ָ���.gif" width="164" height="1" alt=""></td>
		<td>
			<img src="images/�ָ���.gif" width="598" height="1" alt=""></td>
		<td>
			<img src="images/�ָ���.gif" width="7" height="1" alt=""></td>
		<td>
			<img src="images/�ָ���.gif" width="105" height="1" alt=""></td>
	</tr>
</table>
<!-- End ImageReady Slices -->
</center>
</body>
</html>