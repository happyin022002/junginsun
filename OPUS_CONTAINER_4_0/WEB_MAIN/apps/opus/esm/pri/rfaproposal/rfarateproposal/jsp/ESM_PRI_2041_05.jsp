<%  
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_2041_05.jsp
 *@FileTitle  : RFA Search - Amendment History - Rate
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204105Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri204105Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri204105Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="conv_chk" id="conv_chk" />
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" id="rout_seq" />

<div>
	<!-- opus_design_grid(S) -->	
	<div class="opus_design_grid" id="mainTable">
		<h3 class="title_design">Commodity Group</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button><!--  
		 --><button type="button" class="btn_normal" name="btn_gricalc" 	id="btn_gricalc">GRI</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		
		<table class="line_bluedot"><tr><td></td></tr></table>
	
		<h3 class="title_design pad_btm_8">Route Detail</h3>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
		
		<div class="opus_design_data">
			<table style="width:100%; background-color:white;" class="grid2"> 
	           <tr class="tr2_head">
	               <th width="25%">Origin</th>
	               <th width="25%">Origin Via</th> 
	               <th width="25%">Destination Via</th>    
	               <th width="25%">Destination</th>          
	           </tr>
	           <tr>
	               <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
	               <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
	               <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
	               <td class="input2"><div style="width:100%; height:45; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
	           </tr>
	       </table>
		</div>
		<table class="line_bluedot"><tr><td></td></tr></table>

		<h3 class="title_design">Rate</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_specification" 	id="btn_specification">Specification</button>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
<!-- opus_design_grid(E) -->
</div>
<div id="hiddenSheetLayer" style="display: none;">
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
<a href="javascript:showStatus();" onFocus="this.blur();"><font color="white" size="1">Check Status</font></a> 
</form>