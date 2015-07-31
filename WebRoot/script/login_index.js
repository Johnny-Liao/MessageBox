//登录界面验证
function validate_form(thisform) {
	with (thisform) {
		var name = userid.value;
		var password = userpassword.value;
		
		if (name.trim().length == 0) {
			alert("用户名不能为空！");
			userid.focus();
			return false;
		}
		if (password.trim().length == 0) {
			alert("密码不能为空！");
			userpassword.focus();
			return false;
		}
	}
	return true;
}



//主界面
function validate_indexform(thisform) {
	with (thisform) {
		
		var theme = textfield1.value;
		var email = textfield2.value;
		var qq = textfield3.value;
		var myhome = textfield4.value;
		var message = in_message.value;
		var id = user_check.value;
		
		if (id == "admin") {
			alert("管理员不能发表留言！");
			return false;
		}
		
		if (theme.trim().length == 0) {
			alert("留言主题不能为空！");
			theme.focus();
			return false;
		}
		if (email.trim().length == 0) {
			alert("email不能为空！");
			email.focus();
			return false;
		}
		if (qq.trim().length == 0) {
			alert("qq不能为空！");
			qq.focus();
			return false;
		}
		if (qq != parseInt(qq) ) {
			alert("qq不合法！");
			qq.focus();
			return false;
		}
		if (myhome.trim().length == 0) {
			alert("主页不能为空！");
			myhome.focus();
			return false;
		}
		if (message.trim().length == 0) {
			alert("留言不能为空！");
			message.focus();
			return false;
		}
		if (message.trim().length > 300) {
			alert("留言字数最多为300.！");
			message.focus();
			return false;
		}
		
		//确认有文件上传
		var file = document.getElementById("fileupload").value;
		if(file == null || file == ""){
		    alert("请选择上传的图片");
		    return(false);
		}
	}
	return true;
}

//管理员可见提示
function check() { 
	var lee=document.forms["message"].lee;
	if (lee.checked == true) { 
		window.confirm("你確定只有管理员可见吗？");
	} 
} 

//提交快捷键
function ctrlSubmit(event) {
	if(event.ctrlKey&&event.keyCode==13) {
		document.getElementById('submit').click();
	}
}

function naticeChcked(thisform) {
	with(thisform) {
		var title = textfield2.value;
		var natice = naticecontent.value;
		
		if (title.trim().length == 0) {
			alert("公告标题不能为空！");
			textfield2.focus();
			return false;
		}
		
		if (title.trim().length > 12) {
			alert("公告标题不能超过12个字！");
			textfield2.focus();
			return false;
		}
		
		if (natice.trim().length == 0) {
			alert("公告内容不能为空！");
			nativecontent.foucs();
			return false;
		}
	}
	return true;
}

function shownote() {
	window.location.href="/MessageBox/ShowNatice"; 
}