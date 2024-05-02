<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0124.jsp
*@FileTitle  : Bottleneck Input
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
<%@ page import="com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.event.EsdSce0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdSce0124Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error On Server Side
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//DB ResultSet List Count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rlaneSheetList 	= "";
	String rlaneNmSheetList 	= "";

	String gubun		=   "";
	String cust_trd_prnr_id = "";
	String pol_cd	=	"";
	String pod_cd	=   "";

	String rout_rcv_dt	=   "";
	String rout_seq	=   "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdSce0124Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// The data obtained from the server side on load.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rlaneSheetList = eventResponse.getETCData("rlaneSheetList");
		rlaneNmSheetList = eventResponse.getETCData("rlaneNmSheetList");

		gubun	= JSPUtil.getParameter(request, "gubun".trim(), "");

		cust_trd_prnr_id = JSPUtil.getParameter(request, "cust_trd_prnr_id".trim(), "");
		pol_cd	= JSPUtil.getParameter(request, "pol_cd".trim(), "");
		pod_cd  = JSPUtil.getParameter(request, "pod_cd".trim(), "");

		rout_rcv_dt = JSPUtil.getParameter(request, "rout_rcv_dt".trim(), "");
		rout_seq    = JSPUtil.getParameter(request, "rout_seq".trim(), "");
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
		loadPage("<%=rlaneSheetList%>", "<%=rlaneNmSheetList%>");
	}
</script>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="gubun" value="<%=gubun%>" id="gubun" />

<input type="hidden" name="cust_trd_prnr_id" value="<%=cust_trd_prnr_id%>" id="cust_trd_prnr_id" />
<input type="hidden" name="pol_cd" value="<%=pol_cd%>" id="pol_cd" />
<input type="hidden" name="pod_cd" value="<%=pod_cd%>" id="pod_cd" />

<input type="hidden" name="rout_rcv_dt" value="<%=rout_rcv_dt%>" id="rout_rcv_dt" />
<input type="hidden" name="rout_seq" value="<%=rout_seq%>" id="rout_seq" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Block lane</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 	id="btn_save">Save</button><!--
		--><button type="button" class="btn_normal" name="btng_ok" id="btng_ok">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btng_rowadd1" 	id="btng_rowadd1">Row Add</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>