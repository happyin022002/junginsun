<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0617.jsp
*@FileTitle : ESM_BKG_0617
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.07.10 김승민
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="java.util.Date"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0617Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0617Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.CLLCDLManifest");
	String inVvdCd = "";
	String inPolCd = "";
	String isPop = "";
	String toDate = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		inVvdCd = request.getParameter("inVvdCd")==null?"":request.getParameter("inVvdCd");
		inPolCd = request.getParameter("inPolCd")==null?"":request.getParameter("inPolCd");
		isPop = request.getParameter("isPop")==null?"":request.getParameter("isPop");
		
		Date to = new Date();
		toDate = DateTime.getDateString();
		toDate = toDate.replace(".","-");

		event = (EsmBkg0617Event)request.getAttribute("Event");
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
<title>ESM_BKG_0617</title>
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
<input type="hidden" name="in_list_type">
<input type="hidden" name="in_check_gubun">
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
					<td width="123">EDI Receiving Date</td>
					<td width="220"><input type="text" style="width:70;" class="input" name="in_cr_indate_start" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=toDate%>">&nbsp;~&nbsp;<input type="text" style="width:70;" class="input" name="in_cr_indate_end" maxlength="10" dataformat="ymd" style="ime-mode:disabled" value="<%=toDate%>">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar"></td>
					<td width="375">
						<table border="0" style="width:100%;" class="search_sm2"> 
						<tr class="h23">
						<td width="55">List Type</td>
					    <td width=""class="stm"><input type="radio" name="in_list_type_temp" value="" class="trans" checked onclick="setListTeye('searchGubun','L')">&nbsp;Loading(Outbound) &nbsp;&nbsp;<input type="radio" value="" name="in_list_type_temp" class="trans" onclick="setListTeye('searchGubun','D')">&nbsp;&nbsp;Discharging(Inbound) </td></tr></table>
					<td width="85">
					<div id="loadingDate" border="0" style="display:block"><table class="search"><tr class="h23"><td>Loading Date</td></tr></table></div>
					<div id="dischargingDate" border="0" style="display:none"><table class="search"><tr class="h23"><td>Discharging Date</td></tr></table></div>
					</td>
					<td width=""><input type="text" style="width:70;" class="input" name="in_cr_edate_start" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled">&nbsp;~&nbsp;<input type="text" style="width:70;" class="input" name="in_cr_edate_end" value="" maxlength="10" dataformat="ymd" style="ime-mode:disabled">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					</tr></table>
				<!--  biz_1   (E) -->
				
				
				<!--  biz_2  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="70%" height="80">
					<table style="width:100%;">
					<tr class="h23"><td width="77">Yard</td>
					<td width="110"><input type="text" style="width:80;" class="input" name="in_cr_yard" value="" maxlength="7" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td width="30">VVD</td>
					<td width="110"><input type="text" style="width:80;" class="input" name="in_vvd_cd" value="<%=inVvdCd %>" maxlength="9" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td width="55">POL</td>
					<td width="110"><input type="text" style="width:50;" class="input" name="in_pol_cd" value="<%=inPolCd %>" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					<td width="84">POD</td>
					<td><input type="text" style="width:50;" class="input" name="in_pod_cd" value="" maxlength="5" dataformat="upper" style="ime-mode:disabled"></td>
					</tr>
					<tr class="h23"><td>Vessel Name</td>
					<td colspan="3"><input type="text" style="width:220;" class="input" name="in_cr_vslname" value="" maxlength="20" dataformat="uppernum2" style="ime-mode:disabled"></td>
					<td>Call Sign</td>
					<td><input type="text" style="width:80;" class="input" name="in_cr_callsign" value="" maxlength="15" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td>Container No.</td>
					<td><input type="text" style="width:90;" class="input" name="in_cntr_no" value="" maxlength="11" dataformat="uppernum" style="ime-mode:disabled"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					</tr>
					</table>
				</td>
				<td width="">
					
					<table border="0" style="width:100%;"><tr><td>
					<!--  biz_2  (S) -->
				<div id="searchGubun" border="0" style="display:block">
				<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr class="tr2_head">
					<td width="100%"align="center" colspan="2">Data Cross-Check</td>
					</tr>
				<tr>
					<td width="20%" class="tr2_head2">Booking</td>
					<td width="%"><input type="checkbox" name="in_check_gubun_temp1" value="" class="trans" onclick="setSearchGubun('1')">&nbsp; Matched &nbsp;&nbsp;&nbsp;<input type="checkbox" name="in_check_gubun_temp2" value=""class="trans" onclick="setSearchGubun('2')">&nbsp;Un-matched</td>
				</tr>
				<tr>
					<td width="20%" class="tr2_head2">CLL</td>
					<td width="%"><input type="checkbox" name="in_check_gubun_temp3" value="" class="trans" onclick="setSearchGubun('3')">&nbsp; Matched &nbsp;&nbsp;&nbsp;<input type="checkbox" name="in_check_gubun_temp4" value=""class="trans" onclick="setSearchGubun('4')">&nbsp;Un-matched</td>
				</tr>
				</table>
				</div>
			<!--  biz_2  (E) -->	
			
					</td></tr></table>
				</td>
			</tr></table>
				<!--  biz_2   (E) -->		
				
	
			<table class="height_8"><tr><td></td></tr></table>
		
		
				
			
				<!-- Grid  (S) -->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<table width="100%"  id="mainTable" style="display:none">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>						
		
			<!-- Grid (E) -->
			
				
			
		</td></tr>
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
				
				<td class="btn1_line"></td>
				<%if(!"Y".equals(isPop)){ %>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cllForEDI">CLL for EDI</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<%}%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
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

</form>
</body>
</html>