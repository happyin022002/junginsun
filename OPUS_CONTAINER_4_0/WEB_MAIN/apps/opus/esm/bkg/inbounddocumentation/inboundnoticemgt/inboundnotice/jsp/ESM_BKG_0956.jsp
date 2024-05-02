
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0956.jsp
	 *@FileTitle : Integrated Customer Data Management
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate :
	 *@LastModifier : 
	 *@LastVersion : 
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0956Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	EsmBkg0956Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_email = "";
	String strOfc_cd = "";

	Logger log = Logger
			.getLogger("com.clt.apps.InboundBLMgt.ArrivalNotice");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_email = account.getUsr_eml();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0956Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Arrival Info. Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var strUsr_nm    = "<%=strUsr_nm%>";
	var strUsr_email = "<%=strUsr_email%>";
	var strOfc_cd    = "<%=strOfc_cd%>";
	var strBkgNo = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>";
	
	
	function setupPage(){
		loadPage();
	}
	

</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input name="f_cmd" type="hidden" /> <input
	type="hidden" name="pagerows" value="<%=pageRows%>"> <input
	type="hidden" name="bkg_no"
	value="<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>"> 


<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="1">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp;Hold Remark Setup Popup</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> <!-- : ( Search Options ) (S) -->

		<table class="search">
			<tr>
				<td class="bg"><!--  biz_1   (E) --> <!-- : ( Grid ) (S) -->
				<table width="100%" id="mainTable" height="100">
					<tr>
						<td width="100%" height="100"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) --> <!-- : ( Button : Grid ) (E) --></td>
			</tr>
		</table>



		<table class="height_5">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) --> <!-- : ( Button : pop ) (S) -->
		<table width="500" class="sbutton">
			<tr>
				<td height="71" class="popup">

				<table width="300" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>

								<table width="72" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_save">Save</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>

								<td>
								<table width="72" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn1_left"></td>
										<td class="btn1" name="btn_close">Close</td>
										<td class="btn1_right"></td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						<!--Button (E) --></td>
					</tr>
				</table>
				<!-- : ( Button : pop ) (E) --></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>