<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0203.jsp
*@FileTitle  : Tire Purchase Report by Supplier 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMnr0203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<!-- page_title_area(S) -->
	<div class="page_title_area clear">

	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->

	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_new"   id="btn_new">New</button>
		<button type="button" class="btn_normal" name="btn_downexcel"   id="btn_downexcel">Down&nbsp;Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->

<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<table>
		 <colgroup>
			<col width="1" />
			<col width="130" />
			<col width="80" />
			<col width="" />
		</colgroup> 
		<tbody>
			<tr class="h23">
				<th>Period</th>
				<td colspan="3">
					<input type="text" style="width:80px;text-align:center" class="input1" name="from_dt" id="from_dt" dataformat="ymd" maxlength="10" >&nbsp;~&nbsp;<!--  
					--><input type="text" style="width:80px;text-align:center" class="input1" name="to_dt" id="to_dt" dataformat="ymd" maxlength="10" ><button type="button" class="calendar ir" name="cre_dt_cal" id="cre_dt_cal"></button>
				</td>
			</tr>
			<tr class="h23">
				<th>Office</th>
				<td>
					<input type="text" style="width:80px;" class="input" value="" name="ofc_cd" id="ofc_cd" maxlength=7 dataformat="engup"><button type="button" class="input_seach_btn" name="btn_ofc_cd" id="btn_ofc_cd"></button>
				</td>
				<th>Supplier</th>
				<td>
					<input type="text" name="sup_cd" id="sup_cd" style="width:65px;text-align:center" class="input" dataformat="engup" maxlength="8" readOnly="true"><button type="button" class="input_seach_btn" name="btn_sup_cd" id="btn_sup_cd"></button><input type="text" name="sup_nm" id="sup_nm" style="width:152px;" class="input2" readOnly="true">
				</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
    <!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
	<script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
</div>	
<!-- opus_design_grid(E) -->

<!-- Developer's task  -->
</form>