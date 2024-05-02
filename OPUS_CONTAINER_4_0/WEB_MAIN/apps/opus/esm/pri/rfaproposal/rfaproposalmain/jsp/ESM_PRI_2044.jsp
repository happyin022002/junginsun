<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2044.jsp
*@FileTitle  : RFA Proposal Creation [Copy] 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2044Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO"%>
<%@ page import="org.apache.log4j.Logger"%>

<%

    EsmPri2044Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAProposalMain");

	String propNo = null;
	String amdtSeq = null;
    String rfaNo = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri2044Event)request.getAttribute("Event");

	    propNo = JSPUtil.getNull(request.getParameter("prop_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("prop_no"));
	    amdtSeq = JSPUtil.getNull(request.getParameter("amdt_seq")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("amdt_seq"));
	    rfaNo = JSPUtil.getNull(request.getParameter("rfa_no")).trim().equals("")?"":JSPUtil.getNull(request.getParameter("rfa_no"));
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
            showErrMessage(errMessage);
        } // end if
        loadPage();
    }
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer job	-->
<!-- input type="hidden" name="cd" -->
<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation [Copy]</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Ok" id="btn_Ok">OK</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="50">
					<col width="130">
					<col width="50">
					<col width="80">
					<col width="70">
					<col width="*">
				</colgroup>
				<tr>
					<th>RFA No.</th>
					<td><input type="text" name="rfa_no" style="width:90px;" value="<%=rfaNo %>" class="input2" readonly="readonly" id="rfa_no" /></td>
					<th>AMD No.</th>
					<td><input type="text" name="amdt_seq" style="width:45px;text-align:right;" value="<%=amdtSeq%>" class="input2" readonly="readonly" id="amdt_seq" /></td>
					<th>Proposal No.</th>
					<td><input type="text" name="prop_no" style="width:90px;text-align:center;" value="<%=propNo%>" class="input2" readonly="readonly" id="prop_no" /></td>
				</tr>
				<tr>
					<th><input type="checkbox" name="afil_chk_frm" class="trans" id="afil_chk_frm" />&nbsp;Affiliate</th>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>	
			</table>
		</div>
	</div>
	
	<div class="wrap_result">
		<div class="opus_design_grid" style="display:inline;">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
            <script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>
</form>