<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0114.jsp
*@FileTitle : Missing List
*Open Issues :
*Change history :
* 2007-01-15 Kim Jong Beom
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                               //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0114");

    try {
        //추가----------------------------------------------------------------------------------------- START
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //추가----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
        log.error("ESM_COA_0114 Exception : "+e.toString());
    }

    String strType     = JSPUtil.getNull(request.getParameter("f_strtype"));
    if (strType.equals("")) {
        strType = "1";
    }
%>

<html>
<head>
<title>Missing List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_stryear"     value="<%=JSPUtil.getNull(request.getParameter("f_stryear"))%>">
<input type="hidden" name="f_strfmmonth"  value="<%=JSPUtil.getNull(request.getParameter("f_strfmmonth"))%>">
<input type="hidden" name="f_strtomonth"  value="<%=JSPUtil.getNull(request.getParameter("f_strtomonth"))%>">
<input type="hidden" name="f_strfmweek"   value="<%=JSPUtil.getNull(request.getParameter("f_strfmweek"))%>">
<input type="hidden" name="f_strtoweek"   value="<%=JSPUtil.getNull(request.getParameter("f_strtoweek"))%>">
<input type="hidden" name="f_strchkprd"   value="<%=JSPUtil.getNull(request.getParameter("f_strchkprd"))%>">
<input type="hidden" name="f_strtrade"    value="<%=JSPUtil.getNull(request.getParameter("f_strtrade"))%>">
<input type="hidden" name="f_strlane"     value="<%=JSPUtil.getNull(request.getParameter("f_strlane"))%>">
<input type="hidden" name="f_strvessel"   value="<%=JSPUtil.getNull(request.getParameter("f_strvessel"))%>">
<input type="hidden" name="f_strvoyage"   value="<%=JSPUtil.getNull(request.getParameter("f_strvoyage"))%>">
<input type="hidden" name="f_strdir"      value="<%=JSPUtil.getNull(request.getParameter("f_strdir"))%>">
<input type="hidden" name="f_strtype"     value="<%=strType%>">
<input type="hidden" name="f_strprcnm"    value="<%=JSPUtil.getNull(request.getParameter("f_strprcnm"))%>">

<!-- OUTER - POPUP (S)tart -->
<table width="900" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Missing List</td></tr>
      </table>
      <!-- : ( Title ) (E) -->


      <!--Button_L (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td>
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
      <!--Button_L (E) -->


      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr class="h23">
                <td width="8%">Cost Item</td>
                <td width="30%">&nbsp;<script language="javascript">ComComboObject('f_cobcost',1, 180 , 0 )</script></td>
                <td><input type="checkbox" name="f_chk_bsazrflg" value="N" checked="true" class="trans">&nbsp;Exclusion BSA Flag</td>
              </tr>
            </table>

            <table class="line_bluedot"><tr><td></td></tr></table>

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


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
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

<script language="javascript">
<!--
    with(document.form) {
        if (f_strtype.value == "2") { //두번째 TAB
            f_cobcost.value = "54400000";  //'54400000' Space Charterage 만 선택가능
            f_cobcost.disabled = true;
        }
        if (f_strtype.value == "3") { //HJS SalesSlot Cht-out Missing 일때
            f_cobcost.disabled = true;
        }   }
-->
</script>
