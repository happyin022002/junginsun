<% 
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : ESM_BKG_0103.jsp
	 *@FileTitle : Booking Status Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.05.13
	 *@LastModifier : 김경섭
	 *@LastVersion : 1.0  
	 * 2009.05.13 김경섭
	 * 1.0 Creation
	 * -------------------------------------------------------
	 * History
	 * 2011.02.14 변종건 [CHM-201108913-01] [BKG] Booking Status Report보완요청-Page Break,SPECIAL화물구분자 및 CNTR-TYPE./SIZE표기
	 * 2011.07.08 김영철 [CHM-201111970] [BKG]Booking status report 기능 보완
	 * 2013.03.11 김진주 [CHM-201322943] [Invalid VVD 추가] - Booking status report
	 * 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
	 * 2014.06.18 조인영 [CHM-201430731] BKG Status Report에 POL 이나 BKG OFFICE가 US/CA Country에 속하는 경우 1달동아 조회토록 로직 보완
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0103Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0103Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의  건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0103Event) request.getAttribute("Event");
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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	var paramReportName="<%=rpt_nm%>";
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>

<!-- OUTER - POPUP (S)tart -->
<table width="980" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
<!--Page Title, Historical (E)-->
 <!-- : ( Search Options ) (S) -->
		

	<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" style="width:998;" > 
     		<tr><td width="100%">
					<script language="javascript">ComTabObject('tab1')</script>
					<!-- img src="/img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td></tr>
		</table>
		
		
		
		<div id="bkgOfcList" style="position: absolute; display: none;" style="margin-top:220px;margin-left:200px;">

			<table border="0" style="width:130; background-color:white; " class="grid3">	
		    	<td>
				<div>
            		<script language="javascript">ComSheetObject('multiOfc');</script>
             	</div>
             	</td>
			</table>

			<table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
           		<tr><td class="btn2_left"></td>
      				 <td class="btn2" id="ofc_list_add" name="ofc_list_add">&nbsp;Add&nbsp;</td>
       				 <td class="btn2_right"></td>
					<td class="btn2_left"></td>
      				 <td class="btn2" id="ofc_list_del" name="ofc_list_del">Delete</td>
       				 <td class="btn2_right"></td>
				</tr>
			</table>
		</div>
		<!-- Tab ) (E) -->
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
					<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0"></table> 
					<table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_ReportTemplate">Report&nbsp;Template</td>
						<td class="btn2_right"></td> 
						</tr>
					</table>
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
<input type="hidden" name="p_report_type" value="">				
<input type="hidden" name="p_grid_type" value="G">				
<input type="hidden" name="curr_page"      value="1">				
<input type="hidden" name="rows_per_page"      value="50">
<input type="hidden" name="last_orderby"      value="">				
<input type="hidden" name="orderby"      value="pol_cd,del_cd">				
<input type="hidden" name="orderby_title_sql"      value="">
<input type="hidden" name="vis_flg"      value="Y">
<input type="hidden" name="b_ofc_cd" value="">
				
			<tr><td valign="top" width="540" style="padding-right:15;">	
					
									
										<!--  biz_2  (S) -->
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="40">&nbsp;&nbsp;VVD </td>
											<td width="200" class="sm" colspan="3"><input type="text" style="width:80;" class="input1"  name="vvd_cd" value=""  maxlength='9'  required fullfill  dataformat='engupnum' style="ime-mode:disabled">&nbsp;&nbsp;
										    <img src="img/btns_search.gif" name='btn_0019Pop' width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
											<td width="80">Lane</td>
											<td width="110"><input type="text" style="width:80;" class="input" name="lane_cd" value=""  maxlength='3'  dataformat='engupnum' style="ime-mode:disabled"></td>
											<td width="20">Dir</td>
											<td width="" align="right"><script language="javascript">ComComboObject('dir_cd', 1, 57, '');</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr> 
										<tr class="h23">
											<td>&nbsp;&nbsp;POL</td>
											<td class="sm" colspan="3">
												<table cellspacing='0' cellpadding='0' border='0'>
												<tr>
													<td><input type="text" style="width:50" value="" name="pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">&nbsp<input type="text" style="width:25" value="" class="input" name="pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
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
													<td><input type="text" style="width:50" value="" name="pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input">&nbsp;<input type="text" style="width:25" value="" class="input" name="pod_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled"></td>
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
											<td><input type="text" style="width:50;" class="input" name="por_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value=""></td>
											<td><table><tr class="h23"><td style='padding-right:5px'>DEL</td><td><input type="text" style="width:50;" class="input" name="del_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" value=""></td></tr></table></td>
											<td></td>
											<td>R/D Term</td>
											<td colspan="3"><script language="javascript">ComComboObject('r_term', 1, 49, '' );</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->&nbsp;&nbsp;
															<script language="javascript">ComComboObject('d_term', 1, 49, '' );</script>&nbsp;<!-- <img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr> 
										  <tr class="h23">
											<td colspan="2">
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
											<td><script language="javascript">ComComboObject('deli_mode', 1, 49, '');</script>
											<td>MTY RTN ECC</td>
											<td colspan="3" ><input type="text" style="width:120;" class="input" name="mty_rtn_ecc" value=""  maxlength='5'  dataformat='engupnum' style="ime-mode:disabled">
							                  <img src="img/btns_multisearch.gif" name="btns_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('mty_rtn_ecc')"></td>
										 </tr>
										</table>
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">1st VVD ETD</td>
											<td width="225" >
											  <input type="text" style="width:80" value="" class="input1"  name="board_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="board_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_board_date">
