<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_1078.jsp
*@FileTitle  : TAA Commodity PopUp
*@author     : CLT
*@version    : 1.0
*@since      : 2014/04/08
=========================================================
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1078Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg1078Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String taaNo = "";
	String appDt = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg1078Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		taaNo  = JSPUtil.getParameter(request, "taa_no");
		porCd  = JSPUtil.getParameter(request, "por_cd");
		delCd  = JSPUtil.getParameter(request, "del_cd");
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgVvd  = JSPUtil.getParameter(request, "bkg_vvd");	
		appDt = JSPUtil.getParameter(request, "app_dt");			
		
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="lodg_due_dt" value="<%=appDt%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>TAA Commodity Pop-Up</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
			<button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button>
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->
<!-- wrap_search(S) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<div class="wrap_search">
	<!-- inquiry_area(S) -->
	<div class="opus_design_inquiry">
		<table> 
			<colgroup>
				<col width="20px" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>TAA No</th> 
					<td><input type="text" name="taa_no" style="width: 100px" class="input2" value="<%=taaNo %>" readonly></td>
				</tr>
				<tr>
					<th>Commodity Code</th> 
					<td><input type="text" name="cmdt_cd" style="width:100px" class="input" value="" style="ime-mode:disabled"  maxlength=6 dataformat="num"></td>
				</tr>
				<tr>
					<th>Commodity Description</th> 
					<td><input type="text" name="cmdt_nm" style="width:100px" class="input" value="" maxlength=30 dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
	</div>
	</div>
	<!-- inquiry_area(E) -->
	<!-- opus_design_grid(S) -->
	<div class="wrap_result">
	<div class="opus_design_grid" >
		<script language="javascript">ComSheetObject('sheet1');</script>
	</div>
	</div>
	<!-- opus_design_grid(E) -->

<!-- popup_contens_area(E) -->
</div>
<!-- wrap_search(E) -->

</form>
