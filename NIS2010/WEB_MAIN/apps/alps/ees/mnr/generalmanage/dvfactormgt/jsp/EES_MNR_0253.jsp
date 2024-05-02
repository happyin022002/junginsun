<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESS_MNR_0253.jsp
*@FileTitle : Container Seal No-Creation
*Open Issues :	Container Seal No-Creation 를 조회, 등록,수정,삭제하는 화면
*Change history :
*@LastModifyDate : 2011.03.29
*@LastModifier : 김영오
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2011.04.28 김영오 [CHM-201108634-01] 메일 전송버튼 텍스트 변경
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0253Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
EesMnr0253Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesMnr0253Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title><span id="title"></span></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
  var usrId = "<%=strUsr_id%>";
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      showErrMessage(errMessage);
    } // end if
    loadPage();
  }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="userId" value ="<%=strUsr_id%>">
<input type="hidden" name="seal_no_chk" value ="N">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
  <tr>
    <td valign="top">
      <!--Page Title, Historical (S)-->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
              <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!--Page Title, Historical (E)-->

      <!--Button (S) -->
      <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;">
            <tr>
              <td class="btn1_bg">
              <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Retrieve">Retrieve</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_New">New</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr><td class="btn1_left"></td>
                    <td class="btn1" name="btn_Save">Save</td>
                    <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
        <!--Button (E) -->

      <!--biz page (S)-->
      <table class="search" id="mainTable">
            <tr>
              <td class="bg">
            <table class="search" border="0" style="width:979;">
              <tr class="h23">
                <td width="230" align="center">Plan Year</td>
                <td width="280" align="left"><input type="text" maxlength=4 style="width:40;text-align:center;" class="input" name="fr_year" required fullfill>
                <img name ="btn_fryear" src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">
                </td>

                <td><select name="pln_month" style="width:55;">
                  <option value="01" selected>1 Half</option>
                  <option value="07">2 Half</option>
                  </select>
                </td>

                <td width="80%" align="center">&nbsp;</td>
              </tr>
            </table>
          </td>
        </tr>
      </table>

      <table class="height_8"><tr><td></td></tr></table>
      <table class="search" id="mainTable">
            <tr>
              <td class="bg">

          <!-- Grid  (S) -->
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
          <!-- Grid (E) -->
          <!-- Grid  (S) -->
          <div style="display:none">
            <table width="100%"  id="mainTable">
              <tr>
                <td width="100%">
                  <script language="javascript">ComSheetObject('sheet2');</script>
                </td>
              </tr>
            </table>
          </div>
          <!-- Grid (E) -->

          <!--  Button_Sub (S) -->
          <table width="100%" class="button">
                <tr>
                  <td class="btn2_bg">
                <table border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_RowAdd">Row Add</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table>
                    </td>
                    <td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_delete">Row Delete</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table>
                    </td>
                    <td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_DownExcel">Down Excel</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table>
                    </td>
                    <td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_Format_DownExcel">Format Down Excel</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table>
                    </td>
                    <td>
                      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr>
                          <td class="btn2_left"></td>
                          <td class="btn2" name="btn_loadExcel">Load Excel</td>
                          <td class="btn2_right"></td>
                        </tr>
                      </table>
                    </td>
                  </tr>
                </table>
              </td>
            </tr>
          </table>
            <!-- Button_Sub (E) -->
          </td>
        </tr>
      </table>
      <!-- 2 (E) -->
      <!--biz page (E)-->
    </td>
  </tr>
</table>
  <table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>