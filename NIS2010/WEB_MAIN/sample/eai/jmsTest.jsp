<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JMS Send Test Page</title>
</head>
<body>
<form name="form" action="jmsSend.jsp" method="post">
<table>
	<tr>
		<td>Message</td>
		<td><input type="text" size=50 name="message" value=""></td>
		
	</tr>
	<tr>
		<td>Repeat for:</td>
		<td><input type="text" size=5 name="loop" value=""></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="Send"></td>
	</tr>

</table>
</form>
</body>
</html>