<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0456.jsp
*@FileTitle : Pre-booked VL/VD Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.09 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0456Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0456Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_ofc = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();

    event = (EesCtm0456Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration 시작일(현재일)
  String pDate1 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration 종료일(현재일 +7)
  String pDate2 = DateTime.addDays(pDate1, 7, "yyyy-MM-dd");
%>
<html>
<head>
<title>Pre-booked VL/VD Correction</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="error_status">
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
          <td class="bg">
            <!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="75">Event Date</td>
                <td width="220"><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">&nbsp;~
                  <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2">
                  <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar"></td>
                <td width="40">Office</td>
                <td width="70"><input type="text" style="width:55;text-align:center;ime-mode:disabled;" class="input1" value="<%=strUsr_ofc%>" maxlength="6" tabindex="3" name="office"></td>
                <td width="45">Status</td>
                <td width="65"><select style="width:50;"class="input" tabindex="4" name="status">
                    <option value="VL" selected>VL</option>
                    <option value="VD">VD</option>
                  </select></td>
                <td width="30">Yard</td>
                <td width="60" style="padding-top:1;"><input type="text" style="width:55;ime-mode:disabled;" class="input" maxlength="5" tabindex="5" name="yd_cd_disp">
                  <input type="hidden" name="p_yard1"></td>
                  <td width="70"><script language="javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 6)</script></td>
                <td width="30">VVD</td>
                <td width="90"><input type="text" style="width:80;ime-mode:disabled;" class="input" maxlength="9" tabindex="7" name="vvd"></td>
                <td width="40">Type</td>
                <td width="75"><select style="width:65;"class="input" tabindex="8" name="fm">
                    <option value="" selected>All</option>
                    <option value="F">Full</option>
                    <option value="M">Empty</option>
                  </select></td>
                <td>Error&nbsp;<input name="error" type="checkbox" class="trans" value="Y" maxlength="9" tabindex="9"></td>

              </tr>
            </table>
            <!-- biz_1   (E) -->


            <table class="line_bluedot"><tr><td></td></tr></table>


            <!-- biz_2  (S) -->

            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->

            <!-- Grid_button (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_Delete">Row&nbsp;Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- Grid_button (E) -->

            <!-- biz_2   (E) -->
          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left">
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->

    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
