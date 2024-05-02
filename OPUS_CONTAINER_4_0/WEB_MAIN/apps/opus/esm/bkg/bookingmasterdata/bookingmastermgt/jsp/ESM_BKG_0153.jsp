<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0153.jsp
*@FileTitle  : Chinese Booking Agent 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0153Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0153Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String screenName		= "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0153Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//When initial screen loading, adding logic extrat data obtained from the server.
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
		var formObj = document.form;
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		ComSetObjValue(formObj.screenName,"<%=screenName%>");
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="screenName" id="screenName">
<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			<% if (screenName.indexOf("Q") < 0){ %>
			--><button type="button" class="btn_normal" name="btn_save"  	id="btn_save">Save</button><!--  
			<% } %>
			--><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>
<!-- page_title_area(E) -->
<!-- opus_design_inquiry(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
				<col width="1px"></col>
				<col width="1px"></col>
				<col width="120px"></col>
				<col width="1px"></col>
				<col width="120px"></col>
				<col width="1px"></col>
				<col width="*"></col>
				</colgroup>
				<tr class="h23">
					<th>Control Office</th>
					<td>
						<input type="text" name="ofc_cd" id="ofc_cd" style="width:80px;" class="input" value="" style="ime-mode:disabled" dataformat="enguponly"  caption="Control Office" maxlength="6" >
					</td>
					<th>Agent Code</th>
					<td><input type="text" name="chn_agn_cd" id="chn_agn_cd"  style="width:40px;" class="input" value="" style="ime-mode:disabled" dataformat="enguponly"  caption="Agent Code" maxlength="2" fullfill></td>
					<th>Customer</th>
					<td>
						<input type="text" name="cust_cnt_cd" id="cust_cnt_cd" style="width:40px;" class="input" value="" style="ime-mode:disabled" dataformat="enguponly"  caption="Customer Country" maxlength="2" fullfill>
						<input type="text" name="cust_seq" id="cust_seq" style="width:60px;" class="input" value="" style="ime-mode:disabled" dataformat="num"  caption="Customer Code" maxlength="6">
						<input type="text" name="agn_nm" id="agn_nm" style="width:380px;" class="input" value="" style="ime-mode:disabled" dataformat="enguponly"  caption="Customer Name" maxlength="30">
					</td>	
					<td></td>
				</tr> 
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->
</form>