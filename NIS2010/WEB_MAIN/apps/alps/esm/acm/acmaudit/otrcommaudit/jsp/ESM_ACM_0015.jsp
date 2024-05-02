<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0015.js
*@FileTitle : Other Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
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
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.event.EsmAcm0015Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0015Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  String aproStep = "";
	String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0015Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	aproStep =  com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute(strOfc_cd,"ACM");
	inv_sub_sys_cd		= JSPUtil.getParameter(request, "inv_sub_sys_cd			".trim(), "");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Agent Commission CSR Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  // 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("ofcChr", "", "CD03015", 0, "")%>
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
<%=JSPUtil.getIBCodeCombo("xchRtDivLvl", "", "CD03020", 0, "")%>
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
<!-- 개발자 작업 -->

<input name="ofc_cd" type="hidden" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input name="aud_no" type="hidden">
<input name="vvd_cd" type="hidden"><!-- Multi VVD -->
<input name="bl_no" type="hidden" ><!-- Multi B/L No -->
<input type="hidden" name="h_csrNo"> <!-- grid에서 선택된 csrNo -->
<input type="hidden" name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">
<input type="hidden" name="bkg_no">
<input type="hidden" name="bkg_no_array">

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
                      <td class="btn1" name="btn_audit">Audit</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_reject">Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_audit_cancel">Audit Cancel</td>
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
      <!-- 조회조건 상단 영역 -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>

                <td align="left" valign="top">
                  <table align="left" border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Office&nbsp;
                        <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
                        &nbsp;
                        Sub Office&nbsp;
                        <select name="agn_cd" required caption="Sub Office" class="input1" style="width:70px;" tabindex="2"></select>&nbsp;&nbsp;
                      </td>
                      <td>Status&nbsp;
                        <%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:112px;'", "CD03027", 0, "")%>&nbsp;&nbsp;
                      </td>
                      <td>Subject Month&nbsp;&nbsp;&nbsp;
                        <input name="comm_yrmon" type="text" dataformat="ym" maxlength="6" required caption="Subject Month" class="input1" style="width:55px;" tabindex="3">
                      </td>
                    </tr>
                  </table>
                </td>

              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>

      <table class="line_bluedot"><tr><td></td></tr></table>

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
          </td>
        </tr>
      </table>

      <!-- biz_3 (S) -->
      <!--table width="100%" class="button">
        <tr>
          <td class="btn2_bg">
            <table  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn2_left"></td>
                      <td class="btn2" name="btn_add">Row Add</td>
                      <td class="btn2_right"></td>
                      <td class="btn2_left"></td>
                      <td class="btn2" name="btn_delete">Row Delete</td>
                      <td class="btn2_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table-->
      <!-- biz_3 (E) -->

      <!-- biz page (E) -->
    </td>
  </tr>
</table>

<!-- 개발자 작업 끝 -->
</form>
</body>
</html>