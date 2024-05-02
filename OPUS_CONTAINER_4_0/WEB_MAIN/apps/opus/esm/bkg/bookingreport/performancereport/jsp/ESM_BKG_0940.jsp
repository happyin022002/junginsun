<%
 /*
 =========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_BKG_0940.jsp
 *@FileTitle  : I/B DOC Performance Report 
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
 =========================================================
 */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg0940Event"%>	
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0940Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	String cnt_cd = "";
	String strOfc_cd = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		cnt_cd = account.getCnt_cd();
		strOfc_cd = account.getOfc_cd();
		event = (EsmBkg0940Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
	<input type="hidden" name="ch_usr_id">
	<input type="hidden" name="curr_page"      value="1">
	<input type="hidden" name="rows_per_page"  value="50">
<!-- 개발자 작업	-->


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->



<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
<div class="opus_design_inquiry wFit">
	<table>
		<tbody>	
			<colgroup>
				<col width="90"/>
				<col width="270"/>
				<col width="60"/>
				<col width="40"/>
				<col width="60"/>
				<col width="80"/>
				<col width="60"/>
				<col width="100"/>
				<col width="50"/>
				<col width="80"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th>Duration(ETA)</th>
				<td><input type="text" style="width: 75px;" class="input1" value=""  maxlength='10' dataformat="ymd" name="eta_from_dt" id="eta_from_dt"><span class="dash">-</span><!----><input type="text" style="width:75px;" class="input1" value=""  maxlength='10' dataformat="ymd" name="eta_to_dt" id="eta_to_dt"><button type="button" class="calendar ir"  name="btn_period_date" id="btn_period_date" ></button></td>
				<th>Country</th>
				<td><input type="text" style="width: 30px;ime-mode:disabled" class="input1" value="<%=cnt_cd%>" name="cntr_cd" id="cntr_cd" maxlength='2' dataformat='engup'></td>
				<th>Office</th>
				<td><input type="text" style="width: 55px;ime-mode:disabled" class="input1" value="<%=strOfc_cd%>" name="ofc_cd" id="ofc_cd" maxlength='6' dataformat='engup'></td >
				<th>Staff ID</th>
				<td><input type="text" style="width: 60px;ime-mode:disabled" class="input" value="" name="staff_id" id="staff_id" maxlength='20' dataformat='eng'></td>
				<th>LANE</th>
				<td><input type="text" style="width: 40px;ime-mode:disabled" class="input" value="" name="lane_cd" id="lane_cd" maxlength='3' dataformat='enguponly'></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width: 80px;ime-mode:disabled" class="input" value="" name="vvd_cd" id="vvd_cd" maxlength='9' dataformat='engup'></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="90"/>
				<col width="91"/>
				<col width="50"/>
				<col width="90"/>
				<col width="100"/>
				<col width="150"/>
				<col width="*" />
			</colgroup>
			<tr>
				<th title="Port of Discharging">POD</th>
				<td><input type="text" style="width: 50px; ime-mode:disabled" class="input" value="" name="pod_cd" id="pod_cd" maxlength='5' dataformat='engup'></td>
				<th title="Place of Delivery">DEL</th>
				<td><input type="text" style="width: 50px; ime-mode:disabled" class="input" value="" name="del_cd" id="del_cd" maxlength='5' dataformat='engup'></td>
				<th class="sm">Duration Option</th>
				<td class="sm"><input type="radio" value="W" class="trans" name="dura_cd" checked>Weekly Base<label></label><input type="radio" value="P" class="trans" name="dura_cd"> Period Base</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>

<!-- opus_design_grid(S) -->
<div class="wrap_result">
<div class="opus_design_grid">
	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->

<input type="hidden" name="message"> 
</form>	
