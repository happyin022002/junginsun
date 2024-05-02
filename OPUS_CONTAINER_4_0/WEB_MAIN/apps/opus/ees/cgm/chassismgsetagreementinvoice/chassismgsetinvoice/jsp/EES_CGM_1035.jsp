<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1035.jsp
*@FileTitle  : Invoice Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1035Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesCgm1035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String ofc_cd              = "";

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetAgreementInvoice.ChassisMgsetInvoice");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		ofc_cd = account.getOfc_cd();

		event = (EesCgm1035Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<!-- developer working -->
<input type="hidden" name="eq_knd_cd" value="Z" id="eq_knd_cd" />
<input type="hidden" name="ofc_cd" value="<%=ofc_cd %>" id="ofc_cd" />
<input type="hidden" name="intg_cd_id" id="intg_cd_id" />
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" id="usr_id" />
<input type="hidden" name="pay_inv_seq" id="pay_inv_seq" />
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
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="80"/>			
				<col width="100"/>			
				<col width="134"/>			
				<col width="100"/>			
				<col width="100"/>					
				<col width="*" />				
		  	</colgroup> 		  	
			<tr>
				<th>Invoice Date</th>
				<td><script type="text/javascript">ComComboObject('cost_yrmon', 1, 110, 1, 1, 0, true);</script> <input type="text" name="inv_fm_date" id="inv_fm_date" dataformat="ym" maxlength='8' style="width:80px;text-align:center" class="input1" value=""><button type="button" id="btns_Calendar1" name="btns_Calendar1" class="calendar ir"></button>	~ <input type="text" name="inv_to_date" id="inv_to_date" dataformat="ym" maxlength='8' style="width:80px;text-align:center" class="input1" value=""><button type="button" id="btns_Calendar2" name="btns_Calendar2" class="calendar ir"></button></td>
				<th>Invoice Office</th>
				<td><input type="text" name="cost_ofc_cd" style="width:60px;text-align:center;ime-mode:disabled" dataformat="engup" maxlength="6" value="" id="cost_ofc_cd" onchange="obj_change()"/><button type="button" id="btns_office" name="btns_office" class="input_seach_btn"></button></td>
				<th>Creation User ID</th>
				<td><input type="text" name="cre_usr_id" style="width:90px;text-align:center" maxlength="20" value="<%=strUsr_id %>" id="cre_usr_id" /></td>
			</tr> 					
		</table>
		<table>
			<colgroup>
				<col width="80"/>			
				<col width="100"/>
				<col width="280"/>
				<col width="100"/>					
				<col width="*" />				
		  	</colgroup> 		  	
			<tr>
				<th>Division</th>
				<td><script type="text/javascript">ComComboObject('chss_mgst_inv_knd_cd', 2, 110, 0, 0, 0, false);</script></td>
				<td></td>
				<th>S. Provider</th>
				<td><input type="text" name="vndr_seq" dataformat="engup" style="width:80px;text-align:center" class="input" value="" id="vndr_seq" onchange="obj_change()"/><button type="button" id="btns_vndr" name="btns_vndr" class="input_seach_btn"></button><input type="text" name="vndr_nm" style="width:481px;" class="input2" value="" id="vndr_nm" />
			</tr> 					
		</table>
		<table>
			<colgroup>
				<col width="80"/>			
				<col width="100"/>			
				<col width="100"/>											
				<col width="91"/>											
				<col width="*" />				
		  	</colgroup> 		  	
			<tr>					
				<th>INV/CSR No.</th>
				<td><input type="radio" name="inv_csr_no_chk" value="inv_no" class="trans" id="inv_csr_no_chk" />Invoice&nbsp;<input type="radio" name="inv_csr_no_chk" value="csr_no" class="trans" id="inv_csr_no_chk" />CSR</td>
				<td><input type="text" name="inv_csr_no" style="width:300px;ime-mode:disabled" dataformat="engupetc" maxlength="300" class="input" value="" id="inv_csr_no" onchange="obj_change()"/></td>

				<th>Status</th>
				<td><script type="text/javascript">ComComboObject('inv_status', 2, 200, 1, 1, 1, true);</script></td>
			</tr> 				
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">

	<h3 class="title_design">Main</h3>
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">				
		<script type="text/javascript">ComSheetObject('sheet1');</script>			
	</div>	
	<!-- opus_design_grid(E) -->

	<h3 class="title_design">Detail</h3>
		
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">		
		<script type="text/javascript">ComSheetObject('sheet2');</script>	
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
