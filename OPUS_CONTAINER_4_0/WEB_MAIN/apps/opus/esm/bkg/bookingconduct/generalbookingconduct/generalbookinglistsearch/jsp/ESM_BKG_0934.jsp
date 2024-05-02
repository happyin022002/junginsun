<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0934.jsp
*@FileTitle  : Edit Date / Time
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
	String row = request.getParameter("row");	
	String col = request.getParameter("col");
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
		document.form.year.focus();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="row" value="<%= StringUtil.xssFilter(row) %>" id="row" />
<input type="hidden" name="col" value="<%= StringUtil.xssFilter(col) %>" id="col" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Edit Date / Time</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ok" 				id="btn_ok">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_clear" 		id="btn_clear">Clear</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td><input type="checkbox" name="chk0" class="trans" id="chk0" /><label for="chk0"><strong> Edit Full Cargo CCT</strong></label></td>
				</tr>
			</tbody>
		</table>
		<table class="grid_2">			
			<tbody>
				<tr>
					<th style = "text-align:center"><strong>Year</strong></th>
					<th style = "text-align:center"><strong>Month</strong></th>
					<th style = "text-align:center"><strong>Date</strong></th>
					<th style = "text-align:center"><strong>Hour</strong></th>
					<th style = "text-align:center"><strong>Minute</strong></th>
				</tr>
				<tr>
					<td><input type="text" name="year0" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="num" maxlength="4" value="" id="year0" /></td>
					<td><input type="text" name="month0" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="num" maxlength="2" value="" id="month0" /></td>
					<td><input type="text" name="day0" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="num" maxlength="2" value="" id="day0" /></td>
					<td><input type="text" name="time0" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="num" maxlength="2" value="" id="time0" /></td>
					<td><input type="text" name="minute0" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="num" maxlength="2" value="" id="minute0" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td><input type="checkbox" name="chk1" class="trans" id="chk1" /><label for="chk1"><strong> Edit Port CCT</strong></label></td>
				</tr>
			</tbody>
		</table>
		<table class="grid_2">			
			<tbody>
				<tr>
					<th style = "text-align:center"><strong>Year</strong></th>
					<th style = "text-align:center"><strong>Month</strong></th>
					<th style = "text-align:center"><strong>Date</strong></th>
					<th style = "text-align:center"><strong>Hour</strong></th>
					<th style = "text-align:center"><strong>Minute</strong></th>
				</tr>
				<tr>
					<td><input type="text" name="year" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="num" maxlength="4" value="" onkeyup="javascript:formCheck('year')" id="year" /></td>
					<td><input type="text" name="month" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('month')" id="month" /></td>
					<td><input type="text" name="day" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('day')" id="day" /></td>
					<td><input type="text" name="time" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('time')" id="time" /></td>
					<td><input type="text" name="minute" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="num" maxlength="2" value="" id="minute" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr>
					<td><input type="checkbox" name="chk2" class="trans" id="chk2" /><label for ="chk2"><strong> Edit DOC CCT</strong></label></td>
				</tr>
			</tbody>
		</table>
		<table class = "grid2">			
			<tbody>
				<tr>
					<th style = "text-align:center"><strong>Year</strong></th>
					<th style = "text-align:center"><strong>Month</strong></th>
					<th style = "text-align:center"><strong>Date</strong></th>
					<th style = "text-align:center"><strong>Hour</strong></th>
					<th style = "text-align:center"><strong>Minute</strong></th>
				</tr>
				<tr class="h23">
					<td><input type="text" name="year2" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="num" maxlength="4" value="" onkeyup="javascript:formCheck('year2')" id="year2" /></td>
					<td><input type="text" name="month2" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('month2')" id="month2" /></td>
					<td><input type="text" name="day2" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('day2')" id="day2" /></td>
					<td><input type="text" name="time2" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="num" maxlength="2" value="" onkeyup="javascript:formCheck('time2')" id="time2" /></td>
					<td><input type="text" name="minute2" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="num" maxlength="2" value="" id="minute2" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>


</form>