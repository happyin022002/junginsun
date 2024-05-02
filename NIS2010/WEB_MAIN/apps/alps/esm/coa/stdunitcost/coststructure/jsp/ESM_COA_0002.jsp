<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0002.jsp
*@FileTitle : 물류비용 코드 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-13
*@LastModifier : OKYOUNG IM
*@LastVersion : 1.0
* 2006-10-13 OKYOUNG IM
* 1.0 최초 생성
* =========================================================
* History
* 2008.05.02 임옥영 R200804296327 CSS파일 경로 변경
* 2008.09.05 전성진 CSR No.N200809030003
*                       - 7레벨 추가로 크기 변경
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.07.09 김기대 New Framework 적용
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
                   CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
* 2014.05.09 박다은 [CHM-201430133] [COA] Register Cost Item의 Save 기능 제한 요청
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
* 2015.08.31 손진환 [CHM-201536992] Split14-[그룹사 표준 코드 시행] HJS 프로그램 대응 및 데이타 마이그레이션 작업 요청
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.coststructure.event.EsmCoa0002Event"%>

<%
    EsmCoa0002Event  event = null;              //PDTO(Data Transfer Object including Parameters)
    GeneralEventResponse eventResponse = null;  //RDTO(Data Transfer Object including DB ResultSet)

    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                               //에러메세지

    String userId   = "";
    String userName = "";
	String strOfc_cd = "";

    try {

        SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
        userId    = account.getUsr_id();
        //userAuth=account.getAuth();
        userName  = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

        event = (EsmCoa0002Event)request.getAttribute("Event");
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
<title>Register C/A Code</title>
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

<body onload="javascript:setupPage();">
<form name = "hiddenF" mehhod="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="sRow" value=""><!-- 콤보리스트가 변화된 row -->
<input type="hidden" name="changeCol" value=""><!-- 콤보리스트에서 변화된 컬럼, value: stnd_cost_tp_cd, mgrp_cost_cd -->
<input type="hidden" name="changeValue" value=""><!-- 콤보리스트가 변화된 컬럼의 값 -->
</form>
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="cond1" value="1">



<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
  <tr>
    <td>

    <!--  hidden form's iframe -->
    <!--iframe height="0" width="0" name="frmHidden"></iframe-->
    <!--  hidden form's iframe -->


      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr>
          <td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
        </tr>
        <tr>
          <td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


      <!-- TABLE '#D' : ( Button : Main ) (S) -->
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
                      <td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
                      <td class="btn1_right"></td>
                    </tr>
                  </table>
                </td>
                <td class="btn1_line"></td>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                      <td class="btn1_left"></td>
                      <td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td>
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
      <!-- TABLE '#D' : ( Button : Main ) (E) -->



      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <!-- : ( Location ) (S) -->
            <table class="search_in" border="0"">
              <tr class="h23">
                <td><input type="radio" value="1" class="trans"  name="code" checked>&nbsp;Cost Element&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="2" class="trans" name="code" onClick="goURL(2)">&nbsp;So Cost Code</td>
              </tr>
            </table>
            <!-- : ( Location ) (E) -->

          </td>
        </tr>
      </table>
      <!-- TABLE '#D' : ( Search Options ) (E) -->

      <table class="height_10"><tr><td></td></tr></table>

      <!-- TABLE '#D' : ( Search Options ) (S) -->
      <table class="search">
        <tr>
          <td class="bg">

            <table class="search" border="0">
              <tr>
                <td class="title_h"></td>
                <td class="title_s">Register Cost Items</td>
                <td rowspan="2" class="gray">
                <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_COA_0138.do?','','width=800, height=600, menubar=no, scrollbars=no, resizable=yes')"
                class="purple">Inquiry Office</a>
                <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_COA_0130.do','','width=800,height=400, menubar=0, scrollbars=0, resizable=yes');" class="purple"> Report View Management</a>
                <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5"><a href="javascript:ComOpenWindow2('ESM_COA_0001.do','','width=400,height=400, menubar=0, scrollbars=0, resizable=yes')" class="purple">Set List-boxes</a></td>
              </tr>
              <tr>
                <td class="height_5"></td>
              </tr>
            </table>

            <!-- : ( From Location ) (S) -->
            <table width="100%" id="mainTable">
              <tr>
                <td>
                  <script language="javascript">ComSheetObject('sheet1');</script>
                </td>
              </tr>
            </table>
            <!-- : ( From Location ) (E) -->

            <!-- : ( Button : Grid ) (S) -->
            <table width="100%" class="button">
              <tr>
                <td class="btn2_bg">
                  <table border="0" cellpadding="0" cellspacing="0">
                    <tr>
					<%
						//[CHM-201430133] [COA] Register Cost Item의 Save 기능 제한 요청
						if("SELOPA".equals(strOfc_cd)||"SELCSG".equals(strOfc_cd)) {
					%>
                      <!-- Repeat Pattern -->
                      <!--
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                          <tr>
                            <td class="btn2_left"></td>
                            <td class="btn2" id="btng_save" name="btng_save">Save</td>
                            <td class="btn2_right"></td>
                          </tr>
                        </table>
                      </td>
                      -->
					<%
					}
					%>                      
                      <!-- Repeat Pattern -->
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
            <!-- : ( Button : Grid ) (E) -->

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
