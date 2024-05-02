<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1020.jsp
*@FileTitle : Group A/N Remark Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : Son Yun Seuk
*@LastVersion : 1.0
* 2009.07.17 Son Yun Seuk
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1020Event"%>

<%
    EsmBkg1020Event     event = null;
    Exception serverException = null;
    String strOfc_cd          = "";
    String strErrMsg          = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.PickUpNoticeBC");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strOfc_cd = account.getOfc_cd();
      
    
        event = (EsmBkg1020Event)request.getAttribute("Event");
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
<title>Group A/N Remark Template</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage(){  
        loadPage();
    }
</script>

</head>
<body class="popup_bg"  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value = "">
<input type="hidden" name="old_ofc_cd" value="">
<input type="hidden" name="an_seq" value="">

           <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>


      <table class="search"> 
        <tr>
          <td class="bg">
            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:479;"> 
              <tr class="h23">
                <td width="60">&nbsp;&nbsp;Office</td>
                <td width=""><input type="text" style="width:45;ime-mode:disabled;" class="input1" name="ofc_cd" value="<%=strOfc_cd %>" 
                                                 caption="EQ Office Code" maxlength="5" minlength="5" dataformat="engup" required="" fullfill="fullfill" /></td>
              </tr>
            </table>
        
            <table border="0" style="width:100%; background-color:white;" class="grid2"> 
              <tr><td width="" class="tr2_head_l" >Address</td></tr>
              <tr><td><input type="text" style="width:100%" name="addr_ctnt"></td></tr>
            </table>
        
            <table class="line_bluedot"><tr><td></td></tr></table>
        
            <table border="0" style="width:100%; background-color:white;" class="grid2"> 
              <tr><td width="" class="tr2_head_l">Important Notice</td></tr>
              <tr><td><textarea style="width:100%;text-indent:0px" rows="8" name="impt_ntc_rmk"></textarea></td></tr>
            </table>
      
         


                </td>
              </tr>
            </table>



<!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                     <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Delete">Delete</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
               
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!--Button (E) -->

      </td>
        </tr>
      </table>
      <!-- Grid BG Box  (S) -->
      <!--biz page (E)-->
    

<table width="100%"  id="mainTable" style="display:none"> 
  <tr>
    <td width="100%">
      <script language="javascript">ComSheetObject('sheet1');</script>
    </td>
  </tr>
</table> 

     <%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_CLOSE.jsp"%>
     
     
</form>      
</body>
</html>
