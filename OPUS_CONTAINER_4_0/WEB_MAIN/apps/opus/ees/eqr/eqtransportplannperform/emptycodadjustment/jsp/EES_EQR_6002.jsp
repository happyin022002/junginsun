<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_EQR_6002.jsp
*@FileTitle  : Remark by VVD
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/05
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.io.HttpUtil"%> 
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.eqr.eqtransportplannperform.emptycodadjustment.event.EesEqr6002Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.clt.framework.component.util.StringUtil"%>
<%
	EesEqr6002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String xml = "";
	Logger log = Logger.getLogger("com.clt.apps.EQTransportPlanNPerform.EmptyCODAdjustment");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesEqr6002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// adding logic to get data from server when first loading ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		xml = HttpUtil.makeXML(request,response);

	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script type="text/javascript">

	function setupPage(){

		document.form.vessel_remark.value = ComGetEtcData(document.form.xml.value, "vesselremark");

		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
	//	loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />
<input type="hidden" name="div" value="S" id="div" />
<input type="hidden" name="xml" value="<%=xml%>" id="xml" />
<input type="hidden" name="row" value="<%=StringUtil.xssFilter(request.getParameter("row")) %>" id="row" />
<input type="hidden" name="weekdivision" value="<%=StringUtil.xssFilter(request.getParameter("weekdivision")) %>" id="weekdivision" />
<input type="hidden" name="vvd" value="<%=event.getEmptyCODVVDVO().getVvd()%>" id="vvd" />

<!-- page_title_area(S) -->
<div class="page_title_area clear">

	<!-- page_title(S) -->
	<h2 class="page_title"><span>Remark by VVD</span></h2>
	<!-- page_title(E) -->
	
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_save" 			id="btn_save">Save</button><!-- 
		 --><button type="button" class="btn_normal" name="btn_delete" 		id="btn_delete">Delete</button><!-- 		
		 --><button type="button" class="btn_normal" name="btn_close" 		id="btn_close">Close</button>		
	</div>
	<!-- opus_design_btn(E) -->	
	
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
	<div class="opus_design_inquiry">
		<table>
			<colgroup>				
				<col width="*" />				
			</colgroup> 
			<tbody>
				<tr class="h23">
       				<td><input type="text" style="width:200px;" value="WK:<%=event.getEmptyCODVVDVO().getWeek()%>,   <%=event.getEmptyCODVVDVO().getLane()%>/ <%=event.getEmptyCODVVDVO().getVvd()%>" class="input2" /> </td>
       			</tr>
			</tbody>
		</table>
		<table class="grid2">
			<tbody>
				<tr>
					<th style= "text-align:center;"><strong>Vessel Schedule Remark</strong></th>
				</tr>
				<tr>
					<td><textarea style="width:100%;resize:none;" rows="5" class="textarea" name="vessel_remark" id = "vessel_remark" disabled=""></textarea></td>
				</tr>
			</tbody>
		</table>
		<table class="grid2">
			<tbody>
				<tr class="sm">
					<th style= "text-align:center;"><strong>Note</strong></th>
				</tr>
				<tr>
					<td><textarea style="width:100%;resize:none;" rows="7" class="textarea" name="remark" id = "remark" ><%=event.getEmptyCODVVDVO().getRemark()%></textarea></td>
				</tr>
			</tbody>
		</table>		
	</div>
	<!-- opus_design_inquiry(E) -->
	
</div>
</form>