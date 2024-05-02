<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1047.jsp
*@FileTitle  : China: Transmit & Receive History
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1047Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date"%>

<%
	EsmBkg1047Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	//int rowCount = 0; //DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList = "";
	//String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String toDate = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");

		event = (EsmBkg1047Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

	}catch(Exception e) {
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

	<!-- page_title_area(S) -->
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<h2 class="page_title">
			<button type="button">
				<span>China: Transmit & Receive History</span>
			</button>
		</h2>
		<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
		   <div class="opus_design_btn">
				<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
				--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
				--><button class="btn_normal" name="btn_excel" id="btn_excel" type="button">Down Excel</button><!--
				--><button class="btn_normal" name="btn_view" id="btn_view" type="button">View Result</button>
			</div>
			<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="160" />
					<col width="70" />
					<col width="70" />
					<col width="100" />
					<col width="50" />
					<col width="130" />
					<col width="200" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><strong>MSG TYPE</strong></td>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:78px;" class="input" dataformat="engup" name="vvd_cd" maxlength="9" id="vvd_cd" /></td>
						<th title="Port of Loading">POL</th>
						<td><input type="text" style="width:78px;" class="input" dataformat="engup" name="pol_cd" maxlength="5" id="pol_cd" /></td>
						<th title="Port of Discharging">POD</th>
						<td><input type="text" style="width:78px;" class="input" dataformat="engup" name="pod_cd" maxlength="5" id="pod_cd" /></td>
						<td><input type="checkbox" class="trans" name="date_check" checked="" id="date_check" /><!--
							--><label for="date_check"><strong>Send Date</strong></label>
						</td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="160" />
					<col width="63" />
					<col width="70" />
					<col width="100" />
					<col width="50" />
					<col width="130" />
					<col width="200" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td>
							<select class="input1" name="send_indicator">
							<option value="%" selected>ALL</option>

							<option value="O9">O1: Original(POL)</option>
							<option value="O5">O1: Change</option>
							<option value="O3">O1: Delete</option>

							<option value="D9">O2: Other Original(POD)</option>
							<option value="D5">O2: Change</option>
							<option value="D3">O2: Delete</option>
							<option value="D0">O2: Secondly</option>

							<option value="P9">P1: Pre-Stowage</option>
							<option value="P5">P1: Change</option>
							<option value="P3">P1: Delete</option>
							</select>
						</td>
						<th>RHQ</th>
						<td><input type="text" style="width:78px;" name="rhq_ofc_cd" maxlength="6" dataformat="enguponly" class="input" id="rhq_ofc_cd" /></td>
						<th>OFFICE</th>
						<td><input type="text" style="width:78px;" name="ofc_cd" maxlength="6" dataformat="enguponly" class="input" id="ofc_cd" /></td>
						<th>USER ID</th>
						<td><input type="text" style="width:78px;" name="usr_id" maxlength="20" dataformat="engup" class="input" id="usr_id" /></td>
						<td><input type="text" style="width:80px;" value="<%=toDate%>" maxlength="10" dataformat="ymd" class="input" name="start_snd_dt" caption="Send Date" cofield="end_snd_dt" id="start_snd_dt" /><!--
							--><input type="text" style="width:40px;" dataformat="hm" value="00:00" name="start_snd_dt2" class="input" maxlength="5" id="start_snd_dt2" /><!--
							--><span class="dash"> ~ </span><!--
							--><input type="text" style="width:80px;" value="<%=toDate%>" maxlength="10" name="end_snd_dt" dataformat="ymd" class="input" caption="Send Date" cofield="start_snd_dt" id="end_snd_dt" /><!--
							--><input type="text" style="width:40px;" dataformat="hm" value="23:59" name="end_snd_dt2" class="input" maxlength="5" id="end_snd_dt2" /><!--
							--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">

			<div class="pad_4">* Beijing Standard Time (GMT +08:00)</div>

			<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
			<script language="javascript">ComSheetObject('sheet1');</script>
			<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</form>