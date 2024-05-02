<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0102.jsp
*@FileTitle : Daily Forecast Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.08.27 최윤성
* 1.0 Creation
* 2010.07.08 CHOI.Y.S - [프로젝트] Ticket ID : CHM-201004171
* - [프로젝트] 53FT 관련 필드 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0999Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmSpc0999Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.DailyForecastManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0999Event)request.getAttribute("Event");
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
<title>Daily Forecast Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var ofc_cd    = "<%=ofc_cd%>";
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
<form name="form" onsubmit="return false;" onKeyDown="spcKeyAction('ESM_SPC_0999');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vvdList" value="DEFAULT">
<input type="hidden" name="salesRepCodeList" value="DEFAULT">
<input type="hidden" name="uiname" value="ESM_SPC_0999">
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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_confirm" id="btn_confirm">Confirm</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
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
						<script language="JavaScript">ComComboObject("subtrade", 3, 80, 0, 0);</script>
					</td>
					<td width="75"><img class="nostar">Lane</td>
					<td width="140">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 1);</script>
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
					<td width="100"><input class="input1" type="input" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="vvdChanged();"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab" id="tabObj" style="display:">
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>

		<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="" border="0" width="100%">
				<tr class="h23">
					<td></td>
					<td align="right">(Unit : TEU)</td>
					</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->




			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_028_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table width="100%" border="0">
				<tr>
				<td width="710">
					<table cellpadding="0" cellspacing="0">

							<td width="90">Data Selection : </td>
								<td>
									<table>
										<tr>




							<td width="25"><input type="checkbox" class="trans" name="chkDs2LaneInfo" id="ds2LaneInfo" onclick="return changeDataSelection();"></td>
							<td width="55"><label for="ds2LaneInfo">Lane Info</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2Office" id="ds2Office" onclick="return changeDataSelection();"></td>
							<td width="35"><label for="ds2Office">Office</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2Account" id="ds2Account" checked onclick="return changeDataSelection();"></td>
							<td width="35"><label for="ds2Account">Account</label></td>

							<td width="25" id="divDs2POD"><input type="checkbox" class="trans" name="chkDs2POD" id="ds2POD" checked checked onclick="return changeDataSelection();"></td>
							<td width="25" id="divDs2POD"><label for="ds2POD">POD</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2OTH" id="ds2OTH" onclick="return changeDataSelection();"></td>
							<td><label for="ds2OTH">20/40</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return changeDataSelection();"></td>
							<td><label for="ds2HC">HC</label></td>
							</tr>

							<tr>
							<td width="25"><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return changeDataSelection();"></td>
							<td><label for="ds245">45</label></td>
							
							<td width="25"><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return changeDataSelection();"></td>
							<td><label for="ds253">53'</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return changeDataSelection();"></td>
							<td><label for="ds2RF">RF</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return changeDataSelection();"></td>
							<td><label for="ds2WT">WT</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2BKG" id="ds2BKG" checked onclick="return changeDataSelection();"></td>
							<td><label for="ds2BKG">BKG</label></td>

							<td width="25" style="display:none;" id="divDs2CFM"><input type="checkbox" class="trans" name="chkDs2CFM" id="ds2CFM" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2CFM"><label for="ds2CFM">Confirmed</label></td>

							<td width="25"><input type="checkbox" class="trans" name="chkDs2CfrmAll" id="ds2CfrmAll" checked></td>
							<td><label for="ds2CfrmAll">Confirm all data on the screen</label></td>
							</tr>
							</table>
							</td>
					</table>
				</td>
				<td>
					<table>
						<tr>

							<td width="25" style="display:none;" id="divDs2INF"><input type="checkbox" class="trans" name="chkDs2INF" id="ds2INF" onclick="return changeDataSelection();"></td>
							<td style="display:none;" id="divDs2INF"><label for="ds2INF">Information</label></td>

							<td>
							<table border="0" width="100%">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn2_left"></td><td class="btn2" name="btng_addAccount2" id="btng_addAccount2">Acct. Add/Del</td>
											<td class="btn2_right"></td></tr></table></td>
											<!-- Repeat Pattern -->
										</tr>
									</table>
								</td></tr>
							</table>

							</td>
					</tr></table>
				</td>
				<td align="right" id="sheetControlDiv">
					<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="t1sheet2" type="N" onclick="toggleSheetSize();" alt='Alt+↑'>
				</td>
				</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('t1sheet2');</script>
                        </td></tr>
		            </table>


				<!-- : ( POR ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>