<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0115.jsp
*@FileTitle : Expense Plan and PFMC by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.07 민정호
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
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0115Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0115Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMnr0115Event)request.getAttribute("Event");
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
<title><span id="title"></span></title>
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
<input type="hidden" name="rhq">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="report_type">
<input type="hidden" name="backendjob_key">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 				
				<tr class="h23">	
					<td width="45">Period</td>		
					<td width="250">&nbsp;<input type="text" style="width:80;text-align:center" class="input1" name="from_mon" dataformat="ym" maxlength="6" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal_from">&nbsp;~
						<input type="text" style="width:80;text-align:center" class="input1" name="to_mon" dataformat="ym" maxlength="6" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="cre_dt_cal_to"> 										
					</td>									
					<td width="80">Report Type</td>	
					<td width="200">&nbsp;<script language="javascript">ComComboObject('combo_report_type',2, 180 , 0,1);</script></td>

					<td width="80">Regional HQ</td>
					<td width="100">&nbsp;<script language="javascript">ComComboObject('combo_rhq',2, 90 , 0,1);</script></td>
					<td width="45">Office</td>
					<td width="100">&nbsp;<script language="javascript">ComComboObject('combo_office',2, 80 , 0,1,'',0,'');</script></td>
					<td width="45">RHQ&nbsp;Only</td>
					<td width=""><input type="checkbox" name="rhq_only" style="border:0;" onclick="javascript:showRhqOnly(this);"></td>
					</tr> 
				</table>				
				<!--  biz_1   (E) -->			
		</td></tr></table>		
		<table class="height_8"><tr><td></td></tr></table>			
		<table class="search" id="mainTable"> 
       	<tr><td class="bg">	
<!--        				
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s"> M &amp; R Expense Performance</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>
-->							
			<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
			<!-- Grid (E) -->			
			
			<!--  Button_Sub (S) -->
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
	    	<!-- Button_Sub (E) -->			
			</td></tr>
		</table>
		<!--biz page (E)-->
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>