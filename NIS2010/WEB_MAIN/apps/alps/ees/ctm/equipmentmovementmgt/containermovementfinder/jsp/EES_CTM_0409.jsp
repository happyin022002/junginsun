<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0409.jsp
*@FileTitle : Each Booking
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.05.25 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0409Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0409Event  event = null;       //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_ofc = "";
  String strCnt_cd = "";;
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_ofc = account.getOfc_cd();
    event = (EesCtm0409Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // bkgNo
  String bkgNo = (request.getParameter("bkg_no") == null)? "": request.getParameter("bkg_no");
  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>Each Booking</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%//=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
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
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Each Booking Inquiry</td></tr>
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
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle" value="Movement History by Booking No">
<input type="hidden" name="com_mrdBodyTitle" value="Each Booking Inquiry">
<input type="hidden" name="com_mrdPath" value="apps/alps/ees/ctm/equipmentmovementmgt/containermovementfinder/report/EES_CTM_0409.mrd">
<input type="hidden" name="usrId" value="<%=strUsr_id%>">
<input type="hidden" name="usrOfc" value="<%=strUsr_ofc%>">
<input type="hidden" name="cnt_cd">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" style="height:516" valign="top">

            <!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="85">Booking No.</td>
                <td width="200"><input type="text" style="width:105;ime-mode:disabled;" class="input" maxlength="13" value="<%=bkgNo%>" tabindex="1" name="bkg_no">
                  <input type="text" style="width:18;" class="input2" readonly="true" name="bkg_sts_cd"></td>
                <td width="65">B/L No.</td>
                <td><input type="text" style="width:100;" class="input" maxlength="12" tabindex="3" name="bl_no"></td>
              </tr>
            </table>
            <!-- biz_1   (E) -->

            <table class="height_10"><tr><td colspan="8"></td></tr></table>

            <!-- biz_2  (S) -->
            <table class="search" border="0">
              <tr>
              <td class="title_h"></td>
              <td class="title_s">Booking Information</td></tr>
            </table>
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="79">Pre VVD</td>
                <td width="160">&nbsp;<script language="javascript">ComComboObject('pre_vvd', 2, 92, 1, 3)</script>&nbsp;<input type="text" style="width:47;" class="input2" readonly="true" name="pre_pol_cd"></td>
                <td width="26">POR</td>
                <td width="80"><input type="text" style="width:52;" class="input2" readonly="true" name="por_cd"></td>
                <td width="30">POL</td>
                <td width="75"><input type="text" style="width:52;" class="input2" readonly="true" name="bkg_pol_cd"></td>
                <td width="32">SHPR</td>
                <td width="230"><input type="text" style="width:202;" class="input2" readonly="true" name="shpr"></td>
                <td width="75">Split Info.</td>
                <td><input type="text" style="width:20;" class="input2" readonly="true" name="split_cd">
                  <input type="text" style="width:25;" class="input2" readonly="true" name="split_count">
                  <input type="text" style="width:137;" class="input2" readonly="true" name="split_bkg_no">&nbsp;
                  <script language="javascript">ComComboObject('split_info', 3, 52, 1, 3, 1)</script></td>
              </tr>
              <tr class="h23">
                <td>T/VVD</td>
                <td style="padding-left:2"><input type="text" style="width:92;" class="input2" readonly="true" name="t_vvd">&nbsp;<input type="text" style="width:47;" class="input2" readonly="true" name="t_pol_cd"></td>
                <td>POD</td>
                <td><input type="text" style="width:52;" class="input2" readonly="true" name="pod_cd"></td>
                <td>DEL</td>
                <td><input type="text" style="width:52;" class="input2" readonly="true" name="del_cd"></td>
                <td>CNEE</td>
                <td><input type="text" style="width:202;" class="input2" readonly="true" name="cnee"></td>
                <td>Volume</td>
                <td style="padding-left:2"><script language="javascript">ComComboObject("cntr_tpsz_cd", 1, 100, 1, 3)</script></td>
              </tr>
              <tr class="h23">
                <td>Post VVD</td>
                <td>&nbsp;<script language="javascript">ComComboObject("post_vvd", 2, 92, 1, 3)</script>&nbsp;<input type="text" style="width:47;" class="input2" readonly="true" name="post_pol_cd"></td>
                <td>Term</td>
                <td><input type="text" style="width:18;" class="input2" readonly="true" name="rcv_term_cd">&nbsp;/
                  <input type="text" style="width:18;" class="input2" readonly="true" name="de_term_cd"></td>
                <td colspan="2">CGO Type
                  <input type="text" style="width:20;" class="input2" readonly="true" name="bkg_cgo_tp_cd"></td>
                <td>NTFY</td>
                <td><input type="text" style="width:202;" class="input2" readonly="true" name="ntfy"></td>
                <td>CMDT</td>
                <td><input type="text" style="width:246;" class="input2" readonly="true" name="rep_cmdt_nm"></td>
              </tr>
            </table>
            <!-- biz_2   (E) -->

            <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

            <!-- biz_3  (S) -->
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Container Information</td>
              </tr>
            </table>

            <!-- Grid  (S) -->
            <table width="979"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_3  (E) -->

          </td>
        </tr>
      </table>
      <!-- biz page (E) -->

      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_eachcntr">Each CNTR</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_report">Print</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
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


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>