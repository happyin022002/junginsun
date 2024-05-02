<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0057.jsp
*@FileTitle : Cargo Handling Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.05 김종옥
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
<%@ page import="com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event.VopOpf0057Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.Date"%>

<%
	VopOpf0057Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CargoLoadingResultMgt.TerminalDepartureReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopOpf0057Event)request.getAttribute("Event");
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
<title>Cargo Handling Performance</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	
	
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<!-- biz_1  (S) -->
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="30">Port</td>
				<td width="140"> 
					<input type="text" name="loc_cd" style="width:48;ime-mode:disabled" class="input1" dataformat="engup" maxlength="5" caption="Port" required fullfill>&nbsp;<img src="img/btns_search.gif" name="btn_loc_cd" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;
					<script language="javascript">ComComboObject('yd_cd', 2, 55, 1);</script>
				</td> 
				<td width="30">Lane</td>
				<td width="80"><input type="text" name="slan_cd" style="width:40;ime-mode:disabled;" class="input1" dataformat="engup" maxlength="3" caption="Lane" required fullfill>&nbsp;<img src="img/btns_search.gif" name="btn_slan_cd_pop" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="90">From to Date</td>
				<td width="220">  <!-- lastDayOfMonth -->
					<input type="hidden" name="now_date" value="<%=DateTime.getFormatDate(new Date(),"yyyy-MM-dd")%>">
					<input type="hidden" name="last_day" value="<%=DateTime.lastDayOfMonth(DateTime.getFormatDate(new Date(),"yyyyMMdd"))%>">
					<input type="text" name="from_date" style="width:80;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;~&nbsp;<input type="text" name="to_date" style="width:80;" class="input1" dataformat="ymd" maxlength="8" caption="From to Date">&nbsp;<img src="img/btns_calendar.gif" name="from_to_calendar" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				<td width="200">
					<table class="search_sm2" border="0" style="width:210;"> 
					<tr class="h23">
						<td width="100">Cargo Operator</td>
						<td class="stm"><input type="radio" name="opr_cd" value="" class="trans" checked>All&nbsp;&nbsp;&nbsp;<input type="radio" name="opr_cd" value="SML" class="trans">SML</td>
					</tr>
					</table>
				</td>
				<td align="right">
					<table class="search_sm2" border="0" style="width:180;"> 
					<tr class="h23">
						<td width="50">Option</td>
						<td class="stm"><input type="radio" name="option_cd" value="" class="trans" checked>Trunk&nbsp;&nbsp;&nbsp;<input type="radio" name="option_cd" value="O" class="trans">Feeder</td>
					</tr>
					</table>
				</td>
			</tr>
			</table>	
		<!-- biz_1  (E) -->		
		</td></tr>
		</table>		
   		<table class="height_8"><tr><td></td></tr></table>	
			
		<!-- TAB [ VVD ] (S) -->
		<div id="tabLayer" style="display:inline">
					
			<table class="search"> 
		    <tr><td class="bg">
				<!-- biz_1  (S) -->
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->	
			</td></tr>
			</table>
			<!-- Tab BG Box(E) -->
			<!--biz page (E)-->
			
		</div>
		<!-- TAB [ VVD ] (E) -->
	
		<!-- TAB [ Gang Structure ] (E) -->
		<div id="tabLayer" style="display:none">
			<table class="search" id="mainTable"> 
       		<tr><td class="bg">			
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
			</td></tr>
			</table>
		</div>
		<!-- TAB [ Gang Structure ] (E) -->		
	
		<!--Button (S) -->
		<!-- Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
		<!-- Button (E) -->
	</td></tr>
</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>