<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0033.jsp
*@FileTitle : Agent Commission Mass Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.23 김봉균
* 1.0 Creation
* 
* 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.event.EsmAcm0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0033Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMCalculation.AGNCommCalculation");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    event = (EsmAcm0033Event)request.getAttribute("Event");
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
<title>Agent Commission Mass Simulation</title>
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
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="ac_tp_cd"><!-- Commission Account -->
<input type="hidden" name="agmt_no1"><!-- Multi AGMT No.1 (Applied) -->
<input type="hidden" name="agmt_no2"><!-- Multi AGMT No.2 (Should have been applied) -->
<input type="hidden" name="ac_sts_cd"><!-- Commission Status -->
<input type="hidden" name="ac_sts_cd2"><!-- Commission Status중 Interfaced를 클릭했는지 여부 -->
<input type="hidden" name="ofc_cd"><!-- Multi Office -->
<input type="hidden" name="loc_cd"><!-- Multi Loc -->
<input type="hidden" name="bkg_no"><!-- BKG No. -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; border:0px #ff0000 solid; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- biz page (S) -->
      <!-- biz_0 (S) -->
      <table class="gridtitle" border="0"><tr><td>Agreement Condition</td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                       <td>Sail Arrival Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="sa_arr_dt_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" class="input1" style="width:70px;">&nbsp;~
                        <input name="sa_arr_dt_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" class="input1" style="width:70px;" >
                        <img name="btn1_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr> 
                    <tr class="h23">
                      <td>Actual agreement No.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="agn_agmt_no" type="text" tabindex="5" class="input1" style="width:120px; text-align:right;">&nbsp;</td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn1_add_bat">Add Batch</td>
                            <td class="btn2_right"></td>
                          </tr>
                       </table>
                      </td>
                      <td width="38"></td>
                      <td>Simulation Number&nbsp;
                        <input name="act_agmt_sml_no" type="text" tabindex="12" class="input2" style="width:120px; text-align:right;" readOnly>&nbsp;</td>
                    </tr> 
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table style="height:5px"><tr><td></td></tr></table>
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                       <td>BKG Creation Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input name="bkg_date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" class="input1" style="width:70px;">&nbsp;~
                        <input name="bkg_date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" class="input1" style="width:70px;" >
                        <img name="btn2_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr> 
                    <tr class="h23">
                      <td>Simulation agreement No. &nbsp;&nbsp;
                        <input name="sim_agmt_no" type="text" tabindex="5" class="input1" style="width:120px; text-align:right;">&nbsp;</td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn2_add_bat">Add Batch</td>
                            <td class="btn2_right"></td>
                          </tr>
                       </table>
                      </td>
                      <td width="38"></td>
                      <td>Simulation Number&nbsp;
                        <input name="sim_agmt_sml_no" type="text" tabindex="12" class="input2" style="width:120px; text-align:right;" readOnly>&nbsp;</td>
                    </tr> 
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- biz_0 (E) -->    
      
      <!-- biz_1 (S) -->
      <table class="gridtitle" border="0"><tr><td>Search Condition</td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>

                <td width="50%" valign="top">

                  <table style="height:19px"><tr><td></td></tr></table>

                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Date&nbsp;
                        <%=JSPUtil.getCodeCombo("date_div", "", "tabindex='1' style='width:125px;'", "CD03025", 0, "")%>&nbsp;
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="2">&nbsp;~
                        <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="3">
                        <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td style="padding-right:10px">VVD</td>
                            <td style="padding-right:6px"><%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='4' style='width:125px;'", "CD03024", 0, "")%></td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="92" height="25" id="memo_sheet1_td">
                              <div id="memo_sheet1_div">
                                <table width="92">
                                  <tr>
                                    <td><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
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

                  <table style="height:20px"><tr><td></td></tr></table>

                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Commission Account</td>
                    </tr>
                  </table>

                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>
                        <input type="checkbox" name="comm_stnd_cost_div" class="trans" value="G">General
                        <input type="checkbox" name="comm_stnd_cost_div" class="trans" value="H">CHF
                        <input type="checkbox" name="comm_stnd_cost_div" class="trans" value="S">T/S
                        <input type="checkbox" name="comm_stnd_cost_div" class="trans" value="K">Brokerage
                        <input type="checkbox" name="comm_stnd_cost_div" class="trans" value="C">Cross Booking
                      </td>
                    </tr>
                  </table>

                  <table style="height:20px"><tr><td></td></tr></table>

                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Agreement Condition</td>
                    </tr>
                  </table>

                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td style="padding-right:112px"><input type="radio" name="agmt_div" class="trans" value="A">Applied</td>
                      <td>&nbsp;</td>
<!----------------------------------------------------------------->
                      <!-- Memo Sheet (S) -->
                      <td width="100" height="25" id="memo_sheet2_td">
                        <div id="memo_sheet2_div">
                          <table width="100">
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
                            <td class="btn2" name="btn2_agmt_no1">Multi AGMT No.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr class="h23">
                      <td><input type="radio" name="agmt_div" class="trans" checked value="S">Should have been applied</td>
                      <td>&nbsp;</td>
