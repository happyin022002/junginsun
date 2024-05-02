<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_4006.jsp
*@FileTitle : Manual Invoice Report by Office
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.05 mun jung cheol
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesDmt4006Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String strUsr_of        = "";
    String strRhq_ofc_cd    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.DMTInvoiceMgt.InvoiceIssueCollectionMgt");
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        strUsr_of = account.getOfc_cd();
        strRhq_ofc_cd = account.getRhq_ofc_cd();

        event = (EesDmt4006Event)request.getAttribute("Event");
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
<title>Manual Invoice Report by Office</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="h_user_office"  value="<%= strUsr_of %>"  >
<input type="hidden" name="usr_rhq_ofc_cd" value="<%=strRhq_ofc_cd%>">

<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">

<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">

<input type="hidden" name="ofc_flg">
<input type="hidden" name="usr_ofc_cd" value="<%= strUsr_of %>">
<!-- 개발자 작업 -->
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
    
    
    <table class="search"> 
            <tr><td class="bg">
                <!--  biz_1  (S) -->
                <div id="sch_cond_div" style=display:block;>
                
                
                        
            <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="100">&nbsp;Issued Date  </td>
                    <td width="">
                        <input type="text" name="fm_dt" maxlength="8" dataformat="ymd" style="width:80" class="input1">&nbsp;~
                        <input type="text" name="to_dt" maxlength="8" dataformat="ymd" style="width:80" class="input1" cofield="fm_dt">
                        <img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
                    </td>
                        
                </tr>
            </table>
                        
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="610">
                        
                        <table class="search_sm2" border="0" style="width:580;"> 
                            <tr class="h23">
                                <td width="87">Issue Office </td>
                                <td width="450" class="stm">
                                <input type="radio" name="ofc_rdo_flg" value="R" class="trans" checked>&nbsp;RHQ&nbsp;&nbsp;
                                <input type="radio" name="ofc_rdo_flg" value="O" class="trans">&nbsp;Office&nbsp;&nbsp;
                                <script language="javascript">ComComboObject('office',1,80,0,1,0,true);</script>&nbsp;<img src="img/btns_multisearch.gif" width="19" height="20" alt="" border="0" align="absmiddle">
                                <input type="checkbox" name="chk_sub_ofc" value="Y" onClick="doInclSubOfc()"  class="trans">&nbsp;Incl. Sub Office                                
                                </td>
                            </tr>
                        </table>
                        </td>
                        <td width="60">Group by</td>
                        <td>
                            <select style="width:80;" class="input" name="grpbyor">
                                <option value="0" selected>Office</option>
                                <option value="1">RHQ</option>
                            </select>
                        </td>
                        </tr>
                </table>        
                        
                <table class="search" border="0" style="width:979;"> 
                    <tr class="h23">
                        <td width="102">&nbsp;Reason </td>
                        <td width="">
                            <script language="javascript">ComComboObject('reasoncd',2,300,0,1,0,true);</script>
                        </td>
                    </tr>
                </table>
                
                  
                </div>
                
                
                
                
                <!--  biz_1  (E) -->
                
                <!-- Grid  (S) -->
                
                <table width="100%"  id="mainTable"> 
                    <tr>
                        <td width="100%">
                            <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>                

                
                
        
<!-- : ( Search Options ) (E) -->
 
            
            
                
                    
            
            </td></tr>
        </table>
    <!-- Tab BG Box  (S) -->
    <!--biz page (E)-->
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:;"> 
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_minimize">Minimize</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_detatil">Detail</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downexcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
        </td></tr>
        </table>
    <!--Button (E) -->
    </td></tr>
</table>
<!-- Copyright (S) -->

<!-- Copyright(E)-->
<!-- 개발자 작업  끝-->
</form>
</body>
</html>