<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0020.jsp
*@FileTitle  : MQC
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scmqcproposal.event.EsmPri0020Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri0020Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;         //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";

	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCMQCProposal");

	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
	//String effDt = "";
	//String expDt = "";
	String preExpDt = "";
	String svcScpCd ="";	
	String repUsrFlg = "";
	String aproUsrFlg = "";
	//String durDupFlg = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	//String[] scopeCd = null;
	String[] lodUtCd = null;
	String lgcyIfFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0020Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}


		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	

		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		svcScpCd = request.getParameter("sSvcScpCd");
		sc_no = request.getParameter("sSc_No");
		preExpDt = request.getParameter("sPreExpDt");
		
		if (sc_no != null && sc_no !="" && sc_no.length() >= 3){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,sc_no.length());
		}	
		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");
		lgcyIfFlg = request.getParameter("sLgcyIfFlg");
		//durDupFlg = request.getParameter("sDurDupFlg");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
		//scopeCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("scopeList"), true);
		lodUtCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("lodUtList"), false ,"|","\t","getCode","getName");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

    var lodUtCdValue = "<%=lodUtCd[0]%>";
    var lodUtCdText = "<%=lodUtCd[1]%>";  
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
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(preExpDt) %>" id="pre_exp_dt" />
<input type="hidden" name="svc_scp" value="<%=StringUtil.xssFilter(svcScpCd) %>" id="svc_scp" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="main_eff_dt" id="main_eff_dt" />
<input type="hidden" name="main_exp_dt" id="main_exp_dt" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="edt_flg" id="edt_flg" />
<input type="hidden" name="sts_cd" id="sts_cd" />
<input type="hidden" name="req_usr_flg" value="<%=StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%=StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="dur_sub_dup_flg" id="dur_sub_dup_flg" />
<input type="hidden" name="srep_cd" value="<%=strUsr_ofc %>" id="srep_cd" />
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" id="usr_id" />
<input type="hidden" name="lgcy_if_flg" value="<%=StringUtil.xssFilter(lgcyIfFlg)%>" id="lgcy_if_flg" />
<input type="hidden" name="save_gbn" id="save_gbn" />
<input type="hidden" name="save_scp" id="save_scp" />
<input type="hidden" name="amendcancel_gbn" id="amendcancel_gbn" />

<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>MQC</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_AcceptAll" id="btn_AcceptAll" type="button">Accept All</button>
			<button class="btn_normal" name="btn_CancelAll" id="btn_CancelAll" type="button">Accept Cancel</button>
			<button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70" />				
					<col width="120"/>				
					<col width="60" />				
					<col width="60" />				
					<col width="80" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
			   			<th>S/C No.</th>
						<td><input type="text" name="scNo1" style="width:52px;text-align:center;" class="input2" value="<%=scNo1%>" id="scNo1" readonly="readonly" />
							<input type="text" name="scNo2" id="scNo2" style="width:50px;text-align:center;" class="input2" value="<%=scNo2%>" readonly="readonly" /></td>
						<th>AMD No.</th>
						<td><input type="text" style="width:40px;text-align:center;" name="amdt_seq" class="input2" value="<%=StringUtil.xssFilter(amdtSeq) %>" id="amdt_seq" readonly="readonly" /></td>
						<th>Proposal No.</th>
						<td><input type="text" style="width:104px;text-align:center;" name="prop_no" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" readonly="readonly" /></td>
			   		</tr>
			   		<tr>
						<th>SVC Scope</th>
						<td colspan="5"><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 52, 1, 1, 0, false);</script>
										<input type="text" style="width:368px;" name="svc_scp_nm" id="svc_scp_nm" class="input2" readonly="readonly" ></td>
					</tr>
			   		<tr>
						<th>Duration</th>
						<td colspan="2"><input type="text" style="width:75px;" name ="dur_eff_dt" id ="dur_eff_dt" class="input2" readonly="readonly" />
										<span class="dash">~</span>
										<input type="text" style="width:75px;" name ="dur_exp_dt" id ="dur_exp_dt" class="input2" readonly="readonly" /></td>
						<th colspan="2">S/C MQC</th>
						<td><input type="text" style="width:55px;text-align:right;" name = "sc_mqc" id = "sc_mqc" class="input2" readonly="readonly" />
							<input type="text" style="width:45px;" name = "unit" id = "unit" class="input2" readonly="readonly" /></td>
					</tr>
			   		
			   </tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result" style="overflow:hidden;">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<!-- opus_design_btn (S) -->
			<div class="opus_design_btn">
				<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button>
				<button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button>
				<button class="btn_normal" name="btn_Amend" id="btn_Amend" type="button">Amend</button>
				<button class="btn_normal" name="btn_AmendCancel" id="btn_AmendCancel" type="button">Amend Cancel</button>
				<button class="btn_normal" name="btn_Accept" id="btn_Accept" type="button">Accept</button>
				<button class="btn_normal" name="btn_AcceptCancel" id="btn_AcceptCancel" type="button">Accept Cancel</button>
			</div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
		
		<table class="line_bluedot"><tr><td></td></tr></table>
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
			   <tbody>
			   		<tr>
			   			<td>
			   				<select name="selectMqc" id="selectMqc" style="width:90px;"class="input2">								
								<option name="subMqc" value="0" selected></option>
								<option name="subMqc" value="1" >SUB MQC</option>
							</select>
						</td>
			   		</tr>
			   	</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
		
		<div id="subDivMqc" style="display:none">	
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<!-- opus_design_btn (S) -->
				<div class="opus_design_btn">
					<button class="btn_accent" name="btn_New2" id="btn_New2" type="button">New</button>
					<button class="btn_normal" name="btn_Delete2" id="btn_Delete2" type="button">Delete</button>
					<button class="btn_normal" name="btn_Save2" id="btn_Save2" type="button">Save</button>
					<button class="btn_normal" name="btn_Amend2" id="btn_Amend2" type="button">Amend</button>
					<button class="btn_normal" name="btn_AmendCancel2" id="btn_AmendCancel2" type="button">Amend Cancel</button>
					<button class="btn_normal" name="btn_Accept2" id="btn_Accept2" type="button">Accept</button>
					<button class="btn_normal" name="btn_AcceptCancel2" id="btn_AcceptCancel2" type="button">Accept Cancel</button>
				</div>
				<!-- opus_design_btn (E) -->
				<script type="text/javascript">ComSheetObject('sheet2');</script>		
			</div>
			<!-- opus_design_grid(E) -->
		</div>
	</div>
</div>
</form>