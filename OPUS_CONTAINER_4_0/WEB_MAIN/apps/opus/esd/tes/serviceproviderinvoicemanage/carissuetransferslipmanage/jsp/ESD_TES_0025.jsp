<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TES_0025.jsp
*@FileTitle  : 3rd Party Interface
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/16
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

	String csr_no="";
	String vndr_no="";
	String inv_desc="";
	String no_of_inv="";
	String csr_curr_cd="";
	String csr_amt="";
	String attr_ctnt2="";
	String iss_dt="";
	String rcv_dt="";
	String vndr_term_nm="";
	String due_dt="";
	csr_no = JSPUtil.getNull(request.getParameter("csr_no"));
	vndr_no = JSPUtil.getNull(request.getParameter("vndr_no"));
	inv_desc = JSPUtil.getNull(request.getParameter("inv_desc"));
	no_of_inv = JSPUtil.getNull(request.getParameter("no_of_inv"));
	csr_curr_cd = JSPUtil.getNull(request.getParameter("csr_curr_cd"));
	csr_amt = JSPUtil.getNull(request.getParameter("csr_amt"));
	attr_ctnt2 = JSPUtil.getNull(request.getParameter("attr_ctnt2"));
	iss_dt = JSPUtil.getNull(request.getParameter("iss_dt"));
	rcv_dt = JSPUtil.getNull(request.getParameter("rcv_dt"));
	vndr_term_nm = JSPUtil.getNull(request.getParameter("vndr_term_nm"));
	due_dt = JSPUtil.getNull(request.getParameter("due_dt"));

	String ofc_cd = "";
	try {
	   SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   ofc_cd = account.getOfc_cd()!=null&&!account.getOfc_cd().equals("")?account.getOfc_cd():"";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
	var csr_no = '<%=JSPUtil.getNull(csr_no)%>';
    function setupPage(){
		loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd"> 
	
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Rejected CSR Cancellation</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_save" id="btng_save">Save</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents" style="overflow:hidden">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit sm">
			<table> 
	            <colgroup>
	                <col width="8%" />
	                <col width="6%" />
	                <col width="10%" />
	                <col width="8%" />	                
	                <col width="8%" />
	                <col width="14%" />
	                <col width="7%" />
	                <col width="21%" />
	                <col width="8%" />
	                <col width="*" />
	            </colgroup>
				<tbody>
					<tr>
						<th>CRS No.</th>
						<td>
							<input name="csr_no" type="text" style="width:235;" value='<%=csr_no%>' class="input" readonly>
						</td>
						<th>Payment S/P</th>
						<td colspan="7">
							<input name="vndr_no" type="text" style="width:80;" value='<%=vndr_no%>' class="input" readonly>
							<input name="inv_desc" type="text" style="width:250;" value='<%=inv_desc%>' class="input" readonly>
						</td>
					</tr>
					<tr>
						<th>No. of INV</th>
						<td>
							<input name="no_of_inv" type="text" style="width:25;" value='<%=no_of_inv%>' class="input" readonly>
						</td>
						<th>INV Currency</th>
						<td>
							<input name="csr_curr_cd" type="text" style="width:40;" value='<%=csr_curr_cd%>' class="input" readonly>
						</td>
						<th>Total AMT</th>
						<td>
							<input name="csr_amt" type="text" style="width:80;text-align:right;" value='<%=csr_amt%>' class="input" readonly>
						</td>
						<th>ASA No.</th>
						<td>
							<input name="attr_ctnt2" type="text" style="width:120;" value='<%=attr_ctnt2%>' class="input" readonly>
						</td>
						<th>Cost OFC</th>
						<td>
							<input name="ofc_cd" type="text" style="width:61;" value="<%=ofc_cd%>" class="input" readonly>
						</td>
					</tr>
					<tr>
						<th>Issue DT</th>
						<td>
							<input name="iss_dt" type="text" style="width:75;" value='<%=iss_dt%>' class="input" readonly>
						</td>
						<th>Receive DT</th>
						<td>
							<input name="rcv_dt" type="text" style="width:75;" value='<%=rcv_dt%>' class="input" readonly>
						</td>
						<th>Payment Term</th>
						<td>
							<input name="vndr_term_nm" type="text" style="width:120;" value='<%=vndr_term_nm%>' class="input" readonly>
						</td>
						<th>Payment Due DT</th>
						<td>
							<input name="due_dt" type="text" style="width:75;" value='<%=due_dt%>' class="input" readonly>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script>ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<div class="header_fixed"></div>
</form>
