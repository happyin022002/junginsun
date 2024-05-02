<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0121.jsp
*@FileTitle : MNR PFMC by Estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.30
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2009.10.08 민정호
* 1.0 Creation
*=====================================================
* 2013.05.30 조경완 [CHM-201324809-01] [MNR-자체개선] M&R > Guideline & PFMC > General Performance > PFMC by Estimate 수행시 ALPS OLTP Rule에 따라 Timeout SQL 발생 방지를 위한 BackEndJob 으로의 기능 전환
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event.EesMnr0121Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0121Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();

		event = (EesMnr0121Event)request.getAttribute("Event");
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
<input type="hidden" name="user_ofc_cd" value="<%=strOfc_cd%>"> 
<input type="hidden" name="curr_cd">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

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
				</table></td></tr>
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
					<td width="100">Period</td>
					<td width="330">&nbsp;<script language="javascript">ComComboObject('report_period_type',2, 100 , 1,1)</script>						
						&nbsp;<input type="text" name="fm_dt" dataformat="ymd"    caption="from date"        maxlength="8"  size="10"  cofield="to_dt" value="">   
                              	~ <input type="text" name="to_dt" dataformat="ymd"    caption="to date"        maxlength="8"  size="10"  cofield="fm_dt">&nbsp;<img name="btn_calendar" class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">
					</td>		
					<td width="90">EQ Type</td>
					<td width="130">&nbsp;<script language="javascript">ComComboObject('eq_type',2, 100, 1, 0, 2,false,1);</script></td>
					<td width="90">TP/SZ</td>
					<td width="120">&nbsp;<script language="javascript">ComComboObject('tp_sz_cd', 2, 100 ,0);</script></td>
					<td>USD Only&nbsp;<input name="check_usd_only" type="checkbox" class="trans"></td>				
				</tr>							 	
				</table>	 	
				 			
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23"> 
					<td width="100">Regional HQ</td>
					<td width="130">&nbsp;<script language="javascript">ComComboObject('rhq',2, 100, 0, 0);</script></td>
					<td width="80">Office</td>
					<td width="120">&nbsp;<script language="javascript">ComComboObject('ofc_cd',2, 100 ,0, 0,'',0,'');</script></td>					
					<td width="120">Service Provider</td>	
					<td width=""><input type="text" name="vndr_seq" caption="Service Provider" style="width:57;text-align:left;" class="input" value="" dataformat="engup" maxlength="6">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btn_provider_popup" width="19" height="20" border="0" align="absmiddle">&nbsp;<input type="text" name="vndr_lgl_eng_nm" caption="Service Provider" style="width:152;" class="input2" value="" readonly>
				</tr> 
				</table>		
				<!--  biz_1   (E) -->
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
				
			<!-- Title -->
<!-- 			
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">M &amp; R Performance Detail</td></tr>
			<tr><td class="height_5"></td></tr>
			</table>
-->			
			<!-- Title -->
			
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
				<tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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