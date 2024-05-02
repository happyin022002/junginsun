<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0970.jsp
*@FileTitle : ESM_BKG_0970
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.08.24 경종윤
* 1.0 Creation
* ------------------------------------------------------
* HISTORY 
* 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0970Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0970Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd 		= "";
	String callGubun = "";
	String dType = "";
	String vvdCd = "";
	String portCd = "";
	String blNo = "";
	String cntrNo = "";
	String cntrCgoSeq = "";
	String pgmNo = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.SpecialManifest");

	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
	   
		event = (EsmBkg0970Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// 부모창에서 넘오온 파라메터 셋팅
		
		
		// 부모창에서 넘오온 파라메터 셋팅
		callGubun 	= (request.getParameter("callGubun") == null) ? "" : request.getParameter("callGubun");
		dType 		= (request.getParameter("d_type") == null) ? "" : request.getParameter("d_type");
		vvdCd 		= (request.getParameter("vvd_cd") == null) ? "" : request.getParameter("vvd_cd");
		portCd 		= (request.getParameter("port_cd") == null) ? "" : request.getParameter("port_cd");
		blNo 		= (request.getParameter("bl_no") == null) ? "" : request.getParameter("bl_no");
		cntrNo 		= (request.getParameter("cntr_no") == null) ? "" : request.getParameter("cntr_no");
		cntrCgoSeq 	= (request.getParameter("cntr_cgo_seq") == null) ? "" : request.getParameter("cntr_cgo_seq");
		pgmNo 		= (request.getParameter("pgmNo") == null) ? "" : request.getParameter("pgmNo");

		
		if("".equals(callGubun)) {
			if(strOfc_cd.startsWith("ANR")) {
				callGubun = "ESM_BKG_0965";
			} else {
				callGubun = "ESM_BKG_0966";
			}
		}
		
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
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage('<%=dType%>', '<%=callGubun%>');
	}
</script>
</head>


<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="call_gubun" value="<%=callGubun%>">
<input type="hidden" name="pgmNo" value="<%=pgmNo%>">


<!-- 개발자 작업	-->
<% if (request.getParameter("pgmNo") == null) { %>
<table width="1024" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr>
		<td valign="top">
			<table width="100%" border="0">
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Transit (Sending Results) by Container No</td></tr>
			</table>

<% } else { %>
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	<!--Page Title, Historical (S)-->
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
	<!--Page Title, Historical (E)-->	
<% } %>
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:;"> 
				<tr class="h23">
					<td width="400">
					
				<%
					if(callGubun.equals("ESM_BKG_0965")) {
				%>
					
							<table class="search_sm2" border="0" style="width:390;"> 
								<tr class="h23">
									<td width="80" rowspan="2">&nbsp;Declaration </td> 
									<td width="" class="stm">
										<input type="checkbox" name="d_type0" value="" class="trans">All &nbsp;
										<input type="checkbox" name="d_type1" value="D" class="trans">Discharging &nbsp;
										<input type="checkbox" name="d_type2" value="T" class="trans">Transit &nbsp;
										<input type="checkbox" name="d_type3" value="L" class="trans">Loading
									</td>	
								</tr>
								<tr class="h23">
									<td width="" class="stm">
										<input type="checkbox" name="d_type4" value="P" class="trans">Pre-carriage  &nbsp;
										<input type="checkbox" name="d_type5" value="O" class="trans">On-Carriage
									</td>	
								</tr>
							</table>
							
							<input type="hidden" name="d_type" caption="Declaration">
				<%
					} else {
				%>
							<table class="search_sm2" border="0" style="width:390;"> 
								<tr class="h23">
									<td width="80" rowspan="2">&nbsp;Declaration </td> 
									<td width="" class="stm">
										<input type="radio" name="d_type" value="" class="trans" checked>All &nbsp;
										<input type="radio" name="d_type" value="D" class="trans">Import &nbsp;
										<input type="radio" name="d_type" value="T" class="trans">Transit &nbsp;
										<input type="radio" name="d_type" value="L" class="trans">Export
									</td>	
								</tr>
							</table>
				
				<%
					}
				%>					
				
					</td> 
					<td width="" valign="top">
							<table class="search_sm2" border="0" style="width:;"> 
								<tr class="h23">
									<td width="250">
										<input type="radio" name="search_type" value="1" class="trans" checked>VVD&nbsp;
										<input type="text" style="width:80;" value="<%= vvdCd %>" class="input1" name="vvd_cd"
											dataformat="eng" required maxlength="9" fullfill caption="VVD">&nbsp;&nbsp;Port&nbsp;
											<%if(callGubun.equals("ESM_BKG_0965")) {%>
										<script language="JavaScript">ComComboObject("port_cd", 1, 65);</script>
										<input type="hidden" style="width:50;ime-mode: disabled" value="<%= portCd %>" class="input1" name="in_port_cd" dataformat="eng">
											<% }else{ %>
										<input type="text" style="width:50;ime-mode: disabled" value="<%= portCd %>" class="input1" name="port_cd" dataformat="eng" required maxlength="5" fullfill caption="Port">
											<% } %>
									</td> 
									<td>
										<input type="radio" name="search_type" value="2" class="trans">Transmit Date&nbsp;
										<input type="text"  style="width: 80; ime-mode: disabled" class="input1" maxlength="10"
											dataformat="ymd" name="snd_dt_from" required caption="Transmit Date From" cofield="snd_dt_from">
											&nbsp;~&nbsp; <input type="text"
											style="width: 80; ime-mode: disabled" class="input1" maxlength="10"
											dataformat="ymd" name="snd_dt_to" required caption="Transmit Date To" cofield="snd_dt_to">
											<img src="img/btns_calendar.gif" width="19" height="20" alt=""
												border="0" align="absmiddle" class="cursor" name="btn_calendar">										
									</td> 
								</tr>
							</table>
					</td> 
				</tr>
			</table>
			<table class="search" border="0" style="width:;"> 
				<tr class="h23">
				<% if(callGubun.equals("ESM_BKG_0965")) { %>
					<td width="50">B/L No.</td> 
					<td width="123">
						<input type="text" style="width:100;" value="<%= blNo %>" class="input1" name="bl_no"
							dataformat="eng" maxlength="12" fullfill caption="B/L No.">
					</td>
					<td width="90">Container No.</td> 
					<td width="160">
						<input type="text" style="width:90;" value="<%= cntrNo %>" class="input1" name="cntr_no"
						dataformat="eng" maxlength="14" caption="Container No.">
					</td>
				<% } else { %>
					<td width="50"></td> 
					<td width="123"><input type="hidden" style="width:100;" class="input1" name="bl_no"
							dataformat="eng" maxlength="12" fullfill caption="B/L No."></td>
					<td width="90"></td> 
					<td width="160"><input type="hidden" style="width:90;" class="input1" name="cntr_no"
						dataformat="eng" maxlength="14" caption="Container No."></td>
				<% } %>
					<td width="90">Message Type</td> 
					<td width="">
						<select style="width:200;" class="input1" name="msg_type">
							<option value="" selected>All</option>
							<option value="E" >Empty Message not sent</option>
							<option value="P" >Processing</option>
							<option value="A" >Sent, Accepted</option>
							<option value="C" >Sent, Wrong but Acceptable</option>
							<option value="R" >Sent, Not Acceptable</option>
							</select>
					</td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
			
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
				
				<table class="height_8"><tr><td></td></tr></table>
				
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
					<td class="btn1" name="btn1_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_DownExcel">Down Excel</td>
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
