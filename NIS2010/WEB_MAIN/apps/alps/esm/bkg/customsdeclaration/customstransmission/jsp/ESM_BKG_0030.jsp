<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>

<%@ page import="org.apache.log4j.Logger"%>

<% 
	String strOfc_cd			= "";
	try
	{
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		strOfc_cd = account.getOfc_cd();
	
	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
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
<input type="hidden" name="f_cmd" value="">
<input type="hidden" name="in_type">
<input type="hidden" name="strOfc_cd" value="<%=strOfc_cd%>">
 
<table width="100%" border="0" cellpadding="0" cellspacing="0" style="padding-top:2;padding-left:5;">
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
						<td width="50">MRN</td>
						<td width="140"><input type="text" class="input2" style="width:100; text-align:center;" name="mrn_no" ReadOnly></td>
						<td width="30">VVD</td>
						<td width="114"><input type="text" class="input1" style="width:80; text-align:center;" name="vvd" maxlength="9" dataformat="eng"></td>
						<td width="30">POL</td>
						<td width="100"><input type="text" class="input2" style="width:60; text-align:center;" name="pol_cd" maxlength="5" dataformat="eng"></td>
						<td width="30">POD</td>
						<td width="120"><input type="text" class="input1" style="width:60; text-align:center;" name="pod_cd" maxlength="5" dataformat="eng">&nbsp;<input type="text" class="input" style="width:25;" name="yard_cd" maxlength="2" dataformat="eng"></td>
						<td width="36">Type</td>
						<td><script language="javascript">ComComboObject('combo1', 3, 60, 1);</script></td>
					</tr>
				</table>
				
				<table class="search" border="0" style="width:979;"> 
					<tr class="h23">
						<td width="50">B/L No.</td>
						<td width="446"><input type="text" class="input" style="width:100; text-align:center;" name="bl_no" maxlength="12" dataformat="eng"></td>
						<td width="155">
							<table class="search_sm2" border="0" style="width:120;" >
							<tr class="h23">
								<td><input type="radio" class="trans" value="I" name="io_bnd_cd" checked>I/B&nbsp;&nbsp;
								<input type="radio" class="trans" value="O" name="io_bnd_cd">O/B</td></tr>
							</table>
						</td>
						<td width="">
							<table class="search_sm2" border="0" style="width:110;" >
							<tr class="h23">
								<td><input type="radio" class="trans" name="only_error" value="N" checked>&nbsp;All&nbsp;&nbsp;
								<input type="radio" class="trans" name="only_error" value="Y">&nbsp;Err.</td></tr>
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
							<script language="javascript">ComSheetObject('sheet2');</script>
							<script language="javascript">ComSheetObject('sheet3');</script>
						</td>
					</tr>
				</table>

			<table width="100%" class="grid" id="mainTable">
			<tr class="tr_head3">
				<td align="center" style="height:35;">
				<b>B/L :</b> Local&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="bl_local" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="bl_ts" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Empty&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="bl_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Total&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="bl_total" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<b>CNTR :</b> Local&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="cntr_local" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				T/S&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="cntr_ts" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Empty&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="cntr_empty" readOnly>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				Total&nbsp;&nbsp;<input type="text" style="width:35;" class="input2" style="text-align:right;" name="cntr_total" readOnly>
				</td></tr>
			</table>
			<!-- Grid (E) -->		
			</td></tr>
		</table>
		<!--biz page (E)-->
	
	
		<!--Button (S) -->
		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;"> 
       	<tr><td class="btn1_bg">
		
		    <table border="0" cellpadding="0" cellspacing="0">
		    <tr><td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
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
					<td class="btn1" name="btn_BLInfo">Add &amp; B/L Info.</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_DownExcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_Print">Print</td>
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