<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0036.jsp
*@FileTitle  : Transportation Invoice CSR Creation - Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/15
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0036Event"%>
<%
	EsdTrs0036Event  event 		= null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;		
	String strErrMsg 			= "";		

	try {
		event = (EsdTrs0036Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script  type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script  type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input	type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="iPage" id="iPage">

<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Transportation Invoice CSR Preview</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_normal" 	name="btng_print" 				id="btng_print">Print</button>
			 <!-- 2014.12.23    Hyungwook Choi - Requested by Chang-Hyun Jun -->
			 <!-- 
			 <button type="button" class="btn_normal" 	name="btng_approvalrequest" 	id="btng_approvalrequest">Approval Request</button>
			 --><!--	
			 --><button type="button" class="btn_normal" 	name="btn_close" 				id="btn_close">Close</button> 
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">	
	<div class="wrap_result" style="height: 100%">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
</form>