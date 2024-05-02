<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0057_09.jsp (ESM_PRI_0025 Reference)
 *@FileTitle  : Amendment History Inquiry - Affiliate Company
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.event.EsmPri005709Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
    EsmPri005709Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String[] infoCds = null;
    String[] stsCds = null;
    
    Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCAffiliateProposal");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
       
        event = (EsmPri005709Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        // Direction Combo Data creation
        infoCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("infoCd"), false , "|", "\t", "getCode", "getName");
        // Rate Type Combo Data creation
        stsCds = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsCd"), false , "|", "\t", "getCode", "getName");
        
    }catch(Exception e) {
        out.println(e.toString());
    }
    
%>
<html>
<head>
<title>Amendment History Inquiry - Affiliate Company</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    var infoCdComboValue = "<%=infoCds[0]%>";
    var infoCdComboText = "<%=infoCds[1]%>";

    var stsCdComboValue = "<%=stsCds[0]%>";
    var stsCdComboText = "<%=stsCds[1]%>";

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

<input type="hidden" name="f_cmd" 		id="f_cmd">
<input type="hidden" name="pagerows" 	id="pagerows">
<input type="hidden" name="cd" 			id="cd">

<input type="hidden" name="prop_no" 	id="prop_no">
<input type="hidden" name="amdt_seq" 	id="amdt_seq">
<input type="hidden" name="svc_scp_cd" 	id="svc_scp_cd">
<input type="hidden" name="mnl_chk" 	id="mnl_chk">
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