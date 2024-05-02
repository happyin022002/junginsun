<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0113.jsp
*@FileTitle  : GRI Calculation Inquiry - Arbitrary
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scgricalculationproposal.event.EsmPri0113Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0113Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCGRICalculationProposal");
	

	String sPropNo		= "";
	String sAmdtSeq		= "";
	String sSvcScpCd	= "";
	String sAddChgTpCd	= "";
	String sOrgDestTpCd	= "";
	String sEffDt	= "";
	String sApplFlg = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri0113Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sPropNo = request.getParameter("prop_no");
		sAmdtSeq = request.getParameter("amdt_seq");
		sSvcScpCd = request.getParameter("svc_scp_cd");
		sAddChgTpCd = request.getParameter("add_chg_tp_cd");
		sOrgDestTpCd = request.getParameter("org_dest_tp_cd");
		sEffDt = request.getParameter("sEffDt");
        sEffDt = request.getParameter("sEffDt");
        sApplFlg = request.getParameter("sApplFlg");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="cd">

<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(sPropNo) %>">
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(sAmdtSeq) %>">
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(sSvcScpCd) %>">
<input type="hidden" name="add_chg_tp_cd" value="<%=StringUtil.xssFilter(sAddChgTpCd) %>">
<input type="hidden" name="org_dest_tp_cd" value="<%=StringUtil.xssFilter(sOrgDestTpCd) %>">
<input type="hidden" name="n1st_cmnc_dt" value="<%=StringUtil.xssFilter(sEffDt) %>">
<input type="hidden" name="n1st_cmnc_amdt_seq" value="<%=StringUtil.xssFilter(sAmdtSeq) %>">
<input type="hidden" name="gri_appl_tp_cd" value="<%=StringUtil.xssFilter(sApplFlg)%>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>GRI Calculation Inquiry - Arbitrary</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="wrap_result">
		<div class="opus_design_inquiry wFit">
			<table border="0" style="width:400px;" class="search_sm2"> 
				<tr class="h23">
						<th width="">Applying Option</th>
						<td width="" class="stm">
						<input type="radio" name="rdo_appl_option" value="F" class="trans" disabled>&nbsp;Amount&nbsp;&nbsp;
						<input type="radio" name="rdo_appl_option" value="P" class="trans" disabled>&nbsp;Percentage (%)</td>
				</tr>
			</table>
		</div>
		<script language="javascript">ComSheetObject('sheet2');</script>
	</div>
</div>

<div style="display:none">
    <script language="javascript">ComSheetObject('sheet3');</script>
    <script language="javascript">ComSheetObject('sheet4');</script>
    <script language="javascript">ComSheetObject('sheet5');</script>
    <script language="javascript">ComSheetObject('sheet6');</script>
</div>
</form>