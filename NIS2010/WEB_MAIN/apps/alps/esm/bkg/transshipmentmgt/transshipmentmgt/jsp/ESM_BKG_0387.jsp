<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0387.jsp
*@FileTitle : Next VVD Assign I (by VVD POD)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
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
<%@ page import="com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event.EsmBkg0387Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0387Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRelay			= "";
	String strEtbFrom		= "";
	String strEtbTo			= "";
	String strNextVvd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.TransshipmentMgt.TransshipmentMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0387Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		strRelay=event.getRelay();
		strEtbFrom = event.getEtbFrom();
		strEtbTo =event.getEtbTo();
		strNextVvd =event.getNextVvd();

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
<title>Next VVD Assign I (by VVD POD)</title>
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
<form name="form"  onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="nextVvdFor">
<input type="hidden" name="oldRelayPort">
<input type="hidden" name="baseRelayPort">
<input type="hidden" name="relay" value="<%=strRelay%>">
<input type="hidden" name="etbFrom" value="<%=strEtbFrom%>">
<input type="hidden" name="etbTo" value="<%=strEtbTo%>">
<input type="hidden" name="nextVvd" value="<%=strNextVvd%>">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)--> 
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!--Page Title, Historical (E)-->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="80">&nbsp;&nbsp;Relay Port  </td>
					<td width="120"><input type="text" style="width:60;" class="input1" name="relay_port" maxlength="7" dataformat="engup" >&nbsp;<!--<input type="text" style="width:30;" class="input" value="">--></td>
					<td width="80">Former VVD </td>
					<td width="130"><input type="text" style="width:90;" class="input" name="former_vvd" maxlength="9" dataformat="engup"></td> 
					<td width="90">ETB Duration</td>
					<td width="240"><input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="etb_from">&nbsp;&nbsp;~&nbsp&nbsp;<input type="text" style="width:80;" class="input1" value="" dataformat="ymd" name="etb_to">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_duration"></td> 
					<td width="" align="right">
						<table class="search_sm2" border="0" width="129">
							<tr class="h23">
								<td width="70"> Special</td>
								<td class="stm">&nbsp;<input type="checkbox" value="Y" class="trans" name="rc_flg">RF&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="dcgo_flg">DG&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="awk_cgo_flg">AK&nbsp;&nbsp;<input type="checkbox" value="Y" class="trans" name="rd_cgo_flg">RD</td></tr>
						</table>
					</td>
				</tr>
				</table>
					<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="30">&nbsp;&nbsp;POL</td>
					<td width="100"><input type="text" style="width:80;" class="input" name="pol_cd" maxlength="5" dataformat="engup"></td>
					<td width="70">Next Port</td>
					<td width="100"><input type="text" style="width:80;" class="input" name="next_port" maxlength="7" dataformat="engup"></td> 
					<td width="30">POD</td>
					<td width="100"><input type="text" style="width:80"  class="input" name="pod_cd" maxlength="5" dataformat="engup"></td> 
					<td width="70"> Next VVD</td>
					<td width="100"><input type="text" style="width:80" class="input" name="next_vvd" maxlength="9" dataformat="engup"></td> 
					<td align="right">
						<table class="search_sm2" border="0" width="323">
						<tr class="h23">
							<td width="70"> Option</td>
							<td class="stm"><input type="radio" value="All" class="trans" checked name="next_vvd_select">All&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Assigned" class="trans" name="next_vvd_select">Assigned&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" value="Not Assigned" class="trans" name="next_vvd_select">Not Assigned</td></tr>
						</table>
					</td>
					<td width="110"><input type="checkbox" class="trans" name="invalid_vvd" value="Y">Invalid VVD</td>
				</tr>
				</table>
				
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
			
			
			<table class="search"> 
       	<tr><td class="bg">
				<!--  biz_2  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="310" valign="top">
					<!--  biz_2_1  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">Former VVD</td></tr>
					</table>
					<!--Grid (S)-->
					<table width="100%"  id="mainTable1">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					<!--  biz_2_1  (E) -->
					</td>
					<td width="19" valign="top"></td>
					<td width="650" valign="top">
					<!--  biz_2_2  (S) -->
					<table class="search" border="0">
						<tr><td class="title_h"></td>
						<td class="title_s">NEXT VVD SELECTION</td></tr>
					</table>
					<!--Grid (S)-->
					<table width="100%"  id="mainTable2">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
					<!--  biz_2_2  (E) -->
					</td>
				</tr>
				</table>
				
				<!--  biz_2   (E) -->
				</td></tr>
			</table>
			
			
			<table class="height_8"><tr><td></td></tr></table>
			
		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->

