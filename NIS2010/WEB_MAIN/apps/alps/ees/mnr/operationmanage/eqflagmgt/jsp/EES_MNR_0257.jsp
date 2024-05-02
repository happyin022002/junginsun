<%
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EES_MNR_0257.jsp
*@FileTitle : Hanger Rack/Bar Using Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.12.20 김상수
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0257Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
  EesMnr0257Event  event = null;          //PDTO(Data Transfer Object including Parameters)
  Exception serverException   = null;      //서버에서 발생한 에러
  String strErrMsg = "";            //에러메세지
  int rowCount   = 0;            //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id    = "";
  String strUsr_nm    = "";
  String strOfc_cd        = "";
  String rhqOfcCd         = "";
  String currOfcCd        = "";
  Logger log = Logger.getLogger("com.hanjin.apps.test.test");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    rhqOfcCd  = account.getRhq_ofc_cd();
    currOfcCd = account.getOfc_cd();

    event = (EesMnr0257Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!--MNR 공용 사용  -->
<script language="javascript">
  var currOfcCd = '<%=strOfc_cd %>';
  var rhqOfcCd  = '<%=rhqOfcCd %>';

  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="key_value">
<input type="hidden" name="usr" value="<%=strUsr_id %>">
<input type="hidden" name="f_gubuns">
<input type="hidden" name="cost_ofc_cd">
<input type="hidden" name="self_ofc_cd" value="<%=currOfcCd%>">
<input type="hidden" name="mnr_grp_tp_cd" value="RPR">
<input type="hidden" name="mnr_wo_tp_cd" value="RFS">
<input type="hidden" name="sel_type" value="S">

<!-- 개발자 작업  -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr><td valign="top">
        <!--Page Title, Historical (S)-->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
      <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
    </table>
    <!--Page Title, Historical (E)-->

    <!--Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
      <tr>
        <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve">Retrieve</td>
                    <td class="btn1_right"></td></tr></table></td>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr><td class="btn1_left"></td>
                  <td class="btn1" name="btn_new">New</td>
                  <td class="btn1_right"></td></tr></table></td>
            </tr></table></td>
      </tr>
    </table>
      <!--Button (E) -->

    <!--biz page (S)-->
    <table class="search" id="mainTable">
      <tr>
        <td class="bg">
          <!--  biz_1  (S) -->
          <table class="search" style="width:650;">
            <tr class="h23">
              <td>Period</td>
              <td><input type="text" style="width:80;" class="input1" name="from_date" dataformat="ymd" maxlength="8" cofield="to_date">&nbsp;~
                <input type="text" style="width:80;" class="input1" name="to_date" dataformat="ymd" maxlength="8" cofield="from_date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal"></td>
              <td width="100">&nbsp;</td>
              <td>Location By</td>
              <td><script language="javascript">ComComboObject('p_loc_tp', 1, 60, 1, 1);</script>
                &nbsp;<input type="text" name="p_loc_cd" caption="Location" style="width:70;ime-mode:disabled;" class="input2" dataformat="engup" maxlength="5" readonly fullfill>
                <img class="cursor" name="btns_search" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
            </tr>
            <tr class="h23">
              <td>H/R Type</td>
              <td style="padding-left:2px;"><script language="javascript">ComComboObject('mnr_hngr_rck_cd', 1, 201, 1, 0)</script></td>
              <td width="100">&nbsp;</td>
              <td>Tariff Type</td>
              <td><script language="javascript">ComComboObject('mnr_hngr_trf_cd', 1, 157, 1, 0);</script></td>
            </tr>
          </table>
          <!--  biz_1   (E) -->
        </td>
      </tr>
    </table>


    <table class="height_8"><tr><td></td></tr></table>

    <table class="search" id="mainTable">
           <tr><td class="bg">

      <!-- Grid  (S) -->
      <table width="100%"  id="mainTable">
        <tr>
          <td width="100%">
          <script language="javascript">ComSheetObject('sheet1');</script>
          </td>
        </tr>
      </table>
      <!-- Grid (E) -->
      <!--  Button_Sub (S) -->
      <table width="100%" class="button">
           <tr><td class="btn2_bg">

        <table border="0" cellpadding="0" cellspacing="0"><tr>
            <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn2_left"></td>
            <td class="btn2" name="btn_downexcel">Down Excel</td>
            <td class="btn2_right"></td>
            </tr>
            </table></td>
          </tr></table>
      </td></tr>
      </table>

      <!-- Grid (E) -->
    <!--biz page (E)-->

    </td></tr>
    </table>

  </td></tr>
    </table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
