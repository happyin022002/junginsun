<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0102.jsp
*@FileTitle  : Send Mail
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.sce.common.popup.event.CommonPopUpManageEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CommonPopUpManageEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Setting Error at server side
	String strErrMsg = "";						//Error Message
	String rsnNames = "";
	String szSendValue = null;
	String szBkgNoValue = null;
	String szBkgNoSplitValue = null;
	String bkgPsonEml="";
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.common.popup");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		event = (CommonPopUpManageEvent)request.getAttribute("Event");
		
		szSendValue  = StringUtil.xssFilter(request.getParameter("send_val"));
		szBkgNoValue = StringUtil.xssFilter(request.getParameter("szBkgNo"));
		
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
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
	}
</script>
<base target="_self"/>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="expt_no" value="<%= szSendValue%>" id="expt_no" />
<input type="hidden" name="subject" value="" id="subject" />
<input type="hidden" name="contents" value="" id="contents" />
<input type="hidden" name="attachnm" value="" id="attachnm" />
<input type="hidden" name="send_eml3" value="" id="send_eml3" />
<input type="hidden" name="szBkgNo" value="<%=szBkgNoValue%>" id="szBkgNo" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Send Mail</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_send" id="btn_send" type="button">Send</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>
			<colgroup>
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tr>
				<th><input type="radio" name="selection" value="location" class="trans" checked="" id="selection" />&nbsp;To Company&nbsp;&nbsp;&nbsp;<input type="radio" name="selection" value="node" class="trans" id="selection" />&nbsp;To Customer</th>
				<td></td>
			</tr>
		</tbody>
	</table>
	<div id="location" style="margin-top:5px">
	<h3 class=“title_design2”>Exception Notification - Send</h3>
	<table>
		<tbody>
			<colgroup>
				<col width="70" />
				<col width="360" />
				<col width="30" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>To Company</th>
				<td colspan="2"><input id="send_eml1" name="send_eml1" type="text" style="width:360px;" value=""/><button type="button" id="btn_search" name="btn_search" class="input_seach_btn"></button></td>
				<td></td></tr>
			<tr class="h23">
				<th>Subject</th>
				<td><input name="subject1" type="text" style="width:360px;" value="Exception Notification" id="subject1" /></td>
			</tr>
			<tr class="h23">
				<th>Note</th>
				<td><textarea name="contents1" rows="5" style="width:360px;"><%=rsnNames%></textarea></td></tr>
			<tr class="h23">
				<th>File</th>
				<td><input name="attachNm1" value="Exception_Notification.xls" style="width:360px;" readonly id="attachNm1" /></td>
			</tr>
		</tbody>
	</table>
	</div>
	<div id="node" style="display:none;margin-top:5px">
	<h3 class=“title_design2”>Exception Notification - Send</h3>
	<table>
		<tbody>
			<colgroup>
				<col width="70" />
				<col width="*" />
			</colgroup>
			<tr class="h23">
				<th>To Customer</th>
				<td><input id="send_eml2" name="send_eml2" type="text" style="width:360px;" value="<%=bkgPsonEml%>" /></td></tr>
			<tr class="h23">
				<th>Subject</th>
				<td><input name="subject2" type="text" style="width:360px;" value="Exception Notification" id="subject2" /></td></tr>
			<tr class="h23">
				<th>Note</th>
				<td ><textarea name="contents2" rows="5" style="width:360px;"><%=rsnNames%> </textarea></td></tr>
			<tr class="h23">
				<th valign="top" rowspan="2">File</th>
				<td><input name="attachNm2" value="Exception_Notification.xls" style="width:360px;" readonly id="attachNm2" /></td></tr>
		</tbody>
	</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->
</form>
<form method="post" name="form1" ENCTYPE="multipart/form-data">
		<input type="hidden" id="fileParameterNames" name="fileParameterNames" value="fileObj" />
		<input type="hidden" id="f_cmd" name="f_cmd" value="" />
		<input type="hidden" id="fileNo" name="fileNo" value="" />
		<input type="hidden" id="tpbNo" name="tpbNo" value="" />
		<input type="hidden" id="invNo" name="invNo" value="" />
		<input type="hidden" name="send_eml" value="" id="send_eml" />
		<input type="hidden" name="subject" value="" id="subject" />
		<input type="hidden" name="contents" value="" id="contents" />
		<input type="hidden" name="attachNm" value="" id="attachNm" />
		<span id="spanFile" style="position:absolute;width:7px;height:7px;background-color:;clip:rect(2 43 25 2);
		z-index:9;cursor:hand;overflow-x:hidden;overflow-y:hidden;vertical-align:middle;align:center;"
		onclick=""><input type="file" id="fileObj" name="fileObj" style="cursor:hand;width:0px;height:100px;background-color:gold;filter:alpha(opacity=0);
		border-bottom:0px; border-left:0px; border-right:0px; border-top:0px;margin-bottom:0px; margin-left:0px; margin-right:0px; margin-top:0px;" onclick="disappearPoint();" onchange="fileObj_onchange();"></span>
</form>
<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none;">
	<script type="text/javascript">ComSheetObject('sheet');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
