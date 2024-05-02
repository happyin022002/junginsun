<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0418.jsp
*@FileTitle : MVMT Timely Update Ratio
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.27 우경민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.08.18 나상보 [CHM-201005413-01] MVNT timely update ratio 기능보완
*                   : [EES_CTM_0418] 1. LCC 선택시 Yard 단위로 Download 가능 하도록 처리
*						             2. 검색 조건 추가 (mvmt status 멀티 선택 가능)
* 2010.09.09 김상수 [CHM-201006478-01] Full/Mty Option기능 추가 (Movement 적시 update 비율 및 row data를 조회하는 화면)
*                   1.Movement 적시 update 비율 및 row data를 조회하는 화면에 Full/Mty Option기능 추가
*                     ->Service Management > CNTR Movement > Monitoring > MVMT Timely Update Ratio
*                   2. Default 값은 All 로 하고, 필요시 Full 혹은 Mty별 조회 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.backend.support.BackEndJobResult"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0418Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EesCtm0418Event event = null;    //PDTO(Data Transfer Object including Parameters)
    Exception serverException  = null;    //서버에서 발생한 에러
    String strErrMsg = "";    //에러메세지
    int rowCount  = 0;    //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList = "";
    String pageRows = "100";

    String strUsr_id  = "";
    String strUsr_nm  = "";

    try {
        SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EesCtm0418Event)request.getAttribute("Event");
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
    String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // 1개월 이전날짜
    String strStartdate = DateTime.addDays(strEnddate, -7, "yyyy-MM-dd");
    // ediMvmtStsCd
    String ediMvmtStsCd = (request.getParameter("ediMvmtStsCd") == null)? "": "'" + request.getParameter("ediMvmtStsCd") + "'";
