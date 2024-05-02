<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1057.jsp
*@FileTitle : Match-back by Vessel
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.07.01 문중철
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrcodconfirm.emptycodadjustment.event.EesEqr1057Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1057Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String tVvd = "";
    String tPod = "";
    String tVersion = "";
//    Logger log = Logger.getLogger("com.hanjin.apps.cntrcodconfirm.emptycodadjustment");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesEqr1057Event)request.getAttribute("Event");
        // 2015.02.25 CHM-201534210 EQR 소스 보안
        tVvd = JSPUtil.getParameter(request, "vvd");
        tPod = (String)request.getParameter("pod");
        // 2015.02.25 CHM-201534210 EQR 소스 보안
        tVersion = JSPUtil.getParameter(request, "version");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>Welcome to nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="version" value="<%= tVersion %>">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; <span id="HEADTITLE" style="width:500px;text-align:left"></td></tr>
        </table>
        <!-- : ( Title ) (E) -->
    
    <tr><td valign="top">
    
    
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:900;"> 
            <tr class="h23">
                <td width="30">VVD</td>
                <td width="120"><input type="text" name="vvd" style="width:80;ime-mode:disabled" class="input1" dataformat="engup" maxlength="9" value="<%= tVvd %>" ></td>
                <td width="30">POD</td>
                <td width="">
                    <select style="width:65;" class="input" name="pod">
                    <option value="" selected></option>
                    </select>
                </td>
            </tr> 
            </table>
            
                <!--  biz_1   (E) -->
                
            <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
                
            <table class="search" border="0" style="width:900;"> 
            <tr class="h23">
                <td width="49%">
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Source : Master </td></tr>
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
                <td width="1%"></td>
                <td width="49%">
                <table class="search" border="0">
                <tr><td class="title_h"></td>
                    <td class="title_s">Source : MTY BKG </td></tr>
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
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet3');</script>
                        </td>
                    </tr>
                </table> 
            <!-- Grid (E) -->
    </td></tr>
        </table>                
     <table class="height_5"><tr><td></td></tr></table>
    

            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
  
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->  
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right">
                </tr></table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right">
                </tr></table></td>
                
            <td class="btn1_line"></td>     
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right">
                </tr></table></td>    
            </tr>
        </table></td> 
            </tr>
        </table>
        <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
