<%/*=========================================================
*Copyright(c) 2008 CyberLogitec 
*@FileName : $Id: batchScheduleLog.jsp,v 1.12 2010/04/23 08:06:34 9008646 Exp $
*@FileTitle : Schedule Log
*Open Issues :
*Change history :
*@LastModifyDate : $Date: 2010/04/23 08:06:34 $
*@LastModifier : $Author: 9008646 $
*@LastVersion : 1.0
* 2008.12.29 김경범 
* 1.0 최초 생성
=========================================================*/%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<title>Welcome to&gt;nis2010!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<script language="javascript">

	function setupPage() {

		loadPage();

		form.dateFrom.value = ComGetDateAdd(null, "D", 0);
		form.dateTo.value = ComGetDateAdd(null, "D", 0);
	}
	function popCal(calObj) {
		//달력 열기
		var cal = new ComCalendar();
		cal.select(calObj, 'yyyy-MM-dd');
	}
</script>


<body  onLoad="setupPage();">

<form name="form" onkeyup="ComKeyEnter('lengthnextfocus');">
<input type="hidden" name="f_cmd">
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">

		<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
		<!--Page Title, Historical (E)-->

		<!-- 1 (S) -->
		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<!--  biz_1  (S) -->
				<table class="search" border="0" style="width:979;">
				<tr class="h23">
					<td width="85">Job ID</td>
					<td width="140"><input name="skd_id" dataformat="num" type="text" style="width:100;" class="input"></td>

					<td width="100">Job Type</td>
					<td width="150"><select name="skd_tp_cd" style="width:100;" class="input1">
						<option value="" selected>ALL</option>
						<option value="D">Direct</option>
						<option value="S">Scheduled</option>
						</select></td>
					<td width="45">Status</td>
					<td><select name="sts_cd" style="width:100;" class="input1">
						<option value=""selected>All</option>
						<option value="1">RUNNING</option>
						<option value="3">STARTING</option>
						<option value="4">SUCCESS</option>
						<option value="5">FAILURE</option>
						<option value="6">TERMINATED</option>
						<option value="7">ON_ICE</option>
						<option value="8">INACTIVE</option>
						<option value="9">ACTIVATED</option>
						<option value="10">RESTART</option>
						<option value="11">ON_HOLD</option>
						<option value="12">QUE_WAIT</option>
						</select></td>
				</tr>
				<tr class="h23">
					<td width="">Program No.</td>
					<td width=" "><input name="pgm_no" dataformat="engup" type="text" style="width:100;" class="input"></td>
					<td width="85">Execute Date</td>
					<td>
						<input type="text" name="dateFrom" dataformat="ymd" maxlength="8" size="10">
						<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="popCal(dateFrom);">
						<select name="hourFrom" style="width:40;" class="input1">
						<option value="00" selected>00</option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
						<option value="13">13</option>
						<option value="14">14</option>
						<option value="15">15</option>
						<option value="16">16</option>
						<option value="17">17</option>
						<option value="18">18</option>
						<option value="19">19</option>
						<option value="20">20</option>
						<option value="21">21</option>
						<option value="22">22</option>
						<option value="23">23</option>
						</select>
						&nbsp;~&nbsp;
						<input type="text" name="dateTo" dataformat="ymd" maxlength="8" size="10">
						<img src="img/btns_calendar.gif" align="absmiddle" style="cursor:hand" onClick="popCal(dateTo);">
						<select name="hourTo" style="width:40;" class="input1">
						<option value="00">01</option>
						<option value="01">02</option>
						<option value="02">03</option>
						<option value="03">04</option>
						<option value="04">05</option>
						<option value="05">06</option>
						<option value="06">07</option>
						<option value="07">08</option>
						<option value="08">09</option>
						<option value="09">10</option>
						<option value="10">11</option>
						<option value="11">12</option>
						<option value="12">13</option>
						<option value="13">14</option>
						<option value="14">15</option>
						<option value="15">16</option>
						<option value="16">17</option>
						<option value="17">18</option>
						<option value="18">19</option>
						<option value="19">20</option>
						<option value="20">21</option>
						<option value="21">22</option>
						<option value="22">23</option>
						<option value="23" selected>24</option>
						</select>
					</td>
					<td width="45">Server</td>
					<td><select name="machine" style="width:100;" class="input1">
						<option value="L">LIVE</option>
						<option value="T">DEV</option>
					</select></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->

				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

				<!-- Grid (S) -->
				<table width="100%"  id="mainTable">
					<tr>
						<td width="100%">
							<script language="javascript">ComSheetObject('sheet1');</script>
						</td>
					</tr>
				</table>
				<!-- Grid (E) -->

				<table class="height_8"><tr><td></td></tr></table>

				<table width="100%" class="grid2">
				<tr>
					<td class="tr2_head" width="5%">Log</td>
					<td width="%"><iframe name="log_ifr" width="100%" height="220"></iframe></td>
				</tr>
				</table>
		</td></tr></table>
		<!-- 1 (E) -->


		<!--biz page (E)-->

		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn1_bg">

		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Retrieve" id="btn_Retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
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
<input type="hidden" name="filepath">
<input type="hidden" name="readpos" value="0" /> 
<input type="hidden" name="command" value="last" /> 
<input type="hidden" name="readbyte" value="100000" />

</form>
</body>
</html>