%>
<html>
<head>
<title>MVMT Timely Update Ratio</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="edi_type">
<input type="hidden" name="time_off">
<input type="hidden" name="p_yard">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업  -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


  <!--biz page (S)-->
    <table class="search">
         <tr><td class="bg">
        <!--  biz_1 (S) -->
        <table class="search" border="0" style="width:979;">
          <tr>
            <td><table class="search" border="0" style="width:460;">
                <tr class="h23">
                  <td>Event Date&nbsp;</td>
                  <td><input type="text" style="width:70;ime-mode:disabled;" class="input1" value="<%=strStartdate%>" tabindex="1" name="p_date1">&nbsp;~
                    <input type="text" style="width:70;ime-mode:disabled;" class="input1" value="<%=strEnddate%>" tabindex="2" name="p_date2">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar">&nbsp;&nbsp;&nbsp;</td>
                  <td align="right">Status&nbsp;</td>
                  <td>&nbsp;<script language="javascript">ComComboObject("statusCombo", 1, 50, 1, 0, 0, 0, 3);</script><input type="hidden" name="sts_cd">&nbsp;&nbsp;&nbsp;</td>
                  <td align="right">F/M&nbsp;</td>
                  <td><select style="width:50;" tabindex="4" name="fcntr_flg">
                    <option value="" selected>ALL</option>
                    <option value="Y">F</option>
                    <option value="N">M</option>
                  </select></td>
                </tr>
              </table></td>
            <td><table class="search_sm2" border="0" width="310">
                <tr class="h23">
                  <td width="52">&nbsp;GAP</td>
                  <td class="stm"><input type="radio" value="0" name="gap" class="trans" checked>ALL
                    <input type="radio" value="12" name="gap" class="trans">12 Hour
                    <input type="radio" value="24" name="gap" class="trans">24 Hour
                    <input type="radio" value="48" name="gap" class="trans">48 Hour</td>
                </tr>
              </table></td>
            <td rowspan="3"><table class="search_sm2" border="0" style="height:66">
                <tr class="h23">
                  <td><input type="radio" value="I" class="trans" name="dom_flg" checked>International</td>
                </tr>
                <tr class="h23">
                  <td><input type="radio" name="dom_flg" class="trans">ALL
                  <input type="radio" value="D" name="dom_flg" class="trans">Domestic(USA)</td>
                </tr>
              </table></td>
          </tr>
          <tr><td colspan="3" class="height_2"></td></tr>
          <tr>
            <td><table class="search" border="0" style="width:371;">
                <tr class="h23">
                  <td align="right">RCC&nbsp;</td>
                  <td>&nbsp;<script language="javascript">ComComboObject('rcc_cd', 1, 70, 1, 1, 2, 0, 5)</script>&nbsp;</td>
                  <td align="right">LCC&nbsp;</td>
                  <td>&nbsp;<script language="javascript">ComComboObject('lcc_cd', 1, 70, 0, 0, 2, 0, 6)</script>&nbsp;</td>
                  <td align="right">Yard&nbsp;</td>
                  <td width="35" style="padding-top:1;"><input type="text" maxlength="5" style="width:55;" class="input" tabindex="5" name="p_yard1"></td>
                  <td>&nbsp;<script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 7)</script></td>
                <tr>
              </table></td>
            <td><table class="search_sm2" border="0" width="310">
                <tr class="h23">
                  <td width="52">&nbsp;Data By</td>
                  <td class="stm"><input type="radio" value="1" name="data_by" class="trans">RCC
                    <input type="radio" value="5" name="data_by" class="trans">CN
                    <input type="radio" value="2" name="data_by" class="trans">LCC
                    <input type="radio" value="3" name="data_by" class="trans">Location
                    <input type="radio" value="4" name="data_by" class="trans" checked>Yard</td>
                </tr>
              </table></td>
          </tr>
        </table>
        <!--  biz_1   (E) -->

        <table class="line_bluedot"><tr><td></td></tr></table>

        <!--  biz_2  (S) -->

        <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
        <!-- Grid (E) -->
        <!-- Grid  (S) -->
            <div style="display:none">
            <script language="javascript">ComSheetObject('sheet2');</script>
            </div>
        <!-- Grid (E) -->

            <table class="height_2"><tr><td colspan="8"></td></tr></table>
            <table class="grid2" border="0" style="width:979;">
              <tr class="h23">
                <td width="65" class="tr2_head">Summary</td>
                <td width="45" class="tr2_head2">12 Hour</td>
                <td width="82" class="noinput2"><input type="text" style="width:80;text-align:right" class="noinput2" readonly="true" name="c12"></td>
                <td width="57" class="noinput2"><input type="text" style="width:55;text-align:center" class="noinput2" name="p12"></td>
                <td width="45" class="tr2_head2">24 Hour</td>
                <td width="82" class="noinput2"><input type="text" style="width:80;text-align:right" class="noinput2" name="c24"></td>
                <td width="57" class="noinput2"><input type="text" style="width:55;text-align:center" class="noinput2" name="p24"></td>
                <td width="45" class="tr2_head2">48 Hour</td>
                <td width="82" class="noinput2"><input type="text" style="width:80;text-align:right" class="noinput2" name="c48"></td>
                <td width="57" class="noinput2"><input type="text" style="width:55;text-align:center" class="noinput2" name="p48"></td>
                <td width="45" class="tr2_head2">Over</td>
                <td width="82" class="noinput2"><input type="text" style="width:80;text-align:right" class="noinput2" name="c72"></td>
                <td width="57" class="noinput2"><input type="text" style="width:55;text-align:center" class="noinput2" name="p72"></td>
                <td width="45" class="tr2_head2">Total</td>
                <td class="noinput2"><input type="text" style="width:80;text-align:right" class="noinput2" name="c_a"></td>
              </tr>
            </table>

        <!--  biz_2   (E) -->
        </td></tr>
      </table>
</td></tr></table>
  <!--biz page (E)-->


  <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
         <tr><td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
        <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn1_left">
          <td class="btn1" name="btn_Retrieve">Retrieve</td>
          <td class="btn1_right">
          </tr>
        </table></td>
        <td class="btn1_line"></td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn1_left"></td>
          <td class="btn1" name="btn_New">New</td>
          <td class="btn1_right"></td>
          </tr>
        </table></td>
      </tr>
      </table>
    </td></tr>
    </table>
    <!--Button (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>