<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0081.jsp
*@FileTitle : Loading by POL/POD
*Open Issues : 
*Change history :
*@LastModifyDate : 2010.08.26
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.08.26 김민아
* 1.0 Creation
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
* 2010.12.20 이준범 [CHM-201007668-01] SPC 화면 정렬 수정
* 2011.03.03 이석준 [CHM-201109016-01] BSA Input Button 추가
* 1) 작업 내용
*  - Operator -> Carrier로 변경
*  - Bound Size, Carrier Size : Duration과 동일한 Size로 조정
* 2011.07.05 최윤성 [CHM-201111937-01] Space Utilization 화면 보완
*  - Lane 조회조건 추가 및 Full TEU/Mty TEU 각각의 항목 옆에 Full WGT/Mty WGT 항목 추가
* 2011.09.22 김종준 [CHM-201113515-01] SPC내에서 사용하고 있는 Tag Library 제거 작업
* 2015.02.24 김승만 [CHM-201533936] 사용자 표준환경 관련 개선
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event.EsmSpc0081Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmSpc0081Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	
		event = (EsmSpc0081Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		//out.println(e.toString());
		out.println("<!--"+e.toString()+"-->");
	}
	
%>
<html>
<head>
<title>RDR Detail Data</title>
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
<!-- 단축키 설정을 위한 변수 -->
<input type="hidden" name="uiname" value="ESM_SPC_0081">

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
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</td><td class="btn1_right"></td></tr></table></td>
								<td class="btn1_line"></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_bsa" id="btn_bsa" alt="Alt+B">BSA&nbsp;Input</td><td class="btn1_right"></td></tr></table></td>									
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
						<td width="140"><img class="nostar">Start Week</td>
						<td width="200">
							<select class="input1" name="year" style="width:60;" onchange="checkWeek();"></select>
							<select class="input1" name="week" style="width:40;"></select>
						</td>
						<td width="70"><img class="nostar">Duration</td>
						<td width="170">
								<select class="input1" name="duration" size="1">
						</td>
						<td width="50"><img class="nostar">Trade</td>
						<td width="190" style="padding-left:2px;">
							<script language="JavaScript">ComComboObject("trade", 2, 60, 0, 1);</script>
						</td>
						<td width="130"><img class="nostar">Sub Trade</td>
						<td width="140" style="padding-left:3">
							<script language="JavaScript">ComComboObject("subtrade", 3, 60, 0, 0);</script>
						</td>
						<td width="40"><img class="nostar">Lane</td>
						<td width="160" style="padding-left:2">
							<script language="JavaScript">ComComboObject("rlane_cd", 4, 70, 0, 0);</script>
						</td>
					</tr>
					<tr class="h23">
						<td width="85"><img class="nostar">RHQ</td>
						<td width="200">
							<select class="input1" name="rhq">
								<option value=""></option>
								<option value="A">SHARC, SINRS</option>
								<option value="M">NYCRA</option>
								<option value="E">HAMRU</option>
								<option value="F">AFRICA</option>
								<option value="O">OTHER</option>
							</select>
						</td>
						<td width="60"><img class="nostar">Bound</td>
						<td>
							<select name="bound" style="width:41;"></select>
						</td>
						<td width="70"><img class="nostar">Carrier</td>
						<td colspan="3" style="padding-left:2"><script language="javascript">ComComboObject('operator',1,60,0);</script></td>
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

			<table width="100%" class="search"><tr><td class="gray">Unit : TEU</td></tr></table>
			<!-- : ( grid ) (S) -->
			<table  border="0" class="search">
				<tr><td>
					<table width="100%" id="mainTable">
						<tr><td>
							 <script language="javascript">ComSheetObject('sheet1');</script>
						</td></tr>
					</table>
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
