<%--=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : ESM_COA_0072.jsp
* @FileTitle : P&L by Lane
* Open Issues :
* Change history :
* @LastModifyDate : 2007-01-22
* @LastModifier : Kim Jong Beom
* @LastVersion : 1.0
*  2007-01-22 Kim Jong Beom
*  1.0 최초 생성   
 * =========================================================
 * History 
 * 2008.02.28 박칠서 N200801154875 주차와 월 조회 기준 분리
 * 2008.03.21 박칠서 N200803110013 Month 인식자 및 월별 분리 주차 검색조건 추가
 * 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
 * 2008.12.15 박은주 N200811270012 COA_BKG CM 기준 변경 [072]
 * 2009.02.04 박은주 N200901210014 조직개편 관련 기능 수정
 * 2009.03.16 김종열 N200903100130 - VVD Code에 영문 외 숫자도 입력가능하게 수정
 * 2009.04.03 배진환 N200903170122 COA_Multi-dimension report 조회권한 변경
 * 2009.04.22 박상희 N200904070094 CM 계산 수식 변경
 * 2009.05.14 배진환 N200905120702 param9에 f_ofc_cd 값셋팅 추가 ofc selectBox selected위해
 * 2009.05.18 배진환 N200905130071 - COA_조회 조건 입력 관련 수정
 * 2009-09-24 임옥영 Ticket ID:CHM-200900832 CNTR BU 수지분석 기준 변경(Vessel Pool 및 표준원가 반영)
 * 2009.10.26 김기식 Alps전환작업 
 * 2010.08.24 윤진영 [CHM-201005423] RHQ 컬럼 추가 
 * 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정 
 * 2011.05.11 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
 * 2012.06.25 이석준 [CHM-201218363-01] P&L by Lane Report data creation 기능 추가
 * 2012.10.15 이석준 [CHM-201220161-01] 실시간 영업현황 관련 UI
 * 2013.06.12 최성민 [CHM-201324876] [COA] COA Report내 "IAS Region " / "Bound2" 추가
 * 2013.08.08 최성민 [CHM-201325911] [COA] P&L 화면 일부 로직 수정
 * 2014.01.02 김수정 [CHM-201327858] [COA] IAS P&L 추가
=========================================================--%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%
	GeneralEventResponse eventResponse = null;
	Exception serverException = null;
	String strErrMsg = "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.coa.multidimensionrpt.multidimensionrpt.ESM_COA_0072");
	String userId = "";
	String ofc_cd = "";
	String ofc_lvl = "";
	String headCode1 = ""; //sheet1 가변
	String headName1 = "";
	String headCode2 = ""; //sheet2 가변
	String headName2 = "";
	String headCode3 = ""; //sheet3 가변
	String headName3 = "";
	String xml = "";
	try {
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} else {
			SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			userId = account.getUsr_id();
	        ofc_cd = account.getOfc_cd(); //getUserOffice2();
	        ofc_lvl = account.getUsr_auth_tp_cd(); //getUserLevel();
	        xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
	        
	        headCode1 = eventResponse.getETCData("headCode1");
	        headName1 = eventResponse.getETCData("headName1");
	        headCode2 = eventResponse.getETCData("headCode2");
	        headName2 = eventResponse.getETCData("headName2");
	        headCode3 = eventResponse.getETCData("headCode3");
	        headName3 = eventResponse.getETCData("headName3");
	        
		} //end of if
//		N200903120100 처리를 위해 ofc_cd, ofc_lvl을 무조껀 SELHO.  1로 바꿔준다
		ofc_cd = !"SELHO".equals(ofc_cd)?"SELHO":ofc_cd;
		ofc_lvl = !"1".equals(ofc_cd)?"1":ofc_lvl;
		
	} catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}

%>

<html>
<head>
<title>P&L by Lane</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage() {
		var formObj = document.form;
		var errMessage = '<%=strErrMsg%>';
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if

		loadPage("<%=headCode1%>","<%=headName1%>","<%=headCode2%>","<%=headName2%>","<%=headCode3%>","<%=headName3%>");
	}
</script>
</head>

<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="headCode1" value="<%=headCode1.toString()%>">
<input type="hidden" name="headCode1" value="<%=headName1.toString()%>">
<input type="hidden" name="headCode2" value="<%=headCode2.toString()%>">
<input type="hidden" name="headName2" value="<%=headName2.toString()%>">
<input type="hidden" name="headCode3" value="<%=headCode3.toString()%>">
<input type="hidden" name="headName3" value="<%=headName3.toString()%>">

