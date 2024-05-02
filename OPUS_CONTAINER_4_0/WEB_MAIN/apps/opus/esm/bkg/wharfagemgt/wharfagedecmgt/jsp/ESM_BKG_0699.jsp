<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_SPC_0699.jsp
*@FileTitle  : Korea WHF Exemption
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0699Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0699Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0699Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" method="post">

<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="frm_attr_ctnt2" name="frm_attr_ctnt2">

<!-- 개발자 작업	-->
<%
	String bkgNo     = (request.getParameter("bkg_no") == null)? "":request.getParameter("bkg_no");
%>
<!-- OUTER - POPUP (S)tart -->
<input type="hidden" id="bkg_no" name="bkg_no" value="<%=bkgNo %>">

<!-- page_title_area(S) -->
<div class="layer_popup_title">
		<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<span>Wharfage Cargo Classification </span>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!--
			--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
	
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry" id="mainTable">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Shipper</th>
						<td><input type="text" style="width: 395px;" class="input" name="shipper_name" id="shipper_name" readonly></td>
					</tr>
					<tr>
						<th>Export Reference</th>
						<td><input type="text" style="width: 395px;" class="input" name="export_ref" id="export_ref" readonly></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="120">
					<col width="290">
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Rep. Commodity</th>
						<td><input type="text" style="width: 270px;" class="input" name="cstms_desc" id="cstms_desc" readonly></td>
						<th>Cargo Type</th>
						<td><input type="text" style="width: 35px;" class="input" name="bkg_cgo_tp_cd" id="bkg_cgo_tp_cd" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<div class="layout_wrap">
			<div class="layout_vertical_2 pad_rgt_8">
				<h3 class="title_design">Exempt Condition</h3>
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet1');</script>
				</div>
			</div>
			<div class="layout_vertical_2 pad_left_8">
				<h3 class="title_design">T/S 대상 Container</h3>
				<div class="opus_design_grid" id="mainTable">
					<script type="text/javascript">ComSheetObject('sheet2');</script>
				</div>
			</div>
		</div> 
	</div>
</div>
</form>