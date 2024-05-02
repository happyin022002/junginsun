<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0502.jsp
*@FileTitle  :
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/25
=========================================================*/
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
	function setupPage()
	{
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="p_search_option" id="p_search_option" />
<input type="hidden" name="in_snd_op" id="in_snd_op" />
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="in_msg_type" id="in_msg_type" />
<input type="hidden" name="in_ks_type" id="in_ks_type" />

<!-- Developer Work	-->

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
			 --><button type="button" class="btn_normal" name="btn_view" id="btn_view">View Send File</button><!--
		 --></div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
<div class= "wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
		<!--  MiniLayer (S) -->
		<table>
			<tbody>
				<colgroup>
				<col width="40" />
				<col width="70" />
				<col width="60" />
				<col width="90" />
				<col width="80" />
				<col width="110" />
				<col width="80" />
				<col width="180" />
				<col width="120" />
				<col width="150" />
				<col width=* />
				</colgroup>
				<tr>
					<th>MSG</th>
					<td><script type="text/javascript">ComComboObject('combo1', 3, 50, 1, 1);</script></td>
					<th class="sm"><input type="radio" class="trans" name="rad_vvd_op">&nbsp;VVD</th>
					<td><input type="text" class="input" style="width:80px;" name="in_vsl_cd" dataformat="engup" maxlength="9" id="in_vsl_cd" /> </td>
					<th class="sm"><input type="radio" class="trans" name="rad_bl_op">&nbsp;B/L No.</th>
					<td><input type="text" class="input" style="width:100px;" name="in_bl_no" dataformat="engup" maxlength="12" id="in_bl_no" /> </td>
					<th class="sm"><input type="radio" class="trans" name="rad_sub_op">&nbsp;Sub No.</th>
					<td><input type="text" class="input" style="width:140px;" name="in_sub_cd" dataformat="engup" maxlength="19" id="in_sub_cd" /> </td>
					<th class="sm"><input type="radio" class="trans" name="rad_date_op">
						<select class="input" style="width:110;" name="in_date_op">
							<option value="SEND_DATE" selected>Send Date</option>
							<option value="ETA">ETA</option>
							<option value="ETD">ETD</option>
						</select></th>
					<td><input type="text" class="input" style="width:75px;" name="in_snd_dt_s" dataformat="ymd" maxlength="10" id="in_snd_dt_s" /> ~<input type="text" class="input" style="width:75px;" name="in_snd_dt_e" dataformat="ymd" maxlength="10" id="in_snd_dt_e" /> <button type="button" class="calendar ir" name="btn_calendar1" id="btn_calendar1"></button></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
				<col width="40" />
				<col width="72" />
				<col width="58" />
				<col width="90" />
				<col width="80" />
				<col width="110" />
				<col width="80" />
				<col width="148" />
				<col width="55" />
				<col width="110" />
				<col width="180" />
				<col width="*" />
				</colgroup>
					<tr>
						<th>Type</th>
						<td><script type="text/javascript">ComComboObject('combo2', 3, 60, 1, 1);</script></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" class="input" style="width:60px;" name="in_pol_cd" dataformat="engup" maxlength="5" id="in_pol_cd" /> </td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" class="input" style="width:60px;" name="in_pod_cd" dataformat="engup" maxlength="5" id="in_pod_cd" /> </td>
						<th>Office</th>
						<td><input type="text" class="input" style="width:60px;" name="in_ofc_cd" dataformat="enguponly" maxlength="10" id="in_ofc_cd" /> </td>
						<th>User ID</th>
						<td><input type="text" class="input" style="width:95px;" name="in_usr_id" dataformat="engup" maxlength="20" id="in_usr_id" /> </td>
						<th class="sm"><input type="radio" class="trans" name="view_send_unsend" checked>&nbsp;All&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="view_send_unsend">&nbsp;Send&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="view_send_unsend">&nbsp;Un-send</th>
						<td></td>

					</tr>
				</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>