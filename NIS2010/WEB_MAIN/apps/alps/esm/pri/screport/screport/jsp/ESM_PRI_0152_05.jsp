<%/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ESM_PRI_0152_05.jsp
*@FileTitle : Korea MOF Filing (Base Table) - Surcharge Type
*Open Issues :
*Change history :
*@LastModifyDate : 2016.09.07
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@page import="com.hanjin.apps.alps.esm.pri.screport.screport.event.EsmPri0152Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0152Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SCReport.SCReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (EsmPri0152Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			log.debug(serverException);
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Scope & Location</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="mapg_tp_cd" value="SCG">

<!--TAB Arbitrary (S) -->
<table class="search">
    <tr><td class="bg">
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
      	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
			</tr>
			</table>
		</td></tr>
	</table>
	<!--Button (E) -->
	<table class="height_2"><tr><td></td></tr></table>
    
	<!-- TABLE '#D' : ( Search Options ) (S) -->
	<table class="search" border="0">
		<tr>
			<td class="bg">
				<!-- : ( SHEET ) (S) -->
				<table width="100%" id="mainTable" border="0">
					<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
				<!-- : ( SHEET ) (E) -->
			</td>
		</tr>
	</table>
	<!-- TABLE '#D' : ( Search Options ) (E) -->
    

	<table width="100%" class="button" border="0">
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_add">Row&nbsp;Add</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_del">Delete</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr>
			</table>
		</td></tr>
	</table>
    
    
	</td></tr>
</table>
<!--TAB Arbitrary (E) -->
<!-- 개발자 작업  끝 -->
</td>
</tr>
</table>
</form>
</body>
</html>