<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_LSE_0002.jsp
*@FileTitle  : Lease Agreement Version – Pop Up
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.event.EesLse0002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0002Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerLeaseAgreementRegistration.AgreementRegistration");
	
	String strAgmtSeq = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

		strAgmtSeq = JSPUtil.getNull(request.getParameter("agmt_seq"));
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
<input type="hidden" name="lstm_cd" id="lstm_cd" />
<!-- OUTER - POPUP (S)tart -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<h2>Equipment Agreement Version</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_Retrieve" id="btn_Retrieve" type="button">Retrieve</button><!--
		--><button class="btn_normal" name="btn_New" id="btn_New" type="button">New</button><!-- 
		 --><button class="btn_normal" name="btn_Ok" id="btn_Ok" type="button">Ok</button><!-- 
		 --><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button>
		</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->
<div class= "wrap_search">
<div class= "opus_design_inquiry wFit">
		<table> 
		<tbody>
			<colgroup>
				<col width="60">
				<col width="150">
				<col width="70">
				<col width="50">
				<col width="70">
				<col width="*">				
			</colgroup> 
       		<tr>
				<th>AGMT No</th>
				<td><input type="text" name="agmt_cty_cd" caption="AGMT No." style="width:35px;text-align:center;" class="input2" value="HHO" readonly id="agmt_cty_cd" /><input type="text" name="agmt_seq" caption="AGMT No." style="width:50px;text-align:center;" class="input" value="<%= strAgmtSeq %>" maxlength="6" dataformat="num" id="agmt_seq" /><button type="button" id="btns_search1" name="btns_search1" class="input_seach_btn"></button></td>
				<th>Lease Term</th>
				<td><script type="text/javascript">ComComboObject('combo1', 1, 50, 1);</script></td>
				<th>Lessor</th>
				<td><input type="text" name="vndr_seq" caption="Lessor" style="width:50px;text-align:center;" class="input" maxlength="6" dataformat="num" id="vndr_seq" /><button type="button" id="btns_search2" name="btns_search2" class="input_seach_btn"></button><input type="text" name="vndr_nm" caption="Lessor" style="width:200px;" class="input2" value="" readonly="" id="vndr_nm" /></td>
			</tr>
			</tbody>
		</table>
</div>
</div>
<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
<div class="wrap_result">
 <!-- opus_design_grid(S) -->
	        <div class="opus_design_grid">
							<script type="text/javascript">ComSheetObject('sheet1');</script>
			</div>
</div>
</form>