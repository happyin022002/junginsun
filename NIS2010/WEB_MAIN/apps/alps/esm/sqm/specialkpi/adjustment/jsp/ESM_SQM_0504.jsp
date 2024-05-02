<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0504.jsp
*@FileTitle      : KPI Creation & Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.07.15
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.15 이혜민
* 1.0 Creation
* 2015.01.22 김용습 [CHM-201533807] Rev Month 기준으로 관련 화면의 period를 변경
* 2015.11.10 김성욱 [CHM-201538496] [CSR 전환건] KPI Creation & Edit 화면 보완 (Trade Direction 칼럼 추가)
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.event.EsmSqm0504Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0504Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSqm0504Event)request.getAttribute("Event");
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
<title>KPI Creation & Edit</title>
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
											<td class="btn1" id="btn_Save" name="btn_Save">Save</td>
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
									<div id="div_1QTransfer" style="display:none">
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr>
												<td class="btn1_left"></td>
												<td class="btn1" id="btn_1qTransfer" name="btn_1qTransfer">1Q Transfer</td>
												<td class="btn1_right"></td>
											</tr>
										</table>
									</div>
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
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" id="btn_LoadExcel" name="btn_LoadExcel">Load Excel</td>
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
						<table class="search_in"  width="100%" >
							<tr>
								<td width="200" rowspan="2">
									<table class="search_sm2" width="180">
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Y" ><label style="padding-left:2;">Yearly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="R" checked><label style="padding-left:2;">Reefer</label></td>
										</tr>
										<tr class="h23">
											<td><input type="radio" name="f_bse_tp_cd" class="trans" value="Q" checked><label style="padding-left:2;">Quarterly</label></td>
											<td><input type="radio" name="f_spcl_tgt_cd" class="trans" value="S" ><label style="padding-left:2;">Special</label></td>
										</tr>
									</table>
								</td>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="42">Year</td>
											<td width="80"><script language="javascript">ComComboObject('f_bse_yr', 1, 70, 1, 1)</script></td>
											<td width="55"><div id="div_qtr">Quarter</div></td>
											<td width="85"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 70, 1, 1)</script></td>
											<!--  td width="175" class='sm'><div id="div_period_based_on_rev_month"></div></td-->
											<td width="167" class='sm'><div id="div_period"></div></td>
											<td width="55"><div id="div_mon">Month</div></td>
											<td width="88"><script language="javascript">ComComboObject('f_bse_mon', 1, 70, 1, 0)</script></td>
											<td width="30"><div id="div_vvd">VVD</div></td>
											<td >
												<input type="text" name="f_vsl_cd" style="width:40;text-align:center;ime-mode:disabled;" class="input" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="4" value="">
												<input type="text" name="f_skd_voy_no" style="width:40;text-align:center;ime-mode:disabled;" class="input" onKeyPress="ComKeyOnlyNumber(this)" maxlength="4" value="">
												<input type="text" name="f_skd_dir_cd" style="width:20;text-align:center;ime-mode:disabled;" class="input" onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="1" value="">
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search" border="0">
										<tr class="h23">
											<td width="45">Trade</td>
											<td width="85"><script language="javascript">ComComboObject('f_trd_cd', 1, 70, 1,1)</script></td>
											<td width="55">R/Lane</td>
											<td width="85"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
											<td width="95"><div id="div_dir">Trade Bound</div></td>
											<td width="80">
												<div id="dir_cd"><script language="javascript">ComComboObject('f_conv_dir_cd', 1, 70, 1)</script></div>
												<div id="trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_trd_dir', 1, 65, 0 )</script></div>
											</td>
											<td width="20"><input type="checkbox" name="f_gubun" class="trans"></td>
											<td width="85">Trade Dir.</td>
											<td width="55">RHQ</td>
											<td width="90"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 1)</script></td>
											<td width="55">Office</td>
											<td><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 70, 1)</script></td>
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
								<td width="500"><font color="blue" >[ Contract ONLY ]</font></td>
								<td style="text-align:right;">[Unit : TEU, TEU/$, $]</td>
							</tr>
						</table>
						<!-- : ( POR ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( POR ) (E) -->
						
						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
							<tr>
								<td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_NewLaneAdd">New Lane Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
											<td>
												<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
													<tr>
														<td class="btn2_left"></td>
														<td class="btn2" name="btn_OfficeAdd">New Office Add</td>
														<td class="btn2_right"></td>
													</tr>
												</table>
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<!-- Button_Sub (E) -->
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