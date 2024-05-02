<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_BKG_1057.jsp
*@FileTitle : Freight & Charge List by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1057Event)request.getAttribute("Event");
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
<script type="text/javascript" src="/opuscntr/rpt/script/common_rd.js"></script>
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
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="Freight & Charge List by VVD">
<input type="hidden" name="com_mrdBodyTitle" value="Freight & Charge List by VVD">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_excel" 		id="btn_excel">Down Excel</button><!--
		--><button type="button" class="btn_normal" name="btn_print" 		id="btn_print">Print</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
		
<!-- result_area(S) -->
<div class="wrap_search_tab">
<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="75"/>
				<col width="110"/>
				<col width="80"/>
				<col width="80"/>
				<col width="30"/>
				<col width="30"/>
				<col width="80"/>
				<col width="50"/>
				<col width="80"/>
				<col width="50"/>			
				<col width="*" />
			</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td>
						<input type="text" name ="vvd_cd"  id ="vvd_cd" style="width:80px;" class="input1" value=""  maxlength='9'  required fullfill  dataformat = "engup" style="ime-mode:disabled">
					</td>
					<td class="sm pad_left_4"><label>(</label><!--
						--><input type="radio" name ="vvd_chk" value="T" class="trans" onClick ="setSchKey(this.value)" checked><!--
						--><label for="vvd_chk1">Trunk</label><!--
						--><input type="radio" name ="vvd_chk" value="A" class="trans" onClick ="setSchKey(this.value)"><!--
						--><label for="vvd_chk2">Actual)</label>
					</td>		
					<th title="Place of Receipt">POR</th>
					<td>
						<input type="text" name ="por_cd"  id ="por_cd"   style="width:50px;" class="input" value="" maxlength='5' dataformat = "engup" style="ime-mode:disabled" >
					</td> 
					<th>B/POL</th>
					<td>
						<input type="text" name ="pol_cd" id ="pol_cd"  style="width:50px;" class="input" value="" maxlength='5' dataformat = "engup" style="ime-mode:disabled" >
					</td> 
					<th>B/POD</th>
					<td>
						<input type="text" name ="pod_cd" id ="pod_cd"  style="width:50px;" class="input" value="" maxlength='5' dataformat = "engup" style="ime-mode:disabled" >
					</td> 
					<th title="Place of Delivery">DEL</th>
					<td>
						<input type="text" name ="del_cd" id ="del_cd" style="width:50px;" class="input" value="" maxlength='5' dataformat = "engup" style="ime-mode:disabled" >
					</td> 
				</tr>
			</tbody>
		</table>
		<table>
			<tbody>
				<colgroup>
					<col width="50"/>
					<col width="110"/>
					<col width="60"/>
					<col width="80"/>
					<col width="40"/>
					<col width="80"/>
					<col width="40"/>			
					<col width="*" />
				</colgroup>
				<tr>				
					<th>Sales Office</th>
					<td>
						<input type="text" name ="sls_ofc" id ="sls_ofc"  style="width:50px;" class="input" value="" maxlength='6' dataformat='enguponly' style="ime-mode:disabled">
					</td> 
					<th>Booking Office</th>
					<td>
						<input type="text" name ="bkg_ofc" id ="bkg_ofc" style="width:50px;" class="input" value="" maxlength='6' dataformat='enguponly' style="ime-mode:disabled">
					</td> 
					<th>Trade</th>
					<td>
						<input type="text" name ="trd_cd" id ="trd_cd" style="width:30px;" class="input" value="" maxlength='2' dataformat='enguponly' style="ime-mode:disabled">
					</td>
					<th>S/C No</th>
					<td>
						<input type="text" name ="sc_no" id ="sc_no" style="width:80px;" class="input" value="" maxlength='9' dataformat='engup' style="ime-mode:disabled">
					</td> 					
				</tr>				
			</tbody>
		</table>
	</div>
</div>		
<!-- opus_design_inquiry(E) -->

<!-- result_area(S) -->
<div class="wrap_result" style="height:500px;">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<!-- opus_tab_btn(E) -->	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" name="mainTable" id="tabLayer">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid clear" name="mainTable" id="tabLayer">
		<script language="javascript">rdViewerObject();</script>
	</div>
	<!-- opus_design_grid(E) -->	
			<!-- 개발자 작업  끝 -->
</div>
</form>
