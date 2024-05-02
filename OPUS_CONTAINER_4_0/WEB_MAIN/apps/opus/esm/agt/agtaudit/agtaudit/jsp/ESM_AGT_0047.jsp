<%--
/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_AGT_0047.jsp
*@FileTitle : VVD Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.rowset.DBRowSet"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.esm.agt.common.Utils" %>
<%@ page import="com.clt.apps.opus.esm.agt.common.ComboUtil" %>
<%@ page import="com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0047Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%
EsmAgt0047Event  event = null;					//PDTO(Data Transfer Object including Parameters)
Exception serverException   = null;			//error from server
String strErrMsg = "";						//error message
int rowCount	 = 0;						//count of DB resultSET list

String successFlag = "";
String codeList  = "";
String pageRows  = "100";

String strUsr_id		= "";
String strUsr_nm		= "";

String aproNo = "";
Logger log = Logger.getLogger("com.clt.apps.AGTAudit.AGTAudit");
String vvd = JSPUtil.getNull(request.getParameter("vvd_cd"));
String port = JSPUtil.getNull(request.getParameter("port_cd"));
String locl_curr_cd = JSPUtil.getNull(request.getParameter("locl_curr_cd"));
String chg_curr_cd = JSPUtil.getNull(request.getParameter("chg_curr_cd"));
String scope = JSPUtil.getNull(request.getParameter("svc_scp_cd"));
String bound = JSPUtil.getNull(request.getParameter("io_bnd_cd"));

try {
   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	strUsr_id =	account.getUsr_id();
	strUsr_nm = account.getUsr_nm();
	
	event = (EsmAgt0047Event)request.getAttribute("Event");
	serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);


	if (serverException != null) {
		strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
	}

	// adding logic to get data from server when first loading ..
	GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

}catch(Exception e) {
	out.println(e.toString());
}

%>
<html>
<head>
<title>VVD Exchange Rate Inquiry</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">


<input type="hidden" name="iPage"> 


<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

	<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td class="bodyright">

			<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (START) ####### -->
			
			<!--Page Title, Historical (S)-->
			<table width="100%" class="title"> 
			<tr><td class="history"></td></tr>
			<tr><td class="title"><img src="/opuscntr/img/opus/ico_t1.gif" width="20" height="12">VVD Exchange Rate Inquiry</td></tr>
			</table>
			<!--Page Title, Historical (E)--> 

			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"> 
			<tr><td class="bg">
					
					<table class="search" border="0" style="width:735;">
					<tr class="h23">
						<td width="4%">VVD</td>
						<td width="12%">&nbsp;<input type="text" name="vvd_cd" style="width:70" maxlength="9" onKeyUp="javascript:upper(this);"></td>
						<td width="4%">Port</td>
						<td width="10%">&nbsp;<input type="text" name="port_cd" style="width:50" maxlength="5" onKeyUp="javascript:upper(this);"></td>
						<td width="10%">Charge Cur</td>
						<td width="13%">
							<%= com.clt.bizcommon.util.BizComUtil.getCodeCombo("chg_curr_cd", "", "", "CURR", 2, "0: :ALL") %>
						</td>
						<td width="10%">Local Cur</td>
						<td width="13%">
							<%= com.clt.bizcommon.util.BizComUtil.getCodeCombo("locl_curr_cd", "", "", "CURR", 2, "0: :ALL") %>
						</td>
						<td width="5%">Scope</td>
						<td width="8%"><input type="text" name="svc_scp_cd" style="width:30" maxlength="3" onKeyUp="javascript:upper(this);"></td>
						<td width="5%">Bound</td>
						<td width="20%"><select name="io_bnd_cd" style="width:70;">
								<option value="" selected>All</option>
								<option value="O" selected>O/B</option>
								<option value="I" selected>I/B</option>
								</select></td>
					</tr>
					</table>
									
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			<!-- TABLE '#D' : ( Search Options ) (S) -->
			<table class="search"> 
				<tr><td class="bg">
					<!-- : ( POR ) (S) -->
					<table width="100%" id="mainTable">
						<tr><td>
							<script language="javascript">ComSheetObject('sheet');</script>
						</td></tr>
					</table>
					<!-- : ( POR ) (E) -->
					
				</td></tr>
			</table>
			<!-- TABLE '#D' : ( Search Options ) (E) --> 	

		</td></tr>
	</table>

</td></tr>


</table>

<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton"> 
   <tr><td height="71" class="popup">
           <table border="0" cellpadding="0" cellspacing="0">
                <tr>
              <td>                      
                 <!--  Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn1_left"></td>
							   <td class="btn1" name="btn_Retrieve">Retrieve</td>
							   <td class="btn1_right"></td>
							  </tr>
                       </table>
                 <!--  Row Add   Button (E) -->
              </td>
              <td>                      
                 <!-- Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn1_left"></td>
							   <td class="btn1" name="btn_New">New</td>
							   <td class="btn1_right"></td>
							  </tr>
                       </table>
                 <!-- Row Add   Button (E) -->
              </td>
              <td>                      
                 <!-- Row Add   Button (S) -->
                       <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                               <tr><td class="btn1_left"></td>
							   <td class="btn1" name="btn_Close">Close</td>
							   <td class="btn1_right"></td>
							  </tr>
                       </table>
                 <!--  Row Add   Button (E) -->
              </td></tr>
           </table>
    </td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->
<!-- OUTER FRAME : "to make sum of components' HEIGHTS 100%" (E)nd -->


</form>
</body>
</html>
<SCRIPT LANGUAGE="javascript">
<!--
	  
	  with(document.form)
	  {
		<%
		if(event != null){ 
		%>
		eval("vvd_cd" ).value = "<%= vvd	 %>";
		eval("port_cd" ).value = "<%= port	 %>";
		eval("chg_curr_cd" ).value = "<%= chg_curr_cd	 %>";
		eval("locl_curr_cd" ).value = "<%= locl_curr_cd	 %>";
		eval("svc_scp_cd" ).value = "<%= scope	 %>";
		eval("io_bnd_cd" ).value = "<%= bound	 %>";

		<% } %>
	   }
-->
</SCRIPT>