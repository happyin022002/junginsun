<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0657.jsp
*@FileTitle  : SC Commodity PopUp
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
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0657Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0657Event  event = null;					//PDTO(Data Transfer Object including Parameters)
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
	String scNo = "";	
	String svcScpCd = "";
	String appDt = "";
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0657Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		bkgNo  = JSPUtil.getParameter(request, "bkg_no");
		scNo  = JSPUtil.getParameter(request, "sc_no");
		porCd  = JSPUtil.getParameter(request, "por_cd");
		delCd  = JSPUtil.getParameter(request, "del_cd");
		calllFunc  = JSPUtil.getParameter(request, "func");
		bkgVvd  = JSPUtil.getParameter(request, "bkg_vvd");
		svcScpCd = JSPUtil.getParameter(request, "svc_scp_cd");
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="por_cd" value="<%=porCd%>">
<input type="hidden" name="del_cd" value="<%=delCd%>">
<input type="hidden" name="bkg_vvd" value="<%=bkgVvd%>">
<input type="hidden" name="calllFunc" value="<%=calllFunc%>">
<input type="hidden" name="svc_scp_cd" value="<%=svcScpCd%>">
<input type="hidden" name="ui_id" id="ui_id">
<input type="hidden" name="lodg_due_dt" value="<%=appDt%>">

<!-- popup_title_area(S) -->
 <div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
		<!-- page_title(S) -->
		<h2 class="page_title"><span>S/C Commodity Pop-Up</span></h2>
		<!-- page_title(E) -->
			
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn"><!-- 
			--><button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!-- 
			--><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!-- 	
			--><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button><!-- 	
		--></div>
		<!-- opus_design_btn(E) -->	
	</div>
	<!-- page_title_area(E) -->
</div>
<!-- popup_title_area(E) -->

<!-- popup_contens_area(S) -->
<div class="layer_popup_contents">
	<!-- inquiry_area(S) -->
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table> 
				<colgroup>
					<col width="100" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>S/C No</th> 
						<td><input type="text" name="sc_no" style="width:70px;" class="input2" value="<%=scNo %>" readonly></td>
						<th>Commodity Code</th> 
						<td><input type="text" name="cmdt_cd" style="width:70px;" class="input" value="" style="ime-mode:disabled"  maxlength=6 dataformat="num"></td>
					</tr>
					<tr>
						<th>Commodity Description</th> 
						<td colspan="3"><input type="text" name="cmdt_nm" style="width:98%" dataformat="engup" otherchar="!@#$%^&*()? {}=+,-"  class="input" value="" maxlength=30></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div class="wrap_result">
		<div class="opus_design_grid" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>

</form>