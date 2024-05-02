<%	
	/*=========================================================
	 *Copyright(c) 2009 CyberLogitec
	 *@FileName : esm_bkg_0502.jsp
	 *@FileTitle : TransmitHistory
	 *Open Issues :
	 *Change history :
	 *@LastModifyDate : 2009.07.08
	 *@LastModifier : 손윤석
	 *@LastVersion : 1.0
	 * 2009.07.08  손윤석
	 * 1.0 Creation
	 =========================================================*/
%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<title>0502</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage()
    {  
	    loadPage();
    }
</script>
</head>
<body  onLoad="setupPage();"> 

<form name="form"> 
<input type="hidden" name="p_search_option" value="">
<input type="hidden" name="in_snd_op" value="">
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="in_msg_type">
<input type="hidden" name="in_ks_type">
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
<tr><td class="top"></td></tr>
<tr><td valign="top">	
		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->
	
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			

				<!--  biz_1 (S) -->
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">MSG</td>
						<td width="50">
						<script language="javascript">ComComboObject('combo1', 3, 50, 1, 1);</script></td>
						<td>
							
						
							<table class="search_sm2" border="0" style="width:100%;"> 
								<tr class="h23">	
							
									<td width="40"><input type="radio" class="trans" name="rad_vvd_op">&nbsp;VVD</td>
									<td width="90"><input type="text" class="input" style="width:80;" value="" name="in_vsl_cd" dataformat="eng" maxlength="9"></td>
									<td width="75"><input type="radio" class="trans" name="rad_bl_op">&nbsp;B/L No.</td>
									<td width="110"><input type="text" class="input" style="width:100;" value="" name="in_bl_no" dataformat="eng" maxlength="12"></td>
									<td width="80"><input type="radio" class="trans" name="rad_sub_op">&nbsp;Sub No.</td>
									<td width="140"><input type="text" class="input" style="width:140;" value="" name="in_sub_cd" dataformat="eng" maxlength="19"></td>
									<td width="120"><input type="radio" class="trans" name="rad_date_op">&nbsp;<select style="width:90;"class="input" name="in_date_op">
																												<option value="SEND_DATE" selected>Send Date</option>
																												<option value="ETA">ETA</option>
																												<option value="ETD">ETD</option>
																												</select></td>
									<td><input type="text" class="input" style="width:75;" value="" name="in_snd_dt_s" dataformat="ymd" maxlength="10">
									~<input type="text" class="input" style="width:75;" value="" name="in_snd_dt_e" dataformat="ymd" maxlength="10">
									<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1">
									</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>
				<table class="height_2"><tr><td></td></tr></table>
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="30">Type</td>
						<td width="138" style="padding-left:2;">
						<script language="javascript">ComComboObject('combo2', 3, 60, 1);</script>
						</td>
						<td width="25">POL</td>
						<td width="80"><input type="text" class="input" style="width:60;" name="in_pol_cd" dataformat="eng" maxlength="5"></td>
						<td width="30">POD</td>
						<td width="80"><input type="text" class="input" style="width:60;" value="" name="in_pod_cd" dataformat="eng" maxlength="5"></td>
						<td width="40">Office</td>
						<td width="90"><input type="text" class="input" style="width:60;" name="in_ofc_cd"  maxlength="6" dataformat="eng"></td>
						<td width="50">User ID</td>
						<td width="103"><input type="text" class="input" style="width:95;" name="in_usr_id" dataformat="eng"></td>
						<td width="">
							<table class="search_sm2" border="0" style="width:230;"> 
								<tr class="h23">	
									<td width=""><input type="radio" class="trans" name="view_send_unsend" checked>&nbsp;All&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="view_send_unsend">&nbsp;Send&nbsp;&nbsp;&nbsp;<input type="radio" class="trans" name="view_send_unsend">&nbsp;Un-send</td>
								</tr>
							</table>
						</td>
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
	<!--biz page (E)-->
	
	</td></tr>
	</table>
	

	<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_view">View Send File</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td></tr>
			</table>
		</td></tr>
		</table>
    	<!--Button (E) -->

</form>
</body>
</html>