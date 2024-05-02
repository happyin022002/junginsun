<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName  : ESM_BKG_1052.jsp
*@FileTitle : Full CNTR Release Order Remark Pop-up
*@author    : CLT
*@version   : 1.0
*@since     : 2014/07/22
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
	String do_no_t = JSPUtil.getNull(request.getParameter("do_no"));
%>

<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="p_row" value="<%=JSPUtil.getNull(request.getParameter("p_row"))%>">
<input type="hidden" name="old_rmk" value="">

<input type="hidden" name="diff_rmk" value="">
<input type="hidden" name="cntr_no" value="">
<input type="hidden" name="bkg_no" value="">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Full CNTR Release Order Remark Pop-up</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Setup</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
	<table class="grid2"> 
			<tbody>
				<tr>
					<th style="align:center">Remark(s)</th>
				</tr>
				<tr>
					<td>
						<textarea style="width:100%;overflow-y:hidden;text-indent:0px"  rows="5" name="p_remark"><%=JSPUtil.getNull(request.getParameter("p_diff_rmk"))%></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="opus_design_grid"><!-- style="display:none" -->
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>
	