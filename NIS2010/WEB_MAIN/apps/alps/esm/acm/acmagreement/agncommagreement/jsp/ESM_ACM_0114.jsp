<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_ACM_0114.jsp
 *@FileTitle : Agreement Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.06.15
 *@LastModifier : 김봉균
 *@LastVersion : 1.0
 * 2012.06.15 김봉균
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0114Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0114Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String agnAgmtNo = "";

  Logger log = Logger.getLogger("com.hanjin.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0114Event) request.getAttribute("Event");
    serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	//ESM_ACM_0101 화면에서 넘어온 파라미터를 받는다.
	agnAgmtNo  = JSPUtil.getParameter(request, "agn_agmt_no");

  } catch (Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Agreement Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
//공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("acTp", "", "CD03021", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ioBnd", "", "CD00592", 0, "")%>
<%=JSPUtil.getIBCodeCombo("fullMty", "", "CD00748", 0, "")%>
<%=JSPUtil.getIBCodeCombo("commPayTerm", "", "CD03022", 0, "")%>
<%=JSPUtil.getIBCodeCombo("revDiv", "", "CD03023", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcSetTp", "", "CD03016", 0, "")%>
<%=JSPUtil.getIBCodeCombo("ofcCvrg", "", "CD03019", 0, "")%>

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

<input type="hidden" name="agn_agmt_no" value="<%= agnAgmtNo %>">

<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding: 2px 0px 0px 5px; border: 0px #ff0000 solid; width: 800px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
    <!-- Page Title, Historical (S) -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
      <td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">Agreement Information</td>
    </table>
    <!-- Page Title, Historical (S) -->

    <div style="height:5px;"></div>

    <!-- Sheet(1) (S) -->
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
    <!-- Sheet(1) (E) -->
    <!-- Sheet(1)_Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding: 5px 0px 10px 0px;">
      <tr>
        <td class="btn3_bg">
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
    <!-- Sheet(1)_Button (E) -->
    </td>
  </tr>
</table>
<!-- 개발자 작업 끝 -->
</form>
</body>
</html>