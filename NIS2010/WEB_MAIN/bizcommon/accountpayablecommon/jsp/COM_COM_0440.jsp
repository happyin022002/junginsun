<%
/*
=========================================================
*Copyright(c) 2014 CyberLogitec. All Rights Reserved.
*@FileName   : COM_COM_0440.jsp
*@FileTitle  : CENTER POPUP 
*@author     : CLT
*@version    : 1.0
*@since      : 2014/ 
=========================================================
*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.bizcommon.accountpayablecommon.event.ComCom0440Event"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%
	ComCom0440Event  event = null;	
	Exception serverException=null;			//서버에서 발생한 에러
	String strErrMsg="";						//에러메세지
	String f_center="";
	String strUsr_id="";
	String strUsr_nm="";
	String main_page = JSPUtil.getParameter(request, "main_page".trim(), "");
	Logger log=Logger.getLogger("com.hanjin.apps.bizcommon.accountpayablecommon.AccountPayableCommonSC");
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id=account.getUsr_id();
		strUsr_nm=account.getUsr_nm();
		event = (ComCom0440Event)request.getAttribute("Event");
		serverException=(Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		//f_center=StringUtil.xssFilter(request.getParameter("f_center"));
		//f_center=f_center==null?"":f_center;
		if (serverException != null) {
			strErrMsg=new ErrorHandler(serverException).loadPopupMessage();
		}
	} catch(Exception ex) {
		log.error("err " + ex.toString(), ex);
		//out.println(e.toString());
	}
%>
<html>
<head>
<title>Center Code Inquiry</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function setupPage(){
		var errMessage="<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		loadPage(<%=main_page%>);
	}
</script>
</head>
<!-- OUTER - POPUP (S)tart -->
<%if(main_page.equals("true")){ %>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
	<input type="hidden" name="f_cmd">	
	<tr><td valign="top">
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
<%} else { %>
<body class="popup_bg" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="javascript:setupPage();">
<table width="100%" class="popup" cellpadding="10"> 
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
	<input type="hidden" name="f_cmd">	
<tr><td class="top"></td></tr>
<tr><td valign="top">
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="img/icon_title_dot.gif" align="absmiddle">Center Code Inquiry</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	<%} %>

<input type="hidden" name="pagerows" id="pagerows" />


  <table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:0;padding-bottom:2;">
        <tr><td class="btn1_bg">
            <table border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
                    <tr>
                        <td class="btn1_left"></td>
                        <td class="btn1" name="btn_Retrieve">Retrieve</td>
                        <td class="btn1_right"></td>
                    </tr>
                    </table>
                </td>
                <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_OK">OK</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
             <td>
                <table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
                <tr>
                    <td class="btn1_left"></td>
                    <td class="btn1" name="btn_Close">Close</td>
                    <td class="btn1_right"></td>
                </tr>
                </table>
            </td>
   	 	</tr>
    </table>
    </td>
    </tr>
    </table>
</div>

 <table class="search">
		<tr>
			<td class="bg">
				<table class="search" border="0">
				<tr class="h23">
                    <td width="100">Center Code</td>
	                   	<td><input type="text" name="f_center" dataformat="engup" style="width:100px;" class="input" value="<%=f_center%>" id="f_center" /></td>                        
					</tr> 
					</table>
					</td>
					</tr>
			</table>		
	<div class="wrap_result">
		<div class="opus_design_grid clear" id="mainTable" >
			<script type="text/javascript">ComSheetObject('sheet1');</script>
		</div>
	</div>	
	<!-- opus_design_grid(E) -->
</div>
</form>
</table>
</body>
</html>

<%@include file="../../include/common_alps.jsp"%>