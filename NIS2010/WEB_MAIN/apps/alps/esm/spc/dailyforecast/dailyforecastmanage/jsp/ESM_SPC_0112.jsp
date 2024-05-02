<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0112.jsp
*@FileTitle : Account Mapping
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0112Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String sls_ofc_cd = JSPUtil.getParameter(request, "sls_ofc_cd", "");
	String cost_yrwk = JSPUtil.getParameter(request, "cost_yrwk", "");

	EsmSpc0112Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.Dailyforecastmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmSpc0112Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	
%>

<html>
<head>
<title>Account Mapping</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curPgmNo = "ESM_SPC_0112";
	var curTitle = "Account Mapping";
	var curDescription = "Account Mapping";

	var sls_ofc_cd = "<%=sls_ofc_cd%>";

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
<input type="hidden" name="chkCustCd" value ="" >
<input type="hidden" name="cost_yrwk" value ="<%=cost_yrwk%>" >

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
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

						<td class="btn1_line"></td>
						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_upload" id="btn_upload">Upload</td><td class="btn1_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>
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
						<td width="100"><input type="text" name="trade" dataformat="engup" size="7" maxlength="7" readonly style="ime-mode:disabled; text-align:center;"></td>
	
						<td width="60"><img class="nostar">Office</td>
						<td><input type="text"" name="ofc_cd" dataformat="engup" size="5" maxlength="5" readonly style="ime-mode:disabled; text-align:center;"></td>
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
				<table width="100%" class="button">
					<tr>
						<td>
							<table border="0" width="100%" class="button">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_rowadd" id="btng_rowadd">Row&nbsp;Add</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>
						</td>
					</tr>
				</table>

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

<SCRIPT LANGUAGE="javascript">
<!--


/**
 * ibSheet 를 제외한 폼 입력값(?) 유저가 입력한 정보를 event를 통해서 다시 넘겨받아 화면에 뿌려주는 부분입니다.
 */
with(document.form){		
	
	<% if(event != null) {%>

	trade.value     		= "<%= JSPUtil.getNull(request.getParameter("trade"))==null			?"":JSPUtil.getNull(request.getParameter("trade")) %>";
	ofc_cd.value    	= "<%= sls_ofc_cd %>";
	<%}%>
}
-->

</SCRIPT>