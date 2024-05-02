<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_dmt_2011.jsp
*@FileTitle : Time Clock Stop Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.11 최성환
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.timeclockstopmgt.event.EesDmt2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt2010Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.DMTExceptionMgt.TimeClockStopMgt");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesDmt2010Event)request.getAttribute("Event");
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
<title>Time Clock Stop Inquiry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="date_period">
<input type="hidden" name="office">
<input type="hidden" name="clk_stop_ofc_cd">
<input type="hidden" name="dmdt_trf_cd">

<input type="hidden" name="ofc_cd">
<input type="hidden" name="tmp_ofc_cd">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
		<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
	</table>
	<!--Page Title, Historical (E)-->
	<table class="search">
       		<tr><td class="bg">
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="500">

						<table class="search_sm2" border="0" style="width:480;">
							<tr class="h23">
								<td width="40">&nbsp;Date </td>
								<td width="200" class="stm">
								<input type="radio" name="r_date" value="1" class="trans" checked>Creation&nbsp;&nbsp;&nbsp;
								<input type="radio" name="r_date" value="2" class="trans">Stop Period</td>
								<td width="265">
								<input type="text" style="width:80;" class="input1" name="fm_dt" maxlength="8" dataformat="ymd"  caption="From Date">&nbsp;~
								<input type="text" style="width:80;" class="input1" name="to_dt" maxlength="8" dataformat="ymd"  caption="To Date" >
								<img src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" alt="" border="0" align="absmiddle" style="cursor:hand" >
								
								</td>
							</tr>
						</table>
						</td>
						<td width="70">Status</td>
						<td width=""><select name="cxl_flg" style="width:100;" class="input1">
						<option value="" selected>All</option>
						<option value="N">Live</option>
						<option value="Y">Cancelled</option>
						</select></td>
					</tr>

				</table>
				<table class="height_2"><tr><td></td></tr></table>

				<table class="search" border="0" style="width:979;">
					<tr class="h23">
						
						<td width="85">&nbsp;&nbsp;Stop Office </td>
						<td width="415" class="sm">
						<script language="javascript">ComComboObject('combo2', 2, 100 , 0)</script>
						&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor">&nbsp;
						<input type="checkbox" name="chk_sub_ofc" value="Y" class="trans" onClick="doInclSubOfc()">Incl. Sub Office</td>
							
						<td width="72">Tariff type </td>
						<td width="">
						<script language="javascript">ComComboObject('combo1', 2, 250 , 0)</script>
						&nbsp;<img src="img/btns_multisearch.gif"width="19"height="20"alt=""border="0"align="absmiddle"class="cursor"></td>
					</tr>

				</table>
				
				
				<!--  biz_1  (E) -->
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (e) -->
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:0;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				<td class="btn1_line"></td>
				<!-- 
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Detail">Detail</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				 -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</td></tr>
			</table>
    <!--Button (E) -->
			</td></tr>
		</table>

<!-- 개발자 작업  끝-->
</form>
</body>
</html>