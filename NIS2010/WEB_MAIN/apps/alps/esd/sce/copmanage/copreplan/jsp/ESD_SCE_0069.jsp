<%
/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0046.jsp
*@FileTitle : Train & Rail Car Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 2.0
* 2006-11-16 Seong-mun Kang
* 1.0 
=========================================================*/
%>

<%@ page import="com.hanjin.framework.component.util.DateTime" %>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>

<%
	SignOnUserAccount account = null; //Session ??
	int    rowSize = 50 ;
	account = (SignOnUserAccount)session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
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

<body onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="row_size" value="<%=rowSize%>">
<input type="hidden" name="ctrl_user_id" value="<%=account.getUsr_id()%>">

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
		<table class="search">
			<tr>
				<td class="bg">
					<table class="search_in" border="0">
						<tr class="h23">
							<td width="65"><img class="nostar">Date</td>
							<td width="230"><input class="input1" name="act_dt1" type="text" class="input" style="width:70; text-transform:uppercase;" onKeyUp="ComChkObjValid(this, 'date', false, null, null, '-')" onBlur="ComChkObjValid(this, 'date', false, null, null, '-')">&nbsp;~&nbsp;<input class="input1" onKeyUp="ComChkObjValid(this, 'date', false, null, null, '-')" onBlur="ComChkObjValid(this, 'date', false, null, null, '-')" name="act_dt2" type="text" class="input" style="width:70; text-transform:uppercase;" >&nbsp;<img name="btns_calendar" class="cursor" src="/hanjin/img/button/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle">&nbsp;</td>
							<td width="105"><img class="nostar">Booking Office</td>
							<td width="160"><select name = "bkg_ofc"style="width:90;">&nbsp;
							<option value="A" selected>All</option>
							<option value="E">HAMUR</option>
							<option value="X">NYCNA</option>
							<option value="O">SHAAS</option>
							<option value="W">SINWA</option>
							<td width="50">Status</td>
							<td width="150"><select name = "rpln_sts"style="width:90;">&nbsp;
							<option value="A">All</option>
							<option value="N" selected>Unsettled</option>
							<option value="Y">Settled</option>
							<td width="80">Booking No.</td>
							<td width=""><input name="bkg_no" type="text" class="input" style="width:120; text-transform:uppercase;" value=""></td>
						</tr>
						<tr class="h23">
							<td width=""><img class="nostar">Pended</td>
							<td width=""><select name = "pnd"style="width:70;">&nbsp;
							<option value="A" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							<td width=""><img class="nostar">Replaned</td>
							<td width=""><select name = "rpln_man"style="width:90;">&nbsp;
							<option value="A" selected>All</option>
							<option value="Y">Y</option>
							<option value="N">N</option>
							<td width="">Confirmed</td>
							<td width=""><select name = "rpln_cnfm"style="width:90;">&nbsp;
							<option value="A">All</option>
							<option value="Y">Y</option>
							<option value="N" selected>N</option>
						</tr>
					</table>

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
		<table width="100%" class="button">
			<tr><td class="btn2_bg">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<!-- Repeat Pattern -->
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_so_rep" id="btn_so_rep">Validation Pass</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_man_rep" id="btn_man_rep">Manual Replan</td>
						<td class="btn2_right"></td></tr></table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td><td class="btn2" name="btn_cnfm" id="btn_cnfm">Confirm</td>
						<td class="btn2_right"></td></tr></table></td>
						<!-- Repeat Pattern -->
					</tr></table>
			</td></tr>
		</table>



    </td></tr>
</table>
<!-- Outer Table (E)-->
</form>
</body>
</html>

