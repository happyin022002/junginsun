<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sap_0510.jsp
*@FileTitle  : Internal Bank Account Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/11
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0510Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0510Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";					//에러메세지

	String ofc_type    = "";					//PARAMETER
	String ofc_code    = ""; 
	String inactive_type = "";
	String bank_acct_no = "";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0510Event)request.getAttribute("Event");  
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		ofc_type = StringUtil.xssFilter(request.getParameter("ofc_type"))!= null ? StringUtil.xssFilter(request.getParameter("ofc_type")) : "";  //PARAMETER
		ofc_code = StringUtil.xssFilter(request.getParameter("ofc_code"))!= null ? StringUtil.xssFilter(request.getParameter("ofc_code")) : "";  //PARAMETER
		inactive_type = StringUtil.xssFilter(request.getParameter("inactive_type"))!= null ? StringUtil.xssFilter(request.getParameter("inactive_type")) : "";  //PARAMETER
		bank_acct_no = StringUtil.xssFilter(request.getParameter("bank_acct_no"))!= null ? StringUtil.xssFilter(request.getParameter("bank_acct_no")) : "";  //PARAMETER


		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Internal Bank Account</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn_ok" id="btn_ok" >OK</button><!--
			--><button class="btn_normal" type="button" name="btn_close" id="btn_close" >Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>


<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50">				
					<col width="120">				
					<col width="70">				
					<col width="190">				
					<col width="100">				
					<col width="*">				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>Acct No</th>
						<td><input type="text" style="width:100px;text-align:left;" class="input" name="bank_acct_no" value="<%=bank_acct_no%>" id="bank_acct_no" /></td>
						<th>Office Type</th>
						<td>
							<input type="radio" name="ofc_type" id="ofc_type" value="AP" class="trans" <%= ofc_type.equals("") || ofc_type.equals("AP") ? "checked" : "disabled" %> ><label for="ofc_type">AP</label><!--
						--><input type="radio" name="ofc_type" id="ofc_type_1" value="AR" class="trans" <%= ofc_type.equals("AR") ? "checked" : "disabled" %>  ><label for="ofc_type_1">AR</label><!--
						--><input type="radio" name="ofc_type" id="ofc_type_2" value="ALL" class="trans" <%= ofc_type.equals("ALL") ? "checked" : "disabled" %>  ><label for="ofc_type_2">All</label><!--
						--><input type="text" style="width:70px;text-align:left;" class="input2" name="ofc_cd" id="ofc_cd" dataformat="engup" value="<%=ofc_code%>" readonly></td>
						<th>In/Active On</th>
						<td>
							<input type="radio" name="inactive_type" id="inactive_type"  value="1" class="trans"  <%= inactive_type.equals("") || inactive_type.equals("1") ? "checked" : "disabled" %> ><label for="inactive_type">Active</label><!--
						--><input type="radio" name="inactive_type" id="inactive_type_1" value="2" class="trans"  <%= inactive_type.equals("2") ? "checked" : "disabled" %> ><label for="inactive_type_1">Inactive</label><!--
						--><input type="radio" name="inactive_type" id="inactive_type_2" value="3" class="trans"  <%= inactive_type.equals("3") ? "checked" : "disabled" %> ><label for="inactive_type_2">All</label></td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>