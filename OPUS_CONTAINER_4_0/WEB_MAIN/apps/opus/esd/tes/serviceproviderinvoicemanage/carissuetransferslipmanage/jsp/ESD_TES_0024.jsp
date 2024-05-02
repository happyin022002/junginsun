<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0024.jsp
*@FileTitle  : Terminal invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event"%>
<%@ page import="com.clt.apps.opus.esd.tes.common.tescommon.basic.TESCommonBCImpl"%>
<%
	EsdTes0024Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// Errors from server.
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 // Error message.
	int rowCount	 = 0;								  // DB ResultSet list count.
	String userId  = "";
	String ofc_cd  = "";
	String cost_ofc_cd  = "";
	String usr_eml = "";
	String usr_nm  = "";
	String cnt_cd  = "";

	String inv_cfm_dt = "";
	String vndr_seq = "";
	String vndr_seq_name = "";
	String cnt_inv = "";
	String curr_cd = "";
	String total_amt = "";
	String asanogb = "";
	String pay_group_cd = "";
	String iss_dt = "";
	String rcv_dt = "";
	String gen_pay_term_cd = "";
	String gen_pay_term_desc = "";
	String payment_due_dt = "";
	String pay_term_tp_cd = "";

	String inv_sub_sys_cd = "";

	inv_cfm_dt 			 	= JSPUtil.getParameter(request, "inv_cfm_dt 			      ".trim(), "");
	vndr_seq 			  	= JSPUtil.getParameter(request, "vndr_seq 			        ".trim(), "");
	vndr_seq_name 		= JSPUtil.getParameter(request, "vndr_seq_name          ".trim(), "");
	cnt_inv 			  	= JSPUtil.getParameter(request, "cnt_inv 			        	".trim(), "");
	curr_cd 					= JSPUtil.getParameter(request, "curr_cd          			".trim(), "");
	total_amt 			  = JSPUtil.getParameter(request, "total_amt 			        ".trim(), "");
	asanogb 			 	 	= JSPUtil.getParameter(request, "asanogb 			        	".trim(), "");
	pay_group_cd 			 	= JSPUtil.getParameter(request, "pay_group_cd 			        	".trim(), "");
	iss_dt 						= JSPUtil.getParameter(request, "iss_dt          				".trim(), "");
	rcv_dt 						= JSPUtil.getParameter(request, "rcv_dt          				".trim(), "");
	gen_pay_term_cd 	= JSPUtil.getParameter(request, "gen_pay_term_cd 			  ".trim(), "");
	gen_pay_term_desc = JSPUtil.getParameter(request, "gen_pay_term_desc		  ".trim(), "");
	payment_due_dt 		= JSPUtil.getParameter(request, "payment_due_dt 			  ".trim(), "");
	pay_term_tp_cd 		= JSPUtil.getParameter(request, "pay_term_tp_cd 			  ".trim(), "");
	cost_ofc_cd 			= JSPUtil.getParameter(request, "cost_ofc_cd 			  		".trim(), "");

	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");	

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   //userAuth=account.getAuth();
	   ofc_cd=account.getOfc_cd();
	   usr_nm=account.getUsr_nm();
	   usr_eml=account.getUsr_eml();
//		cnt_cd =account.getCnt_cd();
	    cnt_cd = JSPUtil.getNull(new TESCommonBCImpl().getMDMCnt_cd(ofc_cd));

	   // ofc_cd  = "CHIBB";

		event = (EsdTes0024Event)request.getAttribute("Event");

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
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage();
	}
	var cnt_cd = "<%=cnt_cd%>";


