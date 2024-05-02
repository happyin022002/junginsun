<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2206.jsp
*@FileTitle : M.G.Set Estimate Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.09
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.10.12 조재성
* 1.0 Creation
*--------------------------------------------------
* History
* 2013.07.09 조경완 [CHM-201325340-01] Role Hard Coding 제거 및 대체 기능 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2206Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.syscommon.common.util.UserRoleUtil" %>
<%@ page import="com.hanjin.syscommon.common.table.ComUsrRoleVO" %>

<%
    EesCgm2206Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    String ofc_cd  			= "";
    String tRole = ""; //Transaction Role //chungpa 20100304 transaction role apply
    
    Logger log = Logger.getLogger("com.hanjin.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
        ofc_cd = account.getOfc_cd();

        event = (EesCgm2206Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
      	//2013-07-09 조경완 Rold Code 하드코딩 대체
      	// 2015 조직코드개편 Chang-Young Kim
		if("SELCON".equals(ofc_cd)){
			tRole = "Authenticated";
		}else{
			tRole = "Not Authenticated";
		}
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>M.G.Set Estimate Expense</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        
        document.form.ofc_cd.value = "<%=ofc_cd%>";		
        loadPage();
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="trole" value="<%=tRole%>">

<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
    <tr>
        <td valign="top">   
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->   
        </td>
    </tr>
    <tr>
        <td valign="top">          
            <!-- : ( Search Options ) (S) -->
            <table class="search"> 
            <tr>
                <td class="bg">
               
                <!-- table class="line_bluedot"><tr><td></td></tr></table-->
                <table class="search" border="0" bordercolor="red" style="width:979;"> 
                    <tr class="h23">                                
					    <td width="100">&nbsp;Execute Month</td>
                        <td>
						    <input type="text" name="period_eddt" style="width:60" value="" class="input1"  maxlength="6" dataformat="ym" >					        
                            <img class="cursor" src="img/btns_calendar.gif" name="btn_calendar" width="19" height="20" border="0" align="absmiddle">
                        </td>                   
                        <!--                     
                        <td width="30">DIV </td>
                        <td width="100"><script language="javascript">ComComboObject('div', 1, 70, 1, 0, 1, true);</script></td>
                        -->
                        <td width="80">&nbsp;Cost Month</td> 
                        <td>
                            <input type="text" name="rev_month" style="width:60" value="" class="input"  maxlength="6" dataformat="ym" >                         
                            <img class="cursor" src="img/btns_calendar.gif" name="btn_calendarRevMonth" width="19" height="20" border="0" align="absmiddle">
                        </td>                       
                        <td align="right">
                        <table class="search_sm2" border="0"  style="width:210;">
                            <tr class="h23">
                                <td><input type="radio" name="doc_type" value="" class="trans" checked>Detailed&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="doc_type" value="" class="trans">Summary</td>
                            </tr>
                        </table>
                        </td>
                    </tr>
                </table>    
                <!-- : ( Search Options ) (E) -->
 
                </td>
            </tr>
        </table>        
        <table class="height_8"><tr><td></td></tr></table>
        <table class="search" id="mainTable"> 
           <tr>
               <td class="bg">          
                   <!--  table class="search" bordercolor="red" border="0">
                       <tr>                   
                       <td class="title_h"></td> 
                       <td class="title_s"  width="200">Received Container</td>
                       <td>&nbsp;<span id="Detail_text"></span></td>
                       </tr>
                   </table-->               
                   <!--  biz   (E) -->
				   <div id="detailLayer">
                   <!-- Grid  (S) -->
                   <table width="100%"  id="mainTable">
                       <tr>
                           <td width="100%">
                               <script language="javascript">ComSheetObject('sheet1');</script>
                           </td>
                       </tr>
                   </table>
                   <!-- Grid  (e) -->       
				   </div>
                   <div id="summaryLayer" style="display:none;">
                   <!-- Grid  (S) -->
                   <table width="100%"  id="mainTable">
                       <tr>
                           <td width="100%">
                               <script language="javascript">ComSheetObject('sheet2');</script>
                           </td>
                       </tr>
                   </table>
                   <!-- Grid  (e) -->       
                   </div>				   
                   <!--  Button_Sub (S) -->
                   <table width="100%" class="button"> 
                       <tr>
                           <td class="btn2_bg">
                               <table border="0" cellpadding="0" cellspacing="0">
                                  <tr>
                                      <td>
                                      </td>
                                      <td>
                                          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                              <tr>
                                                  <td class="btn2_left"></td>
                                                  <td class="btn2" name="btn_DownExcel">Down Excel</td>
                                                  <td class="btn2_right"></td>
                                              </tr>
                                          </table>
                                      </td>
                                  </tr>
                               </table>
                           </td>
                       </tr>
                   </table>
                   <!-- Button_Sub (E) -->     
               </td>
            </tr>
        </table>
        </td>
    </tr>
</table>
        <!--biz page (E)-->
        <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
        <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
                </td>
                 <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
                </td>
                  <td class="btn1_line"></td>
                <td>
                <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Calculation">Calculation</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
                </td>
                <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                </table>
                </td>
            </tr>
            </table>
        <!--Button (E) -->
        </td>
        </tr>
        </table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>