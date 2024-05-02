<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1139.jsp
*@FileTitle : TRO notice pop
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.28
*@LastModifier : 금병주
*@LastVersion : 1.0
* 2009.11.28 금병주
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg1139Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.core.controller.DefaultViewAdapter"%>

<%

EsmBkg1139Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//서버에서 발생한 에러
String strErrMsg = "";						//에러메세지

String bkgNo   = "";	
String ioBndCd = ""; 
String sXml	   = "";	
Logger log = Logger.getLogger("com.hanjin.apps.GeneralBookingConduct.TransferOrderIssue");

try {
    event = (EsmBkg1139Event)request.getAttribute("Event");
    serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}
	
	if (event != null) {
	    bkgNo   = event.getBkgNo(); 
	    ioBndCd = event.getIoBndCd();
	}	
	
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");
	
	DefaultViewAdapter adapter = new DefaultViewAdapter();
	sXml = adapter.makeXML(request, response);		
	
}catch(Exception e) {
	out.println(e.toString());
}

%>
<html>
<head>
<title>Send TRO Notice</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage();
	} 
</script>
</head> 		

<body CLASS="POPUP_BG" onLoad="setupPage()">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="sXml"      value="<%=sXml.replaceAll("\"", "\'")%>">
<input type="hidden" name="bkg_no"    value="<%=bkgNo%>">
<input type="hidden" name="io_bnd_cd" value="<%=ioBndCd%>">
<!-- 개발자 작업	-->

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
	<!-- : ( Title ) (S) -->
	<table width="100%" border="0">
	<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Send TRO Notice</td></tr>
	</table>
	<!-- : ( Title ) (E) -->
	<!-- : ( Search Options ) (S) -->
	
	<table class="search"><tr><td class="bg">
		<table class="search" border="0">
			<tr><td class="title_h"></td>
				<td class="title_s">C/H Notice Attachment</td></tr>
			<tr><td class="height_5"></td></tr>
		</table>
<%if(ioBndCd.equals("O")){%>
		<input type="hidden" value="R" class="trans" name="cmdt" checked>
		<input type="hidden" value="C" class="trans" name="cmdt">
		<input type="hidden" value="C" class="trans" name="receiver" checked>
		<input type="hidden" value="N" class="trans" name="receiver">
		<input type="hidden" value="O" class="trans" name="receiver">
		<input type="hidden" style="width:200;" class="input" name="other">
		<input type="hidden" style="width:300;" class="input" name="cust_ntc">
		
		<!-- : ( Grid ) (S) -->
			<table width="100%" id="cntrTable" style="display:none">
                <tr><td>
                     <script language="javascript">ComSheetObject('sheet2');</script>
                </td></tr>
            </table>
			<!-- : ( Grid ) (E) -->
<%} else { %>		
		<table class="search">
		<tr><td width="400">
			<table class="search">
				<tr class="h23">
					<td width="200">Commodity Information</td>
				</tr>
				<tr>
					<td width="">
					<input type="radio" value="R" class="trans" name="cmdt" checked>Rep Commodity&nbsp;&nbsp;
					<input type="radio" value="C" class="trans" name="cmdt">Commodity
					</td>
				</tr>
			</table>
			<table class="search">
				<tr class="h23">
					<td width="200">Receiver's Information</td>
				</tr>
			</table>
			<table class="search" border="0">
				<tr><td width="100"><input type="radio" value="C" class="trans" name="receiver" checked>Consignee</td></tr>
				<tr><td width="100"><input type="radio" value="N" class="trans" name="receiver">Notify</td></tr>
				<tr>
					<td width="100"><input type="radio" value="O" class="trans" name="receiver">Other</td>
					<td><input type="text" style="width:200;" class="input" name="other"></td>
				</tr>
			</table>
			<table class="search">
				<tr class="h23">
					<td width="250">Customer Notice:</td>
				</tr>
				<tr>
					<td><input type="text" style="width:300;" class="input" name="cust_ntc" maxlength="100"></td>
				</tr>
			</table>
		</td>
		<td width="200">
			<!-- : ( Grid ) (S) -->
			<table width="100%" id="cntrTable">
				
                <tr><td width="200">
                     <script language="javascript">ComSheetObject('sheet2');</script>
                </td></tr>
            </table>
			<!-- : ( Grid ) (E) -->
		</td></tr>
		</table>
<%} %>		
		<!-- Grid  (S) -->
		<table class="" border="0" width="100%" id="mainTable">		
			<tr class="h23">
				<td>Send Fax/Email</td>
			</tr>
			<tr>
				<td width="100%">
					<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
		</table>
		<!-- Grid (E) -->
	</td></tr></table>
	<!-- : ( Search Options ) (E) -->
</td></tr></table> 
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0" align="center">
		    <tr>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_send">Send</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td width="71"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr></table></td>
		</tr></table>
			
    <!--Button (E) -->
	
</td></tr></table>

<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->

</form>
</body>
</html>
