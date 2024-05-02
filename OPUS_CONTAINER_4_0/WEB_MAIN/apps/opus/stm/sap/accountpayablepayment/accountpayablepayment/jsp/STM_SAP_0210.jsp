<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0210.jsp
*@FileTitle  : Invoices
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0210Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0210Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String sys_curr_date = JSPUtil.getKST("yyyyMMdd");

	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");

	try {

		event = (StmSap0210Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="sys_curr_date" value="<%=sys_curr_date%>" id="sys_curr_date" />
<input type="hidden" name="login_ap_ofc" value="" id="login_ap_ofc" />
<input type="hidden" name="login_curr_cd" value="" id="login_curr_cd" />
<input type="hidden" name="f_curr" value="" id="f_curr" />
<input type="hidden" name="f_curr_prcs" value="" id="f_curr_prcs" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_capture" id="btn_capture" type="button">Capture</button><!--
		--><button class="btn_normal" name="btn_payConfirm" id="btn_payConfirm" type="button">Pay Confirm</button><!--
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
				<col width="80" />				
				<col width="330" />				
				<col width="70" />				
				<col width="250" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		 <tr>
                     <th>Office</th>
                     <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button></td>
                     <th>Batch Name</th>
                     <td><input type="text" style="width:170px;" class="input" name="pay_bat_nm" maxlength="20" dataformat="engup" id="pay_bat_nm" /><button type="button" id="btns_search_batch" name="btns_search_batch" class="input_seach_btn"></button></td>
                     <th>Pay Group</th>
                     <td><input type="text" style="width:170px;" class="input" name="vndr_pay_grp_cd" maxlength="20" dataformat="engup" id="vndr_pay_grp_cd" /><button type="button" id="btns_search_paygroup" name="btns_search_paygroup" class="input_seach_btn"></button></td>
                 </tr>
                 <tr>
                     <th>Payment Date</th>
                     <td><input type="text" style="width:80px;" value="" name="fr_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="to_dt" caption="start date" id="fr_dt" /><!-- 
                       --><button type="button" id="btns_calFr" name="btns_calFr" class="calendar ir"></button><span class="dash">~</span><!-- 
                       --><input type="text" style="width:80px;" value="" name="to_dt" dataformat="ymd" maxlength="10" class="input1" required cofield="fr_dt" caption="end date" id="to_dt" /><!-- 
                       --><button type="button" id="btns_calTo" name="btns_calTo" class="calendar ir"></button></td>
                     <th>Bank Account</th>
                     <td colspan="3"><input type="text" style="width:170px;" class="input" name="bank_acct_nm" maxlength="20" dataformat="engup" id="bank_acct_nm" onchange="bank_acct_nm_onchange();"/><button type="button" id="btns_search_bankAccount" name="btns_search_bankAccount" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="bank_acct_num" readonly id="bank_acct_num" /> </td>
                 </tr>
		   </tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_sheet1RowAdd" id="btn_sheet1RowAdd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_sheet1RowDelete" id="btn_sheet1RowDelete" type="button">Row Delete</button><!--
			--><button class="btn_normal" name="btn_sheet1Save" id="btn_sheet1Save" type="button">Save</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
		
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_sheet2RowAdd" id="btn_sheet2RowAdd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_sheet2RowDelete" id="btn_sheet2RowDelete" type="button">Row Delete</button><!--
			--><button class="btn_normal" name="btn_sheet2Save" id="btn_sheet2Save" type="button">Save</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>


</form>