</script>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>" id="ofc_cd" />
<input type="hidden" name="inv_ofc_cd" value="<%=ofc_cd%>" id="inv_ofc_cd" />
<input type="hidden" name="cnt_cd" value="<%=cnt_cd%>" id="cnt_cd" />
<input type="hidden" name="asanogb" value="<%=asanogb%>" id="asanogb" />
<input type="hidden" name="pay_group_cd" value="<%=pay_group_cd%>" id="pay_group_cd" />
<input type="hidden" name="csr_amt" id="csr_amt" />
<input type="hidden" name="iss_dt" value="<%=iss_dt%>" id="iss_dt" />
<input type="hidden" name="rcv_dt" value="<%=rcv_dt%>" id="rcv_dt" />
<input type="hidden" name="gen_pay_term_cd" value="<%=gen_pay_term_cd%>" id="gen_pay_term_cd" />
<input type="hidden" name="temp_payment_due_dt" value="<%=payment_due_dt%>" id="temp_payment_due_dt" />
<input type="hidden" name="pay_term_tp_cd" value="<%=pay_term_tp_cd%>" id="pay_term_tp_cd" />
<input type="hidden" name="ap_ofc_cd" id="ap_ofc_cd" />
<input type="hidden" name="usr_eml" value="<%=usr_eml%>" id="usr_eml" />
<input type="hidden" name="usr_nm" value="<%=usr_nm%>" id="usr_nm" />
<input type="hidden" name="cre_usr_id" value="<%=userId%>" id="cre_usr_id" />
<input type="hidden" name="csr_tp_cd" id="csr_tp_cd" />
<input type="hidden" name="evi_gb" id="evi_gb" />
<input type="hidden" name="inv_knt" id="inv_knt" />
<input type="hidden" name="pay_due_dt" id="pay_due_dt" />

<input type="hidden" name="tax_naid_flg" id="tax_naid_flg" />
<input type="hidden" name="finance_flg" id="finance_flg" />
<input type="hidden" name="fa_flg" id="fa_flg" />
<input type="hidden" name="tax_type" id="tax_type" />
<input type="hidden" name="tax_nsl_flg" id="tax_nsl_flg" />

<input type="hidden" name="evi_inv_dt" id="evi_inv_dt" />
<input type="hidden" name="evi_comp_no" id="evi_comp_no" />
<input type="hidden" name="evi_total_net_amt" id="evi_total_net_amt" />
<input type="hidden" name="evi_tax_no2" id="evi_tax_no2" />
<input type="hidden" name="evi_total_tax_amt" id="evi_total_tax_amt" />
<input type="hidden" name="evi_ctnt1" id="evi_ctnt1" />
<input type="hidden" name="evi_ctnt2" id="evi_ctnt2" />
<input type="hidden" name="evi_ctnt3" id="evi_ctnt3" />
<input type="hidden" name="evi_ctnt4" id="evi_ctnt4" />
<input type="hidden" name="evi_ctnt5" id="evi_ctnt5" />
<input type="hidden" name="evi_ctnt6" id="evi_ctnt6" />
<input type="hidden" name="evi_ctnt7" id="evi_ctnt7" />
<input type="hidden" name="evi_ctnt8" id="evi_ctnt8" />
<input type="hidden" name="evi_ctnt9" id="evi_ctnt9" />
<input type="hidden" name="evi_ctnt10" id="evi_ctnt10" />
<input type="hidden" name="evi_ctnt11" id="evi_ctnt11" />
<input type="hidden" name="evi_ctnt12" id="evi_ctnt12" />
<input type="hidden" name="evi_tax_no" id="evi_tax_no" />
<input type="hidden" name="evi_tax_code" id="evi_tax_code" />

<input type="hidden" name="s_tax_naid_flg" id="s_tax_naid_flg" />
<input type="hidden" name="s_finance_flg" id="s_finance_flg" />
<input type="hidden" name="s_fa_flg" id="s_fa_flg" />
<input type="hidden" name="s_tax_type" id="s_tax_type" />
<input type="hidden" name="s_tax_nsl_flg" id="s_tax_nsl_flg" />

