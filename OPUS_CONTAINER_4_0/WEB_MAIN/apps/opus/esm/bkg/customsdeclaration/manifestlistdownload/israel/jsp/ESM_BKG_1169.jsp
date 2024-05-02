<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1169.jsp
*@FileTitle  : ESM_BKG_1169
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/02
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.israel.event.EsmBkg1169Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1169Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	   
		event = (EsmBkg1169Event)request.getAttribute("Event");
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
<input type="hidden" name="cond_gubun" value="1" id="cond_gubun" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_exceldown" id="btn_exceldown" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

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
	<table>
		<colgroup>
			<col width="140" />
			<col width="220" />
			<col width="70" />
			<col width="130" />
			<col width="25" />
			<col width="120" />
			<col width="25" />
			<col width="90" />
			<col width="25" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr class="h23">
				<td style="padding-left:5px;"><input type="radio" name="gubun" value="1" class="trans" checked="" id="gubun" /><strong><label for="gubun">Acknowledge Date</label></strong></td>
				<td><input type="text" style="width: 80px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" name="s_vps_eta_dt" caption="ETA" cofield="e_vps_eta_dt" id="s_vps_eta_dt" /><!-- 
			 --><span class="dash">~</span><input type="text" style="width: 80px; ime-mode: disabled" class="input1" maxlength="10" dataformat="ymd" name="e_vps_eta_dt" caption="ETA" cofield="s_vps_eta_dt" id="e_vps_eta_dt" /><!-- 
				 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button>
				</td>
				<td><input type="radio" name="gubun" value="2" class="trans" id="gubun1" /><strong><label for="gubun1">BL No.</label></strong></td>
				<td><input type="text" style="width:100px; ime-mode:disabled" name="bl_no" class="input1" dataformat="engup" maxlength="12" disabled id="bl_no" /></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:90px; ime-mode:disabled" name="vvd" class="input" dataformat="engup" maxlength="9" caption="VVD" id="vvd" /></td>
				<th title="Port of Loading">POL</th>
				<td>
					<input type="text" style="width:60px; ime-mode:disabled" name="pol_cd" class="input" dataformat="engup" maxlength="5" caption="POL" id="pol_cd" />
				</td>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" style="width:60px; ime-mode:disabled" name="pod_cd" class="input" dataformat="engup" maxlength="5" caption="POD" id="pod_cd" />
				</td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->

<!-- wrap_result(S) -->
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>

