<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_1073.jsp
*@FileTitle  : Customer EDI ID Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/10
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingreport.performancereport.event.EsmBkg1073Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg1073Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	String grp_id = JSPUtil.getNull(request.getParameter("grp_id")); ;
	String edi_id = JSPUtil.getNull(request.getParameter("edi_id")); ;
	String grp_nm = JSPUtil.getNull(request.getParameter("grp_nm")); ;

	boolean bBtn_Disabled = true;
	Logger log = Logger.getLogger("com.clt.apps.BookingReport.PerformanceReport");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg1073Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
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


<form method="post" name="form" id="form"  onSubmit="return false;">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Customer EDI ID Inquiry</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" type="button" name="btn_Retrieve" id="btn_Retrieve" >Retrieve</button><!--
			--><button class="btn_normal" type="button" name="btn_Select">Select</button><!--
			--><button class="btn_normal" type="button" name="btn_Close"  id="btn_Close">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="100" />				
					<col width="70" />				
					<col width="100" />				
					<col width="80" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
						<th>Customer Code</th>
						<td>
							<input type="input" name="cnt_cd" value="" style="width:30px;ime-mode:disabled" maxlength="2" dataformat="engup" class="input" id="cnt_cd" /><!-- 
							 --><input type="input" name="cust_seq" value="" style="width:70px;ime-mode:disabled" maxlength="6" dataformat="num" class="input" id="cust_seq" />
						</td>
					</tr>
					<tr>
						<th>Group ID</th>
						<td>
								<input type="input" name="grp_id" value="<%=grp_id %>" style="width:90px;ime-mode:disabled" maxlength="10" dataformat="engup" class="input" id="grp_id" />
						</td>
						<th>TP/EDI ID</th>
						<td>
							<input type="input" name="edi_id" value="<%=edi_id %>" style="width:100px;ime-mode:disabled" maxlength="20" dataformat="engup" class="input" id="edi_id" /></td>
						<th>Group Name</th>
						<td>
							<input type="input" name="grp_nm" value="<%=grp_nm %>" style="width:200px;ime-mode:disabled" maxlength="100" dataformat="engup" otherchar="#&*()., -" class="input" id="grp_nm" />
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
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

</form>
 <%@include file="/bizcommon/include/common_opus.jsp"%>
