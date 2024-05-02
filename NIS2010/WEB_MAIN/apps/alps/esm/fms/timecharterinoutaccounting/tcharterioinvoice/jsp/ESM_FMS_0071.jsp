<%
/*=========================================================
* Copyright(c) 2009 CyberLogitec
* @FileName : ESM_FMS_0071.jsp
* @FileTitle : Bunker Price Selection
* Open Issues :
* Change history :
* @LastModifyDate : 2009.08.08
* @LastModifier : 정윤태
* @LastVersion : 1.0
* 2009.08.08 정윤태
* 1.0 최초 생성
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0071Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0071Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id = "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOInvoice");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	   	strUsr_id = account.getUsr_id();
	   	
	   	event = (EsmFms0071Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.getMessage(),e);
	}
	
	String fromDt = JSPUtil.replaceForHTML(request.getParameter("from_dt"));
	String toDt = JSPUtil.replaceForHTML(request.getParameter("to_dt"));
%>

<html>
<head>
<title>Bunker Price Selection</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">
    function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>


<body class="popup_bg" onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">

<!-- OUTER - POPUP (S)tart -->
<table width="500" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Bunker Price Selection </td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

			<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->

				<table class="search" border="0" style="width:484;">
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Location</td>
					<td width="374"><input type="text" name="loc_cd" style="width:52;text-align:center;ime-mode:disabled" class="input1" maxlength="5" required fullfill caption="Location">&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_locPop">&nbsp;<input type="text" name="loc_nm" style="width:135;" class="input2" readonly></td>
				</tr>
				<tr class="h23">
					<td width="70">&nbsp;&nbsp;Duration</td>
					<td width="374"><input type="text" style="width:75;text-align:center;" class="input1" name="from_dt" maxlength="8" dataformat="ymd" value="<%=fromDt%>" required fullfill caption="Duration From Dt">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="cal_from_dt">&nbsp;~&nbsp;<input type="text" style="width:75;text-align:center;" class="input1" name="to_dt" maxlength="8" dataformat="ymd" value="<%=toDt%>" required fullfill caption="Duration To Dt">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="cal_to_dt"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:484;">
				<tr class="h23">
					<td align="right"><table border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn2_left"></td>
								<td class="btn2" name="btn_execute">Retrieve</td>
								<td class="btn2_right"></td></tr></table></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- : ( Grid ) (E) -->
		    <!-- : ( Button : Grid ) (E) -->

			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
	<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table>


<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right">
				</tr></table></td></td>
				</tr>
        </table></td>
			</tr>
		</table>
    <!--Button (E) -->

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>
<%@include file="/bizcommon/include/common_alps.jsp"%>