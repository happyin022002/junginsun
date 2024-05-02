<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1518.jsp
*@FileTitle  : ACI_Vessel Informationn
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/05
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.event.EsmBkg1518Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1518Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvd ="";
	String ssrNo = "";
	String pod = "";
	String popup = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1518Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		vvd   = JSPUtil.getNull(request.getParameter("vvd"));
		ssrNo = JSPUtil.getNull(request.getParameter("ssrNo"));
		pod   = JSPUtil.getNull(request.getParameter("pod"));
		popup = JSPUtil.getNull(request.getParameter("popup"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

		<%if("y".equals(popup)){ %>
		document.getElementById("title").innerHTML = "B/L List for CUSCAR";
		<%} %>

		loadPage();

	}
</script>
<form name="form" id="form" method="post">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="frm_attr_ctnt2" name="frm_attr_ctnt2">
<input type="hidden" name="in_pod" value="<%=pod%>">
<input type="hidden" id="popup" name="popup" value="<%=popup%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_cuscar" id="btn_cuscar">CUSCAR</button><!--
		--><button type="button" class="btn_normal" name="btn_view" id="btn_view">B/L View</button><!--
		--><button type="button" class="btn_normal" name="btn_transfer" id="btn_transfer">CUSCAR Transmit</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="50"></col>
					<col width="120"></col>
					<!--
					<col width="70"></col>
					<col width="120"></col>
					 -->
					<col width="50"></col>
					<col width="100"></col>
					<col width="50"></col>
					<col width="160"></col>
					<!--
					<col width="50"></col>
					<col width="100"></col>
					 -->
					<col width="*"></col>
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;text-align:center;;ime-mode:disabled" name="vvd" id="vvd" class="input1" align="middle" maxlength="9" required caption="VVD" dataformat="engup" value="<%=vvd %>"></td>
					<!--
					<th>SSR No.</th>
					<td><input type="text" style="width:100px;text-align:center;;ime-mode:disabled" name="ssr_no" id="ssr_no" class="input" align="middle" maxlength="7" dataformat="num" value="<%=ssrNo %>"></td>
					 -->
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:80px;ime-mode: disabled;" name="pol_cd" id="pol_cd"  class="input" align="middle" fullfill maxlength="5" dataformat="engup"></td>
					<th>POD</th>
					<td><input type="text" style="width:80px;text-align:center;ime-mode:disabled" name="pod" id="pod" class="input1" align="middle" fullfill maxlength="5" required caption="POD" maxlength="3" dataformat="engup"></td>
					<th>VSL Name</th>
					<td><input type="text" style="width:200px;text-align:left;" name="vsl_name" id="vsl_name" class="input2" align="middle" maxlength="50" readonly="readonly"></td>
					<!--
					<th>ETA</th>
					<td><input type="text" style="width:100px;text-align:center;" name="eta_dt" id="eta_dt" class="input2" maxlength="10" dataformat="ymd" readonly="readonly"></td>
					-->
				</tr>
			</tbody>
		</table>
	</div>
<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<table class="line_bluedot"><tr><td></td></tr></table>
	</div>
<!-- opus_design_grid(E) -->


<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>