<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0045.jsp
*@FileTitle  : Sublet Revenue Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/19
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0045Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmFms0045Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	//int rowCount	 = 0;						//Number of DB ResultSet List

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmFms0045Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="to_inv_no" id="to_inv_no" />
<input type="hidden" name="csr_no" id="csr_no" value=""/>

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
	--></div>
<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="76" />
				<col width="220" />
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th><strong>Condition</strong></th>
					<td><input type="radio" name="btn_condition" value="" class="trans" checked id="btn_condition" /><label for = "btn_condition">Vessel</label><!-- 
								    --><input type="radio" name="btn_condition" value="" class="trans" id="btn_condition" /><label for = "btn_condition">VVD</label><!-- 
								    --><input type="radio" name="btn_condition" value="" class="trans" id="btn_condition" /><label for = "btn_condition">Invoice No.</label></td>
					<td></td>
		   		</tr>
		   </tbody>
		</table>
		<table class="search" >
			<colgroup>
				<col width="76" />
				<col width="270" />
				<col width="80" />
				<col width="200" />
				<col width="90" />
				<col width="*" />				
		   </colgroup>  
			<tr>
				<th>Vessel Code</th>
				<td><input type="text" onchange="vsl_cd_change()" dataformat="engup" name="vsl_cd" id="vsl_cd" style="width:54px;text-align:center;ime-mode:disabled" class="input1" maxlength="4"   fullfill caption="Vessel Code"><!--
				--><button type="button" id="btn_vslCd" name="btn_vslCd" class="input_seach_btn"></button><!--
				--><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width:140px;" class="input2" readonly></td>
				<th>Contract No.</th>
				<td><input type="text" name="flet_ctrt_no" style="width:120px;text-align:center;" class="input2" value=""  caption="Contract No."  readonly="readonly" id="flet_ctrt_no" /><button type="button" id="btn_fletCtrtNo" name="btn_fletCtrtNo" class="input_seach_btn"></button></td>
				<th>Contract Type</th>
				<td><input type="text" name="flet_ctrt_tp_nm" style="width:70px;" class="input2" value="" caption="Contract Type" readonly id="flet_ctrt_tp_nm" /> </td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="76" />
				<col width="270" />
				<col width="80" />
				<col width="*" />
			</colgroup> 
			<tr>
				<th>VVD </th>
				<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled" dataformat="engup" name="vvd_cd" class="input2" maxlength="10" value="" fullfill caption="VVD" id="vvd_cd" /> </td>
				<th>Invoice No.</th>
				<td><input type="text" name="to_inv_no1" style="width:100px;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="12" class="input2" value="" fullfill  caption="Invoice No." id="to_inv_no1" /> </td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<h3 class="title_design">Inquiry Result List</h3>
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<h3 class="title_design">Sublet Revenue Detail Inquiry</h3>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<!-- opus_design_data(S) -->
		<div style="width:100%; text-align:right;">	
			<table style="width:250px;float:right;">
				<colgroup>
					<col width="100" />
					<col width="10" />
					<col width="180" />
				</colgroup>	
				<tr>
					<th align="right">Total Amount </th>
					<td></td>
					<td><input type="text" name="curr_cd" style="width:50px;text-align:center;" class="tr_head3" value="" readonly id="curr_cd" /><input type="text" name="csr_amt" style="width:100px;text-align:right;" class="tr_head3" value="" readonly id="csr_amt" /> </td>
				</tr>
			</table>
		</div>
		<!-- opus_design_data(E) -->
	</div>
</div>
</form>