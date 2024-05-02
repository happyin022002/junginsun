<%
/*=========================================================
 *Copyright(c) 2014 CyberLogitec. All Rights Reserved.
 *@FileName   : ESM_PRI_0002_04.jsp
 *@FileTitle  : Origin/Destination Arbitrary Charge Guideline Inquiry
 *@author     : CLT
 *@version    : 1.0
 *@since      : 2014/06/09
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.event.EsmPri000204Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
	EsmPri000204Event  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	//int rowCount	 = 0;						//count of DB resultSET list
	
	//String successFlag = "";
	//String codeList  = "";
	//String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	//Logger log = Logger.getLogger("com.clt.apps.SCGuideline.SCArbitraryChargeGuideline");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (EsmPri000204Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
		//GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />


<input type="hidden" name="svc_scp_cd" value="" id="svc_scp_cd" />
<input type="hidden" name="gline_seq" value="" id="gline_seq" />
<input type="hidden" name="org_dest_tp_cd" value="O" id="org_dest_tp_cd" />
<input type="hidden" name="cd" id="cd" />

<div class="opus_design_title clear">
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_DownExcel" 	id="btn_DownExcel">Down Excel</button>
	</div>
</div>

<div class="opus_design_inquiry" style="width:350px;margin-top:-25px;">
	<table>
		<colgroup>
			<col width="40px">
			<col width="10px" />
			<col width="300px">
			<col width="*">
		</colgroup>
		<tr>
			<th class="sm">Type</th>
			<td class="sm"></td>
			<td class="sm">
				<input type="radio" class="trans" name="dest_tp_cd" checked > <span id="dest_tp_cd1">Origin Arbitrary</span>&nbsp;&nbsp;&nbsp;
				<input type="radio" class="trans" name="dest_tp_cd" > <span id="dest_tp_cd2">Destination Arbitrary</span>
			</td>
			<td></td>
		</tr>
	</table>
</div>


<div class="opus_design_grid" id="mainTable">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->
</form>