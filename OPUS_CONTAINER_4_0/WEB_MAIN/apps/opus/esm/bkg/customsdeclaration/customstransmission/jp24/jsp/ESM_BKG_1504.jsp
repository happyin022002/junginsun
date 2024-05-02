<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1504.jsp
*@FileTitle  : JMS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1504Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1504Event event = null;		//PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;	//서버에서 발생한 에러
	String strErrMsg = "";				//에러메세지
	int rowCount = 0;					//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList	= "";
	String pageRows	= "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1504Event)request.getAttribute("Event");
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
<!-- 개발자 작업 -->
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
		 --><button type="button" class="btn_accent" name="btn_bl_inquiry" id="btn_bl_inquiry">Manifest(B/L)</button><!--
		 --><button type="button" class="btn_normal" name="btn_retrieve"  	id="btn_retrieve">Retrieve</button><!--
		 --><button type="button" class="btn_normal" name="btn_down_excel" 	id="btn_down_excel">Down Excel</button>
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

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="30">
				<col width="236">
				<col width="80">
				<col width="122">
				<col width="65">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;" class="input1" name="vvd" maxlength="9" required="" caption="VVD" fullfill="" dataformat="engup" id="vvd" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" required="" caption="POL" class="input1" name="pol_cd" maxlength="5" dataformat="engup" id="pol_cd" /></td>
					<th>BL/No</th>
					<td><input type="text" style="width:90px;" class="input" name="bl_no" maxlength="12" dataformat="engup" id="bl_no" /></td>
				</tr>
			</tbody>
		</table>
		<table>
			<colgroup>
				<col width="410">
				<col width="120">
				<col width="120">
				<col width="80">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<td class="sm pad_left_8"><input type="radio" name="period_div" value="SND_DT" class="trans" checked id="period_div" /><label for="period_div">Send Date</label><!--
					 --><input type="radio" name="period_div" value="RCV_DT" class="trans" id="period_div_1" /><label for="period_div_1">Received Date </label><!--
					 --><input name="date_fm" type="text" dataformat="ymd" maxlength="10" caption="From Date" cofield="date_to" class="input" style="width:80px;" id="date_fm" /><span class="dash">~</span><!--
					 --><input name="date_to" type="text" dataformat="ymd" maxlength="10" caption="To Date" cofield="date_fm" class="input" style="width:80px;" id="date_to" /><!--
					 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button></td>
					 <th>Sent Type</th>
					 <td><select name="snt_tp" id="snt_tp" style="width:80px" class="input">
							<option value="" selected>All</option>
							<option value="AMR" selected>AMR</option>
							<option value="CMR">CMR</option>
						</select>
					</td>
					<th>Ack. Status</th>
					<td><select name="ack_sts" id="ack_sts" style="width:80px" class="input">
							<option value="ACP" selected>Accepted</option>
							<option value="RJC">Rejected</option>
							<option value="DNL">DNL</option>
							<option value="DNU">DNU</option>
							<option value="STP">STP</option>
							<option value="HDL">HLD</option>
						</select>
					</td>
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
	<!-- opus_design_grid(S) -->
</div>
<!-- 개발자 작업 끝 -->
</form>