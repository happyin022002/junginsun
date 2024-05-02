<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2058.jsp
*@FileTitle  : RFA Proposal Creation [Amend] (DEM&DET)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/23
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri2058Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri2058Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RfaProposalDEMDET");

	String propNo = "";
	String propNo1 = "";
	String propNo2 = "";
	String svcScpCd = "";
	String svcScpDesc = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String effDt = "";
	String expDt = "";
	String preExpDt = "";
	String rfaNo = "";
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String durDupFlg = "";
	String[] dmdtFtTpCd		= null;
	String[] srcInfoCd		= null;
	String[] prcProgStsCd	= null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri2058Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		propNo = request.getParameter("sPropNo") == null ? "" : request.getParameter("sPropNo") ;
		amdtSeq = request.getParameter("sAmdtSeq");	
		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");

		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		preExpDt = request.getParameter("sPreExpDt");	
		rfaNo = request.getParameter("sRfaNo");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");
		durDupFlg = request.getParameter("sDurDupFlg");

		if(propNo != "" && propNo.length() == 9) {
			propNo1 = propNo.substring(0,3);
			propNo2 = propNo.substring(3,9);
		}
		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");	

		dmdtFtTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("dmdtFtTpCd"), false,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var dmdtFtTpCdValue = "|<%=dmdtFtTpCd[0]%>";
	var dmdtFtTpCdText = "|<%=dmdtFtTpCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
	function closePage(){
		unloadPage();
	}			
</script>

<form name="form" id="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer performance	-->
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="pre_amdt_seq" value="<%= StringUtil.xssFilter(preAmdtSeq) %>" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="<%= StringUtil.xssFilter(propStsCd) %>" id="prop_sts_cd" />
<input type="hidden" name="pre_exp_dt" value="<%= StringUtil.xssFilter(preExpDt) %>" id="pre_exp_dt" />
<input type="hidden" name="eff_dt" value="<%= StringUtil.xssFilter(effDt) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%= StringUtil.xssFilter(expDt) %>" id="exp_dt" />
<input type="hidden" name="req_usr_flg" value="<%= StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%= StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(durDupFlg)%>" id="dur_dup_flg" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>RFA Proposal Creation [Amend] (DEM&DET)</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button>
			<button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button>
			<button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button>
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

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents" style="overflow:auto; overflow:hidden;">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />				
					<col width="130" />				
					<col width="60" />				
					<col width="60" />				
					<col width="80" />	
					<col width="130" />	
					<col width="60" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>RFA No.</th>
						<td><input type="text" name="rfaNo" id="rfaNo" value="<%=StringUtil.xssFilter(rfaNo)%>" style="width:100px;text-align:center;" class="input2" readonly></td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" id="amdt_seq" value="<%=StringUtil.xssFilter(amdtSeq)%>" style="width:35px;text-align:center;" class="input2" readonly></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" id="prop_no" value="<%=StringUtil.xssFilter(propNo)%>" style="width:100px;text-align:center;" class="input2" readonly></td>
						<th>Duration</th>
						<td><input type="text" name="ctrt_eff_dt"  id="ctrt_eff_dt" value="<%=StringUtil.xssFilter(ctrtEffDt)%>" maxlength="10" dataformat="ymd" style="width:70px;text-align:center;" class="input2" caption="Eff Date" readOnly>~&nbsp;<!-- 
							 --><input type="text" name="ctrt_exp_dt"  id="ctrt_exp_dt" value="<%=StringUtil.xssFilter(ctrtExpDt)%>" maxlength="10" dataformat="ymd" style="width:70px;text-align:center;" class="input2" caption="Expire Date" readOnly></td>
			   		</tr>
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_amend" id="btn_amend" type="button">Amend</button>
				<button class="btn_normal" name="btn_amendcancel" id="btn_amendcancel" type="button">Amend Cancel</button>
				<button class="btn_normal" name="btn_accept" id="btn_accept" type="button">Accept</button>
				<button class="btn_normal" name="btn_acceptcancel" id="btn_acceptcancel" type="button">Accept Cancel</button>
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>			
<!-- popup_contens_area(S) -->
</form>