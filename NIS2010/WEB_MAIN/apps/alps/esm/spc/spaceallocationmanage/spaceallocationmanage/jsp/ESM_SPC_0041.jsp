<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0041.jsp
*@FileTitle : Space-Reallocation Model Run 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 서관영
*@LastVersion : 1.0
* 2009.11.24 서관영
* 1.0 Creation
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event.EsmSpc0041Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0041Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.SpaceAllocationManage.SpaceAllocationManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0041Event)request.getAttribute("Event");
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
<title>Space-Reallocation Model Run </title>
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
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>

							<td class="btn1_line"></td>

							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
							<!-- Repeat Pattern -->

						</tr></table>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->

	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
						<td  width="80"><img class="nostar">Period</td>
						<td colspan="9" style="padding-left:2"><select class="input1" name="year1" style="width:60;"></select>
							<select class="input1" name="week1" style="width:40;"></select>&nbsp;~&nbsp;
							<select class="input1" name="year2" style="width:60;"></select>
							<select class="input1" name="week2" style="width:40;"></select>
						</td>
				<tr class="h23">
					<td width="80"><img class="nostar">Rep. Trade</td>
					<td width="160">&nbsp;
						<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 0);</script>
					</td>
					<td width="50">Bound</td>
					<td width="160"><select name="bound" style="width:80;"></select></td>
					<td width="70">Sub Trade</td>
					<td width="160">
						<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
					</td>
					<td width="40">Lane</td>
					<td width="150">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 0);</script>
					</td>
					<td width="45">Origin</td>
					<td><input type="text" size="5" value="<%=event.getSignOnUserAccount().getOfc_cd() %>" name="office"></td>
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

					<table width="100%" id="sheetControlDiv" style="">
                        <tr><td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();"></td></tr>
		            </table>

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						 <script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
			</td>
		</tr>
		</table>

		<table class="search" style="display:none;">
		<tr><td class="button">

				<!-- : ( POR ) (S) -->
				<table width="100%">
					<tr><td align="right">interval time <input name="intervalTime" size="2" value="10" style="text-align:right;" onchange="intervalTime_OnChange();"> sec
					</td></tr>
				</table>
			</td>
		</tr>
		</table>

		<table class="search" style="display:none;">
		<tr><td class="bg_b1">

					<table width="100%" id="sheetControlDiv" style="">
                        <tr><td align="right"><img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="engineLogDiv" type="N" onclick="toggleSheetSize();"></td></tr>
		            </table>

				<!-- : ( POR ) (S) -->
				<div width="100%" id="engineLogDiv" style="height:110;overflow:auto;" id="engineLogDiv">
					 <table border="0" cellspacing="3" id="engineLog" width="100%">
					 <col valign="top" width="120">
					 <col valign="top">
				 </table>
				</div>
				<table width="100%" style="display:none;">
					<tr><td>
						 <script language="javascript">ComSheetObject('sheet2');</script>
					</td></tr>
				</table>
			</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>