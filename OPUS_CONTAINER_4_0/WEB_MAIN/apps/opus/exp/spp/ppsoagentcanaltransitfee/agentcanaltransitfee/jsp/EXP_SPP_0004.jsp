<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EXP_SPP_0004.jsp
*@FileTitle : Requested MSA
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee.event.ExpSpp0004Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	ExpSpp0004Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//Error from server
	String strErrMsg = "";						//Error message
	int rowCount	 = 0;						//The count of DB ResultSet list

	String successFlag 	= "";
	String codeList  	= "";
	String pageRows  	= "100";

	String strUsr_id	= "";
	String strUsr_nm	= "";
	
	String vndrSeq 		= "";
	String revYrmon 	= "";
	
	Logger log = Logger.getLogger("com.clt.apps.opus.exp.spp.ppsoagentcanaltransitfee.agentcanaltransitfee");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();

		event = (ExpSpp0004Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");		

		vndrSeq 	= (String) request.getParameter("vndrSeq");  //"2132";  //
		revYrmon 	= (String) request.getParameter("revYrmon");  //"200905";  //

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>MSA Request</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script language="javascript">
	//ComDebug("<%=vndrSeq+"/"+revYrmon%>");
		
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
<form name="form" >
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows" value="<%=pageRows%>">
<!-- getting the value from the opener -->
<input type="hidden" name="vndr_seq" value="<%=vndrSeq%>" />
<!-- Saving value after retrieving MSA Status. -->
<input type="hidden" name="pso_msa_sts_cd" />

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;MSA Request</td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">
       	
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="100">Working Month</td>
					<td><input name="rev_yrmon" type="text" dataformat="ym" maxlength="6" style="ime-mode:disabled;width:80;text-align:center;" class="input2" value="<%=revYrmon%>" readonly>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				
		</td>
		</tr>
		</table>
		<table class="height_8"><tr><td></td></tr></table>
				
	<!-- Tab ) (S) -->
   		<table class="tab" border="0" cellpadding="0" cellspacing="0" width=100%> 
     		<tr><td width="100%">
				<script language="javascript">ComTabObject('tab1')</script>
			</td></tr>
		</table>
	<!-- Tab ) (E) --> 
		


	<!--TAB (A) (S) -->
		<div id="tabLayer" style="display:inline">
				
			<!--biz page (S)-->			
			<table class="search"> 
		       	<tr><td class="bg">
	
					<!--  biz_2  (S) -->
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>				
					<!-- Grid (E) -->
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
					</table>
		    		<!-- Button_Sub (E) -->				
					<!--  biz_2   (E) -->
	
				</td></tr>
			</table>
			<!--biz page (E)-->
			
		</div>
	<!--TAB (A) (E) --> 



	<!--TAB (B) (S) -->
		<div id="tabLayer" style="display:none">
		
			<!--biz page (S)-->	
			<table class="search"> 
		       	<tr><td class="bg">	
						
					<!--  biz_2 (S) -->
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>				
					<!-- Grid (E) -->
					
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel2">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
					</table>
		    		<!-- Button_Sub (E) -->						
					<!--  biz_2 (E) -->
						
				</td></tr>
			</table>
			<!--biz page (E)-->
		
		</div>
	<!--TAB (B) (E) -->  



	<!--TAB (C) (S) -->
		<div id="tabLayer" style="display:none">
		
			<!--biz page (S)-->	
			<table class="search"> 
		       	<tr><td class="bg">	
						
					<!--  biz_2  (S) -->
					<!-- Grid  (S) -->
					<table width="100%"  id="mainTable"> 
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>				
					<!-- Grid  (E) -->
						
					<!--  Button_Sub (S) -->
					<table width="100%" class="button"> 
		       			<tr><td class="btn2_bg">
						<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_DownExcel3">Down Excel</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
						</tr></table>
						</td></tr>
					</table>
		    		<!-- Button_Sub (E) -->							
						<!--  biz_2  (E) -->
						
				</td></tr>
			</table>
			<!--biz page (E)-->
		
		</div>
	<!--TAB (C) (E) --> 



	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Request" id="btn_Request">Request</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save" id="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
    
	</td></tr>
</table>

</form>
</body>
</html>