<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0048.jsp
*@FileTitle  : Proposal  Affiliates - Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/27
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.event.EsmPri0048Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>

<%
	EsmPri0048Event  event = null;				// PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCAffiliateProposal");

	String propNo = "";
	String amdtSeq = "";
	String effDt = "";
	String expDt = "";
	String scNo = "";
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0048Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");
		scNo = request.getParameter("sSc_No");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>"; 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(effDt) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(expDt) %>" id="exp_dt" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="sts_cd" id="sts_cd" />

 <div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>S/C Proposal Inquiry - Affiliate</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
	
	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />				
					<col width="120" />				
					<col width="60" />				
					<col width="70" />				
					<col width="80" />	
					<col width="100" />				
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>S/C No.</th>
						<td><input type="text" name="scNo" style="width:100px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(scNo)%>" readonly="" id="scNo" /> </td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:50px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq) %>" readonly id="amdt_seq" /> </td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:90px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" readonly id="prop_no" /> </td>
						<th>Duration</th>
						<td><input type="text" name="hdr_eff_dt" style="width:85px;text-align:center;" class="input2" caption="Eff Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtEffDt)%>" readonly id="hdr_eff_dt" /><span class="dash">~</span> 
						 <input type="text" name="hdr_exp_dt" style="width:85px;text-align:center;" class="input2" caption="Expire Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtExpDt)%>" readonly="" id="hdr_exp_dt" />
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>