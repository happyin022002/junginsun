﻿<%--=========================================================================
'주  시 스 템 : ENIS
'서브  시스템 : Continent Pair
'프로그램 ID  : apps/enis/esm/mas/lanesimulation/jsp/ESM_MAS_150.jsp
'프로그램 명  : Continent Pair 조회/변경
'프로그램개요 : Continent Pair 조회/변경
'작   성   자 : Park Eun Ju
'작   성   일 : 2007.12.18
=============================================================================
' History :
' 20080219 박은주 N200802040018 MAS 내 항로 Simulation 로직 변경
' 2008.05.07 PEJ R200804296325 css 파일 참조 확인 및 수정 요청
' 2009.03.31 박은주 임옥영 박상희  S2K-09U-002(Lane Simulation System 개선)
' 2009.07.20 윤진영 Alps전환작업 
' 2010.06.14 윤진영 CHM-200901719 UI표준처리 tab키 이동 수정 및 onlyEng function 표준대로 수정
' 2010.12.01 김기종 Ticket ID:CHM-201006305-01 MAS Architecture 위배사항 수정
=========================================================================--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.apps.alps.esm.mas.lanesimulation.event.EsmMas0150Event"%>
<%
    EsmMas0150Event  event = null;     //PDTO(Data Transfer Object including Parameters)
    Exception serverException   = null; //서버에서 발생한 에러
    String strErrMsg    = "";           //에러메세지
    Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.mas.lanesimulation.EsmMas0150Event");
		String ibDir = "";
		String ibIOC = "";
		String v_slan_cd = "";

    try {

        serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
        if (serverException != null) {
            strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
        }else{
            event = (EsmMas0150Event)request.getAttribute("Event");
        } // end else
		v_slan_cd     = JSPUtil.getNull(request.getParameter("f_slan_cd"));

    }catch(Exception e) {
        log.error("EsmMas0150Event Exception : "+e.toString());
    }
%>
<html>
<head>
<title>Create Continent Pair Table</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
<!--
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        loadPage();
    }
-->
</script>
</head>


<body onload="javascript:setupPage();">
<form method="post" name="form" onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="dept_cd">
<input type="hidden" name="usr_id">
<input type="hidden" name="slan_cd">
<input type="hidden" name="sim_no">
<input type="hidden" name="sim_dt">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">


		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp; Create Continent Pair Table</td></tr>
		</table>
		<!-- : ( Title ) (E) -->


		<!--Button_L (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
	       	<tr><td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
				<tr>
					<!-- Repeat Pattern -->
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" id="btn_save" name="btn_save">Save</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr></table>

			</td></tr>
		</table>
		<!--Button_L (E) -->


            <!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search" width="100%" >
				<tr>
					<td class="bg">
						<!-- : ( Viewer ) (S) -->
						<table class="search" border="0">
							<tr class="h23">
                                <td width="100">Simulation No.</td>
                                <td style="padding-left:3">
                                    <input type="text" style="width:30;" name="f_dept_cd"value="<%= JSPUtil.getNull(request.getParameter("f_dept_cd")) %>" class="noact2" maxlength="3"  readOnly >&nbsp;&nbsp;-&nbsp;
                                    <input type="text" style="width:75;" name="f_sim_dt" dataformat="ymd" value="<%= JSPUtil.getNull(request.getParameter("f_sim_dt")) %>" class="noact2" maxlength="8" onblur="ComAddSeparator(this);" onFocus="ComClearSeparator(this); this.select();" readOnly>&nbsp;
                                    <input type="text" style="width:30;" name="f_sim_no" value="<%= JSPUtil.getNull(request.getParameter("f_sim_no")) %>" class="noact2" maxlength="3" onKeyPress="ComKeyOnlyNumber(window);" onfocus="this.select()" readOnly>&nbsp;
                                    <input type="text" style="width:75;" name="f_usr_id" value="<%= JSPUtil.getNull(request.getParameter("f_usr_id")) %>" class="noact2" readOnly>
                                    <!-- : 'Simulation No, Description' from (Step_02) -->
                                </td>

								<td>S/Lane</td>
								<td ><input type="text" style="width:45" name="f_slan_cd"  value="<%= JSPUtil.getNull(request.getParameter("f_slan_cd")) %>" class="noact2" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled" readOnly></td -->
								<td width="20"></td>
								<td>Revenue Lane</td>
								<td ><input type="text" style="width:45" name="f_rlane_cd"  value="<%= JSPUtil.getNull(request.getParameter("f_rlane_cd")) %>" maxlength="5" onKeyPress="ComKeyOnlyAlphabet('uppernum');" style="ime-mode:disabled"></td -->
							</tr>
						</table>
						<!-- : ( Viewer ) (E) -->


						<table class="line_bluedot"><tr><td></td></tr></table>


						<!-- : ( Grid ) (S) -->
						<table width="100%" id="mainTable">
							<tr>
								<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
								</td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->


						<!--  Button_Sub (S) -->
						<table width="100%" class="button">
					       	<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
							<tr>

								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" id="btng_rowadd" name="btng_rowadd">Row Add</td><td class="btn2_right"></td></tr></table></td>
								<!-- Repeat Pattern -->


							</tr></table>
						</td></tr>
						</table>
				    	<!-- Button_Sub (E) -->


					</td>
				</tr>
			</table>
            <!-- TABLE '#D' : ( Search Options ) (E) -->


		</td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd -->


<table class="height_5"><tr><td></td></tr></table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<!-- Repeat Pattern -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
				<!-- Repeat Pattern -->

			</tr>
		</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>
