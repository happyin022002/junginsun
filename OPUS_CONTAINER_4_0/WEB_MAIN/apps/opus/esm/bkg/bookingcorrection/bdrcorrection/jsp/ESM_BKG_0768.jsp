<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0768.jsp
*@FileTitle : C/A Reason
*Open Issues : ESM_BKG_0768
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0768Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EsmBkg0768Event  event           = null;	//PDTO(Data Transfer Object including Parameters)
	Exception        serverException = null;	//error from server
	String strErrMsg = "";						//error message

	Logger log = Logger.getLogger("com.clt.apps.BookingCorrection.BdrCorrection");
	
	try {	
		event = (EsmBkg0768Event)request.getAttribute("Event");		
		GeneralEventResponse eventResponse = (GeneralEventResponse)request.getAttribute("EventResponse");

		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		if (serverException != null) {
	        strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>C/A Reason</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			showErrMessage(errMessage);
		}
		loadPage();
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="bkg_no" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="300" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; C/A Reason</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
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

</td></tr></table>

<table class="height_5"><tr><td></td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_select">Select</td>
					<td class="btn1_right"></td>
				</tr></table></td>				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>		
			</tr>
		</table></td>		
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->


</form>
</body>
</html>

<SCRIPT LANGUAGE="javascript">
<!--
      with(document.form)
      {
        <%
        if(event != null){ 
            String bkgNo = event.getBkgBlNoVO().getBkgNo();
        %>
            eval("bkg_no").value = "<%=bkgNo%>"; 
        <% } %>
     }
-->
</SCRIPT>
<%@include file="/bizcommon/include/common_opus.jsp"%>
