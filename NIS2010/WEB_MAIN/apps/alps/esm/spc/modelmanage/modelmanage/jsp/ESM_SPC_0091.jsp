<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0091.jsp
*@FileTitle : SMP History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.25 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.spc.modelmanage.modelmanage.event.EsmSpc0091Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	
	EsmSpc0091Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.DailyForecast.Dailyforecastmanage");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmSpc0091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	String rhq_cd    = "";
	String rgn_cd    = "";
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		rhq_cd    = eventResponse.getETCData("rhq_cd");
		rgn_cd    = eventResponse.getETCData("rgn_ofc_cd");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
	}
%>

<html>
<head>
<title>SMP History</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	
	var ofc_cd = "<%=ofc_cd%>";
	var ofc_tp_cd = "<%=ofc_tp_cd%>";
	
	function setupPage(){
		loadPage();
	}
	
	
</script>
</head>

<body  onLoad="javascript:setupPage()">
<form name="form" onsubmit="return false;" onKeyDown="enter();">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="login_rhq_cd" value="<%=rhq_cd%>">
<input type="hidden" name="login_rgn_cd" value="<%=rgn_cd%>">
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
					<td width="85"><img class="nostar">Trade</td>
					<td width="190" style="padding-left:2">
						<script language="JavaScript">ComComboObject("trade", 2, 104, 0, 1);</script>
					</td>
					<td width="80"><img class="nostar">Season</td>
					<td width="150" style="padding-left:2" >
						<script language="JavaScript">ComComboObject("season", 2, 105, 0, 1);</script>
					</td>
					<td width="80"><img class="nostar">Version</td>
					<td width="180" style="padding-left:2" >
						<script language="JavaScript">ComComboObject("version", 3, 105, 0, 0);</script>
					</td>
					<td width="75"><img class="nostar">Sub Trade</td>
					<td width="170" style="padding-left:2">
						<script language="JavaScript">ComComboObject("subtrade", 3, 80, 0, 0);</script>
					</td>
					<td width="75"><img class="nostar">Lane</td>
					<td width="170">
						<script language="JavaScript">ComComboObject("lane", 4, 80, 0, 0);</script>
					</td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">RHQ</td>
					<td width="190" style="padding-left:2;"><script language="JavaScript">ComComboObject("rhq", 2, 80, 0, 0);</script></td>
					<td width="85"><img class="nostar">L.Office</td>
					<td width="190" style="padding-left:2;"><script language="JavaScript">ComComboObject("office", 2, 104, 0, 0);</script></td>
					<td width="120"><img class="nostar">Grp. Acct</td>
					<td width="150" style="padding-left:2">
						<script language="JavaScript">ComComboObject("grp_acct", 4, 105, 0, 0);</script>
					</td>
					<td width="140"><img class="nostar">Indv. Acct</td>
					<td width="150" style="padding-left:2">
						<script language="JavaScript">ComComboObject("acct_cd", 4, 105, 0, 0);</script>
					</td>

				  </tr>

				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- TABLE '#D' : ( Tab ) (S) -->
		<table class="tab" >
           	<tr><td><script language="javascript">ComTabObject('tab1')</script>
		</table>

		<!-- UI_ESM_SPC_091 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:inline">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">
				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('t1sheet1');</script>
                       </td></tr>
	            </table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

<!-- UI_ESM_SPC_091_T2 : THIS IS 2st TAB -->
<div id="tabLayer" style="display:none">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<!-- : ( POR ) (S) -->
				<table width="100%" id="mainTable">
                       <tr><td>
                            <script language="javascript">ComSheetObject('t1sheet2');</script>
                       </td></tr>
	            </table>
				<!-- : ( POR ) (E) -->

			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

</td></tr>
</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>