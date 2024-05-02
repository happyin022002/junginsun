<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0009.jsp
*@FileTitle : ECC별 MT 표준단가&MT Turntime 생성
*Open Issues :
*Change history : LCC추가에 따른 변경
*@LastModifyDate : 2009-08-20
*@LastModifier : Ari
*              : YJ Jeon
               : 박수훈
*@LastVersion : 1.1
* 2006-11-16 IM OKYOUNG
* 1.0 최초 생성 

* Change history : 2008.08.05 전윤주 
*                  CSR NO. N200807170013 COA_EQ Repo 단가 조회 화면 변경
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.08.20 박수훈 New Framework 적용[0009]
* 2010.09.01 김기종 [CHM-201004982-01] COA Architecture 위배사항 수정
* 2010.09.30 이윤정 [CHM-201006104-01] EQ Repo Cost(PA) 메뉴 ECC 조회기능 수정
* 2012.09.10 이석준 [CHM-201220070-01] EQ Repo Cost (PA) 화면에 Month Copy 기능 추가 
* 2015.07.07 이윤정 [CHM-201536740] COA 내 화면의 조회 기능 (Retrieve, Down Excel)을 뺀 나머지 버튼들을 비활성화 요청 CSR
=========================================================*/ 
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.stdunitcost.mtcost.event.EsmCoa0009Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmCoa0009Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	//사용 변수
	String f_cost_yrmon = JSPUtil.getNullNoTrim(request.getParameter("f_cost_yrmon"));
	String f_cntr_tpsz_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cntr_tpsz_cd"));
	String f_cost_loc_grp_cd = JSPUtil.getNullNoTrim(request.getParameter("f_cost_loc_grp_cd"));
	if("".equals(f_cost_loc_grp_cd)) f_cost_loc_grp_cd = "E";
	String f_ecc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_ecc_cd"));
	String f_lcc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_lcc_cd"));
	String f_rcc_cd = JSPUtil.getNullNoTrim(request.getParameter("f_rcc_cd"));
	
	Logger log = Logger.getLogger("com.hanjin.apps.STDUnitCost.MTCost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EsmCoa0009Event)request.getAttribute("Event");
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
<title>EQ Repo Cost (PA) </title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

//2010.09.29 이윤정 [CHM-201006104-01] hard-cording으로 가져오던 ECC 목록을 DB에서 가져 오는 방식으로 변경 하면서 하드코딩 부분 삭제
	function setupPage(){
        var errMessage = "<%=strErrMsg%>";

        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if

        loadPage();
        ComSetFocus(document.form.f_cost_yrmon);
    }
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onKeyDown="changeSearchSheet();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="f_cntr_tpsz_cd2" value="">
<input type="hidden" name="f_cntr_tpsz_cd3" value="">
<input type="hidden" name="p_cost_yrmon" value="">
<input type="hidden" name="p_fcntr_ecc_cd" value="">
<input type="hidden" name="p_cntr_tpsz_cd" value="">
<input type="hidden" name="p_cntr_io_vol_sts_cd" value="">
<input type="hidden" name="p_ori_dest" value="">
<input type="hidden" name="v_ofc_cd" value="<%=strOfc_cd %>"> 


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

					<!--
					<td class="btn1_line"></td>
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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">

						<!-- : ( Month ) (S) -->
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="7%">YYYY-MM</td>
								<td width="8%"><input type="text" class="input1" name="f_cost_yrmon" style="width:60" maxlength="7" onKeyPress="ComKeyOnlyNumber(window)" onBlur="addDash(this , 4);"  onChange="setPeriod(this);" onFocus="this.value=ComReplaceStr(this.value, '-', '');" ></td>
								<td width="14%" class='sm'><div id='div_period'></div></td>
								<td width="13%">Location Hierarchy</td>
								<td width="10%"><select name="f_cost_loc_grp_cd" style='width:60' onChange="changeLocationHierarchy(this.value)">
									<OPTION value='E' <%= "E".equals(f_cost_loc_grp_cd)?"selected":""%>>ECC</OPTION>
									<OPTION value='L' <%= "L".equals(f_cost_loc_grp_cd)?"selected":""%>>LCC</OPTION>
									<OPTION value='R' <%= "R".equals(f_cost_loc_grp_cd)?"selected":""%>>RCC</OPTION>
								</select></td>

								<td>
									<div id="div_ecc" style="display:<%= "R".equals(f_cost_loc_grp_cd)?"none":"inline"%>">
									ECC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('f_ecc_cd', 1, 70 , 0 )</script></div>
								</td>

								<td>
									<div id="div_lcc" style="display:<%= "R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
									LCC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('f_lcc_cd', 1, 70 , 0 )</script></div>
								</td>

								<td>
									<div id="div_rcc" style="display:<%= "R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
									RCC&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('f_rcc_cd', 1, 70 , 0 )</script></div>
								</td>

								<td width="8%">Type/Size</td>
								<td width="25%"><script language="javascript">ComComboObject('f_cntr_tpsz_cd', 1, 70 , 0 )</script></td>
							</tr>
						</table>
						<!-- : ( Month ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->

				<table class="height_10">
					<tr>
						<td></td>
					</tr>
				</table>

				<!-- TABLE '#D' : ( Search Options ) (S) -->
				<table class="search">
					<tr>
						<td class="bg">

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">MT Repo. Unit Cost Inquiry (Per MT Vol.)</td>
							</tr>
						</table>

						<!-- : ( Full Based ) (S) -->
						<table class="search" border="0" style="width:100%;">
							<tr class="h23">
								<td width="90%"><input type="radio" name="kind" value="1" class="trans" onClick="changeSheet(this.value);">&nbsp;EMU Cost <label for="kind" style="font-weight:normal;">(MT Repo Cost, Prev. Full Based Cost)</label>&nbsp;&nbsp;&nbsp;&nbsp;
												<input type="radio" name="kind" value="2" class="trans" onClick="changeSheet(this.value);" checked>&nbsp;Base Cost <label for="kind" style="font-weight:normal;">(Prev. Simulated Cost)</label></td>
								<td align="right" valign="bottom" class="sm"><a href="javascript:ComOpenPopup('/hanjin/COM_ENS_051.do', 850, 490,	'', '1,0,1,1,1,1,1,1,1,1,1,1', true);" class="purple">Location</a>&nbsp;</td>
								<td class="gray">(USD)</td>
							</tr>
							<tr>
								<td class="height_2"></td>
							</tr>
						</table>
						<!-- : ( Full Based ) (E) -->


						<!----------------------------------------------------------------- MT Start ---------------------------------------------------------->
						<div id = "div_mt" style="display:inline">
						<div id="mt_ecc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"none":"inline"%>">


						<!-- : ( From Location ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_EccStatus1" name="btng_EccStatus1">ECC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="70">ECC Status</td>
								<td class="title_s" align="left">
								<div id="div_period2"></div>
								</td>
							</tr>
							<tr><td class="height_5" colspan="2"></td></tr>
						</table>

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table> <!-- ECC Status , sheet 2번  -->



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RouteDetail1" name="btng_RouteDetail1">Route Detail 1</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr class="h23">
								<td width="45">ECC</td>
								<td width="140"><input type="text" name="f_ecc_cd2" value="" style="width:60" disabled class="input2"></td>
								<td width="130"><input type="radio" name="f_ori_dest" value="0" class="trans" onClick="reSearch();">&nbsp;Origin (From)</td>
								<td><input type="radio" name="f_ori_dest" value="1" class="trans" onClick="reSearch();">&nbsp;Destination (To)</td>
							</tr>
							<tr>
								<td class="height_2"></td>
							</tr>
						</table> <!-- ECC, Origin, Dest radio button -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script>
								</td>
							</tr>
						</table>



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RouteDetail2" name="btng_RouteDetail2">Route Detail 2</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->
						</div>



						<!-- LCC start-->
						<div id="mt_lcc_sheet" style="display:<%="L".equals(f_cost_loc_grp_cd)?"inline":"none"%>">

						<!-- : ( From Location ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet4');</script>
								</td>
							</tr>
						</table>



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_LccStatus1" name="btng_LccStatus1">LCC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="70">LCC Status</td>
								<td class="title_s" align="left">
								<div id="div_period"></div>
								</td>
							</tr>
							<tr>
								<td class="height_5" colspan="2"></td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet5');</script>
								</td>
							</tr>
						</table>
						</div>
						<!-- LCC end-->


						<!-- RCC start-->
						<div id="mt_rcc_sheet" style="display:<%="R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">


						<!-- : ( From Location ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet6');</script>
								</td>
							</tr>
						</table>

						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RccStatus1" name="btng_RccStatus1">RCC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="150">RCC Status</td>
								<td class="title_s" align="left">
								<div id="div_period"></div>
								</td>
							</tr>
							<tr>
								<td class="height_5" colspan="2"></td>
							</tr>
						</table>

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet7');</script>
								</td>
							</tr>
						</table>
						</div>
						<!-- RCC end-->
						</div>
						<!-----------------------------------------------------------------  MT End   ---------------------------------------------------------->

						<!----------------------------------------------------------------- Full Start --------------------------------------------------------->
						<div id = "div_full" style="display:none">
						<div id="full_ecc_sheet"
							style="display:<%="R".equals(f_cost_loc_grp_cd)?"none":"inline"%>">

						<!-- : ( ECC ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet8');</script>
								</td>
							</tr>
						</table> <!-- Full based MT 기본 data 보여주는 sheet 8번  -->
						<!-- : ( ECC ) (E) -->



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_EccStatus2" name="btng_EccStatus2">ECC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>


						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="70">ECC Status</td>
								<td class="title_s" align="left">
								<div id="div_period2"></div>
								</td>
							</tr>
							<tr>
								<td class="height_5" colspan="2"></td>
							</tr>
						</table> <!-- ECC Status 글씨 -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet9');</script>
								</td>
							</tr>
						</table> <!-- ECC Status 보여주는 sheet 9번  -->



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RouteDetail3" name="btng_RouteDetail3">Route Detail 1</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr class="h23">
								<td width="45">ECC</td>
								<td width="140"><input type="text" name="f_ecc_cd3" value="" style="width:60" disabled class="input2"></td>
								<td width="130"><input type="radio" name="f_ori_dest2" value="0" class="trans"  onClick="reSearch2();">&nbsp;Origin (From)</td>
								<td><input type="radio" name="f_ori_dest2" value="1" class="trans" onClick="reSearch2();">&nbsp;Destination (To)</td>
							</tr>
							<tr><td class="height_2"></td></tr>
						</table> <!-- ECC, Origin, Dest radio button -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet10');</script>
								</td>
							</tr>
						</table>


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RouteDetail4" name="btng_RouteDetail4">Route Detail 2</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->

						</div>
						<!-- : ( From Location ) (E) -->

						<!-- LCC start-->
						<div id="full_lcc_sheet"
							style="display:<%="L".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
						<!-- : ( From Location ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet11');</script>
								</td>
							</tr>
						</table>



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_LccStatus2" name="btng_LccStatus2">LCC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="70">LCC Status</td>
								<td class="title_s" align="left">
								<div id="div_period"></div>
								</td>
							</tr>
							<tr>
								<td class="height_5" colspan="2"></td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet12');</script>
								</td>
							</tr>
						</table>
						</div>

						<!-- LCC end-->
						<!-- RCC start-->
						<div id="full_rcc_sheet"
							style="display:<%="R".equals(f_cost_loc_grp_cd)?"inline":"none"%>">
						<!-- : ( From Location ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet13');</script>
								</td>
							</tr>
						</table>



						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_RccStatus2" name="btng_RccStatus2">RCC Status</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s" width="200">RCC Status</td>
								<td class="title_s" align="left">
								<div id="div_period"></div>
								</td>
							</tr>
							<tr>
								<td class="height_5" colspan="2"></td>
							</tr>
						</table>
						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet14');</script>
								</td>
							</tr>
						</table>
						</div>

						</div>
						<!-- RCC end-->

						<!----------------------------------------------------------------- Full End  ---------------------------------------------------------->
						</td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<br>

</form>
</body>
</html>