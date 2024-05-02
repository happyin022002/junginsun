<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0079.jsp
*@FileTitle  : Freight & Charge_S/C Note
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0270Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0270Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.BlRating.BlRating");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0270Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
<input type="hidden" name="bkg_no" value="<%=JSPUtil.getParameter(request, "bkg_no")%>" id="bkg_no" />
<input type="hidden" name="sc_no" value="<%=JSPUtil.getParameter(request, "sc_no")%>" id="sc_no" />
<input type="hidden" name="application_date" value="<%=JSPUtil.getParameter(request, "application_date")%>" id="application_date" />
<input type="hidden" name="svc_scp_cd" value="<%=JSPUtil.getParameter(request, "svc_scp_cd")%>" id="svc_scp_cd" />
<input type="hidden" name="note_rt_seq" value="<%=JSPUtil.getParameter(request,"note_rt_seq") %>" id="note_rt_seq" />
<input type="hidden" name="prop_no" value="<%=JSPUtil.getParameter(request,"prop_no")%>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=JSPUtil.getParameter(request,"amdt_seq") %>" id="amdt_seq" />
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=JSPUtil.getParameter(request,"gen_spcl_rt_tp_cd")%>" id="gen_spcl_rt_tp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=JSPUtil.getParameter(request,"cmdt_hdr_seq")%>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=JSPUtil.getParameter(request,"rout_seq")%>" id="rout_seq" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>S/C Note</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
					<td><h3 class="title_design">OFT Note</h3></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></div>
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="*">
				</colgroup>
				<tr class="h23">
					<td><h3 class="title_design">Surcharge Note</h3></td>
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<div class="opus_design_inquiry"><table class="line_bluedot"><tr><td colspan="8"></td></tr></table></div>
</div>

</form>
