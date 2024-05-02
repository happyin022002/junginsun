<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1108.jsp
*@FileTitle  :  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strPgmNo			= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		strPgmNo = JSPUtil.getNull(request.getParameter("pgmNo"));
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
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
<input type="hidden" name="call_type" value="ESM_BKG_1108" id="call_type" />
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>" id="pgmNo" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
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
	<div class="opus_design_inquiry ">
		<table>
			<colgroup>
				<col width="50">
				<col width="*"/>
			</colgroup>
			<tr>
				<th>Type</th>
				<td><script type="text/javascript">ComComboObject('p_type', 1, 120, 1, '');</script></td>
			</tr>
		</table>
		
		<div id="ensView" style="display:inline">
			<table>
				<colgroup>
					<col width="50">
					<col width="160"/>
					<col width="80"/>
					<col width="140"/>
					<col width="70"/>
					<col width="130"/>
					<col width="160"/>
					<col width="150"/>
					<col width="150"/>
					<col width="*"/>
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px;" class="input1" name="p_vvd" value="" maxlength="9" dataformat="engup" id="p_vvd" /><input type="text" style="width:50px;" class="input2" name="p_lane" value="" maxlength="3" dataformat="engup" readonly="readonly" id="p_lane" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" class="input1" name="p_pol" value="" maxlength="5" dataformat="engup" id="p_pol" /><input type="text" style="width:30px"  class="input" name="p_pol_yd"  value=""  maxlength="2" dataformat='engup' style="ime-mode: disabled"></td>
					<th>BKG OFC</th>
					<td><input type="text" style="width:70px;" class="input" name="p_b_ofc_cd" maxlength="6" dataformat="engup" id="p_b_ofc_cd" /></td>
					<th>POFE (Port of First Entry)</th>
					<td><script type="text/javascript">ComComboObject('p_pofe_yd_temp', 1, 100,1,2);</script><input type="hidden" name="p_pofe" value="" id="p_pofe" /><input type="hidden" name="p_pofe_yd" value="" id="p_pofe_yd" /><input type="hidden" name="p_search_pofe_yard_cd" value="" id="p_search_pofe_yard_cd" /></td>
					<th><label for="p_cancel_yn">Incl. Canceled Booking</label></th>
					<td><input type="checkbox" name="p_cancel_yn" value="Y" class="trans" id="p_cancel_yn" /></td>
				</tr>	
			</table>
		</div>
		
		<div id="fiView" style="display:inline">
			<table>
				<colgroup>
					<col width="50">
					<col width="160">
					<col width="80">
					<col width="140">
					<col width="70">
					<col width="130">
					<col width="160">
					<col width="150">
					<col width="150">
					<col width="*">
				</colgroup>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:90px;" class="input1" name="p_fi_vvd" value="" maxlength="9" dataformat="engup" id="p_fi_vvd" /><input type="text" style="width:50px;" class="input2" name="p_fi_lane" value="" maxlength="3" dataformat="engup" readonly="readonly" id="p_fi_lane" /></td>
					<th>Pre EU Port</th>
					<td><input type="text" style="width:60px;" class="input2" name="p_fi_pol" value="" maxlength="5" dataformat="engup" readonly="readonly" id="p_fi_pol" /><input type="text" style="width:30px;" class="input2" name="p_fi_pol_yd" maxlength="2" dataformat="engup" readonly="readonly" id="p_fi_pol_yd" /></td>
					<th>BKG OFC</th>
					<td><input type="text" style="width:70px;" class="input" name="p_fi_b_ofc_cd" maxlength="6" dataformat="engup" id="p_fi_b_ofc_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;" class="input1" name="p_fi_pofe" value="FIKTK" maxlength="5" dataformat="engup" id="p_fi_pofe" /><input type="text" style="width:30px;" class="input" name="p_fi_pofe_yd" maxlength="2" dataformat="engup" id="p_fi_pofe_yd" /></td>
					<th><label for="p_fi_cancel_yn">Incl. Canceled Booking</label></th>
					<td><input type="checkbox" name="p_fi_cancel_yn" value="Y" class="trans" id="p_fi_cancel_yn" /></td>
				</tr>	
			</table> 
		</div>
		
		<table>
			<colgroup>
				<col width="50">
				<col width="165">
				<col width="40">
				<col width="20">
				<col width="20">
				<col width="320">
				<col width="97">
				<col width="150">
				<col width="150">
				<col width="*">
			</colgroup>
			<tr>
				<th>BL/No</th>
				<td><input type="text" style="width:100px;" class="input" name="p_bl_no" value="" maxlength="12" dataformat="engup" id="p_bl_no" /></td>
				<th class="sm"><input type="radio" name="p_date_gb" value="S" class="trans" checked="checked" id="p_date_gb_1" /><label for="p_date_gb_1">Send</label></th>
				<td class="sm"></td>
				<th class="sm"><input type="radio" name="p_date_gb" value="R" class="trans" id="p_date_gb_2" /><label for="p_date_gb_2">Receive</label></th>
				<td><input type="text" style="width:80px;" value="" class="input" name="p_from_dt" maxlength="10" dataformat="ymd" id="p_from_dt" /><input type="text" name="p_from_mt" style="width:40px;" value="00:00" class="input" dataformat="hm" maxlength="5" id="p_from_mt" />~ <input type="text" style="width:80px;" value="" class="input" name="p_to_dt" maxlength="10" dataformat="ymd" id="p_to_dt" /><input type="text" name="p_to_mt" style="width:40px;" value="23:59" class="input" dataformat="hm" maxlength="5" id="p_to_mt" /><button type="button" id="btn_date" name="btn_date" class="calendar ir"></button></td>
				<th>Sent Type</th>
				<td>
					<select style="width: 80px;" name="p_sent_type">
						<option value="" selected>All</option>
						<option value="O">Original</option>
						<option value="U">Amend</option>
						<option value="DL">D/L</option>
						<option value="NA">N/A</option>
					</select>
				</td>
				<th>Ack. Status</th>
				<td>
					<select style="width: 120px;" name="p_ack_status">
						<option value="" selected>All</option>
						<option value="A">Accepted</option>
						<option value="R">Rejected</option>
						<option value="DNL">Do Not Load</option>
						<option value="NR">Not Received</option>
						<option value="NA">N/A</option>
					</select>
				</td>
			</tr>	
		</table>
	</div>
