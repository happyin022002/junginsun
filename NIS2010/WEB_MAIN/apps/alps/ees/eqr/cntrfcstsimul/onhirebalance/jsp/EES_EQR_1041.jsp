<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1041.jsp
*@FileTitle : On-Hire Request & Approval
*Open Issues :
*Change history : 
	1. 2013-12-18 pick-up week, order year 추가, 신용찬 수석
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.28 문동선
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.onhirebalance.event.EesEqr1041Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1041Event  event = null;                    //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;            //서버에서 발생한 에러
    String strErrMsg = "";                        //에러메세지
    int rowCount     = 0;                        //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";
    
    String levelCd = "";
    String ofcCd   = "";
    
    String popMode  = (request.getParameter("pop_mode") == null)? "N": "Y";  
    //String tempWeek = (request.getParameter("yrwk") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyyww") : request.getParameter("yrwk");
    String tempWeek = "";
    String popRcc   = (request.getParameter("rcc_cd") == null)? "ALL" : request.getParameter("rcc_cd");
    String popLcc   = (request.getParameter("lcc_cd") == null)? "ALL" : request.getParameter("lcc_cd");
    String popTpsz  = (request.getParameter("tpsz_flag") == null)? "D2,D4,D5,D7" : request.getParameter("tpsz_flag");
    
    //2015.02.25 CHM-201534210 EQR 소스 보안
    String dp_seq   = JSPUtil.getParameter(request, "dp_seq"); // 1003화면의 sheet 구분(2,3,4,5,6)
    String row      = JSPUtil.getParameter(request, "row"); // 1003화면의 1048를 오픈한 row 구분
    
    String yrwk      = request.getParameter("yrwk"); // 1003화면의 선택된 주차
    
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofcCd     = account.getOfc_cd();

        event = (EesEqr1041Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);       
        
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        if(popMode.equals("Y")) tempWeek = yrwk;  // 1003에서 선택된 주차
        else                    tempWeek = eventResponse.getETCData("fcast_yrwk");  // 기본주차
        //levelCd   = eventResponse.getETCData("level_cd");
    }catch(Exception e) {
        out.println(e.toString());
    }
   
    String locSelectBox = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");        
    
    String optionStr2 = "000000: :ALL";
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:50;'","CD00263",0,optionStr2);
    String locSelectBox2 = JSPUtil.getCodeCombo("loc_tp_cd_second","L","","CD03052",0,"");   
    
    String currYear = DateTime.getFormatDate(new java.util.Date(), "yyyy");
    
%>
<html>
<head>
<title>On-Hire Request & Approval</title>
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
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;On-Hire Request & Approval</td></tr>
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
<input type="hidden" name="ofc_cd"   value="<%= ofcCd %>">
<input type="hidden" name="pop_mode" value="<%= popMode %>">
<input type="hidden" name="pop_rcc"  value="<%= popRcc %>">
<input type="hidden" name="pop_lcc"  value="<%= popLcc %>">
<input type="hidden" name="pop_tpsz" value="<%= popTpsz %>">
<input type="hidden" name="dp_seq"   value="<%= dp_seq %>">
<input type="hidden" name="row"      value="<%= row %>">

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
                    <td class="btn1" name="btn_request">Request</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_cancel">Request Cancel</td>
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
                    <td>
                        <table border="0" style="width:455;" class="search_sm2"> 
                            <tr class="h23" >
                            
                              <td width="15">
                                  <input type="radio" name="div_flag" value="1" class="trans" OnClick="radioToggle();" checked>
                              </td>  
                              <td width="85">Approval WK</td>
                              <td width="65" class="sm"><input type="text" name="yrwk" id="yrwk" value="<%=tempWeek%>" class="input1" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);"></td>
                              <td width="15">
                                  <input type="radio" name="div_flag" value="2" class="trans" OnClick="radioToggle();">
                              </td>  
                              <td width="40">Period</td>
                              <td width="75"> 
                                  <select name="periodtp" style="width:70;" class="input">
                                  <option value="W" >yyyyww</option>
                                  <option value="M" >yyyymm</option>
                                  </select>
                              </td>
                              <td width="140">
                                 <input name="fmperiod" id="fmperiod" value="" type="text" class="input" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);moveTabNormal(this,toperiod);">&nbsp;~
                                 <input name="toperiod" id="toperiod" value="" type="text" class="input" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);"> 
                              </td>
                              
                            </tr>
                            
                            <tr class="h23" >
                                                          
                              <td width="15">
                                  <input type="radio" name="div_flag" value="3" class="trans" OnClick="radioToggle();" >
                              </td>  
                              <td width="85">Pick-up WK</td>
                              <td width="65" class="sm"><input type="text" name="yrwk_pkup" id="yrwk_pkup" value="<%=tempWeek%>" class="input" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);"></td>
                              <td width="15">
                                  <input type="radio" name="div_flag" value="4" class="trans" OnClick="radioToggle();">
                              </td>  
                              <td width="40">Period</td>
                              <td width="75"> 
                                  <select name="periodtp_pkup" style="width:70;" class="input">
                                  <option value="W" >yyyyww</option>
                                  <option value="M" >yyyymm</option>
                                  </select>
                              </td>
                              <td width="140">
                                 <input name="fmperiod_pkup" id="fmperiod_pkup" value="" type="text" class="input" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);moveTabNormal(this,toperiod_pkup);">&nbsp;~
                                 <input name="toperiod_pkup" id="toperiod_pkup" value="" type="text" class="input" style="width:55;ime-mode:disabled;" maxlength="6" onkeyup="onlyNumberInput(event);"> 
                              </td>

                            </tr>                            
                        </table>
                    </td>  
                    
                    <td>
					    <table class="search_in" border="0" style="width:495;">
					        <tr class="h23">
					
                              <td width="50">RCC</td>
                              <td width="90">
                                  <script language="javascript">ComComboObject('rcc_cd' , 1, 80, 1 )</script>
                              </td>    
                              
                              <td width="30">LCC</td>
                              <td width="90">
                                  <script language="javascript">ComComboObject('lcc_cd' , 1, 80, 1 )</script>
                              </td>             
                              <td width="35">TP/SZ</td>
                              <td width="55"><%= cntrTpsz %></td>
                              <td >&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 100, 1 )</script></td>
                    

                    
                           </tr>
                    
					       <tr class="h23">
					       
                             <td width="50">Status</td>
                             <td width="90">
                                 <select style="width:70;" name="sts_cd" class="input" ><!-- LOC_TYPE_CODE -->
                                     <option value="" selected>ALL</option>
                                     <option value="S">Saved</option>
                                     <option value="R">Requested</option>
                                     <option value="A">Approved</option>
                                     <!-- loc_cd -->
                                 </select>                         
                             </td>    
                             
                             <td width="30"></td>
                             <td width="90">
                                 
                             </td>             
                             <td width="35"></td>
                             <td width="55"></td>
                             <td ></td>
                           
                           
                           </tr>
                        </table>
                    </td>                    
                    
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
            
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>   
                    <table width="100%" border="0" align=left > 
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