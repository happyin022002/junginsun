<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_1523.jsp
*@FileTitle  : Ship Call No Registration(KCT)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_ImportSchedule" id="btn_ImportSchedule">Import Schedule</button>
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
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="30" />
				<col width="70" />
				<col width="110" />
				<col width="*" />
			</colgroup>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 45px; text-align: center;" name="vsl_cd" class="input1" maxlength="4" dataformat="engup"><input type="text" style="width: 40px; text-align: center"name="skd_voy_no" class="input" maxlength="4" dataformat="num"><input type="text" style="width: 20px; text-align: center"name="skd_dir_cd" class="input" maxlength="1" dataformat="enguponly"></td>
				<th>Vessel Name</th>
				<td><input type="text" style="width: 300px" name="vsl_nm"class="input"></td>
			</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_SelectAll" 	id="btn_SelectAll" checkedFlg="0">Select All</button><!--
				 --><button type="button" class="btn_normal" name="btn_RowAdd" 	id="btn_RowAdd">Row Add</button><!--
				 --><button type="button" class="btn_normal" name="btn_Delete" 	id="btn_Delete">Row Delete</button>
		</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>