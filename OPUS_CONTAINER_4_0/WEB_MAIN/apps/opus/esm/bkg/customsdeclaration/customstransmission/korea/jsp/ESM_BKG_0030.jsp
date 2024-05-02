<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0030
*@FileTitle  : Korea Manifest Amend
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger"%>

<%
	String strOfc_cd			= "";
	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();

	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
%>
<script type="text/javascript">

	function setupPage(){

		loadPage();
	}

</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" value="">
<input type="hidden" name="in_type" id="in_type">
<input type="hidden" name="strOfc_cd" id="strOfc_cd" value="<%=strOfc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn"><!--
		--><button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_New" name="btn_New" class="btn_normal">New</button><!--
		--><button type="button" id="btn_BLInfo" name="btn_BLInfo" class="btn_normal">Add & B/L Info.</button><!--
		--><button type="button" id="btn_DownExcel" name="btn_DownExcel" class="btn_normal">Down Excel</button><!--
		--><button type="button" id="btn_Print" name="btn_Print" class="btn_normal">Print</button><!--
		--></div>
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
				<col width="50"/>
				<col width="140"/>
				<col width="30"/>
				<col width="114"/>
				<col width="30"/>
				<col width="100"/>
				<col width="30"/>
				<col width="120"/>
				<col width="36"/>
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>MRN</th>
				<td><input type="text" class="input2" style="width:100px; text-align:center;" name="mrn_no" id="mrn_no" ReadOnly></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" class="input1" style="width:80px; text-align:center;" name="vvd" id="vvd" maxlength="9" dataformat="engup"></td>
				<th title="Port of Loading">POL</th>
				<td><input type="text" class="input2" style="width:60px; text-align:center;" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup"></td>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" class="input1" style="width:60px; text-align:center;" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup"><input type="text" class="input" style="width:25px;" name="yard_cd" id="yard_cd" maxlength="2" dataformat="engup"></td>
				<th>Type</th>
				<td><script type="text/javascript">ComComboObject('combo1', 3, 60, 1);</script></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="50">
				<col width="100">
				<col width="340">
				<col width="95">
				<col width="60">
				<col width="95">
				<col width="*">
			</colgroup>
			<tr>
				<th>B/L No.</th>
				<td><input type="text" class="input" style="width:100px; text-align:center;" name="bl_no" id="bl_no" maxlength="12" dataformat="engup"></td>
				<td></td>
				<td class="sm pad_left_4"><input type="radio" class="trans" value="I" name="io_bnd_cd" id="io_bnd_cd1" checked><label for="io_bnd_cd1">I/B</label><input type="radio" class="trans" value="O" name="io_bnd_cd" id="io_bnd_cd2"><label for="io_bnd_cd2">O/B</label></td>
				<td></td>
				<td class="sm pad_left_4"><input type="radio" class="trans" name="only_error" id="only_error1" value="N" checked><label for="only_error1">All</label><input type="radio" class="trans" name="only_error" id="only_error2" value="Y"><label for="only_error2">Err.</label></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table class="grid" id="mainTable">
			<colgroup>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="50"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th>B/L :</th>
				<td>Local <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="bl_local" id="bl_local" readOnly></td>
				<td>T/S <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="bl_ts" id="bl_ts" readOnly></td>
				<td>Empty <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="bl_empty" readOnly></td>
				<td>Total <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="bl_total" readOnly></td>
				<th>CNTR :</th>
				<td>Local <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="cntr_local" id="cntr_local" readOnly></td>
				<td>T/S <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="cntr_ts" id="cntr_ts" readOnly></td>
				<td>Empty <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="cntr_empty" id="cntr_empty" readOnly></td>
				<td>Total <input type="text" style="width:35px;" class="input2" style="text-align:right;" name="cntr_total" id="cntr_total" readOnly></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</form>