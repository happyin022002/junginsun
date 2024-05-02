<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : vop_opf_2052.jsp
*@FileTitle : Supporting Upload
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 

=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.event.VopOpf2052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopOpf2052Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.StevedoreDamageMgt.StevedoreDamageMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopOpf2052Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Supporting Upload</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- Developer Performance	-->

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Mail Information</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="65">&nbsp;&nbsp;Subject</td>
					<td><input type="text" name="title" style="width:595;" class="input" value=" Re : SDMS Application -"></td></tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="65">&nbsp;&nbsp;From</td>
					<td><input type="text" name="sender_usr_eml" style="width:595;" class="input"></td></tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="65">&nbsp;&nbsp;To</td>
					<td><input type="text" name="receiver_eml" style="width:595;" class="input"></td></tr>
				</table>
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="508">&nbsp;&nbsp;Message</td></tr>
				<tr class="h23">
					<td colspan="2"><textarea name="content" style="width:660; height:260;">[Concerned Office]
- OfficeCode : MailId@XXXXX.com

</textarea></td></tr>
				</table>				
				<!--  biz_2   (E) -->
				
				
		</td></tr></table>
		<!--biz page (E)--> 

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Send</td>
					<td class="btn1_right">
				</tr></table></td>	
			<td class="btn1_line"></td>		
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
			</table>
			</td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<div style="display:none">
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>

<!-- Developer Performance  end -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp"%>