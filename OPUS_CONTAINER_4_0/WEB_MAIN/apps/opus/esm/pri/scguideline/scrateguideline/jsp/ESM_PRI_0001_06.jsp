<%  
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0001_06.jsp
*@FileTitle  : Rate Guideline Creation 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/30
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
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri000106Event"%>
<%@ page import="org.apache.log4j.Logger"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>

<%
	EsmPri000106Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCGuidelineMain");
	ArrayList<CodeInfo> custTypeCdList = null;
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
		event = (EsmPri000106Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		custTypeCdList = (ArrayList<CodeInfo>)eventResponse.getCustomData("custTypeCdList");
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
    var ratUtCdValue = "|<%=ratUtCdList[0]%>";
    var ratUtCdText = "|<%=ratUtCdList[1]%>";
    var prcCgoTpCdValue = "|<%=prcCgoTpCdList[0]%>";
    var prcCgoTpCdText = "|<%=prcCgoTpCdList[1]%>";
    var currCdValue = "|<%=currCdList[0]%>";
    var currCdText = "|<%=currCdList[1]%>";
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


<form name="form" id="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" type="hidden" />
<input id="gline_seq" name="gline_seq" type="hidden" />
<input id="cmdt_hdr_seq" name="cmdt_hdr_seq" type="hidden" />
<input id="rout_seq" name="rout_seq" type="hidden" />

<div>
	<!-- page_title_area(S) -->
	<div>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--  
			--><button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_loadexcel" id="btn_loadexcel">Load Excel</button><!--
			--><button type="button" class="btn_normal" name="btn_mqc" id="btn_mqc">MQC</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry" style="width:600px;margin-top:-25px;">
		<table>
			<colgroup>
				<col width="10px" />
				<col width="40px" />
				<col width="10px" />
				<col width="300px" />
				<col width="%" />
			</colgroup>
			<tr>
				<td></td>
				<th class="sm">Customer Type</th>
				<td class="sm"></td>
				<td class="sm"  id="rdoCustTp">
					<%
					if (custTypeCdList != null && custTypeCdList.size() > 0) {
						for (int i = 0; i < custTypeCdList.size(); i++) {
							CodeInfo row = custTypeCdList.get(i);
							out.print("<input name=\"prc_cust_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\"");
							if (i == 0) {
								out.print(" checked");
							}
							out.print(">&nbsp;" + row.getName());
							out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
						}
					}
					%>
				</td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->

	
	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
	     	 <h3 class="title_design">Commodity Group</h3>
	         <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_rowcopy1" id="btn_rowcopy1">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save1" id="btn_save1">Save</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	    </div>
	<!-- opus_design_grid(E) -->
	
	
	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
	     	 <h3 class="title_design">Route Detail</h3>
	         <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_rowcopy2" id="btn_rowcopy2">Row Copy</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet2');</script>
			<div class="opus_design_data">
				<table  class="grid2"> 
		            <tr>
		                <th width="25%" style="font-weight: bold; text-align: center;">Origin</th>
		                <th width="25%" style="font-weight: bold; text-align: center;">Origin Via</th> 
		                <th width="25%" style="font-weight: bold; text-align: center;">Destination Via</th>    
		                <th width="25%" style="font-weight: bold; text-align: center;">Destination</th>          
		            </tr>
		            <tr>
		            	<td class="input2"><textarea name="origin_desc" id="origin_desc" style="width:100%;resize:none;" rows="3" class="textarea2" readonly></textarea></td>
						<td class="input2"><textarea name="ovia_desc" id="ovia_desc" style="width:100%;resize:none;" rows="3" class="textarea2" readonly></textarea></td>
						<td class="input2"><textarea name="dvia_desc" id="dvia_desc"  style="width:100%;resize:none;" rows="3" class="textarea2" readonly></textarea></td>
						<td class="input2"><textarea name="dest_desc" id="dest_desc"  style="width:100%;resize:none;" rows="3" class="textarea2" readonly></textarea></td>
		            </tr>
	       	 	</table>
			</div>
	    </div>
	<!-- opus_design_grid(E) -->
	
	
	<!-- opus_design_grid(S) -->
	     <div class="opus_design_grid">
	     	 <h3 class="title_design">Rate</h3>
	         <div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd3" id="btn_rowadd3">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_delete3" id="btn_delete3">Delete</button><!-- 
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
</div>
</form>