<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_0157.jsp
*@FileTitle  : COD Status Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0157Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmBkg0157Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			 //error from server
	String strErrMsg = "";				//error message
	int rowCount	 = 0;				//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_nm        = "";
 
	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.CODCorrection");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
        strOfc_nm = account.getOfc_cd(); //getOfc_cd(),getOfc_eng_nm(),getOfc_krn_nm()

		event = (EsmBkg0157Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_CodInquiry" 	id="btn_CodInquiry">COD Inquiry</button>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50"/>
				<col width="200"/>
				<col width="90"/>
				<col width="70"/>
				<col width="50"/>
				<col width="60"/>
				<col width="50"/>
				<col width="90"/>
				<col width="80"/>
				<col width="*" />				
			</colgroup> 
			<tbody>
			<tr>
					<th>Duration</th>
					<td><input type="text" style="width:80px;" class="input1"   dataformat="ymd" name="dur_from" id="dur_from"><!--
					--><span class="dash">~</span><!--
					--><input type="text" style="width:80px;" class="input1"  dataformat="ymd" name="dur_to"><!--
					--><button type="button" class="calendar ir" name="btn_Duration" id="btn_Duration"></button>
					<th>BKG Office</th>
					<td><input type="text" style="width:70px;" class="input1" value="<%=strOfc_nm%>" id="bkg_ofc_cd" name="bkg_ofc_cd" maxlength="6" dataformat="engup" ></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" class="input" value="" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup"></td>
					<th>T/VVD</th>
					<td><input type="text" style="width:90px;" class="input" value="" name="vvd" id="vvd" maxlength="9" dataformat="engup"></td>
					<th>BKG No.</th>
					<td><input type="text" style="width:110px;" class="input" value="" name="bkg_no" id="bkg_no" maxlength="13" dataformat="engup"></td>
					
			</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="920"/>	
				<col width="*"/>		
			</colgroup> 
			<tbody>
				<tr>
					<td class="sm pad_left_8">
						<input type="radio" value="A" class="trans" checked name="cod_sts_cd" id="cod_sts_cd1"><label for="cod_sts_cd1"><strong>All</strong></label>
						<input type="radio" value="R" class="trans" name="cod_sts_cd" id="cod_sts_cd2"><label for="cod_sts_cd2"><strong>R</strong> (Request)</label>
						<input type="radio" value="W" class="trans" name="cod_sts_cd" id="cod_sts_cd3"><label for="cod_sts_cd3"><strong>W</strong> (Waiting for Partner’s Confirmation</label>
						<input type="radio" value="Y" class="trans" name="cod_sts_cd" id="cod_sts_cd4"><label for="cod_sts_cd4"><strong>Y</strong> (Approved)</label>
						<input type="radio" value="N" class="trans" name="cod_sts_cd" id="cod_sts_cd5"><label for="cod_sts_cd5"><strong>N</strong> (Rejected)</label>
						<input type="radio" value="C" class="trans" name="cod_sts_cd" id="cod_sts_cd6"><label for="cod_sts_cd6"><strong>C</strong> (Cancel COD)</label>
						<input type="radio" value="F" class="trans" name="cod_sts_cd" id="cod_sts_cd7"><label for="cod_sts_cd7"><strong>F</strong> (Booking Confirm)</label>
						<input type="radio" value="M" class="trans" name="cod_sts_cd" id="cod_sts_cd8"><label for="cod_sts_cd8"><strong>M</strong> (Manual)
					</td>
					<td></td>
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
