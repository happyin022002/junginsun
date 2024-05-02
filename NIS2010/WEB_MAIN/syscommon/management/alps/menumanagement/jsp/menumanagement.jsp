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
<%@ page import="com.hanjin.syscommon.management.alps.menu.event.MenuManagementEvent"%>
<%@ page import="org.apache.log4j.Logger" %>

<%
	MenuManagementEvent  event = null;					//PDTO(Data Transfer Object including Parameters)
	Exception serverException   = null;			//서버에서 발생한 에러
	DBRowSet rowSet	  = null;					//DB ResultSet
	String strErrMsg = "";						//에러메세지
	int rowCount	 = 0;						//DB ResultSet 리스트의 건수
	
	String strUsr_id		= "";
	String strUsr_nm		= "";
	String strUsr_auth_tp_cd = "";
	Logger log = Logger.getLogger("com.hanjin.apps.MenuManagement.Menu");
	
	try {
	   	SignOnUserAccount account=(SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strUsr_id =	account.getUsr_id();
		strUsr_nm = account.getUsr_nm();
		strUsr_auth_tp_cd = account.getUsr_auth_tp_cd();
	   
		event = (MenuManagementEvent)request.getAttribute("Event");
		serverException = (Exception)request.getAttribute(CommonWebKeys.EXCEPTION_OBJECT);

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
<input type="hidden" name="acss_lvl" value="N">
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
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td>Program No.</td>
					<td><input type="text" style="width:200;" dataformat="engup" class="input" value="" name="pgm_no"></td>
					<td>Program Name</td>
					<td><input type="text" style="width:260;" class="input" value="" name="pgm_nm"></td>
					
					<td>Program Div.</td>
					<td><select style="width:100;" class="input1" name ="s_pgm_mnu_div_cd">
						<option value="">ALL</option>
						<option value="02">Program</option>
						<option value="01">Menu</option>
						</select></td>
						<!--
					<td>Office Access Level</td>
					<td><select style="width:100;" class="input1" name ="acss_lvl">
						<option value="N">exclude</option>
						<option value="Y">include</option>
						</select></td>
						-->
						
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
							
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="40%">
							<table  width="100%">
								<tr><td class="title_h"></td>
									<td class="title_s">Program</td></tr>
								<tr>
									<td colspan="2"><script language="javascript">ComSheetObject('sheet1');</script>
									</td></tr>
							</table>
						</td>
						<td width="10%" align="center" valign="middle">
						<%
							if (strUsr_auth_tp_cd.equalsIgnoreCase("A")) {
						%>
						<table>
							<tr>
								<td><input type="radio" name="add_type" value="0" checked class="trans"></td>
								<td>Child</td>
							</tr>
							<tr>
								<td><input type="radio" name="add_type" value="1" class="trans"></td>
								<td>Previous Sibling</td>
							</tr>
							<tr>
								<td><input type="radio" name="add_type" value="2" class="trans"></td>
								<td>Next Sibling</td>
							</tr>
							<tr>
								<td align="center" colspan="2">
									<table width="60%" border="0" cellpadding="0" cellspacing="0" class="button">
										<tr><td class="btn1_left"></td>
										<td class="btn1" name="btn_Add">Add</td>
										<td class="btn1_right"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						<%
							}
						%>
						</td>
						<td width="50%">
							<table  width="100%">
								<tr><td class="title_h"></td>
									<td class="title_s">Menu</td></tr>
								<tr>
									<td colspan="2"><script language="javascript">ComSheetObject('sheet2');</script>
									</td></tr>
							</table>
							<!-- 
							<table class="search_sm2" border="0">
								<tr class="h23">
									<td width="25%">Office Access Level</td>
									<td width="" class="stm">
									<input type="checkbox" name="SHO" class="trans" value="1">SHO
									<input type="checkbox" name="RHQ" class="trans" value="2">RHQ
									<input type="checkbox" name="GOF" class="trans" value="3">GOF
									<input type="checkbox" name="SOF" class="trans" value="4">SOF
									<input type="checkbox" name="LOF" class="trans" value="5">LOF
									<input type="checkbox" name="AGT" class="trans" value="6">AGT
									<input type="checkbox" name="OTH" class="trans" value="9">OTH
									</td>
								</tr> 
							</table>
							-->
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->			
				
				<table  width="100%">
					<tr><td colspan="2"><script language="javascript">ComSheetObject('sheet3');</script></td></tr>
				</table>
				
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
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table>
				</td>
				<% if ( strUsr_auth_tp_cd.equals("A") || strUsr_auth_tp_cd.equals("E") ) {%><td class="btn1_line"></td>
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
				</table></td><% } %>
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