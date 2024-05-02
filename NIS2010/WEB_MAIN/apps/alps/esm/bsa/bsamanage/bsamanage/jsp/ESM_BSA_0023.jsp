<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_BSA_0023.jsp
* @FileTitle : Add Carriers
* Open Issues :
* Change history :
* @LastModifyDate : 2006-09-18
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2006-09-18 Kim Jong Beom
*  1.0 최초 생성
*=========================================================
* History :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2009.08.01 김기대 ENIS ---> ALPS 변환'
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2011.08.19 최성민 [CHM-201112943-01] Add Carrier Time-Out 에러 수정
*=========================================================--
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
<%@ page import="com.hanjin.apps.alps.esm.bsa.bsamanage.bsamanage.event.EsmBsa0023Event"%>
<%
    String bsa_op_cd = JSPUtil.getNull(request.getParameter("bsa_op_cd"));
    String bsa_op_nm = "";

    if (bsa_op_cd.equals("J")) {
        bsa_op_nm = "Joint Operating";
    } else if (bsa_op_cd.equals("S")) {
        bsa_op_nm = "Space Chartering";
    } else {
        bsa_op_cd = "J";
        bsa_op_nm = "Joint Operating";
    }
%>

<html>
<head>
<title>Add Carriers</title>
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
<input type="hidden" name="bsa_op_cd">
<input type="hidden" name="crr_cd"> 
<input type="hidden" name="backendjob_key">

<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr>
          <td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Add Carriers</td>
        </tr>
      </table>

      <!-- : ( Title ) (E) -->
      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Year ) (S) -->
            <table class="search" border="0" style="width:462;">
              <tr class="h23">
                <td width="15%">Operation :</td>
                <td width="85%"><input type="text" style="width:150" name="bsa_op_nm" readOnly></td>
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

      <!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( Speed ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Speed ) (E) -->

            <!-- : ( Button : Sub ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td><td class="btn2" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td><td class="btn2" name="btn_add" id="btn_add">Add Carrier</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn_save" id="btn_save">Save</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button : Sub ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options : Speed ) (E) -->

    </td>
  </tr>
</table>

<!-- OUTER - POPUP (E)nd -->

<!-- : ( Button : Sub ) (S) -->
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

<script language="javascript">
<!--
    with(document.form) {
        bsa_op_cd.value = "<%=bsa_op_cd%>";
        bsa_op_nm.value = "<%=bsa_op_nm%>";
    }
-->
</script>