<input type="hidden" name="s_evi_inv_dt" id="s_evi_inv_dt" />
<input type="hidden" name="s_evi_comp_no" id="s_evi_comp_no" />
<input type="hidden" name="s_evi_total_net_amt" id="s_evi_total_net_amt" />
<input type="hidden" name="s_evi_tax_no2" id="s_evi_tax_no2" />
<input type="hidden" name="s_evi_total_tax_amt" id="s_evi_total_tax_amt" />
<input type="hidden" name="s_evi_ctnt1" id="s_evi_ctnt1" />
<input type="hidden" name="s_evi_ctnt2" id="s_evi_ctnt2" />
<input type="hidden" name="s_evi_ctnt3" id="s_evi_ctnt3" />
<input type="hidden" name="s_evi_ctnt4" id="s_evi_ctnt4" />
<input type="hidden" name="s_evi_ctnt5" id="s_evi_ctnt5" />
<input type="hidden" name="s_evi_ctnt6" id="s_evi_ctnt6" />
<input type="hidden" name="s_evi_ctnt7" id="s_evi_ctnt7" />
<input type="hidden" name="s_evi_ctnt8" id="s_evi_ctnt8" />
<input type="hidden" name="s_evi_ctnt9" id="s_evi_ctnt9" />
<input type="hidden" name="s_evi_ctnt10" id="s_evi_ctnt10" />
<input type="hidden" name="s_evi_ctnt11" id="s_evi_ctnt11" />
<input type="hidden" name="s_evi_ctnt12" id="s_evi_ctnt12" />
<input type="hidden" name="s_evi_tax_no" id="s_evi_tax_no" />
<input type="hidden" name="s_evi_tax_code" id="s_evi_tax_code" />

<input type="hidden" name="eviInputFlg" id="eviInputFlg" />
<input type="hidden" name="s_eviInputFlg" id="s_eviInputFlg" />

<input type="hidden" name="attr_ctnt8" id="attr_ctnt8" />

<input type="hidden" name="aproSeqKey" value="<%=com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(cost_ofc_cd, inv_sub_sys_cd) %>" id="aproSeqKey" />


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>CSR Creation(Detail)</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span >Service Management > TML INV > Invoice > CSR Creation > CSR Creation > CSR Creation(Detail)</span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>			
			<colgroup>
				<col width="70" />
				<col width="130" />
				<col width="170" />				
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Cost Office</th>
					<td><input name="cost_ofc_cd" type="text" style="width:60px;" value="<%=cost_ofc_cd%>" id="cost_ofc_cd" /></td>
					<th>Payment Service Provider</th>
					<td><input name="vndr_seq" id="vndr_seq" type="text" style="width:70px" value="<%=vndr_seq%>"><input name="vndr_seq_name" id="vndr_seq_name" type="text" style="width:380px" value="<%=vndr_seq_name%>"></td>
					<td id="EDILayer01" style="display:none">
						<button class="btn_etc" id="btn_EDIinvoiceview" name="btn_EDIinvoiceview">EDI Invoice Print</button>
					</td>
				</tr>
			</tbody>			
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<div class="opus_design_btn" id="btLayer" style="display:none">
			<button type="button" class="btn_accent" name="btng_preview" 	id="btng_preview">Preview</button><!--
			--><button type="button" class="btn_normal" name="btng_print" id="btng_print" style="display:none;">Print</button><!--
			--><button type="button" class="btn_normal" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</button><!--
		--></div>
		<div class="opus_design_btn" id="btLayer" style="display:none">
			<button type="button" class="btn_accent" name="btng_evidence" 	id="btng_evidence">증빙</button><!--
			--><button type="button" class="btn_normal" name="btng_preview" id="btng_preview">Preview</button><!--
			--><button type="button" class="btn_normal" name="btng_print" id="btng_print">Print</button><!--
			--><button type="button" class="btn_normal" name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</button><!--
		--></div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>				
