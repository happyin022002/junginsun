<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : STM_SAP_0110.jsp
*@FileTitle  : Bank Account Creation (Supplier Bank)
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
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0110Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0110Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<script  type="text/javascript">	

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
			
	}
	
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="bank_acct_seq"> 
<input type="hidden" name="pagerows" id="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save"  		id="btn_save">Save</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table style="width:250px">
			<colgroup>
				<col width="80"/>
				<col width="150"/>
				<col width="80"/>
				<col width="150"/>
				<col width="80"/>
				<col width="120"/>
				<col width="80"/>
				<col width="*"/>
		    </colgroup>
		    <tbody>
				<tr>
					<th>Account Number</th>
                    <td colspan="7"><input type="text" style="width:102px;text-align:left;ime-mode:disabled;" class="input2" name="sch_bank_acct_no" maxlength="30" readonly id="sch_bank_acct_no" /><button type="button" id="btns_schBankAcctNo" name="btns_schBankAcctNo" class="input_seach_btn"></button></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="150"/>
				<col width="80"/>
				<col width="150"/>
				<col width="80"/>
				<col width="120"/>
				<col width="80"/>
				<col width="*"/>
		    </colgroup>
		    <tbody>	
				<tr><td colspan="8"><h3 class="title_design">General Information</h3></td></tr>
				<tr>
					<th>Number</th>
                    <td><input type="text" style="width:110px;text-align:left;ime-mode:disabled;"  class="input1" name="bank_acct_no" maxlength="30" caption="Account Number" id="bank_acct_no" /></td>
                    <th>Name</th>
                    <td><input type="text" style="width:183px;ime-mode:disabled;" required class="input1" name="bank_acct_nm" maxlength="100" caption="Account Name" id="bank_acct_nm" /> </td>
                    <th>Currency</th>
                    <td><script type="text/javascript">ComComboObject('curr_cd', 1, 60, 0, 1, 0, false, 1);</script></td>
                    <th>End Date</th>
                    <td><input type="text" style="width:80px;text-align:left;" class="input" name="inact_dt" dataformat="ymd" maxlength="8" id="inact_dt" /><button type="button" id="btns_inactDt" name="btns_inactDt" class="calendar ir"></button></td>
				</tr>
				<tr>
					<th>Supplier Code</th>
                    <td colspan="3"><input type="text" style="width:80px;text-align:left;ime-mode:disabled;" required class="input1" name="bank_acct_vndr_seq" maxlength="6" dataformat="engup" caption="Supplier Code" id="bank_acct_vndr_seq" /><button type="button" id="btns_supplier" name="btns_supplier" class="input_seach_btn"></button><input type="text" style="width:360px;" class="input2" name="vndr_lgl_eng_nm" readonly id="vndr_lgl_eng_nm" /></td>
                    <th><label for="bank_acct_prio_cd">Primary</label></th>
                    <td><input type="checkbox" name="bank_acct_prio_cd" class="trans" id="bank_acct_prio_cd" /> </td>
                    <th>Priority (0~99)</th>
                    <td><input type="text" style="width:40px;text-align:left;" required class="input1" name="attr_ctnt7" dataformat="num" maxlength="2" value="99" caption="Priority" id="attr_ctnt7" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="85"/>
				<col width="150"/>
				<col width="80"/>
				<col width="150"/>
				<col width="80"/>
				<col width="120"/>
				<col width="80"/>
				<col width="*"/>
		    </colgroup>
		    <tbody>
				<tr><td colspan="8"><h3 class="title_design">Additional Information</h3></td></tr>
				<tr>
					<th>Bank Name</th>
                    <td><input type="text" style="width:102px;" class="input" name="attr_ctnt5" maxlength="200" caption="Bank Name" id="attr_ctnt5" /> </td>
                    <th>Branch Name</th>
                    <td colspan="5"><input type="text" style="width:102px;" class="input" name="attr_ctnt6" maxlength="200" caption="Branch Name" id="attr_ctnt6" /> </td>
				</tr>
				<tr>
					<th>IBAN No</th>
                    <td><input type="text" style="width:102px;" class="input" name="iban_no" maxlength="50" caption="IBAN No" id="iban_no" /> </td>
                    <th>SWIFT Code</th>
                    <td><input type="text" style="width:102px;" class="input" name="attr_ctnt2" maxlength="200" caption="SWIFT Code" id="attr_ctnt2" /> </td>
                    <th>CMS Country</th>
                    <td colspan="3"><input type="text" name="cntc_area_cd" style="width:40px;text-align:center;" class="input" maxlength="2" caption="CMS Country" id="cntc_area_cd" /><button type="button" id="btns_cntcAreaCd" name="btns_cntcAreaCd" class="input_seach_btn"></button><input type="text" style="width:195px;" class="input2" name="cntc_area_nm" readonly id="cntc_area_nm" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<div id="hidSheetDiv"  style="display:none" >
<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet');</script>
		</div>
	</div>
</div>
</form>

