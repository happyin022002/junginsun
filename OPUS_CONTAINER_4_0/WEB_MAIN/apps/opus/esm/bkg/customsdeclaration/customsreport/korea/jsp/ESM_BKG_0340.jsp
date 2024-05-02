<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0340.jsp
*@FileTitle  : Discharging CY Declare 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/09
=========================================================
--%>
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
<input type="hidden" name="io_bnd_cd" value="I" id="io_bnd_cd" />
<input type="hidden" name="event_no" value="0340" id="event_no" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />

<!-- page(S) -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
    <!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_formprint" id="btn_formprint">Form Print</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_listprint" id="btn_listprint">List Print</button><!-- 
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
    <table>
    	<colgroup>
 		 <col width="60">
		 <col width="150">
         <col width="30">
         <col width="130">
         <col width="65">
         <col width="50">
         <col width="80">
         <col width="*">           
        </colgroup>
        	<tbody>
				<tr>
					<td><input type="radio" name="search_type" checked value="vvd" class="trans" id="search_type" /><label for ="search_type"><strong>VVD</strong></label></td>
					<td><input type="text" style="width:100px;" name="vvd" class="input1" dataformat="engup" maxlength="9" id="vvd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:70px;" name="port_cd" class="input1" dataformat="engup" maxlength="5" id="port_cd" /> </td>
					<td><input type="radio" name="search_type" value="mrn" class="trans" id="search_type1" /><label for ="search_type1"><strong>MRN</strong></label></td>
					<td><input type="text" style="width:80px;" name="mrn_no" class="input1" dataformat="engup" maxlength="10" id="mrn_no" />- <input type="text" style="width:20px;" name="mrn_chk_no" class="input2" readonly id="mrn_chk_no" /><button type="button" id="btn_mrn_search" name="btn_mrn_search" class="input_seach_btn"></button></td>
					<th>Mode</th>
					<td><input type="text" style="width:70px;" value=" Inbound" class="input2" readonly /> </td>
				</tr>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" style="width:100px;" name="bl_no" class="input" dataformat="engup" maxlength="12" id="bl_no" /> </td>
					<th>MSN</th>
					<td><input type="text" style="width:70px;" name="msn_no" class="input" dataformat="num" maxlength="4" id="msn_no" /> </td>
					<th>Type</th>
					<td><select name="mrn_bl_ts_cd" id="mrn_bl_ts_cd" style="width:82px;">
						<option value="" selected>ALL</option>
						<option value="I">Local</option>
						<option value="T">T/S</option>
						</select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	    <script type="text/javascript">ComSheetObject('sheet1');</script>
	    <script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- opus_design_inquiry(E) -->
</form>				
