<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :esm_bkg_0741.jsp
*@FileTitle  : booking master data 
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0741Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0741Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//serverException
	String strErrMsg = "";						//error massage
	int rowCount	 = 0;						//DB ResultSet list count
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
 	String mainpage = "";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingProcessMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		mainpage = request.getParameter("main_page");
		event = (EsmBkg0741Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//when open screen, get data in server..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

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
		
		ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" id="f_cmd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="screenName" name="screenName">
<!-- Developer Work	-->
<input type="hidden" id="chk_op" name="chk_op">
<input type="hidden" id="ofc_cd" name="ofc_cd">
<input type="hidden" id="ofc_ty" name="ofc_ty">
<%if(!"true".equals(mainpage)){ %>
<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<h2 class="page_title"><span>Office Setup Inquiry</span></h2>
<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<% if (screenName.indexOf("Q") < 0){ %>	
		<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>
		<%} %>
		<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
  	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<%}else{ %>
<!-- page_title_area(S) -->
<div class="page_title_area clear">
<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span  id="title"></span></button></h2>
<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<% if (screenName.indexOf("Q") < 0){ %>	
		<button type="button" class="btn_normal" name="btn_save" 	id="btn_save">Save</button>
		<%} %>
		<button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
	<!-- page_title_area(E) -->
<%} %>
<!-- opus_design_inquiry(S) -->
<%if(!"true".equals(mainpage)){ %>
<div class="layer_popup_contents"> 
<%} %>
<div class= "wrap_search">
	<div class="opus_design_inquiry wFit">
	<!--biz page (S)-->
		<table> 
       		<colgroup>
       		<col width="2"></col>
       		<col width="450"></col>
       		<col width="*"></col>
       		</colgroup>
			<tr>
			<td></td>
				<td class="sm pad_left_4">
				  <input type="radio" name="cho_page" id="cho_page" class="trans" checked><label for="cho_page">e-Service Handling Office</label>
				</td>
				<td></td>
			</tr>
			<tr><td></td><td></td></tr>
			<tr>
			<td></td>
				<td class="sm pad_left_4">
				 	<span id="office_0">
					<input type="radio" id="cho_ofc_0" name="cho_ofc_0" value="0" class="trans"><label for="cho_ofc_0">H/OFC</label>
					<input type="radio" id="cho_ofc_1" name="cho_ofc_0" value="1" class="trans"><label for="cho_ofc_1">GSO</label>
					<input type="radio" id="cho_ofc_2" name="cho_ofc_0" value="2" class="trans"><label for="cho_ofc_2">Region</label>
					<input type="radio" id="cho_ofc_3" name="cho_ofc_0" value="3" class="trans"><label for="cho_ofc_3">Controlled OFC</label>
					<input type="text" id="ofc_cd_0" name="ofc_cd_0" style="width:100px;" dataformat="engup" maxlength="6" mixlength="5">
					</span> 

				</td>
				<td></td>
			</tr>
			</table> 
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid">
	<!-- Grid (E) -->		
			<% if (screenName.indexOf("Q") < 0){ %>	
				<!--  Button_Sub (S) -->
				<div class="opus_design_btn">
				        <button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button><!--
				        --><button type="button" class="btn_normal" name="btn_delete" 	id="btn_delete">Row Delete</button><!--
				        --><button type="button" class="btn_normal" name="btn_celladd"  id="btn_celladd">Controlled OFC Add</button>
				</div> 
		    	<!-- Button_Sub (E) -->
			<%} %>
		<!--biz page (E)--> 
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
<!-- opus_design_grid(S) -->
</div>
<%if(!"true".equals(mainpage)){ %>
</div>
<%} %>
</form>