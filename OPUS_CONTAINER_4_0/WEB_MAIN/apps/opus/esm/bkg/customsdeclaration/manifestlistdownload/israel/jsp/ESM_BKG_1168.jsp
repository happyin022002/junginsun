<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1168.jsp
*@FileTitle  : ESM_BKG_1168
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1168Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1168Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strPgmNo			= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg1168Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
		
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="call_type" value="ESM_BKG_1168" id="call_type" />
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>" id="pgmNo" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">EDI Transmit</button>	
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
   	<div class="location">
        <span id="navigation"></span>
   	</div>
   	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class= "wrap_search">
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="100">
				<col width="50">
				<col width="70">
				<col width="50">
				<col width="70">
				<col width="60">
				<col width="*">
		    </colgroup>
		    <tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" style="width:90px; ime-mode: disabled;" value="" class="input1" name="vvd_cd" id="vvd_cd" dataformat="engup" required maxlength="9" caption="VVD">
					</td>
					<th title="Port of Loading">POL</th>
					<td>
						<input type="text" style="width:60px;ime-mode: disabled;" value="" class="input1"  name="pol_cd" id="pol_cd" dataformat="engup" required maxlength="5" caption="POL">
					</td>
					<th title="Port of Discharging">POD</th>
					<td>
						<input type="text" style="width:60px;ime-mode: disabled;" value="" class="input"  name="pod_cd" id="pod_cd" dataformat="engup" maxlength="5" caption="POD">
					</td>
					<th>B/L No.</th>
					<td>
						<input type="text" style="width:100px; ime-mode: disabled;" value="" class="input" name="bl_no" id="bl_no" dataformat="engup" maxlength="12" caption="B/L No.">
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class= "opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70"/>
				<col width="*"/>
		    </colgroup>
		    <tbody>
				<tr>
			   	    <td><input type="radio" name="p_ori_amd_cd"  id="radio_p_ori_amd_cd" value="O" class="trans" checked><label for="radio_p_ori_amd_cd">Original</label></td>
					<td><input type="radio" name="p_ori_amd_cd"  id="radio_p_ori_amd_cd2"  value="U" class="trans"><label for="radio_p_ori_amd_cd2">Update</label></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="80">
				<col width="150">
				<col width="80">
				<col width="70">
				<col width="120">
				<col width="60">
				<col width="50">
				<col width="130">
				<col width="50">
				<col width="*">
		    </colgroup>
		    <tbody>
				<tr>
					<th>Vessel Name</th>
					<td>
						<input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="vvd_nm" readonly="" id="vvd_nm" />
					</td>
					<th>Vessel LLOYD</th>
					<td>
						<input type="text" style="width:60px; ime-mode: disabled;" value="" class="input2" name="vvd_ld" readonly="" id="vvd_ld" />
					</td>
					<th>Vessel Call Sign</th>
					<td>
						<input type="text" style="width:50px; ime-mode: disabled;" value="" class="input2" name="vvd_call" readonly="" id="vvd_call" />
					</td>
					<th>ETA</th>
					<td>
						<input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="eta" readonly="" id="eta" />
					</td>
					<th>ETD</th>
					<td>
						<input type="text" style="width:120px; ime-mode: disabled;" value="" class="input2" name="etd" readonly="" id="etd" />
					</td>
				</tr>
			</tbody>	
		</table>
	</div>
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid" id="mainTable"  style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>