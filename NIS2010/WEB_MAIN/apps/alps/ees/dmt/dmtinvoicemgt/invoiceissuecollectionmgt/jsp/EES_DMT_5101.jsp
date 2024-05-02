<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_5101.jsp
*@FileTitle : Hold Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.12 문중철
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt5101Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    String strUsr_of = "";
    String strUsr_dt = "";
    
    String invoiceNo = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strUsr_dt = account.getCre_dt();


        event = (EesDmt5101Event)request.getAttribute("Event");
        invoiceNo = (String)request.getParameter("invoiceNo");
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
<title>Hold Reason Entry</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="holdReasn">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Hold Reason Entry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
    
    
    <table class="search"> 
            <tr><td class="bg">
                
                <table class="search" border="0" style="width:499;"> 
                    <tr class="h23">
                        <td width="70">Invoice No.  </td>
                        <td width="">
                            <input type="text" style="width:420;" class="input2" value="<%= invoiceNo %>" name="invoiceNo" readOnly>
                        </td>
                        
                    </tr>
                </table>
                <!--  biz_1  (E) -->
                <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
                
                <!-- Grid  (S) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1');</script>
                            </td>
                        </tr>
                    </table>
                
                <!-- Grid  (e) -->
                <table class="height_2"><tr><td></td></tr></table>      
                <table width="100%" class="grid2"> 
                        <tr class="tr2_head">
                        <td width="15%">Remark(s) </td>
                        <td width=""><textarea cols="" rows="3" style="width:100%;" name="holdRemrk">

</textarea> </td>
                    </tr>
                    </table>    
                    
                    <table class="search" border="0" style="width:499;"> 
                    <tr class="h23">
                        <td width="320">
                            <input type="text" style="width:75;" class="input2" value="<%=strUsr_dt%>" Name="holdYear" readOnly>&nbsp;
                            <input type="text" style="width:75;" class="input2" value="<%=strUsr_of%>" Name="holdOffc" readOnly>&nbsp;
                            <input type="text" style="width:150;" class="input2" value="<%=strUsr_nm%>" Name="holdUser" readOnly>
                        </td>
                    </tr>
                    </table>
            </td></tr>
        </table>
        
<!-- : ( Search Options ) (E) -->
 
            
            
                    
      <table class="height_5"><tr><td></td></tr></table>              
            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    
<!-- : ( Search Options ) (E) -->



    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn1_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
            </tr>
        </table>
    <!--Button (E) -->
    </td></tr>
        </table>
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>         
</body>
</html>
