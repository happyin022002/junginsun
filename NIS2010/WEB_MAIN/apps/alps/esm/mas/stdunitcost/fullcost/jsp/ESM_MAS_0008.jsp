<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0008.jsp
*@FileTitle : Route Cost (PA/RA)
*Open Issues :
*Change history :2007-06-07=EMS_MAS_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체
*@LastModifyDate : 2009-08-05
*@LastModifier : 박수훈
*@LastVersion : 1.0
* 2006-12-04 IM OKYOUNG
* 1.0 최초 생성
*=========================================================
* History :
* 2008-02-27 전성진 R200802265273 2007년 7월 이전 data 조회 시도 시 조회 불가 및 Error Message 보여줌
* 2008-04-29 전성진 R200804296328 css 파일 참조 확인 및 수정 요청
* 2008-09-22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치)
* 2009-08-05 박수훈 New Framework 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event.EsmMas0008Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmMas0008Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.FullCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmMas0008Event)request.getAttribute("Event");
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
<title>Route Cost (PA/RA) </title>
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

<body  onLoad="setupPage();">
<div id = "div_mas" style="display:inline">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Retrieve" name="btn_Retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>

					<td class="btn1_line"></td>

					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_Downexcel" name="btn_Downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


		<!-- Button (S) -->
		<table class="search">
		<tr><td class="bg">

				<!-- : ( By Office ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="21%"><input type="radio" class="trans" name="conditionType" value="0" onClick="changeConditionType(this.value);"> Orgin To Destination</td>
					<td width="4%">POR</td>
					<td width="17%">
						<input type="text" style="width:80" name="f_por" class="input1" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" disabled>
						<img class="cursor" src="/hanjin/img/button/btns_search_off.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search1" onClick="openLocationCode('getF_por');" disabled>
					</td>
					<!-- por, pol, pod, del class 활성화, 비활성화시 사용 -->
					<td width="4%">POL</td>
					<td width="17%"><input type="text" style="width:80" class="noact2" name="f_pol" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" disabled></td>
					<td width="4%">POD</td>
					<td width="17%"><input type="text" style="width:80" class="noact2" name="f_pod" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')"disabled></td>
					<td width="4%">DEL</td>
					<td><input type="text" style="width:80"  name="f_del" class="input1" value="" maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')" disabled>
						<img class="cursor" src="/hanjin/img/button/btns_search_off.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search2" onClick="openLocationCode('getF_del');" disabled>
					</td>
				</tr>
				<tr class="h23">
					<td><input type="radio" name="conditionType" class="trans" value="1" onClick="changeConditionType(this.value);" checked> Port To/From Inland</td>
					<td>From</td>
					<td>
						<input type="text" style="width:80" class="input1" name="f_from" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search3" onClick="openLocationCode('getF_from');">
					</td>
					<td>To</td>
					<td>
						<input type="text" style="width:80" class="input1" name="f_to" value="" maxlength="7" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum')">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="f_icon_search4" onClick="openLocationCode('getF_to');">
					</td>
					<td colspan="3">Location Hierarchy&nbsp;&nbsp;
							<select name="f_cost_loc_grp_cd"  style='width:98'>
							<OPTION value='N'>NODE</OPTION>
							<OPTION value='S'>SCC</OPTION>
							<OPTION value='E'>ECC</OPTION>
							<OPTION value='R'>RCC</OPTION>
						</select></td>
					</tr>
				</table>
				<!-- : ( By Office ) (E) -->

				<table class="search_in" border="0">
					<tr><td class="line_bluedot" colspan="7"></td></tr>
					<tr class="h23">
						<td width="9%" style="padding-left:25;">YYYY-MM</td>
						<td width="12%"><input type="text" class="input1" style="width:60" name="f_cost_yrmon" value="" maxlength="6"
							onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);"
							onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
						</td>
						<td width="7%">Type/Size</td>
						<td width="14%">
							<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 77 , 0 )</script>
						</td>
						<td width="11%" style="padding-left:5;">Activity Group</td>
						<td>

								<table border="0" style="height:15; width:325;">
			                       <tr>
			                       		<td width="200" style="padding-left:3;">
			                       			<script language="javascript">ComComboObject('f_act_grp_cd',1, 185 , 1 )</script>
										</td>
									<td class="sm">
										<input type="radio" class="trans" name="f_full_mty_cd"  value="F" onClick="showActGrpCombo();" checked>&nbsp;Full&nbsp;&nbsp;&nbsp;
										<input type="radio" class="trans" name="f_full_mty_cd" value="M" onClick="hideActGrpCombo();">&nbsp;Empty</td>
									</tr>
			                    </table>

						<td align="left">
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
		<!-- Button(E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
		<tr><td class="bg">

				<table class="height_10"><tr><td></td></tr></table>
				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
					<tr>
				    <td align="right" valign="bottom">
						<div id="div_zoom_in" style="display:inline">
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
						</div>
					</td>
					</tr>
					<tr><td>
						 <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( RHQ ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</div>

<div id = "div_prd" style="display:none">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
<tr>
<td valign="top">
<iframe width="100%" height="580" id="iframe_prd" frameborder="0" framespacing="0" scrolling="no"
src="/hanjin/ESD_PRD_0020.do?pgmNo=ESD_PRD_0020&sysCommUiTitle=Route Cost (PA/RA)&sysCommUiNavigation=Sales %26 Marketing > Cost Assignment > Multi-Dimension Report">
</iframe>
</td></tr>
</table>
</div>

</body>
</html>