<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0098.jsp
*@FileTitle  : Invoice File Inquery
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/21
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.event.EesLse0098Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0098Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strCostYrmon	= "";
	String strAgmtCtyCd	= "";
	String strAgmtSeq	= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerRentalCost.PayableRentalCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strCostYrmon = JSPUtil.getNull(request.getParameter("co_cost_yrmon"));
		strAgmtCtyCd = JSPUtil.getNull(request.getParameter("agmt_cty_cd"));
		strAgmtSeq   = JSPUtil.getNull(request.getParameter("agmt_seq"));

		event = (EesLse0098Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
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
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="co_cost_yrmon" value="<%= strCostYrmon %>">
<input type="hidden" name="agmt_cty_cd"   value="<%= strAgmtCtyCd %>">
<input type="hidden" name="agmt_seq"      value="<%= strAgmtSeq %>">

<div class="layer_popup_title">	
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Invoice File Inquery</span></h2>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close"	id="btn_Close">Close</button>
	    </div>
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_result">
	<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>

</form>
