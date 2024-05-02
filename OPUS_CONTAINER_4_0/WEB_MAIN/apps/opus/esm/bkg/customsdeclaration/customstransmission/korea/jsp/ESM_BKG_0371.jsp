<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0371.jsp
*@FileTitle  : MRN Create
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="mrn_no" id="mrn_no" />
<!-- //↓↓↓↓↓↓↓↓↓↓/////////////////////////// -->
<input type="hidden" name="ff_div" id="ff_div" />
<!-- //↑↑↑↑↑↑↑↑↑↑/////////////////////////// -->


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
//↓↓↓↓↓↓↓↓↓↓///////////////////////////
		--><button type="button" class="btn_normal" name="btn_save_3G" id="btn_save_3G">Save [3G]</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save [4G]</button><!--
//↑↑↑↑↑↑↑↑↑↑///////////////////////////
		--><button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_automrn" id="btn_automrn">Auto MRN</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->

</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table style="width:800px">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Bound</th>
					<td><select style="width:97px;" class="input1" name="io_bnd_cd">
						<option value="I" selected>Inbound</option>
						<option value="O">Outbound</option>
						</select></td>
					<th>Port</th>
					<td><input type="text" style="width:50px; text-align:center;" class="input1" name="port_cd" maxlength="5" dataformat="engup" id="port_cd" required caption="Port" fullfill /></td>
					<th>Lane</th>
					<td><input type="text" style="width:40px; text-align:center;" class="input" name="lane" maxlength="3" dataformat="engup" id="lane" /></td>
					<th><input type="radio" class="trans" name="rad_kind" value="vvd" checked id="rad_kind" />&nbsp;VVD</th>
					<td><input type="text" style="width:97px; text-align:center;" class="input1" name="vvd" maxlength="9" dataformat="engup" id="vvd" required caption="vvd" fullfill /></td>
					<th><input type="radio" class="trans" name="rad_kind" value="eta" id="rad_kind" />&nbsp;ETA</th>
					<td><input type="text" class="input2" style="width:75px;" name="from_dt" id="from_dt" dataformat="ymd" maxlength="10" caption="ETA [From Date]" cofield="to_dt" readOnly>~ <!--
						--><input type="text" class="input2" style="width:75px;" name="to_dt" id="to_dt" dataformat="ymd" maxlength="10" caption="ETA [To Date]" cofield="from_dt" readOnly><!--
						--><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir" disabled></button></td>
				</tr>
				<tr>
					<td colspan="6">&nbsp;</td>
					<th>Carrier</th>
					<td><select style="width:97px;" class="input1" name="crr_cd" id="crr_cd">
							<option value="H" selected>NYK</option>
							<option value="O">Others</option>
						</select></td>
					<th>MRN No.</th>
					<td><select style="width:108px;" class="input1" name="mrn_yn" id="mrn_yn">
							<option value="Y" selected>Yes</option>
							<option value="N">No</option>
						</select></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_inquiry(S) -->
	<div style= "float:right">
		<table>
			<colgroup>
				<col width="40"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<td><input type="text" style="width:30px; text-align:center;" class="input2" name="sel_type" id="sel_type" value="I" readOnly /></td>
					<td><input type="text" style="width:30px; text-align:center;" class="input1" name="start_num" maxlength="3" dataformat="num" id="start_num" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</form>