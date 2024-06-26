<%  
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_07.jsp
*@FileTitle  : RFA Proposal Inquiry - Rate  
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri201907Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri201907Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFARateProposal");
	String[] ratUtCdList = null;
	String[] prcCgoTpCdList = null;
	String[] currCdList = null;
	ArrayList<CodeInfo> termOrgCdList = null;
	ArrayList<CodeInfo> termDestCdList = null;
	ArrayList<CodeInfo> transModeCdList = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri201907Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="prop_no" name="prop_no" type="hidden" />
<input id="amdt_seq" name="amdt_seq" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="conv_chk" name="conv_chk" type="hidden" />
<input id="cmdt_hdr_seq" name="cmdt_hdr_seq" type="hidden" />
<input id="rout_seq" name="rout_seq" type="hidden" />
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn"><!--
	--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	--><button type="button" class="btn_normal" name="btn_gricalc" id="btn_gricalc">GRI</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_title_area(E) -->
	<!-- opus_design_grid(S) -->
		<h3 class="title_design">Commodity Group</h3>
	     <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	<!-- opus_design_grid(E) -->
		<table class="line_bluedot"><tr><td></td></tr></table>
		
	<!-- opus_design_grid(S) -->
		<h3 class="title_design">Route Detail</h3>
	    <div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<div class="opus_design_data">
				<table class="grid_2"> 
		            <tr>
		                <td width="25%" style="font-weight: bold; text-align: center;">Origin</td>
		                <td width="25%" style="font-weight: bold; text-align: center;">Origin Via</td> 
		                <td width="25%" style="font-weight: bold; text-align: center;">Destination Via</td>    
		                <td width="25%" style="font-weight: bold; text-align: center;">Destination</td>          
		            </tr>
		            <tr>
		                <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
		                <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
		                <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
		                <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
	            	</tr>
	       	 	</table>
			</div>
	    </div>
	<!-- opus_design_grid(E) -->
	
	<table class="line_bluedot"><tr><td></td></tr></table>
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design">Rate</h3>
         <div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_specification" id="btn_specification">Specification</button>
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
	<script type="text/javascript">ComSheetObject('sheet11');</script>
	<script type="text/javascript">ComSheetObject('sheet12');</script>
	<script type="text/javascript">ComSheetObject('sheet13');</script>
	<script type="text/javascript">ComSheetObject('sheet14');</script>
	<script type="text/javascript">ComSheetObject('sheet15');</script>
	<script type="text/javascript">ComSheetObject('sheet16');</script>
	</div>
	
	<script type="text/javascript">
	function showStatus() {
	    var sStr = "";
	    sStr += "******************** Form Value ********************\n";
	    sStr += "Proposal NO.\t: " + document.form.prop_no.value + "\n";
	    sStr += "Amend Seq.\t: " + document.form.amdt_seq.value + "\n";
	    sStr += "SVC Scope\t: " + document.form.svc_scp_cd.value + "\n";
	    sStr += "Prev. Amend Seq.\t: " + document.form.pre_amdt_seq.value + "\n";
	    sStr += "Proposal Status\t: " + document.form.prc_prop_sts_cd.value + "\n";
	    sStr += "EFF Date\t\t: " + document.form.eff_dt.value + "\n";
	    sStr += "EXP Date\t\t: " + document.form.exp_dt.value + "\n";
	    sStr += "Prev. EXP Date\t: " + document.form.pre_exp_dt.value + "\n";
	    sStr += "Is Sales Rep.\t: " + document.form.is_req_usr.value + "\n";
	    sStr += "Has Appr. Auth.\t: " + document.form.is_apro_usr.value + "\n";
	    sStr += "Comodity Seq.\t: " + document.form.cmdt_hdr_seq.value + "\n";
	    sStr += "Route Seq.\t: " + document.form.rout_seq.value + "\n";
	    
	    alert(sStr);
	}
	</script>
	<a href="javascript:showStatus();" onFocus="this.blur();"><font color="white" size="1">상태값확인</font></a>
</form>
