<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0263.jsp
*@FileTitle : Self Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.09.09 김대호
* 1.0 Creation
===============================================================================
* History
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event.EsmBkg0263Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0263Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String blNo = "";
    String caflg = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.RevenueAudit.UnmatchBL");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        
        blNo = JSPUtil.getNullNoTrim(request.getParameter("bl_no"));
        caflg = JSPUtil.getNullNoTrim(request.getParameter("ca_flg"));
        event = (EsmBkg0263Event)request.getAttribute("Event");
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
<title>Self Audit</title>
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

<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">
<input type="hidden" name="bl_no_org" value="<%=blNo%>">
<input type="hidden" name="ca_flg" value="<%=caflg%>">
<input type="hidden" name="key">  <!-- BackEndJob -->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Self Audit</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!--biz page (S)-->
        <table class="search" id="mainTable"> 
            <tr><td class="bg">
            
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="55">B/L No.</td>
                    <td width=""><input type="text" name="bl_no" style="width:100;text-align:center;ime-mode:disabled" class="input1" caption="B/L No" dataformat="uppernum" maxLength="12"></td>
                    <td width="540">&nbsp;</td>
                    <td width="100">&nbsp;Audit Result</td>
                    <td width=""><input type="text" name="audit_result" style="width:120;text-align:center;" class="input1" value="" readonly></td>
                </tr> 
                </table>                
                <!--  biz_1   (E) -->
                
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable">
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
                <!-- Grid (E) -->   
            
        </td></tr></table>
        <!--biz page (E)--> 

</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td valing="top"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                </tr></table></td>
            <td class="btn1_line"></td>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
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

        