<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_MAS_0016.jsp
*@FileTitle : UI_EQ Repo 회송기여도  Rule Set
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-15
*@LastModifier : Chilseo_Park
*@LastVersion : 1.0
* 2006-11-15 Chilseo_Park
* 1.0 Creation
*=========================================================
* History
* 2008.01.11 전윤주 CSR No. N200712280004 EQ repo rule-set X level 수정하고 저장할 수 있도록 변경
* 2008.05.06 전윤주 CSR No. R200804296329 내부 경로 변경
* 2008-06-05 전윤주 R200806037079 CSS 내부 경로 변경
* 2008.09.01 전윤주 CSR No.N200808260006 EQ repo rule-set(Rlane setting을 From-To ECC setting으로)
*                    장비 부족 지역 선정 ECC를 To-ECC에서 끌어다 쓰기 때문에 ECC setting 삭제
* 2011.01.11 이행지 [CHM-201108260-01]  [MAS]Rule-Set 화면 보완사항 처리
* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.09.10 장영석 New frame work 적용
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 :
*                    CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 이일민 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2012.03.22 김종준 [CHM-201217091-01] EMU 관련 로직 보완/변경 검토 요청의 건 -POR 별 Credit Ratio를 setup 할수 있는 화면추가 (Rule-set)
*=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
    Exception serverException   = null;         //서버에서 발생한 에러
    String strErrMsg = "";                               //에러메세지
    
    String strOfc_cd		= "";

    Logger log = Logger.getLogger("com.hanjin.apps.EQBalance.Eqbalance");

    try {
    	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd =	account.getOfc_cd();
		
        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }
    }catch(Exception e) {
        log.error("Exception : " + e.toString());
    }
%>
<html>
<head>
<title>Booking 소급</title>
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
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input name="f_ofc_cd" type="hidden" value="<%=strOfc_cd%>">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;&nbsp;Booking 소급</td></tr>
        </table>
        <!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

        <!-- TABLE '#D' : ( Button : Main ) (S) -->
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
            <tr><td class="btn1_bg">

                <table border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <!-- Repeat Pattern -->
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_New" name="btn_New">New</td><td class="btn1_right"></td></tr></table></td>
                    <td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                        <tr><td class="btn1_left"></td><td class="btn1" id="btn_Apply" name="btn_Apply">Apply</td><td class="btn1_right"></td></tr></table></td>
                    <!-- Repeat Pattern -->

                </tr></table>

            </td></tr>
        </table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->


        <!-- TABLE '#D' : ( Search Options ) (S) -->
        <table class="search">
          <tr>
            <td class="bg">
              <!-- : ( Location ) (S) -->
              <table class="search_in" border="0">
                <tr class="h23">
                  <td width="7%">Duration</td>
                  <td width="21%"><input type="text" name="f_fm_date" class="input1" style="width:70" maxlength="9"  onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDateDash(this);">~<input type="text" name="f_to_date" class="input1" style="width:70" maxlength="9"  onKeyPress="ComKeyOnlyNumber(window)" onFocus="this.value=ComReplaceStr(this.value, '-', '');" onBlur="addDateDash(this , 4);">
                  <img name="btn_calendar" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" style="cursor:hand;">
                  </td>
                  <td width="6%">Status</td>
                  <td width="16%"><script language="javascript">ComComboObject('f_status',1, 100 , 0 )</script></td>
                  <td width="50%"></td>
                </tr>

              </table>

              <!-- : ( Location ) (E) -->
            </td>
          </tr>
          
        </table>
        <!-- TABLE '#D' : ( Search Options ) (E) -->
        <table class="height_10">
          <tr>
            <td></td>
          </tr>
        </table>
  

        <table class="search">
          <tr>
            <td class="bg">
              <!-- : ( Month ) (S) -->
              
              <!-- : ( Location ) (E) -->
              <table width="100%" id="mainTable">	              
                <tr>
                  <td>
                    <script language="javascript">ComSheetObject('sheet1');</script>
                  </td>
                </tr>
                  <tr><td class="btn2_bg">
                  <table border="0" align="right" cellpadding="0" cellspacing="0">
	                  <tr>
	                      <!-- Repeat Pattern -->
	                      <td style="padding-top:10;">
	                      <table width="100%"  border="0" cellpadding="0" cellspacing="0" class="button">
	                      <tr>
	                        <td><input type="text" name="f_rownum" class="input" maxlength="4" style="width:40" style="height:17" onKeyPress="ComKeyOnlyNumber(window)"></td>
	                          <td width="10" > </td> 
	                      	  <td class="btn2_left"></td><td class="btn2" id="btng_RowAdd" name="btng_RowAdd">Row Add</td><td class="btn2_right"></td>
							  <td class="btn2_left"></td><td class="btn2" id="btng_RowDel" name="btng_RowDel">Delete</td><td class="btn2_right"></td>
							  <td class="btn2_left"></td><td class="btn2" id="btng_DownExcel" name="btng_DownExcel">Down Excel</td><td class="btn2_right"></td>
							  <td class="btn2_left"></td><td class="btn2" id="btng_LoadExcel" name="btng_LoadExcel">Load Excel</td><td class="btn2_right"></td>	                   
	                      </tr></table></td>
	                      <!-- Repeat Pattern -->
	                  </tr>
                  </table>
                
              </table>
              <!-- : ( Grid : Week ) (E) -->
            </td>
          </tr>
        </table>
      </td>
    </tr>
  </table>
  <!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->


</form>
</body>
</html>