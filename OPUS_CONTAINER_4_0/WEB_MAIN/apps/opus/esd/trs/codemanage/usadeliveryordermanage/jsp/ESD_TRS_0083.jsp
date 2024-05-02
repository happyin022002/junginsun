<%
	/*=========================================================
	 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
	 *@FileName   : ESD_TRS_0083.jsp
	 *@FileTitle  :  US D/O Input
	 *@author     : CLT
	 *@version    : 1.0 
	 *@since      : 2014/06/05
	 =========================================================*/
%>
<%@page import="com.clt.framework.component.message.ErrorHandler"%>
<%@page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@page import="com.clt.apps.opus.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	EsdTrs0083Event event = null; 
	Exception serverException = null;
	DBRowSet rowSet = null; 
	String strErrMsg = "";
	int rowCount = 0;
	SignOnUserAccount account = null;
	try {
		account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0083Event) request.getAttribute("Event");

		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>

<head>
<title>US D/O Input</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
  function setupPage(){
    var errMessage = "<%=strErrMsg%>";
    if (errMessage.length >= 1) {
      ComShowMessage(errMessage);
    }
    loadPage();
  }
</script>
</head>
<form method="post" name="form" onSubmit="return false;">
	<input type="hidden" name="f_cmd"> 
	<input type="hidden" name="localDate"> 
	<input type="hidden" name="form_cre_usr_id" value="<%=account.getUsr_id()%>"> 
	<input type="hidden" name="form_usr_ofc_cd" value="<%=account.getOfc_cd()%>">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title">
			<button type="button">
				<span id="title"></span>
			</button>
		</h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
	</div>

	<!-- page_title_area(E) -->

	<div id="MiniLayer" style="display: inline">
		<!-- wrap_search(S) -->
		<div class="wrap_search">
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<colgroup>
						<col width="110">
						<col width="200">
						<col width="90">
						<col width="200">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Bill Of Lading No.</th>
							<td><input name="bill_no" type="text" style="width: 100" dataformat="engup"><button type="button" name="btns_multibillno" id="btns_multibillno" class="multiple_inq ir"></button></td>
							<th>Booking No.</th>
							<td><input name="booking_no" type="text" style="width: 100" dataformat="engup"><button type="button" name="btns_multibookingno" id="btns_multibookingno" class="multiple_inq ir"></button></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<div class="opus_design_inquiry wFit">
				<table class="search_in">
					<colgroup>
						<col width="110">
						<col width="102">
						<col width="102">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Customer</th>
						<td><input type="text" name="cust_cnt_cd" style="width: 100" value="" dataformat="engup"></td>
						<td><input type="text" name="cust_seq" style="width: 100" value="" dataformat="engup"></td>
						<td><input type="text" name="cust_nm" value="" dataformat="engup" otherchar=" "><button type="button" name="btns_consignee" id="btns_consignee" class="input_seach_btn"></button></td>
					</tr>
					<tr class="h23">
						<th>Address</th>
						<td colspan="3"><input type="text" name="address" style="width: 100%" value=""></td>
					</tr>
				</table>
				<table class="search_in">
					<colgroup>
						<col width="110">
						<col width="200">
						<col width="90">
						<col width="200">
						<col width="50">
						<col width="*">
					</colgroup>
					<tr class="h23">
						<th>Zip Code</th>
						<td><input type="text" name="zip_code" style="width: 100" value="" dataformat="engup"></td>
						<th>Door Location</th>
						<td><input name="dor_loc_cd" type="text" style="width: 100" value="" dataformat="engup"></td>
						<th>Zone</th>
						<td><input name="zone_cd" type="text" style="width: 100" value="" dataformat="engup"></td>
					</tr>
					<tr class="h23">
						<th>Person In Charge</th>
						<td><input type="text" name="pic" style="width: 100" value="" dataformat="engup" otherchar=" "></td>
						<th>Telephone</th>
						<td><input type="text" name="tel" style="width: 100" value="" dataformat="engup"></td>
						<th>Fax.</th>
						<td><input type="text" name="fax" style="width: 100" value="" dataformat="engup"></td>
					</tr>
					<tr class="h23">
						<th>Remark</th>
						<td colspan="6"><input type="text" name="remark" style="width: 100%" value=""></td>
					</tr>
				</table>
			</div>
			<!-- opus_design_inquiry (E) -->
		</div>
		<!-- wrap_search(E) -->
	</div>
	<!-- wrap_result(S) -->
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">

			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<!-- Content -->
				<button type="button" class="btn_normal" name="btn_apply" id="btn_apply">Apply</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_socreation" id="btn_socreation">Save</button>
			</div>
			<!-- opus_design_btn(e) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->

		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hiddenTable">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
		<!-- opus_design_grid(E) -->

		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="hidden Table3">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
	<!-- wrap_result(E) -->
	<div class="header_fixed"></div>
</form>