<!--TAB By VVD & POD (S) -->

<div id="tabLayer" style="display:inline">		
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">
			<!--  biz_3 (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="200"><input type="text" style="width:150;" class="input2" name="vsl_nm" readOnly></td>
					<td width="200"><input type="text" style="width:50;text-align:center;" class="input2" value="ETA" readOnly>&nbsp;<input type="text" style="width:90;text-align:center;" class="input2" name="eta" readOnly></td>
					<td width=""><input type="text" style="width:50;text-align:center;" class="input2" value="ETD" readOnly>&nbsp;<input type="text" style="width:90;text-align:center;" class="input2" name="etd" readOnly></td></tr>
				<tr><td height="2"></td></tr>
				</table>
				<!--  biz_3  (E) -->
				
				<!--Grid (S)-->
					<table width="100%"  id="mainTable11">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)--> 
				
				<table class="search" border="0" style="width:979;"> 
				<tr><td height="2"></td></tr>
				<tr class="h23">
						<td width="110">Total</td>
						<td width=""><input type="text" style="width:30;text-align:center;" class="input2" name="t20" readOnly value="20'"> <input type="text" style="width:88;text-align:right;" class="input2" name="total20" readOnly>&nbsp;<input type="text" style="width:30;text-align:center;" class="input2" name="t40" readOnly value="40'"> <input type="text" style="width:98;text-align:right;" class="input2" name="total40" readOnly></td></tr>
				<tr class="h23">
					<td width="110">Selected Volume</td>
					<td width=""><input type="text" style="width:30;text-align:center;" class="input2" name="s20" readOnly value="20'"> <input type="text" style="width:88;text-align:right;" class="input2"  name="selVVD20" readOnly>&nbsp;<input type="text" style="width:30;text-align:center;" class="input2" name="s40" readOnly value="40'"> <input type="text" style="width:98;text-align:right;" class="input2"  name="selVVD40" readOnly></td></tr>
				</table>
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
</div>

<!--TAB By VVD & POD (E) -->

<!--TAB By Booking (S) -->

<div id="tabLayer" style="display:none">	
		<!-- Grid BG Box  (S) -->
     	<table class="search">
       	<tr><td class="bg">

					<!--Grid (S)-->
					<table width="100%"  id="mainTable21">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
				
					<table class="search" border="0" style="width:979;"> 
					<tr><td height="2"></td></tr>
					
					<tr class="h23">
						<td width="110">Selected Volume</td>
						<td width=""><input type="text" style="width:88;text-align:right;" class="input2" name="selBKG20" readOnly>&nbsp;<input type="text" style="width:98;text-align:right;" class="input2" name="selBKG40" readOnly></td></tr>
					</table>
					
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
</div>

<!--TAB By Booking (E) -->

	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
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
					<td class="btn1" name="btn_downexcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_cancelassign">Cancel&nbsp;Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_vvdassign">VVD&nbsp;Assign</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	<!-- Grid  (S) -->
	<table width="100%" id="mainTable3"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet3');</script>
			</td>
		</tr>
	</table> 
			<!-- Grid  (E) --> 
	</td></tr>
		</table>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>