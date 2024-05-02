<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0040.js
*@FileTitle  : CSR Receipt Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    StmSap0040Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountpayableinvoiceSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (StmSap0040Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<input type="hidden" name="lgin_usr_ap_ofc" id="lgin_usr_ap_ofc" />
<input type="hidden" name="lgin_usr_locl_tm" id="lgin_usr_locl_tm" />
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
		--><button class="btn_normal" name="btn_confirm" id="btn_confirm" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_release" id="btn_release" type="button">Release</button><!--
		--><button class="btn_normal" name="btn_reject" id="btn_reject" type="button">Reject</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="60">
				<col width="100">
				<col width="100">
				<col width="60">
				<col width="100">
				<col width="60">
				<col width="144">
				<col width="*">
			</colgroup>
			<tr>
                 <th>AP Office</th>
                 <td><input type="text" style="width:80px;text-align:left;ime-mode:disabled;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_ofc" name="btns_ofc" class="input_seach_btn"></button></td>
                 <th>Inv Date</th>
                 <td><input type="text" style="width:80px;text-align:left;" class="input1" name="inv_dt_fm" dataformat="ymd" maxlength="8" required cofield="inv_dt_to" caption="start date" id="inv_dt_fm" /><button type="button" id="btns_cal_invDtFm" name="btns_cal_invDtFm" class="calendar ir"></button><span class="dash">~</span><input type="text" style="width:80px;text-align:left;" class="input1" name="inv_dt_to" dataformat="ymd" maxlength="8" required cofield="inv_dt_fm" caption="end date" id="inv_dt_to" /><button type="button" id="btns_cal_invDtTo" name="btns_cal_invDtTo" class="calendar ir"></button></td>
                 <th>Pay Group</th>
                 <td><input type="text" style="width:80px;text-align:left;ime-mode:disabled;" class="input" name="ap_pay_grp_lu_cd" dataformat="engup" maxlength="6" id="ap_pay_grp_lu_cd" /><button type="button" id="btns_apPayGrpLuCd" name="btns_apPayGrpLuCd" class="input_seach_btn"></button></td>
                 <th>Approve
                 	<select name="attr_ctnt15" id="attr_ctnt15" class="input" style="width:60px;">
	                     <option value="Y">Yes</option>
	                     <option value="N">No</option>
                   </select></th>
                 <td></td>
             </tr>
             <tr>
                 <th>CSR No</th>
                 <td><input type="text" style="width:170px;ime-mode:disabled;" class="input" name="inv_no" maxlength="20" dataformat="engup" id="inv_no" /><button type="button" id="btns_csr" name="btns_csr" class="input_seach_btn"></button></td>
                 <th>GL Date</th>
                 <td><input type="text" style="width:80px;text-align:left;" class="input" name="gl_dt_fm" dataformat="ymd" maxlength="8" cofield="gl_dt_to" caption="start date" id="gl_dt_fm" /><button type="button" id="btns_cal_glDtFm" name="btns_cal_glDtFm" class="calendar ir"></button><span class="dash">~</span><input type="text" style="width:80px;text-align:left;" class="input" name="gl_dt_to" dataformat="ymd" maxlength="8" cofield="gl_dt_fm" caption="end date" id="gl_dt_to" /><button type="button" id="btns_cal_glDtTo" name="btns_cal_glDtTo" class="calendar ir"></button></td>
                 <th>Supplier</th>
                 <td colspan="3"><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="vndr_no" maxlength="6" dataformat="engup" id="vndr_no" onchange="vndr_no_onchange()"/><button type="button" id="btns_supplier" name="btns_supplier" class="input_seach_btn"></button><input type="text" style="width:156;" class="input2" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm" readOnly></td>
             </tr>
		</tbody>
	</table>
	<table>
		<colgroup>
			<col width="60" />
			<col width="199" />
			<col width="50" />
			<col width="50" />
			<col width="239" />
			<col width="50" />
			<col width="50" />
			<col width="207" />
			<col width="*" />
		</colgroup>
			<tbody>
			<tr style="height:25px">
				<th class="sm">Receipt</th>
				<td class="sm"style="font-weight:normal"><input type="radio" name="rct_flg" id="rct_flg" class="trans" value="N" checked="checked" /><label for = "rct_flg">Not Received</label><input type="radio" name="rct_flg" id="rct_flg1" class="trans" value="Y" /><label for ="rct_flg1">Received</label></td>
				<td></td>
				<th class="sm">Curr</th>
				<td class="sm pad_left_12" style="font-weight:normal"><input type="radio" name="curr_flg" id="curr_flg" class="trans" value="Y" /><label for ="curr_flg">Local</label><input type="radio" name="curr_flg" id="curr_flg2" class="trans" value="N" /><label for ="curr_flg2">Others</label><input type="radio" name="curr_flg" id="curr_flg3" class="trans" value="" checked="checked" /><label for = "curr_flg3">All</label></td>
				<td></td>
				<th class="sm">Paid</th>
				<td class="sm pad_left_12" style="font-weight:normal"><input type="radio" name="pay_sts_flg" id="pay_sts_flg" class="trans" value="Y" /><label for="pay_sts_flg">Paid</label><input type="radio" name="pay_sts_flg" id="pay_sts_flg1" class="trans" value="N" /><label for ="pay_sts_flg1">Unpaid</label><input type="radio" name="pay_sts_flg" id="pay_sts_flg2" class="trans" value="" checked="checked" /><label for ="pay_sts_flg2">All</label></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
