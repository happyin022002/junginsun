<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_038.jsp
*@FileTitle : US Cargo Tracking
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-24
*@LastModifier : Seong-mun Kang
*@LastVersion : 2.0
* 2006-11-24 Seong-mun Kang
* 1.0 최초생성
=========================================================*/
%>

<%
	int    rowSize = 3000 ;
%>

<html>
<head>
<title>Welcome to YMS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">

    function setupPage(){

        loadPage();
    }

</script>
</head>

<body onLoad="setupPage();" >
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="cust_value1" value=''>
<input type="hidden" name="cust_value2" value=''>
<input type="hidden" name="new_target_flag_hidden" value=''>
<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding"  onClick="shootDecision();">
<tr><td>


		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (S) -->
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
				<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
				<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
			</table>
		<!-- TABLE '#D' : ( Page Title, Historical Tail Navigation ) (E) -->


		<!-- TABLE '#D' : ( Button : Main ) (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-bottom:5;">
								<tr><td class="btn1_bg">

										<table border="0" cellpadding="0" cellspacing="0">
										<tr>
											<!-- Repeat Pattern -->
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_new" id="btn_new">New</td><td class="btn1_right"></td></tr></table></td>
											<td class="btn1_line"></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_bkginfo" id="btn_bkginfo">Booking Info</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_cop" id="btn_cop">COP</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_clm" id="btn_clm">CLM</td><td class="btn1_right"></td></tr></table></td>
											<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_rtr" id="btn_rtr">RTR</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>
		<!-- TABLE '#D' : ( Button : Main ) (E) -->









		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search"  onClick="shootDecision();">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="84"><img class="nostar">Customer</td>
							<td width="571"><input onKeyUp="ComChkObjValid(this, 'eng_num', true)" onBlur="ComChkObjValid(this, 'eng_num', true);rememberPreEvent()" value="" name="cust_cnt_seq" type="text"  class="input" style="width:80; text-transform:uppercase;"> <input name="cust_nm" onFocus="shootDecision()" type="text" class="input" style="width:380" readonly> <img onclick="openCustPop(false,'cust_cnt_seq','cust_nm')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="55">S/C No.</td>
							<td><input onFocus="shootDecision()" onKeyUp="ComChkObjValid(this, 'eng_num', true)" onBlur="ComChkObjValid(this, 'eng_num', true);this.value=this.value.toUpperCase();" name="sc_no" type="text" class="input" style="width:80; text-transform:uppercase;" maxlength="20" value="">&nbsp;</td>
						</tr>


					</table>

					<table class="search_in" border="0">
						<tr class="h23">
							<td width="330"><select name="date_kind" style="width:80;" onChange="chgDateKind(this.value)">
							<option value="" selected="selected"></option>
							<option value="S">S/O Date</option>
							<option value="A">DA Date</option>
							<option value="O">DO Date</option>
							</select> <input onFocus="shootDecision()" name="fm_dt" type="text" class="input" style="width:70; text-transform:uppercase;" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;<input onFocus="shootDecision()" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)" name="to_dt" type="text" class="input" style="width:70; text-transform:uppercase;" >&nbsp;<img name="btn_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>

							<td width="30">POR</td>
							<td width="145"><input onFocus="shootDecision()" name="por_cd" onKeyUp="ComChkObjValid(this, 'eng_num', true, 5)" onBlur="ComChkObjValid(this, 'eng_num', true, 5);this.value=this.value.toUpperCase();" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openLocPop(false,'por_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POL</td>
							<td width="145"><input onFocus="shootDecision()" name="pol_cd" onKeyUp="ComChkObjValid(this, 'eng_num', true, 5)" onBlur="ComChkObjValid(this, 'eng_num', true, 5);this.value=this.value.toUpperCase();" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openLocPop(false,'pol_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">POD</td>
							<td width="145"><input onFocus="shootDecision()" name="pod_cd" onKeyUp="ComChkObjValid(this, 'eng_num', true, 5)" onBlur="ComChkObjValid(this, 'eng_num', true, 5);this.value=this.value.toUpperCase();" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openLocPop(false,'pod_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
							<td width="30">DEL</td>
							<td width=""><input onFocus="shootDecision()" name="del_cd" onKeyUp="ComChkObjValid(this, 'eng_num', true, 5)" onBlur="ComChkObjValid(this, 'eng_num', true, 5);this.value=this.value.toUpperCase();" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="" onBure="">&nbsp;<img onClick="openLocPop(false,'del_cd')" class="cursor" src="/hanjin/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

						</tr>

					</table>

					<table class="search_in" border="0">
						<tr class="h23">
						</tr>

				</td></tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->


		<table class="height_10"><tr><td></td></tr></table>


		<!-- TABLE '#D' : ( Tab BG Box ) (S) -->
     	<table class="search" border="0">
			<tr>
				<td class="bg">
					<table class="height_10"><tr><td></td></tr></table>


					<!-- : ( grid ) (S) -->
                    <table width="100%" id="mainTable">
                        <tr><td>
                             <script language="javascript">ComSheetObject('sheet');</script>
                        </td></tr>
                    </table>

				<!-- : ( grid ) (E) -->
			</td></tr>
		</table>
		<!-- TABLE '#D' : ( Tab BG Box ) (E) -->
		<!-- ####### TABLE '#D' ::: 'RIGHT' FRAME (END) ####### -->


	</td></tr>
</table>
</form>
<!-- TABLE '#B' : 'Left + Right Body' Table (E)nd -->
    </td></tr>
</table>
<!-- Outer Table (E)-->

<iframe id="hidden_frm" name="hidden_frm" width="0" height="0"></iframe>
<span id="new_form"></span>
</body>
</html>

