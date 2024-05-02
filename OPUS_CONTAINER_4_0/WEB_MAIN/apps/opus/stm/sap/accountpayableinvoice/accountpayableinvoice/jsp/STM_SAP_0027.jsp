<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0027.jsp
*@FileTitle  : Line Claim DFF Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%

Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message


String reqHType   = "";					//Header'S Evidence Type
String requiredChkStr = "";
String requiredChkStr2 = "";
String requiredChkStr3 = "";

String attr1 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr1")));
String attr2 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr2")));
String attr3 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr3")));
String attr8 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr8")));
String attr11 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr11")));
String attr12 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr12")));
String attr14 = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("attr14")));
String chk_editable = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("chk_editable")));
String chk_svc_editable = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("chk_svc_editable")));

try {

	reqHType = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("reqHType")));

	if (reqHType.equals("INVOICES")) { 
		requiredChkStr = " class='input1' required ";
	} else {
		requiredChkStr = " class='input' ";
	}
	requiredChkStr2 = " class='input' ";
	
	if (chk_svc_editable != null && chk_svc_editable.equals("ACT")) {
		requiredChkStr3 = " class='input1' readonly ";
	} else {
		requiredChkStr3 = " class='input1' required ";
	}
	
	if (chk_editable != null && chk_editable.equals("N")) {
		requiredChkStr = "  class='input2'  readonly ";
		requiredChkStr2 = "  class='input2'  readonly ";
		requiredChkStr3 = "  class='input2'  readonly ";
	}

	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}


}catch(Exception e) {
	out.println(e.toString());
}

%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}


</script>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="reqHType" value="<%=reqHType %>" id="reqHType" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Line Claim DFF</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_ok" id="btn_ok">OK</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_new"  	id="btn_new">New</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Location Code</th>
						<td><input type="text" style="width:80px;" class="input1" name="attr_ctnt3" maxlength="6" dataformat="engup" value="<%=attr3%>" required caption="Location Code" id="attr_ctnt3" /><button type="button" id="btns_loc_srh" name="btns_loc_srh" class="input_seach_btn"></button><input type="text" style="width:150px;" class="input2" name="attr_ctnt3_nm" readonly id="attr_ctnt3_nm" /> </td>
					</tr> 
					<tr>
						<th>Supplier Invoice No</th>
						<td><input type="text" style="width:258px;" <%=requiredChkStr%> name="attr_ctnt1" maxlength="30" dataformat="engupetc" Caption="Supplier Invoice No"></td>
					</tr> 
					<tr>
						<th>Supplier Invoice Date</th>
						<td><input type="text" style="width:80px;ime-mode:disabled" <%=requiredChkStr%> name="attr_ctnt2" id="attr_ctnt2" maxlength="10" dataformat="ymd" Caption="Supplier Invoice Date"><button type="button" id="btns_cal1" name="btns_cal1" class="calendar ir"></button></td>
					</tr> 
					<tr>
						<th>Claim No</th>
						<td><input type="text" style="width:258px;" <%=requiredChkStr2%> name="attr_ctnt8" maxlength="20" dataformat="engup" caption="Claim No" id="attr_ctnt8" /></td>
					</tr>
					<tr>
						<th>Activity Date</th>
						<td><input type="text" style="width:80px;"   <%=requiredChkStr%>  name="attr_ctnt11" maxlength="10" dataformat="ymd" style="ime-mode:disabled"  value="<%=attr11%>"  Caption="Activity Date"><button type="button" id="btns_cal2" name="btns_cal2" class="calendar ir"></button></td>
					</tr> 
					<tr>
						<th>Activity Place</th>
						<td><input type="text" style="width:258px;"  <%=requiredChkStr%>  name="attr_ctnt12" maxlength="10" dataformat="engupetc" value="<%=attr12%>"  Caption="Activity Place"></td>
					</tr> 
					<tr>
						<th>Service Lane</th>
						<td><input type="text" style="width:258px;"  <%=requiredChkStr3%>   name="attr_ctnt14" maxlength="3" dataformat="engupetc" value="<%=attr14%>"  Caption="Service Lane"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div id="hidSheetDiv">
			<div class="opus_design_grid" id="mainTable" style="display: none;">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
	<!-- wrap_result(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>