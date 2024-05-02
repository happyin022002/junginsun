<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0103.jsp
*@FileTitle : dailyforecastmanage
*Open Issues :
*Change history :
	* 2007-12-14 김원섭
	* 1.0 최초 생성
*@LastModifyDate : 2009.08.21
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.21 한상훈
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
<%@ page import="com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event.EsmSpc0103Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	String srep_id = JSPUtil.getParameter(request, "srep_id", "");
	String srep_nm = JSPUtil.getParameter(request, "srep_nm", "");
	String rlane_cd = JSPUtil.getParameter(request, "rlane_cd", "");
	String trd_cd = JSPUtil.getParameter(request, "trd_cd", "");
	String sub_trd_cd = JSPUtil.getParameter(request, "sub_trd_cd", "");
	String bound = JSPUtil.getParameter(request, "bound", "");
	String rgn_ofc_cd = JSPUtil.getParameter(request, "rgn_ofc_cd", "");
	String sub_ofc_cd = JSPUtil.getParameter(request, "sub_ofc_cd", "");
	String ioc_cd = JSPUtil.getParameter(request, "ioc_cd", "");
	String acc_tp = JSPUtil.getParameter(request, "acc_tp", "");
	boolean isChild = !(srep_id + rlane_cd + trd_cd + sub_trd_cd + bound + rgn_ofc_cd + sub_ofc_cd + ioc_cd + acc_tp).equals("");


	EsmSpc0103Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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


		event = (EsmSpc0103Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
	
	String ofc_cd	 = event.getSignOnUserAccount().getOfc_cd();
	String ofc_tp_cd = "";
	
	if (serverException == null) {
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		ofc_tp_cd = eventResponse.getETCData("ofc_tp_cd");
	}
%>

<html>
<head>
<title>Account Registration</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var ofc_cd = "<%=ofc_cd%>";
	var ofc_tp_cd = "<%=ofc_tp_cd%>";
	var srep_id = "<%=srep_id%>";
	var srep_nm = "<%=srep_nm%>";
	var rlane_cd = "<%=rlane_cd%>";
	var trd_cd = "<%=trd_cd%>";
	var sub_trd_cd = "<%=sub_trd_cd%>";
	var bound = "<%=bound%>";
	var rgn_ofc_cd = "<%=rgn_ofc_cd%>";
	var sub_ofc_cd = "<%=sub_ofc_cd%>";
	var ioc_cd = "<%=ioc_cd%>";
	var is_child = "<%=isChild%>";

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
		<% if(isChild){ %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif"  align="absmiddle"> Sales Management > Space Control > Daily Forecast > Account Registration</td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" > Account Registration </td></tr>
			</table>
		<% } else { %>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<% } %>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
					<tr><td class="btn1_bg">

							<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td id="td_retrieve" style="display:<%=isChild?"none":"inline"%>"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve" alt="Alt+R">Retrieve</td><td class="btn1_right"></td></tr></table></td>
								<td id="td_new" style="display:<%=isChild?"none":"inline"%>"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new" alt="Alt+N">New</td><td class="btn1_right"></td></tr></table></td>

								<td id="td_line" style="display:<%=isChild?"none":"inline"%>" class="btn1_line"></td>

								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_save" id="btn_save" alt="Alt+S">Save</td><td class="btn1_right"></td></tr></table></td>


								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
									<tr><td class="btn1_left"></td><td class="btn1" name="btn_rowadd" id="btn_rowadd">Row Add</td><td class="btn1_right"></td></tr></table></td>
								<!-- Repeat Pattern -->

							</tr></table>

					</td></tr>
				</table>
    	<!-- TABLE '#D' : ( Button : Main ) (E) -->
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" id="searchCondition" style="display:none;">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table class="search_in" border="0">
				<tr class="h23">
					<td width="85"><img class="nostar">Salse Office</td>
					<td width="220" style="padding-left:3;"><script language="JavaScript">ComComboObject("rgnOffice", 2, 106, 0, 1);initData_rgnOffice();</script></td>

					<td width="80"><img class="nostar">Sub-Office</td>
					<td width="200" style="padding-left:3;"><script language="JavaScript">ComComboObject("subOffice", 2, 80, 0, 1);</script></td>

					<td width="75"><img class="nostar">Sales Rep</td>
					<td width="190"><script language="JavaScript">ComComboObject("salesRep", 4, 70, 0, 1);</script></td>

					<td width="55"><img class="nostar">IOC</td>
					<td width=""><select name="ioc" class="input1"><option value=""></option><option value="O">OCN</option><option value="I">IPC</option><option value="T">TS</option></select></td>
				</tr>
				<tr class="h23">
					<td width="85"><img class="nostar">Trade</td>
					<td width="220" style="padding-left:3">
						<script language="JavaScript">ComComboObject("trade", 2, 106, 0, 1);</script>
					</td>

					<td width="80"><img class="nostar">Sub Trade</td>
					<td width="200" style="padding-left:3">
						<script language="JavaScript">ComComboObject("subTrade", 3, 80, 0, 1);</script>
					</td>

					<td width="75"><img class="nostar">Lane</td>
					<td width="190">
						<script language="JavaScript">ComComboObject("lane", 4, 70, 0, 1);</script>
					</td>

					<td width="55"><img class="nostar">Bound</td>
					<td width="">
						<select name="bound" style="width:55;" class="input1"></select>
					</td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
	 	<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search" id="searchInformation" style="display:none;">
       	<tr><td class="bg">

				<!-- : ( Year ) (S) -->
				<table border="0">
				<tr class="h23">
					<td>Sales Rep</td>
					<td> : </td>
					<td style="font-weight:100;"><span id="search_srep_nm"></span>&nbsp;[<span id="search_srep_id"></span>]</td>
				</tr>
				<tr class="h23">
					<td>Lane</td>
					<td> : </td>
					<td style="font-weight:100;"><span id="search_trd_cd"></span>&nbsp;/&nbsp;<span id="search_sub_trd_cd"></span>&nbsp;/&nbsp;<span id="search_rlane_cd"></span>&nbsp;/&nbsp;<span id="search_bound"></span>&nbsp;/&nbsp;<span id="search_ioc_cd"></span></td>
					<td width="30"></td>
				</tr>
				</table>
				<!-- : ( Year ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->
		<table class="height_10"><tr><td></td></tr></table>

		<!-- UI_ESM_SPC_028 : THIS IS 1st TAB -->
<div id="tabLayer" style="display:">

		<!-- TABLE '#D' : ( Search Options ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="height_5">
				<tr class="h23">
					<td width="90">Account Type</td>
					<td width=""><select name="accountType" id="selAccountType" onchange="changeAccountType();"><option value="C">Contractor</option><option value="S">Shipper</option></select></td>
				</tr>
				</table>

				<!-- : ( POR ) (S) -->

					<table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet1');</script>
                        </td></tr>
		            </table>
				<!-- : ( POR ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

</div>

</td></tr>

<%
if(isChild){
%>
<tr><td class="bgdybottom_copy">

	<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
	<tr><td height="71" class="popup">
			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
				<tr><td class="btn3_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<!-- Repeat Pattern -->
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_ok" id="btn_ok">Account Reload</td><td class="btn1_right"></td></tr>
								</table></td>
								<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr>
								</table></td>
								<!-- Repeat Pattern -->
							</tr>
						</table>
				</td></tr>
			</table>
	</td></tr>
</table>

</td></tr>
<%
}
%>

</table>
<!-- Outer Table (E)-->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>