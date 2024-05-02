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
<input type="hidden" name="event_no" value="0341">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">
<input type="hidden" name="mrn_bl_ts_cd">

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
			<tr class="h23"><td width="630">
				<table class="search_sm" border="0" style="width:600;"> 
				<tr class="h23">
					<td width="60"><input type="radio" name="search_type" checked value="vvd" class="trans">&nbsp;&nbsp;VVD</td>
					<td width="150"><input type="text" style="width:100" name="vvd" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engupnum" maxlength="9"></td>
					<td width="30">PORT</td>
					<td width="130"><input type="text" style="width:70" name="port_cd" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engupnum" maxlength="5" ></td>
					<td width="65"><input type="radio" name="search_type" value="mrn" class="trans">&nbsp;&nbsp;MRN</td>
					<td width=""><input type="text" style="width:80" name="mrn_no" class="input1" style="ime-mode:disabled; text-align:center;" dataformat="engupnum" maxlength="10">&nbsp;-&nbsp;<input type="text" style="width:20" name="mrn_chk_no" class="input2" ReadOnly>&nbsp;<img src="img/btns_search.gif" width="19" height="20" alt="" border="0" name="btn_mrn_search" align="absmiddle" class="cursor"></td>
				</tr>
				</table>
			</td>
			<td width="40">Mode</td>
			<td width=""><SELECT name="io_bnd_cd">
			<option value="I">InBound</option>
			<option value="O">OutBound</option>
			</SELECT></td>
			<td width="">B/L Type</td>
				<td width="">
				<select style="width:85;" class="input" name="bl_type" onchange="javascript:funcBlTypeOnChange(this);">
					<option value="" selected>ALL</option>
					<option value="S">Simple</option>
					<option value="C">Consol</option>
					<option value="E">Empty</option>
					<option value="M">T/S Empty</option>
				</select></td>
			</tr>
			</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="67">&nbsp;&nbsp;B/L No.</td>
					<td width="150"><input type="text" style="width:100" name="bl_no" class="input" style="ime-mode:disabled; text-align:center;" dataformat="engupnum" maxlength="12"></td>
					<td width="30">MSN</td>
					<td width="133"><input type="text" style="width:70" name="msn_no" class="input" style="ime-mode:disabled; text-align:center;" dataformat="num" maxlength="4"></td>
					<td width="65">Local / TS</td>
					<td width=""><select name="mrn_bl_ts_cd2" style="width:82;">
						<option value="" selected>ALL</option>
						<option value="I">Local</option>
						<option value="T">T/S</option>
						</select></td>
					</tr>
				</table>
				<!--  biz_1   (E) -->
				<table class="line_bluedot"><tr><td colspan="8"></td></tr></table>
				
				<!-- Grid  (S) -->
				<table width="100%"  id="mainTable"> 
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
							<script language="javascript">ComSheetObject('sheet2');</script>
						</td>
					</tr>
				</table>			
			<!-- Grid (E) -->
			
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
				
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_formprint">Form Print</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_listprint">Down Excel</td>
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
