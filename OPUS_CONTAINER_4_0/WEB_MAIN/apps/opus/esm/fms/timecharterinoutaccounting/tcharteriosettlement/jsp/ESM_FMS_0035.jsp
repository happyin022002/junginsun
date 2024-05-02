<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0035.jsp
*@FileTitle  : Prepayments Settlement
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/20
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0035Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOfc_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOSettlement");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();

		event = (EsmFms0035Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="slp_tp_cd" value="07" id="slp_tp_cd" />
<input type="hidden" name="slp_func_cd" value="S" id="slp_func_cd" />
<input type="hidden" name="slp_desc" id="slp_desc" />
<input type="hidden" name="org_slip_no" id="org_slip_no" />
<input type="hidden" name="ctr_cd" id="ctr_cd" />
<input type="hidden" name="slp_loc_cd" id="slp_loc_cd" />
<input type="hidden" name="acct_cd" id="acct_cd" />
<input type="hidden" name="slp_amt" id="slp_amt" />
<input type="hidden" name="org_slp_tp_cd" id="org_slp_tp_cd" />
<input type="hidden" name="org_slp_func_cd" id="org_slp_func_cd" />
<input type="hidden" name="org_slp_ofc_cd" id="org_slp_ofc_cd" />
<input type="hidden" name="org_slp_iss_dt" id="org_slp_iss_dt" />
<input type="hidden" name="org_slp_ser_no" id="org_slp_ser_no" />
<input type="hidden" name="org_slp_seq_no" id="org_slp_seq_no" />
<input type="hidden" name="vvd_exp_dt" id="vvd_exp_dt" />
<input type="hidden" name="vvd_eff_dt" id="vvd_eff_dt" />
<input type="hidden" name="ppay_hir_no" id="ppay_hir_no" />
<input type="hidden" name="inv_seq" id="inv_seq" />
<input type="hidden" name="csr_type" value="AP" id="csr_type" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Consultation Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Consultation Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Consultation Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_retrieve" id="btn_retrieve" type="button">Prepayment Search</button><!--
	--><button class="btn_normal" name="btn_slipInquiry" id="btn_slipInquiry" type="button">Slip Inquiry</button><!--
	--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
	--></div>
<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90" />				
				<col width="255" />				
				<col width="78" />				
				<col width="197" />				
				<col width="90" />				
				<col width="85" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Vessel Code</th>
					<!--  2010.11.24 이상민 vsl_cd dataformat="engup" 삭제 -->
					<td><input type="text" value="" style="width:56px;text-align:center;" class="input1" dataformat="engup" maxlength="4" name="vsl_cd" required="" fullfill="" caption="Vessel Code" id="vsl_cd" /><button type="button" id="btn_vslpop" name="btn_vslpop" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="vsl_eng_nm" value="" readonly id="vsl_eng_nm" /> </td>
					<th>Contract No.</th>
					<td><input type="text" value="" style="width:120px;text-align:center;" name="flet_ctrt_no" required="" caption="Contract No." readonly class="input1" id="flet_ctrt_no" /><button type="button" id="btn_ctrtpop" name="btn_ctrtpop" class="input_seach_btn"></button></td>
					<th>Contract Type </th>
					<td><input type="text" style="width:80px;" class="input2" value="" name="flet_ctrt_tp_cd" alt="" border="0" align="absmiddle" readonly id="flet_ctrt_tp_cd" /> </td>
					<th>Currency</th>
					<td><input type="text" name="csr_curr_cd" value="USD" style="width:56px;text-align:center;ime-mode:disabled" class="input1" maxlength="3" dataformat="engup" required="" fullfill="" caption="Currency" id="csr_curr_cd" /> </td>
		   		</tr>
		   </tbody>
		</table>
		
		<table> 
				<colgroup>
					<col width="90" />				
					<col width="85" />				
					<col width="60" />				
					<col width="110" />				
					<col width="78" />				
					<col width="197" />				
					<col width="90" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Requested by</th>
					<td><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60px;text-align:center;" class="input2" readonly id="slp_ofc_cd" /> </td>
					<th>CSR Date</th>
					<td><input type="text" value="" name="slp_iss_dt" style="width:80px;text-align:center;" class="input2" readonly id="slp_iss_dt" /> </td>
					<th>Provided By </th>
					<td><input type="text" value="<%=strUsr_nm%>" name="prov_by" style="width:150px;text-align:center;" class="input2" readonly id="prov_by" /> </td>
					<th>CSR No.</th>
					<td><input type="text" style="width:201px;" class="input2" value="" name="csr_no" readonly id="csr_no" /> </td>
				</tr>
		</table>
		<table> 
				<colgroup>
					<col width="90" />				
					<col width="530" />				
					<col width="90" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Description</th>
					<td><input type="text" style="width:483px;" class="input1" value="" name="csr_desc" maxlength="500" id="csr_desc" /> </td>
					<th>Effective Date</th>
					<td><input type="text" style="width:80px;text-align:center;ime-mode:disabled;" class="input1" value="" name="eff_dt" dataformat="ymd" required caption="Effective Date" id="eff_dt" /><button type="button" id="eff_dt_cal" name="eff_dt_cal" class="calendar ir"></button></td>
				</tr>
		</table>
		<table> 
				<colgroup>
					<col width="90" />				
					<col width="*" />				
		   		</colgroup> 
				<tr>
					<th>Owner Code</th>
					<td><input type="text" style="width:78px;" class="input2" value="" name="vndr_seq" readonly id="vndr_seq" /><input type="text" style="width:401px;" class="input2" value="" name="vndr_nm" readonly id="vndr_nm" /> </td>
				</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<div style="width:100%; text-align:right;">	
		<table style="width:440px;float:right;">
			<tbody>	
			<colgroup>
			<col width="80"/>
			<col width="10"/>
			<col width="350"/>
			</colgroup> 	
				<tr>
					<th>Total Amount</th>
					<td></td>
					<td><input type="text" style="width:50px;text-align:center" class="tr_head3" value="DR" readonly><input type="text" name="dr_amt" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly><input type="text" style="width:50px;text-align:center" class="tr_head3" value="CR" readonly><input type="text" name="cr_amt" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>