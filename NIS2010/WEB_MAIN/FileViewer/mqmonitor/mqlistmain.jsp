<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : mqlistmain.jsp
*@FileTitle : MQ Monitor List
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
<title>MQ Status Monitor</title>
<script>

function doAction(){
	var frm = document.form;
	if ( !validate(frm) )return false;
    frm.action = "mqdetail.jsp";
    frm.target = "qlist";
    
    document.getElementsByName("qlist")[0].style.display = "inline";
    frm.submit();
}

function doEnter(){
    if(event.keyCode == 13){
        doAction();
    }
}
function validate(formObj){
	if ( formObj.mqname.value == "*" ) {
		alert("MQ Name 에 QueueName 을 정확하게 입력 하세요");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<center><h2>MQ Status Monitor</h2></center>
<form name="form" method="post" onsubmit="return false;">
<input type="hidden" name="filecontent">
<input type="hidden" name="contents">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
    	<td valign="top">
    		MQ Name : <input type=text name="mqname" maxlength="150" size="90" value="" onkeyup="doEnter();"></input>
    	</td>
    	<td>
    		TYPE : 
    		<select type=select name="cmdtype">
    			<option value="status">MQ Status</option>
    		</select>
    	</td>
    	<td>
    		<input type=button name="retrieve" value=" 조 회 " onclick="doAction();"></input>
    	</td>
	</tr>
	<tr>
    	<td colspan = "3" valign="top">
            <iframe name="qlist" style="display:none;width:100%;height:490px;overflowY:scroll;"></iframe>
    	</td>
	</tr>	
</table>
</form>
</body>
</html>