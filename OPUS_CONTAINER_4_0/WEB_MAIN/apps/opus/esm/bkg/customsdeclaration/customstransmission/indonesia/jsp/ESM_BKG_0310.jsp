<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0310.jsp
*@FileTitle  : Customs EDI (I/B)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.event.EsmBkg0310Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0310Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String strOfc_cd = "";

	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.customsdeclaration.customstransmission.indonesia");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0310Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}

%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="bound_cd" value="I">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd %>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_edi" id="btn_edi">EDI File Download</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="40">VVD</th>
					<td width="120"><input type="text" style="width:100px; ime-mode: disabled" class="input1" dataformat="engup" maxlength="9" name="vvd"></td>
					<td width="10" rowspan="4"></td>
					<td width="60" rowspan="4">
						<div class="sm">
						<table>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="01I" class="trans" name="mf_tp_cd" id="01I" checked="checked"></td>
								<td><label for="01I">01I : List of Discharged Goods</label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="02I" class="trans" name="mf_tp_cd" id="02I"></td>
								<td><label for="02I">02I : List of	Transshipment Goods</label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="03I" class="trans" name="mf_tp_cd" id="03I"></td>
								<td><label for="03I">03I : List of Goods Retain on Board</label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="08X" class="trans" name="mf_tp_cd" id="08X"></td>
								<td><label for="08X">08X : Empty Container</label></td>
							</tr>
						</table>
						</div>
					</td>
					<td rowspan="4"></td>
				<tr>
					<td colspan="2"><table class="line_bluedot"><tr><td></td></tr></table></td>
				</tr>
				<tr>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:100px; ime-mode: disabled" class="input1" dataformat="engup" maxlength="5" name="pol_code"></td>
				</tr>
				<tr>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:100px; ime-mode: disabled" class="input1" dataformat="engup" maxlength="5" name="pod_code"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid">
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

</form>
