<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0037.jsp
*@FileTitle : Commission Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.04
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.04 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm0037Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0037Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0037Event)request.getAttribute("Event");
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
<title>Commission Report</title>
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


<input type="hidden" name="bl_no"><!-- Multi B/L No -->
<input type="hidden" name="report_item">


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
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td width="55">Office</td>
                <td width="140"><select name="ar_ofc_cd" required caption="Office" class="input1" style="width:80px;"></select></td>
                <td width="75">Sub Office</td>
                <td width="140"><select name="agn_cd" required caption="Sub Office" class="input1" style="width:80px;"></select></td>
                <td width="100">Status</td>
                <td width="170"><%=JSPUtil.getCodeCombo("sts_option", "", "style='width:80px;'", "CD03039", 0, "")%></td>
                <td width="80">Date</td>
                <td width="237"><input name="fm_dt" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="to_dt" class="input1" style="width:80px;">&nbsp;~
                  <input name="to_dt" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="fm_dt" class="input1" style="width:80px;">
                  <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
              </tr>
              <tr class="h23">
                <td>Bound</td>
                <td><%=JSPUtil.getCodeCombo("io_bnd_cd", "", "style='width:80px;'", "CD03037", 0, " ")%></td>
                <td>Trade</td>
                <td><select name="s_trd_cd" style="width:80px;"></select></td>
                <td>Lane</td>
                <td><select name="s_rlane_cd" style="width:80px;"></select></td></td>
                <td>Direction</td>
                <td><%=JSPUtil.getCodeCombo("s_dir_cd", "", "style='width:80px;'", "CD00593", 0, " ")%></td>
              </tr>
              <tr class="h23">
                <td>VVD</td>
                <td><input name="comm_vvd" type="text" dataformat="engup" maxlength="9" style="width:80px;"></td>
                <td>Audit No.</td>
                <td><input name="aud_no" type="text" dataformat="engup" maxlength="20" style="width:80px;"></td>
                <td>Booking Office</td>
                <td><input name="bkg_ofc_cd" type="text" dataformat="engup" maxlength="6" style="width:80px;">
                  <img name="btn_bkg_ofc_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
                <td> </td>
                <td> </td>
                <!--
                <td>Sales Office</td>
                <td><input name="ob_sls_ofc_cd" type="text" dataformat="engup" maxlength="6" style="width:80px;">
                  <img name="btn_ob_sls_ofc_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;"></td>
                -->
              </tr>
              <tr class="h23">
                <td>B/L No.</td>
                <td colspan="3">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
  <!----------------------------------------------------------------->
                      <!-- Memo Sheet (S) -->
                      <td width="104" height="25" id="memo_sheet1_td">
                        <div id="memo_sheet1_div">
                          <table width="104">
                            <tr>
                              <td><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
                            </tr>
                          </table>
                        </div>
                      </td>
                      <td>&nbsp;&nbsp;</td>
                      <!-- Memo Sheet (E) -->
  <!----------------------------------------------------------------->
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn2_bl_no">Multi B/L No</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                </td>
                <td>POR/POL</td>
                <td><input name="por_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;">&nbsp;/
                    <input name="pol_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;"></td>
                <td>POD/DEL</td>
                <td><input name="pod_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;">&nbsp;/
                    <input name="del_cd" type="text" dataformat="engup" maxlength="5" style="width:50px;"></td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <table class="height_8"><tr><td></td></tr></table>


      <table class="search">
        <tr class="h23">
          <!-- biz_2 (S) -->
          <td class="bg" valign="top">Customized RPT Form&nbsp;&nbsp;
            <select name="slct_itm_fom_seq" style="width:110px;"></select>
            <img name="btn_rpt_itm_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->


          </td>
          <!-- biz_2 (E) -->
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
