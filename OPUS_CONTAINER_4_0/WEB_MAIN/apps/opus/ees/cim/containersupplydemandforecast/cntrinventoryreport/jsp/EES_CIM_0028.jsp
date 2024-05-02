<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CIM_0028.js
*@FileTitle  : Stock Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/23 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.event.EesCim0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.DateTime"%>



<%
	EesCim0028Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String fm_date = DateTime.addDays(DateTime.getDateString(),-7,"yyyy.MM.dd");
	String chk_date = DateTime.addDays(DateTime.getDateString(),-90,"yyyy.MM.dd");
	fm_date = fm_date.replace(".","-");
	chk_date = chk_date.replace(".","-");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (EesCim0028Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="param_loc_cd" id="param_loc_cd" />
<input type="hidden" name="param_loc_type_code" id="param_loc_type_code" />
<input type="hidden" name="param_cntr_tpsz_cd" id="param_cntr_tpsz_cd" />
<input type="hidden" name="param_fm_stk_jb_dt" id="param_fm_stk_jb_dt" />
<input type="hidden" name="param_to_stk_jb_dt" id="param_to_stk_jb_dt" />

<input type="hidden" name="chk_date" value="<%=chk_date%>" id="chk_date" />

<input type="hidden" name="inquiryLevel" value="" id="inquiryLevel" />
<input type="hidden" name="location" value="" id="location" />

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
			--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	    <!-- page_location(S) -->
	<div class="location">
    <!-- location 내용 동적생성 (별도 코딩 불필요) -->
    <span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- wrap_area(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Location</th>
					<td><input type="text" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill="" required="loc_cd" class="input1" value="" id="loc_cd" /><button type="button" id="btn_loc_cd" name="btn_loc_cd" class="input_seach_btn"></button></td>
					<th class="sm pad_left_8"><input type="radio" name="loc_type_code" value="1" class="trans" id="loc_type_code" /><label>RCC</label><input type="radio" name="loc_type_code" value="2" class="trans" id="loc_type_code" /><label>LCC</label><input type="radio" name="loc_type_code" value="3" class="trans" id="loc_type_code" /><label>ECC</label><input type="radio" name="loc_type_code" value="4" class="trans" checked="" id="loc_type_code" /><label>SCC</label></th>
					<th>TP/SZ</th>
					<td><script type="text/javascript">ComComboObject('cntr_tpsz_cd', 1, 115, 1);</script></td>
					<th>Period</th>
					<td><input type="text" name="fm_stk_jb_dt" style="width:80px;text-align:center;" class="input1" caption="Period FM" dataformat="ymd" size="10" maxlength="10" fulfill="" required="" value="<%=fm_date %>" id="fm_stk_jb_dt" /><button type="button" id="btns_calendarfm" name="btns_calendarfm" class="calendar ir"></button>~ <input type="text" name="to_stk_jb_dt" caption="Period To" dataformat="ymd" size="10" maxlength="10" fulfill="" style="width:80px;text-align:center;" class="input" value="" id="to_stk_jb_dt" /><button type="button" id="btns_calendarto" name="btns_calendarto" class="calendar ir"></button></td>
				</tr> 
			</tbody>
		</table>
	<!-- opus_design_inquiry(E) -->
	</div>
</div>
<!-- wrap_area(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_cntrdata" id="btn_cntrdata" type="button">CNTR Data</button><!--
				--><button class="btn_normal" name="btn_duedata" id="btn_duedata" type="button">Due Data</button><!--
				--><button class="btn_normal" name="btn_detail" id="btn_detail" type="button">Detail</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
