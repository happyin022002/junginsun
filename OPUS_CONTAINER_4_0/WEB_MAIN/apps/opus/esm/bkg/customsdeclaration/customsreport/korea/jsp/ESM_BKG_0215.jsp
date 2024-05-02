<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0215.jsp
*@FileTitle  : DownLoad History 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/21
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.korea.event.EsmBkg0215Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0215Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	// error from server
	String strErrMsg 			= "";	// error message
	int rowCount	 			= 0;	// count of DB resultSET list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";
	String strUsr_id	= "";
	String strUsr_nm	= "";

	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0215Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

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
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_downexcel">Down Excel</button>
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
<!-- wrap_search(S) -->  
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
    <!-- 조회영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <table>
		<tbody>
			<tr>
				<td width="60"><label for="rad_mrn"><strong>MRN</strong></label><input type="radio" name="rad_mrn" id="rad_mrn" checked></td>
				<td width="120"><input type="text" class="input1" style="width:100px; text-align:center;" dataformat="engup" caption="MRN No" name="txt_mrn"></td>
				<td width="60"><label for="rad_vvd"><strong>VVD</strong></label><input type="radio" name="rad_vvd" id="rad_vvd"></td>
				<td width="120"><input type="text" class="input2" style="width:90px; text-align:center;" maxlength="9" value="" dataformat="engup" caption="VVD" name="txt_vvd" readOnly></td>
				<th width="35">POL</th>
				<td width="100"><input type="text" class="input2" style="width:70px; text-align:center;" maxlength="5" value="" dataformat="engup" caption="POL" name="txt_pol" readOnly></td>
				<th width="35">POD</th>
				<td width="100"><input type="text" class="input2" style="width:70px; text-align:center;" maxlength="5" value="" dataformat="engup" caption="POD" name="txt_pod" readOnly></td>
				<td width="60"><label for="rad_dat"><strong>Date</strong></label><input type="radio" name="rad_dat" id="rad_dat"></td>
				<td>
					<span class="inquiry_calendar">					
					<input type="text" style="width: 75px; ime-mode: disabled; text-align:center;" class="input2" dataformat="ymd" name="date_from" caption="FromDate" cofield="date_to">
			       	~
					<input type="text" style="width: 75px; ime-mode: disabled; text-align:center;" class="input2" dataformat="ymd" name="date_to" caption="ToDate" cofield="date_from"><!--						
					--><button type="button" class="calendar" name="btn_calendar" id="btn_calendar"></button>
			      	</span>					
				</td>
			</tr>
		</tbody>
	</table>
	<!-- 조회영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_inquiry(E) -->
</div>	
<!-- wrap_result(S) -->  
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">

	<!-- 그리드 데이터 영역 [Table](S) (기존 As-is 구조에서 변경되는 사항 없음) -->
    <script type="text/javascript">ComSheetObject('sheet1');</script>
    <!-- 그리드 데이터 영역 [Table](E) (기존 As-is 구조에서 변경되는 사항 없음) -->
</div>
<!-- opus_design_grid(E) -->
</div>	
</form>