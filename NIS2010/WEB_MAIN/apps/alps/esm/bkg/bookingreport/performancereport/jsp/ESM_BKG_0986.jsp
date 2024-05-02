<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0986.jsp
	 *@FileTitle :  Automatic Termination Notice
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 
	 *@LastModifier : 
	 *@LastVersion : 1.0
	 * 2013.03.29
	 * 1.0 Creation
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

	} catch (Exception e) {
		out.println(e.toString());
	}
%>	
<html>
<head>
<title> Automatic Termination Notice </title>
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

<body class="popup_bg" onLoad="setupPage();window.self.focus();"> 
<div id="debug"></div>
<form name="form">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
<!-- OUTER - POPUP (S)tart -->	
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
			<table width="100%" border="0">
				<tr>
					<td class="title"><img src="./img/icon_title_dot.gif"
						align="absmiddle">&nbsp;Automatic Termination Notice</td>
					</tr>
			</table>
			<table class="search"> 
	       		<tr><td class="bg">
	       		<br>Your screen of queue detail will be shut off automatically 5 minutes after this popup shows.
	       		<br><br>
				</td></tr>
			</table>
			<table class="height_5"><tr><td></td></tr></table>
		</td>
	</tr>
</table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" >
				<tr>
					<td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0"class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Proceed">Proceed</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					<!--Button (E) -->
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>					
		<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>