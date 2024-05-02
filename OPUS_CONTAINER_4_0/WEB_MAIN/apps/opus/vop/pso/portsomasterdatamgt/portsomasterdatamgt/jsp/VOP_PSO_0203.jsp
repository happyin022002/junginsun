<%
/*=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName 	 : vop_pso_0203.jsp
*@FileTitle  : Bank Information 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/08/28
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.vop.pso.portsomasterdatamgt.portsomasterdatamgt.event.VopPso0203Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	VopPso0203Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strBankInfo 		= "";
	Logger log = Logger.getLogger("com.clt.apps.PortSOMasterDataMgt.PortSOMasterDataMgt");
	
	//String strVndrSeq = request.getParameter("vndrSeq"); //Sequence Number of Vendor
	//if(strVndrSeq == null ) strVndrSeq = "181162"; //TEST CODE BY KJI 
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
	   
		event = (VopPso0203Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
	strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
		
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		
		strBankInfo = (String)eventResponse.getCustomData("BANKINFO");
		
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		tblData = "<%=strBankInfo%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- OUTER - POPUP (S)tart -->
<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>Bank Information</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>


<div class="layer_popup_contents" style="overflow:hidden;">
	<div class="wrap_result">
		<div class="layout_wrap">
			<table class="grid2"> 
				<tbody>
						<tr class="tr2_head">
							<th colspan="2" align="left"><b>AGENT BANK ACCOUNT DETAILS AS UNDER</b></th>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%">To</th>
							<td  class="" width=""><div id="dbData1"><!-- Commercial International Bank - Port Said Branch  --></div> </td>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%"> Favour</th>
							<td  class="" width=""><div id="dbData2"><!-- Dominion Shipping Agencies [Egypt] - Port Said  --></div></td>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%">  Account Number</th>
							<td  class="" width=""><div id="dbData3"><!--  0250308483   --></div></td>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%">   Through 	</th>
							<td  class="" width=""><div id="dbData4"><!-- Bank of New York - New York  --></div></td>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%">    Account Number 	</th>
							<td  class="" width=""><div id="dbData5"><!-- 8900045051   --></div></td>
						</tr>
						<tr>
							<th  class="tr2_head2" width="30%"> Swift Code</th>
							<td  class="" width=""><div id="dbData6"><!--  CIBEEGCX002    --></div></td>
						</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>

</form>

