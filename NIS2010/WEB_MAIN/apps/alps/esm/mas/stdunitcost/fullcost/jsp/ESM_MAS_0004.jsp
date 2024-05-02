<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0004.jsp
*@FileTitle :  Node Cost (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate :  2009.07.24
*@LastModifier : 박수훈
*@LastVersion : 1.1
* 2006-11-27 IM OKYOUNG
* 1.0 최초 생성
*=========================================================
* History :
* 2008-02-27 전성진 R200802265273 2007년 7월 이전 data 조회 시도 시 조회 불가 및 Error Message 보여줌
* 2008-04-29 전성진 R200804296328 css 파일 참조 확인 및 수정 요청
* 2008-09-22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009-07-24 박수훈  New Framework 적용
* 2010.09.01 김기종 Ticket ID:CHM-201004982-01 MAS Architecture 위배사항 수정
* 2011.03.18 김상수 [CHM-201109282-01] Split 04-ALPS의 Location 조회불가건 수정 보완 요청
*                                      - Location에 해당하는 input이나 sheet에 영문대문자와 숫자까지 입력되게 수정
* 2011.05.13 김민아 [CHM-201110694-01] MAS Report 화면 combo box validation 추가 - 자리수, 영문대문자, 숫자 입력 제한
*=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.stdunitcost.fullcost.event.EsmMas0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmMas0004Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.FullCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmMas0004Event)request.getAttribute("Event");
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
<title>Node Cost (PA/RA) </title>
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
<form name="form" onKeyDown="ComKeyEnter();">
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



		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<!-- : ( Location ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="7%">Location</td>
					<td width="18%"><input type="text" style="width:100" class="input1" name="f_loc_cd"  maxlength="5" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
					<td width="9%">Service Lane</td>
					<td ><input type="text" style="width:100" name="f_slan_cd" maxlength="3" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
					<td>&nbsp;</td>
					</tr>
				</table>
				<!-- : ( Location ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="search"><tr><td class="height_10"></td></tr></table>


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">

				<!-- : ( From Location ) (S) -->
				<!--
				<table class="search" border="0">
					<tr class="h23">
						<td align="right" valign="bottom">
						<table class="sbutton">
							<tr><td class="bt"><img class="cursor" src="/hanjin/img/button/btn_retrieve.gif" width="66" height="20" border="0" name="btn_Retrieve2"></td></tr>
						</table>

						</td></tr>
				</table>

				<table class="height_5"><tr><td></td></tr></table>
				-->

				<table border="0" width="400" style="background-color:white;" class="search" id="mainTable">
				<tr><td>
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td></tr>
				</table>
				<!-- : ( From Location ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>



		<!-- **************** Tab BG Box - 'A' (OutSide) (S) ********************* -->
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (S) -->
		<table class="search" border="0">
		<tr><td class="bg">

			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Standard Unit Cost Inquiry</td>
					<td align="right">


							<!--Button_L (S) -->
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve3" name="btn_Retrieve3">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>
							<!--Button_L (E) -->

					</td>
					</tr>
				<tr><td class="height_10" colspan="2"></td></tr>
			</table>


			<!-- : ( Month ) (S) -->
			<table class="search" border="0">
			<tr class="h23">
				<td width="90">YYYY-MM</td>
				<td width="220"><input type="text" style="width:60" class="input1" name="f_cost_yrmon" maxlength="6"
					onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);"
					onFocus="this.value=ComReplaceStr(this.value, '-', '');" >
				</td>
				<td width="120">Type/Size</td>
				<td width="240">
						<table border="0" style="height:15; width:205; ">
	                       <tr>
	                       		<td class="sm" width="80" style="padding-left:3;">&nbsp;<script language="javascript">ComComboObject('f_cntr_tpsz_cd',1, 70 , 0 )</script></td>
							<td class="sm"><input type="radio" class="trans" name="f_full_mty_cd"  value="F" onClick="showActGrpCombo();" checked>Full&nbsp;
								<input type="radio" class="trans" name="f_full_mty_cd" value="M" onClick="hideActGrpCombo();">Empty</td>
						</tr>
	                    </table>
				</td>
				<td width="90">Special Cargo</td>
				<td width="180">
						<table border="0" style="height:15; width:100%; ">
	                       <tr><td class="stm" style="padding-left:10;">
								<input type="checkbox" class="trans" name="f_spcl_cgo_dg_flg" value="Y">DG&nbsp;&nbsp;&nbsp;
								<input type="checkbox" class="trans" name="f_spcl_cgo_bb_flg" value="Y">BB&nbsp;&nbsp;&nbsp;
								<input type="checkbox" class="trans" name="f_spcl_cgo_awk_flg" value="Y">AK&nbsp;&nbsp;&nbsp;
								<input type="checkbox" class="trans" name="f_spcl_cgo_rf_flg" value="Y">RF</td>
						</tr>
	                    </table>

				</td>
				<td>&nbsp;</td>
			</tr>
			<tr class="h23">
				<td>Activity Group</td>
				<td><script language="javascript">ComComboObject('f_act_grp_cd',1, 170 , 1 )</script></td>
				<td>Location Hierarchy</td>
				<td style="padding-left:3">
					<select name="f_cost_loc_grp_cd"  style='width:70'>
						<OPTION value='N'>NODE</OPTION>
						<OPTION value='S'>SCC</OPTION>
						<OPTION value='E'>ECC</OPTION>
						<OPTION value='R'>RCC</OPTION>
					</select>
				</td>
				<td colspan="2"></td>
			    <td align="right" valign="bottom">
					<div id="div_zoom_in" style="display:inline">
					<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in" alt="Zoom in(+)">
					</div>
					<div id="div_zoom_out" style="display:none">
					<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out" alt="Zoom out(-)">
					</div>
				</td>
			</tr>
			</table>
			<!-- : ( Month ) (E) -->

			<table class="height_5"><tr><td></td></tr></table>

			<!-- : ( Grid : Week ) (S) -->
			<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,
				 'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->

			<table width="100%" id="mainTable">
				<tr><td>
					<script language="javascript">ComSheetObject('sheet2');</script>
				</td></tr>
			</table>
			<!-- : ( Grid : Week ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box - 'A' ) (E) -->


</td></tr>
</table>
<!-- Outer Table (E)-->

</form>
</body>
</html>