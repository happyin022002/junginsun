<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : ui_pri_0053.jsp
*@FileTitle  : Guideline MQC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/09/25
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0053Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSgRtMqcRngVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0053Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCRateGuideline");
	
	String svcScpCd = null;
	String svcScpNm = null;
	String glineSeq = null;
	String prcCustTpCd = null;
	String prcCustTpNm = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri0053Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		PriSgRtMqcRngVO vo = event.getPriSgRtMqcRngVO();
		
		if (vo != null) {
        	svcScpCd = vo.getSvcScpCd();
        	glineSeq = vo.getGlineSeq();
        	prcCustTpCd = vo.getPrcCustTpCd();
		} else {
        	svcScpCd = "";
        	glineSeq = "";
        	prcCustTpCd = "";
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpNm = (String)eventResponse.getCustomData("SvcScpNm");
		prcCustTpNm = (String)eventResponse.getCustomData("PrcCustTpNm");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<input type="hidden" name="svc_scp_cd"     value="<%=svcScpCd %>">
<input type="hidden" name="gline_seq"      value="<%=glineSeq %>">
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>">

<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Guideline MQC Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--  -->
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry wFit">
			<table class="search" border="0" style="width:400px;">
                <tr class="h23">
                    <th width="25%">Service Scope</th>
                    <td width=""><input type="text" name="svc_scp_cd" style="width:35px;" class="input2" value="<%=svcScpCd %>" readonly="readonly">&nbsp;<input type="text" name="svc_scp_nm" style="width:250;" class="input2" value="<%=svcScpNm %>" readonly="readonly"></td>
                </tr>
                <tr class="h23">
                    <th>Customer Type </th>
                    <td><input type="text" name="prc_cust_tp_nm" style="width:200px;" class="input2" value="<%=prcCustTpNm %>" readonly></td>
                </tr>
           </table>
		</div>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>

</form>
