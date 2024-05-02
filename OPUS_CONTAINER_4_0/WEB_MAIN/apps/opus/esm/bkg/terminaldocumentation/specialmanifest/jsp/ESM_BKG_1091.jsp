<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1091.jsp
*@FileTitle  : ESM_BKG_1091
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1091Event"%>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1091Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");

	String bayId = "";
	String openType = "";
	String currMainPageListCnt = "0";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1091Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// Parameter setting from parents window
		bayId 	= (StringUtil.xssFilter(request.getParameter("bayId")) == null) 	? "" : StringUtil.xssFilter(request.getParameter("bayId"));
		openType = (StringUtil.xssFilter(request.getParameter("openType")) == null) ? "" : StringUtil.xssFilter(request.getParameter("openType"));
		currMainPageListCnt = (StringUtil.xssFilter(request.getParameter("currMainPageListCnt")) == null) ? "0" : StringUtil.xssFilter(request.getParameter("currMainPageListCnt"));
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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

<input type="hidden" name="openType" value=<%=openType %>>
<input type="hidden" name="currMainPageListCnt" value=<%=currMainPageListCnt %>>


<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Bayplan Setup Details Pop-up</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_accent" name="btn_Select" id="btn_Select">Select</button>
			<button type="button" class="btn_accent" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<div class="layer_popup_contents">
<div class="wrap_search">				   	
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
	        	<colgroup>
		            <col width="80" />
		            <col width="130" />
		            <col width="100" />
		            <col width="120" />
		            <col width="100" />
		            <col width="100" />
		            <col width="80" />
		            <col width="*" />
	        	</colgroup>
				<tr>
					<th>Bay ID</th> 
					<td><input type="text" style="width:120px; ime-mode: disabled" class="input1" name="bay_pln_id" value="<%=bayId%>" 
						dataformat="engup" required maxlength="20" caption="Bay ID"></td>
					<th>Container No</th> 
					<td><input type="text" style="width:100px; ime-mode: disabled" class="input" name="eur_dg_cntr_id" value="" 
						dataformat="engup" maxlength="20"></td>
					<th>Cell Position</th> 
					<td><input type="text" style="width:100px; ime-mode: disabled" class="input" name="cell_psn_no" value="" 
						dataformat="engup" maxlength="7"></td>
					<th>Operator</th> 
					<td><input type="text" style="width:80px; ime-mode: disabled" class="input" name="cntr_opr_id" value="<%=ConstantMgr.getCompanyCode()%>" 
						dataformat="engup" maxlength="7"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result" >
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div> 
</div>	
</form>
