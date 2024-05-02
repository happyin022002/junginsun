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
<input type="hidden" name="vvd" value="">
<input type="hidden" name="file_key" value="">
<input type="hidden" name="subSysCd" value="BKG">
<input type="hidden" name="etd_dt" value="">
<input type="hidden" name="eta_dt" value="">

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
					<td width="85">Relay Port CD</td>
					<td width="110"><input type="text" style="width:60;ime-mode:disabled; text-align:center" maxlength="5" class="input1" name="rly_port" dataformat="engupnum" onChange="portChange();" value="SGSIN"></td>
					<td width="30">VVD</td>
					<td width="140"><script language="javascript">ComComboObject('cboVVD', 3, 100, 0, 1, 0, true);</script></td>
					<td width="30"><span id="spanEtdEta">ETD</span></td>
					<td width="145"><input type="text" style="width:80; text-align:center;" name="eta_etd" maxlength="10" dataformat="ymd" class="input" onChange="etdChange();">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_cal1"></td>
					<td width="40">Trans</td>
					<td width="130">
							<select name="trans_tp_cd" id="trans_tp_cd" style="width:80" class="input1" onChange="trans_tp_change();">
							<option value="E" selected>Export</option>
							<option value="I">Import</option>
							</select></td>
				   <td width="269"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>


			<table class="height_8"><tr><td></td></tr></table>


		<!-- Tab ) (S) -->
     		<table class="tab" border="0" cellpadding="0" cellspacing="0" width="100%"> 
       		<tr><td width="100%">
						<script language="javascript">ComTabObject('tab1')</script>
						<!-- img src="img/sub_tab.gif" alt="" width="998" height="23" border="0" -->
					</td></tr>
				</table>
		<!-- Tab ) (E) -->

<!--TAB Unmatch (S) -->

<div id="tabLayer" style="display:inline">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">


				<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t1sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->


			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

</div>

<!--TAB Unmatch (E) -->


<!--TAB NIS (S) -->

<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				
				<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t2sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

</div>

<!--TAB NIS (E) -->


<!--TAB PSA (S) -->

<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			
				
				<!--Grid (S)-->
					<table width="100%"  id="mainTable">
						<tr>
							<td width="100%">
								<script language="javascript">ComSheetObject('t3sheet1');</script>
							</td>
						</tr>
					</table>
					<!--Grid (E)-->
				
				
			</td></tr>
		</table>
	<!-- Grid BG Box  (E) -->

</div>

<!--  Hidden Sheet -->
<script language="javascript">ComSheetObject('t1sheet2');</script>


<!--TAB PSA (E) -->

	<!--biz page (E)-->
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_New">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_PSAIF">PSA&nbsp;I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_JurongIF">Jurong&nbsp;I/F</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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

</form>
</body>
</html>
