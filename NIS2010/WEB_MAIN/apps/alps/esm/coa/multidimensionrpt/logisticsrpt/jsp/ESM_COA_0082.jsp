﻿<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_COA_0082.jsp
*@FileTitle : Trans Mode별 Activity
*Open Issues :
*Change history :
* 2006-11-28 Kim Youngchul 1.0 최초 생성
* 2008-02-26 전성진 CSR.No R200802265273
*					- 대상항차 조회시 WK로 조회하면 SLS_YRMON 사용하게 변경
* 2008-04-03 전성진 CSR No. N200803310003
*					- 물류레포트 파일 분리
*					- Split by Month/Week 기능 추가 - data양이 많은 관계로 split시 2M/2W로 기간 제한함.
* 2008-05-07 전성진 CSR No. R200804296328
*					- css 파일 참조 확인 및 수정
* 2008-05-09 전성진 CSR No. N200804140007
*					- load, void vol -> teu / vol -> box 기준으로 변경, Colume에도 단위 입력.
* 					- Box/TEU 선택옵션 삭제
* 2008-07-24 김태윤 CSR No. N200803310003
*					- 물류레포트 Vol 분리
* 2008.09.22 김태윤 N200808278919 Spilt 01-COA_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
* 2009.10.19 최인경 New Framework 적용
* 2010.12.01 김기종 Ticket ID:CHM-201006305-01 COA Architecture 위배사항 수정
* 2011.05.11 최윤성 [CHM-201110694-01] COA Report 화면 combo box validation 추가
* 2011.06.21 이석준 [CHM-201111642-01] COA Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
* 2011.08.31 최성민 [CHM-201113156-01] [COA] Logistics Exp. By Office화면에서 R.Month / S.Month 구분 관련
* 2012.02.28 이석준 [CHM-201216447-01] COA화면 default값 변경 요청
* 2014.07.15 PEJ [CHM-201431087] [COA] Multi-Dimension Report > Logistics PFMC > Expense 화면 조회로직 변경요청 (문구추가)
* 2014.08.13 박은주 [CHM-201431516]  Logistics PFMC Report - KPI 3 추가 및 화면변경 요청사항
*@LastModifyDate : 2009-10-19
*@LastModifier : Choi In-Kyung
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.apps.alps.esm.coa.multidimensionrpt.logisticsrpt.event.EsmCoa0082Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmCoa0082Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지

	Logger log = Logger.getLogger("com.hanjin.apps.multidimensionrpt.logisticsrpt");
	
	try {
		event = (EsmCoa0082Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		log.error("JSP Exception : " + e.toString());
	}
%>
<html>
<head>
<title>Logistics Expense by Node & Link</title>
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
<iframe height="0" width="0" name="frmHidden"></iframe>
<body onload="javascript:setupPage();">
<form name="form" method="post"  onKeyDown="keyEnterTmlTrs();">
<input	type="hidden" name="f_cmd">
<input  type="hidden" name="iPage">
<input  type="hidden" name="f_report" value="1">

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle">
					<span id="navigation"></span>
				</td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
					<span id="title"></span>
				</td>
			</tr>
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
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr>
							<td class="btn1_left"></td>
							<td class="btn1" id="btn_DownExcel" name="btn_DownExcel">Down Excel</td>
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
              <table class="search_in" border="0">
              		<tr class="h23">
						<td width="104" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Period</td>
						<td colspan="2"><script language="javascript">coaPeriod3();</script></td>
						<td>Split by Month / Week&nbsp;&nbsp;<input type="checkbox" name="f_split_mw" value="T" checked class="trans"></td>
					</tr>
                    <tr class="h23">
                    	<td></td>
                    	<td width="205"></td>
                    	<td width="414" class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
			        	  [ by Mon - effective from July(2007) &nbsp;&nbsp;
			        	    by Week - effective from 27WK(2007) ]</td>
			        	<td>&nbsp;</td>
                    </tr>
                </table>


				<table class="search_in" border="0">
					<tr class="h23">
						<td width="110" class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Trade/Lane</td>
						<td width="105">Trade</td>
						<td width="200">
							<script language="javascript">ComComboObject('f_trd_cd',1, 100 , 0 )</script>
						</td>
						<td width="111">Lane</td>
						<td width="200">
							<script language="javascript">ComComboObject('f_rlane_cd',1, 100 , 0 )</script>
						</td>
						<td width="95">Direction</td>
						<td>
							<script language="javascript">ComComboObject('f_skd_dir_cd',1, 70 , 0 )</script>
						</td>
					</tr>
					<tr class="h23">
						<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Organization</td>
						<td>RHQ</td>
						<td>
							<script language="javascript">ComComboObject('f_rhq_cd',1, 100 , 0 )</script>
						</td>
						<td>Control Office</td>
						<td>
							<script language="javascript">ComComboObject('f_ctrl_ofc_cd',1, 100 , 0 )</script>
						</td>
						<td colspan="2"></td>
					</tr>
					<tr class="h23">
						<td class="gray_tit"><img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Activities</td>
						<td>Cost Group</td>
						<td>
							<SELECT style='width:100' name="f_lgs_kpi_cost_grp_cd" onChange="changeCostGroup(this.value);">
								<OPTION value="TM">TMNL</OPTION>
								<OPTION value="TR">TRANS</OPTION>
							</SELECT>
						</td>
						<td>In/Out</td>
						<td>
							<SELECT style='width:100' name="f_in_out">
								<OPTION value="">All</OPTION>
								<OPTION value="I">In</OPTION>
								<OPTION value="O">Out</OPTION>
								<OPTION value="T">T/S</OPTION>
								<OPTION value="R">RBC</OPTION>
							</SELECT>
						</td>
						<td>Logistics KPI</td>
						<td>
							<div id="div_kpi">
							<script language="javascript">ComComboObject('f_lgs_kpi_cd',1, 120 , 1 )</script>
							</div>
						</td>
					</tr>
					<tr class="h23">
						<td class="gray_tit"></td>
						<td id="div_tm_nod_title" style="display:inline">Node</td>
						<td id="div_tr_route_title" style="display:none">Route N1st</td>
						<td><input type="text" style="width:100;" name="f_nod_cd" style="ime-mode:disabled" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');"></td>
						<td id="div_tr_nod_to" style="display:inline" colspan="4"></td>
						<td id="div_tr_route_to" style="display:none" colspan="4">
				 			N2nd
				 			<input type="text" style="width:60;" name="f_nod_cd2" style="ime-mode:disabled" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 			N3rd
				 			<input type="text" style="width:60;" name="f_nod_cd3" style="ime-mode:disabled" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 			N4th
				 			<input type="text" style="width:60;" name="f_nod_cd4" style="ime-mode:disabled" maxlength="7" onKeyPress="ComKeyOnlyAlphabet('uppernum');">
						</td>
					</tr>
					<tr class="h23">
						<td class="gray_tit"></td>
						<td colspan="2">Display Trade / Lane
							<input type="checkbox" name="f_islane_display" value="1" class="trans" checked></td>
						<td colspan="2">Display Type/Size
							<input type="checkbox" name="f_istpsz_display" value="1" class="trans" checked></td>
						<td colspan="2">Display Node
							<input type="checkbox" name="f_isnode_display" value="1" class="trans" checked></td>
					</tr>
					<tr class="h23">
						<td class="gray_tit"></td>
						<td colspan="2">Including Exclusive Terminal Expense<input type="checkbox" name="f_incld_tml" value="T" checked class="trans"></td>
						<td colspan="2">Excluding C/H Service Charge<input type="checkbox" name="f_excld_crr_hlg" value="T" checked class="trans"></td>
						<!-- td colspan="2">Including Empty Pick-up/Return<input type="checkbox" name="f_incld_mt" value="T" unchecked class="trans"></td -->
						<td colspan="2">&nbsp;</td>
					</tr>
				</table>
			</td>
		  </tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       		<tr><td class="bg">

				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
				  <tr>
					<td align="right" valign="bottom">
						<div id="div_zoom_in" style="display:inline">
						<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_Zoom_in" alt="Zoom in(+)">
						</div>
						<div id="div_zoom_out" style="display:none">
						<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_Zoom_out" alt="Zoom out(-)">
						</div>
					</td>
				  </tr>
	              <tr>
	              <td id="div_tmnl" style="display:inline"><script language="javascript">ComSheetObject('sheet1');</script></td>
	              <td id="div_trans" style="display:none"><script language="javascript">ComSheetObject('sheet2');</script></td>
	              </tr>
				</table>
            <table class="search" border="0">
              <tr class="h23">
                <td class="gray_tit" style="padding-left:0px;"><img src="/hanjin/img/ico_star.gif">&nbsp;<strong>Remark</strong></td>
              </tr>
              <tr class="h23">
                <td class="gray_tit" colspan="2" style="padding-left:10px;">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                       TMNL/TRANS Volume Incentive is not included in Logistics PFMC reports.<br>
                </td>
              </tr>
              <tr class="h23">
                <td class="gray_tit" colspan="2" style="padding-left:10px;">
                  <img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">
                      It is the box volume in "New Volume" column that is used in RHQ/OFC unit cost calculation. <br>
                </td>
              </tr>              
            </table>					
				<!-- : ( RHQ ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->
<br>
</body>
</html>