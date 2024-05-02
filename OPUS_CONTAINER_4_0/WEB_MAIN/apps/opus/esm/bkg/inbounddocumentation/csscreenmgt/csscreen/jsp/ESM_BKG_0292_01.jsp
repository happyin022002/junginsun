<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0292_01.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg029201Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg029201Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
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
		event = (EsmBkg029201Event)request.getAttribute("Event");
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type='hidden' name ='bl_no' id ='bl_no' value = "">
<input type='hidden' name ='bkg_no' id ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">

	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_Cop" id="btn_Cop">Go to COP</button><!--  
		--><button type="button" class="btn_normal" name="btn_Movement" id="btn_Movement">Go to Movement</button>
	</div>

	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('t2sheet1');</script>
	</div>
	
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('t2sheet2');</script>
	</div>
	
	<script type="text/javascript">ComSheetObject('t2sheet3');</script>
</form>
 