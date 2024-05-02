<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  .jsp
*@FileTitle  : Pakistan Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.pakistan.event.EsmBkg1148Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1148Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();

		event = (EsmBkg1148Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			//showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pageno" value="ESM_BKG_1148" id="pageno" />
<input type="hidden" name="pol_cd" id="pol_cd" />
<input type="hidden" name="pod_cd" id="pod_cd" />
<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn_down_excel" id="btn_down_excel" >Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->

		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

	<!-- wrap_search(S) -->
	<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80">
					<col width="200">
					<col width="70">
					<col width="70">
					<col width="60">
					<col width="100">
					<col width="*">
			   </colgroup>
			   <tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input name="vvd_cd" type="text" style="text-align:center" value="" class="input1" dataformat="engup" maxlength="9" id="vvd_cd" /></td>
						<td class="sm pad_left_4"><input name="port_flg" type="radio" class="trans" value="pol" checked="" id="port_flg1" /><label for="port_flg1">POL</label></td>
						<td class="sm"><input name="port_flg" type="radio" class="trans" value="pod" id="port_flg2" /><label for="port_flg2">POD</label></td>
						<td class="sm"><input name="pol_pod_cd" type="text" style="width:50px;" value="PKKHI" class="input1" dataformat="engup" maxlength="5" id="pol_pod_cd" /></td>
						<th>Total B/L</th>
						<td><input name="total_bl" type="text" style="width:35px;" value="" class="input2" readonly id="total_bl" /></td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="80">
					<col width="200">
					<col width="70">
					<col width="180">
					<col width="50">
					<col width="100">
					<col width="50">
					<col width="*">
			   </colgroup>
			   <tbody>
					<tr>
						<th>Vessel Name</th>
						<td><input name="vsl_eng_nm" type="text" style="width:170px;" value="" class="input2" readonly id="vsl_eng_nm" /></td>
						<th>Call Sign</th>
						<td><input name="call_sgn_no" type="text" style="width:70px;" value="" class="input2" readonly id="call_sgn_no" /></td>
						<th>ETD</th>
						<td><input name="etd_dt" type="text" style="width:90px;" value="" class="input2" readonly id="etd_dt" /></td>
						<th>ETA</th>
						<td><input name="eta_dt" type="text" style="width:90px;" value="" class="input2" readonly id="eta_dt" /></td>
					</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript"> ComTabObject ('tab1')</script>
		</div>
		<!-- opus_tab_btn(E) -->
		<div id="tabLayer" style="display:Inline;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- opus_tab_btn(E) -->
		<div id="tabLayer" style="display:none;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
		<!-- opus_tab_btn(E) -->
		<div id="tabLayer" style="display:none;">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<script type="text/javascript">ComSheetObject('sheet3');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
	<!-- wrap_result(E) -->
</form>