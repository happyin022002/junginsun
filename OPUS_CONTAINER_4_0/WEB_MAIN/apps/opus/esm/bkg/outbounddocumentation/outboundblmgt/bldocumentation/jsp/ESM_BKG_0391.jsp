<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_bkg_0391.jsp
*@FileTitle  : Multi Shipment Detail
*@author     : CLT
*@version    : 1.0
*@since      : 2016/01/26
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0391Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0391Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";				//error message
	
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBkgNo			= "";
	String uiNo				= "";
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmBkg0391Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		// getting data from server when load the initial screen
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBkgNo =  JSPUtil.getParameter(request, "bkg_no");
		uiNo =  JSPUtil.getParameter(request, "ui_no");
	}catch(Exception e) {
		out.println("JSP Exception--->"+e.toString());
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
<form name="form2">
<input type="hidden" name="func" id="func">
<input type="hidden" name="mk_desc" id="mk_desc">
<input type="hidden" name="gds_desc" id="gds_desc">
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="uiNo" id="uiNo" value="<%=uiNo%>"  />
<input type="hidden" name="callback_func" value="<%=JSPUtil.getParameter(request, "func")%>"  />

<!-- popup_title_area(S) -->
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Multi Shipment Detail</span></h2>
		<div class="opus_design_btn">
		<% if(uiNo.equals("")){ %>
		<button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button>
		<% } else if (uiNo.equals("ESM_BKG_0229")){%>
		<button type="button" class="btn_normal" name="btn_save" id="btn_save">Save</button>
		<% } else if (uiNo.equals("ESM_BKG_0079_04")||uiNo.equals("ESM_BKG_0079_06")||uiNo.equals("ESM_BKG_0079_07")){%>
		<button type="button" class="btn_normal" name="btn_retrieve" id="btn_retrieve">Retrieve</button>
		<button type="button" class="btn_normal" name="btn_select" id="btn_select">Select</button>
		<button type="button" class="btn_normal" name="btn_save2" id="btn_save2">Save</button>
		<% } %>
		<button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button></div>
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
			<colgroup>
				<col width="55" />
				<col width="*" />
			</colgroup>
				<tr>
					<th>BKG No.</th>
					<td><input type="text" id="bkg_no" name="bkg_no" style="ime-mode:disabled;text-transform:uppercase;width:120px;" dataformat="engup"  class="input1" value="<%=strBkgNo %>" maxlength="13" /></td>
				</tr>
				<% if (uiNo.equals("")||uiNo.equals("ESM_BKG_0079_04")||uiNo.equals("ESM_BKG_0079_06")||uiNo.equals("ESM_BKG_0079_07")){%>
				<tr>
					<th>Route</th>
					<td><input type="text" name="por_cd" style="width:60px;" value="" class="input2" readonly id="por_cd" /><!--
					--><input type="text" name="pol_cd" style="width:60px;" value="" class="input2" readonly id="pol_cd" /><!--
					--><input type="text" name="pod_cd" style="width:60px;" value="" class="input2" readonly id="pod_cd" /><!--
					--><input type="text" name="del_cd" style="width:60px;" value="" class="input2" readonly id="del_cd" /></td>
				</tr>
				<% } %>
			</tbody>
		</table>
	</div>
</div>
<div class="wrap_result">
	<div class="opus_design_grid" >
		<% if(uiNo.equals("ESM_BKG_0079_04")||uiNo.equals("ESM_BKG_0079_06")||uiNo.equals("ESM_BKG_0079_07")){ %>
		<div class="opus_design_btn">
		   <button type="button" class="btn_normal" name="btn_t6gridadd" id="btn_t6gridadd">Row Add</button>
		   <button type="button" class="btn_normal" name="btn_t6griddel" id="btn_t6griddel">Row Delete</button>
  		</div>
  		<% } %>
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</div>
<!-- popup_contens_area(E) -->
</form>
<%@include file="/bizcommon/include/common_opus.jsp"%>