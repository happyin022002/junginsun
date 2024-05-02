<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BSA_0044.jsp
*@FileTitle : BSA Creation/Update(Yearly Plan) Creation Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.31
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.01.31 이행지
* 1.0 Creation
*=========================================================
* History :
* 2011.01.31 이행지 [CHM-201108497-01] 사업계획 노출 방지를 위한 사업계획용 메뉴 추가 개발
=========================================================*/
%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap" %> 
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsayearlyplan.bsayearlyplan.event.EsmBsa0044Event"%>
<%@ page import="com.hanjin.apps.alps.esm.bsa.common.vo.CommonBsaRsVO"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 

<%
    //DBRowSet rowSet = null;
    DBRowSet[] rowSet = new DBRowSet[2];
    EsmBsa0044Event event = null;
    Exception serverException = null;
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.bsa.ESM_BSA_0044");
    String strErrMsg = "";

    String prevWeek = "";
    String userId   = "";
    String userName = "";
    String cobTrade = "";
    String cobLane  = "";
    String cobDir  = "";
    String xml = "";

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    	userId = account.getUsr_id();
    	userName = account.getUsr_nm();


        event = (EsmBsa0044Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
        cobTrade = JSPUtil.getNull(request.getParameter("cobTrade"));
        cobLane  = JSPUtil.getNull(request.getParameter("cobLane"));
        cobDir  = JSPUtil.getNull(request.getParameter("cobDir"));

        xml = HttpUtil.makeXML(request,response); 
        xml = xml.replaceAll("\"", "'");
        
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>

<html>
<head>
<title>Inquire/Edit BSA Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
        
        var formObj = document.form;
    }
</script>
</head>

<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onSubmit="return false;" onKeyDown="keyEnter_loc();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="param1"> <!-- Gubun   |  Method Name  -->
<input type="hidden" name="param2"> <!-- Year    |  vsl_cd       -->
<input type="hidden" name="param3"> <!--         |  skd_voy_no   -->
<input type="hidden" name="param4"> <!--         |  dir_cd       -->
<input type="hidden" name="param5"> <!-- sMonth  |               -->
<input type="hidden" name="param6"> <!-- eMonth  |               -->
<input type="hidden" name="param7"> <!-- sWeek   |               -->
<input type="hidden" name="param8"> <!-- eWeek   |               -->
<input type="hidden" name="trade"      value="<%=cobTrade%>"> 
<input type="hidden" name="lane"       value="<%=cobLane%>"> 
<input type="hidden" name="dir"        value="<%=cobDir%>"> 
<input type="hidden" name="sXml"          value="<%=xml%>"> 


<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; BSA Creation ALL</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Grid ) (S) -->
            <table class="search" width="600">
              <tr class="h23" width="500">
                <td>
                  <table border='0'>
                    <tr class='h23'>
                      <td width='60'>
                        <div id='div_wm' style='display:inline;border:solid 0;'>&nbsp;Week
                        </div>
                      </td>
                      <td width='25' class='sm'>Year</td>
                      <td width='60'><input type='text' style='width:40;text-align:center;' class='input1' name='txtYear' maxlength='4' onKeyPress='ComKeyOnlyNumber(window);' onKeyUp="ComKeyEnter('LengthNextFocus');" onChange="setPeriod(this);"></td>
                      <td class='sm'>
                        <div id='div_week' style='display:inline;border:solid 0;width:130;height:16'>
                          Week&nbsp;
                          <input type='text' style='width:30;text-align:center;' class='input1' name='txtFmWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur="fillSpace(this, 2, '0', 'left');" onKeyUp='moveTab(this, txtToWeek);'  onChange="fillSpace(this, 2, '0', 'left');setPeriod(this);" >&nbsp;&nbsp;~&nbsp;
                          <input type='text' style='width:30;text-align:center;' class='input1' name='txtToWeek' maxlength='2' onKeyPress='ComKeyOnlyNumber(window);' onBlur="fillSpace(this, 2, '0', 'left');" onChange="fillSpace(this, 2, '0', 'left');setPeriod(this);">
                        </div>
                      </td>
                      <td class='sm'><div id='div_period'></div></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <table class="search" border="0">
              <tr><td class="line_bluedot"></td></tr>
            </table>
            <table class="search" border="0">
              <tr class="h23">
                <td width="55" style="text-indent:7;">Trade</td>
                <td width="100"><script language="javascript">ComComboObject('cobTrade', 1, 70 , 0, 1)</script></td>
                <td width="40">Lane</td>
                <td width="100"><div id="div_rLane"><script language="javascript">ComComboObject('cobLane', 1, 80 , 0, 1)</script></div></td>
                <td width="30">Dir.</td>
                <td width="100"><script language="javascript">ComComboObject('cobDir', 1, 70 , 0 )</script></td>
                <td width="30">IOC</td>
                <td><script language="javascript">ComComboObject('cobIOC', 1, 80 , 0 )</script></td>
              </tr>
            </table>
            <div id="tabLayer" style="display:none">
              <table width="100%" id="mainTable">
                <tr>
                  <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                </tr>
              </table>
            </div>
            <!-- : ( Grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->

<table class="height_10"><tr><td></td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton" >
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
	                  <td class="btn1" name="btn_Creation" id="btn_Creation">Creation</td>
	                  <td class="btn1_right"></td>
	                </tr>
	              </table>
	            </td>
		        <td>
		          <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
		            <tr>
		              <td class="btn1_left"></td>
		              <td class="btn1" name="btn_Close" id="btn_Close">Close</td>
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
 <!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
