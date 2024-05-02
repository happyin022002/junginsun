<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoPopup.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoMail.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCommon.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoFormControl.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoCalendar.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoObject.js?version=U5"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/IBSheetInfo.js?version=multi"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoWait.js?version=U10"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoBiz.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/CoUpload.js?version=U1"></script>
<script language="javascript" type="text/javascript" >
	function comMailKeyReturn(key){
		alert(key);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mail Popup Test</title>
</head>
<body>
<form name="form">
<table>
	<tr>
		<td>RdSubSystemCode</td>
		<td><input type="text" size=150 name="com_rdSubSysCd" value="COM"></td>
	</tr>
	<tr>
		<td>From</td>
		<td><input type="text" size=150 name="com_from" value="nhc123@cyberlogitec.com"></td>
	</tr>
	<tr>
		<td>From Name</td>
		<td><input type="text" size=150 name="com_fromName" value="HC TEST"></td>
	</tr>
	<tr>
		<td>To</td>
		<td><input type="text" size=150 name="com_recipient" value="coolguy@cyberlogitec.com"></td>
	</tr>
	<tr>
		<td>CC</td>
		<td><input type="text" size=150 name="com_carbonCopy" value=""></td>
	</tr>
	<tr>
		<td>BCC</td>
		<td><input type="text" size=150 name="com_blindCarbonCopy" value=""></td>
	</tr>
	<tr>
		<td>Subject</td>
		<td><input type="text" size=150 name="com_subject" value="Title 입니다."></td>
	</tr>
	<tr>
		<td>File Key</td>
		<td><input type="text" size=150 name="com_fileKey" value=""></td>
	</tr>
	<tr>
		<td>Content</td>
		<td><input type="text" size=150 name="com_content" value=""></td>
	</tr>
	<tr>
		<td>Template</td>
		<td><input type="text" size=150 name="com_template" value="template.htmlmail"></td>
	</tr>
	<tr>
		<td>TemplateArguments</td>
		<td><input type="text" size=150 name="com_argument" value="name;김정훈,message;Hello"></td>
	</tr>
	<tr>
		<td>Set SMTP</td>
		<td><input type="text" size=150 name="com_smtp" value=""></td>
	</tr>
	<tr>
		<td>Set Office Code</td>
		<td><input type="text" size=150 name="com_officeCode" value=""></td>
	</tr>
	<tr>
		<td>Set Groupware Mail</td>
		<td><input type="text" size=150 name="com_groupwareMail" value="false"></td>
	</tr>
	<tr>
		<td>MailKey</td>
		<td><input type="text" size=150 id="com_mailKeyFlag" value="true"></td>
	</tr>
	<tr>
		<td><input type="button" value="fire" onclick="ComSendMailModal()"></td>
	</tr>
</table>
</form>
</body>
</html>