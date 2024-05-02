<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0582.jsp
*@FileTitle  : PSA Port Registeration
*@author     : CLT
*@version    : 1.0
*@since      : 4/28/2014
=========================================================
*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
	Object menuflag = request.getAttribute("menuflag");
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="60">OPUS Port CD</th>
					<td>
						<input type="text" style="width:88px; text-align:center" class="input1" name="port_cd" id="port_cd" maxlength="5" dataformat="engup">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_rowAdd" id="btn_rowAdd">Row Add</button>
					<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
