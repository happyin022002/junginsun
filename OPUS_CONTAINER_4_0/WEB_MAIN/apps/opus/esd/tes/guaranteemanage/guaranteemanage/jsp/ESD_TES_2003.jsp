﻿<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_2003.jsp
*@FileTitle : Guarantee Report Designer
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.event.EsdTes2003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
String gnte_no = JSPUtil.getNull(request.getParameter("gnte_no"));
Exception serverException   = null;
String strErrMsg = "";
try {
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
}catch(Exception e) {
	out.println(e.toString());
}
%>
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script> 
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
<input type="hidden" name="f_cmd" value=""  />
<input type="hidden" name="pagerows" value="" />
<input type="hidden" name="gnte_no" value="<%=gnte_no %>" id="gnte_no" />

<input type="hidden" name="iPage" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Guarantee Preview</span></h2>
		
		<div class="opus_design_btn">
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_reset" id="btn_reset" type="button">Reset</button>
				<button class="btn_normal" name="btn_send" id="btn_send" type="button">Send</button>
				<button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button>
			</div>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<!-- page_title_area(E) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="120">
					<col width="*">
				</colgroup>
				<tr>
					<th>E-mail Address</th>
					<td><input type="text" style="width:700px;" name="email_addr" value="" onKeyUp="syncData(this);"></td>
				</tr>
				<tr>
					<th>Fax Number</th>
					<td><input type="text" style="width:700px;" name="fax_num" value="" onKeyUp="syncData(this);tes_isNum(this);"></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<div class="opus_design_RD">
			<script type="text/javascript">rdViewerObject();</script>
		</div>
	</div>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet');</script>
	</div>		
	<!-- opus_design_grid(E) -->
</div>
<div class="header_fixed"></div>
</form>