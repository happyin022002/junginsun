<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0190.jsp
*@FileTitle  : Actual Customer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/29
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0190Event"%>	
<%@ page import="org.apache.log4j.Logger"%>

<%
	EsmBkg0190Event event = null; //PDTO(Data Transfer Object including Parameters)
	Exception serverException = null; // error from server
	String strErrMsg = ""; // error message
	int rowCount = 0; // count of DB resultSET list

	String successFlag = "";
	String codeList = "";
	String pageRows = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	boolean bBtn_Disabled = true;

	try {
		SignOnUserAccount account = (SignOnUserAccount) session
				.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0190Event) request.getAttribute("Event");
		serverException = (Exception) request
				.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException)
					.loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request
				.getAttribute("EventResponse");

	} catch (Exception e) {
		out.println(e.toString());
	}
  String svc_scp_cd = JSPUtil.getNull(request.getParameter("svc_scp_cd")); 
  String app_dt     = JSPUtil.getNull(request.getParameter("app_dt")); 
  String sc_no      = JSPUtil.getNull(request.getParameter("sc_no")); 
  String rfa_no      = JSPUtil.getNull(request.getParameter("rfa_no")); 
  String bkg_no      = JSPUtil.getNull(request.getParameter("bkg_no")); 
  String ca_flg      = JSPUtil.getNull(request.getParameter("ca_flg")); 
%>

<script type="text/javascript">
    function setupPage(){
        var errMessage = "<%=strErrMsg%>";
        if (errMessage.length >= 1) {
            ComShowMessage(errMessage);
        } // end if
        // InitTab();
        loadPage();
    }
</script>

<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="f_cmd">
<input type="hidden" name="svc_scp_cd" value="<%=svc_scp_cd%>">
<input type="hidden" name="ca_flg" value="<%=ca_flg%>">
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Actual Customer</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_Select" id="btn_Select" type="button">Select</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	
		<!-- page_location(S) -->
		<div class="location">	
			<span id="navigation"></span>
		</div>
		<!-- page_location(E) -->
	</div>
	<!-- page_title_area(E) -->
</div>

<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="100" />				
					<col width="120" />				
					<col width="70" />				
					<col width="100" />				
					<col width="70" />				
					<col width="100" />				
					<col width="100" />				
					<col width="*" />				
			   </colgroup> 
		   		<tr>
		   			<th>RFA No</th>
					<td><input type="text" name="rfa_no" style="width:109px;" value="<%=rfa_no%>" readonly class="input2" id="rfa_no" /></td>
					<th>S/C No.</th>
					<td><input type="text" name="sc_no" style="width:100px;" value="<%=sc_no%>" readonly class="input2" id="sc_no" /></td>
					<th>BKG No.</th>
					<td><input type="text" name="bkg_no" style="width:100px;" value="<%=bkg_no%>" readonly class="input2" id="bkg_no" /></td>
					<th>Duration</th>
					<td><input type="text" style="width:80px;" class="input2" value="" disabled name="from_dt" id="from_dt" /><span class="dash">~</span><!--
					--><input type="text" style="width:80px;" class="input2" value="" disabled name="to_dt" id="to_dt" /></td>
		   		</tr>
		   	</table>
		   	<table>
				<colgroup>
					<col width="100" />				
					<col width="120" />				
					<col width="70" />				
					<col width="*" />				
			   </colgroup> 
		   		<tr>
		   			<th>Applicable Date</th>
		   			<td><input type="text" style="width:80px;" class="input1" value="<%=app_dt%>" name="app_dt" dataformat="ymd" id="app_dt" /><!--
		   			--><button type="button" id="btn_app_dt" name="btn_app_dt" class="calendar ir"></button></td>
		   			<th>Name</th>
					<td><input type="text" style="width:165px;" class="input" value="" name="cust_lgl_eng_nm" maxlength="20" onkeyup="javascript:upper(this);" id="cust_lgl_eng_nm" /></td>
			</table>
		</div>
		<!-- opus_design_inquiry(E) -->
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>
</div>
</form>
 <%@include file="/bizcommon/include/common_opus.jsp"%>