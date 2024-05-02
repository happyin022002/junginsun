<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_COA_0141.jsp
*@FileTitle  : Popup about the Unit Price of standard by Link
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="org.apache.log4j.Logger" %>	
<%
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";								 //Error message

	//Variable from the parent window
	String f_pctl_no= JSPUtil.getNullNoTrim(request.getParameter("f_pctl_no"));
	Logger log = Logger.getLogger("com.clt.apps.STDUnitcost.Fullcost");


	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		  log.error("Exception : " + e.toString());
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
		setRetrieveAction();
	}
</script>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="f_pctl_no" value="<%=f_pctl_no%>" id="f_pctl_no" />
<input type="hidden" name="f_pgm_no" value="ESM_COA_0141" id="f_pctl_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Route Cost</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
    			<button type="button" class="btn_normal" name="btn_Remark" id="btn_Remark">Remark</button>
		    	<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>