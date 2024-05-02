
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0104.jsp
	 *@FileTitle : Report Template
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * 2013.03.11 김진주 [CHM-201322943] [Invalid VVD 추가] - Booking status report
	 * 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); 
	String edit_yn = JSPUtil.getNull(request.getParameter("edit_yn"));
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0104Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
 paramReportName="<%=rpt_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="./img/icon_title_dot.gif" align="absmiddle">&nbsp;Booking Status Report</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		<!-- ********************************************************************************************************************** -->

<!--TAB Search (S) -->
<div id="tabLayer" style="display:inline">
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
				
			<!-- grid box -->
			<table class="search" border="0" style="width:979;"> 
			<tr><td colspan="2">	

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<form method="post" name="tempform" onSubmit="return false;"> 
				<tr class="h23">
					<td width="90">&nbsp;&nbsp;Report Type</td>
					<td width="250"><script language="javascript">ComComboObject('report_type', 1, 240, '');</script></td>
					<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0"></table><!-- 
					<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_ReportTemplate"><a href="http://nis2010.hanjin.com/nis2010/grid/apps/nis2010/bkg/jsp/UI_BKG_0104.jsp" target="_blank">Report&nbsp;Template</a></td>
								<td class="btn2_right"></td> 
								</tr>
								</table>
					-->			
					</td>
					</tr>
					</form>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				</td></tr>
			<!-- ********************************************* Form Start  ********************************************* -->	
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="p_bkg_rpt_knd_cd" value="B">				
<input type="hidden" name="edit_yn" value="<%= edit_yn %>">
			<tr><td valign="top" width="540" style="padding-right:25;">	
					
									
										<!--  biz_2  (S) -->
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="40">&nbsp;&nbsp;VVD</td>
											<td width="200" class="sm" colspan="3"><input type="text" style="width:80;" class="input1"  name="vvd_cd" value=""  maxlength='9'  required fullfill  dataformat='engupnum' style="ime-mode:disabled">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
											<td width="80">Lane</td>
											<td width="110"><input type="text" style="width:80;" class="input" name="lane_cd" value=""  maxlength='3'  dataformat='engup' style="ime-mode:disabled"></td>
											<td width="20">Dir</td>
											<td width="" align="right"><script language="javascript">ComComboObject('dir_cd', 1, 57, '');</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr> 
										<tr class="h23">
											<td>&nbsp;&nbsp;POL</td>
											<td class="sm" colspan="3">
												<table cellspacing='0' cellpadding='0' border='0'>
												<tr>
													<td><input type="text" style="width:50" value="" name="pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">&nbsp<input type="text" style="width:25" value="" class="input" name="pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
													<td>&nbsp;(</td>
													<td><input type="checkbox" class="trans" name="pol_local" value="Y"> </td>
													<td>Local&nbsp;</td>
													<td><input type="checkbox" class="trans" name="pol_ts" value="Y"></td>
													<td>T/S)</td>
												</tr>
												</table>
											</td>
											<td>POD</td>
											<td class="sm" colspan="4">
												<table cellspacing='0' cellpadding='0' border='0'>
												<tr>
													<td><input type="text" style="width:50" value="" name="pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">&nbsp;<input type="text" style="width:25" value="" class="input" name="pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
													<td>&nbsp;(</td>
													<td><input type="checkbox" class="trans" name="pod_local" value="Y"> </td>
													<td>Local&nbsp;</td>
													<td><input type="checkbox" class="trans" name="pod_ts" value="Y"></td>
													<td>T/S)</td>
												</tr>
												</table>
													
											</td></tr> 
										<tr class="h23">
											<td>&nbsp;&nbsp;POR</td>
											<td><input type="text" style="width:40;" class="input" name="por_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" value=""></td>
											<td><table><tr class="h23"><td style='padding-right:5px'>DEL</td><td><input type="text" style="width:40;" class="input" name="del_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" value=""></td></tr></table></td>
											<td></td>
											<td>R/D Term</td>
											<td colspan="3"><script language="javascript">ComComboObject('r_term', 1, 49, '' );</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->&nbsp;&nbsp;
															<script language="javascript">ComComboObject('d_term', 1, 49, '' );</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr> 
										<tr class="h23">
											<td colspan="4">
												<table class="search_sm" border="0" style="width:81%;"> 
													<tr class="h23">
														<td>Zone</td>
														<td  class="sm">
															<select style="width: 82;" class="input" name="zone_cd">
																<option value="">All</option>
																<option value="OCN">Ocean</option>
																<option value="IPT">Inter Port</option>
																<option value="DOM">Domestic</option>
															</select>
														</td>
													</tr>
												</table>	
											</td>
											<td>Delivery Mode</td>
											<td colspan="3"><script language="javascript">ComComboObject('deli_mode', 1, 49, '');</script>
											<!-- <input type="text" style="width:30;" class="input" value=" Y">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr>
										</table>				
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">On Board Date</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="board_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="board_to_dt"  maxlength='10' dataformat="ymd" >&nbsp;
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_board_date">
						
											<!-- <input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
											</td></tr>
										</table>						
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Booking Date</td>
											<td width="280" >
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_to_dt"  maxlength='10' dataformat="ymd" >&nbsp;
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bkg_date">
						
											<!-- <input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
											</td>
											<td width="90">Booking Kind</td>
											<td align="right">
											<script language="javascript">ComComboObject('bkg_kind', 1, 49, '' );</script>
											
											<!-- <input type="text" style="width:50;" class="input" value=" All">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->
											</td></tr>
										</table>															
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Last VVD ETA</td>
											<td width="" >
											  <input type="text" style="width:80" value="" class="input1"  name="eta_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="eta_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eta_date">
											</td></tr>
										</table>		
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">BKG Office</td>
											<td width="180" class="sm"><input type="text" style="width:50" value="" class="input" name="b_ofc_cd" maxlength='6' dataformat='engup' style="ime-mode:disabled">&nbsp;&nbsp;Sub<input type="checkbox" class="trans" name="b_ofc_cd_sub" value="Y"></td>
											<td width="63">BKG Staff</td>
											<td width="120">
												<script language="javascript">ComComboObject('b_staff_id', 1, 80, '' );</script>
											<!-- <select style="width:80;" name="b_staff_id"><option value="0" selected>0060344</option></select> --></td>
											<td width="30">C/A</td>
											<td width=""><input type="checkbox" class="trans" name="ca_flag" value="Y" ></td></tr> 
										</table>
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="202">Agent Code (for China Booking)</td>
											<td class="sm">
											<input type="text" style="width:75" value="" class="input" name="agent_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled">
											&nbsp;&nbsp;<input type="checkbox" class="trans" name="agent_cd_all" value="Y">All</td></tr>
										</table>				
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="90">EQ TP/SZ</td>
											<td width="170">
												<script language="javascript">ComComboObject('eq_type', 1, 60, true, '');</script>
												<!-- <input type="text" style="width:30;" class="input" value=" D4">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->
											</td>
											<td width="76">Commodity</td>
											<td><input type="text" style="width:80;" class="input" maxlength='6' dataformat='num' name="cmdt_cd" style="ime-mode:disabled" value="">&nbsp;
											    <input type="text" style="width:87;" class="input2" value="" name='cmdt_nm' readonly>&nbsp;
											   <img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_commodity_pop"></td></tr>					
											    <input type="hidden" style="width:87;" class="input2" value="" name='rep_cmdt_cd' readonly>
										</table>				
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="90">Weight</td>
											<td width="194" class="sm"><input type="text" style="width:60" class="input" maxlength='5' dataformat='num' name="wgt_from" value="">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:60" class="input" maxlength='5' dataformat='num'  name="wgt_to" value="">&nbsp;Ton</td>
											<td width="52">S/O No.</td>
											<td><input type="text" style="width:80;" class="input" maxlength='20' dataformat='num'  name="so_no"  value=""></td></tr>
										</table>
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="90">L/Office</td>
											<td width="195" class="sm"><input type="text" style="width:80;" class="input"  maxlength='6' dataformat='engup'  name="l_ofc_cd" value="">&nbsp;&nbsp;Sub <input type="checkbox" class="trans" name="l_ofc_cd_sub" value="Y"></td>
											<td width="53">L/Team</td>
											<td width="63"><script language="javascript">ComComboObject('l_team_cd', 1, 55, '' );</script></td>
											<td width="40">L/Rep.</td>
											<td align="right">
											<script language="javascript">ComComboObject('l_rep_id', 1, 80, '' );</script>
											<!-- <select style="width:80;"><option value="0" selected>0060344</option></select> --></td>
										<tr class="h23">
											<td>C/Office</td>
											<td class="sm" colspan="3"><input type="text" style="width:80;" class="input" maxlength='6' dataformat='engup' style="ime-mode:disabled" name="c_ofc_cd" value="">&nbsp;&nbsp;Sub <input type="checkbox" class="trans" name="c_ofc_cd_sub"></td>
											<td>C/Rep.</td>
											<td align="right"><input type="text" style="width:80;" class="input"  name="c_rep_id" value=""  maxlength='20'  dataformat='engupnum' style="ime-mode:disabled"></td>
										</table>
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="360" colspan="2" rowspan="2">
												
												<table border="0" style="width:360;" class="search_sm"> 
												<tr class="h23">
													<td width="150" style="font-size:12;" class="stm">
														<input type="radio" class="trans" name="ctr_rfa_cd" value="C" checked>S/C&nbsp;<input type="radio" class="trans" name="ctr_rfa_cd" value="R">RFA
														&nbsp;<input type="radio" class="trans" name="ctr_rfa_cd" value="T">TAA
													</td>
													<td width="">
														<input type="text" style="width:90;" class="input" maxlength='20' dataformat='engupnum' name="ctr_rfa_no" style="ime-mode:disabled" value="">
														&nbsp;<!--<img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_ctr_fra_pop">
												--></td>
													<td>
														<input type="checkbox" class="trans" name="rate_check" value="F">Rate Check
													</td>
												</tr>
												</table>	
											</td>
											<td>S/Mode</td>
											<td align="right">
											<table>
											<tr>
												<td><script language="javascript">ComComboObject('s_mode_ori', 1, 60, true, '');</script></td>
												<td><script language="javascript">ComComboObject('s_mode_dest', 1, 60, true, '');</script></td>
											</tr>
											</table>
											<!-- <input type="text" style="width:40;" class="input" value=" CIP">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:40;" class="input" value=" CLO">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr>
										<tr class="h23">
											<td width="60">S/Route</td>
											<td align="right">
											<table>
											<tr>
												<td><script language="javascript">ComComboObject('s_route_ori', 1, 60, true, '');</script></td>
												<td><script language="javascript">ComComboObject('s_route_dest', 1, 60, true, '');</script></td>
											</tr>
											</table>
											<!-- <input type="text" style="width:40;" class="input" value=" AE">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:40;" class="input" value=" AF">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr>
										</table>		
											<table style="height:7;"><tr><td></td></tr></table>		
										<!-- Cargo Type (S) -->
											<table border="" style="width:100%;" class="search_sm"> 
											<tr class="h23"><td>
											
													
													<table class="search" border="0" style="width:100%;"> 
													<tr class="h23">
														<td width="90" rowspan="2">Booking Status</td>	
														<td class="sm"><input type="checkbox" class="trans" name="bkg_sts_cd_f" value="F">F-Firm&nbsp;&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_x" value="X">X-Cancel&nbsp;&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_a" value="A">A-Pseudo Booking&nbsp;&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_i" value="I">Invalid VVD</td></tr>
													<tr class="h23">
														<td class="sm"><input type="checkbox" class="trans" name="bkg_sts_cd_w" value="W">W-Waiting &nbsp;&nbsp;(<input type="checkbox" class="trans" name="non_sp_cargo" value="Y">Non approval of special cargo &nbsp;&nbsp;<input type="checkbox" class="trans" name="holding" value="Y">Holding)</td>
														</tr>
													</table>
													
													
												</td></tr>
											</table>
											<!-- Cargo Type (E) -->			
										
										<!--  biz_2   (E) -->
				
				
				</td>
				
				<td valign="top" width="439">	
										
										<!-- Feeder Vessel (S) -->
										<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Feeder Vessel</td></tr>
										</table>
									
										<table border="0" style="width:100%;" class="search_sm"> 
										<tr class="h23"><td>
										
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td colspan="2"><input type="radio" class="trans" name="fv_pre_pst_cd" value="PR">&nbsp;Pre&nbsp;&nbsp;&nbsp;
													                <input type="radio" class="trans" name="fv_pre_pst_cd" value="PO">&nbsp;Post&nbsp;&nbsp;&nbsp;</td>
													<td>VVD</td>
													<td class="sm"><input type="text" style="width:80;" class="input2"   name="fv_vvd_cd" value=""  maxlength='9'dataformat='engupnum' style="ime-mode:disabled" value=" HJSF0001W">&nbsp;<!-- <input type="text" style="width:25;" class="input2" value=" D"> --></td></tr> 
												<tr class="h23">
													<td width="37">&nbsp;&nbsp;POL</td>	
													<td width="170" class="sm">
														<input type="text" style="width:50" value="" name="fv_pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input2">&nbsp
														<input type="text" style="width:25" value="" class="input2" name="fv_pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
														&nbsp;<input type="checkbox" class="trans" name="fv_pol_local" value="Y">Local
													</td>
													<td width="30">POD</td>
													<td class="sm">
														<input type="text" style="width:50" value="" name="fv_pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input2">&nbsp
														<input type="text" style="width:25" value="" class="input2" name="fv_pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
														&nbsp;<input type="checkbox" class="trans" name="fv_pod_local" value="Y">Local
														
													</td>
													</tr>
												</table>
									
											</td></tr>
										</table>
										<table style="height:8;"><tr><td></td></tr></table>
										<!-- Feeder Vessel (E) -->
										
										
										<!-- Customer (S) -->
										<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Customer</td></tr>
										</table>
									
										<table border="0" style="width:100%;" class="search_sm"> 
										<tr class="h23"><td>
										
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td class="sm" colspan="4">
														<input type="checkbox" class="trans" name="cust_tp_cd_s" value="Y">Shipper&nbsp;
														<input type="checkbox" class="trans" name="cust_tp_cd_c" value="Y">Consignee&nbsp;
														<input type="checkbox" class="trans" name="cust_tp_cd_n" value="Y">Notify&nbsp;
														<input type="checkbox" class="trans" name="cust_tp_cd_f" value="Y">Forwarder&nbsp;
														<input type="checkbox" class="trans" name="cust_tp_cd_a" value="Y">Also Notify&nbsp;
														<input type="checkbox" class="trans" name="cust_tp_cd_g" value="Y">Group</td>
													</tr>
												<tr class="h23">
													<td width="33"><input type="text" style="width:30;" class="input" name="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled"></td>
													<td width="190"><input type="text" style="width:55;" class="input" maxlength='6' dataformat='num' name="cust_seq" style="ime-mode:disabled"  value="">&nbsp;
													<input type="text" style="width:100;" class="input"  maxlength='50' dataformat='custname' name="cust_nm" value="">&nbsp;<img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_customer_pop"></td>
													<td width="92">Customer Type</td>
													<td><script language="javascript">ComComboObject('cust_tp_cd', 1, 50, true, '');</script>
													<!-- <input type="text" style="width:25;" class="input" value=" BK">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"> --></td></tr>
												</table>
									
											</td></tr>
										</table>
										
										<table style="height:8;"><tr><td></td></tr></table>
										<!-- Customer (E) -->
										
										<!-- Special Cargo (S) -->
										<table class="search" border="0">
										<tr><td class="title_h"></td>
											<td class="title_s">Special Cargo</td></tr>
										</table>
									
										<table border="0" style="width:100%;" class="search_sm"> 
										<tr class="h23"><td>
										
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_dg" value="Y">Danger</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_rf" value="Y">Reefer</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_ak" value="Y">Awkward</td>
													<td class="sm" colspan="2"><input type="checkbox" class="trans" name="sp_cargo_bb" value="Y">Break Bulk</td></tr>
												<tr class="h23">
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_hg" value="Y">Hanger</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_soc" value="Y">S.O.C</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_eq" value="Y">EQ Sub</td>
													<td class="sm" colspan="2"><input type="checkbox" class="trans" name="sp_cargo_rd" value="Y">Reefer Dry</td></tr>
												<tr class="h23">
													<!-- <td class="sm" width="20%"><input type="checkbox" class="trans" name="sp_cargo_pm" value="Y">Premier</td> -->
													<td class="sm" width="20%"><input type="checkbox" class="trans" name="sp_cargo_pc" value="Y">Pre-caution</td>
													<td class="sm" width="20%"><input type="checkbox" class="trans" name="sp_cargo_fg" value="Y">Food Grade</td>
													<td class="sm" width="20%"><input type="checkbox" class="trans" name="sp_cargo_hd" value="Y">Hide</td>
													<td class="sm" width="20%"><input type="checkbox" class="trans" name="sp_cargo_rb" value="Y">Rail Bulk</td></tr>
												</table>
									
											</td></tr>
										</table>
										
										<table style="height:8;"><tr><td></td></tr></table>
										<!-- Special Cargo (E) -->
										
										
										<!-- Cargo Type (S) -->
										<table border="0" style="width:100%;" class="search_sm"> 
										<tr class="h23"><td>
										
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td width="90">Cargo Type</td>	
													<td class="sm" colspan="3"><input type="checkbox" class="trans" name="cargo_tp_f" value="F">Full&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													                           <input type="checkbox" class="trans" name="cargo_tp_p" value="P">Empty (for E/Q reposition)&nbsp;&nbsp;&nbsp;&nbsp;
																			   <input type="checkbox" class="trans" name="cargo_tp_r" value="R">Revenue Empty</td>
													</tr>
												</table>
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td width="97">Memo B/L Type</td>	
													<td width="103" class="sm"><input type="checkbox" class="trans" name="bl_type_a" value="Y">ahead&nbsp;<input type="checkbox" class="trans" name="bl_type_s" value="Y">short</td>
													<td width="48">Revenue</td>
													<td class="sm"><input type="checkbox" class="trans" name="rev" value="Y">Revenue&nbsp;<input type="checkbox" class="trans" name="non_rev" value="Y">Non-Revenue</td>
													</tr>
												</table>
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
												
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td width="55">AES/ITN</td>	
													<td width="95" class="sm"><input type="checkbox" class="trans" name="aes_y" value="Y">Yes&nbsp;
													                          <input type="checkbox" class="trans" name="aes_n" value="Y">No</td>
													<td width="110">Stop Cargo<input type="checkbox" class="trans" name="stop_cargo" value="Y"></td>
													<td width="65">Roll Over</td>
													<td width="" class="sm"><script language="javascript">ComComboObject('ro_y', 1, 100, '');</script>
