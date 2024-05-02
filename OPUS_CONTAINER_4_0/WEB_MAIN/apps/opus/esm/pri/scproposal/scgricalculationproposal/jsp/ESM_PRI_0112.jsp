<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0112.js
*@FileTitle  : GRI Calculation Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/15
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0112Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri0112Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list
	String successFlag = "";
	String codeList = "";
	String pageRows = "100";
	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCGRICalcualtionProposal");
	java.util.ArrayList<com.clt.framework.component.util.code.CodeInfo> applyTypeList = null;
	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri0112Event) request.getAttribute("Event");
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
<!-- developer performance	-->
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no")) %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>" id="svc_scp_cd" />
<input type="hidden" name="gen_spcl_rt_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("gen_spcl_rt_tp_cd")) %>" id="gen_spcl_rt_tp_cd" />
<input type="hidden" name="gri_grp_seq" id="gri_grp_seq" />
<input type="hidden" name="gri_appl_flg" id="gri_appl_flg" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>GRI Calculation Inquiry</span></h2>
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_close" id="btn_close" type="button">Close</button>
		</div>
	</div>
</div>
<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
<!-- page_title_area(E) -->
	<div class="wrap_result">
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>	
		<div class="opus_design_data">	
			<table class="grid_2">
		        <tr>
		            <th><strong>CMDT Group</strong></th>
		            <th><strong>Actual Customer</strong></th>
		            <th><strong>Origin</strong></th>
		            <th><strong>Origin Via</strong></th>
		            <th><strong>Destination Via</strong></th>
		            <th><strong>Destination</strong></th>
		        </tr>
		        <tr>
		            <td><textarea style="width:100%; height:40; overflow-x:visible;" readonly="readonly" id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
		            <td><textarea style="width:100%; height:40; overflow-x:visible" readonly="readonly" id="actcust_desc" name="actcust_desc" class="textarea2"></textarea></td>
		            <td><textarea style="width:100%; height:40; overflow-x:visible" readonly="readonly" id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
		            <td><textarea style="width:100%; height:40; overflow-x:visible" readonly="readonly" id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
		            <td><textarea style="width:100%; height:40; overflow-x:visible" readonly="readonly" id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
		            <td><textarea style="width:100%; height:40; overflow-x:visible" readonly="readonly" id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
		        </tr>
	        </table>
	    </div>
	    <div class="opus_design_grid"><table class="line_bluedot"><tr><td></td></tr></table></div>
        <div class="opus_design_grid">
	        <div class="grid_option_left">
	       	  <table>
	               <tr>
	                   <th>Applying Option</th>
	                   <td class="pad_left_12">
		                   <%
		                   if (applyTypeList != null && applyTypeList.size() > 0) {
		                       for (int i = 0; i < applyTypeList.size(); i++) {
		                           com.clt.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
		                           out.print("<input name=\"flt_pct_tp_cd\" id=\"flt_pct_tp_cd_" + i + "\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\" disabled>" + "<label for='flt_pct_tp_cd_" + i + "'>" + row.getName() + "</label>");
		                       }
		                   }
		                   %>
	                   </td>
	                   <td></td>
	               </tr>
               </table>
	        </div>
        </div> 
        <div class="opus_design_grid">
        	<script type="text/javascript">ComSheetObject('sheet2');</script>  
        </div>
        <div id="hiddenSheetLayer" style="display: none">
			<script type="text/javascript">ComSheetObject('sheet3');</script>
			<script type="text/javascript">ComSheetObject('sheet4');</script>
			<script type="text/javascript">ComSheetObject('sheet5');</script>
			<script type="text/javascript">ComSheetObject('sheet6');</script>
			<script type="text/javascript">ComSheetObject('sheet7');</script>
			<script type="text/javascript">ComSheetObject('sheet8');</script>
		</div>      
	</div>
</div>
</form>