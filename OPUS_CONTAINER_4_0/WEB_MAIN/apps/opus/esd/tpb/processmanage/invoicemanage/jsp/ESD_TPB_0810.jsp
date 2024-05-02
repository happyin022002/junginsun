<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0810.jsp
*@FileTitle  : Invoice Cancel Remark 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0810Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0810Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ProcessManage.InvoiceManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0810Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	}
</script>

<!-- 개발자 작업	-->
<form method="post" name="form">
<input	type="hidden" name="f_cmd"> 
<input type="hidden" name="iPage"> 
<input type="hidden" name="pagerows">

<input type="hidden" name="s_file_no">

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="layer_popup_title">
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>&nbsp; Invoice Cancel Remark</span>
        </h2>
        <!-- page_title(E) -->
        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn"><!--
        --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
        --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) -->
    </div>
</div>
<!-- page_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" >
    <!-- inquiry_area(S) -->
    <div class="wrap_search">       
        <div class="opus_design_inquiry wFit">
        <table><tr><td>* Reason for Invoice Cancel</td></tr>
			<tr><td><textarea type="text" style="width:98%" rows="5" name="s_invoice_cancel_remark" onblur="tpb_chkLenByByte(this,1000,'Reason')"></textarea></td></tr></table>
        </div>
    </div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- popup_contens_area(E) -->
<!-- page(E) -->

<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->
</form>