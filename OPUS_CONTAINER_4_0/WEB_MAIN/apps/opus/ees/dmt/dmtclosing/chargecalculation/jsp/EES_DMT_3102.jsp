<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3102.jsp
*@FileTitle  : Split Payment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.event.EesDmt3102Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3102Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet Count of list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeCalculation");
	
	// Parameters from Calling PopUp page 
	String bkgNo		= JSPUtil.getParameter(request, "bkg_no", "");
	String blNo			= JSPUtil.getParameter(request, "bl_no", "");
	String dmdtTrfCd	= JSPUtil.getParameter(request, "dmdt_trf_cd", "");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3102Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server
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


<input type="hidden" name="svr_id" id="svr_id"  value="<%=JSPUtil.getParameter(request, " svr_id", "") %>" />
<input type="hidden" name="cntr_no" value="<%=JSPUtil.getParameter(request, " cntr_no", "") %>" id="cntr_no" />
<input type="hidden" name="cntr_cyc_no" value="<%=JSPUtil.getParameter(request, " cntr_cyc_no", "") %>" id="cntr_cyc_no" />
<input type="hidden" name="dmdt_chg_loc_div_cd" value="<%=JSPUtil.getParameter(request, " dmdt_chg_loc_div_cd", "") %>" id="dmdt_chg_loc_div_cd" />
<input type="hidden" name="cntr_tpsz_cd" value="<%=JSPUtil.getParameter(request, " cntr_tpsz_cd", "") %>" id="cntr_tpsz_cd" />
<input type="hidden" name="dmdt_chg_sts_cd" value="<%=JSPUtil.getParameter(request, " dmdt_chg_sts_cd", "") %>" id="dmdt_chg_sts_cd" />
<input type="hidden" name="backendjob_key" id="backendjob_key" />
<input type="hidden" name="backendjob_id" id="backendjob_id" />
<input type="hidden" name="yd_cd1" id="yd_cd1" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Split Payment</span></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Save" id="btn_Save" type="button">Save</button><!--
		--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
		--></div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<!-- page_title_area(E) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table> 
			<colgroup>
				<col width="50"/>
				<col width="140"/>
				<col width="50"/>
				<col width="140"/>
				<col width="70"/>
				<col width="*" />				
		   	</colgroup> 
		   	<tbody>
			<tr>
				<th>BKG No.</th>
				<td><input type="text" name="bkg_no" value="<%=bkgNo%>" style="width:110px;" class="input2" readonly id="bkg_no" /> </td>
				<th>B/L No.</th>
				<td><input type="text" name="bl_no" value="<%=blNo%>" style="width:110px;" class="input2" readonly id="bl_no" /> </td>
				<th>Tariff Type</th>
				<td><input type="text" name="dmdt_trf_cd" value="<%=dmdtTrfCd%>" style="width:110px;" class="input2" readonly id="dmdt_trf_cd" /> </td>
			</tr>
			</tbody>
		</table> 
	</div>
</div>					

<div class="wrap_result">
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_RowInsert" id="btn_RowInsert" type="button">Row Insert</button><!--
		--><button class="btn_normal" name="btn_Delete" id="btn_Delete" type="button">Delete</button><!--
		--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>	
</form>	
