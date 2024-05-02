<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_4024.jsp
*@FileTitle  : Exchange Rate Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================
--%>


<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.primasterdata.exchangerate.event.EsmPri4024Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri4024Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.PRIMasterData.ExchangeRate");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmPri4024Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading
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
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<colgroup>
					<col width="100"/>
					<col width="200" />
					<col width="100"/>
					<col width="*" />
				</colgroup>
				<tr>
					<th>Year/Month</th>
					<td><input type="text" name="from_acct_xch_rt_yrmon" id="from_acct_xch_rt_yrmon" dataformat="ym" maxlength="7" style="width:60px;" class="input1" required caption="Year/Month Start Date">~ <input type="text" name="to_acct_xch_rt_yrmon" id="to_acct_xch_rt_yrmon" dataformat="ym" maxlength="6" style="width:60px;" class="input"></td>
					<th>Currency Code</th>
						<td><input type="text" name="curr_cd" id="curr_cd" maxlength="3" dataformat="enguponly" style="width:40px; ime-mode:disabled;" class="input"></td>
				</tr>
				
			</tbody>
		</table>
	
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
	<div class="opus_design_grid clear" id="subTable" style="display:none">
		<script type="text/javascript">ComSheetObject('sheet2');</script>
	</div>
</div>
</form>