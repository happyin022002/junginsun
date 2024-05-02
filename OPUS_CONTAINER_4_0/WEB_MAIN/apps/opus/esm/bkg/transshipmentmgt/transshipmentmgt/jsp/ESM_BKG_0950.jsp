<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0950.jsp
*@FileTitle  : Relay Vessel Group Assign by Relay Port
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
<%@ page import="com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0950Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0950Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0950Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows"> 
<input type="hidden" name="assignFlag"> 
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_downexcel"  	id="btn_downexcel">Down Excel</button><!--	
		--><button type="button" class="btn_normal" name="btn_CheckAll" id="btn_CheckAll">Check All</button><!--
		--><button type="button" class="btn_normal" name="btn_UnCheckAll"  	id="btn_UnCheckAll">UnCheck All</button><!--
		--><button type="button" class="btn_normal" name="btn_vvdassign"  	id="btn_vvdassign">VVD Assign</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry">
		<table> 
			<colgroup>
				<col width="80">
				<col width="130">
				<col width="80">
				<col width="220">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Relay Port</th>
					<td><input type="text" style="width:50px;" class="input1" name="loc_cd" id="loc_cd"  maxlength="5" dataformat="engup"><!-- 
						 --><input type="text" style="width:25px;" class="input1" name="loc_yd_cd" maxlength="2" dataformat="engup"><!-- 
						 --><button type="button" name="btn_relay" id="btn_relay" class="input_seach_btn" onClick="openPopup('setPolCd')"></button>
					</td>
					<th>ETB Duration </th>
					<td><input type="text" style="width:80px;" class="input1" value="" dataformat="ymd" name="dur_from" id="dur_from"><!--
					--><span class="dash">~</span><!--  
						 --><input type="text" style="width:80px;" class="input1" value="" dataformat="ymd" name="dur_to" id="dur_to"><!-- 
						 --><button type="button" class="calendar ir" name="btn_duration" id="btn_duration"></button>
					</td>
					<th>Former VVD</th>
					<td><input type="text" style="width:80px;" class="input" name="formerVVD" id="formerVVD" maxlength="9" dataformat="engup"></td>	
				</tr>
			</tbody>
		</table> 
		<table> 
			<colgroup>
				<col width="80">
				<col width="130">
				<col width="80">
				<col width="90">
				<col width="40">
				<col width="90">
				<col width="100">
				<col width="*">
			</colgroup>
			<tbody>
				<tr>
					<th>Next VVD</th>
					<td><input type="text" style="width:108px;" class="input" name="nextVVD" id="nextVVD" maxlength="9" dataformat="engup"></td>
					<th>Next Port</th>
					<td><input type="text" style="width:60px;" class="input" name="nextPort" id="nextPort" maxlength="5" dataformat="engup"></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:73px;" class="input" name="pol_cd" id="pol_cd" maxlength="5" dataformat="engup"></td>
					<th title="Port of Discharging">POD</th>
					<td><input type="text" style="width:70px;" class="input" name="pod_cd" id="pod_cd" maxlength="5" dataformat="engup"></td>
				</tr>
			</tbody>
		</table> 	
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
</div>
	<!-- opus_design_grid(E) -->
</form>
