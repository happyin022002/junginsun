<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0109.jsp
*@FileTitle : SML Sales Amount U/C
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.18
*@LastModifier : 김기대
*@LastVersion : 1.0
*=========================================================
* History
* ESM_MAS_0045 => ESM_MAS_0109 참조 수정
=========================================================*/%>
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
<title>SML Sales Amount U/C </title>
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
<input type="hidden" name="f_uc_cd">

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
                      <td class="btn1" id="btn_Creation" name="btn_Creation">Unit Cost Creation</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Bkg_Creation" name="btn_Bkg_Creation">BKG Creation</td>
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
              <tr><td colspan="8">            
                <table border="0">
              <tr class="h23">
                <input type='hidden' value='W' name='f_chkprd'>
                <td width="52" style="text-indent:7;">Year</td>
                <td width="60"><input type="text" style="width:40;text-align:center;" class="input1" name="f_year" maxlength="4" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(window);" onChange="setPeriod(this);"></td>
                <td width="40">Week</td>
                <td width="100"><input type="text" style="width:30;text-align:center;" class="input1" name="f_fm_wk" maxlength="2" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(window);" onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onKeyUp="ComKeyEnter('LengthNextFocus')" onChange="setPeriod(this);">&nbsp;~&nbsp;<input type="text" style="width:30;text-align:center;" class="input1" name="f_to_wk" maxlength="2" style="ime-mode:disabled" onKeyPress="ComKeyOnlyNumber(window);" onBlur="if(this.value!=''){this.value=ComLpad(this, 2, '0');}" onChange="if(this.value!=''){this.value=ComLpad(this, 2, '0'); setPeriod(this);}"></td>
                <td class='sm'><div id='div_period'></div></td>
                <td width="" colspan="3">&nbsp;</td>
              </tr>
                </table>              
              </td></tr>
              <tr><td class="line_bluedot" colspan="8"></td></tr>
              <tr class="h23">
                <td width="45" style="text-indent:7;">Trade</td>
                <td width="170">&nbsp;<script language="javascript">ComComboObject('f_seltrade',1, 100 , 0 )</script></td>
                <td width="35">Lane</td>
                <td width="180"><div id="div_rLane">&nbsp;<script language="javascript">ComComboObject('f_selrlane',1, 100 , 0 )</script></div></td>
                <td width="30">IOC</td>
                <td width="170">&nbsp;<script language="javascript">ComComboObject('f_selioc',1, 100 , 0 )</script></td>
                <td width="30">VVD</td>
                <td>
                  <input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum');" onKeyUp="ComKeyEnter('f_skd_voy_no');" style="ime-mode:disabled; width:70;" >
                  <input type="text" size="4" name="f_skd_voy_no" maxlength="4" onkeyPress="ComKeyOnlyNumber(window);" onKeyUp="ComKeyEnter('f_dir_cd');" style="ime-mode:disabled; width:70;">
                  <input type="text" size="1" name="f_dir_cd"     maxlength="1" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled; width:30;" >
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
            <!-- : ( POR ) (S) -->
            <table width="100%">
              <tr>
                <td width="100%">
                  <table width="100%" id="mainTable">
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
<!-- Outer Table (E)-->

</form>
</body>
</html>

