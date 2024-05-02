<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0130.jsp
*@FileTitle  : CndManifestListDownload
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%
    String do_no = JSPUtil.getNull(request.getParameter("do_no"));
%>
<script type="text/javascript">
    function setupPage()
    {
        loadPage();
    }
</script>
<form name="form" >
<input type="hidden" name="f_cmd" value="" id="f_cmd" />
<input type="hidden" name="bkg_no" value="" id="bkg_no" />
<input type="hidden" name="old_do_no" value="" id="old_do_no" />
<input type="hidden" name="old_rcvr_co_nm" value="" id="old_rcvr_co_nm" />
<input type="hidden" name="old_cntc_phn_no" value="" id="old_cntc_phn_no" />
<input type="hidden" name="old_pic" value="" id="old_pic" />
<input type="hidden" name="old_act_cnee_nm" value="" id="old_act_cnee_nm" />
<input type="hidden" name="old_cust_ref_nm" value="" id="old_cust_ref_nm" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Receiver Info.</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
		       <button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			--><button class="btn_normal" type="button"  name="btn_Save" id="btn_Save">Save</button><!--
			--><button class="btn_normal" type="button"  name="btn_Close" id="btn_Close">Close</button>
		</div>
	<!-- opus_design_btn (E) -->
	</div>
</div>
<div class="layer_popup_contents">
	<!-- page_title_area(E) -->		     
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_data">
			<table>
				<colgroup>
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
		                <th>D/O No.</th>
		                <td align='left'><input type="text" style="width:90px;ime-mode:disabled;" class="input1" caption="D/O No." value="<%=do_no %>" name="do_no" id="do_no" dataformat="engup"  minlength="10" maxlength="12" required></td>
	             	 </tr>
				</tbody>
			</table>
			<table class="grid2">
				<tbody>
					<tr>
		                <th width="100%"><strong>Receipt Company</strong></th>
		                <td colspan="3" align="center"><input type="text" style="width:334px;" class="noinput" value="" name="rcvr_co_nm" maxlength="50" id="rcvr_co_nm" /> </td>
	                </tr>
	                <tr>
		                <th><strong>Contact Phone No.</strong></th>
		                <td><input type="text" style="width:120px;ime-mode:disabled;" class="noinput" value="" name="cntc_phn_no" dataformat="num" otherchar="-" maxlength="30" id="cntc_phn_no" /> </td>
		                <th align="center"><strong>PIC</strong></th>
		                <td><input type="text" style="width:120px;" class="noinput" value="" name="pic" maxlength="50" id="pic" /> </td>
	                </tr>
	                <tr>
		                <th align="center"><strong>Actual Consignee</strong></th>
		                <td align="center"colspan="3"><input type="text" style="width:334px;" class="noinput" value="" name="act_cnee_nm" maxlength="50" id="act_cnee_nm" /> </td>
	                </tr>
	                <tr>
		                <th><strong>Customer reference</strong></th>
		                <td><input type="text" style="width:120px;ime-mode:disabled;" class="noinput" value="" name="cust_ref_nm" maxlength="15" id="cust_ref_nm" /> </td>
		                <th><strong>Order B/L</strong></th>
		                <td><input type="text" style="width:120px;" class="noinput2" value="" name="order_flg" readonly id="order_flg" /> </td>
	                </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result" hidden="true">
		<div class="opus_design_grid" id="mainTable">
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
</div>	
</form>