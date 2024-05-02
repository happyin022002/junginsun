<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0423.jsp
*@FileTitle : Restuffing Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.27 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.restuffingmgt.restuffingcontainerregistration.event.EesCtm0423Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0423Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_ofc = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);

		strUsr_ofc = account.getOfc_cd();
		event = (EesCtm0423Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
	  // 현재날짜
	  String strEnddate = DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd");
	  // 6개월 이전날짜
	  String strStartdate = DateTime.addMonths(strEnddate, -6, "yyyy-MM-dd");

%>
<html>
<head>
<title>Restuffing Inquiry</title>
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

      <!-- Page Title, Historical (S) -->
      <table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
        <tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
      </table>
      <!-- Page Title, Historical (E) -->


	<!--biz page (S)-->
		<table class="search">
       	<tr><td class="bg" style="height:516" valign="top">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="40">Office</td>
					<!--  <td width="70"><input type="text" style="width:50;ime-mode:disabled;" tabindex="1" class="input1" maxlength="5" value="<%=strUsr_ofc%>" name="p_office"></td> -->
					<!-- Office Code는 필수 입력에서 선택입력으로 변경  -->
					<td width="70"><input type="text" style="width:50;ime-mode:disabled;" tabindex="1" class="input" maxlength="5" value="<%=strUsr_ofc%>" name="p_office"></td>
					<td width="30"> Yard</td>
					<td width="60" style="padding-top:1"><input type="text" style="width:55;text-align:center;ime-mode:disabled;" tabindex="2" class="input" maxlength="5" name="p_yard1"></td>
					<td width="70"><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 3)</script></td>
					<td width="60">Duration</td>
					<td width="250"><input type="text" style="width:80;ime-mode:disabled;" tabindex="4" class="input1" value="<%=strStartdate%>" name="p_date1">&nbsp;~&nbsp;
									<input type="text" style="width:80;ime-mode:disabled;" tabindex="5" class="input1" value="<%=strEnddate%>" name="p_date2">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar2"></td>
					<td width="90">Container No.</td>
					<td width="130"><input type="text" style="width:80; ime-mode:disabled;" class="input" maxlength="10" tabindex="6" name="cntrno_disp">
						<input type="hidden" name="p_cntrno">
						<input type="text" style="width:17;" class="input" readonly name="check_digit"></td>
					<td width="50">Reason</td>
					<td style="padding-bottom:1,padding-top:1"><input type="text" style="width:60;display:none;" class="input" name="p_reson" readonly>
						<span id='m_combo' style="display:"><script language="javascript">ComComboObject('p_reson_op', 2, 60 , 0, '', 2, 0, 7)</script></span></td>
				</tr>
				</table>

				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>


				<!--  biz_2  (S) -->

				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<!--  biz_2   (E) -->
				</td></tr>
			</table>

	<!--biz page (E)-->


	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>

				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>

				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->
</td></tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>