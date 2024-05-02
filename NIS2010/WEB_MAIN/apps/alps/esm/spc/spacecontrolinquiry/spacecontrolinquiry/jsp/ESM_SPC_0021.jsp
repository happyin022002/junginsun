<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0021.jsp
*@FileTitle : spacecontrolinquiry 실적조회지역본부별
*Open Issues :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈 
*@LastVersion : 1.0
* 2009.08.10 한상훈 
* 1.0 Creation
* Change history :
* 2007-01-05 kyungae 1.0 최초 생성
* 2008-05-16 서관영 CSR : N200805066436 - 사용하지 않는 Item정리 Vol/Teu만 display(ESM_SPC_021)
* 2009-02-02 최윤성 CSR : N200812260003, R200902030004 - Adjusted allocation status Tab 추가로 인한 Sheet 및 로직 추가&수정
* 2011.04.07 이석준 [CHM-201109823] sheet2,shee3에서 VVD double click시에 0042 UI popup 호출 추가
* 2011.05.16 이석준 [CHM-201110710-01] Daily F"cast Status 화면 조건 추가 rlane1,rlane2,rlane3,rhq combo 추가  
* 2011.05.31 이석준 [CHM-201111306-01] 각 tab에  Area2 check box 추가
* 2011.07.04 최윤성 [선반영] Duration 의 Option 에 6 추가
* 2011.07.05 이행지 [CHM-201111946-01] Daily F"cast Status 화면 보완 - 2,3번째 tab에 Dest.(IAS) chek box추가, Dest.컬럼 추가
* 2011.07.26 김종준 [SRM-201118467] allocation 체크박스 User Role이 SPC01 인 유저들에게만 활성화 되게 수정,조회조건에 Office들 셋팅해주고 비활성화/활성화 해주는 부분 삭제
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2012.02.16 김성훈 [CHM-201216142-01] 사용자별 Lane 정보 관리/조회시 Lane 항목 추가
* 2012.06.15 김성훈 [CHM-201218360-01] Daily Forecast Status 화면 보완
* 2012.08.08 전상화 [CHM-201219578-01] Tab : BKG Status(RHQ) 추가 
* 2012.09.10 전상화 [CHM-201220051-01] Daily FCST input 개산 및 신규 Report 생성 - Tab : Alloc&PFMC status by S.REP / FCST&BKG PFMC by S.OFFICE 추가
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.08 진마리아 [선처리] Allocation 추가요건 - Guide 더블클릭시 Daily Forecast Status 팝업
* 2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
* 2014.10.27 박은주 [CHM-201432467] Daily FCST Inquiry 보완 요청(BKG Status(RHQ)에 POR 추가)
* 2014.11.04 박은주 [CHM-201432710]  [SPC : 사후CSR 진행] [CHM-201431980]Daily FCST -Dest/Local-IPI 조회기능 보완요청
* 2014.11.05 [CHM-201432345] SMP Report 신규 생성(요건 변경으로 FCST&PFMC Status by ACCT탭 수정 sheet11) -Accout Class삭제, L.OFC 체크박스 추가, Fcast 체크박스 추가 -TTL CM, CMPB, Load% BKG옆에 추가 -Inqurity by Customized Condition 팝업링크 추가
* 2014.11.20 Arie Im [CHM-201432864] Daily FCST보완 - SUB Trade별 전체 실적 GUIDE추가(Acct) - SUB Trade, Trade 별 USMode/Account/Dest Sum 추가(HO/RHQ) - 체크박스 기능 재정의(HO/RHQ) - Excluding Sector(IAS) 추가 (HO/RHQ탭)
* 2014.12.16 박은주 [CHM-201433153] Daily FCST status 리포트 보완 요청(겹선)
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
* 2015.11.10 이혜민 [CHM-201538774] NON SMP account FCST 의 Daily FCST 보완 요청
* 2016.01.12 이혜민 [CHM-201539227] Daily FCST status _ Allocation status(HO) & Allocation status(RHQ) 기능추가
* 2016.05.03 이혜민 [CHM-201640928] Daily Forecast Status 모든 조회 옵션 및 탭 > 그리드 화면에 SELCS, TYOSC 독립 RHQ 분리 요청
* 2016.05.03 이혜민 [CHM-201640976] Daily Fcast Status 오류 수정 요청 & Tap 위치 조정
* 2016.05.27 이혜민 SELSC, TYOSC RHQ 독립분리
* =========================================================*/
%>
 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0021Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");
	
	// Forecast 화면에서 팝업으로 호출될 경우, 조회조건을 넘겨받음
	String t_year     = JSPUtil.getParameter(request, "year", "");
	String t_week     = JSPUtil.getParameter(request, "week", "");
	String t_duration = JSPUtil.getParameter(request, "duration", "");
	String t_trade    = JSPUtil.getParameter(request, "trade", "");
	String t_subtrade = JSPUtil.getParameter(request, "sub_trade", "");
	String t_rlane    = JSPUtil.getParameter(request, "rlane_cd", "");
	String t_rhq      = JSPUtil.getParameter(request, "rhq", "");
	String t_rgn_cd   = JSPUtil.getParameter(request, "rgn_cd", "");
	String t_acct     = JSPUtil.getParameter(request, "acct_cd", "");
	String t_src     = JSPUtil.getParameter(request, "src", "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0021Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	boolean isAdmin = false;
	String rhq_cd   = "";
	String aq_cd    = "";
	String rgn_cd   = "";
	String ofc_cd   = event.getSignOnUserAccount().getOfc_cd();
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		isAdmin = eventResponse.getETCData("adm").equals("Y");
		rhq_cd  = eventResponse.getETCData("rhq_cd");	
		aq_cd   = eventResponse.getETCData("aq_cd");	
		rgn_cd  = eventResponse.getETCData("rgn_ofc_cd");		
		//ofc_cd  = eventResponse.getETCData("rhq_cd");
	}
	
