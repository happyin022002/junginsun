<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : ESM_SPC_0092.jsp
*@FileTitle      : Amend
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.03.06
*@LastModifier   : 
*@LastVersion    : 1.0
* 1.0 Creation
*
* History
* 2014.03.06 [CHM-20142960] SMP/Allocation control보완 요청 - Amend 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0092Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	EsmSpc0092Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String trade   = null;
	String season  = null;
	String version = null;
	
	Logger log = Logger.getLogger("com.hanjin.apps.modelmanage.modelmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		trade   = JSPUtil.getParameter(request, "trade", "");
		season  = JSPUtil.getParameter(request, "season", "");
		version = JSPUtil.getParameter(request, "version", "");
		
		event = (EsmSpc0092Event)request.getAttribute("Event");
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
<title>Amend</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curPgmNo = "ESM_SPC_0112";
	var curTitle = "Amend";
	var curDescription = "Amend";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
     	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr><td class="btn1_bg">

					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
						
						<td class="btn1_line"></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr></table>

			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" id="searchCondition">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search" border="0">
				<tr>
					<td>
					<table class="search" border="0">
					<tr class="h23">
						<td width="60"><img class="nostar">Trade</td>
						<td width="100"><input type="text" name="trade" dataformat="engup" size="7" maxlength="7" value="<%=trade%>" readonly style="ime-mode:disabled; text-align:center;"></td>
	
						<td width="60"><img class="nostar">Season</td>
						<td width="100"><input type="text"" name="cost_yrwk" dataformat="engup" size="7" maxlength="7" value="<%=season%>" readonly style="ime-mode:disabled; text-align:center;"></td>
						
						<td width="60"><img class="nostar">Version</td>
						<td><input type="text"" name="ver_seq" dataformat="engup" size="3" maxlength="2" value="<%=version%>" readonly style="ime-mode:disabled; text-align:center;"></td>
					</tr>
					</table>
					</td>

				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<table class="height_10"><tr><td></td></tr></table>

		<!-- UI_ESM_SPC_112 : THIS IS 1st TAB -->
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
       	<tr><td class="bg">
				<!-- : ( POR ) (S) -->

				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('sheet1');</script>
                       </td></tr>
	            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>

</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>