<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName:  :EES_MNR_0107.js
*@FileTitle  : DV Factor 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/19
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.dvfactormgt.event.EesMnr0107Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesMnr0107Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	
	String strUsr_id		= "";
	String strUsr_nm		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EesMnr0107Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
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
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
		--><button type="button" class="btn_normal" name="btn_New"  	id="btn_New">New</button><!--
		--><button type="button" class="btn_normal" name="btn_Save" 	id="btn_Save">Save</button>
	</div>
	<!-- opus_design_btn(E) -->

	<!-- page_location(S) -->
	<div class="location">
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->
		<span id="navigation"></span>
	</div>
</div>
<!-- page_title_area(E) -->


<!-- opus_design_inquiry(S) -->
<div class= "wrap_search_tab">
	<div class="opus_design_inquiry wFit">
		<table>
			<tbody>
				<tr>
					<th width="1">Applicable Year</th>
					<td width="*">
					  <span class="inquiry_calendar">
				     	  <input type="text" name="eq_dpc_yr" id="eq_dpc_yr" style="width:50;text-align:center" class="input1" maxlength="4" dataformat="yyyy"><!--
				     	  --><a class="calendar ir" name="dpc_yr_cal" id="dpc_yr_cal" style="cursor:pointer">calendar</a>
				      </span>
					</td>
				</tr> 
			</tbody>
		</table>
	</div>
</div>
<!-- opus_design_inquiry(E) -->

<div class="wrap_result">
	<!-- opus_tab_btn(S) -->
		<div class="opus_design_tab">
			<script type="text/javascript">ComTabObject('tab1')</script>
		</div>
<!-- opus_tab_btn(E) -->

<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:inline">
	<div class="opus_design_grid clear" >
		<script type="text/javascript">ComSheetObject('t1sheet1');</script>
	</div>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
	<script type="text/javascript">ComSheetObject('t2sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div id="tabLayer" style="display:none">
			<div class="opus_design_grid clear" >
	<script type="text/javascript">ComSheetObject('t3sheet1');</script>
</div>
</div>
<!-- opus_design_grid(E) -->
</div>
</form>
