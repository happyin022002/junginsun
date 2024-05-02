<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_1038.jsp
*@FileTitle  : Bangladesh Cargo Manifest - Freight Forward License No.
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/17
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>


<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Bangladesh Cargo Manifest – Freight Forward License No.</span></h2>

		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  -->
			<button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--  -->
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--  -->
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--  -->
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<th width="80px">License No.</th>
					<td width="160px"><input type="text" style="width:120px;ime-mode: disabled" class="input" value="" name="cust_lic_no" maxlength="10" dataformat="exceptengdn"></td>
					<th width="100px">Customer Code</th>
					<td width="160px"><input type="text" style="width:120px;ime-mode: disabled" class="input" value="" name="cust_cd" maxlength="8" dataformat="uppernum" ></td>
					<th width="100px">Customer Name</th>
					<td width=""><input type="text" style="width:160px;ime-mode: disabled" class="input" value="" name="cust_nm" dataformat="exceptengdn"></td>
				</tr>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<!-- opus_grid_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_rowadd" id="btn_rowadd">Row Add</button><!--  -->
					<button type="button" class="btn_normal" name="btn_rowdelete" id="btn_rowdelete">Row Delete</button>
				</div>
				<!-- opus_grid_btn(E) -->
			</div>
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>
