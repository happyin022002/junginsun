<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_CSQ_0014.jsp
*@FileTitle  : Basic CMCB_New Lane Cost IF
*@author     : CLT
*@version    : 1.0
*@since      : 2015/02/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.csq.datamanage.costmanage.event.EsmCsq0014Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String p_bse_tp_cd  = JSPUtil.getParameter(request, "f_bse_tp_cd", "");
	String p_bse_yr     = JSPUtil.getParameter(request, "f_bse_yr", "");
	String p_bse_qtr_cd = JSPUtil.getParameter(request, "f_bse_qtr_cd", "");
	String div_period   = JSPUtil.getParameter(request, "div_period", "");
	EsmCsq0014Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.datamanage.costmanage");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmCsq0014Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var curTitle = "Basic CMCB_New Lane Cost IF";
	var curDescription = "Basic CMCB_New Lane Cost IF";
	var p_bse_tp_cd = "<%=p_bse_tp_cd%>";

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
<!-- 개발자 작업	-->

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Basic CMCB New Lane Cost IF</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Apply" id="btn_Apply" type="button">New Setting Apply</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
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
					<col width="80">
					<col width="80">
					<col width="50">
					<col width="50">
					<col width="60">
					<col width="50">
					<col width="50">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<td class="sm"><input type="radio" class="trans" name="f_bse_tp_cd" id="f_bse_tp_cd_y" value="Y" disabled=""/><label for="f_bse_tp_cd_y"><strong>&nbsp;Yearly</strong></label></td>
						<td class="sm"><input type="radio" class="trans" name="f_bse_tp_cd" id="f_bse_tp_cd_q" value="Q" disabled=""/><label for="f_bse_tp_cd_q"><strong>Quarterly</strong></label></td>
						<th>Year</th>
						<td><input type="text" style="text-align:center;" class="input2" size="4" name="f_bse_yr" value="<%=p_bse_yr%>" readonly id="f_bse_yr" /></td>
						<th><div id="div_qtr">Quarter</div></th>
						<td><input type="text" style="text-align:center;" class="input2" size="3" name="f_bse_qtr_cd" value="<%=p_bse_qtr_cd%>" readonly id="f_bse_qtr_cd" /></td>
						<td colspan="2"><div id="div_period"></div></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

</form>