<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0038.jsp
*@FileTitle  : USA Rail Invoice Register and Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>

<%
	EsdTrs0038Event  event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String codeList  = "";
	String userId = "";
	String ofcId = "";
	String inv_no = "";
	String inv_vndr_seq = "";
	String editflag = "";
	try {
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
	   ofcId=account.getOfc_cd();
	    inv_no = request.getParameter("inv_no") == null ? "" : request.getParameter("inv_no") ;
	    inv_vndr_seq = request.getParameter("inv_vndr_seq") == null ? "" : request.getParameter("inv_vndr_seq") ;
	    editflag = request.getParameter("editflag") == null ? "" : request.getParameter("editflag") ;
	    codeList  = JSPUtil.getCodeCombo("currency", "01", "style='width:90'", "CD00884", 0, "");
		event = (EsdTrs0038Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	var today = ComGetNowInfo("ymd", "-");
	<%= JSPUtil.getIBCodeCombo("inv_curr_cd", "", "CD00884", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cgo_tp_cd", "", "CD00748", 0, "")%>

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
<input type="hidden" name="VNDR_CNT_CD" value="Y" id="VNDR_CNT_CD" />
<input type="hidden" name="trsp_inv_aud_sts_cd" id="trsp_inv_aud_sts_cd" />
<input type="hidden" name="cntr_no" id="cntr_no" />
<input type="hidden" name="usr_id" value="<%=StringUtil.xssFilter(userId)%>" id="usr_id" />
<input type="hidden" name="ofc_cd" value="<%=StringUtil.xssFilter(ofcId)%>" id="ofc_cd" />
<input type="hidden" name="seq" id="seq" />
<input type="hidden" name="sts_cd" id="sts_cd" />
<input type="hidden" name="insflag" value="true" id="insflag" />
<input type="hidden" name="editflag" value="<%=StringUtil.xssFilter(editflag)%>" id="editflag" />
<input type="hidden" name="cntr_vndr_svc_cd" id="cntr_vndr_svc_cd" />
<input type="hidden" name="vndr_cost_cd" id="vndr_cost_cd" />
<input type="hidden" name="vndr_cnt_cd" id="vndr_cnt_cd" />
<input type="hidden" name="hid_inv_no" id="hid_inv_no" value="<%=StringUtil.xssFilter(inv_no)%>"/>
<input type="hidden" name="hid_inv_vndr_seq" id="hid_inv_vndr_seq" value="<%=StringUtil.xssFilter(inv_vndr_seq)%>" />
<input type="hidden" name="ptitle" id="ptitle" value="" />

<%String mainPage = JSPUtil.getNull(request.getParameter("mainPage"));%>
<% if("false".equals(mainPage)){  %>
<div class="layer_popup_title">
        <!-- page_title_area(S) -->
        <div class="page_title_area clear">
        
               <!-- page_title(S) -->
               <h2 class="page_title"><span id="title"></span></h2>
               <!-- page_title(E) -->
               
               <!-- opus_design_btn(S) -->
               <div class="opus_design_btn">
                	<button type="button" class="btn_accent" name="btn_minimize"    id="btn_minimize">Minimize</button><!-- 
			 --><button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>                 
               </div>
               <!-- opus_design_btn(E) -->
        </div>
<!-- page_title_area(E) -->
</div>
 
<div class="layer_popup_contents">
<%}else{ %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_reset" 	id="btn_reset">New</button><!--  		
		--><button type="button" class="btn_normal" name="btn_minimize" 	id="btn_minimize">Minimize</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<%} %>

<div  id="MiniLayer" class="wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="197">
				<col width="90">
				<col width="150">
				<col width="80">
				<col width="192">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Invoice No. </th>
				<td><input name="inv_no" type="text" style="width:90px;" value="" dataformat="engupetc" id="inv_no" onBlur='checkInvoiceName()' /></td>
				<th>Receive Date</th>
				<td><input name="receive_dt" type="text" style="width:75px;" maxlength="10" value="" onfocus="fun_Focus_del(this)" onblur="BlurDate(this);" id="receive_dt" /><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button></td>
				<th>Issue Date</th>
				<td><input name="issue_dt" type="text" maxlength="10" style="width:75px;" value="" onfocus="fun_Focus_del(this)" onblur="BlurDate(this);" id="issue_dt" /><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<th>Currency</th>
				<td><%=codeList%></td>
				<th>Invoice Amount</th>
				<td><input name="invoice_amt" type="text" style="width:75px;text-align:right;" value="0.00" onblur="calAmt();" onfocus="initAmt(this);" id="invoice_amt" dataformat="float" />  </td>
				<th>V.A.T Amount</th>
				<td style="width: 50px"><input name="vat_amt" type="text" style="width:75px;text-align:right;" value="0.00" onblur="calAmt();" onfocus="initAmt(this);" id="vat_amt" dataformat="float" /> </td>
				<th>Total Amount</th>
				<td><input name="total_amt" type="text" style="width:90px;text-align:right;" value="0.00" readonly class="input2" id="total_amt" dataformat="float" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="423">
				<col width="80">
				<col width="*">
			</colgroup>
			<tr>
				<th>Rail Road</th>
				<td><script type="text/javascript">ComComboObject('rail_road_code',2, 90 , 1 )</script><input name="rail_road_name" type="text" style="width:272px;" readonly class="input2" id="rail_road_name" /> </td>
				<th>Payment Vendor</th>
				<td><input name="payment_vndr_code" type="text" style="width:75px;" class="input2" id="payment_vndr_code" /><input name="payment_vndr_name" type="text" style="width:286px;" class="input2" id="payment_vndr_name" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="225">
				<col width="*">
			</colgroup>
			<tr>
				<th>Total Amount of Selected for Payment</th>
				<td><input name="total_amt_for_payment" type="text" style="width:230px;text-align:right;" value="0.00" readonly class="input2" id="total_amt_for_payment" /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
		<div class="opus_design_tab sm">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
		
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<!-- opus_design_btn (S) -->
				<div class="opus_design_btn"><!-- 
				--><button class="btn_accent" type="button" id="btng_downexcel_1" name="btng_downexcel_1">Down Excel</button><!--
				--><button class="btn_normal" type="button" id="t1btng_invoicefileimport" name="t1btng_invoicefileimport">Invoice File Import</button><!--
				--><button class="btn_normal" type="button" id="t1btng_paymenthistory" name="t1btng_paymenthistory">Payment History</button><!--
				   <button class="btn_normal" type="button" id="t1btng_reaudit" name="t1btng_reaudit">Re-Audit</button>--><!--
				--><button class="btn_normal" type="button" id="t1btng_save" name="t1btng_save">Save</button><!--
				--><button class="btn_normal" type="button" id="t1btng_confirm" name="t1btng_confirm">Confirm</button><!--
				--><button class="btn_normal" type="button" id="t1btng_print" name="t1btng_print">Print</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
							
			 <script type="text/javascript">ComSheetObject('t1sheet1');</script>
			 <div class="opus_design_inquiry">
			<table class="mar_top_8">
				<tr style="float:left">
					<th>Total Amount</th>
					<td><input name="total_amt_coincidence" id="total_amt_coincidence" type="text" style="width:100px;text-align:right;" value='0.00' readOnly class="input2"></td>
				</tr>
			</table>
			</div>
		</div>
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer">
			<div class="opus_design_btn">
					<div class="opus_design_btn"><!-- 
					--><button class="btn_accent" type="button" id="btng_downexcel_2" name="btng_downexcel_2">Down Excel</button><!--
					--><button class="btn_normal" type="button" id="t2btng_invoicefileimport" name="t2btng_invoicefileimport">Invoice File Import</button><!--
					--><button class="btn_normal" type="button" id="t2btng_paymenthistory" name="t2btng_paymenthistory">Payment History</button><!--
					   <button class="btn_normal" type="button" id="t2btng_reaudit" name="t2btng_reaudit">Re-Audit</button>--><!--
					--><button class="btn_normal" type="button" id="t2btng_move" name="t2btng_move">Move</button><!--
					--><button class="btn_normal" type="button" id="t1btng_save" name="t1btng_save">Save</button><!--
					--><button class="btn_normal" type="button" id="t2btng_confirm" name="t2btng_confirm">Confirm</button><!--
					--><button class="btn_normal" type="button" id="t2btng_print" name="t2btng_print">Print</button><!--
					--></div>						
			</div>	
			<script type="text/javascript">ComSheetObject('t2sheet1');</script>		
			<div class="opus_design_inquiry">	
			<table class="mar_top_8">
				<tr style="float:left">
					<th>Total Amount</th>
					<td><input name="total_amt_discrepancy" id="total_amt_discrepancy" type="text" style="width:100px;text-align:right;" value='0.00' readOnly class="input2"></td>
				</tr>
			</table>
			</div>
		</div>
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">
			<div class="opus_design_btn"><!-- 
			--><button class="btn_accent" type="button" id="btng_downexcel_3" name="btng_downexcel_3">Down Excel</button><!--
			--><button class="btn_normal" type="button" id="t3btng_invoicefileimport" name="t3btng_invoicefileimport">Invoice File Import</button><!--
			--><button class="btn_normal" type="button" id="t3btng_paymenthistory" name="t3btng_paymenthistory">Payment History</button><!--
			   <button class="btn_normal" type="button" id="t3btng_reaudit" name="t3btng_reaudit">Re-Audit</button>--><!--
			--><button class="btn_normal" type="button" id="t3btng_rowadd" name="t3btng_rowadd">Row Add</button><!--
			--><button class="btn_normal" type="button" id="t3btng_save" name="t3btng_save">Save</button><!--
			--><button class="btn_normal" type="button" id="t3btng_confirm" name="t3btng_confirm">Confirm</button><!--
			--><button class="btn_normal" type="button" id="t3btng_print" name="t3btng_print">Print</button><!--
			--></div>		
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>		
			<div class="opus_design_inquiry">	 
				<table class="mar_top_8">
					<tr style="float:left">
						<th>Total Amount</th>
						<td><input name="total_amt_invoice_only" id="total_amt_invoice_only" type="text" style="width:100px;text-align:right;" value='0.00' readOnly class="input2"></td>
					</tr>
				</table>
			</div>
			
		</div>
		<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display:none">	
			<div class="opus_design_btn"><!-- 
			--><button class="btn_accent" type="button" id="t4btng_downexce" name="t4btng_downexce">Down Excel</button><!--
			--></div>	
		 	<script type="text/javascript">ComSheetObject('t4sheet1');</script>			
		</div>
			<div class="opus_design_grid clear">
			 <script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
			<div class="opus_design_grid clear">
			 <script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
<% if("false".equals(mainPage)){  %>
</div>
<% } %>
</form>