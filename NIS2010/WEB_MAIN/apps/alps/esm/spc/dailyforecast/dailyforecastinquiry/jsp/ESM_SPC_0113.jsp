<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0113.jsp
*@FileTitle : dailyforecastinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.03
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.03 한상훈
* 1.0 Creation
* 2011.04.11 김종준 [CHM-201110033-01] ALPS/SPC의 TS booking status 기능보완 요청
			-RHQ가 현재 필수항목으로 SHARC/SINRS/HAMRU/NYCRA로 되어있으나, ALL을 추가.
			-RHQ : ALL 선택 시 T/S Conti는 필수항목. 
			-T/S Lane과 T/S Port 사이에  T/S VVD 및  T/S ETB DATE(T/S VVD의 T/S Port의 ETB_DT) 추가
			-Grid 상단의 Check Box에 T/S VVD 체크박스 추가 : 해당 체크박스 체크시 T/S VVD 및 ETB Date 보여줌
* 2011.05.06 최성민 [CHM-201110577-01] Pre/Post T/S ETB Date 항목 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2014.11.14 신자영 [CHM-201432770] T/S Booking Report 개선 - 기존 105번 화면 copy하여 복원
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
* 2015.08.03 Arie T/S BKG 화면 조직없이 전지역 조회 가능하도록 수정
* 2015.08.17 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(8.03내용 포함)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastinquiry.event.EsmSpc0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0113Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.DailyForecastInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0113Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin  = false;
	String ofc_cd    = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	String rhq_cd    = "";
	String rgn_cd    = "";

	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin   = eventResponse.getETCData("adm").equals("Y");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
		rhq_cd    = eventResponse.getETCData("rhq_cd");
		rgn_cd    = eventResponse.getETCData("rgn_ofc_cd");
	}
%>
<html>
<head>
<title>dailyforecastinquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var rhq_cd = "<%=rhq_cd%>";
	var ofc_cd = "<%=ofc_cd%>";
	var ofc_tp_cd = "<%=ofc_tp_cd%>";

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
<form name="form" onKeyUp="ComKeyEnter();">
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
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="100"><img class="nostar">Start Week</td>
					<td width="140">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week" style="width:40;"></select>
					</td>
					<td width="70"><img class="nostar">Duration</td>
					<td width="80">
						<select class="input1" name="duration" size="1"></select>
					</td>						

					<td width="55"><img class="nostar">RHQ</td>
					<td width="100"><select class="input1" name="rhq_cd" onchange="rhq_cd_OnChange();"><option value="">ALL</option><option value="SHARC">SHARC</option><option value="SINRS">SINRS</option><option value="NYCRA">NYCRA</option><option value="HAMRU">HAMRU</option></select></td>

					<td width="100"><img class="nostar">RGN OFC</td>

					<td width="100"><script language="JavaScript">ComComboObject("ofc_cd", 2, 70, 0);</script></td>
					<td colspan="3">
						<table border="0"  width="210">
							<tr class="h23">
								<td><input type="radio" name="pre_pst_flg" id="pre_pst_flg_U" value="U" class="trans" onclick="changeSelectPort();" checked></td><td><label for="pre_pst_flg_U">By Post Lane</label></td>
								<td><input type="radio" name="pre_pst_flg" id="pre_pst_flg_S" value="S" class="trans" onclick="changeSelectPort();" ></td><td><label for="pre_pst_flg_S">By Pre Lane</label></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr class="h23">
					<td width="130"><img class="nostar">T/S SVC.Lane</td>
					<td width="180">
						<input type="input" name="ts_lane1" size="2" maxlength="3" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);">
						<input type="input" name="ts_lane2" size="2" maxlength="3" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);">
						<input type="input" name="ts_lane3" size="2" maxlength="3" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);">
					</td>

					<td width="80" id="txtConti"><img class="nostar">T/S Conti</td>
					<td width="80"><script language="JavaScript">ComComboObject("ts_conti", 2, 40, 0);</script></td>


					<td width="90" id="txtPol"><img class="nostar">T/S Port</td>
					<td width="100"><input type="input" name="pol1" size="6" maxlength="5" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>

					<td width="70" id="txtPod"><img class="nostar">B.POD</td>
					<td width="100"><input type="input" name="pod1" size="9" maxlength="5" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>

					<td width="50"><img class="nostar">T.Lane</td>
					<td width="110">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 0);</script>
					</td>

					<td width="10"><img class="nostar">T.VVD</td>
					<td><input class="input1" type="input" name="vvd" size="15" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>

				</tr>
				</form>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%">
				<tr>
				<td>
					<table cellpadding="0" cellspacing="0">
					<tr>
					<td width="90">Data Selection : </td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="2" name="chkDsTSPort" id="dsTSPort" checked onclick="return changeDataSelection();"></td><td><label for="dsTSPort">T/S Port</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="4" name="chkDsPost" id="dsPort" checked onclick="return changeDataSelection();"></td><td><label for="dsPort" id="txtDsPort">POL/POD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="5" name="chkDsOffice" id="dsOffice" checked onclick="return changeDataSelection();"></td><td><label for="dsOffice">Office</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="6" name="chkDsLane" id="dsLane" checked checked onclick="return changeDataSelection();"></td><td id="divDs2POD"><label for="dsLane">Lane/VVD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="7" name="chkDsVvd" id="dsVvd" onclick="return showDataCol();"></td><td id="divDsVvd"><label for="dsVvd">T/S VVD</label></td>
					<td width="5"></td>
					<td><input type="checkbox" class="trans" value="7" name="chkDsPVvd" id="dsPVvd" onclick="return showPrePostDataCol();"></td><td id="divDsPVvd"><label for="dsPVvd">Prev. VVD</label></td>
					<td width="5"></td>
					</tr></table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();">
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
