<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0056.jsp
*@FileTitle : Inquiry by T/S port
*Open Issues :
*Change history :
	* 2006-11-22 이민석
	* 1.0 최초 생성
	* 2008-03-19 김원섭
	* CSR : N200803190014   T/S allocation 관련 SPC 화면 수정
	*   - 검색조건 T/S Port 길이 제한 추가
	*   - DataSelection 항목 label 기능 추가
	* 2008-11-17 임옥영/서관영 CSR:N200811140005/N200811130019
	* - 단축키 추가(ESM_SPC_022, 024, 028, 056, 070)
*@LastModifyDate : 2009.10.13
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.13 한상훈
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2013.02.06 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 - Type/Size 별 Hidden 기능 추가
* 2013.11.14 진마리아 ALPS ERROR LOG 조치 - 날짜 형식 체크가 change에서 일어나서, 알맞지 않더라도 지워주지 않아 그대로 조회하며 에러발생
* 2014.07.31 차상영 [CHM-201431081] SPC Allocation Control Option 추가 보완
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0056Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.Spacecontrolinquiry.Spacecontrolinquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0056Event)request.getAttribute("Event");
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
<title>Inquiry by T/S port</title>
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
							<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
						<!-- Repeat Pattern -->

					</tr>
				</table>
			
			</td></tr>
		</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
    	
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="85"><img class="nostar">Date</td>
					<td width="350" colspan="3">
						<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="sDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate_0056();" onblur="convertDateFnc();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar1" align="absmiddle">
						&nbsp;~&nbsp;
						<input class="input1" type="text" style="width:72;ime-mode:disabled;" value="" name="eDate" maxlength="8" onkeypress="checkDateFormat();" onfocus="initDate();" onchange="checkDate_0056();" onblur="convertDateFnc();">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" name="btns_calendar2" align="absmiddle">
					</td>
					<td width="60">T/S Port</td>
					<td width="150">
						<input class="input1" name="port" type="text" maxlength="5" style="width:50;ime-mode:disabled;" value="" onkeypress="eventKeyChangeChar(UPPER_CASE)">
						<img class="cursor" name="btn_popup_port" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="50">VVD</td>
					<td width="150"><input class="input1" type="text" name="vvd" size="15" maxlength="9" style="ime-mode:disabled;" onkeypress="eventKeyChangeChar(UPPER_CASE);"></td>
					<td width="50">Origin</td>
					<td><input type="text" size="5" value="<%//=event.getSignOnUserAccount().getOfc_cd() %>" name="org" onkeypress="eventKeyChangeChar(UPPER_CASE)"></td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Rep. Trade</td>
					<td width="150" style="padding-left:2;">
						<script language="JavaScript">ComComboObject("trade", 2, 95, 0, 1);</script>
					</td>
					<td width="70">Sub Trade</td>
					<td width="130">
						<script language="JavaScript">ComComboObject("subtrade", 3, 60, 0, 0);</script>
					</td>
					<td width="60">Lane</td>
					<td width="150" style="padding-left:2;">
						<script language="JavaScript">ComComboObject("lane", 4, 73, 0, 0);</script>
					</td>
					<td width="50">Bound</td>
					<td width="150">
						<select name="bound" style="width:100;"></select>
					</td>
					<td width="50">O/I</td>
					<td width="">
						<select name="ioc" style="width:47;"></select>
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		
		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
       	
				<table border="0" style="width:100%;">
				<tr class="h23">
					<td align="left" nowrap width="130">Data Selection</td>
					<td width="25"><input type="checkbox" class="trans" name="chkDs2D2" id="ds2D2" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2D2">D2</label></td>					
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2D4" id="ds2D4" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2D4">D4</label></td>						
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2HC" id="ds2HC" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2HC">HC</label></td>
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs245" id="ds245" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds245">45</label></td>
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs253" id="ds253" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds253">53'</label></td>
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2RF" id="ds2RF" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2RF">RF</label></td>
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2RD" id="ds2RD" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2RD">RD</label></td>	
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2WT" id="ds2WT" onclick="return viewByTpSz();"></td>
					<td width="25"><label for="ds2WT">WT</label></td>
					
					<td width="25"><input type="checkbox" class="trans" name="chkDs2Suboffice" id="chkDs2Suboffice" onclick="return viewByTpSz();"></td>
					<td><label for="chkDs2Suboffice">Sub-office</label></td>
					
				</tr>
				</table>
				
				<!-- : ( grid ) (S) -->
				<table width="100%" id="mainTable1">
					<tr><td>
							<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( grid ) (E) -->
		
		</td></tr>
		</table>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>