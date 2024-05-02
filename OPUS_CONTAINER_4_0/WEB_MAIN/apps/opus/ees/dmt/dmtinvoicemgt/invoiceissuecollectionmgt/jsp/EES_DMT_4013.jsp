<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_4013.jsp
*@FileTitle  : Invoice Creation - Group
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	//EesDmt4002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String strUsr_ofc = "";
	String strCnt_cd = "";
	String strUsr_eml = "";
	Logger log = Logger.getLogger("com.clt.apps.InvoiceMgt.InvoiceIssueCollectionMgt");

	//parameter
	String s_group_by = "";
	String s_chg_type = "";
	String jspno	  = "";
	String p_exchange_rt	= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
		strCnt_cd = account.getCnt_cd();
		strUsr_eml = account.getUsr_eml();


		//event = (EesDmt4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		s_group_by		= JSPUtil.getParameter(request,"s_group_by");
		s_chg_type		= JSPUtil.getParameter(request,"s_chg_type");
		jspno			= JSPUtil.getParameter(request,"jspno");
		p_exchange_rt	= JSPUtil.getParameter(request,"inv_xch_rt");	// exchange_rate from 3001 

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<head>
<title>Invoice Creation - Group</title>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>
<body class="popup_bg" onLoad="setupPage();" onUnLoad="unLoadPage();"> 
<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="tax_rto" id="tax_rto" />

<input type="hidden" name="s_cust_gubun" id="s_cust_gubun" />
<input type="hidden" name="s_cust_cd" id="s_cust_cd" />
<input type="hidden" name="s_cust_name" id="s_cust_name" />
<input type="hidden" name="ofc_cd" id="ofc_cd" />

<input type="hidden" name="s_group_by" value="<%=s_group_by %>" id="s_group_by" />
<input type="hidden" name="s_chg_type" value="<%=s_chg_type %>" id="s_chg_type" />

<input type="hidden" name="success_yn" id="success_yn" />

<input type="hidden" name="session_cnt_cd" value="<%=strCnt_cd %>" id="session_cnt_cd" />
<input type="hidden" name="session_ofc_cd" value="<%=strUsr_ofc %>" id="session_ofc_cd" />
<input type="hidden" name="session_email" value="<%=strUsr_eml %>" id="session_email" />
<input type="hidden" name="session_usr_nm" value="<%=strUsr_nm %>" id="session_usr_nm" />
<input type="hidden" name="session_usr_id" value="<%=strUsr_id%>" id="session_usr_id" />

<input type="hidden" name="ofc_curr_date" id="ofc_curr_date" />
<input type="hidden" name="jspno" value="<%=jspno %>" id="jspno" />
<input type="hidden" name="p_exchange_rt" value="<%=p_exchange_rt %>" id="p_exchange_rt" />
<input type="hidden" name="usr_cnt_cd" id="usr_cnt_cd" />

<!-- container count for retrieving -->
<input type="hidden" name="s_ofc_cd" id="s_ofc_cd" />
<input type="hidden" name="s_bkg_no" id="s_bkg_no" />
<input type="hidden" name="s_dmdt_trf_cd" id="s_dmdt_trf_cd" />
<input type="hidden" name="re_cntr_cnt" id="re_cntr_cnt" />

<!--  group invoice -->
<input type="hidden" name="pgm_id" value="4013" id="pgm_id" />

<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />

<!-- Check Payer & RepCust -->
<input type="hidden" name="rep_cust_seq" id="rep_cust_seq">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Invoice Creation - Group</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_update" id="btn_update" type="button">Update</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_ar" id="btn_ar" type="button">A/R I/F</button><!--
		--><button class="btn_normal" name="btn_excel" id="btn_excel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	

	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="150" />				
				<col width="100" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<td><h3  class="title_design mar_top_12">Selected Total</h3></td>
		   			<th>INV Cur.</th>
					<td><input type="text" name="inv_curr_cd" id="inv_curr_cd" style="width:34px;text-align:center;" class="input2" value="" readOnly></td>
		   		</tr>
		   </tbody>
		</table>
		
		<table>
			<colgroup>
				<col width="70" />				
				<col width="80" />				
				<col width="100" />				
				<col width="170" />				
				<col width="100" />		
				<col width="200" />	
				<col width="80" />					
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>INV Q'TY</th>
					<td><input type="text" name="inv_qty" style="width:64px;text-align:right;" class="input2" value="" readonly id="inv_qty" /> </td>
					<th>Billing AMT</th>
					<td><input type="text" name="tot_bil_amt" style="width:165px;text-align:right;" class="input2" value="" readonly id="tot_bil_amt" /> </td>
					<th>Tax Rate/AMT</th>
					<td><input type="checkbox" value="" name="chk_tax_rto" class="trans" onclick="setTax();" id="chk_tax_rto" />&nbsp;<input type="text" name="tax_rto_dis" style="width:50px;text-align:right;" class="input2" value="" readonly id="tax_rto_dis" />%&nbsp;<!-- 
					 --><input type="text" name="tot_tax_amt" style="width:125px;text-align:right;" class="input2" value="" readonly="" id="tot_tax_amt" /></td>
					<th>INV AMT</th>
					<td><input type="text" name="tot_payable_amt" style="width:150px;text-align:right;" class="input2" value="" readonly id="tot_payable_amt" /> </td>
		   		</tr>
		   </tbody>
		</table>
		<table>
			<colgroup>
				<col width="70" />				
				<col width="350" />				
				<col width="150" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
		   			<th>Payer</th>
					<td><input type="text" name="payer_cd" dataformat="engup" style="width:64px;" maxlength="8" class="input1" value="" onkeypress="ComKeyOnlyAlphabet('uppernum')" id="payer_cd" /><button type="button" id="btn_payer_cd" name="btn_payer_cd" class="input_seach_btn"></button><input type="text" name="payer_nm" style="width:250px;" class="input2" value="" readonly id="payer_nm" /> </td>
					<th>Issue Date Office Name</th>
					<td><input type="text" name="issue_date" style="width:80px;" class="input2" value="" readonly id="issue_date" /><!-- 
					 --><input type="text" name="usr_ofc" style="width:50px;" class="input2" value="" readonly="" id="usr_ofc" /><!-- 
					 --><input type="text" name="usr_name" style="width:259px;" class="input2" value="" readonly="" id="usr_name" /></td>
		   		</tr>
		   </tbody>
		</table>
		
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable2" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable2" style="display:none;">
		<script type="text/javascript">ComSheetObject('sheet3');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	
</div>

</form>