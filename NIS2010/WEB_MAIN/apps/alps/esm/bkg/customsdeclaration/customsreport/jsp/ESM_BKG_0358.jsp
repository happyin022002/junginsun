<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%
	String locCd = request.getParameter("loc_cd");
	String mrnNo = request.getParameter("mrn_no");
	String vvd   = request.getParameter("vvd");
	String portCd= request.getParameter("port_cd");
	
	if (locCd==null) locCd = "";
	if (mrnNo==null) mrnNo = "";
	if (vvd==null)   vvd = "";
	if (portCd==null) portCd = "";
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
<input type="hidden" name="f_cmd">
<input type="hidden" name="mrn_no" value="<%=mrnNo%>">
<input type="hidden" name="vsl_cd">
<input type="hidden" name="skd_voy_no">
<input type="hidden" name="skd_dir_cd">


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
				<table class="search" border="0" style="width:650;"> 
				<tr class="h23">
					<td width="35">VVD</td>
					<td width="223"><input type="text" style="width:80; text-align:center;" class="input" name="vvd" value="<%=vvd%>" maxlength="9" style="ime-mode:disabled" dataformat="engupnum"></td>
					<td width="36">Bound</td>
					<td width="450"><select style="width:81;" class="input" name="io_bnd_cd" onChange="ioBndCd_onChange()">
						<option value="" selected>All</option>
						<option value="I">Inbound</option>
						<option value="O">Outbound</option>
						</select></td>
					<td width="36">MRN</td>
					<td width=""><input type="text" style="width:35;text-align:center;" class="input1" name="mrn1" maxlength="2" style="ime-mode:disabled" dataformat="num" >&nbsp;~&nbsp;
					<input type="text" style="width:45;text-align:center;" class="input" name="mrn2" maxlength="4" style="ime-mode:disabled" dataformat="engupnum" >&nbsp;~&nbsp;
					<input type="text" style="width:45;text-align:center;" class="input" name="mrn3" maxlength="4" style="ime-mode:disabled" dataformat="engupnum" >&nbsp;~&nbsp;
					<input type="text" style="width:35;text-align:center;" class="input2" name="mrn4" maxlength="1" style="ime-mode:disabled" dataformat="num" ></td>
				</tr>
				<tr class="h23">
					<td width="">Port</td>
					<td width=""><input type="text" style="width:50;text-align:center;" dataformat="engupnum" class="input" name="port_cd" value="<%=portCd%>" maxlength="5"></td>
					<td width=""><span id="timeStr">ETA</span></td>
					<td width="" colspan="3"><input type="text" style="width:80;text-align:center;" class="input" name="from_dt" maxlength="10" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar1">&nbsp;~&nbsp;<input type="text" style="width:80;text-align:center;" class="input" name="to_dt"  maxlength="10" dataformat="ymd">&nbsp;<img class="cursor" src="img/btns_calendar.gif" width="19" height="20" border="0" align="absmiddle" name="btn_calendar2"></td>
				</tr>
				</table>
				<!--  biz_1   (E) -->
				</td></tr>
			</table>
			<table class="height_8"><tr><td></td></tr></table>
		
		<!-- Grid BG Box  (S) -->
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
					<td class="btn1" name="btn_select">Select</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
		    	<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down&nbsp;Excel</td>
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
