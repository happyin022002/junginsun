<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0154.jsp
*@FileTitle : Space Charter Revenue Missing List
*Open Issues : Lease BSA > 0 & Space Charter Rev = 0 인 항차를 보여준다.
*Change history :
* 2008-06-11 Park Chil Seo
* 2008.06.16 박칠서 N200805276923 S.Cht Rev Missing시 팝업 알림
* 2009.10.23 김기대 New FrameWork 적용
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<title>Space Charter Revenue Missing List</title>
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
<input type="hidden" name="f_chkprd" value="<%=request.getParameter("f_chkprd")%>">
<input type="hidden" name="f_year" value="<%=request.getParameter("f_year")%>">
<input type="hidden" name="f_fm_mon" value="<%=request.getParameter("f_fm_mon")%>">
<input type="hidden" name="f_to_mon" value="<%=request.getParameter("f_to_mon")%>">
<input type="hidden" name="f_fm_wk" value="<%=request.getParameter("f_fm_wk")%>">
<input type="hidden" name="f_to_wk" value="<%=request.getParameter("f_to_wk")%>">

<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Space Charter Revenue Missing List</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table width="100%" border="0"><tr><td height="1"></td></tr></table>

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

