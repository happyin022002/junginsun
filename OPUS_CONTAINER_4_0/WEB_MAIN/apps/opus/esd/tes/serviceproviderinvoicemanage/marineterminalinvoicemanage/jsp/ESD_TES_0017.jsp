<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0017.jsp
*@FileTitle  : Marine Terminal Container List Retrieve
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0017Event"%>
<%
	EsdTes0017Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount = 0;						//DB ResultSet Count

	String inv_no ="";
	String vndr_seq ="";
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq	= JSPUtil.getNull(request.getParameter("vndr_seq"));

	//Add ofc_cd permission 
	String cre_ofc_cd = "";
	String cntCd = "";

	try {
	   	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    cre_ofc_cd = account.getOfc_cd();	    
	    cntCd = account.getCnt_cd();

		event	= (EsdTes0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{

		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var inv_no = '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';

	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD00823", 0, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		// InitTab();

		loadPage();
	}
</script>
<form method="post" name="form" onSubmit="return false;">
<input type="text" style="display:none"  name="f_cmd" id="f_cmd" />
<input type="text" style="display:none"  name="iPage" id="iPage" />
<input type="text" style="display:none"  name="tml_so_ofc_cty_cd" id="tml_so_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_so_seq" id="tml_so_seq" />
<input type="text" style="display:none"  name="is_valid_vndr_seq" id="is_valid_vndr_seq" />
<input type="text" style="display:none"  name="vndr_seq_hidden" id="vndr_seq_hidden" />
<input type="text" style="display:none"  name="is_inq" value="INQ" id="is_inq" />
<input type="text" style="display:none"  name="cost_calc_mode" value="R" id="cost_calc_mode" />
<input type="text" style="display:none"  name="hld_rmk" id="hld_rmk" />

<!-- Add ofc_cd permission -->
<input type="text" style="display:none"  name="no_ofc_cd" value="" id="no_ofc_cd" />
<input type="text" style="display:none"  name="act_tp" value="INV" id="act_tp" />
<input type="text" style="display:none"  name="no_yd_cd" value="" id="no_yd_cd" />
<input type="text" style="display:none"  name="auth_ofc_cd" value="" id="auth_ofc_cd" />
<input type="text" style="display:none"  name="cre_ofc_cd" value="<%=cre_ofc_cd %>" id="cre_ofc_cd" />

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value="MT"> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 

<!-- special character, characterSet problem. //-->
<input type="text" style="display:none"  name="inv_no_tmp" value="<%=JSPUtil.getNull(inv_no)%>" id="inv_no_tmp" />

<input type="text" style="display:none" name="cntCd" id="cntCd" value="<%=JSPUtil.getNull(cntCd)%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --> <button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>

<!-- page_title_area(E) -->

<!-- wrap_search(S) -->  
<div class="wrap_search_tab">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<!-- : ( Week ) (S) -->
		<table>
			<colgroup>
				<col width="100">
				<col width="206">
				<col width="50">				
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Invoice NO</th>
				<td><input class="input1" type="text" name="inv_no" id="inv_no" maxlength="30" style="width:172px" ></td>
				<th>Service Provider Code</th>
				<td>
				<!-- <input class="input1" type="text" name="vndr_seq" id="vndr_seq" maxlength="6" style="width:78px" onKeyDown='tes_isNum(this);' onKeyUp='tes_isNum(this);' onBlur='chkInput(this);'> -->
				<input class="input1" type="text" name="vndr_seq" id="vndr_seq" maxlength="6" style="width:78px" onBlur='chkInput(this);' /><!-- 
				--><button type="button" class="input_seach_btn" name="btn_vndr" id="btn_vndr" ></button><!-- 
				--><input class="input1" type="text" name="vndr_seq_name" id="vndr_seq_name" style="width:368px" readonly /></td>				
			</tr>
		</table>
		<!-- : ( Week ) (E) -->
	</div>
	<div class="line_bluedot"></div>
	<div class="opus_design_inquiry wFit">	
		<table>
			<colgroup>
				<col width="100">
				<col width="150">
				<col width="50">
				<col width="150">
				<col width="50">
				<col width="150">
				<col width="50">
				<col width="*">
			</colgroup>
      				<tr>
      					<th>Cost Office</th>
      					<td><input name="cost_ofc_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>Invoice Office</th>
						<td><input name="inv_ofc_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>Yard Code</th>
      					<td><input name="yd_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
						<th>Yard Name</th>
      					<td><input name="yd_nm" type="text" class="input2" style="width:80px" value="" readonly></td>
      				</tr>
      				<tr>
      					<th>Invoice Status</th>
      					<td><input name="tml_inv_sts_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>Reject Status</th>
						<td><input name="tml_inv_rjct_sts_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>Payment Status</th>
      					<td><input name="pay_flg" type="text" class="input2" style="width:80px" value="" readonly></td>
						<th>Currency</th>
     					<td><input name="curr_cd" type="text" class="input2" style="width:80px" value="" readonly></td>
      				</tr>
					<tr>
      					<th>Hold Status</th>      					      				
				     	<td><input name="hld_flg" type="text" class="input2" style="width:18px" value="" readonly>
				     	<button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button></td>
      					<th>Issued Date</th>
						<td><input name="iss_dt" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>Received Date</th>
      					<td><input name="rcv_dt" type="text" class="input2" style="width:80px" value="" readonly></td>
						<th>Payment Due Date</th>
      					<td><input name="pay_due_dt" type="text" class="input2" style="width:80px" value="" readonly></td>
      				</tr>
					<tr>
					<td colspan=8>
					<table>
					<colgroup>
						<col width="100">
						<col width="135">
						<col width="100">
						<col width="150">
						
						<col width="60">
						<col width="90">
						<col width="50">
						<col width="100">
						<col width="50">
						<col width="*">
					</colgroup>					
						<th>AGMT COST CD</th>
						<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 91, 1, 1)</script></td>	
      					<th>Invoice Amount</th>
      					<td><input name="ttl_inv_amt" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>V.A.T</th>
						<td><input name="vat_amt" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>W.H.T</th>
      					<td><input name="whld_tax_amt" type="text" class="input2" style="width:80px" value="" readonly></td>
      					<th>ACC VOL</th>
      					<td><input name="pay_vol_qty" type="text" class="input2" style="width:80px" value="" readonly></td>					
					</table>
					</td>

     				</tr>
      		</table>
      	</div>
     	<div class="line_bluedot"></div>
      	<div class="opus_design_inquiry wFit">
      		<!-- : ( Week ) (S) -->
			<table>
				<colgroup>
					<col width="100">
					<col width="180">
					<col width="50">
					<col width="220">
					<col width="50">						
					<col width="*">
				</colgroup>
				<tr class="h23">
					
					<th>VVD/BND</th>
					<td><input type="text" name="vvd" style="width:100px" value="" readonly><input type="text" name="io_bnd_cd" style="width:20px" value="" readonly>
					<th>ATB</th>
					<td><input type="text" name="atb_dt" style="width:80px" value="" readonly><button type="button" class="btn_left" name="btng_back" id="btng_back"></button><button type="button" class="btn_right" name="btng_next" id="btng_next"></button><input type="text" name="page" style="width:40px;text-align:center;" value="" readonly></td>
					<th>Calculated AMT(VVD/TTL)</th>
					<td><input type="text" name="vvd_inv_amt" style="width:52px;text-align:right;" value="" readonly>/ <input type="text" name="tot_inv_amt" style="width:52px;text-align:right;" value="" readonly></td>
				</tr>
			</table>
			<!-- : ( Week ) (E) -->
		
	</div>
	<!-- opus_design_inquiry (E) -->
</div>
<!-- wrap_search(E) --> 
 
<!-- wrap_result(S) -->
<div class="wrap_result">
	
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript"> ComTabObject ('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- UI_ESD_TES_0017 : THIS IS 1st TAB -->
	<div id="tabLayer" style="display:inline">
	<!-- : ( Grid : Week ) (S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
			<!-- Content -->
				<button type="button" class="btn_normal" name="btng_totalamount" id="btng_totalamount">Total Amount</button>
			</div>
			<!-- opus_design_btn(e) -->
			
			<script type="text/javascript">ComSheetObject('t1sheet1');</script>
		</div>
		
		<div id="SearchLayer01" style="display:inline">
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		</div>
		<table class="sbutton">
	    	<tr><td class="bt"><button type="button" class="btn_up" onClick="reSize();" id="updown"></button></td></tr>
		</table>
		
		<!-- opus_design_data(S) -->
		<div class="opus_design_data wFit">
			<div id="SearchLayer02" style="display:inline">
			<table style="margin-bottom: 3px" class="grid2">
				<tbody>
				<tr class="h23">
					<th width="4%">Total</th>
					<td width="15%"><input type="text"  name="sht_01_ttl" style="width:80" readonly></td>
					<th width="3%">Full</th>
					<td width="14%"><input type="text" name="sht_01_full" style="width:80" readonly></td>
					<th width="5%">Empty</th>
					<td width="14%"><input type="text" name="sht_01_mt" style="width:80" readonly></td>
					<th width="13%">TS(Same Yard)</th>
					<td><input type="text" name="sht_01_ts_same_yard" style="width:80" readonly></td>

				</tr>
				</tbody>
			</table>


			<table class="grid2">
				<tr class="h23">
					<th  width="18">D2 </th><td style="padding-bottom: 2px;" width="40"><input type="text" name="sht_01_D2" style="width:32px" readonly></td>
					<th width="18">D4 </th><td width="40"><input type="text" name="sht_01_D4" style="width:32px" readonly></td>
					<th width="18">D5 </th><td width="40"><input type="text" name="sht_01_D5" style="width:32px" readonly></td>
					<th width="18">D7 </th><td width="40"><input type="text" name="sht_01_D7" style="width:32px" readonly></td>
					<th width="18">D8 </th><td width="40"><input type="text" name="sht_01_D8" style="width:32px" readonly></td>
					<th width="18">D9 </th><td width="40"><input type="text" name="sht_01_D9" style="width:32px" readonly></td>
					<!-- 
					<th width="18">DW </th><td width="40"><input type="text" name="sht_01_DW" style="width:32px" readonly></td>
					<th width="18">DX </th><td width="40"><input type="text" name="sht_01_DX" style="width:32px" readonly></td>
					 -->
					<th width="18">R2 </th><td width="40"><input type="text" name="sht_01_R2" style="width:32px" readonly></td>
					<th width="18">R4 </th><td width="40"><input type="text" name="sht_01_R4" style="width:32px" readonly></td>
					<th width="18">R5 </th><td width="40"><input type="text" name="sht_01_R5" style="width:32px" readonly></td>
					<th width="18">F2 </th><td width="40"><input type="text" name="sht_01_F2" style="width:32px" readonly></td>
					<th width="18">F4 </th><td width="40"><input type="text" name="sht_01_F4" style="width:32px" readonly></td>
					<th width="18">F5 </th><td width="40"><input type="text" name="sht_01_F5" style="width:32px" readonly></td></tr>
				<tr class="h23">
					<th>O2</th><td><input type="text" name="sht_01_O2" style="width:32px" readonly></td>
					<th>O4</th><td><input type="text" name="sht_01_O4" style="width:32px" readonly></td>
					<th>S2</th><td><input type="text" name="sht_01_S2" style="width:32px" readonly></td>
					<th>S4</th><td><input type="text" name="sht_01_S4" style="width:32px" readonly></td>
					<th>T2</th><td><input type="text" name="sht_01_T2" style="width:32px" readonly></td>
					<th>T4</th><td><input type="text" name="sht_01_T4" style="width:32px" readonly></td>
					<th>A2</th><td><input type="text" name="sht_01_A2" style="width:32px" readonly></td>
					<th>A4</th><td><input type="text" name="sht_01_A4" style="width:32px" readonly></td>
					<th>P2</th><td><input type="text" name="sht_01_P2" style="width:32px" readonly></td>
					<th>P4</th><td><input type="text" name="sht_01_P4" style="width:32px" readonly></td>
					<th>Z2</th><td><input type="text" name="sht_01_Z2" style="width:32px" readonly></td>
					<th>Z4</th><td colspan="1"><input type="text" name="sht_01_Z4" style="width:32px" readonly></td>
				</tr>
			</table>
			</div>
		</div>
		<!-- opus_design_data(E) -->
	</div>
	<!-- tabLayer(E) -->

	<!-- UI_ESD_TES_0017 : THIS IS 2st TAB -->
	<div id="tabLayer" style="display:none">
		<div class="wrap_result">
			<div class="opus_design_grid">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
				<!-- Content -->
					<button type="button" class="btn_normal" name="btng_totalamount" id="btng_totalamount">Total Amount</button>
				</div>
				<!-- opus_design_btn(e) -->
				
				<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>	
	</div>
	<!-- UI_ESD_TES_0017 : THIS IS 2st TAB (E) -->

	<!-- UI_ESD_TES_0017 : THIS IS 3st TAB -->
	<div id="tabLayer" style="display:none">
		<div class="wrap_result">
			<div class="opus_design_grid">
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
				<!-- Content -->
					<button type="button" class="btn_normal" name="btng_totalamount" id="btng_totalamount">Total Amount</button>
				</div>
				<!-- opus_design_btn(e) -->
				
				<script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
		</div>	
	</div>
	
	<!-- UI_ESD_TES_0017 : THIS IS 2st TAB (E) -->
	<div id="hidden_sheets1" style="display:none;">
	<script type="text/javascript">ComSheetObject('main_hidden');</script>
	</div>
	
	<div id="hidden_sheets3" style="display:none;">
	<script type="text/javascript">ComSheetObject('vvd_hidden');</script>
	</div><!--accumulate_hidden : docObjects[5]-->
	
	<div id="hidden_sheets4" style="display:none;">
	<script type="text/javascript">ComSheetObject('accm_hidden');</script>
	</div>
	
	<div id="hidden_sheets10" style="display:none;">
	<script type="text/javascript">ComSheetObject('total_hidden');</script>
	</div>
</div>

</form>
