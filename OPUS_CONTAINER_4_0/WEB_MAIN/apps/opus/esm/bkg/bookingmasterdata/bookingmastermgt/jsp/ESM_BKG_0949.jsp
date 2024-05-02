<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0949.jsp
*@FileTitle  : Documentation Cut-Off Time Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/29
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0949Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0949Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			// error from server
	String strErrMsg = "";						// error message
	int rowCount	 = 0;						// count of DB resultSET list

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


		event = (EsmBkg0949Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		log.debug("====================================");
		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
		log.debug("====================================");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<!-- <title>booking master</title> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		
		//ComSetObjValue(document.form.screenName,"<%=screenName%>");
		loadPage();
	}
</script>

<!-- <body  onLoad="setupPage();"> -->
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="chk_op" value="Y"   id="chk_op">
<input type="hidden" name="pol" id="pol">

<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;"> -->

<!-- 	<tr> -->
<!-- 		<td valign="top"> -->
<!-- 	Page Title, Historical (S) -->
<!-- 		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title"> -->
<!-- 			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr> -->
<!-- 			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr> -->
<!-- 		</table> -->
<!--Page Title, Historical (E)-->
<!-- =======================================================================================================
!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span id="title"></span></button>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
<!-- 		<button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button> -->
		<% if (screenName.indexOf("Q") < 0){ %>				
		<button type="button" class="btn_normal" name="btn1_Save" id="btn1_Save">Save</button>		
		<% } %>
		</div>
	<!-- opus_design_btn(E) -->
		
	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<!-- opus_design_inquiry(S) -->
	<div class= "opus_design_inquiry wFit">
	<table>
		<tbody>	
		<colgroup>
				<col width="30"/>
				<col width="80"/>
				<col width="50"/>
				<col width="100"/>
				<col width="50"/>
				<col width="*"/>
			</colgroup>
			<tr class="h23">
					<th title="Port of Loading">POL</th>
					<td><input type="text" name="yd_cd" id="yd_cd" dataformat="engup" maxlength="5" style="width:80px;" value="" class="input"></td>
					<th>Lane</th>
					<td><select name="vsl_slan_cd" id="vsl_slan_cd" style="width:80px;" class="input">
						<option value="" selected>All</option>
						</select></td>
					<th>Including Deleted Code</th>
					<td><input type="checkbox" name="delt_flg" id="delt_flg" class="trans"></td>	
				</tr>
		</tbody>
	</table>
</div>	
</div>	
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div>	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
	<div class="opus_design_btn">
<!-- 			<button type="button" class="btn_normal" name="btn2_RowAdd" -->
<!-- 				id="btn2_RowAdd">Row Add</button> -->

<!-- 			<button type="button" class="btn_normal" name="btn2_Delete" -->
<!-- 				id="btn2_Delete">Row Delete</button> -->
				<% if (screenName.indexOf("Q") < 0){ %>
			
		<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button><!--
		--><button type="button" class="btn_normal" name="btn2_Delete" id="btn2_Delete">Row Delete</button>
		</div>
		<% } %>		

		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
<!-- opus_design_grid(E) -->
	
</form>