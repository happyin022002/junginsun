<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_BKG_1503.jsp
*@FileTitle  : Departure Time Registration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.event.EsmBkg1503Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1503Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //occurring error in server
	String strErrMsg = "";               //error message
	int rowCount = 0;                    //list count of DB ResultSet

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1503Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>


<script type="text/javascript">
	function setupPage() {
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="send_div" id="send_div" value="1">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button><!--
		--><button type="button" class="btn_normal" name="btn_transmit" id="btn_transmit">Transmit</button>
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
	<div class= "opus_design_inquiry">
		<table style="width:600px;">
			<colgroup>
				<col width="40"/>
				<col/>
				<col/>
				<col/>
				<col/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td><input type="text" style="width:110px;" class="input1" name="vvd" maxlength="9" required caption="VVD" dataformat="engup" id="vvd" /></td>
					<th>Cons Voy.</th>
					<td><input type="text" class="input" style="width:80px; ime-mode:disabled;" name="ib_cssm_voy_no" maxlength="10" dataformat="engup" id="ib_cssm_voy_no" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:60px;" required caption="POL" class="input1" name="pol_cd" maxlength="5" dataformat="engup" id="pol_cd" /><!--
					 --><select style="width:45px;" class="input" id="pol_split_no" name="pol_split_no"><option value="" selected></option><% for (int k=1; k<10; k++) { %><option value="<%=k%>"><%=k%></option><% } %></select></td>
				</tr>
			</tbody>
		</table>

		<div class="opus_design_inquiry">
			<table class="line_bluedot"><tr><td></td></tr></table>
		</div>

		<table style="width:600px;">
			<colgroup>
				<col width="40"/>
				<col/>
				<col/>
			</colgroup>
			<tbody>
				<tr>
					<th>ATD</th>
					<td><input type="text" style="width:75px;" name="etd_date" class="input" dataformat="ymd" maxlength="10" caption="ETD DATE" id="etd_date" /><!--
					 --><button type="button" id="btn_calendar" name="btn_calendar" class="calendar ir"></button><!--
					  --><input type="text" style="width:45px;" name="etd_time" class="input" dataformat="hm" maxlength="10" caption="ETD TIME" id="etd_time" /></td>
					<td colspan="2"><label for="rlx_div"><strong>&nbsp;Relaxed</strong></label><input type="checkbox" name="rlx_div" class="trans" value="1" id="rlx_div" /> </td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>
