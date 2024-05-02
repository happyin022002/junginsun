<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_3010.jsp
*@FileTitle  : TRI GRI Calculation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/07
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
<%@ page import="com.clt.apps.opus.esm.pri.triproposal.trigricalculationproposal.event.EsmPri3010Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri3010Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.TRIProposal.TRIGRICalcualtionProposal");

	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> applyTypeList = null;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri3010Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		applyTypeList = (java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo>)com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect("CD01728", 0);

	} catch (Exception e) {
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="trf_pfx_cd" value="<%=StringUtil.xssFilter(request.getParameter("trf_pfx_cd")) %>" id="trf_pfx_cd" />
<input type="hidden" name="trf_no" value="<%=StringUtil.xssFilter(request.getParameter("trf_no")) %>" id="trf_no" />
<input type="hidden" name="gri_grp_seq" id="gri_grp_seq" />
<input type="hidden" name="gri_appl_flg" id="gri_appl_flg" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>TRI GRI Calculation</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_new" 				id="btn_new">New</button> 
			<button type="button" class="btn_normal" name="btn_ok" 				id="btn_ok">OK</button>		
			<button type="button" class="btn_normal" name="btn_cancel" 			id="btn_cancel">Cancel</button>		
			<button type="button" class="btn_normal" name="btn_close" 			id="btn_close">Close</button>		
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>				
					<col width="70"/>
					<col width="390"/>
					<col width="100"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
						<th>Tariff Code</th>
						<td><script type="text/javascript">ComComboObject("trf_cd", 2, 80, 0, 1, 0, false);</script>
						    <input type="text" name="trf_nm" style="width:270px;text-align:center;" class="input2" readonly caption="Tariff Code" id="trf_nm" /> </td>
						<th>GRI Effective Date</th>
						<td><input type="text" name="gri_eff_dt" style="width:80px;text-align:center;" class="input1" caption="GRI Effective Date" maxlength="10" dataformat="ymd" id="gri_eff_dt" /><button type="button" id="btn_grieffdt" name="btn_grieffdt" class="calendar ir"></button></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">	
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_rowadd1" 				id="btn_rowadd1">Row Add</button> 
				<button type="button" class="btn_normal" name="btn_rowcopy1" 			id="btn_rowcopy1">Row Copy</button> 		
				<button type="button" class="btn_normal" name="btn_delete1" 			id="btn_delete1">Delete</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	
		<div class="opus_design_data">
			<table class="grid_2"> 
	            <tr>
	                <th><strong>CMDT Group</strong></th>
	                <th><strong>Origin</strong></th>
	                <th><strong>Origin Via</strong></th>
	                <th><strong>Destination Via</strong></th>
	                <th><strong>Destination</strong></th>
	            </tr>
	            <tr>
	                <td><textarea style="resize:none;width:100%; height:40px; overflow-x:visible;" readonly="" id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
	                <td><textarea style="resize:none;width:100%; height:40px; overflow-x:visible" readonly="" id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
	                <td><textarea style="resize:none;width:100%; height:40px; overflow-x:visible" readonly="" id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
	                <td><textarea style="resize:none;width:100%; height:40px; overflow-x:visible" readonly="" id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
	                <td><textarea style="resize:none;width:100%; height:40px; overflow-x:visible" readonly="" id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
	            </tr>
	        </table>        
		</div>	
		<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
		
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>	
					<col width="100"/>
					<col width="230"/>
					<col width="*" />				
				</colgroup> 
				<tbody>
					<tr>
	                    <th class="sm">Applying Option</th>
	                    <td class="sm">
		                    <%
		                    if (applyTypeList != null && applyTypeList.size() > 0) {
		                        for (int i = 0; i < applyTypeList.size(); i++) {
		                            com.clt.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
		                            out.print("<input name=\"flt_pct_tp_cd\" id=\"flt_pct_tp_cd_" + i + "\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\">&nbsp;");
		                            out.print("<label for=\"flt_pct_tp_cd_" + i + "\">" +row.getName()+ "</label>");
		                        }
		                    }
		                    %>
	                    </td>
	                    <td></td>
	                </tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_rowadd2" 		id="btn_rowadd2">Row Add</button>
				<button type="button" class="btn_normal" name="btn_delete2" 		id="btn_delete2">Delete</button>
				<button type="button" class="btn_normal" name="btn_save2" 			id="btn_save2">Save</button>		
			</div>
			<!-- opus_design_btn(E) -->		
			<script type="text/javascript">ComSheetObject('sheet2');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
	</div>
	
	<div id="hiddenSheetLayer" style="display: none">
	<script type="text/javascript">ComSheetObject('sheet3');</script>
	<script type="text/javascript">ComSheetObject('sheet4');</script>
	<script type="text/javascript">ComSheetObject('sheet5');</script>
	<script type="text/javascript">ComSheetObject('sheet6');</script>
	<script type="text/javascript">ComSheetObject('sheet7');</script>
	</div>
</div>
</form>