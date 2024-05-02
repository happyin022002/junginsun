<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : ESM_BKG_0184.jsp
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
<%@ page import="com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0184Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0184Event  event = null;				//PDTO(Data Transfer Object including Parameters)
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
		event = (EsmBkg0184Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		// get data from server when load page ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	}catch(Exception e) {
		out.println(e.toString());
	}
%>

<%
	String msgTpCd     = (request.getParameter("msg_tp_cd") == null)? "":request.getParameter("msg_tp_cd");
	String rcvSndDivCd = (request.getParameter("rcv_snd_div_cd")== null)?"":request.getParameter("rcv_snd_div_cd");
	String refSeq      = (request.getParameter("ref_seq")== null)?"":request.getParameter("ref_seq");
	String anrDeclNo   = (request.getParameter("anr_decl_no")== null)?"":request.getParameter("anr_decl_no");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
	String cusrep   = (request.getParameter("cusrep")== null)?"":request.getParameter("cusrep");
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

<form name="form" id="form" method="post">
<input type="hidden" name="f_cmd" id="f_cmd">
<input type="hidden" name="pagerows" id="pagerows">
<input type="hidden" name="frm_attr_ctnt2" id="frm_attr_ctnt2">
<input type="hidden" name="msg_tp_cd" id="msg_tp_cd" value="<%=msgTpCd%>">
<input type="hidden" name="rcv_snd_div_cd"  id="rcv_snd_div_cd"  value="<%=rcvSndDivCd%>">
<input type="hidden" name="anr_decl_no" id="anr_decl_no"  value="<%=anrDeclNo%>">
<input type="hidden" name="ref_seq" id="ref_seq" value="<%=refSeq%>">

<!-- page_title_area(S) -->
<div class="page_title_area clear">
	<!-- page_title(S) -->
	<!-- 타이틀 내용 동적생성 (별도 코딩 불필요) -->
	<h2 class="page_title">
		<button type="button"><span>
			<% if ( "R".equals( rcvSndDivCd )  ){ %>
			
			<% if( "y".equals( popup ) ){ %>
				<% if( "y".equals( cusrep ) ){ %>
					&nbsp;CUSREP History By BL_View Received File
				<% }else{ %>
					&nbsp;CUSREP History By BL_View Received File
				<%} %>
			<% }else{ %>
				<% if( "y".equals( cusrep ) ){ %>
					<span id="title">&nbsp; CUSREP History By BL_View Received File</span>
				<% }else{ %>
					<span id="title">&nbsp; CUSCAR History By BL_View Received File</span>
				<%} %>
			<%} %>
			<% } else{ %>
				<% if( "y".equals( popup ) ){ %>
					<% if( "y".equals( cusrep ) ){ %>
						&nbsp;CUSREP History By BL_View Send File
					<% }else{ %>
						&nbsp;CUSCAR History By BL_View Send File
					<%} %>
				<% }else{ %>
					<% if( "y".equals( cusrep ) ){ %>
						<span id="title">&nbsp; CUSREP History By BL_View Send File</span>
					<% }else{ %>
						<span id="title">&nbsp; CUSCAR History By BL_View Send File</span>
					<%} %>
					
				<%} %>
			<%} %>
		</span></button>
	</h2>

	<!-- page_title(E) -->
	<!-- opus_design_btn(S) -->
	<div class="opus_design_btn">
		<button type="button" class="btn_accent" name="btn_DownExcel" id="btn_DownExcel">Down Excel</button><!--
		 --><button type="button" class="btn_normal" name="btn_close" id="btn_close">Close</button>
	</div>
	<!-- opus_design_btn(E) -->
	<!-- page_location(S) -->
	<div class="location">
		<span id="navigation"></span>
	</div>
	<!-- page_location(E) -->	
</div>
<!-- page_title_area(E) -->

<div class="wrap_result">
<!-- opus_design_grid(S) -->
	<div class="opus_design_grid">
			<script type="text/javascript">ComSheetObject('sheet1');</script>
	</div>

</div>	
<!-- opus_design_grid(E) -->	
</form>