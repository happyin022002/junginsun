<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0033.jsp
*@FileTitle  : Reverse CSR for Sublet
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/17
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0033Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0033Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	//int rowCount	 = 0;						//Number of DB ResultSet List

	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";
	String strOfc_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutAccounting.tcharterioconsultation");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strOfc_cd = account.getOfc_cd();
		strOfc_nm = account.getOfc_eng_nm();

		event = (EsmFms0033Event)request.getAttribute("Event");
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

<input type="hidden" name="slp_tp_cd" value="20" id="slp_tp_cd" />
<input type="hidden" name="slp_func_cd" value="T" id="slp_func_cd" />
<input type="hidden" name="rqst_amt" id="rqst_amt" />
<input type="hidden" name="flet_ctrt_no" id="flet_ctrt_no" />
<input type="hidden" name="search_type" id="search_type" />
<input type="hidden" name="csr_type" value="AR" id="csr_type" />
<!-- Input Box for Report Designer -->
<input type="hidden" name="com_mrdPath" value="" id="com_mrdPath" />
<input type="hidden" name="com_mrdArguments" value="" id="com_mrdArguments" />
<input type="hidden" name="com_mrdTitle" value="Consultation Slip" id="com_mrdTitle" />
<input type="hidden" name="com_mrdBodyTitle" value="Consultation Slip" id="com_mrdBodyTitle" />
<input type="hidden" name="com_mrdSaveDialogFileExt" value="ppt" id="com_mrdSaveDialogFileExt" />
<input type="hidden" name="com_mrdSaveDialogFileExtLimit" value="xls@pdf@doc@ppt" id="com_mrdSaveDialogFileExtLimit" />
<input type="hidden" name="com_mrdSaveDialogFileName" value="Consultation Slip" id="com_mrdSaveDialogFileName" />
<input type="hidden" name="com_mrdSaveDialogDir" value="" id="com_mrdSaveDialogDir" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
<div class="opus_design_btn">
	<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!--
	--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_slip" id="btn_slip" type="button">Slip Inquiry</button><!--
	--><button class="btn_normal" name="btn_Print" id="btn_Print" type="button">Print</button><!--
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
				<col width="100" />	
				<col width="97" />				
				<col width="*" />										
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Condition</th>
					<td><input type="radio" name="btn_condition" value="" class="trans" checked><label>Invoice No.</label><input type="radio" name="btn_condition" value="" class="trans"><label>VVD No.</label></td>
		   			<td></td>
		   		</tr>
		   </tbody>
		</table>
		
		<table> 
			<colgroup>
				<col width="100" />
				<col width="260" />
				<col width="80" />
				<col width="100" />
				<col width="50" />
				<col width="107" />				
				<col width="*" />										
		   </colgroup> 
			<tr>
				<th>Invoice No.</th>
				<td><input type="text" name="to_inv_no" id="to_inv_no" style="width:103px;text-align:center;ime-mode:disabled" class="input1" maxlength="12" value="" dataformat="engup"  caption="Invoice No."><!-- 
				 --><button type="button" name="btn_invNo" id="btn_invNo"  class="input_seach_btn"></button></td>
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled" name="vvd_cd" id="vvd_cd" class="input2" maxlength="10" value="" dataformat="engup"  caption="VVD"></td>
				<td></td>
				<th>Currency</th>
				<td><input type="text" name="csr_curr_cd" id="csr_curr_cd" maxlength="3" style="width:40px;text-align:center;ime-mode:disabled" class="input1" value="USD" maxlength="3" required fullfill dataformat="engup"  caption="Currency"></td>
			</tr>
		</table>
		
		<table> 
			<colgroup>
				<col width="100" />
				<col width="100" />
				<col width="60" />
				<col width="100" />
				<col width="80" />
				<col width="150" />
				<col width="60" />				
				<col width="*" />										
		   </colgroup> 
			<tr>
				<th>Requested By</th>
				<td><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60px;text-align:center;" class="input2" value="" caption="Requested By" readonly></td>
				<th>CSR Date</th>
				<td><input type="text" name="slp_iss_dt" id="slp_iss_dt" style="width:80px;text-align:center;" class="input2" value="" readonly caption="CSR Date"></td>
				<th>Provided By</th>
				<td><input type="text" name="prov_by" id="prov_by" value="<%=strUsr_nm%>" style="width:190px;text-align:center;" class="input2" value="" caption="Provided By" readonly></td>
				<th>CSR No.</th>
				<td>&nbsp;&nbsp;<input type="text" name="csr_no" id="csr_no" style="width:160px;" class="input2" value="" caption="CSR No." readonly></td>
			</tr>
			</table>
			<table>
			 	<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tr>
					<th>Eff Date</th>
					<td><input type="text" name="eff_dt" dataformat="ymd" required  caption="Eff Date" style="width:80px;ime-mode:disabled;" class="input1" value=""><!-- 
					 --><button type="button" name="btn_effDt" id="btn_effDt"  class="calendar ir"></button></td>
				</tr>
			</table>
			<table>
				<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup> 
				<tr>
					<th>Description</th>
					<td><input type="text" name="csr_desc" style="width:488px;" class="input" value="" caption="Description"></td>
				</tr>
			</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid pad_top_8">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<!-- opus_design_data(S) -->
	<div style="width:100%; text-align:right;">	
		<table style="width:250px;float:right;">
			<tbody>	
			<colgroup>
			<col width="80"/>
			<col width="10"/>
			<col width="100"/>
			</colgroup> 	 
			<tr>				
				<th>Total Amount</th>
				<td></td>
				<td><input type="text" name="csr_amt" id="csr_amt" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
			</tr>
		</table>
	</div>
	
	<!-- opus_design_data(E) -->
</div>
</form>