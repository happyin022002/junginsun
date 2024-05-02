<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAQ_XLS.jsp
*@FileTitle  : Excel Save Kind 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>

<%
	String data = JSPUtil.getParameter(request, "data", "");
	String format = JSPUtil.getParameter(request, "format", "");
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<script>

	document.onkeydown = keyEnter;
    function keyEnter() {
        if (ComGetEvent("keycode") == 27) { // Esc
        	ComPopUpReturnValue("CANCEL");
            //window.returnValue = "CANCEL";
        	ComClosePopup();
        }
        if (ComGetEvent("keycode") == 13) { // Enter
            processButtonClick();
        }
    }
    
	function setupPage(data, format){
		loadPage(data, format);
	}    
</script>
</head>
<form name="form" id="form">
 <!-- page_title_area(S) -->
<div class="layer_poup_title"> 
	<div class="page_title_area clear" style="width: 260px;">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!--
			 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents"> 
	<div class="wrap_result" >	
		<div class="opus_design_data">
			<table style="width: 260px;" class="grid_2">
				<tr>
					<th width="50%" style="font-weight: bold">Data</th>
			    	<th width="50%" style="font-weight: bold">Format</th>
				</tr>
			     <tr align="center">
			    	<td><input name="data" id="data" value="1" style="border:0" checked="" type="radio" /><label for="data0">All</label><input name="data" id="data" value="2" style="border:0" type="radio" /><label for="data1">Designed</label></td>
			    	<td><input name="format" id="format" value="1" style="border:0" type="radio" /><label for="format0">Yes</label><input name="format" id="format" value="2" style="border:0" checked="" type="radio" /><label for="format1">No</label></td>
				</tr>
			</table>
		</div>
	</div>
</div>
</form>