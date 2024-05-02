<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_cim_1053.jsp
*@FileTitle : CIM Batch Job Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event.EesCim1053Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesCim1053Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //error from server
    String strErrMsg = "";                      //error message
    int rowCount     = 0;                       //count of DB resultSET list

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.clt.apps.CNTROperatioNPerformanceMgt.EQMatchBackNLoadFactorMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();


        event = (EesCim1053Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

     	// adding logic to get data from server when first loading
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>CIM Batch Job Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        loadPage();
        document.form.froms.focus();
    }
    
</script>
</head>
<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="etcDataValue" value="">
<input type="hidden" name="etcChk" value="">
<input type="hidden" name="fromz">
<input type="hidden" name="toz">
<input type="hidden" name="period" value="W">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
        <!--top menu (S)-->
        <!--top menu (E)-->
    </td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
    <!--Page Title, Historical (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
        <tr><td class="btn1_bg">
        
            <table border="0" cellpadding="0" cellspacing="0">
            <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve"  id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                
                </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
    <!--biz page (S)-->
        <table class="search"> 
        <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="50">Period</td>
                    <td width="" class="stm">
                    <input type="text" style="width:60;" class="input1" value="" name="froms" caption="FM" required dataformat="yw" maxlength="6">&nbsp;~&nbsp;
                    <input type="text" style="width:60;" class="input1" value="" name="tos"   caption="TO" required dataformat="yw" maxlength="6"></td>
                    </tr> 
                </table>
                
                <!--  biz_1   (E) -->
                
                </td></tr>
            </table>
            
            <table class="height_10"><tr><td colspan="8"></td></tr></table>
        <!-- Tab (S) -->
     
        <!-- Tab (E) -->
        <!-- Tab BG Box  (S) -->
        <table class="search"> 
        <tr><td class="bg">
                                                                    
                <!-- Grid  (S) -->
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('t1sheet1');</script>
                        </td>
                    </tr>
                </table>                
            <!-- Grid (E) -->

            <!--  Grid_button (S) -->
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        
    <!--Button (E) -->
    
<table class="height_10"><tr><td colspan="8"></td></tr></table>
    </td></tr>
</table>


<!-- Copyright (S) -->
<!-- Copyright(E)-->
</form>
</body>
</html>
