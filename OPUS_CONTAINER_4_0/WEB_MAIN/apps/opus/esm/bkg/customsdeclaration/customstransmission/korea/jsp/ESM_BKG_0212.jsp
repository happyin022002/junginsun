<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<script type="text/javascript">
    function setupPage(){

	    loadPage();
    }
</script>
<form name="form">
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="io" id="io" />
<input type="hidden" name="authority" id="authority" />
<input type="hidden" name="deleteBtnChkYN" id="deleteBtnChkYN" />
<input type="hidden" name="max_vvd_seq" value="0" id="max_vvd_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_TransDGM" id="btn_TransDGM" type="button">반입신고서 전송</button><!--
		--><button class="btn_normal" name="btn_TransDGL" id="btn_TransDGL" type="button">적하일람표 전송</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="90">
				<col width="100">
				<col width="30">
				<col width="115">
				<col width="50">
				<col width="130">
				<col width="100">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input1" name="vvd" id="vvd" maxlength="9" dataformat="engup"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:62px;text-align:center;" class="input1" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input1" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup"></td>
					<td class="sm pad_left_4"><input type="radio" class="trans" name="current_check" id="current_check1" value="C" checked> <label for="current_check1"><strong>Current</strong></label></td>
					<td class="sm"><input type="radio" class="trans" name="current_check" id="current_check2" value="D"> <label for="current_check2"><strong>Downloaded</strong></label></td>
					<td></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="235">
				<col width="50">
				<col width="129">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Send Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input" maxlengt="10" dataformat="ymd" name="send_dt" id="send_dt"><!--  
						--><input type="text" style="width:50px;text-align:center;" class="input" name="send_tm" id="send_tm" maxlength="5" dataformat="hm"><!--  
						--><button type="button" class="calendar" name="btn_cal1" id="btn_cal1"></button></td>
					<th>Authority</th>
					<td><script type="text/javascript">ComComboObject('comboAuth', 3, 60, 1);</script></td>
					<th>IO DATE</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input" name="io_dt" id="io_dt" maxlength="10" dataformat="ymd"><!--  
						--><input type="text" style="width:50px;text-align:center;" class="input" name="io_tm" id="io_tm" maxlength="5" dataformat="hm"><!--  
						--><button type="button" class="calendar" name="btn_cal2" id="btn_cal2"></button></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="76">
				<col width="80">
				<col width="267">
				<col width="70">
				<col width="125">
				<col width="67">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>In Count</th>
					<td><input type="text" style="width:40px;text-align:center;" class="input" name="call_knt" id="call_knt"></td>
					<th>Arrival Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input" name="arv_dt" id="arv_dt" maxlength="10" dataformat="ymd"><!--  
						--><input type="text" style="width:50px;text-align:center;" class="input" name="arv_tm" id="arv_tm" maxlength="5" dataformat="hm"><!--  
						--><button type="button" class="calendar" name="btn_cal3" id="btn_cal3"></button></td>
					<th>Trans Code</th>
					<td><input type="text" style="width:58px;text-align:center;" class="input" name="trans_code" id="trans_code"></td>
					<th>IO</th>
					<td><script type="text/javascript">ComComboObject('comboIO', 3, 60, 1);</script></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="160">
				<col width="155">
				<col width="70">
				<col width="128">
				<col width="70">
				<col width="112">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Discharge Company Code</th>
					<td><input type="hidden" name="dchg_com_cd" id="dchg_com_cd"><script type="text/javascript">ComComboObject('comboDchgComCd', 3, 100, 0, 0, 0, true);</script></td>
					<th>DSCH Com</th>
					<td><input type="text" style="width:115px;" class="input" name="dsch_com_nm" id="dsch_com_nm" dataformat="engup"></td>
					<th>Total CNTR</th>
					<td><input type="text" style="width:58px;text-align:right;" class="input" name="total_cntr" id="total_cntr" dataformat="float"></td>
					<th>Total Weight</th>
					<td><input type="text" style="width:104px;text-align:right;" class="input" name="total_wgt" id="total_wgt" dataformat="float"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="80">
				<col width="70">
				<col width="80">
				<col width="65">
				<col width="288">
				<col width="102">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Job Code 1</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input" name="job_code1" id="job_code1"></td>
					<th>Job Code 2</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input" name="job_code2" id="job_code2"></td>
					<th>From Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input" maxlength="10" name="from_dt" id="from_dt" dataformat="ymd"><!--  
						--><input type="text" style="width:50px;text-align:center;" class="input" name="from_tm" id="from_tm" maxlength="5" dataformat="hm"><!--  
						--><button type="button" class="calendar" name="btn_cal4" id="btn_cal4"></button></td>
					<th>To Date</th>
					<td><input type="text" style="width:80px;text-align:center;" class="input" name="to_dt" id="to_dt" maxlength="10" dataformat="ymd"><!--  
						--><input type="text" style="width:50px;text-align:center;" class="input" name="to_tm" id="to_tm" maxlength="5" dataformat="hm"><!--  
						--><button type="button" class="calendar" name="btn_cal5" id="btn_cal5"></button></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="80">
				<col width="70">
				<col width="80">
				<col width="65">
				<col width="132">
				<col width="70">
				<col width="138">
				<col width="50">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Previous Port</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input" name="pre_port" id="pre_port"></td>
					<th>Port Area</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input" name="port_area" id="port_area" maxlength="3"></td>
					<th>Port Anch</th>
					<td><input type="text" style="width:60px;text-align:center;" class="input" name="port_anch" id="port_anch" maxlength="2"></td>
					<th>Port Desc.</th>
					<td><input type="text" style="width:120px;text-align:center;" class="input" name="port_desc" id="port_desc"></td>
					<th>MRN</th>
					<td><input type="text" style="width:100px;text-align:center;" class="input" name="mrn_no" id="mrn_no"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Substance</th>
					<td><input type="text" style="width:768px;" class="input" name="substance" id="substance"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="623">
				<col width="60">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Contact</th>
					<td><input type="text" style="width:565px;" class="input" name="contact" id="contact"></td>
					<th>TML. VVD</th>
					<td><input type="text" style="width:121px;text-align:center;" class="input" name="tml_vvd" id="tml_vvd"></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="90">
				<col width="230">
				<col width="65">
				<col width="120">
				<col width="85">
				<col width="102">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>VSL Full Name</th>
					<td><input type="text" style="width:210px;" class="input" name="vsl_eng_nm" id="vsl_eng_nm" dataformat="engup"></td>
					<th>Call Sign</th>
					<td><input type="text" style="width:100px;text-align:center;" class="input" name="call_sgn_no" id="call_sgn_no" dataformat="engup" maxlength="5"></td>
					<th>Inbound Seq.</th>
					<td><input type="text" style="width:65px;text-align:center;" class="input" name="dgco_seq" id="dgco_seq"></td>
					<th>TMN. Voyage</th>
					<td><input type="text" style="width:101px;text-align:center;" class="input" name="tml_skd_voy_no" id="tml_skd_voy_no"></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_SelectAll" id="btn_SelectAll">Select All</button><!--  
			--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button><!--  
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
