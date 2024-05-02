<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0140.js
*@FileTitle  : Bank Balance Adjustment
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
<%-- <%@ page import="com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.event.StmSap0140Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>


<%
    //StmSap0140Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id  = "";
	String strUsr_nm  = "";
	String strUsr_ofc = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablepayment.AccountpayablepaymentSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		//event = (StmSap0140Event)request.getAttribute("Event");
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
<input type="hidden" name="bank_acct_seq" id="bank_acct_seq" />
<input type="hidden" name="hid_func_curr_cd" id="hid_func_curr_cd" />
<input type="hidden" name="hid_func_curr_prcs" id="hid_func_curr_prcs" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
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
				<col width="40">
				<col width="150">
				<col width="115">
				<col width="16">
				<col width="100">
				<col width="260">
				<col width="30">
				<col width="80">
				<col width="170">
				<col width="*">
			</colgroup>
			<tr>
				<th class="sm">Office</th>
				<td class="sm">
                   	<input type="radio" name="ofc_type" value="AP" class="trans" checked id="ofc_type" /><label for="ofc_type">AP</label><!-- 
                   	 --><input type="radio" name="ofc_type" value="AR" class="trans" id="ofc_type_1" /><label for="ofc_type_1">AR</label><!-- 
           			 --><input type="radio" name="ofc_type" value="ALL" class="trans" id="ofc_type_2" /><label for="ofc_type_2">ALL</label></td>
      			<td class="sm">
      				<input type="text" style="width:70px;text-align:left;" class="input1" name="ofc_cd" dataformat="engup" maxlength="6" id="ofc_cd" /><button type="button" id="btns_search_ofc" name="btns_search_ofc" class="input_seach_btn"></button>
                </td>
                <td></td>
                <th>Inquiry Date</th>
                <td><input type="text" style="width:90px;text-align:left;" class="input1" name="fr_dt" dataformat="ymd" maxlength="10" required cofield="to_dt" caption="start date" id="fr_dt" /><button type="button" id="btns_calFrDt" name="btns_calFrDt" class="calendar ir"></button>~ <input type="text" style="width:90px;text-align:left;" class="input1" name="to_dt" dataformat="ymd" maxlength="10" required cofield="fr_dt" caption="end date" id="to_dt" /><button type="button" id="btns_calToDt" name="btns_calToDt" class="calendar ir"></button></td>
				<td></td>
				<th class="sm">In/Active On</th>
				<td class="sm">
                  	<input type="radio" name="inactive_type" value="1" class="trans" checked id="inactive_type" /><label for="inactive_type">Active</label><!--  
     				 --><input type="radio" name="inactive_type" value="2" class="trans" id="inactive_type_1" /><label for="inactive_type_1">Inactive</label><!-- 
     				 --><input type="radio" name="inactive_type" value="3" class="trans" id="inactive_type_2" /><label for="inactive_type_2">All</label><!-- 
            	 --></td>
            	<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="50" />
				<col width="270" />
				<col width="100" />
				<col width="260" />
				<col width="100" />
				<col width="80" />
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tr>
                <th>Acct No</th>
                <td><input type="text" style="width:70px;text-align:left;" class="input1" name="bank_acct_no" id="bank_acct_no" /><button type="button" id="btns_search_bankAcct" name="btns_search_bankAcct" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="bank_acct_name" readonly id="bank_acct_name" /></td>
                <th>Bank Name</th>
                <td><input type="text" style="width:120px;" class="input2" name="bank_name" readonly id="bank_name" /><input type="text" style="width:131px;" class="input2" name="bank_branch_name" readonly id="bank_branch_name" /></td>
                <th>Acct Type</th>
                <td> <input type="text" style="width:80px;" class="input2" name="bank_acct_major_type" readonly id="bank_acct_major_type" /><input type="text" style="width:80px;" class="input2" name="bank_acct_minor_type" readonly id="bank_acct_minor_type" /></td>
                <th>Curr.</th>
                <td> <input type="text" style="width:40px;" class="input2" name="currency_code" readonly id="currency_code" /></td>
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
<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable2">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>