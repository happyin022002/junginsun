<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0110.jsp
*@FileTitle : Create Networkcost & Slot Charter In & Out
*Open Issues :
*Change history :
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
*@LastModifyDate : 2009.10.23
*@LastModifier : 김기대
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException = null;	//서버에서 발생한 에러
    String strErrMsg = "";              //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0110");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error(e.toString());
    }
%>

<html>
<head>
<title>Network Cost by VVD </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
    function setupPage() {
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">

<form method="post" name="form" onKeyDown="keyEnter_loc();" onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_chkprevcre" value="N">
<input type="hidden" name="backendjob_key">

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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_New" name="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
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
                <td width="48" style="text-indent:7;">Trade</td>
                <td width="180">&nbsp;<script language="javascript">ComComboObject('f_cobtrade',1, 100 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="180"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_coblane',1, 100 , 0 )</script></div></td>
                <td width="65">Direction</td>
                <td width="180">&nbsp;<script language="javascript">ComComboObject('cobDir',1, 100 , 0 )</script></td>
                <td width="33">VVD</td>
                <td>
                  <input type="text" name="f_vessel" style="width:70;text-align:center;" maxlength="4" onClick="ComClearSeparator(this);" onKeyUp="ComKeyEnter('f_voyage');" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="upper(this);">
                  <input type="text" name="f_voyage" style="width:70;text-align:center;" maxlength="4" onClick="ComClearSeparator(this);" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('f_dir');" onFocus="this.select();">
                  <input type="text" name="f_dir"    style="width:35;text-align:center;" maxlength="1" onClick="ComClearSeparator(this);" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onFocus="this.select();" onBlur="ComGetMaskedValue(this.value, 'engdn');">
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <!-- TABLE '#D' : ( Search Options ) (E) -->
      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Tab ) (S) -->
      <table class="tab">
        <tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
      </table>
      <!-- TABLE '#D' : ( Tab ) (E) -->

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <table class="height_10"><tr><td></td></tr></table>

            <div id="tabLayer" style="display:inline">

            <!-- TABLE '#D' : ( Grid  ) (S) -->
            <table width="100%" id="mainTable1">
              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- TABLE '#D' : ( Grid  ) (E) -->

            <!--  Button_Sub (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="t1btng_missingstatus" name="t1btng_missingstatus">Missing Status</td>
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
            <!-- Button_Sub (E) -->

            </div>

            <div id="tabLayer" style="display:none">
            <!-- TABLE '#D' : ( Grid  ) (S) -->
            <table width="100%" id="mainTable2">
              <tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
            </table>
            <!-- TABLE '#D' : ( Grid  ) (E) -->

            <!--  Button_Sub (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
                      <!-- Repeat Pattern -->
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="t2btng_missingstatus" name="t2btng_missingstatus">Missing Status</td>
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
            <!-- Button_Sub (E) -->
            </div>

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
