<%
/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SPC_0048.jsp
*@FileTitle : WAF Allocation
*Open Issues :
*Change history :
*@LastModifyDate : 2011.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2011.07.26 이행지
* 1.0 Creation
=========================================================
* History
* 2011.08.11 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAF 노선에 대한 Allocation 팝업 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0048Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmSpc0048Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                      //에러메세지
    int rowCount     = 0;                       //DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id        = "";
    String strUsr_nm        = "";
    Logger log = Logger.getLogger("com.hanjin.apps.spaceallocationmanage.spaceallocationmanage");

    String year       = "";
    String week       = "";
    String trade      = "";
    String subtrade   = "";
    String lane       = "";
    String bound      = "";
    String vvd        = "";
    String vsl_cd     = "";
    String skd_voy_no = "";
    String skd_dir_cd = "";

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        event = (EsmSpc0048Event)request.getAttribute("Event");
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }

        // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
        GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


        year       = JSPUtil.getParameter(request, "year",     "");
        week       = JSPUtil.getParameter(request, "week",     "");        
        trade      = JSPUtil.getParameter(request, "trade",    "");
        subtrade   = JSPUtil.getParameter(request, "subtrade", "");
        lane       = JSPUtil.getParameter(request, "lane",     "");
        bound      = JSPUtil.getParameter(request, "bound",    "");
        vvd        = JSPUtil.getParameter(request, "vvd",      "");
        vsl_cd     = vvd.substring(0,4);
        skd_voy_no = vvd.substring(4,8);
        skd_dir_cd = vvd.substring(8);
        
    }catch(Exception e) {
        out.println(e.toString());
    }
%>
<html>
<head>
<title>WAF Allocation</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="year"     value="<%= year %>">
<input type="hidden" name="week"     value="<%= week %>">
<input type="hidden" name="trade"    value="<%= trade %>">
<input type="hidden" name="subtrade" value="<%= subtrade %>">
<input type="hidden" name="lane"     value="<%= lane %>">
<input type="hidden" name="bound"    value="<%= bound %>">
<input type="hidden" name="vvd"      value="<%= vvd %>">
<input type="hidden" name="vsl_cd"      value="<%= vsl_cd %>">
<input type="hidden" name="skd_voy_no"  value="<%= skd_voy_no %>">
<input type="hidden" name="skd_dir_cd"  value="<%= skd_dir_cd %>">

<!-- 개발자 작업 -->

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;WAF Allocation</td>
        </tr>
      </table>
      <!-- : ( Title ) (E) -->
      
      <!-- TABLE '#D' : ( Button : Main ) (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr><td class="btn1_bg">
          <table border="0" cellpadding="0" cellspacing="0">
            <tr>
              <!-- Repeat Pattern -->
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                  <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_close" id="btn_close">Close</td>
                    <td class="btn1_right"></td>
                  </tr></table>
              </td>
              <!-- Repeat Pattern -->
            </tr>
          </table>
        </td></tr>
      </table>
      <!-- TABLE '#D' : ( Button : Main ) (E) -->
      <table style="width:100%;" class="search">
        <tr><td class="bg">
            <table border="0">
              <tr><td>
                  <table border="0">          
		          <tr class="h23">
		            <td width="45"><img class="nostar">Trade</td>
		            <td width="80"><input type="input" class="input2" name="trd_cd" size="3" maxlength="3" style="ime-mode:disabled;" value="<%= trade %>"></td>
		            <td width="75"><img class="nostar">Sub Trade</td>
		            <td width="70"><input type="input" class="input2" name="sub_trd_cd" size="2" maxlength="2" style="ime-mode:disabled;" value="<%= subtrade %>"></td>
		            <td width="50"><img class="nostar">Lane</td>
		            <td width="110"><input type="input" class="input2" name="ralne_cd" size="5" maxlength="5" style="ime-mode:disabled;" value="<%= lane %>"></td>
		            <td width="60"><img class="nostar">Bound</td>
		            <td width="50"><input type="input" class="input2" name="dir_cd" size="1" maxlength="1" style="ime-mode:disabled;" value="<%= bound %>"></td>
		          </tr>
                  </table>
              </td></tr>
              <tr><td>
                  <table border="0">
		          <tr class="h23">
		            <td width="45"><img class="nostar">Week</td>
		            <td width="80"><input type="text" class="input2"  name="yrwk" size="8" maxlength="8" style="ime-mode:disabled;" value="<%= year + week %>"></td>
		            <td width="75"></td>
		            <td width="70"></td>
		            <td width="50"><img class="nostar">VVD</td>
		            <td width="110"><input type="input" class="input2" name="vvd" size="12" maxlength="9" style="ime-mode:disabled;" value="<%= vvd %>"></td>
		            <td width="40"></td>
		            <td width="50"></td>
		          </tr>
                  </table>
              </td></tr>
            </table>
        </td></tr>
      </table>
      <table class="height_10"><tr><td></td></tr></table>
      <!-- TABLE '#D' : ( Search Options ) (S) -->

     <table class="height_5"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table>
              <tr class="h23">
                <td align="left" nowrap width="100"> Data Selection</td>
                <td align="left" nowrap>
                  <input type="checkbox" value="" class="trans" name="chkHC" id="chkHC" disabled><label for="chkHC">HC</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" value="" class="trans" name="chk45" id="chk45" disabled><label for="chk45">45'</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" value="" class="trans" name="chk53" id="chk53" disabled><label for="chk53">53'</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" value="" class="trans" name="chkRFR" id="chkRFR" disabled><label for="chkRFR">Reefer</label>&nbsp;&nbsp;&nbsp;
                  <input type="checkbox" value="" class="trans" name="chkWGT" id="chkWGT" disabled><label for="chkWGT">Weight</label>
                </td>
              </tr>
            </table>
            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!--  Button_Sub (S) -->
            <table width="100%" class="button"> 
              <tr><td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <td width="">
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btng_rowadd">Row add</td>
                            <td class="btn2_right"></td>
                        </tr></table></td>
                    <td width="">
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn2_left"></td>
                            <td class="btn2" name="btng_rowdel">Row Delete</td>
                            <td class="btn2_right"></td>
                        </tr>
                      </table></td>
                  </table>
              </td></tr>
            </table>
            <!-- Button_Sub (E) -->

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
<!-- <table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern ->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_save" id="btn_save">Save</td>
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
                <!-- Repeat Pattern ->
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table> -->
<!-- : ( Button : Sub ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>