<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_0042.jsp
*@FileTitle  : Slip Inquiry Detail 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/17
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0042Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0042Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.timecharterinoutaccounting.tcharterioconsultation");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmFms0042Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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

<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="usr_id" name="usr_id" value="<%=strUsr_id%>" type="hidden" />
<input id="csr_type" name="csr_type" type="hidden" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Consultation Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Consultation Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Consultation Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="layer_popup_title"> 
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Slip Inquiry Detail</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_tax" name="btn_tax" class="btn_accent" style="display:none;">Tax </button><!--
		--><button type="button" id="btn_print" name="btn_print" class="btn_normal">Print</button><!--
		--><button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<h3 class="title_design">Slip Inquiry Detail</h3>
		<table> 
			<tr class="h23">
				<th>Vessel Code</th>
				<td><input style="width:56px;text-align:center;" class="input2" value="<%=vsl_cd%>" readonly type="text" /><input id="vsl_eng_name" style="width:200px;" class="input2" name="vsl_eng_name" value="&nbsp;<%=vsl_eng_nm%>" readonly type="text" /></td>
				<th>CSR No.</th>
				<td><input id="csr_no" style="width:183px;text-align:center;" class="input2" name="csr_no" value="<%=csr_no%>" readonly type="text" /> </td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<h3 style="margin-bottom:0" class="title_design">Slip Inquory - Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
	<table>
			<colgroup>
				<col width="920px" />				
				<col width="323px" />				
				<col width="120px" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
				<tr class="h23">
					<td></td>
					<th>Total Amount</th>
					<td><input style="width:50px;text-align:center;" class="tr_head3" value="DR" readonly type="text" />  <input id="dr_amt" style="width:100px;text-align:right;" class="tr_head3" name="dr_amt" readonly type="text" /> </td>
					<td><input id="diff" style="width:50px;text-align:center;" class="tr_head3" name="diff" readonly type="text" />  <input id="cr_amt" style="width:100px;text-align:right;" class="tr_head3" name="cr_amt" readonly type="text" /> </td>
				</tr>
				<tr class="h23">
					<td></td>
					<td></td>
					<td></td>
					<td  id="balanceAmt" name="balanceAmt" ><input style="width:50px;text-align:center;" class="tr_head3" value="Balance" readonly type="text" />  <input id="balance_amt" style="width:100px;text-align:right;" class="tr_head3" name="balance_amt" readonly type="text" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- </div>	
<div class="wrap_result"> -->
</div>
</div>
</form>