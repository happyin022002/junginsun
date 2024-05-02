<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0078.jsp
*@FileTitle : Exception Noti Failure Report
*Open Issues :
*Change history :
*2008-06-26:
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
%>
<%
	// Exception Noti Failure Report  rowsize &&&
	int rowSize = 3000 ;
%>
<html>
<head>
<title>Welcome to OPUS!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<script language="javascript">

    function setupPage(){
        loadPage();

    }

</script>
<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<!--Exception Noti Failure Report  rowsize &&& -->
<input type="hidden" name="row_size" value="<%=rowSize%>">
<!--Exception Noti Failure Report  rowsize &&& -->
<input type="hidden" name="totcnt" value="1" >

<!-- Outer Table (S)-->
<table width="100%" border="0" cellpadding="0" cellspacing="0" class="bodypadding">
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
												<tr><td class="btn1_left"></td><td class="btn1" name="btn_downexcel" id="btn_downexcel">Down Excel</td><td class="btn1_right"></td></tr></table></td>
											<!-- Repeat Pattern -->

										</tr></table>

								</td></tr>
						</table>

		<!-- TABLE '#D' : ( Button : Main ) (E) -->


		<!-- TABLE '#D' : ( Search Options ) (S) -->
		<table class="search" >
		<tr>
			<td class="bg" width="100%">

			<table class="search_in" border="0">
			<tr class="h23">
			  <td width="120">Failure Date</td>
			  <td width="300">
			    <input name="fail_fm_dt" value="" type="text" style="width:70" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
			    &nbsp;~&nbsp;<input name="fail_to_dt" value="" type="text" style="width:70" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
			    <img name="btn_fail_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
			  <td width="140">Occurred Date</td>
			  <td width="">
                            <input name="occur_fm_dt" type="text" style="width:78" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~&nbsp;
							<input name="occur_to_dt" type="occur_to_dt" style="width:78" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">

			    <!-- &nbsp;<input name="occur_fm_dt" type="text" style="width:70" value="">
			    &nbsp;~&nbsp;
			    <input name="occur_to_dt" type="text" style="width:70" value=""> -->
			    <img name="btn_occur_calendar" class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"></td>
			</tr>
			</table>

			<table class="search_in" border="0">
			<tr class="h23">
			  <td width="120">Exception Type</td>
			  <td width="300">
			    <DIV id="ExptTPDiv" >
			      <select style="width:167;" name='i_expt_type' disabled>
			        <option value="" selected>ALL</option>
			      </select>
			    </DIV>
			  </td>
			  <td width="140">Exception Type Detail</td>
			  <td width="">
			    <DIV id="ExptDTLTPDiv" >
			      <select style="width:178;" name='i_exptdtl_type' disabled>
			        <option value="" selected>ALL</option>
			      </select>
			    </DIV>
			  </td>
			</tr>
			</table>

			<table class="search_in" border="0">
				<tr class="h23">
			    <td width="120">Occurred Location</td>
			    <td width="300">
			      <input name="occr_nod_cd" type="text"  value="" style="width:70 ; text-transform:uppercase;"> <img name='btn_occu_loc' class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle" onKeyUp="chkField(this, 'eng_num', true, 7)" onBlur="chkField(this, 'eng_num', true, 7)"></td>
			    <td width="140">Occurred Office</td>
			    <td width="" colspan="2">
			      <input name="cre_ofc_cd" type="text" value="" style="width:79 ; text-transform:uppercase;"> <img name="btn_occr_ofc" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
			      <input type="checkbox" name="chk_office" value="Y" class="trans" onClick="javascript:fun_chkOffice();">
			      Incl. Sub Office</td>
			</tr>
			</table>

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<table class="search_in" border="0">
				<tr class="h23">
					<td width="120">Customer</td>
					<td width=""><!--  input name="ofc_cd" type="text" style="width:50" value=""--><input name="cust_cnt_seq" type="text" style="width:70; text-transform:uppercase;" value="">
					<img onclick="openCustPop(false,'cust_cnt_seq','cust_nm', '', 'ofc_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle">
					<input name="cust_nm" type="text" style="width:545" value="">&nbsp;</td>
				</tr>
				<tr class="h23">
					<td width="120">S/C No.</td>
					<td width=""><input id="sc_no" name="sc_no" type="text" style="width:123; text-transform:uppercase;" value="">
					<img name="btn_scpopup" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				</tr>
			</table>

			<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

			<table class="search_in" border="0">
			<tr class="h23">
				<td width="120">Booking Date</td>
				<td width="90"><input name="bkg_fm_dt" type="text" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">&nbsp;~</td>
				<td width="210"><input name="bkg_to_dt" type="text" style="width:70" value="" dataformat="ymd" OnBeforeDeactivate="ComAddSeparator(this)" OnBeforeActivate="ComClearSeparator(this)">
				<img name="btn_bkg_calendar"  class="cursor" src="/opuscntr/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle"/></td>

				<td width="90">Booking No.</td>
				<td width=""><input name="bkg_no" type="text" style="width:110 ; text-transform:uppercase;" value="" Onkeydown="onEnterKey(this)">
				    <img onClick="openAddPaste('bkg_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>


			</tr>
			</table>
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="120">B/L No.</td>
				<td width="300"><input name="bl_no" type="text" style="width:100; text-transform:uppercase;" value="" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">
				<img onClick="openAddPaste('bl_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle">
				</td>

				<td width="90">Container No.</td>
				<td width="275"><input name ="cntr_no"  type="text" style="width:110; text-transform:uppercase;"  onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">
				 <img onClick="openAddPaste('cntr_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle">
				 </td>

				<td width="55">COP No.</td>
				<td width=""><input name="cop_no" type="text" style="width:110px; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)">
				<img onClick="openAddPaste('cop_no')" class="cursor" src="/opuscntr/img/button/btng_plus.gif" width="19" height="20" border="0" align="absmiddle"></td>

			</tr>
			</table>
			<table class="search_in" border="0">
			<tr class="h23">
				<td width="120">VVD</td>
				<td width="160"><input name="vvd" type="text" style="width:70; text-transform:uppercase;" onBlur="ComChkObjValid(this)">&nbsp;<img onClick="openVVDPopUp(true)" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">POR</td>
				<td width="170"><input name="por_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)"> &nbsp;<img onClick="openLocPop(false,'por_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">POL</td>
				<td width="150"><input name="pol_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)"> &nbsp;<img onClick="openLocPop(false,'pol_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">POD</td>
				<td width="160"><input name="pod_cd" type="text" class="input" style="width:60; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)"> &nbsp;<img onClick="openLocPop(false,'pod_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>
				<td width="30">DEL</td>
				<td width=""><input type="text" class="input" style="width:70; text-transform:uppercase;" name="del_cd" onKeyUp="ComChkObjValid(this, 'eng_num', true, 1000)"> &nbsp;<img onClick="openLocPop(false,'del_cd')" class="cursor" src="/opuscntr/img/button/btns_search.gif" width="19" height="20" border="0" align="absmiddle"></td>

			</tr>
			</table>

	</td>
		</tr>
		</table>
		<!-- TABLE '#D' : ( Search Options ) (E) -->

		<table class="height_10"><tr><td></td></tr></table>

		<table class="search">
       	<tr><td class="bg">

				<!-- : ( Speed ) (S) -->
				<table width="100%" id="mainTable">
				<tr><td>
				   <script language="javascript">ComSheetObject('sheet1');</script>
				</td></tr>
				</table>
				<!-- : ( Speed ) (E) -->
				<!-- : ( Button : Sub ) (S) -->
				<table width="100%" class="sbutton">
       				<tr><td class="align">



					</td></tr>
				</table>
	    		<!-- : ( Button : Sub ) (E) -->
			</td></tr>
		</table>

    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>







