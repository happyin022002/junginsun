<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : EES_DMT_3011.jsp
*@FileTitle  : Deleted Charge Report by Office - Detail(s)
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
<%@ page import="com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event.EesDmt3011Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3011Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strRhq_ofc_cd	= "";
	Logger log = Logger.getLogger("com.clt.apps.DMTPerformanceAnalysis.ChargeCalculationReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id		= account.getUsr_id();
		strUsr_nm		= account.getUsr_nm();
		strRhq_ofc_cd	= account.getRhq_ofc_cd();
		

		event = (EesDmt3011Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<input type="hidden" name="dt_flg" id="dt_flg"			value="<%=JSPUtil.getParameter(request, "dt_flg", "")%>">
<input type="hidden" name="fm_dt" id="fm_dt"			value="<%=JSPUtil.getParameter(request, "fm_dt", "")%>">
<input type="hidden" name="to_dt" id="to_dt"			value="<%=JSPUtil.getParameter(request, "to_dt", "")%>">
<input type="hidden" name="grp_flg" id="grp_flg"			value="<%=JSPUtil.getParameter(request, "grp_flg", "")%>">
<input type="hidden" name="ofc_cd" id="ofc_cd"			value="<%=JSPUtil.getParameter(request, "ofc_cd", "")%>">
<input type="hidden" name="del_cd" id="del_cd"			value="<%=JSPUtil.getParameter(request, "del_cd", "")%>">
<input type="hidden"  name="usr_rhq_ofc_cd" id="usr_rhq_ofc_cd"	value="<%=strRhq_ofc_cd%>">
<input type="hidden" name="role_permit" id="role_permit" />
<input type="hidden" name="role_auth" id="role_auth" />
<div class="layer_popup_contents">
	<div class="layer_popup_title">
		<!-- page_title_area(S) -->
			<div class="page_title_area clear">
			   <!-- page_title(S) -->
				<h2 class="page_title"><button type="button"><span>Deleted Charge Report by Office– Detail(s)</span></button></h2>
				<!-- page_title(E) -->
				<!-- opus_design_btn(S) -->
				<div class="opus_design_btn">
					<button type="button" class="btn_accent" name="btn_ByBKG" 	id="btn_ByBKG">By BKG</button><!--
					--><button type="button" class="btn_normal" name="btn_ByCNTR" 		id="btn_ByCNTR">By CNTR</button><!--
					--><button type="button" class="btn_normal" name="btn_DownExcel"  		id="btn_DownExcel">Down Excel</button><!-- 
					--><button type="button" class="btn_normal" name="btn_Close"  		id="btn_Close">Close</button>	
				</div>
				<!-- opus_design_btn(E) -->
				<!-- page_location(S) -->
				<div class="location">
					<span id="navigation"></span>
				</div>
				<!-- page_location(E) -->
			</div>
		<!-- page_title_area(E) -->
	</div>
<!-- opus_design_grid(S) -->
<div class="wrap_result">
	<div class="opus_design_grid clear" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>	
	<div class= "opus_design_inquiry ">
		<table>
			<tbody>
				<colgroup>
					<col width="80"/>
					<col width="*"/>
			    </colgroup>
				<tr>
					<th>CNTR Q'ty</th>
					<td><input type="text" name="cntr_qty" style="width:50px;text-align:right;" class="input2" readonly id="cntr_qty" /></td>
				</tr>	
			</tbody>
		</table>
	</div>
</div>

<!-- opus_design_grid(E) -->
</div>
</form>