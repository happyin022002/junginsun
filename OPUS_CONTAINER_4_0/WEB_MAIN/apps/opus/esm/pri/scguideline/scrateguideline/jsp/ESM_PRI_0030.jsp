<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0030.jsp
*@FileTitle  : Guideline MQC
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/26
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scrateguideline.event.EsmPri0030Event"%>
<%@ page import="com.clt.syscommon.common.table.PriSgRtMqcRngVO"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0030Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
    String enableFlg = null;

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0030Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
        	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		PriSgRtMqcRngVO vo = event.getPriSgRtMqcRngVO();

        svcScpCd = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
        glineSeq = JSPUtil.getNull(request.getParameter("gline_seq"));
        prcCustTpCd = JSPUtil.getNull(request.getParameter("prc_cust_tp_cd"));
        enableFlg = JSPUtil.getNull(request.getParameter("enable_flg"));

		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		svcScpNm = (String)eventResponse.getCustomData("SvcScpNm");
		prcCustTpNm = (String)eventResponse.getCustomData("PrcCustTpNm");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- developer job	-->
<input type="hidden" name="gline_seq" value="<%=glineSeq %>" id="gline_seq" />
<input type="hidden" name="prc_cust_tp_cd" value="<%=prcCustTpCd %>" id="prc_cust_tp_cd" />
<input type="hidden" name="enable_flg" value="<%=enableFlg %>" id="enable_flg" />

<div class="layer_popup_title">
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Guideline MQC</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="95" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
			   		<tr>
	                    <th>Service Scope</th>
	                    <td><input type="text" name="svc_scp_cd" id="svc_scp_cd" style="width:35px;text-align:center;" class="input2" value="<%=svcScpCd %>" readonly="readonly"><input type="text" name="svc_scp_nm" id="svc_scp_nm" style="width:250px;" class="input2" value="<%=svcScpNm %>" readonly="readonly"></td>
	                </tr>
	                <tr>
	                    <th>Customer Type</th>
	                    <td><input type="text" name="prc_cust_tp_nm" id="prc_cust_tp_nm" style="width:165px;" class="input2" value="<%=prcCustTpNm %>" readonly="readonly"></td>
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
				<button class="btn_accent" name="btn_RowAdd" id="btn_RowAdd" type="button">Row Add</button><!--
				--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
				--></div>
			<!-- opus_design_btn (E) -->
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
