<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0048.jsp
*@FileTitle  : 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event"%>
<%
	EsdTrs0048Event  event 		= null;	
	Exception serverException   = null;
	String strErrMsg 			= "";

	String csr_no 	= "";
	String selrow 	= "";
	csr_no 			= JSPUtil.getParameter(request, "csr_no".trim(), "");
	selrow 			= JSPUtil.getParameter(request, "rows".trim(), "");
	String ofc_cd = "";
	String userId = "";
	try {
	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd();
	   userId = account.getUsr_id();
		event = (EsdTrs0048Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} 
		loadPage();
	}
</script>
<form  name="form" >
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="selrow" value="<%=selrow%>" id="selrow" />
<input type="hidden" name="usr_id" value="<%=userId%>" id="usr_id" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd%>" id="ofc_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Rejected CSR Cancellation</span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent"  type="button" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
					<colgroup>
						<col width="90">
						<col width="220">
						<col width="100">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>CSR No.</th>
							<td><input name="csr_no" type="text" style="width: 150px;" value="<%=csr_no %>" id="csr_no" /> </td>
							<th>Payment Service Provider</th>
							<td><input name="vndr_no" type="text" style="width:75px;" value="" id="vndr_no" /><input name="vndr_nm" type="text" style="width: 250px;" value="" id="vndr_nm" /></td>
						</tr>
				</tbody>
			</table>
			<table>
					<colgroup>
						<col width="10">
						<col width="50">
						<col width="82">
						<col width="80">
						<col width="70">
						<col width="60">
						<col width="90">
						<col width="60">
						<col width="50">
						<col width="80">
						<col width="50">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<td></td>
							<th>No. of Invoice</th>
							<td><input name="inv_cnt" type="text" style="width:30px;" value="" id="inv_cnt" /> </td>
							<th>Invoice Currency</th>
							<td><input name="csr_curr_cd" type="text" style="width:40px;" value="" id="csr_curr_cd" /> </td>
							<th>Total AMT</th>
							<td><input name="csr_amt" type="text" style="width:80px;" value="" id="csr_amt" /> </td>
							<th>ASA No.</th>
							<td><input name="asa_no" type="text" style="width:75px;" value="" id="asa_no" /> </td>
							<th>Cost Office</th>
							<td><input name="cost_ofc" type="text" style="width:75px;" value="" id="cost_ofc" /></td>
							<td></td>
						</tr>
				</tbody>
			</table>
			<table>
					<colgroup>
						<col width="90">
						<col width="50">
						<col width="100">
						<col width="90">
						<col width="120">
						<col width="80">
						<col width="150">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Issue DT</th>
							<td><input name="max_iss_dt" type="text" style="width:75px;" value="" id="max_iss_dt" /> </td>
							<th>Receive DT</th>
							<td><input name="max_rcv_dt" type="text" style="width:75px;" value="" id="max_rcv_dt" /> </td>
							<th>Payment Term</th>
							<td><input name="vndr_term_nm" type="text" style="width:75px;" value="" id="vndr_term_nm" /> </td>
							<th>Payment Due DT</th>
							<td><input name="payment_due_dt" type="text" style="width:75px;" value="" id="payment_due_dt" /> </td>
						</tr>
				</tbody>
			</table>
		</div>
		
			<table class="line_bluedot"><tr><td></td></tr></table>
			
		<div class="wrap_result">
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" id="btng_save" name="btng_save">Save</button>
				</div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>
<form name='AuditForm' method='POST'>
<input type="hidden" name="inv_no" id="inv_no" />
<input type="hidden" name="inv_vndr_seq" id="inv_vndr_seq" />
<input type="hidden" name="editflag" id="editflag" />
<input type="hidden" name="mode" id="mode" />
</form>