<%
/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : ESM_ACM_0113.jsp
 *@FileTitle : Location Selection
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.29
 *@LastModifier : 김영오
 *@LastVersion : 1.0
 * 2012.05.29 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.event.EsmAcm0113Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmAcm0113Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";

  Logger log = Logger.getLogger("com.hanjin.apps.ACMCommon.ACMCommon");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0113Event)request.getAttribute("Event");
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
<title>Location Selection</title>
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


<!-- ESM_ACM_0001에서 넘어온 파라미터 -->
<input type="hidden" name="agn_cd" value='<%=JSPUtil.getParameter(request, "agnCd")%>'>
<input type="hidden" name="agn_agmt_no" value='<%=JSPUtil.getParameter(request, "agnAgmtNo")%>'>
<input type="hidden" name="io_bnd_cd" value='<%=JSPUtil.getParameter(request, "ioBndCd")%>'>
<input type="hidden" name="ac_tp_cd" value='<%=JSPUtil.getParameter(request, "acTpCd")%>'>
<input type="hidden" name="agn_agmt_seq" value='<%=JSPUtil.getParameter(request, "agnAgmtSeq")%>'>
<input type="hidden" name="rout_ref_div_cd" value='<%=JSPUtil.getParameter(request, "routRefDivCd")%>'>

<input type="hidden" name="conti_cd">
<input type="hidden" name="sconti_cd">
<input type="hidden" name="cnt_cd">


<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:742px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <td class="title"><img src="img/ico_t1.gif" width="20" height="12">Location Selection</td>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Conti, Sub Conti -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <td valign="top">
          <table class="search" style="width:300px">
            <tr>
              <td class="bg" valign="top">
                <table class="Grid" border="0" style="width:100%; padding-top:0px; padding-bottom:0px; border-bottom:0px;">
                  <tr class="tr_head">
                    <td width="100%" style="padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="route_div" class="trans" onFocus="javascript:this.blur();" checked>&nbsp;Conti</td>
                  </tr>
                </table>
                <table width="100%" id="mainTable1">
                  <tr>
                    <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
                  </tr>
                </table>
              </td>
            </tr>
            <tr>
              <td style="height: 17px;">
              </td>
            </tr>
            <tr>
              <td class="bg" valign="top">
                <table class="Grid" border="0" style="width:100%; padding-top:0px; padding-bottom:0px; border-bottom:0px;">
                  <tr class="tr_head">
                    <td width="100%" style="padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="route_div" class="trans" onFocus="javascript:this.blur();">&nbsp;Sub Conti</td>
                  </tr>
                </table>
                <table width="100%" id="mainTable2">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject("sheet2");</script></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>
        </td>


        <!-- Country -->
        <td valign="top" style="padding-left: 10px;">
          <table class="search">
            <tr>
              <td class="bg" valign="top">
                <table width="300px" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="100%" valign="top">
                      <table class="Grid" border="0" style="width:100%; padding-top:0px; padding-bottom:0px; border-bottom:0px;">
                        <tr class="tr_head">
                          <td width="100%" style="padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="route_div" class="trans" onFocus="javascript:this.blur();">&nbsp;Country</td>
                        </tr>
                      </table>
                      <table width="100%" id="mainTable3">
                        <tr>
                          <td width="100%"><script language="javascript">ComSheetObject("sheet3");</script></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </td>


        <!-- Location -->
        <td valign="top" style="padding-left: 10px;">
          <table class="search">
            <tr>
              <td class="bg" valign="top">
                <table width="300px" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="100%" valign="top">
                      <table class="Grid" border="0" style="width:100%; padding-top:0px; padding-bottom:0px; border-bottom:0px;">
                        <tr class="tr_head">
                          <td width="100%" style="padding-top:0px; padding-bottom:0px; border-bottom:0px;"><input type="radio" name="route_div" class="trans" onFocus="javascript:this.blur();">&nbsp;Location</td>
                        </tr>
                      </table>
                      <table width="100%" id="mainTable4">
                        <tr>
                          <td width="100%"><script language="javascript">ComSheetObject("sheet4");</script></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>


    <!-- Button (S) -->
    <table width="100%" class="button">
      <tr>
        <td class="btn2_bg">
          <table border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td>
                <table border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_ok">OK</td>
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


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>