<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_ctm_0412.jsp
*@FileTitle : BKG container update Irr.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.29
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.04.29 우경민
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
<%@ page import="com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event.EesCtm0412Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCtm0412Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	String strUsr_ofc = null;
	try {

		event = (EesCtm0412Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_ofc = account.getOfc_cd();
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
<title>BKG container update Irr.</title>
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
					<td width="30">LCC</td>
					<td width="90"><input type="text" style="width:50;ime-mode:disabled;" class="input1" maxlength="5" name="p_office" tabindex="1"></td>
					<td width="30">Yard</td>
					<td width="60" style="padding-top:1;"><input type="text" style="width:55;text-align:center;ime-mode:disabled;" class="input" maxlength="5" name="p_yard1" tabindex="2"></td>
					<td width="70"><script language="javascript">ComComboObject('p_yard2', 2, 50 , 0, '', 2, 0, 3)</script></td>
					<td width="55">Duration</td>
					<td width="250"><input type="text" style="width:75;ime-mode:disabled;" class="input1" maxlength="8" value="<%=strStartdate%>"  tabindex="4" name="p_date1">&nbsp;~&nbsp;
									<input type="text" style="width:75;ime-mode:disabled;" class="input1" maxlength="8" value="<%=strEnddate%>" tabindex="5" name="p_date2">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_Calendar2"></td>
					<td width="55">Irr. Type</td>
					<td width="100">&nbsp;<select style="width:70;ime-mode:disabled;" class="input" name="p_irrtype" disabled>
						<option value="">All</option>
						<option value="A" selected>Attach </option>
						<option value="C">Detach </option>
						</select></td>
					<td width="50">Settled</td>
					<td>&nbsp;<select style="width:40;ime-mode:disabled;" class="input" tabindex="6" name="p_settled">
						<option value="" >All</option>
						<option value="N" selected> N</option>
						<option value="Y"> Y</option>
						</select></td>
				</tr>
				</table>
				<table class="height_8"><tr><td colspan="8"></td></tr></table>

				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->
				<!--  biz_3  (E) -->
				</td></tr>
			</table>
	<!--biz page (E)-->
	</td></tr>
	</table>

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>