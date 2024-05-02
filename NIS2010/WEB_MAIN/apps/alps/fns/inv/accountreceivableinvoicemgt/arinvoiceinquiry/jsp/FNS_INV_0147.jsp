
<%
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : fns_inv_0147.jsp
	 *@FileTitle : PCF Status Report
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2018.06.20
	 *@LastModifier : 박성용
	 *@LastVersion : 1.0
	 * 2018.06.20 박성용
	 * 1.0 Creation
	 * History
	 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event.FnsInv0147Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	FnsInv0147Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //서버에서 발생한 에러
	String strErrMsg = ""; //에러메세지
	int rowCount = 0; //DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strCnt_cd = "";

	Logger log = Logger
			.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceInquiry");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strCnt_cd = account.getCnt_cd();

		event = (FnsInv0147Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>PCF Status Report</title>
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

<body onLoad="setupPage();">
<form name="form">
    <input type="hidden" name="f_cmd"> 
    <input type="hidden" name="pagerows"> 
<!-- 개발자 작업	--> 
    <input type="hidden" name="rect_top">
	<input type="hidden" name="rect_left">
	<input type="hidden" name="sheet_vvd_row_chk">
	<input type="hidden" name="re_divr_cd">
	<input type="hidden" name="vvd_cd">
    
<!-- OUTER - POPUP (S)tart -->
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!-- : ( Title ) (S) -->
		<table width="100%" border="0" cellpadding="0" cellspacing="0"
			class="title">
			<tr>
				<td class="history"><img src="img/icon_history_dot.gif"
					align="absmiddle"><span id="navigation"></span></td>
			</tr>
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif"
					align="absmiddle"><span id="title"></span></td>
			</tr>
		</table>
		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!--  biz_1  (S) -->
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="35" >VVD</td>
	                    <td width="210" valign="top">
	                    
	                    	<table class="search" border="0">
                                <tr class="h23">
                                  <td valign="top" id="td_vvd" width="92">
                                    <div id="vvd_input" style="display:block"> 
                                      <input type="text" name="input_vvd" style="width:90;" class="input" value="" maxlength="9" dataformat="engup"  >
                                    </div>
                                    <div id="vvd_sheet" style="display:none;width:90px;height:150px;position:absolute;left:0px;top:0px;">
                                      <script language="javascript">ComSheetObject('sheet3');</script>
                                    </div>
                                 </td>
                                 <td style="width:2"></td>
                                  <td width=""><table width="90" border="0" cellpadding="0" cellspacing="0" class="button">
                                		<tr><td class="btn2_left"></td>
                               				 <td class="btn2" id="btn_input_vvd" name="btn_input_vvd" >Multi VVD</td>
                               				 <td class="btn2_right"></td>
                                		</tr></table>
                                	</td>
                                 </tr>
	                    	</table>
	                    
	                    </td>	
						<td width="35">POL</td>
						<td width="110"><input type="text" value="" class="input"
							style="width: 80;" name="pol_cd" maxlength="5"
							dataformat="engup" style="ime-mode:disabled"></td>
						<td width="35" align="">ATD</td>				
						<td><input type="text" name="fm_atd_dt" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="to_atd_dt" caption="start date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input type="text" name="to_atd_dt" required dataformat="ymd" maxlength="8" style="width:85" class="input1" cofield="fm_atd_dt" caption="end date">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
					</tr>
				</table>
				<!--  biz_1   (E) --></td>
			</tr>
		</table>
		<table class="height_8">
			<tr>
				<td></td>
			</tr>
		</table>
		<!-- 1 (E)--> <!-- 2 (S)--> <!-- Tab ) (S) -->
		<table class="tab" border="0" cellpadding="0" cellspacing="0"
			width="100%">
			<tr>
				<td width="100%"><script language="javascript">ComTabObject('tab1')</script>
				<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
				</td>
			</tr>
		</table>
		<!-- Tab ) (E) --> <!--TAB Creation (S) -->
		<div id="tabLayer" style="display: inline">

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Charge (S) -->

				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="45">Agent</td>
						<td><input type="text" value="" class="input"
							style="width: 80;" name="chn_agn_cd" maxlength="2"
							dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- 2 (E)--></div>
		<!--TAB Creation (E) --> <!--TAB Charge (S) -->
		<div id="tabLayer" style="display: none">

		<table class="search" id="mainTable">
			<tr>
				<td class="bg"><!-- Charge (S) -->

				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td width="45">TMNL</td>
						<td><input type="text" value="" class="input"
							style="width: 80;" name="tmnl_cd" maxlength="2"
							dataformat="engup" style="ime-mode:disabled"></td>
					</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table width="100%" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!-- 2 (E)--></div>
		<!--TAB Charge (E) --></td>
	</tr>
</table>

<!--Button (S) -->
<table width="100%" class="button" border="0" cellpadding="0"
	cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
	<tr>
		<td class="btn1_bg">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_retrieve">Retrieve</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
				<td>
				<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr>
						<td class="btn1_left"></td>
						<td class="btn1" name="btn_downexcel">Down Excel</td>
						<td class="btn1_right">
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!--Button (E) --> <!-- 개발자 작업  끝 --></form>
</body>
</html>