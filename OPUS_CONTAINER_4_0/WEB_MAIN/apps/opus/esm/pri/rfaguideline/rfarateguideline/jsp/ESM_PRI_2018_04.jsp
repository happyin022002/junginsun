<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2018_04.jsp
*@FileTitle  : RFA Guideline Inquiry - Rate
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/03 
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri201804Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri201804Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.clt.apps.RFAGuideline.RFAGuidelineMain");

	String[] ratUtCdList = null;
	String[] prcCgoTpCdList = null;
	String[] currCdList = null;

	ArrayList<CodeInfo> termOrgCdList = null;
	ArrayList<CodeInfo> termDestCdList = null;
	ArrayList<CodeInfo> transModeCdList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri201804Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

		ratUtCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCdList"), false, "|", "\t");
		prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCdList"), true, "|", "\t", "getCode", "getName");
		currCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCdList"), false, "|", "\t");

		termOrgCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termOrgCdList");
		termDestCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termDestCdList");
		transModeCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("transModeCdList");

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var ratUtCdValue = "<%=ratUtCdList[0]%>";
    var ratUtCdText = "<%=ratUtCdList[1]%>";
    var prcCgoTpCddValue = "<%=prcCgoTpCdList[0]%>";
    var prcCgoTpCdText = "<%=prcCgoTpCdList[1]%>";
    var currCdValue = "<%=currCdList[0]%>";
    var currCdText = "<%=currCdList[1]%>";

    var arrTermOrg = new Array();
    var arrTermDest = new Array();
    var arrTransMode = new Array();

    <%
    for (int i = 0; termOrgCdList != null && i < termOrgCdList.size(); i++) {
    	CodeInfo row = termOrgCdList.get(i);
    	out.println("arrTermOrg[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; termDestCdList != null && i < termDestCdList.size(); i++) {
    	CodeInfo row = termDestCdList.get(i);
    	out.println("arrTermDest[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    for (int i = 0; transModeCdList != null && i < transModeCdList.size(); i++) {
    	CodeInfo row = transModeCdList.get(i);
    	out.println("arrTransMode[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
    }
    %>

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
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" id="gline_seq" />
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" id="rout_seq" />
<div>
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button class="btn_accent" type="button" name="btn_downexcel" id="btn_downexcel">Down&nbsp;Excel</button><!--
		--></div>
</div>
	<!-- opus_design_btn (E) -->
	
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design pad_btm_8">Commodity Group</h3>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design pad_btm_8">Route Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="25%" />				
				<col width="25%" />				
				<col width="25%" />				
				<col width="25%" />				
		   </colgroup>  
			<tr>
				<th>Origin</th>
				<th>Origin Via</th> 
				<th>Destination Via</th>    
				<th>Destination</th>          
			</tr>
			<tr>
				<td class="input2"><textarea name="origin_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="ovia_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dvia_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dest_desc" style="width:100%" rows="3" class="textarea2" readonly></textarea></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_grid(E) -->
	<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design pad_btm_8">Commodity Group</h3>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="hiddenSheetLayer" style="display: none">
		<script type="text/javascript">ComSheetObject('sheet4');</script>
		<script type="text/javascript">ComSheetObject('sheet5');</script>
		<script type="text/javascript">ComSheetObject('sheet6');</script>
		<script type="text/javascript">ComSheetObject('sheet7');</script>
		<script type="text/javascript">ComSheetObject('sheet8');</script>
		<script type="text/javascript">ComSheetObject('sheet9');</script>
		<script type="text/javascript">ComSheetObject('sheet10');</script>
	</div>
	<!-- opus_design_grid(E) -->

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Please select Excel file format.</p>
</div>

</form>