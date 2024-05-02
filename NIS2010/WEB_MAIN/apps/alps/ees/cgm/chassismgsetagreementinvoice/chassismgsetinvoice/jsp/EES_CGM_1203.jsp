<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1203.jsp
*@FileTitle : CPS Payable Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.11
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.03.11 조경완
* 1.0 Creation
* -------------------------------------------------------------
* history
* 2014-05-21 Chang Young Kim 
*  [CHM-201430040] Payable Charge Creation_Audit 결과 Update 기능 개발
* 2015-04-02 Chang Young Kim
*  [CHM-201431711] COPS Charge Creation - Charge Audit Result & Payable Amount Confirm
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1203Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%>

<%
    EesCgm1203Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag  = "";
    String codeList     = "";
    String pageRows     = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strOfc_cd        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");
    String xml = HttpUtil.makeXML(request,response);
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strOfc_cd = account.getOfc_cd();
       
        event = (EesCgm1203Event)request.getAttribute("Event");
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
<title>CPS Payable Charge Creation</title>
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

<body  onLoad="setupPage();">
<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace("\"","'")%>">
</form>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name ="eq_knd_cd" value="Z">

<input type="hidden" name ="chg_cre_seq" value="">
<input type="hidden" name ="agmt_seq" value="">
<input type="hidden" name ="agmt_ofc_cty_cd" value="">
<input type="hidden" name ="lse_chg_sts_cd" value="">
<input type="hidden" name ="vndr_seq" value="">
<input type="hidden" name ="chss_pool_cd" value="">
<input type="hidden" name ="cre_ofc_cd" value="<%=strOfc_cd %>">
<!-- 2014.08.04 Chang Young Kim Added In accordance with the "미확정 CHM" (S) -->
<input type="hidden" name ="agmt_ver_no" value="">
<input type="hidden" name ="intg_cd_id" value="">
<!-- 2014.08.05 Chang Young Kim Added In accordance with the "미확정 CHM" (E) -->

<!-- 개발자 작업 -->
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
                <!--  biz_1  (S)  -->
                
            <table width="100%" class="search" > 
            <tr class="h23">
                    <td width="80">Cost Month</td>
                    <td ><input type="text" name="cost_yrmon"  maxlength="6" style="width:60;" dataformat="ym" class="input1" value="">&nbsp;<img name="btns_cost_yrmon" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
                    <td width="80">Pool Name</td>
                    <td><script language="javascript">ComComboObject('combo_pool', 0, 100, 0);</script></td>
                    <td width="500"></td>
                </tr>
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
                <!--  biz_1  (E)  -->
        <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                <!--  biz_2  (S)  -->
                
            <table class="search" border="0">
                        <tr><td class="title_h"></td>
                        <td class="title_s">Created Results</td></tr>
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
            
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0"> 
        <tr><td class="btn2_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <!-- 2014.05.23 Chang Young Kim_Added In accordance with the "CHM-201430040" (S) -->
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_AuditResultUpdate">Audit Result Update</td>
                    <td class="btn2_right"></td>
                    </tr>
                </table></td>
                <!-- 2014.05.23 Chang Young Kim_Added In accordance with the "CHM-201430040" (E) -->
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_InvoiceImportAudit">Invoice Import & Audit</td>
                    <td class="btn2_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_AuditResultCreation">Audit Result & P. Amt Confirm</td>
                    <td class="btn2_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                    <td class="btn2" name="btn_Delete">Delete</td>
                    <td class="btn2_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->
            
            
    <!--  biz_2  (E)  -->
        
                        
                
        </td></tr>
        </table>    
            
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
    <!--Button (E) -->  
    <!--biz page (E)-->
    
    </td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>