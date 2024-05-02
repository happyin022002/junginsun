<%
/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_MAS_0175.jsp
* @FileTitle : Re-Assignment by Bound(OP4)
* Open Issues :
* Change history :
* @LastModifyDate : 2009-09-21
* @LastModifier : IM OKYOUNG
* @LastVersion : 1.0
*   2009-09-21 IM OKYOUNG
*  1.0 최초 생성
 * =========================================================
 * History
 * 2009-09-24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
 * 2010-01-07 김기식 Alps FrameWork 적용
 * 2010.12.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
 * 2011.02.21 김상수 [CHM-201108827-01] * 멀티콤보및 html엘리먼트들의 입력규칙주가 보완
 * 2011.09.15 최성민 [CHM-201113373-01] AES Trade VSL Pool노선의 OP1 및 OP4 산출 로직 변경
 * =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<html>
<head>
<title>Re-Assignment by Bound</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        var formObj = document.form;
        loadPage();
    }
</script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden" id="frmHidden"></iframe>

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- 개발자 작업    -->

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


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
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Create" name="btn_Create">Create</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td>
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


      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search_in" border="0">
              <tr class="h23">
                <td colspan="8"><script language="javascript">masPeriod1();</script></td>
              </tr>
              <tr><td class="line_bluedot" colspan="8"></td></tr>
              <tr class="h23">
                <td width="45" style="text-indent:7;">Trade</td>
                <td width="170">
                    <script language="javascript">ComComboObject('f_trd_cd',1, 100, 0)</script>
                </td>
                <td width="35">Lane</td>
                <td width="180">
                    <script language="javascript">ComComboObject('f_rlane_cd',1, 100, 0)</script>
                </td>
                <td width="30">Group</td>
                <td width="170">
                	<script language="javascript">ComComboObject('f_op_lane_tp_cd',1, 120, 0)</script>
                   <!--  <SELECT name="f_op_lane_tp_cd">
                        <OPTION value="">All</OPTION>
                        <OPTION value="T">Vessel Pool</OPTION>
                        <OPTION value="S">Sub Trade Avg U/C</OPTION>
                        <OPTION value="L">Lane Avg U/C</OPTION>
                    </SELECT> -->
                </td>
                <td width="30">VVD</td>
                <td>
                  <input type="text" name="f_vsl_cd" style="width:70;text-align:center;ime-mode:disabled;" maxlength="4" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_skd_voy_no');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                  <input type="text" name="f_skd_voy_no" style="width:70;text-align:center;ime-mode:disabled;" maxlength="4" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_dir_cd');" onkeyPress="ComKeyOnlyNumber(window);" onFocus="this.select();">
                  <input type="text" name="f_dir_cd" style="width:30;text-align:center;ime-mode:disabled;" maxlength="1" onClick="ComAddSeparator(this);" onKeyUp="ComKeyEnter('f_year');" onKeyPress="ComKeyOnlyAlphabet('upper');" onFocus="this.select();" onBlur="upper(this);">
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Fixed Costs Summary</td>
              </tr>
              <tr>
                <td class="height_5" colspan="2"></td>
              </tr>
            </table>

            <!-- : ( POR ) (S) -->
            <table width="100%">
              <tr>
                <td width="100%">
                  <table width="100%" id="mainTable">
                    <tr>
                      <td><script language="javascript">ComSheetObject('sheet1');</script></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( POR ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->
    </td>
  </tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>

<script language="javascript">
<!--
    with(document.form) {
        //초기값 샛팅
        //if (txtYear.value == "") { txtYear.value = getCurrDate("-").substring(0,4); } /* 현재년  */
        //if (txtSMonth.value == "") { txtSMonth.value = '01'; }
        //if (txtEMonth.value == "") { txtEMonth.value = '12'; }
        //if (txtSWeek.value == "") { txtSWeek.value = '00'; }
        //if (txtEWeek.value == "") { txtEWeek.value = '53'; }
        //setPeriod(txtEWeek);
    }
-->
</script>


