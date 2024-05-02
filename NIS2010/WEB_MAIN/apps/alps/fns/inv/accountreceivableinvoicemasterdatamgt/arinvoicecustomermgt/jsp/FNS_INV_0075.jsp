<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0074.jsp
*@FileTitle : (Korea)Security Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.09.25 최도순
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
<%@ page import="com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0075Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	FnsInv0075Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.AccountReceivableInvoiceMasterDataMgt.ARInvoiceCustomerMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (FnsInv0075Event)request.getAttribute("Event");
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
<title>(Korea)Security Inquiry</title>
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
<input type="hidden" name="ofc_cd">
<input type="hidden" name="ofc">
<input type="hidden" name="pagetype" value = "I">
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0"
	style="padding-top: 2; padding-left: 5;">

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

						<td width="110">Kind of Security</td>
						<td width="190"><select style="width: 150;" class="input1"
							name="cust_scr_div_cd">
							<option value="" selected>A: ALL</option>
							<option value="C">C : Credit Insurance</option>
							<option value="J">J : Joint Guarantee</option>
							<option value="B">B : Bill</option>
							<option value="G">G : Bank Guarantee</option>
							<option value="R">R : Real Estate</option>
							<option value="O">O : Other(s)</option>
							<option value="P">P : Profit Bond</option>
							<option value="S">S : Security All</option>
							<option value="N">N : Non - Security</option>
						</select></td>
						<td width="67">CRD Term</td>
						<td width="200" class="stm">O/B&nbsp;<input type="text"
							style="width: 60;" class="input1" name="fm_ob_term"
							value="-999"
							onKeyPress="ComKeyOnlyNumber(this, '-')"> - <input
							type="text" style="width: 60;" class="input1" name="to_ob_term"
							value="999"
							onKeyPress="ComKeyOnlyNumber(this, '-')"></td>
						<td width="200" class="stm">I/B&nbsp;<input type="text"
							style="width: 60;" class="input1" name="fm_ib_term"
							value="-999"
							onKeyPress="ComKeyOnlyNumber(this, '-')"> - <input
							type="text" style="width: 60;" class="input1" name="to_ib_term"
							value="999"
							onKeyPress="ComKeyOnlyNumber(this, '-')"></td>

						<td width="50">Office</td>
						<td width=""><script language="javascript">ComComboObject('ar_ofc_cd', 1, 100, 1, 1);</script></td>
					</tr>
				</table>
				<table class="search" border="0" style="width: 979;">
					<tr class="h23">
						<td width="110">Customer Code</td>
						<td width="400"><input type="text" style="width: 30;"
							class="input" name="cust_cnt_cd" onblur="fn_cust_chg();"
							style="ime-mode:disabled"
							onKeyPress="ComKeyOnlyAlphabet('upper')" maxlength="2"
							onKeyUp="javascript:checkCustLeng(this.value)">&nbsp;<input
							type="text" style="width: 65;" class="input" name="cust_seq"
							onblur="fn_cust_chg();" value="" maxlength="6" dataformat="num">&nbsp;<img
							src="img/btns_search.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_actcust">&nbsp;<input
							type="text" style="width: 242;" class="input2"
							name="cust_lgl_eng_nm">&nbsp;<img
							src="img/btns_search.gif" width="19" height="20" alt=""
							border="0" align="absmiddle" class="cursor" name="btn_custNm"></td>
						<td width="">

						<table class="search_sm" border="0" style="width: 428;">
							<tr class="h23">
								<td width="110">Security Period</td>
								<td width="" class="stm">&nbsp;From&nbsp;&nbsp;<input
									type="text" style="width: 85" class="input" name="fm_dt"
									onBlur="fn_ComGetMaskedValue('fm_dt');" dataformat="ymd"
									onKeyUp="javascript:checkFmDtLeng(this.value)">&nbsp;<img
									class="cursor" src="img/btns_calendar.gif" width="19"
									height="20" border="0" align="absmiddle" name="btns_calendar1">&nbsp;~&nbsp;&nbsp;To&nbsp;&nbsp;<input
									type="text" style="width: 85" class="input" name="to_dt"
									onBlur="fn_ComGetMaskedValue('to_dt');" dataformat="ymd">&nbsp;<img
									class="cursor" src="img/btns_calendar.gif" width="19"
									height="20" border="0" align="absmiddle" name="btns_calendar2"></td>
							</tr>
						</table>

						</td>

					</tr>
				</table>



				<table class="line_bluedot">
					<tr>
						<td></td>
					</tr>
				</table>


				<!-- Grid (S) -->
				<table width="100%" class="search" id="mainTable">
					<tr>
						<td width="100%"><script language="javascript">ComSheetObject('sheet');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) --></td>
			</tr>
		</table>
		<!-- Tab BG Box(E) --> <!--biz page (E)--> <!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0"
			cellspacing="0" style="padding-top: 5; , padding-bottom: 10;">
			<tr>
				<td class="btn1_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_retrieve">Retrieve</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
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
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_downExcel">Down Excel</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
		<!--Button (E) -->
		</td>
	</tr>
</table>
		<!-- 개발자 작업  끝 -->
</form>
</body>
</html>