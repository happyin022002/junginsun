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
<input type="hidden" name="in_vsl_cd">
<input type="hidden" name="in_skd_voyage_no">
<input type="hidden" name="in_skd_dir_cd">
<input type="hidden" name="in_mrn_mode" value="I">


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
					<td width="75">MRN</td>
					<td width="223"><input type="text" style="width:83; text-align:center;" class="input"  name="in_mrn_no" maxlength="10" style="ime-mode:disabled" dataformat="engupnum">
					<input type="text" style="width:20; text-align:center;" class="input2"  name="in_mrn_chk_no" maxlength="1" style="ime-mode:disabled" dataformat="num">
					<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_Inquiry"></td>
					<td width="76">VVD</td>
					<td width="223"><input type="text" style="width:80;" class="input1" name='in_vvd' maxlength="9" style="ime-mode:disabled; text-align:center;" dataformat="engupnum"></td>
					<td width="26">Port</td>
					<td width="168"><input type="text" style="width:50;" class="input1" name="in_port" maxlength="5" style="ime-mode:disabled; text-align:center;" dataformat="engup"></td>
					<td width="" align="right">Mode : Inbound</td>
				</tr>
				<tr class="h23">
					<td width="">Send Date</td>
					<td width=""><input type="text" name="snd_dt" style="width:130; text-align:center;" class="input2" value="" readOnly="true"></td>
					<td width="">Result Date</td>
					<td width=""><input type="text" name="rslt_dt" style="width:130; text-align:center;" class="input2" value="" readOnly="true"></td>
					<td width="">Result</td>
					<td width=""><input type="text" name="rslt" style="width:105; text-align:center;" class="input2" value="" readOnly="true"></td>
					<td width="">Error MSG&nbsp;&nbsp;<input type="text" name="err_msg" style="width:105;" class="input2" value="" readOnly="true"></td>
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
				</td></tr>
			</table>
		<!-- Tab ) (E) -->

<!-- TAB [ LOCAL ] (S) -->
<div id="tabLayer" style="display:inline">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			<td width="750" valign="top">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t1sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			</td>
			<td width="20"></td>
			<td width="" valign="top">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Record by B/L Type</td></tr>
				</table>
			<!-- Grid  (S) -->
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="50%">Simple</td>
				<td class="input2" align="center"><span id="t1simple">0</span></td></tr>
				<tr><td class="tr2_head">Console</td>
				<td class="input2" align="center"><span id="t1console">0</span></td></tr>
				<tr><td class="tr2_head">Empty</td>
				<td class="input2" align="center"><span id="t1empty">0</span></td></tr>			
			</table> 
			<!-- Grid (E) -->
			</td></tr>
		</table>
			</td></tr>
		</table>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->
	
</div>
<!-- TAB [ LOCAL ] (E) -->


<!-- TAB [ T/S ] (S) -->
<div id="tabLayer" style="display:none">

		<!-- Grid BG Box  (S) -->
     	<table class="search" id="mainTable">
       	<tr><td class="bg">
			<table class="search" border="0" style="width:979;"> 
			<tr class="h23">
			<td width="750">
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('t2sheet1');</script>
						</td>
					</tr>
				</table>
			<!-- Grid (E) -->
			</td>
			<td width="20"></td>
			<td width="" valign="top">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Record by B/L Type</td></tr>
				</table>
				<!-- Grid  (S) -->
			
			<table border="0" style="width:100%; background-color:white;" class="grid2"> 
				<tr><td class="tr2_head" width="50%">Simple</td>
				<td class="input2" align="center"><span id="t2simple">0</span></td></tr>
				<tr><td class="tr2_head">Console</td>
				<td class="input2" align="center"><span id="t2console">0</span></td></tr>
				<tr><td class="tr2_head">Empty</td>
				<td class="input2" align="center"><span id="t2empty">0</span></td></tr>			
			</table> 
			<!-- Grid (E) -->
			</td></tr>
		</table>
			</td></tr>
		</table>
		<script language="javascript">ComSheetObject('sheet3');</script>
	<!-- Grid BG Box  (S) -->
	<!--biz page (E)-->

</div>
<!-- TAB [ T/S ] (E) -->

	
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
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ManifestGeneration">Manifest Generation</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_EDISend">EDI Send</td>
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