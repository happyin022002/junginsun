<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1048.jsp 
*@FileTitle : MTY Repo In 상세내역 조회 및 Discharging List 수기수정
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.05
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2009.08.11 신용찬
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.event.EesEqr1048Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1048Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String locGrpCd = "";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String week = "";
    String title = "";
    String dp_seq = ""; // 1003화면의 sheet 구분(2,3,4,5,6)
    String row    = ""; // 1003화면의 1048를 오픈한 row 구분
    String levelCd = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EesEqr1048Event)request.getAttribute("Event");
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        title = "Discharging List";
        week  = (String)event.getAttribute("fcast_yrwk");
        dp_seq  = (String)event.getAttribute("dp_seq");
        row  = (String)event.getAttribute("row");
        
        levelCd = (String)event.getAttribute("level_cd");
        
        if("E".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "ECC";
        }else if("L".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "LCC";
        }else if("S".equals(event.getAttribute("loc_grp_cd"))){
            locGrpCd = "SCC";
        }
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title><%=title%></title>
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

<script language="javascript">

    function setupPage(){  

        loadPage();
    }

</script>
 


<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="loc_grp_cd"      value="<%=event.getAttribute("loc_grp_cd") %>">
<input type="hidden" name="loc_cd"          value="<%=event.getAttribute("loc_cd") %>">
<input type="hidden" name="fcast_yrwk"      value="<%=event.getAttribute("fcast_yrwk") %>">
<input type="hidden" name="repo_pln_yrwk"   value="<%=event.getAttribute("repo_pln_yrwk") %>">
<input type="hidden" name="level_cd"        value="<%=event.getAttribute("level_cd") %>">
<input type="hidden" name="wk_st_dt"        value="<%=event.getForecastReportListVO().getWkStDt() %>">
<input type="hidden" name="curr_flag"       value="<%=event.getForecastReportListVO().getCurrFlag() %>">
<input type="hidden" name="dp_seq"          value="<%= dp_seq %>">
<input type="hidden" name="row"             value="<%= row %>">

<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<%=title%></td></tr>
        </table>
        <!-- : ( Title ) (E) -->

        <!--biz page (S)-->
        <table class="search" id="mainTable">
            <tr><td class="bg">
            <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td colspan="4" align="center">Wk<%= week.substring(4) %> disc vol. (<%=event.getForecastReportListVO().getWkStDt() %>~<%=event.getForecastReportListVO().getWkEndDt() %>)</td>
                </tr>
                <tr class="h23">
                    <td width="35"><%= locGrpCd %></td>
                    <td width="10">:</td>
                    <td width="100"><%=event.getAttribute("loc_cd") %></td>
                    <td width="834"></td>
                </tr>
            </table>

            <!-- Grid  (S) -->
            <div id="dis_vol" style="display:none">
                <table width="100%" class="search" id="mainTable">
                    <tr class="h23">
                    <td width="145">Discharged Vol.</td>
                    <td width="834"></td>
                    </tr>
                    <tr>
                        <td width="100%">
                        <script language="javascript">ComSheetObject('sheet1');</script>
                        </td>
                    </tr>
                </table>
            </div>
                
                <table width="100%" class="search" id="mainTable">
                    <tr class="h23">
                    <td width="145">To Be discharging Vol.</td>
                    <td width="834"></td>
                    </tr>
                    <tr>
                        <td width="100%">
                        <script language="javascript">ComSheetObject('sheet2');</script>
                        </td>
                    </tr>
                </table>                
            <!-- Grid (E) -->

            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
            <tr><td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" name="btn_RowAdd">Row&nbsp;Add</td>
                        <td class="btn2_right"></td>
                    </tr>
                    </table>
                    </td>

                    <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn2_left"></td>
                        <td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
                        <td class="btn2_right"></td>
                    </tr>
                    </table>
                    </td>                   
                    
                </tr>
                </table>
            </td></tr>
            </table>
            <!-- Button_Sub (E) -->         

            </td></tr>
        </table>
        <!--biz page (E)-->
<table class="height_5"><tr><td colspan="8"></td></tr></table>
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
                    <td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                
                <% if(levelCd.equals("1")) { %>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right">
                </tr></table></td> 
                <% }else { %>
                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_apply">Apply</td>
                    <td class="btn1_right">
                </tr></table></td>                 
                <% } %>
                             
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
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
