<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VOP_VSK_0095.jsp
*@FileTitle : VVD SKD Interface To ERP
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.12.10 김상수
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
<%@ page import="com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event.VopVsk0095Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    VopVsk0095Event event = null;        // PDTO(Data Transfer Object including Parameters)
    Exception serverException = null;    // 서버에서 발생한 에러
    String strErrMsg = "";               // 에러메세지
    int rowCount = 0;                    // DB ResultSet 리스트의 건수

    String successFlag = "";
    String codeList  = "";
    String pageRows  = "100";

    String strUsr_id = "";
    String strUsr_nm = "";

    String dateTo = "";
    String dateFm = "";

    Logger log = Logger.getLogger("com.hanjin.apps.SchedulePlanningOperation.VesselScheduleMgt");

    try {
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        strUsr_id = account.getUsr_id();
        strUsr_nm = account.getUsr_nm();

        dateTo = JSPUtil.getKST("yyyy-MM-dd");    // 현재 날짜
        dateFm = DateTime.addMonths(dateTo, -1, "yyyy-MM-dd");    // 1개월 이전 날짜

        event = (VopVsk0095Event)request.getAttribute("Event");
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
<title>VVD SKD Interface To ERP</title>
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
<input type="hidden" name="vvd_deleted_yn" value="N">

<input type="hidden" name="init_date_fm" value="<%=dateFm%>">
<input type="hidden" name="init_date_to" value="<%=dateTo%>">

<!-- 개발자 작업 -->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding:2px 0px 0px 5px; width:1002px">
  <tr>
    <td valign="top">


      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" align="left" border="0" cellpadding="0" cellspacing="0">
              <tr class="h23">
              
                <td>
					<table class="search_sm2" style="width:100;">
						<tr class="h23">
							<td><input type="radio" name="rdo_vvd" value="" class="trans" checked="checked">Live</td>
						</tr>
						<tr class="h23">
							<td><input type="radio" name="rdo_vvd" value="" class="trans">Deleted</td>
						</tr>
					</table>
                </td>              
              
                <td>Lane Code&nbsp;
                  <input name="vsl_slan_cd" type="text"  class="input1" dataformat="engup" maxlength="3" style="ime-mode:disabled; text-align:center; width:50px;" tabindex="1">
                  <img  name="btn_lane_popup" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                <td>VVD&nbsp;
                  <input name="vsl_cd" type="text" class="input1" dataformat="engup" maxlength="4" style="ime-mode:disabled; text-align:center; width:45px;" tabindex="2">
                  <input name="skd_voy_no" type="text" class="input1" dataformat="engup" maxlength="4" style="ime-mode:disabled; text-align:center; width:45px;" tabindex="3">
                  <input name="skd_dir_cd" type="text" class="input1" dataformat="engup" maxlength="1" style="ime-mode:disabled; text-align:center; width:20px;" tabindex="4">
                  <img name="btn_vvd_popup" class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
                <td>DIR&nbsp;
                  <select name = "skd_dir_combo" style="width:40px;" tabindex="5">
                    <option selected value=""> </option>
                    <option value="E"> E</option>
                    <option value="W"> W</option>
                    <option value="S"> S</option>
                    <option value="N"> N</option>
                  </select></td>
                <td>SKD Creation Date&nbsp;&nbsp;
                  <input name="date_fm" type="text" class="input1" dataformat="ymd" maxlength="8" caption="From Date" 	cofield="date_to" style="ime-mode:disabled; text-align:center;width:70px;" value="" tabindex="6">&nbsp;~
                  <input name="date_to" type="text" class="input1" dataformat="ymd" maxlength="8" caption="To Date" 	cofield="date_fm" style="ime-mode:disabled; text-align:center;width:70px;" value="" tabindex="7">
                  <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                  <br>
                  FirstPort Birth Date&nbsp;
                  <input name="first_port_etb_fm" type="text" class="input" dataformat="ymd" maxlength="8" caption="ETB From Date" 	cofield="first_port_etb_fm" style="ime-mode:disabled; text-align:center;width:70px;" value="" tabindex="8">&nbsp;~
                  <input name="first_port_etb_to" type="text" class="input" dataformat="ymd" maxlength="8" caption="ETB To Date" 	cofield="first_port_etb_to" style="ime-mode:disabled; text-align:center;width:70px;" value="" tabindex="9">
                  <img name="btn_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">                  
                 </td>
              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <table class="height_8"><tr><td></td></tr></table>


      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_2 (S) -->
            <!-- Grid (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td width="100%"><script language="javascript">ComSheetObject("sheet1");</script></td>
              </tr>             
            </table>
            <!-- Grid (E) -->
            <!-- biz_2 (E) -->
          </td>
        </tr>
      </table>
      <!-- biz page (E) -->


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
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_erp">I/F to ERP</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_downexcel">Down Excel</td>
                      <td class="btn1_right"></td>
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


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>