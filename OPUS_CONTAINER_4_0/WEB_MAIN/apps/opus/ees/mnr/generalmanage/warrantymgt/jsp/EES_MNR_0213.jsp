<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_MNR_0213.jsp
*@FileTitle  : Warranty Alert_Pop Up 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/
=========================================================
*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.event.EesMnr0213Event"%>
<%@ page import="org.apache.log4j.Logger" %> 

<%
	EesMnr0213Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//Error message
	String strUsr_id		= "";      
	String strUsr_nm		= "";    
 	String eq_no = ((request.getParameter("eq_no")==null )?"":request.getParameter("eq_no")); 
	try { 
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm(); 
		event = (EesMnr0213Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		} 
	} catch(Exception e) {
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

<body class="popup_bg"  onLoad="setupPage();">
<form name="form"> 
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="eq_no" value="<%=eq_no%>" id="eq_no" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<span>Warranty Alert</span>
	</h2>
	<!-- page_title(E) -->
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button type="button" id="btn1_Close" name="btn1_Close" class="btn_accent">Close</button>
	</div>
	<!-- opus_design_btn (E) -->
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<div class="opus_design_inquiry wFit">
		<table class="grid_2">
			<tr>
				<th colspan="3" style="text-align: center;"><strong>Warranty Warning!<br>(This EQ is in Warranty Service of Maker.)</strong></th>
			</tr>    
			<tr>
				<th style="text-align: center;">Warranty Period</th>
				<td><input name="fm_warr_dt" type="text" style="width: 100%;" class="input2" readonly id="fm_warr_dt" /></td>
				<td><input name="to_warr_dt" type="text" style="width: 100%;" class="input2" readonly id="to_warr_dt" /></td>
			</tr>
			<tr>
				<th style="text-align: center;">Maker</th>
				<td colspan="2"><input name="eq_mkr_nm" type="text" style="width: 100%; text-align:center;" class="input2" readonly id="eq_mkr_nm" class="wAuto"/></td>
			</tr>
			<tr>
				<th style="text-align: center;">Unit Model</th>
				<td colspan="2"><input name="eq_mdl_nm" type="text" style="width: 100%; text-align:center;" class="input2" readonly id="eq_mdl_nm" class="wAuto"/></td>
			</tr>  
			<tr> 
				<th style="text-align: center;">Remark</th>
				<td colspan="2"><input name="warr_rmk" type="text" style="width: 100%; text-align:left;" class="input2" readonly id="warr_rmk" class="wAuto"/></td>
			</tr>      
		</table>
	</div>
</div>

<div class="wrap_result">
	<div class="opus_design_grid">
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>
</div>
</form>