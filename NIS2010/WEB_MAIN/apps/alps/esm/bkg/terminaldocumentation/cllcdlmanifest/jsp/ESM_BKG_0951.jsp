<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0951.jsp
*@FileTitle : Load Summary by POD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.28 김승민
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.09.21 김보배 [CHM-201220211] [BKG] Load Summary by POD 상 Special Stowage Type 추가
* 2012.12.24 김보배 [CHM-201222011] [BKG] Load Summary by POD에 Special Stowage "MUPG" 추가 요청
* 2012.12.24 김보배 [CHM-201222024] [BKG] Stowage code "MUPG" CLL  반영 요청
* 2012.12.28 김보배 [CHM-201222025] [BKG] [Special Stowage Request Code] 간소화 및 HIDE CBF 미 반영 개정건
* 2014.07.28 이한나 [CHM-201431212] Stowage : UDMX 추가에 따른 CLL 반영 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0951Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0951Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");
	String pgmNo = request.getParameter("pgmNo");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0951Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<title>Load Summary by POD</title>
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
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="in_ui_type" value="P">
<input type="hidden" name="in_pgm_no" value="<%=pgmNo%>">	

<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--top menu (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="40">VVD </td> 
									<td width="160"><input type="text" style="width:80;" name="in_vvd_cd" value="" dataformat="uppernum" class="input1" maxlength="9" style="ime-mode:disabled"></td>	
									<td width="30">POL</td>
									<td width="140"><input type="text" style="width:50;" name="in_pol_cd" value="" dataformat="upper" class="input1" maxlength="5" style="ime-mode:disabled">&nbsp;<input type="text" name="in_pol_yd_cd" style="width:30;" value="" class="input1" maxlength="2" dataformat="uppernum" style="ime-mode:disabled"></td>
									<td width="70">BKG Office</td>
									<td width="559"><input type="text" style="width:100;" name="in_bkg_ofc_cd" value="" dataformat="uppernum" class="input" maxlength="6" style="ime-mode:disabled"></td> 
								</tr>
							</table>
							<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="36"></td>
									<td width="880"><input type="text" style="width:700;" name="setText1" value="" class="input" dataformat="uppernum2" maxlength="80"></td>
									<td width="40"></td>
									<td width=""></td>	
								</tr>
								<tr class="h23">
									<td width="36"></td>
									<td width="900"><input type="text" style="width:700;" name="setText2" value="" class="input" dataformat="uppernum2" maxlength="100"></td>
									<td width="40"></td>
									<td width=""></td>	
								</tr>
							</table>
							<table class="search" border="0" style="width:979;"> 
								<tr class="h23">
									<td width="40">VVD</td>
									<td width="620"><input type="text" name="vvd_cd" style="width:500;" value="" class="input2" readonly></td>
									<td width="27">POL</td>
									<td width="193"><input type="text" name="un_loc_cd" style="width:51;" value="" class="input2" readonly></td>
									<td width="40">ETD</td>
									<td width=""><input type="text" name="vps_etd_dt" style="width:140;" value="" class="input2" readonly></td>	
								</tr>
							</table>
							<!--  biz_1   (E) -->
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search"> 
       			<tr><td class="bg">
       			
       				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Loading Summary by POD</td></tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="140"><input type="text" style="width:130;" value="(excluded Void slot)" class="input2" readonly></td>
					<td width=""><input type="text" style="width:100;" value="POD : UN code" class="input2" readonly></td>	
				</tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
				
				<table class="height_8"><tr><td></td></tr></table>
       			
       				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Special Cargo Summary by POD</td></tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 
				<!-- : ( Grid ) (E) -->	
				
				<table class="height_8"><tr><td></td></tr></table>
       			
       				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Special Stowage Request by POD</td></tr>
				</table>
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table> 
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet4');</script>
						</td>
					</tr>
				</table>				
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet5');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<table class="height_8">
					<tr>
						<td></td>
					</tr>
				</table>				
				<table class="search" border="0" style="width: 979;">
					<tr class="stm">
						<td width="300">AB - Away from boiler</td>
						<td width="300">AF - Away from foodstuffs</td>
						<td width="">AL - Away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">BC - Block stowage</td>
						<td width="300">OD - On Deck stowage</td>
						<td width="">ODAB - On deck away from boiler</td>
					</tr>
					<tr class="stm">						
						<td width="300">OBSS - One bay STWG(ONLY SAMSUNG)</td>
						<td width="300">OLBS - Early Discharge (With value added SVC)</td>						
						<td width="">ODAL - On deck away from living quarters</td>
					</tr>
					<tr class="stm">
						<td width="300">ODBC - On deck block stowage</td>
						<td width="300">ODET - On Deck Except Top Stowage</td>
						<td width="">ODFT - On Deck For Flectank</td>
					</tr>
					<tr class="stm">
						<td width="300">ODHD - On deck for Hide</td>
						<td width="300">OP - On deck protected</td>
						<td width="">OT - On deck top</td>
					</tr>
					<tr class="stm">
						<td width="300">OTNO - On deck Top not overstow</td>
						<td width="300">PC - Pre caution</td>
						<td width="">PCOD - Pre caution on deck</td>
					</tr>
					<tr class="stm">
						<td width="300">TS - Top stowage</td>
						<td width="300">OLBP - Priority Early Discharge (Premium Express SVC)</td>
						<td width="">UD - Under Deck</td>
					</tr>	
					<tr class="stm">
						<td width="300">UT - Under deck top</td>
						<td width="300">UDAB - Under Deck away from heating source</td>
						<td width="">UW - Under waterline</td>
						
					</tr>	
					<tr class="stm">
						<td width="300">UTAB - Under deck top away from boiler</td>
						<td width="350">MUPG - Marble UP(Under deck protected) by general cargoes</td>
						<td width="">UDMX - Under Deck for AK only (Not for Dry)</td>
					</tr>
					<tr class="stm">
						<td width="300">OLBL - Discharge (Only LG Electronics Inc)</td>
						<td width="350"></td>
						<td width=""></td>
					</tr>

				</table>
				
				
				<table class="height_8"><tr><td></td></tr></table>
       			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Remark(s)</td>
					<td width=""><textarea name="remark" style="width:100%;height:60;" dataformat="uppernum2"></textarea></td>
				</tr>
				</table>
			</td></tr>
		</table>		
			
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Summary">Summary</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Special_CGO">Special CGO</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td class="btn1_line"></td>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
</body>
</html>