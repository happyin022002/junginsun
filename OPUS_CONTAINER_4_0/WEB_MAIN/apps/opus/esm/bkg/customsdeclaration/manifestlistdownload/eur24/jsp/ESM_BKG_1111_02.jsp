<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1111.js
*@FileTitle  :  US AMS: Main Menu
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String strOfc_cd        = "";
    String strPgmNo         = "";
    String strOfcType       = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		strPgmNo = request.getParameter("pgmNo");
		if("ESM_BKG_1111".equals(strPgmNo)) strOfcType = "Origin";
	}catch(Exception e) {
		out.println(e.toString());
	}
	
%>
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="ofcType" id="ofcType" value="<%=strOfcType%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
		   <!-- page_title(S) -->
			<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
			<!-- page_title(E) -->
			<!-- page_location(S) -->
			<div class="location">
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
</div>
	<!-- page_title_area(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table style="width:315px;">
				<colgroup>
					<col width="30">
					<col width="*">
				</colgroup>
				 <tbody>
					<tr><td colspan="2"><h3 class="title_design">EU ENS/EXS (EU Office)</h3></td></tr>
					<tr><td></td><td></td></tr>
					<tr><td></td><td><h3>EXS</h3></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_EXS_1" onmouseover="obj_MouseOver('btn_EXS_1')" onmouseout="obj_MouseOut('btn_EXS_1')">1. EXS Download & Transmit</button></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_EXS_2" onmouseover="obj_MouseOver('btn_EXS_2')" onmouseout="obj_MouseOut('btn_EXS_2')">2. EXS Report</button></td></tr>					
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_EXS_3" onmouseover="obj_MouseOver('btn_EXS_3')" onmouseout="obj_MouseOut('btn_EXS_3')">3. EXS Monitor</button></td></tr>					
					<tr><td></td><td></td></tr>
					<tr><td></td><td><h3>ENS Inbound Documentation</h3></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_IB_1" onmouseover="obj_MouseOver('btn_IB_1')" onmouseout="obj_MouseOut('btn_IB_1')">1. Arrival Notice</button></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_IB_2" onmouseover="obj_MouseOver('btn_IB_2')" onmouseout="obj_MouseOut('btn_IB_2')">2. Diversion Request</button></td></tr>
					<tr><td></td><td></td></tr>
					<tr><td></td><td><h3>ENS Report</h3></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_IT_1" onmouseover="obj_MouseOver('btn_IT_1')" onmouseout="obj_MouseOut('btn_IT_1')">1. ENS Report(EU Office)</button></td></tr>
					<tr><td></td><td><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_IT_2" onmouseover="obj_MouseOver('btn_IT_2')" onmouseout="obj_MouseOut('btn_IT_2')">2. ENS Monitor(EU Office)</button></td></tr>
					<tr><td></td><td></td></tr>
					<tr><td></td><td><h3>Code</h3></td></tr>
					<tr><td></td><td class="pad_btm_8"><button onclick="return false" class="btn_etc" style="width:300px; text-align:left;" id="btn_CS_1" onmouseover="obj_MouseOver('btn_CS_1')" onmouseout="obj_MouseOut('btn_CS_1')">1. Customs Setup</button></td></tr>
					
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->

</form>
