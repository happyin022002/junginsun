<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_1501-01.jsp
 *@FileTitle : ESM_BKG-1501-01
 *@author     : CLT
 *@version    : 1.0
 *@since      :
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>

<script language="javascript">
	var opnrPgmDiv = '<%=JSPUtil.getParameter(request, "opnrPgmDiv")%>';

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
		<h2 class="page_title"><span> Deletion Transmit</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_confirm" id="btn_confirm">Confirm</button>
			<button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button>
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
			<h3 class="title_design">Please Select proper Reason code</h3>
			<table>
				<colgroup>
					<col />
					<col />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<th title="Reason Code of Deletion">Reason Code of Deletion</th>
						<td>&nbsp;</td>
						<td><select style="width:250px;" class="input1" name="corr_rsn_cd" id="corr_rsn_cd" required caption="Reason Code of Deletion">
								<option value="" selected></option>
								<option value="1">[1] Cancellation of loading</option>
								<option value="3">[3] Change of B/L number</option>
								<option value="4">[4] Misregistration</option>
								<option value="5">[5] Other reasons</option>
							</select></td>
					</tr>
					<tr>
						<th title="Reason (in case of [5])">Reason (in case of [5])</th>
						<td>&nbsp;</td>
						<td><textarea style="width:250px; resize:none;" rows="3" class="input2" maxlength="210" name="corr_rsn" id="corr_rsn" dataformat="excepthan" caption="Reason (in case of [5])" readOnly></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>
