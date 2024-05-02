<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0925.jsp
*@FileTitle  : Re-Audit
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0925Event"%>
<%
	EsdTrs0925Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	DBRowSet rowSet	  = null;					
	String strErrMsg = "";						
	int rowCount	 = 0;						
	String userId = "";
	SignOnUserAccount account = null;
	try {

	   account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   userId=account.getUsr_id();
		event = (EsdTrs0925Event)request.getAttribute("Event");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}

	String mode = JSPUtil.getNull(request.getParameter("mode"));
	String sel_sheet_idx = JSPUtil.getNull(request.getParameter("sel_sheet_idx"));
%>

<script type="text/javascript">
	<%= JSPUtil.getIBCodeCombo("inv_curr_cd", "", "CD00884", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("cgo_tp_cd"  , "", "CD00748", 0, "")%>
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
<input type="hidden" name="eq_no" id="eq_no" />
<input type="hidden" name="wbl_dt" id="wbl_dt" />
<input type="hidden" name="rail_road_code" id="rail_road_code" />
<input type="hidden" name="mode" value="<%=mode%>" id="mode" />
<input type="hidden" name="sel_sheet_idx" value="<%=sel_sheet_idx%>" id="sel_sheet_idx" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Re - Audit</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

	<div class="wrap_result">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2 pad_rgt_8" style="width: 50%;">
				<div class="opus_design_data">
					<h3 class="title_design mar_btm_8">Re-Audit List</h3>
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
			<div class="layout_vertical_2 pad_left_8" style="width: 50%">
				<div class="opus_design_data">
					<h3 class="title_design mar_btm_8">CLM History</h3>
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
		</div>
	     <!-- layout_vertical_2(E) -->
	</div>
	<!-- layout_wrap(E) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Invoice</h3>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(S) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<h3 class="title_design mar_btm_8">Billing</h3>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>

</form>