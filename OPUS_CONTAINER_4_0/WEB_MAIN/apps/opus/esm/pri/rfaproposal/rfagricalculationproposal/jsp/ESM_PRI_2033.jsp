<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_2033.jsp
*@FileTitle  : RFA Proposal Creation - Rate [GRI Calculation]
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2033Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2033Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFAGRICalcualtionProposal");
	
	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> applyTypeList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2033Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		applyTypeList = (java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo>)com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01728", 0);

	} catch (Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
		loadPage();
	}

</script>

<form name="form"><input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer job	-->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no"))%>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq"))%>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>">
<input type="hidden" name="gri_grp_seq">
<input type="hidden" name="gri_appl_flg">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>RFA Proposal Creation - Rate [GRI Calculation]</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_ok" id="btn_ok">OK</button>
			<button type="button" class="btn_normal" name="btn_cancel" id="btn_cancel">Cancel</button>
			<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd1" id="btn_rowadd1">Row Add</button>
				<button type="button" class="btn_normal" name="btn_rowcopy1" id="btn_rowcopy1">Row Copy</button>
				<button type="button" class="btn_normal" name="btn_delete1" id="btn_delete1">Delete</button>
			</div>
			<!-- opus_grid_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_data">
			<table class="grid2"> 
            <tr class="tr2_head">
                <th width="17%">CMDT Group</th>
                <th width="17%">Actual Customer</th>
                <th width="17%">Origin</th>
                <th width="17%">Origin Via</th>
                <th width="17%">Destination Via</th>
                <th width="17%">Destination</th>
            </tr>
            <tr>
                <td><textarea style="width:100%; height:40px; overflow-x:visible;" readonly id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40px; overflow-x:visible" readonly id="actcust_desc" name="actcust_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40px; overflow-x:visible" readonly id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40px; overflow-x:visible" readonly id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40px; overflow-x:visible" readonly id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
                <td><textarea style="width:100%; height:40px; overflow-x:visible" readonly id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
            </tr>
            </table>
		</div>
		<div style="height: 15px;"></div>
		<div class="opus_design_grid" >
			<div class="grid_option_left">
				<table> 
               		<tr>
                   		<th>Applying Option</th>
                   		<td style="padding-left:15px;">
		                   <%
		                   if (applyTypeList != null && applyTypeList.size() > 0) {
		                       for (int i = 0; i < applyTypeList.size(); i++) {
		                           com.clt.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
		                           out.print("<input name=\"flt_pct_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\">&nbsp;" + row.getName() + "&nbsp;&nbsp;");
		                       }
		                   }
		                   %>
                   		</td>
               		</tr>
               </table>
			</div>
			
			<!-- opus_grid_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_normal" name="btn_rowadd2" id="btn_rowadd2">Row Add</button>
				<button type="button" class="btn_normal" name="btn_delete2" id="btn_delete2">Delete</button>
				<button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
			</div>
			<!-- opus_grid_btn(E) -->
		
			<script type="text/javascript">ComSheetObject('sheet2');</script>
		</div>
	</div>
</div>

<div id="hiddenSheetLayer" style="display: none">
<script type="text/javascript">ComSheetObject('sheet3');</script>
<script type="text/javascript">ComSheetObject('sheet4');</script>
<script type="text/javascript">ComSheetObject('sheet5');</script>
<script type="text/javascript">ComSheetObject('sheet6');</script>
<script type="text/javascript">ComSheetObject('sheet7');</script>
<script type="text/javascript">ComSheetObject('sheet8');</script>
</div>
</form>