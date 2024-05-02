<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0937.jsp
*@FileTitle  : Cargo Release Order_E-D/O inquiry _Main
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0937Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CargoReleaseOrderMgtSC.CargoReleaseOrderBC");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0937Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
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
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>Receiver Info.</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
    	     --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
    	     --><button type="button" class="btn_normal" name="btn_Mail_Send" id="btn_Mail_Send">Mail Send</button><!-- 
    	     --><button type="button" class="btn_normal" name="btn_Fax_Send" id="btn_Fax_Send">Fax Send</button><!-- 
    		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->


<div class="wrap_search_tab">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table> 
	            <colgroup>
	                <col width="60"> 
	                <col width="100">
	                <col width="120">
	                <col width="*">
	            </colgroup>
	            <tbody>
               		<tr>
						<th>D/O No.</th> 
						<td><input type="text" name="do_no"  id="do_no" style="width:100px;text-align:left;" class="input2" value="<%=JSPUtil.getNull(request.getParameter("do_no"))%>" maxlength="12" dataformat="eng" style="ime-mode:disabled" readonly></td>
						<th id="div_multi_cntr">Multi-Container</th> 
						<td><select style="width:110px;" class="input1" name = "multi_cntr_no" id = "multi_cntr_no" onchange="fnMoveTrucker(this.value)"></select></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>

<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>
	<div id="tabLayer" class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="*">
			</colgroup>
			<tr>
				<th><strong>D/O Receiver</strong></th> 
				<td colspan="3"><input type="text" name = "rcvr_cnee_nm" id= "rcvr_cnee_nm" style="width:100%" class="input" value="" maxlength="100"></td>
			</tr>
			<tr>
				<th><strong>E-Mail Address</strong></th> 
				<td><input type="text" name = "rcvr_eml" id= "rcvr_eml" style="width:100%" class="input" value="" maxlength="50"></td>
				<th><strong>Fax No.</strong></th> 
				<td><input type="text" name = "rcvr_fax_no" id = "rcvr_fax_no" style="width:100%; ime-mode:disabled" class="input" value="" maxlength="20" dataformat="num"></td>
			</tr>
			<tr>
				<th><strong>Phone No.</strong></th>
				<td><input type="text" name = "rcvr_phn_no" id= "rcvr_phn_no" style="width:100%; ime-mode:disabled" class="input" value="" maxlength="30" dataformat="num"></td>
				<td></td> 
				<td></td>
			</tr>
		</table>
	</div>
	<div id="tabLayer" class="opus_design_data" style="display:none">
		<table class="grid_2">
			<colgroup>
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="*">
			</colgroup> 
			<tr>
				<th><strong>Trucker</strong></th> 
				<td><input type="text" name = "trkr_nm" id= "trkr_nm" style="width:100%" class="input" value="" maxLength="200"></td>
			</tr>
			<tr>
				<th><strong>Phone No.</strong></th> 
				<td><input type="text" name = "trkr_phn_no" id= "trkr_phn_no" style="width:100%; ime-mode:disabled" class="input" value="" maxLength="20" dataformat="num"></td>
				<th><strong>MRN No.</strong></th> 
				<td><input type="text" name = "trkr_mvmt_ref_no" id= "trkr_mvmt_ref_no" style="width:100%" class="input" value="" maxLength="30"></td>
			</tr>
			<tr>
				<th><strong>Empty Return Yard</strong></th> 
				<td><input type="text" name = "trkr_mty_rtn_yd_cd" id = "trkr_mty_rtn_yd_cd" style="width:100%" class="input" value="" maxLength="7" caption="Empty Return Yard" fullfill="true"></td>
				<td></td> 
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>