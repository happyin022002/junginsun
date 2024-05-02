<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESM_MAS_0158.jsp
*@FileTitle : Office/Volum Activity
*Open Issues :
*Change history :
	* 2008-07-21 Kim TaeYun
	* 1.0 최초 생성
	* 2008-07-21 김태윤 N200803310003 성능향상을 위한 물류레포트 신규추가.
	* 2008.09.22 김태윤 N200808278919 Spilt 01-MAS_Report내 수정사항 (메뉴명과 윈도우 타이틀명 일치.)
	* 2009.10.27 최인경 New Framework 적용
	* 2011.06.21 이석준 [CHM-201111642-01] MAS Logistics Exp. By Office화면에서 R.Month / S.Month 구분요청
	* 2011.08.31 최성민 [CHM-201113156-01] [MAS] Logistics Exp. By Office화면에서 R.Month / S.Month 구분 관련
*@LastModifyDate : 2009-10-27
*@LastModifier : Choi In-Kyung
*@LastVersion : 1.0
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.multidimensionrpt.logisticsrpt.event.EsmMas0158Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmMas0158Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	
	String strErrMsg = "";							//에러메세지
	Logger log = Logger.getLogger("com.hanjin.apps.multidimensionrpt.logisticsrpt");
	
	try {
		event = (EsmMas0158Event)request.getAttribute("Event");
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
<title>Logistics Volume by Office</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
		document.form.f_year.focus();
	}
</script>
</head>
<iframe height="0" width="0" name="frmHidden"></iframe>
<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input	type="hidden" name="f_cmd">
<input  type="hidden" name="iPage">
<input type="hidden" name="s_rhq_cd">
<input type="hidden" name="s_cntr_ofc_cd">
<input type="hidden" name="s_lgs_kpi_cost_grp_cd">
<input type="hidden" name="s_kpi_cd">
<input type="hidden" name="s_cost_yrmon2">
<input type="hidden" name="s_cost_wk2">


<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
<tr><td>

		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr>
			<td class="history">
				<img src="img/icon_history_dot.gif" align="absmiddle">
					<span id="navigation"></span>
			</td>
		</tr>
		<tr>
			<td class="title">
				<img src="img/icon_title_dot.gif" align="absmiddle">
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
       	<tr><td class="bg">
				<!-- : ( Year ) (S)  -->
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="103" class="gray_tit">
							<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="7" height="9" border="0">Period
						</td>
						<td colspan="2">
							<script language="javascript">masPeriod3();</script>
						</td>
						<td>Split by Month / Week&nbsp;&nbsp;
							<input type="checkbox" name="f_split_mw" value="T" checked class="trans">
						</td>
					</tr>
                     <tr class="h23">
                    	<td></td>
                        <td width="205"></td>
                     	<td width="390" class="gray_tit" style="color:#4361b6" style="font-size:8pt;">
			        	   [ by Mon - effective from July(2008) &nbsp;&nbsp;
			        	    by Week - effective from 27WK(2008) ]
                   	     </td>
                   	    <td>&nbsp;</td>
                     </tr>
                </table>

				<table class="search_in" border="0">
					<tr class="h23">
						<td width="110" class="gray_tit">
							<img src="/hanjin/img/ico_hystory.gif" align="absmiddle" width="8" height="9" border="0">Organization
						</td>
						<td width="60">Report</td>
						<td width="260">
							<SELECT style='width:150' name="f_report" onChange="reportChange(this.value);">
								<OPTION value="1">World Wide</OPTION>
								<OPTION value="2">RHQ</OPTION>
								<OPTION value="3">Control Office</OPTION>
							</SELECT></td>
						<td width="50">RHQ</td>
						<td width="220">
							<!-- 레벨 2에서 3으로 수정. -->
							<script language="javascript">ComComboObject('f_rhq_cd',1, 120 , 0 )</script>
						</td>
						<td width="55">Office</td>
						<td>
							<script language="javascript">ComComboObject('f_ctrl_ofc_cd',1, 120 , 0 )</script>
						</td>
					</tr>
				</table>
				<!-- : ( Year ) (E) -->

	  </td></tr>
	  </table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

	  <table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" >
       	<tr><td class="bg">
				<!-- : ( RHQ ) (S) -->
				<table width="100%" id="mainTable">
						  <tr>
							<td align="right" valign="bottom">
								<div id="div_zoom_in1" style="display:inline">
									<img class="cursor" src="/hanjin/img/bu_prev01.gif" height="11" border="0" name="bu_zoom_in1" alt="Zoom in(+)">
								</div>
								<div id="div_zoom_out1" style="display:none">
									<img class="cursor" src="/hanjin/img/bu_next01.gif" height="11" border="0" name="bu_zoom_out1" alt="Zoom out(-)">
								</div>
							</td>
						  </tr>
			              <tr>
			              	<td>
			                     <script language="javascript">ComSheetObject('sheet1');</script>
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
</form>
</body>
</html>