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
<input type="hidden" name="msg_log_tp_id" value="">
<input type="hidden" name="tp_cd" value="">
 
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
				<table class="search_sm2" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="35">MSG</td>
					<td width="60">
					<script language="javascript">ComComboObject('cboMsgTp', 3, 50, 1, 1);</script>
					</td>
					<td width="45"><input type="radio" value="vvd" name="search_type" class="trans" onClick="funcChangSearchOption(document.form, 'vvd');">&nbsp;VVD</td>
					<td width="90"><input type="text" style="width:80; text-align:center;" class="input2" name="vvd" maxlength="9" dataformat="eng"></td>
					<td width="80"><input type="radio" value="bl_no" name="search_type" class="trans" onClick="funcChangSearchOption(document.form, 'bl_no');">&nbsp;B/L No</td>
					<td width="114"><input type="text" style="width:100; text-align:center;" class="input2" name="bl_no" maxlength="12" dataformat="eng"></td>
					<td width="90"><input type="radio" value="smt_no" name="search_type" class="trans" onClick="funcChangSearchOption(document.form, 'smt_no');">&nbsp;SUB. No</td>
					<td width="154"><input type="text" style="width:145; text-align:center;" class="input2" name="smt_no" maxlength="19" dataformat="eng"></td>
					<td width="130"><input type="radio" value="recv_dt" name="search_type" class="trans" checked  onClick="funcChangSearchOption(document.form, 'date');">&nbsp;Receive Date</td>
					<td width=""><input type="text" style="width:80; text-align:center;" class="input1" name="from_dt" maxlength="10" dataformat="ymd">&nbsp;~&nbsp;<input type="text" style="width:80; text-align:center;" class="input1" name="to_dt" maxlength="10" dataformat="ymd">&nbsp;<img src="img/btns_calendar.gif" name="btn_calendar1" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor"></td>
				</tr>
				</table>
				<table class="line_bluedot"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="38">&nbsp;Type</td>
					<td width="82"><script language="javascript">ComComboObject('cboTp', 3, 50, 1);</script></td>
					<td width="24">POL</td>
					<td width="114"><input type="text" style="width:80; text-align:center;" class="input" name="pol_cd" maxlength="5" dataformat="eng"></td>
					<td width="41">POD</td>
					<td width="135"><input type="text" style="width:100; text-align:center;" class="input" name="pod_cd" maxlength="5" dataformat="eng"></td>
					<td width="53">Office</td>
					<td width="144"><input type="text" style="width:100; text-align:center;" class="input" name="ofc_cd" maxlength="6" dataformat="eng"></td>
					<td width="50">User ID</td>
					<td width=""><input type="text" style="width:100; text-align:center;" class="input" name="user_id" maxlength="10" dataformat="eng"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
					
		</td></tr></table>
		<table class="height_8"><tr><td></td></tr></table>	
		
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
				</td></tr>
			</table>
				
		
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
			
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">View Receive File</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	<table class="height_10"><tr><td colspan="8"></td></tr></table>
</form>
</body>
</html>
