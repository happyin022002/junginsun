<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CTM_0451.jsp
*@FileTitle : Release/Re-delivery Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.08.16 김상수
* 1.0 Creation
* 2011.09.15 나상보[CHM-201113087] Empty Release/Redelivery Order EDI 전송 신규 추가
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.config.SiteConfigFactory"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList = "";
  String pageRows = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.EmptyReleaseRedeliveryOrderMgt.EmptyReleaseRedeliveryOrderMgt");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();

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
<title>Release/Re-delivery Order</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<!-- 개발자 작업 -->


<input type="hidden" name="unload_flag" value="reset">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="580" border="0">
        <tr><td class="title"><img src="/hanjin/img/alps/ico_t1.gif" width="20" height="12">Release/Redelivery Order</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg_b1">

            <table class="height_10"><tr><td></td></tr></table>

            <!-- : ( Seq. ) (S) -->
            <table border="1" class="grid" width="737"  height="540" ><!-- height="400" -->
              <tr>
                <td><script language='javascript'>comRdObject('rd');</script></td>
              </tr>
            </table>
            <!-- : ( Seq. ) (E) -->

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

            <!-- : ( Button : Sub ) (S) -->
            <table class="search" style="width:100%;">
              <tr class="h23">
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                      <td class="btn2" name="btn_print">Print Only</td>
                      <td class="btn2_right"></td>
                    </tr>
                  </table></td>
                <td width="180"></td>
                <td>Status</td>
                <td class="stm">
                  <select style="width:80;" class="input" name="issue_flag">
                    <option value="R" selected>Resend</option>
                    <option value="O">Correction</option>
                    <option value="C">Cancel</option>
                  </select>&nbsp;&nbsp;
                <td><input type="radio" class="trans" name="issue_type" value="P" checked>Printer&nbsp;&nbsp;
                  <input type="radio" class="trans" name="issue_type" value="F">Fax&nbsp;&nbsp;
                  <input type="radio" class="trans" name="issue_type" value="E">E-mail&nbsp;&nbsp;
                  <!-- EDI 전송 라디오 버튼 Ticket No :CHM-201113087-->
                  <input type="radio" class="trans" name="issue_type" value="D">EDI</td>
                  
                <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn2_left"></td>
                      <td class="btn2" name="btn_confirm">Confirm</td>
                      <td class="btn2_right"></td>
                    </tr>
                  </table></td>
              </tr>
            </table>
            <!-- : ( Button : Sub ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->
  
<table class="height_5"><tr><td></td></tr></table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" border="0" align="center" class="sbutton">
<tr><td height="71" class="popup" width="100%">
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td width="100%" >
		    <table border="0" cellpadding="0" cellspacing="0" align=center>
		    <tr><td align="center"><table  border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>

<!-- OUTER - POPUP (E)nd -->


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>