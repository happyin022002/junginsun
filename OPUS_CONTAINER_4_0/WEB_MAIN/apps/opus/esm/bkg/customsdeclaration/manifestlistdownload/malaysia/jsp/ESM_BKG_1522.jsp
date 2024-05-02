<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1522.jsp
*@FileTitle  : Malaysia Import Status I/F
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="vsl_cd" id="vsl_cd" />
<input type="hidden" name="skd_voy_no" id="skd_voy_no" />
<input type="hidden" name="skd_dir_cd" id="skd_dir_cd" />
<input type="hidden" name="receiver_id" id="receiver_id" />
<input type="hidden" name="type_cd_all" id="type_cd_all" />

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
		 --><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_PrintView" id="btn_PrintView">Print View</button><!--
		 --><button type="button" class="btn_normal" name="btn_SpecialInfo" id="btn_SpecialInfo">Special Info.</button><!--
		 --><button type="button" class="btn_normal" name="btn_MalaysiaIF" id="btn_MalaysiaIF">EDI Transmit</button>
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
<!-- layout_wrap(S) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
<table style="width:900px">
	<colgroup>
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
			<th>VVD CD</th>
			<td><input type="text" style="width:90px; text-align:center" name="vvd" maxlength="9" required caption="VVD CD" fullfill dataformat="engup" class="input1" id="vvd" /></td>
			<th>POD</th>
			<td><input type="text" style="width:55px; text-align:center" name="pod_cd" maxlength="5" required caption="POD" fullfill dataformat="engup" class="input1" id="pod_cd" value="MYPKG" /> </td>
			<th>TML-Vessel Name / Ship Call No.</th>
			<td><input type="text" style="width:100px; text-align:center" name="vsl_nm" class="input2" readOnly id="vsl_nm" /><input type="text" style="width:50px; text-align:center;" name="vsl_voyage" readOnly class="input2" id="vsl_voyage" /></td>
			<th>Type</th>
			<td><%=new com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil().getCstmsCodeCombo("type_cd", "SG", "IMP_STS_TP","")%></td>
		</tr>
	</tbody>
</table>
</div>
</div>
<div class="wrap_result">
<div class="opus_design_grid" >
	<!--  Button_Sub (S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_RowAdd" id="btn_RowAdd">Row Add</button><!--
		 --><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Row Delete</button>
	</div>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
		<script type="text/javascript">ComSheetObject("sheet2");</script>
	</div>
</div>
</form>

