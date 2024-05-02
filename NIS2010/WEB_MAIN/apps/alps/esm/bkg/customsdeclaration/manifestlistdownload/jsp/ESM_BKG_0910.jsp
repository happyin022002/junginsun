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

<!-- OUTER - POPUP (S)tart -->
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

			
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Manifest Preparation</td></tr>
				</table>
	<table class="search" border="0" style="width:489;"> 
	<tr class="h23">
	<td width="200" valign="top">
					
				<table class="search" border="0" style="width:140;"> 
				<tr class="h23">
					<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_mrnCreate" style="text-align:left">&nbsp;&nbsp;1. MRN Create</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="140" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_mrnInquiry" style="text-align:left">&nbsp;&nbsp;2. MRN Inquiry</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
		</td>
		
		<td width="" align="right">
					
				<table class="search" border="0" style="width:320;"> 
				<tr class="h23">
					<td width=""><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_manifestGen" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Manifest Generate</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_whAssign" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Warehouse Assign by B/L</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_printIfm" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. Print IFM by VVD / POL</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="320" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_printDisch" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. Print Discharging CY Declare List by VVD</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
		</td>
		</tr>
		</table>
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 1 : Transmission</td></tr>
				</table>
				<table class="search" border="0" style="width:390;"> 
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downLoad" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Data Download &amp; Transmit</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
			
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 2 : Amendment</td></tr>
				</table>
				
				<table class="search" border="0" style="width:390;"> 
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_amendTrans" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Amendment Transmit</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td colspan="8"></td></tr></table>	
				<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Stage 3 : Closing</td></tr>
				</table>
				<table class="search" border="0" style="width:390;"> 
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_transHist" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Transmit History</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_recvHist" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Receive History</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_transCargo" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3. Transmit DG Cargo Manifest</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_transVessel" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;4. Transmit Vessel Inform and Manifest</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_downloadHist" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;5. Download History</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_cargoPrint" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;6. Cargo Manifest print by B/L No</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				<tr class="h23">
					<td width=""><table width="390" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_genCargoManifest" style="text-align:left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;7. General Cargo Manifest by VVD/PORT</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
				</tr>
				</table>									
							
			</td>	
		</tr>
		</table>
				</td></tr>
			</table>
			
			<table class="height_10"><tr><td colspan="8"></td></tr></table>	
			<!--Button (S) -->
		
    <!--Button (E) -->
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
</form>
</body>
</html>