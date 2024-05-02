<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0019.jsp
*@FileTitle  : Duration
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scdurationproposal.event.EsmPri0019Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0019Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCDurationProposal");

	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String sc_no = "";
	String scNo1 = "";
	String scNo2 = "";
	String svcScpCd ="";
	String strUsr_ofc = "";	
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;

	String preExpDt = "";
	String lgcyIfFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();

		event = (EsmPri0019Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");

		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		sc_no = request.getParameter("sSc_No");
		svcScpCd = request.getParameter("sSvcScpCd");
		preExpDt = request.getParameter("sPreExpDt");

		if (sc_no != null && sc_no !="" && sc_no.length() >= 3){
			scNo1 = sc_no.substring(0,3);
			scNo2 = sc_no.substring(3,sc_no.length());
		}
		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");
		lgcyIfFlg = request.getParameter("sLgcyIfFlg");

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
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="exp_dt" id="exp_dt" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="svc_scp" value="<%=StringUtil.xssFilter(svcScpCd) %>" id="svc_scp" />
<input type="hidden" name="sts_cd" id="sts_cd" />
<input type="hidden" name="req_usr_flg" value="<%=StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%=StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" id="dur_dup_flg" />
<input type="hidden" name="usr_id" value="<%=strUsr_id %>" id="usr_id" />
<input type="hidden" name="srep_cd" value="<%=strUsr_ofc %>" id="srep_cd" />
<input type="hidden" name="amend_flg" id="amend_flg" />
<input type="hidden" name="lgcy_if_flg" value="<%=StringUtil.xssFilter(lgcyIfFlg)%>" id="lgcy_if_flg" />
<input type="hidden" name="save_all" id="save_all" />
<input type="hidden" name="amendcancel_gbn" id="amendcancel_gbn" />
<input type="hidden" name="mn_ctrt_eff_dur" id="mn_ctrt_eff_dur" />
<input type="hidden" name="mn_ctrt_exp_dur" id="mn_ctrt_exp_dur" />

<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	    <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Duration</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"> 
			 <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button> 
			 <button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button> 
			 <button type="button" class="btn_normal" name="btn_AcceptAll" 	id="btn_AcceptAll">Accept All</button> 
			 <button type="button" class="btn_normal" name="btn_CancelAll" 	id="btn_CancelAll">Accept Cancel</button> 
			 <button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
<!-- page_title_area(E) -->

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="70">
					<col width="120">
					<col width="60">
					<col width="120">
					<col width="50">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="sc_no1" style="width:50px;text-align:center;" class="input2" value="<%=scNo1%>" id="sc_no1" readonly="readonly" /><!-- 
						 --><input type="text" name="sc_no2" id="sc_no2" style="width:50px;text-align:center;" class="input2" value="<%=scNo2%>" readonly="readonly" /></td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:40px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq)%>" id="amdt_seq" readonly="readonly" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:80px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo)%>" id="prop_no" readonly="readonly" /></td>
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
						<td><script type="text/javascript">ComComboObject('svc_scp_cd', 2, 50, 1, 1, 0, false);</script><!-- 
						 --><input name="svc_scp_nm" type="text" style="width:165px;"  value="" class="input2" caption="Service Scope" readonly="readonly" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn_Amend" id="btn_Amend">Amend</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_AmendCancel"  	id="btn_AmendCancel">Amend Cancel</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_Accept" 	id="btn_Accept">Accept</button><!-- 
				 --><button type="button" class="btn_normal" name="btn_AcceptCancel" 	id="btn_AcceptCancel">Accept Cancle</button>
			</div>
			<!-- opus_design_btn(E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>