<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0090.jsp
*@FileTitle  : Bank Account Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0090Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    StmSap0090Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0090Event)request.getAttribute("Event");
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
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="bank_acct_seq" name="bank_acct_seq" type="hidden" />
<input id="bank_brnc_seq" name="bank_brnc_seq" type="hidden" />
<input id="aset_cd_cmb_seq" name="aset_cd_cmb_seq" type="hidden" />
<input id="chg_cd_cmb_seq" name="chg_cd_cmb_seq" type="hidden" />
<input id="gain_cd_cmb_seq" name="gain_cd_cmb_seq" type="hidden" />
<input id="lss_cd_cmb_seq" name="lss_cd_cmb_seq" type="hidden" />
<input id="acct_tp_cd" name="acct_tp_cd" type="hidden" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title">Bank Account Creation</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_retrieve" name="btn_retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_new" name="btn_new" class="btn_normal">New</button><!--
		--><button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button><!--
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
            	<col width="40" />
              	<col width="150" />
            	<col width="140" />
              	<col width="" />
           	<tr>
	            <th>Name</th>
	            <td><input id="sch_bank_acct_nm" style="width:110px;" class="input2" name="sch_bank_acct_nm" readonly value="" type="text" /><button class="input_seach_btn" name="btn_bank_acct_nm" id="btn_bank_acct_nm" type="button"></button></td>
	            <th>Number</th>
	            <td><input id="sch_bank_acct_no" style="width:150px;" class="input" name="sch_bank_acct_no" value=""  type="text" /></td>
            </tr>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
		<h3 class="title_design">General Information</h3>
	    <table>
	        <colgroup>
		        <col width="100" />
		        <col width="150" />
		        <col width="140" />
		        <col width="170" />
		        <col width="120" />
		        <col width="*" />
	        </colgroup>
            <tr>
                <th>Bank Name</th>
                <td><input id="bank_nm"  style="width:102px;" class="input2" name="bank_nm" readonly value="" caption="Bank Name" type="text" /><button class="input_seach_btn" name="btn_bank_brnc_nm" id="btn_bank_brnc_nm" type="button"></button></td>
                <th>Branch Name</th>
                <td><input id="bank_brnc_nm"  style="width:150px;" class="input2" name="bank_brnc_nm" readonly value="" caption="Branch Name" type="text" /></td>
                <th>Name</th>
                <td><input id="bank_acct_nm" required style="width:275px;" class="input1" name="bank_acct_nm" value="" caption="Name" maxlength="100" type="text" /></td>
            </tr>
            <tr>
                <th>Number</th>
                <td><input id="bank_acct_no" required style="width:125px;" class="input1" name="bank_acct_no" value="" caption="Number" maxlength="30" type="text" /></td>
                <th>Alternate Name</th>
                <td><input id="bank_acct_altn_nm" required style="width:150px;" class="input1" name="bank_acct_altn_nm" value="" caption="Alternate Name" maxlength="50" type="text" /></td>
                <th>Description</th>
                <td><input id="bank_acct_desc" required style="width:275px;" class="input1" name="bank_acct_desc" value="" caption="Description" maxlength="200" type="text" /></td>
            </tr>
             <tr>
               <th>Start Date</th>
               <td><input id="bank_acct_st_dt" required style="width:80px;" class="input1" name="bank_acct_st_dt" value="" dataformat="ymd" caption="Start Date" type="text" /><button class="calendar ir" name="btn_cal_st" id="btn_cal_st" type="button"></button></td>
               <th>End Date</th>
               <td><input id="inact_dt" style="width:80px;" class="input" name="inact_dt" value="" dataformat="ymd" type="text" /><button class="calendar ir" name="btn_cal_inact" id="btn_cal_inact" type="button"></button></td>
               <th>Country</th>
               <td><input id="cntc_area_cd" name="cntc_area_cd" readonly style="width:42px;" class="input2" caption="Country" type="text" required/><button class="input_seach_btn" name="btn_cnt" id="btn_cnt" type="button"></button><input id="cntc_area_nm" style="width:200px;" class="input2" name="cntc_area_nm" readonly value="" caption="Country" type="text" required/></td>                                                     
           </tr>
           <tr>
               <th>Currency</th>
               <td><script  type="text/javascript">ComComboObject('curr_cd', 1, 90, 0, 1);</script></td>
               <th>Account Type</th>
               <td><input id="bank_acct_tp_nm" readonly style="width:150px;" class="input2" name="bank_acct_tp_nm" value="INTERNAL" type="text" /></td>
               <th>Account Use</th>
               <td><input id="chk_acct_tp_cd1" name="chk_acct_tp_cd" class="trans" value="P" type="checkbox" /><label for="chk_acct_tp_cd1">Account Payable</label><label></label><input type="checkbox" name="chk_acct_tp_cd" id="chk_acct_tp_cd2" class="trans" value="R"><label for="chk_acct_tp_cd2">Account Receivables</label></td>
           </tr>
           <tr>
               <th>Deposit Division</th>
               <td>
               	<select name="dps_div_cd" id="dps_div_cd" class="input1" style="width:130px;">
               		<option value=""> </option>
               		<option value="C">Checking Account</option>
               		<option value="O">Ordinary Account</option>
               	</select>
               </td>
               <th>Bank Acct Type(L)</th>
               <td><script type="text/javascript">ComComboObject('bank_acct_tp_mn_cd', 2, 100, 1, 1,1,false,1);</script></td>
               <th>Bank Acct Type(M)</th>
               <td><script type="text/javascript">ComComboObject('bank_acct_tp_sub_cd', 2, 100, 1, 1,1,false,1);</script></td>
           </tr>
           <tr>
               <th>Open Office</th>
               <td><input id="opn_ofc_cd" required style="width:60px;" class="input1" name="opn_ofc_cd" value="" caption="Open Office" dataformat="engup" maxlength="6" type="text" /><button class="input_seach_btn" name="btn_open_ofc_nm" id="btn_open_ofc_nm" type="button"></button></td>
               <th>Control Office</th>
               <td><input id="ap_ctrl_ofc_cd" required style="width:60px;" class="input1" name="ap_ctrl_ofc_cd" value="" caption="Control Office" dataformat="engup" maxlength="6" type="text" /><button class="input_seach_btn" name="btn_ctrl_ofc_nm" id="btn_ctrl_ofc_nm" type="button"></button></td>
               <th>A/R Office</th>
               <td><input id="ar_ofc_cd" style="width:60px;" class="input" name="ar_ofc_cd" value="" caption="A/R Office" dataformat="engup" maxlength="6" type="text" /><button class="input_seach_btn" name="btn_ar_ofc_nm" id="btn_ar_ofc_nm" type="button"></button></td>
           </tr>
           <tr>
               <th>A/R Offset </th>
               <td>
               		<select name="attr_ctnt1" id="attr_ctnt1" class="input1" style="width:60px;">
               			<option value=""></option>
               			<option value="Y">Yes</option>
               			<option value="N">No</option>
               		</select>
               </td>                           		
               <th>Multiple Currency Use</th>
               <td colspan="3">
               		<select name="mlt_curr_flg" id="mlt_curr_flg" class="input1" style="width:60px;">
               			<option value=""></option>
               			<option value="Y">Yes</option>
               			<option value="N">No</option>
               		</select>
               </td>
           </tr>                           
        </table>
        
        <table class="line_bluedot"><tr><td></td></tr></table>
        <h3 class="title_design">Account Information</h3>
        <table>
			<colgroup>
			  <col width="50" />
			  <col width="370" />
			  <col width="80" />
			  <col width="" />
			</colgroup>
			<tr>
				<th>Cash</th>
				<td><!-- 
					--><input id="aset_coa_co_cd"  style="width:30px;" class="input2" readonly name="aset_coa_co_cd" value="" caption="Cash Company" type="text" required/><!--
					--><input id="aset_coa_rgn_cd"  style="width:30px;" class="input2" readonly name="aset_coa_rgn_cd" value="" caption="Cash Region" type="text" required/><!--
					--><input id="aset_coa_ctr_cd"  style="width:60px;" class="input2" readonly name="aset_coa_ctr_cd" value="" caption="Cash Center" type="text" required/><!--
					--><input id="aset_coa_acct_no"  style="width:60px;" class="input2" readonly name="aset_coa_acct_no" value="" caption="Cash Account" type="text" required/><!--
					--><input id="aset_coa_inter_co_cd"  style="width:30px;" class="input2" readonly name="aset_coa_inter_co_cd" value="" caption="Cash Inter Company" type="text" required/><!--
					--><input id="aset_coa_vvd_cd"  style="width:85px;" class="input2" readonly name="aset_coa_vvd_cd" value="" caption="Cash VVD" type="text" required/><!--
					--><button class="input_seach_btn" name="btn_aset_cd_cmb_seq" id="btn_aset_cd_cmb_seq" type="button"></button><!--
				--></td>
				<th>Bank Charge</th>
				<td><!-- 
					--><input id="chg_coa_co_cd" style="width:30px;" class="input2" readonly name="chg_coa_co_cd" value="" caption="Bank Charge Company" type="text" /><!-- 
					--><input id="chg_coa_rgn_cd" style="width:30px;" class="input2" readonly name="chg_coa_rgn_cd" value="" caption="Bank Charge Region" type="text" /><!-- 
					--><input id="chg_coa_ctr_cd" style="width:60px;" class="input2" readonly name="chg_coa_ctr_cd" value="" caption="Bank Charge Center" type="text" /><!-- 
					--><input id="chg_coa_acct_no" style="width:60px;" class="input2" readonly name="chg_coa_acct_no" value="" caption="Bank Charge Account" type="text" /><!-- 
					--><input id="chg_coa_inter_co_cd" style="width:30px;" class="input2" readonly name="chg_coa_inter_co_cd" value="" caption="Bank Charge Inter Company" type="text" /><!-- 
					--><input id="chg_coa_vvd_cd" style="width:85px;" class="input2" readonly name="chg_coa_vvd_cd" value="" caption="Bank Charge VVD" type="text" /><!-- 
					--><button class="input_seach_btn" name="btn_chg_cmb_seq" id="btn_chg_cmb_seq" type="button"></button><!-- 
				--></td>
		
			</tr>
			<tr>
				<th>Ex.Gain</th>
				<td><!-- 
					--><input id="gain_coa_co_cd" style="width:30px;" class="input2" readonly name="gain_coa_co_cd" value="" caption="Ex.Gain Company" type="text" /><!--
					--><input id="gain_coa_rgn_cd" style="width:30px;" class="input2" readonly name="gain_coa_rgn_cd" value="" caption="Ex.Gain Region" type="text" /><!--
					--><input id="gain_coa_ctr_cd" style="width:60px;" class="input2" readonly name="gain_coa_ctr_cd" value="" caption="Ex.Gain Center" type="text" /><!--
					--><input id="gain_coa_acct_no" style="width:60px;" class="input2" readonly name="gain_coa_acct_no" value="" caption="Ex.Gain Account" type="text" /><!--
					--><input id="gain_coa_inter_co_cd" style="width:30px;" class="input2" readonly name="gain_coa_inter_co_cd" value="" caption="Ex.Gain Inter Company" type="text" /><!--
					--><input id="gain_coa_vvd_cd" style="width:85px;" class="input2" readonly name="gain_coa_vvd_cd" value="" caption="Ex.Gain VVD" type="text" /><!--
					--><button class="input_seach_btn" name="btn_gain_cd_cmb_seq" id="btn_gain_cd_cmb_seq" type="button"></button><!--
				--></td>
				<th>Ex.Loss</th>
				<td><!--
					--><input id="lss_coa_co_cd" style="width:30px;" class="input2" readonly name="lss_coa_co_cd" value="" caption="Ex.Loss Company" type="text" /><!--
					--><input id="lss_coa_rgn_cd" style="width:30px;" class="input2" readonly name="lss_coa_rgn_cd" value="" caption="Ex.Loss Region" type="text" /><!--
					--><input id="lss_coa_ctr_cd" style="width:60px;" class="input2" readonly name="lss_coa_ctr_cd" value="" caption="Ex.Loss Center" type="text" /><!--
					--><input id="lss_coa_acct_no" style="width:60px;" class="input2" readonly name="lss_coa_acct_no" value="" caption="Ex.Loss Account" type="text" /><!--
					--><input id="lss_coa_inter_co_cd" style="width:30px;" class="input2" readonly name="lss_coa_inter_co_cd" value="" caption="Ex.Loss Inter Company" type="text" /><!--
					--><input id="lss_coa_vvd_cd" style="width:85px;" class="input2" readonly name="lss_coa_vvd_cd" value="" caption="Ex.Loss VVD" type="text" /><!--
					--><button class="input_seach_btn" name="btn_lss_cd_cmb_seq" id="btn_lss_cd_cmb_seq" type="button"></button><!--
				--></td>
		 	</tr>
		</table> 
        
 		<table class="line_bluedot"><tr><td></td></tr></table>
        <h3 class="title_design">Contact  Information</h3>
        <table>
			<colgroup>
			  <col width="100"/>
			  <col width="120"/>
			  <col width="100"/>
			  <col width="120"/>
			  <col width="100"/>
			  <col width="120"/>
			  <col width="100"/>
			  <col width="*"/>
			</colgroup>
			<tr>
				<th>Contact Name</th>
				<td><input id="cntc_nm" style="width:120px;" class="input" name="cntc_nm" value="" maxlength="50" type="text" /></td>
				<th>Title</th>
				<td><input id="cntc_tit_nm" style="width:120px;" class="input" name="cntc_tit_nm" value="" maxlength="100" type="text" /></td>
				<th>Phone</th>
				<td><input id="cntc_phn_no" style="width:120px;" class="input" name="cntc_phn_no" value="" maxlength="20" type="text" /></td>
				<th>E-Mail</th>
				<td><input id="attr_ctnt2" style="width:120px;" class="input" name="attr_ctnt2" value="" maxlength="50" type="text" /></td>
			</tr>
		</table>              
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hidSheetDiv"  style="display:none" >
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>

