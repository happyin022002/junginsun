<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0021.jsp
*@FileTitle  : Payments Slip
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmFms0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
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
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>"  />
<input type="hidden" name="slp_ofc_cd" id="slp_ofc_cd" value="<%=strOfc_cd%>" />
<input type="hidden" name="csr_type" value="AP" id="csr_type" />
<input type="hidden" name="ap_ctr_cd" id="ap_ctr_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
<input type="hidden" name="chk_acct_cd" id="chk_acct_cd" />
<input type="hidden" name="chk_ctr_cd" id="chk_ctr_cd" />
<input type="hidden" name="chk_bunker_vvd" id="chk_bunker_vvd" />
<input type="hidden" name="pre_work_flag" id="pre_work_flag" />
<input type="hidden" name="evid_tp_cd_val" id="evid_tp_cd_val" value="" />
<input type="hidden" name="usd_locl_xch_rt" id="usd_locl_xch_rt" />
<input type="hidden" name="make_tax_yn" id="make_tax_yn" />
<input type="hidden" name="param_flet_ctrt_tp_cd" id="param_flet_ctrt_tp_cd" />
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
	<div class="opus_design_btn"><!-- 
		--><button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!-- 
	 	--><button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
		--><button class="btn_normal" name="btn_hireStatement" id="btn_hireStatement" type="button">Hire Statement</button><!--
		--><button class="btn_normal" name="btn_taxEvidence" id="btn_taxEvidence" type="button" style="display:none;">Tax Evidence</button><!--
		--><button class="btn_normal" name="btn_slipInquiry" id="btn_slipInquiry" type="button">Slip Inquiry</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry (S) -->
