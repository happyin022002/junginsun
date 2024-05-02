<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_POPUP_YNC.jsp
*@FileTitle : ESM_BKG_POPUP_YNC
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.20
*@LastModifier : TAE SEUNG YUN
*@LastVersion : 1.0
* 1.0 Creation	
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>

<%
String message = JSPUtil.getParameter(request, "message" , "");
%>
<html>
<head>
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css"/>
<link href="/hanjin/css/alps_menu.css" rel="stylesheet" type="text/css"/>
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css"/>
<title>Confirm Dialog</title>
</head>
<body>
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
</table>
</td>
</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>	
<table class="search" id="mainTable">
<tr>
<td class="bg">	
<table class="search" border="0" style="width:430;">
<tr class="h23">
<td>
<%= message %>
</td>
</tr>
</table>
</td>
</tr>
</table>
<table class="height_8"><tr><td></td></tr></table>
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
								<td class="btn1" name="btn_Yes" onClick="window.returnValue='Y'; self.close();">Yes</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_No" onClick="window.returnValue='N'; self.close();">No</td>
								<td class="btn1_right"></td>
							</tr>
						</table>
						</td>
						<td>
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr>
								<td class="btn1_left"></td>
								<td class="btn1" name="btn_Cancel" onClick="self.close()">Cancel</td>
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
</body>
</html>