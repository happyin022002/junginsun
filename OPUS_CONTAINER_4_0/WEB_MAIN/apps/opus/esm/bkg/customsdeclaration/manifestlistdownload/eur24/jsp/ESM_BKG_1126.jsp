<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1126.jsp
*@FileTitle  : Europe Advanced Manifest - ENS Report
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
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
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
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
<input type="hidden" name="call_type" value="ESM_BKG_1126" id="call_type" />
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_New" 		id="btn_New">New</button><!--
			--><button type="button" class="btn_normal" name="btn_DownExcel"  		id="btn_DownExcel">Down Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40"/>
					<col width="160"/>
					<col width="60"/>
					<col width="110"/>
					<col width="60"/>
					<col width="90"/>
					<col width="60"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th title="Vessel Voyage Direction">VVD</th>
						<td><input type="text" style="width:100px;" class="input1" name="p_vvd" value="" maxlength="9" dataformat="engup" id="p_vvd" /><!-- 
						 --><input type="text" style="width:50px;" class="input2" name="p_lane" value="" dataformat="engup" readonly id="p_lane" /></td>
						<th>EU POL</th>
						<td><script type="text/javascript">ComComboObject('p_pol_cd_temp', 1, 125, '');</script><!-- 
						 --><input type="hidden" style="width:70px;" class="input1" name="p_pol" value="" maxlength="5" dataformat="engup" id="p_pol" /><!-- 
						 --><input type="hidden" style="width:30px;" class="input" name="p_pol_yd" maxlength="2" dataformat="engup" id="p_pol_yd" /><!-- 
						 --><input type="hidden" name="p_search_pol_yard_cd" value="" id="p_search_pol_yard_cd" /><!-- 
						 --><input type="hidden" style="width:70px;" class="input1" name="p_pol_cd" value="" maxlength="5" dataformat="engup" id="p_pol_cd" /><!-- 
						 --><input type="hidden" style="width:30px;" class="input" name="p_pol_yard_temp" maxlength="2" dataformat="engup" readonly id="p_pol_yard_temp" /><!-- 
						 --><input type="hidden" style="width:30px;" class="input" name="p_pol_yard_cd" maxlength="2" dataformat="engup" id="p_pol_yard_cd" /></td>
						<th>BKG OFC</th>
						<td><input type="text" style="width:75px;" class="input" name="p_b_ofc_cd" maxlength="6" dataformat="engup" id="p_b_ofc_cd" /><!-- 
						 --><input type="hidden" name="p_pofe_yd_temp" value="" id="p_pofe_yd_temp" /><input type="hidden" name="p_pofe" value="" id="p_pofe" /><!-- 
						 --><input type="hidden" name="p_pofe_yd" value="" id="p_pofe_yd" /><input type="hidden" name="p_search_pofe_yard_cd" value="" id="p_search_pofe_yard_cd" /></td>
						<td colspan="2"><label for="p_cancel_yn"><b>Incl. Canceled Booking</b></label><input type="checkbox" name="p_cancel_yn" value="Y" class="trans" id="p_cancel_yn" /> </td>
					</tr>	
					<tr>
						<th>BL/No</th>
						<td><input type="text" style="width:100px;" class="input" name="p_bl_no" value="" maxlength="12" dataformat="engup" id="p_bl_no" /> </td>
						<td class="sm pad_left_8"><input type="radio" name="p_date_gb" id="p_date_gb_1" value="S" class="trans" checked><label for="p_date_gb_1"><b>Send</b></label><!-- 
							--><input type="radio" name="p_date_gb" id="p_date_gb_2" value="R"   class="trans"><label for="p_date_gb_2"><b>Receive Date</b></label></td>
					   <td><input type="text" style="width:80px;" value="" class="input" name="p_from_dt" maxlength="10" dataformat="ymd" id="p_from_dt" /><!-- 
					   	 --><input type="text" name="p_from_mt" style="width:40px;" value="00:00" class="input" dataformat="hm" maxlength="5"  id="p_from_mt" />~&nbsp;<!-- 
					   	 --><input type="text" style="width:80px;" value="" class="input" name="p_to_dt" maxlength="10" dataformat="ymd" id="p_to_dt" /><!-- 
					   	 --><input type="text" name="p_to_mt" style="width:40px;" value="23:59" class="input" dataformat="hm" maxlength="5"  id="p_to_mt" /><!-- 
					   	 --><button type="button" id="btn_date" name="btn_date" class="calendar ir"></button></td>
					   <th>Type</th>
					  <td>
							<select style="width: 75px;" name="p_type" id="p_type">
								<option value="" selected>All</option>
								<option value="O">Original</option>
								<option value="U">Amend</option>
								<option value="DL">D/L</option>
								<option value="NA">N/A</option>
							</select>
					 </td>
					 <th>Status</th>
					<td>
						<select style="width: 120px;" name="p_ack_status" id="p_ack_status">
							<option value="" selected>All</option>
							<option value="A">Accepted</option>
							<option value="R">Rejected</option>
							<option value="DNL">Do Not Load</option>
							<option value="H">Hold</option>
							<option value="L">Released</option>
							<option value="NR">Not Received</option>
							<option value="NA">N/A</option>
						</select>
					</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" id="btn_Inquiry" name="btn_Inquiry">Manifest(B/L)</button><!--
				--><button type="button" class="btn_normal" name="btn_History" 	id="btn_History">Transmit & Receive History</button><!--
				--><button type="button" class="btn_normal" id="btn_viewMsg" 	name="btn_viewMsg">View Message</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class= "opus_design_inquiry">
			<table>
				<colgroup>
					<col width="70"/>
					<col width="60"/>
					<col width="15"/>
					<col width="70"/>
					<col width="60"/>
					<col width="15"/>
					<col width="70"/>
					<col width="60"/>
					<col width="15"/>
					<col width="70"/>
					<col width="60"/>
					<col width="15"/>
					<col width="35"/>
					<col width="60"/>
					<col width="15"/>
					<col width="70"/>
					<col width="60"/>
					<col width="15"/>
					<col width="70"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>Total B/L</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_total_bl_cnt" readonly id="div_total_bl_cnt" /> </td>
						<th> = </th>
						<th>Sent B/L</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_sent_bl_cnt" readonly id="div_sent_bl_cnt" /> </td>
						<th> + </th>
						<th style='color:red'>Un-Sent B/L</th>
						<td colspan="12"><input type="text" style="width:50px;" value="" class="input2" name="div_unsent_bl_cnt" readonly id="div_unsent_bl_cnt" /> </td>
					</tr>	
					<tr>
						<th>Sent B/L</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_sent_bl_cnt2" readonly id="div_sent_bl_cnt2" /> </td>
						<th> = </th>
						<th>Accepted</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_a_cnt" readonly id="div_a_cnt" /> </td>
						<th> + </th>
						<th style='color:red'>Rejected</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_r_cnt" readonly id="div_r_cnt" /> </td>
						<th> + </th>
						<th style='color:red'>Do Not Load</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_dnl_cnt" readonly id="div_dnl_cnt" /> </td>
						<th> + </th>
						<th style='color:red'>Hold</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_h_cnt" readonly id="div_h_cnt" /> </td>
						<th> + </th>
						<th>Released</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_l_cnt" readonly id="div_l_cnt" /> </td>
						<th> + </th>
						<th style='color:red'>Not Received</th>
						<td><input type="text" style="width:50px;" value="" class="input2" name="div_nr_cnt" readonly id="div_nr_cnt" /> </td>
					</tr>	
					<tr>
						<td colspan="20"> * EORI No Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp" target="_blank">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp  </a></td>
					</tr>
					<tr>
						<td colspan="20"> * HS Code Validation : <a target='_blank' href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en" target="_blank">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en</a></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_grid clear" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_grid clear" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<div class="opus_design_grid clear" style="display:none">
		<script type="text/javascript">ComSheetObject('sheetDownload');</script>
	</div>
</form>
