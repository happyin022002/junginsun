<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1091.jsp
*@FileTitle : ESM_BKG_1091
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2010.04.15 경종윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1091Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1091Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TerminalDocumentation.SpecialManifest");

	String bayId = "";
	String openType = "";
	String currMainPageListCnt = "0";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// 부모창에서 넘오온 파라메터 셋팅
		bayId 	= (request.getParameter("bayId") == null) 	? "" : request.getParameter("bayId");
		openType = (request.getParameter("openType") == null) ? "" : request.getParameter("openType");
		currMainPageListCnt = (request.getParameter("currMainPageListCnt") == null) ? "0" : request.getParameter("currMainPageListCnt");
		
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
		loadPage();
	}
</script>
</head>


<body  onLoad="setupPage();"> 
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="openType" value=<%=openType %>>
<input type="hidden" name="currMainPageListCnt" value=<%=currMainPageListCnt %>>


<!-- 개발자 작업	-->


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle">&nbsp; Bayplan Setup Details Pop-up</td>
			</tr>
		</table>
		<!--Page Title, Historical (E)-->	
		
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
			
			<table class="search" border="0" style="width:;">
			  
				<tr class="h23">
					<td width="50">Bay ID</td> 
					<td width="115"><input type="text" style="width:100; ime-mode: disabled" class="input1" name="bay_pln_id" value="<%=bayId%>" 
						dataformat="eng" required maxlength="20" caption="Bay ID"></td>
					<td width="85">Container No</td> 
					<td width="115"><input type="text" style="width:100; ime-mode: disabled" class="input" name="eur_dg_cntr_id" value="" 
						dataformat="eng" maxlength="20"></td>
					<td width="80">Cell Position</td> 
					<td width="100"><input type="text" style="width:80; ime-mode: disabled" class="input" name="cell_psn_no" value="" 
						dataformat="eng" maxlength="7"></td>
					<td width="60">Operator</td> 
					<td width="*"><input type="text" style="width:50; ime-mode: disabled" class="input" name="cntr_opr_id" value="SML" 
						dataformat="eng" maxlength="7"></td>
				</tr>
			</table>
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->	
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
	<tr>
		<td height="71" class="popup">
		
		<!--  Button (S) -->
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
		       	<tr>
		       		<td class="btn3_bg">
				    <table border="0" cellpadding="0" cellspacing="0">
				    <tr>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr>
									<td class="btn1_left">&nbsp;</td>
									<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
									<td class="btn1_right">&nbsp;</td>
								</tr>
							</table>
						</td>
						<td class="btn1_line">&nbsp;</td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Select">Select</td>
							<td class="btn1_right"></td>
							</tr>
						</table></td>
						<td class="btn1_line">&nbsp;</td>
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left">&nbsp;</td>
								<td class="btn1" name="btn_Close">Close</td>
								<td class="btn1_right">&nbsp;</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>
					</td>
				</tr>
			</table>
	    <!--Button (E) -->
		
		</td>
	</tr>
</table>
<!-- : ( Button : pop ) (E) -->
	
			
		
<!-- 개발자 작업  끝 -->
</form>
			
</body>
</html>
