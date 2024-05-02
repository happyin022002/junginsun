<%--
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_PRI_7027.jsp
 *@FileTitle : Country
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/ 
--%>

<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.country.event.EsmPri7027Event"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	EsmPri7027Event  event = null;				
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String main_page = "";
	try {
		event = (EsmPri7027Event)request.getAttribute("Event");
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
<title>Country</title>
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

<!-- OUTER - POPUP (S)tart -->
<body class="popup_bg" onload="javascript:setupPage();">
<form name="form">
<input	type="hidden" name="f_cmd"> 

<input type="hidden" name="func" value="SCONTI"> 
<input type="hidden" name="targetCombo" value="sconti_cd"> 
 
<table width="100%" class="popup" cellpadding="10"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="540" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Country Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search" border="0"> 
			<tr>
				<td class="bg">
				<!-- : ( Scenario ID ) (S) -->
				<table class="search" style="width:100%;"> 
					<tr class="h23">
						<td width="100">Country Code</td>
						<td width="150"><input type="text" name="cnt_cd" style="width:35;ime-mode:disabled" maxlength="2" value='' onKeyPress="ComKeyOnlyAlphabet('upper')"></td>
						<td width="60">Name</td>
						<td width="100"><input type="text" name="cnt_nm" style="width:115;ime-mode:disabled" value='' onKeyPress="ComKeyOnlyAlphabet('upper')"></td>
						<td>&nbsp;</td>
					</tr> 
				</table>
				<!-- : ( Scenario ID ) (E) -->
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('sheet');</script>
                       </td></tr>
	            </table>
				</td>
			</tr>
		</table> 
		<!-- OUTER - POPUP (E)nd -->
		<table class="height_5"><tr><td></td></tr></table> 
		</td>
	</tr>
</table> 
<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_New">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_OK">OK</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
					
					<td class="btn1_line"></td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
			</tr>
		</table>
	</td></tr>
</table>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
 <iframe name="iframe_bizcom" style="display:none">