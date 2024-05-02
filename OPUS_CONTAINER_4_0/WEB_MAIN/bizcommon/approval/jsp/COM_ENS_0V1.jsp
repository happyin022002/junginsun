<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : COM_ENS_0V1.jsp
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2009.11.10 정인선
* 1.0 최초 생성
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.clt.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.clt.framework.support.controller.html.CommonWebKeys"%>
<%
	String cahrt = "";
	if(request.getParameter("Subscriber") != null || !request.getParameter("Subscriber").equals("")){
		cahrt = request.getParameter("Subscriber");
	}
	SignOnUserAccount account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
	String ofc_cd = account.getOfc_cd();
%>
<html>
<head>
<title>Organization Chart</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="/opuscntr/css/OrganTree.css" type="text/css" rel="stylesheet" />
<script language="javascript" type="text/javascript" src="/opuscntr/js/OrganTree.js"></script>
<script language="javascript" type="text/javascript" src="/opuscntr/js/HashMap.js"></script>

</HEAD>

<body onLoad="loadPage(); initTree('treeView', 'loadData'); officeSearch();">
<form name="form">
<input type="hidden" name="f_cmd"> 
<input type="hidden" name="ofc_cd_deptsrch">
<input type="hidden" name="mode">
<input type="hidden" name="apro_step">
<input type="hidden" name="target_obj_nm">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top: 2; padding-left: 5;">
	<tr>
		<td valign="top"><!--Page Title, Historical (S)-->
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
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
					<input type="text" style="width:130;" class="input" value="" name="search_text">&nbsp;</td>
					<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn1_left"></td>
							<td class="btn1" name="btn_Search">Search</td>
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
			</td>
			
			<td width="35" align="center">
				<img src="img/btns_add.gif" border="0" name="btns_add" class="cursor" >
				<br><br><img src="img/btns_del.gif" border="0" name="btns_del" class="cursor">
			</td>

			<td width="400" valign="top">
			<table><tr><td width="5%">Office</td>
					<td width="15%">&nbsp;<input type="text" name="ofc_cd" style="width:65" readOnly value="<%=ofc_cd%>"></td>
					<td width="6%">Module</td>
					<td><%= com.clt.bizcommon.util.BizComUtil.getCodeCombo("sub_sys_cd", "", "", "SUBSYS", 1, ": :") %>
					</td></tr></table>
			<table class="line_bluedot"><tr><td></td></tr></table>
			<!-- : ( Grid : Week ) (S) -->
				<table width="100%" id="mainTable">
                	<tr><td>
                    	<script language="javascript">ComSheetObject('sheet2');</script>
               		</td></tr>
               </table>
			<!-- : ( Grid : Week ) (E) -->
					</td>
			</tr>
		</table>
		</td>
	</tr>
</table>

<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
<!-- ################# TABLE '#B' ::: 'LEFT + RIGHT' FRAME (END) ################## -->
<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
</BODY>

</HTML>
 <%@include file="../../include/common_alps.jsp"%>