<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0211.jsp
*@FileTitle  : Payment Batch Name Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0211Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0211Event event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayablecommon.AccountPayableCommonSC");
	
	String pay_from_date = StringUtil.xssFilter(request.getParameter("pay_from_date")) != null ? StringUtil.xssFilter(request.getParameter("pay_from_date")) : "";
	String pay_to_date = StringUtil.xssFilter(request.getParameter("pay_to_date")) != null ? StringUtil.xssFilter(request.getParameter("pay_to_date")) : "";
	String pay_bat_nm = StringUtil.xssFilter(request.getParameter("pay_bat_nm")) != null ? StringUtil.xssFilter(request.getParameter("pay_bat_nm")) : "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (StmSap0211Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
		loadPage();
	}
	
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="pay_from_date" id="pay_from_date" value="<%=pay_from_date%>">
<input type="hidden" name="pay_to_date" id="pay_to_date" value="<%=pay_to_date%>">

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Payment Batch Name</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<tbody>
					<colgroup>
						<col width="70">
						<col width="*">
					</colgroup>
					<tr>
	                  	<th>Batch Name</th>
	                    <td><input type="text" name="pay_bat_nm" id="pay_bat_nm" style="width:200px;" class="input" dataformat="engup" value="<%=pay_bat_nm%>"></td>
	                </tr>
				</tbody>
			</table>
		</div>
	</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
    <div class="wrap_result" style="overflow:hidden; padding-bottom:30px !important;">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
    </div>		
		<!-- opus_design_grid(E) -->

</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>