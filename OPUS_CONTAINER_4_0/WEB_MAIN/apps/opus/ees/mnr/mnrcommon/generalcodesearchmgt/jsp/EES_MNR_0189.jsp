<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_mnr_0189.jsp
*@FileTitle : M&R Service Provider Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.event.EesMnr0189Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0189Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		       = "";
	String strUsr_nm		   = "";
	String rhqOfcCd            = "";
	String currOfcCd           = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id    =	account.getUsr_id();
		strUsr_nm    = account.getUsr_nm();
		rhqOfcCd     = account.getRhq_ofc_cd();
		currOfcCd    = account.getOfc_cd();
		currOfcEngNm = account.getOfc_eng_nm();

		event = (EesMnr0189Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}


%>
<html>
<head>
<title>M&R Service Provider Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var currOfcCd = '<%=currOfcCd %>';
    var rhqOfcCd  = '<%=rhqOfcCd %>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";

		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="retfld">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   M&R Service Provider Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:680;">
					<tr class="h23">
						<td width="135">Cost Control Office</td>
						<td width=""><input type="text" style="width:55;" value="<%=currOfcCd %>" class="input2"  name="costcontrolofc" readonly></td>
					</tr>
				</table>

				<!--  biz_1   (E) -->


				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
			</td></tr>
			</table>


<table class="height_5"><tr><td></td></tr></table>

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>

				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				//-->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_OK">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
</td></tr>
</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- Developer's task   -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp" %>