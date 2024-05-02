<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0103.jsp
*@FileTitle : Charge Deduction User Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.23
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.03.23 박성진
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event.EsmAcm0003Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0003Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMSetup.ACMSetup");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0003Event)request.getAttribute("Event");
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
<title>Charge Deduction User Setting</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  var sFunc = '<%=JSPUtil.getParameter(request, "func")%>';
  var iSheetIdx = '<%=JSPUtil.getParameter(request, "sheetIdx")%>';
  var iRow = '<%=JSPUtil.getParameter(request, "row")%>';
  var iCol = '<%=JSPUtil.getParameter(request, "col")%>';


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


<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:742px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <td class="title"><img src="img/ico_t1.gif" width="20" height="12">Charge Deduction Setting</td>
      </table>
      <!-- Page Title, Historical (E) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td style="color:#532FC3; font-weight:bold;padding-left:0px;"><input type="radio" class="trans" name="grp_idv_div">User Setting</td>
              </tr>
            </table>


            <table class="search" border="0">
              <tr>
                <td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">User Set List</td>
              </tr>
              <tr>
                <td style="padding-left:2px;">
                  <!-- Grid_1 (S) -->
                  <table width="100%" id="mainTable1">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
                    </tr>
                  </table>
                  <!-- Grid_1 (E) -->
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->


            <table class="line_bluedot"><tr><td></td></tr></table>


            <!-- biz_2 (S) -->
            <table  border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td style="color:#532FC3; font-weight:bold;padding-left:0px;"><input type="radio" class="trans" name="grp_idv_div">Individual Setting</td>
              </tr>
            </table>


            <table class="search" border="0">
              <tr>
                <td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Selected Rep.Charge</td>
                <td rowspan="4" style="width:30px"></td>
                <td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Selected Charge Code</td>
              </tr>
              <tr>
                <td><textarea name="slct_rep_chg" style="width:270px; height:34" class="input2" readOnly><%=JSPUtil.getParameter(request, "rep_chg_cd")%></textarea></td>
                <td><textarea name="slct_charge" style="width:400px; height:34" class="input2" readOnly><%=JSPUtil.getParameter(request, "chg_cd")%></textarea></td>
              </tr>
              <tr>
                <td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Rep.Charge</td>
                <td class="gray_tit" style="font-weight:bold; padding:10px 0px 5px 3px;">Charge Code</td>
              </tr>
              <tr>
                <td style="padding-left:2px;">
                  <!-- Grid_2 (S) -->
                  <table width="100%" id="mainTable2">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
                    </tr>
                  </table>
                  <!-- Grid_2 (E) -->
                </td>
                <td style="padding-left:2px;">
                  <!-- Grid_3 (S) -->
                  <table width="100%" id="mainTable3">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet3");</script></td>
                    </tr>
                  </table>
                  <!-- Grid_3 (E) -->
                </td>
              </tr>
            </table>
            <!-- biz_2 (E) -->


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
                      <td class="btn1" name="btn_clear">Clear</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_select">Confirm</td>
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
      <!-- Button (E) -->


    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>
