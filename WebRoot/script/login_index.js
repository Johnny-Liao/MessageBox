//��¼������֤
function validate_form(thisform) {
	with (thisform) {
		var name = userid.value;
		var password = userpassword.value;
		
		if (name.trim().length == 0) {
			alert("�û�������Ϊ�գ�");
			userid.focus();
			return false;
		}
		if (password.trim().length == 0) {
			alert("���벻��Ϊ�գ�");
			userpassword.focus();
			return false;
		}
	}
	return true;
}



//������
function validate_indexform(thisform) {
	with (thisform) {
		
		var theme = textfield1.value;
		var email = textfield2.value;
		var qq = textfield3.value;
		var myhome = textfield4.value;
		var message = in_message.value;
		var id = user_check.value;
		
		if (id == "admin") {
			alert("����Ա���ܷ������ԣ�");
			return false;
		}
		
		if (theme.trim().length == 0) {
			alert("�������ⲻ��Ϊ�գ�");
			theme.focus();
			return false;
		}
		if (email.trim().length == 0) {
			alert("email����Ϊ�գ�");
			email.focus();
			return false;
		}
		if (qq.trim().length == 0) {
			alert("qq����Ϊ�գ�");
			qq.focus();
			return false;
		}
		if (qq != parseInt(qq) ) {
			alert("qq���Ϸ���");
			qq.focus();
			return false;
		}
		if (myhome.trim().length == 0) {
			alert("��ҳ����Ϊ�գ�");
			myhome.focus();
			return false;
		}
		if (message.trim().length == 0) {
			alert("���Բ���Ϊ�գ�");
			message.focus();
			return false;
		}
		if (message.trim().length > 300) {
			alert("�����������Ϊ300.��");
			message.focus();
			return false;
		}
		
		//ȷ�����ļ��ϴ�
		var file = document.getElementById("fileupload").value;
		if(file == null || file == ""){
		    alert("��ѡ���ϴ���ͼƬ");
		    return(false);
		}
	}
	return true;
}

//����Ա�ɼ���ʾ
function check() { 
	var lee=document.forms["message"].lee;
	if (lee.checked == true) { 
		window.confirm("��_��ֻ�й���Ա�ɼ���");
	} 
} 

//�ύ��ݼ�
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
			alert("������ⲻ��Ϊ�գ�");
			textfield2.focus();
			return false;
		}
		
		if (title.trim().length > 12) {
			alert("������ⲻ�ܳ���12���֣�");
			textfield2.focus();
			return false;
		}
		
		if (natice.trim().length == 0) {
			alert("�������ݲ���Ϊ�գ�");
			nativecontent.foucs();
			return false;
		}
	}
	return true;
}

function shownote() {
	window.location.href="/MessageBox/ShowNatice"; 
}