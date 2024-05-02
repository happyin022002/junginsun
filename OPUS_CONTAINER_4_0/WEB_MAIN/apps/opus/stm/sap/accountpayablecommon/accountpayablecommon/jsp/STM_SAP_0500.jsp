<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : stm_sap_0500.jsp
*@FileTitle  : Finance Office Code Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0500Event"%>

<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>


<%
    StmSap0500Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";					//에러메세지

	String ofc_type    = "";					//PARAMETER
	String ofc_code    = "";                      

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountpayablecommonSC"); // 에러메세지 위치

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (StmSap0500Event)request.getAttribute("Event");  // 전성운 수정
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		ofc_type = StringUtil.xssFilter(request.getParameter("ofc_type"))!= null ? StringUtil.xssFilter(request.getParameter("ofc_type")) : "";  //PARAMETER
		ofc_code = StringUtil.xssFilter(request.getParameter("ofc_code"))!= null ? StringUtil.xssFilter(request.getParameter("ofc_code")) : "";  //PARAMETER

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
		} // end if
		loadPage(); // .js 호출
	}
</script>
</head>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Finance Office Code</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
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
					<col width="120" />				
					<col width="100" />				
					<col width="120" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>Finance Office Type</th>
	                   	<td><input type="text" name="ofc_type" style="width:80px;" class="input" value="<%=ofc_type%>" maxlength="3" dataformat="enguponly" id="ofc_type" /></td>
						<th>Finance Office Code</th>
	                   	<td><input type="text" name="ofc_code" style="width:100px;" class="input" value="<%=ofc_code%>" maxlength="6" dataformat="enguponly" id="ofc_code" /></td>
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