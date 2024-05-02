<%
/*=========================================================
 *Copyright(c) 2016 CyberLogitec. All Rights Reserved.
 *@FileName  : esm_bkg_1526.jsp
 *@FileTitle : ESM_BKG-1526
 *@author    : CLT
 *@version   : 1.0
 *@since     :
 =========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.jp24.event.EsmBkg1526Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1526Event event = null;        //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null;    //occurring error in server
	String strErrMsg = "";               //error message
	int rowCount = 0;                    //list count of DB ResultSet

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";

	String blNo = "";
	String popMode = "";

	Logger log = Logger.getLogger("com.clt.apps.esm.bkg.CustomsDeclaration");

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg1526Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		blNo = JSPUtil.getParameter(request, "bl_no");
		popMode = JSPUtil.getParameter(request, "pop_mode");

		if (serverException != null) strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	} catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- 개발자 작업 -->
<input type="hidden" name="del_trasmit_flag" id="del_trasmit_flag" />
<input type="hidden" name="corr_rsn_cd" id="corr_rsn_cd" />
<input type="hidden" name="corr_rsn" id="corr_rsn" />


<% if ("1".equals(popMode)) { %>
<!-- popup_title_area(S) -->
<div class="layer_popup_title">
<% } %>


<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->


<% if ("1".equals(popMode)) { %>
	<h2 class="page_title"><span id="title"></span></h2>
<% } else {%>
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
<% } %>


	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" type="button" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
	 --><% if (!"1".equals(popMode)) { %><button class="btn_normal" type="button" name="btn_new" id="btn_new" >New</button><!--
	 --><% } %><button class="btn_normal" type="button" name="btn_confirm" id="btn_confirm">Confirm</button><!--
	 --><button class="btn_normal" type="button" name="btn_transmit" id="btn_transmit">Transmit</button><!--
	 --><button class="btn_normal" type="button" name="btn_del_transmit" id="btn_del_transmit">DEL Transmit</button><!--
	 --><% if ("1".equals(popMode)) { %><button class="btn_normal" type="button" name="btn_close" id="btn_close">Close</button>
		<% } %>
	</div>
	<!-- opus_design_btn(E) -->


<% if (!"1".equals(popMode)) { %>
	<!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	<!-- page_location(E) -->
<% } %>


</div>
<!-- page_title_area(E) -->


<% if ("1".equals(popMode)) { %>
</div>
<!-- popup_title_area(E) -->


<!-- popup_contents_area(S) -->
<div class="layer_popup_contents">
<% } %>


<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">


<% if ("1".equals(popMode)) { %>
		<input type="hidden" name="bl_no" id="bl_no" value="<%=blNo%>" />
<% } else {%>
		<table >
			<colgroup>
				<col width="50" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>B/L No.</th>
					<td><input type="text" name="bl_no" id="bl_no" value="<%=blNo%>" class="input1" dataformat="engup" maxlength="12" required caption="B/L No." style="width:120px;" /></td>
				</tr>
			</tbody>
		</table>
		<table class="line_bluedot"><tr><td></td></tr></table>
<% } %>


		<h3 class="title_design">Original B/L</h3>
		<div class="opus_design_grid wFix" style="width:735px">
			<script type="text/javascript">ComSheetObject("sheet1");</script>
		</div>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>
<!-- wrap_search(E) -->


<!-- wrap_result(S) -->
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<h3 class="title_design">New B/L List</h3>
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_rowadd" id="btn_rowadd" type="button">Row Add</button><!--
			--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Delete</button>
		</div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject("sheet2");</script>
	</div>
</div>
<!-- wrap_result(E) -->


<% if ("1".equals(popMode)) { %>
</div>
<!-- popup_contents_area(E) -->
<% } %>


</form>
