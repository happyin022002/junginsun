<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0021_01.jsp
*@FileTitle : Off-Hire CNTR List - Send to E-mail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.05 장준우
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.component.util.io.FileUtils"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strContent 		= null;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesLse0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		String template = JSPUtil.getParameter(request,"template");
		String argument = JSPUtil.getParameter(request,"argument");
		strContent = EesLse0021Event.getTemplateContent(template, argument);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<html>
<head>
<title>Off-Hire CNTR List - Send to E-mail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript" src="/hanjin/syscommon/common/fckeditor/ckeditor.js"></script>
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

<body class="popup_bg" onload="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="siteConfig" value="<%= SiteConfigFactory.get("COM.MAIL.SAVE.DIRECTORY") %>">
<input type="hidden" name="blindCarbonCopy" value="<%=JSPUtil.getParameter(request,"blindCarbonCopy")%>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Off-Hire CNTR List - Send to E-mail</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!-- Grid  (S) -->
				<table id="tabLayer" width="100%" class="grid2">
					<tr>
						<td class="tr2_head" width="12%">From</td>
						<td colspan="2"><input type="text" name="from" caption="From" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
							value="<%=JSPUtil.getParameter(request,"from")%>" required></td>
					</tr>
					<tr>
						<td class="tr2_head">TO</td>
						<td colspan="2"><input type="text" name="recipient" caption="Recipient" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
							value="<%=JSPUtil.getParameter(request,"recipient")%>" required></td>
					</tr>
					<tr>
						<td class="tr2_head">CC</td>
						<td colspan="2"><input type="text" name="carbonCopy" caption="Carbon Copy" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
							value="<%=JSPUtil.getParameter(request,"carbonCopy")%>"></td>
					</tr>
					<!--
					<tr>
						<td class="tr2_head">BCC</td>
						<td colspan="2"><input type="hidden" name="h_blindCarbonCopy" caption="Blind Carbon Copy" style="width: 100%; text-align: left;ime-mode:disabled;" class="noinput"
							value="<%=JSPUtil.getParameter(request,"blindCarbonCopy")%>"></td>
					</tr>
					-->
					<tr>
						<td class="tr2_head" width="12%">Subject</td>
						<td colspan="2"><input type="text" name="subject" caption="Subject" style="width: 100%; text-align: left" class="noinput"
							value="<%=JSPUtil.getParameter(request,"subject")%>" required></td>
					</tr>
					<tr>
						<td class="tr2_head" width="12%">Attach</td>
						<td width="4%"><input type="button" value="Attach" name="btn_attach"></td>
						<td><input type="text" name="fileKey" caption="Attach" style="width: 100%; text-align: left;" class="noinput" value="<%=JSPUtil.getParameter(request,"fileKey")%>" readonly></td>
					</tr>
				</table>
				<textarea class="ckeditor" name="content" id="com_content" caption="Contents" required><%=strContent == null ? "" : strContent%></textarea> <!-- Grid  (E) --></td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->
		<table class="height_5"><tr><td></td></tr></table>

		</td>
	</tr>
</table>


<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="80" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_send">Send</td>
						<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_close">Close</td>
				<td class="btn1_right"></td>
			</tr></table></td>
			</tr><tr><td>
				<script language="javascript">ComSheetObject('sheet1');</script>
			</td></tr>
		</table></td>
			</tr>
		</table>
	</td></tr>
</table>
	<!--Button (E) -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>