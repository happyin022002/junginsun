<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0960.jsp
*@FileTitle  : Terminal invoice CSR Creation - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/08
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event"%>
<%
	EsdTrs0960Event  			event 				= null;
	Exception 					serverException   	= null;
	DBRowSet 					rowSet	  			= null;
	String 						strErrMsg 			= "";
	int 						rowCount	 		= 0;
	String csr_no  	= JSPUtil.getParameter(request, "csr_no".trim(), "");
	String mode		= JSPUtil.getParameter(request, "mode".trim()  , "");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0960Event)request.getAttribute("Event");
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
<form name="form" onload="javascript:setupPage();">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="iPage" name="iPage" type="hidden" />
<input id="mode" name="mode" value="<%=mode%>" type="hidden" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Invoice List Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="150"/>
				<col width="180"/>
				<col width="*" />				
			</colgroup>
			<tr>
				<th>CSR No.</th>
				<td><input id="csr_no" name="csr_no" style="width:257px;" value="<%=csr_no %>" type="text" /> </td>
				<th>Payment Service Provider</th>
				<td><input id="vndr_no" name="vndr_no" style="width:75px;" value="" type="text" /><input id="vndr_nm" name="vndr_nm" style="width:200px;" value="" type="text" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80"/>
				<col width="82"/>
				<col width="100"/>
				<col width="82"/>
				<col width="100"/>
				<col width="80"/>
				<col width="95"/>
				<col width="75"/>
				<col width="100"/>
				<col width="*" />				
			</colgroup>
			<tr>
				<th>No. of Invoice</th>
				<td><input id="inv_cnt" name="inv_cnt" style="width:30px;" value="" type="text" /> </td>
				<th>Invoice Currency</th>
				<td><input id="csr_curr_cd" name="csr_curr_cd" style="width:75px;" value="" type="text" /> </td>
				<th>Total AMT</th>
				<td><input id="csr_amt" name="csr_amt" style="width:80px;" value="" type="text" /> </td>
				<th>ASA No.</th>
				<td><input id="asa_no" name="asa_no" style="width:75px;" value="" type="text" /> </td>
				<th>Cost Office</th>
				<td><input id="cost_ofc" name="cost_ofc" style="width:75px;" value="" type="text" /> </td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="80"/>
				<col width="75"/>
				<col width="110"/>
				<col width="75"/>
				<col width="150"/>
				<col width="75"/>
				<col width="150"/>
				<col width="*" />				
			</colgroup>
			<tr>
				<th>Issue DT</th>
				<td><input id="max_iss_dt" name="max_iss_dt" style="width:75px;" value="" type="text" /> </td>
				<th>Receive DT</th>
				<td><input id="max_rcv_dt" name="max_rcv_dt" style="width:75px;" value="" type="text" /> </td>
				<th>Payment Term</th>
				<td><input id="vndr_term_nm" name="vndr_term_nm" style="width:75px;" value="" type="text" /> </td>
				<th>Payment Due DT</th>
				<td><input id="payment_due_dt" name="payment_due_dt" style="width:75px;" value="" type="text" /> </td>
			</tr>
		</table>
	
	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btng_detailinquiry" 		id="btng_detailinquiry">Detail Inquiry</button>
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</div>
</form>
<form name='AuditForm' method='POST'>
<input type='hidden' name='inv_no'>
<input type='hidden' name='inv_vndr_seq'>
<input type='hidden' name='inv_vndr_nm'>
<input type='hidden' name='editflag'>
<input type='hidden' name='mode'>
<input type='hidden' name='mode_tab'>
<input type="hidden" name="pgmNo" >
</form>
</body>
</html>
