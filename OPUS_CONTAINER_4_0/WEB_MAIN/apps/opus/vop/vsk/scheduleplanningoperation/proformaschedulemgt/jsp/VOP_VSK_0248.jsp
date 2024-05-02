<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0248.jsp
*@FileTitle  : P/F SKD History Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/04
=========================================================
--%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.proformaschedulemgt.event.VopVsk0248Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import = "com.clt.framework.component.util.StringUtil" %> 
<%
	VopVsk0248Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
	String paramVslSlanCd = "";
	String paramPfSvcTpCd = "";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SchedulePlanningOperation.ProformaScheduleMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		
		paramVslSlanCd = request.getParameter("vsl_slan_cd");
		paramPfSvcTpCd = request.getParameter("pf_svc_tp_cd");

	   
		event = (VopVsk0248Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>P/F SKD History Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<tbody>
					<tr>
						<th width="65">Lane Code</th>   
						<td width="90"><input type="text" style="width:60;text-align:center" class="input2" readOnly value="<%=StringUtil.xssFilter(paramVslSlanCd)%>" name="vsl_slan_cd"></td>
						<th width="85">P/F SKD Type</th>   
						<td width=""><input type="text" style="width:60;text-align:center" class="input2" readOnly value="<%=StringUtil.xssFilter(paramPfSvcTpCd)%>" name="pf_svc_tp_cd"></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>

	<div class="wrap_result">
		<div class="layout_vertical_2" style="width:60%">
			<div class="opus_design_grid" >
				<script language="javascript">ComSheetObject('sheet1');</script>
			</div>
		</div>
		<div class="layout_vertical_2 pad_left_4" style="width:40%">
			<div class="opus_design_grid" >
				<script language="javascript">ComSheetObject('sheet2');</script>
			</div>
		</div>
	</div>
</div>

</form>