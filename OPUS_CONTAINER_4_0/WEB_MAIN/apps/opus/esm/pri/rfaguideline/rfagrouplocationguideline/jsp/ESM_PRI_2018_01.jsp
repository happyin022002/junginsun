<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2018_01.jsp
*@FileTitle  : RFA Guideline Inquiry - Location Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfagrouplocationguideline.event.EsmPri201801Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri201801Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //Error from Server
	String strErrMsg = ""; //Error Message
	int rowCount = 0; //Number of DB ResultSet List

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri201801Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" id="gline_seq" />
<input type="hidden" name="grp_loc_seq" id="grp_loc_seq" />
<input type="hidden" name="cd" id="cd" />

<!-- opus_design_btn (S) -->
<div>
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	</div>
</div>
<!-- opus_design_btn (E) -->

<!-- layout_wrap(S) -->
<div class="layout_wrap">
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 30%" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
    <div class="layout_vertical_2" style="width: 3%; text-align: center; margin-top: 170px;">
       <button type="button" class="btn_right"></button>	
	</div>

     <!-- layout_vertical_2(E) -->
	<!-- layout_vertical_2(S) -->
	<div class="layout_vertical_2" style="width: 67%" id="mainTable">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	<!-- opus_design_grid(E) -->
	</div>
</div>
<!-- layout_wrap(E) -->
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hiddenSheetLayer" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet3');</script>
		<script type="text/javascript">ComSheetObject('sheet4');</script>
	</div>
</form>