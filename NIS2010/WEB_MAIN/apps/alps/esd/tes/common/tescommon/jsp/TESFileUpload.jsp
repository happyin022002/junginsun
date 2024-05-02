<%
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%
	String	tml_so_ofc_cty_cd	= request.getParameter("tml_so_ofc_cty_cd")!=null&&!request.getParameter("tml_so_ofc_cty_cd").equals("")?request.getParameter("tml_so_ofc_cty_cd"):"";
	String	tml_so_seq			= request.getParameter("tml_so_seq")!=null&&!request.getParameter("tml_so_seq").equals("")?request.getParameter("tml_so_seq"):"";

	TESCommonEvent event = null;
	Exception serverException = null;
	String strErrMsg = "";
	String strSuccessFlag = null;

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			
			event = (TESCommonEvent)request.getAttribute("Event");
			GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
			if (eventResponse != null) {
				strSuccessFlag = eventResponse.getETCData("successFlag");
			}
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<HTML>
<head>
<title>Welcome to ALPS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	var strSuccessFlag = '';
    function setupPage(){
		var errMessage = "<%=JSPUtil.getNull(strErrMsg)%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		strSuccessFlag = "<%=JSPUtil.getNull(strSuccessFlag)%>";
		loadPage();
	}
</script>
</head>
<BODY onload="setupPage();">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
			<table width="100%" border="0">
			<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;File Attach</td></tr>
			</table>
		<!-- : ( Title ) (E) -->

<table width="100%" class="sbutton" border="0" cellpadding="10" style="padding-left:5">
	<tr>
		<td height="71" class="popup" style='padding:20px;'>
			<form name="fileUploadForm" method="post" enctype="multipart/form-data">
				<input type='hidden' name='f_cmd'>
				<input type="hidden" name="tml_so_ofc_cty_cd" value="<%=tml_so_ofc_cty_cd%>">
				<input type="hidden" name="tml_so_seq" value="<%=tml_so_seq%>">
				<input type="file" name="uploadfile">
			</form>
			<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="sbutton">
					<tr><td height="71" class="popup">

						<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				       		<tr><td class="btn3_bg">
						    <table border="0" cellpadding="0" cellspacing="0">
						    <tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Ok</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>

					</td></tr>
				</table>
			<!-- : ( Button : Sub ) (E) -->
			<iframe name="ifr_file" src="" width="0" height="0" marginwidth="0" marginheight="0" frameborder="0"></iframe>
		</td>
	</tr>
</table>
</BODY>
</HTML>
