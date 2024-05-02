<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0703.jsp
*@FileTitle  : TRO-Cancel/Frusrate popup
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0703Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0703Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
/*	
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
*/

	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.TransferOrderIssue");

	try {	
/* 		
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
*/ 

		event = (EsmBkg0703Event)request.getAttribute("Event");		

		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


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
		}
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="io_bnd_cd" value="" id="io_bnd_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>TRO - Multi Cancel/Frustrate</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_ok" id="btn_ok" type="button">Ok</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
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
				<col width="80" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Booking No.</th>
					<td><input type="text" name="bkg_no" style="width:100px;" class="input2" value="" readonly id="bkg_no" /></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_CancelAll" id="btn_CancelAll" type="button">Cancel All</button><!--
			--><button class="btn_normal" name="btn_FrustrateAll" id="btn_FrustrateAll" type="button">Frustrate All</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>	
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_data">
		<table>
			<tbody>
				<tr><td>* TRO can be canceled, when S/O status is "No"</td></tr>
				<tr><td>* TRO can be frustrated, when W/O Status is "Fr"</td></tr>
			</tbody>
		</table>
	</div>
</div>
</form>

<script type="text/javascript">
<!--
      /* 
       * The information entered by user is received through event and show it on the screen
       */
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo   = event.getBkgNo();
            String ioBndCd = event.getIoBndCd();
        %>    
            eval("bkg_no").value    = "<%=bkgNo%>";
            eval("io_bnd_cd").value = "<%=ioBndCd%>";
        <% } %>
       }
-->
</script>
<%@include file="/bizcommon/include/common_opus.jsp"%>