<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_TRS_0030.jsp
*@FileTitle  : Invoice Inquiry - Correction(Service Provider from the W / O after running a batch Confirm Invoice for payment or, Confirmed or Interfaced Invoice screen to cancel the)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event"%>

<%
	EsdTrs0030Event  event = null;
	Exception serverException   = null;
	DBRowSet rowSet	  = null;
	String strErrMsg = "";
	int rowCount	 = 0;
	SignOnUserAccount account= null;
	try {
	  	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		event = (EsdTrs0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception e) {
		out.println(e.toString());
	}
	String today = DateTime.getFormatString("yyyyMMdd");
	String beforeOneMonth = DateTime.addMonths(today, -1);
	String dateCD = JSPUtil.getCodeCombo("date_cd", "01", "style='width:110'", "CD01475", 0, "");
	String statusCD = JSPUtil.getCodeCombo("status_cd", "01", "style='width:176'", "CD00824", 0, "000030:ALL:ALL");
	String holdCD = JSPUtil.getCodeCombo("hold_cd", "01", "style='width:79'", "CD00912", 0, "000030:ALL:ALL");
	String amountVeryfyCD = JSPUtil.getCodeCombo("amount_verify_cd", "01", "style='width:279'", "CD00927", 0, "000030:ALL:ALL");
%>

<script type="text/javascript">
	var beforeOneMonth = '<%=beforeOneMonth%>';
	var today = '<%=today%>';
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		}
		loadPage();
	}
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="iPage" id="iPage" />
<input type="hidden" name="old_ofc_cd" value="<%=account.getOfc_cd()%>" id="old_ofc_cd" />
<input type="hidden" name="FORM_CRE_USR_ID" value="<%=account.getUsr_id()%>" id="FORM_CRE_USR_ID" />
<input type="hidden" name="FORM_USR_OFC_CD" value="<%=account.getOfc_cd()%>" id="FORM_USR_OFC_CD" />
<input type="hidden" name="INV_CRE_OFC_CD" id="INV_CRE_OFC_CD" />
<input type="hidden" name="FORM_INV_NO" id="FORM_INV_NO" />
<input type="hidden" name="FORM_INV_VNDR_SEQ" id="FORM_INV_VNDR_SEQ" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		 --> <button type="button" class="btn_normal" name="btn_reset" id="btn_reset">Reset</button><!--
		 --> <button type="button" class="btn_normal" name="btn_minimize" id="btn_minimize">Minimize</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
	<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->