<!-- 											<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
											</td>
											<td width="30">BS</td>
											<td><script language="javascript">ComComboObject('blck_stwg_cd', 1, 80, 1);</script></td>
										</tr>
										</table>						
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Booking Date</td>
											<td width="225" >
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="bkg_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_bkg_date">
						
											<!-- <input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:80" class="input1" value="2006-04-05">&nbsp;<img class="cursor" src="./img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"> -->
											</td>
											<td width="90">Booking Kind</td>
											<td>
											<script language="javascript">ComComboObject('bkg_kind', 1, 49, '' );</script>
											
											<!-- <input type="text" style="width:50;" class="input" value=" All">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->
											</td></tr>
										</table>				
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">Last VVD ETA</td>
											<td width="225" >
											  <input type="text" style="width:80" value="" class="input1"  name="eta_from_dt"  maxlength='10' dataformat="ymd" >
											 &nbsp;~&nbsp;
											  <input type="text" style="width:80" value="" class="input1"  name="eta_to_dt"  maxlength='10' dataformat="ymd" >
											  <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_eta_date">
											<td width="90">RHQ</td>
											<td>
											<script language="javascript">ComComboObject('rct_rhq_cd', 1, 80, '' );</script>
											</td></tr>
										</table>				
										
										
										<table class="search" border="0" style="width:100%;"> 
										<tr class="h23">
											<td width="95">BKG Office(<span id="b_ofc_cd_cnt" caption="BKG OFC LIST" dataformat="text"></span>)</td>
											<td width="110" class="sm"><input type="text" style="width:50" value="" class="input" name="b_ofc_cd_1" maxlength='6' dataformat='engup' style="ime-mode:disabled">&nbsp;&nbsp;Sub<input type="checkbox" class="trans" name="b_ofc_cd_sub" value="N" onClick="javascript:changeOfcCdSubManual(this)"></td>
											
	                                		<td width="115">
	                                			<table width="100" border="0" cellpadding="0" cellspacing="0" class="button">
			                                		<tr><td class="btn2_left"></td>
			                               				 <td class="btn2" id="btn_multi_ofc" name="btn_multi_ofc">Multi Office.</td>
			                               				 <td class="btn2_right"></td>
			                                		</tr>
			                                	</table>
			                                </td>
											
											<td width="75">BKG Staff</td>
											<td width="90">
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
											<td width="168" style="padding-left:2">
												<script language="javascript">ComComboObject('eq_type', 1, 60, true, '');</script>
												<!-- <input type="text" style="width:30;" class="input" value=" D4">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> -->
											</td>
											<td width="76">Commodity</td>
											<td><input type="text" style="width:70;" class="input" maxlength='6' dataformat='num' name="cmdt_cd" style="ime-mode:disabled" value="">
											    <input type="text" style="width:87;" class="input2" value="" name='cmdt_nm' readonly>
											   <img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_commodity_pop"></td></tr>					
											    <input type="hidden" style="width:87;" class="input2" value="" name='rep_cmdt_cd' readonly>
										</table>

										<table class="search" border="0" style="width:100%;">
										<tr class="h23">
											<td width="90">Weight</td>
											<td width="194" class="sm"><input type="text" style="width:60" class="input" maxlength='5' dataformat='num' name="wgt_from" value="">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" style="width:60" class="input" maxlength='5' dataformat='num'  name="wgt_to" value="">&nbsp;Ton</td>
											<td width="52">S/O No.</td>
											<td><input type="text" style="width:80;" class="input" maxlength='20'  dataformat='engupnum'  name="so_no"  value=""></td></tr>
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
											<td width="380" colspan="2" rowspan="2">
												
												<table border="0" style="width:380;" class="search_sm"> 
												<tr class="h23">
													<td width="145" style="font-size:12;" class="stm">
														<input type="radio" class="trans" name="ctr_rfa_cd" value="C" checked>S/C
														<input type="radio" class="trans" name="ctr_rfa_cd" value="R">RFA
														<input type="radio" class="trans" name="ctr_rfa_cd" value="T">TAA
													</td>
													<td width="">
														<input type="text" style="width:90;" class="input" maxlength='20' dataformat='engupnum' name="ctr_rfa_no" style="ime-mode:disabled" value="">
														&nbsp;<!--<img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_ctr_fra_pop">
												--></td>
													<td>Rate Check
														<select class="input" style="width:40;" name="rate_check">
									                    	<option value="" selected></option>
									                      	<option value="Y">Y</option>
									                      	<option value="N">N</option>
									                    </select>
													</td>
												</tr>
												</table>
														
														
											</td>
											<td>S/Mode</td>
											<td align="right">
											<table>
											<tr>
												<td><script language="javascript">ComComboObject('s_mode_ori', 1, 50, true, '');</script></td>
												<td><script language="javascript">ComComboObject('s_mode_dest', 1, 50, true, '');</script></td>
											</tr>
											</table>
											<!-- <input type="text" style="width:40;" class="input" value=" CIP">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:40;" class="input" value=" CLO">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr>
										<tr class="h23">
											<td width="60">S/Route</td>
											<td align="right">
											<table>
											<tr>
												<td><script language="javascript">ComComboObject('s_route_ori', 1, 50, true, '');</script></td>
												<td><script language="javascript">ComComboObject('s_route_dest', 1, 50, true, '');</script></td>
											</tr>
											</table>
											<!-- <input type="text" style="width:40;" class="input" value=" AE">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;<input type="text" style="width:40;" class="input" value=" AF">&nbsp;<img src="./img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle"> --></td></tr>
										</table>		
										<table style="height:3;"><tr><td></td></tr></table>		
										<!-- Cargo Type (S) -->
										<table  class="search" border="0" style="width:100%;">
											<tr><td>
																		
											<table border="0" style="width:100%;"> 
											<tr class="h23"><td>
													<table class="search" border="0" style="width:100%;"> 
													<tr class="h23">
														<td width="50" rowspan="2">Booking Status</td>	
														<td class="sm"><input type="checkbox" class="trans" name="bkg_sts_cd_f" value="F">F-Firm&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_x" value="X">X-Cancel&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_a" value="A">A-Pseudo Booking&nbsp;
																	   <input type="checkbox" class="trans" name="bkg_sts_cd_i" value="I">Invalid VVD</td></tr>
													<tr class="h23">
														<td class="sm"><input type="checkbox" class="trans" name="bkg_sts_cd_w" value="W">W-Waiting&nbsp;(<input type="checkbox" class="trans" name="non_sp_cargo" value="Y">Non approval of special cargo &nbsp;&nbsp;<input type="checkbox" class="trans" name="holding" value="Y">Holding)</td>
													</tr>
													</table>
												</td></tr>
											</table>
											<table style="height:1;"><tr><td>&nbsp;</td></tr></table>										
											</td>
											<td>
											<table border="0" style="width:100%;"  class="search" > 
											<tr class="h23"><td>
													<table class="search" border="0" style="width:100%;" > 
													<tr class="h23">
													    <td width="170" >Web Upload Status
														<select name="web_upd_sts" style="width:47;">
															<option value="" selected></option>
															<option value="B">BKG</option>
															<option value="S">S/I</option>
															</select></td>
													</tr>
													<tr>
														<td class="sm">&nbsp;&nbsp;(<input type="checkbox" class="trans" name="web_sts_cd_a" value="Y" >Auto&nbsp;&nbsp;
																	   <input type="checkbox" class="trans" name="web_sts_cd_m" value="N">Manual)
														</td></tr>
													</table>
												</td></tr>
											</table>
											</td>
											</tr>

											<tr>
											<td colspan="2">
												<table border="0" style="width:100%;" class="search_sm"> 
												<tr class="h23">
												<td>
														<table class="search" border="0" style="width:100%;"> 
														<tr class="h23">
															<td width="100" rowspan="2">No Rate Status</td>	
															<td class="sm"><input type="checkbox" class="trans" name="non_rd_sts_f" value="F">F-Firm&nbsp;&nbsp;<br>
																		   <input type="checkbox" class="trans" name="non_rd_sts_r" value="R">R-No Rate</td>
															<td width="100" rowspan="2">Standby Status</td>	
															<td class="sm"><input type="checkbox" class="trans" name="aloc_sts_cd_f" value="F">F-Firm&nbsp;&nbsp;<br>
																		   <input type="checkbox" class="trans" name="aloc_sts_cd_s" value="S">S-Standby</td>
														</table>
												</td>
												</table>
											</td>	
											</tr>
															
											<tr>
											<td colspan="2">
												<table border="0" style="width:100%;" class="search_sm"> 
												<tr class="h23">
												<td>
														<table class="search" border="0" style="width:100%;"> 
															<tr class="h23">
															<td width="100" >Spot Guide RFA</td>	
															<td class="sm"><td class="sm"><input type="checkbox" class="trans" name="spot_guide_rfa_no" value="SGR"><br></td>
														
															<td width="100"  >Master RFA</td>	
															<td class="sm"><td class="sm"><input type="checkbox" class="trans" name="master_rfa_no" value="M"><br></td>
															
															<td width="100" >Basic RFA</td>	
															<td class="sm"><td class="sm"><input type="checkbox" class="trans" name="basic_rfa_no" value="B"><br></td>		
															</tr>														   
														</table>
												</td>
												</tr>
												</table>
											</td>
											</tr>
											</table>
											
											<table style="height:1;"><tr><td>&nbsp;</td></tr></table>
											<table>
											<tr>
											<td>
												<table class="search" border="0" style="width:100%;">										
													<tr class="h23">
														<td width="110">Contract change</td>	
														<td><script language="javascript">ComComboObject('ctrt_cng_tp_cd', 1, 120, true, '');</script></td>
													</tr>
												</table>
											</td>
											<td width="20">&nbsp;</td>
											<td>
												<table class="search" border="0" style="width:100%;">										
													<tr class="h23">
														<td width="140">OFT Change after PCT</td>	
														<td><script language="javascript">ComComboObject('rtro_knd_cd', 1, 130, true, '');</script></td>
													</tr>
												</table>
											</td>											
											</tr>											
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
													<td class="sm"><input type="text" style="width:80;" class="input2"   name="fv_vvd_cd" value=""  maxlength='9'dataformat='engupnum' style="ime-mode:disabled">&nbsp;<!-- <input type="text" style="width:25;" class="input2" value=" D"> --></td></tr> 
												<tr class="h23">
													<td width="37">&nbsp;&nbsp;POL</td>	
													<td width="170" class="sm">
														<input type="text" style="width:50" value="" name="fv_pol_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input2">&nbsp
														<input type="text" style="width:25" value="" class="input2" name="fv_pol_yard_cd" maxlength='2' dataformat='engupnum' style="ime-mode:disabled">
														&nbsp;<input type="checkbox" class="trans" name="fv_pol_local" value="Y">Local
													</td>
													<td width="30">POD</td>
													<td class="sm">
														<input type="text" style="width:50" value="KRKAN" name="fv_pod_cd" maxlength='5' dataformat='engupnum' style="ime-mode:disabled" class="input2">&nbsp
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
													<td width="32"><input type="text" style="width:32;" class="input" name="cust_cnt_cd" value=""  maxlength='2'  dataformat='engup' style="ime-mode:disabled" onChange="javascript:changeCustomerValue(this)"></td>
													<td width="190"><input type="text" style="width:55;" class="input" maxlength='6' dataformat='num' name="cust_seq" style="ime-mode:disabled"  value="" onChange="javascript:changeCustomerValue(this)">&nbsp;<input type="text" style="width:100;" class="input"  maxlength='50' dataformat='custname' name="cust_nm" value="" readonly>&nbsp;<img src="./img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_customer_pop"></td>
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
												<col width="19%" /><col width="19%" /><col width="19%" /><col width="19%" /><col width="*" />
												<tr class="h23">
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_dg" value="Y">Danger</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_rf" value="Y">Reefer</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_ak" value="Y">Awkward</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_bb" value="Y">Break Bulk</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_fu" value="Y">Fumigation</td>
													</tr>
												<tr class="h23">
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_hg" value="Y">Hanger</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_soc" value="Y">S.O.C</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_eq" value="Y">EQ Sub</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_rd" value="Y">Reefer Dry</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_li" value="Y">Hide Liner</td>
													</tr>
												<tr class="h23">
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_pc" value="Y">Pre-caution</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_fg" value="Y">Food Grade</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_hd" value="Y">Hide</td>
													<td class="sm"><input type="checkbox" class="trans" name="sp_cargo_rb" value="Y">Rail Bulk</td>
													<td class="sm">Genset
													<select name="sp_cargo_ge" style="width:50;">
														<option value="" selected>All</option>
														<option value="Y">Y</option>
														<option value="N">N</option>
														</select></td>
													</tr> 
												<tr class="h23">
													<td class="sm" ><input type="checkbox" class="trans" name="sp_vehicle" value="Y">Vehicle</td>
													<td class="sm" colspan="4"><input type="checkbox" class="trans" name="non_dg_chem_flg" value="Y">Non DG Chem.</td>
													</tr>
																											
												</table>
											</td></tr>
										</table>
										
										<table style="height:5;"><tr><td></td></tr></table>
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
													<td width="65">Attachment</td>	
													<td  class="sm"><input type="checkbox" class="trans" name="certi_d" value="D">D/G Rider&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_a" value="A">A/K Rider&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_b" value="B">B/B Rider&nbsp;</td>
													<td width="" class="sm" style="background-color:#FFFFFF" rowspan='2'><input type="checkbox" class="trans" name="certi_y" value="Y">Yes&nbsp;
													                        <input type="checkbox" class="trans" name="certi_n" value="Y">No</td>
													</tr>
													<tr>
													<td></td>	
													<td  class="sm"><input type="checkbox" class="trans" name="certi_g" value="G">General&nbsp;</td>
													<td  class="sm"><input type="checkbox" class="trans" name="certi_c" value="C">Certificate&nbsp;</td>
													<td  class="sm"></td>
													</tr>
												</table>
												<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
												<table class="search" border="0" style="width:100%;"> 
												<tr class="h23">
													<td width="90">B/L Certificate</td>	
													<td class="sm" colspan="3"><input type="checkbox" class="trans" name="bl_certi" value="Y"></td>
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



