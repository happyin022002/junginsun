<%
/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : VOP_FCM_0002.jsp
*@FileTitle : Departure Report Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.31
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.vesselreport.vesselreport.event.VopFcm0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	try {
		event = (VopFcm0002Event)request.getAttribute("Event");
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
<title>Departure Report Inquiry</title>
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
	
	<!-- 메인 화면 : biz page (S)-->
	<table class="search">
      	<tr><td class="bg">
      	
      		<!-- 메인 조건부 : biz_1  (S) -->
			<!--  biz_1  (S) -->
			<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">Period</td>
					<td width="230">
						<input type="text" name="fm_dt" style="width:80;" class="input1" dataformat="ymd" size="10" maxlength="8">
						<img class="cursor" name="btns_calendarfm" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
						~
						<input type="text" name="to_dt" style="width:80;" class="input1" dataformat="ymd" size="10" maxlength="8">
						<img class="cursor" name="btns_calendarto" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="35">Lane</td>
					<td width="80">
						<script language="javascript">ComComboObject('vsl_slan_cd',1,70,0,0);</script>
					</td>
					<td width="40">Vessel</td>
					<td width="100" class="stm"><script language="javascript">ComComboObject('vsl_cd',1,80,0,0);</script></td>
					<td width="65">LAST Port</td>
					<td width="90">
						<input type="text" name="last_port" style="width:50;text-align:center;ime-mode:disabled;" maxlength="5" dataformat="uppernum">
						<img class="cursor" name="btn_last_port" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="60">DEP Port</td>
					<td width="90">
						<input type="text" name="dep_port" style="width:50;text-align:center;ime-mode:disabled;" maxlength="5" dataformat="uppernum">
						<img class="cursor" name="btn_dep_port" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="60">Direction</td>  
					<td width="50"><script language="javascript">ComComboObject('skd_dir_cd',1,50,0,0);</script></td>
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
				    PERFORMACE<input name="chk_perfo" type="checkbox" class="trans" checked>&nbsp;
					FUEL CONSUM<input name="chk_fuel" type="checkbox" class="trans" checked>&nbsp;
					R.O.B<input name="chk_rob" type="checkbox" class="trans" checked>&nbsp;
					DESTINATION<input name="chk_dest" type="checkbox" class="trans" checked>&nbsp;
					TIME<input name="chk_time" type="checkbox" class="trans" checked>&nbsp;
					CONDITION & CARGO<input name="chk_condi" type="checkbox" class="trans" checked>&nbsp;
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
	
	<!--Button (S) -->
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		<tr><td class="btn1_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_save">Save</td>
				<td class="btn1_right"></td>
				</tr>
				</table>
			</td>
			</tr></table>
		</td></tr>
	</table>
	<!--Button (E) -->
	
</td></tr>
</table>
    
</form>
</body>
</html>