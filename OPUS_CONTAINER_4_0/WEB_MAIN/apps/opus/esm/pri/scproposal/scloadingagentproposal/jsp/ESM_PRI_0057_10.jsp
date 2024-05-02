<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_10.js
 *@FileTitle  : Amendment History Inquiry - Loding Agent
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/05/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.event.EsmPri005710Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri005710Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCLoadingAgentProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri005710Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

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
<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
	<!-- developer performance	-->
<input type="hidden" name="prop_no" 	id="prop_no">
<input type="hidden" name="amdt_seq" 	id="amdt_seq">
<input type="hidden" name="svc_scp_cd" 	id="svc_scp_cd">
<input type="hidden" name="con_chk" 	id="con_chk">

<input type="hidden" name="cd" 			id="cd">
<input type="hidden" name="mnl_chk" 	id="mnl_chk">

<input type="hidden" name="cust_cnt_cd" id="cust_cnt_cd">
<input type="hidden" name="cust_seq" 	id="cust_seq">
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg">

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>
</body>
</html>