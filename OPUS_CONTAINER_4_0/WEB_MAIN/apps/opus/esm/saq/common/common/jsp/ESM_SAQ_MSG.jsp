<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_MSG.js
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================*/%>

<%
	String fontColor = request.getParameter("fontColor");
	String fontWeight = request.getParameter("fontWeight");
	String btnFlg = request.getParameter("btnFlg");
	if( fontColor.length() != 0 ){
		fontColor = "color:"+fontColor+";";
	}
	if ( fontWeight.length() != 0 ){
		fontWeight = "font-weight:"+fontWeight+";";
	}
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name='form'>
<input id="btnFlg" value="<%=btnFlg%>" name="btnFlg" type="hidden" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<!--<button type="button" class="btn_normal" id="btn_copy" name="btn_copy">Copy To Clipboard</button> -->
			<button type="button" class="btn_normal" id="btn_ok" name="btn_ok">OK</button>
			<button type="button" class="btn_normal" id="btn_close" name="btn_close">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table>
				<tr>
					<td>
						<div>
							<textarea name="msg" id="msg" style="width:100%; height: 200px; border: 2; <%=fontColor+fontWeight%>" readonly="readonly" onchange="document.form.msg.scrollTop=0;"></textarea>
						</div>
					</td>
	    		</tr>
			</table>
		</div>
	</div>
</div>
</form>