<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoMessage.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoAxon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCommon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoFormControl.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoUpload.js"></script>
<script type="text/javascript">
	function doUpload(subSysCd){
	var returnValue = openUpload(subSysCd[0].value);
		document.form.keys.innerText=returnValue;
		alert(returnValue);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form">
<input type="text" value="COM" name="subSysCd"><br>
<input type="button" value="popup" onclick='doUpload(document.getElementsByName("subSysCd"))';><br>
<textarea name="keys" style="width:100%; height:350px"></textarea>
</form>
</body>
</html>