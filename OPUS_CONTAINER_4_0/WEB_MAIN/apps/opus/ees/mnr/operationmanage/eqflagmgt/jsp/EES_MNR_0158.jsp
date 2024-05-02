<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0158.jsp
*@FileTitle  : M&R Disposal Candidate Inquiry_Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/13
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0158Event" %>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0158Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String rhqOfcCd         = "";
	String currOfcCd        = "";
	String currOfcEngNm     = "";
	Logger log = Logger.getLogger("com.clt.apps.OperationManage.EQFlagMgt");

	String reqCostOfcCd = ((request.getParameter("cost_ofc_cd")==null )?"":request.getParameter("cost_ofc_cd"));
	String eqKndCd = ((request.getParameter("eq_knd_cd")==null )?"":request.getParameter("eq_knd_cd"));

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id       = account.getUsr_id();
		strUsr_nm       = account.getUsr_nm();
		rhqOfcCd        = account.getRhq_ofc_cd();
		currOfcCd       = account.getOfc_cd();
		currOfcEngNm    = account.getOfc_eng_nm();

		event = (EesMnr0158Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//Extracting retrieved data from server on load screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
    var currOfcCd = "<%=currOfcCd.trim() %>";
    var selectOfc  = "<% out.print(currOfcCd + "|" + currOfcEngNm); %>";
    var rhqOfcCd  = "<%=rhqOfcCd.trim() %>";
    var HOOfc     = "";
    var self_usr_nm = "<%=strUsr_nm%>";
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}

</script>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="f_gubuns" id="f_gubuns" />
<input type="hidden" name="eq_knd_cd" id="eq_knd_cd" value="<%=eqKndCd %>"/>
<input type="hidden" name="cost_ofc_cd" value="<%=reqCostOfcCd%>" id="cost_ofc_cd" />
<div class="layer_popup_title">
	<!-- page_title_area(S) -->
	<div class="page_title_area clear">

		<!-- page_title(S) -->
		<h2 class="page_title"><span>Disposal Candidate Inquiry</span></h2>
		<!-- page_title(E) -->
		
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
			--><button class="btn_normal" name="btn_downExcel" id="btn_downExcel" type="button">Down Excel</button><!--
			--><button class="btn_normal" name="btn_ok" id="btn_ok" type="button">Ok</button><!--
			--><button class="btn_normal" name="btn_close" id="btn_close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>
	<!-- page_title_area(E) -->
</div>
<div class="layer_popup_contents">
	<!-- wrap_search(S) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table>
				<colgroup>
					<col width="60" />				
					<col width="*" />				
			   </colgroup> 
			   <tbody>
					<tr>
						<th>Location</th>
						<td><input required type="text" name="location_cd" dataformat="engup" style="width:85px;" class="input1" id="location_cd" /><button type="button" id="btn_location" name="btn_location" class="input_seach_btn"></button></td>
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
</div>


</form>
<%@include file="/bizcommon/include/common_opus.jsp" %>
