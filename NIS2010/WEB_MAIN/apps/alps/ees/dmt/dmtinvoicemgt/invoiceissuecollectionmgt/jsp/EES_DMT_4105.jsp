<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4105.jsp
*@FileTitle : Remark(s)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.09.25 문중철
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
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4105Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4105Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String tInvno = "";
    String tJspno = "";
    
    Logger log = Logger.getLogger("com.hanjin.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesDmt4105Event)request.getAttribute("Event");
        tInvno = (String)request.getParameter("invno");
        tJspno = (String)request.getParameter("jspno");
        
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
<title>Remark</title>
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

<input type="hidden" name="tinvno" value="<%=tInvno%>">
<input type="hidden" name="tjspno" value="<%=tJspno%>">
<input type="hidden" name="rmrk">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Remark(s)

</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
        
        <!-- : ( Search Options ) (S) -->
 
            <table class="search"> 
            <tr><td class="bg">
            <table class="search" border="0" style="width:879;"> 
               <tr class="h23">
               
               <td width="70"><span id="dmt4105" style="text-align:left"></span></td>
               <td width=""><input type="text" style="width:100;" class="input2" value="<%= tInvno %>" name="invno" readOnly></td>
               </tr>
        </table> 
                <!-- : ( Grid ) (S) -->
                <table width="100%" class="grid"> 
                    <tr><td width="100%" class="tr2_head" colspan="2">Remark(s) on Sheet</td></tr>
                    <tr class="input1">
                    <td width="5%" align="center" valign="middle">1</td>
                    <td width=""><input type="text" style="width:100%;font-family: Courier New;" class="noinput1" value="" name="remark01" maxlength="85" required></td>
                    </tr>
                    <tr class="input1">
                    <td width="" align="center" valign="middle">2</td>
                    <td width=""><input type="text" style="width:100%;font-family: Courier New;" class="noinput1" value="" name="remark02" maxlength="85" required></td>
                    </tr>
                </table> 
                <!-- : ( Grid ) (E) --> 
                <!-- : ( Button : Grid ) (S) -->
            
                <!--  Button_Sub (S) -->
            <!-- Button_Sub (E) -->
            <!-- : ( Button : Grid ) (E) -->    
            
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
            <tr><td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
            </tr>
            </table></td>
                <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
            </tr>
            </table></td>
            <td class="btn1_line"></td>
            <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
            </tr>
            </table>
        </td></tr>
        </table>
        </td></tr>
        </table>
        
        </td></tr>
</table>
    <!--Button (E) -->
    
    </td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
                    <table width="100%"  id="mainTable"> 
                        <tr>
                            <td width="100%">
                                <script language="javascript">ComSheetObject('sheet1',0,0);</script>
                            </td>
                        </tr>
                    </table>
</form>         
</body>
</html>
