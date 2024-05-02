
<%
	/*=========================================================
	 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	 *@FileName : esm_bkg_0991.jsp
	 *@FileTitle : ESM_BKG-0991
	 *@author     : CLT
	 *@version    : 1.0
	 *@since      : 2014/06/23
	 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0991Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0991Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	//int rowCount	 = 0;						//count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String bl_no= "";
	String in_vvd_cd= "";
	String in_pod_cd= "";
	String in_pod_split_cd= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		bl_no= JSPUtil.getParameter(request, "bl_no");
		in_vvd_cd= JSPUtil.getParameter(request, "in_vvd_cd");
		in_pod_cd= JSPUtil.getParameter(request, "in_pod_cd");
		in_pod_split_cd= JSPUtil.getParameter(request, "in_pod_split_cd");

		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0991Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) strErrMsg = new ErrorHandler(serverException).loadPopupMessage();

		// If you imported data from the server initialization when loading
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- 개발자 작업 -->
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span> Transmit to SEA-NACCS</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<input type="hidden" name="bl_number" id="bl_number" value="<%=bl_no%>">
<input type="hidden" name="in_vvd_cd" id="in_vvd_cd" value="<%=in_vvd_cd%>">
<input type="hidden" name="in_pod_cd" id="in_pod_cd" value="<%=in_pod_cd%>">
<input type="hidden" name="in_pod_split_cd" id="in_pod_split_cd" value="<%=in_pod_split_cd%>">
<input type="hidden" name="in_msg_tp" id="in_msg_tp">
<input type="hidden" name="in_msg_flag" id="in_msg_flag">
<input type="hidden" name="in_mfr_gubun" id="in_mfr_gubun" value="Y">

	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<h3 class="title_design" class="align_center">Do you want to trans to SEA_NACCS as CMF01 or CMF03 ?</h3>
			<table>
				<colgroup>
					<col />
					<col />
					<col />
				</colgroup>
				<tbody>
					<tr>
						<td class="align_center"><button type="button" class="btn_normal" style="text-align:center; width:105px;" name="btn2_MFR">MFR</button></div></td>
						<td class="align_center"><button type="button" class="btn_normal" style="text-align:center; width:105px;" name="btn2_CMF01">CMF01</button></td>
						<td class="align_center"><button type="button" class="btn_normal" style="text-align:center; width:105px;" name="btn2_CMF03">CMF03</button></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td align="center">
							<table style="width:95px;">
								<tr>
									<td></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td><input type="radio" name="CMF01Checked" value="5" class="trans" id="CMF01Checked">&nbsp;Correction</td>
									<td>5</td>
								</tr>
								<tr>
									<td><input type="radio" name="CMF01Checked" value="1" class="trans" id="CMF01Checked">&nbsp;Delete</td>
									<td>1</td>
								</tr>
							</table>
						</td>
						<td align="center">
							<table style="width:95px;">
								<tr>
									<td><input type="radio" name="CMF03Checked" value="2" class="trans" id="CMF03Checked_01">&nbsp;Add</td>
									<td>2</td>
								</tr>
								<tr>
									<td><input type="radio" name="CMF03Checked" value="5" class="trans" id="CMF03Checked">&nbsp;Correction</td>
									<td>5</td>
								</tr>
								<tr>
									<td><input type="radio" name="CMF03Checked" value="1" class="trans"  id="CMF03Checked">&nbsp;Delete</td>
									<td> 1</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td colspan="3" style="height:10px;"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- wrap_search(E) -->
</div>

<!-- hidden wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject("sheet1");</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- hidden wrap_result(E) -->
