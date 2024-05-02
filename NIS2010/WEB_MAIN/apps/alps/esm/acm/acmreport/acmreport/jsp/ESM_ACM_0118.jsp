<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0118.jsp
*@FileTitle : Customized Report Form
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.17
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.09.17 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event.EsmAcm0118Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0118Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0118Event)request.getAttribute("Event");
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
<title>Customized Report Form</title>
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

<input type="hidden" name="save_flag">


<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Customized Report Form</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
      <!-- Search BG (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Select Customized Form ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td>Customized RPT Form&nbsp;&nbsp;
                  <select name="slct_itm_fom_seq" style="width:110px;"></select></td>
              </tr>
            </table>
            <!-- : ( Select Customized Form ) (E) -->
            <table class="line_bluedot"><tr><td></td></tr></table>
            <!-- : ( Grid ) (S) -->
            <table class="search">
              <tr>
                <td width="46%">
                  <table width="100%" id="mainTable">
                    <tr>
                      <td><script language="javascript">ComSheetObject("sheet1");</script></td>
                    </tr>
                  </table>
                </td>
                <td width="8%" valign="middle" align="center">
                  <img src="img/button/btns_add.gif" width="26" height="26" border="0" name="btns_add"><br><br>
                  <img src="img/button/btns_del.gif" width="26" height="26" border="0" name="btns_del"></td>
                <td width="46%">
                  <table width="100%" id="mainTable">
                    <tr>
                      <td><script language="javascript">ComSheetObject("sheet2");</script></td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
                <td colspan="3" class="stm">
                  <input type="radio" class="trans" name="radio_save_yn"  onFocus="javascript:this.blur();">&nbsp;Use this setting at this time only</td>
              </tr>
              <tr>
                <td colspan="3" class="stm">
                  <input type="radio" class="trans" name="radio_save_yn"  onFocus="javascript:this.blur();" checked>&nbsp;Save this setting as&nbsp;&nbsp;
                  <input name="slct_itm_fom_desc" type="text" dataformat="eng" maxlength="99" style="width:160;"></td>
              </tr>
            </table>
            <!-- : ( Grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- Search BG (S) -->
    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_ok">OK</td>
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
                <td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_delete">Delete</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->
    </td>
  </tr>
</table>
</form>
</body>
</html>
