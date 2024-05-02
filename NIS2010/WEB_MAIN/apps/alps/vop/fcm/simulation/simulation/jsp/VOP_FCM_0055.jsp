<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_0054.jsp
*@FileTitle : Fuel Consumption Trend Line Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.02 진마리아
* 1.0 Creation
*
* History
* 2012.03.08 진마리아 [선처리] Displacement 컬럼 추가
* 2012.05.14 진마리아 CHM-201217542-01 Trend Line의 값을 이용한 RPM,load, Speed, FOC을 시뮬레이션 가능하도록 화면 수정
* 2012.06.05 진마리아 CHM-201217542-01 Distance, Sea Time, (Speed, RPM, Load) 상호 계산 가능하도록 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.vop.fcm.simulation.simulation.event.VopFcm0055Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopFcm0055Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";	// Office Code 삭제시 Delete 버튼 활성화 여부 확인.
	//Logger log = Logger.getLogger("com.hanjin.apps.vop.fcm.trendline.trendline");
	Logger log = Logger.getLogger("com.hanjin.apps.alps.vop.fcm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (VopFcm0055Event)request.getAttribute("Event");
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
<title>Fuel Consumption Trend Line Simulation</title>
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
<input type="hidden" name="cntr_dzn_capa">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="vsl_slan_cd">
<input type="hidden" name="skd_dir_cd">

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
					<td class="btn1" name="btn_New" id="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Simulation" id="btn_Simulation">Simulation</td>
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
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">Period</td>
					<td width="300">
					<input type="text" name="trnd_line_fm_dt" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img class="cursor" name="btns_Calendar1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;~
					<input type="text" name="trnd_line_to_dt" style="width:80;text-align:center;" class="input1" dataformat="ymd" value="" maxlength="8" size="10">&nbsp;<img name="btns_Calendar2" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="110"><script language="javascript">ComComboObject('itm_cd_1',0,100,1,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_cd_2',0,100,1,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_cd_3',0,100,1,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_cd_4',0,100,1,0);</script></td>
					<td width="159" align="right">Raw Data&nbsp;<input type="checkbox" name="chk_raw_data" value="Y" class="trans"></td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">AVG.Slip</td>
					<td width="100"><input type="text" name="avg_slp_rt" style="width:80;text-align:center;ime-mode:disabled;" class="input2" readonly></td>
					<td width="60">Adjust</td>
					<td width="140"><input type="text" name="avg_slp_opt_rt" style="width:80;text-align:center;ime-mode:disabled;" class="input" dataformat="float"></td>
					<td width="110"><script language="javascript">ComComboObject('itm_val_1',1,100,0,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_val_2',1,100,0,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_val_3',1,100,0,0);</script></td>
					<td width="110"><script language="javascript">ComComboObject('itm_val_4',1,100,0,0);</script></td>
					<td width="159"></td>
				</tr>
			</table>
		</td></tr>
		</table>
		<!--  biz_1   (E) -->
		
		<table class="search"> 
       	<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="90">Chart Type</td>
				<td> 
				    <input name="cht_tp_cd" type="radio" value="01" class="trans" checked><small>C.SPD vs ME FOC / C.SPD vs A.SPD &nbsp; </small>
					<input name="cht_tp_cd" type="radio" value="02" class="trans"><small>A.SPD vs ME FOC / C.SPD vs ME FOC &nbsp; </small>
					<input name="cht_tp_cd" type="radio" value="03" class="trans"><small>C.SPD vs RPM / C.SPD vs LOAD &nbsp; </small>
					<input name="cht_tp_cd" type="radio" value="04" class="trans"><small>RPM vs ME FOC / LOAD vs ME FOC &nbsp; </small>
				</td></tr>
				</table>
								
				<!-- Grid  (S) -->
				<table width="100%" id="mainTable"> 
					<tr>
					<td width="100%" colspan="3">
						<!-- 차트 -->
						<script language="javascript">ComChartObject('chart_line', 490, 0)</script>
						<script language="javascript">ComChartObject('chart_cspd_mefoc', 489, 0)</script>
						<script language="javascript">ComChartObject('chart_aspd_mefoc', 490, 0)</script>
						<script language="javascript">ComChartObject('chart_cspd_mefoc_2', 489, 0)</script>
						<script language="javascript">ComChartObject('chart_cspd_rpm', 490, 0)</script>
						<script language="javascript">ComChartObject('chart_cspd_load', 489, 0)</script>
						<script language="javascript">ComChartObject('chart_rpm_mefoc', 490, 0)</script>
						<script language="javascript">ComChartObject('chart_load_mefoc', 489, 0)</script>
						
						<table class="line_bluedot"><tr><td></td></tr></table>
					</td>
					</tr>
					<tr>
						<td width="74.5%">
							<!-- 시트 -->
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
						<td width="0.5%">&nbsp;</td>
						<td width="25%">
							<table class="search" border="0" style="width:100%;">
								<tr class="h23">
									<td width="55">Distance</td>
									<td width="69.75"><input name="sea_dist" type="text" dataformat="float" style="width:55" class="input" value=""></td>
									<td width="60">Sea Time</td>
									<td width="60"><input name="sea_time" type="text" dataformat="float" style="width:55" class="input" value=""></td>
								</tr>
								<tr class="h23">
									<td width="65">
										<select name="item" style="width:60;" class="input">
												<option value="S" selected>Speed</option>
												<option value="R">RPM</option>
												<option value="L">Load</option>
										</select>
									</td>
									<td width="" colspan="3"><input name="item_val" type="text" dataformat="float" style="width:55" class="input" value=""></td>
								</tr>
								<tr>
									<td colspan="4" height="13">&nbsp;</td>
								</tr>
								<tr>
									<td width="100%" colspan="4">
									<script language="javascript">ComSheetObject('sheet2');</script>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="100%" colspan="3">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 
				<!-- Grid (E) -->
			</td></tr>
		</table>
		<!-- Grid (E) -->
	
</td></tr>
</table>
    
</form>			
</body>
</html>