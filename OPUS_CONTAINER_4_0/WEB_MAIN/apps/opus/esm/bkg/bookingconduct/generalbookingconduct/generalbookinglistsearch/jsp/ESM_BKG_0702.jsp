<%
/*  =========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   ESM_BKG_0702.jsp
 *@FileTitle  : Booking Receipt Draft BL EDI
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/04/08
 ========================================================= */
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0702Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg0702Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String pgmNo = "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");
	List<BkgComboVO> bkg_cust_tp_cd = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0702Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		pgmNo = JSPUtil.getParameter(request, "pgmNo");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		bkg_cust_tp_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_cust_tp_cd");

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
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="pgm_no" name="pgm_no" value="<%=pgmNo%>">
<input type="hidden" id="key" name="key" value="">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!-- 
	 --><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!-- 
	   --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="1%">
					<col width="1%">
					<col width="1%">
					<col width="7%">
					<col width="1%">
					<col width="1%">
					<col width="5%">
					<col width="1%">
					<col width="5%">
					<col width="1%">
					<col width="5%">
					<col width="1%">
					<col width="5%">
					<col width="*">
				</colgroup>
				<tr>
					<th class="sm">Type</th>
					<td class="sm"  colspan="2"><!-- 
					 --><input type="radio" name="type_gbn" id="type_gbn" value="B" class="trans" onClick="javascript:checkType();"checked>&nbsp;&nbsp;&nbsp;Booking Receipt&nbsp;&nbsp;&nbsp;<!-- 
					  --><input type="radio" name="type_gbn" id="type_gbn" value="D" onClick="javascript:checkType();" class="trans">&nbsp;&nbsp;Draft B/L</td>
					<th>BKG Date</th>
					<td colspan="2"><input type="text" style="width: 75px" maxlength="10" class="input1" name="bkg_from_dt" id="bkg_from_dt" caption="BKG DT" dataformat="ymd">~&nbsp;<!-- 
					  --><input type="text" style="width: 75px" maxlength="10" class="input1" name="bkg_to_dt" id="bkg_to_dt" caption="BKG DT" dataformat="ymd"><!-- 
					  --><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" name="vvd" id="vvd" style="width: 85px" maxlength="9" dataformat="engup" value="" class="input1"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="pol_cd" id="pol_cd" style="width: 55px;" maxlength="5" dataformat="engup" value="" class="input"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" name="pod_cd" id="pod_cd" style="width: 55px;" maxlength="5" dataformat="engup" value="" class="input"></td>
					<th title="Place of Delivery">DEL</th>
					<td><input type="text" name="del_cd" id="del_cd" style="width: 55px;" maxlength="5" dataformat="engup" value="" class="input"></td>
				</tr>
			<tr>
					<th>BKG Office</th>
					<td><input type="text" name="bkg_ofc_cd" id="bkg_ofc_cd" style="width: 90px;" maxlength="6" dataformat="engup" class="input" value=""></td>
					<th>BKG Staff</th>
					<td><input type="text" name="bkg_stf_cd" id="bkg_stf_cd" style="width: 95px;" maxlength="20" dataformat="engup" class="input" value=""></td>
					<th>Sales Office</th>
					<td><input type="text" name="sls_ofc_cd" id="sls_ofc_cd" style="width: 93px;" maxlength="6" dataformat="engup" class="input" value=""></td>
					<th>Sales Rep.</th>
					<td><input type="text" name="sales_rep" id="sales_rep" maxlength="5" dataformat="engup" style="width: 85px" class="input" value=""></td>
					<th>B/L Office</th>
					<td><input type="text" name="bl_ofc_cd" id="bl_ofc_cd" style="width: 70px;" maxlength="6" dataformat="engup" value=""class="input"></td>
				</tr>
				<tr>
					<th>Booking No.</th>
					<td>
						<input type="text" name="bkg_no" id="bkg_no" style="width: 90px;" maxlength="13" dataformat="engup" class="input1"value="">
						<button type="button" class="multiple_inq ir" style="background: url(./style/images/theme_default/sprite_common.png) -98px -157px no-repeat; background-color:#fff;" name="btn_multBkgNo" id="btn_multBkgNo"></button>	
					</td>
					<th>B/L No.</th>
					<td width=""><input type="text" id="bl_no" name="bl_no" style="width: 95px;" maxlength="13" dataformat="engup" class="input1" value=""></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="76">
					<col width="100">
					<col width="96">
					<col width="200">
					<col width="90">
					<col width="100">
					<col width="100">
					<col width="*">
				</colgroup>
				<tr>
					<th>S/C No.</th>
					<td><input type="text" name="sc_no" style="width: 90px;" maxlength="11" dataformat="engup" class="input"value=""></td>
					<th>Customer</th>
					<td><%=HTMLUtil.getComboString("cust_tp_cd", "width:95px;", "","", "", "All", bkg_cust_tp_cd)%><!--
						 --><input type="text" id="cust_cnt_cd" name="cust_cnt_cd" maxlength="2" dataformat="engup" style="width: 25px;" class="input" value=""><!--
						 --><input type="text" id="cust_seq" name="cust_seq" maxlength="6" dataformat="engup" style="width: 55px;" class="input" value=""><!--
						 --><input type="text" id="cust_nm" name="cust_nm" maxlength="50" dataformat="engup" style="width: 90px;" class="input" value="">
					</td>
					<th>EDI Receiver</th>
					<td><!-- 
					 --><select style="width: 120px;" name="edi_group_id" id="edi_group_id">
					  <option	value="G" selected>Group ID</option>
					   <option value="R">Receive ID</option>
					    <option value="N">Receiver Name</option>
					     </select>&nbsp;<!-- 
						 --><input type="text" id="edi_receive_nm" name="edi_receive_nm" maxlength="20" dataformat="engup" style="width: 90px;" class="input" value=""></td>
					<th>EDI Sent Status</th>
					<td>
					 <select style="width: 70px;" id="edi_sent_sts_cd" name="edi_sent_sts_cd">
					  <option value="All" selected>All</option>
					   <option value="N">Unsent</option>
					    <option value="Y">Sent</option>
					     </select></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
			 --><button type="button" class="btn_accent" name="btn_SendtoCustomer" id="btn_SendtoCustomer">Send to Customer</button><!-- 
			  --><button type="button" class="btn_normal" name="btn_SendtoTerminal" id="btn_SendtoTerminal" style="display: none;">Send to Terminal</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		<!-- opus_design_grid(E) -->
		
		<!-- opus_design_data(S) -->
			<table class="grid_2" style="width:700px">
				<colgroup>
					<col width="10%">
					<col width="1%">
					<col width="10%">
					<col width="5%">
					<col width="10%">
					<col width="1%">
					<col width="10%">
					<col width="*">
				</colgroup>
				<tr>
					<th>Total</th>
					<td><input type="text" name="total" id="total" style="width: 60px; text-align: right" class="noinput" value="" readOnly></td>
					<th>Success</th>
					<td><input type="text" name="success" id="success" style="width: 60px; text-align: right" class="noinput" value="" readOnly></td>
					<th>Sending</th>
					<td><input type="text" name="send" id="send" style="width: 60px; text-align: right" class="noinput" value="" readOnly></td>
					<th>Un-sent</th>
					<td><input type="text" name="unsent" id="unsent" style="width: 100%; text-align: right" class="noinput" value="" readOnly></td>
				</tr>
			</table>
		</div>
		<!-- opus_design_data(E) -->
	</div>
	<div id='layList' style='position:absolute; z-index:999; display:none; background-color: white;'> <!-- background-color: #d4f6ff; -->
	<table>
		<tr>
			<td>
				<label style="margin-right: 0px;">Rows : </label>
				<label style="margin-right: 0px;" id="rows">000</label>
				<label style="margin-right: 0px;">/</label>
				<label>100</label>
			</td>
		</tr>
	</table>
	<textarea id="mult_bkg_no" name="mult_bkg_no" placeholder="Booking No." class="multi_value mar_none" style="top:0; text-transform: uppercase; width:145px; height: 140px;"></textarea>
</div>
</form>
<script type="text/javascript" for="sheet1" event="OnMouseMove(Button, Shift, X, Y)">
  Row = MouseRow;
  Col = MouseCol;
  if (Col == 15) {
	  sText = CellText(Row,"snd_usr_nm");
	  MouseToolTipText = sText
	  MousePointer = "Hand";
	  window.status = MousePointer;
  }
</script>