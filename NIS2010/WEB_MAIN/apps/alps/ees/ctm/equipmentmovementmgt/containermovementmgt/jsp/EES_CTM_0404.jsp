<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0404.jsp
*@FileTitle : Update of EDI Message (All MSG)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.08 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0404Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0404Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";    //에러메세지
  int rowCount = 0;    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0404Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // bkgBl
  String bkgBl = JSPUtil.getParameter(request, "bkgBl");
  // pCntrno
  String pCntrno = JSPUtil.getParameter(request, "pCntrno");
  // checkDigit
  String checkDigit = JSPUtil.getParameter(request, "checkDigit");
  // pYard1
  String pYard1 = JSPUtil.getParameter(request, "pYard1");
  // tmlNm
  String tmlNm = JSPUtil.getParameter(request, "tmlNm");
  // lccCd
  String lccCd = JSPUtil.getParameter(request, "lccCd");
  // rccCd
  String rccCd = JSPUtil.getParameter(request, "rccCd");
  // vvdCombo
  String vvdCombo = "".equals(JSPUtil.getParameter(request, "vvdCombo")) ? "VVD_CD" : JSPUtil.getParameter(request, "vvdCombo");
  // vvdValue
  String vvdValue = JSPUtil.getParameter(request, "vvdValue");
  // cntrTpszCd
  String cntrTpszCd = JSPUtil.getParameter(request, "cntrTpszCd");
  // cntrFullStsCd
  String cntrFullStsCd = JSPUtil.getParameter(request, "cntrFullStsCd");
  // mvmtEdiMsgAreaCd
  String mvmtEdiMsgAreaCd = JSPUtil.getParameter(request, "mvmtEdiMsgAreaCd");
  // mvmtEdiMsgTpId
  String mvmtEdiMsgTpId = "".equals(JSPUtil.getParameter(request, "mvmtEdiMsgTpId")) ? "ALL" : JSPUtil.getParameter(request, "mvmtEdiMsgTpId");
  // mvmtEdiRsltCd
  String mvmtEdiRsltCd = "".equals(JSPUtil.getParameter(request, "mvmtEdiRsltCd")) ? "N" : JSPUtil.getParameter(request, "mvmtEdiRsltCd");
  // ediMvmtStsCd
  String ediMvmtStsCd = "".equals(JSPUtil.getParameter(request, "ediMvmtStsCd")) ? "" : "'" + JSPUtil.getParameter(request, "ediMvmtStsCd") + "'";
  // rtyKnt
  String rtyKnt = JSPUtil.getParameter(request, "rtyKnt");
  // ediGateIoCd
  String ediGateIoCd = "".equals(JSPUtil.getParameter(request, "ediGateIoCd")) ? "" : "'" + JSPUtil.getParameter(request, "ediGateIoCd") + "'";

  // ediGateIoCd
//  String ediGateIoCd = (request.getParameter("ediGateIoCd") == null)? "": "'" + request.getParameter("ediGateIoCd") + "'";

  // Duration 종료일 (request가 없다면 오늘날짜)
  String pDate2 = "".equals(JSPUtil.getParameter(request, "pDate2")) ? JSPUtil.getKST("yyyy-MM-dd") : JSPUtil.getParameter(request, "pDate2");
  // Duration 시작일 (request가 없다면 하루 전)
  String pDate1 = "".equals(JSPUtil.getParameter(request, "pDate1")) ? DateTime.addDays(pDate2, -1, "yyyy-MM-dd") : JSPUtil.getParameter(request, "pDate1");

  // Request로 Parameter 받는지 여부
  String requestYN = "";
  if (!"".equals(JSPUtil.getParameter(request, "pDate1")) && !"".equals(JSPUtil.getParameter(request, "pDate2"))) requestYN = "Y";

  // pop_mode
  String popMode = "".equals(JSPUtil.getParameter(request, "pop_mode")) ? "N": "Y";
