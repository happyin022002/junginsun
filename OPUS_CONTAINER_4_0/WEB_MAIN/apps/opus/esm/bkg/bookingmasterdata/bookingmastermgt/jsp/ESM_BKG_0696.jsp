<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : esm_bkg_0696.jsp
*@FileTitle  : Customized Conditions
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.controller.util.WebKeys"%>
<%@ page import="com.clt.framework.core.view.template.Screen"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0696Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0696Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String searcheKeyOpener = "";
	String screenName = "";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0696Event)request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		searcheKeyOpener = JSPUtil.getParameter(request,
				"searcheKeyOpener");

		Screen screen = (Screen) request.getAttribute(WebKeys.CURRENT_SCREEN);
		screenName = screen.getName();
	} catch (Exception e) {
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


<form name="form">
<input type="hidden" id="f_cnd" name="f_cmd">
<input type="hidden" id="pagerows" name="pagerows">
<input type="hidden" id="screenName" name="screenName" value="<%=screenName%>">

<% if ( !"true".equals(request.getParameter("main_page"))) { %>
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Packages Unit Code</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close" onClick="self.close()">Close</button>
		</div>
	</div>
</div>
<div class="layer_popup_contents" style="overflow:hidden;">
<%}else{ %>
	<div class="page_title_area clear ">
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button> 
		</div>
		<div class="location">
			<span id="navigation"></span>
		</div>
	</div>
<% } %>

	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					 <col width="80"/>
				     <col width="*"/>
				</colgroup>
				<tr>
					<th>Code</th>
					<td><input type="text" name="pck_cd" id="pck_cd" value="<%=searcheKeyOpener%>" style="width: 30px;ime-mode:disabled" class="input" value="" dataformat="engup" caption="Name" maxlength="2"></td>
				</tr>
				<tr>
					<th>Description</th>
					<td><input type="text" name="pck_nm" id="pck_nm" style="width: 100%;ime-mode:disabled" class="input" value="" dataformat="enguponly" otherchar=" " caption="Name" maxlength="50"></td>
				</tr>
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	
<% if (screenName.equals("ESM_BKG_0696POP")){ %>
</div>
<% } %>
</form>