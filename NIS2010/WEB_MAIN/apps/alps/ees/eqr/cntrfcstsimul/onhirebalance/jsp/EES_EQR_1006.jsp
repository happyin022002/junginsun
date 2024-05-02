<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1006.jsp
*@FileTitle : On-Hire Balance Status
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13 문동선
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1006Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
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
    
    String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";  
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();

        event = (EesEqr1006Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        //levelCd   = eventResponse.getETCData("level_cd");
    }catch(Exception e) {
        out.println(e.toString());
    }
   
    String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");        
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
    
    String currYear = DateTime.getFormatDate(new java.util.Date(), "yyyy");
    
%>
<html>
<head>
<title>On-Hire Balance Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    //parent.window.moveTo(0,0);
    //parent.window.resizeTo("1600","900");
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>



<!-- 개발자 작업    -->

<% if (popMode.equals("Y")) { %>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
    <tr><td class="top"></td></tr>
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;On-Hire Balance Status</td></tr>
    </table>
<% } else { %>
<body  onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr><td valign="top">
    <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
<% } %>    

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="level_cd" value="<%= levelCd %>">
<input type="hidden" name="ofc_cd" value="<%= ofcCd %>">
<input type="hidden" name="curr_year" value="<%=currYear %>">


    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
           <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_new" id="btn_Retrieve">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
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
                    <td width="30">Year</td>
                    <td width="100">
                        <script language="javascript">ComComboObject('years' , 1, 90, 1, 1 )</script>
                    
                    <td width="70">Lease Term</td>
                    <td width="60">
                        <select style="width:50;" name="eq_lstm_cd" class="input" ><!-- LOC_TYPE_CODE -->
                            <option value="" selected>ALL</option>
                            <option value="LT">LT</option>
                            <option value="ST">ST</option>
                            <option value="OW">OW</option>
                            <!-- loc_cd -->
                        </select> 
                    </td>
                    
                    <td width="80">Lease Period</td>
                    <td width="60">
                        <select style="width:50;" name="lse_prd_seq" class="input" ><!-- LOC_TYPE_CODE -->
                            <option value="" selected>ALL</option>
                            <option value="1">1st</option>
                            <option value="2">2nd</option>
                            <option value="3">3rd</option>
                            <option value="4">4th</option>
                            <option value="5">5th</option>
                            <option value="6">6th</option>
                            <option value="7">7th</option>
                            <option value="8">8th</option>
                            <option value="9">9th</option>
                            <option value="10">10th</option>

                            <!-- loc_cd -->
                        </select> 
                    </td>
                    
                    <td width="30">RCC</td>
                    <td width="90">
                        <script language="javascript">ComComboObject('rcc_cd' , 1, 80, 1 )</script>
                    </td>    
                    
                    <td width="30">LCC</td>
                    <td width="90">
                        <script language="javascript">ComComboObject('lcc_cd' , 1, 80, 1 )</script>
                    </td>             
                    <td width="35">TP/SZ</td>
                    <td width="75"><%= cntrTpsz %></td>
                    <td width="150">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 150, 1 )</script></td>
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
                <table width="100%" id="mainTable" border="0" align=left > 
                        <tr>
                        <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet1');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 1 (E) -->
                </td></tr>
            </table>    
            
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0" >
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr><td class="btn2_left"></td>
                          <td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
                          <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr><td class="btn2_left"></td>
                          <td class="btn2" name="btn_rowdel">Row&nbsp;Del</td>
                          <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            
            <!-- grid box (E) -->
            
        </td></tr>
        </table>            
        <!-- 2 (E) -->
        <!--biz page (E)-->
    
<table class="height_10"><tr><td colspan="8"></td></tr></table>
    </td></tr>
</table>

<% if (popMode.equals("Y")) { %>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->
<% } %>    

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>