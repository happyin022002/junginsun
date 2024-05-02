<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0031.jsp
*@FileTitle      : QTA Adjustment by VVD
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.27
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2013.12.17 박은주 [CHM-201328060] 2013년도 SAQ 데이터 조회시 생성 기준이 다른 부분을 해결하기 위해 f_crnt_qta_cd 추가 
* 2013.12.17 PEJ [CHM-201328060] 2014년 연간 판매목표 수립 지원(Trade 필수항목으로 변경)
* 2013.12.27 이혜민 선조치 SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.01.06 박은주 [CHM-201428374] QTA Adjustment by VVD 화면내 신규 칼럼 추가 및 Creation 로직 수정
* 2015.01.22 김용습 [CHM-201533807] 변경된 Quarter 표시(week에서 rev month로)에 따라 줄바꿈 생기지 않도록 미세조정
* 2015.02.17 이혜민 [CHM-201533941] VVD Adjust 관련 두 화면 내 Trade Direction 추가 
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가 - Adjusted 버튼 추가
* 2015.08.26 김용습 [CHM-201537711] [CSR 전환건] QTA ADJUSTMENT BY VVD 및 QTA ADJUSTMENT BY VVD FOR IAS SECTOR 화면 개선
* 2015.09.09 김용습 [CHM-201537818] QTA Adjustment by VVD, QTA Adjustment by VVD for IAS Sector 두 화면내 칼럼 수정
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.02.25 QTA Adjustment bu VVD와 QTA Adjustment by VVD for IAS Sector 에서 Target VVD 바라보는 것을 잠시 끊을 수 있도록 하는 로직 수정
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0031Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0031Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String login_ofc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.adjustment.qtaadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		login_ofc_cd = account.getOfc_cd();

		event = (EsmSqm0031Event)request.getAttribute("Event");
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
<title>QTA Adjustment by VVD</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var login_ofc_cd = "<%=login_ofc_cd%>";
	
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
<input type="hidden" name="f_bse_tp_cd" value="Q">
<input type="hidden" name="f_qta_tgt_cd" value="D">
<input type="hidden" name="f_crnt_qta_cd">
<input type="hidden" name="f_crnt_bse_yr">
<input type="hidden" name="f_fm_wk">
<input type="hidden" name="f_to_wk">
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
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Adjusted" name="btn_Adjusted">Adjusted</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								
								<td class="btn1_line"></td>
								
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Save" name="btn_Save">Save Supply</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
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

			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in">
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Year</td>
											<td width="70"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
											<td width="55">Quarter</td>
											<td width="55"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 1, 1)</script></td>
											<td width="200" class='sm'><div id="div_period_based_on_rev_month"></div></td>											
											<td width="130">Portion Connected</td>
											<td width="60"><script language="javascript">ComComboObject('f_portion_link', 1, 50, 0)</script></td>
											<td >&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>	
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="50">Trade</td>
											<td width="70"><script language="javascript">ComComboObject('f_trd_cd', 1, 60, 1,1)</script></td>
											<td width="55">R/Lane</td>
											<td width="80"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 0)</script></td>
											<td width="85"><div id="div_dir">Lane Bound</div></td>
											<td width="60">
												<div id="div_dir_cd"><script language="javascript">ComComboObject('f_dir_cd', 1, 50, 0)</script></div>
												<div id="div_trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_hul_bnd_cd', 1, 50, 0)</script></div>
											</td>
											<td width="100"><input type="checkbox" name="f_trd_dir" class="trans">&nbsp;Trade Dir.</td>																						
											<td><input type="checkbox" name="f_dis_mas" class="trans" value="Y" >&nbsp;Disconnect from MAS</td>
											<!--  
											<td width="30">Week</td>
											<td><input type="text" style="width:40" name="f_bse_wk" class="input" maxlength="2" value= "02"></td>
											-->
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
								<td><font color="blue" >[ Trade : <span id="trade_code"></span>, Revenue Quarter : <span id="quarter"></span>&nbsp;]</font></td>
							</tr>
						</table>
						
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						
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