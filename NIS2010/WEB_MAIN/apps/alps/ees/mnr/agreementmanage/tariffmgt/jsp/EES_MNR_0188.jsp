<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0188.jsp
*@FileTitle : MNR Tariff No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.02 김완규
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.event.EesMnr0188Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0188Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String eq_knd_cd		= "";
	String mnr_trf_sts_cd	= "";
	String vndr_seq			= "";
	String mnr_trf_knd_cd 	= "";
	
	strOfc_cd = JSPUtil.getParameter(request, "ofc_cd");
	eq_knd_cd = JSPUtil.getParameter(request, "eq_knd_cd");
	mnr_trf_sts_cd = JSPUtil.getParameter(request, "mnr_trf_sts_cd");
	mnr_trf_knd_cd 	= JSPUtil.getParameter(request, "mnr_trf_knd_cd");
	vndr_seq = JSPUtil.getParameter(request, "vndr_seq");
	
	Logger log = Logger.getLogger("com.hanjin.apps.AgreementManage.TariffMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		if(strOfc_cd.equals("")||strOfc_cd==null) {
			strOfc_cd = account.getOfc_cd();
		}

		event = (EesMnr0188Event)request.getAttribute("Event");
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
<title>M&R Tariff No Inquiry</title>
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="mnr_trf_knd_cd" value="<%=mnr_trf_knd_cd %>">
<input type="hidden" name="eq_knd_cd" value="<%=eq_knd_cd %>">
<input type="hidden" name="mnr_trf_sts_cd" value="<%=mnr_trf_sts_cd %>">
<input type="hidden" name="vndr_seq" value="<%=vndr_seq %>">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">   M&R Tariff No Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 			
			<table class="search"> 
       		<tr><td class="bg">
			
				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:680;"> 
					<tr class="h23">
						<td width="70">Tariff Type</td>
						<td width="140" style="padding-left:2"><script language="javascript">ComComboObject('combo1', 1, 110, 1, 1);</script></td>
						<td width="40">Office</td>
						<td width="80"><input type="text" name="ofc_cd" style="width:50;" value="<%= strOfc_cd%>" class="input2" readonly="readonly"></td>
						<td width="100">Creation Period</td>
						<td width=""><input type="text" name="cre_dt_fr" style="width:75;" class="input1" caption="from date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_to">
						&nbsp;~&nbsp;<input type="text" name="cre_dt_to" style="width:75;" class="input1" caption="to date" requred dataformat="ymd" maxlength="8" cofield="cre_dt_fr">&nbsp;<img src="img/btns_calendar.gif" name="cre_dt_cal" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->	
							
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
	    	
			
<table class="height_5"><tr><td></td></tr></table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="311" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right">
				</tr></table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Ok">OK</td>
					<td class="btn1_right">
				</tr></table></td>
				<td class="btn1_line">
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
</td></tr>
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