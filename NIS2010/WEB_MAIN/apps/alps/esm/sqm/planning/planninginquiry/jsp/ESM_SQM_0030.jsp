<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0030.jsp
*@FileTitle      : QTA Inquiry_Quarterly Planning
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.30
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2015.07.24 김용습 - [CHM-201537212] [CSR 전환건] SQM 9개 Report내 코멘트 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.planning.planninginquiry.event.EsmSqm0030Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.planning.planninginquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0030Event)request.getAttribute("Event");
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
<title>Quarterly Planning</title>
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
<input type="hidden" name="f_bse_tp_cd" value="Q">
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
								<td width="230" rowspan="2" valign="top">
									<table class="search" border="0">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="70"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 0, 1)</script></td>
											<td width="50">Quarter</td>
											<td><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 0, 1 )</script></td>
										</tr>
										<tr class="h23">
											<td width="40">Month</td>
											<td width="180" colspan=3><input type="text" style="text-align:center;" class="input" size="3" maxlength="2" dataformat="int" name="f_fm_mon">
											&nbsp;&nbsp;~&nbsp;&nbsp;&nbsp;<input type="text" style="text-align:center;" class="input" size="3" dataformat="int" maxlength="2" name="f_to_mon"></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="140" class='sm'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td width="90"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 80, 0, 1)</script></td>
											<td width="85">Office Level</td>
											<td width="105"><script language="javascript">ComComboObject('f_ofc_lvl', 1, 90, 0,	1)</script></td>
											<td width="50">&nbsp;<div id="div_rhq">RHQ</div></td>
											<td width="85"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 0)</script></td>
											<td width="40"><div id="div_ofc">Office</div></td>
											<td><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 0)</script></td>
											<td>&nbsp;</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="50">Trade</td>
											<td width="90"><script language="javascript">ComComboObject('f_trd_cd', 1, 75, 0)</script></td>
											<td width="80">R/Lane</td>
											<td width="90"><script language="javascript">ComComboObject('f_rlane_cd', 1, 80, 0)</script></td>
											<td width="85"><div id="div_dir">Lane Bound</div></td>
											<td width="105"><div id="dir_cd"><script language="javascript">ComComboObject('f_dir_cd', 1, 90, 0 )</script></div>
											<div id="trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_trd_dir', 1, 90, 0 )</script></div></td>
											<td width="20"><input type="checkbox" name="f_gubun" class="trans"></td>
											<td>Trade Dir.</td>
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
							<td class="gray" height="19" id="sheet_unit">[Unit: TEU, $, TEU/$]</td>
					 	</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
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