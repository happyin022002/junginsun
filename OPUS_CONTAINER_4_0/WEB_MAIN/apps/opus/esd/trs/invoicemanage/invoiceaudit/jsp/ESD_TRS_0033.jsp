<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0033.jsp
*@FileTitle  : Invoice Audit & Confirm
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/04
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event"%>
<%
	EsdTrs0033Event  event = null;	
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";								 
	int rowCount	 = 0;								  
	SignOnUserAccount account= null;
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
	String inv_no = JSPUtil.getNull(request.getParameter("inv_no"));
	String inv_vndr_seq = JSPUtil.getNull(request.getParameter("inv_vndr_seq"));
	String mode = JSPUtil.getNull(request.getParameter("mode"));
	String if_sys_knd_cd_param = JSPUtil.getNull(request.getParameter("if_sys_knd_cd_param"));
	String mode_tab = JSPUtil.getNull(request.getParameter("mode_tab"));
	if(mode_tab.equals("")) mode_tab = "A";
%>

<script type="text/javascript">
	var today = ComGetNowInfo("ymd", "-").replace(/-/gi, "");
	var mode_tab = '<%=mode_tab%>';
	<%= JSPUtil.getIBCodeCombo("calc_logic_cd", "", "CD00874", 0, "")%>
	function setupPage(){
			var errMessage = "<%=strErrMsg%>";
			if (errMessage.length >= 1) {
					ComShowMessage(errMessage);
			}
			loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="inv_no_param" value="<%=inv_no%>" id="inv_no_param" />
<input type="hidden" name="inv_vndr_seq_param" value="<%=inv_vndr_seq%>" id="inv_vndr_seq_param" />
<input type="hidden" name="mode_param" value="<%=mode%>" id="mode_param" />
<input type="hidden" name="trsp_inv_act_sts_cd_param" id="trsp_inv_act_sts_cd_param" />
<input type="hidden" name="hid_bkg" id="hid_bkg" />
<input type="hidden" name="TRSP_SO_VNDR_NO" id="TRSP_SO_VNDR_NO" />
<input type="hidden" name="if_sys_knd_cd_param" value="<%=if_sys_knd_cd_param%>" id="if_sys_knd_cd_param" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

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
               		<button type="button" class="btn_normal" name="btn_minimize"         id="btn_minimize">Minimize</button>                  
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
		<button type="button" class="btn_accent" name="btn_minimize" 	id="btn_minimize">Minimize</button>			
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

<div id="MiniLayer" style="display:inline">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">	
			<table>
				<tr>
					<th width="60px">Invoice No. </th>
					<td width="130px"><input name="invoice_no" type="text" style="width:122px;" maxlength="20" id="invoice_no" dataformat="engupetc"/></td>
					<th width="80px">Issue Date</th>
					<td width="120px"><input name="issue_dt" type="text" style="width:75px;" value="" maxlength="8" id="issue_dt" dataformat="num" onblur="checkDate(this);" /><button type="button" id="btns_issue" name="btns_issue" class="calendar ir"></button></td>
					<th width="100px">Receive Date</th>
					<td width="130px"><input name="recieve_dt" type="text" style="width:73px;" value="" maxlength="8" id="recieve_dt" dataformat="num" onblur="checkDate(this);" /><button type="button" id="btns_recieve" name="btns_recieve" class="calendar ir"></button></td>
					<td width="80px"></td>
					<td width="80px"></td>
					<td width="133px"></td>
					<td width="*">
						<div class="opus_design_btn">
							<button type="button" class="btn_etc" name="btng_apply" 	id="btng_apply">Apply</button><!-- 
						 --><button type="button" class="btn_etc" name="btng_reset" 	id="btng_reset">Reset</button>							
						</div>
					</td>
				</tr>			
				<tr>
					<th>W/O S/P</th>
					<td colspan="5"><input type="text" name="combo_svc_provider" style="width:122px;" onchange="getVendorSeq(sheetObjects[0], document.form, this.value)" id="combo_svc_provider" dataformat="engup" /><input type="text" name="svc_provider" class="input2" readonly style="width:405px;" id="svc_provider" /><button type="button" id="btng_provider" name="btng_provider" class="input_seach_btn"></button></td>
					<th>Payment S/P</th>
					<td  colspan="3"><input name="paymt_sp_cd" type="hidden"><script type="text/javascript">ComComboObject('paymt_sp_combo', 1, 75, 0);</script><!-- 
					 --><input name="paymt_sp_nm" readonly class="input2" type="text" style="width:215px;" id="paymt_sp_nm" />
					 </td>
				</tr>			
				<tr>
					<th>Currency</th>
					<td><%= BizComUtil.getCodeCombo("apply_currency","","style='width:122px;' onChange='setCurrChange();'","CURR",2,"0::ALL") %></td>
					<th>Invoice Amount</th>
					<td><input name="inv_amt" type="text" style="width:75px;text-align:right;" value="0" onblur="calAmt();" onfocus="initAmt(this);" id="inv_amt" dataformat="singledFloat" /> </td>
					<th>V.A.T Amount</th>
					<td><input name="vat_amt" type="text" style="width:101px;text-align:right;" value="0" onblur="calAmt();" onfocus="initAmt(this);" id="vat_amt" dataformat="float" /> </td>
					<th>W.H.T Amount</th>
					<td><input name="wht_amt" type="text" style="width:75px;text-align:right;" value="0" onblur="calAmt();" onfocus="initAmt(this);" id="wht_amt" dataformat="float" /> </td>
					<th>Total Amount</th>
					<td><input name="tot_amt" type="text" class="input2" readonly style="width:75px;text-align:right;" value="0" id="tot_amt" dataformat="float" /> </td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<div class="opus_design_inquiry">
				<div class="opus_design_inquiry wFit">	
					<table>
					<tr>
						<th width="80px">Work Order No.</th>
						<td width="200px"><input name="wo_no" type="text" style="width:155px;"  onblur="value_upper(this)" id="wo_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_wo_no" name="btns_wo_no" class="multiple_inq ir"></button></td>
						<th width="90px">Booking No.</th>
						<td width="180px"><input name="booking_no" type="text" style="width:155px;"  onblur="value_upper(this)" id="booking_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_booking_no" name="btns_booking_no" class="multiple_inq ir"></button></td>
						<td width="10px">&nbsp;</td>
						<th width="100px">Bill Of Lading No.</th>
						<td width="160px"><input name="bl_no" type="text" style="width:187px;"  onblur="value_upper(this)" id="bl_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_bl_no" name="btns_bl_no" class="multiple_inq ir"></button></td>
						<td><div class="opus_design_btn">
						<button type="button" class="btn_etc" name="btng_retrieve" 	id="btng_retrieve">Retrieve</button><!-- 
						--><button type="button" class="btn_etc" name="btng_reset2" 	id="btng_reset">Reset</button>							
					</div></td>
					</tr>
					<tr>
						<th>Equipment No.</th>
						<td class="sm pad_left_8"><input type="radio" name="eq_no_rdo" value="cntr" class="trans" checked id="eq_no_rdo" />Container&nbsp;<input type="radio" name="eq_no_rdo" value="chss" onclick="checkDigit();" class="trans" id="eq_no_rdo" />Chassis&nbsp;<input type="radio" name="eq_no_rdo" value="gnst" class="trans" id="eq_no_rdo" />Genset</td>
						<td class="sm" colspan="2"><input name="eq_no_text" type="text" style="width:254px;" onchange="checkDigit(this)" id="eq_no_text" dataformat="engup"  otherchar=","/><button type="button" id="btns_eq_no" name="btns_eq_no" class="multiple_inq ir"></button></td>
						<td width="10px">&nbsp;</td>
						<th>Service Order No. </th>
						<td><input name="so_no" type="text" style="width:187px;" onblur="value_upper(this)" id="so_no" dataformat="engup"  otherchar=","/><button type="button" id="btns_so_no" name="btns_so_no" class="multiple_inq ir"></button></td>
						<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>		
</div>	
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div name="tabLayer" id="tabLayer">
		<div class="opus_design_grid clear">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_surchargeapply" 	id="btng_surchargeapply">Surcharge Apply</button><!-- 
				--><button type="button" class="btn_normal" name="btng_invoicefileimport" 	id="btng_invoicefileimport">Invoice File Import</button><!-- 
				   <button type="button" class="btn_normal" name="btng_reject" 	id="btng_reject">Reject</button>--><!-- 
				--><button type="button" class="btn_normal" name="btng_cntrselect" 	id="btng_cntrselect">CNTR Select</button><!-- 
				--><button type="button" class="btn_normal" name="btng_cntrnoimport" 	id="btng_cntrnoimport">CNTR No. Import</button><!-- 
				--><button type="button" class="btn_normal" name="btng_downexcel0" 	id="btng_downexcel0">Down Excel</button><!-- 
				--><button type="button" class="btn_normal" name="btng_mtyselect" 	id="btng_mtyselect">MTY Select</button><!-- 
				--><button type="button" class="btn_normal" name="btng_currencychange" 	id="btng_currencychange">Cur. Change</button><!-- 
				--><button type="button" class="btn_normal" name="btng_verify" 	id="btng_verify">Verify</button><!-- 
				--><button type="button" class="btn_normal" name="btng_sendtoconfirmtab" 	id="btng_sendtoconfirmtab">Send to Confirm Tab</button><!-- 
				--><button type="button" class="btn_normal" name="btng_save" 	id="btng_save">Save</button>							
			</div>							
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		 </div>
		 <div class="opus_design_inquiry">
		 	 <table>
				<tr style="float: left;">
					<th>Sum Of Invoice Total Amount</th>
					<td><input name="cur_sum_inv_audit" type="text" style="width:35px;" readonly class="input2" id="cur_sum_inv_audit" />  <input name="sum_inv_tot_amt_audit" type="text" style="width:145px;text-align:right;" readonly="" class="input2" id="sum_inv_tot_amt_audit" /> </td>
					<th>Number Of Equipment</th>
					<td>20' <input name="num_eq_20_audit" type="text" value="0" style="width:50px; text-align:right;" readonly class="input2" id="num_eq_20_audit" /> </td>
					<td>40' <input name="num_eq_40_audit" type="text" value="0" style="width:50px; text-align:right" readonly class="input2" id="num_eq_40_audit" /> </td>
					<td>Total <input name="num_eq_tot_audit" type="text" value="0" style="width:50px; text-align:right" id="num_eq_tot_audit" /> </td>
				</tr>
			</table>
		 </div>	 
		
	</div>
	<div  name="tabLayer" id="tabLayer">
	<div class="opus_design_grid clear">
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_sendbackto" id="btng_sendbackto">Send Back to Auditing Object Tab</button>
				<button type="button" class="btn_normal" name="btng_save2" 		id="btng_save2">Save</button>							
				<button type="button" class="btn_normal" name="btng_confirm" 	id="btng_confirm">Confirm</button>													
			</div>	
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		 <div class="opus_design_inquiry">
			<table>
				<tr style="float: left;">
					<th>Sum Of Invoice Total Amount</th>
					<td><input name="cur_sum_inv" type="text" style="width:35px;" readonly class="input2" id="cur_sum_inv" />  <input name="sum_inv_tot_amt" type="text" style="width:145px;text-align:right;" readonly="" class="input2" id="sum_inv_tot_amt" />  </td>
					<th>Number Of Equipment</th>
					<td>20' <input name="num_eq_20" type="text" value="0" style="width:50px; text-align:right;" readonly class="input2" id="num_eq_20" /> </td>
					<td>40' <input name="num_eq_40" type="text" value="0" style="width:50px; text-align:right;" readonly class="input2" id="num_eq_40" /> </td>
					<td>Total <input name="num_eq_tot" type="text" value="0" style="width:50px; text-align:right;" id="num_eq_tot" /> </td>
				</tr>
			</table>
		</div>
	</div>
	 <div name="tabLayer" id="tabLayer">
		<div class="opus_design_grid clear">
			 <script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
	</div>
	<div name="tabLayer" id="tabLayer">
	<div class="opus_design_grid clear">					
	 	<script type="text/javascript">ComSheetObject('sheet4');</script>			
	</div>		
	<div class="opus_design_grid">					
	 	<script type="text/javascript">ComSheetObject('sheet6');</script>						
	</div>	
	</div>	
</div>
<div class="header_fixed"></div>
<% if("false".equals(mainPage)){  %>
</div>
<% } %>

</form>


<FORM NAME='scgForm' method='POST'>
<input type="hidden" name="unique_cd" id="unique_cd" />
<input type="hidden" name="open_mode" id="open_mode" />
<input type="hidden" name="step_cd" id="step_cd" />
<input type="hidden" name="main_row" id="main_row" />
<input type="hidden" name="sheet_arr_no" id="sheet_arr_no" />
<input type="hidden" name="ofc_cty_cd" id="ofc_cty_cd" />
<input type="hidden" name="so_seq" id="so_seq" />
<input type="hidden" name="curr_cd" id="curr_cd" />
<input type="hidden" name="cgo_tp_cd" id="cgo_tp_cd" />
<input type="hidden" name="multi_ofc_cty_cd" id="multi_ofc_cty_cd" />
<input type="hidden" name="multi_so_seq" id="multi_so_seq" />
<input type="hidden" name="multi_cgo_tp_cd" id="multi_cgo_tp_cd" />
<input type="hidden" name="check_row" id="check_row" />
</FORM>

