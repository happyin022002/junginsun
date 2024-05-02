<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2087.jsp
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2087Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
    EsmPri2087Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //Error from Server
	String strErrMsg = ""; //Error Message
	int rowCount = 0; //Number of DB ResultSet List

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

		event = (EsmPri2087Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(request.getParameter("prop_no")) %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(request.getParameter("amdt_seq")) %>" id="amdt_seq" />
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd")) %>" id="svc_scp_cd" />
<input type="hidden" name="gri_grp_seq" id="gri_grp_seq" />
<input type="hidden" name="gri_appl_flg" id="gri_appl_flg" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span >GRI Calculation Inquiry</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
</div>
<div class="layer_popup_contents">
<div class="wrap_result">
	<div class="opus_design_gird" >		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_data">
		<table class="grid_2">
			<colgroup>
				<col width="250">
				<col width="250">
				<col width="250">
				<col width="250">
				<col width="250">
				<col width="*">
			</colgroup>
			<tbody>
			<tr>
                <th style  = "text-align: center;"><strong>CMDT Group</strong></th>
                <th style  = "text-align: center;"><strong>Actual Customer</strong></th>
                <th style  = "text-align: center;"><strong>Origin</strong></th>
                <th style  = "text-align: center;"><strong>Origin Via</strong></th>
                <th style  = "text-align: center;"><strong>Destination Via</strong></th>
                <th style  = "text-align: center;"><strong>Destination</strong></th>
            </tr>
            <tr>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible;" readonly id="cmdt_desc" name="cmdt_desc" class="textarea2"></textarea></td>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible" readonly id="actcust_desc" name="actcust_desc" class="textarea2"></textarea></td>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible" readonly id="origin_desc" name="org_desc" class="textarea2"></textarea></td>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible" readonly id="ovia_desc" name="ovia_desc" class="textarea2"></textarea></td>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible" readonly id="dvia_desc" name="dvia_desc" class="textarea2"></textarea></td>
                <td><textarea style="resize:none; width:100%; height:40px; overflow-x:visible" readonly id="dest_desc" name="dest_desc" class="textarea2"></textarea></td>
            </tr>
           </tbody>
		</table>
</div>
<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="110">
				<col width="*">
			</colgroup>
			<tbody>
			<tr>              
                 <th style  = "text-align: center;"><strong>Applying Option</strong></th>
                 <td>
                 <%
                 if (applyTypeList != null && applyTypeList.size() > 0) {
                     for (int i = 0; i < applyTypeList.size(); i++) {
                         com.clt.framework.component.util.code.CodeInfo row = applyTypeList.get(i);
                         out.print("<input name=\"flt_pct_tp_cd\" value=\"" + row.getCode() + "\" type=\"radio\" class=\"trans\" disabled>&nbsp;" + row.getName() + "&nbsp;&nbsp;");
                     }
                 }
                 %>
                 </td>
			</tr>
		</tbody>
 	</table>
</div>
<div class="opus_design_gird" >		
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