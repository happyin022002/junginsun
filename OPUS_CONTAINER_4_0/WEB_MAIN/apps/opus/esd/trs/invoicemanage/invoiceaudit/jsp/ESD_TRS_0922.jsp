<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TRS_0922.jsp
*@FileTitle  : The Transportation Service Order Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
--%>
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
	EsdTrs0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error occurred on the server
	DBRowSet rowSet	  = null;							   //DB ResultSet
	String strErrMsg = "";								 //Error message
	int rowCount	 = 0;								  //List the number of DB ResultSet

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
	String wo_vndr_nm = JSPUtil.getNull(request.getParameter("wo_vndr_nm"));
	String payment_vndr_cd = JSPUtil.getNull(request.getParameter("payment_vndr_cd"));
	String payment_vndr_nm = JSPUtil.getNull(request.getParameter("payment_vndr_nm"));
	String invoice_no = JSPUtil.getNull(request.getParameter("invoice_no"));
	String apply_currency = JSPUtil.getNull(request.getParameter("apply_currency"));
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
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="apply_currency" value="<%=apply_currency%>" id="apply_currency" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Invoice File Import</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_apply" 	id="btn_apply">Apply</button><!--
			--><button type="button" class="btn_normal" name="btn_fileselect" 		id="btn_fileselect">File Select</button><!--
			--><button type="button" class="btn_normal" name="btn_verify" 		id="btn_verify">Verify</button><!--
			--><button type="button" class="btn_normal" name="btng_downexcel" 		id="btng_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_close"  		id="btn_close">Close</button>	
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class= "opus_design_inquiry wFit">
			<table>
					<colgroup>
						<col width="80"/>
						<col width="300"/>
						<col width="80"/>
						<col width="*"/>
				    </colgroup>
				    <tbody>
					<tr>
						<th>W/O Vendor</th>
						<td colspan="3"><input type="text" name="wo_vndr_cd" value="<%=wo_vndr_cd%>" readonly style="width:70px;" id="wo_vndr_cd" /><!-- 
						 --><input type="text" name="wo_vndr_nm" value="<%=wo_vndr_nm%>" readonly style="width:200px;" id="wo_vndr_nm" />
					</tr>
					<tr>
						<th>Payment Vendor</th>
						<td><input type="text" name="payment_vndr_cd" value="<%=payment_vndr_cd%>" readonly style="width:70px;" id="payment_vndr_cd" /><!-- 
						 --><input type="text" name="payment_vndr_nm" value="<%=payment_vndr_nm%>" readonly style="width:200px;" id="payment_vndr_nm" />
						<th>Invoice No.</th>
						<td><input type="text" name="invoice_no" value="<%=invoice_no%>" readonly style="width:100%;" id="invoice_no" /> </td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td></td></tr></table></div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>