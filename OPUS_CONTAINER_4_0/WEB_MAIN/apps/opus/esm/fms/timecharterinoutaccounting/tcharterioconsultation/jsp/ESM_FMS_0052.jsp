<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0052.jsp
*@FileTitle  : Slip Approval
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/18
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0052Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0052Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.TCharterIOConsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmFms0052Event)request.getAttribute("Event");
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


<input type="hidden" name="slip_apro_flg" value="N" id="slip_apro_flg" />
<input type="hidden" name="vat_slp_tp_cd" value="N" id="vat_slp_tp_cd" />
<input type="hidden" name="flet_ctrt_tp_cd" id="flet_ctrt_tp_cd" />
<input type="hidden" name="save_csr_no" id="save_csr_no" />
<input type="hidden" name="slip_type" id="slip_type" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_slip" id="btn_slip" type="button">Slip Detail</button><!--
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
				<col width="80px">				
				<col width="250px">				
				<col width="100px">				
				<col width="280px">				
				<col width="100px">				
				<col width="*">				
		   </colgroup>
		   <tbody>
		   		<tr>
		   			<th>Condition</th>
					<td><input type="radio" value="E" class="trans" name="condition" checked onclick="condition_click()">Effective <label></label><input type="radio" value="C" name="condition" class="trans" onclick="condition_click()">CSR Date </td>
					<th>Effective Date </th>
					<td><input value="" type="text" style="width:80px;text-align:center;" class="input1" name="from_eff_dt" dataformat="ymd"><!--
					--><button type="button" name="from_ef_dt" id="from_ef_dt"  class="calendar ir"></button><!--
					-->~ <!--
					--><input value="" type="text" style="width:80px;text-align:center;" class="input1" name="to_eff_dt" dataformat="ymd"><!--
					--><button type="button" name="to_ef_dt" id="to_ef_dt"  class="calendar ir"></button></td>
					<th>CSR Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input2" name="from_cre_dt" dataformat="ymd"><!--
					--><button type="button" name="from_cr_dt" id="from_cr_dt"  class="calendar ir"></button>~
					<input type="text" style="width:80px;text-align:center;" class="input2" name="to_cre_dt" dataformat="ymd"><!--
					--><button type="button" name="to_cr_dt" id="to_cr_dt"  class="calendar ir"></button></td>
				</tr>
				<tr>
					<th>Vessel Code</th>
					<td><input type="text" onchange="vsl_cd_change()" style="width:56px; text-align:center; ime-mode:disabled" dataformat="engup" class="input" maxlength="4" id="vsl_cd" name="vsl_cd" fullfill caption="Vessel Code"><!--
					--><button type="button" name="btn_vslpop" id="btn_vslpop"  class="input_seach_btn"></button><!--
					--><input type="text" style="width:150px;" class="input2" name="vsl_eng_nm" id="vsl_eng_nm" readonly></td>
					<th>CSR No.</th>
					<td><input value="" type="text" style="width:224px;ime-mode:disabled" dataformat="engup" class="input" name="csr_no" id="csr_no" maxlength="22"></td>
					<td></td>
					<td></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design mar_btm_8">Approval Waiting List</h3>
		<br/>
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Approval Conclusion</h3>
		<table> 
			<colgroup>
				<col width="100" />				
				<col width="180" />				
				<col width="100" />				
				<col width="190" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup>
			<tr>
				<th>Request Team</th>
				<td><input type="text" style="width:120px;text-align:center;" class="input2" name="request_team" readonly id="request_team" /> </td>
				<th>CSR Date</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input2" name="csr_dt" readonly id="csr_dt" /></td>
				<th>Request Date</th>
				<td><input type="text" style="width:80px;text-align:center;" class="input2" name="rqst_dt" readonly id="rqst_dt" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="180" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Produced By  </th>
				<td><input type="text" style="width:120px;text-align:center;" class="input2" name="produced_by" readonly id="produced_by" /> </td>
				<th>CSR Desc</th>
				<td><input type="text" style="width:370px;" class="input2" name="csr_desc" readonly id="csr_desc" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="180" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Owner Code</th>
				<td><input type="text" style="width:120px;text-align:center;" class="input2" name="ownr_cd" readonly id="ownr_cd" /> </td>
				<th>Owner Name</th>
				<td><input type="text" style="width:370px;" class="input2" name="ownr_nm" readonly id="ownr_nm" /> </td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<th id="owner_full_nm_txt" name="">Vendor Name</th>
				<td><input type="text" style="width:370px;" class="input2" name="ownr_full_nm" readonly id="ownr_full_nm" /></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="100" />				
				<col width="180" />				
				<col width="100" />				
				<col width="140" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Currency </th>
				<td><input type="text" style="width:120px;text-align:center;" class="input2" name="csr_curr_cd" readonly id="csr_curr_cd" /> </td>
				<th>CSR Amount</th>
				<td><input type="text" style="width:130px;text-align:right" class="input2" name="csr_amt" readonly id="csr_amt" /> </td>
				<th>Tax Type</th>
				<td><input type="text" style="width:130px;text-align:center;" class="input2" name="evid_tp" readonly id="evid_tp" /> </td>
			</tr>
		</table>
		
		<table style="margin-bottom: 4px">
			<colgroup>
				<col width="100" />				
				<col width="120" />
				<col width="60" />				
				<col width="100" />				
				<col width="140" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Deduction</th>
				<td><input type="radio" class="trans" name="deduction" disabled="" id="deduction" /> Yes    <input type="radio" class="trans" name="deduction" disabled="" id="deduction" /> No </td>
				<td></td>
				<th>RQST Amount</th>
				<td><input type="text" style="width:130px;text-align:right" class="input2" name="rqst_amt" readonly id="rqst_amt" /> </td>
				<th>Deducted Amt</th>
				<td><input type="text" style="width:130px;text-align:right" class="input2" name="diff_desc" readonly id="diff_desc" /> </td>
			</tr>
		</table>
		
		<table style="margin-bottom: 4px">
			<colgroup>
				<col width="100" />				
				<col width="120" />
				<col width="*" />
			</colgroup>
			<tbody> 
			<tr>
				<th>Approval</th>
				<td><input type="radio" class="noinput1" name="apro_flg" disabled="" value="Y" id="apro_flg" onclick="approval_click()"/> Yes    <input type="radio" class="noinput1" name="apro_flg" disabled="" value="N" id="apro_flg" onclick="approval_click()" /> No </td>
				<td></td>
			</tr>
			</tbody>
		</table>
		
		<table>
			<colgroup>
					<col width="100" />				
					<col width="120" />
					<col width="60" />				
					<col width="100" />				
					<col width="*" />				
		   </colgroup> 
			<tr>
				<th>Cancel MK</th>
				<td><input type="radio" class="trans" name="cxl_flg" disabled="" value="Y" id="cxl_flg" /> Yes    <input type="radio" class="trans" name="cxl_flg" disabled="" value="N" id="cxl_flg" /> No </td>
				<td></td>
				<th>Cancel Remark</th>
				<td><input type="text" style="width:370px;" maxlength="100" class="input2" name="cxl_desc" readonly caption="Cancel Remark" id="cxl_desc" /> <input type="hidden" name="slp_no" id="slp_no" /> <input type="hidden" name="vsl_code" id="vsl_code" /> <input type="hidden" name="vsl_eng_name" id="vsl_eng_name" /> </td>
			</tr>
		</table>
</div>	
	<!-- opus_design_inquiry(E) -->
</div>
</form>