<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_TES_9310.jsp
*@FileTitle :Notice on Old Invoice & CSR Of TES Popup 화면
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : KimYongJin
*@LastVersion : 1.0
* 2010-11-08 KimYongJin
* 1.0 최초 생성
* 2012.03.12 변종건 [CHM-201216765-01] Old invoice/CSR 정보를 제공하는 Pop-up 화면에 list되는 조건 중 경과기간 축소. (90일을 60일로)
=========================================================*/
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.EsdTes9310Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsdTes9310Event  event = null; //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount   = 0;                  //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();

    event = (EsdTes9310Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>Notice on Old Invoice & CSR of TES</title>
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
<!-- 개발자 작업 -->


<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="0" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Notice on Old Invoice & CSR of TES</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="coid" value="imsi">
<input type="hidden" name="inv_ofc_cd" value = "<%= strOfc_cd %>">
<input type="hidden" name="inv_usr_id" value = "<%= strUsr_id %>">

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Old Invoice Data Waiting for Your Handling Over 2 Months</td>
              </tr>
            </table>
        <tr>
          <td class="bg"  style="height:467" valign="top">

            <table width="100%"  id="mainTable">
              <tr>
              <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>

            <table class="height_8"><tr><td colspan="8"></td></tr></table>

            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Old CSR Data Waiting for Your Handling Over 1 Month</td>
              </tr>
            </table>

            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
              </tr>
            </table>
            <table width="100%" class="sbutton" align=center>
				<tr>
					<td height="10" class="popup">
						<table class="sbutton" align=center>
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_close" id="btn_close">Close</td>
											<td class="btn1_right"></td>
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
	
	<!-- : ( Button : Sub ) (S) -->
	
	<!-- : ( Button : Sub ) (E) -->
<!-- 개발자 작업 끝 -->
</form>
</body>
</html>