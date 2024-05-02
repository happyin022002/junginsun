<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0035.jsp
*@FileTitle : Agent Commission Agreement Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.13
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.13 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.event.EsmAcm0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0001Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAgreement.AGNCommAgreement");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0001Event)request.getAttribute("Event");
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
<title>Commission Agreement Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
// 공통코드 combo string 추출
<%=JSPUtil.getIBCodeCombo("effDiv", "", "CD03014", 0, "")%>
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


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td>RHQ&nbsp;
                  <select name="rhq_cd_disp" required caption="RHQ" class="input1" style="width:100; display:none;" tabindex="1"></select><input name="rhq_cd" type="text" class="input2" style="width:100; text-align:center;" tabindex="1" readOnly>
                </td>
                <td>Office&nbsp;
                  <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:100;" tabindex="2"></select>
                </td>
                <td>Sub Office&nbsp;
                  <select name="agn_cd" required caption="Sub Office" class="input1" style="width:100;" tabindex="3"></select>
                </td>
                <td align="right">Show Deleted Agreement&nbsp;
                  <input name="delt_flg" type="checkbox" class="trans" value="Y">
                </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <table class="height_10"><tr><td></td></tr></table>


      <!-- biz_2 (S) -->
      <!-- Tab_Layer_1 (S) -->
      <div id="tabLayer" style="display:inline">
        <table class="search">
          <tr>
            <td class="bg" valign="top">
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Agreement List</td>
                </tr>
              </table>
              <!-- Tab_3_Grid_1 (S) -->
              <table width="100%" id="mainTableT1S1">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject("tab3sheet1");</script></td>
                </tr>
              </table>
              <!-- Tab_3_Grid_1 (E) -->

              <table class="height_10"><tr><td></td></tr></table>

              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Agreement Detail</td>
                </tr>
              </table>
              <!-- Tab_3_Grid_1 (S) -->
              <table width="100%" id="mainTableT1S1">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject("tab3sheet2");</script></td>
                </tr>
              </table>
              <!-- Tab_3_Grid_1 (E) -->

              <!-- Tab_3_Button_1 (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn2_bg">
                    <table  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td>
                          <table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="tab3btn_retrieve">Retrieve</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <!-- Tab_3_Button_1 (E) -->

            </td>
          </tr>
        </table>
        
      </div>
      <!-- Tab_Layer_1 (E) -->
      <!-- biz_2 (E) -->




    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>