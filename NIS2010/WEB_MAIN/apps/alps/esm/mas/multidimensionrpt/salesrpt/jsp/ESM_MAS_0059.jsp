<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0059.jsp
*@FileTitle : 점소 Weekly 비정형 실적 분석 RPT Pop UP
*Open Issues :
*Change history :
* 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
* 2008.08.29 박상희 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[059]
* 2008.11.19 전윤주 CSR No. N200811060003 MAS_Report 기능 개선(2) 선택된 option 상하로 이동
* 2009.10.23 김기대 New FrameWork 적용
* 2010.09.01 김기종 CSR No. CHM-201004982-01 MAS Architecture 위배사항 수정 (CommonSC)
*@LastModifyDate : 2010.09.01
*@LastModifier : 김기종
*@LastVersion : 1.0

History
2016.03.14 김성욱  OOME 발생 방지를 위한 검색 제약조건 강화
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException = null;
    String strErrMsg = "";
    String userId = "";
    String selGroup = "";
    String pColDesc = "";
    String reportFormPopupCallCnt = "";

    Logger log = Logger.getLogger("com.hanjin.alps.esm.mas.ESM_MAS_0059");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        //추가----------------------------------------------------------------------------------------- START
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        pColDesc = JSPUtil.getParameter( request, "col_desc");
        reportFormPopupCallCnt = JSPUtil.getParameter( request, "call_cnt");

        pColDesc = StringUtil.xssFilter(pColDesc);
        reportFormPopupCallCnt = StringUtil.xssFilter(reportFormPopupCallCnt);
        
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
        //추가----------------------------------------------------------------------------------------- END

    }catch(Exception e) {
    	log.error("JSP Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Set Customized Report Form</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
</head>
<body onload="javascript:setupPage();">
<iframe height="0" width="0" name="frmHidden"></iframe>
<form method="post" name="form"  onKeyUp="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="f_group">
<input type="hidden" name="f_header">
<input type="hidden" name="f_headernm">
<input type="hidden" name="f_dividename">
<input type="hidden" name="f_p_col_desc" value="<%=pColDesc%>">
<input type="hidden" name="f_p_call_cnt" value="<%=reportFormPopupCallCnt%>">
<!-- OUTER - POPUP (S)tart -->
<table width="600" class="popup" cellpadding="10" border="0">
  <tr><td class="top"></td></tr>
  <tr>
    <td valign="top">
      <!-- : ( Title ) (S) -->
      <table width="100%" border="0">
        <tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Set Customized RPT Form</td></tr>
      </table>
      <!-- : ( Title ) (E) -->

      <!-- : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <!-- : ( Select Customized Form ) (S) -->
            <table class="search" border="0">
              <tr class="h23">
                <td width="30%"><img class="nostar">Select Customized Form</td>
                <td width="70%">
                	<script language="javascript">ComComboObject('f_selgroup',1, 150 , 0 )</script>
                </td>
              </tr>
            </table>
            <!-- : ( Select Customized Form ) (E) -->

            <table class="line_bluedot"><tr><td colspan="6"></td></tr></table>


            <!-- : ( Grid ) (S) -->
            <table class="search" border="0">
              <tr>
                <td width="42%" style="padding-left:3;">
                  <table width="100%" id="mainTable1">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet1');</script>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="8%" rowspan="2" valign="middle" align="center">
                  <img src="/hanjin/img/button/btns_add.gif" width="26" height="26" border="0" name="btns_add"><br><br>
                  <img src="/hanjin/img/button/btns_del.gif" width="26" height="26" border="0" name="btns_del">
                </td>
                <td width="42%" style="padding-left:3;">
                  <table width="100%" id="mainTable2">
                    <tr>
                      <td>
                        <script language="javascript">ComSheetObject('sheet2');</script>
                      </td>
                    </tr>
                  </table>
                </td>
                <td width="8%" rowspan="2" valign="middle" align="center">
                  <img src="/hanjin/img/button/btns_up.gif" width="38" height="26" border="0" name="btns_up"><br><br>
                  <img src="/hanjin/img/button/btns_down.gif" width="38" height="26" border="0" name="btns_down">
                </td>
              </tr>
              <tr>
                <td valign="top"></td>
                <td valign="top"></td>
              </tr>

              <tr>
                <td class="height_10" colspan="4">
                  <table class="line_bluedot"><tr><td></td></tr></table>
                </td>
              </tr>


              <tr>
                <td colspan="4" class="sm">
                  <input type="radio" class="trans" name="saveYn" value="n">&nbsp;Use This Setting At This Time Only
                </td>
              </tr>
              <tr>
                <td colspan="4" class="sm">
                  <input type="radio" class="trans" name="saveYn" value="y" checked>&nbsp;Save This Setting For Later As&nbsp;&nbsp;
                  <input type="text" style="width:160;" name="f_savename" value="">
                </td>
              </tr>
            </table>
            <!-- : ( Grid ) (E) -->
          </td>
        </tr>
      </table>
      <!-- : ( Search Options ) (E) -->

    </td>
  </tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
  <tr>
    <td height="71" class="popup">
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
        <tr>
          <td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
              <tr>
                <!-- Repeat Pattern -->
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_New" id="btn_New">New</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Save" id="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Delete" id="btn_Delete">Delete</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>

                <td class="btn1_line"></td>

                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" name="btn_Close" id="btn_Close">Close</td>
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
    </td>
  </tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>