%>
<html>
<head>
<title>Daily Forecast Status</title>
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
<form name="formSel">
<input type="hidden" name="f_cmd">
<input type="hidden" name="trd_cd"><!-- 2012.01.19 SHKIM -->
<input type="hidden" name="sub_trd_cd"><!-- 2012.01.19 SHKIM -->
<input type="hidden" name="dir_cd"><!-- 2012.01.19 SHKIM -->
</form>

<form name="formSave">
<input type="hidden" name="ibflag" value=""><!-- 2012.01.19 SHKIM -->
<input type="hidden" name="f_cmd">
<input type="hidden" name="trd_cd">
<input type="hidden" name="sub_trd_cd">
<input type="hidden" name="rlane_cd">
<input type="hidden" name="dir_cd">
</form>

<form name="form">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="chkview">
<input type="hidden" name="login_ofc_cd" value="<%=ofc_cd%>">
<input type="hidden" name="login_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="login_aq_cd"  value="<%=aq_cd%>">
<input type="hidden" name="login_rgn_cd" value="<%=rgn_cd%>">
<input type="hidden" name="t_year"       value="<%=t_year%>">
<input type="hidden" name="t_week"       value="<%=t_week%>">
<input type="hidden" name="t_duration"   value="<%=t_duration%>">
<input type="hidden" name="t_trade"      value="<%=t_trade%>">
<input type="hidden" name="t_subtrade"   value="<%=t_subtrade%>">
<input type="hidden" name="t_rlane"      value="<%=t_rlane%>">
<input type="hidden" name="t_rhq"        value="<%=t_rhq%>">
<input type="hidden" name="t_rgn_cd"     value="<%=t_rgn_cd%>">
<input type="hidden" name="t_acct"       value="<%=t_acct%>">
<input type="hidden" name="t_src"       value="<%=t_src%>">

