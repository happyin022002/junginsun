<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0573.jsp
*@FileTitle  : PSA DG EDI Transmit History
*@author     : CLT
*@version    : 1.0
*@since      :
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.psaspecialmanifest.event.EsmBkg0573Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0573Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";

	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.PSASpecialManifest");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0573Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>


<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry">
		<table style="width:700px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th><input type="radio" name="search_type" value="1" class="trans" checked>&nbsp;&nbsp;VVD</th>
					<td><input type="text" style="width:80px;" value='<%= JSPUtil.getParameter(request, "vvd_cd") %>' class="input" name="vvd_cd" id="vvd_cd" dataformat="engup" required maxlength="9" fullfill caption="VVD"></td>
					<th>Port</th>
					<td><input type="text" style="width:50px; ime-mode: disabled" value='<%= JSPUtil.getParameter(request, "port_cd") %>' class="input" name="port_cd" id="port_cd" dataformat="engup" required maxlength="5" fullfill caption="Port"></td>
					<th><input type="radio" name="search_type" value="2" class="trans">&nbsp;&nbsp;Transmit Date</th>
					<td><input type="text" style="width:80px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="snd_dt_from" id="snd_dt_from" caption="Transmit Date From" cofield="snd_dt_from" readOnly>&nbsp;~&nbsp;
						<input type="text" style="width:80px; ime-mode: disabled" class="input" maxlength="10" dataformat="ymd" name="snd_dt_to" id="snd_dt_to" caption="Transmit Date To" cofield="snd_dt_to" readOnly><!--
						--><img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" class="cursor" name="btn_calendar" id="btn_calendar" disabled></td>
				</tr>
			</tbody>
		</table>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result" id="mainTable">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
<!-- opus_design_grid(E) -->
</form>
