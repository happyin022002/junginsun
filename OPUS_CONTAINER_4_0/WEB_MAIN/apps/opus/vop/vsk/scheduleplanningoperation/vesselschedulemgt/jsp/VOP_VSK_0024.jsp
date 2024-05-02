<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_VSK_0024.jsp
*@FileTitle  : Canal Transit List
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
<%@ page import="com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopVsk0024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	Logger log = Logger.getLogger("com.clt.apps.scheduleplanningoperation.vesselschedulemgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		event = (VopVsk0024Event)request.getAttribute("Event");
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
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />

<input type="hidden" name="start_date" id="start_date" />
<input type="hidden" name="end_date" id="end_date" />
<input type="hidden" name="bkg_sts" id="bkg_sts" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_S/PRegistration" id="btn_S/PRegistration" type="button">S/P Registration</button><!--
		-->
		<!-- 
         * 2014.12.23
         * dongsoo 
         * btn_TLCreation, btn_TBCreation hidden 처리 
        -->
		<button class="btn_normal" name="btn_TLCreation" id="btn_TLCreation" type="button" style="display:none">T/L Creation</button><!--
		--><button class="btn_normal" name="btn_TBCreation" id="btn_TBCreation" type="button" style="display:none">T/B Creation</button><!--
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
		<table>
			<colgroup>
				<col width="70" />				
				<col width="230" />				
				<col width="50" />				
				<col width="100"/>	
				<col width="60" />				
				<col width="90" />				
				<col width="70" />	
				<col width="100" />	
				<col width="80" />	
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th>Period</th>
					 <td><!-- 
					 	 --><input name="start_month" type="text" dataformat="ym" style="width:60px;text-align:center;" class="input1" maxlength="6" size="7" id="start_month" /><!-- 
					 	 --><button type="button" id="btn_cal1" name="btn_cal1" class="calendar ir"></button><!-- 
					 	 --><input type="text" style="width:15px;text-align:center;background-color:#f3f2f8;border:0px" value="~" readonly="" tabindex="-1" /><!-- 
					 	 --><input name="end_month" type="text" dataformat="ym" style="width:60px;text-align:center;" class="input1" maxlength="6" size="7" id="end_month" /><!-- 
					 	 --><button type="button" id="btn_cal2" name="btn_cal2" class="calendar ir"></button>
					 </td>
					<th>Port</th>
					<td><select name="port_cd" style="width:80px;" class="input1">
						<option value="EGSCA">EGSCA</option>
						<option value="PAPCA">PAPCA</option></select></td>
					<th>Lane Code</th>
					<td><input type="text" name="vsl_slan_cd" style="width:40px;text-align:center;ime-mode:disabled" class="input" id="vsl_slan_cd" onkeypress="obj_keypress()" onkeyup="obj_keyup()" dataformat="engup"/><!-- 
					 --><button type="button" id="btns_search" name="btns_search" class="input_seach_btn"></button></td>
					<th>Canal Service Provider</th>
					<td><script type="text/javascript">ComComboObject('vndr_seq',1,80,1);</script></td>
					<th>Limit Surcharge</th>
					<td><select style="width:40px;" name="surcharge" class="input">
						<option></option>
						<option value="Y">Y</option>
						<option value="N">N</option></select></td>
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
