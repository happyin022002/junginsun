<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : STM_SAP_0241.jsp
*@FileTitle  : Prepayment Invoice Entry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.event.StmSap0241Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.bizcommon.util.BizComUtil"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>

<%
    StmSap0241Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	List<String> rhqOfcList = null;
	Logger log = Logger.getLogger("com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice");

	String inv_seq = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("inv_seq")));
	String point = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("point")));
	String f_curr = JSPUtil.getNull(StringUtil.xssFilter(request.getParameter("f_curr")));

	String sysCurrdate = JSPUtil.getKST("yyyy-MM-dd");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (StmSap0241Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

<%=BizComUtil.getIBCodeCombo("curr", "", "CURR", 2, "")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="hid_inv_seq" value="<%=inv_seq%>" id="hid_inv_seq" />
<input type="hidden" name="hid_point" value="<%=point%>" id="hid_point" />
<input type="hidden" name="sys_curr_date" value="<%=sysCurrdate%>" id="sys_curr_date" />
<input type="hidden" name="f_curr" value="<%=f_curr%>" id="f_curr" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Prepayment Apply/Unapply Invoices</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><button type="button" class="btn_normal" name="btn_close" 	id="btn_close">Close</button><!--
			-->
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40">
					<col width="760">
					<col width="200">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>CSR No.</th>
						<td><input type="text" style="width:150px;" class="input2" name="csr_no" readonly id="csr_no" /></td>
						<th>Prepayment Amount</th>
						<td><input type="text" style="width:150px;text-align:right; background-color: rgb(247, 225, 236)" class="tr_head3" name="prepay_amt" readonly id="prepay_amt" /></td>
					</tr>
					<tr>
						<th>Supplier </th>
						<td><input type="text" style="width:80px;text-align:center;" class="input2" name="vndr_no" readonly id="vndr_no" /><input type="text" style="width:250px;text-align:left;" class="input2" name="vndr_nm" readonly id="vndr_nm" /></td>
						<th>Prepayment Amount Remaining</th>
						<td><input type="text" style="width:150px;text-align:right; background-color: rgb(247, 225, 236)" class="tr_head3" name="remain_amt" readonly id="remain_amt" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hiddenTable" style="display:none">		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_apply" id="btn_apply" type="button">Apply</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(S) -->
	<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable">
		<h3 class="title_design mar_btm_8 mar_top_8">Existing Prepayment Applications</h3>
		<div class="opus_design_btn">
			<button class="btn_normal" name="btn_unapply" id="btn_unapply" type="button">Unapply</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(S) -->
</div>
</div>
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>