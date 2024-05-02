<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_FMS_00331.jsp  
*@FileTitle  : RCS / Invoice No Inquiry - Window
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms00331Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmFms00331Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
//	int rowCount	 = 0;						//Number of DB ResultSet List
	
//	String successFlag = "";
//	String codeList  = "";
//	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
//	Logger log = Logger.getLogger("com.clt.apps.TimeCharterInOutFleetManagement.TCharIODeliverySchedule");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmFms00331Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// Adding Logic extracting data from server when loading initial window ..
//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RCS / Invoice No Inquiry</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
	    <div class="opus_design_btn">
			   <button type="button" class="btn_accent"  name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			    --><button type="button" class="btn_normal"  name="btn_New" id="btn_New">New</button><!-- 
			    --><button type="button" class="btn_normal"  name="btn_Confirm" id="btn_Confirm">Confirm</button><!-- 
			    --><button type="button" class="btn_normal"  name="btn_close" id="btn_close">Close</button>
	    </div>
		 <!-- opus_design_btn(E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				 <table> 
		            <colgroup>
		                <col width="80"> 
		                <col width="*">
		            </colgroup>
		            <tbody>
		               	<tr>
							<th>CSR No.</th>
							<td><input type="text" name="csr_no" id="csr_no" style="width:160px;text-align:center;ime-mode:disabled;" class="input" maxlength="20" dataformat="engup" value="" caption="CSR No."></td>
						</tr>
					</tbody>
				</table>
				<table> 
		            <colgroup>
		                <col width="80"> 
		                <col width="100">
		                <col width="120">
		                <col width="*">
		            </colgroup>
		            <tbody>
		               	<tr>
							<th>Vessel Code</th>
							<td>
								<input type="text" name="vsl_cd" id="vsl_cd" style="width:54px;text-align:center;ime-mode:disabled" class="input" maxlength="4" dataformat="engup" fullfill caption="Vessel Code"><!-- 
								 --><button type="button" class="input_seach_btn" name="btn_vslCd" id="btn_vslCd"></button><!--
								 --><input type="text" name="vsl_eng_nm" id="vsl_eng_nm" style="width:140px;" class="input2" readonly>
							</td>
							<th>Contract No.</th>
							<td>
								<input type="text" name="flet_ctrt_no" id="flet_ctrt_no" style="width:120px;text-align:center;" class="input" value="" dataformat="engup" caption="Contract No." readonly><!-- 
								 --><button type="button" class="input_seach_btn" name="btn_fletCtrtNo" id="btn_fletCtrtNo"></button>
							</td>
						</tr>
					</tbody>
				</table>
				
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable" >	
			 <script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>