<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0219.jsp
*@FileTitle  : QTA Adjustment by VVD for IAS Sector
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.event.EsmCsq0219Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0219Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String login_ofc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.adjustment.qtaadjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		login_ofc_cd = account.getOfc_cd();

		event = (EsmCsq0219Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
	var login_ofc_cd = "<%=login_ofc_cd%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_gubun" value="HO" id="f_gubun" />
<input type="hidden" name="f_bse_tp_cd" value="Q" id="f_bse_tp_cd" />
<input type="hidden" name="f_qta_tgt_cd" value="D" id="f_qta_tgt_cd" />
<input type="hidden" name="f_crnt_qta_cd" id="f_crnt_qta_cd" />
<input type="hidden" name="f_crnt_bse_yr" id="f_crnt_bse_yr" />
<input type="hidden" name="f_fm_wk" id="f_fm_wk" />
<input type="hidden" name="f_to_wk" id="f_to_wk" />
<input type="hidden" name="f_trd_cd" id="f_trd_cd" value="IAS"/> 

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Creation" id="btn_Creation" type="button">Creation</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button>
	</div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="35">
				<col width="70">
				<col width="55">
				<col width="55">
				<col width="155">
				<col width="85">
				<col width="65">
				<col width="70">
				<col width="90">
				<col width="50">
				<col width="75">
				<col width="75">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Year</th>
					<td><script type="text/javascript">ComComboObject('f_bse_yr', 1, 60, 1, 1)</script></td>
					<th>Quarter</th>
					<td><script type="text/javascript">ComComboObject('f_bse_qtr_cd', 1, 50, 1, 1)</script></td>
					<td><div id="div_period"></div></td>
					<th>Sub Trade</th>
					<td><script type="text/javascript">ComComboObject('f_sub_trd_cd', 1, 60, 1)</script></td>
					<th>R/Lane</th>
					<td><script type="text/javascript">ComComboObject('f_rlane_cd', 1, 70, 1)</script></td>
					<th>Lane Bound</th>
					<td><script type="text/javascript">ComComboObject('f_dir_cd', 1, 70, 1)</script></td>
					<th> </th>
					<td> </td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
