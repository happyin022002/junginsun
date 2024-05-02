<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp;PSA Vessel Register : Import Schedule </span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="grid2" border="0" width="100%"> 
					<tr>
						<td width="80" class="tr2_head" style="height:30">Port</td>		
						<td width="">&nbsp;<input type="text" class="input1" name="port_cd" maxlength="5" style="width:80; ime-mode:disabled; text-align:center" dataformat="engupnum"></td>		
					</tr>
					<tr>
						<td class="tr2_head" style="height:30">ETB</td>
						<td>&nbsp;<input type="text" class="input1" name="etb_dt1" maxlength="10" style="width:80; text-align:center" dataformat="ymd">
						~ <input type="text" class="input1" name="etb_dt2" maxlength="10" style="width:80; text-align:center" dataformat="ymd">
						<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1">
						</td>
					</tr>
				</table>
				<script language="javascript">ComSheetObject('sheet1');</script>
				<!--  biz_1   (E) -->	
		<!--biz page (E)-->

	</td></tr>
		</table>
	
	</td>
	<td height="350"></td>
	</tr>
		</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td class="btn1_line"></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
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
