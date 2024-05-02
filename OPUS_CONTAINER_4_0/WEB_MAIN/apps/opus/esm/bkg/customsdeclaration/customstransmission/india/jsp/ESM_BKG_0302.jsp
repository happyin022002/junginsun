<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0302.jsp
*@FileTitle  : ESM_BKG_0302
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/24
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0302Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0302Event  event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";
	String emptyCheck = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0302Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// parent window parameter setting
		vvdCd = JSPUtil.getParameter(request, "vvd_cd");
		polCd = JSPUtil.getParameter(request, "pol_cd");
		podCd = JSPUtil.getParameter(request, "pod_cd");
		emptyCheck = JSPUtil.getParameter(request, "empty_check");


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

		$('<button type="button" class="btn_accent" name="btn_download"	id="btn_download">EDI Download</button>').appendTo("#btnArea");
		$('#btn_download').after($('#btn_Close'));

		document.getElementById("title").innerHTML = " India IGM Generation (EDI)";

		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="process_type" value="2" id="process_type" />
<input type="hidden" name="empty_check" value="<%=emptyCheck%>" id="empty_check" />
	<!-- : ( Title ) (S) -->
	 <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
	<!-- : ( Title ) (E) -->
	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">

		<!-- wrap_search(S) -->
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />
					<col width="100" />
					<col width="70" />
					<col width="100" />
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:100px;" class="input2" name="vvd_cd" value="<%=vvdCd%>" required dataformat="engup" maxlength="9"  caption="VVD"></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:60px;" class="input" name="pol_cd" value="<%=polCd%>" dataformat="engup" maxlength="5" caption="POL"></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:60px;" class="input" name="pod_cd" value="<%=podCd%>" required  dataformat="engup" caption="POD"  maxlength="5"></td>
					</tr>
					<tr>
						<th>Message Type</th>
						<td><input type="radio" class="trans" name="msg_type" value="1" checked>&nbsp;&nbsp;Type V&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="msg_type" value="2">&nbsp;&nbsp;MAABS Only</td>
					</tr>

				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
		<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject("sheet1");</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
	<!-- popup_contens_area(E) -->


</form>
