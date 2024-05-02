<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0508.js
*@FileTitle      : Current KPI Report
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.25
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.25 이혜민
* 1.0 Creation
* 2014.11.07 이혜민 [CHM-201432524] Current KPI Report 화면 내 Trade Direction 조건 추가
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.07.24 김용습 [CHM-201537212] [CSR 전환건] SQM 9개 Report내 코멘트 추가
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
* 2015.11.20 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0508Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0508Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.specialkpi.planning");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0508Event)request.getAttribute("Event");
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
<title>Current KPI Report</title>
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
<input type="hidden" name="f_gubun" value="HO">
<input type="hidden" name="f_qta_step_cd" value="02">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			<!--Button_L (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td class="btn1_line"></td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_RawDataDownExcel" name="btn_RawDataDownExcel">Raw Data Export</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>

								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!--Button_L (E) -->
		
						<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%">
				<tr>
					<td class="bg">
						<table class="search_in">
							<tr>
								<td width="310" rowspan="3">
									<table class="search_sm2" border="0" width="300">
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" ><label style="padding-left:2;">Yearly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="R" checked><label style="padding-left:2;">Reefer</label></td>
											<td><input type="radio" name="f_year_tp_cd" class="trans" value="I" disabled><label style="padding-left:2;">Initial Fixed</label></td>
										</tr>
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="S" ><label style="padding-left:2;">Special</label></td>
											<td><input type="radio" name="f_year_tp_cd" class="trans" value="C" disabled><label style="padding-left:2;">Currently Updated</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Year</td>
											<td width="85"><script language="javascript">ComComboObject('f_bse_yr', 1, 70, 1, 1)</script></td>
											<td width="55"><div id="div_qtr">Quarter</div></td>
											<td width="80"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 1, 1)</script></td>
											<td width="160" class='sm'><div id="div_period_based_on_rev_month"></div></td>
											<!-- <td width="160" class='sm'><div id="div_period"></div></td> -->
											<td width="135">
												<div id="div_mon" style="display:inline">Month&nbsp;&nbsp;
												<input type="text" style="width:30;text-align:center;" class="input" size="3" maxlength="2"  onKeyPress='ComKeyOnlyNumber(window);' name="f_fm_mon">
												~&nbsp;<input type="text" style="width:30;text-align:center;" class="input" size="3"  onKeyPress='ComKeyOnlyNumber(window);' maxlength="2" name="f_to_mon">
												</div>
												<div id="div_wk" style="display:none">Week&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="text" style="width:30;text-align:center;" class="input" size="3" maxlength="2"  onKeyPress='ComKeyOnlyNumber(window);' name="f_fm_wk">
												~&nbsp;<input type="text" style="width:30;text-align:center;" class="input" size="3"  onKeyPress='ComKeyOnlyNumber(window);' maxlength="2" name="f_to_wk">
												</div>
											</td>
											<td><input type="checkbox" value="W" name="chk_week" class="trans">&nbsp;Week</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Trade</td>
											<td width="85"><script language="javascript">ComComboObject('f_trd_cd', 1, 70, 1)</script></td>
											<td width="55">R/Lane</td>
											<td width="80"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
											<!--td width="82">Trade Bound</td-->
											<!-- td ><script language="javascript">ComComboObject('f_conv_dir_cd', 1, 70, 1)</script></td-->
											<td width="82"><div id="div_dir">Trade Bound</div></td>
											<td width="75">
												<div id="div_dir_cd"><script language="javascript">ComComboObject('f_conv_dir_cd', 1, 70, 1)</script></div>
												<div id="div_trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 70, 0)</script></div>
											</td>
											<td width=""><input type="checkbox" name="f_trd_dir" class="trans">&nbsp;Trade Dir.</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="80">Office Level</td>
											<td width="85"><script language="javascript">ComComboObject('f_ofc_lvl', 1, 70, 1, 1)</script></td>
											<td width="55"><div id="div_rhq">RHQ</div></td>
											<td width="80"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
											<td width="82"><div id="div_ofc">Office</div></td>
											<td width="80"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			<table class="height_10"><tr><td></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg_b1">
						<table class="height_10"><tr><td></td></tr></table>
						<table width="100%"  class="search" >
							<tr>
								<td>
									<table class="search_sm2" width="300" >
										<tr class="h23">
											<td><input type="checkbox" value="W" name="f_chk_week" class="trans">&nbsp;By Week</td>
											<td><input type="checkbox" value="V" name="f_chk_vvd" class="trans">&nbsp;By VVD</td>
											<td><input type="checkbox" value="D" name="f_chk_decimal" class="trans">&nbsp;Decimal G.RPB</td>
										</tr>	
									</table>
								</td>
								<td style="text-align:left;" width="550">
					                  <input type="radio" name="rdoOp_cd" value="C" class="trans" checked><strong>Current Version</strong>&nbsp;&nbsp;
					                  <input type="radio" name="rdoOp_cd" value="P" class="trans"><strong>Previous Version(Until 2015 2Q)</strong>
               				    </td>
								<td style="text-align:right;text-valign:button;cellspacing:0 ">[Unit : TEU, TEU/$, $]</td>
							</tr>
						</table>
						<!-- table class="height_10"><tr><td></td></tr></table -->
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><div id="tabLayer1" style="display:inline"><script language="javascript">ComSheetObject('sheet1');</script></div></td>
							</tr>
							<tr>
								<td><div id="tabLayer2" style="display:none"><script language="javascript">ComSheetObject('sheet2');</script></div></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table width="100%" class="search" >
							<tr><td height="5" id="sheet_unit">*CM Cost (PA) = ALPS MAS (PA) CM Cost - DEM/DET Revenue </td></tr>
							<tr><td height="5" id="sheet_unit">*CM Cost (RA) = ALPS MAS (RA) CM Cost - DEM/DET Revenue </td></tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>