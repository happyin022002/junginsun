<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0647.jsp
*@FileTitle  : B/L Status Report 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/02
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event.EsmBkg0647Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0647Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //DB ResultSet List count

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.CndManifestListDownload");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0647Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="pagerows"> 
	<input type="hidden" name="rows_per_page"  value="50">
	<input type="hidden" name="curr_page"      value="1">
 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table >
		<tbody>
			<colgroup>
				<col width="105" />
				<col width="400" />
				<col width="200" />
				<col width="60"/>
				<col width="50" />
				<col width="50" />
				<col width="*" />
			</colgroup>
			<tr>
				<th class="sm">Duration Option</th>
				<td class="sm">
					<input type="radio" class="trans" name="dura_opt" id="dura_opt1" value="OB" checked><label for = "dura_opt1">On Board</label><!--
					--><input type="radio" class="trans" name="dura_opt" id="dura_opt2" value="BC"><label for = "dura_opt2">BKG Create</label><!--
					--><input type="radio" class="trans" name="dura_opt" id="dura_opt3" value="BI"><label for = "dura_opt3">B/L Issue</label><!--
					--><input type="radio" class="trans" name="dura_opt" id="dura_opt4" value="OS"><label for = "dura_opt4">OB/L Surrender</label><!--
					--><input type="radio" class="trans" name="dura_opt"id="dura_opt5"  value="OR"><label for = "dura_opt5">OB/L Receive</label>
				</td>
				<td class="sm">
					<input type="text" style="width:75px;" value="" class="input1" name="dura_from_dt" id="dura_from_dt"  maxlength='10' dataformat="ymd"><!--
					--><span class="dash">~</span><!--
					--><input type="text" style="width:75px;" value="" class="input1" name="dura_to_dt" id="dura_to_dt"  maxlength='10' dataformat="ymd"><!--
					--><button type="button" class="calendar ir" name="btn_dura_date" id="btn_dura_date"></button>
				</td>
				<th>B/L Type</th>
				<td class="sm">
					<input type="checkbox" class="trans" name="bl_type_ori" id="bl_type_ori" value="Y"><!--
					--><label for = "bl_type_ori">Original B/L</label>
				</td>
				<td class="sm">
					<input type="checkbox" class="trans" name="bl_type_way" id="bl_type_way" value="Y"><!--
					--><label for = "bl_type_way">Waybill</label>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="5" />
				<col width="30" />
				<col width="110" />
				<col width="30" />
				<col width="80" />
				<col width="30" />
				<col width="80" />
				<col width="30" />
				<col width="80" />
				<col width="30" />
				<col width="80" />
				<col width="80" />
				<col width="80" />
				<col width="100" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<input type="text" style="width:90px;"   value=""  name="vvd_cd" id="vvd_cd" maxlength='9'  fullfill  dataformat='engup' style="ime-mode:disabled" class="input1" >
				</td>
				<th title="Port of Loading">POL</th>
				<td>
					<input type="text" style="width:60px;"   value="" name="pol_cd" id="pol_cd"  maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">
				</td>
				<th title="Port of Discharging">POD</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="pod_cd" id="pod_cd"  maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">
				</td>
				<th title="Place of Receipt">POR</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="por_cd" id="por_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">
				</td>
				<th title="Place of Delivery">DEL</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="del_cd" id="del_cd" maxlength='5' dataformat='engup' style="ime-mode:disabled" class="input">
				</td>
				<th>DEL Control Office</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="del_ofc_cd" id="del_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
				<th>OB/L Surrender Office</th>
				<td>
					<input type="text" style="width:75px;"    value="" name="obl_ofc_cd" id="obl_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="5" />
				<col width="88" />
				<col width="86" />
				<col width="80" />
				<col width="87" />
				<col width="90" />
				<col width="86" />
				<col width="100" />
				<col width="83" />
				<col width="30" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>Booking Office</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="bkg_ofc_cd" id="bkg_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
				<th>Sales Office</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="sal_ofc_cd" id="sal_ofc_cd"  maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
				<th>B/L Issue Office</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="bl_ofc_cd" id="bl_ofc_cd" maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
				<th>OB/L Receive Office</th>
				<td>
					<input type="text" style="width:60px;"    value="" name="obl_rcv_ofc_cd" id="obl_rcv_ofc_cd"  maxlength='6' dataformat='enguponly' style="ime-mode:disabled" class="input">
				</td>
				<th>By</th>
				<td><select style="width:103;" class="input2" name="by_cd">
					<option value="BS">Booking Staff</option>
					<option value="SR">Sales Rep</option>
					<option value="BR">B/L Ready</option>
					<option value="BI">B/L Issue</option>
					<option value="OR">OBL Receive</option>
					</select>&nbsp;<input type="text" style="width:114px;" value="" name="staff_id" id="staff_id"  maxlength='20' dataformat='eng' style="ime-mode:disabled" class="input">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>	
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="122" />
				<col width="115" />
				<col width="31" />
				<col width="260" />
				<col width="100" />
				<col width="115" />
				<col width="82" />
				<col width="*" />
			</colgroup>
			<tr>
				<td></td>
				<th>
					<input type="radio" class="trans" name="bkg_bl_cd" id="bkg_bl_cd1" value="BKG" onClick="setSchKey(this.value)"><label for = "bkg_bl_cd1">BKG</label><!--
					--><input type="radio" class="trans" name="bkg_bl_cd" id="bkg_bl_cd2" value="BL" checked onClick="setSchKey(this.value)"><label for = "bkg_bl_cd2">B/L No.</label>
				</th>
				<td>
					<input type="text" style="width:106px;" value="" name="bkg_bl_no" maxlength='12' dataformat='engup' style="ime-mode:disabled" class="input">
				</td>
				<th>Cust</th>
				<td>
					<script type="text/javascript">ComComboObject('cust_tp_cd', 2, 50, true, '');</script><!--
					--><input type="text" style="width:25px" value="" class="input" name="cust_cnt_cd" maxlength='2' dataformat='enguponly' style="ime-mode:disabled"><!--
					--><input type="text" style="width:60px" value="" class="input" name="cust_seq" maxlength='6' dataformat='num' style="ime-mode:disabled"><!--
					--><input type="text" style="width:103px" value="" class="input" name="cust_nm" maxlength='50' dataformat='engup' style="ime-mode:disabled">
				</td>
				<th>
					<input type="radio" class="trans" name="sc_rfa_cd" id="sc_rfa_cd1" value="SC"><label for = "sc_rfa_cd1">S/C</label><!--
					--><input type="radio" class="trans" name="sc_rfa_cd" id="sc_rfa_cd2" value="RFA" checked ><label for = "sc_rfa_cd2">RFA</label>
				</th>
				<td><input type="text" style="width:106px;" value="" name="sc_rfa_no" maxlength='20' dataformat='engup' style="ime-mode:disabled" class="input"></td>
				<th>B/L Status</th>
				<td><select style="width:125;" class="input2" name="bl_sts_cd">
						<option value="" selected></option>			
						<option value="DCP">B/L Completed</option>
						<option value="NCP">B/L Non-Completed</option>		
						<option value="ISS">B/L Issued</option>
						<option value="NIS">B/L Non-Issued</option>
						<option value="PRI">B/L Printed</option>
						<option value="NPR">B/L Non-Printed</option>
						<option value="REL">B/L Released</option>
						<option value="NRL">B/L Non-Released</option>
						<option value="SUR">B/L Surrendered</option>
						<option value="REC">B/L Received</option>
						<option value="CFM">B/L Confirmed</option>
						<option value="NCF">B/L Non-confirmed</option>					
					</select></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid clear" style="width:100%">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</form> 