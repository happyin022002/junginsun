<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0057_18.jsp
*@FileTitle  : Amendment History Inquiry Contract Parties Information
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri005718Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>

<%
	EsmPri005718Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCContractPartyProposal");
    String[] prcCtrtPtyTpCd = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri005718Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");    
        prcCtrtPtyTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCtrtPtyTpCd"), false ,"|","\t","getCode","getName"); 
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Amendment History Inquiry? Contract Parties Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script type="text/javascript">
    var prcCtrtPtyTpCdValue = "<%=prcCtrtPtyTpCd[0]%>";
    var prcCtrtPtyTpCdText = "<%=prcCtrtPtyTpCd[1]%>"; 
    
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd" 			id="f_cmd">
<input type="hidden" name="pagerows" 		id="pagerows">
<!-- developer performance	-->
<input type="hidden" name="prop_no" 		id="prop_no" value="">
<input type="hidden" name="amdt_seq" 		id="amdt_seq" value="">
<input type="hidden" name="pre_amdt_seq" 	id="pre_amdt_seq" value="">
<input type="hidden" name="prop_sts_cd" 	id="prop_sts_cd" value="">
<input type="hidden" name="eff_dt" 			id="eff_dt" value="">
<input type="hidden" name="exp_dt" 			id="exp_dt" value="">
<input type="hidden" name="pre_exp_dt" 		id="pre_exp_dt" value="">
<input type="hidden" name="cd" 				id="cd">
<input type="hidden" name="req_usr_flg" 	id="req_usr_flg" value="">
<input type="hidden" name="apro_usr_flg" 	id="apro_usr_flg" value="">
<input type="hidden" name="dur_dup_flg" 	id="dur_dup_flg" value="">
<input type="hidden" name="lgcy_if_flg" 	id="lgcy_if_flg">

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" name="mainTable" id="mainTable">
	<div class="opus_design_btn" style="margin-bottom:-19px">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
	</div>
	<div class="opus_design_data">
		<table style="width:250px;" class="search_sm2">
			<tbody>
				<col width="50px"/>
				<col width="300px"/>
				<tr class="h23">
					<th>Type</th>
					<td  class="stm" style="font-size:12;" style="font-size:12;">
					    <div id="div_prcCtrtPtyTpCd"></div>
						<!-- <input type="radio" name="prc_ctrt_pty_tp_cd" value="P" class="trans" checked>&nbsp;<span id="tp2">Provider</span>&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="prc_ctrt_pty_tp_cd" value="C" class="trans">&nbsp;<span id="tp1">Customer</span>&nbsp;&nbsp;&nbsp;&nbsp;-->
					</td> 
				</tr>
				<tr style="height:5px">
					<th></th>
					<td></td>
				</tr>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>
</body>
</html>