<%
/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BOOK_0067.jsp
 *@FileTitle : B/L Turn Report
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.13
 *@LastModifier : 김경섭
 *@LastVersion : 1.0
 * 2009.05.13 김경섭
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 : B/L Turn Time Report (ESM_BKG_0067) Summary Sheet추가 및 로직 변경
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0067Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  EsmBkg0067Event event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null; //서버에서 발생한 에러
  String strErrMsg = ""; //에러메세지
  int rowCount = 0; //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  boolean bBtn_Disabled = true;
  Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CndManifestListDownload");

  try {
    SignOnUserAccount account = (SignOnUserAccount) session
        .getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();

    event = (EsmBkg0067Event) request.getAttribute("Event");
    serverException = (Exception) request
        .getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException)
          .loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request
        .getAttribute("EventResponse");

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
<input type="hidden" name="bkg_ofc_cd_d">
<input type="hidden" name="usr_ofc_cd" value=<%=strOfc_cd%>>
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
    <table class="search">
         <tr><td class="bg">

					<!-- td width="70">Doc OFC</td>
					<td width="100"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 100, '');</script></td-->
        <!--  biz_1 (S) -->
        <table class="search" border="0" style="width:900;">
          <tr class="h23">
          	<td width="60" align="left">&nbsp;Doc OFC</td>
			<td width="100"><script language="javascript">ComComboObject('dpcs_ofc_cd', 1, 100, '');</script></td>
            <td width="90"  align="right"><input name="divide" type="radio" class="trans" align="absmiddle" value="PRD" checked>Period&nbsp;&nbsp;</td>
            <td colspan="4" style="padding-left:2px;"><table border="0">
                <tr class="h23">
                  <td style="background-color: #E9E9E9; border:1px solid #A3A4C7; padding:3px 30px 3px 3px;">
                    <select class="input" style="width:100;" name="period">
                      <option value="CPT" selected>Complete</option>
                      <option value="WRK">Working</option>
                      <option value="OTH">Other</option>
                    </select>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="text" style="width:85" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" class="input1" name="from_dt" maxlength="10" dataformat="ymd">&nbsp;~
                    <input type="text" style="width:85" value="<%=JSPUtil.getKST("yyyy-MM-dd") %>" class="input1" name="to_dt"  maxlength="10" dataformat="ymd">
                    <img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Period"></td>
                </tr>
              </table></td>
            
            <td><input name="divide" type="radio" class="trans" align="absmiddle" value="BKG">BKG No.</td>
            <td width="150"><input type="text" style="width:100;ime-mode:disabled" name="bkg_no" maxlength="13" dataformat="engupnum"></td>
            <td width="40">&nbsp;</td>
          </tr>
          <tr><td height="5"></td></tr>
          <tr class="h23">
          
            <td align="left">&nbsp;Region</td>
            <td style="padding-left:2px;"><script language="javascript">ComComboObject("rgnCdCombo", 2, 100, 1, 0, 1);</script></td>
            
            <td align="right">BKG Ofc.&nbsp;</td>
            <td><input type="text" style="width:70;ime-mode:disabled" name="bkg_ofc_cd" maxlength="6" dataformat="engup"></td>
            
            <td width="140" align="right">VVD&nbsp;&nbsp;<input type="text" style="width:90;ime-mode:disabled" name="vvd_cd" maxlength="9" dataformat="engupnum"></td>
            <td align="right">POL&nbsp;</td>
            <td><input type="text" style="width:90;ime-mode:disabled" name="pol_cd" maxlength="5" dataformat="engupnum"></td>
            <td align="right">POD&nbsp;</td>
            <td><input type="text" style="width:90;ime-mode:disabled" name="pod_cd" maxlength="5" dataformat="engupnum"></td>
          </tr>
        </table>
        <!--  biz_1 (E) -->

        </td>
      </tr>
    </table>

      <table class="height_8"><tr><td></td></tr></table>

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

               <tr>
                 <td>
                   <!-- Grid_button-1 (S) -->
                   <table width="100%" class="button">
                     <tr>
                       <td class="btn1_bg">
                         <table border="0" cellpadding="0" cellspacing="0">
                           <tr>
                             <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                                 <tr>
                                   <td class="btn2_left"></td>
                                   <td class="btn2" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
                                   <td class="btn2_right"></td>
                                 </tr>
                               </table></td>
                             <td class="btn1_line"></td>
                             <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                                 <tr>
                                   <td class="btn2_left"></td>
                                   <td class="btn2" name="btn_DownExcelSummary">Down&nbsp;Excel</td>
                                   <td class="btn2_right"></td>
                                 </tr>
                               </table></td>
                           </tr>
                         </table>
                       </td>
                     </tr>
                   </table>
                   <!-- Grid_button-1 (E) -->
                 </td>
               </tr>

               <tr><td>&nbsp;</td></tr>

               <tr>
                 <td>
                   <!-- Grid-2 (S) -->
                   <script language="javascript">ComSheetObject("sheet2");</script>
                   <!-- Grid-2 (E) -->
                 </td>
               </tr>

               <tr>
                 <td>
                   <!-- Grid_button-2 (S) -->
                   <table width="100%" class="button">
                     <tr>
                       <td class="btn1_bg">
                         <table  border="0" cellpadding="0" cellspacing="0">
                           <tr>
                             <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                                 <tr>
                                   <td class="btn2_left"></td>
                                   <td class="btn2" name="btn_Retrieve_Detail">Retrieve</td>
                                   <td class="btn2_right"></td>
                                 </tr>
                               </table></td>
                             <td class="btn1_line"></td>
                             <td><table border="0" cellpadding="0" cellspacing="0" class="button">
                                 <tr>
                                   <td class="btn2_left"></td>
                                   <td class="btn2" name="btn_DownExcelDetail">Down&nbsp;Excel</td>
                                   <td class="btn2_right"></td>
                                 </tr>
                               </table></td>
                           </tr>
                         </table>
                       </td>
                     </tr>
                   </table>
                   <!-- Grid_button-2 (E) -->
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
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_New">New</td>
                        <td class="btn1_right"></td>
                      </tr>
                    </table>
                  </td>
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