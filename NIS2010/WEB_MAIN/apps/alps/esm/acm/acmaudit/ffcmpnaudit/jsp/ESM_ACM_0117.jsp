<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0117.js
*@FileTitle : FF Compensation Details & History for B/L
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.13
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.13 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmaudit.ffcmpnaudit.event.EsmAcm0117Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0117Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0117Event)request.getAttribute("Event");
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
<title>FF Compensation Details & History for B/L</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("grpTp", "", "CD00888", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ffCmpnDiv", "", "CD00598", 0, "")%>


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

<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:900px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <td class="title"><img src="img/ico_t1.gif" width="20" height="12">FF Compensation Details & History for B/L</td>
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
                      <td class="btn1" name="btn_new">New</td>
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
          <td class="bg">
            <table class="search" border="0" style="width:20%;" align="right">
              <tr class="h23">
              <td valign="top"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>
            </table>

            <table><tr><td style="height:3;"></td></tr></table>

            <table class="search" border="0" style="width:650px;">
              <tr class="h23">
                <td width="120">B/L</td>
                <td width="104"><input type="text" name="bl_no" dataformat="engup" maxlength="12" class="input1" value="<%=JSPUtil.getParameter(request, "bl_no")%>" style="width:100;text-align:center;ime-mode:disabled;" tabindex="1"></td>
                <td width="104" align="right">Booking No.&nbsp;</td>
                <td colspan="2"><input type="text" name="bkg_no" dataformat="engup" maxlength="13" class="input1" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" style="width:100;text-align:center;ime-mode:disabled;" tabindex="2"></td>
              </tr>
              <tr class="h23">
                <td>ETD DT</td>
                <td colspan="4"><input type="text" name="vsl_dep_dt" class="input2" style="width:100;text-align:center;" readOnly></td>
              </tr>
              <tr class="h23">
                <td>Shipper</td>
                <td colspan="4">
                  <input type="text" name="shpr_cnt_seq" class="input2" style="width:100;text-align:center;" readOnly>
                  <input type="text" name="shpr_nm" class="input2" style="width:416;" readOnly>
                </td>
              </tr>
              <tr class="h23">
                <td>F.Frwder / Vendor</td>
                <td colspan="4">
                  <input type="text" name="ff_cnt_seq" class="input2" style="width:100;text-align:center;" readOnly>
                  <input type="text" name="vndr_cnt_seq" class="input2" style="width:100;text-align:center;" readOnly>
                  <input type="text" name="ff_nm" class="input2" style="width:312;" readOnly>
                </td>
              </tr>
              <tr class="h23">
                <td>T.VVD</td>
                <td><input type="text" name="comm_vsl" class="input2" style="width:100;text-align:center;" readOnly></td>
                <td align="right">Route&nbsp;&nbsp;</td>
                <td colspan="2">
                  <input type="text" name="por_cd" class="input2" style="width:75;text-align:center;" readOnly>
                  <input type="text" name="pol_cd" class="input2" style="width:75;text-align:center;" readOnly>
                  <input type="text" name="pod_cd" class="input2" style="width:75;text-align:center;" readOnly>
                  <input type="text" name="del_cd" class="input2" style="width:75;text-align:center;" readOnly>
                </td>
              </tr>
              <tr class="h23">
                <td>REF No.</td>
                <td><input type="text" name="ff_ref_no" class="input2" style="width:100; text-align:center;" readOnly></td>
                <td align="right">FMC&nbsp;&nbsp;</td>
                <td colspan="2"><input type="text" name="fmc_no" class="input2" style="width:154;text-align:center;" readOnly></td>
              </tr>
              <tr class="h23">
                <td>SC / RFA No.</td>
                <td colspan="2"><input type="text" name="sc_rfa_no" class="input2" style="width:204;" readOnly></td>
                <td width="158" align="right">Kind&nbsp;&nbsp;</td>
                <td><input type="text" name="ff_knd_cd" class="input2" style="width:154;text-align:center;" readOnly></td>
              </tr>
            </table>

            <table><tr><td style="height:4;"></td></tr></table>
            <table class="line_bluedot"><tr><td style="height:20;"></td></tr></table>

            <!-- : ( grid ) (S) -->
            <table width="100%" id="mainTable1">
              <tr>
                <td><script language="javascript">ComSheetObject("sheet2");</script></td>
              </tr>
            </table>
            <!-- : ( grid ) (E) -->
            <!-- : ( grid ) (S) -->
            <table width="100%" id="mainTable2">
              <tr>
                <td><script language="javascript">ComSheetObject("sheet3");</script></td>
              </tr>
            </table>
            <!-- : ( grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


      <!-- Button (S) -->
      <table class="height_8"><tr><td></td></tr></table>
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
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


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>