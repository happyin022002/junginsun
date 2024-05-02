<%--
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0205.jsp
*@FileTitle  : Tire Replacement History Report
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
<%@ page import="com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event.EesMnr0205Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0205Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Occurred error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//Row count of retrieved database data

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ReportManage.PerformanceReport");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesMnr0205Event)request.getAttribute("Event");
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

<script language="javascript">
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

<!-- page_title_area(S) -->
<div class="page_title_area clear ">
	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
		
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_new" id="btn_new">New</button>
	</div>
	<!-- opus_design_btn(E) -->	
	
    <!-- page_location(S) -->
	<div class="location"><span id="navigation"></span></div>
	
</div>
<!-- page_title_area(E) -->



<!-- wrap_search(S) -->
<div class="wrap_search">
	<div class="opus_design_inquiry wFit">   <!-- no TAB  -->
		<table>
			<colgroup>
				<col width="1" />
				<col width="270" />
				<col width="50" />
				<col />
			</colgroup>
			<tbody>
				<tr>
					<th>Period</th>
					<td><span class="inquiry_calendar">
	                        <input type="text" style="width:80px; ime-mode:disabled" dataformat="ymd" maxlength='8' name="from_dt" value="" class="input1"><!--
	                        --><span class="dash">-</span><!--
	                        --><input type="text" style="width:80px; ime-mode:disabled" dataformat="ymd" maxlength='8' name="to_dt" value="" class="input1"><!--
	                        --><button type="button" class="calendar ir" name="cre_dt_cal" id="cre_dt_cal"></button>
	                   	</span>
					</td>
					<th>EQ No.</th>
					<td><input type="text" style="width:100px;" class="input" value="" name="eq_no" maxlength="11" dataformat="engup"></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<!-- wrap_search(E) -->



<!-- wrap_result(S) -->
<div class="wrap_result" >

	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
	
		<!-- opus_grid_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_downexcel" id="btn_downexcel">Down Excel</button>
		</div>
		<!-- opus_grid_btn(E) -->
		
		<script language="javascript">ComSheetObject('sheet1');</script>
		
	</div>
	<!-- opus_design_grid(E) -->
	
	
</div>
<!-- wrap_result(E) -->



</form>
</body>
</html>