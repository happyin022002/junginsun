<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title>Forecast Accuracy Review</title>
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="/hanjin/css/alps_contents.css" rel="stylesheet" type="text/css">
</head>
<body class="popup_bg">
<!-- OUTER - POPUP (S)tart -->

<table width="100%" class="popup" cellpadding="10">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td height="79" class="title"><img src="/hanjin/img/icon_title_dot.gif" align="absmiddle">&nbsp;Evaluation Rule</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--Page Title, Historical (E)-->
		<table class="search">
			<tr>
				<td class="bg">
				<table class="search" border="0" style="width: 100%;">
					<tr class="h23">
						<td style="padding: 0 0 10 0; color: #505151;">◎ Diff. (%) Formula = Diff. Vol ÷ FCST</td>
					</tr>
					<tr class="">
						<td style="padding: 0 0 15 0; color: #505151;">
						1) ECC’s Each EQ ;  (FCST – PFMC) ÷ FCST<br>      
					    2) ECC’s Total EQ ;  {Sum of abs(all EQ’s FCST – PFMC)} ÷ Sum of all EQ’s FCST<br>
					    3) Total’s Each EQ ; {Sum of abs(each EQ’s FCST – PFMC)} ÷ Sum of each EQ’s FCST<br>
					    4) Total’s Total EQ ; {Sum of abs(all EQ’s FCST – PFMC)} ÷ Sum of all EQ’s FCST<br>
					        * abs = abbreviation of absolute value         
						</td>
					</tr>

					<tr class="h23">
						<td style="padding: 0 0 10 0; color: #505151;">◎ Accuracy Evaluation (by Diff.(%) Range)</td>
					</tr>
					<tr class="">
						<td style="padding: 0 0 15 0; color: #505151;">
						    1) Excellent ; -3.0≤~0 ≤ 3.0%          2) Good ; ±3.0＜~≤±7.0%<br>
						    3) Not Good ; ±7.0%＜~≤±12.0%     4) Poor ; Over ±12%
  
						</td>
					</tr>

				</table>


				</td>
			</tr>
		</table>
		<!-- : ( Search Options ) (E) -->	
		
<table class="height_5"><tr><td colspan="8"></td></tr></table>
	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       		<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close" onclick="window.close();">Close</td>
					<td class="btn1_right">
				</tr></table></td>
			</tr>
		</table></td>
			</tr>
		</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</body>
</html>