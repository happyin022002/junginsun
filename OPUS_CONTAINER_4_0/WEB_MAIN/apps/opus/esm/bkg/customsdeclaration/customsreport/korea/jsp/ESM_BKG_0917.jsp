<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0917.jsp
*@FileTitle  : Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/09
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="msg_log_tp_id" value="" id="msg_log_tp_id" />
<input type="hidden" name="tp_cd" value="" id="tp_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
	 --></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40">
				<col width="70">
				<col width="40">
				<col width="100">
				<col width="60">
				<col width="120">
				<col width="70">
				<col width="170">
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>MSG</th>
					<td><script type="text/javascript">ComComboObject('cboMsgTp', 3, 50, 1, 1);</script></td>
					<td><input type="radio" value="vvd" name="search_type" class="trans" onclick="funcChangSearchOption(document.form, 'vvd');" id="search_type" /><label for ="search_type"><strong>VVD</strong></label> </td>
					<td><input type="text" style="width:80px; text-align:center;" class="input2" name="vvd" maxlength="9" dataformat="eng" id="vvd" /> </td>
					<td><input type="radio" value="bl_no" name="search_type" class="trans" onclick="funcChangSearchOption(document.form, 'bl_no');" id="search_type1" /><label for ="search_type1"><strong>B/L No</strong></label></td>
					<td><input type="text" style="width:100px; text-align:center;" class="input2" name="bl_no" maxlength="12" dataformat="eng" id="bl_no" /> </td>
					<td><input type="radio" value="smt_no" name="search_type" class="trans" onclick="funcChangSearchOption(document.form, 'smt_no');" id="search_type2" /><label for ="search_type2"><strong>SUB. No</strong></label> </td>
					<td><input type="text" style="width:145px; text-align:center;" class="input2" name="smt_no" maxlength="19" dataformat="eng" id="smt_no" /> </td>
					<td><input type="radio" value="recv_dt" name="search_type" class="trans" checked="" onclick="funcChangSearchOption(document.form, 'date');" id="search_type3" /><label for ="search_type3"><strong>Receive Date</strong></label> </td>
					<td><input type="text" style="width:80px; text-align:center;" class="input1" name="from_dt" maxlength="10" dataformat="ymd" id="from_dt" />~ <input type="text" style="width:80px; text-align:center;" class="input1" name="to_dt" maxlength="10" dataformat="ymd" id="to_dt" /><button type="button" id="btn_calendar1" name="btn_calendar1" class="calendar ir"></button></td>
				</tr>
			</tbody>
			</table>
			<table>
			<colgroup>
				<col width="40">
				<col width="82">
				<col width="42">
				<col width="114">
				<col width="56">
				<col width="135">
				<col width="63">
				<col width="144">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Type</th>
					<td><script type="text/javascript">ComComboObject('cboTp', 3, 50, 1);</script></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:80px; text-align:center;" class="input" name="pol_cd" maxlength="5" dataformat="eng" id="pol_cd" /> </td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:100px; text-align:center;" class="input" name="pod_cd" maxlength="5" dataformat="eng" id="pod_cd" /> </td>
					<th>Office</th>
					<td><input type="text" style="width:100px; text-align:center;" class="input" name="ofc_cd" maxlength="5" dataformat="eng" id="ofc_cd" /> </td>
					<th>User ID</th>
					<td><input type="text" style="width:100px; text-align:center;" class="input" name="user_id" maxlength="10" dataformat="eng" id="user_id" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>