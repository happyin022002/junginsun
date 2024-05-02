<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0617.jsp
*@FileTitle  : Common 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="java.util.Date"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0617Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0617Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");
	String inVvdCd = "";
	String inPolCd = "";
	String isPop = "";
	String toDate = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCd"));
		isPop = StringUtil.xssFilter(request.getParameter("isPop"))==null?"":StringUtil.xssFilter(request.getParameter("isPop"));
		
		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");

		event = (EsmBkg0617Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type ="text/javascript">
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
<input type="hidden" name="in_list_type">
<input type="hidden" name="in_check_gubun">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_cllForEDI" id="btn_cllForEDI">CLL for EDI</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_downExcel" id="btn_downExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_printfor" id="btn_printfor">Print</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>

<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
		<div class="layout_wrap" style="height: 100px">
			<div class="layout_flex_fixed floatR" style="width: 430px">
				<table>
					<colgroup>
						<col width="100" />
						<col width="*" />
					</colgroup>
					<tbody>
						<tr>
							<th id="loadingDate">Loading Date</th>
							<th id="dischargingDate"  style="display:none">Discharging Date</th>	
							<td><input type="text" style="width:75px;" class="input" name="in_cr_edate_start" id="in_cr_edate_start" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled"><!--
							--><span class="dash">~</span><!--
							--><input type="text" style="width:75px;" class="input" name="in_cr_edate_end" id="in_cr_edate_end" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled"><!--
							--><button type="button" class="calendar ir" name="btns_calendar2" id="btns_calendar2"></button></td>
						</tr>
					</tbody>
				</table>
				<table style="width:294px;" id="searchGubun" class="mar_top_4"> 
					<tr class="tr2_head">
						<td style="border: 1px solid #B8D6F6; width="100px" align="center" colspan="2" class = "sm"><b>Data Cross-Check</b></td>
						</tr>
					<tr>
						<td style="border: 1px solid #B8D6F6; text-align:center;" class ="sm">Booking</td>
						<td style="border: 1px solid #B8D6F6; text-align:center;"><!--
						--><input type="checkbox" name="in_check_gubun_temp1" id="in_check_gubun_temp1" value="" class="trans" onclick="setSearchGubun('1')"><!--
						--><label for = "in_check_gubun_temp1">Matched</label><input type="checkbox" name="in_check_gubun_temp2" id="in_check_gubun_temp2" value=""class="trans" onclick="setSearchGubun('2')"><!--
						--><label for = "in_check_gubun_temp2">Un-matched</label></td>
					</tr>
					<tr>
						<td style="border: 1px solid #B8D6F6; text-align:center;" class ="sm">CLL</td>
						<td style="border: 1px solid #B8D6F6; text-align:center;"><input type="checkbox" name="in_check_gubun_temp3" value="" class="trans" onclick="setSearchGubun('3')"><label for = "in_check_gubun_temp3">Matched</label><input type="checkbox" name="in_check_gubun_temp4" value=""class="trans" onclick="setSearchGubun('4')"><label for = "in_check_gubun_temp4">Un-matched</label></td>
					</tr>
				</table>
			</div>
			<div class="layout_flex_flex" style="padding-right: 458px">
				<table>
					<colgroup>
						<col width="110"/>
						<col width="230"/>
						<col width="80"/>
						<col width="290" />
						<col width="*" />
					</colgroup>
					<tbody>
					<tr>
						<th>EDI Receiving Date</th>
						<td><input type="text" style="width:75px;" class="input" name="in_cr_indate_start" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=toDate%>"><!--
						--><span class="dash">~</span><!--
						--><input type="text" style="width:75px;" class="input" name="in_cr_indate_end" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=toDate%>"><!--
						--><button type="button" class="calendar ir" name="btns_calendar" id="btns_calendar"></button></td>
						<th>List Type</th>
						<td class="sm pad_left_8"><!--
						--><input type="radio" name="in_list_type_temp" id="in_list_type_temp1" value="" class="trans" checked onclick="setListTeye('searchGubun','L')"><label for = "in_list_type_temp1">Loading(Outbound)</label><!--
						--><input type="radio" value="" name="in_list_type_temp" id="in_list_type_temp2" class="trans" onclick="setListTeye('searchGubun','D')"><label for = "in_list_type_temp2">Discharging(Inbound)</label></td>
						<td></td>
					</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="110"/>
						<col width="90"/>
						<col width="40"/>
						<col width="100"/>
						<col width="80"/>
						<col width="100"/>
						<col width="100"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Yard</th>	
							<td><input type="text" style="width:80px;" class="input" name="in_cr_yard" value="" maxlength="7" dataformat="engup" style="ime-mode:disabled"></td>
							<th title="Vessel Voyage Direction">VVD</th>
							<td><input type="text" style="width:90px;" class="input" name="in_vvd_cd" value="<%=inVvdCd %>" maxlength="9" dataformat="engup" style="ime-mode:disabled"></td>
							<th title="Port of Loading">POL</th>
							<td><input type="text" style="width:70px;" class="input" name="in_pol_cd" value="<%=inPolCd %>" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
							<th title="Port of Discharging">POD</th>
							<td><input type="text" style="width:70px;" class="input" name="in_pod_cd" value="" maxlength="5" dataformat="engup" style="ime-mode:disabled"></td>
						</tr>
					</tbody>
				</table>
				<table>
					<colgroup>
						<col width="110"/>
						<col width="230"/>
						<col width="80"/>
						<col width="100"/>
						<col width="100"/>
						<col width="*"/>
					</colgroup>
					<tbody>
						<tr>
							<th>Vessel Name</th>
							<td><input type="text" style="width:220px;" class="input" name="in_cr_vslname" value="" maxlength="20" dataformat="engupetc" otherchar="" style="ime-mode:disabled"></td>
							<th>Call Sign</th>
							<td><input type="text" style="width:90px;" class="input" name="in_cr_callsign" value="" maxlength="15" dataformat="engup" style="ime-mode:disabled"></td>
							<th>Container No.</th>
							<td><input type="text" style="width:90px;" class="input" name="in_cntr_no" value="" maxlength="11" dataformat="engup" style="ime-mode:disabled"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<!-- opus_design_inquiry(E) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->	
</div>
</form>