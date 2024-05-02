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
<input type="hidden" name="io">
<input type="hidden" name="authority">
<input type="hidden" name="deleteBtnChkYN">
<input type="hidden" name="max_vvd_seq" value="0">

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
					<td width="35">VVD</td>
					<td width="100"><input type="text" style="width:80;text-align:center;" class="input1" name="vvd" maxlength="9" dataformat="eng"></td>
					<td width="30">POL</td>
					<td width="105"><input type="text" style="width:62;text-align:center;" class="input1" name="pol_cd" maxlength="5" dataformat="eng"></td>
					<td width="50">POD</td>
					<td width="140"><input type="text" style="width:60;text-align:center;" class="input1" name="pod_cd" maxlength="5" dataformat="eng"></td>
					<td width="">
					<table class="search_sm2" border="0" style="width:200;" >
							<tr class="h23">
								<td><input type="radio" class="trans" name="current_check" value="C" checked> Current &nbsp;
					             <input type="radio" class="trans" name="current_check" value="D"> Downloaded</td></tr>
							</table>					
					</td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">Send Date</td>
					<td width="200"><input type="text" style="width:80;text-align:center;" class="input" maxlengt="10" dataformat="ymd" name="send_dt">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="send_tm" maxlength="5" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal1" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="50">Authority</td>
					<td width="130">&nbsp;<script language="javascript">ComComboObject('comboAuth', 3, 60, 1);</script></td>
					<td width="70">IO DATE</td>
					<td width="">&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="io_dt" maxlength="10" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="io_tm" maxlength="5" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal2" width="19" height="20" alt="" border="0" align="absmiddle"></td>
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="70">In Count</td>
					<td width="75"><input type="text" style="width:40;text-align:center;" class="input" name="call_knt"></td>
					<td width="80">Arrival Date</td>
					<td width="235"><input type="text" style="width:80;text-align:center;" class="input" name="arv_dt" maxlength="10" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="arv_tm" maxlength="5" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" name="btn_cal3"></td>
					<td width="70">Trans Code</td>
					<td width="140">&nbsp;<input type="text" style="width:58;text-align:center;" class="input" name="trans_code"></td>
					<td width="50">IO</td>
					<td width="">&nbsp;<script language="javascript">ComComboObject('comboIO', 3, 60, 1);</script></td>
				</tr>
				</table>
				
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="160">Discharge Company Code</td>
					<td width="110"><input type="hidden" name="dchg_com_cd"><script language="javascript">ComComboObject('comboDchgComCd', 3, 100, 0, 0, 0, true);</script></td>
					<td width="70">DSCH Com</td>
					<td width="120"><input type="text" style="width:115;" class="input" name="dsch_com_nm" dataformat="eng"></td>
					<td width="70">Total CNTR</td>
					<td width="140">&nbsp;<input type="text" style="width:58;text-align:right;" class="input" name="total_cntr" dataformat="float"></td>
					<td width="80">Total Weight</td>
					<td width="">&nbsp;<input type="text" style="width:104;text-align:right;" class="input" name="total_wgt" dataformat="float"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Job Code 1</td>
					<td width="80"><input type="text" style="width:60;text-align:center;" class="input" name="job_code1"></td>
					<td width="70">Job Code 2</td>
					<td width="80"><input type="text" style="width:60;text-align:center;" class="input" name="job_code2"></td>
					<td width="65">From Date</td>
					<td width="290"><input type="text" style="width:80;text-align:center;" class="input" maxlength="10" name="from_dt" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="from_tm" maxlength="5" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal4" width="19" height="20" alt="" border="0" align="absmiddle"></td>
					<td width="50">To Date</td>
					<td width="">&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="to_dt" maxlength="10" dataformat="ymd">&nbsp;<input type="text" style="width:50;text-align:center;" class="input" name="to_tm" maxlength="5" dataformat="hm">&nbsp;<img src="img/btns_calendar.gif" name="btn_cal5" width="19" height="20" alt="" border="0" align="absmiddle"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Previous Port</td>
					<td width="80"><input type="text" style="width:60;text-align:center;" class="input" name="pre_port"></td>
					<td width="70">Port Area</td>
					<td width="80"><input type="text" style="width:60;text-align:center;" class="input" name="port_area" maxlength="3"></td>
					<td width="65">Port Anch</td>
					<td width="80"><input type="text" style="width:60;text-align:center;" class="input" name="port_anch" maxlength="2"></td>
					<td width="70">Port Desc.</td>
					<td width="140"><input type="text" style="width:120;text-align:center;" class="input" name="port_desc"></td>
					<td width="50">MRN</td>
					<td width="">&nbsp;<input type="text" style="width:100;text-align:center;" class="input" name="mrn_no"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="83">Substance</td>
					<td width="">&nbsp;<input type="text" style="width:768;" class="input" name="substance"></td>
				</tr>
				</table>
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">Contact</td>
					<td width="585"><input type="text" style="width:565;" class="input" name="contact"></td>
					<td width="60">TML. VVD</td>
					<td width="">&nbsp;<input type="text" style="width:121;text-align:center;" class="input" name="tml_vvd"></td>
				</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
				<tr class="h23">
					<td width="85">VSL Full Name</td>
					<td width="230"><input type="text" style="width:210;" class="input" name="vsl_eng_nm" dataformat="eng"></td>
					<td width="65">Call Sign</td>
					<td width="120"><input type="text" style="width:100;text-align:center;" class="input" name="call_sgn_no" dataformat="eng" maxlength="5"></td>
					<td width="85">Inbound Seq.</td>
					<td width="85"><input type="text" style="width:65;text-align:center;" class="input" name="dgco_seq"></td>
					<td width="80">TMN. Voyage</td>
					<td width="">&nbsp;<input type="text" style="width:101;text-align:center;" class="input" name="tml_skd_voy_no"></td>
				</tr>
				</table>
					
				<!--  biz_1   (E) -->
				
				<table class="line_bluedot"><tr><td></td></tr></table>
				
			
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
				
			<!--  Button_Sub (S) -->
			<table width="100%" class="button"> 
	       	<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0"><tr>						
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_SelectAll" id="btn_SelectAll">Select All</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_Delete">Row Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_DownExcel">Down Excel</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
			</td></tr>
			</table>
	    	<!-- Button_Sub (E) -->	
				
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
					<td class="btn1" name="btn_TransDGM">반입신고서 전송</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_TransDGL">적하일람표 전송</td>
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