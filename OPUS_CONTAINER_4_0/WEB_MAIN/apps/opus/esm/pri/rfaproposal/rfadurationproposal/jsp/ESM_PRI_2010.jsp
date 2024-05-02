<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2010.jsp
*@FileTitle  : Duration
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
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri2010Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri2010Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFADurationProposal");
	
	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String rfaNo = "";
	//String rfaNo1 = "";
	//String rfaNo2 = "";
	String svcScpCd ="";
	String strUsr_ofc = "";	
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String durDupFlg = "";

	String[] srcInfoCd = null;
	String[] stsCd = null;
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	   
		event = (EsmPri2010Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
				
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");

		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		rfaNo = request.getParameter("sRfaNo");
		svcScpCd = request.getParameter("sSvcScpCd");

		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");
		durDupFlg = request.getParameter("sDurDupFlg");

		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
    var srcInfoCdValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdText = "<%=srcInfoCd[1]%>";    
    var stsCdValue = "<%=stsCd[0]%>";
    var stsCdText = "<%=stsCd[1]%>"; 
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
	function closePage(){
		unloadPage();
	}		
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(preAmdtSeq) %>" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(propStsCd) %>" id="prop_sts_cd" />
<input type="hidden" name="pre_exp_dt" id="pre_exp_dt" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="svc_scp" value="<%=StringUtil.xssFilter(svcScpCd) %>" id="svc_scp" />
<input type="hidden" name="req_usr_flg" value="<%=StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%=StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(durDupFlg) %>" id="dur_dup_flg" />
<input type="hidden" name="usr_id" value="<%=StringUtil.xssFilter(strUsr_id) %>" id="usr_id" />
<input type="hidden" name="srep_cd" value="<%=StringUtil.xssFilter(strUsr_ofc) %>" id="srep_cd" />
<input type="hidden" name="amend_flg" id="amend_flg" />
<input type="hidden" name="scp_accept" id="scp_accept" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Duration</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			    <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button> 
			    <button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button> 
			    <button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="70">
					<col width="90">
					<col width="70">
					<col width="80">
					<col width="100">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>RFA No.</th>
						<td><input type="text" name="rfaNo1" id="rfaNo1" style="width:100px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(rfaNo)%>"></td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq"  id="amdt_seq" style="width:40px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq)%>"></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" id="prop_no" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo)%>"></td>
					</tr>
				</tbody>
			</table>
			<table>
				<colgroup>
					<col width="70">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>SVC Scope</th>
						<td>    
							<script type="text/javascript">ComComboObject('svc_scp_cd', 2, 50, 0, 1, 0, false);</script><!-- 
						 --><input name="svc_scp_nm" id="svc_scp_nm" type="text" style="width:306px;"  value="" class="input2" readonly caption="Service Scope">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn">
				    <span id="Amend"><button type="button" class="btn_normal" name="btn_Amend" id="btn_Amend">Amend</button></span>
				    <span id="AmendCancel"><button type="button" class="btn_normal" name="btn_AmendCancel" id="btn_AmendCancel">Amend Cancel</button></span>
				    <span id="Accept"><button type="button" class="btn_normal" name="btn_Accept" id="btn_Accept">Accept</button></span>
				    <span id="AcceptCancel"><button type="button" class="btn_normal" name="btn_AcceptCancel" id="btn_AcceptCancel">Accept Cancel</button></span>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>