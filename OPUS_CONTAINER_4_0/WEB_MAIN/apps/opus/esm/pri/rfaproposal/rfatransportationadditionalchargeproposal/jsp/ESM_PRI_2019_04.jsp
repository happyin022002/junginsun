<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2019_04.jsp
*@FileTitle  : RFA Proposal Origin/Destination Arbitrary Charge Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/28
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri201904Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri201904Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from Server
	String strErrMsg = "";						//Error Message
	int rowCount	 = 0;						//Number of DB ResultSet List
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String[] prcTrspModCd	= null;
	String[] ratUtCd		= null;
	String[] currCd			= null;
	String[] prcCgoTpCd		= null;
	String[] srcInfoCd		= null;
	String[] prcProgStsCd	= null;
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RFATransportationAdditionalChargeProposal");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmPri201904Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// Adding Logic extracting data from server when loading initial window ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	var prcTrspModCdValue = " |<%=prcTrspModCd[0]%>";
	var prcTrspModCdText = " |<%=prcTrspModCd[1]%>";
	var ratUtCdValue = " |<%=ratUtCd[0]%>";
	var ratUtCdText = " |<%=ratUtCd[1]%>";
	var currCdValue = "|<%=currCd[0]%>";
	var currCdText = "|<%=currCd[1]%>";
	var prcCgoTpCdValue = " |<%=prcCgoTpCd[0]%>";
	var prcCgoTpCdText = " |<%=prcCgoTpCd[1]%>";
	var srcInfoCdValue = "|<%=srcInfoCd[0]%>";
	var srcInfoCdText = "|<%=srcInfoCd[1]%>";
	var PrcProgStsCdValue = "|<%=prcProgStsCd[0]%>";
	var PrcProgStsCdText = "|<%=prcProgStsCd[1]%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input id="f_cmd" name="f_cmd" type="hidden" />
<input id="pagerows" name="pagerows" type="hidden" />
<input id="cd" name="cd" type="hidden" />
<input id="prop_no" name="prop_no" value="" type="hidden" />
<input id="amdt_seq" name="amdt_seq" value="" type="hidden" />
<input id="svc_scp_cd" name="svc_scp_cd" value="" type="hidden" />
<input id="add_chg_tp_cd" name="add_chg_tp_cd" value="A" type="hidden" />

	<!-- page_title_area(S) -->
<div class="opus_design_title clear">
	<div>
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_design_btn(E) -->
	</div>
</div>
	<!-- page_title_area(E) -->
	
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="40px" />
				<col width="10px" />
				<col width="300px" />
				<col width="%" />
			</colgroup>
			<tr>
				<th class="sm">Type</th>
				<td class="sm"></td>
				<td class="sm">
					<input type="radio" name="org_dest_tp_cd" value="O" class="trans" checked><span id="org_dest_tp_cd1">Origin Arbitrary</span>&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" name="org_dest_tp_cd" value="D" class="trans"><span id="org_dest_tp_cd2">Destination Arbitrary</span></td>
				<td></td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	
	<!-- opus_design_grid(S) -->
     <div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
     </div>
	<!-- opus_design_grid(E) -->
</form>