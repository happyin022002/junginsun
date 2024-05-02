<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_057.jsp
*@FileTitle : 구간별 전사 표준단가(평균) 조회
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-05
*@LastModifier : IM OKYOUNG
*@LastVersion : 1.0
* 2007-02-05 IM OKYOUNG
* 1.0 최초 생성
=========================================================
' History :
' 2008.02.21 PEJ N200802280015 COA_Report 관련 수정 요청_1,2번항목
'                1. Monthly Average U/C[057]
'                - RA 기준 추가, Term 조건 추가
'                - Sheet 각각에 Total 값추가
'                - Profit Level을 OP를 선택했을때 OP항목에 해당하는 컬럼을 보여줌(동적으로)
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
' 2008.10.20 전윤주 N200810200014 Expense Detail로 테이블 변경하면서 sales 디렉토리로 소스분리 [057]
* 2009.10.12 김기식 Alps전환작업
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.05.13 김민아 [CHM-201110694-01] COA Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	
	String userId   = "";
    String ofc_cd   = "";
    String ofc_lvl  = "";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MultiDimensionRPT.SalesRPT");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		userId = account.getUsr_id();
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
<title>Monthly Average U/C(PFMC-Based) </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.f_cost_yrmon.focus();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<!-- 개발자 작업	-->
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->

        <!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
<!-- 
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_new" name="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
 -->
					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
        <!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( By Rev.  ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
				    <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Period</td>
					<td width="9%">YYYY-MM</td>
					<td width="18%">
						<input type="text" name="f_cost_yrmon" class="input1" style="width:60" value="" maxlength="7" 
						onKeyPress="ComKeyOnlyNumber(this, '-')" 
						onFocus="this.value = ComReplaceStr(this.value, '-', '');"
						onBlur="addDash(this , 4);" 
						 >		 			
					</td>
					<td width="9%">Type/Size</td>
					<td width="18%">
						<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 80 , 0 )</script>
					</td>
					<td>&nbsp;</td>
				</table>
        <table class="search_in" border="0">
            <tr>
              <td colspan="9" class="line_bluedot" style="height:11;"></td>
            </tr>				
        </table>    
        <table class="search_in" border="0">
          <tr class="h23">
              <td width="9%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
              <td width="9%"> Profit View</td>
              <td width="18%">
              	<script language="javascript">ComComboObject('f_pro_vw',1, 120 , 1 )</script>
              </td>
              <td width="9%">Profit Level</td>
              <td >
              	<script language="javascript">ComComboObject('f_pro_lvl',1, 80 , 1 )</script>
              </td>
          </tr>
        </table>
        <table class="search_in" border="0">
            <tr>
              <td colspan="9" class="line_bluedot" style="height:11;"></td>
            </tr>				
        </table>    
				<table class="search_in" border="0">
				<tr class="h23">
				    <td width="8%" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Route</td>
					<td width="359" style="padding-left:4;">
						<input type="radio" name="f_kind" value="1" onClick="InvOnChange('RadioLayer','Inline','none')" class="trans" checked>&nbsp;By Rev. POL - POD&nbsp;&nbsp;&nbsp;&nbsp;
					    <input type="radio" name="f_kind" value="2" onClick="InvOnChange('RadioLayer','none','Inline')"  class="trans">&nbsp;By Origin Destination</td>
					<td width="250" class="stm"><input type="text" name="f_from" value="" class="input1" style="width:80; ime-mode:disabled;"  maxlength="5" onKeyUp="upper(this);ComKeyEnter(this, document.form.f_to, 5);">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openLocationCode('getF_from');">&nbsp;~
					    <input type="text" name="f_to" value="" class="input1" style="width:80; ime-mode:disabled;" maxlength="5" onKeyUp="upper(this);">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onClick="openLocationCode('getF_to');"></td>
					<td><div id="term_div" style="display:none;">
							R term
							<script language="javascript">ComComboObject('f_rcv_term',1, 80 , 1 )</script>			
							D term
							<script language="javascript">ComComboObject('f_de_term',1, 80 , 1 )</script>	
						</div>
					</td>
					<td>&nbsp;</td>
					</tr>
				</table>
				<!-- : ( By Rev.  ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

<!--      By Rev.POL - POD 체크했을 경우 보임		-->

        <div id="RadioLayer" style="display:inline">
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="search" border="0">
				<tr><td class="gray">(USD)</td></tr>
				</table>

				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
			              </td></tr>
				</table>
				<!-- : ( RHQ ) (E) -->


				<!--  Button_Sub (S) -->
				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>

						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" id="btng_routedetail" name="btng_routedetail">Route Detail</td><td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->


					</tr></table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
         </div>
<!--  /////////////////// By Rev.POL - POD 체크했을 경우 보임		//-->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5"><tr><td></td></tr></table>

				<table class="search" border="0">
				<tr><td class="gray">(USD)</td></tr>
				</table>

				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
			              <tr><td>
			                     <script language="javascript">ComSheetObject('sheet2');</script>
			              </td></tr>
				</table>
				<!-- : ( RHQ ) (E) -->

				<!-- : ( Button : Grid ) (S) -->
				<table width="100%" class="sbutton">
		       	<tr><td class="align">

				    <table class="sbutton">
				    <tr><td class="bt"><!-- <img class="cursor" src="/hanjin/img/button/btng_bkgdetail.gif" width="90" height="19" border="0" name="btng_bkgdetail"> --></td></tr>
					</table>

				</td></tr>
				</table>
		    	<!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>