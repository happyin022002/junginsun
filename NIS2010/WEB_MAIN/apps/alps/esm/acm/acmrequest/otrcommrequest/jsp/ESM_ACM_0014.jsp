<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0014.jsp
*@FileTitle : Other Commission Request
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmrequest.otrcommrequest.event.EsmAcm0014Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0014Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";
  String yyyyMMDD = JSPUtil.getKST("yyyy-MM-dd");
  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMRequest.OTRCommRequest");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();

    event = (EsmAcm0014Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Other Commission Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  // 공통코드 combo string 추출
<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "0: :ALL")%>

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
<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<!-- 개발자 작업 -->

<input type="hidden" name="hid_add_row">
<input type="hidden" name="frm_vndr_seq">
<input type="hidden" name="frm_vndr_lgl_eng_nm">
<input type="hidden" name="frm_ar_ofc_cd">
<input type="hidden" name="frm_ac_occr_info_cd">
<input type="hidden" name="frm_ap_ctr_cd">
<input type="hidden" name="frm_curr_cd">
<input type="hidden" name="frm_aply_dt">
<input type="hidden" name="hid_vndr_seq">
<input type="hidden" name="hid_ac_occr_info_cd">
<input type="hidden" name="hid_curr_cd">
<input type="hidden" name="hid_ap_ctr_cd">
<input type="hidden" name="hid_pay_xch_rt">
<input type="hidden" name="to_date" value="<%=yyyyMMDD%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_request">Request</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down Excel</td>
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

      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" align="left" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td>Office&nbsp;
                  <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
                  &nbsp;
                  Sub Office&nbsp;
                  <select name="agn_cd" required caption="Sub Office" class="input1" style="width:70px;" tabindex="2"></select>
                  &nbsp;
                  Subject Month&nbsp;
                  <input name="comm_yrmon" type="text" dataformat="ym" maxlength="6" required caption="Subject Month" class="input1" style="width:55px;" tabindex="3">
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <div style="height:8px;"></div>


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->


            <!-- biz_3 (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <!-- Grid_button (S) -->
                  <table  border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_add">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_delete">Delete</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <!-- Grid_button (E) -->
                </td>
              </tr>
            </table>
            <!-- biz_3 (E) -->


          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>