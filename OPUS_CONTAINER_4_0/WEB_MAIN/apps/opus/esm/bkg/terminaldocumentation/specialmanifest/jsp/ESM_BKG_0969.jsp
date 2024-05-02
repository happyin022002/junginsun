<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0969.jsp
*@FileTitle  : ESM_BKG_0969
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/04
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event.EsmBkg0969Event"%>

<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0969Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list 

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.SpecialManifest");
	String pageGubun = "";


	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0969Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		pageGubun = StringUtil.xssFilter(request.getParameter("pageGubun")) == null ? "" : StringUtil.xssFilter(request.getParameter("pageGubun"));

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// If you imported data from the server initialization when loading
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
</head>


<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="pageGubun" value="<%=pageGubun%>" id="pageGubun" />
<!-- page_title_area(S) -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><span>Forwarder Code &amp; Name Setup</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			 <button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button> 
			 <button type="button" class="btn_normal" name="btn_Save"  	id="btn_Save">Save</button> 
			 <% if(!"MAIN".equals(pageGubun)) { %>
			 <button type="button" class="btn_normal" name="btn_Select" 	id="btn_Select">Select</button> 
			 <button type="button" class="btn_normal" name="btn_Close" 	id="btn_Close">Close</button>
			 <% } %>
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
</div>
<!-- page_title_area(E) -->
<div class="layer_popup_contents">
	<div class="wrap_search" style="clear: both;">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry">
			<table>
				<colgroup>
					<col width="90">
					<col width="100">
					<col width="90">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>Forwarder Code</th>
						<td><input type="text" style="width:60px; ime-mode: disabled" class="input" name="anr_fwrd_id" dataformat="engup" maxlength="6" caption="Forwarder Code"></td>
						<th>Forwarder Name</th>
						<td><input type="text" style="width:100%; ime-mode: disabled" class="input" name="fwrd_nm" id="fwrd_nm" /></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<div class="opus_design_btn"><!-- 
				 --><button type="button" class="btn_accent" name="btn2_RowAdd" id="btn2_RowAdd">Row Add</button><!-- 
				 --><button type="button" class="btn_normal" name="btn2_Delete"  	id="btn2_Delete">Row Delete</button>
			</div>
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(S) -->
	</div>
</div>
</form>