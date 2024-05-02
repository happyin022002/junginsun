<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0012.jsp
*@FileTitle : Fuel Consumption Trend line M_Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
*
* History
* 2012.03.08 진마리아 [선처리] Displacement 컬럼 추가
* 2012.04.04 진마리아 CHM-201216636-01 [FCM] ALPS 모델 및 DB 구조 불일치 복구
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.trendline.trendline.event.VopFcm0012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0012Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	String fm_date = DateTime.addDays(DateTime.getDateString(),-7,"yyyy.MM.dd");
	String chk_date = DateTime.addDays(DateTime.getDateString(),-90,"yyyy.MM.dd");
	fm_date = fm_date.replace(".","-");
	chk_date = chk_date.replace(".","-");	
	Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.fcm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0012Event)request.getAttribute("Event");
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
<title>Fuel Consumption Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/sheet/ibchart.js"></script>

<script language="javascript">
	var gOfcCd = "<%=strOfc_cd%>";
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

<form name="form">
<!-- 기본 필수 hidden -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 업무용 hidden -->
<input type="hidden" name="trnd_line_tp_sub_cd">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
	
	<!-- Title, Navigation 고정 -->
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	<!-- 메인 화면 바깐쪽 화면 하단 버튼 부 -->
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
					<td class="btn1" name="btn_Simulation">Simulation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
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
					<td width="119">Period</td>
					<td width="742">
					<input type="text" name="trnd_line_fm_dt" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~
					<input type="text" name="trnd_line_to_dt" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="58">Budget</td>
					<td width="60">
						<select id="trnd_line_use_tp_cd" name="trnd_line_use_tp_cd" style="width:50;text-align:center;" class="input1">
							<option value="N">N</option>
							<option value="B">B</option>
						</select>
					</td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="118">Trend Line Type</td>
					<td width="130">
						<select id="trnd_line_tp_cd" name="trnd_line_tp_cd" style="width:125;text-align:center;" class="input1">
							<option value=""></option>
							<option value="1">1 - Design Capa/Lane</option>
							<option value="2">2 - Design Capa/All</option>
							<option value="3">3 - Vessel/Bound</option>
							<option value="4">4 - Vessel/All</option>
						</select>
					</td>
					<td width="258"><input type="text" name="trnd_line_no" style="width:125;text-align:center;ime-mode:disabled;" class="input2" readonly>
					<img class="cursor" name="btn_trnd_line_no" src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="58">Avg Slip</td>
					<td width="95"><input type="text" name="avg_slp_rt" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="47">Adjust</td>
					<td width="273"><input type="text" name="avg_slp_opt_rt" style="width:80;text-align:center;ime-mode:disabled;" class="input" dataformat="float"></td>
				</tr>
				</table>
			<div id="creTrndLine" style="display:inline;" width="100%">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="121">Design Capacity</td>
					<td width="95"><script language="javascript">ComComboObject('vsl_clss_cd',1,80,0,1);</script></td>
					<td width="65">Sub Class</td>
					<td width="95"><script language="javascript">ComComboObject('vsl_clss_sub_cd',1,80,0,0);</script></td>
					<td width="38">Lane</td>
					<td width="95"><script language="javascript">ComComboObject('vsl_slan_cd',1,80,0,1);</script></td>
					<td width="58">Vessel</td>
					<td width="95" class="stm"><script language="javascript">ComComboObject('vsl_cd',1,80,0,1);</script></td>
					<td width="47">Bound</td>
					<td width="270"><script language="javascript">ComComboObject('skd_dir_cd',1,80,0,1);</script></td>
				</tr>
				</table>
			</div>
			<div id="inqTrndLine" style="display:none;" width="100%">
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="120">Design Capacity</td>
					<td width="95"><input type="text" name="vsl_clss_cd_i" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="65">Sub Class</td>
					<td width="95"><input type="text" name="vsl_clss_sub_cd_i" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="38">Lane</td>
					<td width="95"><input type="text" name="vsl_slan_cd_i" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="58">Vessel</td>
					<td width="95"><input type="text" name="vsl_cd_i" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="47">Bound</td>
					<td width="271"><input type="text" name="skd_dir_cd_i" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
				</tr>
				</table>
			</div>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">						
					<td width="119">Remark</td>
					<td width="860"><input type="text" name="trnd_line_rmk" style="width:668;text-align:left;ime-mode:disabled;" class="input" size="10" maxlength="4000"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
				</td></tr>
			</table>
			<table class="height_8"><tr><td colspan="8"></td></tr></table>	

		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="118">Chart Type</td>
				<td> 
				    <input name="cht_tp_cd" type="radio" value="01" class="trans" checked>C.SPD vs M/E FOC&nbsp;
					<input name="cht_tp_cd" type="radio" value="03" class="trans">A.SPD vs M/E FOC&nbsp;
					<input name="cht_tp_cd" type="radio" value="04" class="trans">C.SPD vs RPM&nbsp;
					<input name="cht_tp_cd" type="radio" value="05" class="trans">RPM vs M/E FOC&nbsp;
					<input name="cht_tp_cd" type="radio" value="06" class="trans">LOAD vs M/E FOC&nbsp;
					<input name="cht_tp_cd" type="radio" value="07" class="trans">C.SPD vs LOAD&nbsp;
				</td></tr>
				</table>				
				<!-- Grid  (S) -->
					<table width="100%" id="mainTable"> 
						<tr>
							<td width="100%">
								<!-- 차트 -->
								<script language="javascript">ComChartObject('chart1', 490, 0)</script>
								<script language="javascript">ComChartObject('chart2', 489, 0)</script>
								<script language="javascript">ComChartObject('chart3', 980, 0)</script>
								<script language="javascript">ComChartObject('chart4', 980, 0)</script>
								<script language="javascript">ComChartObject('chart5', 980, 0)</script>
								<script language="javascript">ComChartObject('chart6', 980, 0)</script>
								<script language="javascript">ComChartObject('chart7', 980, 0)</script>
								
								<!--시트-->
								<script language="javascript">ComSheetObject('sheet1');</script>
								<script language="javascript">ComSheetObject('sheet2');</script>
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