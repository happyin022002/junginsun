<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec. All Rights Reserved.
*@FileName   ESM_BKG_0738.js
*@FileTitle  : Wharfage Exception Customers
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page
	import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page
	import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page
	import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page
	import="com.clt.apps.opus.esm.bkg.wharfagemgt.wharfagedecmgt.kr.event.EsmBkg0738Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0738Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger
			.getLogger("com.clt.apps.wharfagemgt.wharfagedecmgt");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0738Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
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
<%
	String sCountry = (request.getParameter("country") == null) ? "" : request.getParameter("country");
	String sPopup = (request.getParameter("popup") == null) ? "" : request.getParameter("popup");
	String sFcol = (request.getParameter("fcol") == null) ? "" : request.getParameter("fcol");
	String sFrow = (request.getParameter("frow") == null) ? "" : request.getParameter("frow");
%>
<form name="form" method="post">
		<input type="hidden" name="f_cmd" id="f_cmd" />
		<input type="hidden" name="pagerows" id="pagerows" />
		<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2" />
		<input type="hidden" name="popup" value="<%=sPopup%>" id="popup" />
		<input type="hidden" name="fcol" value="<%=sFcol%>" id="fcol" />
		<input type="hidden" name="frow" value="<%=sFrow%>" id="frow" />
<div class="layer_popup_title">
		<!-- page_title_area(S) -->
		<div class="page_title_area clear">
			<!-- page_title(S) -->
			<h2 class="page_title"><span>Wharfage Exception Customers </span></h2>
			<!-- page_title(E) -->
			<!-- opus_design_btn(S) -->
			<div class="opus_design_btn"><!--
			--><button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
			--><button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button><!--
			--><button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button><!--
			--><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
			</div>
			<!-- opus_design_btn(E) -->
		</div>
		<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
		<!-- wrap_search(S) -->
		<div class="wrap_search">
			<!-- opus_design_inquiry(S) -->
			<div class="opus_design_inquiry wFit">
				<table>
					<tbody>
						<colgroup>
						<col width="50" />	
						<col width="*" />
						</colgroup>
						<tr>
							<th>Country</th>
							<td><input type="text" style="width: 30px;" class="input1" name="attr_ctnt1" dataformat="engup" value="<%=sCountry%>"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<!-- opus_design_inquiry(E) -->
		</div>
		<!-- wrap_search(E) -->
		<!-- wrap_result(S) -->
		<div class="wrap_result">
			<!-- opus_design_grid(S) -->
			<div class="opus_design_grid">
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row&nbsp;Add</button>
					<button type="button" class="btn_normal" name="btn_del" id="btn_del">Row Delete</button>
				</div>
				<script type="text/javascript">
					ComSheetObject('sheet1');
				</script>
			</div>
			<!-- opus_design_grid(E) -->
		</div>
</div>
</form>