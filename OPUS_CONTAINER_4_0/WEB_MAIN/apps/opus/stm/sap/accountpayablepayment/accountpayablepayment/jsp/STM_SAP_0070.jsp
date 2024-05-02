<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0070.jsp
*@FileTitle  : Payment Schedule Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0070Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0070Event event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;		//서버에서 발생한 에러
	String strErrMsg = ""; 		  			//에러메세지
	int rowCount	 = 0;					//DB ResultSet Count of list
	
	String strUsr_id    = "";
	String strUsr_nm    = "";
	String strUsr_ofc   = "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment");
	
	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSap0070Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	} catch(Exception e) {
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
<form  name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hid_pay_seq" id="hid_pay_seq" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Payment Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Payment Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Payment Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button>
	</div>
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
		<table >
				<colgroup>
					<col width="90">
					<col width="330">
					<col width="75">
					<col width="270">
					<col width="80">
					<col width="290">
					<col width="*">
				</colgroup>
				<tbody>
				<tr >
					<th>Open Office</th>
                    <td><input type="text" style="width:80px;" class="input1" name="ofc_cd" id="ofc_cd" maxlength="6" dataformat="engup" style="ime-mode:disabled"><!--  
                       	--><button type="button" class="input_seach_btn" name="btns_search_ofc" id="btns_search_ofc" auth="R"></button>
                     </td>
                     <th>Pay Group</th>
                     <td><input type="text" style="width:150px;" class="input" name="vndr_pay_grp_cd" id="vndr_pay_grp_cd" maxlength="25" dataformat="engup" style="ime-mode:disabled"><!-- 
                 		--><button type="button" class="input_seach_btn" name="btns_search_paygroup" id="btns_search_paygroup" auth="R"></button>
                     </td>
                     <th>Batch Name</th>
                     <td><input type="text" style="width:180px;" class="input" name="pay_bat_nm" id="pay_bat_nm" maxlength="50" dataformat="engup" style="ime-mode:disabled"><!--  
                       	--><button type="button" class="input_seach_btn" name="btns_search_batchnm" id="btns_search_batchnm" auth="R"></button>
                     </td>
                     <td></td>
                 </tr>
				<tr >
                    <th>Payment Date</th>
                    <td><input type="text" style="width:80px;" class="input1" name="pay_dt_fr" required cofield="pay_dt_to" caption="start date" id="pay_dt_fr" dataformat="ymd" maxlength="10"><!--  
                    	--><button type="button" class="calendar" name="btns_calPayFr" id="btns_calPayFr"></button>~&nbsp;<!--  
                    	--><input type="text" style="width:80px;" class="input1" name="pay_dt_to" required cofield="pay_dt_fr" caption="end date" id="pay_dt_to" dataformat="ymd" maxlength="10"><!--  
                    	--><button type="button" class="calendar" name="btns_calPayTo" id="btns_calPayTo"></button>
                    </td>
                    <th>Payment Method</th>
                    <td><input type="text" style="width:150px;" class="input" name="pay_mzd_lu_cd" id="pay_mzd_lu_cd" maxlength="20" dataformat="engup" style="ime-mode:disabled"><!--  
                    	--><button type="button" class="input_seach_btn" name="btns_search_docnm" id="btns_search_docnm" auth="R"></button>
                    </td>
                    <th>Supplier</th>
                    <td><input type="text" style="width:60px;" class="input" name="vndr_no" id="vndr_no" maxlength="6" dataformat="engup" style="ime-mode:disabled"><!--  
                    	--><button type="button" class="input_seach_btn" name="btns_search_supplier" id="btns_search_supplier" auth="R"></button><!--  
                    	--><input type="text" style="width:190px;" class="input2" name="vndr_nm" id="vndr_nm" maxlength="100" readonly>
                    </td>
                    <td></td>
                </tr>
			
				<tr >
                    <th>Bank Account</th>
                    <td><input type="text" style="width:160px;" class="input" name="bank_acct_nm" id="bank_acct_nm" maxlength="100"><!--  
						--><button type="button" class="input_seach_btn" name="btns_search_bankacctnm" id="btns_search_bankacctnm" auth="R"></button>
                    </td>
                    <th>Voucher No</th>
                    <td><input type="text" style="width:150px;" class="input" name="doc_seq" id="doc_seq" maxlength="15"></td>
                    <th class="sm">Currency</th>
                    <td class="sm pad_left_8"><span style="font-weight:normal;">
                    	<input type="radio" name="curr_tp" id="curr_tp1" value="LOCAL" class="trans"><label for="curr_tp1">Local</label><!--  
                    	--><input type="radio" name="curr_tp" id="curr_tp2" value="OTHER" class="trans"><label for="curr_tp2">Others</label><!--  
                    	--><input type="radio" name="curr_tp" id="curr_tp3" value="ALL" class="trans" checked><label for="curr_tp3">All</label></span>
					</td>
					<td></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

	
<div class="wrap_result">
	<div class="opus_design_inquiry"><h3 class="title_design">Payment</h3></div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
		<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table style="width:100%; background-color:white;" class="grid2">
			<tbody>
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tr>
					<td class="tr2_head2" style="text-align:center;"><b>Invoice Description</b></td>
					<td><input type="text" style="width:100%;text-align:left" class="noinput" name="sub_invDesc" id="sub_invDesc" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry"><h3 class="title_design">Payment Detail</h3></div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
<div class="wrap_result">
	
</div>
</form>
<%@ include file="/bizcommon/include/common_opus.jsp"%>