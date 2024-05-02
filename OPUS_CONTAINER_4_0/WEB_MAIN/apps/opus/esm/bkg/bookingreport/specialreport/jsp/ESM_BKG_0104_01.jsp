<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0104_01.jsp
*@FileTitle  : Report Template
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0104Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String rpt_nm = JSPUtil.getNull(request.getParameter("rpt_nm"));
	int rpt_index_temp = Integer.parseInt(JSPUtil.getNull(request.getParameter("rpt_index")));
	String rpt_index = Integer.toString(rpt_index_temp-1);
	
	String edit_yn = JSPUtil.getNull(request.getParameter("edit_yn"));
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.statusreport");

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

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
 paramReportName="<%=rpt_nm%>";
 paramReportIndex="<%=rpt_index%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	
</script>
<div id="debug"></div>

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Booking Status Report</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		     	<button type="button" class="btn_accent" name="btn_OK" id="btn_OK">Save</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<div id="tabLayer" style="display:inline"></div>
	<form  name="tempform">
		<div class="wrap_search"> 
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table> 
		            <colgroup>
		                <col width="90"> 
		                <col width="*">
		            </colgroup>
		            <tbody>
			             <tr>
							<th>Report Type</th>
							<td><script type="text/javascript">ComComboObject('report_type', 1, 240, '');</script></td>
						</tr>
					</tbody>
				</table>
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
	</form>
	<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd" id="f_cmd" />
	<input type="hidden" name="p_bkg_rpt_knd_cd" value="B" id="p_bkg_rpt_knd_cd" />
	<input type="hidden" name="edit_yn" value="<%= edit_yn %>" id="edit_yn" />
