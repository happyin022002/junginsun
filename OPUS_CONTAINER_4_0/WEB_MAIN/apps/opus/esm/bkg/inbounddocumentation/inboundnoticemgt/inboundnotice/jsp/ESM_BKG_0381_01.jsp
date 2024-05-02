<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0381_01.jsp
 *@FileTitle : ESM_BKG-0381_01
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
		<h2 class="page_title"><span> Send method select</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_send" id="btn_send">Send</button>
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
					<col width="80" />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<td>&nbsp;</td>
						<th height="30" style="text-align:left;"><input type="radio" name="method" value="BL" class="trans" id="method" checked>&nbsp;&nbsp;per B/L</th>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<th height="30" style="text-align:left;"><input type="radio" name="method" value="MAIL" class="trans" id="method">&nbsp;&nbsp;per Mail Address</th>
						<td>&nbsp;</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>
