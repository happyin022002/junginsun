<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VOP_SCG_0077.jsp
 *@FileTitle : Setup Mail Contents for SPCL CGO Application
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/17
 =========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event.VopScg0077Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopScg0077Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.SpecialCargoMasterDataMgt.SpecialCargoMasterDataMgt");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (VopScg0077Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// add logic data extracting from server when loading initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 		id="btn_save">Save</button>		
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry wFit">
	<table class="grid2">
		<tbody>
			<colgroup>
				<col width="120" />
				<col width="480" />
				<col width="*" />
			</colgroup>
			<tr class="tr2_head">
				<th>Type</th>
				<th style="text-align:center">Header (Introduction)</th>
				<th style="text-align:center">Footer (Signature)</tdh>
			</tr>
			<tr class="h23">
				<th class="tr2_head2" nowrap >DG / Stowage</th>
				<td><textarea name="dg_hdr_ctnt" id="dg_hdr_ctnt"style="ime-mode:disabled;width:478px;" rows="7" caption="DG Header (Introduction)"></textarea></td>
				<td><textarea name="dg_ftr_ctnt" id="dg_ftr_ctnt" style="ime-mode:disabled;width:100%;" rows="7" caption="DG Footer (Signature)"></textarea></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head2">Awkward</th>
				<td><textarea name="ak_hdr_ctnt" id="ak_hdr_ctnt" style="ime-mode:disabled;width:478px;" rows="7" caption="Awkward Header (Introduction)"></textarea></td>
				<td><textarea name="ak_ftr_ctnt" id="ak_ftr_ctnt" style="ime-mode:disabled;width:100%;" rows="7" caption="Awkward Footer (Signature)"></textarea></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head2">Break-Bulk</th>
				<td><textarea name="bb_hdr_ctnt" id="bb_hdr_ctnt" style="ime-mode:disabled;width:478px;" rows="7" caption="Break-Bulk Header (Introduction)"></textarea></td>
				<td><textarea name="bb_ftr_ctnt" id="bb_ftr_ctnt" style="ime-mode:disabled;width:100%;" rows="7" caption="Break-Bulk Footer (Signature)"></textarea></td>
			</tr>
			<tr class="h23">
				<th class="tr2_head2">Reefer</th>
				<td><textarea name="rf_hdr_ctnt" id="rf_hdr_ctnt" style="ime-mode:disabled;width:478px;" rows="7" caption="Reefer Header (Introduction)"></textarea></td>
				<td><textarea name="rf_ftr_ctnt" id="rf_ftr_ctnt" style="ime-mode:disabled;width:100%;" rows="7" caption="Reefer Footer (Signature)"></textarea></td>
			</tr>
		</tbody>
	</table>
	<table>
		<tbody>
			<colgroup>
				<col width="10" />
				<col width="480" />
				<col width="*" />
			</colgroup>
			<tr class="tr2_head">
				<td class="tr2_head2" nowrap><input type="checkbox" value="N" class="trans" name="auto_eml_flg"></td>
				<td>Import email address of Loading Office & BKG Staff to Copy</td>
				<td></td>
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
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) -->
				
</form>
