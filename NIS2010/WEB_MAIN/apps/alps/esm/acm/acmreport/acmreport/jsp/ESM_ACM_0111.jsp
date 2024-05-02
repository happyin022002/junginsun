<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_ACM_0111.jsp
 *@FileTitle : CSR Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.16
 *@LastModifier : 김봉균
 *@LastVersion : 1.0
 * 2012.05.16 김봉균
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm0111Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0111Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String agn_cd = "";
  String csr_no = "";
  String rev_vvd_cd = "";
  String comm_stnd_cost_cd = "";

  Logger log = Logger.getLogger("com.hanjin.apps.ACMReport.ACMReport");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0111Event) request.getAttribute("Event");
    serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	//ESM_ACM_0034 화면에서 넘어온 파라미터를 받는다.
	agn_cd  = JSPUtil.getParameter(request, "agn_cd");
	csr_no  = JSPUtil.getParameter(request, "csr_no");
	rev_vvd_cd  = JSPUtil.getParameter(request, "rev_vvd_cd");
	comm_stnd_cost_cd  = JSPUtil.getParameter(request, "comm_stnd_cost_cd");

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->

<input type="hidden" name="agn_cd" value="<%= agn_cd %>">
<input type="hidden" name="csr_no" value="<%= csr_no %>">
<input type="hidden" name="rev_vvd_cd" value="<%= rev_vvd_cd %>">
<input type="hidden" name="comm_stnd_cost_cd" value="<%= comm_stnd_cost_cd %>">

<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding: 2px 0px 0px 5px; border: 0px #ff0000 solid; width: 800px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
    <!-- Page Title, Historical (S) -->
    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
      <td class="title"><img src="/hanjin/img/ico_t1.gif" width="20" height="12">CSR Detail</td>
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
        <table border="0" cellpadding="0" cellspacing="0" align="left">
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