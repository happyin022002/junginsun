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
<body  onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="status" value="">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->
	
	<!--Button (S) -->
		
    <!--Button (E) -->
	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Send Date </td>
					<td width="250"><input type="text" style="width:75; text-align:center" name="from_dt" maxlength="10" dataformat="ymd" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_cal1" width="19" height="20" border="0" align="absmiddle">&nbsp;~&nbsp;<input type="text" style="width:75; text-align:center" name="to_dt" maxlength="10" dataformat="ymd" class="input1">&nbsp;<img class="cursor" src="img/btns_calendar.gif" name="btn_cal2" width="19" height="20" border="0" align="absmiddle"></td>
					<td width="25">POD</td>
					<td width="80"><input type="text" style="width:60;ime-mode:disabled; text-align:center" name="pod_cd" maxlength="5" dataformat="engupnum"></td>
					<td width="75">Booking No.</td>
					<td width="140"><input type="text" style="width:120; text-align:center" name="bkg_no" maxlength="13" dataformat="eng"></td>
					<td width="25">VVD</td>
					<td width="100"><input type="text" style="width:80; text-align:center" name="vvd" maxlength="9" dataformat="eng"></td>
					<td width="45">Status</td>
					<td width=""><script language="javascript">ComComboObject('comboStatus', 3, 80);</script></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
												
				
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>	
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
				
				</td></tr>
			</table>
				
			<!-- Grid (E) -->
			<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
						
				<td class="btn1_line"></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_StatusLog">Status Log</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->

</form>
</body>
</html>