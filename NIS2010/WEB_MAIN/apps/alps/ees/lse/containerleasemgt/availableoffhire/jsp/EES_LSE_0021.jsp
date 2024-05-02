<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0021.jsp
*@FileTitle : Off-Hire CNTR List - Send to Lessor
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.05
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.05 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0021Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_eml		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.availableoffhire");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_eml = account.getUsr_eml();

		event = (EesLse0021Event)request.getAttribute("Event");
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
<title>Off-Hire CNTR List - Send to Lessor</title>
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

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="backendjob_key">
<input type="hidden" name="loc_case" value="<%= JSPUtil.getParameter(request,"h_loc_case") %>">
<input type="hidden" name="loc_tp" value="<%= JSPUtil.getParameter(request,"h_loc_tp") %>">
<input type="hidden" name="loc_cd" value="<%= JSPUtil.getParameter(request,"h_loc_cd") %>">
<input type="hidden" name="port_cd" value="<%= JSPUtil.getParameter(request,"h_port_cd") %>">
<input type="hidden" name="slan_cd" value="<%= JSPUtil.getParameter(request,"h_slan_cd") %>">
<input type="hidden" name="del_cd" value="<%= JSPUtil.getParameter(request,"h_del_cd") %>">
<input type="hidden" name="vvd_cd" value="<%= JSPUtil.getParameter(request,"h_vvd_cd") %>">
<input type="hidden" name="estm_tp" value="<%= JSPUtil.getParameter(request,"h_estm_tp") %>">
<input type="hidden" name="str_estm_dt" value="<%= JSPUtil.getParameter(request,"h_str_estm_dt") %>">
<input type="hidden" name="end_estm_dt" value="<%= JSPUtil.getParameter(request,"h_end_estm_dt") %>">
<input type="hidden" name="lstm_cd" value="<%= JSPUtil.getParameter(request,"h_lstm_cd") %>">
<input type="hidden" name="cntr_tpsz_cd" value="<%= JSPUtil.getParameter(request,"h_cntr_tpsz_cd") %>">
<input type="hidden" name="cnmv_sts_cd" value="<%= JSPUtil.getParameter(request,"h_cnmv_sts_cd") %>">
<input type="hidden" name="agmt_cty_cd" value="<%= JSPUtil.getParameter(request,"h_agmt_cty_cd") %>">
<input type="hidden" name="agmt_seq" value="<%= JSPUtil.getParameter(request,"h_agmt_seq") %>">
<input type="hidden" name="vndr_seq" value="<%= JSPUtil.getParameter(request,"h_vndr_seq") %>">
<input type="hidden" name="used_dys" value="<%= JSPUtil.getParameter(request,"h_used_dys") %>">
<input type="hidden" name="free_dys" value="<%= JSPUtil.getParameter(request,"h_free_dys") %>">
<input type="hidden" name="min_onh_dys_tp" value="<%= JSPUtil.getParameter(request,"h_min_onh_dys_tp") %>">
<input type="hidden" name="curr_dt" value="<%= JSPUtil.getParameter(request,"h_curr_dt") %>">
<input type="hidden" name="complex_pk" value="<%= JSPUtil.getParameter(request,"complex_pk") %>">
<input type="hidden" name="complex_pk2" value="<%= JSPUtil.getParameter(request,"complex_pk2") %>">
<input type="hidden" name="complex_pk3" value="<%= JSPUtil.getParameter(request,"complex_pk3") %>">
<input type="hidden" name="complex_pk4" value="<%= JSPUtil.getParameter(request,"complex_pk4") %>">
<input type="hidden" name="complex_pk5" value="<%= JSPUtil.getParameter(request,"complex_pk5") %>">
<input type="hidden" name="complex_pk6" value="<%= JSPUtil.getParameter(request,"complex_pk6") %>">
<input type="hidden" name="complex_pk7" value="<%= JSPUtil.getParameter(request,"complex_pk7") %>">
<input type="hidden" name="complex_pk8" value="<%= JSPUtil.getParameter(request,"complex_pk8") %>">
<input type="hidden" name="complex_pk9" value="<%= JSPUtil.getParameter(request,"complex_pk9") %>">
<input type="hidden" name="complex_pk10" value="<%= JSPUtil.getParameter(request,"complex_pk10") %>">
<input type="hidden" name="complex_pk11" value="<%= JSPUtil.getParameter(request,"complex_pk11") %>">
<input type="hidden" name="complex_pk12" value="<%= JSPUtil.getParameter(request,"complex_pk12") %>">
<input type="hidden" name="complex_pk13" value="<%= JSPUtil.getParameter(request,"complex_pk13") %>">
<input type="hidden" name="complex_pk14" value="<%= JSPUtil.getParameter(request,"complex_pk14") %>">
<input type="hidden" name="complex_pk15" value="<%= JSPUtil.getParameter(request,"complex_pk15") %>">
<input type="hidden" name="complex_pk16" value="<%= JSPUtil.getParameter(request,"complex_pk16") %>">
<input type="hidden" name="complex_pk17" value="<%= JSPUtil.getParameter(request,"complex_pk17") %>">
<input type="hidden" name="complex_pk18" value="<%= JSPUtil.getParameter(request,"complex_pk18") %>">
<input type="hidden" name="complex_pk19" value="<%= JSPUtil.getParameter(request,"complex_pk19") %>">
<input type="hidden" name="from" value="<%= strUsr_eml %>">
<input type="hidden" name="recipient" value="<%= strUsr_eml %>">
<input type="hidden" name="carbonCopy" value="">
<input type="hidden" name="blindCarbonCopy" value="<%= strUsr_eml %>">
<input type="hidden" name="subject" value="Available Off Hire Quantity (Detail Inquiry) List <%= JSPUtil.getParameter(request,"h_curr_dt") %>">
<input type="hidden" name="fileKey" value="">
<input type="hidden" name="template" value="EES_LSE_0020_01T.html">
<input type="hidden" name="argument">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">
	<!--top menu (S)-->

		<!--top menu (E)-->
	</td></tr>


	<tr><td valign="top">

	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Available Off Hire Quantity (Detail inquiry) List
		</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

	<table class="search">
     	<tr><td class="bg">

		<!-- Grid  (S) -->
		<table width="100%" class="search"  id="mainTable">
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid  (E) -->
		<!--  Button_Sub (S) -->
		<table width="100%" class="button">
       	<tr><td class="btn2_bg">
			<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
				</tr></table>
		</td></tr>
		</table>
    	<!-- Button_Sub (E) -->

		</td></tr>
	</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr></table>



	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_email">E-Mail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save W/O  E-Mail  Sending
</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
					</tr>
				</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>
</td></tr>
</table>
</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp" %>
