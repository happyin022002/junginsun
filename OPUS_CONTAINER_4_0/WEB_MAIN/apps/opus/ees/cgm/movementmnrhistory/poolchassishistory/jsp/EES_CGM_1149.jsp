<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1149.jsp
*@FileTitle  : Import Error Report (Pop-Up)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/10/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.movementmnrhistory.poolchassishistory.event.EesCgm1149Event"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1149Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String file_seq         = "";
	Logger log = Logger.getLogger("com.clt.apps.MovementMnrHistory.PoolChassisHistory");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		file_seq  = StringUtil.xssFilter(request.getParameter("file_seq"));

		event = (EesCgm1149Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="file_seq" value="<%=file_seq %>">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Import Error Report (Pop-Up)</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>