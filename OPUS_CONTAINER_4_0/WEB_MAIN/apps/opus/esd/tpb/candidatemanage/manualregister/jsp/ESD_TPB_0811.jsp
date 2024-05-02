<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESD_TPB_0811.jsp
*@FileTitle  : Container Selection
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/19
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.tpb.candidatemanage.manualregister.event.EsdTpb0811Event"%>
<%@ page import="com.clt.apps.opus.esd.tpb.common.TPBUtils"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdTpb0811Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Server Exception
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//DB ResultSet list count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CandidateManage.ManualRegister");

	String s_bkg_no = JSPUtil.getNull(request.getParameter("s_bkg_no")); 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdTpb0811Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Add logic information data from the server when loading the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="s_bkg_no" value="<%=s_bkg_no%>">
<input type="hidden" name="s_eq_knd_cd">
<input type="hidden" name="s_eq_no">


<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>&nbsp;BKG No. <%=s_bkg_no%></span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_add" id="btn_add">Add</button>
			<button type="button" class="btn_normal" name="btn_delete" id="btn_delete">Delete</button>
			<button type="button" class="btn_normal" name="btn_save" id="btn_save">OK</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">	
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject('sheet1');</script>
			</div>

		</div>
	</div>
</div>
	
</form>
