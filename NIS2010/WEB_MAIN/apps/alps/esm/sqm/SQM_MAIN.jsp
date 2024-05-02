<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : ESM_SQM_0000.jsp
*@FileTitle      : sample
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
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
<%@ page import="com.hanjin.apps.alps.esm.sqm.datamanage.basicdata.event.EsmSqm0001Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSqm0001Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.sqm");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSqm0001Event)request.getAttribute("Event");
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
<title>sample</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
var hostname = location.hostname;
var port = location.port;

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}

	function openWindow(URL){
		document.form.target = "_blank";
		window.open("http://" + hostname + ":" + port + URL, "Window","width=1000, height=550,status=yes,scrollbars=no, resizable=yes,menubar=no");
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
	<tr>
		<td>
		
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search">
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="300">Data Management</td>
								<td width="300">Planning</td>
							</tr>
						</table>
						<table class="search_in" border="0">
						<tr><td class="line_bluedot" style="height:11;"></td></tr>
						</table>							
						<table border="0" style="padding:0px; font-size: 12px; width:979;">
							<tr>
								<td width="300" style="vertical-align:top;">
								Basic Data Management<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0001.do');">[ESM_SQM_0001] Basic Data Relation Setting</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0038.do');">[ESM_SQM_0038] Lane Master</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0002.do');">[ESM_SQM_0002] Lane Direction Change</a><br>
								<br>Office Mapping Management<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0007.do');">[ESM_SQM_0007] RHQ-Office Mapping</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0008.do');">[ESM_SQM_0008] Lane-Office Relation Setting</a><br>
								<br>Basic Data Creation<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0003.do');">[ESM_SQM_0003] Basic Data Creation</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0005.do');">[ESM_SQM_0005] Target VVD Fix</a><br>
								<br>Unit Cost Management<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0010.do');">[ESM_SQM_0010] NEW Lane&Office CMCB</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0011.do');">[ESM_SQM_0011] Basic CMCB</a><br>
								</td>
								<td width="300" style="vertical-align:top;">
								Planning by Yearly & Quarterly<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0014.do');">[ESM_SQM_0014] QTA Set up by Head Office(L/F&G.RPB)</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0015.do');">[ESM_SQM_0015] RBC Lane QTA</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0016.do');">[ESM_SQM_0016] QTA Set-up by Head Office</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0019.do');">[ESM_SQM_0019] QTA Set up by RHQ_OB Loading</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0022.do');">[ESM_SQM_0022] QTA Set up by RHQ_NON OB Contract</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0025.do');">[ESM_SQM_0025] QTA Set up by RHQ_OB Contract</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0040.do');">[ESM_SQM_0040] QTA Set up by RHQ_Contract TTL retrieve only)</a><br>
								<br><a href="#" onClick="openWindow('/hanjin/ESM_SQM_0028.do');">[ESM_SQM_0028] QTA Establishing Status Management</a><br>
								<br>Planning QTA Inquiry<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0029.do');">[ESM_SQM_0029] QTA Inquiry_Yearly Planning</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0030.do');">[ESM_SQM_0030] QTA Inquiry_Quarterly Planning</a><br>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class="bg">
						<table class="search_in" border="0">
							<tr class="h23">
								<td width="300">Final QTA Adjustment</td>
								<td width="300">RF SPCL KPI</td>
							</tr>
						</table>
						<table class="search_in" border="0">
						<tr><td class="line_bluedot" style="height:11;"></td></tr>
						</table>								
						<table border="0" style="padding:0px; font-size: 12px; width:979;">
							<tr>
								<td width="300" style="vertical-align:top;">
								Post QTA Adjustment by HO & RHQ<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0031.do');">[ESM_SQM_0031] QTA Adjustment by VVD</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0032.do');">[ESM_SQM_0032] Portion Adjustment by Head Office</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0033.do');">[ESM_SQM_0033] Portion Adjustment by RHQ</a><br>
								<br>Post QTA Adjustment<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0034.do');">[ESM_SQM_0034] QTA Edit</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0035.do');">[ESM_SQM_0035] Allocation = QTA Setting</a><br>
							    <br><br><B>Final QTA Report</B><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0036.do');">[ESM_SQM_0036] Yearly Currnet QTA Report</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0037.do');">[ESM_SQM_0037] Quarterly Current QTA Report</a><br>
								</td>
							    <td width="300" style="vertical-align:top;">
								KPI Planning<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0501.do');">[ESM_SQM_0501] KPI Input by Head Office</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0502.do');">[ESM_SQM_0502] Basic CMCB</a><br>
								<br>KPI Creation Q Adjustment<br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0504.do');">[ESM_SQM_0504] KPI Creation & Edit</a><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0507.do');">[ESM_SQM_0507] SKD Adjustment by VVD</a><br>
								<br><a href="#" onClick="openWindow('/hanjin/ESM_SQM_0508.do');">[ESM_SQM_0508] Current KPI Report</a><br>
								<br><br>
							    <b>Key ACCT KPI</b><br>
								  &nbsp&nbsp <a href="#" onClick="openWindow('/hanjin/ESM_SQM_0601.do');">[ESM_SQM_0601] KPI Upload</a><br>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) -->
			
			<table class="height_10"><tr><td></td></tr></table>
			
		</td>
	</tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>