
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : smssend.jsp
	 *@FileTitle : smssend
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2011.10.26 
	 *@LastModifier : 
	 *@LastVersion : 1.0
	 * 2011.10.26 
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.hanjin.syscommon.common.sms.SmsUtil"%>
<%@ page import="com.hanjin.syscommon.common.table.TblSubmitQueueVO"%>

<%
	Exception serverException = null;
	String strErrMsg = ""; 
	int rowCount = 0; 

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String id = "";
	String strUsr_id = "";
	String strUsr_nm = "";

	if(request.getParameter("RcvPhnId")!= null)
			{
		System.out.println(request.getParameter("setSndMsg"));

		TblSubmitQueueVO tblSubmitQueueVO = new TblSubmitQueueVO();
		tblSubmitQueueVO.setSndMsg(request.getParameter("SndMsg"));
		tblSubmitQueueVO.setRcvPhnId(request.getParameter("RcvPhnId"));
		id = SmsUtil.send(tblSubmitQueueVO);
	
			}

%>
<%=id %>
<html>
<head>
<title>FTP_SEND</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
input {width =200
	
}
</style>
</head>
<body onLoad="setupPage();">
<form name="form"><!-- 개발자 작업	-->
<h1>sms Sender</h1>
<table border=2>
	<tr>
		<td>전송번호</td>
		<td><input type="text" name="RcvPhnId" value=""></td>
	</tr>
	<tr>
		<td>전송 내용</td>
		<td><input type="text" name="SndMsg" value=""></td>
	</tr>
	<tr>
		<td colspan=2><input type="button" value="send" onclick="form.submit()"></td>
	</tr>
</table>
<!-- 개발자 작업  끝 --></form>
</body>
</html>