<input type="hidden" name="v_ofc_cd"  value="<%=ofc_cd%>">
<input type="hidden" name="v_ofc_lvl" value="<%=ofc_lvl%>">
<input type="hidden" name="sXml" value="<%=xml%>"> 


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
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_create" name="btn_create">Create</td><td class="btn1_right"></td></tr></table></td>
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
<tr>
	<td class="bg">

		<table class="search_in" border="0">
		<tr class="h23">
			<td colspan="10"><script language="javascript">coaPeriod3_ofc();</script></td>
		</tr>
		</table>

		<table class="search_in" border="0">
		<tr><td class="line_bluedot" style="height:15;"></td></tr>
		</table>

		<table class="search_in" border="0">
		<tr class="h23">
			<td class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By View</td>
			<td>Profit View</td>
			<td>
				<script language="javascript">ComComboObject('f_pro_vw',1, 140 , 1 )</script>
			</td>
			<td>Office View</td>
			<td>
				<script language="javascript">ComComboObject('f_ofc_vw',1, 80 , 1 )</script>
			</td>
			<td>Profit Level</td>
			<td>
				<script language="javascript">ComComboObject('f_pro_lvl',1, 100 , 1 )</script>
			</td>
			<td><div id="div_display1" style="display:inline">By Object</div></td>
			<td>
				<div id="div_display2" style="display:inline">
					<script language="javascript">ComComboObject('f_pro_obj',1, 155 , 1 )</script>
				</div>
			</td>
		</tr>
		<tr><td colspan="9" class="line_bluedot" style="height:15;"></td></tr>
		<tr class="h23">
			<td class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Office</td>
			<td>Office Level</td>
			<td>
				<script language="javascript">ComComboObject('f_ofc_lvl',1, 140 , 1 )</script>
			</td>
			<td>Office</td>
			<td>
				<script language="javascript">ComComboObject('f_ofc_cd',1, 80 , 0 )</script>
			</td>
            <td colspan="2"><input type="checkbox" class="trans" name="f_excl_sts" value="Y">&nbsp;Exclude Sub </td>
			<td class="gray_tit" style="color:#7F9DB9;" ><div id="div_text" style="display:none"> TS Commitment based</div></td>
			<td align="right">
				<div id="div_display3" style="display:inline">OP View&nbsp;
					<SELECT name="f_op_view">
						<OPTION value="OP1">OP</OPTION>
						<OPTION value="OP4">OP4</OPTION>
						<OPTION value="OP5">OP5</OPTION>
						<OPTION value="OP6">OP6</OPTION>
					</SELECT>
				</div>
			</td>
		</tr>
		<tr><td colspan="9" class="line_bluedot" style="height:15;"></td></tr>
		<tr class="h23">
			<td width="9%" class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">By Lane</td>
			<td width="8%">Trade</td>
			<td width="18%">
				<script language="javascript">ComComboObject('f_trd_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Sub Trade</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_sub_trd_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">IAS Region</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_ias_rgn_cd',1, 100 , 0 )</script>
			</td>
			<td width="7%"></td>
			<td align="right"></td>
		</tr>
		<tr class="h23">
			<td width="9%" class="gray_tit"><td width="8%">Lane</td>
			<td width="18%">
				<script language="javascript">ComComboObject('f_rlane_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Bound</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_dir_cd',1, 80 , 0 )</script>
			</td>
			<td width="8%">Trade Dir.</td>
			<td width="13%">
				<script language="javascript">ComComboObject('f_trd_dir_cd',1, 100 , 0 )</script>
			</td>
			<td width="7%">VVD</td>
			<td align="right">
				<input type="text" size="4" name="f_vsl_cd"     maxlength="4" onKeyPress="ComKeyOnlyAlphabet('uppernum')" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55;" >
				<input type="text" size="4" name="f_skd_voy_no" maxlength="4" onKeyPress="ComKeyOnlyNumber(this);" onKeyUp="ComKeyEnter('LengthNextFocus');" style="ime-mode:disabled; width:55;">
				<input type="text" size="1" name="f_skd_dir_cd" maxlength="1" onKeyPress="ComKeyOnlyAlphabet('upper')" style="ime-mode:disabled; width:37;" >
			</td>
		</tr>
		<tr class="h23">
			<td width="9%" class="gray_tit">
				<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Report Type</td>
			<td colspan="2"><input type="checkbox" class="trans" name="f_init_cost" value="N" onClick="initCost_change();">&nbsp;Initial Network Cost Display</td>
			<td colspan="2"><input type="checkbox" class="trans" name="f_ias_flg" value="N" onClick="ias_change();">&nbsp;IAS P&L</td>
		</tr>
		</table>

	</td>
