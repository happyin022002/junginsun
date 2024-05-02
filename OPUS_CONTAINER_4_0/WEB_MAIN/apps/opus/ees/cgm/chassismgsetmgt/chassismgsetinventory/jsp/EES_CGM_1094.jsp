<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_CGM_1094.jsp
*@FileTitle  : Chassis Long Staying Environment
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/11
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetinventory.event.EesCgm1094Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%>

<%
	EesCgm1094Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";

	Logger log = Logger.getLogger("com.clt.apps.ChassisMgsetMgt.ChassisMgsetInventory");

	String xml = HttpUtil.makeXML(request,response);

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EesCgm1094Event)request.getAttribute("Event");
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

<form name="form2">
<input type="hidden" name="sXml" value="<%=xml.replace(" \"","'") %>" id="sXml" />
</form>
<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn (S) -->
	<div class="opus_design_btn">
		<button class="btn_accent" name="btn_retrieve" id="btn_retrieve" type="button">Pre-Set Env.</button><!--
		--><button class="btn_normal" name="btn_new" id="btn_new" type="button">New</button><!--
		--><button class="btn_normal" name="btn_save" id="btn_save" type="button">Save</button><!--
		--></div>
	<!-- opus_design_btn (E) -->

	<!-- page_location(S) -->
	<div class="location">	
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_search">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50"/>			
				<col width="*"/>			
		   </colgroup> 
		   <tr>
			   	<th>Long Staying Days Period</th>
				<td><input name="staying_days" type="text" style="width:60px;text-align:right;ime-mode:disabled" class="input1" value="0" dataformat="num" maxlength="5" id="staying_days" /></td>
		   </tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
</div>

<div class="wrap_result">
	<!-- opus_design_inquiry(S) -->
	<div class="opus_design_inquiry">
		<table>
			<colgroup>
				<col width="50"/>			
				<col width="50"/>			
				<col width="50"/>			
				<col width="50"/>			
				<col width="50"/>			
				<col width="*"/>			
		   </colgroup>
			<tr>
				<th>1st</th>
				<td><input name="n1st_inq_fm_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input2" value="0" dataformat="num" maxlength="5" disabled="" id="n1st_inq_fm_dys" /><input name="n1st_inq_to_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input" value="15" dataformat="num" maxlength="5" id="n1st_inq_to_dys" /></td>
				<th>2nd</th>
				<td><input name="n2nd_inq_fm_dys" type="text" style="width:50px;ime-mode:disabled;text-align:right;" class="input2" value="16" dataformat="num" maxlength="5" disabled="" id="n2nd_inq_fm_dys" /><input name="n2nd_inq_to_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input" value="30" dataformat="num" maxlength="5" id="n2nd_inq_to_dys" /></td>
				<th>3rd</th>
				<td><input name="n3rd_inq_fm_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input2" value="31" dataformat="num" maxlength="5" disabled="" id="n3rd_inq_fm_dys" /><input name="n3rd_inq_to_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input" value="50" dataformat="num" maxlength="5" id="n3rd_inq_to_dys" /></td>
			</tr>
			<tr>
				<th>4th</th>
				<td><input name="n4th_inq_fm_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input2" value="51" dataformat="num" maxlength="5" disabled="" id="n4th_inq_fm_dys" /><input name="n4th_inq_to_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input" value="100" dataformat="num" maxlength="5" id="n4th_inq_to_dys" /></td>
				<th>5th</th>
				<td><input name="n5th_inq_fm_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input2" value="101" dataformat="num" maxlength="5" disabled="" id="n5th_inq_fm_dys" /><input name="n5th_inq_to_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input" value="180" dataformat="num" maxlength="5" id="n5th_inq_to_dys" /></td>
				<th>6th</th>
				<td><input name="n6th_inq_fm_dys" type="text" style="width:50px;text-align:right;ime-mode:disabled" class="input2" value="181" dataformat="num" maxlength="5" disabled="" id="n6th_inq_fm_dys" />&nbsp;~&nbsp;&nbsp;or Over</td>
			</tr>
		</table>
	</div>
	<!-- opus_design_inquiry(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" id="tabLayer" style="display:none">		
		<script type="text/javascript">ComSheetObject('sheet1');</script>		
	</div>
	<!-- opus_design_grid(E) -->
	<!-- opus_design_grid(S) -->
	<div class="opus_design_grid" style="display:none">		
		<script type="text/javascript">ComSheetObject('sheet2');</script>		
	</div>
	<!-- opus_design_grid(E) -->
</div>
</form>