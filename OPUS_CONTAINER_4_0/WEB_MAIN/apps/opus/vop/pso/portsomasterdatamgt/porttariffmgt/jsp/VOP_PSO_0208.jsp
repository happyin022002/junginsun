<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0208.jsp
*@FileTitle  : Bank Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/18
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0208Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0208Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_Ofc_cd      = "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortSOMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_Ofc_cd = account.getOfc_cd();

		event = (VopPso0208Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pso_ofc_cd" id="pso_ofc_cd" value="<%=strUsr_Ofc_cd%>"/>


<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Subject Favorites</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn1_OK" 	id="btn1_OK">OK</button><!--
		--><button type="button" class="btn_normal" name="btn1_Close" id="btn1_Close">Close</button><!--
	--></div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents" style="overflow:hidden;">
	<!-- layout_wrap(S) -->
	<div class="layout_wrap">
	   <!-- layout_flex_fixed(S) -->
	   <div class="layout_flex_fixed pad_left_8" style="width:400px">
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	           <script type="text/javascript">ComSheetObject('sheet1');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_flex_fixed(E) -->
	   <!-- layout_flex_fixed(S) -->
	   <div class="layout_flex_fixed pad_left_8" style="width:25px">
		   	<table style="margin-top:230px">
		   		<tr><td><button type="button" class="btn_right" name="btns_add" id="btns_add" ></button></td></tr>
		   		<tr><td> <br /></td></tr>
		   		<tr><td><button type="button" class="btn_left" name="btns_del" id="btns_del" ></button></td></tr>
		   	</table>
	   </div>
	   <!-- layout_flex_fixed(E) -->
	   <!-- layout_flex_flex(S) -->
	   <div class="layout_flex_flex " style="padding-left:441px; "> 
	   		<!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	       		<h3 class="title_design">First Row</h3>
	           <script type="text/javascript">ComSheetObject('sheet2');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	       		<h3 class="title_design">Second Row</h3>
	           <script type="text/javascript">ComSheetObject('sheet3');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	       <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	       <!-- opus_design_grid(S) -->
	       <div class="opus_design_grid">
	       		<h3 class="title_design">Third Row</h3>
	           <script type="text/javascript">ComSheetObject('sheet4');</script>
	       </div>
	       <!-- opus_design_grid(E) -->
	   </div>
	   <!-- layout_flex_flex(E) -->
	</div>
	<!-- layout_wrap(E) -->
</div>
</form>


