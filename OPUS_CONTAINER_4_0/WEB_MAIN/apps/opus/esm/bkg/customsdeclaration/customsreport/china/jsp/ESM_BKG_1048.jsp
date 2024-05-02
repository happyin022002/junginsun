<%--
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1048.jsp
*@FileTitle  : China: Customs Result View
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/20
=========================================================*/
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	Exception serverException   = null;         //occurring error in server
	String strErrMsg = "";                      //error message
	int rowCount     = 0;                       //list count of DB ResultSet

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String rcv_snd_div_cd = "";
	String sheet_msg_snd_dt = "";
	String sheet_bl_no = "";
	String strUsr_id        = "";
	String strUsr_nm        = "";
	String edi_ref_id       = "";
	String vvd_cd           = "";
	String pol_cd           = "";
	String pod_cd           = "";
	//Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
		//SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//strUsr_id =   account.getUsr_id();
		//strUsr_nm = account.getUsr_nm();

		edi_ref_id = JSPUtil.getParameter(request, "edi_ref_id");
		vvd_cd = JSPUtil.getParameter(request, "vvd_cd");
		pol_cd = JSPUtil.getParameter(request, "pol_cd");
		pod_cd = JSPUtil.getParameter(request, "pod_cd");

		//serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		//if (serverException != null) {
		//  strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		//}

		//When initial screen loading, adding logic extrat data obtained from the server.
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="edi_ref_id" value="<%=edi_ref_id%>">
<input type="hidden" name="vvd_cd" value="<%=vvd_cd%>">
<input type="hidden" name="pol_cd" value="<%=pol_cd%>">
<input type="hidden" name="pod_cd" value="<%=pod_cd%>">

<!-- layer_popup_title(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>China: Customs Result View</span></h2>
		<!-- page_title(E) -->

		<!-- btn_div(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_excel" id="btn_excel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- btn_div(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry">
		<!--  biz_1 (S) -->
		<table>
			<colgroup>
				<col width="40px"  />
				<col width="120px" />
				<col width="40px"  />
				<col width="120px" />
				<col width="40px"  />
				<col width=""      />
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;" class="input2" value="<%=vvd_cd%>" disabled="disabled"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:80px;" class="input2" value="<%=pol_cd%>" disabled="disabled"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:80px;" class="input2" value="<%=pod_cd%>" disabled="disabled"></td>
				</tr>
			</tbody>
		</table>
		<!--  biz_1   (E) -->
	</div>
	<!-- inquiry_area(E) -->
</div>
<div class="wrap_result">
	 <div class="opus_design_inquiry"><span>* Beijing Standard Time (GMT +08:00)</span></div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table style="width:450px;">
			<colgroup>
				<col width="70px"  />
				<col width="120px" />
				<col width="110px" />
				<col width=""      />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L Count</th>
					<td ><input type="text" name="bl_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
					<th> Container Count</th>
					<td><input type="text" name="cntr_cnt" style="width:80px;text-align:right;" class="input2" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- layer_popup_contents(E) -->
</form>
