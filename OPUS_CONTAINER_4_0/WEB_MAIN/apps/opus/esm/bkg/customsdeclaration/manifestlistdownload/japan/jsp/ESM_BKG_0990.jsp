<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName : esm_bkg_0990.jsp
 *@FileTitle : ESM_BKG-0990
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/13
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkg0990Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0990Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	//int rowCount = 0; //count of DB resultSET list

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String vvd_cd= "";
	String pod_cd= "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		vvd_cd = JSPUtil.getParameter(request, "vvd_cd");
		pod_cd = JSPUtil.getParameter(request, "pod_cd");

		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0990Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="form1_vvd_cd" value="<%=vvd_cd%>" id="form1_vvd_cd" />
<input type="hidden" name="form1_pod_cd" value="<%=pod_cd%>" id="form1_pod_cd" />

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Manifest Registration (MFS)_B/L ADD</span></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
			<colgroup>
				<col width="40">
				<col width="90">
				<col width="140">
				<col width="*">
			</colgroup>
				<tbody>
					<tr>
						<th>B/L No</th>
						<td><input type="text" style="width:110px;" name="form1_dummy_bl_no" value="" class="input1" maxlength="12" readonly id="form1_dummy_bl_no" /></td>
						<th>Stage</th>
						<td><select style="width:67px;" name="form1_stage" id="form1_stage">
							<option value="M" selected>Empty</option>
							<option value="F"></option>
							</select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>

	<div class="wrap_result" style="display:none">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid"  id="mainTable" style="display:none" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- popup_contens_area(E) -->
</form>