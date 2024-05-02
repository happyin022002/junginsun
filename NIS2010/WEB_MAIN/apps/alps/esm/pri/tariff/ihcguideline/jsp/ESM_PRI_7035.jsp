<%
/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_PRI_7035.jsp
*@FileTitle : Rail Hub – Port pair deletion 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.28
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 1.0 Creation
=========================================================
* History                                                                            
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.event.EsmPri7035Event"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="java.util.List"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.common.PRIUtil"%>
<%@ page import="com.hanjin.framework.component.util.code.CodeInfo"%>
<%@ page import="com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO"%>
<%
	EsmPri7035Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			
	String strErrMsg = "";						
	int rowCount	 = 0;						
	
	String successFlag = "";
	String codeList  = "";
	String pageRows  = "100";

	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_ofc		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.alps.esm.pri.tariff");
	String[] termCd = null;
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_ofc = account.getOfc_cd();
	    
		event = (EsmPri7035Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}

		GeneralEventResponse eventResponse = (GeneralEventResponse) request.getAttribute("EventResponse");	

	}catch(Exception e) {
		out.println(e.toString());
	}
%>
<html>
<head>   
<title>Rail Hub – Port pair deletion</title>
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

<body  onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">  			
<input type="hidden" name="pagerows">
<input type="hidden" name="svc_scp_cd" value="<%= JSPUtil.getParameter(request, "svc_scp_cd") %>">
<input type="hidden" name="org_dest_tp_cd" value="<%= JSPUtil.getParameter(request, "org_dest_tp_cd") %>">
<input type="hidden" name="ihc_trf_no" value="<%= JSPUtil.getParameter(request, "ihc_trf_no") %>">
<input type="hidden" name="amdt_seq" value="<%= JSPUtil.getParameter(request, "amdt_seq") %>">
<input type="hidden" name="ihc_cgo_tp_cd" value="<%= JSPUtil.getParameter(request, "ihc_cgo_tp_cd") %>">
<input type="hidden" name="cost_cnt_cd" value="<%= JSPUtil.getParameter(request, "cost_cnt_cd") %>">  
<input type="hidden" name="fic_prop_sts_cd" value="<%= JSPUtil.getParameter(request, "fic_prop_sts_cd") %>">  
<input type="hidden" name="rcv_de_term_cd" value="Y">
<table width="100%" class="popup" cellpadding="10" border="0">
	<tr><td valign="top">	
	
	<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
			<tr>
				<td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Rail Hub – Port pair deletion </td>
			</tr>
		</table>
	<!-- : ( Title ) (E) -->
	
	<!-- : ( Description ) (S) -->
		<table width="100%" class="search" border="0" style="padding-top:10;,padding-bottom:10;">
		<tr>
			<td><table class="search" border="0">                                                                                                                                                                                                                  
					<tr class="h23">
					<td width="">'Delete from Tariff'</td>                                                                                                                                                                                                                        
					</tr>                                                                                                                                                                   
				</table>  
			</td>
			<td><table class="search" border="0">                                                                                                                                                                                                                  
					<tr>
					<td width="">: All routes based on below 'Rail Hub' – 'Base Port' pair will be</td>
					</tr>                                                                                                                                                                   
				</table>  
			</td>
		</tr>	 
		</table>
		
		<table width="100%" class="search" border="0">
		<tr><td>
			<table class="search" border="0">                                                                                                                                                                                                                  
				<tr>
				<td width="">deleted from Inland Add-on list</td>
				</tr>
			</table>	
		</td></tr> 
		</table> 
	<!-- : ( Description ) (E) -->
		
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:10;,padding-bottom:2;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_down_excel">Down Excel</td>
				<td class="btn1_right"></td>
				</tr></table></td>		
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_load_excel">Load Excel</td>
				<td class="btn1_right"></td>
				</tr></table></td>	
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_delete_from_tariff">Delete from Tariff</td>
				<td class="btn1_right"></td>
				</tr></table></td>						
			</tr>
			</table>
		</td></tr>
		</table>
	<!--Button (E) --> 
	
		<table class="search"> 
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
			
	<!--  Button_Sub (S) -->
	<table width="100%" class="button">
	<tr><td class="btn2_bg">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>							
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_row_add">Row Add</td>
			<td class="btn2_right"></td>
			</tr></table></td>	
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_row_copy">Row Copy</td>
			<td class="btn2_right"></td>
			</tr></table></td>	
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_row_delete">Delete</td>
			<td class="btn2_right"></td>
			</tr></table></td>	
			
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
			<tr><td class="btn2_left"></td>
			<td class="btn2" name="btn_check">Check</td>
			<td class="btn2_right"></td>
			</tr></table></td>	
																					
		</tr>
		</table>
	</td></tr>
 	</table>
 	<!-- Button_Sub (E) -->		  
		
		</td></tr>
	</table>
	</td></tr>
</table>

<!-- Button_Sub (E) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    	<tr>				    	    
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
								<tr><td class="btn1_left"></td>
									<td class="btn1" name="btn_close">Close</td>
									<td class="btn1_right"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>
	</td></tr>
</table>
<!-- Button_Sub (E) -->	
	
</form>
</body>
</html>