<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0225.jsp
*@FileTitle      : Yearly Current QTA Report for IAS Sector
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.23
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2014.01.23 SQM USER
* 1.0 Creation
* History
* 2014.05.07 이혜민 [CHM-201430049] IAS Sector sales - Planning 메뉴의 report 검색 조건 위치 변경 요청
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2015.07.17 김용습 [CHM-201537066] [CSR 전환건] QTA Inquiry_Yearly Current QTA Report for IAS Sector 조회 로직 변경
* 2015.07.24 김용습 [CHM-201537212] [CSR 전환건] SQM 9개 Report내 코멘트 추가
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze) 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event.EsmSqm0225Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0225Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.adjustment.qtainquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0225Event)request.getAttribute("Event");
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
<title>Yearly Current QTA Report for IAS Sector</title>
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
<input type="hidden" name="f_bse_tp_cd" value="Y">
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
			<table class="search" >
				<tr>
					<td class="bg">
						<table class="search_in">
							<tr>
								<td width="155" rowspan="2">
									<table class="search_sm2" width="150">
										<tr class="h23"><td><input type="radio" name="f_year_tp_cd" class="trans" value="I"><label style="padding-left:2;">Initially Fixed</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_year_tp_cd" class="trans" value="C" checked><label style="padding-left:2;">Currently Updated</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="46">Year</td>
											<td width="79"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 0, 1 )</script></td>
											<td width="70"></td>
											<td width="73">Office View</td>
											<td width="85"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 75, 1, 1)</script></td>
											<td width="80">Office Level</td>
											<td width="100"><script language="javascript">ComComboObject('f_ofc_lvl', 1, 90, 1, 1)</script></td>
											<td width="80"><div id="div_rhq">RHQ</div></td>
											<td width="80"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 1 )</script></td>
											<td width="60"><div id="div_ofc">Office</div></td>
											<td width="70"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
											<td width="">&nbsp;</td>
										</tr>
									</table>
									<table class="search" border="0">	
										<tr class="h23">
											<td width="45"><div id="div_monwk">Month</div></td>
											<td width="80">
												<div id="div_mon" style="display:inline">
													<input type="text" style="text-align:center;" class="input" size="2" maxlength="2" dataformat="int" name="f_fm_mon">~<input type="text" style="text-align:center;" class="input" size="2" maxlength="2" dataformat="int" name="f_to_mon">
												</div>
												<div id="div_wk" style="display:none">
													<input type="text" style="text-align:center;" class="input" size="2" maxlength="2" dataformat="int" name="f_fm_wk">~<input type="text" style="text-align:center;" class="input" size="2" maxlength="2" dataformat="int" name="f_to_wk">
												</div>
											</td>
											<td width="69"><input type="checkbox" value="W" name="chk_week" class="trans">Week</td>
											<td width="73">Sub Trade</td>
											<td width="85"><script language="javascript">ComComboObject('f_sub_trd_cd', 1, 75, 1)</script></td>
											<td width="79">IAS Region</td>
											<td width="100"><script language="javascript">ComComboObject('f_ias_rgn_cd', 1, 90, 1)</script></td>
											<td width="80"><div id="div_dir">Lane Bound</div></td>
											<td width="75">
												<div id="div_dir_cd"><script language="javascript">ComComboObject('f_dir_cd', 1, 70, 1)</script></div>
												<div id="div_trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 70, 0)</script></div>
											</td>
											<td ><input type="checkbox" name="f_trd_dir" class="trans">&nbsp;Trade Dir.</td>
										</tr>
									</table>
									<table class="search" border="0">		
										<tr class="h23">
											<td width="195">&nbsp;</td>
											<td width="72">R/Lane</td>
											<td width="85"><script language="javascript">ComComboObject('f_rlane_cd', 1, 75, 1)</script></td>
											<td width="79">POL</td>
											<td width="100"><script language="javascript">ComComboObject('f_pol_cd', 1, 90, 1)</script></td>
											<td width="80">POD</td>
											<td width="80"><script language="javascript">ComComboObject('f_pod_cd', 1, 70, 1)</script></td>
											<td width="60"><div id="div_main" style="display:none;">Main</div></td>
											<td width="60">
											    <div id="div_main_sel" style="display:none;">
													<select  name="f_sqm_mn_sctr_flg" style="width:60;" class="input">
														<option value="All" selected="selected">All</option>
														<option value="Y">Y</option>
														<option value="N">N</option>
													</select>
												</div>
											</td>
											<td width="">&nbsp;</td>
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
						<table width="100%" class="search">
							<tr>
								<td  width="270">
									<table class="search_sm2" width="260">
										<tr class="h23">
											<td width="70"><input type="checkbox" value="W" name="f_chk_week" class="trans">&nbsp;Week</td>
											<td width="60"><input type="checkbox" value="V" name="f_chk_vvd" class="trans">&nbsp;VVD</td>
											<td width=""><input type="checkbox" value="Y" name="f_chk_pair" class="trans">&nbsp;POL-POD Pair</td>
											
										</tr>
									</table>
								</td>
								<td style="text-align:left;" width="430">
					                  <input type="radio" name="rdoOp_cd" value="C" class="trans" checked><strong>Current Version</strong>&nbsp;&nbsp;
					                  <input type="radio" name="rdoOp_cd" value="P" class="trans"><strong>Previous Version(Until 2015 2Q)</strong>
               				    </td>
								<td>
									<table width="130" class="search">
										<tr>
											<td style="text-align:right;">[Unit : TEU, TEU/$, $]</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
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