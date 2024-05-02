<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0247.jsp
*@FileTitle : Disposal Equipment Detail list(Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.23
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.11.23 장준우
* 1.0 Creation
*=======================================================
* 2010.12.06 남궁진호 [CHM-201007441-01]Disposal Result Equipment list 팝업 신규개발  
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0247Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0247Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesMnr0247Event)request.getAttribute("Event");
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
<title>Disposal Equipment Detail list</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="p_curr_cd" value="<%= JSPUtil.getParameter(request, "h_curr_cd") %>">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td class="top"></td></tr>
	<tr><td valign="top">

<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Disposal Result Equipment list</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz  (S) -->
				<table class="search" border="0" style="width:100%;">
				<tr class="h23">
					<td width="90">Sold Period</td>
					<td width="200">
						<input type="text" name="p_str_evnt_dt" caption="Start Duration" style="width:70;text-align:center;" class="input2" value="<%= JSPUtil.getParameter(request, "h_str_evnt_dt") %>" readOnly="true">&nbsp;~
						<input type="text" name="p_end_evnt_dt" caption="End Duration" style="width:70;text-align:center;" class="input2" value="<%= JSPUtil.getParameter(request, "h_end_evnt_dt") %>" readOnly="true">
					</td>
					<td width="95">EQ Type/Size</td>
					<td width="160">
						<input type="text" name="t_eq_knd_nm" style="width:80" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_eq_knd_nm") %>">
						<input type="text" name="p_eq_tpsz_cd" style="width:30;text-align:center;" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_eq_tpsz_cd") %>">
						<input type="hidden" name="p_eq_knd_cd" value="<%= JSPUtil.getParameter(request, "h_eq_knd_cd") %>">
					</td>
					<td width="70">Office By</td>
					<td width="200">
						<input type="text" name="p_rhq_cd" style="width:65;text-align:center" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_rhq_cd") %>">
						<input type="text" name="p_ofc_cd" style="width:70;text-align:center" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_ofc_cd") %>">
					</td>
					<td style="text-align:right"><input type="checkbox" name="p_chk_usd" class="trans">USD Only&nbsp;&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="90">Disposal Kind</td>
					<td width="200">
						<input type="text" name="t_disp_rsn_cd" style="width:158" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_disp_rsn_nm") %>">
						<input type="hidden" name="p_disp_rsn_cd" value="<%= JSPUtil.getParameter(request, "h_disp_rsn_cd") %>">
					</td>
					<td width="95">Disposal Type</td>
					<td width="160">
						<input type="text" name="t_disp_tp_nm" style="width:114" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_disp_tp_nm") %>">
						<input type="hidden" name="p_disp_tp_cd" value="<%= JSPUtil.getParameter(request, "h_disp_tp_cd") %>">
					</td>
					<td width="70">Buyer By</td>
					<td colspan="2">
						<input type="text" name="p_cust_cd" caption="Buyer" style="width:65;text-align:center" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_cust_cd") %>" class="input2">
						<input type="text" name="p_vndr_nm" style="width:220" class="input2" readOnly="true" value="<%= JSPUtil.getParameter(request, "h_vndr_nm") %>">
					</td>
				</tr>
				</table>
				<!--  biz   (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!--  biz_1   (E) -->

				<!-- Grid  (S) -->
					<table width="100%"  id="sheetTable">
						<tr>
							<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script></td>
						</tr>
					</table>
				<!-- Grid (E) -->

				<table width="100%" class="button">
		       	<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0">
					<tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						</tr></table>
				</td></tr>
				</table>

			</td></tr>
		</table>
		<!--biz page (E)-->

		<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr>
			<td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Close">Close</td>
						<td class="btn1_right">
					</tr></table></td>
				</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
