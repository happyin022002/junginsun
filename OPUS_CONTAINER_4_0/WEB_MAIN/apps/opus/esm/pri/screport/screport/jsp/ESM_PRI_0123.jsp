<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0140.js
*@FileTitle  : MOT/SSE Filing Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.screport.screport.event.EsmPri0123Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0123Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCReport.SCReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0123Event)request.getAttribute("Event");
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
<input type="hidden" name="lane_list" id="lane_list" />
<input type="hidden" name="inq_tp_cd" id="inq_tp_cd" />
<input type="hidden" name="col_nm" id="col_nm" />
<input type="hidden" name="col_title" id="col_title" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Downexcel" id="btn_Downexcel" type="button">Down Excel</button><!--
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
			<col width="70" />
			<col width="208" />
			<col width="20" />
			<col width="80" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr class="h23">
				<th>Filing Date</th>
				<td>
				<input type="text" caption="Filing From Date" style="width:75px;text-align:center;" class="input1" name="fr_file_dt" cofield="to_file_dt" dataformat="ymd" maxlength="10" minlength="8"  required="" id="fr_file_dt" />&nbsp;~&nbsp;
                <input type="text" caption="Filing To Date" style="width:75px;text-align:center;" class="input1" name="to_file_dt" cofield="fr_file_dt" dataformat="ymd" maxlength="10" minlength="8"  required="" id="to_file_dt" /><!-- --><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button>
                </td>
				<th>&nbsp;</th>
				<th>Inquiry Type</th>
				<td width="*" class="wAuto" style="font-size:12;" id="rdoTpCd">
					<input type="radio" name="inq_tp_rdo" value="1" class="trans" checked id="inq_tp_rdo" />&nbsp;Daily Log
					<input type="radio" name="inq_tp_rdo" value="2" class="trans" id="inq_tp_rdo" />&nbsp;Daily Log with Booking No
					<input type="radio" name="inq_tp_rdo" value="3" class="trans" id="inq_tp_rdo" />&nbsp;File</td>
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
<!-- opus_design_grid(S) -->
<div class="hiddenSheetLayer" style="display: none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<div class="hiddenSheetLayer" style="display: none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
</form>
