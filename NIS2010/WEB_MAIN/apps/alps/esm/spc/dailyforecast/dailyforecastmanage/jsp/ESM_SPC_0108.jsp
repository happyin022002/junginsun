<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0108.jsp
*@FileTitle : Accumulated Guide&PFMC
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2014.03.12 [선처리] SMP/Allocation control보완 요청 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0108Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String year        = JSPUtil.getParameter(request, "year", "");
	String week        = JSPUtil.getParameter(request, "week", "");
	String trade       = JSPUtil.getParameter(request, "trade", "");
	String salesOffice = JSPUtil.getParameter(request, "salesOffice", "");
	String rhqCd       = JSPUtil.getParameter(request, "rhqCd", "");

	EsmSpc0108Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmSpc0108Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	
%>

<html>
<head>
<title>Accumulated Guide&PFMC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curPgmNo = "ESM_SPC_0108";
	var curTitle = "Accumulated Guide&PFMC";
	var curDescription = "Accumulated Guide & PFMC";

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
<input type="hidden" name="year" value ="<%=year %>" >
<input type="hidden" name="week" value ="<%=week %>" >
<input type="hidden" name="trade" value ="<%=trade %>" >
<input type="hidden" name="ofc_cd" value ="<%=salesOffice %>" >
<input type="hidden" name="rhq" value ="<%=rhqCd %>" >
<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="790" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
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
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr>
							</table></td>
						
						<td class="btn1_line"></td>
						
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
						<td width="60"><img class="nostar">Period : </td>
						<!-- <td width="60"><input type="text" class="input1" name="year1" maxlength="4" size=5 style="ime-mode:disabled; text-align:center;"></td>
						<td width="60"><input type="text" class="input1" name="week1" maxlength="2" size=2 style="ime-mode:disabled; text-align:center;">&nbsp; ~ </td>
						
						<td width="60"><input type="text" class="input1" name="year2" maxlength="4" size=5 style="ime-mode:disabled; text-align:center;" value ="<%=year %>"></td>
						<td width="170"><input type="text" class="input1" name="week2" maxlength="2" size=2 style="ime-mode:disabled; text-align:center;" value ="<%=week %>"></td>
						 -->
						<td width="350">
						<select class="input1" name="year1" style="width:60;"></select>
						<select class="input1" name="week1" style="width:40;"></select>
						~
						<select class="input1" name="year2" style="width:60;"></select>
						<select class="input1" name="week2" style="width:40;"></select>
						</td>
						
						<td width=110><img class="nostar">Season Period : </td>
						<td width="150"><input type="text" class="input2" name="sdate" readonly style="width:60;ime-mode:disabled; text-align:center;"> ~ 
						                <input type="text" class="input2" name="edate" readonly style="width:60;ime-mode:disabled; text-align:center;"></td>
						
						
						<td width="100">
							<input type="checkbox" value="" class="trans" name="chkExpand" id="chkExpand" onclick="return changechkExpand();"><label for="chkExpand">Expand All</label>&nbsp;&nbsp;&nbsp;
						</td>
						<td width="*">&nbsp;</td>
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