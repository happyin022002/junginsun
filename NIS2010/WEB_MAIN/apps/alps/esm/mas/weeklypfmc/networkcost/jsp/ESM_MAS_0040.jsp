<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0040.jsp
*@FileTitle : Port Class별 Tariff 조회/변경
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.23
*@LastModifier : 이행지
*@LastVersion : 1.0
=========================================================
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.04.01 김종열 CSR No.N200903170121  Port Tariff(PA)기능 변경으로 btn_create.gif 추가
*                                        -조회(searchPortTariffList)와 생성(createPortTariff) 분리
* 2009.10.23 김기대 New FrameWork 적용 
* 2010.06.23 이행지 CHM-201003663 -Port tariff vessel class 변경 : 검색 조건을 VSL Class Capa -> Port Class Capa
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.07.07 이석준 [CHM-201111498-01] PSO와 연계하여 VVD,TERMINAL별로 TARIFF 직접 수정및 PSO I/F 추가
* 2012.11.13 원종규 [CHM-201221358] Port tariff 기간 조회 시 팝업 관련 수정 요청: 주차 변경시 VALIDATION MSG 무한루프 현상 
*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%
    Exception serverException   = null;             //서버에서 발생한 에러
    String strErrMsg    = "";                       //에러메세지
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0040");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Port Tariff (PA) </title>
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

<body onload="javascript:setupPage();form.f_yearweek.select()">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">

<input type="hidden" name="cost_yrmon">
<input type="hidden" name="locl_curr_cd">
<input type="hidden" name="locl_port_amt">
<input type="hidden" name="locl_cnl_amt">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
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
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="20%">
                     YYYY-MM <input type="radio" name="f_yrtype" class="trans" value="M" onClick="setYrMon()" checked="true">&nbsp;&nbsp;
                     YYYY-WW <input type="radio" name="f_yrtype" class="trans" value="W"></td>
                <td width="8%"><input type="text" class="input1" style="width:60" name="f_yearweek" maxlength="6" onkeyPress="ComKeyOnlyNumber(window);" dataformat="ym" ></td>              
                <td class="sm"><span id="div_period"></span>&nbsp;</td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot" colspan="10"></td></tr>
              <tr class="h23">
                <td width=>S/Lane</td>
                <td width=>&nbsp;<script language="javascript">ComComboObject('f_selslane',1, 110 , 0 )</script></td>
   <!--               <td width="4%">Class</td>
                <td width=>&nbsp;<script language="javascript">ComComboObject('f_selclass',1, 110 , 0 )</script></td>
   -->
                <td>R/Lane</td>
                <td align="left">&nbsp;<script language="javascript">ComComboObject('f_selrlane',1, 110 , 0 )</script></td>
                <td>VVD</td>
                <td colspan="3">
                    <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;" >
                    <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:60;">
                    <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper');" style="ime-mode:disabled; width:30;" >
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
       		<table class="search" border="0">
              <tr>
                <td rowspan="2" class="gray">
                <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:callModification();"
                class="purple">Cost Modification</a>
              </tr>
              <tr>
                <td class="height_5"></td>
              </tr>
            </table>
            <!-- : ( POR ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="10%" align="right" valign="bottom" style="padding-right:4;">
                  <div id="div_zoom_in"  style="position:relative; right:0px; top:0px; display:inline"> <!-- absolute / relative -->
                  <img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out" style="position:relative; right:0px; top:0px; display:none">
                  <img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
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
