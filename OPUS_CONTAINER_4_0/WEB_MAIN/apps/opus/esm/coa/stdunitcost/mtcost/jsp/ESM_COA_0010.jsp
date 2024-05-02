<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0010.jsp
*@FileTitle  : MT CNTR MVMT History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.mtcost.event.EsmCoa0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmCoa0010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	//Variable from the parent window
	String f_cost_yrmon= JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_from_ecc= JSPUtil.getNullNoTrim(request.getParameter("f_from_ecc"));
	String f_to_ecc= JSPUtil.getNullNoTrim(request.getParameter("f_to_ecc"));
	String f_cntr_tpsz_cd= JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
	String f_ori_dest= JSPUtil.getNullNoTrim(request.getParameter("f_ori_dest"));

	Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.MTCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCoa0010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
        log.error("Exception : " + e.toString());
	}
%>

<head>
<title>Creation MT unit price of standard & MT Turntime by ECC</title>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setRetrieveAction();
	}
</script>
</head>

<body onload="setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_cost_yrmon" value="<%= f_cost_yrmon %>" id="f_cost_yrmon" />
<input type="hidden" name="f_from_ecc" value="<%= f_from_ecc %>" id="f_from_ecc" />
<input type="hidden" name="f_to_ecc" value="<%= f_to_ecc %>" id="f_to_ecc" />
<input type="hidden" name="f_cntr_tpsz_cd" value="<%= f_cntr_tpsz_cd %>" id="f_cntr_tpsz_cd" />
<input type="hidden" name="f_ori_dest" value="<%= f_ori_dest %>" id="f_ori_dest" />

<div class="layer_popup_contents" style="overflow:hidden">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Inquire MT CNTR MVMT History</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
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
	<!-- opus_design_grid(S) -->
	<div class="wrap_result" style="overflow:hidden;">
		<div class="opus_design_grid clear" id="mainTable" >
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>



</form>