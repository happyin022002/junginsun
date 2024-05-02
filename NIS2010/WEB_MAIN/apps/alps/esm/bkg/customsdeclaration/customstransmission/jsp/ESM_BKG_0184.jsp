<%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ui_bkg_0184.jsp
*@FileTitle : ACI_Vessel Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정재엽
*@LastVersion : 1.0
* 2009.04.24 정재엽
* 1.0 Creation
=========================================================*/%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkg0184Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0184Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.CustomsDeclaration.ManifestListDownload");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (EsmBkg0184Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		// 초기화면 로딩시 서버로부터 가져온 데이터 추출하는 로직추가 ..
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
		

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>

<%
	String msgTpCd     = (request.getParameter("msg_tp_cd") == null)? "":request.getParameter("msg_tp_cd");
	String rcvSndDivCd = (request.getParameter("rcv_snd_div_cd")== null)?"":request.getParameter("rcv_snd_div_cd");
	String refSeq      = (request.getParameter("ref_seq")== null)?"":request.getParameter("ref_seq");
	String anrDeclNo   = (request.getParameter("anr_decl_no")== null)?"":request.getParameter("anr_decl_no");
	String popup   = (request.getParameter("popup")== null)?"":request.getParameter("popup");
	String cusrep   = (request.getParameter("cusrep")== null)?"":request.getParameter("cusrep");
%>

<% if ( "R".equals( rcvSndDivCd )  ){ %>
	<% if( "y".equals( cusrep ) ){ %>
		<title>&nbsp;CUSREP History By BL_View Received File</title>
	<% }else{ %>
		<title>&nbsp;CUSREP History By BL_View Received File</title>
	<%} %>
<% }else{ %>
	<% if( "y".equals( cusrep ) ){ %>
		<title>&nbsp;CUSREP History By BL_View Send File</title>
	<% }else{ %>
		<title>&nbsp;CUSCAR History By BL_View Send File</title>
	<%} %>
<%} %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		} // end if
		loadPage();
	}
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form" method="post">

<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="frm_attr_ctnt2">
<input type="hidden" name="msg_tp_cd"       value="<%=msgTpCd%>">
<input type="hidden" name="rcv_snd_div_cd"  value="<%=rcvSndDivCd%>">
<input type="hidden" name="anr_decl_no"     value="<%=anrDeclNo%>">
<input type="hidden" name="ref_seq"         value="<%=refSeq%>">

<!-- 개발자 작업	-->

<table width="100%" class="popup" border="0" cellpadding="10" cellspacing="0">
	<tr><td class="top"></td>
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">
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
			<% }else{ %>
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
			</td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
	
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
				<tr>
					<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
					</td>
				</tr>
				</table>			
				<!-- Grid (E) -->		
			
			
			</td></tr>
		</table>
		<!--biz page (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
	

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>