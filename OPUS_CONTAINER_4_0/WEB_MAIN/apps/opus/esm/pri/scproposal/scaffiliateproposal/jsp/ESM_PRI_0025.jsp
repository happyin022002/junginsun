<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0025.jsp
*@FileTitle  : Proposal Affiliate Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.event.EsmPri0025Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0025Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCAffiliateProposal");

	String propNo = "";
	String amdtSeq = "";
	String preAmdtSeq = "";
	String propStsCd = "";
	String effDt = "";
	String expDt = "";
	String preExpDt = "";
	String sc_no = "";
	String repUsrFlg = "";
	String aproUsrFlg = "";
	String ctrtExpDt = "";
	String ctrtEffDt = "";
	String durDupFlg = "";
	String[] srcInfoCd = null;
	String[] stsCd = null;
	String lgcyIfFlg = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0025Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");	
		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		preExpDt = request.getParameter("sPreExpDt");	
		sc_no = request.getParameter("sSc_No");
		ctrtExpDt = request.getParameter("sCtrtExpDt");
		ctrtEffDt = request.getParameter("sCtrtEffDt");
		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");	
		durDupFlg = request.getParameter("sDurDupFlg");
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
			ComShowMessage(errMessage);
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
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(effDt) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(expDt) %>" id="exp_dt" />
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="sts_cd" id="sts_cd" />
<input type="hidden" name="req_usr_flg" value="<%=StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%=StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(durDupFlg) %>" id="dur_dup_flg" />
<input type="hidden" name="lgcy_if_flg" value="<%=StringUtil.xssFilter(lgcyIfFlg)%>" id="lgcy_if_flg" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
   <!-- page_title(S) -->
	<h2 class="page_title"><span>Proposal Affiliate Creation</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button>
		<button type="button" class="btn_normal" name="btn_AcceptAll" id="btn_AcceptAll">Accept All</button>
		<button type="button" class="btn_normal" name="btn_CancelAll" id="btn_CancelAll">Accept Cancel</button>
		<button type="button" class="btn_normal" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button>
		<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
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
<div class="layer_popup_contents" style="overflow:hidden">	
	<div class= "wrap_search">
		<div class= "opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="50" />
					<col width="120" />
					<col width="55" />
					<col width="80" />
					<col width="80" />
					<col width="130" />
					<col width="60" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No.</th>
						<td><input type="text" name="scNo" style="width:90px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(sc_no)%>" id="scNo" readonly="readonly" /></td>
						<th>AMD No.</th>
						<td><input type="text" name="amdt_seq" style="width:50px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(amdtSeq) %>" id="amdt_seq" readonly="readonly" /></td>
						<th>Proposal No.</th>
						<td><input type="text" name="prop_no" style="width:90px;text-align:center;" class="input2" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" readonly="readonly" /></td>
						<th>Duration</th>
						<td><input type="text" name="hdr_eff_dt" style="width:85px; text-align:center;" class="input2" caption="Eff Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtEffDt)%>" id="hdr_eff_dt" readonly="readonly" />~ <!--  
							 --><input type="text" name="hdr_exp_dt" style="width:85px; text-align:center;" class="input2" caption="Expire Date" maxlength="10" dataformat="ymd" value="<%=StringUtil.xssFilter(ctrtExpDt)%>" id="hdr_exp_dt" readonly="readonly" /></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>		
	<!-- opus_design_grid(S) -->	
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_RowAdd" 	id="btn_RowAdd">Row&nbsp;Add</button>
				<button type="button" class="btn_normal" name="btn_Delete" id="btn_Delete">Delete</button>
				<button type="button" class="btn_normal" name="btn_Amend" id="btn_Amend">Amend</button>
				<button type="button" class="btn_normal" name="btn_AmendCancel" id="btn_AmendCancel">Amend Cancel</button>
				<button type="button" class="btn_normal" name="btn_Accept" id="btn_Accept">Accept</button>
				<button type="button" class="btn_normal" name="btn_AcceptCancel" id="btn_AcceptCancel">Accept Cancel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>