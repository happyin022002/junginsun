<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EES_BOOK_0254.jsp
 *@FileTitle : Container Seal Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.08.17
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2011.08.17 김상수
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.08.17 김상수 [CHM-201112813-01] ALPS MNR-Seal management-Inquiry (신규화면 개발)
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0254Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EesMnr0254Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

    event = (EesMnr0254Event) request.getAttribute("Event");
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
<title>Welcome to alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body onLoad="setupPage();">
<div id="debug"></div>
<form name="form">
<input type="hidden" name="f_cmd">


<!-- 개발자 작업  -->
<input type="hidden" name="rgn_cd">
<input type="hidden" name="rgn_cd_d">
<input type="hidden" name="mnr_ofc_cd_d">
<input type="hidden" name="back_end_job_key1">
<input type="hidden" name="back_end_job_key2">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
  <tr>
    <td valign="top">

    <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0"
          class="title">
          <tr>
            <td class="history"><img src="img/icon_history_dot.gif"
              align="absmiddle"><span id="navigation"></span></td>
          </tr>
          <tr>
            <td class="title"><img src="img/icon_title_dot.gif"
              align="absmiddle"><span id="title"></span></td>
          </tr>
        </table>
    <!--Page Title, Historical (E)--> <!-- : ( Search Options ) (S) -->

      <!--biz page (S)-->
      <table class="search" id="mainTable">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr class="h23">
                <td>Plan Year&nbsp;
                  <input type="text" maxlength="4" style="width:40;text-align:center;ime-mode:disabled;" class="input1" name="fr_yy" onKeyPress="javascript:ComKeyOnlyNumber(this);" value="<%=JSPUtil.getKST("yyyy")%>" required fullfill caption="Plan Year">
                  <img name ="btn_fr_yy" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                  <select class="input" name="fr_mm" style="width:60;">
                    <option value="01" selected>All</option>
                    <option value="01">1 Half</option>
                    <option value="07">2 Half</option>
                  </select>
                  ~
                  <input type="text" maxlength="4" style="width:40;text-align:center;ime-mode:disabled;" class="input1" name="to_yy" onKeyPress="javascript:ComKeyOnlyNumber(this);" value="<%=JSPUtil.getKST("yyyy")%>" required fullfill caption="Plan Year">
                  <img name ="btn_to_yy" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                  <select class="input" name="to_mm" style="width:60;">
                    <option value="12" selected>All</option>
                    <option value="06">1 Half</option>
                    <option value="12">2 Half</option>
                  </select></td>
                <td>Kind of Seal&nbsp;
                  <select class="input" name="seal_knd_nm" style="width:120;">
                    <option value="" selected>All</option>
                    <option value="S">High Security</option>
                    <option value="G">General</option>
                    <option value="B">Barrier</option>
                    <option value="P">Plastic</option>
                  </select>
                </td>
                <td>Office&nbsp;
                  <script language="javascript">ComComboObject("ofc_cd", 2, 120, 0, 0, "", 0, "");</script></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td></td></tr></table>

      <table class="search" border="0">
        <tr class="h23">
          <td align="right">Out of Range&nbsp;
            <input type="text" maxlength="4" style="width:90;text-align:center;" class="input" name="out_qty" readOnly="true">&nbsp;&nbsp;</td>
        </tr>
      </table>


       <!-- Grid BG Box (S) -->
       <table class="search" border="0">
         <tr>
           <td class="bg">
             <table width="100%" id="mainTable">
               <tr>
                 <td>
                   <!-- Grid-1 (S) -->
                   <script language="javascript">ComSheetObject("sheet1");</script>
                   <!-- Grid-1 (E) -->
                 </td>
               </tr>
             </table>
           </td>
         </tr>
       </table>
       <!-- Grid BG Box (E) -->

    <!--biz page (E)-->

    <!--Button (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5; padding-bottom:10;">
          <tr>
            <td class="btn1_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                      </tr>
                    </table></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_New">New</td>
                        <td class="btn1_right"></td>
                      </tr>
                    </table></td>
                  <td class="btn1_line"></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
                        <td class="btn1_right"></td>
                      </tr>
                    </table></td>
                </tr>
              </table>
            </td>
          </tr>
        </table>
    <!--Button (E) -->

    </td>
  </tr>
</table>
<!-- 개발자 작업  끝 -->


</form>
</body>
</html>