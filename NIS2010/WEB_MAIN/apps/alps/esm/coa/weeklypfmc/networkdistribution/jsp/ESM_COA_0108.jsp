<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0108.jsp
*@FileTitle : > Estimated PFMC-PA > Allocate Network Cost > Allocation Results
*Open Issues :
*Change history :
* 2006-11-28 Kim Jong Beom
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
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0042");
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
<title>Allocation Results </title>
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
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Applytopl" name="btn_Applytopl">Apply to P/L</td>
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
              <tr class="h22">
                <td><script language="javascript">coaPeriod1();</script></td>
                <td align="right">OP View&nbsp;<SELECT name="f_op_view"><OPTION value="OP5">OP5</OPTION><OPTION value="OP6">OP6</OPTION></SELECT></td>
              </tr>
            </table>

            <table class="search_in" border="0">
              <tr><td class="line_bluedot" colspan="8"></td></tr>
            </table>

            <table class="search_in" border="0">
              <tr class="h23">
                <td width="5%" style="padding-left:7;">Trade</td>
                <td width="14%">&nbsp;<script language="javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
                <td width="4%">Lane</td>
                <td width="14%"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></div></td>
                <td width="3%">IOC</td>
                <td width="14%">&nbsp;<script language="javascript">ComComboObject('f_selioc',1, 100 , 0 )</script></td>
                <td width="3%">VVD</td>
                <td width="20%" style="padding-left:7;">
                    <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('f_skd_voy_no');" style="ime-mode:disabled; width:60;" >
                    <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('f_dir_cd');" style="ime-mode:disabled; width:60;" >
                    <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled; width:30;" >
                </td>
                <td width="4%">Cost</td>
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
            <table class="height_10"><tr><td></td></tr></table>

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
