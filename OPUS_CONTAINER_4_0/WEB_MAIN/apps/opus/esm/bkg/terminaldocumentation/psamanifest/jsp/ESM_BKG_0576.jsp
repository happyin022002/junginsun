<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0576.jsp
*@FileTitle  : Container Booking I/F History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>


<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="status" id="status">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->


	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_StatusLog" 	id="btn_StatusLog">Status Log</button>
	</div>
	<!-- opus_design_btn(E) -->


	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
	<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="1%" />
				<col width="18%" />
				<col width="3%" />
				<col width="7%" />
				<col width="3%" />
				<col width="3%" />
				<col width="3%" />
				<col width="3%" />
				<col width="5%" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr class="h23">
					<th>Send Date </th>
					<td><input type="text" style="width:75px; text-align:center" name="from_dt" id="from_dt" maxlength="10" dataformat="ymd" class="input1"><!--
					--><button type="button" class="calendar ir" name="btn_cal1" id="btn_cal1"></button><!--
					--><input type="text" style="width:75px; text-align:center" name="to_dt" id="to_dt" maxlength="10" dataformat="ymd" class="input1"><!--
					--><button type="button" class="calendar ir" name="btn_cal2" id="btn_cal2"></button></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px; text-align:center" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup"></td>
					<th>Booking No.</th>
					<td><input type="text" style="width:120px; text-align:center" name="bkg_no" id="bkg_no" maxlength="13" dataformat="engup"></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px; text-align:center" name="vvd" id="vvd" maxlength="9" dataformat="engup"></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject('comboStatus', 3, 80);</script></td>
				</tr>
			</tbody>
		</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_result(S) -->
	<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>