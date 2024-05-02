<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0972.jsp
*@FileTitle  : Service Mode And Route
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0972Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0972Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	// parent window parameter setting
	String bkgNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0972Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		
		// If you imported data from the server initialization when loading
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

<style type="text/css">
	table tr th, table tr td {
		font-weight: bold !important;
	}
</style>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%= bkgNo%>">
<input type="hidden" name="org_trns_svc_mod_nm">
<input type="hidden" name="dest_trns_svc_mod_nm">
<input type="hidden" name="ca_flg">
<input type="hidden" name="old_blck_stwg_cd">

<!-- OUTER - POPUP (S)tart -->
<div id="msg" style="position:absolute;left:0;top:0;width:0;height:0;"></div>

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Booking Creation Service Mode & Route</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- layout_wrap(S) -->
		<div class="layout_wrap">
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2" style="width:50%;padding-right:10px">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_data">
					<table class="grid_2 ">
						<colgroup>
							<col width="50">
							<col width="65">
							<col width="110">
							<col width="65">
						</colgroup>
						<tr>
							<th colspan="4">Service Route</th>
						</tr>
						<tr>
							<th>Origin</th>
							<td><input type="text" style="width:100%" class="noinput" name="orgScontiCd" readonly id="orgScontiCd" /> </td>
							<th>Destination</th>
							<td><input type="text" style="width:100%" class="noinput" name="destScontiCd" readonly id="destScontiCd" /> </td>
						</tr>
					</table>
				</div>
			</div>
		     <!-- layout_vertical_2(E) -->
			<!-- layout_vertical_2(S) -->
			<div class="layout_vertical_2"style="width:50%">
				<!-- opus_design_inquiry(S) -->
				<div class="opus_design_data">
					<table class="grid_2 ">
						<colgroup>
							<col width="60">
							<col width="65">
							<col width="80">
							<col width="65">
							<col width="110">
							<col width="65">
						</colgroup>
						<tr>
							<th colspan="6">Service Mode</th>
						</tr>
						<tr>
							<th>Origin</th>
							<td><input type="text" style="width:100%;" class="noinput" name="orgTrnsSvcModCd" onmousemove="msgmove('org')" onmouseover="msgset(document.form.org_trns_svc_mod_nm.value);return true;" onmouseout="msghide();return true;" readonly id="orgTrnsSvcModCd" /> </td>
							<th>Destination	</th>
							<td><input type="text" style="width:100%;" class="noinput" name="destTrnsSvcModCd" onmousemove="msgmove('dest')" onmouseover="msgset(document.form.dest_trns_svc_mod_nm.value);return true;" onmouseout="msghide();return true;" readonly id="destTrnsSvcModCd" /> </td>
							<th>Block Stowage</th>
							<td><input type="text" style="width:100%;" class="input" name="blckStwgCd" id="blckStwgCd" /> </td>
						</tr>
					</table>
				</div>
			</div>
		     <!-- layout_vertical_2(E) -->
		<!-- layout_wrap(E) -->
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

<!-- : ( Button : pop ) (E) -->
</form>
