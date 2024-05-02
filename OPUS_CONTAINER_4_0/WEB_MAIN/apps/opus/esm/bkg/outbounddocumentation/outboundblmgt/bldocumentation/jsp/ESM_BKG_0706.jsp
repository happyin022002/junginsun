<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0706.jsp
*@FileTitle  : Mark And Description for C/M
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/15
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0706Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0706Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLDocumentationBL");

	String mkDesc = "";
	String gdsDesc = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0706Event)request.getAttribute("Event");
		mkDesc = event.getMkDesc();
		gdsDesc = event.getGdsDesc();

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
		//
		//if(!opener) opener = window.dialogArguments;
		//document.form.cntr_mf_mk_desc.value = opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_mk_desc");
		//document.form.cntr_mf_gds_desc.value = opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_gds_desc");
		//alert(opener.sheetObjects[1].CellValue(opener.sheetObjects[1].SelectRow, "cntr_mf_mk_desc"));
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Mark & Description for C/M</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_OK" 			id="btn_OK">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->
	
</div>
<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table class="grid2">
			<tbody>
				<tr>
					<th style= "text-align:center;"><strong>Description for Customs</strong></th>
				</tr>
				<tr>
					<td><textarea name="cntr_mf_gds_desc" style="ime-mode:disabled;width:100%;height:160px;resize:none"  dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" ><%=gdsDesc%></textarea></td>
				</tr>
			</tbody>
		</table>
		<table class="grid2">
			<tbody>
				<tr class="sm">
					<th style= "text-align:center;"><strong>Marks & Numbers</strong></th>
				</tr>
				<tr>
					<td><textarea name="cntr_mf_mk_desc" style="ime-mode:disabled;width:100%;height:160px;resize:none"  dataformat="engup" otherchar="<%=getSpecialChars()%>" onpaste="javascript:mousePaste(this)" ><%=mkDesc%></textarea></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</div>
</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>