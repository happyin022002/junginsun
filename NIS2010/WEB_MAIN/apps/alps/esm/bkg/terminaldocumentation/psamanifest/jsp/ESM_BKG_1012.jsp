<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String cntrNo 	= request.getParameter("cntr_no")==null?"":request.getParameter("cntr_no");
	String bkgNo 	= request.getParameter("bkg_no")==null?"":request.getParameter("bkg_no");
	String vslCd 	= request.getParameter("vsl_cd")==null?"":request.getParameter("vsl_cd");
	String skdVoyNo = request.getParameter("skd_voy_no")==null?"":request.getParameter("skd_voy_no");
	String skdDirCd = request.getParameter("skd_dir_cd")==null?"":request.getParameter("skd_dir_cd");
	String selectRow = request.getParameter("select_row")==null?"":request.getParameter("select_row");
%>
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
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">
<input type="hidden" name="vsl_cd" value="<%=vslCd%>">
<input type="hidden" name="skd_voy_no" value="<%=skdVoyNo%>">
<input type="hidden" name="skd_dir_cd" value="<%=skdDirCd%>">
<input type="hidden" name="type_cd" value="U">
<input type="hidden" name="select_row" value="<%=selectRow%>">

<!-- OUTER - POPUP (S)tart -->
<table width="700" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp; PSA Special Cargo Info.</span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 		
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:679;"> 
					<tr class="h23">
						<td width="90">Container No.</td>
						<td width=""><input type="text" style="width:100; text-align:center;" ReadOnly name="cntr_no" class="input2" value="<%=cntrNo%>"></td>
					</tr>					
				</table>
				<script language="javascript">ComSheetObject('sheet1');</script>
				<!--  biz_1   (E) -->	
		
			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
			
			<table class="search" border="0" style="width:679;"> 
					<tr class="h23">
						<td width="115" rowspan="5" valign="top">Over Dim.</td>
						<td width="40" class="stm">Height</td>
						<td width="80"><input type="text" style="width:60; text-align:right" class="input" name="ovr_dim_hgt" dataformat="float"></td>
						<td width="60" class="stm">RF Temp.</td>
						<td width="80"><input type="text" style="width:60; text-align:right" class="input" name="rf_flg"  dataformat="signedfloat"></td>
						<td width="70" class="stm">DIR DEL</td>
						<td width="80"><select style="width:40;" name="dir_de_flg">
						<option value=""></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
						<td width="90" class="stm">Disc. Over SZ</td>
						<td width=""><select style="width:40;" name="dchg_ovr_sz_flg">
						<option value=""></option>
						<option value="Y">Y</option>
						<option value="N">N</option>
						</select></td>
					</tr>
					<tr class="h23">
						<td width="" class="stm">Front</td>
						<td width=""><input type="text" style="width:60; text-align:right" class="input" name="ovr_fnt_dim_len" dataformat="float"></td>
						<td width="" class="stm">Height</td>
						<td width=""><input type="text" style="width:60; text-align:right" class="input" name="dim_hgt" dataformat="float"></td>
						<td width="" class="stm">Loading Ins.</td>
						<td width="" colspan="3"><select style="width:40;" name="ld_ins1">
						<option value=""></option>
						<option value="AB">AB</option>
						<option value="BD">BD</option>
						<option value="BU">BU</option>
						<option value="CU">CU</option>
						<option value="DM">DM</option>
						<option value="DO">DO</option>
						<option value="ER">ER</option>
						<option value="FN">FN</option>
						</select>&nbsp;<select style="width:40;" name="ld_ins2">
						<option value=""></option>
						<option value="AB">AB</option>
						<option value="BD">BD</option>
						<option value="BU">BU</option>
						<option value="CU">CU</option>
						<option value="DM">DM</option>
						<option value="DO">DO</option>
						<option value="ER">ER</option>
						<option value="FN">FN</option>
						</select>&nbsp;<select style="width:40;" name="ld_ins3">
						<option value=""></option>
						<option value="AB">AB</option>
						<option value="BD">BD</option>
						<option value="BU">BU</option>
						<option value="CU">CU</option>
						<option value="DM">DM</option>
						<option value="DO">DO</option>
						<option value="ER">ER</option>
						<option value="FN">FN</option>
						</select></td>
					</tr>
					<tr class="h23">
						<td width="" class="stm">Rear</td>
						<td width=""><input type="text" style="width:60; text-align:right" class="input" name="ovr_bak_dim_len" dataformat="float"></td>
						<td width="" class="stm">Width</td>
						<td width="" colspan="4"><input type="text" style="width:60; text-align:right" class="input" name="dim_wdt" dataformat="float"></td>
					</tr>
					<tr class="h23">
						<td width="" class="stm">Left</td>
						<td width=""><input type="text" style="width:60; text-align:right" class="input" name="ovr_lf_dim_wdt" dataformat="float"></td>
						<td width="" class="stm">Length</td>
						<td width="" colspan="4"><input type="text" style="width:60; text-align:right" class="input" name="dim_len" dataformat="float"></td>
					</tr>
					<tr class="h23">
						<td width="" class="stm">Right</td>
						<td width="" colspan="6"><input type="text" style="width:60; text-align:right" class="input" name="ovr_rt_dim_wdt" dataformat="float"></td>
					</tr>
				</table>
				<table class="search" border="0" style="width:679;"> 
				<tr class="h23">
						<td width="110" valign="top">Cargo Desc.</td>
						<td width=""><textarea style="width:100%" rows="4" name="cgo_desc" dataformat="etc"></textarea></td>
					</tr>
					<tr class="h23">
						<td width="">Commodity Desc.</td>
						<td width="" style="padding-left:1"><input type="text" style="width:100%;" class="input" name="cmdt_desc" dataformat="etc"></td>
					</tr>
				</table>
		<!--biz page (E)-->

	</td></tr>
		</table>
<table class="height_5"><tr><td></td></tr></table>
	
	</td></tr>
		</table>
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">
	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Delete">Delete</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			<td class="btn1_line"></td>		
				<td><table width="" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
    <!--Button (E) -->
	
	</td></tr>
</table>
</td></tr></table>
<!-- : ( Button : pop ) (E) -->
		
</form>				
</body>
</html>
