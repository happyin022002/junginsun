<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0203.jsp
*@FileTitle  : Berth window input
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vesseloperationsupportmgt.terminalinformationmgt.event.VopVsk0703Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VopVsk0703Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String enableForm		= "";
	String row				= "";
	
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationSupportMgt.TerminalInformationMgt");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (VopVsk0703Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		row = request.getParameter("row");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		enableForm = request.getParameter("enableForm");

		if(enableForm == null)
			enableForm = "";
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
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
<input type="hidden" name="enableForm" id="enableForm" value="<%=StringUtil.xssFilter(enableForm)%>">
<input type="hidden" name="row" id="row" value="<%=StringUtil.xssFilter(row)%>">

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Berth window input</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<% 
		if(enableForm.equals("Y")){
		%>
			<button type="button" class="btn_accent" name="btn_ok" id="btn_ok">Ok</button>
		<%
		}
		%>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
	<h3 style="margin-bottom:0" class="title_design">Berth Window Input Information</h3>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40">
					<col width="100">
					<col width="60">
					<col width="*">
				</colgroup>
				<tbody>
				<tr>
					<th>Port</th>
					<td><input type="text" style="width:99px;text-align:center;" class="input2" value="" name="loc_cd" readonly id="loc_cd" /> </td>
					<th>TMNL Code</th>
					<td><input type="text" style="width:100px;text-align:center;" class="input2" value="" name="yd_cd" readonly id="yd_cd" /> </td>
				</tr>
				<tr>
					<th>Bound</th>
					<td><input type="text" style="width:99px;text-align:center;" class="input2" value="" name="skd_dir_cd" readonly id="skd_dir_cd" /> </td>
					<th>Carrier Code</th>
					<td><input type="text" style="width:100px;text-align:center;" class="input2" value="" name="crr_cd" readonly id="crr_cd" /> </td>
				</tr>
				<tr>
					<th>ETB</th>
					<td><script type="text/javascript">ComComboObject('etb_dy_cd');</script><input type="text" style="width:60px;text-align:center;" class="input" value="" name="etb_tm_hrmnt" dataformat="num" required caption="etb_hour" maxlength="2" id="etb_tm_hrmnt" />
				</tr>
				<tr>
					<th>ETD</th>
					<td><script type="text/javascript">ComComboObject('etd_dy_cd');</script><input type="text" style="width:60px;text-align:center;" class="input" value="" name="etd_tm_hrmnt" required dataformat="num" caption="etd_hour" maxlength="2" id="etd_tm_hrmnt" /> </td>
				</tr>
			</tbody>
		</table>
		</div>
	</div>
</div>

</div>
</form>