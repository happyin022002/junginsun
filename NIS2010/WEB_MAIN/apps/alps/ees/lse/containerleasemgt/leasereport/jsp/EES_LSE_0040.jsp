<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0040.jsp
*@FileTitle : Off Hire Result-Average using Day
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.28 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport.event.EesLse0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0040Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.leasereport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0040Event)request.getAttribute("Event");
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
<title>Off Hire Result-Average using Day</title>
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
<input type="hidden" name="lstm_cd">
<input type="hidden" name="cntr_tpsz_cd">
<input type="hidden" name="hcond_params">
<input type="hidden" name="hcond_tpsz_cd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

	</td></tr>
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
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">


				<!--  biz  1(S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="65">Period</td>
					<td width="300">
						<input type="text" name="str_evnt_dt" caption="Start Duration" style="width:70;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="end_evnt_dt">&nbsp;~&nbsp;<input type="text" name="end_evnt_dt" caption="End Duration" style="width:70;text-align:center;ime-mode:disabled;" class="input1" value="" maxlength="8" dataformat="ymd" !cofield="str_evnt_dt">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="77">Lease Term</td>
					<td width="240" style="padding-left:1">
						<script language="javascript" >ComComboObject('combo1', 1, 42, 1, 1);</script>
					</td>
					<td width="87">Company</td>
					<td style="padding-left:2;"><select name="cntr_use_co_cd" style="width:50;" class="input">
						<option value="">All</option>
						<option value="H" selected>SML</option>
						<option value="D">SEN</option>
						</select></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;">
					<tr class="h23">
					<td width="65">AGMT No.</td>
					<td width="300">
						<input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" caption="AGMT No." name="agmt_seq" style="width:56;" class="input" value="" maxlength="6" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="ref_no" style="width:120" class="input2" readonly>
					</td>
					<td width="78">TP/SZ</td>
					<td width="240"><script language="javascript" >ComComboObject('combo2', 1, 202, 1 );</script>&nbsp;</td>
					<td width="87">Term Change</td>
					<td style="padding-left:2;"><select name="hjs_cre_flg" style="width:80;" class="input1">
						<option value="">Including</option>
						<option value="N" selected>Excluding</option>
						<option value="Y">Only</option>
						</select></td>
					</tr>

					<tr class="h23">
					<td width="65">Lessor</td>
					<td width="618" colspan="3">
						<input type="text" name="vndr_seq" caption="Lessor." style="width:100;text-align:center;" class="input" value="" maxlength="6" dataformat="int">&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="vndr_abbr_nm" caption="Lessor." style="width:120;text-align:center;"  class="input2" value="" readonly>
						<input type="text" name="vndr_nm" caption="Lessor." style="width:327"  class="input2" value="" readonly></td>
					<td width="87">DII</td>
					<td style="padding-left:2;"><select name="cntr_sts_cd" style="width:80;" class="input1">
						<option value="1" selected>Including</option>
						<option value="2">Excluding</option>
						<option value="3">Only</option>
						</select></td>
					</tr>
				</table>
			</td></tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!-- Grid  (S) -->
				<table width="100%" class="search"  id="mainTable">
					<tr>
						<td width="100%">
						<script language="javascript">ComSheetObject1('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->

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

    	<table class="height_8"><tr><td></td></tr></table>
    	<table class="line_bluedot"><tr><td></td></tr></table>

			<table width="100%">
    			<tr><td width="10">&nbsp;</td><td id="dcondTD" style="color:gray;">&nbsp;</td></tr>
    		</table>

			<!-- Grid  (S) -->
			<table width="100%"  id="sheetTable2">
				<tr>
					<td width="100%">
						<script language="javascript">ComSheetObject('sheet2');</script>
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
					<td class="btn2" name="btn_DownExcel2">Down Excel</td>
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

	</td></tr>
		</table>


	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</td></tr>
		</table>


<!-- 개발자 작업  끝 -->
</form>
</body>
</html>