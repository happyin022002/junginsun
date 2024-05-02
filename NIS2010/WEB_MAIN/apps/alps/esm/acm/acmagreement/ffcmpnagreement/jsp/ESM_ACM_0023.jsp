<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0023.jsp
*@FileTitle : FF Compensation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.event.EsmAcm0023Event"%>
<%@ page import="com.hanjin.bizcommon.util.BizComUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0023Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
  String grpTpText = "";                                                  //Location 별 Type 구분 Text
	String inv_sub_sys_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0023Event)request.getAttribute("Event");
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
<%=JSPUtil.getIBCodeCombo("proTp", "", "CD00888", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ffDivCd", "", "CD02812", 0, "")%>

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
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="cust_cd">
<input type="hidden" name="sheetId">
<input type="hidden" name="row">
<input type="hidden" name="colNm1">
<input type="hidden" name="colNm2">
</form>
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="rowNum">
<input type="hidden" name="colNum">
<!-- 개발자 작업 -->

<input name="ofc_cd" type="hidden" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input name="aud_no" type="hidden">
<input name="vvd_cd" type="hidden"><!-- Multi VVD -->
<input name="bl_no" type="hidden" ><!-- Multi B/L No -->
<input type="hidden" name="h_csrNo"> <!-- grid에서 선택된 csrNo -->
<input type="hidden" name="aproSeqKey" value="<%=com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute1(strOfc_cd, inv_sub_sys_cd) %>">

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
                      <td width="17%">Freight Forwarder Code</td>
                      <td>&nbsp;<input type="text" name="search_brog_cnt_cust_seq" style="width:100;ime-mode:disabled;" onKeyPress="ComKeyOnlyAlphabet('uppernum')" maxlength="8"><input type="hidden" name="search_brog_cnt_cust_seqName">
                      	<img class="cursor" name="btn_popup" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
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
                            <td class="btn2" name="btn_copy">Row Copy</td>
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