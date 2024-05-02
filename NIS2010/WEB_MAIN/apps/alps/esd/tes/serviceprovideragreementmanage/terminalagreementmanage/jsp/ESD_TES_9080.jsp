<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9080.jsp
*@FileTitle : Agreement Storage Remark Column Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.08 yOng hO lEE
* 1.0 Creation
=========================================================*/
%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%
String lgs_cost_cd 		= "";
String row 				= "";
String sheetObj 		= "";
String agmt_rmk 		= "";
String mode 			= "";

lgs_cost_cd	= JSPUtil.getParameter(request, "pop_cost_cd ".trim(), "");
row 		= JSPUtil.getParameter(request, "pop_row 	 ".trim(), "");
sheetObj 	= JSPUtil.getParameter(request, "pop_sheetObj".trim(), "");
agmt_rmk	= JSPUtil.getParameter(request, "pop_agmt_rmk".trim(), "");
mode		= JSPUtil.getParameter(request, "pop_mode".trim(), "");

%>
<html>
<head>
<title>Agreement Remarks</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
	var mode  = "<%=mode%>";
</script>

<body >
<form method="post" name="form" onSubmit="return false;">
<input type="hidden" name="row" value="<%=row%>">
<input type="hidden" name="sheetObj" value="<%=sheetObj%>">
<!-- OUTER - POPUP (S)tart -->
<table width="400" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Remarks Column</td></tr>
		</table>
		<!-- : ( Title ) (E) -->





		<!-- TABLE '#D' : ( Search Options : Speed ) (S) -->
     	<table class="search">
       	<tr><td class="bg">

				<table class="search" border="0" style="width:362;">
					<tr class="h23">
						<td width="65">Cost Code</td>
						<td width="297"><input type="text" name="lgs_cost_cd" maxlength="7" style="width:90" value="<%=lgs_cost_cd%>" readOnly></tr>
				</table>


				<table class="height_5"><tr><td></td></tr></table>
				<!-- : ( Speed ) (S) -->
				<table border="0" style="width:362;" class="search">
				<tr><td><textarea name="agmt_dtl_rmk" style="width:362;height:200;"><%=agmt_rmk%></textarea></td>
				</tr>




				</table>

				<!-- : ( Speed ) (E) -->






			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options : Speed ) (E) -->




</td></tr>
</table>
<!-- OUTER - POPUP (E)nd -->



<table class="height_10"><tr><td></td></tr></table>


<!-- : ( Button : Sub ) (S) -->
<table width="100%" class="sbutton">
		<tr><td height="71" class="popup">

			<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
	       		<tr><td class="btn3_bg">
			    <table border="0" cellpadding="0" cellspacing="0">
			    <tr>

					<!-- Repeat Pattern -->
					<% if( mode.trim().equals("create")){%>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_apply" id="btn_apply">Apply</td><td class="btn1_right"></td></tr></table></td>
					<%} %>
					<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn1_left"></td><td class="btn1" name="btn_close" id="btn_close">Close</td><td class="btn1_right"></td></tr></table></td>
					<!-- Repeat Pattern -->

				</tr>
			</table>

		</td></tr>
</table>
<!-- : ( Button : Sub ) (E) -->

</form>

</body>
</html>