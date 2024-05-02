<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : VOP_PSO_0201.jsp
*@FileTitle  : Expense Plan Per VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/21
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.event.VopPso0201Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0201Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strAcctNo		= "";
	String strLaneCd		= "";
	String strGubun			= "";
    String strLocCd			= "";
    String strVslCls		= "";
	String strCreDtFr		= "";
	String strCreDtTo		= "";
	String strTermCd		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortChargeBudget.BudgetPortChargeMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopPso0201Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//Setting parameter from Main
		strAcctNo		= StringUtil.xssFilter(request.getParameter("acctNo"));
		strLaneCd		= StringUtil.xssFilter(request.getParameter("laneCd"));
		strGubun		= StringUtil.xssFilter(request.getParameter("gubun"));//0:Port 1:lane
		strLocCd		= StringUtil.xssFilter(request.getParameter("locCd"));
		strVslCls		= StringUtil.xssFilter(request.getParameter("vslCls"));
		strCreDtFr		= StringUtil.xssFilter(request.getParameter("creDtFr"));
		strCreDtTo		= StringUtil.xssFilter(request.getParameter("creDtTo"));
		strTermCd		= StringUtil.xssFilter(request.getParameter("termCd"));

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Expense Plan Per VVD</title>


<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="acct_cd" value="<%=strAcctNo %>" id="acct_cd" />
<input type="hidden" name="lane_cd" value="<%=strLaneCd %>" id="lane_cd" />
<input type="hidden" name="cre_dt_fr" value="<%=strCreDtFr %>" id="cre_dt_fr" />
<input type="hidden" name="cre_dt_to" value="<%=strCreDtTo %>" id="cre_dt_to" />
<input type="hidden" name="gubun" value="<%=strGubun %>" id="gubun" />
<input type="hidden" name="vsl_cls" value="<%=strVslCls %>" id="vsl_cls" />
<input type="hidden" name="loc_cd" value="<%=strLocCd %>" id="loc_cd" />
<input type="hidden" name="term_cd" value="<%=strTermCd %>" id="term_cd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><span>Expense Plan Per VVD</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_close" 	id="btn_close">Close</button><!--  
	--></div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<div class="opus_design_grid clear">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>	

</form>