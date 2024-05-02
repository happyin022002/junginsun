<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName :  EES_MNR_QEXE.jsp
*@FileTitle : Query Execute
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.MnrComEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
 	MnrComEvent  event = null;				//PDTO(Data Transfer Object including Parameters)
 	Exception serverException   = null;			//Occurred error from server
 	String strErrMsg = "";	 					//Error message
 	String strUsr_id		= "";
 	String strUsr_nm		= "";

 	//Variable for existing logic
 	String returnval = ((request.getParameter("returnval")==null )?"":request.getParameter("returnval"));
	String returntitle = ((request.getParameter("returntitle")==null )?"":request.getParameter("returntitle"));

	try {
 	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
 		strUsr_id =	account.getUsr_id();
 		strUsr_nm = account.getUsr_nm();

 		event = (MnrComEvent)request.getAttribute("Event");
 		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

 		if (serverException != null) {
 			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
 		}
 	}catch(Exception e) {
 		out.println(e.toString());
 	}
 %>
<html>
<head>
<title>Query Execute</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--Use a common at MNR  -->
<script language="javascript">
	function setupPage(){
		var errMessage = '';
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<script language="javascript">ComSheetObject('sheet1');</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- Developer's task	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		    <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Query Execute</td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Run">Run</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_GetInsert">Get Insert</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_FileOpen">File Open</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_SendEDI">Send EDI</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<table class="height_8"><tr><td></td></tr></table>

		<!-- Main (S) -->
		<table class="search" id="mainTable">
		<tr>
		<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="75">Run Count</td>
				<td width="120"><input type="text" name="run_cnt" style="width:100" value="1" class="input1" dataformat="int"></td>
				<td width="">&nbsp;</td>
			</tr>
		</table>
		</tr>
       	<tr><td class="bg" width="979" valign="top">
       	<table class="search" border="0" style="width:979;">
			<tr class="h23">
			<td width="" valign="top">Query</td>
			<td><textarea name="mnr_query" wrap="on" style="width:910;background-color:beige;" rows="50">
			</textarea></td>
			</tr>
		</table>

		</td></tr>
		</table>
</td></tr></table>
<!-- Developer's task   -->
</form>
</body>
</html>