<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0892.jsp
*@FileTitle  : Container No Inquiry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/06/30
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
<%@ page import="com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0892Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
    EsmBkg0892Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//DB ResultSet List count

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.outboundblmgt.bldocumentation");


	String bkgVvd    = "";
	String bkgOfcCd  = "";
	String bkgPol    = "";
	String bkgPod    = "";
	String cfmFlg    = "";

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EsmBkg0892Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");


		bkgVvd    = event.getBkgVvd();
		bkgOfcCd  = event.getBkgOfcCd();
		bkgPol    = event.getBkgPol();
		bkgPod    = event.getBkgPod();
		cfmFlg    = event.getCfmFlg();

	}catch(Exception e) {
		out.println(e.toString());
	}

%>
<html>
<head>
<title>Container No Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
		//
		callback_func = '<%=JSPUtil.getParameter(request, "func", "")%>';
	}
</script>
</head>

<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">

<div class="layer_popup_title">
	<div class="page_title_area clear">
		<h2 class="page_title"><span>C/M Container No Inquiry</span></h2>
		
		<div class="opus_design_btn">
			<button type="button" class="btn_accent" name="btn_Retrieve" id="btn_Retrieve">Retrieve</button><!--
			 --><button type="button" class="btn_normal" name="btn_Select" id="btn_Select">Select</button><!--
			 --><button type="button" class="btn_normal" name="btn_Close" id="btn_Close">Close</button>
		</div>
	</div>
</div>

<div class="layer_popup_contents">
	<div class="wrap_search">
		<div class="opus_design_inquiry">
			<table>
				<tbody>
					<tr>
						<th>T/VVD</th>
						<td><input type="text" name="bkg_vvd" style="ime-mode:disabled;width:80;" dataformat="engupnum" class="input1" value="<%=bkgVvd%>"></td>
						<th>BKG Office</th>
						<td><input type="text" name="bkg_ofc_cd" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input1" value="<%=bkgOfcCd%>"></td>
					</tr>
					<tr>
						<th width="40">POL</th>
						<td width="80"><input type="text" name="bkg_pol" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input1" value="<%=bkgPol%>"></td>
						<th width="40">POD</th>
						<td width="80"><input type="text" name="bkg_pod" style="ime-mode:disabled;width:50;" dataformat="engupnum" class="input" value="<%=bkgPod%>"></td>
						<th width="40">C/M</th>
						<td><%=JSPUtil.getCodeCombo("cfm_flg", "", "", "CD00912", 0, "")%></td>
					</tr>
				</tbody>
			</table> 
		</div>
	</div>
	
	<div class="wrap_result">
		<!-- opus_design_grid(S) -->
		<div class="opus_design_grid" >
			<script language="javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>
</div>
</form>