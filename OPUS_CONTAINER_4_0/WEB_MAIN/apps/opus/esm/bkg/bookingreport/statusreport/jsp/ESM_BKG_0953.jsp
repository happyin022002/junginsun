<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_SPC_CODGS.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0953Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0953Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.opus.esm.bkg.bookingreport.performancereport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0953Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

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
<div id="debug"></div>
<form name="form">
	<input type="hidden" id="f_cmd" name="f_cmd"> 
	<input type="hidden" id="pagerows" name="pagerows"> 
	<input type="hidden" id="ch_usr_id" name="ch_usr_id">
	<input type="hidden" id="curr_page" name="curr_page"      value="1">
	<input type="hidden" id="rows_per_page" name="rows_per_page"  value="50">
	<input type="hidden" id="order_by_title" name="order_by_title"  value="">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<!--Button (S) -->
			<div class="opus_design_btn"><!--  
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button><!--  
			--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--  
			--></div>
			<!-- opus_design_btn(E) -->

			<!-- page_location(S) -->
			<div class="location">
				<!-- location 내용 동적생성 (별도 코딩 불필요) -->
				<span id="navigation"></span>
			</div>
			<!-- page_location(E) -->
	</div>
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80">
				<col width="70">
				<col width="80">
				<col width="70">
				<col width="80">
				<col width="70">
				<col width="84">
				<col width="90">
				<col width="100">
				<col width="*">
			</colgroup>
	    	<tr>
				<th>Location</th>
				<td><!--  
				--><input type="text" style="width: 60px;" value="" class="input1" name="location_cd" id="location_cd" maxlength="5" dataformat="engup"><!--  
				--><input type="text" style="width: 40px;" value="" class="input" name="location_yd_cd" id="location_yd_cd" maxlength="2" dataformat="engup"><!--  
				--><button type="button" name="btn_0083LocPop" id="btn_0083LocPop" class="input_seach_btn"></button></td>
				<th>Duration</th>
				<td colspan="3"><!--  
				--><input type="text" style="width: 80px;" class="input1" value="" maxlength="10" dataformat="ymd" name="dura_from_dt" id="dura_from_dt">&nbsp;-&nbsp;<!--  
				--> <input type="text" style="width: 80px;" class="input1" value="" maxlength="10" dataformat="ymd" name="dura_to_dt" id="dura_to_dt"><!--  
				--><button type="button" class="calendar ir" name="btn_period_date" id="btn_period_date"></button></td>
				<th>B/L Type</th>
				<td class="sm pad_left_8"><!--  
				--><input type="checkbox" value="Y" class="trans" name="bl_type_ob" id="bl_type_ob"><label for="bl_type_ob">Local</label><!--  
				--><input type="checkbox" value="Y" class="trans" name="bl_type_ts" id="bl_type_ts"><label for="bl_type_ts">T/S</label></td>
				<th>Trade Zone </th>
				<td><!--  
				--><select style="width:80px;" class="input" name="trade_zone" id="trade_zone"><!--  
				--><option value="" ></option><!--  
				--><option value="USA" >USA</option><!--  
				--><option value="EUR">EUR</option><!--  
				--><option value="PRC">PRC</option><!--  
				--><option value="JPN">JPN</option><!--  
				--><option value="IPC">IPC</option><!--  
				--></select></td> 
			</tr>			
			<tr>
				<th title="Port of Loading">First POL</th>
				<td><input type="text" style="width: 105px; ime-mode: disabled" class="input" value="" id="pol_cd" name="pol_cd" maxlength="5" dataformat="engup"></td>
				<th title="Port of Discharging">Last POD</th>
				<td><input type="text" style="width: 57px; ime-mode: disabled" class="input" value="" id="pod_cd" name="pod_cd" maxlength="5" dataformat="engup"></td>
				<th>Out -Lane</th>
				<td><input type="text" style="width: 57px;" value="" class="input" name="out_lane" id="out_lane" maxlength="3" dataformat="engup"></td>
				<th>Out -TMNL</th>
				<td><input type="text" style="width: 100px;" value="" class="input" name="out_tmnl" id="out_tmnl" maxlength="7" dataformat="engup"></td>
				<th>Shipper CD</th>
				<td><input type="text" style="width: 80px;" value="" class="input" name="shipper_cd" id="shipper_cd" maxlength="20" dataformat="engup"><!--  
				--><button type="button" name="btn_shipper_pop" id="btn_shipper_pop" class="input_seach_btn"></button></td>
			</tr>
		</table>
	</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry">
		<table>
				<colgroup>
				     <col width="70">
				     <col width="270">
				     <col width="40">
				     <col width="*">
		    	</colgroup>
				<tr>
					<th>CNTR Q'ty</th>
					<td><!--  
					--><input type="text" style="width: 50px;" value=" 40ft" class="input2" readonly><!--  
					--><input type="text" style="width: 50px; text-align: right" value="" class="input2" id="total_40t" name="total_40t" id='total_40t' readonly><!--  
					--><input type="text" style="width: 50px;" value=" 20ft" class="input2" readonly><!--  
					--><input type="text" style="width: 50px; text-align: right" value="" class="input2" name="total_20t" id="total_20t" readonly>
					</td>
					<th>Sort</th>
					<td><script type="text/javascript">ComComboObject('order_by', 1, 80, '');</script></td>
				</tr>
		</table>
	</div>
</div>
</form>
<form name="form2" method="POST">
	<input type="hidden" name="message" id='message'> 
</form>