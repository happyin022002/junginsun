<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0004_08.jsp
*@FileTitle  : S/C Proposal Standard Note - Inquiry
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.event.EsmPri000408Event"%>
<%@ page import="com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%@ page import="com.clt.apps.opus.esm.pri.common.PRIUtil"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri000408Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String[] srcInfoCd = null;		//Source
	String[] prcProgStsCd = null;	//Status
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCNoteProposal");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmPri000408Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		 
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		//COMMBO LIST
		srcInfoCd 		= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("SRC_INFO_CD"), false);
		prcProgStsCd 	= PRIUtil.getValueObject2StringArray((List<?>)eventResponse.getCustomData("PRC_PROG_STS_CD"), false);
	} catch (Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>S/C Proposal Standard Note Creation</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	var srcInfoCdComboValue = "<%=srcInfoCd[0]%>";
    var srcInfoCdComboText = "<%=srcInfoCd[1]%>";
    
    var prcProgStsCdComboValue = "<%=prcProgStsCd[0]%>";
    var prcProgStsCdComboText = "<%=prcProgStsCd[1]%>";

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body onLoad="setupPage();">
<form name="form"><input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
  
<input type="hidden" name="prop_no"> 
<input type="hidden" name="amdt_seq"> 
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="pre_amdt_seq"> 
<input type="hidden" name="prop_sts_cd"> 
<input type="hidden" name="eff_dt">
<input type="hidden" name="exp_dt"> 
<input type="hidden" name="pre_exp_dt"> 
<input type="hidden" name="cd"> 
<input type="hidden" name="req_usr_flg"> 
<input type="hidden" name="apro_usr_flg"> 
<input type="hidden" name="dur_dup_flg">
<input type="hidden" name="note_seq"> 
<input type="hidden" name="note_tp_cd">


	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
	</div>

	<div class="opus_design_inquiry layout_flex_fixed" style="width:80%">
		<table style="width:700px;  margin-top:-25px;">
			<tbody>
				<tr class="h23">
					<th>Year</th>
					<td>
						<input type="text" style="width:50px;" name="note_ref_yr" class="input2" readonly="true">
					</td>
					<th>Standard Note</th>
					<td>
						<input type="text" style="width:200px;" name="note_nm" class="input2" readonly="true">
					</td>
					<th>Cust Type</th>
					<td>
						<input type="text" style="width:200px;" name="cust_tp_desc" class="input2" readonly="true">
					</td>

				</tr>
			</tbody>
		</table>
	</div>
		
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>

 
</form>
</body>
</html>