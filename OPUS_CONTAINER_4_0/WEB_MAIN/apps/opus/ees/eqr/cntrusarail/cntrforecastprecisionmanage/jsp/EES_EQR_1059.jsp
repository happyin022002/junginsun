<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_1059.jsp
*@FileTitle : MTY Rail Trans Result
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.cntrusarail.cntrforecastprecisionmanage.event.EesEqr1059Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesEqr1059Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr1059Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String optionStr = "000000: :ALL";
	String cntrTpsz  = JSPUtil.getCodeCombo("cntrTpsz","","style='width:62;'","CD00263",0,optionStr);

	String railCompany  = JSPUtil.getCodeCombo("rail_company","","style='width:370;'","CD00930",0,optionStr);

%>
<html>
<head>
<title>MTY Rail Trans Result</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
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
<form name="form"  onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input	type="hidden" name="diff_date">
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
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_new" id="btn_new">New</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<td class="btn1_line"></td>	
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<td class="btn1_line"></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_print" id="btn_print">Print</td>
									<td class="btn1_right"></td>
								</tr></table></td>
							<!-- Repeat Pattern -->
						</tr>
					</table>
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Button : Main ) (E) -->

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<div id="searchLayer">
		     	<table class="search">
					<tr><td class="bg"> 
						<table class="search_in" border="0">
							<tr class="h23">
								<td colspan="2" align="left" width="120">
									<img class="nostar"><select name="date_kind" class="input1" style="width:111;">
										<option value="A">Arrival Date</option>
										<option value="D">Departure Date</option></select></td>
								<td width="195"><input name="fm_dt" type="text" class="input1" style="width:72;" maxlength="10" dataformat="ymdhm">&nbsp;~&nbsp;
												<input name="to_dt" type="text" class="input1" style="width:72;" maxlength="10" dataformat="ymdhm"><img name="btns_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" ></td>
								<td width="10"></td>
								<td width="95">Origin Location</td>
								<td width="85"><input name="org_loc" maxlength="5" type="text" class="input" style="width:50;ime-mode:disabled;" dataformat='engup'><img name="btn_orgloc" class="cursor" src="/opuscntr/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="90">Dest. Location</td>
								<td width="85"><input name="dest_loc" maxlength="5" type="text" class="input" style="width:50;ime-mode:disabled;" dataformat='engup'><img name="btn_destloc" class="cursor" src="/opuscntr/img/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
								<td width="60">Company</td>
								<td width="40"><input name="company" type="text" style="width:35;" value="Hanjin" class="input2" readOnly></td>
								<td width="10"></td>
								<td rowSpan="2">
									<table style="padding:1px;border:1px solid #C9C4DF">
										<tr><td><img class="nostar"><input type="radio" class="trans" name="gubun" value="A" checked ></td><td>Loc. to Loc.</td><td width="20"></td></tr>
										<tr><td><img class="nostar"><input type="radio" class="trans" name="gubun" value="B" ></td><td>Yard to Yard</td><td width="20"></td></tr>
									</table>
								</td>
							</tr>
							<tr class="h23">
								<td width="55"><img class="nostar">TP/SZ</td>
								<td width="65"><%= cntrTpsz %></td>
								<td width="195">&nbsp;<script language="javascript">ComComboObject('tpsztype' , 1, 184, 1 )</script></td>
								<td width="10"></td>
								<td width="95">Rail Company</td>
								<td width="370" colspan="5"><%= railCompany %></td>
								<td></td>
							</tr>
						</table>
					</td>
					</tr>
				</table>
			</div>
			<!-- TABLE '#D' : ( Search Options ) (E) -->

			<table class="height_10"><tr><td></td></tr></table>

			<!-- TABLE '#D' : ( Grid BG Box ) (S) -->
			<table class="search" border="0">
				<tr>
					<td class="bg">
						<table class="search"><tr><td height="3"></td></tr></table>
						<!-- : ( Grid ) (S) -->
						<!-- 'HEAD1-BGCOLOR : 203 240 169' , 'HEAD2-BGCOLOR : 222 251 248' , 'BORDER 1-outside : 88 152 164' ,'BORDER 2-inside : 202 226 233' , 'HEAD-FONT : 39 95 101' , 'SELETED ROW BG : 252 255 233' -->
					     <table width="100%" id="mainTable">
	                        <tr><td>
	                             <script language="javascript">ComSheetObject('sheet1');</script>
	                        </td></tr>
	                        <tr><td>
		                             <script language="javascript">ComSheetObject('sheet2');</script>
		                    </td></tr>
	                    </table>
						<!-- : ( Grid ) (E) -->
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Grid BG Box ) (E) -->
		</td></tr>
	</table>
	<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>