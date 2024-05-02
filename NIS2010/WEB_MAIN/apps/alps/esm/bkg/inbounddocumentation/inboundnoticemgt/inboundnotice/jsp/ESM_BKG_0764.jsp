<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : esm_bkg_0764.jsp
 *@FileTitle : Customer Data Management Update History
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.10
 *@LastModifier : 박만건
 *@LastVersion : 1.0
 * 2009.07.10 박만건
 * 1.0 Creation
 * 2009.11.05 박만건 수정 - 폼에 javascript 제거
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0764Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0764Event  event = null;          //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;      //서버에서 발생한 에러
    String strErrMsg = "";            //에러메세지
    int rowCount   = 0;            //DB ResultSet 리스트의 건수
    
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    
    String strUsr_id    = "";
    String strUsr_nm    = "";
    Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgt.ArrivalNotice");
    
    /* user define variable */
    String strOfc_cd = "";
    
    String custCntCd = "";
    String custSeq = "";
    String custNm = "";
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id =  account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
         
        strOfc_cd = account.getOfc_cd();
               
        
        event = (EsmBkg0764Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
      
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        
        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
      
        custCntCd = JSPUtil.getParameter(request, "cust_cnt_cd");
        custSeq = JSPUtil.getParameter(request, "cust_seq");
        String ofcCd = JSPUtil.getParameter(request, "ofc_cd");
        custNm = JSPUtil.getParameter(request, "cust_nm");
        if (!ofcCd.equals("")) {
            strOfc_cd = ofcCd;
        }
        
        // Param으로 고객의 국가코드가 오지 않을 경우 로그인 사용자의 국가코드를 사용한다.
        if (custCntCd == null || custCntCd.trim().equals("") ) {
        	custCntCd = account.getCnt_cd();
        }

    }catch(Exception e) {
      out.println(e.toString());
    }
%>
<html>
<head>
<title>Customer Data Management Update History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    var podCdArr = new Array();
    var strOfc_cd = "<%=strOfc_cd%>";
    var parCustCntCd = "<%=custCntCd %>";
    var parCustSeq = "<%=custSeq %>";
    
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            showErrMessage(errMessage);
        } // end if
        
        
        var formObject = document.form;
        formObject.ofc_cd.value =strOfc_cd;
        loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input name="f_cmd" type="hidden" />
<input name="pagerows" type="hidden" />
<!-- 개발자 작업  -->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
  
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle" />&nbsp;Customer Data Management Update History</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
    
      <!-- : ( Search Options ) (S) -->
       
      <table class="search"> 
        <tr>
          <td class="bg">
      
            <!--  biz_1 (S) -->
            <table class="search" border="0" style="width:100%;"> 
              <tr class="h23">
                <td width="70">Customer</td>
                <td width="350">
                  <input type="text" name="cust_cnt_cd" id="cust_cnt_cd" caption="Customer" minlength="2" maxlength="2" 
                         required="true" fullfill="true" style="ime-mode:disabled" style="width:30;" class="input1" tabindex="1" />
                  <input type="text" name="cust_seq" id="cust_seq" required="true" caption="Customer" maxlength="6" 
                         style="ime-mode:disabled" style="width:55;" class="input1" tabindex="2" />
                  <input type="text" name="cust_nm" readonly="true" style="width:206;" class="input2" tabindex="false" tabindex="-1" value="<%=custNm %>" />
                </td>
                <td width="85">Update Date</td>
                <td width="250">
                  <input type="text" name="cng_dt_s" caption="Update Date Start" dataformat="ymd" maxlength="10" 
                         required="true" style="width:75;" cofield="cng_dt_e" style="ime-mode:disabled" class="input1" tabindex="3" />&nbsp;~
                  <input type="text" name="cng_dt_e" caption="Update Date End" dataformat="ymd" maxlength="10"
                         required="true" style="width:75;" value="" cofield="cng_dt_s" style="ime-mode:disabled" class="input1" tabindex="4" />
                  <img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" 
                         class="cursor" name="btn_cng_dt" />
                </td>
                <td width="40">Office</td>
                <td width=""><input type="text" name="ofc_cd" readonly="true" style="width:50;" value="" class="input2" tabindex="-1" /></td>
              </tr>
            </table>
            <table class="search" border="0" style="width:100%;"> 
              <tr class="h23">
                <td width="70">Concerned</td>
                <td width="150">
                  <select name="cust_cntc_tp_cd" caption="Concerned" style="width:90;" class="input1" tabindex="5">
                    <option value="" selected="true" >All</option>
                    <option value="C1">CNEE</option>
                    <option value="C2">CNEE #2</option>
                    <option value="B1">BRK #1</option>
                    <option value="B2">BRK #2</option>
                    <option value="A1">A.NTFY </option>
                  </select>
                </td>
                <td width="80">Update Type</td>
                <td width="120">
                  <select name="auto_mnl_flg" caption="Update Type" style="width:70;" class="input1" tabindex="6">
                    <option value="" selected="true">All</option>
                    <option value="Y">Auto</option>
                    <option value="N">Manual</option>
                  </select>
                </td>
                <!-- td width="55">B/L No.</td>  -- 삭제됨
                <td width="145"><input type="text" name="bl_no"caption="B/L No." minlength="12" maxlength="12" fullfill style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="width:99;" value="" class="input" tabindex="7"></td-->
                <td width="85">Do not Send</td>
                <td width="">
                  <select name="snd_sel_flg" caption="Do Not Send" style="width:76;" class="input1" tabindex="8">
                    <option value="" selected="true">All</option>
                    <option value="Y">Select</option>
                    <option value="N">Deselect</option>
                  </select>
                </td>
              </tr>
            </table>
            <!--  biz_1   (E) -->  
              
            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!-- : ( Grid ) (S) -->
            <table width="979"  id="mainTable"> 
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Button_Sub (E) -->
      
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
      <table class="height_5">
  <tr><td></td></tr>
</table>
      
    </td>
  </tr>
</table> 


  
  
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close">Close</td>
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
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->
<table>
  <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>