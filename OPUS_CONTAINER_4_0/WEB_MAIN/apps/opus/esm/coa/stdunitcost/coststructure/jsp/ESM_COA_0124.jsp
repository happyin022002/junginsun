<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0124.jsp
*@FileTitle  : So Cost Code Column hide
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa0124Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	Logger log = Logger.getLogger("com.clt.apps.StdUnitCost.CostStructure");

	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		log.debug(e.toString());
		out.println(e.toString());
	}
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		setDataFromParentHeader();
	}
</script>
<form name="form">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>So Cost Code Column hide</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
    	<button type="button" class="btn_accent" name="btn_apply" id="btn_apply">Apply</button><!-- SJH.20150109.ADD : 공통 -->
    	<button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >										
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</form>