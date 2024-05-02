<%--
 - Copyright(c) 2012 CyberLogitec
 - @FileName : ESM_ACM_0008.jsp
 - @FileTitle : Agent Commission Audit
 - Open Issues :
 - Change history :
 - @LastModifyDate : 2012.04.02
 - @LastModifier : 김상수
 - @LastVersion : 1.0
 - 2012.04.02 김상수 1.0 Creation.
 - 2016.07.20 김상현 [CHM-201642691] Agent Commission System - Agent Commission Audit 화면 보완 요청.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil" %>
<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse" %>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount" %>
<%@ page import="com.hanjin.apps.alps.esm.acm.acmaudit.agncommaudit.event.EsmAcm0008Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0008Event event = null;        //PDTO(Data Transfer Object including Parameters)
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
    event = (EsmAcm0008Event)request.getAttribute("Event");
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
<input type="hidden" name="bkg_no">
<input type="hidden" name="bkg_no_array">

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
                      <td class="btn1" name="btn_detail">Detail</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_audit">Audit</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_reject">Reject</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_cancel">Audit Cancel</td>
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
                          <tr class="h23">
                            <!-- <td>VVD&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
                            <td>
                              <%=JSPUtil.getCodeCombo("vvd_div", "", "tabindex='7' style='width:70px; font-weight:bold; color:#313131;'", "CD03024", 0, "") %>&nbsp;
                            </td>
<!----------------------------------------------------------------->
                            <!-- Memo Sheet (S) -->
                            <td width="98" height="25" id="memo_sheet1_td">
                              <div id="memo_sheet1_div">
                                <table width="98">
                                  <tr>
                                    <td><script language="javascript">ComSheetObject("memo_sheet1");</script></td>
                                  </tr>
                                </table>
                              </div>
                            </td>
                            <td>&nbsp;&nbsp;</td>
                            <!-- Memo Sheet (E) -->
<!----------------------------------------------------------------->
                            <td style="padding-left:2px">
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
                    <tr>
                      <td>
                        <table border="0" cellpadding="0" cellspacing="0">
                          <tr class="h23">
                            <td>Select</td>
                            <td style="padding-left:4px">
                              <input name="slct_start" type="text" dataformat="int" maxlength="5" style="width:40px;" tabindex="9">&nbsp;~
                              <input name="slct_end" type="text" dataformat="int" maxlength="5" style="width:40px;" tabindex="10">&nbsp;&nbsp;
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
                <td align="center" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Commission Status&nbsp;
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
                    <tr class="h23">
                    	<td>Comm. Type&nbsp;</td>
                        <td>
		                  	
		                  	<select name="ac_tp_cd" caption="Type Code" style="width:100px;" tabindex="4">
		                  		<option value="">All</option>
		                  		<option value="G">General</option>
		                  		<option value="K">Brokerage</option>
		                  		<option value="H">CHF</option>
		                  		<option value="S">T/S</option>
		                  		<option value="C">Cross</option>
		                  	</select>
                        </td>
					</tr>
                        </table>
                      </td>
                    </tr>
                  </table>


                </td>
                <td align="right" valign="top">


                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr class="h23">
                      <td>Date</td>
                      <td>
                        <%=JSPUtil.getCodeCombo("date_div", "", "tabindex='4' style='width:100px;'", "CD03025", 0, "")%>&nbsp;
                        <input name="date_fm" type="text" dataformat="ymd" maxlength="8" required caption="From Date" cofield="date_to" class="input1" style="width:70px;" tabindex="5">&nbsp;~
                        <input name="date_to" type="text" dataformat="ymd" maxlength="8" required caption="To Date" cofield="date_fm" class="input1" style="width:70px;" tabindex="6">
                        <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                      </td>
                    </tr>
                    <tr class="h23">
                      <td>Audit No&nbsp;</td>
                      <td>
                        <input name="aud_no" type="text" dataformat="engup" maxlength="20" style="width:100px;" tabindex="7">
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


    </td>
  </tr>
</table>


<!-- 개발자 작업 끝 -->
</form>
</body>
</html>