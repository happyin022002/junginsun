<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0021.js
*@FileTitle  : Rate Guideline Creation - Route Point
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/25
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
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0021Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0021Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String[] termOrgCd = null;
	String[] termDesCd = null;
	String[] transCd = null;	
	
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri0021Event) request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
        termOrgCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termOrgCd"), false ,"|","\t","getCode","getName");
        termDesCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("termDesCd"), false ,"|","\t","getCode","getName");
        transCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("transCd"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var termOrgCdComboValue = " |<%=termOrgCd[0]%>";
    var termOrgCdComboText = " |<%=termOrgCd[1]%>";
    var termDesCdComboValue = " |<%=termDesCd[0]%>";
    var termDesCdComboText = " |<%=termDesCd[1]%>";    
    var transCdComboValue = " |<%=transCd[0]%>";
    var transCdComboText = " |<%=transCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="cd" id="cd" value="">
<input type="hidden" name="svc_scp_cd" id="svc_scp_cd" value="<%=StringUtil.xssFilter(request.getParameter("svc_scp_cd"))%>" >
<input type="hidden" name="gline_seq" id="gline_seq" value="<%=StringUtil.xssFilter(request.getParameter("gline_seq"))%>">
<input type="hidden" name="prc_cust_tp_cd" id="prc_cust_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("prc_cust_tp_cd"))%>">
<input type="hidden" name="cmdt_hdr_seq" id="cmdt_hdr_seq" value="<%=StringUtil.xssFilter(request.getParameter("cmdt_hdr_seq"))%>">
<input type="hidden" name="rout_seq" id="rout_seq" value="<%=StringUtil.xssFilter(request.getParameter("rout_seq"))%>">
<input type="hidden" name="org_dest_tp_cd" id="org_dest_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("org_dest_tp_cd"))%>">
<input type="hidden" name="pnt_via_tp_cd" id="pnt_via_tp_cd" value="<%=StringUtil.xssFilter(request.getParameter("pnt_via_tp_cd"))%>">
<input type="hidden" name="isEditable" id="isEditable" value="<%=StringUtil.xssFilter(request.getParameter("isEditable"))%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Rate Guideline Creation - Route Point</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Ok" 	id="btn_Ok">OK</button><!--
			--><button type="button" class="btn_normal" name="btn_Close" 		id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
		<!-- page_location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="40"/>
					<col width="200"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th class="sm pad_left_8">Route Point</th>
						<td class="sm pad_left_8">
						   <input type="radio" class="trans" name="rt_pnt" id="rt_pnt1" value="4" checked><label for="rt_pnt1">Origin</label>
						   <input type="radio" class="trans" name="rt_pnt" id="rt_pnt2" value="5" ><label for="rt_pnt2">Origin Via</label>
						   <input type="radio" class="trans" name="rt_pnt" id="rt_pnt3" value="6"><label for="rt_pnt3">Destination Via</label>
						   <input type="radio" class="trans" name="rt_pnt" id="rt_pnt4" value="7"><label for="rt_pnt4">Destination</label>
						</td>
						<td></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" id="btn_RowAdd">Row Add</button>
				<button type="button" class="btn_normal" name="btn_RowDel" 	id="btn_RowDel">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<div class="opus_design_grid clear" >
			<div id="hiddenSheetLayer" style="display: none ">
				<script type="text/javascript">ComSheetObject('sheet2');</script>
				<script type="text/javascript">ComSheetObject('sheet3');</script>
				<script type="text/javascript">ComSheetObject('sheet4');</script>
				<script type="text/javascript">ComSheetObject('sheet5');</script>
			</div>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>