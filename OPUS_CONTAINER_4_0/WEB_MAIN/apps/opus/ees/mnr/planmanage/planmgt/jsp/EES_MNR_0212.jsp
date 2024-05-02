
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ui_mnr_0212.jsp
	 *@FileTitle : Expense Plan Creation by HO
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
<%@ page import="com.clt.apps.opus.ees.mnr.planmanage.planmgt.event.EesMnr0216Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	EesMnr0216Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //Error message
	int rowCount = 0; //count of DB resultSet list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.PlanManage.PlanMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesMnr0216Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from sever when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}

	String ofc_cd = StringUtil.xssFilter(request.getParameter("po"));
	if (ofc_cd == null)
		ofc_cd = "";
%>
<html>
<head>
<title>M&R Regional Office Code Inquiry</title>
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

<body class="popup_bg" onLoad="setupPage()">
<form name="form"><input type="hidden" name="f_cmd"> <input
	type="hidden" name="pagerows"> <input type="hidden"
	name="retfld"> <!-- Developer's task	--> <!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"> M&R Regional Office Code Inquiry</td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg">

				<table class="search" border="0" style="width: 479;">
					<tr class="h23">
						<td width="79">Regional HQ</td>
						<td width=""><input type="text" style="width: 70;"
							class="input2" name="ofc_cd" value="<%=ofc_cd%>" readonly></td>
					</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) --></td>
			</tr>
		</table>

<table class="height_5"><tr><td></td></tr></table>

		</td>
	</tr>
</table>
<!-- : ( Search Options ) (E) -->


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>



						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						<td class="btn1_line">
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_CLOSE">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
						</td>
						</td>
					</tr>
				</table></td>
					</tr>
				</table>
				<!--Button (E) --></td>
			</tr>
		</table>
		<!-- : ( Button : pop ) (E) --> <!-- Developer's task	-->
		</form>
</body>
</html>
<%@include file="/bizcommon/include/common_opus.jsp"%>