<!--														<input type="checkbox" class="trans" name="ro_y" value="Y">Yes&nbsp;-->
<!--														<input type="checkbox" class="trans" name="ro_n" value="Y">No-->
													</td>
													</tr>
												<tr class="h23">
													<td width="55">CAED</td>	
													<td width="95" class="sm"><input type="checkbox" class="trans" name="caed_y" value="Y">Yes&nbsp;
													                          <input type="checkbox" class="trans" name="caed_n" value="Y">No</td>
													<td width="110">CRN No.<input type="checkbox" class="trans" name="crn_no_flag" value="Y"></td>
													<td width="65"></td>
													<td width="" class="sm"></td>
													</tr>
												</table>
												
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
												
												<table class="search" border="0" style="width:100%;">										
													<tr class="h23">
													<td width="65">Certificate</td>	
													<td  class="sm"><input type="checkbox" class="trans" name="certi_d" value="D">D/G Ride&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_a" value="A">A/K Ride&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_b" value="B">B/B Ride&nbsp;</td>
													<td width="" class="sm" style="background-color:#FFFFFF" rowspan='2'><input type="checkbox" class="trans" name="certi_y" value="Y">Yes&nbsp;
													                        <input type="checkbox" class="trans" name="certi_n" value="Y">No</td>
													</tr>
													<tr>
													<td></td>	
													<td  class="sm"><input type="checkbox" class="trans" name="certi_g" value="G">B/L Ride&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_c" value="C">Certificate&nbsp;</td>
													<td  class="sm"></td>
													</tr>
												</table>
											</td></tr>
										</table>
					<!-- Cargo Type (E) -->
				</td></tr>
