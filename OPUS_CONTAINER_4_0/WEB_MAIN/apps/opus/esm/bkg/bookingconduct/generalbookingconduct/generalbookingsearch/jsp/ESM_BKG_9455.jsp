
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_9455.jsp
*@FileTitle  : Container No Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9455Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9455Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");
	
	String ydCd = "";
	String vvd = "";
	String calllFunc = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9455Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		ydCd  = JSPUtil.getParameter(request, "yd_cd");
		vvd  = JSPUtil.getParameter(request, "vvd");
		calllFunc  = JSPUtil.getParameter(request, "func");
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="vvd" id="vvd" value="<%=vvd %>">
<input type="hidden" name="calllFunc" id="calllFunc" value="<%=calllFunc%>">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Container No inquiry</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn_Retrieve" name="btn_Retrieve" class="btn_accent">Retrieve</button><!--
		--><button type="button" id="btn_Ok" name="btn_Ok" class="btn_normal">OK</button><!--
		--><button type="button" id="btn_Close" name="btn_Close" class="btn_normal">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="65"/>
				<col width="50"/>
				<col width="40"/>
				<col width="50"/>
				<col width="*" />				
			</colgroup> 
			<tr class="h23">
				<th>Yard</th>
				<td><input id="yd_cd" style="width:65px;" class="input1" name="yd_cd" value="<%=ydCd %>" maxlength="7" dataformat="engup" type="text" /> </td>
				<th>STS</th>
				<td><input style="width:40px;" class="input2" value="MT" readonly type="text" /> </td>
				<th>TP/SZ</th>
				<td><input id="cntr_tpsz" style="width:40px;" class="input" name="cntr_tpsz" value="" maxlength="2" dataformat="engup" type="text" /> </td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
</div>
</form>