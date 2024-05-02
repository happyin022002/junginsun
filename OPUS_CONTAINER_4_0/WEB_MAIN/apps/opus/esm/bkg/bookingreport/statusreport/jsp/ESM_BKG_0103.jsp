<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_0103.jsp
 *@FileTitle : Booking Status Report
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/27
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0103Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0103Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server		
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	
	String cookiesJSessionId="";
	
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0103Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int loop = 0; loop < cookies.length; loop++) {
                if (cookies[loop].getName().equals("JSESSIONID")) {
                	cookiesJSessionId=cookies[loop].getValue();
				}
            }
		}
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	var paramReportName="<%=rpt_nm%>";

</script>		

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->		
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		
	</div>
	<!-- page_title_area(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn opus_design_normal2">
			   <button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Sort" 			id="btn_Sort">Sort</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>
		</div>
		<!-- opus_design_btn(E) -->	
		
		<div class="opus_design_inquiry" >
			<form method="post" name="tempform" onSubmit="return false;">  	
				<table style="width:550px" >
					<colgroup>
						<col width="90" />
						<col width="250" />
					</colgroup>
					<tbody>
					   <tr>
					   		<th >Report Type</th>
							<td><script  type="text/javascript">ComComboObject('report_type', 1, 240, '');</script><button type="button" class="btn_etc" name="btn_ReportTemplate"	id="btn_ReportTemplate">Report Template</button></td>							
						</tr>	
					</tbody>
				</table>
			</form>	
		</div>			
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
	<input type="hidden" name="jsession" id="jsession" value="<%=cookiesJSessionId %>"/>
	
			<!-- layout_wrap(S) -->
			<div class="opus_design_inquiry">
			<div class="layout_wrap mar_top_12">
				<div class="layout_vertical_2" style="width:49%;">
					<div class="opus_design_data sm" style="height:470px;">
						<table>
							<tr>
								<th style="text-align:left;">VVD</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input1" name="vvd_cd" value="" maxlength="9" id="vvd_cd" dataformat="engup"/> Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
								<th>Lane</th>
								<td><input type="text" style="width:80px;" class="input" name="lane_cd" value="" maxlength="3" id="lane_cd" dataformat="engup" /> </td>
								<th>Dir</th>
								<td><script type="text/javascript">ComComboObject('dir_cd', 1, 57, '');</script></td>
							</tr> 
							<tr>
								<th style="text-align:left;">POL</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd" maxlength="5"  class="input" id="pol_cd"  dataformat="engup"/>  <input type="text" style="IME-MODE: disabled; width:35px;" value="" class="input" name="pol_yard_cd" maxlength="2"  id="pol_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" />Local<input type="checkbox" class="trans" name="pol_ts" value="Y" id="pol_ts"/>T/S)</td>
								<th title="Port of Discharging">POD</th>
								<td colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd" maxlength="5" class="input" id="pod_cd"  dataformat="engup" />  <input type="text" style="IME-MODE: disabled; WIDTH: 35px" value="" class="input" name="pod_yard_cd" maxlength="2" id="pod_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pod_local" />Local<input type="checkbox" class="trans" name="pod_ts" value="Y" id="pod_ts" />T/S)</td>
							</tr> 
							 <tr>
								<th style="text-align:left;">POR</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="por_cd" maxlength="5" value="" id="por_cd"  dataformat="engup" /><strong>DEL</strong><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="del_cd" id="del_cd" maxlength="5" value="" dataformat="engup"></td>
								<th>R/D Term</th>
								<td colspan="3"><script type="text/javascript">ComComboObject('r_term', 1, 123, '' );</script><script type="text/javascript">ComComboObject('d_term', 1, 123, '' );</script></td>
							</tr> 
							<tr>
								<th style="text-align:left;" class="sm">Zone</th>
								<td class="sm"><%=JSPUtil.getCodeCombo("zone_cd", "", "", "CD20054", 0, "000001: :All")%></td>							
								<th>Delivery Mode</th>
								<td colspan="3"><script type="text/javascript">ComComboObject('deli_mode', 1, 250, '');</script></td>
							</tr>						
						</table>				
						<table>
						 <colgroup>
						  <col width="97"/>
						  <col width="220"/>
						  <col width="114"/>
						  <col width="175"/>
						  <col width="30"/>
						  <col width="*"/>
						 </colgroup>
							<tr>
								<th style="text-align:left;">On Board Date</th>
								<td colspan="5"><input type="text" style="width:80px" value="" class="input1"  name="board_from_dt" id="board_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="board_to_dt" id="board_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_board_date" id="btn_board_date"></button></td>
							</tr>
							<tr>
								<th style="text-align:left;">Booking Date</th>
								<td><input type="text" style="width:80px" value="" class="input1"  name="bkg_from_dt" id="bkg_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="bkg_to_dt" id="bkg_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_bkg_date" id="btn_bkg_date"></button></td>
								<th>Booking Kind</th>
								<td colspan="3"><script type="text/javascript">ComComboObject('bkg_kind', 1, 150, '' );</script></td>
							</tr>
							<tr>
								<th style="text-align:left;">BKG Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="b_ofc_cd" maxlength="6"  dataformat='engup' value="" id="b_ofc_cd" onkeyup="onlyText(this);"/>   Sub<input type="checkbox" class="trans" name="b_ofc_cd_sub" value="Y" id="b_ofc_cd_sub" /> </td>
								<th>BKG Staff</th>
								<td><script type="text/javascript">ComComboObject('b_staff_id', 1, 150, '' );</script></td>
								<th>C/A</th>
								<td><input type="checkbox" class="trans" name="ca_flag" value="Y" ></td>
							</tr> 						
						</table>										
						<table>
							<tr>
								<th style="text-align:left;width:20px">Agent Code (for China Booking)</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" class="input" name="agent_cd" maxlength="2" dataformat='engup' id="agent_cd" /><input type="checkbox" class="trans" name="agent_cd_all" value="Y">All</td>
							</tr>
						</table>															
						<table>
						 <colgroup>
						  <col width="90"/>
						  <col width="*"/>
						  <col width="100"/>
						  <col width="*"/>
						 </colgroup>						
							<tr>
								<th style="text-align:left;">EQ TP/SZ</th>
								<td><script type="text/javascript">ComComboObject('eq_type', 1, 150, true, '');</script></td>
								<th>Commodity</th>
								<td><input type="text" style="width:70px;" class="input" maxlength="6" dataformat="num" name="cmdt_cd" value="" id="cmdt_cd" /><input type="text" style="width:87;" class="input2" value="" name='cmdt_nm' readonly/><button type="button" name="btn_commodity_pop" id="btn_commodity_pop" class="input_seach_btn"></button><input type="hidden" style="width:87;" class="input2" value="" name='rep_cmdt_cd' readonly/></td>
							</tr>							
						</table>				
						<table>
						 <colgroup>
						  <col width="90"/>
						  <col width="*"/>
						  <col width="100"/>
						  <col width="*"/>
						 </colgroup>							
							<tr>
								<th style="text-align:left;">Weight</th>
								<td><input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="wgt_from" value="" id="wgt_from" />   ~  <input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="wgt_to" value="" id="wgt_to" />  Ton</td>
								<th>S/O No.</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" maxlength="20" dataformat='engup' name="so_no" value="" id="so_no" /></td>
							</tr>
						</table>						
						<table>
						 <colgroup>
						  <col width="90"/>
						  <col width="160"/>
						  <col width="95"/>
						  <col width="60"/>
						  <col width="70"/>
						  <col width="*"/>						  
						 </colgroup>								
							<tr>
								<th style="text-align:left;">L/Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" maxlength="6" dataformat='engup' name="l_ofc_cd" value="" id="l_ofc_cd" onkeyup="onlyText(this);"/>   Sub <input type="checkbox" class="trans" name="l_ofc_cd_sub" value="Y" id="l_ofc_cd_sub" /> </td>
								<th>Dept.</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 35px" class="input" maxlength="6" dataformat='engup' name="dept_cd" value="" id="dept_cd" onkeyup="onlyText(this);"/> </td>
								<th>L/Rep.</th>
								<td><script type="text/javascript">ComComboObject('l_rep_id', 1, 80, '' );</script></td>
							</tr>
							<tr>
								<th style="text-align:left;">C/Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" maxlength="6" dataformat='engup' name="c_ofc_cd" value="" id="c_ofc_cd" onkeyup="onlyText(this);"/>   Sub <input type="checkbox" class="trans" name="c_ofc_cd_sub" id="c_ofc_cd_sub" /> </td>
								<td></td>
								<td></td>
								<th>C/Rep.</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="c_rep_id" dataformat='engup' value="" maxlength="20" id="c_rep_id" /> </td>
							</tr>
						</table>						
						<table>						
							<tr>
								<td rowspan="2" class="sm"><input type="radio" class="trans" name="ctr_rfa_cd" value="C" checked>S/C <input type="radio" class="trans" name="ctr_rfa_cd" value="R">RFA <input type="radio" class="trans" name="ctr_rfa_cd" value="T">TAA <input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input" maxlength="20" dataformat='engup' name="ctr_rfa_no" value="" id="ctr_rfa_no" /></td>
								<th>S/Mode</th>
								<td><script  type="text/javascript">ComComboObject('s_mode_ori', 1, 150, true, '');</script></td>
								<td><script  type="text/javascript">ComComboObject('s_mode_dest', 1, 150, true, '');</script></td>	
							</tr>
							<tr>																
								<th>S/Route</th>
								<td><script  type="text/javascript">ComComboObject('s_route_ori', 1, 150, true, '');</script></td>
								<td><script  type="text/javascript">ComComboObject('s_route_dest', 1, 150, true, '');</script></td>	
							</tr>
						</table>				
						<table class="sm mar_top_4"> 
							<tr>
								<th rowspan="2" style="text-align:left;">Booking Status</th>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_f" value="F" id="bkg_sts_cd_f" />F-Firm <input type="checkbox" class="trans" name="bkg_sts_cd_x" value="X">X-Cancel <input type="checkbox" class="trans" name="bkg_sts_cd_a" value="A">A-Pseudo Booking</td>
							</tr>
							<tr>
								<td> <input type="checkbox" class="trans" name="bkg_sts_cd_w" value="W" id="bkg_sts_cd_w" /> W-Waiting   (<input type="checkbox" class="trans" name="non_sp_cargo" value="Y" id="non_sp_cargo" /> Non approval of special cargo    <input type="checkbox" class="trans" name="holding" value="Y" id="holding" /> Holding)</td>
							</tr>
						</table>	
					</div>					
			    </div>
			    <div class="layout_vertical_2" style="width:50%; float:right;">
			    	<div class="opus_design_data sm">
					    <h3 class="title_design">Feeder Vessel</h3>
				    	<table>					
							<tbody>					
								<tr>
									<td colspan="2"><input type="radio" class="trans" name="fv_pre_pst_cd" id="fv_pre_pst_cd" value="PR"><strong> Pre </strong><input type="radio" class="trans" name="fv_pre_pst_cd" id="fv_pre_pst_cd" value="PO"><strong> Post </strong></td>
									<th title="Vessel Voyage Direction">VVD</th>
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input2"   name="fv_vvd_cd" id="fv_vvd_cd" value=""  maxlength='9' dataformat='engup' style="ime-mode:disabled"></td>
								</tr> 
								<tr>
									<th style="text-align:left;">POL</th>	
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 50px" value="" name="fv_pol_cd" id="fv_pol_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input2"><input type="text" style="width:25px" value="" class="input2" name="fv_pol_yard_cd" id="fv_pol_yard_cd" maxlength='2'  dataformat="engup"  style="ime-mode:disabled"><input type="checkbox" class="trans" name="fv_pol_local" id="fv_pol_local" value="Y">Local</td>
									<th title="Port of Discharging">POD</th>
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 50px" value="" name="fv_pod_cd" id="fv_pod_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input2"><input type="text" style="width:25px" value="" class="input2" name="fv_pod_yard_cd" id="fv_pod_yard_cd" maxlength='2' dataformat='engup' style="ime-mode:disabled"><input type="checkbox" class="trans" name="fv_pod_local" id="fv_pod_local" value="Y">Local</td>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="opus_design_data sm mar_top_8">
						<h3 class="title_design">Customer</h3>		
				    	<table>					
							<tbody>					
								<tr>
									<td colspan="4"><input type="checkbox" class="trans" name="cust_tp_cd_s" id="cust_tp_cd_s" value="Y">Shipper <input type="checkbox" class="trans" name="cust_tp_cd_c" id="cust_tp_cd_c" value="Y">Consignee <input type="checkbox" class="trans" name="cust_tp_cd_n" id="cust_tp_cd_n" value="Y">Notify <input type="checkbox" class="trans" name="cust_tp_cd_f" id="cust_tp_cd_f" value="Y">Forwarder <input type="checkbox" class="trans" name="cust_tp_cd_a" id="cust_tp_cd_a" value="Y">Also Notify <input type="checkbox" class="trans" name="cust_tp_cd_g" id="cust_tp_cd_g" value="Y">Group</td>
								</tr>
								<tr>
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 32px" class="input" name="cust_cnt_cd" id="cust_cnt_cd" value=""  maxlength='2' dataformat='engup' style="ime-mode:disabled" onkeyup="onlyText(this);"></td>
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 55px" class="input" maxlength='6' dataformat='engup' name="cust_seq" id="cust_seq" style="ime-mode:disabled"  value=""><input type="text" style="width:100px;" class="input"  maxlength='50' dataformat='engup' otherchar="#().,*& -" name="cust_nm" id="cust_nm" value="" ><button type="button" name="btn_customer_pop" id="btn_customer_pop" class="input_seach_btn"></button></td>
									<%-- <th>Customer Type</th>
									<td><script  type="text/javascript">ComComboObject('cust_tp_cd', 1, 150, true, '');</script></td>--%>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="opus_design_data sm mar_top_8">
						<h3 class="title_design">Special Cargo</h3>
						<table>					
							<tbody>					
								<tr>
									<td><input type="checkbox" class="trans" name="sp_cargo_dg" id="sp_cargo_dg" value="Y">Danger</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_rf" id="sp_cargo_rf" value="Y">Reefer</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_ak" id="sp_cargo_ak" value="Y">Awkward</td>
									<td colspan="2"><input type="checkbox" class="trans" name="sp_cargo_bb" id="sp_cargo_bb" value="Y">Break Bulk</td></tr>
								<tr>
									<td><input type="checkbox" class="trans" name="sp_cargo_hg" id="sp_cargo_hg" value="Y">Hanger</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_soc" id="sp_cargo_soc" value="Y">S.O.C</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_eq" id="sp_cargo_eq" value="Y">EQ Sub</td>
									<td colspan="2"><input type="checkbox" class="trans" name="sp_cargo_rd" id="sp_cargo_rd" value="Y">Reefer Dry</td></tr>
								<tr>
									<td><input type="checkbox" class="trans" name="sp_cargo_pm" id="sp_cargo_pm" value="Y">Premier</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_pc" id="sp_cargo_pc" value="Y">Pre-caution</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_fg" id="sp_cargo_fg" value="Y">Food Grade</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_hd" id="sp_cargo_hd" value="Y">Hide</td>
									<td><input type="checkbox" class="trans" name="sp_cargo_rb" id="sp_cargo_rb" value="Y">Rail Bulk</td>
								</tr>
							</tbody>
						</table>
						</div>
						<div class="opus_design_data sm mar_top_8">
						<table>	
						<colgroup>
						 <col width="120">
						 <col width="*">
						</colspan>
							<tr>
								<th style="text-align:left;">Cargo Type</th>	
								<td><input type="checkbox" class="trans" name="cargo_tp_f" id="cargo_tp_f" value="F">  Full  <input type="checkbox" class="trans" name="cargo_tp_p" id="cargo_tp_p" value="P">  Empty (for E/Q reposition)  <input type="checkbox" class="trans" name="cargo_tp_r" id="cargo_tp_r" value="R">Revenue Empty</td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table>
						<colgroup>
						 <col width="120">
						 <col width="100">
						 <col width="100">
						 <col width="*">
						</colgroup>		
							<tr>
								<th style="text-align:left;" wi>Memo B/L Type</th>	
								<td><input type="checkbox" class="trans" name="bl_type_a" id="bl_type_a" value="Y">ahead <input type="checkbox" class="trans" name="bl_type_s" id="bl_type_s" value="Y">short</td>
								<th>Revenue</th>
								<td><input type="checkbox" class="trans" name="rev" id="rev" value="Y">Revenue <input type="checkbox" class="trans" name="non_rev" id="non_rev" value="Y">Non-Revenue</td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>				
						<table>
						<colgroup>
						 <col width="120">
						 <col width="120">
						 <col width="100">
						 <col width="50">
						 <col width="80">
						 <col width="*">						 						 
						</colgroup>										
							<tr>
								<th style="text-align:left;">AES/ITN</th>	
								<td><input type="checkbox" class="trans" name="aes_y" id="aes_y" value="Y">Yes <input type="checkbox" class="trans" name="aes_n" id="aes_n" value="Y">No</td>
								<th>Stop Cargo</th>
								<td><input type="checkbox" class="trans" name="stop_cargo" id="stop_cargo" value="Y"></td>
								<th>Roll Over</th>
								<td><script  type="text/javascript">ComComboObject('ro_y', 1, 100, '');</script></td>
							</tr>
							<tr>
								<th style="text-align:left;">CAED</th>	
								<td><input type="checkbox" class="trans" name="caed_y" id="caed_y" value="Y">Yes <input type="checkbox" class="trans" name="caed_n" id="caed_n" value="Y">No</td>
								<th>CRN No.</th>
								<td><input type="checkbox" class="trans" name="crn_no_flag" id="crn_no_flag" value="Y"></td>
								<td></td>
								<td></td>
							</tr>
						</table>				
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>				
						<table>
						<colgroup>
						 <col width="120">
						 <col width="120">
						 <col width="120">
						 <col width="120">
						 <col width="*">						 						 
						</colgroup>																	
							<tr>
								<th style="text-align:left;">Attachment</th>	
								<td><input type="checkbox" class="trans" name="certi_d" id="certi_d" value="D">D/G Rider</td>
								<td><input type="checkbox" class="trans" name="certi_a" id="certi_a" value="A">A/K Rider</td>
								<td><input type="checkbox" class="trans" name="certi_b" id="certi_b"   value="B">B/B Rider</td>
								<td style="background-color:#FFFFFF" rowspan='2'><input type="checkbox" class="trans" name="certi_y" id="certi_y" value="Y">Yes <input type="checkbox" class="trans" name="certi_n" value="Y">No</td>
							</tr>
							<tr>
								<td></td>	
								<td><input type="checkbox" class="trans" name="certi_g" value="G">General</td>
								<td colspan="2"><input type="checkbox" class="trans" name="certi_c" value="C">Certificate</td>
							</tr>
						</table>	  	  	   
					</div>
			    </div>
			</div>
			</div>
			<!-- layout_wrap(E) -->
</form>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none" id="tabLayer">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Sort" 		id="btn_Sort">Sort</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!--	
			--><button type="button" class="btn_normal" name="btn_Total" 			id="btn_Total">Total Sum Print</button><!--	
			--><button type="button" class="btn_normal" name="btn_Preview" 			id="btn_Preview">Print View</button><!--	
			--><button type="button" class="btn_normal" name="btn_Print" 			id="btn_Print" style="display:none">Print</button><!--		
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_inquiry mar_top_12" >
			<table>			
				<tr>
					<th>No. of Booking</th>
					<td><input type="text" style="width:40px;text-align:right;padding-right: 5px" class="input" id="total_bkg" value="" readonly /> </td>
					<th>No. of B/L</th>
					<td><input type="text" style="width:40px;text-align:right;padding-right: 5px" class="input" id="total_bl" value="" readonly /> </td>
					<th>TEU</th>
					<td><input type="text" style="width:60px;text-align:right;padding-right: 5px" class="input" id="total_teu" value=" " readonly /> </td>
					<th>FEU</th>
					<td><input type="text" style="width:60px;text-align:right;padding-right: 5px" class="input" id="total_feu" value="" readonly /> </td>
					<th>TOT TEU</th>
					<td><input type="text" style="width:60px;text-align:right;padding-right: 5px" class="input" id="total_all_teu" value="" readonly /> </td>
					<th>MEA(CBM)</th>
					<td><input type="text" style="width:67px;text-align:right;padding-right: 5px" class="input" id="total_mea" value="" readonly /> </td>
					<th>Weight(TON)</th>
					<td><input type="text" style="width:60px;text-align:right;padding-right: 5px" class="input" id="total_wgt" value="" readonly /> </td>
				</tr>
			</table>
		</div>
		
		<table border="0" style="width:979"> 
			<tr>
				<td align="left">
					<div id='options' style="padding:5 10 5 10;width: 100%;font-size:11px;height:40px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
					</div>
				</td>
			</tr>
		</table>
				
	</div>
	<!-- opus_design_grid(E) -->	
		
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="downSheet" id="downSheet" style="display:none">
	<script  type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="downSheet_ak" id="downSheet_ak" style="display:none">
		<script  type="text/javascript">ComSheetObject('ak');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="downSheet_bb" id="downSheet_bb" style="display:none">
		<script  type="text/javascript">ComSheetObject('bb');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid clear"  name="downSheet_dg" id="downSheet_dg" style="display:none">
		<script  type="text/javascript">ComSheetObject('dg');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="downSheet_rf" id="downSheet_rf" style="display:none">
		<script  type="text/javascript">ComSheetObject('rf');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none" id="tabLayer">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_DownExcel_Summary" 			id="btn_DownExcel_Summary">Down Excel</button><!-- 	
			 --><button type="button" class="btn_normal" name="btn_Retrieve_Summary" 			id="btn_Retrieve_Summary">Retrieve</button><!--	
			 --><button type="button" class="btn_normal" name="btn_Sort" 			id="btn_Sort">Sort</button><!--
		 --></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('summary');</script>
		<table class="search mar_top_12">
			<tbody>
				<colgroup>
					<col width="1px"/>												
			   </colgroup> 
				<tr>
					<td align="left">
					<div id='options_summary' style="padding:5 10 5 10;width: 100%;font-size:11px;height:40px;border-right:#000000 1px; border-top: #000000 1px;z-index:1;visibility: visible;overflow: auto;border-left: #000000 1px;border-bottom: #000000 1px;" >
					</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear"  name="downSheet_options" id="downSheet_options" style="display:none">
		<script  type="text/javascript">ComSheetObject('search_options');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<form name="form2" method="post">
    <input type="hidden" name="rfn" id="rfn">
    <input type="hidden" name="mrd" id="mrd">
    <input type="hidden" name="rd_title" id="rd_title">
    <input type="hidden" name="rp" id="rp">
    <input type="hidden" name="rv" id="rv">
    <input type="hidden" name="print_type" id="print_type">
</form>
<iframe name="hidden_frame" height="1" width="1"></iframe>	