<!-- add : 2012.08.08	-->
<input type="hidden" name="port_div" value="POL">

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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_sendmail" id="btn_sendmail">Send&nbsp;Mail</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
	 	<div id="searchLayer" style="display:inline">
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="110"><img class="nostar">Start Week</td>
					<td width="120">
						<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
						<select class="input1" name="week1" style="width:40;" onchange="week_Change(this);"></select>
					</td>
					<td width="70"><img class="nostar">Duration</td>
					<td width="75">
					<select class="input1" name="duration" size="1" onchange="week_Change(this);"></select>
					</td>
					<td width="50"><img class="nostar">Trade</td>
					<td width="120" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script>
					</td>					                   				
					<td width="100"><img class="nostar">Sub Trade</td>
					<td width="100" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("subtrade1", 3, 50, 0, 0);</script>
					</td>					
					<td width="60"><img class="nostar">Lane</td> 
					<td width="100" style="padding-left:2px;"><script language="javascript">ComComboObject('rlane1',4, 80 , 1,0);</script>
					</td>	
					<td width="70"><img class="nostar">Duration2</td>
					<td width="50">
					<select name="duration2_from" size="1"></select>
					</td>
					<td width="50">
					<select name="duration2_to" size="1"></select>
					</td>
				</tr>
				<tr class="h23">
					<td width="90"><img class="nostar">RHQ</td>
					<td width="120" style="padding-left:2px;">
						<div id="rhq_div" style="display:none"><script language="JavaScript">ComComboObject("rhq", 2, 104, 0, 1);</script></div>
						<div id="rhq2_div" style="display:inline"><script language="JavaScript">ComComboObject("rhq2", 2, 104, 0, 1);</script></div>
					</td>
					<td width="30"><img class="nostar">Area</td>
					<td width="75"><input name="area" type="text" style="width:60;ime-mode:disabled;" value="<%=aq_cd%>" maxlength=6  onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					
					<td width="50"><img class="nostar">Office</td>
					<td width="120"><input type="text" id="sales_office" name="sales_office" style="width:78;" value="<%=rgn_cd%>" maxlength=6 onkeypress="eventKeyChangeChar(UPPER_CASE);"onchange="checkValue('office');">
					<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup_office"></td>
					<td width="80"><img class="nostar">Port</td>
					<td width="110"><input name="pol_cd" type="text" style="width:58;ime-mode:disabled;" value="" maxlength=5  onkeypress="eventKeyChangeChar(UPPER_CASE);"onchange="checkValue('pol');">
						<img class="cursor" name="btn_popup_pol_cd" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="60"><img class="nostar">Bound</td>
					<td>
						<select name="bound" style="width:50;" onChange="bound_Change(this);"></select>
					</td>
				</tr>
				<tr class="h23" style="display:none;">
				<td colspan="9">&nbsp;<input type="checkbox" value="P" class="trans" name="chkViewP" onclick="changetitle();">Port View&nbsp;&nbsp;&nbsp;
						<input type="checkbox" value="L" class="trans" name="chkViewL">Local Week</td>

				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		</div>
	 	<div id="searchLayer" style="display:none">
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="85"><img class="nostar">Start Date</td>
					<td width="130"><input type="text" class="input1" name="from_dt" dataformat="ymd" style="width:90;text-align:center;ime-mode:disabled;">&nbsp;<img class="cursor" name="btn_period1" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="75"><img class="nostar">Duration</td>
					<td colspan="5">
						<select class="input1" name="duration1" size="1"></select>
					</td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">RHQ</td>
					<td width="130" style="padding-left:2px;">
						<script language="JavaScript">ComComboObject("rhq1", 2, 113, 0, 1);</script>
					</td>
					<td width="75"><img class="nostar">Area</td>
					<td width="80"><input name="area1" type="text" style="width:60;ime-mode:disabled;" value="" maxlength="6"  onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					
					<td width="65"><img class="nostar">Office</td>
					<td width="125">
						<input type="text" class="input1" name="sales_office1" style="width:80;text-align=center;" value="" maxlength="6" onkeypress="eventKeyChangeChar(UPPER_CASE);" onchange="setSalesRepCombo(this);">
						<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_popup_office1"></td>
					<td width="60"><img class="nostar">S.REP</td>
					<td><script language="JavaScript">ComComboObject("srep_cd", 4, 70, 0);</script></td>

				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		</div>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       	<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		
		<!-- ******************************************* -->
		<!-- (2) Allocation Status(HO) (sheet2)-->
		<!-- ******************************************* -->
        <div id="tabLayer" style="display:inline">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
					
					<td width="100" >Data Selection&nbsp;</td>
					<td width="60"><input type="checkbox" value="" name="check_office" class="trans" onclick="changeTitle2(this);">Office<!--  REMOVE SHKIM 0613 checkbox 80 Office --></td>
					<td width="90"><input type="checkbox" value="" name="check_suboffice" class="trans" onclick="clickSubOfc(this);">Sub Office</td>
					<td width="85" id="check_alloc_div"><input type="checkbox" value="" name="check_alloc" class="trans" checked onclick="showAlloc2(this);">Allocation</td>
					<td width="80"><input type="checkbox"  name="check_wgt2" 		class="trans" value="" onclick="showWgtLf2(this);">WGT L/F</td>
					<td width="100"><input type="checkbox"  name="check_area2" 		class="trans" value="">Area2</td>
                    <td width="200"><input type="checkbox" name="check_sector2" 		class="trans" value="N" disabled>Excluding Sector.(IAS)</td>
                    <td width="*" align="right"><input   type="checkbox" name="check_vvd1" 	    class="trans" value="">Split merged VVDs</td>
                </tr>
                <tr class="h23">
                	<td></td>
                    <td width="60"><input type="checkbox" name="check_guide2" 		class="trans" onclick="hiddenGuide2();" >Guide</td>
                    <td width="90"><input type="checkbox" name="check_usMod2" 	class="trans" onclick="hiddenUsMod2();">IPI/Local</td>
                    <td width="85"><input type="checkbox" name="check_acct2" 		class="trans" onclick="hiddenAcct2();">Account</td>
                    <td width="55"><input type="checkbox" name="check_destLoc2" 	class="trans" onclick="hiddenDestLoc2();">Dest</td>
                    <td width="100"><input type="checkbox" name="check_dest2" 		class="trans" value="N" disabled>Dest.(IAS)</td>
                    <td width="*">&nbsp;&nbsp;<font color="red">[</font><input type="checkbox" name="check_ipi_local" 	class="trans" value="Y">IPI/Local&nbsp;<input type="checkbox" name="check_dest_ctrl" value="Y"	class="trans">Dest<font color="red">]</font>&nbsp;</td>
 				</tr>

				</table>


				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet2');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="" alt="Alt+M">Save</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
		<!-- ******************************************* -->
		<!-- (3) Allocation Status(RHQ) (sheet5)-->
		<!-- ******************************************* -->
        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
					
					<td width="100">Data Selection&nbsp;</td>
					<td width="60"><input type="checkbox" value="" name="check_office5" class="trans" onclick="checkBoxControl5(this);">Office</td>
					<td width="90"><input type="checkbox" value="" name="check_suboffice5" class="trans" onclick="clickSubOfc(this);">Sub Office</td>
					<td width="85" id="check_alloc_div3"><input type="checkbox" value="" name="check_alloc4" class="trans" checked onclick="showAlloc5(this);">Allocation</td>
					<td width="80"><input type="checkbox"  name="check_wgt5" 		class="trans" value="" onclick="showWgtLf5(this);">WGT L/F</td>
					<td width="100"><input type="checkbox" name="check_area5" class="trans" value="">Area2</td>
                    <td width="200"><input type="checkbox" name="check_sector5"  class="trans" value="N" disabled>Excluding Sector.(IAS)</td>
                    <td width="*" align="right"><input   type="checkbox" name="check_vvd2" 	    class="trans" value="">Split merged VVDs</td>
                </tr>
                <tr class="h23">
                	<td></td>
					<td width="60"><input type="checkbox" name="check_guide5" class="trans" onclick="checkBoxControl5(this);" >Guide</td>
                    <td width="90"><input type="checkbox" name="check_usMod5" 	class="trans" onclick="checkBoxControl5(this);">IPI/Local</td>
                    <td width="85"><input type="checkbox" name="check_acct5" 		class="trans" onclick="checkBoxControl5(this);">Account</td>
                    <td width="70"><input type="checkbox" name="check_destLoc5" 	class="trans" onclick="checkBoxControl5(this);">Dest</td>
                    <td width="100"><input type="checkbox" name="check_dest5" class="trans" value="N" disabled>Dest.(IAS)</td>
                    <td width="*">&nbsp;&nbsp;<font color="red">[</font><input type="checkbox" name="check_ipi_local2" 	class="trans" value="Y">IPI/Local&nbsp;<input type="checkbox" name="check_dest_ctrl2" value="Y"	class="trans">Dest<font color="red">]</font>&nbsp;</td>
					</tr>

				</table>

				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet5');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="" alt="Alt+M">Save</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>


			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
		<!-- ******************************************* -->
		<!-- (4) Adjusted allocation status (sheet3)-->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<!-- >table class="height_10"><tr><td></td></tr></table -->

				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
					<td width="100">Data Selection&nbsp;</td>
					<td width="80">
						<input type="checkbox" value="" name="check_office2" class="trans" onclick="changeTitle3(this);"> Office <!--  REMOVE SHKIM S 20120613 80 Office-->
					</td>
					<td width="100" id="check_alloc_div2"><input type="checkbox" value="" name="check_alloc2" class="trans" checked onclick="showAlloc3(this);"> Allocation</td>
					<td width="80"><input type="checkbox" name="check_area3" class="trans" value=""> Area2</td>
                    <td width="120"><input type="checkbox" name="check_dest3" class="trans" value="N" disabled> Dest.(IAS)</td>
                    <td width="*" align="right"><input type="checkbox" name="check_vvd3" class="trans" value="">Split merged VVDs</td>
					</tr>

				</table>


				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet3');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="" alt="Alt+M">Save</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
				

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
		<!-- ******************************************* -->
		<!-- (5) PFMC Ration vs QTA & BSA (sheet4)-->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
					<td width="100">Data Selection&nbsp;</td>
					<td width="80">
						<input type="checkbox" value="" name="check_office3" class="trans" onclick="changeTitle4(this);"> Office
					</td>
					<td width="80"><input type="checkbox" name="check_area4" class="trans" value=""> Area2</td>
					<td width="*" align="right"><input type="checkbox" name="check_vvd4" class="trans" value="">Split merged VVDs</td>
					</tr>

				</table>


				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet4');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="" alt="Alt+M">Save</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
				

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
        
        <!-- ******************************************* -->
		<!-- (6) BKG Status(RHQ) (sheet6)-->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
						<td width="100" align="right"><img class="nostar">View&nbsp;&nbsp;&nbsp;</td>
						<td width="80">
							<select class="input1" style="width:100;" name="VIEW" id="viewDiv" onChange="doSelectSheet6ByView();">
								<option value="OFFICE" selected>Office</option>
								<option value="PORT" >BKG</option>
							</select>						
						</td>
						<td colspan="5">
							 <input type="radio" class="trans" name="div_cd" value="POR" onclick="sheet6PortReSearch('POR');" checked><label for="id_chk_por">POR</label>&nbsp;
							 <input type="radio" class="trans" name="div_cd" value="POL" onclick="sheet6PortReSearch('POL');" checked><label for="id_chk_pol">POL</label>&nbsp;
							 <input type="radio" class="trans" name="div_cd" value="POD" onclick="sheet6PortReSearch('POD');"><label for="id_chk_pod">POD</label>&nbsp;
							 <input type="radio" class="trans" name="div_cd" value="DEL" onclick="sheet6PortReSearch('DEL');"><label for="id_chk_del">DEL</label>&nbsp;
							 <input type="text"  name="del_cd" value="" style="width:58;ime-mode:disabled;display:none;" value="" maxlength=5 onkeypress="eventKeyChangeChar(UPPER_CASE);" onKeyDown="sheet6ReSearch();"><!--
						  --><input type="text"  name="por_cd" value="" style="width:58;ime-mode:disabled;display:none;" value="" maxlength=5 onkeypress="eventKeyChangeChar(UPPER_CASE);" onKeyDown="sheet6ReSearch();">
						</td>		
						<td width="*" rowspan="2" style="vertical-align:top" align="right"><input type="checkbox" name="check_vvd5" class="trans" value="">Split merged VVDs</td>	
					</tr>
					<tr class="h23" style="height:17">
						<td width="100">Data Selection&nbsp;</td>
						<td width="80"><input type="checkbox" value="" name="officeView" class="trans" onclick="sheet6OfficeView();"> Office</td>
						<td width="130"><input type="checkbox" name="portView" class="trans" onclick="sheet6PortView();"> POL/POD/DEL</td>
						<td width="95" id="check_alloc_div6">
							<input type="checkbox" value="" name="check_alloc6" class="trans" checked onclick="showAlloc6();"> Allocation
						</td>
						<td width="70"><input type="checkbox" name="typeView" class="trans" onclick="sheet6TypeView();"> TP/SZ</td>
						<td width="130"><input type="checkbox" name="cntrView" class="trans" onclick="sheet6CntrView();"> CNTR Movement</td>
					</tr>
				</table>
				

				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet6');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				
				

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>        
        <!-- ******************************************* -->
		<!-- (1) F'cast Comparison (sheet1) -->
		<!-- ******************************************* -->
        <div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" border='0'>
       	<tr><td class="bg" style="padding-top:5px">
				<table class="search" width="100%">
				<tr class="h23" style="height:17">
					<td width="100">Data Selection</td>
					<td width="65"><input type="checkbox" name="check_area1" class="trans" value=""> Area2</td>
					<td width="*">&nbsp;</td>
				</tr>
				</table>


				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_save" id="" alt="Alt+M">Save</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
        <!-- ******************************************* -->
		<!-- (7) Alloc&PFMC status by S.REP              -->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<!-- >table class="height_10"><tr><td></td></tr></table -->

				<table class="search" width="100%" border="0">
				<tr class="h23" style="height:17">
						<td width="50"><img class="nostar">Trade</td>
						<td width="85" style="padding-left:2px;">
							<script language="JavaScript">ComComboObject("trade7", 3, 70, 0, 0);</script>
						</td>
						<td width="50"><img class="nostar">Lane</td> 
						<td width="115" style="padding-left:2px;"><script language="javascript">ComComboObject('rlane7',4, 100 , 1,0);</script></td>	
						<td width="100">Data Selection&nbsp;</td>
						<td width="80"><input type="checkbox" name="check_tpsz7" class="trans" checked value="Y" onclick="sheet7HiddenItems();"> 20'/40'</td>
	                    <td width="70"><input type="checkbox" name="check_acct7" class="trans" checked value="Y" onclick="sheet7ColView('ctrt_cust_cd');"> ACCT</td>
	                    <td width="65"><input type="checkbox" name="check_pol7" class="trans" checked value="Y" onclick="sheet7ColView('pol_cd');"> POL</td>
	                    <td><input type="checkbox" name="check_pod7" class="trans" value="N" onclick="sheet7ColView('pod_cd');"> POD</td>
					</tr>
				</table>
				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet7');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_vvd" id="" >VVD Input</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
				<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>        
        
        <!-- ******************************************* -->
		<!-- (8) FCST&BKG PFMC by S.Office               -->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
       	
				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                    	<tr><td class="gray_tit" style="text-align=left;"> &nbsp;[금주]</td></tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet8');</script>
                        </td></tr>
                        <tr><td class="gray_tit" style="text-align=left;"> &nbsp;[차주]</td></tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet9');</script>
                        </td></tr>
                        <tr><td class="gray_tit" style="text-align=left;"> &nbsp;[전주]</td></tr>
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet10');</script>
                        </td></tr>
                    </table>
				<!-- : ( POR ) (E) -->
				
				<!-- : ( Button : Sub ) (S) -->
    			<table width="100%" class="button">
					<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_qta" id="" >Quota Upload</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td><td class="btn2" name="btn_vvd" id="" >VVD Input</td><td class="btn2_right"></td></tr></table></td>								
								<!-- Repeat Pattern -->
							</tr>
						</table>
					</td></tr>
				</table>
				<!-- : ( Button : Sub ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>        
        
        <!-- ******************************************* -->
		<!-- (9) FCST & PFMC Status by ACCT(sheet11) -->
		<!-- ******************************************* -->
		<div id="tabLayer" style="display:none">
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg" style="padding-top:5px">
       	
				<!-- >table class="height_10"><tr><td></td></tr></table -->

				<table class="search" width="100%" border="0">
					<tr class="h23" style="height:17">
						<td width="40"><img class="nostar">Item</td>
						<td width="120">
							<select class="input1" style="width:100;" name="item11" id="item11" onChange="changeColum11(this);">
								<option value="1" selected>Vol/Teu.</option>
								<option value="2">Vol/Feu.</option>
							</select>
						</td>
						<td width="160">
 							<table class="search_sm2" width="150">
 								<tr><td>
									<input type="radio" class="trans" name="check_smp" value="SMP" onclick="smp_Change(this);" checked> SMP
									<input type="radio" class="trans" name="check_smp" value="NSMP" onclick="smp_Change(this);" > Non SMP
								</td></tr>
							</table>
						</td>				

						<td width="120"><img class="nostar">Group Account</td>
						<td width="115"  style="padding-left:2"><script language="JavaScript">ComComboObject("grp_acct", 4, 100, 0);</script></td>						
						<td width="75"><img class="nostar">Account</td>
						<td width="*" style="padding-left:2"><script language="JavaScript">ComComboObject("acct", 4, 100, 0);</script></td>
					</tr>
				</table>
				<table class="" border="0">
					<tr class="h23" style="height:17">
						<td width="160">
							<input type="radio" class="trans" name="view_type11" value="ACCT" onclick="sheet11ReSearch();" checked> ACCT
							<input type="radio" class="trans" name="view_type11" value="LOFC" onclick="sheet11ReSearch();"> L/Office
						</td>
						
						<td width="80"><input type="checkbox" name="check_acct" class="trans" value="" onclick="chagneSheet11();"> I/ACCT</td>
						<td width="60"><input type="checkbox" name="check_vvd" class="trans" value="" onclick="chagneSheet11();"> VVD</td>
						<td width="65"><input type="checkbox" name="check_lane" class="trans" value="" onclick="chagneSheet11();"> Lane</td>
						<td width="95"><input type="checkbox" name="check_acct_tp" class="trans" value="" onclick="chagneSheet11();"> BCO/NVO</td>
						<td width="80"><input type="checkbox" name="check_lofc" class="trans" value="" onclick="chagneSheet11();" checked> L.OFC</td> <!--  -->
						<td width="80"><input type="checkbox" name="check_cfcst" class="trans" value="" onclick="chagneSheet11();"> C.Fcast</td>
						<td width="75"><input type="checkbox" name="check_guide" class="trans" value="" onclick="chagneSheet11();"> GUIDE</td>
						<td width="80"><input type="checkbox" name="check_fcst" class="trans" value="" onclick="chagneSheet11();" checked> Fcast</td><!--  -->
						<td width="60" style="display:none"><input type="checkbox" name="check_tps" class="trans" value="" onclick="chagneSheet11();"> TPS</td>
						<td width="60" style="display:none"><input type="checkbox" name="check_aes" class="trans" value="" onclick="chagneSheet11();"> AES</td>
						<td width="*"></td>
					</tr>
				</table>
				<!-- : ( POR ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet11');</script>
                        </td></tr>
                    </table>
                    <table width="100%" class="button">
						<tr><td class="btn2_bg">
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<!-- Repeat Pattern -->
									<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn2_left"></td><td class="btn2" name="btng_season_grp" id="">Yield Group</td><td class="btn2_right"></td></tr></table></td>								
									<!-- Repeat Pattern -->
								</tr>
							</table>
						</td></tr>
					</table>
				<!-- : ( POR ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
        </div>
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>