<div class= "opus_design_inquiry wFit">
	<table class="search_in">
		<colgroup>
			<col width="100"/>
			<col width="250"/>
			<col width="90"/>
			<col width="162"/>
			<col width="50"/>
			<col width="80"/>
			<col width="69"/>
			<col width="70"/>
			<col width="*">
		</colgroup>
		<tbody> 
			<tr>
				<th>Vessel Code</th>
				<td><input type="text" style="width:56px;text-align:center;ime-mode:disabled;" class="input1" maxlength="4" name="vsl_cd" required=""  caption="Vessel Code" id="vsl_cd" dataformat="engup" onchange="vsl_cd_change()"/><button type="button" id="btn_vslpop" name="btn_vslpop" class="input_seach_btn"></button><input type="text" style="width:143px;" class="input2" name="vsl_eng_nm" readonly id="vsl_eng_nm" /> </td>
				<th>Contract No.</th>
				<td><input type="text" style="width:120px;text-align:center;" class="input1" maxlength="15" name="flet_ctrt_no" required=""  caption="Contract No." readonly id="flet_ctrt_no" /><button type="button" id="btn_ctrtpop" name="btn_ctrtpop" class="input_seach_btn"></button></td>
				<td></td>
				<th>Contract Type </th>
				<td><input type="text" style="width:56px;text-align:center;" class="input2" name="flet_ctrt_tp_cd" readonly id="flet_ctrt_tp_cd" /> </td>
				<th>Currency</th>
				<td><input type="text" style="width:56px;text-align:center;ime-mode:disabled;" class="input1" name="csr_curr_cd" value="USD" maxlength="3" dataformat="engup" required=""  caption="Currency" id="csr_curr_cd" onchange="csr_curr_cd_change()"/> </td>
			</tr>
		</tbody>
	</table>
	<table class="search_in">
		<colgroup>
			<col width="100"/>
			<col width="70"/>
			<col width="80"/>
			<col width="60"/>
			<col width="20"/>
			<col width="80"/>
			<col width="188"/>
			<col width="80"/>
			<col width="*">
		</colgroup>
		<tbody> 	
			<tr>
				<th>Requested by</th>
				<td><input type="text" style="width:65px;text-align:center;" class="input2" value="<%=strOfc_cd%>" readonly /> </td>
				<th>CSR Date</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input2" name="slp_iss_dt" readonly id="slp_iss_dt" /> </td>
				<td></td>
				<th>Provided By </th>
				<td><input type="text" style="width:150px;text-align:center;" class="input2" name="usr_nm" value="<%=strUsr_nm%>" readonly id="usr_nm" /> </td>
				<th>CSR No.</th>
				<td><input type="text" style="width:206px;text-align:center;" name="csr_no" class="input2" readonly id="csr_no" />&nbsp;<!-- 
				 --><button type="button" name="btn_csr_no" id="btn_csr_no" class="input_seach_btn"></button></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
			<col width="100"/>
			<col width="490"/>
			<col width="55"/>
			<col width="50"/>
			<col width="200"/>
			<col width="*">
		</colgroup> 
			<tr>
				<th>Description</th>
				<td><input type="text" style="width:488px;" class="input1" maxlength="100" name="slp_desc" caption="Description" id="slp_desc" /> </td>
				<td></td>
				<th style="margin-left:2px;">Slip Type</th>
				<td style="vertical-align:center;height:20px;margin-left:2px;"><input type="radio" value="P" class="trans" name="slp_tp" checked id="slp_tp" onclick="slp_tp_click()"/><!-- 
				 --><label for="chk_pro">Prepayment</label><!-- 
				 --><input type="radio" value="S" class="trans" name="slp_tp" id="slp_tp" /> <!-- 
				 --><label for="chk_pro">Standard</label><!-- 
				 --><input type="radio" value="P" class="trans" name="slp_tp" id="slp_tp" style="display:none;"><!-- 
				 --><label for="chk_pro" style="display:none;">Prepayment without Hire</label><!-- 
				 --></td>
				 <td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
		<colgroup>
			<col width="100"/>
			<col width="80"/>
			<col width="216"/>
			<col width="20"/>
			<col width="80"/>
			<col width="110"/>
			<col width="*">
		</colgroup> 
			<tr>
				<th>Tax Type </th>
				<td><input type="hidden" name="evid_tp_cd" value="" id="evid_tp_cd" /><!-- 
				 --><input type="text" style="width:100px;text-align:center;" class="input2" name="evid_tp_nm" readonly id="evid_tp_nm" value="" /><!-- 
				 --><span style="display:none;"><select style="width:100px;" class="input1" name="evid_tp_cd_combo" id="evid_tp_cd_combo" onchange="setButton(this.value);" disabled="disabled"></select></span></td>
				<td></td>
				<th>Request Date</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input1" name="rqst_dt" dataformat="ymd" id="rqst_dt" /><button type="button" id="rqst_dt_cal" name="rqst_dt_cal" class="calendar ir"></button></td>
				<th>Effective Date</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input1" name="eff_dt" dataformat="ymd" id="eff_dt" /><button type="button" id="eff_dt_cal" name="eff_dt_cal" class="calendar ir"></button></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
		<colgroup>
			<col width="100"/>
			<col width="500"/>
			<col width="110"/>
			<col width="*">
		</colgroup> 
			<tr>
				<th>Owner Code</th>
				<td><input type="text" style="width:100px;text-align:center;" class="input2" name="ownr_cd" readonly id="ownr_cd" /><input type="text" style="width:406px;" class="input2" name="ownr_nm" readonly id="ownr_nm" /> </td>
				<th>Hire No.</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input2" name="ppay_hir_no" readonly id="ppay_hir_no" /> </td>
			</tr>
		</tbody>
</table>
</div>
<div class="opus_design_inquiry"><table><tr><td colspan="6"></td></tr></table></div>
</div>
<div class="wrap_result">
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_normal" name="btn_prepayments" id="btn_prepayments" >Prepayments</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_charterersExp" id="btn_charterersExp" >Acct Management</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_offhireExp" id="btn_offhireExp" >Offhire Exp</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_bodBor" id="btn_bodBor" >BOD/BOR</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_rowAdd" id="btn_rowAdd" >Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_rowDel" id="btn_rowDel" >Row Del</button><!-- 
 	--></div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
<div class="opus_design_grid clear" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>	
<div class="opus_design_grid clear" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>	
<div class="opus_design_grid clear" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
<div style="width:100%; text-align:right;">	
	<table style="width:440px;float:right;">
		<tbody>	
		<colgroup>
		<col width="100"/>
		<col width="160"/>
		<col width="170"/>
		</colgroup> 	
			<tr>
				<th>Total Amount</th>
				<td><input type="text" style="width:50px;text-align:center;" class="tr_head3" value="DR" readonly><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="dr_amt" id="dr_amt" value="0.00" readonly></td>
				<td><input type="text" style="width:60px;text-align:center;" class="tr_head3" value="Diff" readonly><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="diff_amt" id="diff_amt" value="0.00" readonly></td>
			</tr>
			<tr><td height="5px" colspan="3"></td></tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="text" style="width:60px;text-align:center;" class="tr_head3" value="Balance" readonly><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="balance_amt" id="balance_amt" value="0.00" readonly></td>
			</tr>
		</tbody>
	</table>
</div>

</div>
</form>
