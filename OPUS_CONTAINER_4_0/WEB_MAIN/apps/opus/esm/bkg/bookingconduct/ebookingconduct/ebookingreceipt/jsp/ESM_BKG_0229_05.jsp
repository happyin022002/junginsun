<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName:   ESM_BKG_0229_05.jsp
*@FileTitle  : e-Booking & SI Process Detail(C/M)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905Event"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905ViewAdapter"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg022905Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from the server
	String strErrMsg = "";						//error messege
	int rowCount	 = 0;						//the number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.EBookingConduct.EBookingReceipt");
	String sXml = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg022905Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//  extract additional data obtained from the server during Initial loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		EsmBkg022905ViewAdapter adapter = new EsmBkg022905ViewAdapter();
		sXml = adapter.makeXML(request, response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<style type="text/css">
	.specialCls {
		float: right;
	}
	.specialCls:after {
		display: block;
		content: " ";
		clear: both;
	}
</style>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="rqst_seq" id="rqst_seq" value="<%=StringUtil.xssFilter(request.getParameter("rqst_seq"))%>">
<input type="hidden" name="sender_id" id="sender_id" value="<%=StringUtil.xssFilter(request.getParameter("sender_id"))%>">
<input type="hidden" name="cm_opus" id="cm_opus" value="">
<input type="hidden" name="cm_esvc" id="cm_esvc" value="">
<input type="hidden" name="sXml" id="sXml" value="<%=JSPUtil.replace(sXml, "\"", "&quot;")%>">

<!-- layout_wrap (S) -->
<div class="layout_wrap">
 	<div class="layout_vertical_2 pad_rgt_8" > 
		<div class="wrap_search sm">
			<div class="opus_design_grid">
				<h3 class="title_design">Booking Data OPUS</h3>
				<div class="specialCls">
					<button type="button" class="btn_normal" name="btn_t9multishp" id="btn_t9multishp">Multi-Shipment</button>
					<button type="button" class="btn_etc" name="btn_cancelcopydata" id="btn_cancelcopydata">Cancel Copy Data</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="80">
						<col width="110">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Booking No.</th>
							<td><input type="text" name="bkg_no" id="bkg_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("bkg_no"))%>" readOnly></td>
							<td style="text-align:right;"><button type="button" class="btn_etc" name="btn_copyfromcntr" id="btn_copyfromcntr">Copy from CNTR</button></td>
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	
	    	<!-- opus_design_grid(S) -->
	    	<div class="opus_design_gird" id="mainTable">
	    		<script type="text/javascript">ComSheetObject('sheet1');</script>
	    	</div>
	    	<!-- opus_design_grid(E) -->
		</div>
	</div>
	<div class="layout_vertical_2" >
		<div class="wrap_search sm">
			<div class="opus_design_grid">
				<h3 class="title_design">From e- Service</h3>
				<div class="specialCls">
					<button type="button" class="btn_etc" name="btn_datacopytoopus" id="btn_datacopytoopus">Data Copy to OPUS</button>
				</div>
			</div>
			<!-- opus_design_inquiry (S) -->
			<div class="opus_design_inquiry">
		    	<table>
					<colgroup>
						<col width="80">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Request No.</th>
							<td><input type="text" name="rqst_no" id="rqst_no" style="width:105px;" class="input2" value="<%=StringUtil.xssFilter(request.getParameter("rqst_no"))%>" readOnly></td>
						</tr>
					</tbody>
				</table>
	    	</div>
	    	<!-- opus_design_inquiry (E) -->
	    	
	    	<!-- opus_design_grid(S) -->
	    	<div class="opus_design_grid" id="mainTable">
	    		<script type="text/javascript">ComSheetObject('sheet2');</script>
	    	</div>
	    	<!-- opus_design_grid(E) -->
		</div>
	</div>
	<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>

<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
</div>

<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet5');</script>
</div>

</div>
<!-- layout_wrap (E) -->

<!-- opus_design_grid(E) -->
</form>		