<!--Button (S) -->
				<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
					<tr>
						<td class="btn1_bg">
						
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
									<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_Sort">Sort</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>									
									<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0"
										class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_New">New</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
									</td>
								</tr>
							</table>

				</td>
					</tr>
				</table>
		<!--Button (E) --> 
	
	
<!--TAB Search (E) -->					
</div>

<!-- PAGE Result (S) -->

<div id="tabLayer" style="display:none">
  <table class="search"> 
       	<tr><td class="bg">
			
				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					<td>
				<!--Grid (S)-->
					<table width="978"  id="mainTable">
						<tr>
							<td width="100%">
									<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<table style="height:5;"><tr><td></td></tr></table>
					<!--Grid (E)-->
				<table border="0" style="width:979"> 
				<tr class="h23">
					<td width="95">No. of Booking</td>
					<td width="60"><input type="text" style="width:40;text-align:right;padding-right: 5px"  class="input" ID="total_bkg" value=""></td> 
					<td width="65">No. of B/L</td>
					<td width="60"><input type="text" style="width:40;text-align:right;padding-right: 5px" class="input" ID="total_bl" value=""></td> 
					<td width="25">TEU</td>
					<td width="75"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_teu" value=" "></td> 
					<td width="25">FEU</td>
					<td width="75"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_feu" value=""></td>
					<td width="55">TOT TEU</td>
					<td width="75"><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_all_teu" value=""></td>					 
					<td width="28">MEA</td>
					<td width="77"><input type="text" style="width:67;text-align:right;padding-right: 5px" class="input" ID="total_mea" value=""></td> 
					<td width="40">CBM </td>
					<td width="80">Weight(TON)</td>
					<td width=""><input type="text" style="width:60;text-align:right;padding-right: 5px" class="input" ID="total_wgt" value=""></td>
				</tr>
				</table>
				
				<table border="0" style="width:979"> 
				<tr>
					<td align="left" bgcolor="#E9E9E9">
					<div id='options' style="padding:5 10 5 10;width: 100%;font-size:11px;height:40px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
					</div>
					</td>
					</tr>
				</table>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	    </td></tr>
