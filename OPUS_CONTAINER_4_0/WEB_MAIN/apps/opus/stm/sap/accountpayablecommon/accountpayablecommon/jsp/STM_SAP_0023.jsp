<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0023.jsp
*@FileTitle  : Location Popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.event.StmSap0023Event"%>

<%
StmSap0023Event event = null;				//PDTO(Data Transfer Object including Parameters)		
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message


String reqCd = "";					//reqCd
String reqNm = "";					//reqNm


try {

	reqCd = JSPUtil.getNull(request.getParameter("loc_cd"));
	reqNm = JSPUtil.getNull(request.getParameter("loc_nm"));

	event = (StmSap0023Event)request.getAttribute("Event");  // 전성운 수정
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<input type="hidden" name="pagerows" id="pagerows" />

<!--<div class="layer_popup_title"> -->
	 <!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title">
			<span>Location</span>
		</h2>
		<!-- page_title(E) -->
	
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">OK</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
<!-- </div> -->

<!-- <div class="layer_popup_contents"> -->
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
						<th>Location Code</th>
						<td><input type="text" style="width:60px" class="input" name="loc_cd" id="loc_cd" maxlength="5" dataformat="engup" style="ime-mode:disabled" value="<%=reqCd%>"></td>
						<th>Location Name</th>
						<td><input type="text" style="width:130px" class="input" name="loc_nm" id="loc_nm" maxlength="50" dataformat="engup" style="ime-mode:disabled" value="<%=reqNm%>"></td>
					</tr>
			   </tbody>
			</table>
			<!-- <table><tr class="line_bluedot"><td colspan="2"></td></tr></table> -->
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- wrap_search(E) -->
	
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
<!-- </div> -->			

</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>
