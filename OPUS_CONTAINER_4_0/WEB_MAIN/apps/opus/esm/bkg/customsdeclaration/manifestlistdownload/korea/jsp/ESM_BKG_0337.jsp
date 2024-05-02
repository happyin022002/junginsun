<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0337
*@FileTitle  : MSN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="in_vsl_cd">
<input type="hidden" name="in_skd_voyage_no">
<input type="hidden" name="in_skd_dir_cd">
<input type="hidden" name="in_mrn_mode" value="I">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
	--><button type="button" id="btn_ManifestGeneration" name="btn_ManifestGeneration" class="btn_normal">Edit MSN/Customs Inform</button><!--
	--></div>
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="75"/>
				<col width="220"/>
				<col width="75"/>
				<col width="220"/>
				<col width="20"/>
				<col width="160"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th>MRN</th>
				<td><input type="text" style="width:90px; text-align:center;" class="input"  name="in_mrn_no" id="in_mrn_no" maxlength="10" style="ime-mode:disabled" dataformat="engup"><input type="text" style="width:20px; text-align:center;" class="input2"  name="in_mrn_chk_no" id="in_mrn_chk_no" maxlength="1" style="ime-mode:disabled" dataformat="num"><button class="input_seach_btn" name="btn_Inquiry" id="btn_Inquiry" type="button"  onclick="return false"></button></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:100px;" class="input1" name='in_vvd' maxlength="9" style="ime-mode:disabled; text-align:center;" dataformat="engup"></td>
				<th>Port</th>
				<td><input type="text" style="width:60px;" class="input1" name="in_port" maxlength="5" style="ime-mode:disabled; text-align:center;" dataformat="engup"></td>
				<td><b>Mode : Inbound</b></td>
			</tr>
			<tr>
				<th>Send Date</th>
				<td><input id="snd_dt" name="snd_dt" style="width:130px; text-align:center;" class="input2" readonly type="text" /></td>
				<th>Result Date</th>
				<td><input id="rslt_dt" name="rslt_dt" style="width:130px; text-align:center;" class="input2" readonly type="text" /></td>
				<th>Result</th>
				<td><input id="rslt" name="rslt" style="width:105px; text-align:center;" class="input2" readonly type="text" /></td>
				<td><b>Error MSG</b> <input id="err_msg" name="err_msg" style="width:105px;" class="input2" readonly type="text" /></td>
			</tr>
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

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display: inline;">

		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">

				<!-- layout_flex_fixed(S) -->
				<div class="layout_flex_fixed" style="width:750px">
					<!-- opus_design_grid(S) -->
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t1sheet1');</script>
					</div>
					<!-- opus_design_grid(E) -->
				</div>
				<!-- layout_flex_fixed(E) -->

				<!-- layout_flex_flex(S) -->
				<div class="layout_flex_flex" style="padding-left:758px">
					<h3 class="title_design">Record by B/L Type</h3>
					<div style="clear:both"></div>
					<!-- opus_design_inquiry(S) -->
					<div class="opus_design_inquiry">
						<table class="grid2" style="width: 200px">
							<colgroup>
								<col width="100"/>
								<col width="*" />
							</colgroup>
							<tr>
								<th>Simple</th>
								<td align="center"><span id="t1simple">0</span></td></tr>
							<tr>
								<th>Console</th>
								<td align="center"><span id="t1console">0</span></td></tr>
							<tr>
								<th>Empty</th>
								<td align="center"><span id="t1empty">0</span></td>
							</tr>
						</table>
					</div>
					<!-- opus_design_inquiry(S) -->
				</div>
				<!-- layout_flex_flex(E) -->

			</div>
			<!-- layout_wrap(E) -->
		</div>
		<!-- opus_design_inquiry(E) -->

	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="tabLayer" id="tabLayer" style="display: none;">

	<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<!-- layout_wrap(S) -->
			<div class="layout_wrap">

				<!-- layout_flex_fixed(S) -->
				<div class="layout_flex_fixed" style="width:750px">
					<!-- opus_design_grid(S) -->
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('t2sheet1');</script>
					</div>
					<!-- opus_design_grid(E) -->
				</div>
				<!-- layout_flex_fixed(E) -->

				<!-- layout_flex_flex(S) -->
				<div class="layout_flex_flex" style="padding-left:758px">
					<h3 class="title_design">Record by B/L Type</h3>
					<div style="clear:both"></div>
					<!-- opus_design_inquiry(S) -->
					<div class="opus_design_inquiry">
						<table class="grid2" style="width: 200px">
							<colgroup>
								<col width="100"/>
								<col width="*" />
							</colgroup>
							<tr>
								<th>Simple</th>
								<td align="center"><span id="t2simple">0</span></td>
							</tr>
							<tr>
								<th>Console</th>
								<td align="center"><span id="t2console">0</span></td>
							</tr>
							<tr>
								<th>Empty</th>
								<td align="center"><span id="t2empty">0</span></td>
							</tr>
						</table>
					</div>
					<!-- opus_design_inquiry(S) -->
					<!-- opus_design_grid(S) -->
					<div class="opus_design_grid">
						<script type="text/javascript">ComSheetObject('sheet3');</script>
					</div>
					<!-- opus_design_grid(E) -->

				</div>
				<!-- layout_flex_flex(E) -->

			</div>
			<!-- layout_wrap(E) -->
		</div>
		<!-- opus_design_inquiry(E) -->

	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