<div id="MiniLayer" style="display:inline">
<!-- wrap_search(S) -->  
<div class="wrap_search">
	<!-- opus_design_inquiry (S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="54">
				<col width="330">
				<col width="215">
				<col width="150">
				<col width="50">
				<col width="55">
				<col width="90">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Date</th>
				<td><%=dateCD%>
					<input type="text" maxlength="8" style="width:75px" name='fmdate' dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);"> ~ <!-- 
					 --><input type="text" maxlength="8" style="width:75px" name='todate' dataformat="ymd" onfocus="javascript:delHypen(this);" onblur="javascript:getHypen(this);"><!-- 
					 --><button type="button" name="btns_calendar" id="btns_calendar"  class="calendar ir"></button>
				</td>
				<th>Status</th>
				<td><%=statusCD%></td>
				<th>Hold</th>
				<td><%=holdCD%></td>
				<th>Invoice Type</th>
				<td>
					<select name="inv_tp_cd" id="inv_tp_cd" style="width:120px">
						<option value="A">ALL</option>
						<option value="C">Common</option>
						<option value="R">Refund/DC</option>
						<option value="P">Pool CHZ Repo.</option>
					</select>
				</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="54">
				<col width="448">
				<col width="90">
				<col width="450">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Amount</th>
				<td><%=amountVeryfyCD%></td>
				<th>Service Provider</th>
				<td class="sm"> <input type="radio" class="trans" name='sp_tp' value='wo' checked> Work Order <!-- 
				 --><input type="radio" name='sp_tp' value='py'class="trans"> Payment <!-- 
				 --> <input type='text' name='combo_svc_provider' style="width:77px; margin-left:5px" onChange='getTextVendorSeq(sheetObjects[0], document.form, this.value)' onKeyup='enterCheck(this)' dataformat="engup"><!-- 
				 --><input name='svc_provider' ReadOnly class="input2" type="text" style="width:200px;"></td><td></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="54">
				<col width="380">
				<col width="160">
				<col width="200">
				<col width="180">
				<col width="*">
			</colgroup>
			<tr class="h23">
				<th>Number</th>
				<td class="sm"><input type="radio" name='no_tp' value='iv' class="trans" onchange="funcRadioOnChange(this)" checked > Invoice 
					<input type="radio" name='no_tp' value='csr' class="trans" onchange="funcRadioOnChange(this)" > CSR 
					<input type="radio" name='no_tp' value='reference' class="trans" onchange="funcRadioOnChange(this)" > Reference 
					<input name="no_cd" id="no_cd" type="text" onKeyup='enterCheck(this)' style="width:167px; margin-left:5px" dataformat="engupetc" dataformat="engup" otherchar=","><!-- 
			   		--><button type="button" name="btns_no_cd" id="btns_no_cd" class="multiple_inq ir"></button></td>
				<th>Invoice Creation Office</th>
				<td class="sm"><input name="inv_cre_ofc" type="text" style="width:79px;" value='<%=account.getOfc_cd()%>' onBlur='value_upper(this)' onKeyup='enterCheck(this)' dataformat="engup" otherchar=","><!-- 
				 --><button type="button" name="btns_ofc_cd" id="btns_ofc_cd"  class="multiple_inq ir"></button> <!-- 
				  --><input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();"> Incl. Sub OFC</td> 
				<th>Invoice Creation User ID</th>
				<td><input name="ivc_cre_usr_id" type="text" style="width:85px ;" maxlength='10' onKeyup='enterCheck(this)' dataformat="eng"></td>
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
		<button type="button" class="btn_normal" name="btng_downexcel1" id="btng_downexcel1">Down In Excel(1)</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_downexcel2" id="btng_downexcel2">Down In Excel(2)</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_MasterInvoiceCreation" id="btng_MasterInvoiceCreation">Master Invoice Creation(Print)</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_detailinquiry" id="btng_detailinquiry">Detail Inquiry</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_holdsave" id="btng_holdsave">Hold Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_invoicedelete" id="btng_invoicedelete">Invoice Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_invaudit" id="btng_invaudit">Invoice Audit</button><!-- 
		 --><button type="button" class="btn_normal" name="btng_invconfrimcancel" id="btng_invconfrimcancel">Invoice Confirm Cancel</button>
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

 
</div>
<!-- wrap_result(E) -->  
<div class="header_fixed"></div>

</form>
<form method="post" name="inv_form" action='ESD_TRS_0033_POP.do' onSubmit="return false;">
	<input	type="hidden" name="inv_no">
	<input	type="hidden" name="inv_vndr_seq">
	<input	type="hidden" name="inv_vndr_nm">
	<input	type="hidden" name="mode">
	<input	type="hidden" name="sysCommUiTitle" value="Audit &amp; Confirm">
	<input	type="hidden" name="sysCommUiNavigation" value="Trans S/O > Invoice">
	<input  type="hidden" name="if_sys_knd_cd_param">
	<input  type="hidden" name="pgmNo" value='ESD_TRS_0033'>
	<input  type="hidden" name="parentPgmNo" value='ESD_TRS_M001'>
	<input  type="hidden" name="mainPage" value='false'>
</form>
<form method="post" name="esd_030rd_form" action='ESD_TRS_0208.do' onSubmit="return false;">
<input	type="hidden" name="queryStr">
</form>
</body>
</html>
