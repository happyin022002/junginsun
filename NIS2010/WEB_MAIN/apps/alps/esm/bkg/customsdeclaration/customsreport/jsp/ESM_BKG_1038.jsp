 <%/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_1038.jsp
*@FileTitle : Bangladesh Cargo Manifest - Freight Forward License No.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : OH DONG HYUN
*@LastVersion : 1.0
* 2009.10.08 OH DONG HYUN
* 1.0 Creation
=========================================================*/%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="com.hanjin.framework.component.util.JSPUtil"%>
<%@ page import="com.hanjin.framework.component.util.DateTime"%>
<%@ page import="com.hanjin.framework.component.message.ErrorHandler"%>
<%@ page import="com.hanjin.framework.core.layer.event.GeneralEventResponse"%>
<%@ page import="com.hanjin.framework.support.controller.html.CommonWebKeys"%>
<%@ page import="com.hanjin.framework.support.view.signon.SignOnUserAccount"%>
<%@ page import="org.apache.log4j.Logger" %>

<html>
<head>
<title>Bangladesh Cargo Manifest – Freight Forward License No.</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
    function setupPage(){
	    loadPage();
    }
</script>
</head>

<body class="popup_bg" onLoad="setupPage();">

<form name="form">
<input type="hidden" name="f_cmd">

<!-- OUTER - POPUP (S)tart -->
<table width="100%" class="popup" cellpadding="10" border="0">
<tr><td class="top"></td></tr>
<tr><td valign="top">

		<!-- : ( Title ) (S) -->
		<table width="100%" border="0">
		<tr><td class="title"><img src="img/icon_title_dot.gif" align="absmiddle">&nbsp;Bangladesh Cargo Manifest – Freight Forward License No.</td></tr>
		</table>
		<!-- : ( Title ) (E) -->

		<!-- : ( Search Options ) (S) -->

		<table class="search" id="mainTable">
       		<tr><td class="bg">

				<table class="search" border="0" style="width:100%;"> 
				<tr class="h23">
					<td width="80">License No.</td>
					<td width="160"><input type="text" style="width:120;ime-mode: disabled" class="input" value="" name="cust_lic_no" maxlength="10" dataformat="etc"></td> 
					<td width="100">Customer Code</td>
					<td width="160"><input type="text" style="width:120;ime-mode: disabled" class="input" value="" name="cust_cd" maxlength="8" dataformat="uppernum" ></td> 
					<td width="100">Customer Name</td>
					<td width=""><input type="text" style="width:160;ime-mode: disabled" class="input" value="" name="cust_nm" dataformat="etc"></td> 
				</tr>
				</table>
				
				<table class="line_bluedot"><tr><td colspan="6"></td></tr></table>

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
				<table width="100%" class="button"> 
	       			<tr><td class="btn2_bg">
					<table border="0" cellpadding="0" cellspacing="0"><tr>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowadd">Row&nbsp;Add</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
						<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
						<tr><td class="btn2_left"></td>
						<td class="btn2" name="btn_rowdelete">Row&nbsp;Delete</td>
						<td class="btn2_right"></td>
						</tr>
						</table></td>
					</tr></table>
				</td></tr>
				</table>
	    			<!-- Button_Sub (E) -->

		</td></tr>
		</table>
<!-- : ( Search Options ) (E) -->
<div>
</div>
<!-- (TAB) H/BL List (E) -->

	</td></tr>
</table>

<!-- : ( Button : pop ) (S) -->
<table width="100%" class="sbutton">
<tr><td height="71" class="popup">

		<table width="100%" class="button" border="0" cellpadding="0" cellspacing="0" style="padding-top:5;,padding-bottom:10;">
       	<tr><td class="btn3_bg">
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
					<td class="btn1" name="btn_new">New</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_save">Save</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_downexcel">Down Excel</td>
					<td class="btn1_right"></td>
					</tr>
				</table></td>
				<td class="btn1_line"></td>
				<td><table width="100%" border="0" cellpadding="0" cellspacing="0" class="button">
					<tr><td class="btn1_left"></td>
					<td class="btn1" name="btn_close">Close</td>
					<td class="btn1_right"></td>
				</tr></table></td>
			</tr>
		</table></td></tr>
	</table>

	</td></tr>
</table>
<!-- : ( Button : pop ) (E) -->

</form>
</body>
</html>