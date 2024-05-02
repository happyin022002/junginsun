<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : vop_scg_2013_01
*@FileTitle  : Supporting Documents or Pictures
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
<%@ page import="com.clt.apps.opus.vop.scg.vesseloperationirregularmgt.specialcargoirregularmgt.event.VopScg201301Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg201301Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						////count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.VesselOperationIrregularMgt.SpecialCargoIrregularMgt");
	
	String file_pop_kind = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg201301Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		file_pop_kind = request.getParameter("file_pop_kind");

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
		
		//Change title of page
		var titleStr = "Supporting Documents or Pictures";
		if('approval' == '<%=StringUtil.xssFilter(file_pop_kind)%>') {
		    var titleStr = "Attach File";
		}
		
		/* try {
			var appName = navigator.appName;		
		 	if (appName.indexOf("Netscape") == -1) {
		  		document.all.title.innerHTML = '&nbsp; '+titleStr;
		  		document.title = titleStr;
		 	} else {
		  		document.getElementById("title").innerHTML = '&nbsp; '+titleStr;
		  		document.title = titleStr;
		 	}
		}catch(err) {
		 	ComShowMessage(err);
		} */
		
		loadPage("<%=StringUtil.xssFilter(file_pop_kind)%>");
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="vsl_cd" value="<%=StringUtil.xssFilter(request.getParameter("vsl_cd"))%>">
<input type="hidden" name="skd_voy_no" value="<%=StringUtil.xssFilter(request.getParameter("skd_voy_no"))%>">
<input type="hidden" name="skd_dir_cd" value="<%=StringUtil.xssFilter(request.getParameter("skd_dir_cd"))%>">
<input type="hidden" name="spcl_cgo_irr_seq" value="<%=StringUtil.xssFilter(request.getParameter("spcl_cgo_irr_seq"))%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Supporting Documents or Pictures</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_OK" 		id="btn_OK">OK</button>
		<button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>		
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_FileAdd" 		id="btn_FileAdd">File Add</button>
			<button type="button" class="btn_normal" name="btn_Delete" 			id="btn_Delete">File Delete</button>		
		</div>
		<!-- opus_design_btn(E) -->		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
<%-- <%@include file="/bizcommon/include/common_opus.jsp"%> --%>