</table>


			<!--  Button_Sub (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn2_bg">
				
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>					
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Sort">Sort</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>	
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Total">Total Sum Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Preview">Print View</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Page_Break_Preview">Print View with Page break</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td style="display:none">
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Print">Print</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) --> 		
</div>
<div id="downSheet" style="display:none">
	<script language="javascript">ComSheetObject('sheet2');</script>
</div>
<div id="downSheet_ak" style="display:none">
	<script language="javascript">ComSheetObject('ak');</script>
</div>
<div id="downSheet_bb" style="display:none">
	<script language="javascript">ComSheetObject('bb');</script>
</div>
<div id="downSheet_dg" style="display:none">
	<script language="javascript">ComSheetObject('dg');</script>
</div>
<div id="downSheet_rf" style="display:none">
	<script language="javascript">ComSheetObject('rf');</script>
</div>
<div id="downSheet_cntr" style="display:none">
	<script language="javascript">ComSheetObject('cntr');</script>
</div>
<!-- PAGE Result (E) -->
		<!-- ********************************************************************************************************************** -->

<div id="tabLayer" style="display:none">
  <table class="search"> 
       	<tr><td class="bg">
			
				<table class="search" border="0" style="width:958;"> 
				<tr class="h23">
					<td>
				<!--Grid (S)-->
					<table width="978"  id="mainTable">
						<tr>
							<td width="100%">
									<script language="javascript">ComSheetObject('summary');</script>
							</td>
						</tr>
					</table>
					<table style="height:5;"><tr><td></td></tr></table>
					<!--Grid (E)-->
				<table border="0" style="width:979"> 
				<tr>
					<td align="left" bgcolor="#E9E9E9">
					<div id='options_summary' style="padding:5 10 5 10;width: 100%;font-size:11px;height:40px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
					</div>
					</td>
					</tr>
				</table>
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
	    </td></tr>
</table>


			<!--  Button_Sub (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
					cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn2_bg">
				
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_DownExcel_Summary">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>						
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve_Summary" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>						
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Sort">Sort</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				
				</td>
			</tr>
		</table>
		<!-- Button_Sub (E) --> 		
</div>

<div id="downSheet_options" style="display:none">
	<script language="javascript">ComSheetObject('search_options');</script>
</div>
<div id="downSheet_loc" style="display:none">
	<script language="javascript">ComSheetObject('locsheet');</script>
</div>

</td></tr>
</table> 
<div style='position:absolute;top:200px;left:1px'>
	<input type="text" name="temp_input" id='temp_input' value="" style="width:1px;height:1px">
</div>
	<!-- 레포트  팝업  -->
<form name="form2" method="post">
    <input type="hidden" name="rfn">
    <input type="hidden" name="mrd">
    <input type="hidden" name="rd_title">
    <input type="hidden" name="rp">
    <input type="hidden" name="rv">
    <input type="hidden" name="print_type">
</form>
<iframe name="hidden_frame" height="1" width="1"></iframe>	
</body>
</html>
