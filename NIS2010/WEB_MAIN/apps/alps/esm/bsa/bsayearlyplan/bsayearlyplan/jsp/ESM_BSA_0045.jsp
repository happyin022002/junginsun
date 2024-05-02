<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName       : ESM_BSA_0045.jsp
* @FileTitle      : BSA Data I/F Popup
* Open Issues     :
* Change history  :
* @LastModifyDate : 2011.04.04
* @LastModifier   : 최윤성
* @LastVersion    : 1.0
*  2011.04.04 
*  1.0 최초 생성
*=========================================================
* History :
* 2011.04.04 최윤성 [CHM-201109932-01] BSA Yearly PLan 메뉴에 Live Data I/F 기능 추가 
*=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0045Event"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    EsmBsa0045Event event = null;
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0045");
    String strErrMsg = "";
    
    String userId    = "";
    String userName  = "";
    String cobTrade  = "";
    String cobLane   = "";
    String opCd      = "";
    String ctrtprice = "";
    String xml       = "";

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	userId = account.getUsr_id();
    	userName = account.getUsr_nm();
    	
        event = (EsmBsa0045Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
    	cobTrade  = JSPUtil.getNull(request.getParameter("cobTrade"));
        cobLane   = JSPUtil.getNull(request.getParameter("cobLane"));
        opCd      = JSPUtil.getNull(request.getParameter("opCd"));
        ctrtprice = JSPUtil.getNull(request.getParameter("ctrtprice"));
        
        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>BSA Data I/F</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="trade"     value="<%=cobTrade%>"> 
<input type="hidden" name="lane"      value="<%=cobLane%>">
<input type="hidden" name="opcd"      value="<%=opCd%>"> 
<input type="hidden" name="ctrtprice" value="<%=ctrtprice%>">  
<input type="hidden" name="sXml"      value="<%=xml%>">

<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;BSA Data I/F</td>
        </tr>
      </table>

      <!-- : ( Title ) (E) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td width="120">Duration</td>
                <td>
                	<input class="input1" type="text" name="txtSDate" style="width:75;text-align:center;" maxlength="8"
                	       onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
                           onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-');this.select();" value="">
	                <img name="btns_calendar1" src="/hanjin/img/button/btns_calendar.gif" class="cursor" width="19" height="20" border="0" align="absmiddle">
	                &nbsp;~&nbsp;
	                <input class="input1" type="text" name="txtEDate" style="width:75;text-align:center;" maxlength="8"
	                       onKeyPress="ComKeyOnlyNumber(this, '-');"   onKeyUp="ComKeyEnter('LengthNextFocus');"
	                       onBlur="this.value = ComGetMaskedValue(this.value, 'ymd');" onFocus="ComClearSeparator(this,'ymd','-'); this.select();" value="" >
	                <img name="btns_calendar2" src="/hanjin/img/button/btns_calendar.gif" class="cursor" width="19" height="20" border="0" align="absmiddle">
                </td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10">
        <tr><td></td></tr>
      </table>
      
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td width="80">Trade</td>
                <td width="120"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0 )</script></td>
                <td width="70">Lane</td>
                <td><script language="javascript">ComComboObject('cobLane', 1, 70 , 0 )</script></td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search" style="display:none">
        <tr>
          <td class="bg">
            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Speed ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

    </td>
  </tr>
</table>

<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
<table width="400" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_confirm" id="_confirm">Confirm</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close" id="btn_close">Close</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <!-- Repeat Pattern -->
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>
</body>
</html>