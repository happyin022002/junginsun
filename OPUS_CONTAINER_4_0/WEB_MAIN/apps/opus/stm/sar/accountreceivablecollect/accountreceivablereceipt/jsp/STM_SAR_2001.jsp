<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAR_2001.js
*@FileTitle  : Receipts
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2001Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>  

<%
    StmSar2001Event  event = null;				//PDTO(Data Transfer Object including Parameters) //temp
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt"); 
	
	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");
	String sysStartDate = JSPUtil.getKST("yyyy-MM") + "-01";
	
	 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		event = (StmSar2001Event)request.getAttribute("Event"); //temp
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
<form name="form">
<input type="text" name="f_cmd" id="f_cmd" style="display:none"/>
<input type="text" name="pagerows" id="pagerows"  style="display:none"/>
<input type="text" name="rct_seq" id="rct_seq"  style="display:none"/>
<input type="text" name="ots_ofc_cd" id="ots_ofc_cd" value=""  style="display:none"/>
<input type="text" name="rhq_cd" id="rhq_cd"  style="display:none"/>
<input type="text" name="ots_smry_cd" id="ots_smry_cd"  style="display:none"/>
<input type="text" name="ots_cd" id="ots_cd"  style="display:none"/>
<input type="text" name="rep_ots_ofc_cd" id="rep_ots_ofc_cd"  style="display:none"/>
<input type="text" name="rct_unapy_flg" id="rct_unapy_flg"  style="display:none"/>
<input type="text" name="ofc_entr_lvl_cd" id="ofc_entr_lvl_cd"  style="display:none"/>
<input type="text" name="dp_prcs_knt" value="2" id="dp_prcs_knt"  style="display:none"/>
<input type="text" name="acct_ctnt" id="acct_ctnt"  style="display:none"/>
<input type="text" name="acct_ctnt2" id="acct_ctnt2"  style="display:none"/>
<input type="text" name="cust_cnt_cd" id="cust_cnt_cd"  style="display:none"/>
<input type="text" name="cust_seq" id="cust_seq"  style="display:none"/>
<input type="text" name="cust_use_flg" id="cust_use_flg"  style="display:none"/>
<input type="text" name="bank_ctrl_cd" id="bank_ctrl_cd"  style="display:none"/>
<input type="text" name="bank_acct_seq" id="bank_acct_seq"  style="display:none"/>
<input type="text" name="bal_rct_amt" id="bal_rct_amt"  style="display:none"/>
<input type="text" name="rct_sts_cd" id="rct_sts_cd"  style="display:none"/>
<input type="text" name="chg_tp_cd" id="chg_tp_cd"  style="display:none"/>
<input type="text" name="bl_curr_cd" id="bl_curr_cd"  style="display:none"/>
<input type="text" name="rct_cxl_dt" id="rct_cxl_dt"  style="display:none"/>
<input type="text" name="rct_cxl_cate_cd" id="rct_cxl_cate_cd"  style="display:none"/>
<input type="text" name="rct_cxl_rsn_cd" id="rct_cxl_rsn_cd"  style="display:none"/>
<input type="text" name="rct_cxl_rmk" id="rct_cxl_rmk"  style="display:none"/>
<input type="text" name="save_kind_cd" id="save_kind_cd"  style="display:none"/>
<input type="text" name="ots_srch_flg" id="ots_srch_flg"  style="display:none"/>
<input type="text" name="rvs_all_flg" id="rvs_all_flg"  style="display:none"/>
<input type="text" name="agn_cd" id="agn_cd"  style="display:none"/>
<input type="text" name="usr_id" value="<%=strUsr_id%>" id="usr_id"  style="display:none"/>
<input type="text" name="bfr_cust_cnt_cd" id="bfr_cust_cnt_cd"  style="display:none"/>
<input type="text" name="bfr_cust_seq" id="bfr_cust_seq"  style="display:none"/>
<input type="text" name="ots_rct_tmp_seq" id="ots_rct_tmp_seq"  style="display:none"/>
<input type="text" name="com_mrdPath" value="" id="com_mrdPath"  style="display:none"/>
<input type="text" name="com_mrdArguments" value="" id="com_mrdArguments"  style="display:none"/>
<input type="text" name="com_mrdTitle" value="Tax Receipt" id="com_mrdTitle"  style="display:none"/>
<input type="text" name="com_mrdBodyTitle" value="Tax Receipt" id="com_mrdBodyTitle"  style="display:none"/>
<input type="text" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt"  style="display:none"/>
<input type="text" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit"  style="display:none"/>
<input type="text" name="com_mrdSaveDialogFileName" value="Tax Receipt" id="com_mrdSaveDialogFileName"  style="display:none"/>
<input type="text" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir"  style="display:none"/>
<!-- Local Charge를 사용할 수 있는 Office 에 대한 처리 2014.11.18-->
<input type="text" name="local_chg_flag" id="local_chg_flag"  style="display:none"/>
<input type="text" name="ar_curr_cd" id="ar_curr_cd"  style="display:none"/>
<input type="text" name="acct_ctnt3" id="acct_ctnt3"  style="display:none"/>
<input type="text" name="acct_ctnt4" id="acct_ctnt4"  style="display:none"/>
<input type="text" name="ib_ob_cd" id="ib_ob_cd"  style="display:none"/>
<input type="text" name="rct_doc_cd" id="rct_doc_cd"  style="display:none"/>
<!-- Input Box for MI/ML Limit Amount Check 2014.09.15 -->
<input type="text" name="misc_ofc_cd" id="misc_ofc_cd"  style="display:none">
<input type="text" name="misc_tp_cd" id="misc_tp_cd"  style="display:none">
<input type="text" name="misc_amt" id="misc_amt"  style="display:none">
<input type="text" name="misc_xch_rt_dt" id="misc_xch_rt_dt"  style="display:none">
<input type="text" name="misc_curr_cd" id="misc_curr_cd"  style="display:none">
<!-- Add for checking modified 2015.01.06 -->
<input type="text" name="tmp_agn_ofc_cd" id="tmp_agn_ofc_cd"  style="display:none">
<input type="text" name="tmp_asa_no" id="tmp_asa_no"  style="display:none">
<input type="text" name="tmp_cust_cnt_cd" id="tmp_cust_cnt_cd"  style="display:none">
<input type="text" name="tmp_cust_seq" id="tmp_cust_seq"  style="display:none">
<input type="text" name="tmp_rmk" id="tmp_rmk"  style="display:none">
<input type="text" name="tmp_bank_chg_amt" id="tmp_bank_chg_amt"  style="display:none">
<!-- BackEndJob -->
<input type="text" name="backendjob_key" id="backendjob_key"  style="display:none">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_view_accounting" id="btn_view_accounting" type="button">View Accounting</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_receipt" id="btn_receipt" type="button">Receipt</button><!--
		--><button class="btn_normal" name="btn_cancel" id="btn_cancel" type="button">Cancel</button><!--
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
<div class="wrap_search ">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="90" />  	<!-- deposit -->
					<col width="50" />		<!-- agent -->
					<col width="100" />
					<col width="50" />		<!-- asa no -->
					<col width="140" />
					<col width="50" />		<!-- Invoice Type -->
					<col width="170" />
					<col width="50" />		<!-- bound -->
					<col width="140" />
					<col width="50" />		<!-- receipt no -->
					<col width="140" />
					<col width="50" />		<!-- office -->
					<col width="*" />
				</colgroup>
				<tr>
					<th><button type="button" id="btn_deposit" name="btn_deposit" class="btn_etc">Deposit</button></th>
					<th>Agent</th>
	                <td><script type="text/javascript">ComComboObject('agn_ofc_cd', 1, 80, 1, 0);</script></td>
	                <th>ASA No</th>
	                <td><script type="text/javascript">ComComboObject('asa_no', 2, 110, 1, 0);</script></td>
	                
	                <th id="invoice_label">Invoice Type</th>
	                <td id="invoice_input"><script type="text/javascript">ComComboObject('invoice_type', 2, 150, 1, 1,1);</script></td>
	                
	                <th id="bound_label">Bound</th>
	                <td id="bound_input"><script type="text/javascript">ComComboObject('bound_type', 2, 70, 1, 1,1);</script></td>
	                
	                <th>Receipt No</th>
	                <td><input type="text" style="width:150px;" class="input1" name="rct_no" dataformat="engup" maxlength="20" id="rct_no" /></td>
	                <th>Office</th>
	                <td><script type="text/javascript">ComComboObject('rct_ofc_cd', 1, 80, 1, 1);</script></td>
				</tr>
			</tbody>
		</table>
		<div><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="180" />
					<col width="100" />
					<col width="235" />
					<col width="120" />
					<col width="190" />
					<col width="50" />
					<col width="*" />
				</colgroup>
				<tr>
	                <th>Cheque No</th>
	                <td><input type="text" style="width:140px;" class="input" name="chq_no" dataformat="engup" maxlength="17" id="chq_no" /></td>
	                <th>Bank</th>
	                <td><input type="text" style="width:180px;" class="input1" name="bank_acct_nm" readonly tabindex="-1" id="bank_acct_nm" /><button type="button" id="btns_bank" name="btns_bank" class="input_seach_btn"></button></td>
	                <th>Receipt Date</th>
	                <td><input type="text" style="width:80px;" class="input1" name="rct_dt" dataformat="ymd" maxlength="8" cofield="rct_dps_dt" caption="Receipt date" id="rct_dt" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
	                <th>Unidentified</th>
	                <td><input type="text" style="width:150px; text-align:right" class="input2" name="unid_amt" readonly tabindex="-1" id="unid_amt" /></td>
	              </tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="555" />
					<col width="70" />
					<col width="202" />
					<col width="50" />
					<col width="*" />
				</colgroup>
	              <tr>
	                <th>Amount</th>
	                <td><input type="text" style="width:40px;" class="input2" name="rct_curr_cd" readonly tabindex="-1" id="rct_curr_cd" /><input type="text" style="width:230px;text-align:right" class="input1" name="rct_amt" dataformat="float" maxlength="23" pointcount="3" maxnum="999999999999999.999" id="rct_amt" /></td>
	                <th>Deposit Date</th>
	                <td><input type="text" style="width:80px;" class="input1" name="rct_dps_dt" dataformat="ymd" maxlength="8" cofield="rct_dt" caption="Deposit date" id="rct_dps_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
	                <th>Unapplied</th>
	                <td><input type="text" style="width:150px; text-align:right" class="input2" name="unapp_amt" readonly tabindex="-1" id="unapp_amt" /></td>
	              </tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="534" />
					<col width="101" />
					<col width="187" />
					<col width="79" />
					<col width="*" />
				</colgroup>
				<tr>
	                <th>Customer</th>
	                <td><input type="text" style="width:40px;" class="input" name="rct_cust_cnt_cd" maxlength="2" dataformat="engup" id="rct_cust_cnt_cd" /><input type="text" style="width:62px;" class="input" name="rct_cust_seq" maxlength="6" dataformat="num" id="rct_cust_seq" /><button type="button" id="btns_cust_info" name="btns_cust_info" class="input_seach_btn"></button><input type="text" style="width: 230px;" class="input2" name="rct_cust_nm" id="rct_cust_nm" readonly tabindex="-1"><input type="text" style="width:100px;" class="input2" name="rct_cust_rgst_no" readonly tabindex="-1" id="rct_cust_rgst_no" /><button type="button" id="btns_cust" name="btns_cust" class="input_seach_btn"></button></td>
	                <th>Receipt Type</th>
	                <td><script type="text/javascript">ComComboObject('rct_tp_cd', 1, 100, 1, 1);</script></td>
	                <th>Applied</th>
	                <td><input type="text" style="width:150px; text-align:right" class="input2" name="app_amt" readonly tabindex="-1" id="app_amt" /> </td>
	              </tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="51" />
					<col width="80" />
					<col width="71" />
					<col width="100" />
					<col width="41" />
					<col width="100" />
					<col width="40" />
					<col width="80" />
					<col width="42" />
					<col width="80" />
					<col width="40" />
					<col width="176" />
					<col width="*" />
				</colgroup>
				<tr>
	                <th>Credit Mark</th>
	                <td><input type="text" style="width:40px;" class="input2" name="crd_mark" readonly tabindex="-1" id="crd_mark" /></td>
	                <th>Credit Office</th>
	                <td><input type="text" style="width:60px;" class="input2" name="crd_ofc_cd" readonly tabindex="-1" id="crd_ofc_cd" /></td>
	                <th>I/B Credit Term</th>
	                <td><input type="text" style="width:30px;" class="input2" name="ib_crd_term" readonly tabindex="-1" id="ib_crd_term" /></td>
	                <th>O/B Credit Term</th>
	                <td><input type="text" style="width:30px;" class="input2" name="ob_crd_term" readonly tabindex="-1" id="ob_crd_term" /></td>
	                <th>RLS CNTL</th>
	                <td><input type="text" style="width:30px;" class="input2" name="rls_cntl" readonly tabindex="-1" id="rls_cntl" /></td>
	                <th>Issue Type</th>
	                <td><input type="text" style="width:30px;" class="input2" name="iss_tp" readonly tabindex="-1" id="iss_tp" /></td>
	                <th>Cancel</th>
	                <td><input type="text" style="width:150px;text-align:left" class="input2" name="cxl_desc" readonly tabindex="-1" id="cxl_desc" /></td>
	              </tr>
	        </tbody>
		</table>
	    <table>
			<tbody>
				<colgroup>
					<col width="80" />
					<col width="*" />
				</colgroup>
	            <tr>
	                <th>Remark</th>
	                <td><input type="text" style="width:715px;" class="input" name="rct_rmk" maxlength="110" id="rct_rmk" /></td>
	                <th></th>
	                <th></th>
	            </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
		<div class="layout_flex_fixed" style="width: 49%">
			
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<!-- opus_design_btn (S) -->
				<div class="grid_option_left" style="width:50%">
					<table>
						<colgroup>
							<col width="80" />
							<col width="80" />
							<col width="*" />
						</colgroup>
						<tbody>
							<tr>
								<th id="bl_label" align="right">B/L No&nbsp;&nbsp;</th>
				                <td id="bl_input"><input type="text" style="width:108px;" class="input" name="bl_no" dataformat="engup" maxlength="13" id="bl_no" /></td>
				                <th id="inv_label" align="right">Invoice No&nbsp;&nbsp;</th>
				                <td id="inv_input"><input type="text" style="width:114px;" class="input" name="inv_no" dataformat="engup" maxlength="15" id="inv_no" /></td>
								<td><button type="button" id="btn_otsadd" name="btn_otsadd" class="btn_etc">OTS Add</button></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_search" id="btn_search" type="button">OTS Search</button><!--
					--><button class="btn_normal" name="btn_reverse" id="btn_reverse" type="button">APP Reverse</button><!--
					--><button class="btn_normal" name="btn_del1" id="btn_del1" type="button">Row Delete</button>
				</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- layout_vertical_2(E) -->
		
		<!-- layout_vertical_2(S) -->
		<div class="layout_flex_flex" style="padding-left: 50%;padding-top:0px">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
					--><button class="btn_normal" name="btn_del2" id="btn_del2" type="button">Row Delete</button>
				</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<div style="float: right">
			<table>
				<tbody>
					<tr>
		              	<th>Sub Total</th>
		                <td><input type="text" style="width:40px;" class="input2" name="ttl_curr_cd" readonly tabindex="-1" id="ttl_curr_cd" /><input type="text" style="width:154px;text-align:right" class="input2" name="bl_ttl_amt" readonly tabindex="-1" id="bl_ttl_amt" /></td>
	              	</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div style="clear: both;"></div>
	<div><table class="line_bluedot"><tr><td colspan="6"></td></tr></table></div>
		<div class="layout_wrap">
		<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2">
				<div style="float: left;">
					<table>
						<tbody>
							<colgroup>
								<col width="90" />
								<col width="200" />
								<col width="80" />
								<col width="110" />
								<col width="80" />
								<col width="*" />
							</colgroup>
							<tr>
				                <th>Bank Charge</th>
				                <td><input type="text" style="width:150px;text-align:right" class="input2" name="bank_chg_amt" dataformat="float" maxlength="12" pointcount="3" maxnum="99999999.999" readonly id="bank_chg_amt" /> </td>
			              	</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="layout_vertical_2">
				<div style="float: right">
					<table>
						<tbody>
							<colgroup>
								<col width="80" />
								<col width="50" />
								<col width="90" />
								<col width="110" />
								<col width="3" />
								<col width="*" />
							</colgroup>
							<tr>
				                <th>Total Count</th>
				                <td><input type="text" style="width:40px;" class="input2" name="ttl_count" readonly tabindex="-1" id="ttl_count" /> </td>
				                <th>Total Amount</th>
				                <td> <input type="text" style="width:154px;text-align:right" class="input2" name="ttl_amt" readonly tabindex="-1" id="ttl_amt" /> </td>
				                <td></td>
			              	</tr>
						</tbody>
					</table>
				</div>
				</div>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_result(E) -->
</form>

