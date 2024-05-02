<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="com.hanjin.framework.core.controller.util.WebKeys"%>
<%@ page import="com.hanjin.framework.core.view.template.Screen"%>
<html>
<head>
<title>Discharge CY by Country Inquiry</title>
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
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
	<tr><td valign="top">
	<!--Page Title, Historical (S)-->
		<table width="100%" border="0" cellpadding="0" cellspacing="0" class="title">
			<tr><td class="history"><img src="img/icon_history_dot.gif" align="absmiddle"><span id="navigation"></span></td></tr>
			<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle"><span id="title"></span></td></tr>
		</table>
	<!--Page Title, Historical (E)-->


		<table class="search"> 
       		<tr><td class="bg">
			<table class="search" border="0">
				<tr><td class="title_h"></td>
					<td class="title_s">Search Option</td></tr>
				</table>
				
				<table class="search" border="0" style="width:800;"> 

				<tr class="h23">
					<td width="100" >Sailing Period</td>
					<td width="400" >
					<input type="text"
			        style="width: 75; ime-mode: disabled" class="input1"  maxlength="10" dataformat="ymd" name="from_dt" cofield="from_dt" caption="Sailing Period" required>
					&nbsp;~&nbsp; 
					<input type="text"
			        style="width: 75; ime-mode: disabled" class="input1"  maxlength="10" dataformat="ymd"  name="to_dt" cofield="to_dt" caption="Sailing Period" required>
					<img src="img/btns_calendar.gif" width="19" height="20" alt="" border="0" align="absmiddle" class="cursor" name="btn_calendar">
					</td>
					<td width="30">POL</td>
					<td width="80"><input type="text" name="pol" style="width:60; ime-mode: disabled;" class="input1" dataformat="eng" maxlength="5" fullfill  caption="POL" required></td>
					<td width="80">Export VVD</td>
					<td width="90"><input type="text" name="export_vvd" style="width:90; ime-mode: disabled;" class="input1" dataformat="eng" minlength="9" maxlength="9" fullfill caption="Export VVD" required></td> 
					</tr>
				
				</table>
				
				
				</td>
				</tr>
				</table>
				
				
				<table class="height_8"><tr><td></td></tr></table>
		
			<!-- Grid BG Box  (S) -->
	     	<table width="100%" class="search" id="mainTable">
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
				
				<!--  Button_Sub (S) -->
				
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
					<td class="btn1" name="btn_retrieve" id="btn_retrieve">Retrieve</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>			
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_new" id="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_exceldown">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
			
			</tr>
			</table>
		</td></tr>
		</table>
    <!--Button (E) -->
	</td>
	</tr>
	</table>
			
</form>
</body>
</html>