<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_EAS_COM_0001.jsp
*@FileTitle : Common Popup
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001Event"%>
<%
	SignOnUserAccount account = null; 
	EsdEasCom0001Event  event = null;			
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;							
	String strErrMsg = "";								
	int rowCount	 = 0;								
	String sofccd = request.getParameter("ctrl_ofc_cd") == null ? "" : request.getParameter("ctrl_ofc_cd");
	String selfccd = request.getParameter("sel_ofc_cd") == null ? "" : request.getParameter("sel_ofc_cd");

	try {
		account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdEasCom0001Event)request.getAttribute("Event");
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
<title>TRO Office Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		// InitTab();
		loadPage();
	}

</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="ctrl_ofc_cd" value="<%=sofccd%>">
<input type="hidden" name="sel_ofc_cd" value="<%=selfccd%>">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/opuscntr/img/icon_title_dot.gif" align="absmiddle">&nbsp;TRO Office Select</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Node / Link ) (S) -->
                    <table width="380" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>
				<!-- : ( Node / Link ) (E) -->

			</td></tr>
		</table>
		<!-- : ( Search Options ) (E) -->



</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_10"><tr><td></td></tr></table>
<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>