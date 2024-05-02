<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_9454.jsp
*@FileTitle : Transhipment Route Update
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9454Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg9454Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	String bkgNo 			= "";	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg9454Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		bkgNo  	= JSPUtil.getParameter(request, "bkg_no");			
		
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
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>T/S Route Update</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>


<div class="layer_popup_contents">
	<div class="wrap_result">
		
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_grid clear" id="mainTable">		
			<div class="opus_design_inquiry wFit">
				Pre VVD
			</div>			
			<script language="javascript">ComSheetObject('sheet1');</script>
			<div style="height:30px"></div>
				<div class="opus_design_inquiry wFit">
				Trunk VVD
			</div>
			<script language="javascript">ComSheetObject('sheet2');</script>
			
			<div style="height:30px"></div>
			<div class="opus_design_inquiry wFit">
				Post VVD
			</div>
			<script language="javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_grid_btn(E) -->
	</div>
	

</div>

</form>