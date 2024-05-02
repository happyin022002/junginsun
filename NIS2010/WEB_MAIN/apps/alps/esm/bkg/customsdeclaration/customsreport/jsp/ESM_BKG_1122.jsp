<%/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_BKG_1122.jsp
*@FileTitle : US AMS : BAPLIE Monitoring Report
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김봉균 
*@LastVersion : 1.0
* 2011.06.20 김봉균
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.event.EsmBkg1122Event"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg1122Event  event 		= null;	//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;	//서버에서 발생한 에러
	String strErrMsg 			= "";	//에러메세지
	int rowCount	 			= 0;	//DB ResultSet 리스트의 건수

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "1000";
	String strUsr_id	= "";
	String strUsr_nm	= "";
    String today        = "";
	String strPgmNo = "";
	String strCustoms = "";

	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.CustomsReport");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1122Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        
		strPgmNo = JSPUtil.getParameter(request, "pgmNo");
		strCustoms = "ESM_BKG_1122".equals(strPgmNo) ? "US" : "CA";

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>US AMS : BAPLIE Monitoring Report</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    var today = "<%=today%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		loadPage();
	}
</script>
</head>

<body  onLoad="javascript:setupPage();">
<form name="form" method="post">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value=<%=pageRows%>>
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">
<input type="hidden" name="pageno" value="<%=strPgmNo%>">
<input type="hidden" name="customs_gb" value="<%=strCustoms%>">

<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;padding-right:5;">
	<tr><td valign="top">
        <!--Page Title, Historical (S)-->
        <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
            <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
            <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title">US AMS : BAPLIE Monitoring Report</span></td></tr>
        </table>
        <!--Page Title, Historical (E)-->
	
	
		<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="50">LANE</td>
					<td width="70"><input type="text" name="lane" style="width:50; ime-mode: disabled;" class="input"
                        dataformat="engup" maxlength="3" fullfill caption="LANE"></td>
					<td width="60">VVD</td>
					<td width="120"><input type="text" name="vvd" style="width:90; ime-mode: disabled;" class="input1" 
						dataformat="eng" maxlength="9" fullfill caption="VVD"></td> 
					<td width="80">Last F. POL</td>
					<td width="80"><input type="text" name="l_pol" style="width:70; ime-mode: disabled;" class="input"
                        dataformat="eng" maxlength="5" fullfill caption="Last Foreign POL"></td>
        
					<td rowspan="2" align="right">
					
						<table class="search_sm" border="0" width="400">
							<tr class="h23">
								<td width="120"><input type="checkbox" name="gubun" class="trans"></td>
								<td width="50%">
									<input type="radio" name="srch_dt" value="atd" class="trans" checked>&nbsp;Vessel A.T.D.<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Actual Time of Departure)</td>
								<td width="40%">
									<input type="radio" name="srch_dt" value="due" class="trans">&nbsp;Due Date</td>
							</tr>
							<tr class="h23">
								<td></td>
								<td class="stm" colspan="2">
			                        <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="" required disabled
			                        dataformat="ymd" name="due_from_dt" maxlength="10" caption="Due Date" cofield="due_to_dt">
			                        <input type="text" name="due_from_tm" maxlength="5" style="width:40" dataformat="hm" value="00:00" class="input1" disabled>
			                        ~ <input type="text"
			                        style="width: 75; ime-mode: disabled" class="input1" value="" required disabled
			                        dataformat="ymd" name="due_to_dt" maxlength="10" caption="Due Date" cofield="due_from_dt">
			                        <input type="text" name="due_to_tm" maxlength="5" style="width:40" value="23:59" class="input1" disabled>
			                        <img src="img/btns_calendar.gif" width="19" height="20" border="0" dataformat="hm" align="absmiddle" class="cursor" name="btn_calendar">
								</td>
							</tr>
						</table>

					</td> 
				</tr>
				<tr class="h23">
				    <td width="60">Customs</td>
					<td><input type="text" name="customs" style="width:70; ime-mode: disabled;" class="input"
						dataformat="eng" maxlength="5" fullfill caption="Customs"></td> 
					<td colspan="2" width="180">Send Status&nbsp;&nbsp;&nbsp;
						<select name="snd_sts" class="input" style="width:60;">
						<option value="" selected>All</option>
						<option value="N">No</option>
						<option value="Y">Yes</option>
						</select>
					</td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">

				<!--Grid (S)-->
				<table width="100%"  id="mainTable">  
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>				
				<!--Grid (E)-->
				
				
			</td></tr>
		</table>
		<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>				
			<td align="right">			
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>				
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_downExcel">Down Excel</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>					
					<td class="btn1_line"></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_baplie">Go to BAPLIE</td>
						<td class="btn1_right"></td>
						</tr>
					</table></td>
				</tr></table>				
			</td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>