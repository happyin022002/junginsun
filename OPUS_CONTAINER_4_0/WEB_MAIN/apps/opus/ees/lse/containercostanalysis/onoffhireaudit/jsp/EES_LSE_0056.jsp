<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ees_lse_0056.jsp
*@FileTitle : Invoice File import
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.component.util.JSPUtil"%>
<%@ page import="com.clt.framework.component.util.DateTime"%>
<%@ page import="com.clt.framework.component.message.ErrorHandler"%>
<%@ page import="com.clt.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.apps.opus.ees.lse.containercostanalysis.onoffhireaudit.event.EesLse0056Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	EesLse0056Event  event = null;				//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//error from server
	String strErrMsg = "";						//error message
	int rowCount	 = 0;						//count of DB resultSET list

	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	Logger log = Logger.getLogger("com.clt.apps.ContainerCostAnalysis.IOnOffHireAudit");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();


		event = (EesLse0056Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		//getting data from server when load the initial screen
		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>
<title>Invoice File import</title>
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
<!-- OUTER - POPUP (S)tart -->
<input type="hidden" name="ref_no">
<input type="hidden" name="contract_no">
<input type="hidden" name="vndr_seq">
<table width="800" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Invoice File Import
        </td></tr>
		</table>
		<!-- : ( Title ) (E) -->		
		<!-- : ( Search Options ) (S) -->
        <table class="search"> 
       		<tr><td class="bg">
						<!-- : ( Grid ) (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>						
				<!-- : ( Grid ) (E) -->	
				<div style="display:none;">
					<table width="100%"  id="mainTable" border="0" cellpadding="0" cellspacing="0"> 
						<tr>
							<td width="100%">
							<!--?트-->
								<script language="javascript">ComSheetObject('sheet2');</script>
							</td>
						</tr>
					</table>
					</div>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
 <!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
						<td>
						  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_verify">Verify</td>
						      <td class="btn2_right"></td>
						    </tr>
						  </table>
						</td>
						<!-- <td>
						  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_LoadFile">Load File</td>
						      <td class="btn2_right"></td>
						    </tr>
						   </table>   
						</td>-->
						<td>
						  <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						    <tr>
						      <td class="btn2_left"></td>
						      <td class="btn2" name="btn_LoadExcel">Load Excel</td>
						      <td class="btn2_right"></td>
						    </tr>
						  </table>
						</td>
						
				</table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
</td></tr>
</table> 

<table class="height_5"><tr><td></td></tr></table>
	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
    <tr>
        <td height="71" class="popup">	
		    <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	        <tr>
       	            <td class="btn3_bg">
		                <table border="0" cellpadding="0" cellspacing="0">
		                    <tr>
		                        <td width="">
		                             <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                     <tr>
					                         <td class="btn1_left"></td>
					                         <td class="btn1" name="btn_New">New</td>
					                         <td class="btn1_right"></td>
			                             </tr>
			                         </table>
			                    </td>
				                <td width="">
				                     <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                     <tr>
					                         <td class="btn1_left"></td>
					                         <td class="btn1" name="btn_Save">Ok</td>
					                         <td class="btn1_right"></td>
			                             </tr>
			                         </table>
			                    </td>			
				                <td width="">
				                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					                    <tr>
					                        <td class="btn1_left"></td>
					                        <td class="btn1" name="btn_Close">Close</td>
					                        <td class="btn1_right"></td>
			                            </tr> 			
			                        </table>
			                    </td>
		                    </tr>
		                </table>
                        <!--Button (E) -->
	                </td>
	            </tr>
	        </table>
	    </td>
	 </tr>
</table>	 
<!-- : ( Button : pop ) (E) -->
</form>
</body>
</html>