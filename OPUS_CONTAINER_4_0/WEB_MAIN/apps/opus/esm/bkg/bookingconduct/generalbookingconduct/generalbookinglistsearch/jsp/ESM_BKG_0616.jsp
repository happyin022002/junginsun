<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0616.jsp
*@FileTitle  : Booking EDI Transmit to Terminal 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0616Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List" %>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO" %>
<%@ page import="com.clt.apps.opus.esm.bkg.common.*" %>

<%
	EsmBkg0616Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingListSearch");
	String usrCntCd = null;
	List<BkgComboVO> bkg_sts_cd = null;
	List<BkgComboVO> ack_cd = null;
	List<BkgComboVO> edi_msg = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0616Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		usrCntCd = (String) eventResponse.getCustomData("cnt_cd");
		bkg_sts_cd = (List<BkgComboVO>) eventResponse.getCustomData("bkg_sts_cd");
		ack_cd = (List<BkgComboVO>) eventResponse.getCustomData("ack_cd");
		edi_msg = (List<BkgComboVO>) eventResponse.getCustomData("edi_msg");

	}catch(Exception e) {
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


<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="usr_cnt_cd" value="<%=usrCntCd%>">

<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn1_retrieve" 	id="btn1_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn1_new"  		id="btn1_new">New</button><!--
	--><button type="button" class="btn_normal" name="btn1_DownExcel" 	id="btn1_DownExcel">Down Excel</button><!--
	--></div>
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
<div class= "opus_design_inquiry wFit">
	<table>
		<colgroup>
			<col width="40"/>
			<col width="110"/>
			<col width="80"/>
			<col width="200"/>
			<col width="80"/>
			<col width="80"/>
			<col width="80"/>
			<col width="80"/>
			<col width="100"/>
			<col width="80"/>
			<col width="60"/>
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th class="sm">Type</th>
				<td class="sm"><!--
				--><input type="radio" name="search_type" value="" class="trans" onClick="javascript:clickSearchType();" checked>General <!--
				--><input type="radio" name="search_type" value="" class="trans" onClick="javascript:clickSearchType();">USA<!--
				--></td>
				<th><input type="radio" name="date_type" value="1" class="trans" checked="checked" />BKG
					<input type="radio" name="date_type" value="2" class="trans" />EDI Send</th>
				<td><!--
				--><input type="text" style="width:75px" maxlength="10" class="input1" name="bkg_from_dt" caption="BKG DT" dataformat="ymd">~ <!--
				--><input type="text" style="width:75px" maxlength="10" class="input1" name="bkg_to_dt" caption="BKG DT" dataformat="ymd"><!--
				--><button type="button" id="btns_calendar" name="btns_calendar" class="calendar ir"></button><!--
				--></td>
				<th>BKG OFC</th>
				<td><!--
				--><input type="text" name="bkg_ofc_cd" style="width:45px;" maxlength="6" dataformat="engup" class="input" value=""> 
				</td>
				<th>BKG Status</th>
				<td><!--
				--><%=HTMLUtil.getComboString("bkg_sts_cd", "width:70px;", "", "","","All", bkg_sts_cd)%><!--
				--></td>
				<th>EDI Send Status</th>
				<td><!--
				--><select style="width:45px;" name="edi_send_sts_cd"><!--
					--><option value="0" selected>All</option><!--
					--><option value="Y">Yes</option><!--
					--><option value="N">No</option><!--
				--></select><!--
				--></td>
				<th>ACK</th>
				<td><!--
				--><%=HTMLUtil.getComboString("ack", "width:45px;", "", "","","All", ack_cd)%><!--
				--></td>
			</tr>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" name="vvd" id="vvd" style="width:85px" maxlength="9" dataformat="engup" class="input1" value="" caption="VVD"></td>
				<th title="Port of Loading">POL</th>
				<td><!--
				--><input type="text" name="pol_cd"  id="pol_cd" style="width:65px;" maxlength="5" dataformat="engup" class="input1" value="" caption="POL"><!--
				--><input type="text" name="pol_yd_cd" maxlength="2" dataformat="engup" style="width:25px;" value="" class="input1"><!--
				--></td>
				<th>Lane</th>
				<td><!--
				--><input type="text" name="slan_cd"  id="slan_cd" style="width:42px;" maxlength="3" dataformat="engup" class="input" value=""><!--
				--></td>
				<th>BKG No.</th>
				<td><!--
				--><input type="text" name="bkg_no"  id="bkg_no" style="width:100px;" maxlength="13" dataformat="engup" class="input1" value="" caption="BKG NO"><!--
				--></td>
				<th>BKG Staff</th>
				<td><!--
				--><input type="text" name="bkg_staff" id="bkg_staff" style="width:75px;" maxlength="20" dataformat="engup" class="input" value=""><!--
				--></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<div class="opus_design_btn">
			<span class="grid_option_left"><strong>EDI Message&nbsp;&nbsp;</strong><%=HTMLUtil.getComboString("brac_cd", "width:75px;", "", "","","All", edi_msg)%></span>
				<button type="button" class="btn_normal" name="btn2_BatchEDI" id="btn2_BatchEDI">Batch EDI</button><!-- 
			--><button type="button" class="btn_normal" name="btn2_EDITransmit" id="btn2_EDITransmit">EDI Transmit</button><!--
			--><button type="button" class="btn_normal" name="btn2_CheckAll"id="btn2_CheckAll">Check All</button><!--
			--><button type="button" class="btn_normal" name="btn2_UncheckAll" id="btn2_UncheckAll">Uncheck All</button><!--
			--><button type="button" class="btn_normal" name="btn2_Save" id="btn2_Save">Save</button><!--
			--></div>
		<script type="text/javascript">
			ComSheetObject('sheet1');
		</script>
		<script type="text/javascript">
			ComSheetObject('sheet2');
		</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="80"/>
				<col width="80"/>
				<col width="40"/>
				<col width="80"/>
				<col width="60"/>
				<col width="80"/>
				<col width="80"/>
				<col width="80"/>
				<col width="80"/>
				<col width="80"/>
				<col width="60"/>
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>Total Booking</th>
						<td><input type="text" name="bkg_total" id="bkg_total"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
						<th>CRN</th>
						<td><input type="text" name="crn" id="crn"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
						<th>EDI Sent</th>
						<td><input type="text" name="sent" id="sent"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
						<th>EDI Unsent</th>
						<td><input type="text" name="unsent" id="unsent"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
						<th>ACK Received</th>
						<td><input type="text" name="ack_cnt" id="ack_cnt"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
						<th>TML Error</th>
						<td><input type="text" name="tml" id="tml"style="width: 60px; text-align: right" class="noinput" value=""readOnly></td>
					</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
</form>