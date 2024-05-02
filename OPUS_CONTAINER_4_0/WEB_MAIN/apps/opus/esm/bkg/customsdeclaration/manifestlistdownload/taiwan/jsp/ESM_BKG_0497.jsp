<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0497.jsp
*@FileTitle : Taiwan Customs EDI
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.taiwan.event.EsmBkg0497Event"%><%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0497Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		//event = (EsmBkg0440Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="frm_vsl_cd">
<input type="hidden" name="frm_skd_voy_no">
<input type="hidden" name="frm_skd_dir_cd">
<input type="hidden" name="vvd_nm">


	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>

	<!-- page_title(E) -->


			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_edi" id="btn_edi">EDI Transmit</button>
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
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<table style="width:400px">
			<colgroup>
				<col width="50px" />
				<col />
				<col width="50px" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input name="frm_vvd_number" style="ime-mode: disabled; width:100px" id="frm_vvd_number" maxlength="9" required caption="VVD" dataformat="engup" type="text" class="input1"></td>
					<th title="I/O Bound">I/O Bound</th>
					<td><select class="input1" name="frm_io_bnd_cd" id="frm_io_bnd_cd" style="width:100px;">
							<option value="I" selected>Inbound</option>
							<option value="O">Outbound</option>
						</select></td>
				</tr>
			</tbody>
		</table>


		<table style="width:300px">
			<colgroup>
				<col width="50px" />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th title="Port of Loading">POL</th>
					<td>
						<input name="frm_pol_cd" id="frm_pol_cd" maxlength="5" dataformat="engup" type="text" style="width:60px;ime-mode: disabled" class="input" caption="POL">
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input name="frm_pod_cd" id="frm_pod_cd" maxlength="5" dataformat="engup" type="text" style="width:60px;ime-mode: disabled" class="input1" required caption="POD">
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
	<div class="opus_design_grid">
		<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
		<script language="javascript">ComSheetObject('sheet1');</script>
		<!-- 그리드 데이터 영역 [Table]z(E) (기존 As-is 구조에서 변경되는 사항 없음) -->
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>