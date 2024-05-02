<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0411.jsp
*@FileTitle : Detail Form
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.08.17 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0411Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0411Event  event = null;         //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;    //서버에서 발생한 에러
	String strErrMsg = "";                 //에러메세지
	int rowCount	 = 0;                    //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.hanjin.apps.EquipmentMovementMgt.ContainerMovementFinder");
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

	try {
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesCtm0411Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

  // 현재날짜
  String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
  // 6개월 이전날짜
  String strStartdate = DateTime.addMonths(strEnddate, -6, "yyyy-MM-dd");

  String cntrNo = (request.getParameter("cntrNo") == null)? "": request.getParameter("cntrNo");
  String checkDigit = (request.getParameter("checkDigit") == null)? "": request.getParameter("checkDigit");
  String typeSize = (request.getParameter("typeSize") == null)? "": request.getParameter("typeSize");

  // pop_mode
  String popMode = (request.getParameter("pop_mode") == null)? "N": "Y";
%>
<html>
<head>
<title>Detail Form</title>
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
<!-- 개발자 작업	-->


<% if (popMode.equals("Y")) { %>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Detail Form Inquiry</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

<% } else { %>

<body onLoad="setupPage();">
<form name="form">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->

<% } %>

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="user_id" value="<%=account.getUsr_id()%>">
<input type="hidden" name="ofc_cd" value="<%=account.getOfc_cd()%>">
<input type="hidden" name="cnt_cd">

      <!--biz page (S)-->
      <table class="search">
        <tr>
          <td class="bg">

            <!--  biz_1  (S) -->
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="90">Container No.</td>
                <td width="220"><input type="text" style="width:85;" class="input1" value="<%=cntrNo %>" name="p_cntrno"  maxlength="10" tabindex="1">&nbsp;<input type="text" style="width:20;" class="input" value="<%=checkDigit %>" maxlength="1" name="check_digit">&nbsp;<input type="text" style="width:25;" class="input" readonly value="<%=typeSize %>" name="ctnr_tpsz_cd"></td>
                <td width="60">Duration</td>
                <td><input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=strStartdate%>"  tabindex="4" name="p_date1">&nbsp;~&nbsp;
                  <input type="text" style="width:80;ime-mode:disabled;" class="input1" value="<%=strEnddate%>" tabindex="5" name="p_date2">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar2"></td>
              </tr>
            </table>
            <!--  biz_1   (E) -->

          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td colspan="8"></td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" style="height:465" valign="top">

            <!--  biz_2  (S) -->
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">VVD/BKG History</td>
              </tr>
            </table>

            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->

            <!--  biz_2   (E) -->
            <table class="line_bluedot"><tr><td colspan="8"></td></tr></table>

            <!--  biz_3  (S) -->
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Movement History</td>
              </tr>
            </table>

            <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject('sheet2');</script></td>
              </tr>
            </table>
            <!-- Grid (E) -->
            <!--  biz_3  (E) -->

          </td>
        </tr>
      </table>
      <!--biz page (E)-->


      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
        <tr>
          <td class="btn1_bg"><table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_eachbkg">Each&nbsp;BKG</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_del">DEL&nbsp;History</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_clm">CLM</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table></td>
                <td class="btn1_line"></td>
                  <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                      <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_print">Print</td>
                        <td class="btn1_right"></td>
                      </tr>
                    </table></td>
                </tr>
              </table></td>
          </tr>
        </table>
      <!--Button (E) -->

    </td>
  </tr>
</table>

<% if (popMode.equals("Y")) { %>

      <table class="height_5"><tr><td></td></tr></table>
      <!-- : ( Button : pop ) (S) -->
      <table width="100%" class="sbutton">
        <tr>
          <td height="71" class="popup"><table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
              <tr>
                <td class="btn3_bg"><table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <td width="72"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn1_left"></td>
                            <td class="btn1" name="btn_close">Close</td>
                            <td class="btn1_right"></td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <!-- : ( Button : pop ) (E) -->

<% } %>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>