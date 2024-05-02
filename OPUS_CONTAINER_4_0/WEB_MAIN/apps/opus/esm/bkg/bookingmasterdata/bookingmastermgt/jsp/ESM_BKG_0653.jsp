<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0653.jsp
*@FileTitle  : Package Table
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg0653Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0653Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server	
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String cmdt_cd			= "";
	String rep_cmdt_cd		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.BookingMasterMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0653Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		
		cmdt_cd =  JSPUtil.getParameter(request, "cmdt_cd");
		rep_cmdt_cd =  JSPUtil.getParameter(request, "rep_cmdt_cd");
		
		
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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- popup_title_area(S) -->
	<!-- page_title_area(S) -->
	<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Commodity Code Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!-- 
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	</div>
	<!-- page_title_area(E) -->
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="140" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<td><input type="radio" id="rdo_search_type_cd" name="rdo_search_type" value="A" checked><label for="rdo_search_type_cd" style="font-weight:bold">Commodity Code</label></th>
						<td><input type="text" name="cmdt_cd" style="width:100px;" class="input" value="<%=cmdt_cd %>" style="ime-mode:disabled" dataformat="num" caption="Commodity Code" maxlength="6"></td>
					</tr>
					<tr>
						<td><input type="radio" id="rdo_search_type_rep" name="rdo_search_type" value="B"><label style="font-weight:bold" for="rdo_search_type_rep">Rep. Commodity Code</label></th>
						<td><input type="text" name="rep_cmdt_cd" style="width:100px;" class="input" value="<%=rep_cmdt_cd %>" style="ime-mode:disabled" dataformat="num" caption="Rep. Commodity Code" maxlength="4"></td>
					</tr>
					<tr>
						<td><input type="radio" id="rdo_search_type_nm" name="rdo_search_type"  value="C"><label style="font-weight:bold" for="rdo_search_type_nm">Commodity Keyword</label></th>
						<td><input type="text" name="cmdt_nm" style="width:95%;" class="input" value="" style="ime-mode:disabled" dataformat="eng" otherchar="<%=getSpecialChars()%>" caption="Commodity Keyword" maxlength="80"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- inquiry_area(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	</div>
<!-- popup_contens_area(E) -->

</form>

<%!

	public String getSpecialChars() {
		return " ~!@#$%^&*()`_+-={}|[]\\\"\\':;,./?"; 
	}
		
%>