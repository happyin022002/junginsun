<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   :ESM_COA_0015.jsp
*@FileTitle  : Inquiry and update DEM/DET 3RD 
*@author     : CLT
*@version    : 1.0
*@since      : 29/04/2014
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.coa.stdunitcost.demdet3rd.event.EsmCoa0015Event"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="org.apache.log4j.Logger" %>

	<%
	//	EsmCoa0015Event  event = null;					//PDTO(Data Transfer Object including Parameters)
		Exception serverException   = null;			//Error from server
		String strErrMsg = "";						//Error message
		int rowCount	 = 0;						//Count of DB resultSET list
	
		String successFlag = "";
		String codeList  = "";
		String pageRows  = "100";
	
		String strUsr_id		= "";
		String strUsr_nm		= "";
		String xml				= "";
		Logger log = Logger.getLogger("com.clt.apps.STDUnitCost.DemDet3rd");
	
		try {
		   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			strUsr_id =	account.getUsr_id();
			strUsr_nm = account.getUsr_nm();
	
	
	//		event = (EsmCoa0015Event)request.getAttribute("Event");
			serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
	
			if (serverException != null) {
				strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
			}
			
	        xml = HttpUtil.makeXML(request,response); 
	        xml = xml.replaceAll("\"", "'");
	
	//		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
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
			ComSetFocus(document.form.f_cost_yrmon); 
		}
	</script>
	<form method="post" name="form" onSubmit="return false;" onKeyDown="ComKeyEnter();" >
	<input	type="hidden" id="f_cmd" name="f_cmd">
	<input type="hidden" id="iPage" name="iPage">
	<input type="hidden" id="sXml" name="sXml" value="<%=xml%>">

	<div class="page_title_area clear">
	   <!-- page_title(S) -->
		<h2 class="page_title"><button type="button"><span id="title"></span></button></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn(S) -->
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_retrieve" id="btn_retrieve">Retrieve</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_downexcel" 	id="btn_downexcel">Down Excel</button><!-- 
			 --><button type="button" class="btn_normal" name="btn_loadexcel" 	id="btn_loadexcel">Load Excel</button>	
		</div>
		<!-- opus_design_btn(E) -->
	
		<!-- page_location(S) -->
		<div class="location">
			
			<span id="navigation"></span>
		</div>
	</div>
<div class= "wrap_search">
<div class= "opus_design_inquiry wFit">
	<table>
	<tbody>
		<colgroup>
		<col width="45"></col>
		<col width="*"></col>
		</colgroup>
		<tr>
			<th>YYYY-MM</th>
			<td><input type="text" name="f_cost_yrmon" class="input1" style="width:60px;" value="" maxlength="7" dataformat="ym" onKeyDown="ComKeyEnter()" onkeypress="ComKeyOnlyNumber(window)" onfocus="this.value=ComReplaceStr(this.value, '-', '');" onblur="addDash(this , 4);" id="f_cost_yrmon" />
			</td>
		</tr>
		</tbody>
		</table>
</div>
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<!-- opus_design_btn(S) -->
	  	<h3>DEM/DET, Vol Discount Inquiry</h3>
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_add" id="btn_add">Row Add</button>
			<button type="button" class="btn_normal" name="btng_save" 	id="btng_save">Save</button>
		</div> 
		<!-- opus_design_btn(e) -->
		<script type="text/javascript">ComSheetObject('sheet1');</script>
	<!-- opus_design_grid(S) -->
</div>
</div>	 
</form>