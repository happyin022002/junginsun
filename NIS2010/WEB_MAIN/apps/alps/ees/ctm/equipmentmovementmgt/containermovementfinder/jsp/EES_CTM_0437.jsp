<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0437.jsp
*@FileTitle : Correction History Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : 두기민
*@LastVersion : 1.0
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0437Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0437Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount   = 0;                  //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0437Event)request.getAttribute("Event");
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

  // Duration 종료일 (Hidden - 오늘날짜)
  String tempDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration 시작일 (Hidden - 6개월 이전날짜)
  String tempDate1 = DateTime.addMonths(tempDate2, -6, "yyyy-MM-dd");

  // Duration 종료일 (request가 없다면 tempDate2)
  String pDate2 = (request.getParameter("p_date2") == null)? tempDate2: request.getParameter("p_date2");
  // Duration 시작일 (request가 없다면 tempDate1)
  String pDate1 = (request.getParameter("p_date1") == null)? tempDate1: request.getParameter("p_date1");

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>Correction History Inquiry</title>
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
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Correction History Inquiry</td></tr>
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
<input type="hidden" name="temp_date1" value="<%=tempDate1%>">
<input type="hidden" name="temp_date2" value="<%=tempDate2%>">
<input type="hidden" name="cntr_no">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- biz_1 (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="90">Container No.</td>
                <td width="260"><input type="text" style="width:85; ime-mode:disabled;" class="input1" maxlength="10" value="<%=pCntrno%>" tabindex="1" name="cntrno_disp">
                                <input type="hidden" value="<%=pCntrno%>" name="p_cntrno">
                                <input type="text" style="width:20;" class="input" value="<%=checkDigit%>" maxlength="1" name="check_digit">
                                <input type="text" style="width:25;" class="input" readonly="true" value="<%=ctnrTpszCd%>" name="ctnr_tpsz_cd">
                                <input type="text" style="width:0;ime-mode:disabled;" maxlength="1" tabindex="2" name="temp_0">
                                <img src="img/btns_multisearch.gif" name="btns_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')">
                                </td>
                <td width="60">Duration</td>
                <td><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="3" name="p_date1">&nbsp;~
                    <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="4" name="p_date2">
                    <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar"></td>
              </tr>
            </table>
            <!-- biz_1 (E) -->

          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg"  style="height:467" valign="top">

            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%"  border="0" id="mainTable">
              <tr>
              <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>
              </td>
              </tr>
            </table>
            <!-- Grid (E) -->
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
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
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
<iframe name="hiddenFrame" style="visibility:hiddden" height="0" width="0" id="hiddenFrame"></iframe>
</body>
</html>