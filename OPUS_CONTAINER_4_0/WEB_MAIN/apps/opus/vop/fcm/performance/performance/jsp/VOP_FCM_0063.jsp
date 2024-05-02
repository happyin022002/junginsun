<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0063.jsp
*@FileTitle : Fuel Consumption Master Table Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : 이병훈
*@LastVersion : 1.0
* 2015.01.23 이병훈
* 1.0 Creation
*
* History
* 2015.01.23 이병훈 [CHM-201430612] Fuel Consumption Master table 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.fcm.performance.performance.event.VopFcm0063Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0063Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	try {
		event = (VopFcm0063Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Fuel Consumption Master Table Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">

<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 업무용 hidden -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!-- 메인 화면 바깥쪽 화면 상단 버튼 부 -->
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
      	<tr><td class="btn1_bg">
	    <table border="0" cellpadding="0" cellspacing="0">
	    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_New">New</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Down_Excel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr>
			</table></td>
		</tr>
		</table>
	</td></tr>
	</table>
    <!--Button (E) -->
	
	<!-- 메인 화면 : biz page (S)-->
	<table class="search">
      	<tr><td class="bg">
      	
      		<!-- 메인 조건부 : biz_1  (S) -->
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="80">Rev. Month</td>
				<td width="250">
					<input type="text" style="width:75;text-align:center;" class="input1" name="fm_yrmon" maxlength="6" dataformat="ym" caption="Target Month">
					<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					~
					<input type="text" style="width:75;text-align:center;" class="input1" name="to_yrmon" maxlength="6" dataformat="ym" caption="Target Month">
					<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
				</td>
				<td width="40">Lane</td>
				<td width="120">
					<input type="text" style="width:80;ime-mode:disabled" name="vsl_slan_cd" maxlength="3" dataformat="uppernum">
					<img src="img/btns_search.gif" name="btn_lane_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
				</td>
				<td width="50">Vessel</td>
				<td>
					<input type="text" style="width:60;ime-mode:disabled" name="vsl_cd" maxlength="4" dataformat="uppernum">
					<img src="img/btns_search.gif" name="btn_vessel_search"  class="cursor" width="19" height="20" alt="" border="0" align="absmiddle">
				</td>
			</tr>
			</table>
			<!--  biz_1   (E) -->
			
		</td></tr>
	</table>
	
	<table class="height_8"><tr><td colspan="8"></td></tr></table>

	<table class="search">
      	<tr><td class="bg">
			<table class="search" border="0" style="width:100%;">
				<tr class="h23"><td>
				    SKED<input name="chk_sked" type="checkbox" value="1" class="trans">&nbsp;
					P/F SKED<input name="chk_pf" type="checkbox" value="1" class="trans">&nbsp;
					Total Summary - Departure report<input name="chk_total" type="checkbox" value="1" class="trans">&nbsp;
					EEOI<input name="chk_eeoi" type="checkbox" value="1" class="trans">&nbsp;
				</td></tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
		</td></tr>
	</table>
	<!--biz page (E)-->
	
</td></tr>
</table>
    
</form>
</body>
</html>