<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4007.jsp
*@FileTitle : Manual Invoice Report by Office - Detail(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.10.06 문중철
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4007Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4007Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    
    String tIssoff = "";
    String tJspno = "";
    String tFmdt = "";
    String tTodt = "";
    String tOfcFlg = "";
    String tOffice = "";
    String tReason = "";
    String selcur = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();


        event = (EesDmt4007Event)request.getAttribute("Event");
        tIssoff = (String)request.getParameter("issoff");
        tJspno = (String)request.getParameter("jspno");
        tFmdt = (String)request.getParameter("fmdt");
        tTodt = (String)request.getParameter("todt");
        tOfcFlg = (String)request.getParameter("ofcflg");
        tOffice = (String)request.getParameter("office");
        tReason = (String)request.getParameter("reason");
        selcur = (String)request.getParameter("selcur");
        
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
<title>Manual Invoice Report by Office - Detail(s)</title>
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
<input type="hidden" name="pagerows">

<input type="hidden" name="tJspno" value="<%=tJspno%>">
<input type="hidden" name="h_user_office" value="<%= strUsr_of %>">

<input type="hidden" name="fm_dt"   value="<%= tFmdt   %>">
<input type="hidden" name="to_dt"   value="<%= tTodt   %>">
<input type="hidden" name="ofc_flg" value="<%= tOfcFlg %>">
<input type="hidden" name="office"  value="<%= tOffice %>">
<input type="hidden" name="reasoncd"  value="<%= tReason %>">
<input type="hidden" name="selcur"  value="<%= selcur %>">


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Manual Invoice Report by Office – Detail(s)</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
    <!--Page Title, Historical (E)-->
    
    
    <table class="search"> 
            <tr><td class="bg"  border="0">
                <!-- Grid  (S) -->
                
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                

                <!-- Grid  (E) -->
                <table class="search" border="0" style="width:100%;"> 
                <tr class="h23">
                    <td width="70">INV Q'ty</td>
                    <td width="160">
                    <input type="text" name="invqtybox" style="width:50;text-align:right" class="input2" value="" readOnly>
                    </td>
                    <td width="">&nbsp;</td>
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
    
  

    
    
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_detail">Detail</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td class="btn1_line"></td>
                    <td width=""><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
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