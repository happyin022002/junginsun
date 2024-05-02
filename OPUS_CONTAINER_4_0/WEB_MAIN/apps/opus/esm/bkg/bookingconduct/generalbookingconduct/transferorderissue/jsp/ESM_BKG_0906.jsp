<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0906.jsp
*@FileTitle  : TRO-Confirm
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0906Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0906Event  event = null;			    //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmBkg0906Event)request.getAttribute("Event");		

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
<!-- 개발자 작업	-->
<input type="hidden" name="io_bnd_cd" value="" id="io_bnd_cd" />
<input type="hidden" name="cct_ofc_cd" value="" id="cct_ofc_cd" />
<input type="hidden" name="loc_cfm_cd" value="" id="loc_cfm_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span>TRO Confirm</span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Confirm" id="btn_Confirm" type="button">Confirm</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
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
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Booking No.</th>
					<td><input type="text" name="bkg_no" style="width:100px;" class="input2" value="" readonly id="bkg_no" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
		<div id="div_inbound">
			<table>
				<colgroup>
					<col width="100" />
					<col width="70" />
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th><input type="radio" name="rdo_cct_ofc_cd" class="trans" id="rdo_cct_ofc_cd1" /><label for="rdo_cct_ofc_cd1">TRO</label></th>
						<td><input type="text" name="cre_ofc_cd" value="" class="input2" maxlength="6" style="width:50px;" id="cre_ofc_cd" /></td>
						<th><input type="radio" name="rdo_cct_ofc_cd" class="trans" id="rdo_cct_ofc_cd2" /><label for="rdo_cct_ofc_cd2">CCT at B/L</label></th>
						<td><input type="text" name="clt_ofc_cd" value="" class="input" maxlength="6" dataformat="engup" style="width:50px;" id="clt_ofc_cd" /></td>
			   		</tr>
			   </tbody>
			</table>
			<table>
				<colgroup>
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>Actual Payer</th>
			   			<td><!--
			   			--><input type="text" name="payer_cnt_cd" style="width:40px;" class="input" maxlength="2" dataformat="engup" id="payer_cnt_cd" /><!--
			   			--><input type="text" name="payer_seq" style="width:60px;" class="input" maxlength="6" dataformat="num" id="payer_seq" /><!--
			   			--><input type="text" name="payer_nm" style="width:270px;" class="input2" maxlength="50" dataformat="engup" id="payer_nm" />
			   			</td>
			   		</tr>
			   </tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<!-- div class="opus_design_btn">
			<button class="btn_accent" name="Row_Add" id="Row_Add" type="button">Row Add</button>
			<button class="btn_normal" name="Delete" id="Delete" type="button">Row Delete</button>
            <button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button>
            <button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button>
            </div-->
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<SCRIPT type="text/javascript">
<!--
      /* 
       * Information entered by the user is received through event and show screen
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
</SCRIPT>
<%@include file="/bizcommon/include/common_opus.jsp"%>