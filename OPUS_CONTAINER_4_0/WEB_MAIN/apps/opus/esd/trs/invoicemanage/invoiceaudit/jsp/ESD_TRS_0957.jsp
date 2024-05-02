<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0014.jsp
*@FileTitle : Service Order Creation - Chassis or Genset
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event"%>

<%
	EsdTrs0033Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;								  
	SignOnUserAccount account= null;
	try {
		account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0033Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	String wo_vndr_cd = JSPUtil.getNull(request.getParameter("wo_vndr_cd"));
	String payment_vndr_cd = JSPUtil.getNull(request.getParameter("payment_vndr_cd"));
	String invoice_no = JSPUtil.getNull(request.getParameter("invoice_no"));
	String apply_currency = JSPUtil.getNull(request.getParameter("apply_currency"));
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="apply_currency" value="<%=apply_currency%>">
<input type="hidden" name='wo_vndr_cd' value='<%=wo_vndr_cd%>'>
<input type="hidden" name='payment_vndr_cd' value='<%=payment_vndr_cd%>'>
<input type="hidden" name='invoice_no' value='<%=invoice_no%>'>
<input	type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>">
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Container File Import</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btng_apply" id="btng_apply">Apply</button><!--
		 --><button type="button" class="btn_normal" name="btng_fileimport" id="btng_fileimport">File Import</button><!--
		 --><button type="button" class="btn_normal" name="btng_delete" id="btng_delete">Delete</button><!--
		 --><button type="button" class="btn_normal" name="btng_verify" id="btng_verify">Verify</button><!--
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_grid clear" id="mainTable">					
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_grid_btn(E) -->
	</div>
</div>

</form>

