<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ESM_PRI_0017.jsp
*@FileTitle  : Customer Type Amend Creation
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.event.EsmPri0017Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%
	EsmPri0017Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCContractPartyProposal");
	
	
	String propNo = "";	
	String amdtSeq = "";
	String prcCtrtPtyTpCd = "";
	String preAmdtSeq = "";
	String propStsCd = "";	
	String effDt = "";
	String expDt = "";
	String preExpDt = "";

	String repUsrFlg = "";
	String aproUsrFlg = "";
	String durDupFlg = "";
	
	String[] custTpCd = null;	
	String[] srcInfoCd = null;
	String[] stsCd = null;
	String lgcyIfFlg = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0017Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		propNo = request.getParameter("sPropNo");
		amdtSeq = request.getParameter("sAmdtSeq");
		prcCtrtPtyTpCd = request.getParameter("sPrcCtrtPtyTpCd");	
		preAmdtSeq = request.getParameter("sPreAmdtSeq");
		propStsCd = request.getParameter("sPropStsCd");
		effDt = request.getParameter("sEffDt");
		expDt = request.getParameter("sExpDt"); 
		preExpDt = request.getParameter("sPreExpDt");		

		repUsrFlg = request.getParameter("sIsReqUsr");		
		aproUsrFlg = request.getParameter("sIsAproUsr");		
		durDupFlg = request.getParameter("sDurDupFlg");
		lgcyIfFlg = request.getParameter("sLgcyIfFlg");
		custTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("custTypeList"), true ,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoList"), false ,"|","\t","getCode","getName");	
		stsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("stsList"), false ,"|","\t","getCode","getName");	
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var custTpCdValue = "<%=custTpCd[0]%>";
    var custTpCdText = "<%=custTpCd[1]%>";
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
<input type="hidden" name="cd" id="cd" />
<input type="hidden" name="prop_no" value="<%=StringUtil.xssFilter(propNo) %>" id="prop_no" />
<input type="hidden" name="amdt_seq" value="<%=StringUtil.xssFilter(amdtSeq) %>" id="amdt_seq" />
<input type="hidden" name="prc_ctrt_pty_tp_cd" value="C" id="prc_ctrt_pty_tp_cd" />
<input type="hidden" name="pre_amdt_seq" value="<%=StringUtil.xssFilter(preAmdtSeq) %>" id="pre_amdt_seq" />
<input type="hidden" name="prop_sts_cd" value="<%=StringUtil.xssFilter(propStsCd) %>" id="prop_sts_cd" />
<input type="hidden" name="eff_dt" value="<%=StringUtil.xssFilter(effDt) %>" id="eff_dt" />
<input type="hidden" name="exp_dt" value="<%=StringUtil.xssFilter(expDt) %>" id="exp_dt" />
<input type="hidden" name="pre_exp_dt" value="<%=StringUtil.xssFilter(preExpDt) %>" id="pre_exp_dt" />
<input type="hidden" name="req_usr_flg" value="<%=StringUtil.xssFilter(repUsrFlg) %>" id="req_usr_flg" />
<input type="hidden" name="apro_usr_flg" value="<%=StringUtil.xssFilter(aproUsrFlg) %>" id="apro_usr_flg" />
<input type="hidden" name="dur_dup_flg" value="<%=StringUtil.xssFilter(durDupFlg) %>" id="dur_dup_flg" />
<input type="hidden" name="lgcy_if_flg" value="<%=StringUtil.xssFilter(lgcyIfFlg)%>" id="lgcy_if_flg" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><span>Customer Type Amend Creation</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" 	id="btn_Retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_Save" 		id="btn_Save">Save</button><!--
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
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
		<div class="opus_design_grid clear" >
			<div class="opus_design_btn">
				<button type="button" class="btn_accent" name="btn_Amend" id="btn_Amend">Amend</button><!--
				--><button type="button" class="btn_normal" name="btn_AmendCancel" 	id="btn_AmendCancel">Amend Cancel</button><!--
				--><button type="button" class="btn_normal" name="btn_Accept" 	id="btn_Accept">Accept</button><!--
				--><button type="button" class="btn_normal" name="btn_AcceptCancel" 	id="btn_AcceptCancel">Accept Cancel</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>
