<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_fms_0060.jsp
*@FileTitle : Fleet Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 최우석
*@LastVersion : 1.0
* 2009.05.26 최우석
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
<%@ page import="com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tcharterioinquiry.event.EsmFms0060Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0060Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	//int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.hanjin.apps.TimeCharterInOutFleetManagement.TCharterIOInquiry");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmFms0060Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Fleet Status</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript" src="/hanjin/rpt/script/rdviewer50.js"></script>
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

<input type="hidden" name="schDt">
<input type="hidden" name="schDtTo">
<input type="hidden" name="ownrSeq">
<input type="hidden" name="periodFlag">
<input type="hidden" name="vslSizeFlag">
<input type="hidden" name="usr_id" value="<%=strUsr_id%>">

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
				<td class="title_s">Fleet Status - Master</td></tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="400">
					<table class="search_sm2" border="0" style="width:370;"> 
						<tr class="h23">
							<td width="100">&nbsp;&nbsp;Search Period</td>
							<td class="stm"><input type="radio" name="btn_periodFlag" value="" class="trans" checked>Date&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Month&nbsp;&nbsp;&nbsp;<input type="radio" name="btn_periodFlag" value="" class="trans">Year</td>
						</tr>
					</table>
				</td>		
				
					<td width="80">Duration</td>
					<td width="">
						<div id="style1" style="display:''">
							&nbsp;<input type="text" name="schDate" maxlength="8" dataformat="ymd" required fullfill caption="Duration" style="width:80;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schDate" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
							<input type="text" name="schDateTo" maxlength="8" dataformat="ymd" required fullfill caption="Duration" style="width:80;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schDateTo" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</div>
						<div id="style2" style="display:none">
							&nbsp;<input type="text" name="schMonth" maxlength="6" dataformat="ym" required fullfill caption="Duration" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schMonth" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
							<input type="text" name="schMonthTo" maxlength="6" dataformat="ym" required fullfill caption="Duration" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schMonthTo" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</div>
						<div id="style3" style="display:none">
							&nbsp;<input type="text" name="schYear" maxlength="4" dataformat="yyyy" required fullfill caption="Duration" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schYear" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">&nbsp;~
							<input type="text" name="schYearTo" maxlength="4" dataformat="yyyy" required fullfill caption="Duration" style="width:40;text-align:center;ime-mode:disabled;" class="input1" value="">
							<img src="img/btns_calendar.gif" name="btn_schYearTo" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						</div>
					</td>
				</tr>
			</table>
			<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Contract Type</td>
					<td width="300">&nbsp;
						<select name="contractType" style="width:100;">
							<option value="">All</option>
						</select>
					</td>
					<td width="80">Vessel Size</td>
					<td width="300" class="stm" >
						&nbsp;<input type="text" name="vslSize1" dataformat="int" maxlength="5" style="width:60;ime-mode:disabled;text-align:right;" class="input" value="">&nbsp;~&nbsp;
						<input type="text" name="vslSize2" dataformat="int" maxlength="5" style="width:60;ime-mode:disabled;text-align:right;" class="input" value="">
						<input type="radio" name="btn_vslSizeFlag" value="" class="trans" align="baseline" checked>Max.&nbsp;&nbsp;
						<input type="radio" name="btn_vslSizeFlag" value="" class="trans" align="baseline">14Ton
					</td>
					<td width="40">Lane</td>
					<td>
						<input type="text" name="laneCd" style="width:40;text-align:center;ime-mode:disabled" class="input" maxlength="3" fullfill caption="Lane Code">&nbsp;
						<img src="img/btns_search.gif" name="btn_laneCd" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						<input type="checkbox" name="btn_laneCdClr" class="trans">
					</td>
				</tr>
				<tr class="h23">
					<td width="100">&nbsp;&nbsp;Owner</td>
					<td width="300">&nbsp;&nbsp;<input type="text" name="ownrNm" style="width:200;" class="input" value="" readonly>&nbsp;<img src="img/btns_search.gif" name="btn_owner" style="cursor:hand" width="19" height="20" alt="" border="0" align="absmiddle">
						<input type="checkbox" name="btn_ownrClr" class="trans"></td>
					<td>Gear with</td>
					<td style="padding-left:2">
						<select name="gearWith" style="width:78;">
							<option value="" selected>All</option>
							<option value="N">G.Less</option>
							<option value="Y">Geared</option>
						</select>
					</td>
				</tr>
			</table>
			<!--  biz_1   (E) -->
			<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
			<!--  biz_2  (S) -->
			<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">Fleet Status Result</td></tr>
			</table>
			<!-- Grid  (S) -->
			<table width="100%" id="mainTable" cellpadding="0" cellspacing="0" border="0"> 
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				<tr id="totalAmount">
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
					</td>
				</tr>
			</table>
			<!-- Grid (E) -->
			<!--  biz_2   (E) -->
		</td></tr>
	</table>
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
		<td class="btn1_line"></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_savetofile">Down&nbsp;Excel</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
		<td class="btn1_line"></td>
		<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn1_left"></td>
			<td class="btn1" name="btn_print">Print</td>
			<td class="btn1_right"></td>
			</tr>
		</table></td>
	</tr>
	</table>
</td></tr>
</table>
<!--Button (E) -->

<!------- Print용 Hidden RD Object Start -------->
<table width="100%" id="rdTable"> 
	<tr>
		<td width="100%">
			<script language="javascript">comRdObject('Rd');</script>
		</td>
	</tr>
</table>
<!------- Print용 Hidden RD Object End -------->

<script language="javascript">ComSheetObject('sheet3');</script>

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>