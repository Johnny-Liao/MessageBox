<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%-- <%@ include file="sessioncheck.jsp" %>	--%>	<%-- ��֤�Ƿ��¼ --%>
<html>
<head>
<link href="css/index.css" rel="stylesheet" type="text/css">
<title>note_edit</title>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script type="text/javascript" src="script/login_index.js"></script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
<!-- ImageReady Slices (login_index.jpg) -->
<table id="__01" width="990" height="320" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td rowspan="6">
			<img src="images/login_index_01.gif" width="102" height="320" alt=""></td>
		<td colspan="5">
	</td>
		<td rowspan="6">
			<img src="images/login_index_03.gif" width="104" height="320" alt=""></td>
	</tr>

	<tr>
		<td rowspan="4">
			<img src="images/login_index_05.gif" width="12" height="198" alt=""></td>
		<td height="27" colspan="3" class="tdfont" background="images/index_09_repeat.gif">&nbsp;<a href="#">[������ҳ]</a><a href="#">
		[��������]</a><a href="#">[��������]</a><a href="#">[ע��]</a></td>
		<td rowspan="4">
			<img src="images/login_index_07.gif" width="8" height="198" alt=""></td>
	</tr> 
	<tr>
		<td colspan="3">
			<img src="images/login_index_08.gif" width="764" height="20" alt=""></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="images/login_index_09.gif" width="29" height="148" alt=""></td>
		<td width="707" height="120">
		
		
		
			<form action="NaticeServlet" name="notice" method="post" onsubmit="return naticeChcked(this);">
			  <table class="tdfont"   width="707" height="160" border="1" cellpadding="0" cellspacing="0" bordercolor="orange">
  <tr align="center">
    <td height="28" colspan="2" background="images/index_09_repeat.gif"><font style="font-weight:bold; color:ffffff">��������</font></td>
  </tr>
  <tr>
    <td width="233" height="28" align="right">�����ߣ�</td>
    <td width="523" height="28"><label>
      <input type="text" name="textfield" readonly="true" value="${LoginName}"/>*��������,�Զ���֤.��</label></td>
  </tr>
  <tr>
    <td height="28"><div align="right">������⣺</div></td>
    <td height="28"><label>
      <input type="text" name="textfield2" />*�����<font color="#FF3333">${errortitle}</font></label></td>
  </tr>
  <tr>
    <td><div align="right">�������ݣ�</div></td>
    <td><textarea name="naticecontent" cols="55" rows="10"></textarea>*�����<font color="#FF3333">${errorcon}</font></td>
  </tr>
  <tr>
    <td height="28">&nbsp;</td>
    <td height="28" ><input name="" type="image" src="images/button_note_tijiao.gif" />
      </td>
  </tr>
</table>

			</form>
			</td>
		<td rowspan="2">
			<img src="images/login_index_11.gif" width="28" height="148" alt=""></td>
	</tr>
	<tr>
		<td width="707" height="36" align="center" class="tdfont" background="images/foot_repeate.gif"><a href="#">����Ա��½</a></td>
	</tr>	
</table>
</center>
<!-- End ImageReady Slices -->
</body>
</html>