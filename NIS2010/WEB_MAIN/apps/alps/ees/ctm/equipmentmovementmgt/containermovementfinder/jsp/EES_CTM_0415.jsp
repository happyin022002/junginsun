<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0415.jsp
*@FileTitle : Deleted CNTR MVMT History
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.11 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0415Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0415Event event = null;        //PDTO(Data Transfer Object including Parameters)
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

    event = (EesCtm0415Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Container No.
  String pCntrno = (request.getParameter("p_cntrno") == null)? "": request.getParameter("p_cntrno");
  // checkDigit
  String checkDigit = (request.getParameter("check_digit") == null)? "": request.getParameter("check_digit");
  // ctnrTpszCd
  String ctnrTpszCd = (request.getParameter("ctnr_tpsz_cd") == null)? "": request.getParameter("ctnr_tpsz_cd");
  // Duration 종료일 (request가 없다면 오늘날짜)
  String pDate2 = (request.getParameter("p_date2") == null)? DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"): request.getParameter("p_date2");
  // Duration 시작일 (request가 없다면 6개월 이전날짜)
  String pDate1 = (request.getParameter("p_date1") == null)? DateTime.addMonths(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), -6, "yyyy-MM-dd"): request.getParameter("p_date1");

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>

<html>
<head>
<title>Deleted CNTR MVMT History</title>
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
<!-- 개발자 작업 -->


<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Deleted CNTR MVMT history Inquiry</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" style="height:516" valign="top">

            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="90">Container No.</td>
                <td width="180"><input type="text" style="width:80;" class="input1" value="<%=pCntrno%>" maxlength="10" style="ime-mode:disabled;" tabindex="1" name="p_cntrno">
                                <input type="text" style="width:18;" class="input" value="<%=checkDigit%>" readonly="true" name="check_digit">
                                <input type="text" style="width:28;" class="input" value="<%=ctnrTpszCd%>" readonly="true" name="ctnr_tpsz_cd"></td>
                <td width="50">Duration</td>
                <td><input type="text" style="width:75;" class="input1" value="<%=pDate1%>" style="ime-mode:disabled;" tabindex="2" name="p_date1">&nbsp;~
                    <input type="text" style="width:75;" class="input1" value="<%=pDate2%>" style="ime-mode:disabled;" tabindex="3" name="p_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar"></td>
              </tr>
            </table>
            <!-- biz_1 (E) -->

            <table class="line_bluedot"><tr><td></td></tr></table>

            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->

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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
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

<% if (popMode.equals("Y")) { %>

      <table class="height_5"><tr><td></td></tr></table>
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


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
