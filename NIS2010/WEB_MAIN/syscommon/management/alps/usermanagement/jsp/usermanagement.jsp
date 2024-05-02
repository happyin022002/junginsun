<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : usermanagement.jsp
*@FileTitle : User Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.02.19
*@LastModifier : 김경범
*@LastVersion : 1.0
* 2009.02.19 김경범
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
<%@ page import="com.hanjin.syscommon.management.alps.user.event.UserManagementEvent"%>
<%@ page import="com.hanjin.syscommon.common.util.OrganizationUtil"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	UserManagementEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	boolean adminAuth = false;
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_auth = "";
	String admin_page = "";
	Logger log = Logger.getLogger("com.hanjin.apps.UserManagement.User");
	SignOnUserAccount account = null;
	
	try {
	   	account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_auth = account.getUsr_auth_tp_cd();
	   
		event = (UserManagementEvent)request.getAttribute("Event");
		admin_page = event.getAdminPage();
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

		// SELHO이외의 지역 Super 유저는  add 버튼 사용이 불가능하다.
		// 2009.08.25 by desis
		String sRHQ = (new OrganizationUtil()).getHeadQuaterCode(account.getUsr_id());
		if ( account.getUsr_auth_tp_cd().equals("A") ) adminAuth = true;
//		else if ( account.getUsr_auth_tp_cd().equals("E") ) adminAuth = true;
//		else if ( account.getUsr_auth_tp_cd().equals("S") ) {
//			if ( sRHQ.equals("SELHO") ) adminAuth = true;
//			else adminAuth = false;
		else adminAuth = false;

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
%>
<html>
<head>
<title>User Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="/hanjin/css/alps_contents.css" type="text/css" rel="stylesheet"/>

<script language="javascript">
var almightyFlag = false;
	function setupPage(){
		var errMessage = "<%=strErrMsg%>";
		if (errMessage.length >= 1) {
			ComShowMessage(errMessage);
		} // end if
		if (curPgmNo == 'COM_SEC_0001' ) {
			if ( document.all.s_usr_id ) document.all.s_usr_id.value = '<%=strUsr_id%>';
			loadPage(true);
		} else {
			loadPage(false);
		}
<% if ( account.getUsr_auth_tp_cd().equals("A") ) { %>
		almightyFlag = true;
<% } %>
	}
</script>
</head>

<body  onLoad="setupPage();">
<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<input type="hidden" name="pgm_no_form">
<input type="hidden" name="admin_page" value="<%= admin_page %>"> 
<!-- 개발자 작업	-->

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
		
		<!-- 1 (S) -->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
<% if (! strUsr_auth.equals("R") ) { %>			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td>User ID</td>
					<td><input type="text" style="width:100;" class="input" value="" name="s_usr_id"></td>
					<td>Office Code</td>
					<td><input type="text" style="width:80;" dataformat="engup" class="input" name= "s_ofc_cd" value="" onKeyPress="javascript:ComKeyOnlyAlphabet('uppernum');">&nbsp;<img class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" name="btn_ofc_cd"></td>
					<td>User Auth. Type</td>
					<td><select style="width:100;" class="input1" name ="s_usr_auth_tp_cd">
					<option value="">ALL</option>
						<option value="R">Regular</option>
						<option value="E">System Admin</option>
						<option value="S">Super User</option>
						<option value="A">Almighty</option>
						</select></td>
				</tr>
				<tr class="h23">
					<td>User Name</td>
					<td><input type="text" style="width:100;" class="input" value="" name="s_usr_nm"></td>
					<td>Use Flag</td>
					<td><select style="width:100;" class="input1" name ="s_use_flg">
						<option value="">ALL</option>
						<option value="Y" selected>Yes</option>
						<option value="N">No</option>
						</select></td>
					<td>ID DIV</td>
					<td><select style="width:100;" class="input1" name ="s_id_div">
						<option value="">ALL</option>
						<option value="GID">GID</option>
						<option value="LID">LID</option>
						</select></td>
				</tr>
				</table>				
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
<% } %>
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->			
				
				
		</td></tr></table>
		<!-- 1 (E) -->	

		
<% if (! strUsr_auth.equals("R") ) { %>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr>
       		<td class="btn">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Copy">Copy</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
       		</td></tr>
       		</table>
			</td>
       		<td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><% if (adminAuth) { %><td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Add">Add</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td><% } %>	
				<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	
<% } else { %>
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				</tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->	
<% } %>
	</td></tr>
		</table>
	
<!-- 개발자 작업  끝 -->
</form>
</body>
</html>