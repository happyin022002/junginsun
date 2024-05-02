<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0107.jsp
*@FileTitle : Daily Forecast Input(한국지점용)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.10
*@LastModifier : 전상화
*@LastVersion : 1.0
* 2012.09.10 전상화
* 1.0 Creation
* 2012.09.10 전상화 [CHM-201220051-01] Daily FCST Input 개선 및 신규 Report 생성
* 2013.01.02 최윤성 [CHM-201322312-01] FCST Input(SELSC) 2차 수정요청
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.07.27 [CHM-201431081] SPC Allocation Control Option 추가 보완 요청
* 2015.02.23 [CHM-201533936] Split13-사용자 표준환경 관련 - 버튼 공백대신 &nbsp;추가, combobox 처리
* --IAS SMP 적용 후속작업 - RFA# 보이도록 수정
* 2015.12.10 이혜민 [CHM-201539143] FCST Input 및 Bottleneck 오류 수정 요청_버튼명수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0102Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSpc0102Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strSrep_cd	="";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.DailyForecastManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strSrep_cd =account.getSrep_cd();
				
		event = (EsmSpc0102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {			
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd    = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ofc_cd    = eventResponse.getETCData("ofc_cd");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
	}
	
%>
<html>
<head>
<title>Daily Forecast Input(SELSC)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

var ofc_cd    = "<%=ofc_cd%>";
var ofc_tp_cd = "<%=ofc_tp_cd%>";
var strUsr_id = "<%=strUsr_id%>";
var strSrep_cd ="<%=strSrep_cd%>";

function setupPage(){
	var errMessage = "";
	
	if (errMessage.length >= 1) {
		ComShowMessage(errMessage);
	} // end if
	
	loadPage();
}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0102');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvdList" value="DEFAULT">
<input type="hidden" name="salesRepCodeList" value="DEFAULT">
<input type="hidden" name="uiname" value="ESM_SPC_0102">
<input type="hidden" name="view_type" value="TEU">
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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>
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
					<td width="85"><img class="nostar">Start Week</td>
					<td width="150">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week" style="width:40;"></select>
						
					</td>
					<td width="75"><img class="nostar">Duration</td>
					<td width="150">
						<select class="input1" name="duration" size="1"></select>
					</td>
					<td width="*">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Trade</td>
					<td width="150" style="padding-left:2">
						<script language="JavaScript">ComComboObject("trade", 2, 104, 0, 1);</script>
					</td>
					<td width="75"><img class="nostar">Sub Trade</td>
					<td width="150" style="padding-left:2">
						<script language="JavaScript">ComComboObject("subtrade1", 3, 50, 0, 1);</script>
					</td>
					<td width="75"><img class="nostar">Lane</td>
					<td width="140">
						<script language="JavaScript">ComComboObject('rlane1',4, 100 , 1,0);</script>
						
						
					</td>
					<td width="70"><img class="nostar">Bound</td>
					<td width="100">
						<select name="bound" style="width:82;"></select>
					</td>
					<td width=""><input type="radio" class="trans" name="ioc" id="id_chk_ocn" value="O" checked></td><td width=""><label for="id_chk_ocn">OCN</label>&nbsp;</td>
					<td width=""><input type="radio" class="trans" name="ioc" id="id_chk_ipc" value="I"></td><td width=""><label for="id_chk_ipc">IPC</label>&nbsp;</td>
					<td width=""><input type="radio" class="trans" name="ioc" id="id_chk_ts" value="T"></td><td width=""><label for="id_chk_ts">TS</label>&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Sales Office</td>
					<td width="150" style="padding-left:2;"><script language="JavaScript">ComComboObject("salesOffice", 2, 104, 0, 1);</script></td>
					<td width="75"><img class="nostar">Sub-Office</td>
					<td width="150" style="padding-left:2;"><script language="JavaScript">ComComboObject("subOffice", 2, 80, 0);</script></td>
					<td width="75"><img class="nostar">Sales Rep</td>
					<td width="140"><script language="JavaScript">ComComboObject("salesRep", 4, 70, 0);//initData_salesRep();</script></td>
					<td width="70"><img class="nostar">VVD</td>
					<td width="100"><input class="input0" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="vvdChanged();"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td width="600">
					<table cellpadding="0" cellspacing="1">
					<tr>
							<td width="90">Data Selection : </td>
								<td>
									<table>
										<tr>
							<td width="25"><input type="checkbox" class="trans" name="chkDs2LaneInfo" id="ds2LaneInfo" onclick="return changeDataSelection();"></td>
							<td width="55"><label for="ds2LaneInfo">Lane Info</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2Office" id="ds2Office" onclick="return changeDataSelection();"></td>
							<td width="35"><label for="ds2Office">Office</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2USMode" id="ds2USMode" onclick="return changeDataSelection();"></td>
							<td width="35"><label for="ds2USMode">IPI/Local</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account" checked onclick="return changeDataSelection();"></td>
							<td width="35"><label for="ds2Account">Account</label></td>

							<td width="25" id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD" onclick="return changeDataSelection();"></td>
							<td width="25" id="divDs2POD"><label for="ds2POD">POD</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2TEU" id="ds2TEU" checked onclick="return changeDataSelection();"></td>
							<td><label for="ds2TEU">TEU</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2FEU" id="ds2FEU" onclick="return changeDataSelection();"></td>
							<td><label for="ds2FEU">FEU</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2BKG" id="ds2BKG" checked onclick="return changeDataSelection();"></td>
							<td><label for="ds2BKG">BKG</label></td>
							
							<td style="display:none;" width="25"><input type="checkbox" class="trans" name="chkDs2CIF" id="ds2CIF" onclick="return changeDataSelection();"></td>
							<td style="display:none;"><label for="ds2BKG">CIF/FOB</label></td>
							
							<td colspan="8"></td>
							</tr>

							<tr>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeDataSelection();"></td>
							<td><label for="ds2OTH">TEU/FEU</label></td>
							
                            <td colspan="12">
                            <table><tr>
	                           	<td width="25"><input type="checkbox" class="trans" name="chkDs2D2" id="ds2D2" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds2D2">D2</label></td>
								
	                           	<td width="25"><input type="checkbox" class="trans" name="chkDs2D4" id="ds2D4" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds2D4">D4</label></td>
	
								<td width="25"><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds2HC">HC</label></td>
								
								<td width="25"><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds245">45</label></td>
								
								<td width="25"><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds253">53'</label></td>
								
								<td width="25"><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds2RF">RF</label></td>
								
                            	<td width="25"><input type="checkbox" class="trans" name="chkDs2RD" id="ds2RD" onclick="return changeDataSelection();"></td>
								<td width="25"><label for="ds2RD">RD</label></td>
							</tr></table>
							</td>  
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeDataSelection();"></td>
							<td><label for="ds2WT">WT</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs2RMK" id="ds2RMK" onclick="return changeDataSelection();"></td>
							<td><label for="ds2RMK">Remark</label></td>
							
							<td width="25" style="display:none;" id="divDs2ACCT"><input type="checkbox" class="trans" name="chkDs2ACCT" id="ds2ACCT" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2ACCT"><label for="ds2ACCT">Account Level</label></td>
							<td width="25" style="display:none;" id="divDs2MDL"><input type="checkbox" class="trans" name="chkDs2MDL" id="ds2MDL" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2MDL"><label for="ds2MDL">Model</label></td>
							<td width="25" style="display:none;" id="divDs2SC"><input type="checkbox" class="trans" name="chkDs2SC" id="ds2SC" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2SC"><label for="ds2SC">S/C</label></td>
							<td width="25" style="display:none;" id="divDs2RFA"><input type="checkbox" class="trans" name="chkDs2RFA" id="ds2RFA" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2RFA"><label for="ds2RFA">RFA</label></td>
							
							</tr>
							</table>
							</td>
						</tr>
					</table>
				</td>
				<td width="20">&nbsp;</td>
				<td>
					<table>
						<tr height="30">

							<td width="25" style="display:none;" id="divDs2INF"><input type="checkbox" class="trans" name="chkDs2INF" id="ds2INF" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2INF"><label for="ds2INF">Information</label></td>

							<td>
							<table border="0" width="100%">
								<tr>
								<td class="btn2_bg" width="180">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_addAccount2" id="btng_addAccount2">&nbsp;Acct.Add/Del&nbsp;(Non SMP)</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
								<td class="btn2_bg" width="150">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_acctMapping" id="btng_acctMapping">Acct.Mapping&nbsp;(SMP)</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td>
							</table>

							</td>
					</tr>
					
					<tr>

							<td width="25" style="display:none;" id="divDs2INF"><input type="checkbox" class="trans" name="chkDs2INF" id="ds2INF" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2INF"><label for="ds2INF">Information</label></td>
							<td>
							<table border="0" width="100%">
								<tr>
								<td class="btn2_bg" width="120">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_accum" id="btng_accum" width="86">Accum.&nbsp;Guide </td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td><td class="btn2_bg" width="118">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_dlyfcast" id="btng_dlyfcast" width="88"> Daily&nbsp;Report </td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td><td class="btn2_bg" width="115">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_season_grp" id="btng_season_grp">&nbsp; Yield&nbsp;&nbsp;Group </td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>

							</td>
					</tr>
					</table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();" alt='Alt+↑'>
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
