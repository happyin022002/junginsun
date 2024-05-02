<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ADM_SYS_0025.jsp
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : DukWoo, Choi
*@LastVersion : 1.0
* 2013.07.04 DukWoo, Choi
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>

<%
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String usrId = account.getUsr_id();
%>

<html>
<head>
<title>Organization Chart</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/hanjin/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/hanjin/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/hanjin/js/HashMap.js"></script>

</HEAD>

<body onLoad="loadPage();">
<form name="form">
<input type="hidden" name="f_cmd">


<input type="hidden" name="usr_id" value="<%=usrId%>">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Job Code Approver Assign</td></tr>
			</table>
			<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->
		<!--Page Title, Historical (E)--> <!-- 1 (S) -->
		<table class="search" id="mainTable" border="0">
			<tr><td class="bg">
				<table class="search" border="0">
					<tr class="h23">
						<td width="210">
						<!--  biz_1  (S) -->
							<table class="search" border="0">
								<tr class="h23">
									<td></td>
								</tr>
							</table>
						<!--  biz_1   (E) -->

							<table class="line_bluedot"><tr><td></td></tr></table>

							<!-- Grid (S) -->
							<table id="mainTable">
								<tr>
									<td>
									<div id="treeView" style="overflow: auto; width: 210px; height: 320px; border-width: 1px; border-style: solid; border-color: #7F9DB9;"></div>
									</td>
								</tr>
							</table>
						</td>
						<td width="10"></td>
						<td>
							<!--  biz_1  (S) -->
							<table class="search" border="0">
								<tr class="h23">
									<td><select id="search">
										<option value="NAME">Name</option>
										<option value="TEAMNM">Department</option>
										<option value="POS">Title</option>
										<option value="JOB">Job Info</option>
										<option value="CN">User ID</option>
									</select>
									<input type="text" style="width:130;" class="input" value="" name="search_text"></td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td>
											<td class="btn1" name="btn_search">Search</td>
											<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
									<td>
										<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
											<tr><td class="btn1_left"></td>
											<td class="btn1" name="btn_reset">Reset</td>
											<td class="btn1_right"></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
							<!--  biz_1   (E) -->

							<table class="line_bluedot"><tr><td></td></tr></table>

							<!-- Grid (S) -->
							<table id="mainTable" width="100%">
								<tr>
									<td>
									<script language="javascript">ComSheetObject('sheet1');</script>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td></tr>
		</table>

		<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
		<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
		<!--Button (S) -->
		<table width="100%" class="sbutton">
			<tr>
				<td height="71" class="popup">
					<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
						<tr>
							<td class="btn3_bg">
								<table border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_ok">OK</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
										<td>
											<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr>
													<td class="btn1_left"></td>
													<td class="btn1" name="btn_close">Close</td>
													<td class="btn1_right"></td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	<!--Button (E) -->
	</td>
</tr>
</table>
</BODY>

</HTML>
 <%@include file="/bizcommon/include/common_alps.jsp"%>