<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_03.jsp
*@FileTitle  : C/S Screen_S/O Info
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg029203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CsScreenMgtSC.CsScreenBC");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg029203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var strUsr_id    = "<%=strUsr_id%>";

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
<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">

	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
		<h3 class="title_design">S/O Status per Container</h3>
	    <div class="layout_vertical_2" style="width:78%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('t4sheet1');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	    <div class="layout_vertical_2" style="width:2%">
	       <table><tr><td>&nbsp;</td></tr></table>
	    </div>
	    <div class="layout_vertical_2"  style="width:20%">
	        <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
	            <script type="text/javascript">ComSheetObject('t4sheet2');</script>
	        </div>
	        <!-- opus_design_grid(E) -->
	    </div>
	</div>
	<!-- layout_wrap(E) -->
	
	<div class="opus_design_grid">
		<h3 class="title_design">W/O Detail(s) per Container</h3>
		<br/>
		<script type="text/javascript">ComSheetObject('t4sheet3');</script>
		<script type="text/javascript">ComSheetObject('t4sheet4');</script>
	</div>
</form> 