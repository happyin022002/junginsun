<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0740.jsp
*@FileTitle  : Group Update for B/L Issue And Onboard Date
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.apps.opus.esm.bkg.common.HTMLUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0740Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0740Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_id        = "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_id = account.getOfc_cd();

		event = (EsmBkg0740Event)request.getAttribute("Event");
		
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="eta" id="eta" value="<%=JSPUtil.getParameter(request, "eta", "")%>">
<input type="hidden" name="etd" id="etd" value="<%=JSPUtil.getParameter(request, "etd", "")%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>B/L Issue & On-Board Date Adjust</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" 		class="btn_accent" id="btn_save"    name="btn_save">Ok</button><!-- 
			 --><button type="button" 	    class="btn_normal"  id="btn_close" name="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table id="mainTable">
				<tbody>
					<colgroup>
						<col width="120">
						<col width="*">
				    </colgroup>
				    <tbody>
						<tr>
							<th><input type="checkbox" name="ob_chk" id="ob_chk" class="trans" checked><label for="ob_chk">On-Board Date</label></th>
							<td><input type="text" name="ob_date" id="ob_date" value="" dataformat="ymd" size="10"><!-- 
								 --><button type="button" class="calendar ir" name="img_ob_cal" id="img_ob_cal" ></button>
							</td>
						</tr> 
					</tbody>
			</table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<table>
				<tbody>
					<colgroup>
						<col width="120">
						<col width="*">
				    </colgroup>
				    <tbody>
						<tr>
							<th><input type="checkbox" name="issue_chk" id="issue_chk" class="trans" checked><label for="issue_chk">B/L Issue Date</label></th>
							<td><input type="text" name="issue_date" id="issue_date" value="" dataformat="ymd" size="10" ><!-- 
							 --><button type="button" class="calendar ir" name="img_issue_cal" id="img_issue_cal" ></button>
						</tr> 
				</tbody>
			</table>
			<table> 
				<tbody>
					<colgroup>
						<col width="40">
						<col width="50">
						<col width="30">
						<col width="80">
						<col width="80">
						<col width="*">
				    </colgroup>
				    <tbody>
						<tr>
							<th>AT</th>
							<td><input type="text" name="ussue_at" id="ussue_at" maxlength="6" value="<%=strOfc_id%>" style="ime-mode:disabled;width:50px" class="input"></td>
							<th>BY</th>
							<td><input type="text" name="ussue_by" id="ussue_by" maxlength="20" value="<%=strUsr_id%>" style="ime-mode:disabled;width:80px;" class="input"></td>
							<th><label for="credit_chk">PPD Credit</label><input type="checkbox" name="credit_chk" id="credit_chk" class="trans"></th>
							<td></td>
						</tr> 
					</tbody>
				</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
</div>
</form>