<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0056.jsp
*@FileTitle  : S/C No. Assignment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0056Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCProposalMain");
	
	String propNo = "";
	String ctrtEffDt = "";
	String ctrtExpDt = "";
	
	String svcScpCd = "";
	String svcCnt = "";
	String ofcCd = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmPri0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
				
		propNo = request.getParameter("sPropNo");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");		
		svcScpCd = request.getParameter("svcScpCd");
		svcCnt = request.getParameter("svcCnt");		
		ofcCd = request.getParameter("sOfcCd");

	}catch(Exception e) {
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
<!-- developer job	-->
<input type="hidden" name="svc_scp_cd" value="<%=StringUtil.xssFilter(svcScpCd) %>" id="svc_scp_cd" />
<input type="hidden" name="svcCnt" value="<%=StringUtil.xssFilter(svcCnt) %>" id="svcCnt" />
<input type="hidden" name="ofc_cd" value="<%=StringUtil.xssFilter(ofcCd) %>" id="ofc_cd" />

<!-- layer_popup_title(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<!-- page_title(S) -->
			<h2 class="page_title"><span>S/C No. Assignment</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_Ok" id="btn_Ok">OK</button> 
		        <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- layer_popup_title(E) -->

<!-- layer_popup_contents(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table id="mainTable">
				<colgroup>
					<col width="242">
					<col width="90">
					<col width="100">
					<col width="200">
				</colgroup>
				<tbody>
					<tr>
						<th>Proposal No.</th>
						<td>
							<input type="text" name="prop_no" style="width:93px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" />
						</td>
						<th>Duration</th>
						<td>
							<input type="text" name="ctrt_eff_dt" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(ctrtEffDt) %>" id="ctrt_eff_dt" /> 
							<span class="dash">~</span> 
							<input type="text" name="ctrt_exp_dt" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(ctrtExpDt) %>" id="ctrt_exp_dt" />
						</td> 
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="120">
					<col width="100">
					<col width="130">
					<col width="200">
				</colgroup>
				<tbody>
					<tr>
						<th class="sm"><input type="radio" style="width:30px;" name="opt_sc" class="trans" checked="" id="opt_sc" />General S/C  No.</th>
						<td class="sm">
						    <input type="text" name="spre_fix" dataformat="engup" style="width:35px;text-align:center;" maxlength="3" minlength="3" fulfil="" class="input" caption="S/C PreFix" id="spre_fix" /> 
						    <input type="text" name="ssc_no" dataformat="num" style="width:50px;text-align:center;" maxlength="6" minlength="6" fulfil="" class="input" caption="S/C no" id="ssc_no" />
						</td>
						<th class="sm">
							<input type="radio" style="width:30px;" name="opt_sc" class="trans" id="opt_sc" />Global S/C No.
						</th>
						<td class="sm">
							<input type="text" name="gpre_fix" fulfil="" dataformat="engup" maxlength="3" style="width:35px;text-align:center;" class="input" value="GLO" id="gpre_fix" /> 
							<input type="text" name="gsc_no" fulfil="" dataformat="num" style="width:50px;text-align:center;" maxlength="6" class="input" caption="S/C no" id="gsc_no" />
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<!-- <div class="wrap_result">  -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	<!-- </div> -->	
</div>
<!-- layer_popup_contents(E) -->
</form>