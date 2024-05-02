<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0101.jsp
*@FileTitle : Agreement Copy From
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 이정수
*@LastVersion : 1.0
* 2012.03.20 이정수
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0101Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAgreementSC.AGNCommAgreement");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0101Event)request.getAttribute("Event");
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
<title>Agreement Copy From</title>
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


<input type="hidden" name="agn_agmt_no">
<input type="hidden" name="opnr_agn_cd" value='<%=JSPUtil.getParameter(request, "agn_cd")%>'>
<input type="hidden" name="delt_flg" value="Y">


<table width="100%"  class="popup" border="0" cellpadding="10" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:495px">
  <tr>
    <td class="top"></td>
  </tr>
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="title"><img src="img/ico_t1.gif" width="20" height="12">Agreement Copy From</td>
        </tr>
      </table>
      <!-- Page Title, Historical (S) -->


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td>
                  <input name="opt" type="radio" class="trans" checked>Direct input&nbsp;
                  <input name="dir_agmt_no" type="text" dataformat="engup" minlength="9" maxlength="9" required caption="Direct input" class="input1" style="width:100;">
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td>
                  <input name="opt" type="radio" class="trans">Agreement Search
                </td>
              </tr>
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td style="padding-left:22px">RHQ&nbsp;
                        <select name="rhq_cd_disp" required caption="RHQ" class="input1" style="width:80; display:none;" tabindex="1"></select><input name="rhq_cd" type="text" class="input2" style="width:80; text-align:center;" tabindex="1" readOnly>
                      </td>
                      <td style="padding-left:22px">Office&nbsp;
                        <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:80px;" tabindex="2"></select>
                      </td>
                      <td style="padding-left:22px">Sub Office&nbsp;
                        <select name="agn_cd" required caption="Sub Office" class="input1" style="width:80px;" tabindex="3"></select>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
                <td>
                  <table class="line_bluedot"><tr><td></td></tr></table>
                  <table class="height_8"><tr><td></td></tr></table>
                </td>
              </tr>
              <tr>
                <td style="width:455px">
                  <!-- Grid_(S) -->
                  <table width="100%" id="mainTable">
                    <tr>
                      <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
                    </tr>
                  </table>
                  <!-- Grid_ (E) -->
                  <!-- Sheet_Button (S) -->
                  <table width="100%" class="button">
                    <tr>
                      <td class="btn2_bg">
                        <table  border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td>
                              <table border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                  <td class="btn2_left"></td>
                                  <td class="btn2" name="btn_retrieve">Retrieve</td>
                                  <td class="btn2_right"></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <!-- Sheet_Button (E) -->
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>


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
                      <td class="btn1" name="btn_select">Select</td>
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