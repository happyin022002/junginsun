<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0418.jsp
*@FileTitle  : Multi-B/L Print
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/07
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0418Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.StringTokenizer" %>
<%
	EsmBkg0418Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.OutboundBLMgt.BLIssuance");

	String strMode = "";
	String strVvd = "";
	String strPort = "";

	try {
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0418Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strMode = JSPUtil.getParameter(request, "mode");
		strVvd = JSPUtil.getParameter(request, "vvd_cd");
		strPort = JSPUtil.getParameter(request, "port_cd");

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

<input type="hidden" name="form_vslCd">
<input type="hidden" name="form_voyNo">
<input type="hidden" name="form_dirCd">
<input type="hidden" name="form_clptIndSeq">

<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->

		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<!-- 버튼 name / ID정의되어 있음. 별도 지정 금지 -->
			<button type="button" class="btn_normal" name="btn_New" id="btn_New">New</button>
			<button type="button" class="btn_normal" name="btn_Print" id="btn_Print">Print</button>
		</div>
		<!-- opus_design_btn(E) -->

		<!-- page_location(S) -->
		<div class="location">
			<!-- location 내용 동적생성 (별도 코딩 불필요) -->
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
<!-- page_title_area(E) -->


<!-- layout_wrap(S) -->
<div class="wrap_search" style="height:355px">
	<div class="layout_wrap">
		<!-- layout_flex_fixed(S) -->
		<div class="layout_flex_fixed" style="width:160px;">
			<div class="opus_design_inquiry">
				<!--biz page (S)-->
				<!--  biz_1  (S) -->
				<table>
					<tr>
						<th width="40px">Mode</th>
						<td><select name="mode" style="width:100px">
								<option value="I" <% if (strMode.equals("I") || strMode.equals("")) {%>selected<%}%>>Inbound</option>
								<option value="O" <% if (strMode.equals("O")) {%>selected<%}%>>Outbound</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>VVD</th>
						<td width=""><input type="text" name="vvd_cd" style="width:100px;" class="input1" required value="<%=strVvd%>" maxlength="9" dataformat="engup"></td>
					</tr>
					<tr>
						<th>Port</th>
						<td width=""><input type="text" name="port_cd" style="width:80px;" class="input1" required value="<%=strPort%>" maxlength="5" dataformat="engup"></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				<!--biz page (E)-->
			</div>
		</div>

		<!-- opus_design_inquiry(E) -->
		<!-- opus_design_grid(S) -->
		<div class="layout_flex_flex" style="padding-left:200px">
			<div class="opus_design_grid">
				<script language="javascript">ComSheetObject("sheet1");</script>
			</div>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>

