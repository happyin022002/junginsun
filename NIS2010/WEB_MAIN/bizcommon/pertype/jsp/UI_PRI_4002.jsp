<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_PRI_4002.jsp
*@FileTitle : Per Type
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.04.22 김석준
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.bizcommon.pertype.event.UiPri4002Event"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	UiPri4002Event  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	String strErrMsg = "";						//에러메세지

	String strUsr_id		= "";
	String strUsr_nm		= "";
	
	String pertpChar = request.getParameter("rat_ut_grp_cd");
	String cxlInd = request.getParameter("cxl_ind");
	Logger log = Logger.getLogger("com.hanjin.bizcommon.BizCommon.PerType");

	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
	   
		event = (UiPri4002Event)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}
		
	}catch(Exception e) {
		log.error(e.toString());
	}
%> 
<html>
<head>
<title>Welcome to nis2010!</title>
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

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');"> 
<input type="hidden" name="f_cmd">

<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
    
            
        <!-- : ( Title ) (S) -->
        <table width="100%" border="0">
        <tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Rating Unit Inquiry</td></tr>
        </table>
        <!-- : ( Title ) (E) -->
	
	<!--biz page (S)-->
		<table class="search">  
       	<tr><td class="bg">
				<!-- biz_1  (S) -->
				
			  
	<table class="search" border="0" style="width:800;"> 
				<tr class="h23">
					<td width="30">Unit</td>
					<td width="180">
						<input type="text" style="width:30;" class="input" name="rat_ut_cd"  value='<%= (request.getParameter("rat_ut_cd") == null)? "" :  request.getParameter("rat_ut_cd")%>' dataformat="engup" maxlength="2" style="ime-mode:disabled"></td>
					<td width="55">Character </td>
					<td width="250"><select style="width:100;"class="input" name="rat_ut_grp_cd">&nbsp;
						<option value="" <%if("".equals(pertpChar)){%>selected <%} %>></option>
						<option value="E" <%if("E".equals(pertpChar)){%>selected <%} %>>Equipment</option>
						<option value="C" <%if("C".equals(pertpChar)){%>selected <%} %>>Percentage</option>
						<option value="M" <%if("M".equals(pertpChar)){%>selected <%} %>>Measure</option>
						<option value="W" <%if("W".equals(pertpChar)){%>selected <%} %>>Weight</option>
						<option value="P" <%if("P".equals(pertpChar)){%>selected <%} %>>Package</option>
						<option value="B" <%if("B".equals(pertpChar)){%>selected <%} %>>B/L</option>
						<option value="R" <%if("R".equals(pertpChar)){%>selected <%} %>>Rail</option>
						</select></td> 
					<td width=""><input type="checkbox" value="Y" class="trans" name="cxl_ind" value=<%if(!"".equals(cxlInd)){%>checked<%} %>>&nbsp;Including Deleted Unit </td>
 				</tr>
				</table>

<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->
			
		<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="979"> 
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
		<!-- Grid (E) -->
		</td></tr>
		</table>
  
<table class="height_5"><tr><td></td></tr></table> 
		
			</td></tr>
		</table>
		<!-- Tab BG Box(E) -->
	<!--biz page (E)-->
	<!--Button (S) -->
	<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
    
        <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
        <tr><td class="btn3_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_select">OK</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left">
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right">
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					
			</tr></table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
</table>

</form>
</body>
</html>

<%@include file="../../include/common_alps.jsp"%>