</tr>
</table>

<!-- TABLE '#D' : ( Search Options ) (E) -->
<table class="height_10"><tr><td></td></tr></table>



<!-- **************** Tab BG Box - 'B' (InSide) (S) ********************* -->
<!-- TABLE '#E' : ( Tab ) (S) -->
<table class="tab">
	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
</table>
<!-- TABLE '#E' : ( Tab ) (E) -->



<!-- TABLE '#D' : ( Search Options ) (S) -->
<table class="search">
<tr><td class="bg">


		<table class="search" border="0">
		<tr><td class="title_h"></td>
			<td class="title_s">Report Form</td></tr>
		</table>

		<!-- P&L Report -->
		<div id="tabPLLayer" style="display:inline; ">
	
		<!-- : ( Report Form ) (S) -->
		<table class="search" border="0" style="width:100%;">
		<tr class="h23">
			<td width="80">TEU Based</td>
			<td width="330" class="sm">
				<input type="radio" name="f_rdotype" class="trans" value="1" checked>&nbsp;By Account &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype" class="trans" value="2" >&nbsp;By Lane / BND &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype" class="trans" value="3" >&nbsp;By VVD</td>
			<td width="160">
				<div id = "div_kor" style="display:inline">
					<input type="radio" name= "f_iskorean" class="trans" value="1">&nbsp;KOR&nbsp;&nbsp;
					<input type="radio" name= "f_iskorean" class="trans" value="2" checked>&nbsp;ENG
				</div>
			</td>
	
			<td width="180">
				<div id = "div_chtBiz" style="display:none">
				<b>By Division</b>&nbsp;&nbsp;&nbsp;
				<SELECT name="f_chtbiz" onChange='changeChtBiz();' style='width:80'>
					<OPTION value=''>All</OPTION>
					<OPTION value=" CHT"> Cht-out</OPTION>
					<OPTION value=" BIZ"> HJS-sales</OPTION>
				</SELECT>
				</div>
			</td>
	
			<td width="180" valign="middle" align="right">&nbsp;</td>
	
	
			<td align="right" valign="bottom" style="padding-right:4;">
		        <div id="div_zoom_in1"  style="position:relative; right:0px; top:0px; display:inline"> <!-- absolute / relative -->
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out1" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in2"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in2" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out2" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out2" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in3"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in3" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out3" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out3" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in7"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in7" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out7" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out7" alt="Zoom out(-)">
				</div>
			</td>
		</tr>
		<tr><td class="height_5" colspan="3"></td></tr>
		</table>
		<!-- : ( Report Form ) (E) -->
	
		<table width="100%">
		<tr>
			<td width="100%">
				<div id="tabLayer1" style="display:inline">
				<table width="100%" id="mainTable1">
				<tr><td><script language="javascript">ComSheetObject('sheet1');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer2" style="display:inline">
				<table width="100%" id="mainTable2">
				<tr><td><script language="javascript">ComSheetObject('sheet2');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer3" style="display:inline">
				<table width="100%" id="mainTable3">
				<tr><td><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer7" style="display:inline">
				<table width="100%" id="mainTable7">
				<tr><td><script language="javascript">ComSheetObject('sheet7');</script></td></tr>
				</table>
				</div>
	
			</td>
		</tr>
		</table>
		</div>
		
				
		<!-- Adjusted P&L -->
		<div id="tabPLLayer" style="display:none; ">
		
		<!-- : ( Report Form ) (S) -->
		<table class="search" border="0" style="width:100%;">
		<tr class="h23">
			<td width="80">TEU Based</td>
			<td width="330" class="sm">
				<input type="radio" name="f_rdotype_a" class="trans" value="4" checked>&nbsp;By Account &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype_a" class="trans" value="5" >&nbsp;By Lane / BND &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="f_rdotype_a" class="trans" value="6" >&nbsp;By VVD</td>
			<td width="160">
				<div id = "div_kor_a" style="display:inline">
					<input type="radio" name= "f_iskorean_a" class="trans" value="1">&nbsp;KOR&nbsp;&nbsp;
					<input type="radio" name= "f_iskorean_a" class="trans" value="2" checked>&nbsp;ENG
				</div>
			</td>
	
			<td width="180">
				<div id = "div_chtBiz_a" style="display:none">
				<b>By Division</b>&nbsp;&nbsp;&nbsp;
				<SELECT name="f_chtbiz" onChange='changeChtBiz();' style='width:80'>
					<OPTION value=''>All</OPTION>
					<OPTION value=" CHT"> Cht-out</OPTION>
					<OPTION value=" BIZ"> HJS-sales</OPTION>
				</SELECT>
				</div>
			</td>
			
			<td width="180" valign="middle" align="right">
                <img class="cursor" src="/hanjin/img/alps/ico_newwin.gif" width="11" height="12" align="absmiddle" hspace="5">
                <a href="javascript:popupAdjCostDetail();" class="purple">Adjusted Cost Detail</a>
            </td>
	
			<td align="right" valign="bottom" style="padding-right:4;">
		        <div id="div_zoom_in4"  style="position:relative; right:0px; top:0px; display:inline"> <!-- absolute / relative -->
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in4" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out4" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out4" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in5"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in5" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out5" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out5" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in6"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in6" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out6" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out6" alt="Zoom out(-)">
				</div>
				<div id="div_zoom_in8"  style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_prev01.gif" width="20" height="11" border="0" name="bu_zoom_in8" alt="Zoom in(+)">
				</div>
				<div id="div_zoom_out8" style="position:relative; right:0px; top:0px; display:none">
				<img class="cursor" src="/hanjin/img/bu_next01.gif" width="20" height="11" border="0" name="bu_zoom_out8" alt="Zoom out(-)">
				</div>
			</td>
		</tr>
		<tr><td class="height_5" colspan="3"></td></tr>
		</table>
		<!-- : ( Report Form ) (E) -->
		
		<table width="100%">
		<tr>
			<td width="100%">
				<div id="tabLayer4" style="display:inline">
				<table width="100%" id="mainTable4">
				<tr><td><script language="javascript">ComSheetObject('sheet4');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer5" style="display:inline">
				<table width="100%" id="mainTable5">
				<tr><td><script language="javascript">ComSheetObject('sheet5');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer6" style="display:inline">
				<table width="100%" id="mainTable6">
				<tr><td><script language="javascript">ComSheetObject('sheet6');</script></td></tr>
				</table>
				</div>
				<div id="tabLayer8" style="display:inline">
				<table width="100%" id="mainTable8">
				<tr><td><script language="javascript">ComSheetObject('sheet8');</script></td></tr>
				</table>
				</div>
	
			</td>
		</tr>
		</table>
		</div>
		
		
		
		

		<table class="search" border="0">
		<tr><td height="18"><img src="/hanjin/img/ico_star.gif" border="0" hspace="3" align="absmiddle"><strong>Remark</strong></td></tr>
		<tr><td style="padding-left:11;" class="sm">
			<!-- img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
			CM for H/O = Total Revenue - Full Cost - EMU - Agt Comm - Own Vol Activity Cost - Oth Vol Activity Cost<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
			BKG CM for Non-H/O = Total Revenue - Full Cost - EMU - Agt Comm - Own Vol Activity Cost - STP Cost<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
			Branch CM for Non-H/O = BKG CM + STP Rev - Oth Vol Activity Cost -->

			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			BKG CM = Freight Rev + Misc OP Rev - Full Cost - EMU Cost - Agt Comm<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			BKG OP = BKG CM + DEM/DET - EQ Fixed Cost - Business Activity Cost - SMU Cost<br>
<!-- 	
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			Branch CM for Non-H/O = BKG CM + STP Profit<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			STP Profit = Balance(SVC OFC) - Balance(CONT OFC)<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			Balance(CONT OFC) = STP Expense - ABC for STP Expense(Minus Cost)<br>
			<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0" vspace="3">
			Balance(SVC OFC) = STP Revenue - ABC for STP Revenue</td></tr>
 -->
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

