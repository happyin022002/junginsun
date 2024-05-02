<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String bkgNo  = request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	String bkgSeq = request.getParameter("bkg_seq")==null?"":request.getParameter("bkg_seq");
%>
<html>
<head>
<title>Welcome to Alps!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">

    function setupPage(){  

	    loadPage();
    }

</script>
</head>
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp;PSA Container Booking – Exception Message</span> 
</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
		<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td width="80">Booking No.</td>
				<td width="150"><input type="input" style="width:100; text-align:center" name="bkg_no" value="<%=bkgNo%>" class="input" ReadOnly="true"></td>
				<td width="70">Sequence</td>
				<td width=""><input type="input" style="width:50; text-align:center" value="<%=bkgSeq%>" name="bkg_seq" class="input" ReadOnly="true"></td>
				</tr>
				<tr class="h23">
				<td colspan="4"><textarea style="width:100%;height:100" name="status_log" ReadOnly="true"></textarea></td>
				</tr>
		</table>
			</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<table class="height_5"><tr><td></td></tr></table>
</td></tr>
</table> 

	
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
<script language="javascript">ComSheetObject('sheet1');</script>
</td></tr></table>			
			
</form>			
</body>
</html>
