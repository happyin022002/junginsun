<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1141.js
*@FileTitle  : Malaysia Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.event.EsmBkg1141Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1141Event event = null;
//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지

	String strUsr_id = "";
	String strUsr_nm = "";
	String search_flg1 = "";
	String search_flg3 = "";

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		String ofcCd = account.getOfc_cd();

		// Log-in ID 소속 Office 가 "MX" 인 경우 Default
		// 하동일 수석 가이드에 따라 조직코드의 앞 3자리가 MEX인 유저에 대해 로직을 적용함.
		if(ofcCd != null){
			if(ofcCd.substring(0, 3).equals("MEX")){
				search_flg1 = "checked";
			}
		}
		//Log-in ID 소속 Office 가 "MX" 가 아닌 경우 Default
		if( search_flg1.equals("")){
			search_flg3 = "checked";
		}

		event = (EsmBkg1141Event) request.getAttribute("Event");
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="pageno" id="pageno" value="ESM_BKG_1141">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_down_excel" id="btn_down_excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">EDI Transmit</button>
		  <script type="text/javascript">ComComboObject('s_status', 1, 80, 1, 0, 0, true);</script>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="67">
				<col width="100">
				<col width="30">
				<col width="100">
				<col width="30">
				<col width="70">
				<col width="30">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th class="sm">Mode</th>
					<td class="sm"><input type="radio" name="s_mode"  id="s_mode0" value="E" class="trans" checked><label for="s_mode0">Outbound</label>&nbsp;&nbsp;&nbsp;<!--
							--><input type="radio" name="s_mode" value="I" class="trans" id="s_mode1"><label for="s_mode1">Inbound</label>
					</td>
					<th>TYPE</th>
				<td style="padding-left:1">
					<select style="width:79px;" class="input" name="ts_tp_cd" id="ts_tp_cd" onChange="tsTpCd_OnChange()">
							<option value="L">Local</option>
							<option value="T">T/S</option>
						</select>
					</td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width: 80px; ime-mode:disabled;" class="input1" maxlength="9" value="" name="s_vvd" id="s_vvd" caption="VVD" dataformat="engup" required></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="s_pol_cd" id="s_pol_cd" caption="POL" maxlength="5" style="width:50px;ime-mode:disabled;" value="" class="input1" dataformat="engup" required></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="s_pod_cd" id="s_pod_cd" caption="POD" maxlength="5" style="width:50px;ime-mode:disabled;" value="" class="input" dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
		<h3 class="title_design mar_top_12">Booking Route</h3>
		<table>
			<colgroup>
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="83">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Place of Receipt">POR</th>
					<td><input type="text" name="s_trunk_por_cd" id="s_trunk_por_cd" maxlength="5" style="width:50px;" class="input" dataformat="engup" value=""></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="s_trunk_pol_cd" id="s_trunk_pol_cd" maxlength="5" style="width:50px;" class="input" dataformat="engup" value=""></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="s_trunk_pod_cd" id="s_trunk_pod_cd" maxlength="5" style="width:50px;" class="input" dataformat="engup" value=""></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="s_trunk_del_cd" id="s_trunk_del_cd" maxlength="5" style="width:50px;" class="input" dataformat="engup" value=""></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->

	<div  id="tabLayer" style="display:inline;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>B/L Total</th>
						<td><input type="text" name="bl_tot_cnt" id="bl_tot_cnt" maxlength="5" style="width:50px;text-align:right" class="input2" dataformat="engup" value="" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div  id="tabLayer" style="display:none;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid clear">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>CNTR Total</th>
						<td><input type="text" name="cntr_tot_cnt" id="cntr_tot_cnt" maxlength="5" style="width:50px;text-align:right" class="input2" dataformat="engup" value="" readonly></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>