<div class= "wrap_search">
	
	<div class="opus_design_inquiry">
	   <!-- layout_flex_fixed(S) -->
	   
		<!-- opus_design_inquiry(S) -->			
			<table>					
				<colgroup>
					<col width="100" />
					<col width="115" />
					<col width="110" />
					<col width="110" />
					<col width="95" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>NO Of Invoice</th>
						<td><input name="cnt_inv" type="text" style="width:75px;" value="" id="cnt_inv" /></td>
						<th>Invoice Currency</th>
						<td><input name="curr_cd" type="text" style="width:75px;" value="<%=curr_cd%>" id="curr_cd" /></td>
						<th>Total Amount</th>
						<td><input name="total_amt" type="text" style="width:110px;" value="" id="total_amt" /></td>
					</tr>		
				</tbody>					
			</table>
		
		<!-- opus_design_inquiry(E) -->
		
		<div class="layout_flex_flex" style="padding-left:608px ; float:right;"> <!-- (fixed Width) + (padding 8px) = 408 -->
			<div id="srLayer" style="display:none">
				<table class="search">
					<tr>
						<th width=185>ASA NO</th>
						<td><script type="text/javascript">ComComboObject('asa_no', 1, 110 , 0 )</script></td>
					</tr>
				</table>
			</div>
			<div id="srLayer" style="display:none">
				<table class="search">
					<tr>
						<th>증빙구분</th>
						<td width="">&nbsp;<select style="width:93px;" name="evi_gb1" id="evi_gb1" onChange="eviGbSelect(1)">
							<option value="1">세금계산서</option>
							<option value="2">계산서</option>
							<option value="3">기타</option>
							</select></td>
						<td></td>
					</tr>
				</table>
			</div>
			<div id="srLayer" style="display:none">
				<table>
					<tr>
						<th>ASA NO</th>
						<!-- td><script type="text/javascript">ComComboObject('asa_no',1, 90 , 0 )</script></td -->
						<th>증빙구분</th>
						<td><select style="width:90px;" name="evi_gb2" id="evi_gb2" onChange="eviGbSelect(2)">
							<option value="1">세금계산서</option>
							<option value="2">계산서</option>
							<option value="3">기타</option>
							</select></td>
					</tr>
				</table>

			</div>
		</div>
		
			<table>					
				<colgroup>
					<col width="100" />
					<col width="115" />
					<col width="110" />
					<col width="110" />
					<col width="95" />
					<col width="150" />
					<col width="120" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>Issued Date</th>
						<td><input name="max_iss_dt" type="text" style="width:75px;" value="" maxlength="10" onkeyup="tes_isNumD(this,"Y");" onkeydown="tes_chkInput(this); tes_isNumD(this,&quot;Y&quot;);" onblur="validateDateObj2(this);" id="max_iss_dt" /> </td>
						<th>Received Date</th>
						<td><input name="max_rcv_dt" type="text" style="width:75px;" value="" maxlength="10" onkeyup="tes_isNumD(this,"Y");" onkeydown="tes_chkInput(this); tes_isNumD(this,&quot;Y&quot;);" onblur="validateDateObj(this);" id="max_rcv_dt" /> </td>
						<th>Payment Term</th>
						<td><input name="gen_pay_term_desc" type="text" style="width:110px;" value="<%=gen_pay_term_desc%>" id="gen_pay_term_desc" /> </td>
						<th>Payment Due Date</th>
						<td><input name="payment_due_dt" type="text" style="width:75px;" maxlength="10" value="" onkeyup="tes_isNumD(this,"Y");" onkeydown="tes_chkInput(this); tes_isNumD(this,&quot;Y&quot;);" onblur="if(this.value!=null&amp;&amp;this.value!=&quot;&quot;){validateDateObj2(this);}" id="payment_due_dt" /> </td>
					</tr>
					<tr>
						<th>CSR NO</th>
						<td colspan="7"><input name="csr_no" type="text" style="width:882px;" value="" id="csr_no" /> </td>
					</tr>
				</tbody>
				
			</table>			
	</div>	
</div>
</form>
<DIV style="display:none">
	<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		 <script type="text/javascript">ComSheetObject('sheet2');</script>
         <script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
                            
</DIV>