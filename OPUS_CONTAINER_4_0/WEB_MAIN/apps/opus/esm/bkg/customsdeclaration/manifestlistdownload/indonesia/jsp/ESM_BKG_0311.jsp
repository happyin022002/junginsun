<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0311.jsp
*@FileTitle  : Indonesia Customs Manifest
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event.EsmBkg0311Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>

<%
	EsmBkg0311Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd = "";

	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.customsdeclaration.manifestListDownload.indonesia");

	String bkg_no = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg0311Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	}catch(Exception e) {
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


<form name="form" method="post" id="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_ofc_cd" value="<%=strOfc_cd %>">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="strBkgNo">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="vvd_nm">
<input type="hidden" name="bound_cd" value="O">
<input type="hidden" name="where_query">
<input type="hidden" name="pg_no" value="esm0311">


<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button">
			<span>Customs EDI (O/B)</span>
		</button>
	</h2>
	<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save"   id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Excel Down</button><!--
			--><button type="button" class="btn_normal" name="btn_edi"   id="btn_edi">EDI File Download</button>
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
					<td width="120">
						<input name="vvd" id="vvd" type="text" style="width:110px" maxlength="9" dataformat="engup" style="ime-mode:disabled" class="input1">
					</td>
					<td width="10" rowspan="4"></td>
					<td width="60" rowspan="4">
						<div class="sm">
						<table>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="09E" name="mf_tp_cd" id="mf_tp_cd_09E" checked="checked"></td>
								<td><label for="mf_tp_cd_09E">09E : Goods Loaded and registered at the same Customs Offices</label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="10E" name="mf_tp_cd" id="mf_tp_cd_10E"></td>
								<td><label for="mf_tp_cd_10E">10E : Goods Loaded and registered at different Customs office</label></td>
							</tr>
							<tr>

								<td width="30" class="align_center"><input type="radio" value="04E" name="mf_tp_cd" id="mf_tp_cd_04E" ></td>
								<td><label for="mf_tp_cd_04E">04E : Transshipment Goods </label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="05E" name="mf_tp_cd" id="mf_tp_cd_05E" ></td>
								<td><label for="mf_tp_cd_05E">05E : Goods Retain on Board  </label></td>
							</tr>
							<tr>
								<td width="30" class="align_center"><input type="radio" value="08X" name="mf_tp_cd" id="mf_tp_cd_08X" ></td>
								<td><label for="mf_tp_cd_08X">08X : Empty Container </label></td>
							</tr>
						</table>
						</div>
					</td>
					<td rowspan="4"></td>
				<tr>
					<th width="40">POL</th>
					<td>
						<input name="pol_code" id="pol_code" type="text" style="width:110px" maxlength="5" dataformat="engup" style="ime-mode:disabled" class="input1">
					</td>
				</tr>
				<tr>
					<th width="40">POD</th>
					<td>
						<input name="pod_code" id="pod_code" type="text" style="width:110px" maxlength="5" dataformat="engup" style="ime-mode:disabled" class="input1">
					</td>
				</tr>
				<tr>
					<th width="80">Booking No.</th>
					<td>
						<input name="bkg_no" id="bkg_no" type="text" maxlength="13" dataformat="engup" style="ime-mode:disabled;width:110px;" class="input">
						<div id="layList" name="layList" style="position:absolute;z-index:999;display:none;"></div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid"  id="mainTable">

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 그리드 버튼 영역(데이터 그리드 상단에 위치) -->
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Row Delete</button>
		</div>
		<!-- opus_design_btn(E) -->


		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
		<script language="javascript">ComSheetObject('sheet2');</script>
		<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->

	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
