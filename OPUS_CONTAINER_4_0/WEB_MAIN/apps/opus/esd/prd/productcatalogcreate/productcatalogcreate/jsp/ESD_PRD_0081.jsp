<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_PRD_0081.jsp
*@FileTitle  : Product Catalog - Full Route
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/15
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0081Event"%>
<%@ page import="com.clt.framework.core.controller.DefaultViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsdPrd0081Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml = null;   
	String ldd ="";
	String mt_pu_dt ="";
	String calllFunc  = "";
	String pctlNo  = "";
 
	Logger log = Logger.getLogger("com.clt.apps.ProductCatalogManage.ProductCatalogManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsdPrd0081Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		//calllFunc  = JSPUtil.getParameter(request, "func");
		
		//DefaultViewAdapter adapter = new DefaultViewAdapter();   
		//xml = adapter.makeXML(request, response); 
	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script language="javascript">
    function setupPage(){
	    loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" >
<input type="hidden" name="pctl_no" value="<%=JSPUtil.getParameter(request, "pctl_no") %>">

<div class="layer_popup_title">
    <!-- page_title_area(S) -->
    <div class="page_title_area clear">
        <!-- page_title(S) -->
        <h2 class="page_title">
            <span>Product Catalog - Full Route</span>
        </h2>
        <!-- page_title(E) -->

        <!-- opus_design_btn(S) -->
        <div class="opus_design_btn">
            <button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
        </div>
        <!-- opus_design_btn(E) --> 
    </div>
<!-- page_title_area(E) -->
</div>

	<div class="wrap_result">
<div class="layer_popup_contents">

	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	</div>
</div>

</form>

