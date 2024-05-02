<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0384.jsp
*@FileTitle  : Booking Notice Remark
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event.EsmBkg0384Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0384Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String calllFunc 		= "";
	String xml ="";
	Logger log = Logger.getLogger("com.clt.apps.BookingMasterData.UserSetupMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0384Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		// call parent window script method (pop_mode : 1(function call) )
		calllFunc  = JSPUtil.getParameter(request, "func");
		
		xml = HttpUtil.makeXML(request,response); 

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="tmplt_tp_cd" value="R">
<input type="hidden" name="sXml" value="<%=xml%>">  

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Remark Template</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" id="btn_Save">Save</button><!--  
			--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--  
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->


<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry">   <!-- no TAB  -->
		<table> 
			<colgroup>
				<col width="10%" />
				<col width="90%" />
			</colgroup>
			<tbody>
				<tr>
					<th>User ID</th>
					<td><input type="text" style="width:100;" class="input2" value="<%=strUsr_id%>" readonly></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- inquiry_area(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" >
    	<!-- opus_grid_btn(S) -->
    	<div class="opus_design_btn">
    		<button type="button" class="btn_normal" name="btn_AddRow" id="btn_AddRow">Row Add</button>
    		<button type="button" class="btn_normal" name="btn_DeleteRow" id="btn_DeleteRow">Row Delete</button>
    	</div>
    	<!-- opus_grid_btn(E) -->
		
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- popup_contens_area(E) -->
</div>
</form>
