<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1701.jsp
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1701Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1701Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from the server		
	String strErrMsg = ""; //error messege
	int rowCount = 0; //the number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "50";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm")); ;
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1701Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			   <button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve" style="display:none">Retrieve</button><!--
			 --><button type="button" class="btn_accent" name="btn_Direct_Retrieve" id="btn_Direct_Retrieve">Direct Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Sort" 			id="btn_Sort" style="display:none">Sort</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_New" 			id="btn_New">New</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
		
	</div>
	<!-- page_title_area(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab sm" style="display:none">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">	
		
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
	<input type="hidden" name="p_bkg_rpt_knd_cd" value="K">				
	<input type="hidden" name="p_report_type" value="">				
	<input type="hidden" name="p_grid_type" value="G">				
	<input type="hidden" name="curr_page"      value="1">				
	<input type="hidden" name="rows_per_page"      value="50">
	<input type="hidden" name="last_orderby"      value="">				
	<input type="hidden" name="orderby"      value="pol_cd,del_cd">				
	<input type="hidden" name="orderby_title_sql"      value="">
	<input type="hidden" name="vis_flg"      value="Y">
	<input type="hidden" name="rpt_id">
	
			<!-- layout_wrap(S) -->
			<div class="opus_design_inquiry">
			<div class="layout_wrap mar_top_12">
				<div class="layout_vertical_2" style="width:49%;">
					<div class="opus_design_data sm" style="height:400px;">
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
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd" maxlength="5"  class="input" id="pol_cd"  dataformat="engup"/>  <input type="text" style="IME-MODE: disabled; width:35px;" value="" class="input" name="pol_yard_cd" maxlength="2"  id="pol_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" /> Local <input type="checkbox" class="trans" name="pol_ts" value="Y" id="pol_ts"/> T/S)</td>
								<th title="Port of Discharging">POD</th>
								<td colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd" maxlength="5" class="input" id="pod_cd"  dataformat="engup" />  <input type="text" style="IME-MODE: disabled; WIDTH: 35px" value="" class="input" name="pod_yard_cd" maxlength="2" id="pod_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pod_local" /> Local <input type="checkbox" class="trans" name="pod_ts" value="Y" id="pod_ts" /> T/S)</td>
							</tr> 
							 <tr>
								<th style="text-align:left;">POR</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="por_cd" maxlength="5" value="" id="por_cd"  dataformat="engup" /><strong> DEL </strong><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="del_cd" id="del_cd" maxlength="5" value="" dataformat="engup"></td>
								<th>R/D Term</th>
								<td colspan="3"><script type="text/javascript">ComComboObject('r_term', 1, 123, '' );</script><script type="text/javascript">ComComboObject('d_term', 1, 123, '' );</script></td>
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
								<th style="text-align:left;">Sail Date</th>
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
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="b_ofc_cd" maxlength="6"  dataformat='engup' value="" id="b_ofc_cd" />   Sub <input type="checkbox" class="trans" name="b_ofc_cd_sub" value="Y" id="b_ofc_cd_sub" /> </td>
								<th>BKG Staff</th>
								<td><script type="text/javascript">ComComboObject('b_staff_id', 1, 150, '' );</script></td>
								<th>C/A</th>
								<td><input type="checkbox" class="trans" name="ca_flag" value="Y" ></td>
							</tr> 						
						</table>										
						<table>
							<tr>
								<th style="text-align:left;width:20px">B/L Release Office</th>
								<td><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" class="input" name="bl_rlse_ofc_cd" maxlength="6" dataformat='engup' id="bl_rlse_ofc_cd" /></td>
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
						 </colgroup>							
							<tr>
								<th style="text-align:left;">Cargo Weight</th>
								<td><input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="cgo_wgt_from" value="" id="cgo_wgt_from" />   ~  <input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="cgo_wgt_to" value="" id="cgo_wgt_to" />  (<input type="checkbox" class="trans" name="cgo_wgt_kg" value="Y" id="cgo_wgt_kg" /> KG <input type="checkbox" class="trans" name="cgo_wgt_lb" value="Y" id="cgo_wgt_lb"/> LB)</td>
							</tr>
							<tr>
								<th style="text-align:left;">Gross Weight</th>
								<td><input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="grs_wgt_from" value="" id="grs_wgt_from" />   ~  <input type="text" style="width:60px;" class="input" maxlength="5" dataformat="num" name="grs_wgt_to" value="" id="grs_wgt_to" />  (<input type="checkbox" class="trans" name="grs_wgt_kg" value="Y" id="grs_wgt_kg" /> KG <input type="checkbox" class="trans" name="grs_wgt_lb" value="Y" id="grs_wgt_lb"/> LB)</td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table>
							<tr>
								<td width="180">
									<table>
										<tr><td><h3>Weight Band</h3></td></tr>
										<tr><td>in Metric Tons</td></tr>
										<tr></tr>
										<tr><td>1 T = 1000 KGs of G/W(KG)</td></tr>
									</table>
								</td>
								<td>
									<table>
										<tr><td><input type="checkbox" class="trans" name="wgt_bnd_xh" value="Y" id="wgt_bnd_xh"/> XH = 22 + (above 22) MT</td></tr>
										<tr><td><input type="checkbox" class="trans" name="wgt_bnd_h" value="Y" id="wgt_bnd_h"/> H = 16 - 22 (above 16, including 22) MT</td></tr>
										<tr><td><input type="checkbox" class="trans" name="wgt_bnd_m" value="Y" id="wgt_bnd_m"/> M = 10 - 16 (above 10, including 16) MT</td></tr>
										<tr><td><input type="checkbox" class="trans" name="wgt_bnd_l" value="Y" id="wgt_bnd_l"/> L = 0 - 10 (including 10) MT</td></tr>
									</table>
								</td>
							</tr>
						</table>
					</div>					
			    </div>
			    <div class="layout_vertical_2" style="width:50%; float:right;">
			    	<div class="opus_design_data sm" style="height:400px;">
						<h3 class="title_design">Customer</h3>								
				    	<table>					
							<tbody>
							<colgroup>
							 <col width="70">
							 <col width="260">
							 <col width="110">
							 <col width="*">
							</colgroup>	
								<tr>
									<td colspan="4">
										<input type="checkbox" class="trans" name="cust_tp_cd_s" id="cust_tp_cd_s" value="Y"> Shipper &nbsp;&nbsp;&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_c" id="cust_tp_cd_c" value="Y"> Consignee &nbsp;&nbsp;&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_n" id="cust_tp_cd_n" value="Y"> Notify &nbsp;&nbsp;&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_f" id="cust_tp_cd_f" value="Y"> Forwarder &nbsp;&nbsp;&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_a" id="cust_tp_cd_a" value="Y"> Also Notify &nbsp;&nbsp;&nbsp;
									</td>
								</tr>
								<tr>
									<th>Customer</th>
									<td colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 32px" class="input" name="cust_cnt_cd" id="cust_cnt_cd" value=""  maxlength='2' dataformat='engup' style="ime-mode:disabled" onkeyup="onlyText(this);"><input type="text" style="IME-MODE: disabled; WIDTH: 55px" class="input" maxlength='6' dataformat='engup' name="cust_seq" id="cust_seq" style="ime-mode:disabled"  value=""><input type="text" style="width:100px;" class="input"  maxlength='50' dataformat='engup' otherchar="#().,*& -" name="cust_nm" id="cust_nm" value="" ><button type="button" name="btn_customer_pop" id="btn_customer_pop" class="input_seach_btn"></button></td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<h3 class="title_design">Cargo Nature</h3>
						<table>					
							<tbody>					
								<tr>
									<td width="60"><input type="checkbox" class="trans" name="sp_cargo_dg" id="sp_cargo_dg" value="Y"> DG</td>
									<td width="60"><input type="checkbox" class="trans" name="sp_cargo_rf" id="sp_cargo_rf" value="Y"> RF</td>
									<td width="60"><input type="checkbox" class="trans" name="sp_cargo_ak" id="sp_cargo_ak" value="Y"> AK</td>
									<td width="60"><input type="checkbox" class="trans" name="sp_cargo_bb" id="sp_cargo_bb" value="Y"> BB</td>
									<td width="60"><input type="checkbox" class="trans" name="sp_cargo_rd" id="sp_cargo_rd" value="Y"> RD</td>
									<td width=""><input type="checkbox" class="trans" name="sp_cargo_hg" id="sp_cargo_hg" value="Y"> HG</td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table class="sm mar_top_4">						
							<tr>
								<td rowspan="2" class="sm"><input type="radio" class="trans" name="ctr_rfa_cd" value="C" checked> S/C <input type="radio" class="trans" name="ctr_rfa_cd" value="R"> RFA <input type="radio" class="trans" name="ctr_rfa_cd" value="T"> TAA <input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input" maxlength="20" dataformat='engup' name="ctr_rfa_no" value="" id="ctr_rfa_no" /></td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table class="sm mar_top_4"> 
							<colgroup>
							  <col width="135"/>
							  <col width="*"/>
							</colgroup>	
							<tr>
								<th style="text-align:left;">Booking Status</th>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_f" value="F" id="bkg_sts_cd_f" /> F-Firm <input type="checkbox" class="trans" name="bkg_sts_cd_x" value="X"> X-Cancel <input type="checkbox" class="trans" name="bkg_sts_cd_a" value="A"> A-Pseudo Booking</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_w" value="W" id="bkg_sts_cd_w" /> W-Waiting   (<input type="checkbox" class="trans" name="non_sp_cargo" value="Y" id="non_sp_cargo" /> Non approval of special cargo    <input type="checkbox" class="trans" name="holding" value="Y" id="holding" /> Holding)</td>
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table class="sm mar_top_4"> 
							<colgroup>
							  <col width="110"/>
							  <col width="260"/>
							  <col width="*"/>
							</colgroup>	
							<tr>
								<th style="text-align:left;">Container Status</th>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_mt" value="MT"> MT - Empty Container</td> 
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_op" value="OP"> OP - Empty Release for Outbound</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_oc" value="OC"> OC - Outbound Full CY</td> 
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_en" value="EN"> EN - Enroute BTWN different EQ CTRL Area</td> 
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_tn" value="TN"> TN - Transportation with same EQ CTRL Area</td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_vl" value="VL"> VL - Vessel Loading</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_ts" value="TS"> TS - Transshipment</td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_vs" value="VD"> VD - Vessel Discharge</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_ic" value="IC"> IC - Inbound Full CY</td> 
								<td><input type="checkbox" class="trans" name="cntr_sts_cd_id" value="ID"> ID - Inbound Full Delivery</td> 
							</tr>
						</table>
						<table class="line_bluedot"><tr><td></td></tr></table>
						<table class="sm mar_top_4"> 
							<colgroup>
							  <col width="135"/>
							  <col width="*"/>
							</colgroup>	
							<tr>
								<th style="text-align:left;">Rating Status</th>
								<td><input type="checkbox" class="trans" name="rate_sts_r" value="R"> Complete</td> 
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="rate_sts_u" value="U"> Incomplete</td>
							</tr>
						</table>
					</div>
			    </div>
			</div>
			</div>
			<!-- layout_wrap(E) -->

	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none" id="tabLayer">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_Retrieve" 		id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Sort" 		id="btn_Sort">Sort</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 			id="btn_DownExcel">Down Excel</button><!--	
		--></div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_inquiry mar_top_12" >
			<table>			
				<tr>
					<th>No. of Container</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_cntr" value="" readonly /> </td>
					<th>TEU</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_teu" value="" readonly /> </td>
					<th>CNTR G/W(KG)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_grs_kg" value="" readonly /> </td>
					<th>CNTR T/W(KG)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_tare_kg" value="" readonly /> </td>
					<th>Cargo Weight(KG)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_cgo_kg" value="" readonly /> </td>
				</tr>		
				<tr>
					<th>No. of Packages</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_pck" value="" readonly /> </td>
					<th>FEU</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_feu" value="" readonly /> </td>
					<th>CNTR G/W(LB)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_grs_lb" value=" " readonly /> </td>
					<th>CNTR T/W(LB)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_tare_lb" value="" readonly /> </td>
					<th>Cargo Weight(LB)</th>
					<td><input type="text" style="width:80px;text-align:right;padding-right: 5px" class="input" id="ttl_cgo_lb" value="" readonly /> </td>
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
</form>