<%  
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :  esm_pri_2001_04.jsp
*@FileTitle  :  RFA Rate Guideline Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/27
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfarateguideline.event.EsmPri200104Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
EsmPri200104Event event = null; //PDTO(Data Transfer Object including Parameters)
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

		event = (EsmPri200104Event) request.getAttribute("Event");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<!-- developer job	-->
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd">
<input type="hidden" name="gline_seq" id="gline_seq">
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq">
<input type="hidden" name="rout_seq" id="rout_seq">

<div class="opus_design_btn">
	<!-- Content -->
	<button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
	 --><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!-- 
	  --><button type="button" class="btn_normal" name="btn_LoadExcel" id="btn_LoadExcel">Load Excel</button>				
</div>

<div class="opus_design_grid">
	<div class="grid_option_left">
		<h3 class="title_design">Commodity Group</h3>
	</div>
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd1" suppressWait="Y" id="btn_rowadd1">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_rowcopy1" suppressWait="Y" id="btn_rowcopy1">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<table class="line_bluedot"><tr><td></td></tr></table>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">

	<div class="grid_option_left">
		<h3 class="title_design">Route Detail</h3>
	</div>
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd2" suppressWait="Y" id="btn_rowadd2">Row Add</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_rowcopy2" suppressWait="Y" id="btn_rowcopy2">Row Copy</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	

	<div class="opus_design_data">
		<table class="grid_2"> 
			<tr>
				<th>Origin</th>
				<th>Origin Via</th> 
				<th>Destination Via</th>    
				<th>Destination</th>          
			</tr>
			<tr>
				<td class="input2"><textarea name="origin_desc" style="width:100%; resize:none;" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="ovia_desc" style="width:100%; resize:none;" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dvia_desc" style="width:100%; resize:none;" rows="3" class="textarea2" readonly></textarea></td>
				<td class="input2"><textarea name="dest_desc" style="width:100%; resize:none;" rows="3" class="textarea2" readonly></textarea></td>
			</tr>
		</table>
	</div>
</div>
<table class="line_bluedot"><tr><td></td></tr></table>

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<div class="grid_option_left">
		<h3 class="title_design">Rate</h3>
	</div>
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd3" suppressWait="Y" id="btn_rowadd3">Row Add</button><!-- 
		--><button type="button" class="btn_normal" name="btn_delete3" suppressWait="Y" id="btn_delete3">Delete</button><!-- 
		--><button type="button" class="btn_normal" name="btn_save3" id="btn_save3">Save</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet3');</script>
</div>
<!-- opus_design_grid(E) -->


<div id="hiddenSheetLayer" style="display: none">
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<script type="text/javascript">ComSheetObject('sheet5');</script>
	<script type="text/javascript">ComSheetObject('sheet6');</script>
	<script type="text/javascript">ComSheetObject('sheet7');</script>
	<script type="text/javascript">ComSheetObject('sheet8');</script>
	<script type="text/javascript">ComSheetObject('sheet9');</script>
	<script type="text/javascript">ComSheetObject('sheet10');</script>
</div>

</form>

<div id="confirmDialog" style="display: none">
	 <p>Please select Excel file format.</p>
</div>
