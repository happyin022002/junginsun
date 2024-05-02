<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String type = request.getParameter("type") == null ? "" : request.getParameter("type");
	String vvd = request.getParameter("vvd") == null ? "" : request.getParameter("vvd");
	String mrn_no = request.getParameter("mrn_no") == null ? "" : request.getParameter("mrn_no");
	String mrn_chk_no = request.getParameter("mrn_chk_no") == null ? "" : request.getParameter("mrn_chk_no");
	String mode = request.getParameter("mode") == null ? "Inbound" : request.getParameter("mode");
	String pol = request.getParameter("pol") == null ? "" : request.getParameter("pol");
	String pod = request.getParameter("pod") == null ? "" : request.getParameter("pod");
	String etd = request.getParameter("etd") == null ? "" : request.getParameter("etd");
	String eta = request.getParameter("eta") == null ? "" : request.getParameter("eta");
	String yard = request.getParameter("yard") == null ? "" : request.getParameter("yard");
	String bl_cnt = request.getParameter("cnt_bl_no") == null ? "0" : request.getParameter("cnt_bl_no");
	String bkgNo = request.getParameter("bkg_no") == null ? "" : request.getParameter("bkg_no");
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
<body class="popup_bg" onLoad="setupPage();"> 

<form name="form">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="yard" value="<%=yard%>">
<input type="hidden" name="bkg_no" value="<%=bkgNo%>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="notitle">&nbsp;MSN &amp; Bonded Inform Designate-Group</span></td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!-- 1 (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="35">Type</td>
					<td width="90"><input type="text" style="width:60; text-align:center;" name="type" class="input2" value="<%=type%>" ReadOnly></td>
					<td width="30">VVD</td>
					<td width="115"><input type="text" style="width:85;text-align:center;" name="vvd" class="input2" value="<%=vvd%>" ReadOnly></td>			
					<td width="30">MRN</td>
					<td width="190"><input type="text" style="width:90;text-align:center;" name="mrn_no" class="input2" value="<%=mrn_no%>" ReadOnly>&nbsp;-&nbsp;<input type="text" style="width:30;text-align:center;" name="mrn_chk_no" class="input2" value="<%=mrn_chk_no%>" ReadOnly></td>
					<td width="40">Mode</td>
					<td width="150"><input type="text" style="width:90;text-align:center;" name="mode" class="input2" value="<%=mode%>" ReadOnly></td>
					<td width="30">MSN</td>
					<td><input type="text" style="width:40;" class="input1" name="msn1" dataformat="int" maxlength="4" onChange="msn1_onChange();">&nbsp;-&nbsp;<input type="text" style="width:40;" class="input1" name="msn2" dataformat="int" maxlength="4" onChange="msn2_onChange();"></td>					
				</tr> 
				</table>				
				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="35">POL</td>
					<td width="90"><input type="text" style="width:60;text-align:center;" name="pol" class="input2" value="<%=pol%>" ReadOnly></td>
					<td width="30">ETD</td>
					<td width="115"><input type="text" style="width:85;text-align:center;" class="input2" value="<%=etd%>" name="etd" ReadOnly></td>			
					<td width="30">POD</td>
					<td width="190"><input type="text" style="width:90;text-align:center;" name="pod" class="input2" value=" <%=pod%>" ReadOnly></td>
					<td width="40">ETA</td>
					<td width="150"><input type="text" style="width:90;text-align:center;" class="input2" value="<%=eta%>" name="eta" ReadOnly></td>
					<td width="85">Total Record</td>
					<td class="stm"><input type="text" style="width:30;text-align:center;" name="bl_cnt" class="input2" value=" <%=bl_cnt%>" ReadOnly>&nbsp;&nbsp;B/Ls</td>
				</tr> 
				</table>				
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>
				
				<!--  Button_Sub (S) -->
				<table width="100%" class="button"> 
		       	<tr><td align="right">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
							<td width="">
							<table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
							<tr><td class="btn2_left"></td>
							<td class="btn2" name="btn_msn" id="btn_msn">MSN Assign</td>
							<td class="btn2_right"></td>
							</tr>
							</table></td></tr>
					</table>
				</td></tr>
				</table>
		    	<!-- Button_Sub (E) -->
				
		</td></tr></table>
		<!-- 1 (E)--> 
		
		
		<!-- 2 (S)-->
		<table class="height_8"><tr><td></td></tr></table>
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
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
			
		</td></tr></table>
		<!-- 2 (E)--> 

<table class="height_5"><tr><td></td></tr></table>

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" id="btn_retrieve" name="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
				</tr></table></td>	
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_listprint">Down Excel</td>
					<td class="btn1_right"></td>
				</tr></table></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_confirm">Confirm All</td>
					<td class="btn1_right"></td>
				</tr></table></td>	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_editBl">Go to Edit B/L</td>
					<td class="btn1_right">
				</tr></table></td>	
				<td class="btn1_line"></td>		
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
			</table>
		</td></tr></table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->
</form>			
</body>
</html>

		