<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0979.jsp
*@FileTitle  : PSA Container Booking I/F - Exception Message
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String bkgNo  = request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	String bkgSeq = request.getParameter("bkg_seq")==null?"":request.getParameter("bkg_seq");
%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title">
		<span>PSA Container Booking – Exception Message</span>
	</h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />
				<col width="130" />
				<col width="70" />
				<col width="*" />
		   </colgroup>
		   <tbody>
				<tr>
					<th>Booking No.</th>
					<td><input type="input" style="width:100px; text-align:center" name="bkg_no" value="<%=bkgNo%>" class="input" readonly id="bkg_no" /> </td>
					<th>Sequence</th>
					<td><input type="input" style="width:50px; text-align:center" value="<%=bkgSeq%>" name="bkg_seq" class="input" readonly id="bkg_seq" /> </td>
				</tr>
				<tr>
					<td colspan="4"><textarea style="width:100%;height:100px;resize:none" name="status_log" id="status_log" readonly></textarea></td>
				</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
	<div class="opus_design_grid" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
	<!-- wrap_result(E) -->
</form>
