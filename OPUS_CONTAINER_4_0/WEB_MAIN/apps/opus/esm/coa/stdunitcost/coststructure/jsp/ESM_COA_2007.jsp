<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : esm_coa_2007.jsp
*@FileTitle  : Week Period Management
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.coststructure.event.EsmCoa2007Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.apps.opus.bcm.sup.valuemanage.util.OfficeCodeMgr"%>
<%
	EsmCoa2007Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strOfc_cd		= "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		strOfc_cd = account.getOfc_cd();

		event = (EsmCoa2007Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<script type="text/javascript">

<%=OfficeCodeMgr.getOfficeCodeListToJS("000001", "MST")%>

	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if

		// Setting Ofc_cd
		strOfcCd = "<%=strOfc_cd%>";

		loadPage();
	}
</script>
<form name="form"  onKeyDown="ComKeyEnter();">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
 <!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
	<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Retrieve</button><!--
	--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
	--><button class="btn_normal" name="btn_downexcel" id="btn_downexcel" type="button">Down Excel</button><!--
	--><button class="btn_normal" name="btn_loadexcel" id="btn_loadexcel" type="button">Load Excel</button><!--
	--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
</div>
<!-- page_title_area(E) -->
<!-- wrap_search(S) -->
<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry wFit">
		<table>
			<colgroup>
				<col width="40" />				
				<col width="80" />				
				<col width="60" />				
				<col width="*" />				
		   </colgroup> 
		   <tbody>
	   			<tr class="h23">
	               <th>Year</th>
	               <td><input type="text" class="" size="6" name="f_cost_yr" dataformat="yyyy" id="f_cost_yr" /></td>
	               <th>Week</th>
	               <td><!--
	               --><input type="text" class="" size="3" name="f_cost_wk_fm" maxlength="2"  dataformat="num" id="f_cost_wk_fm" /><!--
	               --><span class="dash">~</span><!--
	               --><input type="text" class="" size="3" name="f_cost_wk_to" maxlength="2" dataformat="num"  id="f_cost_wk_to" /></td>
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
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn">
			<button class="btn_accent" name="btn_add" id="btn_add" type="button">Row Add</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
<!-- wrap_result(E) --> 
</form>
