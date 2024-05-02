<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TES_0080.js
*@FileTitle  : Terminal invoice CSR Creation -Preview
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0080Event"%>


<%
	EsdTes0080Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet Count
	String cnt_cd  = "";
	String previewFlg  = "";
	String previewFlgYN  = "";	

	previewFlg 			 	= JSPUtil.getParameter(request, "previewFlg 			      ".trim(), "");
	previewFlgYN 		 	= JSPUtil.getParameter(request, "previewFlgYN 			      ".trim(), "");

	try {

	   SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   //userId=account.getUsr_id();
	   //userAuth=account.getAuth(); 
	   cnt_cd =account.getCnt_cd();

		//event = (EsdTes0080Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
/*			eventResponse = (EsdTes0080EventResponse)request.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if(rowSet != null){
					 rowCount = rowSet.getRowCount();
				} // end if
			} // end if
*/		} // end else
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();		
	}
	var cnt_cd = "<%=cnt_cd%>";
	var previewFlg  = "<%=previewFlg%>";
	var previewFlgYN  = "<%=previewFlgYN%>";
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd"> 
<input type="hidden" name="iPage" id="iPage">
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Terminal Invoice CSR Preview</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		
		<div class="opus_design_btn">
		          <button class="btn_accent" type="button"  name="btn_close" id="btn_close">Close</button><!-- 
		       --><span id='btng_approvalrequest_yn' style="display:none"><!--
				   --><button class="btn_normal" type="button"  name="btng_print" id="btng_print">Print</button><!-- 
				   --><button class="btn_normal" type="button"  name="btng_approvalrequest" id="btng_approvalrequest">Approval Request</button><!-- 
				--></span><!-- 
		   	    --><span id='btng_approvalrequest_yn' style="display:none"><!--
					--><button class="btn_normal" type="button"  name="btng_print" id="btng_print">Print</button>
				  </span>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden">
	<div class="wrap_result">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
</div>
<div class="header_fixed"></div>
</form>