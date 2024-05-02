<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0963.jsp
*@FileTitle  : Bay plan Setup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0963Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0963Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");

	String vvdCd 	= "";
	String portCd 	= "";
	String etaDate 	= "";
	String etaTime 	= "";
	String etdDate 	= "";
	String etdTime 	= "";
	String openType = "";
	String currMainPageListCnt = "0";


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0963Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// parent window parameter setting
		vvdCd 	= (StringUtil.xssFilter(request.getParameter("vvdCd")) == null) 	? "" : StringUtil.xssFilter(request.getParameter("vvdCd"));
		portCd 	= (StringUtil.xssFilter(request.getParameter("portCd")) == null) 	? "" : StringUtil.xssFilter(request.getParameter("portCd"));
		etaDate = (StringUtil.xssFilter(request.getParameter("etaDate")) == null) ? "" : StringUtil.xssFilter(request.getParameter("etaDate"));
		etaTime = (StringUtil.xssFilter(request.getParameter("etaTime")) == null) ? "" : StringUtil.xssFilter(request.getParameter("etaTime"));
		etdDate = (StringUtil.xssFilter(request.getParameter("etdDate")) == null) ? "" : StringUtil.xssFilter(request.getParameter("etdDate"));
		etdTime = (StringUtil.xssFilter(request.getParameter("etdTime")) == null) ? "" : StringUtil.xssFilter(request.getParameter("etdTime"));
		openType = (StringUtil.xssFilter(request.getParameter("openType")) == null) ? "" : StringUtil.xssFilter(request.getParameter("openType"));
		currMainPageListCnt = (StringUtil.xssFilter(request.getParameter("currMainPageListCnt")) == null) ? "0" : StringUtil.xssFilter(request.getParameter("currMainPageListCnt"));


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


<body class="popup_bg" onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="openType" value="<%=openType%>" id="openType" />
<input type="hidden" name="currMainPageListCnt" value="<%=currMainPageListCnt %>" id="currMainPageListCnt" />
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Bay plan Setup</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
		 --><% if("1".equals(openType)) { %><button type="button" class="btn_accent" name="btn1_Select" 		id="btn1_Select">Select</button><% } else  { %><!-- 
		 --><button type="button" class="btn_accent" name="btn1_Detail" 			id="btn1_Detail">Bay-Plan Detail</button><% } %><!-- 		
		 --><button type="button" class="btn_normal" name="btn1_Close" 			id="btn1_Close">Close</button><!-- 
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
	<div class= "wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="170" />
					<col width="65" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:90px;" class="input2" name="vvd_cd" readonly value="<%= vvdCd %>" id="vvd_cd" /> </td>
						<th>Port</th>
						<td><input type="text" style="width:70px;" class="input2" name="port_cd" readonly value="<%= portCd %>" id="port_cd" /> </td>
					</tr>
					<tr>
						<th>Arrival</th>
						<td><input type="text" style="width:90px;" class="input2" readonly name="eta_date" value="<%= etaDate %>" id="eta_date" /></td>
						<th>Departure</th>
						<td><input type="text" style="width:90px;" class="input2" readonly name="etd_date" value="<%= etdDate %>" id="etd_date" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>	
	<div class="wrap_result">
		<div class="opus_design_grid clear"">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
</div>	
</form>