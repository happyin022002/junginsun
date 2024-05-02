<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0027.jsp
*@FileTitle : Ex Rate Update by Date or VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.08.26 최도순
* 1.0 Creation
*-------------------------------------------------------- 
* History
* 2012.03.21 권   민 [CHM-201216481] ONBOARD DATE 적용 개별환율 화주 일괄 업데이트 관련 개발 요청
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.event.FnsInv0027Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0027Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMgt.ARInvoiceCorrection");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (FnsInv0027Event)request.getAttribute("Event");
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
<title>Ex Rate Update by Date or VVD</title>
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
<input type="hidden" name="pagerows">
<input type="hidden" name="ofc">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="pagetype" value = "I">
<input type="hidden" name="cust_cnt_cd">
<input type="hidden" name="cust_seq">
<input type="hidden" name="backendjob_key">
<!-- 개발자 작업	-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
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
		<!--Page Title, Historical (E)--> <!--biz page (S)-->
		<table class="search">
			<tr>
				<td class="bg"><!-- biz_1  (S) -->
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">&nbsp;&nbsp;Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1,1);</script></td>
					</tr>
				</table>
				<table class="search_sm" border="0">
					<tr class="h23">
						<td width="100">&nbsp;&nbsp;Option</td>
						<td class="stm"><input type="radio" name="run_opt" value="N"
							class="trans" checked onClick="javascript:chkOption(this.value)">No
						Good&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="run_opt"
							value="V" class="trans"
							onClick="javascript:chkOption(this.value)">VVD&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="run_opt" value="C" class="trans"
							onClick="javascript:chkOption(this.value)">Customer&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="run_opt" value="B" class="trans"
							onClick="javascript:chkOption(this.value)">B/L&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="run_opt" value="O" class="trans"
							onClick="javascript:chkOption(this.value)">ON BOARD(Individual Ex.rate)&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="run_opt" value="P" class="trans"
							onClick="javascript:chkOption(this.value)">PERIOD & CHINA </td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0">
					<tr class="h23">
						<td width="100" id="dt_name">&nbsp;&nbsp;Interface Date</td>
						<td><input type="text" style="width: 80;" name="fm_if_dt"
							dataformat="ymd" cofield="to_if_dt"
							onBlur="fn_ComGetMaskedValue('fm_if_dt');" maxlength="10"
							onKeyUp="javascript:checkFmDtLeng(this.value)" class="input1">&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar1">&nbsp;&nbsp;~&nbsp;&nbsp;<input
							type="text" style="width: 80;" name="to_if_dt" dataformat="ymd"
							cofield="fm_if_dt" onBlur="fn_ComGetMaskedValue('to_if_dt');"
							maxlength="10" class="input1">&nbsp;&nbsp;<img
							class="cursor" src="img/btns_calendar.gif" width="19" height="20"
							border="0" align="absmiddle" name="btns_calendar2"></td>
						<td width="100">&nbsp;&nbsp;INV Cust</td>
						<td width=""><input type="text" style="width: 30;"
							class="input2" name="inv_cust_cnt_cd" onblur="fn_inv_cust_chg();checkOnBoardDateCust();"
							style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng(this.value)" disabled>&nbsp;<input
							type="text" style="width: 60;" name="inv_cust_seq"
							onblur="fn_inv_cust_chg();checkOnBoardDateCust();" 
							onKeyPress="javascript:checkOnBoardDateCust();"value="" maxlength="6"
							dataformat="num" class="input2" disabled><img
							class="cursor" src="img/btns_search.gif" name="btn_invcust"
							width="19" height="20" border="0" align="absmiddle">&nbsp;<input
							type="text" style="width: 300;" name="cust_lgl_eng_nm" value=""
							class="input2" readOnly>&nbsp;<img class="cursor"
							src="img/btns_search.gif" name="btn_custNm" width="19"
							height="20" border="0" align="absmiddle"></td>
					</tr>
				</table>
				<table class="line_bluedot">
					<tr>
						<td colspan="6"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="100">&nbsp;&nbsp;Bound</td>
						<td width="" style="padding-left: 2"><select
							style="width: 106;" class="input" name="io_bnd_cd" disabled>
							&nbsp;
							<option value="" selected>All</option>
							<option value="O">O/B</option>
							<option value="I">I/B</option>
						</select></td>
					</tr>
					<tr class="h23">
						<td width="100" valign="top">&nbsp;&nbsp;Local VVD</td>
						<td width="" style="padding-left: 2"><!--grid (S)-->
						<table width="31%" id="mainTable">
							<tr>
								<td width="100%"><script language="javascript">ComSheetObject('sheet1');</script>
								<script language="javascript">ComSheetObject('sheet2');</script>
								</td>
							</tr>
						</table>
						<!--grid (E)--></td>
					</tr>
					<table class="line_bluedot">
						<tr>
							<td colspan="6"></td>
						</tr>
					</table>
					<table class="search" border="0" style="width: 979;">
						<tr class="h23">
							<td width="100">&nbsp;&nbsp;B/L No</td>
							<td width="" style="padding-left: 2"><!--grid (S)-->
							<table width="31%" id="mainTable2">
								<tr>
									<td width="100%"><script language="javascript">ComSheetObject('sheet3');</script>
									<script language="javascript">ComSheetObject('sheet4');</script>
									</td>
								</tr>
							</table>
							<!--grid (E)--></td>
						</tr>
					</table>
					<table class="line_bluedot">
						<tr>
							<td colspan="6"></td>
						</tr>
					</table>
					<table class="search" border="0" style="width: 979;">
						<tr class="h23">
							<td width="100">&nbsp;&nbsp;Total Count</td>
							<td width=""><input type="text" style="width: 104;"
								name="tot_cnt" class="input2" readOnly></td>
						</tr>
						<tr class="h23">
							<td width="100">&nbsp;&nbsp;Good Count</td>
							<td width=""><input type="text" style="width: 104;"
								name="good_cnt" class="input2" readOnly></td>
						</tr>
						<tr class="h23">
							<td width="100">&nbsp;&nbsp;Nogood Count</td>
							<td width=""><input type="text" style="width: 104;"
								name="no_good_cnt" class="input2" readOnly></td>
						</tr>
					</table>	
					<table class="search" border="0" style="width: 979;">
						<tr class="h23">
							<td width="" style="padding-left: 2">
							<!--grid (S)-->
							<table width="100%" id="mainTable2">
								<tr>
									<td width="100%">
									<script language="javascript">ComSheetObject('sheet5');</script>
									</td>
								</tr>
							</table>
							<!--grid (E)-->
							</td>
						</tr>
					</table>				
				</td>
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
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_new">New</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td class="btn1_line"></td>
						<td>
						<table width="72" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_run">Run</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"	class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downexcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				<!--Button (E) --></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>