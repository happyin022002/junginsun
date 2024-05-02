<%
/*=========================================================
*Copyright(c) 2015 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0011.js
*@FileTitle  : Target VVD Fix_Disable Pop up
*@author     : CLT
*@version    : 1.0
*@since      : 2015/01/20
=========================================================*/ 
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.basicdata.event.EsmCsq0011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCsq0011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String trdCd = "";
	String laneCd = "";
	String dirCd = "";
	String subTrdCd = "";
	String bseYr = "";
	String bseQtrCd = "";
	String divPeriod = "";
	String bseTpCd = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.basicdata");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmCsq0011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		trdCd = JSPUtil.getNull(request.getParameter("f_trd_cd"));
		laneCd = JSPUtil.getNull(request.getParameter("f_rlane_cd"));
		dirCd = JSPUtil.getNull(request.getParameter("f_dir_cd"));
		
		subTrdCd = JSPUtil.getNull(request.getParameter("f_sub_trd_cd"));
		bseYr = JSPUtil.getNull(request.getParameter("f_bse_yr"));
		bseQtrCd = JSPUtil.getNull(request.getParameter("f_bse_qtr_cd"));
		divPeriod = JSPUtil.getNull(request.getParameter("div_period"));
		bseTpCd = JSPUtil.getNull(request.getParameter("f_bse_tp_cd"));
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
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

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Target VVD Fix Disable</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_apply" id="btn_apply" type="button">Lane Disable Apply</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="95">
					<col width="40">
					<col width="65">
					<col width="80">
					<col width="60">
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th class="sm pad_left_4" style="text-align: left"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd1" class="trans" value="Y" <%=bseTpCd.equals("Y")? "checked":"" %>><label for="f_bse_tp_cd1" style="padding-left:2;">Yearly</label></th>
						<th>Year</th>
						<td><input type="text" style="width:50px; text-align:center; ime-mode:disabled" name="f_bse_yr" id="f_bse_yr" class="input2" maxlength="20" readOnly value="<%=bseYr%>"></td>
						<th><div id="div_qtr">Quarter</div></th>
						<td><input type="text" style="width:50px; text-align:center; ime-mode:disabled" name="f_bse_qtr_cd" id="f_bse_qtr_cd" class="input2" maxlength="20" readOnly value="<%=bseQtrCd%>"></td>
						<td><div id="div_period"><%=divPeriod%></div></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="95">
					<col width="40">
					<col width="65">
					<col width="80">
					<col width="60">
					<col width="75">
					<col width="80">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th class="sm pad_left_4" style="text-align: left"><input type="radio" name="f_bse_tp_cd" id="f_bse_tp_cd2" class="trans" value="Q" <%=bseTpCd.equals("Q")? "checked":"" %>><label for="f_bse_tp_cd2" style="padding-left:2;">Quarterly</label></th>
						<th>Trade</th>
						<td><input type="text" style="width:50px; text-align:center; ime-mode:disabled" name="f_trd_cd" id="f_trd_cd" class="input2" maxlength="20" readOnly value="<%=trdCd%>"></td>
						<th>Lane Bound</th>
						<td><input type="text" style="width:50px; text-align:center; ime-mode:disabled" name="f_dir_cd" id="f_dir_cd" class="input2" maxlength="20" readOnly value="<%=dirCd%>"></td>
						<th>Sub Trade</th>
						<td><input type="text" style="width:65px; text-align:center; ime-mode:disabled" name="f_sub_trd_cd" id="f_sub_trd_cd" class="input2" maxlength="20" readOnly value="<%=subTrdCd%>"></td>
						<th>R/Lane</th>
						<td><input type="text" style="width:65px; text-align:center; ime-mode:disabled" name="f_rlane_cd" class="input2" maxlength="20" readOnly value="<%=laneCd%>"></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>