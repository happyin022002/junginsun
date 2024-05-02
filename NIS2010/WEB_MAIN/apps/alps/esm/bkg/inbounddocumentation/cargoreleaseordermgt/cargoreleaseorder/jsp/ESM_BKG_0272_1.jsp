<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0272.jsp
*@FileTitle : E-mail / Print
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.27 손윤석
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0272Event"%>
<%@ page import="org.apache.log4j.Logger" %>



<%
	EsmBkg0272Event event = null;
	Exception serverException   = null;
	String strErrMsg = "";
	String strUsr_eml = "";
	String subject = "";
	String strUsr_id = "";
	String strUsr_nm = "";
	//String content = JSPUtil.getNull(request.getParameter("mailcontent"));
	String fileKey = "";
	String emailParam = "";
	
	Logger log = Logger.getLogger("com.hanjin.apps.InboundBLMgtSC.FullReleaseOrderBC");
	try
	{
		SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id  = account.getUsr_id();
		strUsr_nm  = account.getUsr_nm();
		strUsr_eml = "SM Line Corporation.,";
		event = (EsmBkg0272Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if(serverException != null) 
		{
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
	}
	catch(Exception e) 
	{
		log.error(e.getMessage(),e);
	}
	
	fileKey = request.getParameter("fileKey");
	emailParam = request.getParameter("emailParam");
%>
<html>
<head>
<title>Full Container Release Order E-mail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage()
	{
		var errMessage = "<%=strErrMsg%>";
		if(errMessage.length >= 1) 
		{
			ComShowMessage(errMessage);
		}
		loadPage();
	}
	
	var emailParam = "<%= emailParam %>";
</script>
</head>
<body onLoad="setupPage();"> 
<form name="form"> 
<input type="hidden" name="f_cmd">
<input type="hidden" name="from" value="<%=strUsr_eml%>">
<input type="hidden" name="eml_diff" value="<%= emailParam %>">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	

	<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;E-mail</td></tr>
	</table>
	
	
	<table class="search"> 
 	<tr>
    <td class="bg">
    <table width="100%" class="search"> 
		<tr class="h23">
			<td align="right">E-mail :&nbsp;<input type="text" style="width:50;text-align:center;"  class="noinput3" name="pageCount" value=""></td>
		</tr>
	</table>
	<table width="100%" class="grid2"> 
		<tr class="tr2_head_l">
			<td>E-mail Address</td>
		</tr>
		<tr class="tr2_head2">
			<td width="100%"><input type="text" style="width:100%;"  name="recipient" value=""></td>
		</tr>
	</table>
	
	<table width="100%" class="grid2">
		<tr class="tr2_head_l">
			<td>subject</td>
		</tr> 
		<tr class="tr2_head2">
			<td width="100%"><input type="text" style="width:100%;"  name="subject" value="Full Container Release Order" readOnly=true></td>
		</tr>
	</table>
	
	<table width="100%" class="grid2">
		<tr class="tr2_head_l">
			<td>content</td>
		</tr> 
		<tr class="tr2_head2">
			<td width="100%">
				<textarea style="width:100%;text-indent:0px" rows="27" name="content" readOnly=true></textarea>
			</td>
		</tr>
	</table>
	
	<table width="100%"  id="mainTable"> 
		<tr>
			<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				<script language="javascript">ComSheetObject('sheet2');</script>
			</td>
		</tr>
	</table>
</td>
</tr>
</table>
</td>
</tr>
</table>

<table class="height_5"><tr><td></td></tr></table>

<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
       		<table border="0" cellpadding="0" cellspacing="0">
		    	<tr>
		    		<td>
		    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_new">New</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
		    		<td>
		    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Prev">Prev</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
		    		<td>
		    			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_Next">Next</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td>
						<td class="btn1" name="btn_E-mail">E-mail Send</td>
						<td class="btn1_right"></td>
						</tr>
						</table>
					</td>
					
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

</form>		
</body>
</html>