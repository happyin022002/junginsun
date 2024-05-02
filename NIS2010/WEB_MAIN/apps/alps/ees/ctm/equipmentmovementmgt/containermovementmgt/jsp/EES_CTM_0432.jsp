<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0432.jsp
*@FileTitle : Detail Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.06.26 김상수
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
<%@ page import="org.apache.log4j.Logger" %>

<%
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";    //에러메세지
  int rowCount = 0;    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id =  account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }


  // ok_count
  String okCount = (request.getParameter("ok_count") == null)? "": request.getParameter("ok_count");
  // error_count
  String errorCount = (request.getParameter("error_count") == null)? "": request.getParameter("error_count");
  // ignored_count
  String ignoredCount = (request.getParameter("ignored_count") == null)? "": request.getParameter("ignored_count");
  // total_count
  String totalCount = (request.getParameter("total_count") == null)? "": request.getParameter("total_count");
%>
<html>
<head>
<title>Detail Information</title>
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

<body onLoad="setupPage();" onUnload="unloadPage(document.form.unload_flag.value);">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="ok_count" value="<%=okCount%>">
<input type="hidden" name="error_count" value="<%=errorCount%>">
<input type="hidden" name="ignored_count" value="<%=ignoredCount%>">
<input type="hidden" name="total_count" value="<%=totalCount%>">
<input type="hidden" name="unload_flag" value="reset">
<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="1">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Message</td></tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="100%" class="search" id="mainTable">
              <tr>
              <td width="100%">
              <script language="javascript">ComSheetObject('sheet1');</script>
              </td>
              </tr>
            </table>
            <!-- : ( Grid ) (E) -->
          <!-- : ( Button : Grid ) (E) -->
          </td>
        </tr>
      </table>
    <!-- : ( Search Options ) (E) -->
    </td>
  </tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="300" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right">
                    </tr>
                  </table></td>
              </tr>
            </table></td>
      <!-- Button (E) -->
        </tr>
      </table></td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>