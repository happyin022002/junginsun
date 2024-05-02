<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
</head>
<%
	GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");
%>
<link href="http://nis2010.hanjin.com/css/alps_contents.css" rel="stylesheet" type="text/css">

<body> 
<form name="form" action="/hanjin/MailResend.do">
<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="1" align="center"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn2_Resend_Mail" onclick="form.submit()">ReSend</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<table class="search"> 
       	<tr><td class="bg">
				
	<table width="100%" class="search"> 
		<tr class="h23">
			<td width="20%">MailKey</td>
			<td><input type="text" class="input" name="MailKey" style="width:100%"></td>
		</tr>
		<tr class="h23">
			<td width="20%">FileKey</td>
			<td><input type="text" class="input" name="FileKey" style="width:100%"></td>
		</tr>				
	</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( bottom : email ) (S) -->
<table width="100%" class="popup">
<tr><td  class="bottom">
	<table align="center"><tr><td class="bottom_img" width="460" height="16"></td></tr></table>
</td></tr>
</table>
</form>	
</body>
</html>