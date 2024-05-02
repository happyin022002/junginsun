<html>
<head>
<title>Status Inquiry by Class Popup</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script language="javascript">
    function setupPage(){  
	    loadPage();
    }
</script>
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="page_no" value="1">
<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Status Inquiry by Class</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- : ( Search Options ) (S) -->
 
			<table class="search"> 
       		<tr><td class="bg">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="60">Template</td>
					<td width="310"><select name="template_class" style="width:300;">
						<option value="63" selected>By Area</option>
						<option value="64">By HOFC</option>
						<option value="65">By Handler</option>
						<option value="66">By Surveyor</option>
						<option value="67">By Liable Party</option>
						<option value="68">By VVD</option>
						<option value="69">By Container</option>
						<option value="70">By Claim Amount</option>
						<option value="71">By Application</option>
						<option value="72">By Settled Amount</option>
						<option value="73">By Litigation</option>
						<option value="74">By Insurer</option>
						<option value="75">By Handling Period</option>
						</select></td>
						<td >
				      <table width="56" border="0" cellpadding="0" cellspacing="0"
									class="button">
									<tr>
										<td class="btn2_left"></td>
										<td class="btn2" name="btns_Get">Get</td>
										<td class="btn2_right"></td>
									</tr>
								</table>
				</td>
				</tr>
				
				</table>
				<table class="height_5"><tr><td></td></tr></table>
			<table class="search" border="0" style="width:100%;"> 
			<tr class="h23">
			<td width="45%">
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Selectable Columns</td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td>column <input type="text" style="width:81%;" name="sheet1autofind">
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
					</table> 
				</td>
				</tr>
				</table>
			</td>
			<td width="10%" align="center">
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
				<td align="center"><img class="cursor" src="img/btns_add.gif" width="26" height="26" border="0" align="absmiddle" name="btns_Add"></td>
				</tr>
				<tr class="h23">
				<td><table class="height_8"><tr><td></td></tr></table></td>
				</tr>
				<tr class="h23">
				<td align="center"><img class="cursor" src="img/btns_del.gif" width="26" height="26" border="0" align="absmiddle" name="btns_Del"></td>
				</tr>
				</table>
			</td>
			<td>
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Selected & To be displayed</td></tr>
				</table>
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td>column <input type="text" style="width:61%;" name="sheet2autofind">
					<table width="100%"  id="mainTable"> 
					<tr>
						<td width="80%">
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
					</table> </td>
				</tr>
				<tr>
				<td align="right">
					<table>
					<tr align="center"><td align="center">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td><img src="img/btn_2_left_up.gif" width="17" height="19" alt="" border="0"></td>
							<td class="btn2" name="btns_Up">Up</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
							<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td><img src="img/btn_2_left_down.gif" width="17" height="19" alt="" border="0"></td>
							<td class="btn2" name="btns_Down">Down</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td>
					</tr>
					</table>
				</td>
				</tr>
				</table>
				
			</td>
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
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_OK">OK</td>
					<td class="btn1_right">
				</tr></table></td>
				
				<td class="btn1_line">
			<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn1_Close">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
			
			
</body>
</html>
