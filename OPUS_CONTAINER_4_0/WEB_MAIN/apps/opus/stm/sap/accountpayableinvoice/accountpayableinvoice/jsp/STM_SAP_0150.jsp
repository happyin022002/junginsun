<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0150.jsp
*@FileTitle  : AP Cost Accrual Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/11/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0150Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	StmSap0150Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountpayableinvoiceSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0150Event)request.getAttribute("Event");
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
<input type="hidden" name="lgin_usr_ap_ofc" id="lgin_usr_ap_ofc">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_accrual_if" id="btn_accrual_if" type="button">Accural I/F</button><!--
		--><button class="btn_normal" name="btn_if_cancel" id="btn_if_cancel" type="button">Accr I/F Delete</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button" >Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70">
				<col width="150">
				<col width="70">
				<col width="150">
				<col width="70">
				<col width="150">
				<col width="70">
				<col width="150">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Office Code</th>
					<td><input type="text" style="ime-mode:disabled;width:60px;text-align:left;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_ofc" name="btns_ofc" class="input_seach_btn"></button></td>
					<th>Invoice Date</th>
					<td><input type="text" style="width:80px;" value="" name="inv_date_from" dataformat="ymd" maxlength="10" class="input1" required caption="Invoice Date" cofield="inv_date_to" caption="start date" id="inv_date_from" /><button type="button" id="btns_calInvFr" name="btns_calInvFr" class="calendar ir"></button>~&nbsp;<input type="text" style="width:80px;" value="" name="inv_date_to" dataformat="ymd" maxlength="10" class="input1" required caption="Invoice Date" cofield="inv_date_from" caption="end date" id="inv_date_to" /><button type="button" id="btns_calInvTo" name="btns_calInvTo" class="calendar ir"></button></td>
					<th>Supplier</th>
					<td><input type="text" style="ime-mode:disabled;width:80px;" class="input" name="vndr_no" maxlength="6" dataformat="engup" id="vndr_no" onchange="vndr_no_onchange();"/><button type="button" name="btns_supplier" id="btns_supplier" auth="R" class="input_seach_btn"></button><input type="text" style="width:170px;" class="input2" name="vndr_lgl_eng_nm" id="vndr_lgl_eng_nm"  readOnly >
					</td>
					<th>CSR No</th>
					<td><input type="text" style="ime-mode:disabled;width:170px;" class="input" name="inv_no" maxlength="20" dataformat="engup" id="inv_no" /><button type="button" id="btns_csr" name="btns_csr" class="input_seach_btn"></button></td>
					<th>I/F Flag</th>
					<td>
						<select name="accrual_if_flag" id="accrual_if_flag" class="input" style="width:60px;">
						<option value="N">No</option>
						<option value="Y">Yes</option>						
						</select>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</form>