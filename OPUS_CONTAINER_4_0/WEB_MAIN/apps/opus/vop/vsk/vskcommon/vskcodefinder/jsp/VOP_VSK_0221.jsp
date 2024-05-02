<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   VOP_VSK_0221.jsp
*@FileTitle  : Port Code Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/22
=========================================================
--%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event.VopVsk0221Event"%>
<%@ page import="org.apache.log4j.Logger"%>

<%
	VopVsk0221Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; //error from server
	String strErrMsg = ""; //error message
	int rowCount = 0; //count of DB ResultSet list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.vskcommon.vskcodefinder");

	try {
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (VopVsk0221Event) request.getAttribute("Event");
		serverException = (Exception) request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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

<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="pagerows"> 
<input type="hidden" name="tmp_cnt_cd">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		</div>
		<!-- opus_design_btn(E) -->


		<!-- location(S) -->
		<div class="location">
			<span id="navigation"></span>
		</div>
		<!-- location(E) -->
</div>
	<!-- page_title_area(E) -->


<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="10"/>
				<col width="*"/>
				</colgroup>
				<tr>
					<th>VOSI RHQ</th>
					<td><script type="text/javascript">ComComboObject('vskd_port_rhq_cd', 1, 90, 1);</script></td>
					<td></td>
					<th>Country Code</th>
					<td>
						<input type="text" name="cnt_cd" id="cnt_cd" style="width: 30px; ime-mode: disabled;text-align: Center"  maxlength=2 class="input_search" dataformat="enguponly" value="" onchange="setCountryCode()"><button type="button" name="btns_popup" id="btns_popup" class="input_seach_btn"></button>
						<input type="text" name="cnt_nm" id="cnt_nm" style="width: 200px;"	class="input2" readonly>
					</td>
					<td></td>
					<th>Port</th>
					<td><input type="text" name="loc_cd" id="loc_cd" maxlength=5 style="width: 60px; text-align: Center; ime-mode: disabled" class="input" dataformat="engup" tabindex="3"></td>
					<td></td>
					<th>Port Name</th>
					<td><input type="text" name="loc_nm" id="loc_nm" style="width: 200px; ime-mode: disabled" class="input" tabindex="4"></td>
					<td></td>
					
					<th>Monitoring Port</th>
					<td><select name="vop_port_mntr_flg" style="width: 50px;">
							<option></option>
							<option value="Y">Y</option>
							<option value="N">N</option>
					</select></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
	<!-- opus_design_inquiry(E) -->
	
<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid clear">	
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
	<!-- opus_design_grid(E) -->
</form>
