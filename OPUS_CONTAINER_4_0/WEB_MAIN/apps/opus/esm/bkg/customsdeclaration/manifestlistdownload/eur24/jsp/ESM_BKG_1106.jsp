<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1106.jsp
*@FileTitle  : Europe Advanced Manifest  : ENS Download  & Transmit
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
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

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
<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="call_type" value="ESM_BKG_1106" id="call_type" />
<input type="hidden" name="p_send_yn" value="" id="p_send_yn" />
<input type="hidden" name="p_search_pofe_yard_cd" value="" id="p_search_pofe_yard_cd" />
<input type="hidden" name="pgmNo" value="<%=strPgmNo%>" id="pgmNo" />
<input type="hidden" name="p_first_of_multi_pofe_cd" value="" id="p_first_of_multi_pofe_cd" />
<input type="hidden" name="p_down_yn_first_of_multi_pofe" value="" id="p_down_yn_first_of_multi_pofe" />
<input type="hidden" name="eu_1st_port_clpt_seq" value="" id="eu_1st_port_clpt_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button" style="display:none">Data Delete</button><!--
		--><button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_DownExcel" id="btn_DownExcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_EDIDownload" id="btn_EDIDownload" type="button">Data Download</button><!--
		--><button class="btn_normal" name="btn_Inquiry" id="btn_Inquiry" type="button">Manifest(B/L)</button><!--
		--><button class="btn_normal" name="btn_Transmit" id="btn_Transmit" type="button">EDI Transmit</button><!--
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
		<table class="mar_top_4">
			<colgroup>
				<col width="40" />				
				<col width="120" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Type</th>
		   			<td><script type="text/javascript">ComComboObject('p_type', 1, 120, '');</script></td>
		   			<td></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<div class="line_bluedot"></div>
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="200">
				<col width="30">
				<col width="130">
				<col width="30">
				<col width="170">
				<col width="20">
				<col width="70">
				<col width="125">
				<col width="70">
				<col width="120">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
				    <td class="sm pad_left_8"><input type="radio" name="p_data_cd" id="p_data_cd1" value="BL" class="trans" checked /><label for="p_data_cd1">B/L Data</label><!--
				    --><input type="radio" name="p_data_cd" id="p_data_cd2" value="DL" class="trans" /><label for="p_data_cd2">Download Data</label></td>
				    <td></td>
					<td class="sm pad_left_8"><input type="radio" name="p_error_cd" value="" class="trans" checked id="p_error_cd1" /><label for="p_error_cd1">All</label><!--
					--><input type="radio" name="p_error_cd" value="E" class="trans" id="p_error_cd2" /><label for="p_error_cd2">Error  B/L</label></td>
					<td></td>
					<td class="sm pad_left_8"><input type="radio" name="p_ori_amd_cd" value="O" class="trans" checked id="p_ori_amd_cd1" /><label for="p_ori_amd_cd1">Original</label><!--
					--><input type="radio" name="p_ori_amd_cd" value="A" class="trans" id="p_ori_amd_cd2" /><label for="p_ori_amd_cd2">To Amend</label></td>
					<td></td>
					<th>BKG OFC</th>
					<td><input type="text" style="width:80px;" class="input" name="p_b_ofc_cd" maxlength="6" dataformat="enguponly" id="p_b_ofc_cd" /></td>
					<th>Sales OFC</th>
					<td><input type="text" style="width:80px;" class="input" name="p_s_ofc_cd" maxlength="6" dataformat="enguponly" id="p_s_ofc_cd" /></td>
					<th>BKG Staff</th>
					<td><input type="text" style="width:120px;" class="input" name="p_b_staff" value="" maxlength="20" dataformat="engup" id="p_b_staff" /></td>
				</tr>	
			</tbody>
		</table>
		<table id="ensView"> 
			<colgroup>
				<col width="40">
				<col width="110">
				<col width="50">
				<col width="110">
				<col width="150">
				<col width="120">
				<col width="70">
				<col width="120">
				<col width="69">
				<col width="117">
				<col width="72">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;" class="input1" name="p_vvd_cd" value="" maxlength="9" dataformat="engup" id="p_vvd_cd" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" class="input1" name="p_pol_cd" value="" maxlength="5" dataformat="engup" id="p_pol_cd" /><!--
					--><input type="text" style="width:30px;" class="input" name="p_pol_yard_cd" maxlength="2" dataformat="engup" id="p_pol_yard_cd" /></td>
					<th>POFE (Port of First Entry)</th>
					<td>
						<script type="text/javascript">ComComboObject('p_pod_cd_temp', 1, 110, '');</script><!--
						--><input type="hidden" style="width:70px;" class="input1" name="p_pod_cd" value="" maxlength="5" dataformat="engup" id="p_pod_cd" /><!--
						--><!--<input type="text" style="width:70px;" class="input1" name="p_pod_cd" value="GRPIR" maxlength='5' dataformat='engup' style="ime-mode:disabled" >--><!--
						--><input type="hidden" style="width:30px;" class="input" name="p_pod_yard_temp" maxlength="2" dataformat="engup" readonly="" id="p_pod_yard_temp" /><!--
						--><input type="hidden" style="width:30px;" class="input" name="p_pod_yard_cd" maxlength="2" dataformat="engup" id="p_pod_yard_cd" /></td>
					<th>B/L No.</th>
					<td><input type="text" style="width:120px;" class="input" name="p_bl_no" value="" maxlength="12" dataformat="engup" id="p_bl_no" /></td>
					<th>L/T</th>
					<td>
						<select style="width: 70px;" name="p_lt">
							<option value="" selected>All</option>
							<option value="L">Local</option>
							<option value="T">T/S</option>
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
			</tbody>
		</table>
		<table id="fiView"> 
			<colgroup>
				<col width="40">
				<col width="150">
				<col width="80">
				<col width="110">
				<col width="80">
				<col width="110">
				<col width="80">
				<col width="130">
				<col width="67">
				<col width="117">
				<col width="70">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:100px;" class="input1" name="p_fi_vvd_cd" value="" maxlength="9" dataformat="engup" id="p_fi_vvd_cd" /></td>
					<th>Pre EU Port</th>
					<td><input type="text" style="width:60px;" class="input2" name="p_fi_pol_cd" value="" maxlength="5" dataformat="engup" readonly="" id="p_fi_pol_cd" /><!--
					--><input type="text" style="width:30px;" class="input2" name="p_fi_pol_yard_cd" maxlength="2" dataformat="engup" readonly="" id="p_fi_pol_yard_cd" /></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:60px;" class="input1" name="p_fi_pod_cd" value="FIKTK" maxlength="5" dataformat="engup" id="p_fi_pod_cd" /><!--
					--><input type="text" style="width:30px;" class="input" name="p_fi_pod_yard_cd" maxlength="2" dataformat="engup" id="p_fi_pod_yard_cd" /></td>
					<th>BL/No</th>
					<td><input type="text" style="width:120px;" class="input" name="p_fi_bl_no" value="" maxlength="12" dataformat="engup" id="p_fi_bl_no" /></td>
					<th>L/T</th>
					<td>
						<select style="width: 70px;" name="p_fi_lt">
							<option value="" selected>All</option>
							<option value="L">Local</option>
							<option value="T">T/S</option>
						</select>
					</td>										
					<th>Ack. Status</th>
					<td>
						<select style="width: 120px;" name="p_fi_ack_status">
							<option value="" selected>All</option>
							<option value="A">Accepted</option>
							<option value="R">Rejected</option>
							<option value="DNL">Do Not Load</option>
							<option value="NR">Not Received</option>
							<option value="NA">N/A</option>
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
	<div class="opus_design_grid">
		<table class="grid2"> 
			<tr class="st">
				<td  id="div_option" name="div_option" ></td>
			</tr>	
		</table>
		   <script type="text/javascript">ComSheetObject('sheet1');</script> 
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_data (S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="70" />
                    <col width="100"  />
                    <col width="70"  />
                    <col width="70"  />
                    <col width="30" />
                    <col width="80"  />
                    <col width="70" />
                    <col width="30"  />
                    <col width="60" />
                    <col width="70"  />
                    <col width="30" />
                    <col width="80" />
                    <col width="70"  />
                    <col width="30" />
                    <col width="80" />
                    <col width="*"  />
				</colgroup>
				<tr>
					<th><strong>Total B/L</strong></th>
					<td><input type="text" style="width:70px;" value="" class="input2" id="div_ttl_bl" /></td>
					<th style="color:red;"><strong>Error B/L</strong></th>
					<td><input type="text" style="width:70px;color:red;" value="" class="input2" id="div_ttl_err" /></td>
					<td ></td>
					<th><strong>Total Container</strong></th>
					<td><input type="text" style="width:70px;" value="" class="input2" id="div_ttl_cntr" /><!--
					--><input type="hidden" style="width:70px;" name="port_ofc_cd" value="" id="port_ofc_cd" /></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
					<td ></td>
				</tr>
				<tr>
					<td style="border:none"></td>
					<td style="border:none"></td>
					<th><strong>Sent B/L</strong></th>
					<td><input type="text" style="width:70px;" value="" class="input2" name="div_sent_bl_cnt" readonly id="div_sent_bl_cnt" /></td>
					<td class="pad_left_8 pad_rgt_8"> + </td>
					<th style="color:red;"><strong>Un-Sent B/L</strong></th>
					<td><input type="text" style="width:70px;color:red;" value="" class="input2" name="div_unsent_bl_cnt" readonly id="div_unsent_bl_cnt" /></td>
				</tr>
				<tr>
					<td style="border:none"></td>
					<td style="border:none"></td>
					<th><strong>Sent B/L</strong></th>
					<td><input type="text" style="width:70px;" value="" class="input2" name="div_sent_bl_cnt2" readonly id="div_sent_bl_cnt2" /></td>
					<td class="pad_left_8 pad_rgt_8"> = </td>
					<th><strong>Accepted</strong></th>
					<td><input type="text" style="width:70px;" value="" class="input2" name="div_a_cnt" readonly id="div_a_cnt" /></td>
					<td class="pad_left_8 pad_rgt_8"> + </td>
					<th style="color:red;"><strong>Rejected</strong></th>
					<td><input type="text" style="width:65px;color:red;" value="" class="input2" name="div_r_cnt" readonly id="div_r_cnt" /></td>
					<td class="pad_left_8 pad_rgt_8"> + </td>
					<th style="color:red;"><strong>Do Not Load</strong></th>
					<td><input type="text" style="width:65px;color:red;" value="" class="input2" name="div_dnl_cnt" readonly id="div_dnl_cnt" /></td>
					<td class="pad_left_8 pad_rgt_8"> + </td>
					<th style="color:red;"><strong>Not Received</strong></th>
					<td><input type="text" style="width:70px;color:red;" value="" class="input2" name="div_nr_cnt" readonly id="div_nr_cnt" /></td>
				</tr>
			</tbody>
		</table>
		<br>
		<table>
			<tr>
				<td> * EORI No Validation : <a target="_blank" href="http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp">http://ec.europa.eu/taxation_customs/dds2/eos/eori_validation.jsp  </a></td>
			</tr>
			<tr>
				<td> * HS Code Validation : <a target="_blank" href="http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en">http://ec.europa.eu/taxation_customs/dds2/taric/taric_consultation.jsp?Lang=en  </a></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_data (E) -->
</div>

<div class="wrap_result" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>
</form>