%>
<html>
<head>
<title>Update of EDI Message - All MSG</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
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
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Update of EDI Message - All MSG</td></tr>
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
<input type="hidden" name="user_svr_id">
<input type="hidden" value="<%=requestYN%>" name="requestYN">
<input type="hidden" name="cntr_no">
<input type="hidden" name="err_msg">

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <!-- biz_1  (S) -->
            <table class="search" border="0" style="width:979;">

              <tr class="h23">
                <td width="150" rowspan="4">
                  <table class="grid2" border="0" style="width:140;">
                    <tr class="tr2_head">
                      <td colspan="2"><input type="radio" name="event_receive" value="EVENT" class="trans" checked disabletype="no">Event
                        <input type="radio" name="event_receive" value="RECEIVE" class="trans" disabletype="no">Receiving</td>
                    </tr>
                    <tr>
                      <td class="tr2_head2" width="40">From</td>
                      <td><input type="text" style="width:75;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1" disabletype="no"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head2">To</td>
                      <td><input type="text" style="width:75;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2" disabletype="no">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar" disabletype="no">
                        <input type="hidden" name="p_date3"></td>
                    </tr>
                  </table>
                </td>
              </tr>

              <tr class="h23">
                <td width="92">BKG or B/L No.</td>
                <td width="145"><input type="text" style="width:107;ime-mode:disabled;" class="input" maxlength="13" tabindex="3" value="<%=bkgBl%>" name="bkg_bl" disabletype="no"></td>
                <td width="75">Terminal</td>
                <td width="135"><input type="text" style="width:125;ime-mode:disabled;" class="input" maxlength="20" tabindex="7" value="<%=tmlNm%>" name="tml_nm" disabletype="no"></td>
                <td width="45" align="right">TP/SZ&nbsp;</td>
                <td width="55" style="padding-left:2"><script language="javascript">ComComboObject("tpszCombo", 1, 50, 1, 0, 0, 0, 11);</script>
                  <input type="hidden" value="<%=cntrTpszCd%>" name="cntr_tpsz_cd"></td>
                <td width="50">Area</td>
                <td width="105"><select style="width:70;" tabindex="14" name="mvmt_edi_msg_area_cd" disabletype="no">
                    <!-- 항목 추가시 javascript도 수정 - [case SEARCH16:]으로 검색 -->
                    <option value="KOR">KR / JP</option>
                    <option value="CHN">CHN</option>
                    <option value="SWA">SWA</option>
                    <option value="EUR">EUR</option>
                    <option value="USA">USA</option>
                    <option value="">ALL</option>
                   </select><input type="hidden" value="<%=mvmtEdiMsgAreaCd%>" name="mvmtEdiMsgAreaCd"></td>
                <td width="70">Status</td>
                <td style="padding-left:2;"><script language="javascript">ComComboObject("statusCombo", 1, 70, 1, 0, 0, 0, 17);</script>
                  <input type="hidden" value="<%=ediMvmtStsCd%>" name="edi_mvmt_sts_cd"></td>
              </tr>

              <tr class="h23">
                <td>Container No.</td>
                <td><input type="text" style="width:83; ime-mode:disabled;" class="input" maxlength="10" tabindex="4" value="<%=pCntrno%>" name="cntrno_disp" disabletype="no"><input type="hidden" value="<%=pCntrno%>" name="p_cntrno">
                  <input type="text" style="width:20;" class="input" readonly="true" value="<%=checkDigit%>" name="check_digit" disabletype="no">
                  <img src="img/btns_multisearch.gif" name="btns_multisearch" width="19"height="20"alt=""border="0"align="absmiddle"class="cursor" onClick="doProcessPopup('m_cntr_no')">
                  </td>
                <td>LCC</td>
                <td><input type="text" style="width:50; ime-mode:disabled;" class="input" maxlength="5" tabindex="8" value="<%=lccCd%>" name="lcc_cd" disabletype="no"></td>
                <td align="right">RCC&nbsp;</td>
                <td><input type="text" style="width:50; ime-mode:disabled;" class="input" maxlength="5" tabindex="12" value="<%=rccCd%>" name="rcc_cd" disabletype="no"></td>
                <td>MSG ID</td>
                <td style="padding-left:2"><script language="javascript">ComComboObject("mvmt_edi_msg_tp_id", 1, 70, 1, 0, 0, 0, 15);</script><input type="hidden" value="<%=mvmtEdiMsgTpId%>" name="mvmtEdiMsgTpId"></td>
                <td>Retry</td>
                <td><select style="width:70;" tabindex="18" name="rty_knt" disabletype="no">
                    <option value="" selected>ALL</option>
                    <option value="0">0</option>
                    <option value="1">More</option>
                  </select><input type="hidden" value="<%=rtyKnt%>" name="rtyKnt"></td>
              </tr>

              <tr class="h23">
                <td>Origin Yard</td>
                <td><input type="text" style="width:63; ime-mode:disabled;" class="input" maxlength="5" tabindex="5" value="<%=pYard1%>" name="yd_cd_disp" disabletype="no">
                  <input type="hidden" value="<%=pYard1%>" name="p_yard1">
                  <script language="javascript">ComComboObject("p_yard2", 2, 40, 0, 0, 0, 0, 6);</script></td>
                <!-- VVD -->
                <td><select style="width:95%; font-weight:bold; color:#000000;" tabindex="9" name="vvd_combo" disabletype="no">
                    <option value="VVD_CD">VVD</option>
                    <option value="CALL_SGN_NO">Call Sign</option>
                    <option value="LLOYD_NO">Lloyd</option>
                  </select><input type="hidden" value="<%=vvdCombo%>" name="vvdCombo"></td>
                <td><input type="text" style="width:125; ime-mode:disabled;" class="input" maxlength="20" tabindex="10" value="<%=vvdValue%>" name="vvd_value" disabletype="no"></td>
                <td align="right">F/M&nbsp;</td>
                <td><select style="width:50;" tabindex="13" name="cntr_full_sts_cd" disabletype="no">
                    <option value="" selected>ALL</option>
                    <option value="F">F</option>
                    <option value="M">M</option>
                  </select><input type="hidden" value="<%=cntrFullStsCd%>" name="cntrFullStsCd"></td>
                <td>Result</td>
                <td><select style="width:70;" tabindex="16" name="mvmt_edi_rslt_cd" disabletype="no">
                    <option value="ALL">ALL</option>
                    <option value="N" selected>Error</option>
                    <option value="Y">OK</option>
                    <option value="X">Ignored</option>
                  </select><input type="hidden" value="<%=mvmtEdiRsltCd%>" name="mvmtEdiRsltCd">
                  <img src="img/btns_multisearch.gif" name="btn_result" width="19"height="20"alt=""border="0"align="absmiddle" ></td>
                <td>I/O Status</td>
                <td style="padding-left:2"><script language="javascript">ComComboObject("ioStatusCombo", 2, 70, 1, 0, 0, 0, 19);</script>
                  <input type="hidden" value="<%=ediGateIoCd%>" name="edi_gate_io_cd"></td>
              </tr>
            </table>
            <!-- biz_1 (E) -->

          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr><td class="bg">
          <table class="search" border="0" style="width:979;">

            <!-- Grid (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->

            <!-- Grid_button (S) -->
            <table width="100%" class="button">
              <tr>
                <td>
                  <!-- biz_3  (S) -->
                  <table class="search">
                  <tr class="h23">
                    <td width="31">Total</td>
                    <td width="70"><input type="text" style="width:60;text-align:right;" class="input2" readonly="true" name="disp_total"></td>
                    <td width="45">R/Total</td>
                    <td width="70"><input type="text" style="width:60;text-align:right;" class="input2" readonly="true" name="rtv_total"></td>
                    <td width="45">G/Total</td>
                    <td width="75"><input type="text" style="width:60;text-align:right;font-weight:bold;" class="input2" readonly="true" name="gnd_total"></td>
                    <td width="150">
                      <select style="width:60; font-weight:bold; color:#000000;" tabindex="19" name="vvdsts_change_combo">
                        <option value="VVD" selected>VVD</option>
                        <option value="STATUS">Status</option>
                      </select>
                      <input type="text" style="width:80; ime-mode:disabled; display:inline;" class="input" maxlength="9" tabindex="20" name="vvdcd_change">
                      <select style="width:80; display:none;" tabindex="20" name="stscd_change">
                        <option value="OP" selected>OP</option>
                        <option value="EN">EN</option>
                        <option value="TN">TN</option>
                        <option value="OC">OC</option>
                        <option value="VL">VL</option>
                        <option value="VD">VD</option>
                        <option value="IC">IC</option>
                        <option value="ID">ID</option>
                        <option value="MT">MT</option>
                        <option value="CP">CP</option>
                        <option value="CT">CT</option>
                        <option value="CE">CE</option>
                        <option value="CO">CO</option>
                        <option value="CI">CI</option>
                        <option value="CD">CD</option>
                        <option value="CM">CM</option>
                      </select></td>
                    <td>
                      <table width="130" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_vvdchange">VVD/Sts&nbsp;Change</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table></td>
                    </tr>
                  </table>
                  <!-- biz_3   (E) -->
                </td>
                <td class="btn1_bg">
                  <table  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_more">More</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_detail">Detail&nbsp;Info.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_downexcel">Down&nbsp;Excel</td>
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
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save">Save</td>
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
