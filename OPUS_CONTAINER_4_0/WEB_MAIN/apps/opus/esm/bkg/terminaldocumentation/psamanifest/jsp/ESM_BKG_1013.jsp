<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1013.jsp
*@FileTitle  : PSA Vessel Registeration : Import Schedule
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>PSA Vessel Register : Import Schedule </span></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">OK</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table class="grid_2">
			<colgroup>
				<col width="60" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th style = "text-align: center;"><b>Port</b></th>
					<td><input type="text" class="input1" name="port_cd" maxlength="5" style="width:80px; text-align:center" dataformat="engup"></td>
				</tr>
				<tr>
					<th style = "text-align: center;"><b>ETB</b></th>
					<td><input type="text" class="input1" name="etb_dt1" maxlength="10" style="width:80px; text-align:center" dataformat="ymd">~ <!--
					 --><input type="text" class="input1" name="etb_dt2" maxlength="10" style="width:80px; text-align:center" dataformat="ymd"><!--
					 --><button type="button" id="btn_calendar1" name="btn_calendar1" class="calendar ir"></button>
					</td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>

