<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_GEM_0105.jsp
     *@FileTitle :  [CPS_GEM_0105] Request No. Reference
     *Open Issues :
     *Change history :
     *@LastModifyDate : 2009.04.21
     *@LastModifier : 진윤오
     *@LastVersion : 1.0
     * 2009.04.17 진윤오
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
<%@page import="com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.event.CpsGem0105Event"%>
<%
    CpsGem0105Event event = null; //PDTO(Data Transfer Object including Parameters)
    Exception serverException = null; //서버에서 발생한 에러
    String strErrMsg = ""; //에러메세지
    int rowCount = 0; //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.basic.GemPlanningPerformanceBC");

    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (CpsGem0105Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    // 요청 오피스 코드 
    String rqst_ofc_cd = JSPUtil.getParameter(request,"rqst_ofc_cd","");
    // 계획년월 
    String pln_yrmon = JSPUtil.getParameter(request,"pln_yrmon","");
    // request구분 EA,EI,ET
    String gen_expn_rqst_tp_cd = JSPUtil.getParameter(request,"gen_expn_rqst_tp_cd","");
    //prg_id 있는경우 cre_usr_id 제외 
    String prg_id= JSPUtil.getParameter(request,"prg_id","");
    String auth_flg= JSPUtil.getParameter(request,"auth_flg","");
    
%>




<html>
<head>
<title>Request No. Reference</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 

<!-- 개발자 작업 -->
<input type="hidden" name="rqst_ofc_cd" value="<%=rqst_ofc_cd%>">
<input type="hidden" name="gen_expn_rqst_tp_cd" value="<%=gen_expn_rqst_tp_cd%>">
<input type="hidden" name="pln_yrmon" value="<%=pln_yrmon%>">
<input type="hidden" name="prg_id" value="<%=prg_id%>">
<input type="hidden" name="auth_flg" value="<%=auth_flg%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Request No. Reference</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                
                
                <!-- Grid  (S) -->
                <table width="100%" id="mainTable"> 
                <tr>
                    <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                    </td>
                </tr>
            </table>
                <!-- Grid (E) -->   
            
        </td></tr></table>
        <!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Select">Select</td>
                    <td class="btn1_right"></td>
                </tr></table></td>  
            <td class="btn1_line"></td>     
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
                
            </tr>
        </table>
        <!--Button (E) -->        </td>
        
        </tr>
        </table>
        
</td>
</tr>
</table>    
<!-- : ( Button : pop ) (E) -->
 
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>