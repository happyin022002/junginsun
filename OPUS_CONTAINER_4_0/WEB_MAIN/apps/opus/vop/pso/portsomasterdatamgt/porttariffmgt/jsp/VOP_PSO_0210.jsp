<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0210.jsp
*@FileTitle  : ID Link Condition
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/22
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.event.VopPso0210Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0210Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortTariffMgt");

	String id_tp = "";		//Condition or Formula
	String id_no = "";		//Number
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0210Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		id_tp = event.getAttribute("id_tp") == null ? "" : event.getAttribute("id_tp").toString();	
		id_no = event.getAttribute("id_no") == null ? "" : event.getAttribute("id_no").toString();
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
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
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="id_tp" id="id_tp" value="<%=id_tp %>">
<input type="hidden" name="id_no" id="id_no" value="<%=id_no %>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>ID Link <%="F".equalsIgnoreCase(id_tp) ? "Formula" : "Condition"%></span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
