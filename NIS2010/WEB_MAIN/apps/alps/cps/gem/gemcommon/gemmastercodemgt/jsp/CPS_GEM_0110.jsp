
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : cps_gem_0110.jsp
	 *@FileTitle : Expense Matrix Copy
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.15
	 *@LastModifier : 최정미
	 *@LastVersion : 1.0
	 * 2009.05.15 최정미
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
<%@ page import="com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event.CpsGem0110Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	CpsGem0110Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBunkerRegister");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (CpsGem0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Expense Matrix Copy</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="errCode">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr>
		<td class="top"></td>
	</tr>
	<tr>
		<td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Expense Matrix Copy</td>
			</tr>
		</table>
		<!-- : ( Title ) (E) --> 
		
		<!--biz page (S)-->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg">
				<!--  biz_1  (S) -->
				<table class="search_sm2" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="80">Matrix DIV</td>
						<td class="stm">
							<input type="radio" name="matrix_div" id="matrix_div1" value="I" class="trans" onclick="isMatrixDivCheck(this);">Initial&nbsp;&nbsp;&nbsp;
							<input type="radio" name="matrix_div" id="matrix_div2" value="C" class="trans" onclick="isMatrixDivCheck(this);" checked>Copy
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>

				<table width="100%" class="grid2">
					<tr class="tr2_head">
						<td width="50%">From Office</td>
						<td>To Office</td>
					</tr>
					<tr align="center">
						<td><input type="text" id="from_ofc_cd" name="from_ofc_cd" class="input" maxlength="6" onchange="isErrorCodeChk('1');" style="width: 70; text-align:center; ime-mode:disabled"> </td>
						<td><input type="text" id="to_ofc_cd" name="to_ofc_cd" class="input" maxlength="6" onchange="isErrorCodeChk('2');" style="width: 70; text-align:center; ime-mode:disabled"> </td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--biz page (E)-->

<table width="100%">
	<tr>
		<td height="10"><script language="javascript">ComSheetObject('sheet1');</script></td>
	</tr>
</table>
		</td>
	</tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn3_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Confirm">Confirm</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Reset">Reset</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
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
		<!-- : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>

</form>
</body>
</html>