<div class="wrap_search">					
	<div class="layout_wrap">
	  	   <!-- layout_flex_fixed(S) -->
   		   <div class="layout_vertical_2" style="width:550px"> 
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_inquiry">
					<table> 
			            <colgroup>
			                <col width="40"> 
			                <col width="110">
			                <col width="90"> 
			                <col width="50"> 
			                <col width="20"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
				             <tr>
								<th title="Vessel Voyage Direction">VVD</th>
								<td><input type="text"  class="input1"  name="vvd_cd" id="vvd_cd" value=""  maxlength='9'  required fullfill  dataformat='engup' style="width:80px;ime-mode:disabled"></td>
								<td>Trunk <input type="checkbox" class="trans" name="trunk_flag" id="trunk_flag" value="Y"></td>
								<th>Lane</th>
								<td><input type="text" class="input" name="lane_cd" id="lane_cd" value=""  maxlength='3'  dataformat='engup' style="width:80px;ime-mode:disabled"></td>
								<th>Dir</th>
								<td><script type="text/javascript">ComComboObject('dir_cd', 1, 57, '');</script></td>
							</tr> 
						</tbody>
					</table>
					<table>
						<colgroup>
			                <col width="40"> 
			                <col width="200">
			                <col width="50"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th title="Port of Loading">POL</th>
								<td><input type="text"  value="" name="pol_cd" id="pol_cd" maxlength='5' dataformat='engup' style="width:50px;ime-mode:disabled" class="input"><!-- 
								 	 --><input type="text" value="" class="input" name="pol_yard_cd" id="pol_yard_cd" maxlength='2' dataformat='engup' style="width:25px;ime-mode:disabled"><!--  
								 	 -->(<input type="checkbox" class="trans" name="pol_local"  id="radio_pol_local" value="Y"><label for="radio_pol_local">Local</label><!--  
								 	 --><input type="checkbox" class="trans" name="pol_ts"  id="radio_pol_ts1" value="Y"><label for="radio_pol_ts1">T/S)</label>
								</td>
								<th title="Port of Discharging">POD</th>
								<td><input type="text"  value="" name="pod_cd" id="pod_cd" maxlength='5' dataformat='engup' style="width:50px;ime-mode:disabled" class="input"><!-- 
									  --><input type="text"  value="" class="input" name="pod_yard_cd" id="pod_yard_cd" maxlength='2' dataformat='engup' style="width:25px;ime-mode:disabled"><!--  
									  -->(<input type="checkbox" class="trans" name="pod_local" id="radio_pod_local3" value="Y"><label for="radio_pod_local3">Local</label><!--  
									  --><input type="checkbox" class="trans" name="pod_ts" id="radio_pod_ts56" value="Y"><label for="radio_pod_ts56">T/S)</label>
								</td>
							</tr> 
						<tbody>
					</table>
					<table>
						<colgroup>
			                <col width="40"> 
			                <col width="60">
			                <col width="40"> 
			                <col width="90">
			                <col width="60">
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th title="Place of Receipt">POR</th>
								<td><input type="text" name="por_cd" id="por_cd" maxlength='5' dataformat='engup' style="width:40px;ime-mode:disabled" value=""></td>
								<th title="Place of Delivery">DEL</th>
								<td><input type="text"  class="input" name="del_cd" id="del_cd" maxlength='5' dataformat='engup' style="width:40px;ime-mode:disabled" value=""></td>
								<th>R/D Term</th>
								<td>
									<script type="text/javascript">ComComboObject('r_term', 1, 49, '' );</script><!-- 
									 --><script type="text/javascript">ComComboObject('d_term', 1, 49, '' );</script>
								</td>
							</tr> 
						</tbody>
					</table>
					<table class="search_sm">
						<colgroup>
			                <col width="10"> 
			                <col width="60"> 
			                <col width="100">
			                <col width="120"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<td></td>
								<th class="sm">Zone</th>
								<td class="sm"><%=JSPUtil.getCodeCombo("zone_cd", "", "", "CD20054", 0, "000001: :All")%></td>
								<th>Delivery Mode</th>
								<td><script type="text/javascript">ComComboObject('deli_mode', 1, 49, '');</script></td>
							</tr>
						</tbody>
					</table>
					<table>
						<colgroup>
			                <col width="90"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>On Board Date</th>
								<td><input type="text" style="width:80px" value="" class="input1"  name="board_from_dt" id="board_from_dt"  maxlength='10' dataformat="ymd" ><span class="dash">~</span><!-- 
								   --><input type="text" style="width:80px" value="" class="input1"  name="board_to_dt" id="board_to_dt"  maxlength='10' dataformat="ymd" ><!--
								   --><button type="button" id="btn_board_date" name="btn_board_date" class="calendar ir"></button>
								</td>
							</tr>
						</tbody>
					</table>		
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="60"> 
			                <col width="160"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>Booking Date</th>
								<td><input type="text" style="width:80px" value="" class="input1"  name="bkg_from_dt" id="bkg_from_dt"  maxlength='10' dataformat="ymd" ><span class="dash">~</span><!--
								   --><input type="text" style="width:80px" value="" class="input1"  name="bkg_to_dt" id="bkg_to_dt"  maxlength='10' dataformat="ymd" ><!--
								   --><button type="button" class="calendar ir"  name="btn_bkg_date" id="btn_bkg_date"></button>
								</td>
								<th>Booking Kind</th>
								<td><script type="text/javascript">ComComboObject('bkg_kind', 1, 49, '' );</script></td>
							</tr>
						</tbody>
					</table>				
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="60"> 
			                <col width="130"> 
			                <col width="90"> 
			                <col width="40"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>BKG Office</th>
								<td>
									<input type="text" value="" class="input" name="b_ofc_cd" id="b_ofc_cd" maxlength='6' dataformat='engup' style="width:50px;ime-mode:disabled">
									<label for="radio_b_ofc_cd_sub2">Sub</label><input type="checkbox" class="trans" name="b_ofc_cd_sub" id="radio_b_ofc_cd_sub2" value="Y"></td>
								<th>BKG Staff</th>
								<td>
									<script type="text/javascript">ComComboObject('b_staff_id', 1, 80, '' );</script>
								</td>
								<th>C/A</th>
								<td><input type="checkbox" class="trans" name="ca_flag"  id="radio_ca_flag5" value="Y" ><label for="radio_ca_flag5"></label></td>
							</tr> 
						</tbody>
					</table>
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="90"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>Agent Code (for China Booking)</th>
								<td>
									<input type="text" value="" class="input" name="agent_cd" id="agent_cd" maxlength='2' dataformat='engup' style="width:75px;ime-mode:disabled">
								</td>
								<td>  
									<input type="checkbox" class="trans" name="agent_cd_all" id="radio_agent_cd_all5" value="Y"><label for="radio_agent_cd_all5">All</label>
								</td>
							</tr>
						</tbody>
					</table>		
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="60"> 
			                <col width="170"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>EQ TP/SZ</th>
								<td>
									<script type="text/javascript">ComComboObject('eq_type', 1, 60, true, '');</script>
								</td>
								<th>Commodity</th>
								<td>
									<input type="text" class="input" maxlength='6' dataformat='num' name="cmdt_cd" id="cmdt_cd" style="width:80px;ime-mode:disabled" value=""><!-- 
								    --><input type="text" style="width:87px;" class="input2" value="" name='cmdt_nm' id='cmdt_nm' readonly><!-- 
								    --><button type="button" class="input_seach_btn"   name="btn_commodity_pop" id="btn_commodity_pop"></button><!-- 
								    --><input type="hidden" style="width:87px;" class="input2" value="" name='rep_cmdt_cd' id='rep_cmdt_cd' readonly>
								</td>
							 </tr>	
						</tbody>
					</table>				
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="60"> 
			                <col width="75"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>Weight</th>
								<td><input type="text" style="width:60px" class="input" maxlength='5' dataformat='num' name="wgt_from" id="wgt_from" value="">~ <!-- 
									 --><input type="text" style="width:60px" class="input" maxlength='5' dataformat='num'  name="wgt_to" id="wgt_to" value="">Ton
								</td>
								<th>S/O No.</th>
								<td><input type="text" style="width:80px;" class="input" maxlength='20' dataformat='num'  name="so_no"  id="so_no"  value=""></td>
							</tr>
						</tbody>
					</table>	
					<table> 
						<colgroup>
			                <col width="90"> 
			                <col width="150"> 
			                <col width="85"> 
			                <col width="66"> 
			                <col width="40"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>L/Office</th>
								<td>
									<input type="text" style="width:80px;" class="input"  maxlength='6' dataformat='engup'  name="l_ofc_cd" id="l_ofc_cd" value=""><label for="radio_l_ofc_cd_sub2">Sub</label> 
									<input type="checkbox" class="trans" id="radio_l_ofc_cd_sub2" name="l_ofc_cd_sub" value="Y"></td>
								<th>Dept.</th>
								<td><input type="text" style="width:35px;" class="input" maxlength='6' dataformat='engup'  name="dept_cd" id="dept_cd" value=""></td>
								<th>L/Rep.</th>
								<td>
									<script type="text/javascript">ComComboObject('l_rep_id', 1, 80, '' );</script>
								</td>
							</tr>
						</tbody>
					</table>
					<table>
						<colgroup>
			                <col width="90"> 
			                <col width="150"> 
			                <col width="85"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th>C/Office</th>
								<td>
									<input type="text"  class="input" maxlength='6' dataformat='engup' style="width:80px;ime-mode:disabled" name="c_ofc_cd" id="c_ofc_cd" value=""><label for="radio_c_ofc_cd_sub3">Sub</label>
									<input type="checkbox" class="trans" name="c_ofc_cd_sub" id="radio_c_ofc_cd_sub3"></td>
								<th>C/Rep.</th>
								<td><input type="text" class="input"  name="c_rep_id" id="c_rep_id" value=""  maxlength='20'  dataformat='engup' style="width:80px;ime-mode:disabled"></td>
							</tr>
						</tbody>
					</table>	
					<table class="search_sm"> 
						<colgroup>
			                <col width="30"> 
			                <col width="60"> 
			                <col width="60"> 
			                <col width="60"> 
			                <col width="90"> 
			                <col width="10"> 
			                <col width="70"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<td rowspan="2"></td>
								<td rowspan="2" class="sm"><input type="radio" class="trans" name="ctr_rfa_cd" id="radio_ctr_rfa_cd33" value="C" checked><label for="radio_ctr_rfa_cd33">S/C</label></td>
								<td rowspan="2" class="sm"><input type="radio" class="trans" name="ctr_rfa_cd" id="radio_ctr_rfa_cd35" value="R"><label for="radio_ctr_rfa_cd35">RFA</label></td>
								<td rowspan="2" class="sm"><input type="radio" class="trans" name="ctr_rfa_cd" id="radio_ctr_rfa_cd34" value="T"><label for="radio_ctr_rfa_cd34">TAA</label></td>
								<td rowspan="2" class="sm"><input type="text" class="input" maxlength='20' dataformat='engup' name="ctr_rfa_no" id="ctr_rfa_no" style="width:90px;ime-mode:disabled" value=""></td>
								<td rowspan="2"></td>
								<th>S/Mode</th>
								<td><script type="text/javascript">ComComboObject('s_mode_ori', 1, 60, true, '');</script><!-- 
									 --><script type="text/javascript">ComComboObject('s_mode_dest', 1, 60, true, '');</script>
								</td>
							</tr>
			            	<tr>
								<th>S/Route</th>
								<td><script type="text/javascript">ComComboObject('s_route_ori', 1, 60, true, '');</script><!-- 
									 --><script type="text/javascript">ComComboObject('s_route_dest', 1, 60, true, '');</script>
								</td>
							</tr>
						</tbody>
					</table>
					<table> 
						<colgroup>
			                <col width="80"> 
			                <col width="10"> 
			                <col width="90"> 
			                <col width="190"> 
			                <col width="*">
			            </colgroup>
			            <tbody>
							<tr>
								<th rowspan="2">Booking<br/>Status</th>	
								<td></td>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_f" id="radio_bkg_sts_cd_f12" value="F"><label for="radio_bkg_sts_cd_f12">F-Firm</label></td>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_x" id="radio_bkg_sts_cd_x23" value="X"><label for="radio_bkg_sts_cd_x23">X-Cancel</label></td>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_a" id="radio_bkg_sts_cd_a124" value="A"><label for="radio_bkg_sts_cd_a124">A-Pseudo Booking</label></td>
							</tr>
							<tr>
								<td></td>
								<td><input type="checkbox" class="trans" name="bkg_sts_cd_w" id="bkg_sts_cd_w" value="W"> W-Waiting</td>
								<td>(<input type="checkbox" class="trans" name="non_sp_cargo" id="non_sp_cargo" value="Y"> Non approval of special cargo</td>
								<td><input type="checkbox" class="trans" name="holding" id="holding" value="Y"> Holding)</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			 <div class="layout_vertical_2">
				<div class="opus_design_inquiry">
					<h3 class="title_design">Feeder Vessel</h3>
					<div class="sm">
						<table> 
							<colgroup>
				                <col width="35"> 
				                <col width="157"> 
				                <col width="50"> 
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<td></td>
									<td><input type="radio" class="trans" name="fv_pre_pst_cd" id="radio_fv_pre_pst_cd56" value="PR"><label for="radio_fv_pre_pst_cd56">Pre</label><!-- 
									    --><input type="radio" class="trans" name="fv_pre_pst_cd" id="radio_fv_pre_pst_cd78" value="PO"><label for="radio_fv_pre_pst_cd78">Post</label>
								   	</td>
									<th title="Vessel Voyage Direction">VVD</th>
									<td><input type="text"  class="input2"   name="fv_vvd_cd" id="fv_vvd_cd" value=""  maxlength='9'dataformat='engup' style="width:80px;ime-mode:disabled" value="">
								</tr>
							</tbody>
						</table>
						<table>
							<colgroup>
				                <col width="40"> 
				                <col width="60"> 
				                <col width="60">
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<th title="Port of Loading">POL</th>	
									<td><input type="text" value="" name="fv_pol_cd" id="fv_pol_cd" maxlength='5' dataformat='engup' style="width:50px;ime-mode:disabled" class="input2"><!-- 
										--><input type="text" value="" class="input2" name="fv_pol_yard_cd" id="fv_pol_yard_cd" maxlength='2' dataformat='engup' style="width:25px;ime-mode:disabled"><!--  
										--><input type="checkbox" class="trans" name="fv_pol_local" id="radio_fv_pol_local87" value="Y"><label for="radio_fv_pol_local87">Local</label>
									</td>
									<th title="Port of Discharging">POD</th>
									<td><input type="text"  value="" name="fv_pod_cd" maxlength='5' dataformat='engup' style="width:50px;ime-mode:disabled" class="input2"><!-- 
										 --><input type="text"  value="" class="input2" name="fv_pod_yard_cd" maxlength='2' dataformat='engup' style="width:25px;ime-mode:disabled"><!--  
										 --><input type="checkbox" class="trans" name="fv_pod_local" id="radio_fv_pod_local54" value="Y"><label for="radio_fv_pod_local54">Local</label>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<h3 class="title_design">Customer</h3>
					<div class="sm">
						<table> 
							<colgroup>
				                <col width="10"> 
				                <col width="75"> 
				                <col width="90"> 
				                <col width="60">
				                <col width="90"> 
				                <col width="90"> 
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<td ></td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_s" id="cust_tp_cd_s" value="Y"> Shipper</td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_c" id="cust_tp_cd_c" value="Y"> Consignee</td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_n" id="cust_tp_cd_n" value="Y"> Notify</td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_f" id="cust_tp_cd_f" value="Y"> Forwarder</td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_a" id="cust_tp_cd_a" value="Y"> Also Notify</td>
									<td><input type="checkbox" class="trans" name="cust_tp_cd_g" id="cust_tp_cd_g" value="Y"> Group</td>
								</tr>
							</tbody>
						</table>
						<table>
							<colgroup>
								<col width="10"> 
				                <col width="60"> 
				                <col width="100">
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<td></td>
									<td><input type="text" style="width:30px;" class="input" name="cust_cnt_cd" value="" maxlength="2" dataformat="engup" id="cust_cnt_cd" /><!-- 
									 	 --><input type="text" style="width:55px;" class="input" maxlength="6" dataformat="num" name="cust_seq" value="" id="cust_seq" /><!-- 
										 --><input type="text" style="width:100px;" class="input" maxlength="50" dataformat="engup" otherchar="#&*()., -" name="cust_nm" value="" id="cust_nm" /><!-- 
										 --><button type="button" id="btn_customer_pop" name="btn_customer_pop" class="input_seach_btn"></button>
									 </td>
									<th>Customer Type</th>
									<td><script type="text/javascript">ComComboObject('cust_tp_cd', 1, 50, true, '');</script>
								</tr>
							</tbody>
						</table>
					</div>
					<h3 class="title_design">Special Cargo</h3>
					<div class="sm">
						<table> 
							<colgroup>
				                <col width="10"> 
				                <col width="60"> 
				                <col width="30"> 
				                <col width="60"> 
				                <col width="10"> 
				                <col width="90"> 
				                <col width="10">
				                <col width="80">
				                <col width="10"> 
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_dg" value="Y" id="sp_cargo_dg" /> Danger</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_rf" value="Y" id="sp_cargo_rf" /> Reefer</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_ak" value="Y" id="sp_cargo_ak" /> Awkward</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_bb" value="Y" id="sp_cargo_bb" /> Break Bulk</td>
									<td></td>
									<td></td>
								<tr>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_hg" value="Y" id="sp_cargo_hg" /> Hanger</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_soc" value="Y" id="sp_cargo_soc" /> S.O.C</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_eq" value="Y" id="sp_cargo_eq" /> EQ Sub</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_rd" value="Y" id="sp_cargo_rd" /> Reefer Dry</td>
									<td></td>
									<td></td>
								<tr>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_pm" value="Y" id="sp_cargo_pm" /> Premier</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_pc" value="Y" id="sp_cargo_pc" /> Pre-caution</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_fg" value="Y" id="sp_cargo_fg" /> Food Grade</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_hd" value="Y" id="sp_cargo_hd" /> Hide</td>
									<td></td>
									<td><input type="checkbox" class="trans" name="sp_cargo_rb" value="Y" id="sp_cargo_rb" /> Rail Bulk</td>
								</tr>
							</tbody>
						</table>
					</div>
					<table style="height:10px;"><tr><td></td></tr></table>
					<div class="sm">
						<table class="search_sm"> 
							<colgroup>
				                <col width="75"> 
				                <col width="25"> 
				                <col width="90"> 
				                <col width="190"> 
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<th>Cargo Type</th>	
									<td></td>
									<td><input type="checkbox" class="trans" name="cargo_tp_f" id="cargo_tp_f" value="F"> Full</td>
									<td><input type="checkbox" class="trans" name="cargo_tp_p" id="cargo_tp_p" value="P"> Empty (for E/Q reposition)</td>
									<td><input type="checkbox" class="trans" name="cargo_tp_r" id="cargo_tp_r" value="R"> Revenue Empty</td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table> 
							<colgroup>
				                <col width="100"> 
				                <col width="10"> 
				                <col width="70">
				                <col width="60"> 
				                <col width="10">  
				                <col width="10"> 
				                <col width="80">  
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<th>Memo B/L Type</th>	
									<td></td>
									<td><input type="checkbox" class="trans" id="bl_type_a" name="bl_type_a" value="Y"> ahead</td>
									<td><input type="checkbox" class="trans" id="bl_type_s" name="bl_type_s" value="Y"> short</td>
									<th>Revenue</th>
									<td></td>
									<td><input type="checkbox" class="trans" id="rev" name="rev" value="Y"> Revenue</td>
									<td><input type="checkbox" class="trans" id="non_rev" name="non_rev" value="Y"> Non-Revenue</td>
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table> 
							<colgroup>
				                <col width="60"> 
				                <col width="60"> 
				                <col width="60"> 
				                <col width="70"> 
				                <col width="*">
				            </colgroup>
				            <tbody>
								<tr>
									<th>AES/ITN</th>	
									<td>
										<input type="checkbox" class="trans" name="aes_y" id="radio_aes_n9" value="Y"><label for="radio_aes_n9">Yes</label>
									    <input type="checkbox" class="trans" name="aes_n" id="radio_aes_n8"  value="Y"><label for="radio_aes_n8">No</label>
									</td>
									<th><label for="radio_stop_cargo3">Stop Cargo</label><input type="checkbox" class="trans" id="radio_stop_cargo3" name="stop_cargo" value="Y"></th>
									<th>Roll Over</th>
									<td>
										<script type="text/javascript">ComComboObject('ro_y', 1, 100, '');</script>
									</td>
								</tr>
								<tr>
									<th>CAED</th>	
									<td>
										<input type="checkbox" class="trans" name="caed_y" id="radio_caed_y6" value="Y"><label for="radio_caed_y6">Yes</label>
			                            <input type="checkbox" class="trans" name="caed_n" id="radio_caed_n7" value="Y"><label for="radio_caed_n7">No</label>
			                        </td>
									<th><label for="radio_crn_no_flag6">CRN No.</label><input type="checkbox" class="trans" id="radio_crn_no_flag6" name="crn_no_flag" value="Y">
								</tr>
							</tbody>
						</table>
						<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
						<table>	
							<colgroup>
				                <col width="70"> 
				                <col width="10"> 
				                <col width="90"> 
				                <col width="80"> 
				                <col width="90"> 
				                <col width="100"> 
				                <col width="*">
				            </colgroup>
				            <tbody>									
								<tr>
									<th>Certificate</th>	
									<td></td>
									<td><input type="checkbox" class="trans" name="certi_d" id="certi_d" value="D"> D/G Ride</td>
									<td><input type="checkbox" class="trans" name="certi_a" id="certi_a" value="A"> A/K Ride</td>
									<td><input type="checkbox" class="trans" name="certi_b" id="certi_b" value="B"> B/B Ride</td>
									<td rowspan="2" style="background-color:#FFFFFF; text-align:center;"><input type="checkbox" class="trans" name="certi_y" id="certi_y" value="Y"> Yes&nbsp;<!--  
										--><input type="checkbox" class="trans" name="certi_n" id="certi_n" value="Y"> No
									</td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td><input type="checkbox" class="trans" name="certi_c" id="certi_c" value="C"> Certificate</td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- opus_design_inquiry(E) -->
			</div>
		</div>
	</div>
</form><!-- ********************************************* Form End  ********************************************* -->				
<div style="display: none;">
 <!-- Hidden Grid -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<%@include file="/bizcommon/include/common_opus.jsp"%>