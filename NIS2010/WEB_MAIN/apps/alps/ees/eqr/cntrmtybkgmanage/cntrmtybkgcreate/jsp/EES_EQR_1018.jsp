<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1018.jsp
*@FileTitle : MTY BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.13 신용찬
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event.EesEqr1018Event"%>
<%@ page import="com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.RepoPlanManage.CntrRepoExecutionPlanEstablish");
	
	String user_id              = "";
	
	String optionStr = "000001: :ALL";
	
	// from loc select box
	String frLocSelectBox = JSPUtil.getCodeCombo("fromstatus","","onChange='javascript:frLocChange(document.form.fromstatus.options[document.form.fromstatus.selectedIndex].value)' style='width:55;'","CD00259",0,"");

	// to loc select box
	String toLocSelectBox = JSPUtil.getCodeCombo("tostatus",  "","onChange='javascript:toLocChange(document.form.tostatus.options[document.form.tostatus.selectedIndex].value)'     style='width:55;'","CD00259",0,"");

	// TP/SZ select 박스
	String tyszSelectBox = JSPUtil.getCodeCombo("tpsz","","onChange='javascript:tpszChange(document.form.tpsz.options[document.form.tpsz.selectedIndex].value)' style='width:53;'","CD00263",0,optionStr);

  
	// Duration 종료일 (Hidden - 오늘날짜)
    String tempToPeriod = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
    // Duration 시작일 (Hidden - 1주일 이전날짜)
    String tempFmPeriod = DateTime.addDays(tempToPeriod, -6, "yyyy-MM-dd");
    
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		

		event = (EesEqr1018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		EesEqr1018ConditionVO conditionVO = new EesEqr1018ConditionVO();
		conditionVO = event.getEesEqr1018ConditionVO();

		user_id = event.getSignOnUserAccount().getUsr_id();

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Execution Plan</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	// Reason(검색정보)
	<%= JSPUtil.getIBCodeCombo("reason",  "01", "CD00261", 0, "")%>         // CD00369
	// Reason(sheet에서 선택값)
	<%= JSPUtil.getIBCodeCombo("reason_sheet",  "01", "CD00261", 0, " ")%>  // " " 는 선택값 없는 경우를 대비한 소스(중요)
	// Item ( ALL )
	<%= JSPUtil.getIBCodeCombo("item",    "01", "CD00253", 0, "")%>
	// Item (Truck, Rail, Water)
	<%= JSPUtil.getIBCodeCombo("item_inland",    "01", "CD00566", 0, "")%>
	// Item ( On Hire & Off Hire )
	<%= JSPUtil.getIBCodeCombo("item_hire",    "01", "CD00241", 0, "")%>
	// Item (Truck, Water) - SHUTTLE 에서 사용
	// CSR NO : N200905180100 (ECC internal mode에서 'Rail' 추가) Modified by Lee Byoung Hun
	//<%= JSPUtil.getIBCodeCombo("item_shuttle",    "01", "CD01062", 0, "")%>
	<%= JSPUtil.getIBCodeCombo("item_shuttle",    "01", "CD00566", 0, "")%>

	// Purpose
	<%= JSPUtil.getIBCodeCombo("purpose", "01", "CD00269", 0, " ")%> // " " 는 선택값 없는 경우를 대비한 소스(중요)
	
	// Type Size
    <%= JSPUtil.getIBCodeCombo("tpszall", "01", "CD00830", 0, "")%> // ALL TYPE SIZE CD00244
    <%= JSPUtil.getIBCodeCombo("tpszdry", "01", "CD00751", 0, "")%> // DRY TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszrfr", "01", "CD00752", 0, "")%> // RFR TYPE SIZE
    <%= JSPUtil.getIBCodeCombo("tpszot",  "01", "CD00828", 0, "")%> // OT  TYPE SIZE CD00753
    <%= JSPUtil.getIBCodeCombo("tpszfr",  "01", "CD00829", 0, "")%> // FR  TYPE SIZE CD00754
   
	// ------- type 변수선언 -------------- START
	var consTpsz      = replaceAll(tpszallText, "|", ",");
	var consTpszArr   = consTpsz.split(',');
	var consTpszDry   = replaceAll(tpszdryText, "|", ",");
	var consTpszRfr   = replaceAll(tpszrfrText, "|", ",");
	var consTpszOt    = replaceAll(tpszotText,  "|", ",");
	var consTpszFr    = replaceAll(tpszfrText,  "|", ",");
	// ------- type 변수선언 -------------- END

</script>
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

<body onLoad="setupPage();tpszChange('');">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="tpszall" > <!-- full type size (매우중요, 신용찬)-->

<!-- 개발자 작업	-->
<input type="hidden"  name="iPage">
<input type="hidden" name="localDate">               <!--  local pc 의 오늘날짜 -->
<input type="hidden" name="position_row1" value="1"> <!-- 입력.수정시 row 위치를 기억한후 재조회시 포커스를 맞춘다 -->


<!-- USER LEVEL, ACTION, LOCATION -->
<input  type="hidden" name="user_id"              value="<%= user_id %>">

<!-- VVD 검색시 사용 -->
<input type="hidden" name="vvdSearchCol" value="">

	<!-- Outer Table (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
	<tr>
		<td>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
			
			
			<!-- TABLE '#D' : ( Button : Main ) (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
			<tr>
				<td class="btn1_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new" id="btn_new">New</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_save" id="btn_save">Save</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
									<td class="btn1_right"></td></tr>
							</table></td>
						<td class="btn1_line"></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_print" id="btn_print">Print</td>
									<td class="btn1_right"></td></tr>
							</table></td>
					</tr>
					</table>				
				</td>
			</tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->
			
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			
			<table class="search">
				<tr><td class="bg">
                        
                        <table class="search" border="0" style="width:979;">
                        <tr>
						<td>
						<table class="search_sm" border="0" style="width:340;">
						<!-- FROM, TO LOCATION -->
							<tr class="h23">
                            	<td width="10"><input type="radio" name="divflag" value="1" class="trans" OnClick="classToggle();" checked></td> 											
								<td width="50" class="stm"><B>Period</B> </td>
								<td >
									<select name="divdate" onchange="classToggle();" style="width:55;">
										<option value="F" selected>From</option>
										<option value="T">To</option>
									</select>
								</td>
								<td ><input type="text" style="width:75;" class="input1" name="fromdate" value="<%=tempFmPeriod%>" required dataformat="ymd" maxlength="8" >&nbsp;~&nbsp;
									 <input type="text" style="width:75;" class="input1" name="todate"   value="<%=tempToPeriod%>" required dataformat="ymd" maxlength="8" >&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendarto"  id="btns_calendarfm" >
								</td>

							</tr>
							<tr>
								<td ><input type="radio" name="divflag" value="2" class="trans" OnClick="classToggle();" ></td> 	
								<td class="stm"><B>VVD</B></td>
								<td colspan=2>
									<input name="vvdname" type="text" style="width:173;ime-mode:disabled;" value="" maxlength="9" onKeyUp="upperCase_Num()">
								</td>
							</tr>
						</table>												
						</td>
                        <td width="29"></td>

					    <td>
						<table class="search_in" border="0" cellpadding="0" cellspacing="0" style="width:610;">
							<tr class="h23">
								<td width="60" >From Loc</td>
								<td width="150">
									<%= frLocSelectBox %>
									<input type="text" style="width:60;ime-mode:disabled;" name="fromlocation" maxlength=7 onKeyUp="javascript:upperCase_Num();">
									<img class="cursor" src="/hanjin/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="frloc_btn">
								</td>
								<td width="20">&nbsp;</td>			
								<td width="40">Item</td>
								<td width="100"><script language="javascript">ComComboObject('itemname' , 1, 90, 1 )</script></td>
								
								<td width="20">&nbsp;</td>					
								<td width="40">Lane</td>
								<td >
									<input name="lane" type="text" style="width:105;ime-mode:disabled;" value="" maxlength="3" onKeyUp="upperCase_Num()">		
								</td>												

							</tr>
							
							<tr class="h23">
								<td >To Loc</td>
								<td >
									<%= toLocSelectBox %>
									<input type="text" style="width:60;ime-mode:disabled;" name="tolocation"  maxlength=7 onKeyUp="javascript:upperCase_Num();">
									<img class="cursor" src="/hanjin/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="toloc_btn">
								</td>																							
								<td width="20">&nbsp;</td>						
								<td >TP/SZ</td>
								<td colspan=4>

									<table class="search" border="0">
										<tr>
											<td width="22%"><%= tyszSelectBox %></td>
											<td style="padding-left:2"><script language="javascript">ComComboObject('tpsztype' , 1, 192, 1 )</script></td>
										</tr>
									</table>	
								
								</td>												
							</tr>							
						</table>
					</td>
          </tr></table>

				<!-- TABLE '#D' : ( Search Options ) (E) -->
				
                <table class="line_bluedot"><tr><td></td></tr></table>
				<!-- TABLE '#D' : ( Tab BG Box ) (S) -->

							<!-- table class="search"><tr><td class="height_2"></td></tr></table -->
							<table width="100%" id="sheetControlDiv" style="">
							<tr>
							<!-- CSR NO : N200906040080 로 Data Selection 조건 추가  -->
							<td align="left">Data Selection: &nbsp;<input type="radio" name="dataselect"  class="trans" checked onclick="javascript:dataSelectionPlanBKG(1)" >&nbsp;ALL
							                <input type="radio" name="dataselect"   class="trans" onclick = "javascript:dataSelectionPlanBKG(2)">&nbsp;Plan
							                <input type="radio" name="dataselect"   class="trans" onclick = "javascript:dataSelectionPlanBKG(3)">&nbsp;REPO BKG
							</td>

							</tr>
							</table>

							
							<!-- : ( Grid ) (S) -->
							<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
							
							<table width="100%" id="mainTable">
								<tr><td><script language="javascript">ComSheetObject('t1sheet1');</script></td></tr>
							</table>
							
							<!-- : ( Grid ) (E) -->
							
							<!-- : ( Button_ Sub ) (S) -->
							<table width="100%" class="button">
								<tr><td class="btn2_bg">
									<table border="0" cellpadding="0" cellspacing="0">
										<tr><td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_rowaddnoplan" id="t1btng_rowaddnoplan">VL Add(No Plan)</td>
													<td class="btn2_right"></td></tr>
											</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_rowadd" id="t1btng_rowadd">VL Add</td>
													<td class="btn2_right"></td></tr>
											</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_vdsplit" id="t1btng_vdsplit">VD Split</td>
													<td class="btn2_right"></td></tr>
											</table></td>	
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_vdsplitmulti" id="t1btng_vdsplitmulti">VD Split(Multi)</td>
													<td class="btn2_right"></td></tr>
											</table></td>									
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_repobkg" id="t1btng_repobkg">Repo. BKG Cre.</td>
													<td class="btn2_right"></td></tr>
											</table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn2_left"></td>
													<td class="btn2" name="t1btng_gobkgupdate" id="t1btng_gobkgupdate">Mty Bkg Update</td>
													<td class="btn2_right"></td></tr>
											</table></td>											
										</tr>
									</table>
								</td></tr>
							</table>
							<!-- : ( Button_ Sub ) (E) -->
		</td>
	</tr>
</table>
				<!-- TABLE '#D' : ( Tab BG Box ) (E) -->			
		

	<!-- Outer Table (E)-->

	<iframe frameborder="0" width="0"  name="iframe1018_vvdexist" scrolling="no" frameborder="0" width="0" height="0"></iframe>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>