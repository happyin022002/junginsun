<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0032.jsp
*@FileTitle  : Sublet Revenue
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
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0032Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0032Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmFms0032Event)request.getAttribute("Event");
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

<head>
<title>Sublet Revenue</title>

<script type="text/javascript">
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="slp_tp_cd" value="20" id="slp_tp_cd" />
<input type="hidden" name="slp_func_cd" value="T" id="slp_func_cd" />
<input type="hidden" name="slp_iss_dt" id="slp_iss_dt" />
<input type="hidden" name="rqst_amt" id="rqst_amt" />
<input type="hidden" name="csr_type" value="AR" id="csr_type" />
<input type="hidden" name="tot_hire_amt" id="tot_hire_amt" />
<input type="hidden" name="tot_bnk_amt" id="tot_bnk_amt" />
<input type="hidden" name="param_flet_ctrt_tp_cd" id="param_flet_ctrt_tp_cd" />
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
	<button class="btn_accent" name="btn_new" id="btn_new" type="button">New</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_slip" id="btn_slip" type="button">Slip&nbsp;Inquiry</button><!--
	--><button class="btn_normal" name="btn_print" id="btn_print" type="button">Print</button><!--
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
				<col width="200" />				
				<col width="85" />				
				<col width="260" />				
				<col width="90" />
				<col width="105" />
				<col width="45" />				
				<col width="*" />				
		   </colgroup> 
		   		<tr>
		   			<th>Vessel Code</th>
					<td><input type="text" name="vsl_cd" style="width:54px;text-align:center;ime-mode:disabled" class="input1" maxlength="4" required fullfill caption="Vessel Code" dataformat="engup"><!-- 
					 --><button type="button" name="btn_vslCd" id="btn_vslCd"  class="input_seach_btn"></button><!-- 
					  --><input type="text" name="vsl_eng_nm" style="width:140px;" class="input2" readonly></td>
					<th>Contract No.</th>
					<td><input type="text" name="flet_ctrt_no" style="width:120px;text-align:center;" class="input2" value="" required caption="Contract No." readonly><!-- 
					 --><button type="button" name="btn_fletCtrtNo" id="btn_fletCtrtNo"  class="input_seach_btn"></button></td>
					<th>Contract Type</th>
					<td><input type="text" name="flet_ctrt_tp_nm" style="width:70px;" class="input2" value="" caption="Contract Type" readonly></td>
					<th>Currency</th>   
					<td><input type="text" name="csr_curr_cd" maxlength="3" style="width:40px;text-align:center;ime-mode:disabled"  dataformat="enguponly" class="input1" value="USD" maxlength="3" required fullfill caption="Currency"></td>
		   		</tr>
		   		<tr>
					<th>Requested By</th>
					<td><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60px;text-align:center;" class="input2" value="" caption="Requested By" readonly></td> 
					<th>Provided By</th>
					<td><input type="text" name="prov_by" value="<%=strUsr_nm%>" style="width:190px;text-align:center;" class="input2" value="" caption="Provided By" readonly></td> 
					<th>CSR No.</th>
					<td colspan="3"><input type="text" name="csr_no" style="width:160px;" class="input2" value="" caption="CSR No." readonly></td>		   			
		   		</tr>
	   		<tr>
	   			<th>Description</th>
				<td colspan="7"><input type="text" name="csr_desc" style="width:515px;" class="input1" value="" caption="Description"></td>
	   		</tr>
	   		<tr class="h23">
				<th title="Vessel Voyage Direction">VVD</th>
				<td><input type="text" style="width:100px;text-align:center;ime-mode:disabled" name="vvd_cd" class="input1" maxlength="10" dataformat="engup" value="" required fullfill caption="VVD"></td>
				<th>Eff Date</th>
				<td colspan="7"><input type="text" name="eff_dt" id="eff_dt" dataformat="ymd" required caption="Eff Date" style="width:80px;ime-mode:disabled;" class="input1" value=""><!-- 
				 --><button type="button" name="btn_effDt" id="btn_effDt"  class="calendar ir"></button></td>
			</tr>
		</table>
		
		<table>
			<colgroup>
				<col width="100" />				
				<col width="*" />										
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Owner Code</th>
					<td><input type="text" style="width:30px;text-align:center;" class="input2" name="ownr_cd" required caption="Owner Code" readonly><!-- 
					 --><input type="text" style="width:66px;text-align:center;" class="input2" name="ownr_seq" required caption="Owner Code" readonly><!-- 
					  --><input type="text" style="width:410px;" class="input2" name="ownr_nm" required caption="Owner Code" readonly>
					</td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_hire" id="btn_hire" type="button">Hire Revenue</button><!--
			--><button class="btn_normal" name="btn_bodBor" id="btn_bodBor" type="button">BOD/BOR</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->

	<!-- <table class="line_bluedot"><tr><td colspan="6"></td></tr></table> -->
	<!-- opus_design_data(S) -->
	<div style="width:100%; text-align:right;">	
			<table style="width:440px;float:right;"> 
			<tbody>	
			<colgroup>
			<col width="80px"/>
			<col width="5px"/>
			<col width="355px"/>
			</colgroup>
			<tr class="h23">
				<th>Total Amount</th>
				<td></td>
				<td><input type="text" style="width:50px;text-align:center" class="tr_head3" value="DR" readonly><!-- 
				 --><input type="text" name="dr_amt" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly><!-- 
				 --><input type="text" style="width:50px;text-align:center" class="tr_head3" value="CR" readonly><!-- 
				 --><input type="text" name="cr_amt" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
			</tr>
			</tbody>
		</table>
	</div>
</div>	
</form>
