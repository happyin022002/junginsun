<%
/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_SPC_0093.jsp
*@FileTitle : Report by Loading
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.17
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.01.17 진마리아
* 1.0 Creation
* 2013.01.17 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0093Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0093Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ModelManage.ModelManage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0093Event)request.getAttribute("Event");
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
<title>Report by Loading</title>
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
<form name="form" onsubmit="return false;" onKeyDown="enter();">
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
						<td width="80"><img class="nostar">Trade</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("trade", 2, 105, 0, 1);</script>
						</td>
						<td width="80"><img class="nostar">Season</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("season", 2, 105, 0, 1);</script>
						</td>
						<td width="80"><img class="nostar">Version</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("version", 3, 105, 0, 1);</script>
						</td>
						<td width="75"><img class="nostar">Status</td>
						<td width="170">
							<input type="text" id="sts" name="sts" value="" style="font-Weight:Bold" disabled></input>
						</td>
						<td width="*">&nbsp;</td>
					</tr>
					<tr class="h23">
						<td width="80"><img class="nostar">Sub Trade</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("subtrade", 3, 50, 0, 0);</script>
						</td>
						<td width="80"><img class="nostar">Lane</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("lane", 4, 82, 0, 0);</script>
						</td>
						<td width="80"><img class="nostar">RHQ</td>
						<td width="130" style="padding-left:2" >
							<script language="JavaScript">ComComboObject("rhq", 2, 105, 0, 0);</script>
						</td>
					</tr>
				</table>
				<!-- : ( Year ) (E) -->
				
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		
		<table class="height_10"><tr><td></td></tr></table>
		
		<!-- TABLE '#D' : ( Tab ) (S) -->
     	<table class="tab">
       		<tr><td><script language="javascript">ComTabObject('tab1')</script></td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab ) (E) -->
		<!-- ******************************************* -->
		<!-- (1) -->
		<!-- ******************************************* -->
        <div id="tabLayer" style="display:inline">
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">
		
				<table width="100%" border="0">
					<tr>
						<td align="right" id="sheetControlDiv">
							<img name="maxi" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet1" type="N" onclick="toggleSheetSize();">
						</td>
					</tr>
				</table>
				
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="70"><img class="nostar">Guide/QTA</td>
						<td width="200">
							<input type="radio" class="trans" name="gq_view" value="B" checked> Both
							<input type="radio" class="trans" name="gq_view" value="G"> Guide only
						</td>
						<td width="30">
							<input type="checkbox" class="trans" name="acct_all">
						</td>
						<td width="100">Account Expand</td>
						<td width="400"></td>
					</tr>
				</table>
				
				<!-- : ( SHEET ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td></tr>
				</table>
				<!-- : ( SHEET ) (E) -->
				
		</td></tr>
	</table>
	</div>
	
	<div id="tabLayer" style="display:none">
		
		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search">
		<tr><td class="bg">
		
				<table width="100%" border="0">
					<tr>
						<td align="right" id="sheetControlDiv">
							<img name="maxi2" class="cursor" src="/hanjin/img/bu_next01.gif" sheetId="sheet2" type="N" onclick="toggleSheetSize();">
						</td>
					</tr>
				</table>
				
				<table class="search_in" border="0">
					<tr class="h23">
						<td width="30">
							<input type="checkbox" class="trans" name="acct_all_2">
						</td>
						<td width="100">Account Expand</td>
						<td width="670"></td>
					</tr>
				</table>
				
				<!-- : ( SHEET ) (S) -->
				<table width="100%" id="mainTable">
					<tr><td>
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td></tr>
				</table>
				<!-- : ( SHEET ) (E) -->
				
		</td></tr>
	</table>
	</div>
	<!-- TABLE '#D' : ( Search Options ) (E) -->

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>