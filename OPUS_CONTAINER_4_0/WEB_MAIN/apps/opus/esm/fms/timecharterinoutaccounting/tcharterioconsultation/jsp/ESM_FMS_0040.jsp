<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_fms_0040.jsp
*@FileTitle  : Manual Slip
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
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0040Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms0040Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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

		event = (EsmFms0040Event)request.getAttribute("Event");
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
<input type="hidden" name="slp_tp_cd" value="07" id="slp_tp_cd" />
<input type="hidden" name="csr_amt" id="csr_amt" />
<input type="hidden" name="rqst_amt" id="rqst_amt" />
<input type="hidden" name="csr_type" value="AP" id="csr_type" />
<!-- NYK Modify 2014.11.05 -->
<input type="hidden" name="ap_ctr_cd" id="ap_ctr_cd" />
<input type="hidden" name="loc_cd" id="loc_cd" />
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
		<button class="btn_accent" name="btn_New" id="btn_New" type="button">New</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_TaxEvidence" id="btn_TaxEvidence" type="button" style="display:none;">Tax Evidence</button><!--
		--><button class="btn_normal" name="btn_SlipInquiry" id="btn_SlipInquiry" type="button">Slip Inquiry</button><!--
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
	<div class="opus_design_inquiry wFit mar_top_4">
		<table>
			<colgroup>
				<col width="90" />				
				<col width="90" />				
				<col width="60" />				
				<col width="100" />				
				<col width="80" />				
				<col width="150" />				
				<col width="75" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Requested By</th>
					<td><input type="text" name="slp_ofc_cd" value="<%=strOfc_cd%>" style="width:60px;text-align:center;" class="input2" caption="Requested By" readonly id="slp_ofc_cd" /> </td>
					<th>CSR Date</th>
					<td><input type="text" name="slp_iss_dt" style="width:80px;text-align:center;" class="input2" value="" readonly caption="CSR Date" id="slp_iss_dt" /> </td>
					<th>Provided By</th>
					<td><input type="text" name="prov_by" value="<%=strUsr_nm%>" style="width:120px;text-align:center;" class="input2" caption="Provided By" readonly id="prov_by" /> </td>
					<th>CSR No.</th>
					<td><input type="text" name="csr_no" style="width:150px;" class="input2" value="" caption="CSR No." readonly id="csr_no" /> </td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="90" />				
				<col width="480" />				
				<col width="75" />				
				<col width="*" />				
		   </colgroup>  
			<tr>
				<th>Description</th>
				<td><input type="text" name="csr_desc" style="width:448px;" class="input1" value="" required="" caption="Description" maxlength="500" id="csr_desc" /> </td>
				<th>Slip Type</th>
				<td><select style="width:150px;" class="input1" name="slp_func_cd"></select></td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="480" />				
				<col width="75" />				
				<col width="130" />				
				<col width="80" />				
				<col width="*" />				
		   </colgroup>  
			<tr>
				<th>Tax Type</th>
				<td><input type="hidden" name="evid_tp_cd" value="" id="evid_tp_cd" /><!-- 
				 --><input type="text" style="width:100px;text-align:center;" class="input2" name="evid_tp_nm" readonly id="evid_tp_nm" value="" /><!-- 
				 --><span style="display:none;"><select name="combo_evid_tp_cd" id="combo_evid_tp_cd" style="width:95px;" class="input1"></select></span></td>
				<th>Request DT</th>
				<td>
					<input type="text" name="rqst_dt" dataformat="ymd" required=""  caption="Request DT" style="width:80px;ime-mode:disabled;" class="input1" id="rqst_dt" /><!-- 
					 --><button type="button" id="btn_rqstDt" name="btn_rqstDt" class="calendar ir"></button>
				</td>
				<th>Effective DT</th>
				<td>
					<input type="text" name="eff_dt" dataformat="ymd" required=""  caption="Eff Date" style="width:80px;ime-mode:disabled;" class="input1" id="eff_dt" /><!-- 
					 --><button type="button" id="btn_effDt" name="btn_effDt" class="calendar ir"></button>
				</td>
			</tr>
		</table>
		<table>
			<colgroup>
				<col width="90" />				
				<col width="480" />				
				<col width="75" />				
				<col width="*" />				
		   </colgroup>   
			<tr>
				<th>Vendor Code</th>
				<td><input type="text" name="vndr_seq" style="width:95px;text-align:center;ime-mode:disabled" class="input1" dataformat="num" required="" caption="Vendor Code" maxlength="6" id="vndr_seq" /><button type="button" id="btn_vndrSeq" name="btn_vndrSeq" class="input_seach_btn"></button><input type="text" name="vndr_nm" style="width:340px;" class="input2" readonly id="vndr_nm" /> </td>
				<th>Currency</th>
				<td><input type="text" name="csr_curr_cd" maxlength="3" style="width:40px;text-align:center;ime-mode:disabled" class="input1" value="USD" required=""  caption="Currency" id="csr_curr_cd" dataformat="engup" onchange="obj_change()"/> </td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!--  
			--><button class="btn_normal" name="btn_Brokerage" id="btn_Brokerage" type="button">Brokerage</button><!-- 
			--><button class="btn_normal" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_RowDel" id="btn_RowDel" type="button">Row Del</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_inquiry(S) -->
	<div  style="width:100%; text-align:right;">
		<table style="width:440px;float:right;">
		<tbody>	
		<colgroup>
		<col width="100"/>
		<col width="160"/>
		<col width="170"/>
		</colgroup> 	
			<tr>
				<th>Total Amount</th>
				<td><input type="text" style="width:55px;" class="tr_head3" value="DR" readonly><input type="text" name="dr" id="dr" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
				<td><input type="text" style="width:55px;" class="tr_head3" value="Diff" readonly><input type="text" name="diff" id="diff" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
			</tr>
			<tr><td height="5px" colspan="3"></td></tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="text" style="width:55px;" class="tr_head3" value="Balance" readonly><input type="text" name="balance" id="balance" style="width:100px;text-align:right;" class="tr_head3" value="0" readonly></td>
			</tr>
		</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->	
</div>

</form>