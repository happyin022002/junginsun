<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_09.jsp
*@FileTitle  : S/C Proposal General/Special Rate - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scrateproposal.event.EsmPri000409Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
    EsmPri000409Event event = null; //PDTO(Data Transfer Object including Parameters)
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
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri000409Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<!-- <title>S/C Proposal General/Special Rate - Inquiry</title> -->
<script language="javascript">
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

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
 
<input type="hidden" name="prop_no">
<input type="hidden" name="amdt_seq">
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="cmdt_hdr_seq">
<input type="hidden" name="rout_seq">

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_gricalc" id="btn_gricalc">GRI</button>
	</div>
		
	<div class=opus_design_inquiry>
		<table style="width: 200px; margin-top:-10px;">
			<tbody class="sm">
				<tr>
					<th>Type</th>
					<td id="rdoRateTp">
					<%
	                if (rateTypeList != null && rateTypeList.size() > 0) {
	                    for (int i = 0; i < rateTypeList.size(); i++) {
	                        com.clt.framework.component.util.code.CodeInfo row = rateTypeList.get(i);
	                        if( i != 0 ){
	                        	out.print("-->");
	                        }
	                        out.print("<input name=\"gen_spcl_rt_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" id=\"gen_spcl_rt_tp_cd"+i+"\" class=\"trans\"><label for=\"gen_spcl_rt_tp_cd"+i+"\">"+ row.getName()+"</label>");
	                        if( i <rateTypeList.size()-1 ){
	                        	out.print("<!--");
	                        }

	                    }
	                }
	                %>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="opus_design_grid">
		<div class="grid_option_left">
			<h3 class="title_design mar_btm_8">Commodity Group</h3>
		</div>
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
		<div class="grid_option_left">
			<h3 class="title_design mar_btm_8">Route Detail</h3>
		</div>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>

	
	<div class=opus_design_inquiry>
		<table border="0" style="width:100%; background-color:white;" class="grid_2"> 
           <tr class="tr2_head">
               <th width="25%" class="align_center">Origin</th>
               <th width="25%" class="align_center">Origin Via</th> 
               <th width="25%" class="align_center">Destination Via</th>    
               <th width="25%" class="align_center">Destination</th>          
           </tr>
           <tr>
               <td class="input2">
               		<div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;">
               		<table>
               			<tr>
               				<td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="origin_desc"></td>
               			</tr>
               		</table>
               		</div>
               	</td>
               <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="ovia_desc"></td></tr></table></div></td>
               <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dvia_desc"></td></tr></table></div></td>
               <td class="input2"><div style="width:100%; height:45px; word-wrap:break-word; overflow-x:hidden; overflow-y:scroll;"><table width="100%" height="100%"><tr><td style="border:0px; padding:2px; text-indent:0px;" valign="top" id="dest_desc"></td></tr></table></div></td>
           </tr>
       </table>
	</div>
	
	<div class="opus_design_grid">
		<div class="grid_option_left">
			<h3 class="title_design mar_btm_8">Rate</h3>
		</div>
		<script type="text/javascript">ComSheetObject('sheet3');</script>
	</div>
	           

<div id="hiddenSheetLayer" style="display: none">
<script language="javascript">ComSheetObject('sheet4');</script>
<script language="javascript">ComSheetObject('sheet5');</script>
<script language="javascript">ComSheetObject('sheet6');</script>
<script language="javascript">ComSheetObject('sheet7');</script>
<script language="javascript">ComSheetObject('sheet8');</script>
<script language="javascript">ComSheetObject('sheet9');</script>
<script language="javascript">ComSheetObject('sheet10');</script>
<script language="javascript">ComSheetObject('sheet11');</script>
<script language="javascript">ComSheetObject('sheet12');</script>
<script language="javascript">ComSheetObject('sheet13');</script>
<script language="javascript">ComSheetObject('sheet14');</script>
</div>

<script language="javascript">
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

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Please select Excel file format.</p>
</div>

</form>