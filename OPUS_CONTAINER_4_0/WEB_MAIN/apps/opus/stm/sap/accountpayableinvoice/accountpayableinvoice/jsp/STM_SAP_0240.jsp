<%/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   STM_SAP_0240.js
*@FileTitle  : Prepayment Invoices
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
<%-- <%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0240Event"%> --%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>

<%
    /* StmSap0240Event  event = null; */				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		
		/* event = (StmSap0240Event)request.getAttribute("Event"); */
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
	<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="hid_inv_seq" id="hid_inv_seq" />
<input type="hidden" name="hid_func_curr_cd" id="hid_func_curr_cd" />
<input type="hidden" name="hid_func_curr_prcs" id="hid_func_curr_prcs" />
<input type="hidden" name="hid_local_sysdate" id="hid_local_sysdate" />
<input type="hidden" name="hid_login_ap_ofc" id="hid_login_ap_ofc" />
<input type="hidden" name="hid_login_curr_cd" id="hid_login_curr_cd" />
<input type="hidden" name="hid_login_loc_cd" id="hid_login_loc_cd" />
<input type="hidden" name="inv_tp_lu_cd" value="PREPAYMENT" id="inv_tp_lu_cd" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Invoice Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Invoice Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Invoice Slip" id="com_mrdSaveDialogFileName" />
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
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!-- 
		--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button><!-- 
		--><button class="btn_normal" name="btn_cancel" id="btn_cancel" type="button">Cancel</button><!-- 
		--><button class="btn_normal" name="btn_apply" id="btn_apply" type="button">Apply/Unapply</button><!-- 
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
		<table>
			<tbody>
				<colgroup>
					<col width="60">
					<col width="300">
					<col width="50">
					<col width="300">
					<col width="70">
					<col width="*">
				</colgroup>
				<tr>
                    <th>Office</th>
                    <td><input type="text" style="width:80px;ime-mode:disabled"  class="input1" name="ofc_cd" id="ofc_cd" dataformat="engup" maxlength="6"><!--
                    --><button type="button" class="input_seach_btn" name="btns_search_ofc" id="btns_search_ofc" auth="R"></button>
                    </td>
                    <th>CSR No</th>
                    <td><input type="text" style="width:170px;ime-mode:disabled" class="input" name="inv_no" id="inv_no" maxlength="20" dataformat="engup"><!-- 
                    --><button type="button" class="input_seach_btn" name="btns_search_csr" id="btns_search_csr" auth="R"></button>
                    </td>
                    <th>Pay Group</th>
                    <td><input type="text" style="width:170px;" class="input" name="ap_pay_grp_lu_cd" id="ap_pay_grp_lu_cd" maxlength="20"><!-- 
                    --><button type="button" class="input_seach_btn" name="btns_search_paygroup" id="btns_search_paygroup" auth="R"></button>
                    </td>
                </tr>
                <tr>
                    <th>Inv Date</th>
                    <td><input type="text" style="width:80px;" value="" name="inv_fr_dt" required cofield="inv_to_dt" caption="start date" id="inv_fr_dt" dataformat="ymd" maxlength="10" class="input1"><!-- 
                    --><button type="button" class="calendar" name="btns_calInvFr" id="btns_calInvFr"></button>~&nbsp;
                    	<input type="text" style="width:80px" value="" name="inv_to_dt" required cofield="inv_fr_dt" caption="end date" id="inv_to_dt" dataformat="ymd" maxlength="10" class="input1"><!-- 
                    --><button type="button" class="calendar" name="btns_calInvTo" id="btns_calInvTo"></button>
                    </td>
                    <th>GL Date</th>
                    <td><input type="text" style="width:80px;" value="" name="gl_fr_dt" cofield="gl_to_dt" caption="start date" id="gl_fr_dt" dataformat="ymd" maxlength="10" class="input"><!-- 
                    --><button type="button" class="calendar" name="btns_calGlFr" id="btns_calGlFr"></button>~&nbsp;
                    	<input type="text" style="width:80px" value="" name="gl_to_dt" cofield="gl_fr_dt" caption="end date" id="gl_to_dt" dataformat="ymd" maxlength="10" class="input"><!-- 
                   	--><button type="button" class="calendar" name="btns_calGlTo" id="btns_calGlTo"></button>
                    </td>
                    <th>Supplier</th>
                    <td><input type="text" style="width:60px;ime-mode:disabled" class="input" name="vndr_no" id="vndr_no" maxlength="6" dataformat="num" onchange="vndr_no_onchange();"><!-- 
                    --><button type="button" class="input_seach_btn" name="btns_search_supplier" id="btns_search_supplier" auth="R"></button><!-- 
                    --><input type="text" style="width:200px;" class="input2" name="vndr_nm" id="vndr_nm" readonly>
                    </td>
                </tr>
                <tr>
                    <th>Source</th>
                    <td><input type="text" style="width:170px;" class="input" name="ap_inv_src_cd" id="ap_inv_src_cd" maxlength="20"><!-- 
                    --><button type="button" class="input_seach_btn" name="btns_search_source" id="btns_search_source" auth="R"></button>
                    </td>
                    <th>Supplier Inv No</th>
                    <td><input type="text" style="width:170px;" class="input" name="attr_ctnt1" id="attr_ctnt1" maxlength="30" dataformat="engupetc"></td>
                    <th>Curr</th>
                    <td><script type="text/javascript">ComComboObject('inv_curr_cd', 1, 70, 0, 0,0,false,1);</script></td>
                </tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_sheet1RowAdd" id="btn_sheet1RowAdd" type="button">Row Add</button>
			<button class="btn_normal" name="btn_sheet1RowDelete" id="btn_sheet1RowDelete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->


	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid clear" id="tabLayer" style="display:inline;">
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_sheet2CalcTax" id="btn_sheet2CalcTax">Calculate Tax</button>
			<button class="btn_normal" name="btn_sheet2RowAdd" id="btn_sheet2RowAdd" type="button">Row Add</button>
			<button class="btn_normal" name="btn_sheet2RowDelete" id="btn_sheet2RowDelete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
		
	<div class="opus_design_grid clear" id="tabLayer" style="display:none;">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_sheet3RowAdd" id="btn_sheet3RowAdd" type="button">Row Add</button>
			<button class="btn_normal" name="btn_sheet3RowDelete" id="btn_sheet3RowDelete" type="button">Row Delete</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
