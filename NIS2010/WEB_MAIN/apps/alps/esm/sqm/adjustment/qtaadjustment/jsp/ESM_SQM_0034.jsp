<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0034.jsp
*@FileTitle      : QTA Edit
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.08
*@LastModifier   :  
*@LastVersion    : 1.0
* 2013.05.08  
* 1.0 Creation
* 2013.12.10 QTA Edit_Office Add 팝업 추가
* 2013.12.17 2014년 연간 판매목표 수립 지원(Trade 필수항목으로 변경)
* 2015.01.22 변경된 Quarter 표시(week에서 rev month로)에 따라 줄바꿈 생기지 않도록 미세조정
* 2015.07.24 [CSR 전환건] SQM 9개 Report내 코멘트 추가
* 2016.04.22 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.06.17 SELCMI로 접속시 IAS Trade에 대해서 Creation 가능하도록 로직 수정 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.event.EsmSqm0034Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0034Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSqm0034Event)request.getAttribute("Event");
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
<title>QTA Edit</title>
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
											<td class="btn1" id="btn_Creation" name="btn_Creation">CMCB Adjust Creation</td>
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
											<td class="btn1" id="btn_Loadexcel" name="btn_Loadexcel">Load Excel</td>
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
								<td width="380" rowspan="2" valign="top">
									<table class="search">
										<tr class="h23">
											<td width="40">Year</td>
											<td width="70"><script language="javascript">ComComboObject('f_bse_yr', 1, 60, 0, 1)</script></td>
											<td width="45">Quarter</td>
											<td width="60"><script language="javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 0, 1 )</script></td>
											<td class='sm' colspan=4><div id="div_period_based_on_rev_month"></div></td>
										</tr>
										<tr class="h23">
											<td width="40">Month</td>
											<td width="70"><script language="javascript">ComComboObject('f_to_mon', 1, 60, 0)</script></td>
											<td width="45">Week</td>
											<td width="60"><script language="javascript">ComComboObject('f_to_wk', 1, 50, 0)</script></td>
											<td width="150">
												<table>
												 <td>
												 	<b>VVD</b>
												 </td>
												 <td>
												 	<input type="text" style="width:38; ime-mode:disabled" name="f_vsl_cd" class="input" maxlength="4" dataformat="engup">
												 </td>
												 <td>
												 	<input type="text" style="width:38; ime-mode:disabled" name="f_skd_voy_no" class="input" maxlength="4" dataformat="int">
												 </td>
												 <td>
												 	<input type="text" style="width:23; ime-mode:disabled" name="f_skd_dir_cd" class="input" maxlength="1" dataformat="engup">
												 </td>
												</table>
											</td>
											<!-- <td width="40"><input type="text" style="width:38; ime-mode:disabled" name="f_vsl_cd" class="input" maxlength="4" dataformat="engup"></td>
											<td width="40"><input type="text" style="width:38; ime-mode:disabled" name="f_skd_voy_no" class="input" maxlength="4" dataformat="int"></td>
											<td><input type="text" style="width:23; ime-mode:disabled" name="f_skd_dir_cd" class="input" maxlength="1" dataformat="engup"></td> -->
										</tr>
									</table>
								</td>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="76">Office View</td>
											<td width="83"><script language="javascript">ComComboObject('f_ofc_vw_cd', 1, 75, 0, 1)</script></td>
											<td width="51">RHQ</td>
											<td width="80"><script language="javascript">ComComboObject('f_rhq_cd', 1, 70, 0)</script></td>
											<td width="80">Office</td>
											<td width="74"><script language="javascript">ComComboObject('f_rgn_ofc_cd', 1, 65, 0)</script></td>
											<td width="100">&nbsp;&nbsp;Portion &nbsp;&nbsp;Connected</td>
											<td><script language="javascript">ComComboObject('f_sqm_cng_tp_cd', 1, 70, 0)</script></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td>
									<table class="search">
										<tr class="h23">
											<td width="72">Trade</td>
											<td width="83"><script language="javascript">ComComboObject('f_trd_cd', 1, 75, 1, 1)</script></td>
											<td width="49">R/Lane</td>
											<td width="78"><script language="javascript">ComComboObject('f_rlane_cd', 1, 70, 0)</script></td>
											<td width="76"><div id="div_dir">Lane Bound</div></td>
											<td width="75"><div id="dir_cd"><script language="javascript">ComComboObject('f_dir_cd', 1, 65, 0 )</script></div>
											<div id="trd_dir" style="display:none;"><script language="javascript">ComComboObject('f_trd_dir', 1, 65, 0 )</script></div></td>
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
								<td>
									<table class="search_sm2">
										<tr class="h23">
											<td><input type="checkbox" name="f_decimal_flg" value="Y" class="trans">&nbsp;Decimal G.RPB</td>
										</tr>	
									</table>
								</td>
								<td>
									<table width="130" class="search">
										<tr>
											<td class="gray" height="19" id="sheet_unit">[Unit: TEU, TEU/$, $]</td>
										</tr>
									</table>
								</td>
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
													<!-- <td class="btn2_left"></td>
													<td class="btn2" name="btn_ofcAdd">IAS Office Add</td>
													<td class="btn2_right"></td> -->
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
			    	<!-- Button_Sub (E) -->		
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