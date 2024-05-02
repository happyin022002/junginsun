<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1012.jsp
*@FileTitle : Port Inventory Balance Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.09.17 문동선
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
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.surplusarea.event.EesEqr1012Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EesEqr1012Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
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

        event = (EesEqr1012Event)request.getAttribute("Event");
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
    String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:70;'","CD00263",0,optionStr2);
%>
<html>
<head>
<title>Port Inventory Balance Simulation</title>
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
<input type="hidden" name="loc_chk" value="">

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
                    <td width="40">Trade</td>
                    <td width="90"><script language="javascript">ComComboObject('trade' , 2, 70, 0, 1 )</script></td>
                    <td width="50">S.Trade</td>
                    <td width="90"><script language="javascript">ComComboObject('subtrade' , 4, 70, 0, 1 )</script></td>
                    <td width="40">Lane</td>
                    
                    <!-- td width="90"><script language="javascript">ComComboObject('lane' , 5, 70, 0, 0 )</script></td -->
                    <td width="90"><script language="JavaScript">ComComboObject('lane', 2, 70, 0, 0);</script></td><!-- 정길수 부장님 작업용 -->
                    
                    <td width="85">POL Location</td>
                    <td width="90"><script language="javascript">ComComboObject('subconti' , 2, 70, 0, 1)</script></td>
                    
                    <td width="119">Inventory Include</td>
                    <td width="300">
                    <table border="0" style="width:300;" class="search_sm2"> 
                        <tr class="h23">
                            <td width="50">Damage</td>
                            <td width="50"><select style="width:40;" name="chk_im" class="input">
                                           <option value="Y" selected>Y</option>
                                           <option value="N" >N</option>
                                           </select></td>
                            <td width="50">Disposal</td>
                            <td width="50"><select style="width:40;" name="chk_id" class="input">
                                           <option value="Y">Y</option>
                                           <option value="N" selected>N</option>
                                           </select></td>
                            <td width="50">&nbsp;&nbsp;SOC</td>
                            <td width="50"><select style="width:40;" name="chk_is" class="input">
                                           <option value="Y" >Y</option>
                                           <option value="N" selected>N</option>
                                           </select></td>                              
                        </tr>
                    </table>
                    </td>
                    <td width=""></td>
                </tr>
              </table>
              
              <table class="search" border="0" style="width:979;"> 
                <tr class="h23">
                    
                    <td width="38">TP/SZ</td>
                    <td width="80"><%= cntrTpsz %></td>
                    <td width="140">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 127, 1 )</script></td>
                    <td width="5"></td>
                    <td width="175"><input type="checkbox" name="show_history" class="trans" OnClick="showHistory();" >Past 3 weeks history&nbsp;&nbsp;</td>
                    <td width="120"><input type="checkbox" name="show_detail" class="trans" OnClick="showDetail();" >Show Detail&nbsp;&nbsp;</td>
                    
                    <td width="412"></td>
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
                <table width="100%" border="0" align=left> 
                        <tr>
                        <td width = "979" align=left><script language="javascript">ComSheetObject('sheet1');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 1 (E) -->
                </td></tr>
           </table>      
            
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>    
                <!-- Grid - 2 (S) -->
                <table width="100%" id="mainTable" border="0" align=left> 
                        <tr>
                        <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet2');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 2 (E) -->
                </td></tr>
            </table>   
            
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>   
                <!-- Grid - 3 (S) -->
                <table width="100%" border="0" align=left> 
                        <tr>
                        <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet3');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 3 (E) -->
                </td></tr>
            </table> 
            <!-- grid box (E) -->
            
            <table class="search" width="" border="0" >
                <tr><td valign="top" align=left>   
                <!-- Grid - 3 (S) -->
                <table width="100%" border="0" align=left> 
                        <tr>
                        <td width = "100%" align=left><script language="javascript">ComSheetObject('sheet4');</script></td>   
                        </tr>
                </table>
                <!-- Grid - 3 (E) -->
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