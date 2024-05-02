<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0298.jsp
*@FileTitle : ESM_BKG_0969
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
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.event.EsmBkg0298Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0298Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	String vvdCd = "";
	String polCd = "";
	String podCd = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0298Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// Setting the parmeter from the parents screen
		vvdCd = JSPUtil.getParameter(request, "vvd_cd");
		polCd = JSPUtil.getParameter(request, "pol_cd");
		podCd = JSPUtil.getParameter(request, "pod_cd");

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

		document.getElementById("title").innerHTML = "Container List (EDI)";

		loadPage();
	}
</script>


<form name="form" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="process_type" value="1">

	<!-- : ( Title ) (S) -->
	 <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
	<!-- : ( Title ) (E) -->


	<!-- popup_contens_area(S) -->
	<div class="layer_popup_contents">
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry">
				<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
				<table>
					<colgroup>
						<col width="60" />
						<col width="100" />
						<col width="60" />
						<col width="100" />
						<col width="60" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th title="Vessel Voyage Direction">VVD</th>
							<td>
								<input type="text" style="width:100px;" class="input2" name="vvd_cd" value="<%=vvdCd%>" required dataformat="engup" maxlength="9" fullfill caption="VVD" id="vvd_cd" />
							</td>
							<th title="Port of Loading">POL</th>
							<td>
								<input type="text" style="width:60px;" class="input" name="pol_cd" value="<%=polCd%>" dataformat="engup" maxlength="5" caption="POL" id="pol_cd" />
							</td>

							<th title="Port of Discharging">POD</th>
							<td>
								<input type="text" style="width:60px;" class="input" name="pod_cd" value="<%=podCd%>" required dataformat="engup" caption="POD" fullfill maxlength="5" id="pod_cd" />
							</td>
						</tr>
						<tr>
							<th>Line Code</th>
							<td>
								<input type="text" style="width:100px;" class="input" name="line_cd" value=" NYK" id="line_cd" />
							</td>
						</tr>
					</tbody>
				</table>
				<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid"  id="mainTable">
				<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
	<!-- popup_contens_area(E) -->
</form>