<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : menumanagement.jsp
*@FileTitle : Menu Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.04
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.03.04 김경범
* 1.0 Creation
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.rowset.DBRowSet"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.syscommon.management.alps.copyauthority.event.CopyAuthorityEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	CopyAuthorityEvent  event = null;			//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_auth_tp_cd = "";
	String admin_page 		= "";
	Logger log = Logger.getLogger("com.hanjin.apps.MenuManagement.Menu");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_auth_tp_cd = account.getUsr_auth_tp_cd();
	   
		event = (CopyAuthorityEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);
		
		admin_page = event.getParam().get("admin_page");

		if (serverException != null) {
			strErrMsg = new ErrorHandler(serverException).loadPopupMessage();
		}else{
			if(rowSet != null){
				 rowCount = rowSet.getRowCount();
			} // end if
		} // end else
	}catch(Exception e) {
		log.error(e.toString());
	}
//	com.tobesoft.iam.virtualagent.TBVirtualAgent VA = new com.tobesoft.iam.virtualagent.TBVirtualAgent();
//	out.println(VA.decrypt("wd3t1P22QHNmT4m9yFfPDg==")); //qhdkscjfwj
%>
<html>
<head>
<title>Menu Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

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
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->


<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
<%	if("Y".equals(admin_page)) { %>			
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
<%	} else {%>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Copy of Authority</td></tr>
<%	} %>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0"> 
				<tr class="h23">
					<td>Option</td>
					<td class="stm"><input type="radio" class="trans" name="opt" checked value="add">Add&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="opt" value="del">Delete &amp; Insert</td>
					<td>&nbsp;&nbsp;&nbsp;</td>
					<td>Function</td>
					<td class="stm"><input type="checkbox" class="trans" name="RAP">Role &amp; Program&nbsp;&nbsp;&nbsp;<input type="checkbox" class="trans" name="SUR">Super User's Role&nbsp;&nbsp;&nbsp;<input type="checkbox" class="trans" name="OC">Office Change</td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
							
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<table  width="100%">
								<tr><td class="title_h"></td>
									<td class="title_s">From</td></tr>
								<tr>
									<td colspan="2"><script language="javascript">ComSheetObject('sheet1');</script>
									</td></tr>
							</table>
							<table  width="100%">
								<tr><td class="title_h"></td>
									<td class="title_s">To</td></tr>
								<tr>
									<td colspan="2"><script language="javascript">ComSheetObject('sheet2');</script>
									</td></tr>
							</table>
							

						
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->			
			    <table class="sbutton" width="100%" > 
			    <tr>
				<td class="align">
			    	<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><input type="text" name="addrows" size="3" value="1"></td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btng_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr></table>
								
		</td></tr></table>
		<!-- 1 (E) -->	

		
		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<%	if(!"Y".equals(admin_page)) { %>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
<%	} %>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	
	
	</td></tr>
		</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>