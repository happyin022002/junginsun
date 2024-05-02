<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0420.jsp
*@FileTitle : EDI Result Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.09.03 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0420Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0420Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.LongTxContainerMovementFinder");

  try {
       SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();


    event = (EesCtm0420Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration 종료일(현재일)
  String pDate2 = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // Duration 시작일(현재일 -7)
  String pDate1 = DateTime.addDays(pDate2, -7, "yyyy-MM-dd");
%>
<html>
<head>
<title>EDI Result Monitoring</title>
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
<input type="hidden" name="backendjob_key">
<input type="hidden" name="f_cmd">
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
                <td width="450" colspan="7">Receiving Date&nbsp;
                  <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">&nbsp;~
                  <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2">
                  <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar"></td>
                <td width="529"><table class="search_sm2" border="0" style="width:360;">
                    <tr class="h23">
                      <td width="55">&nbsp;GAP</td>
                      <td class="stm">
                        <input type="radio" name="gap_radio" value="" class="trans" checked>All&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gap_radio" value="12" class="trans">12 Hour&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gap_radio" value="24" class="trans">24 Hour&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="gap_radio" value="48" class="trans">48 Hour
                      </td>
                    </tr>
                  </table></td>
              </tr>

              <tr><td colspan="10" class="height_2"></td></tr>

              <tr class="h23">
                <td width="30">RCC</td>
                <td width="90"><script language="javascript">ComComboObject('rcc_cd', 1, 70, 1, 1, 2, 0, 3)</script></td>
                <td width="30">LCC</td>
                <td width="90"><script language="javascript">ComComboObject('lcc_cd', 1, 70 , 0, 0, 2, 0, 4)</script></td>
                <td width="35">Yard</td>
                <td width="57" style="padding-top:1;"><input type="text" style="width:55;text-align:center;ime-mode:disabled;" class="input" maxlength="5" tabindex="5" name="yd_cd_disp">
                  <input type="hidden" name="p_yard1"></td>
                <td width="100"><script language="javascript">ComComboObject("p_yard2", 2, 50, 0, 0, 0, 0, 10)</script></td>
                <td><table class="search_sm2" border="0" style="width:360;">
                    <tr class="h23">
                      <td width="55">&nbsp;Source</td>
                      <td class="stm">
                        <input type="radio" name="source_radio" value="ITN" class="trans" checked>International&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="source_radio" value="" class="trans" disabled>ALL&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="source_radio" value="DOM" class="trans" disabled>Domestic(USA)
                      </td>
                    </tr>
                  </table></td>
              </tr>
            </table>
            <!-- biz_1   (E) -->

            <table class="line_bluedot"><tr><td></td></tr></table>

            <!-- biz_2  (S) -->
            <!-- Grid  (S) -->
            <table width="100%" class="search"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
              <tr>
                <td><script language="javascript">ComSheetObject('sheet2');</script><!-- hidden --></td>
              </tr>
            </table>
            <!-- Grid (E) -->

            <table class="height_2"><tr><td colspan="8"></td></tr></table>

            <table class="grid2" border="0" style="width:979;">
              <tr class="h23">
                <td width="5%" class="tr2_head">SUMM</td>
                <td width="3.5%" class="tr2_head2">ERR</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="int_err"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="int_err_ratio"></td>
                <td width="3.5%" class="tr2_head2">OK</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="int_ok"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="int_ok_ratio"></td>
                <td width="3.5%" class="tr2_head2">12 H</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="edi_12h"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="edi_12h_ratio"></td>
                <td width="4%" class="tr2_head2">24 H</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="edi_24h"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="edi_24h_ratio"></td>
                <td width="3.5%" class="tr2_head2">48 H</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="edi_48h"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="edi_48h_ratio"></td>
                <td width="3.5%" class="tr2_head2">Over</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="edi_over"></td>
                <td width="4.5%" class="noinput2"><input type="text" style="width:100%;text-align:center;font-size:11px" class="noinput2" name="edi_over_ratio"></td>
                <td width="3.5%" class="tr2_head2">TTL</td>
                <td width="6%" class="noinput2"><input type="text" style="width:100%;text-align:right;font-size:11px" class="noinput2" name="edi_ttl"></td>
              </tr>
            </table>

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
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_Retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                      <td class="btn1" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downExcel">Down Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table></td>
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