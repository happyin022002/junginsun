<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0656.jsp
*@FileTitle  : RFA Commodity PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/20
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0656Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0656Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.GeneralBookingConduct.GeneralBookingSearch");

	String bkgNo = "";	
	String porCd = "";
	String delCd = "";
	String calllFunc = "";
	String bkgVvd = "";	
	String rfaNo = "";
	String appDt = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0656Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		rfaNo  = JSPUtil.getParameter(request, "rfa_no");
		porCd  = JSPUtil.getParameter(request, "por_cd");
		delCd  = JSPUtil.getParameter(request, "del_cd");
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgVvd  = JSPUtil.getParameter(request, "bkg_vvd");		
		appDt = JSPUtil.getParameter(request, "app_dt");
		
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
		loadPage();
	}
</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="bkg_no" value="<%=bkgNo%>" id="bkg_no" />
<input type="hidden" name="por_cd" value="<%=porCd%>" id="por_cd" />
<input type="hidden" name="del_cd" value="<%=delCd%>" id="del_cd" />
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>" id="bkg_vvd" />
<input type="hidden" name="calllFunc" value="<%=calllFunc%>" id="calllFunc" />
<input type="hidden" name="svc_scp_cd">
<input type="hidden" name="ui_id" id="ui_id">
<input type="hidden" name="lodg_due_dt" value="<%=appDt%>">


<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title">RFA Commodity Pop-Up</h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_Select" id="btn_Select" type="button">Select</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table style="width:560px;">
				<colgroup>
					<col width="150">
					<col width="*">
				</colgroup>
				<tbody>
					<tr>
						<th>RFA No</th> 
						<td><input type="text" name="rfa_no" id="rfa_no" style="width:30%" class="input2" value="<%=rfaNo %>" readonly></td>
					</tr>
					<tr>
						<th>Commodity Code</th> 
						<td><input type="text" name="cmdt_cd" id="cmdt_cd" style="width:100%" class="input" value="" style="ime-mode:disabled"  maxlength=6 dataformat="num"></td>
					</tr>
					<tr>
						<th>Commodity Description</th> 
						<td><input type="text" name="cmdt_nm" id="cmdt_nm" style="width:100%" class="input" value="" maxlength=30 dataformat="engup"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" id="mainTable">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>

</form>
