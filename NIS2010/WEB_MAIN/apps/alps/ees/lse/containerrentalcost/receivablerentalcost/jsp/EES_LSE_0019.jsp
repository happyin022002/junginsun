<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0019.jsp
*@FileTitle : Receivable Charge & Invoice Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.26 장준우
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
<%@ page import="com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event.EesLse0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0019Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	String strQtyMonth	= "";
	String strOfc_cd	= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strOfc_cd  = account.getOfc_cd();
		strQtyMonth = EesLse0019Event.getCurrAddMonths("yyyy-MM", -1);

		event = (EesLse0019Event)request.getAttribute("Event");
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
<title>Receivable Invoice Creation</title>
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
<input type="hidden" name="invoice_no">
<input type="hidden" name="cost_yrmon">
<input type="hidden" name="rcv_rntl_seq">
<input type="hidden" name="inv_agmt_seq">
<input type="hidden" name="inv_lstm_cd">
<input type="hidden" name="com_mrdPath">
<input type="hidden" name="com_mrdArguments">
<input type="hidden" name="com_mrdTitle">
<input type="hidden" name="com_mrdBodyTitle">
<input type="hidden" name="usr_id" value="<%= strUsr_id %>">
<input type="hidden" name="ofc_cd" value="<%= strOfc_cd %>">
<input type="hidden" name="usd_xch_rt">
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
				<tr>
					<td class="btn1_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_retrieve">Retrieve</td>
											<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
								<td>
									<table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr>
											<td class="btn1_left"></td>
											<td class="btn1" name="btn_new">New</td>
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
		<!--biz page (S)-->
		<table class="search" id="mainTable">
       		<tr><td class="bg">


				<!--  biz  1(S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="110">Revenue Month</td>
					<td width="120"><input type="text" name="qty_yrmon" caption="Revenue Month" style="width:60;text-align:center;ime-mode:disabled;" class="input1" value="<%= strQtyMonth %>" maxlength="6" dataformat="ym" required fullfill>&nbsp;<img src="img/btns_calendar.gif" name="btns_calendar1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
					<td width="45">Term</td>
					<td width="100"><select name="lstm_cd" caption="Term" style="width:60;" class="input">
						<option value="" selected>All</option>
						<option value="SO">SO</option>
						<option value="MO">MO</option>
						</select></td>
					<td width="55">Lessee</td>
					<td width="">
						<input type="text" name="vndr_seq" caption="Lessee" style="width:60;text-align:center;" class="input" value="" maxlength="6" dataformat="int">
						<img class="cursor" src="img/btns_search.gif" name="btns_search1" width="19" height="20" border="0" align="absmiddle">
						<input type="text" name="vndr_abbr_nm" style="width:100;text-align:center;"  class="input2" value="" readonly>
						<input type="text" name="vndr_nm" style="width:300" class="input2" value="" readonly>
					</td>
					<!--
					<td width="121"><input type="checkbox" name="useful_chg" value="Y" class="trans">Useful Charge</td>
					-->
				</tr>
				</table>


       			<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->

				<table width="100%" class="button">
			       	<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0">
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_RowAdd">Row Add</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_Delete">Delete</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_preparation">Preparation</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_charge">Charge Creation</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				<!--
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_recharge">RE Creation</td>
					<td class="btn2_right"></td>
					</tr>
				</table></td>
				-->
				</table>
			</td></tr>
			</table>

			</td></tr>
					</table>
		<!--biz page (E)-->

			<table class="height_8"><tr><td></td></tr></table>
			<table class="search" id="mainTable">
       		<tr><td class="bg">
       			<table class="search" border="0"><tr><td>
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="125">&nbsp;Invoice No.</td>
						<td width="150"><input type="text" name="inv_no" style="width:122;text-align:center;" class="input2" value="" readonly></td>
						<td width="55">Lessee</td>
						<td width="243">
							<input type="text" name="inv_vndr_seq" style="width:60;text-align:center;" class="input2" value="" readonly>
							<input type="text" name="inv_vndr_abbr_nm" style="width:150" class="input2" value="" readonly>
						</td>
						<td width="75">Customer</td>
						<td width="">
							<input name="cust_cnt_cd" type="text" style="width:30;text-align:left" class="input2" value="" maxlength="2" dataformat="engup" readonly>
							<input name="cust_seq" type="text" style="width:62;text-align:left" class="input2" maxlength="6" class="input" value="" dataformat="int" readonly>
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust1">
							<input name="cust_nm" type="text" style="width:183;" class="input2" value="" readonly>
							<img class="cursor" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btns_cust2"></td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="125">&nbsp;Invoice Amount</td>
						<td width="150">
							<input type="text" name="fm_chg_amt" style="width:83;text-align:right" class="input2" value="" readonly tabIndex="-1">
							<input type="text" name="fm_curr_cd" style="width:35;text-align:center" class="input2" value="" readonly tabIndex="-1">
						</td>
						<td width="55">Ex, Rate</td>
						<td width="185">
							<select name="to_curr_cd" caption="Currency" style="width:60;" class="input2">
								<!--
								<option value="" selected>&nbsp;</option>
								<option value="KRW">KRW</option>
								<option value="EUR">EUR</option>
								<option value="USD">USD</option>
								-->
							</select>
							<input type="text" caption="Ex, Rate" name="to_curr_rt" style="width:99;text-align:right" class="input2" value="" dataformat="float" maxlength="11" pointcount="3" maxnum="9999999.999" readonly>
							<%--
							<input type="text" caption="Currency" name="to_curr_cd" style="width:35;text-align:center" class="input2" value="" maxlength="3" dataformat="engup" readonly>
							<img class="cursor" name="btns_search2" src="img/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
							--%>
						</td>
						<td width="133">Receivable Amount</td>
						<td width="145">
							<input type="text" name="to_chg_amt" style="width:120;text-align:right" class="input2" value="" readonly tabIndex="-1">
						</td>
						<td width="35">Tax</td>
						<td width="">
							<select name="locl_tax_flg" style="width:50">
								<option value="N" selected>&nbsp;0%</option>
								<option value="Y">10%</option>
		                    </select>
							<input name="tax_amount" type="text" style="width:95;text-align:right" class="input2" value="" readonly tabIndex="-1">
						</td>
					</tr>
					</table>
					<table class="search" border="0" style="width:979;">
					<tr class="h23">
						<td width="125">&nbsp;Invoice Issue Date</td>
						<td width="150"><input type="text" name="inv_isu_dt" caption="Invoice Issue Date" style="width:99;text-align:center;" class="input2" value="" maxlength="8" dataformat="ymd" fullfill readonly>&nbsp;<img class="cursor" name="btns_calendar2" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="119">Invoice Due Date</td>
						<td width="215"><input type="text" name="inv_due_dt" caption="Invoice Due Date" style="width:99;text-align:center;" class="input2" value="" maxlength="8" dataformat="ymd" fullfill readonly>&nbsp;<img class="cursor" name="btns_calendar3" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
						<td width="162">TTL. Receivable Amount</td>
						<td width="">
							<input type="text" name="ttl_chg_amt" style="width:157;text-align:right" class="input2" value="" readonly tabIndex="-1">
							<input type="text" name="ttl_curr_cd" style="width:45;text-align:center" class="input2" value="" readonly tabIndex="-1">
						</td>
					</tr>
					</table>
				</td></tr></table>
				<table class="height_8"><tr><td></td></tr></table>

				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>
				<!-- Grid  (E) -->

			<!--  Button_Sub (S) -->
			<table width="100%" class="button">
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_cntr">CNTR List</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_downexcel">Down Excel</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_invoice">Invoice Creation</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_confirm">Invoice Confirm</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn2_left"></td>
					<td class="btn2" name="btn_print">Invoice Print</td>
					<td class="btn2_right"></td>
					</tr>
					</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
<!-- : ( Search Options ) (E) -->
			<script language="javascript">ComSheetObject('sheet3');</script>
			</td></tr>
		</table>
	<!-- Tab BG Box  (S) -->

	<!--biz page (E)-->
	</td></tr>
</table>
	</td></tr>
</table>
<table class="height_10"><tr><td></td></tr></table>
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>