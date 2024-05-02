<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1073.jsp
*@FileTitle : MT Inventory Simulation by Yard
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.04 문동선
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1073Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1073Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    
    String levelCd = "";
    String ofcCd = "";
    
    String currYrwk = "";
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =    account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();
        currYrwk  = DateTime.getFormatDate(new java.util.Date(), "yyyyww");

        event = (EesEqr1073Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

        levelCd   = JSPUtil.getNull(eventResponse.getETCData("level_cd"));
    }catch(Exception e) {
        out.println(e.toString());
    }
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:50;'","CD00263",0,optionStr2);
%>
<html>
<head>
<title>MT Inventory Simulation by Yard</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    parent.window.moveTo(0,0);
    parent.window.resizeTo("1600","900");
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">

<input type="hidden" name="curr_yrwk" value="<%= currYrwk %>">
<input type="hidden" name="rcc_cd" value="">

<!-- 개발자 작업    -->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
           <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Bkg" id="btn_Bkg">BKG for OP Ref.</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>                
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_downExcel">Down Excel</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
            </tr>
            </table>
        </td></tr>
        </table>
        <!--Button (E) -->
    
        <!--biz page (S)-->
        <!-- 1 (S) -->
        <table class="search"> 
           <tr><td class="bg">
                <!--  biz_1  (S) -->
                <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    <td width="80">Location by</td>
                    <td width="230">
                        <select style="width:115;" name="loc_type_code" class="input" ><!-- LOC_TYPE_CODE -->
                            <!-- <option value="1" selected>ALL (by RCC)</option> -->
                            <option value="2">RCC (by Country)</option>
                            <option value="3">RCC (by LCC)</option>
                            <option value="8">RCC (by ECC)</option>                            
                            <option value="4">LCC (by ECC)</option>
                            <option value="5" selected>LCC (by SCC)</option>
                            <option value="6">ECC (by SCC)</option>
                            <option value="7">SCC (by Yard)</option>
                            <!-- loc_cd -->
                        </select> 
                        <input type="text" class="input" name="loc_cd" style="ime-mode:inactive" dataformat="engup" size="5" maxlength="5" fulfill size="5" maxlength="5" fulfill  style="width:82;" class="input" value="">&nbsp;
                        <img class="cursor" src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" border="0" align="absmiddle">
                    </td>
                    <td width="30"></td>
                    <td width="35">TP/SZ</td>
                    <td width="55"><%= cntrTpsz %></td>
                    <td width="110">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 100, 1 )</script></td>
                    <td width="29"></td>
                    <td width="190"><input type="checkbox" name="show_history" class="trans" OnClick="showHistory();" >Past 3 weeks history&nbsp;&nbsp;</td>
                    <td width="120"><input type="checkbox" name="show_detail" class="trans" OnClick="showDetail();" >Show Detail&nbsp;&nbsp;</td>
                    
                    <td width="90"></td>
                </tr>
            </table>
            <!--  biz_1   (E) -->
            
            <table class="line_bluedot"><tr><td></td></tr></table>
            <!-- 1 (E) -->
        
            <!-- 2 (S) -->        
           
            <!-- grid box (S) -->
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>    
                <!-- Grid - 1 (S) -->
                <table width="100%" id="mainTable" border="0" align=left> 
                        <tr>
                        <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet1');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 1 (E) -->
                </td></tr>
            </table>   
            
            
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>   
                    <table width="100%" border="0" align=left> 
                            <tr>
                            <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet2');</script></td>   
                            </tr>
                    </table>
                </td></tr>
            </table> 
            <!-- grid box (E) -->
            
        </td></tr>
        </table>            
        <!-- 2 (E) -->
        <!--biz page (E)-->
    
    
<table class="height_10"><tr><td colspan="8"></td></tr></table>
    </td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>