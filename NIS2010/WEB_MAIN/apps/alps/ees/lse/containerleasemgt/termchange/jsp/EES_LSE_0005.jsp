<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0005.jsp
*@FileTitle : Term Change Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.event.EesLse0005Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0005Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();


		event = (EesLse0005Event)request.getAttribute("Event");
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
<title>Term Change Creation</title>
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
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:;,padding-bottom:2;">
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

	<table class="search">
       		<tr><td class="bg">

				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Current Status</td>
					<td align="right" id="div_diFlag" style="display:none"><input type="checkbox" name="di_flag" value="Y" class="trans">DI Flag&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>
				<tr></tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="60">AGMT No.</td>
					<td width="140"><input type="text" name="cur_agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" caption="Current AGMT No." name="cur_agmt_seq" style="width:55;ime-mode:disabled;" class="input1" value="" maxlength="6" dataformat="int" required>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Contract No.</td>
					<td width="120"><input type="text" name="cur_ctrt_no" caption="Contract No." style="width:100" class="input2" value="" readonly></td>
					<td width="50">Ref. No.</td>
					<td width="120"><input type="text" name="cur_ref_no" caption="Ref. No." style="width:100;" class="input2" value=""  readonly></td>
					<td width="70">Lease Term</td>
					<td width="60"><input type="text" name="cur_lstm_cd" caption="Lease Term" style="width:35;text-align:center;" class="input2" value="" readonly></td>
					<td width="40">Lessor</td>
					<td>&nbsp;<input type="text" name="cur_vndr_seq" caption="Lessor" style="width:50;text-align:center;" class="input2" value="" readonly>&nbsp;<input type="text" name="cur_vndr_nm" caption="Lessor" style="width:180"  class="input2" value="" readonly></td>
					<td>&nbsp;</td>
				</tr>
				</table>
				<!--  biz_1  (E) -->
				<!--  biz_2 (S) -->
			<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">After Status</td></tr>
				</table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="60">AGMT No.</td>
					<td width="140"><input type="text" name="aft_agmt_cty_cd" caption="AGMT No." style="width:40;text-align:center;" class="input2" value="HHO" readonly>&nbsp;<input type="text" caption="After AGMT No." name="aft_agmt_seq" style="width:55;" class="input1" value="" maxlength="6" dataformat="int" required>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search3" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="80">Contract No.</td>
					<td width="120"><input type="text" name="aft_ctrt_no" caption="Contract No." style="width:100" class="input2" value="" readonly></td>
					<td width="50">Ref. No.</td>
					<td width="120"><input type="text" name="aft_ref_no" caption="Ref. No." style="width:100;" class="input2" value=""  readonly></td>
					<td width="70">Lease Term</td>
					<td width="60"><input type="text" name="aft_lstm_cd" caption="Lease Term" style="width:35;text-align:center;" class="input2" value="" readonly></td>
					<td width="40">Lessor</td>
					<td>&nbsp;<input type="text" name="aft_vndr_seq" caption="Lessor" style="width:50;text-align:center;" class="input2" value="" readonly>&nbsp;<input type="text" name="aft_vndr_nm" caption="Lessor" style="width:180"  class="input2" value="" readonly></td>
					<td>&nbsp;</td>
				</tr>
				</table>
				<!--  biz_2  (E) -->

				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="85">Activity Date</td>
					<td width="152">
						<input type="text" name="act_dt" caption="Activity Date" style="width:73;text-align:left;" class="input1" value="" maxlength="8" dataformat="ymd" required fullfill>
						<img class="cursor" src="img/btns_calendar.gif" name="btns_calendar" width="19" height="20" border="0" align="absmiddle">
					</td>
					<td width="40">Office</td>
					<td width="120"><input type="text" name="ofc_cd" caption="Office" style="width:76;text-align:center;ime-mode:disabled;" class="input1" value="<%= strOfc_cd %>" maxlength="6" dataformat="engup" required>&nbsp;<img class="cursor" src="img/btns_search.gif" name="btns_search" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="69" id="div_dcond1" style="display:none">DI Vender</td>
					<td width="469" id="div_dcond2" style="display:none">
						<input type="text" name="di_vndr_seq" caption="DI Vender" style="width:57;text-align:center;" class="input1" value="" maxlength="6" dataformat="int">
						<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="di_vndr_nm" style="width:240" class="input2" value="" readonly></td>
					<td>&nbsp;</td>
				</td></tr>
				</table>

<!-- : ( Search Options ) (E) -->

			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable">
       		<tr><td class="bg" style="height:347;" valign="top">
       			<table class="search" border="0">
				<tr></tr>
				</table>
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->
			</td></tr>
		</table>
	<!--biz page (E)-->
	
	</td></tr>
</table>


</form>
</body>
</html>
