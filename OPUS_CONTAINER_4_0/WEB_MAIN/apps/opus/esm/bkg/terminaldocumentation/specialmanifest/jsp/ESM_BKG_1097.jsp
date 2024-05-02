<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1097.jsp
*@FileTitle  : ESM_BKG_1097
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/01
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg1097Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1097Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	String pageType = "";

	String callFunc = "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg1097Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		pageType = StringUtil.xssFilter(request.getParameter("pageType")) == null ? "" : StringUtil.xssFilter(request.getParameter("pageType"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		callFunc  = JSPUtil.getParameter(request, "func");
		
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
<input type="hidden" name="pageType" value="<%= pageType %>" id="pageType" />
<input type="hidden" id="func" name="func" value="<%=callFunc%>" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><span>EU DG Declare-Feeder Registry Pop-up</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
    <div class="opus_design_btn">
		    	<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
		     --><button type="button" class="btn_normal" name="btn_Save" id="btn_Save">Save</button><!-- 
		     <% if(!"MAIN".equals(pageType)) { %>
			     --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 
			     --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		     <% } %>
    </div>
	 <!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			 <table> 
	            <colgroup>
	                <col width="60"> 
	                <col width="100">
	                <col width="120">
	                <col width="*">
	            </colgroup>
	            <tbody>
	               	<tr>
						<th>Feeder Lloyd Code</th> 
						<td>
							<input type="text" style="width:60px; ime-mode: disabled" class="input" name="fdr_vsl_lloyd_no" id="fdr_vsl_lloyd_no" dataformat="num" maxlength="7" caption="Feeder Lloyd Code">
						</td>
						<th>Feeder Vessel Name</th> 
						<td>
							<input type="text" style="width:100%; ime-mode: disabled" class="input" name="fdr_vsl_nm" id="fdr_vsl_nm" dataformat="engup">
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
</div>
<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="mainTable" >		
		 <div class="opus_design_btn">
				<button class="btn_normal" type="button"  name="btn2_RowAdd" id="btn2_RowAdd">Row&nbsp;Add</button><!-- 
			 --><button class="btn_normal" type="button"  name="btn2_Delete" id="btn2_Delete">Delete</button>
		</div>		
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(E) -->
	</div>
</div>
</form>