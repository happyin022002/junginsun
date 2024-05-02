.<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0019.jsp
*@FileTitle  : Marine Terminal Storage Container List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0019Event"%>
<%
	EsdTes0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String inv_no = "";
	String vndr_seq = "";	
	
	inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	vndr_seq = JSPUtil.getNull(request.getParameter("vndr_seq"));

	String cre_ofc_cd = "";
	String cntCd = "";
	
	try {
	   	SignOnUserAccount account	= (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	    cre_ofc_cd = account.getOfc_cd();
	    cntCd = account.getCnt_cd();

	    event = (EsdTes0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var inv_no = '<%=JSPUtil.getNull(inv_no)%>';
	var vndr_seq = '<%=JSPUtil.getNull(vndr_seq)%>';
	<%= JSPUtil.getIBCodeCombo("dscr_ind_cd"    , "01", "CD20038", 0, "")%>
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<SCRIPT type="text/javascript" FOR="document" EVENT="onkeydown">
      <!--
          //enterKeyMaxLengthNextFocus();
      //-->
</SCRIPT>

<form method="post" name="form" onSubmit="return false;">
<input type="text" style="display:none"  name="f_cmd" id="f_cmd" />
<input type="text" style="display:none"  name="iPage" id="iPage" />
<input type="text" style="display:none"  name="tml_so_ofc_cty_cd" value="" id="tml_so_ofc_cty_cd" />
<input type="text" style="display:none"  name="tml_so_seq" value="" id="tml_so_seq" />
<input type="text" style="display:none"  name="is_valid_vndr_seq" id="is_valid_vndr_seq" />
<input type="text" style="display:none"  name="vndr_seq_hidden" id="vndr_seq_hidden" />
<input type="text" style="display:none"  name="tml_inv_tp_cd" value="" id="tml_inv_tp_cd" />
<input type="text" style="display:none"  name="hld_rmk" value="" id="hld_rmk" />

<!-- Add ofc_cd permission -->
<input type="text" style="display:none"  name="no_ofc_cd" value="" id="no_ofc_cd" />
<input type="text" style="display:none"  name="act_tp" value="INV" id="act_tp" />
<input type="text" style="display:none"  name="no_yd_cd" value="" id="no_yd_cd" />
<input type="text" style="display:none"  name="auth_ofc_cd" value="" id="auth_ofc_cd" />
<input type="text" style="display:none"  name="cre_ofc_cd" value="<%=cre_ofc_cd %>" id="cre_ofc_cd" />
<input type="text" style="display:none"  name="inv_no_tmp" value="<%=JSPUtil.getNull(inv_no)%>" />

<input type="text" style="display:none" 	name="agmt_ftr_inv_tp_cd" value="ST"> 
<input type="text" style="display:none" 	name="cost_cd_ftr_rmk" value=""> 

<input type="text" style="display:none" name="cntCd" id="cntCd" value="<%=JSPUtil.getNull(cntCd)%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab" style="margin-top:-15px;">
	<div class= "opus_design_inquiry">
		<table class="wFit">
			<tbody>
					<colgroup>
						<col width="1px"/>
						<col width="150px"/>
						<col width="150px"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th>Invoice NO</th>
						<td><input class="input1" type="text" style="width:172px" name="inv_no" id="inv_no" maxlength="30"/></td>
						<th>Service Provider Code</th>
						<td><input class="input1" type="text" name="vndr_seq"  id="vndr_seq"  maxlength=6 style="width:78px" onKeyDown='tes_isNum(this);' onKeyUp='tes_isNum(this);' onBlur='chkInput(this);'><!-- 
						--><button type="button" class="input_seach_btn" name='btn_vndr' id='btn_vndr'></button><!-- 
						--><input class="input1" type="text" name="vndr_seq_name" id="vndr_seq_name" style="width:378px" readonly></td>
					</tr>
			</tbody>
		</table>
       <div class="line_bluedot"></div>
		<table class="wFit">
			<tbody>
				<colgroup>
					<col width="1px"/>
					<col width="100px"/>
					<col width="110px"/>
					<col width="100px"/>
					<col width="122px"/>
					<col width="100px"/>
					<col width="126px"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>Cost Office</th>
        			<td><input name="cost_ofc_cd" type="text" class="input2" style="width:100px;" value="" readonly id="cost_ofc_cd" /> </td>
        			<th>Invoice Office</th>
					<td><input name="inv_ofc_cd" type="text" class="input2" style="width:100px;" value="" readonly id="inv_ofc_cd" /> </td>
        			<th>Yard Code</th>
        			<td><input name="yd_cd" type="text" class="input2" style="width:100px;" value="" readonly id="yd_cd" /> </td>
					<th>Yard Name</th>
        			<td><input name="yd_nm" type="text" class="input2" style="width:100px;" value="" readonly id="yd_nm" /> </td>						
				</tr>	
				
				<tr>
    				<th >Hold Status</th>
					<td ><input name="hld_flg" type="text" class="input2" style="width:18px;" value="" readonly id="hld_flg" />
						<button type="button" class="btn_etc" name="btns_remarks" id="btns_remarks">Remarks</button> </td>
					<th >Issued Date</th>
					<td ><input name="iss_dt" type="text" class="input2" style="width:100px;" value="" readonly id="iss_dt" /> </td>
        			<th >Received Date</th>
        			<td ><input name="rcv_dt" type="text" class="input2" style="width:100px;" value="" readonly id="rcv_dt" /> </td>
					<th >Effective Date</th>
        			<td ><input name="eff_dt" type="text" class="input2" style="width:100px;" value="" readonly id="eff_dt" /> </td>
        		</tr>
        		<tr>
        			<th>Invoice Amount</th>
        			<td><input name="ttl_inv_amt" type="text" class="input2" style="width:100px;" value="" readonly id="ttl_inv_amt" /> </td>
        			<th>V.A.T</th>
					<td><input name="vat_amt" type="text" class="input2" style="width:100px;" value="" readonly id="vat_amt" /> </td>
        			<th>W.H.T</th>
        			<td><input name="whld_tax_amt" type="text" class="input2" style="width:100px;" value="" readonly id="whld_tax_amt" /> </td>
        			<th>Payment Due Date</th>
        			<td><input name="pay_due_dt" type="text" class="input2" style="width:100px;" value="" readonly id="pay_due_dt" /> </td>
        		</tr>
        		
        		<tr>
					<th>AGMT COST CD</th>
					<td><script type="text/javascript">ComComboObject('agmt_lgs_cost_cd', 2, 100, 1, 1)</script></td>									
        			<th>Reject Status</th>
        			<td><input name="tml_inv_rjct_sts_cd" type="text" class="input2" style="width:100px;" value="" id="tml_inv_rjct_sts_cd" /> </td>
					<th>Period</th>
        			<td colspan="3"><input name="fm_prd_dt" type="text" class="input2" style="width:200px;" value="" readonly id="fm_prd_dt" /> </td>
        		</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
	<!-- opus_tab_btn(E) -->
	
		<div id="tabLayer" style="display:inline">
			<div class="opus_design_grid clear" >
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btng_totalamount" 	id="btng_totalamount">Total Amount</button>			
				</div>
				<script type="text/javascript">ComSheetObject('t1sheet1');</script>
			</div>
			<div class="opus_design_inquiry">
				<table class="grid2 wFit">
				<tbody>
					<colgroup>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="40px"/>
						<col width="18px"/>
						<col width="*"/>
				    </colgroup>
					<tr>
						<th colspan="3">Total</th>
						<td colspan="3"><input type="text" name='sht_01_ttl_box' value='' style="width:80px" class="input2" readonly></td>
						<th colspan="1">Full</th>
						<td colspan="3"><input type="text" name='sht_01_full' value='' style="width:80px" class="input2" readonly></td>
						<th colspan="3">Empty</th>
						<td colspan="3"><input type="text" name='sht_01_mt' style="width:80px" class="input2" readonly></td>
						<th colspan="5">TS(Same Yard)</th>
						<td colspan="7"><input type="text" name='sht_01_ts_same_yard' style="width:80px" class="input2" readonly></td>
					</tr> 
					<tr>
						<th>D2 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D2" readonly id="sht_01_D2" /> </td>
						<th>D4 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D4" readonly id="sht_01_D4" /> </td>
						<th>D5 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D5" readonly id="sht_01_D5" /> </td>
						<th>D7 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D7" readonly id="sht_01_D7" /> </td>
						<th>D8 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D8" readonly id="sht_01_D8" /> </td>
						<th>D9 </th>
						<td><input type="text" style="width:32px;" name="sht_01_D9" readonly id="sht_01_D9" /> </td>
						<!-- 
						<th>DW </th>
						<td><input type="text" style="width:32px;" name="sht_01_DW" readonly id="sht_01_DW" /> </td>
						<th>DX </th>
						<td><input type="text" style="width:32px;" name="sht_01_DX" readonly id="sht_01_DX" /> </td>
						-->
						<th>R2 </th>
						<td><input type="text" style="width:32px;" name="sht_01_R2" readonly id="sht_01_R2" /> </td>
						<th>R4 </th>
						<td><input type="text" style="width:32px;" name="sht_01_R4" readonly id="sht_01_R4" /> </td>
						<th>R5 </th>
						<td><input type="text" style="width:32px;" name="sht_01_R5" readonly id="sht_01_R5" /> </td>
						<th>F2 </th>
						<td><input type="text" style="width:32px;" name="sht_01_F2" readonly id="sht_01_F2" /> </td>
						<th>F4 </th>
						<td><input type="text" style="width:32px;" name="sht_01_F4" readonly id="sht_01_F4" /> </td>
						<th>F5 </th>
						<td><input type="text" style="width:32px;" name="sht_01_F5" readonly id="sht_01_F5" /> </td>
					</tr>
					<tr>
						<th>O2</th>
						<td><input type="text" name="sht_01_O2" style="width:32px;" readonly id="sht_01_O2" /> </td>
						<th>O4</th>
						<td><input type="text" name="sht_01_O4" style="width:32px;" readonly id="sht_01_O4" /> </td>
						<th>S2</th>
						<td><input type="text" name="sht_01_S2" style="width:32px;" readonly id="sht_01_S2" /> </td>
						<th>S4</th>
						<td><input type="text" name="sht_01_S4" style="width:32px;" readonly id="sht_01_S4" /> </td>
						<th>T2</th>
						<td><input type="text" name="sht_01_T2" style="width:32px;" readonly id="sht_01_T2" /> </td>
						<th>T4</th>
						<td><input type="text" name="sht_01_T4" style="width:32px;" readonly id="sht_01_T4" /> </td>
						<th>A2</th>
						<td><input type="text" name="sht_01_A2" style="width:32px;" readonly id="sht_01_A2" /> </td>
						<th>A4</th>
						<td><input type="text" name="sht_01_A4" style="width:32px;" readonly id="sht_01_A4" /> </td>
						<th>P2</th>
						<td><input type="text" name="sht_01_P2" style="width:32px;" readonly id="sht_01_P2" /> </td>
						<th>P4</th>
						<td><input type="text" name="sht_01_P4" style="width:32px;" readonly id="sht_01_P4" /> </td>
						<th>Z2</th>
						<td><input type="text" name="sht_01_Z2" style="width:32px;" readonly id="sht_01_Z2" /> </td>
						<th>Z4</th>
						<td colspan="1"><input type="text" name="sht_01_Z4" style="width:32px;" readonly id="sht_01_Z4" /> </td>
					
					</tr>
				</tbody>
			</table>
			</div>		
		</div>
		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
					<div class="opus_design_btn">
						<button type="button" class="btn_normal" name="btng_totalamount" 	id="btng_totalamount">Total Amount</button>			
					</div> 
					<script type="text/javascript">ComSheetObject('t2sheet1');</script>
			</div>
		</div>

		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
					<table class="mar_btm_8">
						<colgroup>
							<col width="100px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>Calculated AMT</th><td><input type="text" name="ttl_calc_amt1" style="width:100px;text-align:right;" readOnly></td></tr>
					</table>
					<div class="opus_design_btn"  style="margin-top:-25px !important;">
						<button type="button" class="btn_normal" name="btng_totalamount" 	id="btng_totalamount">Total Amount</button>			
					</div>
					<script type="text/javascript">ComSheetObject('t3sheet1');</script>
			</div>
		</div>

		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
					<table class="mar_btm_8">
						<colgroup>
							<col width="100px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>Calculated AMT</th><td><input type="text" name="ttl_calc_amt2" style="width:100;text-align:right;" readonly></td></tr>
					</table>
					<div class="opus_design_btn" style="margin-top:-25px !important;">
						<button type="button" class="btn_normal" name="btng_totalamount" 	id="btng_totalamount">Total Amount</button>			
					</div>
					<script type="text/javascript">ComSheetObject('t4sheet1');</script>
			</div>
		</div>
		
		<div id="main_hidden_sheets" style="display:none;">
		<script type="text/javascript">ComSheetObject('main_hidden');</script>
		</div>

		<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
					<table class="mar_btm_8">
						<colgroup>
							<col width="100px"/>
							<col width="*"/>
			    		</colgroup>
						<tr>
							<th>Calculated AMT</th><td><input type="text" name="ttl_calc_amt3" style="width:100px;text-align:right;" readOnly></td></tr>
					</table>
					<div class="opus_design_btn"  style="margin-top:-25px !important;">
						<button type="button" class="btn_normal" name="btng_totalamount" 	id="btng_totalamount">Total Amount</button>			
					</div>
					<script type="text/javascript">ComSheetObject('t5sheet1');</script>
			</div>
		</div>
</div>
</form>

