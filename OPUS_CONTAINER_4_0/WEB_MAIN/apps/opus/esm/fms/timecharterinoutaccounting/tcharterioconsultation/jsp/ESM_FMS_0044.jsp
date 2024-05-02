<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0044.jsp
*@FileTitle  : Slip Correction - Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0044Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0044Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0044Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String vsl_cd 		= StringUtil.xssFilter(request.getParameter("vsl_cd"));
	String vsl_eng_nm 	= StringUtil.xssFilter(request.getParameter("vsl_eng_nm"));
	String csr_no 		= StringUtil.xssFilter(request.getParameter("csr_no"));
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
 <!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Slip Correction Detail</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_save" id="btn_save">Save</button><!--
		--><button class="btn_normal" type="button" name="btn_tax" id="btn_tax" style="display:none;">Tax</button><!--
		--><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button><!--
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
	<div class="opus_design_inquiry wFit">
	<h3 class="title_design">Slip Correction Head</h3>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="323" />				
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
				<tr>
					<th>Vessel Code</th>
					<td><input type="text" style="width:56px;text-align:center;" class="input2" value="<%=vsl_cd%>" readonly />  <input type="text" style="width:200px;" class="input2" value="&nbsp;<%=vsl_eng_nm%>" readonly /> </td>
					<th>CSR No.</th>
					<td><input type="text" style="width:183px;text-align:center;" class="input2" name="csr_no" value="<%=csr_no%>" readonly id="csr_no" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<h3 style="margin-bottom:0" class="title_design">Slip Correction - Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
			<colgroup>
				<col width="920" />				
				<col width="323" />				
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
				<tr>
					<td></td>
					<th>Total Amount</th>
					<td><input type="text" style="width:50px;text-align:center;" class="tr_head3" value="DR" readonly /><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="dr_amt" readonly id="dr_amt" /> </td>
					<td><input type="text" style="width:50px;text-align:center;" class="tr_head3" name="diff" readonly id="diff" /><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="cr_amt" readonly id="cr_amt" /> </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td  id="balanceAmt" name="balanceAmt" style="display:none;"><input type="text" style="width:50px;text-align:center;" class="tr_head3" value="Balance" readonly /><input type="text" style="width:100px;text-align:right;" class="tr_head3" name="balance_amt" readonly id="balance_amt" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</form>