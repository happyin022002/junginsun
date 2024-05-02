<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_05.jsp
*@FileTitle  : S/C Proposal Origin/Destination IHC Charge-Creation
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.sctransportationadditionalchargeproposal.event.EsmPri000405Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.framework.component.util.code.CodeInfo"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="com.clt.framework.component.common.AbstractValueObject"%>
<%@ page import="java.util.List"%>

<%
	EsmPri000405Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

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
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCTransportationAdditionalChargeProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri000405Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		prcTrspModCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcTrspModCd"), false,"|","\t","getCode","getName");
		ratUtCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("ratUtCd"),false,"|","\t");
		currCd = PRIUtil.getValueObject2StringArray((List<RsltCdListVO>)eventResponse.getCustomData("currCd"),false,"|","\t");
		prcCgoTpCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcCgoTpCd"), true,"|","\t","getCode","getName");
		srcInfoCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("srcInfoCd"), false,"|","\t","getCode","getName");
		prcProgStsCd = PRIUtil.getValueObject2StringArray((List<CodeInfo>)eventResponse.getCustomData("prcProgStsCd"), false,"|","\t","getCode","getName");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Origin/Destination IHC Charge-Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
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
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- developer performance	-->
<input type="hidden" name="cd">
<input type="hidden" name="prop_no" value="">
<input type="hidden" name="amdt_seq" value="">
<input type="hidden" name="svc_scp_cd" value="">
<input type="hidden" name="pre_amdt_seq" value="">
<input type="hidden" name="prop_sts_cd" value="">
<input type="hidden" name="add_chg_tp_cd" value="I">
<input type="hidden" name="eff_dt" value="">
<input type="hidden" name="exp_dt" value="">
<input type="hidden" name="pre_exp_dt" value="">
<input type="hidden" name="dur_dup_flg" value="">

<input type="hidden" name="grp_loc_seq">
<input type="hidden" name="req_usr_flg">
<input type="hidden" name="apro_usr_flg">

	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	</div>

	<div class="opus_design_inquiry">
		<table style="width: 250px; margin-top:-25px;">
			<tbody class="sm">
				<tr class="h23">
					<th>Route</th>
					<td>
						<input type="radio" class="trans" name="org_dest_tp_cd"  value="O"  checked="true"><label for="org_dest_tp_cd1">Origin IHC</label><!-- 
						 --><input type="radio" class="trans" name="org_dest_tp_cd" value="D" ><label for="org_dest_tp_cd2">Destination IHC</label>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
				
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
			
	
</form>
</body>
</html>