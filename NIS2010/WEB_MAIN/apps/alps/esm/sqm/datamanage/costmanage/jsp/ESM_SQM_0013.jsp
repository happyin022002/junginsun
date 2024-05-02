<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0013.jsp
*@FileTitle      : Basic CMCB_MAS PFMC Retrieve
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   : JEONGMIN CHO
*@LastVersion    : 1.0
* 2013.05.08 JEONGMIN CHO
* 1.0 Creation
* 2015.06.15 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.event.EsmSqm0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%

	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String p_ofc_vw_cd  = JSPUtil.getParameter(request, "f_ofc_vw_cd", "");
	String p_rhq_cd     = JSPUtil.getParameter(request, "f_rhq_cd", "");
	String p_rgn_ofc_cd = JSPUtil.getParameter(request, "f_rgn_ofc_cd", "");
	String p_trd_cd     = JSPUtil.getParameter(request, "f_trd_cd", "");
	String p_rlane_cd   = JSPUtil.getParameter(request, "f_rlane_cd", "");
	String p_dir_cd     = JSPUtil.getParameter(request, "f_dir_cd", "");

	EsmSqm0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";


	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.datamanage.costmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0013Event)request.getAttribute("Event");
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
<title>Basic CMCB_MAS PFMC Retrieve</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

	var curTitle = "Basic CMCB_MAS PFMC Retrieve";
	var curDescription = "Basic CMCB_MAS PFMC Retrieve";
	
	var p_bse_tp_cd  = "<%=p_bse_tp_cd%>";
	var p_bse_yr     = "<%=p_bse_yr%>";
	var p_bse_qtr_cd = "<%=p_bse_qtr_cd%>";
	var p_ofc_vw_cd  = "<%=p_ofc_vw_cd%>";
	var p_rhq_cd     = "<%=p_rhq_cd%>";
	var p_rgn_ofc_cd = "<%=p_rgn_ofc_cd%>";
	var p_trd_cd     = "<%=p_trd_cd%>";
	var p_rlane_cd   = "<%=p_rlane_cd%>";
	var p_dir_cd     = "<%=p_dir_cd%>";
	
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="f_fm_wk">
<input type="hidden" name="f_to_wk">
<!-- 개발자 작업	-->

<!-- Outer Table (S)-->
<table width="100%" class="popup" cellpadding="10" border="0"> 
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%">
				<tr>
					<td class="bg">
						<table class="search_in">
							<tr>
								<td width="105" rowspan="2">
									<table class="search_sm2" width="95">
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" disabled><label style="padding-left:2;">Yearly</label></td></tr>
										<tr class="h23"><td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" disabled><label style="padding-left:2;">Quarterly</label></td></tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="72">Year</td>
											<td width="75"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 0, 1)</script></td>
											<td width="62"><div id="div_qtr">Quarter</div></td>
											<td width="65"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 0, 1)</script></td>
											<td width="140" class='sm'><div id="div_period"></div></td>
											<td width="80">Office View</td>
											<td width="95"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 80, 0, 1)</script></td>
											<td width="55">RHQ</td>
											<td width="90"><script language="javascript">ComComboObject('f_rhq_cd', 1, 75, 0, 1)</script></td>
											<td width="85">Office</td>
											<td><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 75, 0, 1)</script></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="70">End Week</td>
											<td width="77"><input type="text" style="text-align:center;width:60;" class="input1" maxlength="2" name="f_week" onchange="period_OnChange();"></td>
											<td width="60">Duration</td>
											<td width="67"><input type="text" style="text-align:center;width:50;" class="input1" maxlength="2" name="f_duration" onchange="period_OnChange();"></td>
											<td width="140" class="sm"><div id="div_period2">&nbsp;</div></td>
											<td width="80">Trade</td>
											<td width="95"><script language="javascript">ComComboObject('f_trd_cd', 1, 80, 0)</script></td>
											<td width="55">R/Lane</td>
											<td width="90"><script language="javascript">ComComboObject('f_rlane_cd', 1, 75, 0)</script></td>
											<td width="85">Lane Bound</td>
											<td><script language="javascript">ComComboObject('f_dir_cd', 1, 75, 0)</script></td>
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
								<td style="text-align:right;">[Unit : $/TEU]</td>
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
			
			<!-- TABLE '#D' : ( Button : pop ) (S) -->
			<table width="100%" class="sbutton">
		       	<tr>
		       		<td height="71" class="popup">
		       			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
		       				<tr>
		       					<td class="btn3_bg"> 
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
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
														<td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
														<td class="btn1_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn1_left"></td>
														<td class="btn1" id="btn_close" name="btn_close">Close</td>
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
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Button : pop ) (E) -->
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>