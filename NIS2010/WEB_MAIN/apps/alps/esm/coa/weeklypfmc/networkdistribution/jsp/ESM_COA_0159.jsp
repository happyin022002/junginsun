<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0159.jsp
*@FileTitle : Commercial Based Unit Cost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================
* History
* 2008-07-22 : YJ Jeon
* 2008.07.22 전윤주 N200807218173 Commercial Base U/C 화면 추가
* 2008.09.11 박칠서 N200809040008 약정율 4자리까지 표시
* 2009.10.23 김기대 New FrameWork 적용
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<html>
<head>
<title>Commercial Based Unit Cost</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">

<form method="post" name="form" onKeyDown="keyEnter_loc();" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<!-- OUTER - POPUP (S)tart -->
<table width="800" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
    <tr>
      <td valign="top">

      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Commercial Based Unit Cost</td></tr>
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
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
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
            <!-- : ( Year ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td>YYYY-MM</td>
                <td>
                  <input type="text" name="f_yearmonth" class="input1" style="width:70;text-align:center;" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" onChange="setPeriod(this);" onBlur="this.value=ComGetMaskedValue(this.value,'ym');" onFocus="ComClearSeparator(this, 'ym', '-'); this.select();" >
                </td>
                <td colspan="6" class="sm"><div id="div_period"></div></td>
              </tr>

              <tr><td class="line_bluedot" colspan="8"></td></tr>

              <tr class="h23">
                <td width="8%">Trade</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_cobtrade',1, 70 , 0 );</script>
                </td>

                <td width="5%">Lane</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_coblane',1, 80 , 0 );</script>
                </td>

                <td width="8%">Direction</td>
                <td width="16%">
                	<script language="javascript">ComComboObject('f_cobdir',1, 70 , 0 );</script>
                </td>

                <td width="4%">IOC</td>
                <td>
                	<script language="javascript">ComComboObject('f_cobioc',1, 80 , 0 );</script>
                </td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">
            <!-- : ( POR ) (S) -->
            <table width="100%">
              <tr>
                <td width="100%">
                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Unit Cost</td>
                      <td align="right" valign="buttom" style="padding-right:2;">
                        <div id="div_zoom_in1" style="display:inline">
                        <img class="cursor" src="/hanjin/img/alps/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
                        </div>
                        <div id="div_zoom_out1" style="display:none">
                        <img class="cursor" src="/hanjin/img/alps/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
                        </div>
                      </td>
                    </tr>
                  </table>

                  <table width="100%" id="mainTable1">
                    <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
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

