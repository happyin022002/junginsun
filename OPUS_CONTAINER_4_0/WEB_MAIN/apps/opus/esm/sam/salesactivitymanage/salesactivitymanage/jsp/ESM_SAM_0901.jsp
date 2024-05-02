<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0901.jsp
*@FileTitle  : Sales Activity List
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/22
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0901Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0901Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strSrep_cd		= "";

	Logger log = Logger.getLogger("com.clt.apps.SalesActivityManage.SalesActivityManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strSrep_cd = account.getSrep_cd();


		event = (EsmSam0901Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		// PopUp 호출시 받은 Sales Rep Code
		// request.getAttribute("srep_cd");
		//String srep_cd = 'AAAAA';
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Sales Activity List</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="hidden_ofc_cd" value="" id="hidden_ofc_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2><span>Sales Activity List </span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80" />				
				<col width="150" />				
				<col width="80" />				
				<col width="350" />				
				<col width="80" />				
				<col width="100" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Office Code</th>
					<td><input type="text" name="office_cd" style="width:100px;text-align:center;ime-mode:disabled" class="input1" value="<%=strOfc_cd%>" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" maxlength="6" id="office_cd" /><button type="button" id="btn_office_code" name="btn_office_code" class="input_seach_btn"></button></td>
					<th>Team Code</th>
					<td><input type="text" style="width:70px; text-align: center;" name="team_cd" dataformat="engup" onkeyup="javascript:searchOfficeCodeName(this);" maxlength="3" class="input" id="team_cd" /></td>
					<th>Status</th>
					<td><script type="text/javascript">ComComboObject("combo_status", 1, 73, 1, 0, 0, false); </script></td>
					<th>Activity #</th>
					<td><input type="text" style="width:70px; text-align: center;" name="activity" dataformat="num" maxlength="3" class="input" id="activity" /></td>
		   		</tr>
		   		<tr>
		   			<th>Sales Rep Code</th>
					<td><input type="text" style="width:130px;text-align:center;ime-mode:disabled" name="sales_rep_cd" value="<%=strSrep_cd%>" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" maxlength="5" class="input1" id="sales_rep_cd" /></td>
					<th>Search Type</th>
					<td>
					<!-- 
					--><script type="text/javascript">ComComboObject("search_type", 1, 73, 1, 1, 0, false);</script><!-- 
					-->		
					
					<!-- 2014.08.01 김용습 - 달력 스타일 변경 -->
					<!-- <input type="text" name="from_date" maxlength="10" dataformat="ymd" style="width: 72px; text-align: center;" readonly class="input" id="from_date" />
					<button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;
					<input type="text" name="to_date" maxlength="10" dataformat="ymd" style="width: 72px; text-align: center;" readonly class="input" id="to_date" />
					<button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button> -->	
					<input type="text" style="width:80px;ime-mode:disabled;" class="input" name="from_date" dataformat="ymd" maxlength="8" size="10" id="from_date" />~ <!-- 
			        --><input type="text" style="width:80px;ime-mode:disabled;" class="input" name="to_date" dataformat="ymd" maxlength="8" size="10" id="to_date" /><!-- 
			        --><button type="button" class="calendar" name="btn_Calendar" id="btn_Calendar"></button><!-- 
					-->						
					</td>
					<th>Customer Code</th>
					<td><input type="text" style="width:73px; text-align: center;" name="customer_cd" dataformat="engup" maxlength="8" onkeyup="javascript:searchOfficeCodeName(this);" class="input" id="customer_cd" /></td>
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

</form>