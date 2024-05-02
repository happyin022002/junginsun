<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0110.jsp
*@FileTitle : booking report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.08.25 강동윤
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0110Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0110Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.BookingReport.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0110Event)request.getAttribute("Event");
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
<title>booking report</title>
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

<input type="hidden" name="rea_val">
	<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>

	<!--Page Title, Historical (E)-->
	</td></tr>
	<tr><td valign="top">
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="580">
							<table border="0" style="width:550;" class="search_sm2"> 
							<tr class="h23">
								<td width="110">
									<input type="radio" name="tab_tp" class="trans" value="1" onClick="javascript:changeTab(1);">&nbsp;By Customer</td>
								<td width="220" class="sm">
									<input type="radio" name="cust_tp" class="trans" value="S">&nbsp;Shipper&nbsp;&nbsp;
									<input type="radio" name="cust_tp" class="trans" value="F" checked>&nbsp;Forwarder&nbsp;<input type="text" name="cust_nm" style="width:70;" value=""></td>
								<td width="">
									<input type="radio" name="tab_tp" class="trans" value="0" onClick="javascript:changeTab(0);" checked>&nbsp;By Booking Office&nbsp;<input type="text" name="bkg_ofc_cd" style="width:60;" value="" dataformat="engup" maxlength="6"></td>
							</tr>
							</table>
						</td>
						<td width="69">C/A Staff</td>
						<td><input type="text" name="corr_usr_id" style="width:105;" value=""></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="580">
							<table border="0" style="width:550;" class="search_sm2"> 
							<tr class="h23">
								<td width="100">
									<input type="radio" name="cho_dt" class="trans" value="0">&nbsp;C/A Date</td>
								<td width="120">
									<input type="radio" name="cho_dt" class="trans" value="1" checked>&nbsp;Booking Date</td>
								<td><input type="text"  name="cho_from_dt" style="width:75;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<!-- img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar" -->&nbsp;~&nbsp;<input type="text" name="cho_to_dt" style="width:75;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1"></td>
							</tr>
							</table>
						</td>
						<td width="100">On Board Date</td>
						<td><input type="text" name="bl_obrd_from_dt" style="width:75;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<!-- img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" -->&nbsp;~&nbsp;<input type="text" name="bl_obrd_to_dt" style="width:75;" value="" dataformat="ymd" maxlength="10" size="10" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
					</tr>
				</table>
				<!--table class="search" border="0" style="width:979;"> 
				<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="510">
							<table border="0" style="width:500;" class="search_sm2"> 
							<tr class="h23">
								<td width="100">
									<input type="radio" name="cho_dt" class="trans" value="0">&nbsp;C/A Date</td>
								<td width="120">
									<input type="radio" name="cho_dt" class="trans" value="1" checked>&nbsp;Booking Date</td>
								<td><input type="text"  name="cho_from_dt" style="width:75;" value="" maxlength="7">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar">&nbsp;~&nbsp;<input type="text" name="cho_to_dt" style="width:75;" value="" maxlength="7">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1"></td>
							</tr>
							</table>
						</td>
						<td width="100">Booking Office</td>
						<td><input type="text" name="bkg_ofc_cd" style="width:105;" value="" dataformat="engup" maxlength="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr><td height="3"></td></tr>
					<tr class="h23">						
						<td width="213" align="right">On Board Date</td>
						<td width="297">&nbsp;&nbsp;&nbsp;<input type="text" name="bl_obrd_from_dt" style="width:75;" value="">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;~&nbsp;<input type="text" name="bl_obrd_to_dt" style="width:75;" value="">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
						<td width="100" align="left">C/A Staff</td>
						<td><input type="text" name="corr_usr_id" style="width:105;" value=""></td>
					</tr>
				</table-->
				<table class="search" border="0" style="width:979;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="80">&nbsp;&nbsp;&nbsp;Lane / Dir</td>
						<td width="125"><input type="text" name="slan_cd" style="width:50;" value="" dataformat="engup" maxlength="3">&nbsp;<input type="text" name="lan_skd_dir_cd" style="width:20;" value="" dataformat="engup" maxlength="1"></td>
						<td width="30">VVD</td>
						<td width="190"><input type="text" name="vsl_cd" style="width:50;" value="" dataformat="engup" maxlength="4">&nbsp;<input type="text" name="skd_voy_no" style="width:50;" value="" dataformat="engupnum" maxlength="4">&nbsp;<input type="text" name="skd_dir_cd" style="width:20;" value="" dataformat="engup" maxlength="1"></td>
						<td width="49">Route</td>
						<td>&nbsp;POR&nbsp;<input type="text" name="por_cd" style="width:70;" value="" dataformat="engup" maxlength="5">&nbsp;POL&nbsp;<input type="text" name="pol_cd" style="width:70;" value="" dataformat="engup" maxlength="5">&nbsp;POD&nbsp;<input type="text" name="pod_cd" style="width:70;" value="" dataformat="engup" maxlength="5">&nbsp;DEL&nbsp;<input type="text" name="del_cd" style="width:70;" value="" dataformat="engup" maxlength="5">&nbsp;</td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr><td height="3"></td></tr>
					<tr class="h23">
						<td width="305">
							<table border="0" style="width:285;" class="search_sm2"> 
							<tr class="h23">
								<td width="70">&nbsp;&nbsp;&nbsp;Reason</td>
								<td class="sm">
									<input type="checkbox" name="ca_rsn_cd" class="trans" value="M">&nbsp;M&nbsp;&nbsp;
									<input type="checkbox" name="ca_rsn_cd" class="trans" value="C">&nbsp;C&nbsp;&nbsp;
									<input type="checkbox" name="ca_rsn_cd" class="trans" value="G">&nbsp;G&nbsp;&nbsp;
									<input type="checkbox" name="ca_rsn_cd" class="trans" value="A">&nbsp;A&nbsp;&nbsp;
									<input type="checkbox" name="ca_rsn_cd" class="trans" value="R">&nbsp;R</td>
							</tr>
							</table>
						</td>
						<td width="120">Kind&nbsp;&nbsp;&nbsp;<script language="javascript">ComComboObject('ca_knd', 2, 50, true, '');</script></td>
						<td>
							<table border="0" style="width:225;" class="search_sm2"> 
							<tr class="h23">
								<td width="100">&nbsp;&nbsp;<input type="checkbox" name="rat_flg" class="trans" value="Y" onClick="javascript:changeRat(0)">&nbsp;Revenue</td>
								<td><input type="checkbox" name="rat_flg" class="trans" value="N" onClick="javascript:changeRat(1)">&nbsp;Non Revenue</td>
							</tr>
							</table>
						</td>
					</tr>
				</table>
				<!--  biz_1   (E) -->		
			
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) --> 
		
		
		
<!--TAB  (S) -->
<div id="tabLayer" style="display:inline">		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
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
		<!--biz page (E)-->
</div>
<!--TAB  (E) -->

	

<!--TAB  (S) -->
<div id="tabLayer" style="display:none">		
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">	
			
			
			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table> 			
			<!-- Grid (E) -->		
			
			
			
			</td></tr>
		</table>
		<!--biz page (E)-->
</div>
<!--TAB  (E) -->
	
	
	</td></tr>
		</table>
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
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
					<td class="btn1" name="btn_excel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!-- <td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
				 -->
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>