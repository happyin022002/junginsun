<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0186.jsp
*@FileTitle  : Customer Code Entry 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/05/09
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event.EsmBkg0186Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0186Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//occurring error in server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//list count of DB resultSet 
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
// 	String mainPage 		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
// 	   	mainPage = request.getParameter("mainPage");
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0186Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		//When initial screen loading, adding logic extrat data obtained from the server.
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
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
		
		$('<button type="button" class="btn_accent" name="btn_retrieve"		id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>').appendTo("#btnArea");		
        $('<button type="button" class="btn_normal" name="btn_sendfile"  		id="btn_sendfile">View Send File</button>').appendTo("#btnArea");		
        $('<button type="button" class="btn_normal" name="btn_receivefile"  		id="btn_receivefile">View Receive File</button>').appendTo("#btnArea");		
		loadPage();
		
        $('#btn_view').after($('#btn_Close'));
        
	}
</script>


<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2">

<%
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
%>

<%-- <input type="hidden" name="popup" id="popup" value="popup "> --%>


<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>
<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>

<div class="wrap_search">
<!-- opus_design_inquiry(S) -->
<div class="opus_design_inquiry">
	<table>
		<colgroup>
			<col width="30"/>
			<col width="380"/>
			<col width="50"/>
			<col width="100"/>
			<col width="50"/>
			<col width="*"/>
		</colgroup>
		<tbody>
			<tr>
				<th title="Vessel Voyage Direction">VVD</th>
				<td>
					<input type="text" style="width:100px; ime-mode:disabled" class="input1" name="vvd" maxlength="9" dataformat="engup" value="<%=vvd %>"><!--
					--><input type="text" style="width:250px;" class="input" name="vvd_nm" maxlength="500" dataformat="engupetc" readonly>
				</td>
				<th>SSR No.</th>
				<td>
					<input type="text" style="width:80px;ime-mode:disabled"  class="input1" name="svc_rqst_no" maxlength="6" dataformat="engup" value="<%=ssrNo %>">
				</td>
				<th>Accept</th>
				<td>
					<img src="img/btng_icon_b.gif" width="13" height="13" alt="" border="0" name="anr_msg_sts_cd">
				</td>
				<td></td>
			</tr>
		</tbody>
	</table>
</div>
<!-- opus_design_inquiry(E) -->
</div>
<div class="wrap_result">
<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet1');</script>
</div>
<!-- opus_design_grid(E) -->

<!-- opus_design_grid(S) -->
<div class="opus_design_grid">
	<script type="text/javascript">ComSheetObject('sheet2');</script>
</div>
<!-- opus_design_grid(E) -->
</div>
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>