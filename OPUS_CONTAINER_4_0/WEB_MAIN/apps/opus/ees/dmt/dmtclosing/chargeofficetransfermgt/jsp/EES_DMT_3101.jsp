<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : EES_DMT_3101.jsp
*@FileTitle  : Office Transfer
*@author     : CLT
*@version    : 1.0
*@since      : 2014/07/30
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.event.EesDmt3101Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesDmt3101Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id = "";
	String strUsr_nm = "";
	Logger log = Logger.getLogger("com.clt.apps.DMTClosing.ChargeOfficeTransferMgt");
	
	
	String fmOfcCd = JSPUtil.getParameter(request, "fm_ofc_cd", "");
	String ofcRhqCd = JSPUtil.getParameter(request, "ofc_rhq_cd", "");
	

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesDmt3101Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// Retrieving the parameter values ​​for calls to pop-up page ..
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
<input type="hidden" name="f_cmd" id="f_cmd" />
<input type="hidden" name="pagerows" id="pagerows" />

<!-- Developer's task	-->
<input type="hidden" name="ofc_cd" id="ofc_cd" />
<input type="hidden" name="ofc_rhq_cd" value="<%=ofcRhqCd%>" id="ofc_rhq_cd" />
<input type="hidden" name="to_ofc_cd" id="to_ofc_cd" />

	<!-- page_title_area(S) -->
	<div class="page_title_area clear">
	
		<!-- page_title(S) -->
		<h2 class="page_title"><span>Office Transfer</span></h2>
		<!-- page_title(E) -->
		<!-- opus_design_btn (S) -->
		<div class="opus_design_btn"><!-- 
			 --><button class="btn_accent" name="btn_Save" id="btn_Save" type="button">Save</button><!--
			--><button class="btn_normal" name="btn_Close" id="btn_Close" type="button">Close</button><!--
			--></div>
		<!-- opus_design_btn (E) -->
	</div>

	<!-- page_title_area(E) -->
	<div class="wrap_search">
		<!-- opus_design_inquiry(S) -->
		<div class="opus_design_inquiry wFit">
			<table> 
				<colgroup>
					<col width="30"/>
					<col width="80"/>
					<col width="90"/>
					<col width="*" />				
			   	</colgroup> 
			   	<tbody>
				<tr>
					<th>Current</th>
					<td><input type="text" name="fm_ofc_cd" value="<%=fmOfcCd%>" style="width:55px;" class="input2" readonly id="fm_ofc_cd" /> </td>
					<th>Should Read</th>
					<td class="stm"><label>RHQ</label><select name="shd_rhq_cd" id="shd_rhq_cd"style=" width:75px;"></select><label>Office Code</label><script type="text/javascript">ComComboObject('cb_to_ofc_cd', 1, 70, 0, 1, 0, true);</script></td>
				</tr>
				</tbody>
			</table>
			<table> 
				<colgroup>
					<col width="30"/>
					<col width="*" />				
			   	</colgroup> 
			   	<tbody>
				<tr>
					<th>Reason</th>
					<td><input type="text" name="trns_rsn" dataformat="exceptengdn" maxlength="500" caption="Reason" style="width:438px;" class="input1" value="" id="trns_rsn" /> </td>
				</tr>
				</tbody>
			</table> 
		</div>
	</div>				
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>		
		</div>
		<!-- opus_design_grid(E) -->
	</div>	
</form>