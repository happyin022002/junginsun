<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0746.jsp
*@FileTitle : Vessel Utilization Status vs. BSA by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.26
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.10.26 강동윤
* 1.0 Creation
*--------------------------------------------------------
* History
* 2010.09.01 김경섭 [000 ] [ESM-BKG] Vessel Utilization Status vs BSA by Lane 집계 쿼리 수정 및 RAW DATA SHEET 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0746Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0746Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0746Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Vessel Utilization Status vs. BSA by Lane</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<input type="hidden" name="cost_yrmon">
<input type="hidden" name="vvds">

<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="40">Trade</td>
						<td width="90" style="padding-left:2"><script language="javascript">ComComboObject('trd_cd', 1, 60, 1);</script>
						<!--select style="width:60;" class="input1">
						<option value="0" selected>All</option>
						<option value="1"></option>
						</select--></td>
						<td width="65">Sub Trade</td>
						<td width="110" style="padding-left:2"><script language="javascript">ComComboObject('sub_trd_cd', 1, 60, 1);</script>
						<!--select style="width:80;" class="input1">
						<option value="0" selected>All</option>
						<option value="1"></option>
						</select--></td>
						<td width="45">Bound</td>
						<td width="80"><script language="javascript">ComComboObject('vsl_slan_dir_cd', 1, 60, 1);</script>
						<!--select style="width:60;" class="input">
						<option value="0" selected>All</option>
						<option value="1"></option>
						</select--></td>
						<td rowspan="2">
							<table class="search_sm" border="0" style="width:400;"> 
								<tr class="h23">
									<td width="130"><input type="radio" name="dt_tp" value="0" class="trans" checked>Port ETD</td>
									<td width=""><input type="text" style="width:75;" value="" class="input1" dataformat="ymd" name="etd_from_dt" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onClick="javascript:choiceDt('ymd');">&nbsp;~&nbsp;<input type="text" style="width:75;" value="" class="input1" dataformat="ymd" name="etd_to_dt" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" onClick="javascript:choiceDt('ymd');">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar" onClick="javascript:choiceDt('ymd');"></td>
								</tr>
								<tr class="h23">
									<td width=""><input type="radio" name="dt_tp" value="1" class="trans">Performance Year	</td>
									<td width="" class="stm"><input type="text" style="width:40;" value="" class="input1" name="cost_year" dataformat="int" maxlength="4" size="4" onClick="javascript:choiceDt('week');">&nbsp;&nbsp;&nbsp;Month&nbsp;<input type="text" style="width:26;" value="" class="input1" name="cost_morth" dataformat="int" maxlength="2" size="2" onClick="javascript:choiceDt('week');">&nbsp;&nbsp;&nbsp;Week&nbsp;<input type="text" style="width:26;" value="" class="input" name="cost_wk" dataformat="int" maxlength="2" size="2" onClick="javascript:choiceDt('week');"></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr class="h23">
						<td width="40">Lane</td>
						<td width="80"><input type="text" style="width:60;" value="" class="input1" name="slan_cd" dataformat="engupnum" maxlength="3"></td>
						<td width="65">VVD</td>
						<td width="80"><input type="text" style="width:80;" value="" class="input" name="vvd" dataformat="engupnum" maxlength="9"></td>
						
					</tr>
				</table>
				<!--  biz_1   (E) -->		
					
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<table class="search" id="mainTable"> 
   		<tr><td class="bg">	
			
			
			<!-- Grid_1 (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid_1 (E) -->		
			<!-- Grid_2 (S) -->
			<div id="downSheet" style="display:none">
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			</div>
			<!-- Grid_2 (E) -->		
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Rawdata">Down Raw Data</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print" id="btn_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	
	
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
