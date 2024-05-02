<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0021.jsp
*@FileTitle  : VSL SKD Inquiry by Port
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list
 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VSKCommon.VSKCodeFinder");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopVsk0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");



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

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="loc_cd" id="loc_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search sm">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="70" />				
				<col width="200" />				
				<col width="40" />				
				<col width="80" />	
				<col width="80" />				
				<col width="80" />				
				<col width="70" />	
				<col width="80" />	
				<col width="80" />	
				<col width="80" />	
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Period</th>
					<td><input type="text" name="fm_dt" dataformat="ymd" style="width:75px;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" size="10" id="fm_dt" />~&nbsp;<!-- 
					 --><input type="text" name="to_dt" dataformat="ymd" style="width:75px;text-align:center;" class="input1" value="" maxlength="8" size="10" id="to_dt" /><!-- 
					 --><button type="button" id="btn_period" name="btn_period" class="calendar ir"></button></td>
					<th>Port</th>
					<td><input type="text" name="vps_port_cd" style="width:50px;text-align:center;ime-mode:disabled;"  dataformat="engup" class="input" value="" maxlength="5" onfocus="this.select();" id="vps_port_cd" /><!-- 
					 --><button type="button" id="btn_port" name="btn_port" class="input_seach_btn"></button></td>
					<th>Vessel Code</th>
					<td><input type="text" name="vsl_cd" style="width:50px;text-align:center;ime-mode:disabled;" dataformat="engup" class="input" value="" maxlength="4" onfocus="this.select();" id="vsl_cd" /><!-- 
					 --><button type="button" id="btn_vsl_cd" name="btn_vsl_cd" class="input_seach_btn"></button></td>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" style="width:35px;text-align:center;ime-mode:disabled;" dataformat="engup" value="" maxlength="3" onfocus="this.select();" id="vsl_slan_cd" /><!-- 
					 --><button type="button" id="btn_lane_cd" name="btn_lane_cd" class="input_seach_btn"></button></td>
					<th>Carrier Code</th>
					<td><input type="text" style="width:35px;ime-mode:disabled;text-align:center" name="carrier_cd" class="input" maxlength="3" dataformat="engup" value="" onfocus="this.select();" id="carrier_cd" /><!-- 
					 --><button type="button" id="btn_carrier_cd" name="btn_carrier_cd" class="input_seach_btn"></button></td>
					<td class="wrap_search_btn"><input type="radio" name="type_cd" value="" class="trans" checked="checked">&nbsp;<b>All</b>&nbsp;&nbsp;<!-- 
					 --><input type="radio" name="type_cd" value="T" class="trans">&nbsp;<b>Trunk&nbsp;&nbsp;</b><!-- 
					 -->
					 	<!-- 20150407 Off-lane -> Feeder 로 수정 by TaeWoong Kim
				 		Because of User's Request
						 -->	
					 	<input type="radio" name="type_cd" value="O" class="trans">&nbsp;<b>Feeder</b>&nbsp;&nbsp;</td>	
					 <td></td>
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
	</div>
	<!-- opus_design_grid(E) -->
</div>

</form>
