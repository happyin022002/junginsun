<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0036.jsp
*@FileTitle : 항로 생성/조회/변경
*Open Issues :
*Change history :
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.23 김기대 New FrameWork 적용
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2012.06.08 이석준 [CHM-201218114-01] 삭제된 데이터를 원복할 수 있도록 기능 변경
*@LastModifyDate : 2010.05.28
*@LastModifier : 송호진
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
    Exception serverException   = null;                 //서버에서 발생한 에러
    String strErrMsg    = "";                           //에러메세지
    String usr_ofc_cd = "";
    Logger log = Logger.getLogger("com.hanjin.alps.esm.coa.ESM_COA_0036");
    try {
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		usr_ofc_cd = account.getOfc_cd();  //.getUserOffice2();
		if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    } catch(Exception e) {
        log.error("ESM_COA_0036 Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Create Lane Table </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
        var errMessage  = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input  type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="f_strlane" value = "N"><!-- 저장이후에 service lane 콤보만 다시 부르기 위해서 setting -->
<input type="hidden" name="f_usr_ofc_cd" value = <%=usr_ofc_cd%>>

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
                <!-- 
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_Save" name="btn_Save">Save</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                 -->
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
            <!-- : ( Year ) (S) -->
            <table class="search_in" border="0">
              <tr class="h23">
                <td width="5%">Trade</td>
                <td width="16%">&nbsp;<script language="javascript">ComComboObject('f_cbotrade',1, 80 , 0 )</script></td>
                <td width="6%">S.Lane</td>
			    <td width="16%">&nbsp;<script language="javascript">ComComboObject('f_cboslane',1, 80 , 0 )</script></td>
                <td><input type="checkbox" name="f_chkdel" value="Y" class="trans">&nbsp;Deleted Data</td>
              </tr>
            </table>
            <!-- : ( Year ) (E) -->
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
            <table width="100%" id="mainTable">
              <tr>
                <td align="right" valign="bottom">
                  <div id="div_zoom_in" style="display:inline"> <!-- absolute / relative -->
                    <img class="cursor" src="/hanjin/img/alps/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
                  </div>
                  <div id="div_zoom_out" style="display:none">
                    <img class="cursor" src="/hanjin/img/alps/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
                  </div>
                </td>
              </tr>
              <tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
            </table>
            <!-- : ( POR ) (E) -->

            <!--  Button_Sub (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>

                      <!-- Repeat Pattern -->
                      <!-- 
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btn_Rowadd" name="btn_Rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                       -->
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- Button_Sub (E) -->
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