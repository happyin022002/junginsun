<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0161.jsp
*@FileTitle : ESM_BKG_0161
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0161Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    EsmBkg0161Event  event = null;                  //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수
    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";
    String strUsr_id = "";
    String strUsr_nm = "";
    String codeGubun = "";
	String isPop     = "";
    Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");
    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        codeGubun = request.getParameter("codeGubun")==null?"":request.getParameter("codeGubun");
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();
		isPop     = JSPUtil.getParameter(request, "isPop");
        event = (EsmBkg0161Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (null != serverException) {
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
<title>ESM_BKG_0161</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (1 <= errMessage.length) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>
<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="codeGubun" value="<%=codeGubun%>">
<input type="hidden" name="isPop" value="<%=isPop%>">
<table width="100%" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><%="Y".equalsIgnoreCase(isPop) ? " Sort Option" : " &nbsp;Container Loading/Discharging List Sorting Option" %></td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table width="100%"  id="mainTable">
              <tr class="h23">
                <td width="100%">1st Priority</td>
                <td width="100%"><script language="javascript">ComComboObject('select1', 2, 280, 1, 0, 2);</script></td>
              </tr>
              <tr class="h23">
                <td width="100%">2nd Priority</td>
                <td width="100%"><script language="javascript">ComComboObject('select2', 2, 280, 1, 0, 2);</script></td>
              </tr>
              <tr class="h23">
                <td width="100%">3rd Priority</td>
                <td width="100%"><script language="javascript">ComComboObject('select3', 2, 280, 1, 0, 2);</script></td>
              </tr>
              <tr class="h23">
                <td width="100%">4th Priority</td>
                <td width="100%"><script language="javascript">ComComboObject('select4', 2, 280, 1, 0, 2);</script></td>
              </tr>
              <tr class="h23">
                <td width="100%">5th Priority</td>
                <td width="100%"><script language="javascript">ComComboObject('select5', 2, 280, 1, 0, 2);</script></td>
              </tr>
            </table>
            <table width="100%"  id="mainTable" style="display:none">
              <tr><td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- : ( Grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
      <table class="height_5"><tr><td></td></tr></table>
    </td>
  </tr>
</table>



<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_ok">OK</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
                    <td class="btn1_line"></td>
                <td><table width="70" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_close">Close</td>
                    <td class="btn1_right"></td>
                    </tr></table></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
