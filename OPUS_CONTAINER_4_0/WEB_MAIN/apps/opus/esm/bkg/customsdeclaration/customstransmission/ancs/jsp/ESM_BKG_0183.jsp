<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0183.jsp
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0183Event"%>
<%@ page import="org.apache.log4j.Logger" %>


<%
	EsmBkg0183Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";
	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.CustomsDeclaration.ManifestListDownload");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		event = (EsmBkg0183Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>


<%
	String blno     = (request.getParameter("bl_no") == null)? "":request.getParameter("bl_no");
	String vvd   = (request.getParameter("vvd") == null)? "":request.getParameter("vvd");
	String ssrNo = (request.getParameter("ssr_no")== null)?"":request.getParameter("ssr_no");
	String pod   = (request.getParameter("pod")== null)?"":request.getParameter("pod");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
%>


<script type="text/javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		
        $('<button type="button" class="btn_accent" name="btn_retrieve"		id="btn_retrieve">Retrieve</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_new"  		id="btn_new">New</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_sendfile" 	id="btn_sendfile">View Send File</button>').appendTo("#btnArea");
        $('<button type="button" class="btn_normal" name="btn_receivefile"	id="btn_receivefile">View Receive File</button>').appendTo("#btnArea");
        
        $('#btn_receivefile').after($('#btn_Close'));
        
		
		loadPage();
	}
</script>


<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2">
<input type="hidden" name="popup" id="popup" value="<%=popup %>">
<%@include file="../../../../bookingcommon/bookingutil/jsp/ESM_BKG_POPUP_TOP.jsp"%>

<%if(!mainPage.equals("true")){%><div class="layer_popup_contents"><%}%>
<div class="wrap_search">
	<div class="opus_design_inquiry">		
		<table>
			<colgroup>
					<col width="50"/>
					<col width="150"/>
					<col width="70"/>
					<col width="160"/>
					<col width="50"/>
					<col width="10"/>
					<col width="110"/>
					<col width="*" />				
			</colgroup> 
			<tbody>			
			<tr>
				<th>BL No.</th>
				<td><input type="text" style="width:120px; ime-mode:disabled" class="input1" name="bl_no" maxlength="12" dataformat="engup" value="<%=blno %>"></td>
				<th>CNTR No.</th>
				<td><input type="text" style="width:120px; ime-mode:disabled" value=" " class="input" name="cntr_no" maxlength="14" dataformat="engup"></td>
				<th class="sm">Target</th>
				<td class="sm"></td>
				<td class="sm">
					<input type="checkbox" value="" checked="checked" name="target_bl" id="target_bl"><label for="target_bl_bl">BL</label><!--
				 --><input type="checkbox" value="" checked="checked" name="target_cntr" id="target_cntr"><label for="target_bl_cntr">CNTR</label>
				</td>
				<td></td>
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
<%if(!mainPage.equals("true")){	%></div><%}%>
</form>
