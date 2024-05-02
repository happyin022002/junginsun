<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="mrn_no"> 
<input type="hidden" name="mode">

<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->

	<!--biz page (S)-->
		<table class="search"> 
       	<tr><td class="bg">

				<!--  biz_1  (S) -->
		<table class="search" border="0" style="width:979;"> 
		<tr class="h23">
		<td width="360">
			<table class="search" border="0" style="width:289;"> 
			<tr class="h23">	
					<td width="">&nbsp;&nbsp;Bound</td>
					<td width="" width=""><select style="width:97;" class="input1" name="io_bnd_cd">
						<option value="I" SELECTED>Inbound</option>
						<option value="O">Outbound</option>
						</select></td>
					<td width="">&nbsp;Port&nbsp;&nbsp;<input type="text" style="width:50; text-align:center;" class="input1" name="port_cd" maxlength="5" dataformat="engup"></td>
					<td width="">&nbsp;Lane&nbsp;&nbsp;<input type="text" style="width:30; text-align:center;" class="input" name="lane" maxlength="3" dataformat="engupnum"></td>
			</tr>
			<tr class="h23">
			
			</tr>
			</table>
		</td>
		<td width="">
<!-- 			<table border="0" style="width:58%; background-color:white;" class="grid2"> --> 
			<table class="search" border="0" style="width:70%;">  
			<tr class="h23">		
						<td width="40"><input type="radio" class="trans" name="rad_kind" value="vvd" checked>VVD</td>						
						<td width="60"><input type="text" style="width:90; text-align:center;" class="input1" name="vvd1" maxlength="9" dataformat="engupnum"></td>
						
						<td width=""><input type="radio" class="trans" name="rad_kind" value="eta">ETA</td>						
						<td width="" colspan="3">
						<input type="text" style="width:80;text-align:center;" class="input1" name="from_dt" maxlength="10" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input1" name="to_dt"  maxlength="10" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
						
			</tr>
			<tr class="h23">
			
					    <td width="40">Carrier</td>
					
						<td width="60"><select style="width:97;" class="input1" name="crr_cd">
						<option value="H" selected>SML</option>
						<option value="O">Others</option>
						</select></td>
						
						<td width="">&nbsp;&nbsp;MRN No.</td>
					
						<td width="60"><select style="width:97;" class="input1" name="mrn_yn">
						<option value="Y" >Yes</option>
						<option value="N" SELECTED>No</option>
						</select></td>
								
			</tr>
			</table>
		</td>
		
		</tr>
		</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			
			<!--  Button_Sub (S) -->
			
	    	<!-- Button_Sub (E) -->	
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			<!-- 	<td class="btn1_line"></td> -->
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_delete">Delete</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_automrn">Auto MRN </td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<select style="width:40;" class="input1" name="sel_type">
						<option value="0" SELECTED>0</option>
						<option value="H">H</option>
						<option value="E">E</option>
						<option value="F">F</option>
						</select>
						</table></td>
						
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
					<input type="text" style="width:30; text-align:center;" class="input1" name="start_num" maxlength="3" dataformat="int">				
					</tr>
				</table></td>
	
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td></tr>
		</table>
</form>
</body>
</html>
