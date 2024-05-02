<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0028.jsp
*@FileTitle : Agent Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.26 김영오
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.event.EsmAcm0028Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0028Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMAudit.AGNCommAudit");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0028Event)request.getAttribute("Event");
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
<title>Agent Commission Audit</title>
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


<input type="hidden" name="ofc_cd" value="<%=strOfc_cd%>"><!-- 로그인 한 사용자의 ofc_cd -->
<input type="hidden" name="vvd_cd"><!-- Multi VVD -->
<input type="hidden" name="bl_no"><!-- Multi B/L No -->


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
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_new">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_calculate">Re-Calculate</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
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


      <!-- biz page (S) -->
      <table class="search">
        <tr>
          <td class="bg" valign="top">
            <!-- biz_1 (S) -->
            <table width="100%" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>
						<input type="radio" name="ofc_option" value="A" class="trans" checked>AR Office&nbsp;&nbsp;&nbsp;
						<input type="radio" name="ofc_option" class="trans" value="S">Sales Office
						<select name="ar_ofc_cd" required caption="Office" class="input1" style="width:70px;" tabindex="1"></select>
					  </td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>&nbsp;&nbsp;VVD&nbsp;</td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="101" height="25" id="memo_sheet1_td">
                              <div id="memo_sheet1_div">
                                <table width="101">
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


                </td>
                <td align="center" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>
                        <input type="radio" name="date_div" class="trans" value="C" checked>BKG Creation&nbsp;&nbsp;&nbsp;<input type="radio" name="date_div" class="trans" value="E">ETD
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">&nbsp;~
                        <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6">
                        <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
                    <tr class="h23">
						<td>&nbsp;&nbsp;F/Forwarder&nbsp;
						<input type="text" name="ff_cnt_seq" dataformat="engup" style="width: 79; ime-mode: disabled;" maxlength="8">
							<img name="btn_forwarder" class="cursor" src="img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
						</td>
					</tr>
                  </table>


                </td>
                <td align="right" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td width="88">Cur&nbsp;<select name="curr_cd" style="width: 50;">
							<option value="" selected>All</option>
							<option value="USD">USD</option>
							<option value="EUR">EUR</option>
						</select></td>
                    </tr>
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>B/L No&nbsp;</td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="102" height="25" id="memo_sheet2_td">
                              <div id="memo_sheet2_div">
                                <table width="102">
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


              </tr>
            </table>
            <!-- biz_1 (E) -->
          </td>
        </tr>
      </table>


      <div style="height:8px;"></div>


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


    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>