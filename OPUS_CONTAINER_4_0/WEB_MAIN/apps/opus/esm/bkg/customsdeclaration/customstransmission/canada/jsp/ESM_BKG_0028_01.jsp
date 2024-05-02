<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved. 
 *@FileName : esm_bkg_0028_01.jsp
 *@FileTitle : ESM_BKG-0028_01
 *@author     : CLT
 *@version    : 1.0
 *@since      :
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span> Modify for Delete Transmission</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col />
					<col width="20px" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td>&nbsp;</td>
						<td><input type="text" class="input" style="width:120px;" name="vvd_cd" id="vvd_cd" maxlength="9" caption="VVD" fullfill dataformat="engup"></td>
					</tr>
					<tr>
						<th title="Port of Discharging">POD</th>
						<td>&nbsp;</td>
						<td><input type="text" class="input" style="width:120px;" name="pod_cd" id="pod_cd" maxlength="5" caption="POD" fullfill dataformat="engup"></td>
					</tr>
					<tr>
						<th title="Customs Port of Discharging">Customs</th>
						<td>&nbsp;</td>
						<td><input type="text" class="input" style="width:120px;" name="cstms_port_cd" id="cstms_port_cd" maxlength="5" caption="Customs" fullfill dataformat="engup"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>
