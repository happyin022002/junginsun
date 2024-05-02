<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0101.jsp
*@FileTitle  : Invoice List Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%
	String csr_no = JSPUtil.getNull(request.getParameter("csr_no"));
	String cost_ofc_cd = JSPUtil.getNull(request.getParameter("cost_ofc_cd"));

	String ofc_cd = "";
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	var csr_no = '<%=JSPUtil.getNull(csr_no)%>';
    function setupPage(){
        loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Invoice List Inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_close" 		id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70">
				<col width="70">
				<col width="60">
				<col width="40">
				<col width="130">
				<col width="100">
				<col width="120">
				<col width="80">
				<col width="100">
				<col width="*">				
			</colgroup>
			<tbody>
				<tr>
					<th>CSR No.</th>
					<td colspan="3"><input name="csr_no" type="text" style="width:252px;" value="<%=csr_no%>" class="input" readonly id="csr_no" /></td>
					<th>Payment S/P</th>
					<td colspan="5"><input name="vndr_no" type="text" style="width:80px;" value="" class="input" readonly id="vndr_no" /><input name="inv_desc" type="text" style="width:215px;" value="" class="input" readonly="" id="inv_desc" /></td>
				</tr>
				<tr>
					<th>No. of INV</th>
					<td><input name="no_of_inv" type="text" style="width:30px;" value="" class="input" readonly id="no_of_inv" /></td>
					<th>INV Currency</th>
					<td><input name="csr_curr_cd" type="text" style="width:55px;" value="" class="input" readonly id="csr_curr_cd" /></td>
					<th>Total AMT</th>
					<td><input name="csr_amt" type="text" style="width:80px;text-align:right;" value="" class="input" readonly id="csr_amt" /></td>
					<th>ASA No.</th>
					<td><input name="attr_ctnt2" type="text" style="width:80px;" value="" class="input" readonly id="attr_ctnt2" /></td>
					<th>Cost OFC</th>
					<td><input name="ofc_cd" type="text" style="width:65px;" value="<%=cost_ofc_cd%>" class="input" readonly id="ofc_cd" /></td>
				</tr>
				<tr>
					<th>Issue DT</th>
					<td><input name="iss_dt" type="text" style="width:75px;" value="" class="input" readonly id="iss_dt" /></td>
					<th>Receive DT</th>
					<td><input name="rcv_dt" type="text" style="width:75px;" value="" class="input" readonly id="rcv_dt" /></td>
					<th>Payment Term</th>
					<td><input name="vndr_term_nm" type="text" style="width:80px;" value="" class="input" readonly id="vndr_term_nm" /></td>
					<th>Payment Due DT</th>
					<td><input name="due_dt" type="text" style="width:80px;" value="" class="input" readonly id="due_dt" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<div class="opus_design_grid"  id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>		
</form>

<div style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>