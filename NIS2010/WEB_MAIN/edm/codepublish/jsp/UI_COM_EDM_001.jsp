<%--
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : UI_COM_EDM_001.jsp
*@FileTitle : 공통코드관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-07
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-09-07 SeongWook Kim
* 1.0 최초 생성
=========================================================*/ 
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.edm.codepublish.event.ComEdm001Event"%>
<%@ page import="com.hanjin.edm.codepublish.event.ComEdm001EventResponse"%>
<%
	ComEdm001Event event = null; //PDTO(Data Transfer Object including Parameters)
	ComEdm001EventResponse eventResponse = null; //RDTO(Data Transfer Object including DB ResultSet)
	Exception serverException = null; //서버에서 발생한 에러
	DBRowSet rowSet = null; //DB ResultSet
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	try {
		event = (ComEdm001Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		} else {
			eventResponse = (ComEdm001EventResponse) request
					.getAttribute("EventResponse");
			if (eventResponse != null) {
				rowSet = eventResponse.getRs();
				if (rowSet != null) {
					rowCount = rowSet.getRowCount();
				} // end if
			} // end if
		} // end else
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>공통코드관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet" />

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
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<form name="form1">
<input type="hidden" name="f_cmd">
<input type="hidden" name="iPage">
<input type="hidden" name="codeid">
<input type="hidden" name="selectedcodes">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<!--Page Title, Historical (E)--> <!-- TABLE '#D' : ( Search Options : Scenario ID ) (S) -->
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- : ( Scenario ID ) (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="70">Subsystem</td>
						<td width="130"><input name="var1" type="text" style="width: 100" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');"></td>
						<td width="90"><select name="searchtype" style="width: 80;">
							<option value="0" selected>Cd ID</option>
							<option value="1">Cd Name</option>
						</select></td>
						<td><input type="text" name="id" style="width: 150" value=""></td>
					</tr>
				</table>
				<!-- : ( Scenario ID ) (E) -->


				<table class="line_bluedot">
					<tr>
						<td colspan="4"></td>
					</tr>
				</table>



				<!-- TABLE '#D' : ( Tab BG Box ) (S) --> <!-- Grid (S) -->
				<table width="100%" id="mainTable">
					<tr>
						<td width="49%">
						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">Enterprise Data Management System</td>
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<!-- : ( Grid ) (S) -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet1');</script></td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->

						<table class="height_10">
							<tr>
								<td></td>
							</tr>
						</table>

						<!-- : ( Grid ) (S) -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet2');</script></td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) --></td>
						<td width="2%" align="center">&nbsp;</td>
						<td width="49%">

						<table class="search" border="0">
							<tr>
								<td class="title_h"></td>
								<td class="title_s">NIS2010</td>
							</tr>
							<tr>
								<td class="height_5"></td>
							</tr>
						</table>
						<!-- : ( Grid ) (S) -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet3');</script></td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) -->

						<table class="height_10">
							<tr>
								<td></td>
							</tr>
						</table>

						<!-- : ( Grid ) (S) -->

						<table width="100%" id="mainTable">
							<tr>
								<td><script language="javascript">ComSheetObject('sheet4');</script></td>
							</tr>
						</table>
						<!-- : ( Grid ) (E) --></td>
					</tr>
				</table>
				<!-- TABLE '#D' : ( Tab BG Box ) (E) --></td>
			</tr>
		</table>

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Save">Save</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		<!--Button (E) --></td>
	</tr>
</table>
<!-- OUTER - POPUP (E)nd --></form>
</body>
</html>