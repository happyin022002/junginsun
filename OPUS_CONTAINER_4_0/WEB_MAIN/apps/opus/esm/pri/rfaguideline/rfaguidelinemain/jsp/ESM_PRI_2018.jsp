<%/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_PRI_2018.jsp
*@FileTitle  :  RFA Guideline Inquiry
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/04 
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.rfaguideline.rfaguidelinemain.event.EsmPri2018Event"%>
<%@ page import="com.clt.framework.component.util.code.CodeUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmPri2018Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.RFAGuideline.RFAGuidelineMain");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri2018Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	log.debug(serverException);
		}
		
		// adding logic to get data from server when first loading
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="usr_id" id="usr_id" value="<%=strUsr_id%>">
<!-- developer performance	-->

<!-- page_title_area(S) -->			
<div class="page_title_area clear">			
	<!-- page_title(S) -->		
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->		
	<h2 class="page_title">		
		<button type="button">	
			<span id="title"></span>
		</button>	
	</h2>		
	<!-- page_title(E) -->		
	<!-- opus_design_btn(S) -->		
	<div class="opus_design_btn">		
		<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button>				
	</div>		
	<!-- opus_design_btn(E) -->		
			
	<!-- page_location(S) -->		
	<div class="location">		
		<!-- location 내용 동적생성 (별도 코딩 불필요) -->	
		<span id="navigation"></span>	
	</div>		
</div>			
			
<!-- page_title_area(E) -->			
<!-- wrap_search(S) -->
<div class="wrap_search_tab">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
	<table>
		<colgroup>
			<col width="100">
			<col width="300">
			<col width="50">
			<col width="50">
			<col width="100">
			<col width="100">
			<col width="100">
			<col width="100">
			<col width="*">
		</colgroup>
		<tr>
			<th>Service Scope</th>
			<td><script type="text/javascript">ComComboObject("svc_scp_cd", 2, 50, 0, 1, 0, false);</script><!--
			--><input name="svc_scp_nm" type="text" style="width:222px;"  value="" class="input2" readonly caption="Service Scope"></td>
			<th>Year</th>
			<td><input type="text" suppresswait="Y" name="scope_year" style="width:60px; text-align:center;" value="" maxlength="4" dataformat="yyyy" caption="Year" id="scope_year" /></td>
			<th>Duration</th>
			<td><script type="text/javascript">ComComboObject("gline_seq", 3, 90, 1, 1, 2, true);</script>&nbsp;~&nbsp;<!--
			--><input name="eff_dt" type="hidden" value="" class="input1" caption="Effective Date" required><!--
			--><input name="eff_dt_hidden" type="hidden" value="" class="input1"></td>
			<td><input name="exp_dt" type="text" style="width:80px;" value="" class="input1" readonly caption="Expire Date" maxlength="10" dataformat="ymd" required id="exp_dt" /></td>
			<th>Confirmation</th>
			<td><input name="cfm_flg" type="text" style="width:38px;" value="" class="input2" readonly caption="Confirmation" id="cfm_flg" /></td>
		</tr>
	</table>
	
	<table> 
		<colgroup>
			<col width="100">
			<col width="87">
			<col width="80">
			<col width="110">
			<col width="66">
			<col width="*">
		</colgroup>			
		<tbody>
			<tr>
			<th>Creation Date</th>
			<td><input name="cre_dt" type="text" style="width:80px;" value="" class="input2" readonly caption="Creation Date" id="cre_dt" /></td>
			<th>Staff</th>
			<td><input name="cre_usr_nm" type="text" style="width:110px;" value="" class="input2" readonly caption="Staff" id="cre_usr_nm" /></td>
			<th>Team</th>
			<td><input name="cre_ofc_cd" type="text" style="width:60px;" value="" class="input2" readonly caption="Team" id="cre_ofc_cd" /></td>
		</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry (E) -->
</div>
<!-- opus_tab_btn(S) -->
<div class="wrap_result">
	<div class="opus_design_tab">
		<script type="text/javascript">ComTabObject('tab1')</script>
	</div>

<!-- opus_tab_btn(E) -->
	<!-- iFrame (S) -->
	<div id="tabLayer" style="display:none">
		<iframe name="t1frame" id="t1frame" frameborder="0" scrolling="no" width="100%" height="460px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t2frame" id="t2frame" frameborder="0" scrolling="no" width="100%" height="460px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t3frame" id="t3frame" frameborder="0" scrolling="no" width="100%" height="460px" src="about:blank"></iframe>
	</div>
	<div id="tabLayer" style="display:none">
		<iframe name="t4frame" id="t4frame" frameborder="0" scrolling="no" width="100%" height="630px" src="about:blank"></iframe>
	</div>            
	<!-- iFrame (E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid" style="display:none">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<!-- developer performance  end -->
</form>