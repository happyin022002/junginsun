<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0389.jsp
*@FileTitle  : OPUS vs Portnet Reconciliation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/05
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>

<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="vvd" 		id="vvd">
<input type="hidden" name="file_key" 	id="file_key">
<input type="hidden" name="subSysCd" 	id="subSysCd" value="BKG">
<input type="hidden" name="etd_dt" 		id="etd_dt">
<input type="hidden" name="eta_dt" 		id="eta_dt">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_PSAIF" 		id="btn_PSAIF">PSA I/F</button><!--
<button type="button" class="btn_normal" name="btn_JurongIF" 	id="btn_JurongIF">Jurong I/F</button>
	<button type="button" class="btn_normal" name="btn_Print" 		id="btn_Print">Print</button>
	-->
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class='wrap_search_tab'>
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="85px">
				<col width="100px">
				<col width="50px">
				<col width="130px">
				<col width="50px">
				<col width="100px">
				<col width="80px">
				<col width="*">
			</colgroup>
			<tr>
				<th>Relay Port CD</th>
				<td>
					<input type="text" name="rly_port" id="rly_port" style="width:60px; text-align:center;" maxlength="5" class="input1" dataformat="engup" onChange="portChange();" value="SGSIN">
				</td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<script type="text/javascript">ComComboObject('cboVVD', 1, 100, 0, 1, 0, true);</script>
				</td>
				<th><span id="spanEtdEta">ETD</span></th>
				<td>
					<input type="text" name="eta_etd" id="eta_etd" 	style="width:80px; text-align:center;" maxlength="10" class="input" dataformat="ymd" onChange="etdChange();"><!--
					--><button type="button" class="calendar ir" name="btn_cal1" id="btn_cal1"></button>
				</td>
				<th>Trans</th>
				<td>
					<%=JSPUtil.getCodeCombo("trans_tp_cd", "", "width:85px; onChange='trans_tp_change();'", "CD02257", 0, "")%>
				</td>
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

<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t1sheet1');</script>
</div>

<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>

<div class="opus_design_grid clear" style="width:98%" name="tabLayer" id="tabLayer">
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
<script type="text/javascript">ComSheetObject('t1sheet2');</script>
<!-- opus_design_grid(E) -->
</div>

</form>