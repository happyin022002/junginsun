<% /*=========================================================
	 *Copyright(c) 2006 CyberLogitec
	 *@FileName :  ESM_BKG_1061.jsp
	 *@FileTitle : Manual Booking Creation without Agent
	 *@author     : CLT
	 *@version    : 1.0 
	 *@since      : 2014/11/11
	 =========================================================*/ %>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg3008Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg3008Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strOfc_cd = "";

	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterData");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EsmBkg3008Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch (Exception e) {
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
<input 	type="hidden" name="f_cmd" id="f_cmd">
<input	type="hidden" name="pagerows" id="pagerows">
<input 	type="hidden" name="agn_flg" id="agn_flg" value="N">
<input	type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
<input	type="hidden" name="ofc_cd" id="ofc_cd" value="<%=strOfc_cd%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 		id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" 		id="btn_new">New</button><!-- 	
		 --><button type="button" class="btn_normal" name="btn_down_excel" 	id="btn_down_excel">Down Excel</button>			
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
				<col width="50"/>
				<col width="80"/>
				<col width="50"/>
				<col width="90"/>
				<col width="40"/>
				<col width="60"/>
				<col width="100"/>					
				<col width="200" />
				<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>B.Office</th>
				<td>
					<input type="text" style="width: 60px; ime-mode: disabled" class="input1"	name="cre_ofc_cd" id="cre_ofc_cd" maxlength="6" dataformat="engup" value="">
				</td>
				<th>User ID</th>
				<td>
					<input type="text" style="width: 80px; ime-mode: disabled" class="input" name="cre_usr_id" id="cre_usr_id" maxlength="20" dataformat="eng" value="">
				</td>
				<th>Use</th>
				<td>
					<select style="width: 50px;" class="input" name="bkg_no_use_flg" id="bkg_no_use_flg">
						<option value="%" selected>All</option>
						<option value="N">No</option>
						<option value="Y">Yes</option>
					</select>
				</td>
				<th>Creation Date</th>
				<td>
					<input type="text"	style="width: 80px; ime-mode: disabled" class="input1" id="fm_cre_dt" name="fm_cre_dt" cofield="fm_cre_dt" maxlength="10" dataformat="ymd" value=""><!--
					--><span class="dash">~</span><!-- 
					--><input type="text" style="width: 80px; ime-mode: disabled" class="input1"	id="to_cre_dt" name="to_cre_dt" cofield="to_cre_dt"	maxlength="10" dataformat="ymd" value=""><!-- 
					--><button type="button" class="calendar ir" name="btn_calendar" id="btn_calendar"></button>
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
<div class="opus_design_grid clear" style="width:100%" name="tabLayer" id="tabLayer">
	
	<!-- opus_design_data(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
					<col width="100"/>
					<col width="80"/>
					<col width="80"/>
					<col width="60"/>
					<col width="60"/>	
					<col width="*"/>								
		   	</colgroup>
			<tbody>
				<tr>
					<th>Number of BKG(s)</th>
					<td>
						<input type="text" style="width: 60px; text-align: right" class="input1" id="no_of_bkg" name="no_of_bkg" maxlength="3" dataformat="num" value="0">
					</td>
					<th>BKG No. Prefix</th>
					<td>
						<input type="text" style="width: 40px;" class="input1" id="act_chn_agn_cd" name="act_chn_agn_cd" maxlength="2" dataformat="engup" value="" onkeydown="prefixCheck(this, event)">
					</td>				
					<td class="pad_left_8">
						<button type="button" class="btn_etc" name="btn_create" id="btn_create">Create</button>
					</td>				
					<td></td>
				</tr>				
			</tbody>
		</table>			
	</div>
	<!-- opus_design_data(E) -->
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>	
<!-- opus_design_grid(S) -->
</div>
</form>	





