<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_13.jsp
 *@FileTitle  : Amend History Inquiry - Boiler Plate
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.event.EsmPri005713Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri005713Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCBoilerPlateProposal");
	
	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String effDt = "";
	String expDt = "";
	String preExpDt = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
		
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String blplHdrSeq = "";
	String durDupFlg = "";
	//sBlplHdrSeq
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri005713Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		preExpDt = request.getParameter("sPreExpDt");
		sc_no = request.getParameter("sSc_No");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");

		if (sc_no != null && sc_no !="" && sc_no.length() == 9){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,9);
		}
			
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
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
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(preAmdtSeq) %>" 	id="pre_amdt_seq">
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(propStsCd) %>" 		id="prop_sts_cd">
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(preExpDt) %>" 		id="pre_exp_dt">
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(effDt) %>" 				id="eff_dt">
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(expDt) %>" 				id="exp_dt">
<input type="hidden" name="blpl_seq" id="blpl_seq">
<input type="hidden" name="blpl_hdr_seq" value="<%=blplHdrSeq %>" 	id="blpl_hdr_seq">
<input type="hidden" name="prop_no" 								id="prop_no">
<input type="hidden" name="amdt_seq" 								id="amdt_seq">
<input type="hidden" name="svc_scp_cd" 								id="svc_scp_cd">
<input type="hidden" name="cd" 										id="cd">
<input type="hidden" name="sts_cd" 									id="sts_cd">
<input type="hidden" name="lgcy_if_flg" 							id="lgcy_if_flg">

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<div class="opus_design_grid">
	<table class="line_bluedot"><tr><td></td></tr></table>
</div>
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</form>
</body>
</html>