<!----------------------------------------------------------------->
                      <!-- Memo Sheet (S) -->
                      <td width="100" height="25" id="memo_sheet3_td">
                        <div id="memo_sheet3_div">
                          <table width="100">
                            <tr>
                              <td><script language="javascript">ComSheetObject("memo_sheet3");</script></td>
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
                            <td class="btn2" name="btn2_agmt_no2">Multi AGMT No.</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>


                </td>
                <td width="50%" valign="top">


                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Commission Status</td>
                    </tr>
                  </table>

                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td><input type="checkbox" name="ac_sts_div" class="trans">All&nbsp;&nbsp;&nbsp;&nbsp;</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="CS,CN">Calculated</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="CE">Calculation Error</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="RS">Requested</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="CB">Cross Booking</td>
                    </tr>
                    <tr class="h23">
                      <td>&nbsp;</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="AS">Audited</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="PS">Approved</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="IF">Interfaced</td>
                      <td><input type="checkbox" name="ac_sts_div" class="trans" value="RR,AR,PR">Rejected</td>
                    </tr>
                  </table>

                  <table style="height:20px"><tr><td></td></tr></table>

                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Office</td>
                    </tr>
                  </table>

                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td style="width:8px"></td>
                      <td>Office&nbsp;
                        <%=JSPUtil.getCodeCombo("ofc_div", "", "tabindex='5' caption='Office' style='width:100px;'", "CD03036", 0, " ")%>
                        <%=JSPUtil.getCodeCombo("port_div", "", "tabindex='5' caption='Route' style='width:70px;'", "CD01773", 0, " ")%></td>
                      <td>&nbsp;</td>
<!----------------------------------------------------------------->
                      <!-- Memo Sheet (S) -->
                      <td width="100" height="25" id="memo_sheet4_td">
                        <div id="memo_sheet4_div">
                          <table width="100">
                            <tr>
                              <td><script language="javascript">ComSheetObject("memo_sheet4");</script></td>
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
                            <td class="btn2" name="btn2_ofc_cd">Multi Office</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>

                  <table style="height:20px"><tr><td></td></tr></table>

                  <table class="search" border="0">
                    <tr>
                      <td class="title_h"></td>
                      <td class="title_s">Route & Bound</td>
                    </tr>
                  </table>

                  <table border="0" cellpadding="0" cellspacing="0" bordercolor="#0000ff">
                    <tr class="h23">
                      <td style="width:8px"></td>
                      <td>Route&nbsp;
                        <input type="radio" name="route_div" class="trans" value="POR">POR
                        <input type="radio" name="route_div" class="trans" value="POL">POL
                        <input type="radio" name="route_div" class="trans" value="POD">POD
                        <input type="radio" name="route_div" class="trans" value="DEL">DEL
                        <input type="radio" name="route_div" class="trans" value="TSP">T/S Port
                      </td>
                      <td>&nbsp;</td>
<!----------------------------------------------------------------->
                      <!-- Memo Sheet (S) -->
                      <td width="70" height="25" id="memo_sheet5_td">
                        <div id="memo_sheet5_div">
                          <table width="70">
                            <tr>
                              <td><script language="javascript">ComSheetObject("memo_sheet5");</script></td>
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
                            <td class="btn2" name="btn2_loc_cd">Multi Loc</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                    <tr class="h23">
                      <td style="width:8px"></td>
                      <td colspan="5">Commission Bound&nbsp;
                        <%=JSPUtil.getCodeCombo("io_bnd_cd", "", "tabindex='4' style='width:100px;'", "CD03037", 0, "")%></td>
                    </tr>
                  </table>
                </td>

              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- biz_1 (E) -->


      <!-- Button_1 (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_search">Simulation Target Search</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button_1 (E) -->


      <table class="line_bluedot"><tr><td></td></tr></table>


      <!-- biz_2 (S) -->
      <table class="gridtitle" border="0"><tr><td>Batch Condition</td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Total Target Bookings&nbsp;
                        <input name="ttl_bkg" type="text" tabindex="11" class="input2" style="width:120px; text-align:right;" readOnly>&nbsp;</td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn2_bkg_expt">BKG Export</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td width="38"></td>
                      <td>Simulation Number&nbsp;
                        <input name="sml_no1" type="text" tabindex="12" class="input2" style="width:120px; text-align:right;" readOnly>&nbsp;</td>
                      <td>
                    </tr>
                  </table>
                </td>
              </tr>
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td style="padding-right:24px">Calculation Remark</td>
                      <td><input name="clc_rmk" type="text" maxlength="500" caption="Calculation Remark" class="input1" style="width:500px; ime-mode:disabled;" tabindex="15"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- biz_2 (E) -->


      <!-- Button_2 (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 0px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_chk_sts">Check Batch Status</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left">
                      <td class="btn1" name="btn_start_clc">Start Simulation</td>
                      <td class="btn1_right">
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <!-- Button_2 (E) -->


      <table class="line_bluedot"><tr><td></td></tr></table>


      <!-- biz_3 (S) -->
      <table class="gridtitle" border="0"><tr><td>Simulation Result</td></tr></table>

      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Simulation Number&nbsp;
                        <input name="sim_no" type="text" tabindex="16" class="input2" style="width:120px; text-align:right;" readOnly>
                        <img name="btn_sml_popup" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">&nbsp;</td>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" name="btn2_downexcel">Down Excel</td>
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
      <table class="height_10">
	    <tr>
	      <td></td>
	    </tr>
      </table>
      <!-- biz_3 (E) -->
      <!-- biz page (E) -->


    </td>
  </tr>
</table>

<div style="display: none;" id="mainTable"><script language="javascript">ComSheetObject('sheet1');</script></div>

<!-- 개발자 작업 끝 -->
</form>
</body>
</html>