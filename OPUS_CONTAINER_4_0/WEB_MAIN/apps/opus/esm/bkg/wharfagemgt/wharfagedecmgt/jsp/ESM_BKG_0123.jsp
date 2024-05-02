<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0123.js
*@FileTitle  : Wharfage Cargo Classification - Add Booking Data
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0123Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0123Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0123Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

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

<form name="form" method="post"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> <input type="hidden" name="attr_ctnt2">
  <%
	String vvd = (request.getParameter("vvd") == null) ? "" : request
			.getParameter("vvd");
	String portCd = (request.getParameter("port_cd") == null) ? ""
			: request.getParameter("port_cd");
	String whfBndCd = (request.getParameter("whf_bnd_cd") == null) ? ""
			: request.getParameter("whf_bnd_cd");
	String whfRate = (request.getParameter("whf_rate") == null) ? ""
			: request.getParameter("whf_rate");
	String blNo = (request.getParameter("bl_no") == null) ? ""
			: request.getParameter("bl_no");
	String bkgNo = (request.getParameter("bkg_no") == null) ? ""
			: request.getParameter("bkg_no");
	String popup = (request.getParameter("popup") == null) ? ""
			: request.getParameter("popup");
	String options = vvd + portCd + whfBndCd + "w" + whfRate;
 %>
<input type="hidden" name="vvd" value="<%=vvd%>">
<input type="hidden" name="port_cd" value="<%=portCd%>">
<input type="hidden" name="whf_bnd_cd" value="<%=whfBndCd%>">
<input type="hidden" name="whf_rate" value="<%=whfRate%>">
<input type="hidden" name="options" value="<%=options%>">
<input type="hidden" name="popup" value="<%=popup%>">

<!-- OUTER - POPUP (S)tart -->

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear ">
		<!-- page_title(S) -->
		<!-- <h2 class="page_title"><button type="button"><span id="title"></span></button></h2> -->
		<h2 class="page_title"><span>Wharfage Cargo Classification - Add Booking Data</span></h2>
		<!-- Wharfage Cargo Classification - Add Booking Data -->
		<!-- page_title(E) -->

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
				<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
				<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
				<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->

	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class="layer_popup_contents">
	<div class="opus_design_inquiry">
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 766px;">
					<tr class="h23">
						<td width="250px"><!-- : ( biz ) (S) -->
						<table border="0" style="width: 220px; background-color: white;"
							class="grid2">
							<tr>
								<td width="100px" class="tr2_head">B/L No.</td>
								<td width="125px" colspan="2" class="input1"><input
									class="noinput1" type="text" style="width: 100%" name="frm_bl_no"
									maxlength="12" dataformat="engup" value="<%=blNo%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Booking No.</td>
								<td width="" colspan="2" class="input1"><input
									class="noinput1" style="width: 100%; ime-mode: disabled"
									type="text" name="frm_bkg_no" maxlength="13" dataformat="engup"
									value="<%=bkgNo%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">VVD</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_vvd" dataformat="engup" maxlength="9"
									value="<%=vvd%>"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POL</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_pol_cd" dataformat="engup"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POD</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_pod_cd" dataformat="engup"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">POR</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_por_cd" dataformat="engup"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">DEL</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_del_cd" dataformat="engup"
									maxlength="5"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Booking<br>
								Status</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_bkg_sts_cd" dataformat="engup"
									maxlength="1"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">R/D</td>
								<td width="" colspan="2" align="center"><input
									class="noinput" type="text" style="width: 40px"
									name="frm_rcv_term_cd" dataformat="engup" maxlength="1"> <input
									class="noinput" type="text" style="width: 40px" name="frm_de_term_cd"
									dataformat="engup" maxlength="1"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Package</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 90px; text-align: right;"
									name="frm_pck_qty" dataformat="float" maxlength="16"
									onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 30px" name="frm_pck_tp_cd" dataformat="engup"
									maxlength="2"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Tran Mode</td>
								<td width="" colspan="2"><select style="width: 100%;"
									class="input" name="frm_whf_bnd_cd">
									<option value="II">II</option>
									<option value="IT">IT</option>
									<option value="OO">OO</option>
									<option value="OT">OT</option>
								</select></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Weight</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 100%" name="frm_act_wgt"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="22" onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 40px" name="frm_wgt_ut_cd" dataformat="engup"
									maxlength="3"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Measure</td>
								<td width="" align="right"><input class="noinput"
									type="text" style="width: 100%" name="frm_meas_qty"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="16" onkeyup="PointNumberFixed()"></td>
								<td width=""><input class="noinput" type="text"
									style="width: 40px" name="frm_meas_ut_cd" dataformat="engup"
									maxlength="3"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Revenue</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_revenue"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="23" onkeyup="PointNumberFixed()"></td>
							</tr>
							<tr>
								<td width="" class="tr2_head">Amount</td>
								<td width="" colspan="2"><input class="noinput" type="text"
									style="width: 100%" name="frm_amount"
									style="width:100%;text-align:right;" dataformat="float"
									maxlength="23" onkeyup="PointNumberFixed()"></td>
							</tr>
						</table>
						<!-- : ( biz ) (E) --></td>
						<td width="" valign="top"><!-- : ( Grid ) (S) -->

						<!-- opus_design_grid(S) -->
						<div class="opus_design_grid" id="mainTable" >
							<div class="opus_design_btn">
								<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
								<button type="button" class="btn_normal" name="btn_new1" id="btn_new1">New</button>
								<button type="button" class="btn_normal" name="btn_add1" id="btn_add1">Row Add</button>
								<button type="button" class="btn_normal" name="btn_del1" id="btn_del1">Row Delete</button>
							</div>
							<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
								<script language="javascript">ComSheetObject('sheet1');</script>
							<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
						</div>
						<!-- opus_design_grid(E) -->

						<!-- opus_design_grid(S) -->
						<div class="opus_design_grid" id="mainTable" >
							<div class="opus_design_btn">
								<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
								<button type="button" class="btn_normal" name="btn_new2" id="btn_new2">New</button>
								<button type="button" class="btn_normal" name="btn_add2" id="btn_add2">Row Add</button>
								<button type="button" class="btn_normal" name="btn_del2" id="btn_del2">Row Delete</button>
							</div>
							<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
								<script language="javascript">ComSheetObject('sheet2');</script>
							<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
						</div>
						<!-- opus_design_grid(E) -->

						<!-- opus_design_grid(S) -->
						<div class="opus_design_grid" id="mainTable" style="display:none">
							<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
							<script language="javascript">ComSheetObject('sheet3');</script>
							<!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
						</div>
						<!-- opus_design_grid(E) -->

					</td>
					</tr>
				</table>
			</td>
			</tr>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

</form>
