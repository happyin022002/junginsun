<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1089.jsp
*@FileTitle  : Hold/Internal Remark Pop-up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<script type="text/javascript">
    function setupPage()
    {  
	    loadPage();
    } 
</script>
<form name="form">
<input type="hidden" name="old_remark" value="" id="old_remark" />
<input type="hidden" name="sheet_name" value="<%=JSPUtil.getNull(request.getParameter("sheet_name")) %>" id="sheet_name" />
<input type="hidden" name="f_cmd" id="f_cmd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Hold/Internal Remark Pop-up</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Save" id="btn_Save">Save</button><!--
			--><button class="btn_normal" type="button" name="btn_Close" id="btn_Close" >Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
				   		<th>Remark(s)</th>
						<td><textarea style="width:100%;height:100px;overflow-y:hidden;text-indent:0px;resize:none;"  rows="5" id="remark" name="remark"></textarea></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
</div>
</form>