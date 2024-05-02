<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESD_SCE_0110.jsp
*@FileTitle  : Summary Report by Customer - Detail(s)
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/31
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt6006Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt6006Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB ResultSet list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id = account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strRhq_ofc_cd = account.getRhq_ofc_cd();

		event = (EesDmt6006Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// in loading page, Get data from server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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



<input type="hidden" name="start_dt">
<input type="hidden" name="end_dt">
<input type="hidden" name="sc_no">
<input type="hidden" name="rfa_no">
<input type="hidden" name="cust_cd">
<input type="hidden" name="cust_nm">
<input type="hidden" name="ctrt_ofc">
<input type="hidden" name="dmdt_trf_cd">
<input type="hidden" name="ofc_cd">
<input type="hidden" name="cvr_cd">
<input type="hidden" name="por_cd">
<input type="hidden" name="pol_cd">
<input type="hidden" name="pod_cd">
<input type="hidden" name="del_cd">
<input type="hidden" name="usr_rhq_ofc_cd"		value="<%=strRhq_ofc_cd%>">

<!-- Parameters for checking authority  -->
<input type="hidden" name="role_permit">
<input type="hidden" name="role_auth">


<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title" style="font-weight:100;">Summary Report by Customer - Detail(s)</h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_ByBKG" id="btn_ByBKG">by BKG</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_ByCNTR"  	id="btn_ByCNTR">by CNTR</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
</div>
<!-- page_title_area(E) -->
<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_inquiry">
		<table>
			<tbody>
				<colgroup>
					<col width="70"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>CNTR Q'ty</th>
					<td><input type="text" name="cntr_qty" id="cntr_qty" style="width:50px;text-align:right;" readonly ></td>				
				</tr>
			</tbody>
		</table>
	</div>
	<!-- opus_tab_btn(E) -->
</div>
</form>
