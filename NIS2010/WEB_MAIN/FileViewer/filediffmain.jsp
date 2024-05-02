<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : filediffmain.jsp
*@FileTitle : File Verify Tool
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 송유성
*@LastVersion : 1.0
* 2009.06.02 최초생성
* 1.0 Creation
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>File Verification Tool</title>
</head>
<body>
<center><h2>File Verification Tool</h2></center>
<form name="form" action="filediffresultlist.jsp" method="post">
<input type="hidden" name="srcfilepath">
<input type="hidden" name="destfilepath">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<td colspan = "2" width="600" valign="top">
            <iframe name="flist1" src="filedifflist.jsp?frame=src" style="width:500px;height:490px;"></iframe>
    	</td>
    	<td colspan = "2" width="600" valign="top">
            <iframe name="flist2" src="filedifflist.jsp?frame=dest" style="width:500px;height:490px;"></iframe>
    	</td>
	</tr>
</table>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center"><input type="submit" value="Verify"/></td>
	</tr>	
</table>
</form>
</body>
</html>