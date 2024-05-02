<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec All Rights Reserved
*@FileName : esm_bkg_0253.jsp
*@FileTitle : Equalization Port 
*@author : CLT
*@version : 1.0
*@since : 2014.04.22
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0253Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0253Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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


		event = (EsmBkg0253Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="screenName">


<!-- 제목 -->
<div class="page_title_area clear">
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- btn_div -->
   <div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve">Retrieve</button>
<% if (screenName.indexOf("Q") < 0){ %>		
	    <button type="button" class="btn_normal" name="btn_save">Save</button>
<% } %>	    
	     <button type="button" class="btn_normal" name="btn_downexcel">Down Excel</button>
   </div>

   <!-- page_location(S) -->
   <div class="location">
		<span id="navigation"></span>
   </div>
</div>
<!-- 제목 -->

<!-- 검색영역 -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">		
			<table> 
				<colgroup>
			  		<col width="35px"></col>
			  		<col width="100px"></col>
			  		<col width="110px"></col>
			  		<col width="*"></col>
			  	</colgroup>
				<tbody>
				<tr>
					<th>Port</th>
					<td><input type="text" name="loc_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engup" caption="Port" maxlength="5" fullfill></td>
					<th>Equalization Port</th>
					<td><input type="text" name="eqlz_port_cd" style="width:60;" value="" style="ime-mode:disabled" dataformat="engup" caption="Equalization Port" maxlength="5"  fullfill></td>
				</tr> 
				</tbody>
			</table>
	</div>
</div>
<!-- 검색영역 -->

<!-- 시트영역 -->
<div class="wrap_result">
	<div class="opus_design_grid">
	<% if (screenName.indexOf("Q") < 0){ %>	
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_add">Row Add</button>
		   <button type="button" class="btn_normal" name="btn_del">Row Delete</button>
		</div>
	<% } %>		
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
<!-- 시트영역 -->

</form>
