<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0965.jsp
*@FileTitle  : Stop Off Cargo Order
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	Exception serverException   = null;
	String strErrMsg = "";
	String currow = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		currow = JSPUtil.getParameter(request, "currow");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var currow = "<%= currow %>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Stop Off Cargo Order</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
       	    <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table> 
			<colgroup>
				<col width="90" />
				<col width="110" />
				<col width="40" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Location</th> 
					<td><input type="text" name="stop_off_loc_cd" style="width:100px;ime-mode:disabled;" class="input" readonly="readonly"/></td>
					<th>Tel</th> 
					<td><input type="text" name="stop_off_cntc_phn_no" id="stop_off_cntc_phn_no" style="width:200px;ime-mode:disabled;" size="20" class="input" otherchar="-" readonly="readonly"/></td>
				</tr>
				<tr>
					<th>Contact Point</th> 
					<td colspan="3"><input type="text" name="stop_off_cntc_pson_nm" id="stop_off_cntc_pson_nm" style="width:350px; size="30" class="input" readonly="readonly"/></td>
				</tr>
				<tr>
    				<th style="text-align:center;"> Remark(s)</th>
    				<td colspan="3"><textarea rows="6" style="width:350px;resize:none;" name="stop_off_diff_rmk"  id="stop_off_diff_rmk" readonly="readonly"></textarea></td>
				</tr>				
				<tr>
    				<td colspan="4">&nbsp;</td>
				</tr>				
			</tbody>
		</table>
	</div>
</div>
</div>
</form>