<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_ACM_0107.jsp
 *@FileTitle : Audit Confirm
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.04.04
 *@LastModifier : 김영오
 *@LastVersion : 1.0
 * 2012.04.04 김영오
 * 1.0 Creation
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.event.EsmAcm0107Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0107Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.clt.apps.ACMMaster.AGNCommAgreement");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0107Event) request.getAttribute("Event");
    serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch (Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Commission Agreement Creation_Master</title>
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
<input type="hidden" name="f_cmd"> <input type="hidden" name="pagerows"> <input type="hidden" name="agmt_agn_cd">
<input type="hidden" name="new_agmt_no">
<!-- 개발자 작업 -->



<!-- ESM_ACM_0008 화면에서 넘어온 파라미터를 받는다. -->
<!-- 임시 하드코딩 테스트위해..추후삭제예정 -->
<input type="hidden" name="ar_ofc_cd" value="<%//=JSPUtil.getParameter(request, "ar_ofc_cd")%>SAOBB%>">
<input type="hidden" name="sts_cd" value="<%//=JSPUtil.getParameter(request, "sts_cd")%>4">
<input type="hidden" name="scn_id" value="<%//=JSPUtil.getParameter(request, "scn_id")%>ACMCOMM">
<input type="hidden" name="arr_val" value="<%//=JSPUtil.getParameter(request, "arr_val")%>'LIM100177100LIMBAO1', 'SAO005300100SAOBBO1', 'LIM100177100MEXBBI1'">
<input type="hidden" name="date_fm" value="<%//=JSPUtil.getParameter(request, "date_fm")%>20000106">
<input type="hidden" name="date_to" value="<%//=JSPUtil.getParameter(request, "date_to")%>20120930">
<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding: 2px 0px 0px 5px; border: 0px #ff0000 solid; width: 570px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top"><!-- Page Title, Historical (S) -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
      <td class="title"><img src="img/ico_t1.gif" width="20" height="12">Audit Confirm</td>
    </table>
    <!-- Page Title, Historical (S) --> <!-- Search Condition (2) -->
    <table class="search">
      <tr>
        <td class="bg" valign="top"><!-- biz_1 (S) -->
        <table width="530" cellpadding="0" cellspacing="0" border="0">
          <tr class="h23">
            <td>Audit Number&nbsp; <input name="audit_number" type="text" required caption="Audit Number" class="input1" style="width: 200px;"></td>
          </tr>
        </table>
        <!-- biz_1 (E) --></td>
      </tr>
    </table>
    <!-- Search Condition (2) -->
    <div style="height:5px;"></div>
    <!-- Sheet(1) -->
    <table class="search">
      <tr>
        <td class="bg" valign="top"><!-- Tab_1_Grid_1 (S) -->
        <table width="100%" id="mainTable1">
          <tr>
            <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
          </tr>
        </table>
        <!-- Tab_1_Grid_1 (E) --></td>
      </tr>
    </table>
    <!-- Sheet(1) --> <!-- Sheet(1)_Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding: 5px 0px 10px 0px;">
      <tr>
        <td class="btn1_bg">
        <table border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td>
            <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
              <tr>
                <td class="btn1_left"></td>
                <td class="btn1" name="btn_confirm">Confirm</td>
                <td class="btn1_right"></td>
              </tr>
            </table>
            </td>
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
    <!-- Sheet(1)_Button (E) --></td>
  </tr>
</table>
<!-- 개발자 작업 끝 --></form>
</body>
</html>