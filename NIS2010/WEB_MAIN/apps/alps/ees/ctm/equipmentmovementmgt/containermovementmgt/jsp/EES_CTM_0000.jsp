<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0000.jsp
*@FileTitle : GATENEW Test
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.04.30 김상수
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event.EesCtm0000Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EesCtm0000Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementMasterDataMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesCtm0000Event)request.getAttribute("Event");
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
<title>GATENEW Test</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage() {
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
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


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;GATENEW Test</td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

  <!-- biz page (S) -->
    <table class="search">
       <tr><td width="70%" class="bg" valign="top"><table width="100%" id="mainTable" border="0">
                <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
              </table></td>
           <td width="30%" class="bg" valign="top"><table width="100%" id="mainTable">
                <tr><td width="100%" valign="top"><textarea name="mq_text" style="width:100%; height:181" class="input1"></textarea></td></tr>
            </table></td>
       </tr>
       <tr>
         <td class="bg" align="center"><input type="radio" name="input_radio" value="SHEET" class="trans">&nbsp;Sheet</td>
         <td class="bg" align="center"><input type="radio" name="input_radio" value="MQ" class="trans" checked>&nbsp;MQ_Text</td>
       </tr>
       <tr><td colspan="2" class="bg">


  <!-- Button (S) -->
    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
       <tr><td class="btn1_bg">
      <table border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
          <tr><td class="btn1_left"></td>
          <td class="btn1" name="btn_save">Save</td>
          <td class="btn1_right"></td>
          </tr>
        </table></td>
        <td class="btn1_line"></td>
        <td>&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
            <tr><td class="btn1_left"></td>
              <td class="btn1" name="btn_new">New</td>
              <td class="btn1_right"></td>
            </tr>
          </table></td>
      </tr></table>
    </td></tr>
    </table>
  <!-- Button (E) -->
<br>
        <!-- Grid  (S) -->
        <table width="100%"  id="mainTable">
          <tr>
            <td width="100%">
              <script language="javascript">ComSheetObject('sheet2');</script>
            </td>
          </tr>
        </table>
        <!-- Grid (E) -->

        <!-- biz_2   (E) -->
        </td></tr>
      </table>

  <!-- biz page (E) -->

    </td></tr>
    </table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>