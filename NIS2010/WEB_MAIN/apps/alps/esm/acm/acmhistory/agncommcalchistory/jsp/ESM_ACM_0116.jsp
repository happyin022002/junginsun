<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_ACM_0116.jsp
*@FileTitle : Calculation Detail from History
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.07.10 김상수
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
<%@ page import="com.hanjin.apps.alps.esm.acm.acmhistory.agncommcalchistory.event.EsmAcm0116Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
  EsmAcm0116Event event = null;        //PDTO(Data Transfer Object including Parameters)
  Exception serverException = null;    //서버에서 발생한 에러
  String strErrMsg = "";               //에러메세지
  int rowCount = 0;                    //DB ResultSet 리스트의 건수

  String successFlag = "";
  String codeList  = "";
  String pageRows  = "100";

  String strUsr_id = "";
  String strUsr_nm = "";
  String strOfc_cd = "";
  Logger log = Logger.getLogger("com.hanjin.apps.ACMHistory.AGNCommCalcHistory");

  try {
    SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    strUsr_id = account.getUsr_id();
    strUsr_nm = account.getUsr_nm();
    strOfc_cd = account.getOfc_cd();
    event = (EsmAcm0116Event)request.getAttribute("Event");
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
<title>Calculation Detail from History</title>
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


<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업 -->


<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>">
<input type="hidden" name="agn_cd" value="<%=JSPUtil.getParameter(request, "agn_cd")%>">
<input type="hidden" name="io_bnd_cd" value="<%=JSPUtil.getParameter(request, "io_bnd_cd")%>">
<input type="hidden" name="ac_seq" value="<%=JSPUtil.getParameter(request, "ac_seq")%>">
<input type="hidden" name="calc_no" value="<%=JSPUtil.getParameter(request, "calc_no")%>">
<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0" style="border:0px #ff0000 solid; width:870px">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- Page Title (S) -->
      <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Calculation Detail from History</td></tr>
      </table>
      <!-- Page Title (E) -->

      <div style="width:866px; height:425px; overflow:auto;">
        <!-- biz page (S) -->
        <table class="search" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td height="425" valign="top">


              <!-- biz_1 (S) -->
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Booking Detail</td>
                </tr>
              </table>

              <table class="search">
                <tr>
                  <td class="bg" valign="top">

                    <!-- Grid (S) -->
                    <table width="402" id="mainTableB1S1">
                      <tr>
                        <td class="gray_tit" style="font-weight:bold; padding:0px 0px 5px 2px;">Booking Revenue</td>
                      </tr>
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box1sheet1");</script></td>
                      </tr>
                      <tr class="h23">
                        <td align="right" style="padding:5px 3px 10px 0px;">Non Deducted Rev.&nbsp;<input name="non_ddc_rev" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "crnt_rev_amt")%>" readOnly>&nbsp;USD</td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                    <table class="line_bluedot"><tr><td></td></tr></table>

                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td colspan="2" class="gray_tit" style="font-weight:bold; padding:0px 0px 5px 2px;">Booking Q'ty</td>
                      </tr>
                      <tr class="h23">
                        <td valign="top">
                          <!-- Grid (S) -->
                          <table width="200" id="mainTableB1S2">
                            <tr>
                              <td width="100%"><script language="javascript">ComSheetObject("box1sheet2");</script></td>
                            </tr>
                          </table>
                          <!-- Grid (E) -->
                        </td>
                        <td align="right" valign="baseline" style="padding:0px 3px 0px 0px;">Total Q'ty&nbsp;<input name="ttl_qty" type="text" class="input2" style="width:100px; text-align:right;" readOnly>&nbsp;Box</td>
                      </tr>
                    </table>

                    <table class="line_bluedot"><tr><td></td></tr></table>

                    <!-- Grid (S) -->
                    <table width="402" id="mainTableB1S3">
                      <tr>
                        <td class="gray_tit" style="font-weight:bold; padding:0px 0px 5px 2px;">Booking Route</td>
                      </tr>
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box1sheet3");</script></td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                  </td>
                </tr>
              </table>
              <!-- biz_1 (E) -->


            </td>
            <td style="width:8px;"></td>
            <td valign="top">


              <!-- biz_2 (S) -->
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Deduction Detail</td>
                </tr>
              </table>

              <table class="search">
                <tr>
                  <td class="bg" valign="top">

                    <!-- Grid (S) -->
                    <table width="402" id="mainTableB2S1">
                      <tr>
                        <td class="gray_tit" style="font-weight:bold; padding:0px 0px 5px 2px;">Charge Deduction</td>
                      </tr>
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box2sheet1");</script></td>
                      </tr>
                      <tr class="h23">
                        <td align="right" style="padding:5px 3px 10px 0px;">Total Charge Deduction&nbsp;<input name="ttl_chr_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_chg_amt")%>" readOnly>&nbsp;USD</td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                    <table class="line_bluedot"><tr><td></td></tr></table>

                    <!-- Grid (S) -->
                    <table width="402" id="mainTableB2S2">
                      <tr>
                        <td class="gray_tit" style="font-weight:bold; padding:0px 0px 5px 2px;">Transportation Cost Deduction</td>
                      </tr>
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box2sheet2");</script></td>
                      </tr>
                      <tr class="h23">
                        <td align="right" style="padding:5px 3px 10px 0px;">Total Transportation Deduction&nbsp;<input name="ttl_trs_ddc" type="text" class="input2" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "ddct_trsp_amt")%>" readOnly>&nbsp;USD</td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                    <table class="line_bluedot"><tr><td></td></tr></table>

                    <table class="search" border="0" style="width:402px">
                      <tr class="h23">
                        <td align="right" style="padding:2px 3px 0px 0px; color:#FB1901;">Net Revenue&nbsp;<input name="net_rev" type="text" class="input2_1" style="width:100px; text-align:right;"  value="<%=JSPUtil.getParameter(request, "post_rev_amt")%>" readOnly>&nbsp;USD</td>
                      </tr>
                    </table>

                  </td>
                </tr>
              </table>
              <!-- biz_2 (E) -->


            </td>
          </tr>
          <tr>
            <td height="425" colspan="3" valign="top">


              <!-- biz_3 (S) -->
              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">General Commission</td>
                </tr>
              </table>

              <table class="search">
                <tr>
                  <td class="bg" valign="top">

                    <!-- Grid (S) -->
                    <table width="100%" id="mainTableB3S1">
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box3sheet1");</script></td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                  </td>
                </tr>
              </table>


              <div style="height:10px"></div>


              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">Container Handling Fee (CHF)</td>
                </tr>
              </table>

              <table class="search">
                <tr>
                  <td class="bg" valign="top">

                    <!-- Grid (S) -->
                    <table width="100%" id="mainTableB3S2">
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box3sheet2");</script></td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                  </td>
                </tr>
              </table>


              <div style="height:10px"></div>


              <table class="search" border="0">
                <tr>
                  <td class="title_h"></td>
                  <td class="title_s">T/S Commission</td>
                </tr>
              </table>

              <table class="search">
                <tr>
                  <td class="bg" valign="top">

                    <!-- Grid (S) -->
                    <table width="100%" id="mainTableB3S3">
                      <tr>
                        <td width="100%"><script language="javascript">ComSheetObject("box3sheet3");</script></td>
                      </tr>
                    </table>
                    <!-- Grid (E) -->

                  </td>
                </tr>
              </table>
              <!-- biz_3 (E) -->


            </td>
          </tr>
        </table>
        <!-- biz page (E) -->
      </div>


      <!-- Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding:5px 20px 10px 0px;">
        <tr>
          <td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_close">Close</td>
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