</div>
	
<div class="wrap_result">
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" id="btn_Inquiry" name="btn_Inquiry">Manifest(B/L)</button>
			<button type="button" class="btn_normal" id="btn_History" name="btn_History">Transmit & Receive History</button>
			<button type="button" class="btn_normal" id="btn_viewMsg" name="btn_viewMsg">View Message</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="70">
				<col width="60">
				<col width="30">
				<col width="70">
				<col width="60">
				<col width="30">
				<col width="80">
				<col width="60">
				<col width="30">
				<col width="70">
				<col width="60">
				<col width="30">
				<col width="85">
				<col width="60">
				<col width="30">
				<col width="90">
			</colgroup>
			<tr>
				<th>Total B/L</th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_total_bl_cnt" readonly id="div_total_bl_cnt" /> </td>
				<th> = </th>
				<th>Sent B/L</th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_sent_bl_cnt" readonly id="div_sent_bl_cnt" /> </td>
				<th> + </th>
				<th><font color="red">Un-Sent B/L</font></th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_unsent_bl_cnt" readonly id="div_unsent_bl_cnt" /> </td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<th>Sent B/L</th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_sent_bl_cnt2" readonly id="div_sent_bl_cnt2" /> </td>
				<th> = </th>
				<th>Accepted</th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_a_cnt" readonly id="div_a_cnt" /> </td>
				<th> + </th>
				<th><font color="red">Rejected</font></th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_r_cnt" readonly id="div_r_cnt" /> </td>
				<th> + </th>
				<th><font color="red">Do Not Load</font></th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_dnl_cnt" readonly id="div_dnl_cnt" /> </td>
				<th> + </th>
				<th><font color="red">Not Received</font></th>
				<td><input type="text" style="width:70px;" value="" class="input2" name="div_nr_cnt" readonly id="div_nr_cnt" /> </td>
			</tr>	
		</table>
		
		</br>
		
		<table>
			<tr>
				<td> * EORI No Validation : <a target="_blank" href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp</a></td>
			</tr>
			<tr>
				<td> * HS Code Validation : <a target="_blank" href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en</a></td>
			</tr>
		</table>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
	
	<div class="opus_design_grid" style="display: none;">
		<script type="text/javascript">ComSheetObject('sheetDownload');</script>
	</div>
</div>

</form>