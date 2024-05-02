<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TPB_0801.js
*@FileTitle  : TPB Duplication Check
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0801Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0801Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CandidateManage.ManualRegister");
	
	String s_if_ofc_cd = JSPUtil.getNull(request.getParameter("s_if_ofc_cd")); 
	String s_eq_no = JSPUtil.getNull(request.getParameter("s_eq_no")); 
	String s_bkg_no = JSPUtil.getNull(request.getParameter("s_bkg_no")); 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsdTpb0801Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
		loadPage();
	}
</script>
<form method="post" name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- 개발자 작업	-->
<input type="hidden" name="s_ofc_cd" value="<%=s_if_ofc_cd%>" id="s_ofc_cd" />
<input type="hidden" name="s_eq_no" value="<%=s_eq_no%>" id="s_eq_no" />
<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no%>" id="s_bkg_no" />

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>TPB Duplication Check</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_save" 		id="btn_Save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" 			id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tr >
				<th>Please check below whether your TPB is already created.</th>
				<td></td>
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
</div>
</form>
