<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ees_ctm_0463.jsp
*@FileTitle : Modified event date history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.01
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2011.11.01 김종옥
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0463Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0463Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0463Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }

  // 현재날짜
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // 7일 이전날짜
  String pDate1 = DateTime.addDays(pDate2, -7, "yyyy-MM-dd");
  
  String cntrNo = (request.getParameter("cntrNo") == null)? "": request.getParameter("cntrNo");
  String chkDgt = (request.getParameter("chkDgt") == null)? "": request.getParameter("chkDgt");
  String tpSz = (request.getParameter("tpSz") == null)? "": request.getParameter("tpSz");
  String autoFlg = (request.getParameter("autoFlg") == null)? "": request.getParameter("autoFlg");
%>
<html>
<head>
<title>Empty VL List without BKG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="as_p_date1" value="<%=pDate1%>"> 
<input type="hidden" name="as_p_date2" value="<%=pDate2%>"> 
<input type="hidden" name="pe_co" value="P">
<!-- 개발자 작업 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


  <!-- biz page (S) -->
    <table class="search">
         <tr>
  <td class="bg" style="height:516" valign="top">
        <table class="search" border="0" style="width:979;">
        <tr class="h23">               
          <td width="70"><input type="radio" name="pe_co_tp" value="P" class="trans" checked>&nbsp;Period</td>
          <td width="270"><input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="8" value="<%=pDate1%>" style="ime-mode:disabled;" name="p_date1">&nbsp;~
                         <input type="text" style="width:75;" class="input1" dataformat="ymd" maxlength="8" value="<%=pDate2%>" style="ime-mode:disabled;" name="p_date2">
                         <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar">
          </td>
          <td width="57">Location</td>
          <td width="60"><script language="javascript">ComComboObject("location_gb", 2, 60, 0, 0, 0, 0, 3)</script></td>
          <td width="60" style="padding-top:1;">
            <input type="text" style="width:55;text-align:center;" class="input1" maxlength="5" style="ime-mode:disabled;" name="yd_cd_disp">
            <input type="hidden" name="p_yard1">
          </td>
          <td width="113"><script language="javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 3)</script></td>
          <td width="48">Status</td>
          <td width="155">
            <script language="javascript">ComComboObject('status_cd', 2, 60 ,0);</script>
          </td>
          <td width="38">S.O.C</td>     
          <td width="*">
            <script language="javascript">ComComboObject('soc_cd', 1, 70, 1);</script>
          </td>
        </tr>
        </table>
        <table class="search" border="0" style="width:979;">
        <tr class="h23">               
          <td width="110"><input type="radio" name="pe_co_tp" value="C" class="trans">&nbsp;Container No.</td>
          <td width="">
            <input type="text" style="width:80;ime-mode:disabled;" name="p_cntrno" class="input" maxlength='10' value="<%=cntrNo%>">&nbsp;<input type="text" style="width:20;" maxlength="1" name="check_digit" class="input" value="<%=chkDgt %>">&nbsp;<input type="text" style="width:26;" class="input" name="ctnr_tpsz_cd" value="<%=tpSz %>" readonly>&nbsp;
          </td>
        </tr>
        </table>
        
        <!-- biz_1   (E) -->

        <table class="line_bluedot">
        <tr>
          <td></td>
        </tr>
        </table>


        <!-- biz_2  (S) -->

        <!-- Grid  (S) -->
        <table width="100%"  id="mainTable">
          <tr>
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>
            </td>
          </tr>
        </table>
        <!-- Grid (E) -->
        <!-- biz_2   (E) -->
        </td>
</tr>
      </table>

  <!-- biz page (E) -->


  <!-- Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
      <tr>
        <td class="btn1_bg">
          <table border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
</td>

              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
</td>

              <td class="btn1_line"></td>

              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Excel">Down Excel</td>
                    <td class="btn1_right"></td>
                  </tr>
                </table>
</td>
            </tr>
          </table>
        </td>
      </tr>
    </table>
    <!-- Button (E) -->

    </td>
</tr>
    </table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>