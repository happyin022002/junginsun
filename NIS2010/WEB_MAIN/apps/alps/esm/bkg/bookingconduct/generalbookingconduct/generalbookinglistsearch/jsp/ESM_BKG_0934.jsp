<%
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0934.jsp
*@FileTitle : bookringconduct
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2009.06.10 강동윤
* 1.0 Creation
* -------------------------------------------------------
* History
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2016.03.11 문동선 [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
=========================================================*/
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.hanjin.framework.component.util.StringUtil" %>

<%

	String row = StringUtil.xssFilter(request.getParameter("row"));	
	String col = StringUtil.xssFilter(request.getParameter("col"));

%>

<html>
<head>
<title>bookingconduct</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script language="javascript">
	function setupPage(){
		
		loadPage();
		document.form.year.focus();
	}
</script>

</head>

<body class="popup_bg" onLoad="setupPage();">
<form name="form">
<input type="hidden" name="f_cmd">
<input type="hidden" name="pagerows">
<!-- 개발자 작업	-->
<input type="hidden" name="row" value="<%= row %>">
<input type="hidden" name="col" value="<%= col %>">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0"> 
<tr><td class="top"></td></tr>
<tr><td valign="top">
	
		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp; Edit Date / Time</td></tr>
		</table>
		<!-- : ( Title ) (E) -->
		
		<!--biz page (S)-->
		<table class="search" id="mainTable"> 
       		<tr><td class="bg">
			
				<!--  biz_1  (S) -->
    			<table class="search" border="0">
    				<td class="title_s"><input type="checkbox" name="chk1" class="trans">Edit Port CCT</td></tr>
    			</table>
				<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<td width="20%">Year</td>
					<td width="20%">Month</td>
					<td width="20%">Date</td>
					<td width="20%">Hour</td>
					<td width="20%">Minute</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="text" name="year" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="int" maxlength="4" value="" onKeyup="javascript:formCheck('year')"></td>
					<td width=""><input type="text" name="month" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('month')"></td>
					<td width=""><input type="text" name="day" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('day')"></td>
					<td width=""><input type="text" name="time" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('time')"></td>
					<td width=""><input type="text" name="minute" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="int" maxlength="2" value=""></td>
				</tr>
				</table>

    			<table class="height_10"><tr><td></td></tr></table>

    			<table class="search" border="0">
    				<td class="title_s"><input type="checkbox" name="chk2" class="trans">Edit DOC CCT</td></tr>
    			</table>
				<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<td width="20%">Year</td>
					<td width="20%">Month</td>
					<td width="20%">Date</td>
					<td width="20%">Hour</td>
					<td width="20%">Minute</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="text" name="year2" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="int" maxlength="4" value="" onKeyup="javascript:formCheck('year2')"></td>
					<td width=""><input type="text" name="month2" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('month2')"></td>
					<td width=""><input type="text" name="day2" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('day2')"></td>
					<td width=""><input type="text" name="time2" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('time2')"></td>
					<td width=""><input type="text" name="minute2" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="int" maxlength="2" value=""></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>

    			<table class="search" border="0">
    				<td class="title_s"><input type="checkbox" name="chk3" class="trans">Edit Rail CCT (From)</td></tr>
    			</table>
				<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<td width="20%">Year</td>
					<td width="20%">Month</td>
					<td width="20%">Date</td>
					<td width="20%">Hour</td>
					<td width="20%">Minute</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="text" name="year3" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="int" maxlength="4" value="" onKeyup="javascript:formCheck('year3')"></td>
					<td width=""><input type="text" name="month3" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('month3')"></td>
					<td width=""><input type="text" name="day3" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('day3')"></td>
					<td width=""><input type="text" name="time3" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('time3')"></td>
					<td width=""><input type="text" name="minute3" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="int" maxlength="2" value=""></td>
				</tr>
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>

    			<table class="search" border="0">
    				<td class="title_s"><input type="checkbox" name="chk4" class="trans">Edit Rail CCT (To)</td></tr>
    			</table>
				<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<td width="20%">Year</td>
					<td width="20%">Month</td>
					<td width="20%">Date</td>
					<td width="20%">Hour</td>
					<td width="20%">Minute</td>
				</tr>
				<tr class="h23">
					<td width=""><input type="text" name="year4" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="int" maxlength="4" value="" onKeyup="javascript:formCheck('year4')"></td>
					<td width=""><input type="text" name="month4" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('month4')"></td>
					<td width=""><input type="text" name="day4" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('day4')"></td>
					<td width=""><input type="text" name="time4" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('time4')"></td>
					<td width=""><input type="text" name="minute4" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="int" maxlength="2" value=""></td>
				</tr>
				
				</table>
				
				<table class="height_10"><tr><td></td></tr></table>
				
				<table class="search" border="0">
					<td class="title_s"><input type="checkbox" name="chk5" class="trans">Edit VGM CCT</td></tr>
				</table>
    			<table border="0" style="width:100%;" class="grid2"> 
				<tr class="tr2_head">
					<td width="20%">Year</td>
					<td width="20%">Month</td>
					<td width="20%">Date</td>
					<td width="20%">Hour</td>
					<td width="20%">Minute</td>
				</tr> 
				<tr class="h23">
					<td width=""><input type="text" name="year5" style="width:100%;text-align:center;" class="noinput" caption="YYYY" dataformat="int" maxlength="4" value="" onKeyup="javascript:formCheck('year5')"></td>
					<td width=""><input type="text" name="month5" style="width:100%;text-align:center;" class="noinput" caption="MM" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('month5')"></td>
					<td width=""><input type="text" name="day5" style="width:100%;text-align:center;" class="noinput" caption="DD" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('day5')"></td>
					<td width=""><input type="text" name="time5" style="width:100%;text-align:center;" class="noinput" caption="HH" dataformat="int" maxlength="2" value="" onKeyup="javascript:formCheck('time5')"></td>
					<td width=""><input type="text" name="minute5" style="width:100%;text-align:center;" class="noinput" caption="mm" dataformat="int" maxlength="2" value=""></td>
				</tr>
				</table>
				
				</table>
				<!--  biz_1   (E) -->
	

		<!--biz page (E)--> 

</td></tr></table>
	
<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

    	<!--Button (S) -->	
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn3_bg">
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_ok">OK</td>
					<td class="btn1_right"></td>
				</tr></table></td>
				<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_clear">Clear</td>
					<td class="btn1_right"></td>
				</tr></table></td>		
			<td class="btn1_line"></td>		
			<td><table width="72" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table>
	</td></tr>
	</table>
    	<!--Button (E) -->
	
	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

<!-- 개발자 작업  끝 -->
</form>
</body>
</html>