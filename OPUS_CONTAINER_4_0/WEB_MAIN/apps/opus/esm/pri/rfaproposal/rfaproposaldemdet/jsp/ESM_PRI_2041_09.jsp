<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_2041_09.jsp
 *@FileTitle  : Amendment History Inquiry - Duration
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/06
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri204109Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri204109Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.RFAProposal.RfaProposalDEMDET");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri204109Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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


<input type="hidden" name="prop_no" id="prop_no" />
<input type="hidden" name="amdt_seq" id="amdt_seq" />
<input type="hidden" name="eff_dt" id="eff_dt" />
<input type="hidden" name="cd" id="cd" />

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" id="mainTable">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" 	id="btn_retrieve">Retrieve</button>
	</div>
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>