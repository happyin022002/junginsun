<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : filelistmain.jsp
*@FileTitle : File Viewer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.15
*@LastModifier : 송유성
*@LastVersion : 1.0
* 2009.05.15 최초생성
* 1.0 Creation
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>File Viewer</title>
<script>

function doAction(){
	var frm = document.form;
    frm.action = "filelistview.jsp";
    frm.target = "flist";
    document.getElementsByName("flist")[0].style.display = "inline";
    frm.submit();
}

function doEnter(){
    if(event.keyCode == 13){
        doAction();
    }
}

</script>
</head>
<body>
<center><h2>File Viewer</h2></center>
<form name="form" action="filelist.jsp" method="post" onsubmit="return false;">
<input type="hidden" name="filecontent">
<input type="hidden" name="contents">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<td valign="top">
    		디렉토리 : <input type=text name="filepath" maxlength="150" size="90" value="/sitelog/WEBLOG/ALPS" onkeyup="doEnter();"></input>
    	</td>
    	<td>
    		조회규칙 :  <input type="text" name="reg_name" size="20"></input>
    	</td>
    	<td>
    		<input type=button name="retrieve" value=" 조 회 " onclick="doAction();"></input>
    	</td>
	</tr>
	<tr>
    	<td colspan = "3" valign="top">
            <iframe name="flist" style="display:none;width:100%;height:490px;overflowY:scroll;"></iframe>
    	</td>
	</tr>	
</table>
</form>
</body>
</html>