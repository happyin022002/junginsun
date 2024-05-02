<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0013.jsp
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
* History
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.08.28 송호진 ALPS 전환
* 2010.05.28 송호진 [Legacy전환] UI 표준안 적용 요청 관련 수정 : 
	               CHM-200901714, CHM-200901715, CHM-200901716, CHM-200901717, CHM-200901718, CHM-200901719
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 COA Architecture 위배사항 수정
2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.event.EsmCoa0013Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
//	EsmCoa0013Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.EQHolding");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


//		event = (EsmCoa0013Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>실적장비비 표준단가 조회, 생성</title>
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
<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();" >
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


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>
					<!-- 
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
	                <td>
	                  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
	                    <tr>
	                      <td class="btn1_left"></td>
	                      <td class="btn1" id="btn_Month_Copy" name="btn_Month_Copy">Month Copy</td>
	                      <td class="btn1_right"></td>
	                    </tr>
	                  </table>
	                </td>
	                 -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_downexcel" name="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="7%">YYYY-MM</td>
					<td width="14%"><input type="text" class="input1" name="f_cost_yrmon" style="width:70" value="" maxlength="7" onKeyPress="ComKeyOnlyNumber(this);" onBlur="addDash(this, 4);" onFocus="ComClearSeparator(this, 'ym','-');this.select();" ></td>
					<td width="5%">TP/SZ</td>
					<td><script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 100 , 0 )</script></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- **************** Tab BG Box - 'A' (OutSide) (S) ********************* -->
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		<table class="search">
			<tr><td class="bg">

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">EQ Holding Cost Inquiry</td></tr>
				</table>


				<!-- : ( Demurrage ) (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="70%">
						<input type="radio" value="CNTR" class="trans" name="f_calc_term_cd" onClick="LayerView(1)" checked>&nbsp;Container&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" value="CHSS" class="trans" name="f_calc_term_cd" onClick="LayerView(2)">&nbsp;CHZ</td>
					<td width="30%" class="gray" rowspan="2">(USD)</td></tr>
				<tr><td class="height_2"></td></tr>
				</table>
				<!-- : ( Demurrage ) (E) -->


				<div id="RadioLayer" style="display:inline">
				<!-- : ( Grid : No. ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
						<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>

				<!-- : ( Grid : No. ) (E) -->

				</div>

				<div id="RadioLayer1" style="display:none">
				<!-- : ( Grid : No. ) (S) -->
				<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
					 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

					<table width="100%" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td></tr>
					</table>

				<!-- : ( Grid : No. ) (E) -->

				</div>

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>