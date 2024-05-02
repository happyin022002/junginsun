<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0010.jsp
*@FileTitle : Agent Commission Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.10 김상수
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0010Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMSimulation.ACMSimulation");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0010Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

    if (serverException != null) {
      strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
    }

    // 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
    GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

  } catch(Exception e) {
    out.println(e.toString());
  }
%>
<html>
<head>
<title>Agent Commission Simulation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="bl_no"><!-- Multi B/L No -->
<input type="hidden" name="agmt_no"><!-- Multi AGMT No. -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button (E) -->


      <!-- biz page (S) -->
      <!-- biz_1 (S) -->
      <table class="search" border="0">
        <tr>
          <td class="title_h"></td>
          <td class="title_s">Target Search Condition</td>
        </tr>
      </table>


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Office&nbsp;
                        <select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
                        &nbsp;
                        Sub Office&nbsp;
                        <select name="agn_cd" required caption="Sub Office" class="input1" style="width:70px;" tabindex="2"></select>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td><%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='7' style='width:70px; font-weight:bold; color:#313131;'", "CD03024", 0, "")%>&nbsp;</td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="101" height="25" id="memo_sheet1_td" name="memo_sheet1_td">
                              <div id="memo_sheet1_div" name="memo_sheet1_div">
                                <table width="101" name="tmp_table">
                                  <tr>
                                    <td name="tmp_td"><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
                                  </tr>
                                </table>
                              </div>
                            </td>
                            <td>&nbsp;&nbsp;</td>
                            <!-- Memo Sheet (E) -->
<!----------------------------------------------------------------->
                            <td>
                              <table border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                  <td class="btn2_left"></td>
                                  <td class="btn2" name="btn2_vvd_cd">Multi VVD</td>
                                  <td class="btn2_right"></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>


                </td>
                <td align="left" valign="top" style="padding-left:25px">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Commission Status&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <%=JSPUtil.getCodeCombo("ac_sts_cd", "", "tabindex='3' style='width:112px;'", "CD03039", 0, "")%>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>B/L No&nbsp;</td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="104" height="25" id="memo_sheet2_td">
                              <div id="memo_sheet2_div">
                                <table width="104">
                                  <tr>
                                    <td><script language="javascript">ComSheetObject("memo_sheet2");</script></td>
                                  </tr>
                                </table>
                              </div>
                            </td>
                            <td>&nbsp;&nbsp;</td>
                            <!-- Memo Sheet (E) -->
<!----------------------------------------------------------------->
                            <td>
                              <table border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                  <td class="btn2_left"></td>
                                  <td class="btn2" name="btn2_bl_no">Multi B/L No</td>
                                  <td class="btn2_right"></td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>


                </td>
                <td rowspan="2" align="right" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Date&nbsp;
                        <%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:100px;'", "CD03025", 0, "")%>&nbsp;
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">&nbsp;~
                        <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6">
                        <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
                    <tr class="h23">
                      <td>Simulation No.&nbsp;
                        <input name="sim_no" type="text" dataformat="engup" maxlength="20" style="width:94px;" tabindex="8">
                        <img name="btn_smlt_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Select&nbsp;
                              <input name="slct_start" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="9">&nbsp;~
                              <input name="slct_end" type="text" dataformat="int" maxlength="5" style="width:41px;" tabindex="10">&nbsp;&nbsp;
                            </td>
                            <td>
                              <table  border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                  <td>
                                    <table border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn2_check">Check</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </td>
                                  <td>
                                    <table border="0" cellpadding="0" cellspacing="0" class="button">
                                      <tr>
                                        <td class="btn2_left"></td>
                                        <td class="btn2" name="btn2_uncheck">Uncheck</td>
                                        <td class="btn2_right"></td>
                                      </tr>
                                    </table>
                                  </td>
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>


                </td>
              </tr>
              <tr>
                <td align="left" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Display bookings before BDR&nbsp;
                        <input name="bdr_flg" type="checkbox" class="trans" tabindex="11" value="Y">
                      </td>
                    </tr>
                  </table>


                </td>
                <td align="left" valign="top" style="padding-left:25px">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Display Advanced Bookings&nbsp;
                        <input name="bkg_sts_cd" type="checkbox" class="trans" tabindex="12" value="A">
                      </td>
                    </tr>
                  </table>


                </td>
                <td></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- biz_1 (E) -->

      <table class="height_5"><tr><td></td></tr></table>


      <table class="search">
        <tr>
          <td class="bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
                <td valign="top">Simulation Remark&nbsp;
                  <input name="sim_rmk" type="text" maxlength="500" class="input1" style="width:300px; ime-mode:disabled;" tabindex="13">&nbsp;&nbsp;
                </td>
                <td valign="top">
                  <!-- Button (S) -->
                  <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
                    <tr>
                      <td class="btn1_bg">
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td>
                              <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                                <tr>
                                  <td class="btn1_left">
                                  <td class="btn1" name="btn_simulation">Start Simulation</td>
                                  <td class="btn1_right">
                                </tr>
                              </table>
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                  <!-- Button (E) -->
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- biz_1 (E) -->


      <table class="height_8"><tr><td></td></tr></table>


      <!-- Tab_1 (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="tab">
        <tr>
          <td width="100%"><script language="javascript">ComTabObject("tab1");</script></td>
        </tr>
      </table>
      <!-- Tab_1 (E) -->


      <!-- biz_2 (S) -->
      <!-- Tab_Layer_1 (S) -->
      <div id="tabLayer" style="display:inline">
        <table class="search">
          <tr>
            <td class="bg" valign="top">
              <!-- Tab_1_Grid_1 (S) -->
              <table width="100%" id="mainTableT1S1">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject("tab1sheet1");</script></td>
                </tr>
              </table>
              <!-- Tab_1_Grid_1 (E) -->
              <!-- Tab_1_Button (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn2_bg">
                    <table  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td>
                          <table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="tab1btn_downexcel">Down Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <!-- Tab_1_Button (E) -->
            </td>
          </tr>
        </table>
      </div>
      <!-- Tab_Layer_1 (E) -->
      <!-- biz_2 (E) -->


      <!-- biz_3 (S) -->
      <!-- Tab_Layer_2 (S) -->
      <div id="tabLayer" style="display:none">
        <table class="search">
          <tr>
            <td class="bg" valign="top">
              <!-- Tab_2_Grid_1 (S) -->
              <table width="100%" id="mainTableT2S1">
                <tr>
                  <td width="100%"><script language="javascript">ComSheetObject("tab2sheet1");</script></td>
                </tr>
              </table>
              <!-- Tab_2_Grid_1 (E) -->
              <!-- Tab_2_Button (S) -->
              <table width="100%" class="button">
                <tr>
                  <td class="btn2_bg">
                    <table  border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td>
                          <table border="0" cellpadding="0" cellspacing="0" class="button">
                            <tr>
                              <td class="btn2_left"></td>
                              <td class="btn2" name="tab2btn_downexcel">Down Excel</td>
                              <td class="btn2_right"></td>
                            </tr>
                          </table>
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
              </table>
              <!-- Tab_2_Button (E) -->
            </td>
          </tr>
        </table>
      </div>
      <!-- Tab_Layer_1 (E) -->
      <!-- biz_3 (E) -->


      <!-- biz page (E) -->
    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>