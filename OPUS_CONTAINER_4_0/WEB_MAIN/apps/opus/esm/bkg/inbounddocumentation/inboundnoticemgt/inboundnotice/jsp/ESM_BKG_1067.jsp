<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1067.jsp
*@FileTitle : Pick up upload history
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
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1067Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1067Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
    String parBkgNo         = "";
    String parCntrNo        = "";
    String parOfcCd         = "";
	Logger log = Logger.getLogger("com.clt.apps.InboundBLMgtSC.PickUpNotice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

        parBkgNo  = JSPUtil.getParameter(request, "bkg_no");
        parCntrNo = JSPUtil.getParameter(request, "cntr_no");
        parOfcCd  = JSPUtil.getParameter(request, "ofc_cd");

		event = (EsmBkg1067Event)request.getAttribute("Event");
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
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
        with(document.form) {
            bkg_no.value  = "<%=parBkgNo%>";
            cntr_no.value = "<%=parCntrNo%>";
            ofc_cd.value  = "<%=parOfcCd%>";
        }
		
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no">
<input type="hidden" name="cntr_no">
<input type="hidden" name="ofc_cd">


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Pick up upload history</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">

		 <button type="button" class="btn_normal" name="btn_close"  	id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
		
</div>
<!-- page_title_area(E) -->


    
<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->	
	
</div>
</form>