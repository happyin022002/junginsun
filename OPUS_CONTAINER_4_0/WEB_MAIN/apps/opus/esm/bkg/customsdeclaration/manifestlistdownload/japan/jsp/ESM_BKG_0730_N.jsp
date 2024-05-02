<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0730.jsp
*@FileTitle  : ESM_BKG_0730
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0730Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0730Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;  //error from server

	String strErrMsg = ""; //error message
	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0730Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<input type="hidden" name="in_msg_flag" id="in_msg_flag" />
<input type="hidden" name="in_mfr_gubun" id="in_mfr_gubun" value="Y" />
<input type="hidden" name="in_download_yn" id="in_download_yn" />
<input type="hidden" name="KEY" id="KEY" />
<!-- //↓↓↓↓↓↓↓↓↓↓/////////////////////////// -->
<input type="hidden" name="pgm_div" id="pgm_div" value="NEW" />
<!-- //↑↑↑↑↑↑↑↑↑↑/////////////////////////// -->


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_customer" id="btn_customer">Customer</button><!--
		 --><button type="button" class="btn_normal" name="btn_cntr" id="btn_cntr">CNTR</button><!--
		 --><button type="button" class="btn_normal" name="btn_marks" id="btn_marks">Marks & Desc</button><!--
		 --><button type="button" class="btn_normal" name="btn_approval" id="btn_approval">Approval No.</button><!--
		 --><button type="button" class="btn_normal" name="btn_trans" id="btn_trans">Trans to SEA-NACCS</button><!--
	 --></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<table style="width:900px">
			<colgroup>
				<col width="30">
				<col>
				<col>
				<col>
				<col>
				<col>
				<col>
				<col width="45">
				<col>
				<col>
				<col>
				<col>
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:104px;" class="input1" name="in_vvd_cd" maxlength="9" dataformat="engup" id="in_vvd_cd" /></td>
					<th>Cons Voy.</th>
					<td><input type="text" style="width:80px;" class="input" name="in_voyage_no" maxlength="10" dataformat="engup" id="in_voyage_no" /></td>
					<th>Call Sign</th>
					<td><input type="text" style="width:90px;" class="input" name="in_call_sgn_no" maxlength="15" dataformat="engup" id="in_call_sgn_no" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" class="input1" style="width: 50px; margin-right:0px;" name="in_pod_cd" maxlength="5" dataformat="engup" id="in_pod_cd" /></td>
					<td><input type="text" style="width: 30px;" class="input1" name="in_pod_split_cd" maxlength="2" dataformat="engup" id="in_pod_split_cd" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width: 50px;" class="input" name="in_pol_cd" maxlength="5" dataformat="engup" id="in_pol_cd" /></td>
					<th>MSG Type</th>
					<td><select style="width:55;" name="in_msg_tp" id="in_msg_tp">
							<option value="" selected></option>
							<option value="MFR">MFR</option>
							<option value="CMF03">CMF03</option>
						</select></td>
				</tr>
				<tr>
					<th>ETA</th>
					<td><input type="text" style="width:75px;" class="input" name="in_vps_eta_dt" dataformat="ymd" maxlength="10" id="in_vps_eta_dt" caption="ETD" /><!--
						--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					<th>B/L Type</th>
					<td width="100">
						<select style="width:60px;" name="in_bl_type" id="in_bl_type">
							<option value="0" selected>ALL</option>
							<option value="1">Local</option>
							<option value="2">T/S</option>
						</select></td>
					<td colspan="2" align="center"><input type="radio" value="A" class="trans" name="in_err_gb" id="in_err_gb" checked /><label for = "in_err_gb">All</label><input type="radio" value="E" class="trans" name="in_err_gb" id="in_err_gb1" /><label for = "in_err_gb1">Error</label></td>
					<th colspan="2">CY Operator CD</th>
					<td><input type="text" style="width: 60px;" class="input" name="in_cy_opr_cd" maxlength="5" dataformat="engup" id="in_cy_opr_cd" /></td>
					<th>DEL</th>
					<td><input type="text" style="width: 50px;" class="input" name="in_del_cd" maxlength="5" dataformat="engup" id="in_del_cd" /></td>
					<th></th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">B/L Add</button><!--
		 --><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</form>