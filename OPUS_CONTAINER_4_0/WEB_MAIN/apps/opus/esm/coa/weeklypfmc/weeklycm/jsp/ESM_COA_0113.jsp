<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0113.jsp
*@FileTitle  : Select Creation Type
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
%>
<script type="text/javascript">
	function setupPage(){
		//loadPage();
	}
</script>
<form name="form">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Select Creation Type</span></h2>
		<div class="opus_design_btn">
			 <button type="button" class="btn_normal" name="btn_OK" id="btn_OK">OK</button><!--
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<!-- page_title_area(E) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<td align="center">
							<input type="radio" name="rdoType" id="rdoType_C" value="Creation" checked><label for="rdoType_C">Creation</label><!--
							--><input type="radio" name="rdoType" id="rdoType_W" value="Weekly"><label for="rdoType_W">Weekly Confirm</label>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>