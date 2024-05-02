<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0155.jsp
*@FileTitle  : ESM_BKG_0155
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/16
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
<%@ page import="com.clt.apps.opus.esm.bkg.terminaldocumentation.cllcdlmanifest.event.EsmBkg0155Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0155Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String inListType		= "";
	String inVvdCd			= "";
	String inPolCd			= "";
	String inPolTs			= "";
	Logger log = Logger.getLogger("com.clt.apps.TerminalDocumentation.CLLCDLManifest");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		inListType = StringUtil.xssFilter(request.getParameter("inListType"))==null?"":StringUtil.xssFilter(request.getParameter("inListType"));
		inVvdCd = StringUtil.xssFilter(request.getParameter("inVvdCd"))==null?"":StringUtil.xssFilter(request.getParameter("inVvdCd"));
		inPolCd = StringUtil.xssFilter(request.getParameter("inPolCd"))==null?"":StringUtil.xssFilter(request.getParameter("inPolCd"));
		inPolTs = StringUtil.xssFilter(request.getParameter("inPolTs"))==null?"":StringUtil.xssFilter(request.getParameter("inPolTs"));

		event = (EsmBkg0155Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
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
		//alert("test");
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="inListType" value="<%=inListType %>" id="inListType" />
<input type="hidden" name="popBkgNo" id="popBkgNo" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>CLL for EDI</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_edi" id="btn_edi" type="button">EDI</button><!--
		--><button class="btn_normal" name="btn_loadingConfirm" id="btn_loadingConfirm" type="button">Loading Confirm</button><!--
		--><button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40" />				
				<col width="100" />				
				<col width="40" />				
				<col width="100" />				
				<col width="40" />				
				<col width="120" />				
				<col width="50" />				
				<col width="120" />				
				<col width="80" />				
				<col width="80" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
		   		<tr>
					<th title="Vessel Voyage Direction">VVD</th>
					<td> <input type="text" style="width:80px;" class="input" name="in_vvd_cd" dataformat="engup" maxlength="9" value="<%=inVvdCd %>" id="in_vvd_cd" /></td>
					<th title="Port of Loading">POL</th>
					<td><input type="text" style="width:80px;" class="input" name="in_pol_cd" maxlength="5" dataformat="engup" value="<%=inPolCd %>" id="in_pol_cd" /></td>
					<th>ETA</th>
					<td><input type="text" style="width:110px;" class="input2" name="eta_dt" value="" readonly id="eta_dt" /></td>
					<th>ETD</th>
					<td><input type="text" style="width:110px;" class="input2" name="etd_dt" value="" readonly id="etd_dt" /></td>
					<th>Local T/S</th>
					<td>
						<select name="in_local_ts" id="in_local_ts">
						<option value="" <%if(inPolTs.equals("")){%>selected<%}%>>ALL</option>
						<option value="T" <%if(inPolTs.equals("T")){%>selected<%}%>>T/S</option>
						<option value="L" <%if(inPolTs.equals("L")){%>selected<%}%>>Local</option>
						</select>
					<!--input type="text" style="width:30;" class="input" name="in_local_ts" dataformat="upper" maxlength="1" value="<%=inPolTs %>" style="ime-mode:disabled"--></td>
					<th>User ID</th>
					<td><input type="text" style="width:100px;" class="input2" name="upd_usr_id" value="<%=strUsr_id%>" readonly id="upd_usr_id" /></td>
		   		</tr>
		   </tbody>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_rowadd" id="btn_rowadd" type="button">Row&nbsp;Add</button><!--
			--><button class="btn_normal" name="btn_delete" id="btn_delete" type="button">Row&nbsp;Delete</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
		<div class="opus_design_data">
			<table class="grid2 wAuto"> 
				<tr>
					<th class="pad_rgt_12"><b>Total</b></th>
					<th>CNTR</th>
					<td><input type="text" style="width:80px;text-align:right" class="input" name="cntr" value="" readonly id="cntr" /> </td>
					<th>BKG</th>
					<td><input type="text" style="width:80px;text-align:right" class="input" name="bkg" value="" readonly id="bkg" /> </td>
					<th>TEU</th>
					<td><input type="text" style="width:80px;text-align:right" class="input" name="teu" value="" readonly id="teu" /> </td>
					<th>FEU</th>
					<td><input type="text" style="width:80px;text-align:right" class="input" name="feu" value="" readonly id="feu" /> </td>
				</tr>
			</table>
		</div>	
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>