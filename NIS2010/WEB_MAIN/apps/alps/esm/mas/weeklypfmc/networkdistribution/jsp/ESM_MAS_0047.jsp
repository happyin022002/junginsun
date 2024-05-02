<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0047.jsp
*@FileTitle : Re-allocate Slot-cost By Lane
*Open Issues :
*Change history :
* 2006-11-28 Kim Jong Beom
* 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
* 2008.07.22 전윤주 N200807218173 Commercial Base U/C 화면 추가
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.03.13 김태윤 N200903110001 - VVD Code에 영문 외 숫자도 입력가능하게 수정
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2010.10.01 김기종 Ticket ID:CHM-201006017-01[MAS] 아주 노선 선복사용량에 대한 원양으로의 운항 변고정비 배부 로직(약정율) 추가 요청
* 2013.05.06 김수정 [CHM-201324486][MAS] TS Allocation상 WK, Month Display 기능 추가
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
    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0042");
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
<title>TS Allocation </title>
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

<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">

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
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Creation</td>
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
                <td>OP View&nbsp;<SELECT name="f_op_view"><OPTION value="OP1">OP</OPTION><OPTION value="OP4">OP4</OPTION></SELECT></td>
                <td align="left" nowrap>
                	<span id="chkWk"><input type="checkbox" value="" class="trans" name="chkWk" id="chkWk" onclick="return hiddenWk();"><label for="chkWk">Week Display</label>&nbsp;</span>
                	<span id="chkMonth"><input type="checkbox" value="" class="trans" name="chkMonth" id="chkMonth" onclick="return hiddenMonth();"><label for="chkMonth">R.Month Display</label>&nbsp;</span>
                </td>
              </tr>
            </table>
            <table class="search_in" border="0">
              <tr><td class="line_bluedot" colspan="10"></td></tr>
              <tr class="h23">
                <td width="45" style="text-indent:7;">Trade</td>
                <td width="140">&nbsp;<script language="javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="140"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></div></td>
                <td width="30">IOC</td>
                <td width="140">&nbsp;<script language="javascript">ComComboObject('f_selioc',1, 100 , 0 )</script></td>
                <td width="30">VVD</td>
                <td width="200">
                  <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('f_skd_voy_no');" style="ime-mode:disabled; width:60;" >
                  <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('f_dir_cd');" style="ime-mode:disabled; width:60;">
                  <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled width:25;" >
                </td>
                <td width="35">Cost</td>
                <td>&nbsp;<script language="javascript">ComComboObject('f_selcost',1, 180 , 0 )</script></td>
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
                <td class="title_s">1st Network Cost Assignment</td>
                <td width="30%" valign="middle" align="right">
                    <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                    <a href="javascript:window.showModalDialog('ESM_MAS_0159.do', 'win_commit', 'dialogWidth:800px;dialogHeight:560px;scroll:no');" class="purple">Commercial Based Unit Cost</a>
                </td>
                
              </tr>
              <tr><td height="2" colspan="4"></td></tr>
            </table>

            <!-- : ( Trade ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td><script language="javascript">ComSheetObject('sheet1');</script></td>
              </tr>
            </table>
            <!-- : ( Trade ) (E) -->
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
