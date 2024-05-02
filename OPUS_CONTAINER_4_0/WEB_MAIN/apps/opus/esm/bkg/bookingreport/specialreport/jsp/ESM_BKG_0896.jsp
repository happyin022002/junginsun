<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0896.jsp
*@FileTitle  : BookingReport
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.specialreport.event.EsmBkg0896Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0896Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String usrId			= "";
	String rptId			= "";
	String bkgRptKndCd		= "";
	String editYn			= "";

	Logger log = Logger.getLogger("com.clt.apps.BookingReport.SpecialReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		rptId 		= StringUtil.xssFilter(request.getParameter("rpt_id"));
		bkgRptKndCd 	= StringUtil.xssFilter(request.getParameter("bkg_rpt_knd_cd"));
		editYn		= StringUtil.xssFilter(request.getParameter("edit_yn"));

		if (rptId == null){
			rptId 		= "SELHO00011";
			bkgRptKndCd = "C";
		}

		event = (EsmBkg0896Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />


<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="usr_id" value="<%= usrId %>" id="usr_id" />
<input type="hidden" name="rpt_id" value="<%= rptId %>" id="rpt_id" />
<input type="hidden" name="bkg_rpt_knd_cd" value="<%= bkgRptKndCd %>" id="bkg_rpt_knd_cd" />
<input type="hidden" name="edit_yn" value="<%= editYn %>" id="edit_yn" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>My Report Share</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" 	id="btn_Save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!--
		--></div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<!-- div class="location">
			<span id="navigation"></span>
		</div-->
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
	</div>
	
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" 	id="btn_RowAdd">Row Add</button><!--
				--><button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button><!--
			--></div>
				<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>