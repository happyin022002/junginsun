<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ESM_BKG_1702.jsp
 *@FileTitle : BL Container Information Report
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg1702Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1702Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg1702Event) request.getAttribute("Event");
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
<form method="post" name="form" id="mainform" onSubmit="return false;">
	<input type="hidden" name="f_cmd"/>
	<input type="hidden" name="p_bkg_rpt_knd_cd" value="L">		
	<input type="hidden" name="rpt_id">	
	<input type="hidden" name="orderby">	
			<!-- layout_wrap(S) -->
			<div class="opus_design_inquiry">
			<div class="layout_wrap mar_top_12">
				<div class="layout_vertical_2" style="width:49%;">
					<div class="opus_design_data sm" style="height:230px;">
						<table>
							<colgroup>
							  <col width="100"/>
							  <col width="214"/>
							  <col width="118"/>
							  <col width="*"/>
							</colgroup>						
							<tr>
								<td colspan="4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<input name="rdo_in_out" type="radio" value="O" class="trans" id="rdo2_1" onclick="chgMandatory();" checked><label for="rdo2_1">Outbound</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<!-- 
									 --><input name="rdo_in_out" type="radio" value="I" class="trans" id="rdo2_2" onclick="chgMandatory();"><label for="rdo2_2">Inbound</label>
								</td>
							</tr>
							<tr>
								<th name="arr_title">VVD</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 90px" class="input1" name="vvd_cd" value="" maxlength="9" id="vvd_cd" dataformat="engup"/> Trunk <input type="checkbox" class="trans" name="trunk_flag" value="Y"></td>
								<th name="arr_title">Dir</th>
								<td name="arr_detail"><script type="text/javascript">ComComboObject('dir_cd', 1, 80, '');</script></td>
							</tr>							
							<tr>								
								<th name="arr_title">POL</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pol_cd" maxlength="5"  class="input1" id="pol_cd"  dataformat="engup"/>  <input type="text" style="IME-MODE: disabled; width:35px;" value="" class="input" name="pol_yard_cd" maxlength="2"  id="pol_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pol_local" value="Y" id="pol_local" />Local<input type="checkbox" class="trans" name="pol_ts" value="Y" id="pol_ts"/>T/S)</td>
								<th name="arr_title">POD</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" value="" name="pod_cd" maxlength="5" class="input1" id="pod_cd"  dataformat="engup" />  <input type="text" style="IME-MODE: disabled; WIDTH: 35px" value="" class="input" name="pod_yard_cd" maxlength="2" id="pod_yard_cd" dataformat="engup" />(<input type="checkbox" class="trans" name="pod_local" value="Y" id="pod_local" />Local<input type="checkbox" class="trans" name="pod_ts" value="Y" id="pod_ts" />T/S)</td>								
							</tr>
							<tr>
								<th name="arr_title">POR</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="por_cd" maxlength="5" value="" id="por_cd"  dataformat="engup" />&nbsp;&nbsp;<strong>DEL</strong>&nbsp;<input type="text" style="IME-MODE: disabled; WIDTH: 83px" class="input" name="del_cd" id="del_cd" maxlength="5" value="" dataformat="engup"></td>
								<th name="arr_title">R/D Term</th>
								<td name="arr_detail"><script type="text/javascript">ComComboObject('r_term', 1, 80, '' );</script>&nbsp;
													  <script type="text/javascript">ComComboObject('d_term', 1, 80, '' );</script></td>
							</tr>							
							<tr>								
								<th name="arr_title">Sail Date</th>
								<td name="arr_detail"><input type="text" style="width:80px" value="" class="input1"  name="sail_from_dt" id=sail_from_dt  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="sail_to_dt" id="sail_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_sail_date" id="btn_sail_date"></button></td>
								<th name="arr_title">Arrival Date</th>
								<td name="arr_detail"><input type="text" style="width:80px" value="" class="input1"  name="arr_from_dt" id="arr_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input1"  name="arr_to_dt" id="arr_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_arr_date" id="btn_arr_date"></button></td>							
							</tr>
							<tr>
								<th name="arr_title">B/L Print Date</th>
								<td name="arr_detail"><input type="text" style="width:80px" value="" class="input"  name="bl_prn_from_dt" id="bl_prn_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input"  name="bl_prn_to_dt" id="bl_prn_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_bl_prn_date" id="btn_bl_prn_date"></button></td>
								<th name="arr_title">B/L Surrender Date</th>
								<td name="arr_detail"><input type="text" style="width:80px" value="" class="input"  name="bl_srnd_from_dt" id="bl_srnd_from_dt"  maxlength='10' dataformat="ymd" >~<input type="text" style="width:80px" value="" class="input"  name="bl_srnd_to_dt" id="bl_srnd_to_dt"  maxlength='10' dataformat="ymd" ><button type="button" class="calendar ir" name="btn_bl_srnd_date" id="btn_bl_srnd_date"></button></td>								
							</tr>							
						</table>	 																							
						<table>
							<colgroup>
							  <col width="35"/>
							  <col width="65"/>
							  <col width="92"/>
							  <col width="80"/>
							  <col width="83"/>
							  <col width="162"/>
							  <col width="*"/>
							</colgroup>						
							<tr><!-- 
								<th name="arr_title">Tariff Code</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="trf_cd" maxlength="20"  dataformat='engup' value="" id="trf_cd" onkeyup="onlyText(this);"/> </td>
								 -->
								<td></td>
							 	<th name="arr_title">Carrier</th>
								<td name="arr_detail"><script type="text/javascript">ComComboObject('crr_cd', 1, 80, '');</script></td>
								<th name="arr_title">Cleared By</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 80px" class="input" name="obl_iss_usr_id" maxlength="20"  dataformat='eng' value="" id="obl_iss_usr_id"/> </td>
								<th name="arr_title">Cargo Release Stauts</th>
								<td name="arr_detail"><script type="text/javascript">ComComboObject('cgo_rlse_sts_cd', 1, 109, '');</script></td>
							</tr>
							<tr>
								<td></td>
								<td colspan="3" class="sm">&nbsp;
									<input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_sc" value="S" checked><label for="sc_rfa_gbn_sc">S/C</label><!-- 
								 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_rfa" value="R"><label for="sc_rfa_gbn_rfa">RFA</label><!--
								 --><input type="radio" name="sc_rfa_gbn" id="sc_rfa_gbn_taa" value="T"><label for="sc_rfa_gbn_taa">TAA</label><!--
								 --><input type="text" 	name="sc_rfa_no"  id="sc_rfa_no" 	class="input" value="" style="width:80px;" maxlength="11" dataformat="engup">
								</td>
								<td colspan="3"></td>								
							</tr>							
						</table> 					
					</div>		
			    </div>
			    <div class="layout_vertical_2" style="width:50.5%; float:right;">
					<div class="opus_design_data sm">
					    <h3 class="title_design">B/L CNTR Details</h3>
				    	<table>		
							<colgroup>
							  <col width="120"/>
							  <col width="200"/>
							  <col width="118"/>
							  <col width="*"/>
							</colgroup>					
							<tr>
								<th name="arr_title">B/L Status</th>	
								<td name="arr_detail"><script type="text/javascript">ComComboObject('bl_sts_cd', 1, 150, '');</script></td>
								<th name="arr_title">Country of POR</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" value="" name="por_cd2" id="por_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
							</tr>
							<tr>
								<th name="arr_title">B/L Type</th>	
								<td name="arr_detail"><script type="text/javascript">ComComboObject('bl_tp_cd', 1, 150, '');</script></td>
								<th name="arr_title">Country of POD</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" value="" name="pod_cd2" id="pod_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
							</tr>
							<tr>
								<th name="arr_title">Internet BL</th>	
								<td name="arr_detail"><script type="text/javascript">ComComboObject('internet_bl', 1, 50, '');</script></td>
								<th name="arr_title">Last Discharge VVD</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" value="" name="vvd_cd2" id="vvd_cd2" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input"></td>
							</tr>
							<tr>
								<th name="arr_title">B/L Release Office</th>	
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" class="input" maxlength="6" dataformat='engup' name="bl_rlse_ofc_cd" value="" id="bl_rlse_ofc_cd" onkeyup="onlyText(this);"/></td>
								<th name="arr_title">B/L Surrender Office</th>
								<td name="arr_detail"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" class="input" maxlength="6" dataformat='engup' name="bl_srnd_ofc_cd" value="" id="bl_srnd_ofc_cd" onkeyup="onlyText(this);"/></td>
							</tr>	
							<tr>
								<th name="arr_title">B/L Issue Office</th>	
								<td name="arr_detail" colspan="3"><input type="text" style="IME-MODE: disabled; WIDTH: 150px" class="input" maxlength="6" dataformat='engup' name="cptr_ofc_cd" value="" id="cptr_ofc_cd" onkeyup="onlyText(this);"/></td>									
							</tr>	
						</table>
					</div>
					<div class="opus_design_data sm mar_top_4">
						<h3 class="title_design" name="arr_title">Customer</h3>		
				    	<table name="arr_detail">					
							<tbody>			
								<colgroup>
								  <col width="200"/>
								  <col width="120"/>
								  <col width="*"/>
								</colgroup>										
								<tr>
									<td>&nbsp;
										<input type="checkbox" class="trans" name="cust_tp_cd_s" id="cust_tp_cd_s" value="Y">Shipper&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_c" id="cust_tp_cd_c" value="Y">Consignee&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_n" id="cust_tp_cd_n" value="Y">Notify&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_f" id="cust_tp_cd_f" value="Y">Forwarder&nbsp;
						                <input type="checkbox" class="trans" name="cust_tp_cd_a" id="cust_tp_cd_a" value="Y">Also Notify&nbsp;
						                <!--<input type="checkbox" class="trans" name="cust_tp_cd_g" id="cust_tp_cd_g" value="Y">Group-->
									</td>
									<th>Customer</th>
									<td><input type="text" style="IME-MODE: disabled; WIDTH: 32px" class="input" name="cust_cnt_cd" id="cust_cnt_cd" value=""  maxlength='2' dataformat='engup' style="ime-mode:disabled" onkeyup="onlyText(this);"><input type="text" style="IME-MODE: disabled; WIDTH: 55px" class="input" maxlength='6' dataformat='engup' name="cust_seq" id="cust_seq" style="ime-mode:disabled"  value=""><input type="text" style="width:100px;" class="input"  maxlength='50' dataformat='engup' otherchar="#().,*& -" name="cust_nm" id="cust_nm" value="" ><button type="button" name="btn_customer_pop" id="btn_customer_pop" class="input_seach_btn"></button></td>
									<!-- 
									<th>Group Customer</th>
									<td><input type="text" style="width:100px;" class="input"  maxlength='20' dataformat='engup' otherchar=" -" name="cust_grp_id" id="cust_grp_id" value="" ><button type="button" name="btn_cust_grp_pop" id="btn_cust_grp_pop" class="input_seach_btn"></button></td>
									-->									
								</tr>
							</tbody>
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
			 --><button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Sort" 		id="btn_Sort">Sort</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_inquiry mar_top_12" >
			<table>			
				<tr>
					<th>No. of Booking</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="cnt_bkg" value="" readonly /> </td>
					<th>No. of BL</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="cnt_bl" value="" readonly /> </td>					
					<th>No. of Container</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="cnt_cntr" value="" readonly /> </td>
					<th>No. of Package</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="cnt_pck" value="" readonly /> </td>	
				</tr>
				<tr>
					<th>SUM of Collect Freight</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_cct_amt" value="" readonly /> </td>
					<th>SUM of PrePaid Freight</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_ppd_amt" value="" readonly /> </td>	
					<th>Gross Measurement(CBM)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_grs_mea_cbm" value="" readonly /> </td>
					<th>Net Measurement(CBM)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_net_mea_cbm" value="" readonly /> </td>	
				</tr>
				<tr>
					<th>Cargo Weight(TON)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_wgt_ton" value="" readonly /> </td>
					<th>Gross Weight(KG)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_grs_wgt_kgs" value="" readonly /> </td>
					<th>Net Weight(KG)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_net_wgt_kgs" value="" readonly /> </td>
					<th>Net Weight(LBS)</th>
					<td><input type="text" style="width:100px;text-align:right;padding-right: 5px" class="input" id="sum_wgt_lbs" value="" readonly /> </td>
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
	<div class="opus_design_grid clear"  name="downSheet_options" id="downSheet_options" style="display:none">
		<script  type="text/javascript">ComSheetObject('search_options');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
