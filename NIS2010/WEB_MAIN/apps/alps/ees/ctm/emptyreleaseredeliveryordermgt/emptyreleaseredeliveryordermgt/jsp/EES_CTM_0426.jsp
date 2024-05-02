<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0426.jsp
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.07.27 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.core.layer.event.EventResponse"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.event.EesCtm0426Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0426Event  event = null;    //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";    //에러메세지
  int rowCount = 0;    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strUsr_eml = "";
  String strUsr_ofc = "";
  List<String> mailKey = new ArrayList();

  Logger log = Logger.getLogger("com.hanjin.apps.EmptyReleaseRedeliveryOrderMgt.EmptyReleaseRedeliveryOrderMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strUsr_eml = account.getUsr_eml();
    strUsr_ofc = account.getOfc_cd();

    event = (EesCtm0426Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    if(request.getAttribute("EventResponse") != null){
      // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
      GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
      mailKey = (List<String>)eventResponse.getCustomData(SiteConfigFactory.get("COM.MAIL.KEYS"));
    }

  } catch(Exception e) {
    out.println(e.toString());
  }


  // Duration 시작일
  String pDate1 = DateTime.addDays(DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd"), -7, "yyyy-MM-dd");
  // Duration 종료일
  String pDate2 = DateTime.addMonths(pDate1, 1, "yyyy-MM-dd");

%>
<html>
<head>
<title>Release/Re-delivery Order</title>
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
<!-- 개발자 작업 -->


<input type="hidden" name="mail_key" value="<%=mailKey%>">
<input type="hidden" name="sub_sys_cd" value="CTM">                    <!-- Mail Module -->
<input type="hidden" name="sender_usr_id" value="<%=strUsr_id%>">      <!-- RD/Mail Sender ID -->
<input type="hidden" name="sender_usr_nm" value="<%=strUsr_nm%>">      <!-- Mail Sender Name -->
<input type="hidden" name="sender_usr_eml" value="<%=strUsr_eml%>">    <!-- Mail Sender E-Mail -->
<input type="hidden" name="sender_usr_ofc" value="<%=strUsr_ofc%>">    <!-- RD/Fax Sender Office -->
<input type="hidden" name="sender_usr_cnt">                            <!-- RD User Country -->
<input type="hidden" name="receiver_eml">                              <!-- Mail Receiver E-Mail -->
<input type="hidden" name="receiver_fax">                              <!-- FAX Receiver Fax No. -->
<input type="hidden" name="tmpl_mrd" value="EES_CTM_0451.mrd">         <!-- Mail Template MRD -->
<input type="hidden" name="issue_flag">
<input type="hidden" name="issue_type">
<input type="hidden" name="tmpl_param">
<input type="hidden" name="rd_content">


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
            <table border="0">
              <tr class="h23">
                <td>
                  <table class="grid2" border="0">
                    <tr>
                      <td class="tr2_head" width="80">Date</td>
                      <td colspan="3"><input type="text" style="width:90;ime-mode:disabled;" class="input1" value="<%=pDate1%>" tabindex="1" name="p_date1">&nbsp;~
                        <input type="text" style="width:90;ime-mode:disabled;" class="input1" value="<%=pDate2%>" tabindex="2" name="p_date2">
                        <img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;" name="btn_Calendar"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head">Territory</td>
                      <td colspan="3"><script language="javascript">ComComboObject("territory", 2, 214, 1, 0, 0, 0, 3)</script><input type="hidden" name="office"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head">Type</td>
                      <td><select style="width:80;" tabindex="4" name="type">
                          <option value="RLS" selected>Release</option>
                          <option value="RDV">Redelivery</option>
                        </select></td>
                      <td class="tr2_head" width="60">Issued</td>
                      <td><select style="width:62;" tabindex="5" name="issued">
                          <option value="N" selected>No</option>
                          <option value="Y">Yes</option>
                        </select></td>
                    </tr>
                  </table>
                </td>
                <td width="30"></td>
                <td>
                  <table class="grid2" border="0">
                    <tr>
                      <td class="tr2_head" id="bkg_no_head" width="80">BKG No.</td>
                      <td><input type="text" style="width:120;ime-mode:disabled;" class="input" maxlength="13" tabindex="6" name="bkg_no"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head" id="bl_no_head">B/L No.</td>
                      <td><input type="text" style="width:120;ime-mode:disabled;" class="input" maxlength="13" tabindex="6" name="bl_no"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head">CNTR No.</td>
                      <td><input type="text" style="width:120;ime-mode:disabled;" class="input" maxlength="11" tabindex="7" name="cntr_no"></td>
                    </tr>
                  </table>
                </td>
                <td width="30"></td>
                <td align="left">
                  <table class="grid2" border="0">
                    <tr>
                      <td class="tr2_head" width="80">LCC</td>
                      <td><input type="text" style="width:120;ime-mode:disabled;" class="input" maxlength="13" tabindex="8" name="lcc_cd"></td>
                    </tr>
                    <tr>
                      <td class="tr2_head">Empty CY</td>
                      <td><input type="text" style="width:72;ime-mode:disabled;" class="input" maxlength="5" tabindex="9" name="yd_cd_disp">
                        <input type="hidden" name="p_yard1">
                        <script language="javascript">ComComboObject("p_yard2", 2, 45, 0, 0, 0, 0, 10)</script></td>
                    </tr>
                    <tr>
                      <td class="tr2_head">W/O No.</td>
                      <td><input type="text" style="width:120;ime-mode:disabled;" class="input" maxlength="13" tabindex="11" name="wo_no"></td>
                    </tr>
                  </table>
                <!-- biz_1 (E) -->
                </td>
                <td width="30"></td>
                <td align="left" valign="top">
                  <table class="grid2" border="0">
                    <tr>
                      <td class="tr2_head" width="80">TP/SZ</td>
                      <td><script language="javascript">ComComboObject("tpszCombo", 1, 50, 1, 0, 0, 0, 11);</script>
                      <input type="hidden" name="cntr_tpsz_cd">
                      </td>
                    </tr>
                  </table>
                <!-- biz_1 (E) -->
                </td>                
              </tr>
            </table>

            <table class="height_10"><tr><td colspan="8"></td></tr></table>

            <table class="search">
              <tr>
                <td>
                <!-- biz_2 (S) -->
                <!-- Grid (S) -->
                  <table width="100%" class="search"  id="mainTable">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
                    </tr>
                  </table>
                <!-- Grid (E) -->
                <!-- Grid (S) -->
                  <table width="100%" class="search"  id="mainTable">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
                    </tr>
                  </table>
                <!-- Grid (E) -->
                <!-- Grid_button (S) -->
                </td>
              </tr>
            </table>
          <!-- biz_2 (E) -->
          <!-- biz page (E) -->
          </td>
        </tr>
      </table>

    <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
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
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_settled">Settled</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_preview">Preview</td>
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