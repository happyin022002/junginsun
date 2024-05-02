<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_SAM_0009.jsp
*@FileTitle  : Performance by Customer
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
<%@ page import="com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.event.EsmSam0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSam0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strUsrSrepCd 	= "";
	Logger log = Logger.getLogger("com.clt.apps.SalesActivityManage.SalesActivityManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strUsrSrepCd = account.getSrep_cd();

		event = (EsmSam0009Event)request.getAttribute("Event");
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

<head>
<title>Performance by Customer</title>


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
<input type="hidden" name="in_usr_srep_cd" value="<%=strUsrSrepCd%>" id="in_usr_srep_cd" />
<input type="hidden" name="hidden_ofc_cd" value="" id="hidden_ofc_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id%>" id="usr_id" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="100" />				
				<col width="70" />				
				<col width="100" />				
				<col width="80" />				
				<col width="250" />				
				<col width="80" />				
				<col width="140" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Sales Office</th>
					<td><input type="text" name="sales_office" style="width:70px;text-align:center;ime-mode:disabled" class="input1" value="<%=strOfc_cd%>" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" maxlength="5" id="sales_office" /><button type="button" id="btn_office_code" name="btn_office_code" class="input_seach_btn"></button></td>
					<th>Sales Rep</th>
					<td><input type="text" style="width:70px; text-align: center;" name="sales_rep" dataformat="engup" maxlength="5" onkeyup="javascript:searchOfficeCodeName(this);" value="<%=strUsrSrepCd%>" class="input1" id="sales_rep" /></td>
					<th>Booking Date</th>
					<td><!-- 
					--><input type="text" name="from_date" maxlength="10" dataformat="ymd" style="width: 80px; text-align: center;" class="input1" id="from_date" /><!-- 
					--><button type="button" id="btns_calendar1" name="btns_calendar1" class="calendar ir"></button>~&nbsp;<!-- 
					--><input type="text" name="to_date" maxlength="10" dataformat="ymd" style="width: 72px; text-align: center;" class="input1" id="to_date" /><!-- 
					--><button type="button" id="btns_calendar2" name="btns_calendar2" class="calendar ir"></button><!-- 
					--></td>
					<th>Customer Code</th>
					<td><input type="text" name="cust_cd" style="width:80px;text-align:center;ime-mode:disabled" class="input" value="" onkeyup="javascript:searchOfficeCodeName(this);" dataformat="engup" maxlength="8" id="cust_cd" /><button type="button" id="btn_cust_cd" name="btn_cust_cd" class="input_seach_btn"></button></td>
			 		<td><input name="bkg_info" type="checkbox" class="trans" id="bkg_info" /> Booking Info.</td>
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
		<table class="grid_2">
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Total Booking</th>
					<td><input type="text" name="total_bkg" style="width:100%;text-align:center;" class="noinput" value="" readonly="readonly" maxlength="5" id="total_bkg" /></td>
						<th>Total Qty(TEU)</th>
					<td><input type="text" name="total_qty" style="width:100%;text-align:center;" class="noinput" value="" readonly="readonly" maxlength="5" id="total_qty" /></td>
					<td style="border: none"></td>
				</tr>
			</tbody>
		</table>	
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>