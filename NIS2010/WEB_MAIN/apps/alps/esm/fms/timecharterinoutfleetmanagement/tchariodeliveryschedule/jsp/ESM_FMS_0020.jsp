<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0020.jsp
*@FileTitle : NB Delivery Schedule Inquiry
*@LastModifyDate : 2009.04.23
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.04.15 최우석
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.event.EsmFms0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;				//서버에서 발생한 에러
	String strErrMsg = "";							//에러메세지
//	int rowCount	 = 0;							//DB ResultSet 리스트의 건수
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutFleetManagement.TCharterStandardPrimeCost");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>NB Delivery Schedule Inquiry</title>
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

<input type="hidden" name="ydSeq">
<input type="hidden" name="ownrSeq">
<input type="hidden" name="periodFlag">
<input type="hidden" name="vslDeDt1">
<input type="hidden" name="vslDeDt2">
<input type="hidden" name="vslCdSizeFlag">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;<span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
			<!--  biz_1  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">NB Delivery Schedule Inquiry / Master</td></tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			
				<td width="393">
					<table class="search_sm2" border="0" style="width:370;"> 
						<tr class="h23">
							<td width="100">&nbsp;Search Period</td>
							<td class="stm"><input type="radio" name="btn_periodFlag" value="" class="trans" checked>Date&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Month&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Year</td>
						</tr>
					</table>
				</td>		
				<td width="107">&nbsp;&nbsp;Duration </td>
				<td width="">
					<div id="style1" style="display:''">
						<input type="text" name="vslDeDate1" maxlength="8" dataformat="ymd" required fullfill caption="Duration To" style="width:80;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeDate1" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="vslDeDate2" maxlength="8" dataformat="ymd" required fullfill cofield="vslDeDate1" caption="Duration From" style="width:80;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeDate2" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
					</div>
					<div id="style2" style="display:none">
						<input type="text" name="vslDeMonth1" maxlength="6" dataformat="ym" required fullfill caption="Duration To" style="width:60;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeMonth1" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="vslDeMonth2" maxlength="6" dataformat="ym" required fullfill cofield="vslDeMonth1" caption="Duration From" style="width:60;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeMonth2" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
					</div>
					<div id="style3" style="display:none">
						<input type="text" name="vslDeYear1" maxlength="4" dataformat="yyyy" required fullfill caption="Duration To" style="width:40;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeYear1" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~&nbsp;
						<input type="text" name="vslDeYear2" maxlength="4" dataformat="yyyy" required fullfill cofield="vslDeYear1" caption="Duration From" style="width:40;text-align:center;" class="input1" value="">&nbsp;
						<img src="img/btns_calendar.gif" name="btn_vslDeYear2" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
					</div>
				</td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
				<td width="80">&nbsp;&nbsp;Yard</td>
				<td width="320"><input type="text" name="shpYdNm" style="width:202;" class="input" value="" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_yard" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
					<input type="checkbox" name="btn_ydClr" class="trans">
			 	</td>
				<td width="100">Owner</td>
				<td><input type="text" name="ownrNm" style="width:200;" class="input" value="" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_owner" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
					<input type="checkbox" name="btn_ownrClr" class="trans">
				</td>
			</tr>
			</table>
			<table class="search" border="0" style="width:979;">
			<tr class="h23">
				<td width="400">
					<table class="search_sm2" border="0" style="width:370;"> 
						<tr class="h23">
							<td width="75">&nbsp;Vessel Size</td>
							<td class="stm"><input type="text" name="vslCdSize1" dataformat="int" maxlength="5" style="width:60;text-align:right;" class="input" value="">&nbsp;~&nbsp;<input type="text" name="vslCdSize2" maxlength="5" dataformat="int" style="width:60;text-align:right;" class="input" value="">&nbsp;<input type="radio" name="btn_vslCdSizeFlag" value="" class="trans" checked>Max&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_vslCdSizeFlag" value="" class="trans">14Ton</td>
						</tr>
					</table>
				</td>
				<td width="100">Ship's Full Name</td>
				<td><input type="text" name="shpNm" maxlength="50" style="width:183;" class="input" value=""></td>
			</tr>
			</table>
			
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!--  biz_2  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">NB Delivery Schedule Inquiry / Grid</td></tr>
			</table>
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<!--<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_print">Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>-->
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