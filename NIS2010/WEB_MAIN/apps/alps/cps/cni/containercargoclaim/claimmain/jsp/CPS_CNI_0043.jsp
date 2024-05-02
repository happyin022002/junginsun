<%/*=========================================================
     *Copyright(c) 2009 CyberLogitec
     *@FileName : CPS_CNI_0043.jsp
     *@FileTitle : [CPS_CNI_0043] Impending TB Claim
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
<%@page import="com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0043Event"%>
<%
    CpsCni0043Event  event = null;
    Exception serverException = null;
    String strErrMsg = "";
    int rowCount = 0; 

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String userId = "";
    String userName = "";
    String userOffice = "";
    String userArea = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.alps.cps.cni.containercargoclaim.ContainerCargoClaimSC");
    
    
    try
    {
        SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId = account.getUsr_id();
        userName = account.getUsr_nm();
        userOffice = account.getOfc_cd();
        
        event = (CpsCni0043Event) request.getAttribute("Event");
        serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null)
        {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }


    }
    catch (Exception e)
    {
        out.println(e.toString());
    }
    
    
    // ----------------------------------------------------------------
    // 해당 초기 파라미터 설정
    // ----------------------------------------------------------------
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
    String currDt = (String)eventResponse.getCustomData("curr_dt");
    
    
%>


<%@page import="com.hanjin.apps.alps.cps.gem.common.GemUtil"%>
<%@page import="com.hanjin.framework.component.util.StringUtil"%>
<html>
<head>
<title>Impending TB Claim</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	function setupPage(year){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage(year);
	}
</script>
<script language="javascript" src="rpt/script/rdviewer50.js"></script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Impending TB Claim </td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
                <tr><td class="bg">
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="225">Time Bar Claims Within 15 days From </td>
                    <td width=""><input type="text" style="width:80;text-align: center;" name="tb_dt" class="input2" value="<%=currDt%>"></td>                    
                </tr>
                <tr class="h23">
                    <td width="" colspan="2">
                        <table class="search_sm2" border="0" style="width:300;"> 
                        <tr class="h23">
                            <td width="40">&nbsp;For </td>
                            <td class="stm"><input type="radio" class="trans" name="cond_for" value="1" checked="checked">Handler&nbsp;&nbsp;
                            <input type="radio" name="cond_for" value="2" class="trans">HOFC&nbsp;&nbsp;
                            <input type="radio" name="cond_for" value="3" class="trans">Area &nbsp;&nbsp;
                            <input type="radio" name="cond_for" value="4" class="trans">All</td>
                        </tr>
                        </table>
                    </td>
                </tr>                
                </table>
                
                <table class="line_bluedot"><tr><td></td></tr></table>
                                
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="">
                        <table class="search" border="0">
                            <tr><td class="title_h"></td>
                            <td class="title_s">Main Claim</td></tr>
                        </table>
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                        </table> 
                        <!-- Grid (E) -->
                    </td>
                </tr>
                <tr class="h23">
                    <td width="">
                        <table class="search" border="0">
                            <tr><td class="title_h"></td>
                            <td class="title_s">Indemnity Claim</td></tr>
                        </table>
                        <!-- Grid  (S) -->
                        <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                            <script language="javascript">ComSheetObject('sheet2');</script>
                            </td>
                        </tr>
                        </table> 
                        <!-- Grid (E) -->
                    </td>
                    
                </tr>

                </table>
            
            </td></tr>
        </table>
<!-- : ( Search Options ) (E) -->

<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 
    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_New">New</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_Detail">Detail</td>
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
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>

</body>
</html>