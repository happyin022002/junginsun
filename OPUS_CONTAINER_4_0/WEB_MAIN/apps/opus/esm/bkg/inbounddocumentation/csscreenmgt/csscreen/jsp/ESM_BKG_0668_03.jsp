<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0668_03.jsp
*@FileTitle  : In-bound C/S Screen US
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.csscreenmgt.csscreen.event.EsmBkg066803Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg066803Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
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
	   
	   
		event = (EsmBkg066803Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
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
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type='hidden' name ='bl_no' value = "">
<input type='hidden' name ='bkg_no' value = "<%=JSPUtil.getNull(request.getParameter("bkg_no"))%>">
<input type='hidden' name ='h_mov_cntr_no' value = "">
<input type='hidden' name ='xmlData' value = "">

<!--TAB Movement (S) -->
<div class="wrap_result">
		<div class="opus_design_inquiry">
			<script type="text/javascript">ComSheetObject('t3sheet1');</script>
		</div>
		<div class="opus_design_tab">
			<script >ComTabObject('t3tab1')</script>
		</div>
		<div id="t3tabLayer" style="display:inline">
			<div class="opus_design_inquiry">
				<script type="text/javascript">ComSheetObject('t3sheet1_1');</script>
			</div>
		</div>				<!--TAB  (E) --> 		
		<div id="t3tabLayer" style="display:none">
			<div class="opus_design_inquiry">
				<div class="opus_design_btn">
					<button type="button" class="btn_normal" name="btn_Cop" id="btn_Cop">Go to COP</button>
					<button type="button" class="btn_normal" name="btn_Movement" id="btn_Movement">Go to Movement</button>
				</div>
				<script type="text/javascript">ComSheetObject('t3sheet1_2');</script>
				<script type="text/javascript">ComSheetObject('t3sheet1_3');</script>
			</div>
		</div>
</div>
</form>
 