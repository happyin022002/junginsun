
<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_0074.jsp
*@FileTitle  : S/C Boiler Plate Creation - Excel Import
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
<%@ page import="com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.event.EsmPri0074Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri0074Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String sPropNo		= "";
	String sAmdtSeq		= "";
	String mBlplSeq		= "";
	String mDpSeq		= "";
	
	Logger log = Logger.getLogger("com.clt.apps.SCProposal.SCBoilerPlateProposal");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri0074Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		sPropNo = request.getParameter("sPropNo");
		sAmdtSeq = request.getParameter("sAmdtSeq");
		mBlplSeq = request.getParameter("mBlplSeq");
		mDpSeq = request.getParameter("mDpSeq");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="propNo" id="propNo"   value="<%=StringUtil.xssFilter(sPropNo) %>">
<input type="hidden" name="amdtSeq" id="amdtSeq"  value="<%=StringUtil.xssFilter(sAmdtSeq) %>">
<input type="hidden" name="blplSeq" id="blplSeq"  value="<%=StringUtil.xssFilter(mBlplSeq) %>">
<input type="hidden" name="dpSeq" id="dpSeq" 	 value="<%=StringUtil.xssFilter(mDpSeq) %>">


<div class="layer_popup_title">

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Boiler Plate Excel Import</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button type="button" id="btn_openfile" name="btn_openfile" class="btn_normal">Open&nbsp;File</button>
			<button type="button" id="btn_check" name="btn_check" class="btn_normal">Check</button>
			<button type="button" id="btn_save" name="btn_save" class="btn_normal">Save</button>
			<button type="button" id="btn_close" name="btn_close" class="btn_normal">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
		
	</div>
	<!-- page_title_area(E) -->

</div>

<div class="layer_popup_contents">

	<div class="wrap_result">
		
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">	
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>