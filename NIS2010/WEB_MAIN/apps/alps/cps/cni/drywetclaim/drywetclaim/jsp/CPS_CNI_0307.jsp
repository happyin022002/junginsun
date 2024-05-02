<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CPS_CNI_0307.jsp
*@FileTitle : R.O.E. (Rate of Exchange) Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.28
*@LastModifier : 윤세영
*@LastVersion : 1.0
* 2009.10.28 윤세영
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
<%@ page import="com.hanjin.apps.alps.cps.cni.drywetclaim.drywetclaim.event.CpsCni0307Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CpsCni0307Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutAccounting.TCharterIOBasicRegister");

    String currCd = JSPUtil.getNull(request.getParameter("curr_cd"));
    String yrMon = JSPUtil.getNull(request.getParameter("yr_mon"));

    if (yrMon.equals("")) {
		yrMon = DateTime.getDateString().substring(0,4)+"-"+DateTime.getDateString().substring(5,7);
    } else if (yrMon.length() > 5) {
    	yrMon = yrMon.substring(0,4)+"-"+yrMon.substring(4,6);
    }
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (CpsCni0307Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		log.error("err " + e.toString(), e);
	}
%>
<html>
<head>
<title>R.O.E. (Rate of Exchange) Inquiry</title>
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

<body class="popup_bg" onLoad="setupPage();" class="popup_bg">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; R.O.E. (Rate of Exchange) Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="100">Year-Month</td>
					<td width=""><input type="text" name="fm_dt" required style="width:60;ime-mode:disabled;text-align:center" maxlength="6" dataformat="ym" fullfill caption="Year-Month(From Date)" class="input1" value="<%=yrMon%>">&nbsp;<img src="img/btns_calendar.gif" name="cal_fm_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;~&nbsp;<input type="text" name="to_dt" required style="width:60;ime-mode:disabled;text-align:center" maxlength="6" dataformat="ym" fullfill caption="Year-Month(To Date)" class="input1" value="<%=yrMon%>">&nbsp;<img src="img/btns_calendar.gif" name="cal_to_dt" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				<tr class="h23">
					<td width="">Local Currency</td>
					<td width=""><input type="text" name="search_curr_cd" caption="Local Currency" maxlength="3" dataformat="engup" fullfill style="width:60;text-align:center;ime-mode:disabled" class="input" value="<%=currCd%>"></td>
				</tr>
				</table>
				
				<table class="height_5"><tr><td></td></tr></table>
				
		<!-- Grid  (S) -->
			<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
			</table> 
			<!-- Grid (E) -->
			
			
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
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_New">New</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td class="btn1_line">
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right"></td>
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
<%@include file="/bizcommon/include/common_alps.jsp"%>