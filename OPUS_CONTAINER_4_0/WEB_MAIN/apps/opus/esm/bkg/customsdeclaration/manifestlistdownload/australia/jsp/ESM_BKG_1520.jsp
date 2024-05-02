<%
/* =========================================================
*Copyright(c) CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1520.js
*@FileTitle  : Aus DG EDI Transmit
*@author     : CLT
*@version    : 1.0
*@since      :
 ========================================================= */
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.event.EsmBkg1520Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1520Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strCnt_cd		= "";
	String strPort_cd		= "";

	String dType			= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration");


	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strPort_cd = strCnt_cd + strOfc_cd.substring(0, 3);


		event = (EsmBkg1520Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// 부모창에서 넘오온 파라메터 셋팅

		dType = JSPUtil.getParameter(request, "d_type");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		//loadPage("<%=dType%>");
		loadPage("ddd");
	}
</script>


<form name="form">
<input type="hidden" name="f_cmd" />
<input type="hidden" name="pagerows" />


<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>" />
<input type="hidden" name="trans_type" />
<input type="hidden" name="cond_type" /><!-- 입력 Validation type ("bl_no", "pol_cd", "pod_cd", "cntr_no") -->
<input type="hidden" name="cond_value" /><!-- 입력 Validation value -->
<input type="hidden" name="ui_type" value="ESM_BKG_1520" />
<input type="hidden" name="hid_d_type" />
<input type="hidden" name="hid_vvd_cd" />
<input type="hidden" name="d_type" value="D" />

<input type="hidden" name="init_d_type" value="<%=dType%>" />
<!-- 개발자 작업	-->

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button class="btn_normal" type="button" name="btn_new" id="btn_new">New</button><!--
		 --><button class="btn_normal" type="button" name="btn_edi_transmit" id="btn_edi_transmit">EDI Transmit</button><!--
		 --><button class="btn_normal" type="button" name="btn_edi_cancel" id="btn_edi_cancel">EDI Cancel</button><!--
		 --><button class="btn_normal" type="button" name="btn_down_excel" id="btn_down_excel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table style="width:800px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<td><table class="sm">
							<colgroup>
								<col />
								<col />
							</colgroup>
							<tbody>
								<tr>
									<th>Declaration&nbsp;&nbsp;</th>
									<td><input type="checkbox" name="d_type1" id="d_type1" value="D" class="trans" />Discharging&nbsp;&nbsp;<!--
										--><input type="checkbox" name="d_type2" id="d_type2" value="T" class="trans" />Transit&nbsp;&nbsp;<!--
										--><input type="checkbox" name="d_type3" id="d_type3" value="L" class="trans" />Loading&nbsp;&nbsp;<!--
										--><input type="checkbox" name="d_type4" id="d_type4" value="P" class="trans" />Pre-carriage&nbsp;&nbsp;<!--
										--><input type="checkbox" name="d_type5" id="d_type5" value="O" class="trans" />On-Carriage
									</td>
								</tr>
							</tbody>
						</table>
					</td>
					<th>VVD</th>
					<td><input type="text" style="width:80px; ime-mode: disabled" class="input1" name="vvd_cd" id="vvd_cd" dataformat="engup" required maxlength="9" fullfill caption="VVD" /></td>
					<th>Port</th>
					<td><input type="text" style="width:50px;" class="input1" name="port_cd" id="port_cd" style="ime-mode: disabled"  dataformat="engup" required maxlength="5" fullfill caption="Port" /></td>
					<th>Sent</th>
					<td><select name="search_type" id="search_type">
							<option value="A" selected>ALL</option>
							<option value="Y">Yes</option>
							<option value="N">No</option>
						</select>
					</td>
				</tr>
			</tbody>
		</table>
		<table style="width:800px;">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Arrival</th>
					<td><input type="text" style="width:80px;" class="input2" name="frm_eta_d" id="frm_eta_d" readonly /><!--
					 --><input type="text" style="width:45px;" class="input2" name="frm_eta_t" id="frm_eta_t" readonly />
					</td>
					<th>Departure</th>
					<td><input type="text" style="width:80px;" class="input2" name="frm_etd_d" id="frm_etd_d" readonly /><!--
					 --><input type="text" style="width:45px;" class="input2" name="frm_etd_t" id="frm_etd_t" readonly />
					</td>
					<th>Berth</th>
					<td><input type="text" style="width:70px;" class="input2" name="frm_brth_yd_cd" id="frm_brth_yd_cd" readonly>&nbsp;/&nbsp;
						<input type="text" style="width:200px;" class="input2" name="frm_yd_nm" id="frm_yd_nm" readonly />
					</td>
				</tr>
				<tr>
					<th>Vessel Flag/Call Sign</th>
					<td><input type="text" style="width:80px;" class="input2" name="frm_vsl_cnt_cd" id="frm_vsl_cnt_cd" readonly /><!--
					 --><input type="text" style="width:70px;" class="input2" name="frm_call_sgn_no" id="frm_call_sgn_no" readonly />
					</td>
					<th>Vessel Code</th>
					<td><input type="text" style="width:80px;" dataformat="engup" class="input2" name="frm_vsl_cd" id="frm_vsl_cd" readonly /></td>
					<th>Vessel Name</th>
					<td><input type="text" style="width:100%; " class="input2" name="frm_vsl_eng_nm" id="frm_vsl_eng_nm" readonly /></td>
				</tr>
				<tr>
					<th>Reason of<br>Re-sending</th>
					<td><script language="javascript">ComComboObject("reason_resending", 1, 130, 1);</script></td>
					<th>Lloyd code</th>
					<td><input type="text" style="width:80px;" class="input2" name="frm_lloyd_no" id="frm_lloyd_no" readonly /></td>
					<th>Total Container</th>
					<td><input type="text" style="width:100px; ime-mode: disabled; text-align:Center" class="input2" name="cntr_cnt" id="cntr_cnt" readOnly="true" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<!--Hidden Grid (S)-->
		<script type="text/javascript">ComSheetObject("sheet1");</script>
		<!--Hidden Grid (E)-->
		<!-- Grid (S) -->
		<script type="text/javascript">ComSheetObject("sheet2");</script>
		<!-- Grid (E) -->
	</div>
	<!-- opus_design_grid(S) -->
</div>


<!-- 임시 (S)-->
<table style="display:none;">
	<tr>
		<td>Flat File</td>
		<td>Original Update Flat File</td>
		<td>Cancel Flat File</td>
	</tr>
	<tr>
		<td><textarea name="output1" cols="180" rows="20"></textarea></td>
		<td><textarea name="output2" cols="60" rows="20"></textarea></td>
		<td><textarea name="output3" cols="90" rows="20"></textarea></td>
	</tr>
</table>
</form>
