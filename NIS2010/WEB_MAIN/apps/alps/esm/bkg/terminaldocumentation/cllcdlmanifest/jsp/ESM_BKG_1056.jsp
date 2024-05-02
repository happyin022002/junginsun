<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1056.jsp
*@FileTitle : ESM_BKG_1056
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.09.14 손윤석
* 1.0 Creation
=========================================================*/
%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	//"typecode : FM, TO"
	String typecode = request.getParameter("typecode");
	String fmSelect = "";
	String toSelect = "";
	if("FM".equals(typecode)) fmSelect = "selected";
	if("TO".equals(typecode)) toSelect = "selected";
%>

<html>
<head>
<title>Container Loading List_Summary_SPP List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>

<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="typecode" value="<%=typecode %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"> Container Loading List_Summary_SPP List</td></tr>
		</table>	
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
       		
       			
			<table width="100%" class="search">
				<tr class="h23">
					<td width="75">Entry Type</td>
					<td width="">
						<select style="width:55;" class="input" name="entryTp" onchange="javascript:funcSetDefault();">
							<option value="" >All</option>
							<option value="TO" <%=toSelect %>>TO</option>
							<option value="FM" <%=fmSelect %>>FM</option>
						</select>
					</td>
				</tr>
			</table>
		
			
			<table class="height_8"><tr><td></td></tr></table>
			<!-- : ( Grid ) (S) -->
			<table width="100%"  id="mainTable"> 
			<tr>
				<td width="100%">
				<script language="javascript">ComSheetObject('sheet1');</script>
				</td>
			</tr>
			</table>
			<!-- : ( Grid ) (E) -->	
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Add">Row Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->
				
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
</td></tr>
</table> 

	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    <td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td>
			<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Save">Save</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td>
			<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Select">Select</td>
				<td class="btn1_right"></td>
				</tr></table>
			</td>
			<td class="btn1_line"></td>		
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
				<tr><td class="btn1_left"></td>
				<td class="btn1" name="btn_Close">Close</td>
				<td class="btn1_right"></td>
			</tr></table>
			</td>
			</tr>
		</table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
</form>					
</body>
</html>
