<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BSA_0120.jsp
*@FileTitle  : Carrier's Register
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bsa.bsamanage.bsamanage.event.EsmBsa0120Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBsa0120Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String bsa_op_cd ="";
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BSAManage.BSAManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBsa0120Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Extracting the data gotten from serve while initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		bsa_op_cd = JSPUtil.getNull(request.getParameter("bsa_op_cd"));

		
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
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="bsa_op_cd" id="bsa_op_cd" value="<%=bsa_op_cd%>">
<input type="hidden" name="param1" id="param1"> <!-- Gubun   |  Method Name -->
<input type="hidden" name="param2" id="param2"> <!-- Carrier |  crr_cd      -->

<!-- 2015.01.06 김용습 -->
<%if (bsa_op_cd.equals("J")) {%> <!-- 0023화면에서 불러올 때 -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Carrier's Register</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_ok" 		id="btn_ok">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<%} else {%> <!-- 0021화면에서 불러올 때 -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Carrier Information</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<%}%>

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" name="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- layer_popup_contents(E) -->
</form>
<SCRIPT type="text/javascript">
<!--
      /* 
        getting the Infomation, which the user input, from event except ibsheet and showing it on the screen 
      */
     with(document.form)
      {
       }
-->
</SCRIPT>
<%@ include file="/bizcommon/include/common_opus.jsp" %>