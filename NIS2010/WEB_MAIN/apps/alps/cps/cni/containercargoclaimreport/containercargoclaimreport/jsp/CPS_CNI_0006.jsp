<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : cps_cni_0006.jsp
     *@FileTitle : [CPS_CNI_0006] Cargo Claim Report
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.11.20
     *@LastModifier : 정행룡
     *@LastVersion : 1.0
     * 2009.11.20 정행룡
     * 1.0 Creation
     =========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@page import="com.hanjin.framework.component.util.io.HttpUtil"%>
<%@page import="com.hanjin.apps.alps.cps.cni.common.CniUtil"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaimreport.ContainerCargoClaimReportSC");
    
    String cgoClmNo = JSPUtil.getParameter(request, "cgo_clm_no" , "");
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //세션에 Claim No가 존재하면
        String ssCgoClmNo =  eventResponse.getETCData("CGO_CLM_NO");
        if ( cgoClmNo.equals("") && ssCgoClmNo != null && !ssCgoClmNo.equals("")) {
        	cgoClmNo = ssCgoClmNo;
        }
        userArea =  CniUtil.getAreaInfo(account);
    }
    catch (Exception e)
    {
    	out.println(e.toString());
    }
   
%>
<html>
<head>
<title>Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
</head>
<script language="javascript">
	 
    function setupPage(){ 
    	var errMessage = "<%=strErrMsg.replace("\"","'")%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
      
	    loadPage();
    }
</script>
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="ofc_cd" value="<%=userOffice%>"/> 

<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="usr_area" value="<%=userArea%>"/>
<input type="hidden" name="com_mrdBodyTitle">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
	    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
	        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
	        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	    </table>
   		<!--Page Title, Historical (E)-->
	
			<!--biz page (S)-->
		
<table class="search" id="mainTable"> 
    <tr><td class="bg">	
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="65">Claim  No.</td>
				<td width="145"><input type="text" name="cgo_clm_no" style="width:80;" maxlength="10" value="<%=cgoClmNo%>" dataformat="engup" class="input1">&nbsp;
				<input type="text" name="area_cd" style="width:20;text-align:center" value="" class="input2" readonly="readonly"></td>
				<td width="">
					<table class="search_sm2" border="0" style="width:310;"> 
						<tr class="h23">
							<td width="50">&nbsp;Status</td>
							<td class="stm"><input type="radio" name="status" class="trans" checked value="B">Before  Litigation &nbsp;&nbsp;&nbsp;&nbsp;
							<input type="radio" class="trans" name="status" value="A">After Litigation </td>
						</tr>
					</table> 
				</td>
				</tr>
			</table> 
			<table border="0" class="line_bluedot"><tr><td></td></tr></table>		
			
			<table border="0" style="width:100%;" height="450" class="search"  > 
				<tr>
					<td align="center"><script language='javascript'>comRdObject('report1');</script>1</td>
				</tr>
			</table> 
			
		</td>
		</tr>
		</table> 
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
		</table>
<div style="display: none;"><script language="javascript">ComSheetObject('sheet1');</script></div>		
</body>
</html>