</form><!-- ********************************************* Form End  ********************************************* -->				
			</table>
			
			
		</td></tr>
		</table>			
		<!--biz page (E)-->

	
	
	
<!--TAB Search (E) -->					
</div>

		<!-- ********************************************************************************************************************** -->

		


</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	    <tr><td class="btn3_bg">
		            <table border="0" cellpadding="0" cellspacing="0">
		              <tr>
		                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					          <tr><td class="btn1_left"></td>
					           <td class="btn1" name="btn_OK">Save</td>
					             <td class="btn1_right"></td>
				              </tr>
				            </table>
				        </td>	
			            <td class="btn1_line"></td>		
			            <td class="btn3_bg">
		                   <table border="0" cellpadding="0" cellspacing="0">
		                      <tr><td>
		                             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr><td class="btn1_left"></td>
					                        <td class="btn1" name="btn_New">New</td>
					                        <td class="btn1_right"></td>
				                        </tr>
				                     </table>
				                  </td>	
				                  <!--<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Set">Set</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
					--><td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right">
							</tr>
						</table>
					</td>
			                  </tr>
		                   </table>
		                </td>
		              </tr>
		            </table>
		    </td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

			
<div style="display: none;">
 <!-- Hidden Grid -->
	<script language="javascript">ComSheetObject('sheet1');</script>
</div>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>