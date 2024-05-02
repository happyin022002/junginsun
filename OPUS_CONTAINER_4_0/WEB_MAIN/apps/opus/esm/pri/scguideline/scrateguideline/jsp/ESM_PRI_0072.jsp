<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0072.jsp
*@FileTitle  : Rate Guideline Inquiry - Origin & Destination
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
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

<%@ page import="org.apache.log4j.Logger" %>

<%
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
		String svcScpCd = request.getParameter("svc_scp_cd");
		String glineSeq = request.getParameter("gline_seq");
		String prcCustTpCd = request.getParameter("prc_cust_tp_cd");
		String CmdtHrdSeq = request.getParameter("cmdt_hdr_seq");
		String routSeq = request.getParameter("rout_seq");
		String orgDestTpCd = request.getParameter("org_dest_tp_cd");
		String pntViaTpCd = request.getParameter("pnt_via_tp_cd");
%>
<script type="text/javascript" >
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
<!-- developer performance	-->
<input type="hidden" name="cd" value="" id="cd" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(svcScpCd) %>" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="<%=StringUtil.xssFilter(glineSeq) %>" id="gline_seq" />
<input type="hidden" name="prc_cust_tp_cd" value="<%=StringUtil.xssFilter(prcCustTpCd) %>" id="prc_cust_tp_cd" />
<input type="hidden" name="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(CmdtHrdSeq) %>" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" value="<%=StringUtil.xssFilter(routSeq) %>" id="rout_seq" />
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(orgDestTpCd) %>" id="org_dest_tp_cd" />
<input type="hidden" name="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(pntViaTpCd) %>" id="pnt_via_tp_cd" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>Rate Guideline Inquiry - Origin & Destination</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
		    <button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table style="height:38px">
				<colgroup>
					<col width="80">
					<col width="40">
					<col width="70">
					<col width="90">
					<col width="120">
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th class="sm">Route Point</th>
						<td class="sm"></td>
						<td class="sm"><input type="radio" class="trans" name="rt_pnt" id="rt_pnt" value="4" checked><span id="pnt1">Origin</span>&nbsp;&nbsp;&nbsp;</td>
						<td class="sm"><input type="radio" class="trans" name="rt_pnt" id="rt_pnt" value="5" ><span id="pnt2">Origin Via</span>&nbsp;&nbsp;&nbsp;</td>
						<td class="sm"><input type="radio" class="trans" name="rt_pnt" id="rt_pnt" value="6" ><span id="pnt3">Destination Via</span>&nbsp;&nbsp;&nbsp;</td>
						<td class="sm"><input type="radio" class="trans" name="rt_pnt" id="rt_pnt" value="7" ><span id="pnt4">Destination</span>&nbsp;&nbsp;&nbsp;</td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result"> 
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- : ( Button : pop ) (E) -->
		<div class="opus_design_grid" id="hiddenSheetLayer" style="display: none ">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<script type="text/javascript">ComSheetObject('sheet3');</script>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
			<script type="text/javascript">ComSheetObject('sheet5');</script>
		</div>
		<!-- developer performance  end -->
	</div>	
</div>
<!-- layer_popup_contents(E) -->
</form>