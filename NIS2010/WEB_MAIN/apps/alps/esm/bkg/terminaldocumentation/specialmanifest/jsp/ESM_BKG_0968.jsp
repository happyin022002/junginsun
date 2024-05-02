<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0968.jsp
*@FileTitle :  DG Declare Main Menu (EU)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.31
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.07.31 경종윤
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.SpecialManifest");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

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
<title>DG Declare Main Menu (EU)</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofcCd" value="<%=strOfc_cd%>">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr>
		<td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">

			
			<%
				if(!strOfc_cd.startsWith("ANR")) {
			%>
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Dangerous Cargo Declaration EDI Transmit</td></tr>
				</table>

				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_1" style="text-align:left;">
						<span id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')">1. Import Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_2" style="text-align:left;">
						<span id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')">2. Transit Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_3" style="text-align:left;">
						<span id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')">3. Export Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Message Status</td></tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_2_1" style="text-align:left;">
						<span id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')">1. Transmit (Sending Results)</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
			
			
			
			<%
				} else {
			%>
			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Dangerous Cargo Declaration EDI Transmit</td></tr>
				</table>

				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_1" style="text-align:left;">
						<span id="btn_1_1" onmouseover="obj_MouseOver('btn_1_1')" onmouseout="obj_MouseOut('btn_1_1')">1. Discharging Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_2" style="text-align:left;">
						<span id="btn_1_2" onmouseover="obj_MouseOver('btn_1_2')" onmouseout="obj_MouseOut('btn_1_2')">2. Transit Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_3" style="text-align:left;">
						<span id="btn_1_3" onmouseover="obj_MouseOver('btn_1_3')" onmouseout="obj_MouseOut('btn_1_3')">3. Loading Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_4" style="text-align:left;">
						<span id="btn_1_4" onmouseover="obj_MouseOver('btn_1_4')" onmouseout="obj_MouseOut('btn_1_4')">4. Pre-carriage Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_1_5" style="text-align:left;">
						<span id="btn_1_5" onmouseover="obj_MouseOver('btn_1_5')" onmouseout="obj_MouseOut('btn_1_5')">5. On-carriage Declaration</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Message Status</td></tr>
				</table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_2_1" style="text-align:left;">
						<span id="btn_2_1" onmouseover="obj_MouseOver('btn_2_1')" onmouseout="obj_MouseOut('btn_2_1')">1. Transmit (Sending Results)</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>
				
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Setup</td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_3_1" style="text-align:left;">
						<span id="btn_3_1" onmouseover="obj_MouseOver('btn_3_1')" onmouseout="obj_MouseOut('btn_3_1')">2. Forwarder Code Setup (Antwerp)</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_3_2" style="text-align:left;">
						<span id="btn_3_2" onmouseover="obj_MouseOver('btn_3_2')" onmouseout="obj_MouseOut('btn_3_2')">3. Special UN Numbers Setup (Antwerp)</span></td>
					<td class="btn2_right"></td>
					</tr>
					</table></td></tr>
				</table>
			
			
			
			
			<%
				}
			%>
			
				
				
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_10"><tr><td></td></tr></table>
<table class="height_10"><tr><td></td></tr></table>
<table class="height_10"><tr><td></td></tr></table>

</body>
</html>
