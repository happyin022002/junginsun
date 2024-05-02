<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0058.jsp
*@FileTitle  : Filing Date Creation
*@author     : CLT
*@version    : 1.0 
*@since      : 2014/08/25
=========================================================*/%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.util.StringUtil" %>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scproposalmain.event.EsmPri0058Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSpHdrVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmPri0058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
	String amdtSeq = "";
	String ctrtEffDt = "";
	String ctrtExpDt = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
	String sEffDt ="";
	String sSlsLdNo = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   	   
		event = (EsmPri0058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("amdt_seq");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");		
		sEffDt = request.getParameter("sEffDt");	
		sSlsLdNo = request.getParameter("sSlsLdNo");
		sc_no = request.getParameter("sSc_No");
		if (sc_no != null && sc_no !="" && sc_no.length() >= 3){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,sc_no.length());
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script  type="text/javascript">
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
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(amdtSeq)%>" id="amdt_seq" />
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(sEffDt)%>" id="eff_dt" />
<input type="hidden" name="change_dt" value="N" id="change_dt" />
<input type="hidden" name="sls_ld_no" value="<%=StringUtil.xssFilter(sSlsLdNo)%>" id="sls_ld_no" />
<input type="hidden" name="eff_dt_chg" id="eff_dt_chg" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Filing Date Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Save" 	id="btn_Save">Save</button>
			<button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<!-- opus_design_inquiry(S) -->
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60"/>
					<col width="110"/>
					<col width="100"/>
					<col width="*"/>
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="scno1" style="width:30px;" class="input2" value="<%=scNo1%>" id="scno1" />
							<input type="text" name="scno2" style="width:65px;" class="input2" value="<%=scNo2%>" id="scno2" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:80px;" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" /> </td>
					</tr>
					<tr>
						<th>Duration</th>
						<td colspan="3"><input type="text" name="ctrt_eff_dt" style="width:70px;" class="input2" value="<%=StringUtil.xssFilter(ctrtEffDt) %>" id="ctrt_eff_dt" />
						<span class="dash">~</span>
						<input type="text" name="ctrt_exp_dt" style="width:70px;" class="input2" value="<%=StringUtil.xssFilter(ctrtExpDt) %>" id="ctrt_exp_dt" /></td>
					</tr>	
				</tbody>
			</table>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>

<div id="confirmDialog"  title="ConfirmDialog" style="display: none">
	 <p>Amendment effective date is later than Filing date, <br/>
	 	Do you want to update Effective date as Filing date?
	 </p>
</div>
</form>