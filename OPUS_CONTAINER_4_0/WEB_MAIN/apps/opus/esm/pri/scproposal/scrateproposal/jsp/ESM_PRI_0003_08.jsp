<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ui_pri_0003_08.jsp
*@FileTitle  : Rate Proposal Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================*/
%> 
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event.EsmPri000308Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
		EsmPri000308Event event = null; //PDTO(Data Transfer Object including Parameters)
		Exception serverException = null; //error from server
		String strErrMsg = ""; //error message
		int rowCount = 0; //count of DB resultSET list

		String successFlag = "";
		String codeList = "";
		String pageRows = "100";

		String strUsr_id = "";
		String strUsr_nm = "";
		Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCRateProposal");
		
		ArrayList<CodeInfo> rateTypeList = null;
		
		String[] ratUtCdList = null;
		String[] prcCgoTpCdList = null;
		String[] currCdList = null;
		
		ArrayList<CodeInfo> termOrgCdList = null;
		ArrayList<CodeInfo> termDestCdList = null;
		ArrayList<CodeInfo> noteClassCdList = null;
		ArrayList<CodeInfo> transModeCdList = null;

		try {
				SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
				strUsr_id = account.getUsr_id();
				strUsr_nm = account.getUsr_nm();

				event = (EsmPri000308Event) request.getAttribute("Event");
				serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

				if (serverException != null) {
						strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
				}

				GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
				rateTypeList = (ArrayList<CodeInfo>)eventResponse.getCustomData("rateTypeCdList");
				
				ratUtCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCdList"), false, "|", "\t");
				prcCgoTpCdList = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCdList"), true, "|", "\t", "getCode", "getName");
				currCdList = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCdList"), false, "|", "\t");
				
				termOrgCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termOrgCdList");
				termDestCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("termDestCdList");
				noteClassCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("noteClassCdList");
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
    var arrNoteClass = new Array();
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
    for (int i = 0; noteClassCdList != null && i < noteClassCdList.size(); i++) {
	    	CodeInfo row = noteClassCdList.get(i);
	    	out.println("arrNoteClass[\"" + row.getCode()  + "\"] = \"" + row.getName() + "\";");
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
<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" />
<input type="hidden" name="pre_amdt_seq" id="pre_amdt_seq" />
<input type="hidden" name="prc_prop_sts_cd" id="prc_prop_sts_cd" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" />
<input type="hidden" name="is_req_usr" id="is_req_usr" />
<input type="hidden" name="is_apro_usr" id="is_apro_usr" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq" />
<input type="hidden" name="rout_seq" id="rout_seq" />
<input type="hidden" name="lgcy_if_flg" id="lgcy_if_flg" />

<!-- opus_design_btn(S) -->
<div class="opus_design_btn">
	<!-- Content -->
	<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button> 
	<button type="button" class="btn_normal" name="btn_acceptall" id="btn_acceptall">Accept All</button> 
	<button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Accept Cancel</button> 
	<button type="button" class="btn_normal" name="btn_glcopy" id="btn_glcopy">G/L Copy</button> 
	<button type="button" class="btn_normal" name="btn_gricalc" id="btn_gricalc">GRI Cal.</button>
	<button type="button" class="btn_normal" name="btn_viewall" id="btn_viewall">View All</button> 	      
	<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
	<button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button> 			
</div>

<!-- opus_design_grid(S) -->
<div class="opus_design_inquiry" id="mainTable">
	<table>
		<tbody>
			<tr>
				<th class="sm" width="40">Type</th>
				<td class="sm" width="60" id="rdoRateTp">
			   	<%
				 if (rateTypeList != null && rateTypeList.size() > 0) {
				     for (int i = 0; i < rateTypeList.size(); i++) {
				         com.clt.framework.component.util.code.CodeInfo row = rateTypeList.get(i);
				         out.print("<input id=\"gen_spcl_rt_tp_cd"+i+"\" name=\"gen_spcl_rt_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\"><label for=\"gen_spcl_rt_tp_cd"+i+"\">"+row.getName()+"</label>");
				     }
				 }
				 %>
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div> 
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">

	<div class="grid_option_left">
		<h3 class="title_design">Commodity Group</h3>
	</div>
	
	<div class="opus_design_btn" id="mainTable">
		<button type="button" class="btn_normal" suppressWait="Y" name="btn_rowadd1" id="btn_rowadd1">Row Add</button> 
		<button type="button" class="btn_normal" suppressWait="Y" name="btn_rowcopy1" id="btn_rowcopy1">Row Copy</button> 
  		<button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 		   --><button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>		      
	</div>
	
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- ########################################################### -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">

	<div class="grid_option_left">
		<h3 class="title_design">Route Detail</h3>
	</div>

	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd2" suppressWait="Y" id="btn_rowadd2">Row Add</button> 
		<button type="button" class="btn_normal" name="btn_rowcopy2" suppressWait="Y" id="btn_rowcopy2">Row Copy</button> 
		<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button> 
		<button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
	</div>
	<!-- opus_design_btn(e) -->
	
	<script type="text/javascript">ComSheetObject('sheet2');</script>
	
	<!-- opus_design_data(S) -->
	<div class="opus_design_data">
		<table class="grid2">
		 <tr>
                <th width="25%">Origin</th>
                <th width="25%">Origin Via</th> 
                <th width="25%">Destination Via</th>    
                <th width="25%">Destination</th>          
            </tr>
            <tr>
                <td class="input2" style="height:50px;"><div style="width:100%; height:50px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="45px"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td></tr></table></div></td>
                <td class="input2" style="height:50px;"><div style="width:100%; height:50px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="45px"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
                <td class="input2" style="height:50px;"><div style="width:100%; height:50px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="45px"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
                <td class="input2" style="height:50px;"><div style="width:100%; height:50px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="45px"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
            </tr>
        </table>
	</div>
	<!-- opus_design_data(E) -->
</div>	
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">

	<div class="grid_option_left">
		<h3 class="title_design">Rate</h3>
	</div>

	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_rowadd3" suppressWait="Y" id="btn_rowadd3">Row Add</button> 
		<button type="button" class="btn_normal" name="btn_delete3" suppressWait="Y" id="btn_delete3">Delete</button> 
		<button type="button" class="btn_normal" name="btn_save3" id="btn_save3">Save</button> 
		<button type="button" class="btn_normal" name="btn_amend3" suppressWait="Y" id="btn_amend3">Amend</button>
		<button type="button" class="btn_normal" name="btn_amendcancel3" suppressWait="Y" id="btn_amendcancel3">Amend Cancel</button>
		<button type="button" class="btn_normal" name="btn_accept3" suppressWait="Y" id="btn_accept3">Accept</button>
		<button type="button" class="btn_normal" name="btn_acceptcancel3" suppressWait="Y" id="btn_acceptcancel3">Accept Cancel</button>
	</div>
	<!-- opus_design_btn(e) -->
	
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
    sStr += "BackEnd timer.\t: " + parent.document.form.ori_timer.value + "\n";
    sStr += "BackEnd ctimer.\t: " + parent.document.form.cl_timer.value + "\n";
    alert(sStr);
}
</script>
<a href="javascript:showStatus();" onFocus="this.blur();"><font color="white" size="1" name="showStatus">상태값확인</font></a>
<br>
<a href="javascript:clearTimeout(timeID);" onFocus="this.blur();"><font color="white" size="1" name="turnOffMonitoring">Turn off Batch Monitoring</font></a>

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Please select Excel file format.</p>
</div>

</form>